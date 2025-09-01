package s.a.c2;

import kotlin.coroutines.Continuation;

/* compiled from: Channel.kt */
/* renamed from: s.a.c2.g, reason: use source file name */
/* loaded from: classes3.dex */
public interface Channel5<E> {
    Object a(Continuation<? super Boolean> continuation);

    E next();
}
