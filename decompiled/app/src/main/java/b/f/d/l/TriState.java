package b.f.d.l;

/* compiled from: TriState.java */
/* renamed from: b.f.d.l.a, reason: use source file name */
/* loaded from: classes.dex */
public enum TriState {
    YES,
    NO,
    UNSET;

    public static TriState f(boolean z2) {
        return z2 ? YES : NO;
    }
}
