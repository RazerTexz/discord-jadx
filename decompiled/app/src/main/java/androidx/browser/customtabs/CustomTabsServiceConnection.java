package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import x.a.a.ICustomTabsService;

/* loaded from: classes.dex */
public abstract class CustomTabsServiceConnection implements ServiceConnection {

    @Nullable
    private Context mApplicationContext;

    /* renamed from: androidx.browser.customtabs.CustomTabsServiceConnection$1, reason: invalid class name */
    public class AnonymousClass1 extends CustomTabsClient {
        public AnonymousClass1(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
            super(iCustomTabsService, componentName, context);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        if (this.mApplicationContext == null) {
            throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
        onCustomTabsServiceConnected(componentName, new AnonymousClass1(ICustomTabsService.a.asInterface(iBinder), componentName, this.mApplicationContext));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setApplicationContext(@NonNull Context context) {
        this.mApplicationContext = context;
    }
}
