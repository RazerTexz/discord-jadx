package b.g.a.a;

/* compiled from: OptBoolean.java */
/* renamed from: b.g.a.a.m0, reason: use source file name */
/* loaded from: classes3.dex */
public enum OptBoolean {
    TRUE,
    FALSE,
    DEFAULT;

    public Boolean f() {
        if (this == DEFAULT) {
            return null;
        }
        return this == TRUE ? Boolean.TRUE : Boolean.FALSE;
    }
}
