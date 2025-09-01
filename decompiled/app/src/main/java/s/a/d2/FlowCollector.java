package s.a.d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: FlowCollector.kt */
/* renamed from: s.a.d2.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface FlowCollector<T> {
    Object emit(T t, Continuation<? super Unit> continuation);
}
