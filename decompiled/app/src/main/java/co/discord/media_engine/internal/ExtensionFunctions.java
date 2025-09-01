package co.discord.media_engine.internal;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import org.webrtc.Logging;

/* compiled from: ExtensionFunctions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "tag", NotificationCompat.CATEGORY_MESSAGE, "", "logi", "(Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.internal.ExtensionFunctionsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ExtensionFunctions {
    public static final void logi(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logging.log(Logging.Severity.LS_INFO, str, str2);
    }
}
