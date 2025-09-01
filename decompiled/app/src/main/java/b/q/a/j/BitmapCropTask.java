package b.q.a.j;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import b.q.a.UCropActivity7;
import b.q.a.h.BitmapCropCallback;
import b.q.a.i.CropParameters;
import b.q.a.i.ImageState;
import b.q.a.k.ImageHeaderParser;
import com.yalantis.ucrop.UCropActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;

/* compiled from: BitmapCropTask.java */
/* renamed from: b.q.a.j.a, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {
    public final WeakReference<Context> a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f1981b;
    public final RectF c;
    public final RectF d;
    public float e;
    public float f;
    public final int g;
    public final int h;
    public final Bitmap.CompressFormat i;
    public final int j;
    public final String k;
    public final String l;
    public final BitmapCropCallback m;
    public int n;
    public int o;
    public int p;
    public int q;

    public BitmapCropTask(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull ImageState imageState, @NonNull CropParameters cropParameters, @Nullable BitmapCropCallback bitmapCropCallback) {
        this.a = new WeakReference<>(context);
        this.f1981b = bitmap;
        this.c = imageState.a;
        this.d = imageState.f1980b;
        this.e = imageState.c;
        this.f = imageState.d;
        this.g = cropParameters.a;
        this.h = cropParameters.f1978b;
        this.i = cropParameters.c;
        this.j = cropParameters.d;
        this.k = cropParameters.e;
        this.l = cropParameters.f;
        this.m = bitmapCropCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0261 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() throws Throwable {
        boolean z2;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        if (this.g > 0 && this.h > 0) {
            float fWidth = this.c.width() / this.e;
            float fHeight = this.c.height() / this.e;
            int i = this.g;
            if (fWidth > i || fHeight > this.h) {
                float fMin = Math.min(i / fWidth, this.h / fHeight);
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.f1981b, Math.round(r3.getWidth() * fMin), Math.round(this.f1981b.getHeight() * fMin), false);
                Bitmap bitmap = this.f1981b;
                if (bitmap != bitmapCreateScaledBitmap) {
                    bitmap.recycle();
                }
                this.f1981b = bitmapCreateScaledBitmap;
                this.e /= fMin;
            }
        }
        if (this.f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f, this.f1981b.getWidth() / 2, this.f1981b.getHeight() / 2);
            Bitmap bitmap2 = this.f1981b;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.f1981b.getHeight(), matrix, true);
            Bitmap bitmap3 = this.f1981b;
            if (bitmap3 != bitmapCreateBitmap) {
                bitmap3.recycle();
            }
            this.f1981b = bitmapCreateBitmap;
        }
        this.p = Math.round((this.c.left - this.d.left) / this.e);
        this.q = Math.round((this.c.top - this.d.top) / this.e);
        this.n = Math.round(this.c.width() / this.e);
        this.o = Math.round(this.c.height() / this.e);
        int iRound = Math.round(Math.max(this.n, r0) / 1000.0f) + 1;
        if (this.g <= 0 || this.h <= 0) {
            float f = iRound;
            z2 = Math.abs(this.c.left - this.d.left) > f || Math.abs(this.c.top - this.d.top) > f || Math.abs(this.c.bottom - this.d.bottom) > f || Math.abs(this.c.right - this.d.right) > f || this.f != 0.0f;
        }
        Log.i("BitmapCropTask", "Should crop: " + z2);
        FileChannel channel = null;
        if (!z2) {
            String str = this.k;
            String str2 = this.l;
            if (!str.equalsIgnoreCase(str2)) {
                try {
                    FileChannel channel2 = new FileInputStream(new File(str)).getChannel();
                    try {
                        channel = new FileOutputStream(new File(str2)).getChannel();
                        channel2.transferTo(0L, channel2.size(), channel);
                        channel2.close();
                        channel2.close();
                        if (channel != null) {
                            channel.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileChannel = channel;
                        channel = channel2;
                        if (channel != null) {
                            channel.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            }
            return false;
        }
        ExifInterface exifInterface = new ExifInterface(this.k);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.f1981b, this.p, this.q, this.n, this.o);
        try {
            if (this.a.get() != null) {
                try {
                    fileOutputStream = new FileOutputStream(new File(this.l), false);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (IOException e) {
                        e = e;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileChannel2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileChannel2 = null;
                }
                try {
                    bitmapCreateBitmap2.compress(this.i, this.j, byteArrayOutputStream);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                    bitmapCreateBitmap2.recycle();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e = e3;
                    channel = byteArrayOutputStream;
                    fileChannel2 = channel;
                    channel = fileOutputStream;
                    try {
                        Log.e("BitmapCropTask", e.getLocalizedMessage());
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        if (this.i.equals(Bitmap.CompressFormat.JPEG)) {
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (fileChannel2 != null) {
                            throw th;
                        }
                        try {
                            fileChannel2.close();
                            throw th;
                        } catch (IOException unused4) {
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    channel = byteArrayOutputStream;
                    fileChannel2 = channel;
                    channel = fileOutputStream;
                    if (channel != null) {
                    }
                    if (fileChannel2 != null) {
                    }
                }
            }
        } catch (IOException unused5) {
        }
        if (this.i.equals(Bitmap.CompressFormat.JPEG)) {
            int i2 = this.n;
            int i3 = this.o;
            String str3 = this.l;
            byte[] bArr = ImageHeaderParser.a;
            String[] strArr = {ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
            try {
                ExifInterface exifInterface2 = new ExifInterface(str3);
                for (int i4 = 0; i4 < 22; i4++) {
                    String str4 = strArr[i4];
                    String attribute = exifInterface.getAttribute(str4);
                    if (!TextUtils.isEmpty(attribute)) {
                        exifInterface2.setAttribute(str4, attribute);
                    }
                }
                exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i2));
                exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i3));
                exifInterface2.setAttribute(ExifInterface.TAG_ORIENTATION, "0");
                exifInterface2.saveAttributes();
            } catch (IOException e4) {
                Log.d("ImageHeaderParser", e4.getMessage());
            }
        }
        return true;
    }

    @Override // android.os.AsyncTask
    @Nullable
    public Throwable doInBackground(Void[] voidArr) {
        Bitmap bitmap = this.f1981b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            a();
            this.f1981b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@Nullable Throwable th) {
        Throwable th2 = th;
        BitmapCropCallback bitmapCropCallback = this.m;
        if (bitmapCropCallback != null) {
            if (th2 != null) {
                UCropActivity7 uCropActivity7 = (UCropActivity7) bitmapCropCallback;
                uCropActivity7.a.b(th2);
                uCropActivity7.a.finish();
                return;
            }
            Uri uriFromFile = Uri.fromFile(new File(this.l));
            BitmapCropCallback bitmapCropCallback2 = this.m;
            int i = this.p;
            int i2 = this.q;
            int i3 = this.n;
            int i4 = this.o;
            UCropActivity7 uCropActivity72 = (UCropActivity7) bitmapCropCallback2;
            UCropActivity uCropActivity = uCropActivity72.a;
            uCropActivity.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uriFromFile).putExtra("com.yalantis.ucrop.CropAspectRatio", uCropActivity.w.getTargetAspectRatio()).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", i4).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2));
            uCropActivity72.a.finish();
        }
    }
}
