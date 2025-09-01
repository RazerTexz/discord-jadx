package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a¬\u0001\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00070\u0007 \u0005*V\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\tj*\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00070\u0007\u0018\u0001`\n0\tj(\u0012\u0016\u0012\u0014 \u0005*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00070\u0007`\n26\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u00002.\u0010\b\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007 \u0005*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "members", "", "usernames", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/HashMap;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Companion$getModel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed5<T1, T2, R> implements Func2<Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, HashMap<Long, String>> {
    public static final WidgetChatListAdapterItemEmbed5 INSTANCE = new WidgetChatListAdapterItemEmbed5();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ HashMap<Long, String> call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends String> map2) {
        return call2((Map<Long, GuildMember>) map, (Map<Long, String>) map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final HashMap<Long, String> call2(Map<Long, GuildMember> map, Map<Long, String> map2) {
        Intrinsics3.checkNotNullExpressionValue(map, "members");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, GuildMember> entry : map.entrySet()) {
            if (entry.getValue().getNick() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        HashMap<Long, String> map3 = new HashMap<>(map2);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            String nick = ((GuildMember) entry2.getValue()).getNick();
            Intrinsics3.checkNotNull(nick);
            map3.put(key, nick);
        }
        return map3;
    }
}
