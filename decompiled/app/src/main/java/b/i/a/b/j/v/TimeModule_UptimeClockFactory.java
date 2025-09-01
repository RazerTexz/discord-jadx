package b.i.a.b.j.v;

import c0.a.Provider3;

/* compiled from: TimeModule_UptimeClockFactory.java */
/* renamed from: b.i.a.b.j.v.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class TimeModule_UptimeClockFactory implements Provider3 {

    /* compiled from: TimeModule_UptimeClockFactory.java */
    /* renamed from: b.i.a.b.j.v.c$a */
    public static final class a {
        public static final TimeModule_UptimeClockFactory a = new TimeModule_UptimeClockFactory();
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new UptimeClock();
    }
}
