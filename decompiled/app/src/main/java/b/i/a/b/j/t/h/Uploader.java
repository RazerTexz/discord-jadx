package b.i.a.b.j.t.h;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;

/* compiled from: Uploader.java */
/* renamed from: b.i.a.b.j.t.h.g, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class Uploader implements Runnable {
    public final Uploader6 j;
    public final TransportContext k;
    public final int l;
    public final Runnable m;

    public Uploader(Uploader6 uploader6, TransportContext transportContext, int i, Runnable runnable) {
        this.j = uploader6;
        this.k = transportContext;
        this.l = i;
        this.m = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Uploader6 uploader6 = this.j;
        TransportContext transportContext = this.k;
        int i = this.l;
        Runnable runnable = this.m;
        try {
            try {
                SynchronizationGuard synchronizationGuard = uploader6.f;
                EventStore eventStore = uploader6.c;
                eventStore.getClass();
                synchronizationGuard.a(new Uploader4(eventStore));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) uploader6.a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    uploader6.a(transportContext, i);
                } else {
                    uploader6.f.a(new Uploader5(uploader6, transportContext, i));
                }
            } catch (SynchronizationException unused) {
                uploader6.d.a(transportContext, i + 1);
            }
        } finally {
            runnable.run();
        }
    }
}
