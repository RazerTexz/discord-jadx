package s.a;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContextElement.kt */
/* renamed from: s.a.v1, reason: use source file name */
/* loaded from: classes3.dex */
public interface ThreadContextElement<S> extends CoroutineContext.Element {
    S C(CoroutineContext coroutineContext);

    void y(CoroutineContext coroutineContext, S s2);
}
