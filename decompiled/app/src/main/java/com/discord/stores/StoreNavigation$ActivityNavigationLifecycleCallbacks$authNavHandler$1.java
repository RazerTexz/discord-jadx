package com.discord.stores;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.AppScreen2;
import com.discord.app.AppActivity;
import com.discord.models.authentication.AuthState;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.auth.WidgetAuthForceChangePassword;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreNavigation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/app/AppActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;", "model", "", "invoke", "(Lcom/discord/app/AppActivity;Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1();

    /* compiled from: StoreNavigation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/app/AppActivity;", "context", "", "authed", "", "invoke", "(Lcom/discord/app/AppActivity;Z)V", "resetBackstackAndStart"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<AppActivity, Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppActivity appActivity, Boolean bool) {
            invoke(appActivity, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(AppActivity appActivity, boolean z2) {
            Intrinsics3.checkNotNullParameter(appActivity, "context");
            Intent intentAddFlags = new Intent().addFlags(268468224);
            Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "Intent()\n            .ad…FLAG_ACTIVITY_CLEAR_TASK)");
            AppScreen2.b(appActivity, z2, intentAddFlags);
        }
    }

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1() {
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
        AppScreen2 appScreen2 = AppScreen2.g;
        boolean zG = appActivity.g(AppScreen2.a);
        boolean zG2 = appActivity.g(AppScreen2.f58b);
        boolean zH = appActivity.h(Reflection2.getOrCreateKotlinClass(WidgetAuthForceChangePassword.class));
        boolean zIsInitializedForAuthedUser = modelGlobalNavigation.isInitializedForAuthedUser();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        if (!zIsInitializedForAuthedUser || (!(zG || zH) || modelGlobalNavigation.getAuthState() == null)) {
            if (modelGlobalNavigation.getAuthState() == null) {
                if (!zG && !zG2) {
                    anonymousClass1.invoke(appActivity, false);
                }
            } else if (!zG && !zH) {
                return false;
            }
        } else if (modelGlobalNavigation.getAuthState().getRequiredActions().isEmpty()) {
            anonymousClass1.invoke(appActivity, true);
        } else {
            if (zH || !AuthState.INSTANCE.isUpdatePasswordRequired(modelGlobalNavigation.getAuthState())) {
                return false;
            }
            WidgetAuthForceChangePassword.INSTANCE.launch(appActivity);
        }
        return true;
    }
}
