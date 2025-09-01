package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.UserProfile;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.settings.profile.EditUserOrGuildMemberProfileViewModel2;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052:\u0010\u0004\u001a6\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0002*\u001a\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "Lcom/discord/models/guild/Guild;", "<name for destructuring parameter 0>", "Lrx/Observable;", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class EditUserOrGuildMemberProfileViewModel4<T, R> implements Func1<Tuples2<? extends MeUser, ? extends Guild>, Observable<? extends EditUserOrGuildMemberProfileViewModel2.StoreState>> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\n \u0001*\u0004\u0018\u00010\b0\b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u000e\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/api/user/UserProfile;", "kotlin.jvm.PlatformType", "userProfile", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "member", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "guildChannelsInfo", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/user/UserProfile;Lcom/discord/models/member/GuildMember;Lcom/discord/utilities/channel/GuildChannelsInfo;)Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<UserProfile, GuildMember, GuildChannelsInfo, EditUserOrGuildMemberProfileViewModel2.StoreState> {
        public final /* synthetic */ Guild $guild;
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass1(MeUser meUser, Guild guild) {
            this.$meUser = meUser;
            this.$guild = guild;
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ EditUserOrGuildMemberProfileViewModel2.StoreState call(UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            return call2(userProfile, guildMember, guildChannelsInfo);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EditUserOrGuildMemberProfileViewModel2.StoreState call2(UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            MeUser.Companion companion = MeUser.INSTANCE;
            MeUser meUser = this.$meUser;
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            MeUser meUserMerge = companion.merge(meUser, userProfile.getUser());
            Guild guild = this.$guild;
            Intrinsics3.checkNotNullExpressionValue(userProfile, "userProfile");
            Intrinsics3.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
            return new EditUserOrGuildMemberProfileViewModel2.StoreState(meUserMerge, guild, userProfile, guildMember, guildChannelsInfo);
        }
    }

    public EditUserOrGuildMemberProfileViewModel4(StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, Long l) {
        this.$storeUserProfile = storeUserProfile;
        this.$storeGuilds = storeGuilds;
        this.$guildId = l;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends EditUserOrGuildMemberProfileViewModel2.StoreState> call(Tuples2<? extends MeUser, ? extends Guild> tuples2) {
        return call2((Tuples2<MeUser, Guild>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends EditUserOrGuildMemberProfileViewModel2.StoreState> call2(Tuples2<MeUser, Guild> tuples2) {
        MeUser meUserComponent1 = tuples2.component1();
        Guild guildComponent2 = tuples2.component2();
        Observable<UserProfile> observableObserveUserProfile = this.$storeUserProfile.observeUserProfile(meUserComponent1.getId());
        StoreGuilds storeGuilds = this.$storeGuilds;
        Long l = this.$guildId;
        Observable<GuildMember> observableObserveGuildMember = storeGuilds.observeGuildMember(l != null ? l.longValue() : -1L, meUserComponent1.getId());
        GuildChannelsInfo.Companion companion = GuildChannelsInfo.INSTANCE;
        Long l2 = this.$guildId;
        return Observable.i(observableObserveUserProfile, observableObserveGuildMember, companion.get(l2 != null ? l2.longValue() : -1L), new AnonymousClass1(meUserComponent1, guildComponent2));
    }
}
