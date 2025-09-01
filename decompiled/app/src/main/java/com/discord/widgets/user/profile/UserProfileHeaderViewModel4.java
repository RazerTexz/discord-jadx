package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.UserProfile;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.user.presence.ModelRichPresence;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.a.EmptyObservableHolder;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.Observable;
import rx.functions.Func8;

/* compiled from: UserProfileHeaderViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052:\u0010\u0004\u001a6\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0002*\u001a\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "Lcom/discord/models/user/User;", "<name for destructuring parameter 0>", "Lrx/Observable;", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel4<T, R> implements Func1<Tuples2<? extends MeUser, ? extends User>, Observable<? extends UserProfileHeaderViewModel.StoreState>> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreAccessibility $storeAccessibility;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUserPresence $storeUserPresence;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;
    public final /* synthetic */ StreamContextService $streamContextService;

    /* compiled from: UserProfileHeaderViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0017\u001a\n \u0004*\u0004\u0018\u00010\u00140\u00142.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002V\u0010\b\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00070\u0000 \u0004*(\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00070\u0000\u0018\u00010\u00000\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n \u0004*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0010\u001a\n \u0004*\u0004\u0018\u00010\u000f0\u000f2\u000e\u0010\u0011\u001a\n \u0004*\u0004\u0018\u00010\u000f0\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\n¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "kotlin.jvm.PlatformType", "userIdToGuildMembersMap", "Lcom/discord/primitives/GuildId;", "Lcom/discord/stores/ClientGuildMember;", "guildMembers", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "richPresence", "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "Lcom/discord/api/user/UserProfile;", "userProfile", "", "allowAnimatedEmojis", "reducedMotionEnabled", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Lcom/discord/widgets/user/presence/ModelRichPresence;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/user/UserProfile;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Map<Long, ? extends GuildMember>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, ModelRichPresence, StreamContext, UserProfile, Boolean, Boolean, Channel, UserProfileHeaderViewModel.StoreState> {
        public final /* synthetic */ MeUser $meUser;
        public final /* synthetic */ User $targetUser;

        public AnonymousClass1(MeUser meUser, User user) {
            this.$meUser = meUser;
            this.$targetUser = user;
        }

        @Override // rx.functions.Func8
        public /* bridge */ /* synthetic */ UserProfileHeaderViewModel.StoreState call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends Map<Long, ? extends GuildMember>> map2, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, Boolean bool, Boolean bool2, Channel channel) {
            return call2((Map<Long, GuildMember>) map, (Map<Long, ? extends Map<Long, GuildMember>>) map2, modelRichPresence, streamContext, userProfile, bool, bool2, channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final UserProfileHeaderViewModel.StoreState call2(Map<Long, GuildMember> map, Map<Long, ? extends Map<Long, GuildMember>> map2, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, Boolean bool, Boolean bool2, Channel channel) {
            MeUser meUser = this.$meUser;
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            User user = this.$targetUser;
            Intrinsics3.checkNotNullExpressionValue(map, "userIdToGuildMembersMap");
            Collection<? extends Map<Long, GuildMember>> collectionValues = map2.values();
            Intrinsics3.checkNotNullExpressionValue(userProfile, "userProfile");
            Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics3.checkNotNullExpressionValue(bool2, "reducedMotionEnabled");
            return new UserProfileHeaderViewModel.StoreState(meUser, user, map, collectionValues, modelRichPresence, streamContext, userProfile, zBooleanValue, bool2.booleanValue(), channel);
        }
    }

    public UserProfileHeaderViewModel4(Long l, StoreChannels storeChannels, StoreGuilds storeGuilds, Long l2, StoreUserPresence storeUserPresence, StreamContextService streamContextService, StoreUserProfile storeUserProfile, StoreUserSettings storeUserSettings, StoreAccessibility storeAccessibility) {
        this.$channelId = l;
        this.$storeChannels = storeChannels;
        this.$storeGuilds = storeGuilds;
        this.$guildId = l2;
        this.$storeUserPresence = storeUserPresence;
        this.$streamContextService = streamContextService;
        this.$storeUserProfile = storeUserProfile;
        this.$storeUserSettings = storeUserSettings;
        this.$storeAccessibility = storeAccessibility;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Observable<? extends UserProfileHeaderViewModel.StoreState> call2(Tuples2<MeUser, ? extends User> tuples2) {
        Observable<Channel> scalarSynchronousObservable;
        MeUser meUserComponent1 = tuples2.component1();
        User userComponent2 = tuples2.component2();
        if (userComponent2 == null) {
            return EmptyObservableHolder.k;
        }
        Long l = this.$channelId;
        if (l != null) {
            l.longValue();
            scalarSynchronousObservable = this.$storeChannels.observeChannel(this.$channelId.longValue());
            if (scalarSynchronousObservable == null) {
                scalarSynchronousObservable = new ScalarSynchronousObservable<>(null);
            }
        }
        return Observable.d(UserProfileHeaderViewModel.Companion.access$observeComputedMembers(UserProfileHeaderViewModel.INSTANCE, this.$channelId, this.$guildId, Sets5.setOf((Object[]) new Long[]{Long.valueOf(meUserComponent1.getId()), Long.valueOf(userComponent2.getId())}), this.$storeChannels, this.$storeGuilds), this.$storeGuilds.observeComputed(), ModelRichPresence.INSTANCE.get(userComponent2.getId(), this.$storeUserPresence), this.$streamContextService.getForUser(userComponent2.getId(), true), this.$storeUserProfile.observeUserProfile(userComponent2.getId()), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(this.$storeUserSettings, false, 1, null), this.$storeAccessibility.observeReducedMotionEnabled(), scalarSynchronousObservable, new AnonymousClass1(meUserComponent1, userComponent2));
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends UserProfileHeaderViewModel.StoreState> call(Tuples2<? extends MeUser, ? extends User> tuples2) {
        return call2((Tuples2<MeUser, ? extends User>) tuples2);
    }
}
