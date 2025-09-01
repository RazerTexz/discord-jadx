package com.discord.utilities.search.validation;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SearchData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001,B\u0089\u0001\u0012\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u0002\u0012\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u0002\u0012\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0011\u0012\b\u0012\u00060\u0005j\u0002`\u00140\u0002¢\u0006\u0004\b*\u0010+J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÂ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J \u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J \u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J$\u0010\u0015\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0011\u0012\b\u0012\u00060\u0005j\u0002`\u00140\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0092\u0001\u0010\u001b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00022\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00022\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u00022\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0011\u0012\b\u0012\u00060\u0005j\u0002`\u00140\u0002HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R&\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010%R-\u0010\u001a\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0011\u0012\b\u0012\u00060\u0005j\u0002`\u00140\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b&\u0010\u0007R)\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b'\u0010\u0007R)\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b(\u0010\u0007R%\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b)\u0010\u0007¨\u0006-"}, d2 = {"Lcom/discord/utilities/search/validation/SearchData;", "", "", "", "Lcom/discord/utilities/search/validation/UsernameWithDiscrim;", "", "component1", "()Ljava/util/Map;", "username", "", "discriminator", "getUserId", "(Ljava/lang/String;I)Ljava/lang/Long;", "component2", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/guild/UserGuildMember;", "component3", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component4", "Lcom/discord/api/permission/PermissionBit;", "component5", "usernameAndDiscriminatorIndex", "channelNameIndex", "users", "channels", "channelPermissions", "copy", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/utilities/search/validation/SearchData;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getChannelPermissions", "getChannels", "getUsers", "getChannelNameIndex", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "Builder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class SearchData {
    private final Map<String, Long> channelNameIndex;
    private final Map<Long, Long> channelPermissions;
    private final Map<Long, Channel> channels;
    private final Map<String, Long> usernameAndDiscriminatorIndex;
    private final Map<Long, UserGuildMember> users;

    /* compiled from: SearchData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006Ja\u0010\u0011\u001a\u00020\u00102\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u00072\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\bj\u0002`\u000e0\u0007¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0017\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0016\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/utilities/search/validation/SearchData$Builder;", "", "Lcom/discord/models/user/User;", "", "Lcom/discord/utilities/search/validation/UsernameWithDiscrim;", "getUsernameWithDiscrim", "(Lcom/discord/models/user/User;)Ljava/lang/String;", "", "", "Lcom/discord/models/member/GuildMember;", "guildMembers", "allUsers", "Lcom/discord/api/channel/Channel;", "guildSearchableChannels", "Lcom/discord/api/permission/PermissionBit;", "guildChannelPermissions", "Lcom/discord/utilities/search/validation/SearchData;", "buildForGuild", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/utilities/search/validation/SearchData;", "channel", "Lcom/discord/models/user/MeUser;", "meUser", "Lcom/discord/primitives/UserId;", "buildForChannel", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/user/MeUser;Ljava/util/Map;)Lcom/discord/utilities/search/validation/SearchData;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        public static final /* synthetic */ String access$getUsernameWithDiscrim(Builder builder, User user) {
            return builder.getUsernameWithDiscrim(user);
        }

        private final String getUsernameWithDiscrim(User user) {
            return user.getUsername() + user.getDiscriminator();
        }

        public final SearchData buildForChannel(Channel channel, MeUser meUser, Map<Long, GuildMember> guildMembers) {
            List<com.discord.api.user.User> listZ;
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            SearchData2 searchData2 = new SearchData2(this, map, guildMembers, map2);
            if (channel != null && (listZ = channel.z()) != null) {
                Iterator<T> it = listZ.iterator();
                while (it.hasNext()) {
                    searchData2.invoke2((User) new CoreUser((com.discord.api.user.User) it.next()));
                }
            }
            searchData2.invoke2((User) meUser);
            return new SearchData(map2, null, map, null, null, 26, null);
        }

        public final SearchData buildForGuild(Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> allUsers, Map<Long, Channel> guildSearchableChannels, Map<Long, Long> guildChannelPermissions) {
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(allUsers, "allUsers");
            Intrinsics3.checkNotNullParameter(guildSearchableChannels, "guildSearchableChannels");
            Intrinsics3.checkNotNullParameter(guildChannelPermissions, "guildChannelPermissions");
            HashMap map = new HashMap();
            for (Channel channel : guildSearchableChannels.values()) {
                map.put(ChannelUtils.c(channel), Long.valueOf(channel.getId()));
            }
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            Iterator<Long> it = allUsers.keySet().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                GuildMember guildMember = guildMembers.get(Long.valueOf(jLongValue));
                User user = allUsers.get(Long.valueOf(jLongValue));
                if (guildMember != null && user != null) {
                    map2.put(Long.valueOf(jLongValue), new UserGuildMember(user, guildMember));
                    map3.put(getUsernameWithDiscrim(user), Long.valueOf(jLongValue));
                }
            }
            return new SearchData(map3, map, map2, guildSearchableChannels, guildChannelPermissions);
        }
    }

    public SearchData() {
        this(null, null, null, null, null, 31, null);
    }

    public SearchData(Map<String, Long> map, Map<String, Long> map2, Map<Long, UserGuildMember> map3, Map<Long, Channel> map4, Map<Long, Long> map5) {
        Intrinsics3.checkNotNullParameter(map, "usernameAndDiscriminatorIndex");
        Intrinsics3.checkNotNullParameter(map2, "channelNameIndex");
        Intrinsics3.checkNotNullParameter(map3, "users");
        Intrinsics3.checkNotNullParameter(map4, "channels");
        Intrinsics3.checkNotNullParameter(map5, "channelPermissions");
        this.usernameAndDiscriminatorIndex = map;
        this.channelNameIndex = map2;
        this.users = map3;
        this.channels = map4;
        this.channelPermissions = map5;
    }

    private final Map<String, Long> component1() {
        return this.usernameAndDiscriminatorIndex;
    }

    public static /* synthetic */ SearchData copy$default(SearchData searchData, Map map, Map map2, Map map3, Map map4, Map map5, int i, Object obj) {
        if ((i & 1) != 0) {
            map = searchData.usernameAndDiscriminatorIndex;
        }
        if ((i & 2) != 0) {
            map2 = searchData.channelNameIndex;
        }
        Map map6 = map2;
        if ((i & 4) != 0) {
            map3 = searchData.users;
        }
        Map map7 = map3;
        if ((i & 8) != 0) {
            map4 = searchData.channels;
        }
        Map map8 = map4;
        if ((i & 16) != 0) {
            map5 = searchData.channelPermissions;
        }
        return searchData.copy(map, map6, map7, map8, map5);
    }

    public final Map<String, Long> component2() {
        return this.channelNameIndex;
    }

    public final Map<Long, UserGuildMember> component3() {
        return this.users;
    }

    public final Map<Long, Channel> component4() {
        return this.channels;
    }

    public final Map<Long, Long> component5() {
        return this.channelPermissions;
    }

    public final SearchData copy(Map<String, Long> usernameAndDiscriminatorIndex, Map<String, Long> channelNameIndex, Map<Long, UserGuildMember> users, Map<Long, Channel> channels, Map<Long, Long> channelPermissions) {
        Intrinsics3.checkNotNullParameter(usernameAndDiscriminatorIndex, "usernameAndDiscriminatorIndex");
        Intrinsics3.checkNotNullParameter(channelNameIndex, "channelNameIndex");
        Intrinsics3.checkNotNullParameter(users, "users");
        Intrinsics3.checkNotNullParameter(channels, "channels");
        Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
        return new SearchData(usernameAndDiscriminatorIndex, channelNameIndex, users, channels, channelPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchData)) {
            return false;
        }
        SearchData searchData = (SearchData) other;
        return Intrinsics3.areEqual(this.usernameAndDiscriminatorIndex, searchData.usernameAndDiscriminatorIndex) && Intrinsics3.areEqual(this.channelNameIndex, searchData.channelNameIndex) && Intrinsics3.areEqual(this.users, searchData.users) && Intrinsics3.areEqual(this.channels, searchData.channels) && Intrinsics3.areEqual(this.channelPermissions, searchData.channelPermissions);
    }

    public final Map<String, Long> getChannelNameIndex() {
        return this.channelNameIndex;
    }

    public final Map<Long, Long> getChannelPermissions() {
        return this.channelPermissions;
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final Long getUserId(String username, int discriminator) {
        Intrinsics3.checkNotNullParameter(username, "username");
        return this.usernameAndDiscriminatorIndex.get(username + discriminator);
    }

    public final Map<Long, UserGuildMember> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Map<String, Long> map = this.usernameAndDiscriminatorIndex;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<String, Long> map2 = this.channelNameIndex;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, UserGuildMember> map3 = this.users;
        int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, Channel> map4 = this.channels;
        int iHashCode4 = (iHashCode3 + (map4 != null ? map4.hashCode() : 0)) * 31;
        Map<Long, Long> map5 = this.channelPermissions;
        return iHashCode4 + (map5 != null ? map5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("SearchData(usernameAndDiscriminatorIndex=");
        sbU.append(this.usernameAndDiscriminatorIndex);
        sbU.append(", channelNameIndex=");
        sbU.append(this.channelNameIndex);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", channelPermissions=");
        return outline.M(sbU, this.channelPermissions, ")");
    }

    public /* synthetic */ SearchData(Map map, Map map2, Map map3, Map map4, Map map5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Maps6.emptyMap() : map, (i & 2) != 0 ? Maps6.emptyMap() : map2, (i & 4) != 0 ? Maps6.emptyMap() : map3, (i & 8) != 0 ? Maps6.emptyMap() : map4, (i & 16) != 0 ? Maps6.emptyMap() : map5);
    }
}
