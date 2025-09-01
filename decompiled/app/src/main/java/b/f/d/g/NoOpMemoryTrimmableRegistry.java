package b.f.d.g;

/* compiled from: NoOpMemoryTrimmableRegistry.java */
/* renamed from: b.f.d.g.d, reason: use source file name */
/* loaded from: classes.dex */
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {
    public static NoOpMemoryTrimmableRegistry a;

    public static synchronized NoOpMemoryTrimmableRegistry b() {
        if (a == null) {
            a = new NoOpMemoryTrimmableRegistry();
        }
        return a;
    }

    @Override // b.f.d.g.MemoryTrimmableRegistry
    public void a(MemoryTrimmable memoryTrimmable) {
    }
}
