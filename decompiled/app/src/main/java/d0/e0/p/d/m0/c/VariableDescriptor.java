package d0.e0.p.d.m0.c;

/* compiled from: VariableDescriptor.java */
/* renamed from: d0.e0.p.d.m0.c.d1, reason: use source file name */
/* loaded from: classes3.dex */
public interface VariableDescriptor extends ValueDescriptor2 {
    d0.e0.p.d.m0.k.v.g<?> getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();
}
