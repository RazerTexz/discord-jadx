package kotlin.reflect;

import d0.Function3;
import kotlin.Metadata;

/* compiled from: KFunction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003R\u001c\u0010\u0005\u001a\u00020\u00048&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00048&@'X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\b\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00048&@'X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00048&@'X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\u00048&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/KFunction;", "R", "Lkotlin/reflect/KCallable;", "Ld0/c;", "", "isInline", "()Z", "isInline$annotations", "()V", "isInfix", "isInfix$annotations", "isExternal", "isExternal$annotations", "isSuspend", "isSuspend$annotations", "isOperator", "isOperator$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public interface KFunction<R> extends KCallable<R>, Function3<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();
}
