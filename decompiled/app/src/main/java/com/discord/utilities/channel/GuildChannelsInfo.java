package com.discord.utilities.channel;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import d0.t.Collections2;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildChannelsInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 M2\u00020\u0001:\u0001MB\u0089\u0001\u0012\b\u0010%\u001a\u0004\u0018\u00010\r\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010'\u001a\u00020\u0013\u0012\u0006\u0010(\u001a\u00020\u0016\u0012\u001a\u0010)\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\u00190\u0002\u0012\u0006\u0010*\u001a\u00020\u0016\u0012\u0006\u0010+\u001a\u00020\u0016\u0012\u0006\u0010,\u001a\u00020\u0016\u0012\u0006\u0010-\u001a\u00020\u001f\u0012\u0006\u0010.\u001a\u00020\u0016\u0012\u0018\u0010/\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`#\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002¢\u0006\u0004\bK\u0010LJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\b\u0010\tJ=\u0010\u000b\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u00022\u0018\u0010\u0006\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\u00190\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0018J\u0010\u0010\u001e\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010 \u001a\u00020\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\"\u0010\u0018J\"\u0010$\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`#\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001bJ¨\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00162\u001c\b\u0002\u0010)\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\u00190\u00022\b\b\u0002\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u00162\b\b\u0002\u0010,\u001a\u00020\u00162\b\b\u0002\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010.\u001a\u00020\u00162\u001a\b\u0002\u0010/\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`#\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00103\u001a\u000202HÖ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00106\u001a\u000205HÖ\u0001¢\u0006\u0004\b6\u00107J\u001a\u00109\u001a\u00020\u00162\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b9\u0010:R\u0019\u0010-\u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010;\u001a\u0004\b<\u0010!R\u0019\u0010+\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010=\u001a\u0004\b>\u0010\u0018R\u0019\u0010'\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010?\u001a\u0004\b@\u0010\u0015R+\u0010/\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`#\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010A\u001a\u0004\bB\u0010\u001bR\u0019\u0010*\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010=\u001a\u0004\bC\u0010\u0018R\u0019\u0010.\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010=\u001a\u0004\bD\u0010\u0018R\u0019\u0010,\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010=\u001a\u0004\b,\u0010\u0018R\u001b\u0010%\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010E\u001a\u0004\bF\u0010\u000fR\u0019\u0010(\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010=\u001a\u0004\bG\u0010\u0018R\u001b\u0010&\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010H\u001a\u0004\bI\u0010\u0012R-\u0010)\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\u00190\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010A\u001a\u0004\bJ\u0010\u001b¨\u0006N"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelsInfo;", "", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "guildChannels", "", "getSortedVisibleChannels", "(Ljava/util/Map;)Ljava/util/List;", "", "getSortedCategories", "(Ljava/util/Map;)Ljava/util/Map;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/role/GuildRole;", "component2", "()Lcom/discord/api/role/GuildRole;", "Lcom/discord/models/domain/ModelNotificationSettings;", "component3", "()Lcom/discord/models/domain/ModelNotificationSettings;", "", "component4", "()Z", "Lcom/discord/api/permission/PermissionBit;", "component5", "()Ljava/util/Map;", "component6", "component7", "component8", "Lcom/discord/utilities/permissions/ManageGuildContext;", "component9", "()Lcom/discord/utilities/permissions/ManageGuildContext;", "component10", "Lcom/discord/primitives/RoleId;", "component11", "guild", "everyoneRole", "notificationSettings", "hideMutedChannels", "channelPermissions", "ableToInstantInvite", "unelevated", "isVerifiedServer", "manageGuildContext", "canChangeNickname", "guildRoles", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/role/GuildRole;Lcom/discord/models/domain/ModelNotificationSettings;ZLjava/util/Map;ZZZLcom/discord/utilities/permissions/ManageGuildContext;ZLjava/util/Map;)Lcom/discord/utilities/channel/GuildChannelsInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/permissions/ManageGuildContext;", "getManageGuildContext", "Z", "getUnelevated", "Lcom/discord/models/domain/ModelNotificationSettings;", "getNotificationSettings", "Ljava/util/Map;", "getGuildRoles", "getAbleToInstantInvite", "getCanChangeNickname", "Lcom/discord/models/guild/Guild;", "getGuild", "getHideMutedChannels", "Lcom/discord/api/role/GuildRole;", "getEveryoneRole", "getChannelPermissions", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/role/GuildRole;Lcom/discord/models/domain/ModelNotificationSettings;ZLjava/util/Map;ZZZLcom/discord/utilities/permissions/ManageGuildContext;ZLjava/util/Map;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildChannelsInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean ableToInstantInvite;
    private final boolean canChangeNickname;
    private final Map<Long, Long> channelPermissions;
    private final GuildRole everyoneRole;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRoles;
    private final boolean hideMutedChannels;
    private final boolean isVerifiedServer;
    private final PermissionsContexts manageGuildContext;
    private final ModelNotificationSettings notificationSettings;
    private final boolean unelevated;

    /* compiled from: GuildChannelsInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelsInfo$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<GuildChannelsInfo> get(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<GuildChannelsInfo> observableR = ObservableWithLeadingEdgeThrottle.combineLatest(companion.getUsers().observeMe(true), companion.getGuilds().observeGuild(guildId), companion.getUserGuildSettings().observeGuildSettings(guildId), companion.getUserGuildSettings().observeHideMutedChannels(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), companion.getChannels().observeChannelCategories(guildId), GuildChannelsInfo2.INSTANCE, 500L, TimeUnit.MILLISECONDS).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildChannelsInfo(Guild guild, GuildRole guildRole, ModelNotificationSettings modelNotificationSettings, boolean z2, Map<Long, Long> map, boolean z3, boolean z4, boolean z5, PermissionsContexts permissionsContexts, boolean z6, Map<Long, GuildRole> map2) {
        Intrinsics3.checkNotNullParameter(modelNotificationSettings, "notificationSettings");
        Intrinsics3.checkNotNullParameter(map, "channelPermissions");
        Intrinsics3.checkNotNullParameter(permissionsContexts, "manageGuildContext");
        this.guild = guild;
        this.everyoneRole = guildRole;
        this.notificationSettings = modelNotificationSettings;
        this.hideMutedChannels = z2;
        this.channelPermissions = map;
        this.ableToInstantInvite = z3;
        this.unelevated = z4;
        this.isVerifiedServer = z5;
        this.manageGuildContext = permissionsContexts;
        this.canChangeNickname = z6;
        this.guildRoles = map2;
    }

    public static /* synthetic */ GuildChannelsInfo copy$default(GuildChannelsInfo guildChannelsInfo, Guild guild, GuildRole guildRole, ModelNotificationSettings modelNotificationSettings, boolean z2, Map map, boolean z3, boolean z4, boolean z5, PermissionsContexts permissionsContexts, boolean z6, Map map2, int i, Object obj) {
        return guildChannelsInfo.copy((i & 1) != 0 ? guildChannelsInfo.guild : guild, (i & 2) != 0 ? guildChannelsInfo.everyoneRole : guildRole, (i & 4) != 0 ? guildChannelsInfo.notificationSettings : modelNotificationSettings, (i & 8) != 0 ? guildChannelsInfo.hideMutedChannels : z2, (i & 16) != 0 ? guildChannelsInfo.channelPermissions : map, (i & 32) != 0 ? guildChannelsInfo.ableToInstantInvite : z3, (i & 64) != 0 ? guildChannelsInfo.unelevated : z4, (i & 128) != 0 ? guildChannelsInfo.isVerifiedServer : z5, (i & 256) != 0 ? guildChannelsInfo.manageGuildContext : permissionsContexts, (i & 512) != 0 ? guildChannelsInfo.canChangeNickname : z6, (i & 1024) != 0 ? guildChannelsInfo.guildRoles : map2);
    }

    /* renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final Map<Long, GuildRole> component11() {
        return this.guildRoles;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildRole getEveryoneRole() {
        return this.everyoneRole;
    }

    /* renamed from: component3, reason: from getter */
    public final ModelNotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHideMutedChannels() {
        return this.hideMutedChannels;
    }

    public final Map<Long, Long> component5() {
        return this.channelPermissions;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getAbleToInstantInvite() {
        return this.ableToInstantInvite;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getUnelevated() {
        return this.unelevated;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsVerifiedServer() {
        return this.isVerifiedServer;
    }

    /* renamed from: component9, reason: from getter */
    public final PermissionsContexts getManageGuildContext() {
        return this.manageGuildContext;
    }

    public final GuildChannelsInfo copy(Guild guild, GuildRole everyoneRole, ModelNotificationSettings notificationSettings, boolean hideMutedChannels, Map<Long, Long> channelPermissions, boolean ableToInstantInvite, boolean unelevated, boolean isVerifiedServer, PermissionsContexts manageGuildContext, boolean canChangeNickname, Map<Long, GuildRole> guildRoles) {
        Intrinsics3.checkNotNullParameter(notificationSettings, "notificationSettings");
        Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
        Intrinsics3.checkNotNullParameter(manageGuildContext, "manageGuildContext");
        return new GuildChannelsInfo(guild, everyoneRole, notificationSettings, hideMutedChannels, channelPermissions, ableToInstantInvite, unelevated, isVerifiedServer, manageGuildContext, canChangeNickname, guildRoles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildChannelsInfo)) {
            return false;
        }
        GuildChannelsInfo guildChannelsInfo = (GuildChannelsInfo) other;
        return Intrinsics3.areEqual(this.guild, guildChannelsInfo.guild) && Intrinsics3.areEqual(this.everyoneRole, guildChannelsInfo.everyoneRole) && Intrinsics3.areEqual(this.notificationSettings, guildChannelsInfo.notificationSettings) && this.hideMutedChannels == guildChannelsInfo.hideMutedChannels && Intrinsics3.areEqual(this.channelPermissions, guildChannelsInfo.channelPermissions) && this.ableToInstantInvite == guildChannelsInfo.ableToInstantInvite && this.unelevated == guildChannelsInfo.unelevated && this.isVerifiedServer == guildChannelsInfo.isVerifiedServer && Intrinsics3.areEqual(this.manageGuildContext, guildChannelsInfo.manageGuildContext) && this.canChangeNickname == guildChannelsInfo.canChangeNickname && Intrinsics3.areEqual(this.guildRoles, guildChannelsInfo.guildRoles);
    }

    public final boolean getAbleToInstantInvite() {
        return this.ableToInstantInvite;
    }

    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final Map<Long, Long> getChannelPermissions() {
        return this.channelPermissions;
    }

    public final GuildRole getEveryoneRole() {
        return this.everyoneRole;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final boolean getHideMutedChannels() {
        return this.hideMutedChannels;
    }

    public final PermissionsContexts getManageGuildContext() {
        return this.manageGuildContext;
    }

    public final ModelNotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    public final Map<Long, Collection<Channel>> getSortedCategories(Map<Long, Channel> guildChannels) {
        Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
        TreeMap treeMap = new TreeMap(new GuildChannelsInfo3(guildChannels));
        for (Channel channel : _Collections.filterNotNull(guildChannels.values())) {
            Long lValueOf = Long.valueOf(ChannelUtils.k(channel) ? channel.getId() : channel.getParentId());
            Object treeSet = treeMap.get(lValueOf);
            if (treeSet == null) {
                treeSet = new TreeSet(ChannelUtils.h(Channel.INSTANCE));
                treeMap.put(lValueOf, treeSet);
            }
            ((Set) treeSet).add(channel);
        }
        return treeMap;
    }

    public final List<Channel> getSortedVisibleChannels(Map<Long, Channel> guildChannels) {
        Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
        Map<Long, Collection<Channel>> sortedCategories = getSortedCategories(guildChannels);
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, Collection<Channel>>> it = sortedCategories.entrySet().iterator();
        while (it.hasNext()) {
            Collection<Channel> value = it.next().getValue();
            List arrayList2 = new ArrayList();
            for (Object obj : value) {
                Channel channel = (Channel) obj;
                if (PermissionUtils.INSTANCE.hasAccess(channel, (Long) outline.d(channel, this.channelPermissions))) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() == 1) {
                arrayList2 = Collections2.emptyList();
            }
            MutableCollections.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    public final boolean getUnelevated() {
        return this.unelevated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        GuildRole guildRole = this.everyoneRole;
        int iHashCode2 = (iHashCode + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        ModelNotificationSettings modelNotificationSettings = this.notificationSettings;
        int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
        boolean z2 = this.hideMutedChannels;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        Map<Long, Long> map = this.channelPermissions;
        int iHashCode4 = (i2 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z3 = this.ableToInstantInvite;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (iHashCode4 + i3) * 31;
        boolean z4 = this.unelevated;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z5 = this.isVerifiedServer;
        int i7 = z5;
        if (z5 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        PermissionsContexts permissionsContexts = this.manageGuildContext;
        int iHashCode5 = (i8 + (permissionsContexts != null ? permissionsContexts.hashCode() : 0)) * 31;
        boolean z6 = this.canChangeNickname;
        int i9 = (iHashCode5 + (z6 ? 1 : z6 ? 1 : 0)) * 31;
        Map<Long, GuildRole> map2 = this.guildRoles;
        return i9 + (map2 != null ? map2.hashCode() : 0);
    }

    public final boolean isVerifiedServer() {
        return this.isVerifiedServer;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildChannelsInfo(guild=");
        sbU.append(this.guild);
        sbU.append(", everyoneRole=");
        sbU.append(this.everyoneRole);
        sbU.append(", notificationSettings=");
        sbU.append(this.notificationSettings);
        sbU.append(", hideMutedChannels=");
        sbU.append(this.hideMutedChannels);
        sbU.append(", channelPermissions=");
        sbU.append(this.channelPermissions);
        sbU.append(", ableToInstantInvite=");
        sbU.append(this.ableToInstantInvite);
        sbU.append(", unelevated=");
        sbU.append(this.unelevated);
        sbU.append(", isVerifiedServer=");
        sbU.append(this.isVerifiedServer);
        sbU.append(", manageGuildContext=");
        sbU.append(this.manageGuildContext);
        sbU.append(", canChangeNickname=");
        sbU.append(this.canChangeNickname);
        sbU.append(", guildRoles=");
        return outline.M(sbU, this.guildRoles, ")");
    }
}
