package com.discord.widgets.user.search;

import b.a.d.AppViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetGlobalSearchDismissModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R:\u0010\u0007\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00020\u0002 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00050\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchDismissModel;", "Lb/a/d/d0;", "", "dismiss", "()V", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "dismissEventsSubject", "Lrx/subjects/PublishSubject;", "Lrx/Observable;", "getDismissEvents", "()Lrx/Observable;", "dismissEvents", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchDismissModel extends AppViewModel<Unit> {
    private final PublishSubject<Unit> dismissEventsSubject;

    public WidgetGlobalSearchDismissModel() {
        super(null, 1, null);
        this.dismissEventsSubject = PublishSubject.k0();
    }

    public final void dismiss() {
        PublishSubject<Unit> publishSubject = this.dismissEventsSubject;
        publishSubject.k.onNext(Unit.a);
    }

    public final Observable<Unit> getDismissEvents() {
        PublishSubject<Unit> publishSubject = this.dismissEventsSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "dismissEventsSubject");
        return publishSubject;
    }
}
