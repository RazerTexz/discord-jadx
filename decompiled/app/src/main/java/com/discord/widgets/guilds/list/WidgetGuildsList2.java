package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreNux;
import com.discord.widgets.guilds.list.WidgetGuildsList;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetGuildsList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\n \u0001*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032.\u0010\t\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b \u0001*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "kotlin.jvm.PlatformType", "nuxState", "", "connectionOpen", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "channels", "Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreNux$NuxState;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/discord/widgets/guilds/list/WidgetGuildsList$AddGuildHint;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsList2<T1, T2, T3, R> implements Func3<StoreNux.NuxState, Boolean, Map<Long, ? extends Channel>, WidgetGuildsList.AddGuildHint> {
    public static final WidgetGuildsList2 INSTANCE = new WidgetGuildsList2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetGuildsList.AddGuildHint call(StoreNux.NuxState nuxState, Boolean bool, Map<Long, ? extends Channel> map) {
        return call2(nuxState, bool, (Map<Long, Channel>) map);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetGuildsList.AddGuildHint call2(StoreNux.NuxState nuxState, Boolean bool, Map<Long, Channel> map) {
        boolean z2;
        if (nuxState.getAddGuildHint()) {
            Intrinsics3.checkNotNullExpressionValue(bool, "connectionOpen");
            z2 = bool.booleanValue() && map.isEmpty();
        }
        return new WidgetGuildsList.AddGuildHint(z2, nuxState.getAddGuildHint());
    }
}
