package b.i.a.c.f3;

/* compiled from: ConditionVariable.java */
/* renamed from: b.i.a.c.f3.j, reason: use source file name */
/* loaded from: classes3.dex */
public class ConditionVariable {
    public final Clock4 a = Clock4.a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f971b;

    public synchronized boolean a() {
        boolean z2;
        z2 = this.f971b;
        this.f971b = false;
        return z2;
    }

    public synchronized boolean b() {
        if (this.f971b) {
            return false;
        }
        this.f971b = true;
        notifyAll();
        return true;
    }
}
