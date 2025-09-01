package co.discord.media_engine;

import android.content.Context;
import androidx.annotation.AnyThread;
import co.discord.media_engine.internal.ExtensionFunctions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;

/* compiled from: CameraEnumeratorProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lco/discord/media_engine/CameraEnumeratorProvider;", "", "Landroid/content/Context;", "context", "", "maybeInit", "(Landroid/content/Context;)V", "Lorg/webrtc/CameraEnumerator;", "get", "()Lorg/webrtc/CameraEnumerator;", "", "cameraName", "Lorg/webrtc/CameraVideoCapturer;", "createCapturer", "(Ljava/lang/String;)Lorg/webrtc/CameraVideoCapturer;", "", "forceCamera1", "init", "(Landroid/content/Context;Z)V", "TAG", "Ljava/lang/String;", "enumerator", "Lorg/webrtc/CameraEnumerator;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CameraEnumeratorProvider {
    public static final CameraEnumeratorProvider INSTANCE = new CameraEnumeratorProvider();
    private static final String TAG = "CameraEnumeratorProvider";
    private static CameraEnumerator enumerator;

    private CameraEnumeratorProvider() {
    }

    @AnyThread
    public static final CameraVideoCapturer createCapturer(String cameraName) {
        Intrinsics3.checkNotNullParameter(cameraName, "cameraName");
        CameraVideoCapturer cameraVideoCapturerCreateCapturer = get().createCapturer(cameraName, null);
        Intrinsics3.checkNotNullExpressionValue(cameraVideoCapturerCreateCapturer, "get().createCapturer(cameraName, null)");
        return cameraVideoCapturerCreateCapturer;
    }

    @AnyThread
    public static final synchronized CameraEnumerator get() {
        CameraEnumerator camera1Enumerator;
        camera1Enumerator = enumerator;
        if (camera1Enumerator == null) {
            ExtensionFunctions.logi(TAG, "init was never called. Use Camera 1 API by default.");
            camera1Enumerator = new Camera1Enumerator();
        }
        return camera1Enumerator;
    }

    @AnyThread
    public static final synchronized void maybeInit(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (enumerator == null) {
            INSTANCE.init(context, false);
        }
    }

    @AnyThread
    public final synchronized void init(Context context, boolean forceCamera1) {
        CameraEnumerator camera1Enumerator;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (forceCamera1) {
            ExtensionFunctions.logi(TAG, "Override: Forcing Camera 1 API");
            camera1Enumerator = new Camera1Enumerator();
        } else if (Camera2Enumerator.isSupported(context)) {
            ExtensionFunctions.logi(TAG, "Use Camera 2 API");
            camera1Enumerator = new Camera2Enumerator(context.getApplicationContext());
        } else {
            ExtensionFunctions.logi(TAG, "Camera 2 API is not supported. Use Camera 1 API");
            camera1Enumerator = new Camera1Enumerator();
        }
        enumerator = camera1Enumerator;
    }
}
