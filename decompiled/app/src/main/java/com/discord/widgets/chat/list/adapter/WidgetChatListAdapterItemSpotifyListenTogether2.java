package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether;
import com.discord.widgets.chat.list.entries.SpotifyListenTogetherEntry;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012.\u0010\b\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0007*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u00032\u0018\u0010\t\u001a\u0014 \u0007*\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\u0004j\u0002`\u0005H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presence", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "userMap", "meId", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/presence/Presence;Ljava/util/Map;Ljava/lang/Long;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSpotifyListenTogether$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether2<T1, T2, T3, R> implements Func3<Presence, Map<Long, ? extends User>, Long, WidgetChatListAdapterItemSpotifyListenTogether.Model> {
    public final /* synthetic */ SpotifyListenTogetherEntry $item;

    public WidgetChatListAdapterItemSpotifyListenTogether2(SpotifyListenTogetherEntry spotifyListenTogetherEntry) {
        this.$item = spotifyListenTogetherEntry;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogether.Model call(Presence presence, Map<Long, ? extends User> map, Long l) {
        return call2(presence, map, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemSpotifyListenTogether.Model call2(Presence presence, Map<Long, ? extends User> map, Long l) {
        WidgetChatListAdapterItemSpotifyListenTogether.Model.Companion companion = WidgetChatListAdapterItemSpotifyListenTogether.Model.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(map, "userMap");
        SpotifyListenTogetherEntry spotifyListenTogetherEntry = this.$item;
        return WidgetChatListAdapterItemSpotifyListenTogether.Model.Companion.access$create(companion, presence, map, spotifyListenTogetherEntry, l != null && l.longValue() == spotifyListenTogetherEntry.getUserId());
    }
}
