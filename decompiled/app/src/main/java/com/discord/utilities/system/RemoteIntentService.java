package com.discord.utilities.system;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import b.m.a.AndroidClockFactory;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.time.NtpClock;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RemoteIntentService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H$¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\tR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/system/RemoteIntentService;", "Landroid/app/IntentService;", "Landroid/content/Intent;", "intent", "Landroid/os/Bundle;", "doWork", "(Landroid/content/Intent;)Landroid/os/Bundle;", "", "onCreate", "()V", "onHandleIntent", "(Landroid/content/Intent;)V", "onDestroy", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "IpcCallback", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class RemoteIntentService extends IntentService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MESSENGER_KEY = "com.discord.utilities.analytics.RemoteIntentService.MESSENGER_KEY";
    private static final String TAG = "RemoteIntentService";
    private static final int WHAT_CALLBACK_RESULT = 1;
    private final String name;

    /* compiled from: RemoteIntentService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/system/RemoteIntentService$Companion;", "", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "", "messageToString", "(Landroid/os/Message;)Ljava/lang/String;", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "serviceClass", "Lcom/discord/utilities/system/RemoteIntentService$IpcCallback;", "callback", "", "startRemoteServiceWithCallback", "(Landroid/content/Context;Ljava/lang/Class;Lcom/discord/utilities/system/RemoteIntentService$IpcCallback;)V", "MESSENGER_KEY", "Ljava/lang/String;", "TAG", "", "WHAT_CALLBACK_RESULT", "I", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$messageToString(Companion companion, Message message) {
            return companion.messageToString(message);
        }

        private final String messageToString(Message msg) {
            StringBuilder sbU = outline.U("Message(what=");
            sbU.append(msg.what);
            sbU.append(", arg1=");
            sbU.append(msg.arg1);
            sbU.append(", arg2=");
            sbU.append(msg.arg2);
            sbU.append(", obj=");
            sbU.append(msg.obj);
            sbU.append(", replyTo=");
            sbU.append(msg.replyTo);
            sbU.append(')');
            return sbU.toString();
        }

        public final void startRemoteServiceWithCallback(Context context, Class<?> serviceClass, IpcCallback callback) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(serviceClass, "serviceClass");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            Logger logger = LoggingProvider.INSTANCE.get();
            StringBuilder sbU = outline.U("Starting service in remote process: ");
            sbU.append(serviceClass.getSimpleName());
            sbU.append(", app pid=");
            sbU.append(Process.myPid());
            Logger.d$default(logger, RemoteIntentService.TAG, sbU.toString(), null, 4, null);
            Intent intent = new Intent(context, serviceClass);
            Bundle bundle = new Bundle();
            bundle.putParcelable(RemoteIntentService.MESSENGER_KEY, callback.getMessenger());
            intent.putExtras(bundle);
            context.startService(intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RemoteIntentService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/discord/utilities/system/RemoteIntentService$IpcCallback;", "", "Landroid/os/Bundle;", "bundle", "", "onSuccess", "(Landroid/os/Bundle;)V", "", "throwable", "onFailure", "(Ljava/lang/Throwable;)V", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "Landroid/os/Messenger;", "getMessenger", "()Landroid/os/Messenger;", "messenger", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Landroid/os/Looper;", "callbackLooper", "<init>", "(Ljava/lang/String;Landroid/os/Looper;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class IpcCallback {
        private final Handler handler;
        private final String name;

        public IpcCallback(String str, Looper looper) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(looper, "callbackLooper");
            this.name = str;
            this.handler = new Handler(looper, new RemoteIntentService2(this));
        }

        public static final /* synthetic */ String access$getName$p(IpcCallback ipcCallback) {
            return ipcCallback.name;
        }

        public final Messenger getMessenger() {
            return new Messenger(this.handler);
        }

        public abstract void onFailure(Throwable throwable);

        public abstract void onSuccess(Bundle bundle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteIntentService(String str) {
        super(str);
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
    }

    public abstract Bundle doWork(Intent intent);

    @Override // android.app.IntentService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        StringBuilder sbQ = outline.Q('[');
        sbQ.append(this.name);
        sbQ.append("] created, remote pid=");
        sbQ.append(Process.myPid());
        Log.d(TAG, sbQ.toString());
    }

    @Override // android.app.IntentService, android.app.Service
    public final void onDestroy() {
        StringBuilder sbQ = outline.Q('[');
        sbQ.append(this.name);
        sbQ.append("] destroyed");
        Log.d(TAG, sbQ.toString());
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) throws RemoteException {
        StringBuilder sbQ = outline.Q('[');
        sbQ.append(this.name);
        sbQ.append("] onHandleIntent() start, pid=");
        sbQ.append(Process.myPid());
        Log.d(TAG, sbQ.toString());
        if (intent == null) {
            StringBuilder sbQ2 = outline.Q('[');
            sbQ2.append(this.name);
            sbQ2.append("] null intent");
            Log.d(TAG, sbQ2.toString());
            return;
        }
        NtpClock ntpClock = new NtpClock(AndroidClockFactory.a(this, null, null, 0L, 0L, 0L, 62));
        long jCurrentTimeMillis = ntpClock.currentTimeMillis();
        try {
            th = doWork(intent);
        } catch (Throwable th) {
            th = th;
            StringBuilder sbQ3 = outline.Q('[');
            sbQ3.append(this.name);
            sbQ3.append("] doWork returned error: ");
            sbQ3.append(th);
            Log.e(TAG, sbQ3.toString());
        }
        long jCurrentTimeMillis2 = ntpClock.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sbQ4 = outline.Q('[');
        sbQ4.append(this.name);
        sbQ4.append("] doWork finished: ");
        sbQ4.append(jCurrentTimeMillis2);
        sbQ4.append(" ms");
        Log.d(TAG, sbQ4.toString());
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = (int) jCurrentTimeMillis2;
        messageObtain.obj = th;
        Messenger messenger = (Messenger) intent.getParcelableExtra(MESSENGER_KEY);
        if (messenger != null) {
            messenger.send(messageObtain);
            return;
        }
        StringBuilder sbQ5 = outline.Q('[');
        sbQ5.append(this.name);
        sbQ5.append("] reply-to Messenger not set by caller");
        Log.e(TAG, sbQ5.toString());
    }
}
