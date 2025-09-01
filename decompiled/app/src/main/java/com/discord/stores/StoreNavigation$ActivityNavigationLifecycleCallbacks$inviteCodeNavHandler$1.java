package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNux;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncMode;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.guilds.invite.WidgetGuildInvite;
import d0.Tuples;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreNavigation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/app/AppActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;", "model", "", "invoke", "(Lcom/discord/app/AppActivity;Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$inviteCodeNavHandler$1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* compiled from: StoreNavigation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "it", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;)Lcom/discord/stores/StoreNux$NuxState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$inviteCodeNavHandler$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 60, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$ActivityNavigationLifecycleCallbacks$inviteCodeNavHandler$1(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks) {
        super(2);
        this.this$0 = activityNavigationLifecycleCallbacks;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        Intrinsics3.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(modelGlobalNavigation, "model");
        StoreInviteSettings.InviteCode inviteCode = modelGlobalNavigation.getInviteCode();
        if (inviteCode == null) {
            return false;
        }
        boolean postRegisterWithInvite = modelGlobalNavigation.getNuxState().getPostRegisterWithInvite();
        Experiment userExperiment = StoreNavigation.ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getExperiments().getUserExperiment("2021-04_contact_sync_android_main", true);
        boolean z2 = postRegisterWithInvite && (userExperiment != null && userExperiment.getBucket() == 1) && modelGlobalNavigation.getUserHasPhone();
        if (postRegisterWithInvite && z2 && !modelGlobalNavigation.getNuxState().getContactSyncCompleted()) {
            if (!appActivity.h(Reflection2.getOrCreateKotlinClass(WidgetContactSync.class))) {
                ContactSyncFlowAnalytics.INSTANCE.trackStart(true, MapsJVM.mapOf(Tuples.to("location_page", "Onboarding")));
                WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, appActivity, ContactSyncMode.ONBOARDING, false, false, false, 28, null);
            }
        } else {
            if (appActivity.h(Reflection2.getOrCreateKotlinClass(WidgetGuildInvite.class))) {
                return false;
            }
            WidgetGuildInvite.INSTANCE.launch(appActivity, inviteCode);
            StoreNavigation.ActivityNavigationLifecycleCallbacks.access$getStream$p(this.this$0).getNux().updateNux(AnonymousClass1.INSTANCE);
        }
        return true;
    }
}
