package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.chat.list.CreateThreadsFeatureFlag;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.Observable;
import rx.functions.Func8;

/* compiled from: WidgetHomeModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00070\u0007 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00062Z\u0010\u0005\u001aV\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004 \u0003**\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/Pair;", "", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "<name for destructuring parameter 0>", "Lrx/Observable;", "Lcom/discord/widgets/home/WidgetHomeModel;", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.home.WidgetHomeModel$Companion$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomeModel3<T, R> implements Func1<Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>, Observable<? extends WidgetHomeModel>> {
    public static final WidgetHomeModel3 INSTANCE = new WidgetHomeModel3();

    /* compiled from: WidgetHomeModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0017\u001a\n \u0001*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u000026\u0010\b\u001a2\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u0007 \u0001*\u0018\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u00030\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\f\u001a\n \u0001*\u0004\u0018\u00010\u000b0\u000b26\u0010\u000e\u001a2\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\b\u0012\u00060\u000bj\u0002`\r \u0001*\u0018\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\b\u0012\u00060\u000bj\u0002`\r\u0018\u00010\u00030\u00032.\u0010\u0010\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u000f\u0012\u0004\u0012\u00020\t \u0001*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u00030\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0013\u001a\n \u0001*\u0004\u0018\u00010\u00120\u0012H\n¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presences", "Lcom/discord/api/channel/Channel;", "voiceChannel", "", "unreadCount", "Lcom/discord/primitives/RelationshipType;", "userRelationships", "Lcom/discord/primitives/ChannelId;", "activeThreads", "parentChannel", "", "threadExperimentEnabled", "Lcom/discord/widgets/home/WidgetHomeModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Ljava/util/Map;Lcom/discord/api/channel/Channel;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/Map;Lcom/discord/api/channel/Channel;Ljava/lang/Boolean;)Lcom/discord/widgets/home/WidgetHomeModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.home.WidgetHomeModel$Companion$get$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<MeUser, Map<Long, ? extends Presence>, Channel, Integer, Map<Long, ? extends Integer>, Map<Long, ? extends Channel>, Channel, Boolean, WidgetHomeModel> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

        public AnonymousClass1(Channel channel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            this.$channel = channel;
            this.$selectedChannel = resolvedSelectedChannel;
        }

        @Override // rx.functions.Func8
        public /* bridge */ /* synthetic */ WidgetHomeModel call(MeUser meUser, Map<Long, ? extends Presence> map, Channel channel, Integer num, Map<Long, ? extends Integer> map2, Map<Long, ? extends Channel> map3, Channel channel2, Boolean bool) {
            return call2(meUser, (Map<Long, Presence>) map, channel, num, (Map<Long, Integer>) map2, (Map<Long, Channel>) map3, channel2, bool);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WidgetHomeModel call2(MeUser meUser, Map<Long, Presence> map, Channel channel, Integer num, Map<Long, Integer> map2, Map<Long, Channel> map3, Channel channel2, Boolean bool) {
            boolean z2;
            User userA;
            User userA2;
            Channel channel3 = this.$channel;
            if (channel3 != null && ChannelUtils.B(channel3)) {
                Long lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
                Channel channel4 = this.$channel;
                if (Intrinsics3.areEqual(lValueOf, channel4 != null ? Long.valueOf(channel4.getId()) : null)) {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.$selectedChannel;
            Intrinsics3.checkNotNullExpressionValue(resolvedSelectedChannel, "selectedChannel");
            Channel channel5 = this.$channel;
            Presence presence = (channel5 == null || (userA2 = ChannelUtils.a(channel5)) == null) ? null : (Presence) outline.f(userA2, map);
            Intrinsics3.checkNotNullExpressionValue(num, "unreadCount");
            int iIntValue = num.intValue();
            Intrinsics3.checkNotNullExpressionValue(map2, "userRelationships");
            Channel channel6 = this.$channel;
            boolean zIsType = ModelUserRelationship.isType(map2.get((channel6 == null || (userA = ChannelUtils.a(channel6)) == null) ? null : Long.valueOf(userA.getId())), 1);
            NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
            int size = map3.size();
            Intrinsics3.checkNotNullExpressionValue(bool, "threadExperimentEnabled");
            return new WidgetHomeModel(resolvedSelectedChannel, channel, channel2, presence, iIntValue, zIsType, z2, nsfwAllowance, size, bool.booleanValue());
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetHomeModel> call(Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> tuples2) {
        return call2((Tuples2<Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetHomeModel> call2(Tuples2<Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> tuples2) {
        Long lValueOf;
        long id2;
        Long lComponent1 = tuples2.component1();
        StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannelComponent2 = tuples2.component2();
        Channel maybeChannel = resolvedSelectedChannelComponent2.getMaybeChannel();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
        Observable<Map<Long, Presence>> observableObserveAllPresences = companion.getPresences().observeAllPresences();
        Observable<Channel> observableObserveSelectedChannel = companion.getVoiceChannelSelected().observeSelectedChannel();
        Observable<Integer> observableObserveTotalMentions = companion.getMentions().observeTotalMentions();
        Observable<Map<Long, Integer>> observableObserve = companion.getUserRelationships().observe();
        StoreThreadsActive threadsActive = companion.getThreadsActive();
        Intrinsics3.checkNotNullExpressionValue(lComponent1, "selectedGuildId");
        long jLongValue = lComponent1.longValue();
        if (maybeChannel != null && ChannelUtils.H(maybeChannel)) {
            id2 = maybeChannel.getParentId();
        } else {
            if (maybeChannel == null) {
                lValueOf = null;
                return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.INSTANCE.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new AnonymousClass1(maybeChannel, resolvedSelectedChannelComponent2), 350L, TimeUnit.MILLISECONDS);
            }
            id2 = maybeChannel.getId();
        }
        lValueOf = Long.valueOf(id2);
        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.INSTANCE.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new AnonymousClass1(maybeChannel, resolvedSelectedChannelComponent2), 350L, TimeUnit.MILLISECONDS);
    }
}
