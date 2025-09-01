package b.i.a.f.e.k;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.d;
import b.i.a.f.e.k.k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* loaded from: classes3.dex */
public final class s implements d.a {
    public final /* synthetic */ b.i.a.f.e.h.d a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f1393b;
    public final /* synthetic */ k.a c;

    public s(b.i.a.f.e.h.d dVar, TaskCompletionSource taskCompletionSource, k.a aVar, k.b bVar) {
        this.a = dVar;
        this.f1393b = taskCompletionSource;
        this.c = aVar;
    }

    @Override // b.i.a.f.e.h.d.a
    public final void a(Status status) {
        if (!status.w0()) {
            this.f1393b.a.t(AnimatableValueParser.l0(status));
            return;
        }
        b.i.a.f.e.h.d dVar = this.a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        BasePendingResult basePendingResult = (BasePendingResult) dVar;
        Objects.requireNonNull(basePendingResult);
        AnimatableValueParser.G(!basePendingResult.i, "Result has already been consumed.");
        AnimatableValueParser.G(true, "Cannot await if then() has been called.");
        try {
            if (!basePendingResult.d.await(0L, timeUnit)) {
                basePendingResult.e(Status.m);
            }
        } catch (InterruptedException unused) {
            basePendingResult.e(Status.k);
        }
        AnimatableValueParser.G(basePendingResult.f(), "Result is not ready.");
        b.i.a.f.e.h.h hVarJ = basePendingResult.j();
        this.f1393b.a.s(this.c.a(hVarJ));
    }
}
