package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import x.a.a.ICustomTabsCallback;
import x.a.a.IPostMessageService;

/* loaded from: classes.dex */
public class PostMessageService extends Service {
    private IPostMessageService.a mBinder = new AnonymousClass1();

    /* renamed from: androidx.browser.customtabs.PostMessageService$1, reason: invalid class name */
    public class AnonymousClass1 extends IPostMessageService.a {
        public AnonymousClass1() {
        }

        @Override // x.a.a.IPostMessageService
        public void onMessageChannelReady(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onMessageChannelReady(bundle);
        }

        @Override // x.a.a.IPostMessageService
        public void onPostMessage(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onPostMessage(str, bundle);
        }
    }

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }
}
