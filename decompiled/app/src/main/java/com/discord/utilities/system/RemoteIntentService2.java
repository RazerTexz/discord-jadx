package com.discord.utilities.system;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.system.RemoteIntentService;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: RemoteIntentService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "", "handleMessage", "(Landroid/os/Message;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.system.RemoteIntentService$IpcCallback$handler$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RemoteIntentService2 implements Handler.Callback {
    public final /* synthetic */ RemoteIntentService.IpcCallback this$0;

    public RemoteIntentService2(RemoteIntentService.IpcCallback ipcCallback) {
        this.this$0 = ipcCallback;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Intrinsics3.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        Logger logger = LoggingProvider.INSTANCE.get();
        if (message.what == 1) {
            StringBuilder sbQ = outline.Q('[');
            sbQ.append(RemoteIntentService.IpcCallback.access$getName$p(this.this$0));
            sbQ.append("] in IpcCallback: app pid=");
            sbQ.append(Process.myPid());
            Logger.d$default(logger, "RemoteIntentService", sbQ.toString(), null, 4, null);
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                StringBuilder sbQ2 = outline.Q('[');
                sbQ2.append(RemoteIntentService.IpcCallback.access$getName$p(this.this$0));
                sbQ2.append("] success after (");
                Logger.d$default(logger, "RemoteIntentService", outline.B(sbQ2, message.arg1, " ms)"), null, 4, null);
                RemoteIntentService.IpcCallback ipcCallback = this.this$0;
                Object obj2 = message.obj;
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.os.Bundle");
                ipcCallback.onSuccess((Bundle) obj2);
                return true;
            }
            if ((obj instanceof Throwable) || obj == null) {
                StringBuilder sbQ3 = outline.Q('[');
                sbQ3.append(RemoteIntentService.IpcCallback.access$getName$p(this.this$0));
                sbQ3.append("] failure after (");
                Logger.d$default(logger, "RemoteIntentService", outline.B(sbQ3, message.arg1, " ms)"), null, 4, null);
                RemoteIntentService.IpcCallback ipcCallback2 = this.this$0;
                Object obj3 = message.obj;
                if (!(obj3 instanceof Throwable)) {
                    obj3 = null;
                }
                ipcCallback2.onFailure((Throwable) obj3);
                return true;
            }
        }
        StringBuilder sbQ4 = outline.Q('[');
        sbQ4.append(RemoteIntentService.IpcCallback.access$getName$p(this.this$0));
        sbQ4.append("] unexpected message in handler: ");
        sbQ4.append(RemoteIntentService.Companion.access$messageToString(RemoteIntentService.INSTANCE, message));
        Logger.w$default(logger, "RemoteIntentService", sbQ4.toString(), null, 4, null);
        return false;
    }
}
