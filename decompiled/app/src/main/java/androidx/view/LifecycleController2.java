package androidx.view;

import androidx.view.Lifecycle;
import b.i.a.f.e.o.f;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* compiled from: LifecycleController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "<anonymous parameter 1>", "", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* renamed from: androidx.lifecycle.LifecycleController$observer$1, reason: use source file name */
/* loaded from: classes.dex */
public final class LifecycleController2 implements LifecycleEventObserver {
    public final /* synthetic */ Job $parentJob;
    public final /* synthetic */ LifecycleController this$0;

    public LifecycleController2(LifecycleController lifecycleController, Job job) {
        this.this$0 = lifecycleController;
        this.$parentJob = job;
    }

    @Override // androidx.view.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics3.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics3.checkNotNullParameter(event, "<anonymous parameter 1>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "source.lifecycle");
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            LifecycleController lifecycleController = this.this$0;
            f.t(this.$parentJob, null, 1, null);
            lifecycleController.finish();
        } else {
            Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
            Intrinsics3.checkNotNullExpressionValue(lifecycle2, "source.lifecycle");
            if (lifecycle2.getCurrentState().compareTo(LifecycleController.access$getMinState$p(this.this$0)) < 0) {
                LifecycleController.access$getDispatchQueue$p(this.this$0).pause();
            } else {
                LifecycleController.access$getDispatchQueue$p(this.this$0).resume();
            }
        }
    }
}
