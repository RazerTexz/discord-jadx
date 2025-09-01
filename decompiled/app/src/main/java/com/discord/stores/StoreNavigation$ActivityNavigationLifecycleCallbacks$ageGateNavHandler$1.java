package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.auth.WidgetAgeVerify;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreNavigation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/app/AppActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;", "model", "", "invoke", "(Lcom/discord/app/AppActivity;Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "model");
        boolean zH = appActivity.h(Reflection2.getOrCreateKotlinClass(WidgetAgeVerify.class));
        if (modelGlobalNavigation.getShouldShowAgeGate() != null && !zH) {
            WidgetAgeVerify.INSTANCE.start(appActivity, modelGlobalNavigation.getShouldShowAgeGate() == StoreNavigation.AgeGate.NSFW_CHANNEL_AGE_GATE);
        } else if (modelGlobalNavigation.getShouldShowAgeGate() == null) {
            return false;
        }
        return true;
    }
}
