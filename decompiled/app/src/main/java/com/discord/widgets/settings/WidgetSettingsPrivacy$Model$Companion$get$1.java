package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.stores.StoreUserConnections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ListIterator;
import kotlin.Metadata;

/* compiled from: WidgetSettingsPrivacy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreUserConnections$State;", "kotlin.jvm.PlatformType", "accounts", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreUserConnections$State;)Lcom/discord/api/connectedaccounts/ConnectedAccount;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$1<T, R> implements Func1<StoreUserConnections.State, ConnectedAccount> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$1 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ ConnectedAccount call(StoreUserConnections.State state) {
        return call2(state);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ConnectedAccount call2(StoreUserConnections.State state) {
        ConnectedAccount connectedAccountPrevious;
        Intrinsics3.checkNotNullExpressionValue(state, "accounts");
        ListIterator<ConnectedAccount> listIterator = state.listIterator(state.size());
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
        return connectedAccountPrevious;
    }
}
