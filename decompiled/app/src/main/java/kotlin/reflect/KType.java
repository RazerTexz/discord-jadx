package kotlin.reflect;

import d0.e0.KAnnotatedElement;
import d0.e0.KClassifier;
import d0.e0.KTypeProjection;
import java.util.List;
import kotlin.Metadata;

/* compiled from: KType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8&@'X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/KType;", "Ld0/e0/b;", "Ld0/e0/d;", "getClassifier", "()Ld0/e0/d;", "getClassifier$annotations", "()V", "classifier", "", "Ld0/e0/i;", "getArguments", "()Ljava/util/List;", "getArguments$annotations", "arguments", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public interface KType extends KAnnotatedElement {
    List<KTypeProjection> getArguments();

    KClassifier getClassifier();
}
