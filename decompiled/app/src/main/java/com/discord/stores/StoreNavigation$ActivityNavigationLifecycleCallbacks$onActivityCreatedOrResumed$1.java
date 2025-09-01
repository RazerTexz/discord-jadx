package com.discord.stores;

import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreNavigation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;", "it", "", "invoke", "(Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$onActivityCreatedOrResumed$1 extends Lambda implements Function1<StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Unit> {
    public final /* synthetic */ AppActivity $activity;
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$ActivityNavigationLifecycleCallbacks$onActivityCreatedOrResumed$1(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks, AppActivity appActivity) {
        super(1);
        this.this$0 = activityNavigationLifecycleCallbacks;
        this.$activity = appActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        invoke2(modelGlobalNavigation);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "it");
        StoreNavigation.ActivityNavigationLifecycleCallbacks.access$handleGlobalNavigationData(this.this$0, this.$activity, modelGlobalNavigation);
    }
}
