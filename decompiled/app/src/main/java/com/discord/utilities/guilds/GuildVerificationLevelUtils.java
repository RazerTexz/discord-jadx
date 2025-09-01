package com.discord.utilities.guilds;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.guildmember.GuildMemberUtils;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import j0.l.a.OnSubscribeLift;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func6;

/* compiled from: GuildVerificationLevelUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!Ja\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0018\u0010\u0012\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u001b\u001a\u00020\b2\n\u0010\u0016\u001a\u00060\nj\u0002`\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ=\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001d2\n\u0010\u0016\u001a\u00060\nj\u0002`\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/discord/utilities/guilds/GuildVerificationLevelUtils;", "", "Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/member/GuildMember;", "member", "Lcom/discord/api/guild/GuildVerificationLevel;", "verificationLevel", "", "Lcom/discord/primitives/Timestamp;", "joinedAt", "Lcom/discord/utilities/time/Clock;", "clock", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "computeVerificationLevelTriggered", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/models/member/GuildMember;Lcom/discord/api/guild/GuildVerificationLevel;JLcom/discord/utilities/time/Clock;Ljava/util/Map;)Lcom/discord/api/guild/GuildVerificationLevel;", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreUser;", "userStore", "getVerificationLevelTriggered", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/utilities/time/Clock;)Lcom/discord/api/guild/GuildVerificationLevel;", "Lrx/Observable;", "observeVerificationLevelTriggered", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/utilities/time/Clock;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildVerificationLevelUtils {
    public static final GuildVerificationLevelUtils INSTANCE = new GuildVerificationLevelUtils();

    /* compiled from: GuildVerificationLevelUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0014\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00060\u000626\u0010\f\u001a2\u0012\b\u0012\u00060\u0000j\u0002`\t\u0012\b\u0012\u00060\nj\u0002`\u000b \u0002*\u0018\u0012\b\u0012\u00060\u0000j\u0002`\t\u0012\b\u0012\u00060\nj\u0002`\u000b\u0018\u00010\b0\b2\u000e\u0010\u000e\u001a\n \u0002*\u0004\u0018\u00010\r0\r2.\u0010\u0011\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\u000f\u0012\u0004\u0012\u00020\u0010 \u0002*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\b0\bH\n¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"", "Lcom/discord/primitives/Timestamp;", "kotlin.jvm.PlatformType", "joinedAt", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/guild/GuildVerificationLevel;", "verificationLevel", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Lcom/discord/models/guild/Guild;Lcom/discord/api/guild/GuildVerificationLevel;Ljava/util/Map;Lcom/discord/models/user/MeUser;Ljava/util/Map;)Lcom/discord/api/guild/GuildVerificationLevel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.guilds.GuildVerificationLevelUtils$observeVerificationLevelTriggered$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, R> implements Func6<Long, Guild, GuildVerificationLevel, Map<Long, ? extends GuildMember>, MeUser, Map<Long, ? extends GuildRole>, GuildVerificationLevel> {
        public final /* synthetic */ Clock $clock;

        public AnonymousClass1(Clock clock) {
            this.$clock = clock;
        }

        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ GuildVerificationLevel call(Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Map<Long, ? extends GuildMember> map, MeUser meUser, Map<Long, ? extends GuildRole> map2) {
            return call2(l, guild, guildVerificationLevel, (Map<Long, GuildMember>) map, meUser, (Map<Long, GuildRole>) map2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildVerificationLevel call2(Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Map<Long, GuildMember> map, MeUser meUser, Map<Long, GuildRole> map2) {
            GuildVerificationLevelUtils guildVerificationLevelUtils = GuildVerificationLevelUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            Intrinsics3.checkNotNullExpressionValue(map, "members");
            GuildMember guildMember = map.get(Long.valueOf(meUser.getId()));
            Intrinsics3.checkNotNullExpressionValue(guildVerificationLevel, "verificationLevel");
            Intrinsics3.checkNotNullExpressionValue(l, "joinedAt");
            return GuildVerificationLevelUtils.access$computeVerificationLevelTriggered(guildVerificationLevelUtils, meUser, guild, guildMember, guildVerificationLevel, l.longValue(), this.$clock, map2);
        }
    }

    private GuildVerificationLevelUtils() {
    }

    public static final /* synthetic */ GuildVerificationLevel access$computeVerificationLevelTriggered(GuildVerificationLevelUtils guildVerificationLevelUtils, MeUser meUser, Guild guild, GuildMember guildMember, GuildVerificationLevel guildVerificationLevel, long j, Clock clock, Map map) {
        return guildVerificationLevelUtils.computeVerificationLevelTriggered(meUser, guild, guildMember, guildVerificationLevel, j, clock, map);
    }

    private final GuildVerificationLevel computeVerificationLevelTriggered(MeUser me2, Guild guild, GuildMember member, GuildVerificationLevel verificationLevel, long joinedAt, Clock clock, Map<Long, GuildRole> guildRoles) {
        List<Long> roles;
        GuildRole guildRole;
        boolean z2 = false;
        boolean z3 = guild != null && guild.isOwner(me2.getId());
        if (member != null && (roles = member.getRoles()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : roles) {
                if (!((guildRoles == null || (guildRole = guildRoles.get(Long.valueOf(((Number) obj).longValue()))) == null) ? true : guildRole.getManaged())) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                z2 = true;
            }
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean hasPhone = userUtils.getHasPhone(me2);
        boolean zIsStaff = userUtils.isStaff(me2);
        if (z3 || z2 || hasPhone || zIsStaff) {
            return GuildVerificationLevel.NONE;
        }
        GuildVerificationLevel guildVerificationLevel = GuildVerificationLevel.HIGHEST;
        if (verificationLevel == guildVerificationLevel) {
            return guildVerificationLevel;
        }
        GuildVerificationLevel guildVerificationLevel2 = GuildVerificationLevel.HIGH;
        if (verificationLevel == guildVerificationLevel2 && !GuildMemberUtils.isGuildMemberOldEnough(joinedAt)) {
            return guildVerificationLevel2;
        }
        GuildVerificationLevel guildVerificationLevel3 = GuildVerificationLevel.MEDIUM;
        if (verificationLevel == guildVerificationLevel3 && !userUtils.isAccountOldEnough(me2, clock)) {
            return guildVerificationLevel3;
        }
        GuildVerificationLevel guildVerificationLevel4 = GuildVerificationLevel.LOW;
        return (verificationLevel != guildVerificationLevel4 || me2.isVerified()) ? GuildVerificationLevel.NONE : guildVerificationLevel4;
    }

    public static /* synthetic */ GuildVerificationLevel getVerificationLevelTriggered$default(GuildVerificationLevelUtils guildVerificationLevelUtils, long j, StoreGuilds storeGuilds, StoreUser storeUser, Clock clock, int i, Object obj) {
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        StoreGuilds storeGuilds2 = storeGuilds;
        if ((i & 4) != 0) {
            storeUser = StoreStream.INSTANCE.getUsers();
        }
        StoreUser storeUser2 = storeUser;
        if ((i & 8) != 0) {
            clock = ClockFactory.get();
        }
        return guildVerificationLevelUtils.getVerificationLevelTriggered(j, storeGuilds2, storeUser2, clock);
    }

    public static /* synthetic */ Observable observeVerificationLevelTriggered$default(GuildVerificationLevelUtils guildVerificationLevelUtils, long j, StoreGuilds storeGuilds, StoreUser storeUser, Clock clock, int i, Object obj) {
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        StoreGuilds storeGuilds2 = storeGuilds;
        if ((i & 4) != 0) {
            storeUser = StoreStream.INSTANCE.getUsers();
        }
        StoreUser storeUser2 = storeUser;
        if ((i & 8) != 0) {
            clock = ClockFactory.get();
        }
        return guildVerificationLevelUtils.observeVerificationLevelTriggered(j, storeGuilds2, storeUser2, clock);
    }

    public final GuildVerificationLevel getVerificationLevelTriggered(long guildId, StoreGuilds guildStore, StoreUser userStore, Clock clock) {
        GuildVerificationLevel verificationLevel;
        Intrinsics3.checkNotNullParameter(guildStore, "guildStore");
        Intrinsics3.checkNotNullParameter(userStore, "userStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Guild guild = guildStore.getGuild(guildId);
        Map<Long, GuildMember> map = guildStore.getMembers().get(Long.valueOf(guildId));
        MeUser meSnapshot = userStore.getMeSnapshot();
        Map<Long, GuildRole> map2 = guildStore.getRoles().get(Long.valueOf(guildId));
        GuildMember guildMember = map != null ? map.get(Long.valueOf(meSnapshot.getId())) : null;
        if (guild == null || (verificationLevel = guild.getVerificationLevel()) == null) {
            verificationLevel = GuildVerificationLevel.NONE;
        }
        return computeVerificationLevelTriggered(meSnapshot, guild, guildMember, verificationLevel, GuildMemberUtils.getJoinedAtOrNow(guildStore.getGuildsJoinedAt().get(Long.valueOf(guildId))), clock, map2);
    }

    public final Observable<GuildVerificationLevel> observeVerificationLevelTriggered(long guildId, StoreGuilds guildStore, StoreUser userStore, Clock clock) {
        Intrinsics3.checkNotNullParameter(guildStore, "guildStore");
        Intrinsics3.checkNotNullParameter(userStore, "userStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Observable<Long> observableObserveJoinedAt = guildStore.observeJoinedAt(guildId);
        Observable<Guild> observableObserveGuild = guildStore.observeGuild(guildId);
        Observable<GuildVerificationLevel> observableObserveVerificationLevel = guildStore.observeVerificationLevel(guildId);
        Observable<Map<Long, GuildMember>> observableObserveComputed = guildStore.observeComputed(guildId);
        Observable<GuildVerificationLevel> observableR = Observable.f(observableObserveJoinedAt, observableObserveGuild, observableObserveVerificationLevel, Observable.h0(new OnSubscribeLift(observableObserveComputed.j, new LeadingEdgeThrottle(1500L, TimeUnit.MILLISECONDS))), userStore.observeMe(true), guildStore.observeRoles(guildId), new AnonymousClass1(clock)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        return observableR;
    }
}
