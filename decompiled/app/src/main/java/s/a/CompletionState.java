package s.a;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;

/* compiled from: CompletionState.kt */
/* renamed from: s.a.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class CompletionState extends CompletionState2 {
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(CompletionState.class, "_resumed");
    public volatile int _resumed;

    public CompletionState(Continuation<?> continuation, Throwable th, boolean z2) {
        if (th == null) {
            th = new CancellationException("Continuation " + continuation + " was cancelled normally");
        }
        super(th, z2);
        this._resumed = 0;
    }
}
