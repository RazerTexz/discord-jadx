package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.widgets.chat.input.MentionUtils;
import d0.w.ContinuationInterceptor;
import d0.w.CoroutineContextImpl;
import d0.w.CoroutineContextImpl2;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import s.a.CancellableContinuationImpl5;
import s.a.CoroutineDispatcher2;
import s.a.a.DispatchedContinuation;

/* compiled from: CoroutineDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\tH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0017¢\u0006\u0004\b\u000e\u0010\rJ'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Ld0/w/a;", "Ld0/w/d;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "(Lkotlin/coroutines/CoroutineContext;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "continuation", "interceptContinuation", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "releaseInterceptedContinuation", "(Lkotlin/coroutines/Continuation;)V", "other", "plus", "(Lkotlinx/coroutines/CoroutineDispatcher;)Lkotlinx/coroutines/CoroutineDispatcher;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "Key", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class CoroutineDispatcher extends CoroutineContextImpl implements ContinuationInterceptor {

    /* renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: CoroutineDispatcher.kt */
    /* renamed from: kotlinx.coroutines.CoroutineDispatcher$a, reason: from kotlin metadata */
    public static final class Companion extends CoroutineContextImpl2<ContinuationInterceptor, CoroutineDispatcher> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super(ContinuationInterceptor.b.a, CoroutineDispatcher2.j);
            int i = ContinuationInterceptor.e;
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.b.a);
    }

    public abstract void dispatch(CoroutineContext context, Runnable block);

    public void dispatchYield(CoroutineContext context, Runnable block) {
        dispatch(context, block);
    }

    @Override // d0.w.CoroutineContextImpl, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.a.get(this, key);
    }

    @Override // d0.w.ContinuationInterceptor
    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext context) {
        return true;
    }

    @Override // d0.w.CoroutineContextImpl, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.a.minusKey(this, key);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher other) {
        return other;
    }

    @Override // d0.w.ContinuationInterceptor
    public void releaseInterceptedContinuation(Continuation<?> continuation) {
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        Object obj = ((DispatchedContinuation) continuation)._reusableCancellableContinuation;
        if (!(obj instanceof CancellableContinuationImpl5)) {
            obj = null;
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = (CancellableContinuationImpl5) obj;
        if (cancellableContinuationImpl5 != null) {
            cancellableContinuationImpl5.q();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtils.MENTIONS_CHAR + f.l0(this);
    }
}
