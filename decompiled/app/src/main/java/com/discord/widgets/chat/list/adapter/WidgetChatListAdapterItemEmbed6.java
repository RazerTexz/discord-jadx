package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed;
import com.discord.widgets.chat.list.entries.EmbedEntry;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0011\u001a\n \u0002*\u0004\u0018\u00010\u000e0\u000e2\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0002*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00040\u00042±\u0001\u0010\n\u001a¬\u0001\u0012\u0016\u0012\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006 \u0002*V\u0012\u0016\u0012\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\bj*\u0012\u0016\u0012\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006\u0018\u0001`\t0\bj(\u0012\u0016\u0012\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006`\t2.\u0010\r\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\u000b\u0012\u0004\u0012\u00020\f \u0002*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "myId", "", "Lcom/discord/primitives/ChannelId;", "", "channelNames", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "userNames", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemEmbed$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Ljava/util/Map;Ljava/util/HashMap;Ljava/util/Map;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemEmbed$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Companion$getModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed6<T1, T2, T3, T4, R> implements Func4<Long, Map<Long, ? extends String>, HashMap<Long, String>, Map<Long, ? extends GuildRole>, WidgetChatListAdapterItemEmbed.Model> {
    public final /* synthetic */ EmbedEntry $embedEntry;
    public final /* synthetic */ Collection $parsedDescription;
    public final /* synthetic */ List $parsedFields;

    public WidgetChatListAdapterItemEmbed6(EmbedEntry embedEntry, Collection collection, List list) {
        this.$embedEntry = embedEntry;
        this.$parsedDescription = collection;
        this.$parsedFields = list;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemEmbed.Model call(Long l, Map<Long, ? extends String> map, HashMap<Long, String> map2, Map<Long, ? extends GuildRole> map3) {
        return call2(l, (Map<Long, String>) map, map2, (Map<Long, GuildRole>) map3);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemEmbed.Model call2(Long l, Map<Long, String> map, HashMap<Long, String> map2, Map<Long, GuildRole> map3) {
        EmbedEntry embedEntry = this.$embedEntry;
        Collection collection = this.$parsedDescription;
        List list = this.$parsedFields;
        Intrinsics3.checkNotNullExpressionValue(l, "myId");
        return new WidgetChatListAdapterItemEmbed.Model(embedEntry, collection, list, map, map2, map3, l.longValue());
    }
}
