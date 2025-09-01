package com.discord.utilities.viewcontroller;

import android.view.View;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: ViewDetachedFromWindowObservable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\tJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR:\u0010\r\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00030\u0003 \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/viewcontroller/ViewDetachedFromWindowObservable;", "Landroid/view/View$OnAttachStateChangeListener;", "Lrx/Observable;", "", "observe", "()Lrx/Observable;", "Landroid/view/View;", "v", "onViewDetachedFromWindow", "(Landroid/view/View;)V", "onViewAttachedToWindow", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "onDetachSubject", "Lrx/subjects/BehaviorSubject;", "view", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ViewDetachedFromWindowObservable implements View.OnAttachStateChangeListener {
    private final BehaviorSubject<Unit> onDetachSubject;

    public ViewDetachedFromWindowObservable(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        this.onDetachSubject = BehaviorSubject.k0();
        view.addOnAttachStateChangeListener(this);
    }

    public final Observable<Unit> observe() {
        BehaviorSubject<Unit> behaviorSubject = this.onDetachSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "onDetachSubject");
        return behaviorSubject;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.onDetachSubject.onNext(Unit.a);
    }
}
