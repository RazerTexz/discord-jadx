package s.a.c2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: Channel.kt */
/* renamed from: s.a.c2.s, reason: use source file name */
/* loaded from: classes3.dex */
public interface Channel7<E> {
    boolean j(Throwable th);

    void l(Function1<? super Throwable, Unit> function1);

    Object o(E e, Continuation<? super Unit> continuation);

    boolean offer(E e);

    boolean p();
}
