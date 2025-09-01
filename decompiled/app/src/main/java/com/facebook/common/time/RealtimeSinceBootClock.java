package com.facebook.common.time;

import android.os.SystemClock;
import b.f.d.d.DoNotStrip;
import b.f.d.k.MonotonicClock;

@DoNotStrip
/* loaded from: classes.dex */
public class RealtimeSinceBootClock implements MonotonicClock {
    public static final RealtimeSinceBootClock a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @DoNotStrip
    public static RealtimeSinceBootClock get() {
        return a;
    }

    @Override // b.f.d.k.MonotonicClock
    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
