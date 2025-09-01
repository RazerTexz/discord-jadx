package b.i.a.b.j.v;

import android.os.SystemClock;

/* compiled from: UptimeClock.java */
/* renamed from: b.i.a.b.j.v.d, reason: use source file name */
/* loaded from: classes3.dex */
public class UptimeClock implements Clock3 {
    @Override // b.i.a.b.j.v.Clock3
    public long a() {
        return SystemClock.elapsedRealtime();
    }
}
