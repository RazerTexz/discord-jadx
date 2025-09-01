package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import b.a.a.WidgetBlockRussianPurchasesDialog;
import com.discord.app.AppActivity;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.stores.StoreNavigation;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.WidgetUserMentions;
import d0.e0.KClass;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreNavigation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/app/AppActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;", "model", "", "invoke", "(Lcom/discord/app/AppActivity;Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1 extends Lambda implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1() {
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
        if (modelGlobalNavigation.getNotice() == null) {
            return false;
        }
        List<KClass<? extends AppComponent>> validScreens = modelGlobalNavigation.getNotice().getValidScreens();
        boolean z2 = true;
        boolean z3 = validScreens != null && validScreens.contains(Reflection2.getOrCreateKotlinClass(WidgetHome.class)) && appActivity.h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class)) && modelGlobalNavigation.getNavigationTab() == NavigationTab.HOME;
        boolean z4 = validScreens != null && validScreens.contains(Reflection2.getOrCreateKotlinClass(WidgetUserMentions.class)) && appActivity.h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class)) && modelGlobalNavigation.getNavigationTab() == NavigationTab.MENTIONS;
        String name = modelGlobalNavigation.getNotice().getName();
        Objects.requireNonNull(WidgetBlockRussianPurchasesDialog.INSTANCE);
        boolean zAreEqual = Intrinsics3.areEqual(name, "Block Russian Purchases Dialog");
        if (validScreens != null && !appActivity.g(validScreens) && !z3 && !z4 && !zAreEqual) {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        AppLog appLog = AppLog.g;
        String name2 = modelGlobalNavigation.getNotice().getName();
        Objects.requireNonNull(appLog);
        Intrinsics3.checkNotNullParameter(name2, "noticeName");
        appLog.recordBreadcrumb("Notice [" + name2 + ']', NotificationCompat.CATEGORY_NAVIGATION);
        if (modelGlobalNavigation.getNotice().getAutoMarkSeen()) {
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), modelGlobalNavigation.getNotice().getName(), 0L, 2, null);
        }
        return modelGlobalNavigation.getNotice().show(appActivity);
    }
}
