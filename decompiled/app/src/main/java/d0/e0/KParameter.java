package d0.e0;

import kotlin.reflect.KType;

/* compiled from: KParameter.kt */
/* renamed from: d0.e0.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface KParameter extends KAnnotatedElement {

    /* compiled from: KParameter.kt */
    /* renamed from: d0.e0.f$a */
    public enum a {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    a getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}
