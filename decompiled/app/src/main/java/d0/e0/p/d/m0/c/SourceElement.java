package d0.e0.p.d.m0.c;

/* compiled from: SourceElement.java */
/* renamed from: d0.e0.p.d.m0.c.u0, reason: use source file name */
/* loaded from: classes3.dex */
public interface SourceElement {
    public static final SourceElement a = new a();

    /* compiled from: SourceElement.java */
    /* renamed from: d0.e0.p.d.m0.c.u0$a */
    public static class a implements SourceElement {
        @Override // d0.e0.p.d.m0.c.SourceElement
        public v0 getContainingFile() {
            return v0.a;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    v0 getContainingFile();
}
