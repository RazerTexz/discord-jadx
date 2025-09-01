package com.discord.utilities.views;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: ViewVisibilityObserver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tR:\u0010\f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u0002 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\n0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/views/ViewVisibilityObserver;", "", "", "isVisible", "", "updateVisibility", "(Z)V", "Lrx/Observable;", "observeIsVisible", "()Lrx/Observable;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "isVisibleSubject", "Lrx/subjects/BehaviorSubject;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ViewVisibilityObserver {
    private final BehaviorSubject<Boolean> isVisibleSubject = BehaviorSubject.k0();

    public final Observable<Boolean> observeIsVisible() {
        Observable<Boolean> observableR = this.isVisibleSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "isVisibleSubject.distinctUntilChanged()");
        return observableR;
    }

    public final void updateVisibility(boolean isVisible) {
        this.isVisibleSubject.onNext(Boolean.valueOf(isVisible));
    }
}
