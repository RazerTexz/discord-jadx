package com.discord.widgets.contact_sync;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.models.user.MeUser;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: WidgetContactSyncViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Unit;)Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetContactSyncViewModel2<T, R> implements Func1<Unit, WidgetContactSyncViewModel.StoreState> {
    public final /* synthetic */ StoreUserConnections $storeConnections;
    public final /* synthetic */ StorePhone $storePhone;
    public final /* synthetic */ StoreUser $storeUsers;

    public WidgetContactSyncViewModel2(StoreUser storeUser, StorePhone storePhone, StoreUserConnections storeUserConnections) {
        this.$storeUsers = storeUser;
        this.$storePhone = storePhone;
        this.$storeConnections = storeUserConnections;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel.StoreState call(Unit unit) {
        return call2(unit);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetContactSyncViewModel.StoreState call2(Unit unit) {
        ConnectedAccount connectedAccountPrevious;
        MeUser meSnapshot = this.$storeUsers.getMeSnapshot();
        PhoneCountryCode countryCode = this.$storePhone.getCountryCode();
        StoreUserConnections.State stateSnapshot = this.$storeConnections.getStateSnapshot();
        ListIterator<ConnectedAccount> listIterator = stateSnapshot.listIterator(stateSnapshot.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            }
            connectedAccountPrevious = listIterator.previous();
            if (Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                break;
            }
        }
        return new WidgetContactSyncViewModel.StoreState(meSnapshot.getPhoneNumber(), UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, meSnapshot, null, null, 3, null).toString(), countryCode, connectedAccountPrevious);
    }
}
