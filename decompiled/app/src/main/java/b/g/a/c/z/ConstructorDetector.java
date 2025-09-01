package b.g.a.c.z;

import java.io.Serializable;

/* compiled from: ConstructorDetector.java */
/* renamed from: b.g.a.c.z.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class ConstructorDetector implements Serializable {
    private static final long serialVersionUID = 1;
    public final boolean _allowJDKTypeCtors;
    public final boolean _requireCtorAnnotation;
    public final a _singleArgMode;

    /* compiled from: ConstructorDetector.java */
    /* renamed from: b.g.a.c.z.h$a */
    public enum a {
        DELEGATING,
        PROPERTIES,
        HEURISTIC,
        REQUIRE_MODE
    }
}
