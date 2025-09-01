package androidx.browser.browseractions;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.FileProvider;
import androidx.core.util.AtomicFile;
import b.d.b.a.outline;
import b.i.b.d.a.ListenableFuture8;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY})
@Deprecated
/* loaded from: classes.dex */
public final class BrowserServiceFileProvider extends FileProvider {
    private static final String AUTHORITY_SUFFIX = ".image_provider";
    private static final String CLIP_DATA_LABEL = "image_provider_uris";
    private static final String CONTENT_SCHEME = "content";
    private static final String FILE_EXTENSION = ".png";
    private static final String FILE_SUB_DIR = "image_provider";
    private static final String FILE_SUB_DIR_NAME = "image_provider_images/";
    private static final String LAST_CLEANUP_TIME_KEY = "last_cleanup_time";
    private static final String TAG = "BrowserServiceFP";
    public static Object sFileCleanupLock = new Object();

    /* renamed from: androidx.browser.browseractions.BrowserServiceFileProvider$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ ContentResolver val$resolver;
        public final /* synthetic */ ResolvableFuture val$result;
        public final /* synthetic */ Uri val$uri;

        public AnonymousClass1(ContentResolver contentResolver, Uri uri, ResolvableFuture resolvableFuture) {
            this.val$resolver = contentResolver;
            this.val$uri = uri;
            this.val$result = resolvableFuture;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.val$resolver.openFileDescriptor(this.val$uri, "r");
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    this.val$result.setException(new FileNotFoundException());
                    return;
                }
                Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                parcelFileDescriptorOpenFileDescriptor.close();
                if (bitmapDecodeFileDescriptor == null) {
                    this.val$result.setException(new IOException("File could not be decoded."));
                } else {
                    this.val$result.set(bitmapDecodeFileDescriptor);
                }
            } catch (IOException e) {
                this.val$result.setException(e);
            }
        }
    }

    public static class FileCleanupTask extends AsyncTask<Void, Void, Void> {
        private static final long CLEANUP_REQUIRED_TIME_SPAN;
        private static final long DELETION_FAILED_REATTEMPT_DURATION;
        private static final long IMAGE_RETENTION_DURATION;
        private final Context mAppContext;

        static {
            TimeUnit timeUnit = TimeUnit.DAYS;
            IMAGE_RETENTION_DURATION = timeUnit.toMillis(7L);
            CLEANUP_REQUIRED_TIME_SPAN = timeUnit.toMillis(7L);
            DELETION_FAILED_REATTEMPT_DURATION = timeUnit.toMillis(1L);
        }

        public FileCleanupTask(Context context) {
            this.mAppContext = context.getApplicationContext();
        }

        private static boolean isImageFile(File file) {
            return file.getName().endsWith("..png");
        }

        private static boolean shouldCleanUp(SharedPreferences sharedPreferences) {
            return System.currentTimeMillis() > sharedPreferences.getLong(BrowserServiceFileProvider.LAST_CLEANUP_TIME_KEY, System.currentTimeMillis()) + CLEANUP_REQUIRED_TIME_SPAN;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
            return doInBackground2(voidArr);
        }

        /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Void... voidArr) {
            SharedPreferences sharedPreferences = this.mAppContext.getSharedPreferences(this.mAppContext.getPackageName() + BrowserServiceFileProvider.AUTHORITY_SUFFIX, 0);
            if (!shouldCleanUp(sharedPreferences)) {
                return null;
            }
            synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
                File file = new File(this.mAppContext.getFilesDir(), BrowserServiceFileProvider.FILE_SUB_DIR);
                if (!file.exists()) {
                    return null;
                }
                File[] fileArrListFiles = file.listFiles();
                long jCurrentTimeMillis = System.currentTimeMillis() - IMAGE_RETENTION_DURATION;
                boolean z2 = true;
                for (File file2 : fileArrListFiles) {
                    if (isImageFile(file2) && file2.lastModified() < jCurrentTimeMillis && !file2.delete()) {
                        Log.e(BrowserServiceFileProvider.TAG, "Fail to delete image: " + file2.getAbsoluteFile());
                        z2 = false;
                    }
                }
                long jCurrentTimeMillis2 = z2 ? System.currentTimeMillis() : (System.currentTimeMillis() - CLEANUP_REQUIRED_TIME_SPAN) + DELETION_FAILED_REATTEMPT_DURATION;
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putLong(BrowserServiceFileProvider.LAST_CLEANUP_TIME_KEY, jCurrentTimeMillis2);
                editorEdit.apply();
                return null;
            }
        }
    }

    public static class FileSaveTask extends AsyncTask<String, Void, Void> {
        private final Context mAppContext;
        private final Bitmap mBitmap;
        private final Uri mFileUri;
        private final String mFilename;
        private final ResolvableFuture<Uri> mResultFuture;

        public FileSaveTask(Context context, String str, Bitmap bitmap, Uri uri, ResolvableFuture<Uri> resolvableFuture) {
            this.mAppContext = context.getApplicationContext();
            this.mFilename = str;
            this.mBitmap = bitmap;
            this.mFileUri = uri;
            this.mResultFuture = resolvableFuture;
        }

        private void saveFileBlocking(File file) throws IOException {
            FileOutputStream fileOutputStreamStartWrite;
            if (Build.VERSION.SDK_INT < 22) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    this.mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                    this.mResultFuture.set(this.mFileUri);
                    return;
                } catch (IOException e) {
                    this.mResultFuture.setException(e);
                    return;
                }
            }
            AtomicFile atomicFile = new AtomicFile(file);
            try {
                fileOutputStreamStartWrite = atomicFile.startWrite();
            } catch (IOException e2) {
                e = e2;
                fileOutputStreamStartWrite = null;
            }
            try {
                this.mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStreamStartWrite);
                fileOutputStreamStartWrite.close();
                atomicFile.finishWrite(fileOutputStreamStartWrite);
                this.mResultFuture.set(this.mFileUri);
            } catch (IOException e3) {
                e = e3;
                atomicFile.failWrite(fileOutputStreamStartWrite);
                this.mResultFuture.setException(e);
            }
        }

        private void saveFileIfNeededBlocking() {
            File file = new File(this.mAppContext.getFilesDir(), BrowserServiceFileProvider.FILE_SUB_DIR);
            synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
                if (!file.exists() && !file.mkdir()) {
                    this.mResultFuture.setException(new IOException("Could not create file directory."));
                    return;
                }
                File file2 = new File(file, this.mFilename + BrowserServiceFileProvider.FILE_EXTENSION);
                if (file2.exists()) {
                    this.mResultFuture.set(this.mFileUri);
                } else {
                    saveFileBlocking(file2);
                }
                file2.setLastModified(System.currentTimeMillis());
            }
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(String[] strArr) {
            return doInBackground2(strArr);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(String... strArr) {
            saveFileIfNeededBlocking();
            return null;
        }

        /* renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(Void r3) {
            new FileCleanupTask(this.mAppContext).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    private static Uri generateUri(Context context, String str) {
        return new Uri.Builder().scheme(CONTENT_SCHEME).authority(context.getPackageName() + AUTHORITY_SUFFIX).path(outline.y(FILE_SUB_DIR_NAME, str, FILE_EXTENSION)).build();
    }

    public static void grantReadPermission(@NonNull Intent intent, @Nullable List<Uri> list, @NonNull Context context) {
        if (list == null || list.size() == 0) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        intent.addFlags(1);
        ClipData clipDataNewUri = ClipData.newUri(contentResolver, CLIP_DATA_LABEL, list.get(0));
        for (int i = 1; i < list.size(); i++) {
            clipDataNewUri.addItem(new ClipData.Item(list.get(i)));
        }
        intent.setClipData(clipDataNewUri);
    }

    @NonNull
    public static ListenableFuture8<Bitmap> loadBitmap(@NonNull ContentResolver contentResolver, @NonNull Uri uri) {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass1(contentResolver, uri, resolvableFutureCreate));
        return resolvableFutureCreate;
    }

    @NonNull
    @UiThread
    public static ResolvableFuture<Uri> saveBitmap(@NonNull Context context, @NonNull Bitmap bitmap, @NonNull String str, int i) {
        StringBuilder sbX = outline.X(str, "_");
        sbX.append(Integer.toString(i));
        String string = sbX.toString();
        Uri uriGenerateUri = generateUri(context, string);
        ResolvableFuture<Uri> resolvableFutureCreate = ResolvableFuture.create();
        new FileSaveTask(context, string, bitmap, uriGenerateUri, resolvableFutureCreate).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        return resolvableFutureCreate;
    }
}
