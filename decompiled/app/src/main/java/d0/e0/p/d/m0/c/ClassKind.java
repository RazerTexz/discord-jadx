package d0.e0.p.d.m0.c;

/* compiled from: ClassKind.java */
/* renamed from: d0.e0.p.d.m0.c.f, reason: use source file name */
/* loaded from: classes3.dex */
public enum ClassKind {
    CLASS,
    INTERFACE,
    ENUM_CLASS,
    ENUM_ENTRY,
    ANNOTATION_CLASS,
    OBJECT;

    public boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
