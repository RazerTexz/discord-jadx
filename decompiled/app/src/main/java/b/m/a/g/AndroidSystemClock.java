package b.m.a.g;

import android.os.SystemClock;
import b.m.a.Clock5;

/* compiled from: AndroidSystemClock.kt */
/* renamed from: b.m.a.g.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class AndroidSystemClock implements Clock5 {
    @Override // b.m.a.Clock5
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // b.m.a.Clock5
    public long b() {
        return SystemClock.elapsedRealtime();
    }
}
