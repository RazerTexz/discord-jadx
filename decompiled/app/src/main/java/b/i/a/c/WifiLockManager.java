package b.i.a.c;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;

/* compiled from: WifiLockManager.java */
/* renamed from: b.i.a.c.r2, reason: use source file name */
/* loaded from: classes3.dex */
public final class WifiLockManager {

    @Nullable
    public final WifiManager a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public WifiManager.WifiLock f1059b;
    public boolean c;
    public boolean d;

    public WifiLockManager(Context context) {
        this.a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public final void a() {
        WifiManager.WifiLock wifiLock = this.f1059b;
        if (wifiLock == null) {
            return;
        }
        if (this.c && this.d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
