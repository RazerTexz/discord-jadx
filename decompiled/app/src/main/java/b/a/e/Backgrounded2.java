package b.a.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: Backgrounded.kt */
/* renamed from: b.a.e.b, reason: use source file name */
/* loaded from: classes.dex */
public final class Backgrounded2 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ Function1 j;

    public Backgrounded2(Function1 function1) {
        this.j = function1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [b.a.e.c] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Backgrounded4 backgrounded4 = Backgrounded4.d;
        Function1 backgrounded3 = this.j;
        Observable observableQ = new ScalarSynchronousObservable(Boolean.TRUE).q(2000L, TimeUnit.MILLISECONDS);
        Backgrounded3 backgrounded32 = new Backgrounded3(new Backgrounded(backgrounded4));
        if (backgrounded3 != null) {
            backgrounded3 = new Backgrounded3(backgrounded3);
        }
        Backgrounded4.c = observableQ.W(backgrounded32, (Action1) backgrounded3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Backgrounded4 backgrounded4 = Backgrounded4.d;
        Backgrounded4.a = false;
        Subscription subscription = Backgrounded4.c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Backgrounded4.f65b.onNext(Boolean.FALSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(bundle, "bundle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }
}
