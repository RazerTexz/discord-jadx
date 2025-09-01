package com.discord.utilities.file;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.ResponseBody;
import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: DownloadUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/file/DownloadUtils;", "", "Landroid/content/Context;", "context", "", "fileUrl", "fileName", "Ljava/io/File;", "downloadDirectory", "Lrx/Observable;", "Lcom/discord/utilities/file/DownloadUtils$DownloadState;", "downloadFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Lrx/Observable;", "<init>", "()V", "DownloadState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DownloadUtils {
    public static final DownloadUtils INSTANCE = new DownloadUtils();

    /* compiled from: DownloadUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/utilities/file/DownloadUtils$DownloadState;", "", "<init>", "()V", "Completed", "Failure", "InProgress", "Lcom/discord/utilities/file/DownloadUtils$DownloadState$InProgress;", "Lcom/discord/utilities/file/DownloadUtils$DownloadState$Completed;", "Lcom/discord/utilities/file/DownloadUtils$DownloadState$Failure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class DownloadState {

        /* compiled from: DownloadUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/file/DownloadUtils$DownloadState$Completed;", "Lcom/discord/utilities/file/DownloadUtils$DownloadState;", "Ljava/io/File;", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Completed extends DownloadState {
            private final File file;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Completed(File file) {
                super(null);
                Intrinsics3.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final File getFile() {
                return this.file;
            }
        }

        /* compiled from: DownloadUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/utilities/file/DownloadUtils$DownloadState$Failure;", "Lcom/discord/utilities/file/DownloadUtils$DownloadState;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "<init>", "(Ljava/lang/Exception;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends DownloadState {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(Exception exc) {
                super(null);
                Intrinsics3.checkNotNullParameter(exc, "exception");
                this.exception = exc;
            }

            public final Exception getException() {
                return this.exception;
            }
        }

        /* compiled from: DownloadUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/file/DownloadUtils$DownloadState$InProgress;", "Lcom/discord/utilities/file/DownloadUtils$DownloadState;", "", "progress", "F", "getProgress", "()F", "<init>", "(F)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class InProgress extends DownloadState {
            private final float progress;

            public InProgress(float f) {
                super(null);
                this.progress = f;
            }

            public final float getProgress() {
                return this.progress;
            }
        }

        private DownloadState() {
        }

        public /* synthetic */ DownloadState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DownloadUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lrx/Emitter;", "Lcom/discord/utilities/file/DownloadUtils$DownloadState;", "emitter", "", NotificationCompat.CATEGORY_CALL, "(Lrx/Emitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.file.DownloadUtils$downloadFile$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Emitter<DownloadState>> {
        public final /* synthetic */ File $downloadDirectory;
        public final /* synthetic */ String $fileName;
        public final /* synthetic */ String $fileUrl;

        /* compiled from: DownloadUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lokhttp3/ResponseBody;", "responseBody", "", "invoke", "(Lokhttp3/ResponseBody;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.file.DownloadUtils$downloadFile$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02131 extends Lambda implements Function1<ResponseBody, Unit> {
            public final /* synthetic */ Emitter $emitter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02131(Emitter emitter) {
                super(1);
                this.$emitter = emitter;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResponseBody responseBody) {
                invoke2(responseBody);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ResponseBody responseBody) {
                Intrinsics3.checkNotNullParameter(responseBody, "responseBody");
                try {
                    try {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        File file = new File(anonymousClass1.$downloadDirectory, anonymousClass1.$fileName);
                        byte[] bArr = new byte[8192];
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        float fA = responseBody.a();
                        int i = 0;
                        while (true) {
                            int i2 = responseBody.c().u0().read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            i += i2;
                            this.$emitter.onNext(new DownloadState.InProgress(i / fA));
                            fileOutputStream.write(bArr, 0, i2);
                        }
                        this.$emitter.onNext(new DownloadState.Completed(file));
                        this.$emitter.onCompleted();
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.$emitter.onNext(new DownloadState.Failure(e));
                    }
                } finally {
                    responseBody.close();
                }
            }
        }

        public AnonymousClass1(String str, File file, String str2) {
            this.$fileUrl = str;
            this.$downloadDirectory = file;
            this.$fileName = str2;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<DownloadState> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<DownloadState> emitter) {
            Intrinsics3.checkNotNullParameter(emitter, "emitter");
            emitter.onNext(new DownloadState.InProgress(0.0f));
            ObservableExtensionsKt.appSubscribe$default(RestAPI.INSTANCE.getApiFiles().getFile(this.$fileUrl), DownloadUtils.INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C02131(emitter), 62, (Object) null);
        }
    }

    private DownloadUtils() {
    }

    @RequiresPermission(conditional = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "android.permission.WRITE_EXTERNAL_STORAGE")
    public static final Observable<DownloadState> downloadFile(Context context, String fileUrl, String fileName, File downloadDirectory) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics3.checkNotNullParameter(fileName, "fileName");
        Intrinsics3.checkNotNullParameter(downloadDirectory, "downloadDirectory");
        Observable<DownloadState> observableO = Observable.o(new AnonymousClass1(fileUrl, downloadDirectory, fileName), Emitter.BackpressureMode.BUFFER);
        Intrinsics3.checkNotNullExpressionValue(observableO, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return observableO;
    }

    public static /* synthetic */ Observable downloadFile$default(Context context, String str, String str2, File file, int i, Object obj) {
        if ((i & 8) != 0) {
            file = context.getCacheDir();
            Intrinsics3.checkNotNullExpressionValue(file, "context.cacheDir");
        }
        return downloadFile(context, str, str2, file);
    }
}
