package com.discord.stores;

import android.net.Uri;
import com.discord.models.authentication.AuthState;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNux;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function14;

/* compiled from: StoreNavigation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "p1", "", "p2", "Lcom/discord/models/authentication/AuthState;", "p3", "p4", "p5", "Lcom/discord/models/requiredaction/RequiredAction;", "p6", "p7", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "p8", "", "p9", "Lcom/discord/stores/StoreNotices$Notice;", "p10", "Lcom/discord/stores/StoreNavigation$AgeGate;", "p11", "Landroid/net/Uri;", "p12", "Lcom/discord/widgets/tabs/NavigationTab;", "p13", "p14", "Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;ZLcom/discord/models/authentication/AuthState;ZZLcom/discord/models/requiredaction/RequiredAction;ZLcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;Lcom/discord/stores/StoreNotices$Notice;Lcom/discord/stores/StoreNavigation$AgeGate;Landroid/net/Uri;Lcom/discord/widgets/tabs/NavigationTab;Z)Lcom/discord/stores/StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2 extends FunctionReferenceImpl implements Function14<StoreNux.NuxState, Boolean, AuthState, Boolean, Boolean, RequiredAction, Boolean, StoreInviteSettings.InviteCode, String, StoreNotices.Notice, StoreNavigation.AgeGate, Uri, NavigationTab, Boolean, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2();

    public StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2() {
        super(14, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation.class, "<init>", "<init>(Lcom/discord/stores/StoreNux$NuxState;ZLcom/discord/models/authentication/AuthState;ZZLcom/discord/models/requiredaction/RequiredAction;ZLcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;Lcom/discord/stores/StoreNotices$Notice;Lcom/discord/stores/StoreNavigation$AgeGate;Landroid/net/Uri;Lcom/discord/widgets/tabs/NavigationTab;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function14
    public /* bridge */ /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation invoke(StoreNux.NuxState nuxState, Boolean bool, AuthState authState, Boolean bool2, Boolean bool3, RequiredAction requiredAction, Boolean bool4, StoreInviteSettings.InviteCode inviteCode, String str, StoreNotices.Notice notice, StoreNavigation.AgeGate ageGate, Uri uri, NavigationTab navigationTab, Boolean bool5) {
        return invoke(nuxState, bool.booleanValue(), authState, bool2.booleanValue(), bool3.booleanValue(), requiredAction, bool4.booleanValue(), inviteCode, str, notice, ageGate, uri, navigationTab, bool5.booleanValue());
    }

    public final StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation invoke(StoreNux.NuxState nuxState, boolean z2, AuthState authState, boolean z3, boolean z4, RequiredAction requiredAction, boolean z5, StoreInviteSettings.InviteCode inviteCode, String str, StoreNotices.Notice notice, StoreNavigation.AgeGate ageGate, Uri uri, NavigationTab navigationTab, boolean z6) {
        Intrinsics3.checkNotNullParameter(nuxState, "p1");
        Intrinsics3.checkNotNullParameter(requiredAction, "p6");
        Intrinsics3.checkNotNullParameter(uri, "p12");
        Intrinsics3.checkNotNullParameter(navigationTab, "p13");
        return new StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation(nuxState, z2, authState, z3, z4, requiredAction, z5, inviteCode, str, notice, ageGate, uri, navigationTab, z6);
    }
}
