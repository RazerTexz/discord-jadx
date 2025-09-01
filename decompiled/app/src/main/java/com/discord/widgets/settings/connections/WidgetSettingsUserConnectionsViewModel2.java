package com.discord.widgets.settings.connections;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreUserConnections;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\n \u0001*\u0004\u0018\u00010\b0\b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0001*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/stores/StoreUserConnections$State;", "kotlin.jvm.PlatformType", "accounts", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "guilds", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreUserConnections$State;Ljava/util/Map;)Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsViewModel2<T1, T2, R> implements Func2<StoreUserConnections.State, Map<Long, ? extends Guild>, WidgetSettingsUserConnectionsViewModel.StoreState> {
    public static final WidgetSettingsUserConnectionsViewModel2 INSTANCE = new WidgetSettingsUserConnectionsViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetSettingsUserConnectionsViewModel.StoreState call(StoreUserConnections.State state, Map<Long, ? extends Guild> map) {
        return call2(state, (Map<Long, Guild>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsUserConnectionsViewModel.StoreState call2(StoreUserConnections.State state, Map<Long, Guild> map) {
        Intrinsics3.checkNotNullExpressionValue(state, "accounts");
        ArrayList arrayList = new ArrayList();
        for (ConnectedAccount connectedAccount : state) {
            if (!Intrinsics3.areEqual(connectedAccount.getType(), "contacts")) {
                arrayList.add(connectedAccount);
            }
        }
        Intrinsics3.checkNotNullExpressionValue(map, "guilds");
        return new WidgetSettingsUserConnectionsViewModel.StoreState(arrayList, map);
    }
}
