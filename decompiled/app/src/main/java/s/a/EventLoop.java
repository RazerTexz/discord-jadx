package s.a;

/* compiled from: EventLoop.kt */
/* renamed from: s.a.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class EventLoop extends r0 {
    public final Thread p;

    public EventLoop(Thread thread) {
        this.p = thread;
    }

    @Override // s.a.EventLoop2
    public Thread S() {
        return this.p;
    }
}
