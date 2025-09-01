package s.a.c2;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* compiled from: Channel.kt */
/* renamed from: s.a.c2.o, reason: use source file name */
/* loaded from: classes3.dex */
public interface Channel6<E> {
    void b(CancellationException cancellationException);

    Channel5<E> iterator();

    Object m(Continuation<? super Channel8<? extends E>> continuation);
}
