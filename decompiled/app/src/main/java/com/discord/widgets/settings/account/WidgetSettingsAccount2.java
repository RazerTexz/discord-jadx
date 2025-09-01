package com.discord.widgets.settings.account;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMFA;
import com.discord.stores.StoreUserConnections;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func5;

/* compiled from: WidgetSettingsAccount.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0011\u001a\n \u0001*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032.\u0010\t\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b \u0001*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u00052\u000e\u0010\u000b\u001a\n \u0001*\u0004\u0018\u00010\n0\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/stores/StoreMFA$State;", "pendingMFAState", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "guilds", "Lcom/discord/stores/StoreUserConnections$State;", "connectedAccounts", "Lcom/discord/models/experiments/domain/Experiment;", "contactSyncExperiment", "Lcom/discord/widgets/settings/account/WidgetSettingsAccount$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/stores/StoreMFA$State;Ljava/util/Map;Lcom/discord/stores/StoreUserConnections$State;Lcom/discord/models/experiments/domain/Experiment;)Lcom/discord/widgets/settings/account/WidgetSettingsAccount$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccount2<T1, T2, T3, T4, T5, R> implements Func5<MeUser, StoreMFA.State, Map<Long, ? extends Guild>, StoreUserConnections.State, Experiment, WidgetSettingsAccount.Model> {
    public static final WidgetSettingsAccount2 INSTANCE = new WidgetSettingsAccount2();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetSettingsAccount.Model call(MeUser meUser, StoreMFA.State state, Map<Long, ? extends Guild> map, StoreUserConnections.State state2, Experiment experiment) {
        return call2(meUser, state, (Map<Long, Guild>) map, state2, experiment);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccount.Model call2(MeUser meUser, StoreMFA.State state, Map<Long, Guild> map, StoreUserConnections.State state2, Experiment experiment) {
        ConnectedAccount connectedAccount;
        ConnectedAccount connectedAccountPrevious;
        Intrinsics3.checkNotNullExpressionValue(state2, "connectedAccounts");
        ListIterator<ConnectedAccount> listIterator = state2.listIterator(state2.size());
        while (true) {
            connectedAccount = null;
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            }
            connectedAccountPrevious = listIterator.previous();
            if (Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                break;
            }
        }
        ConnectedAccount connectedAccount2 = connectedAccountPrevious;
        boolean z2 = true;
        if (experiment != null && experiment.getBucket() == 1) {
            connectedAccount = connectedAccount2;
        }
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        Intrinsics3.checkNotNullExpressionValue(state, "pendingMFAState");
        Collection<Guild> collectionValues = map.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((Guild) it.next()).getOwnerId() == meUser.getId()) {
                    break;
                }
            }
            z2 = false;
        }
        return new WidgetSettingsAccount.Model(meUser, state, z2, connectedAccount);
    }
}
