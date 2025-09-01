package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: ChatTypingModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\n\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \u0003*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006 \u0003* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \u0003*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "userIds", "Lrx/Observable;", "", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel6<T, R> implements Func1<Set<? extends Long>, Observable<? extends List<? extends String>>> {
    public final /* synthetic */ Channel $channel;

    /* compiled from: ChatTypingModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n \u0004*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u000026\u0010\b\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "users", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends String>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends String> call(Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2) {
            return call2(map, (Map<Long, GuildMember>) map2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<String> call2(Map<Long, ? extends User> map, Map<Long, GuildMember> map2) {
            Collection<? extends User> collectionValues = map.values();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
            for (User user : collectionValues) {
                arrayList.add(GuildMember.INSTANCE.getNickOrUsername((GuildMember) outline.f(user, map2), user));
            }
            return arrayList;
        }
    }

    public ChatTypingModel6(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends String>> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<String>> call2(Set<Long> set) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreUser users = companion.getUsers();
        Intrinsics3.checkNotNullExpressionValue(set, "userIds");
        return Observable.j(users.observeUsers(set), companion.getGuilds().observeComputed(this.$channel.getGuildId(), set), AnonymousClass1.INSTANCE);
    }
}
