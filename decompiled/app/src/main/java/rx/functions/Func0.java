package rx.functions;

import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public interface Func0<R> extends Callable<R> {
    @Override // java.util.concurrent.Callable
    R call();
}
