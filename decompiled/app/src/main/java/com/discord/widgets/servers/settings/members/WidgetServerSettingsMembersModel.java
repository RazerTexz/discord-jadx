package com.discord.widgets.servers.settings.members;

import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetServerSettingsMembersModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 82\u00020\u0001:\u000289BS\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0013¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015Jj\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R%\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b*\u0010\tR\u0019\u0010\u001b\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010\u0012R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b.\u0010\rR\u0019\u0010\u001c\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u0010\u0015R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\b2\u0010\u000fR\u0019\u0010\u001d\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b3\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00104\u001a\u0004\b5\u0010\u0004¨\u0006:"}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "", "Lcom/discord/api/role/GuildRole;", "component2", "()Ljava/util/Map;", "", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;", "component3", "()Ljava/util/List;", "component4", "()Lcom/discord/api/role/GuildRole;", "Lcom/discord/models/user/MeUser;", "component5", "()Lcom/discord/models/user/MeUser;", "", "component6", "()Z", "component7", "guild", "roles", "memberItems", "myHighestRole", "meUser", "canKick", "canManageMembers", "copy", "(Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/List;Lcom/discord/api/role/GuildRole;Lcom/discord/models/user/MeUser;ZZ)Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getRoles", "Lcom/discord/models/user/MeUser;", "getMeUser", "Ljava/util/List;", "getMemberItems", "Z", "getCanKick", "Lcom/discord/api/role/GuildRole;", "getMyHighestRole", "getCanManageMembers", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/List;Lcom/discord/api/role/GuildRole;Lcom/discord/models/user/MeUser;ZZ)V", "Companion", "MemberItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsMembersModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MEMBER_LIST_ITEM_TYPE = 1;
    private final boolean canKick;
    private final boolean canManageMembers;
    private final Guild guild;
    private final MeUser meUser;
    private final List<MemberItem> memberItems;
    private final GuildRole myHighestRole;
    private final Map<Long, GuildRole> roles;

    /* compiled from: WidgetServerSettingsMembersModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0007\u0012\u0004\u0012\u00020\u00050\u00022\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00102\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$Companion;", "", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "Lcom/discord/primitives/RoleId;", "sortRoles", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/util/Comparator;", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;", "kotlin.jvm.PlatformType", "sortMembersComparator", "()Ljava/util/Comparator;", "guildId", "Lrx/Observable;", "", "filterPublisher", "roleFilterPublisher", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;", "get", "(JLrx/Observable;Lrx/Observable;)Lrx/Observable;", "", "MEMBER_LIST_ITEM_TYPE", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Comparator access$sortMembersComparator(Companion companion) {
            return companion.sortMembersComparator();
        }

        public static final /* synthetic */ Map access$sortRoles(Companion companion, Map map) {
            return companion.sortRoles(map);
        }

        private final Comparator<MemberItem> sortMembersComparator() {
            return WidgetServerSettingsMembersModel3.INSTANCE;
        }

        private final Map<Long, GuildRole> sortRoles(Map<Long, GuildRole> guildRoles) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(guildRoles.size());
            ArrayList arrayList = new ArrayList(guildRoles.values());
            Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
            for (Object obj : arrayList) {
                linkedHashMap.put(Long.valueOf(((GuildRole) obj).getId()), obj);
            }
            return linkedHashMap;
        }

        public final Observable<WidgetServerSettingsMembersModel> get(long guildId, Observable<String> filterPublisher, Observable<Long> roleFilterPublisher) {
            Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
            Intrinsics3.checkNotNullParameter(roleFilterPublisher, "roleFilterPublisher");
            Observable<R> observableY = StoreStream.INSTANCE.getGuilds().observeComputed(guildId).Y(new WidgetServerSettingsMembersModel2(guildId, filterPublisher, roleFilterPublisher));
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
            Observable<WidgetServerSettingsMembersModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsMembersModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JH\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u0007R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u0011R\u001c\u0010'\u001a\u00020\u001a8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u001cR\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b\u0015\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010-\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010!\u001a\u0004\b.\u0010\u0007¨\u00061"}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "", "component2", "()Ljava/lang/String;", "", "Lcom/discord/api/role/GuildRole;", "component3", "()Ljava/util/List;", "", "component4", "()Z", "Lcom/discord/models/member/GuildMember;", "component5", "()Lcom/discord/models/member/GuildMember;", "user", "userDisplayName", "roles", "isManagable", "guildMember", "copy", "(Lcom/discord/models/user/User;Ljava/lang/String;Ljava/util/List;ZLcom/discord/models/member/GuildMember;)Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUserDisplayName", "Ljava/util/List;", "getRoles", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "type", "I", "getType", "Z", "Lcom/discord/models/user/User;", "getUser", "key", "getKey", "<init>", "(Lcom/discord/models/user/User;Ljava/lang/String;Ljava/util/List;ZLcom/discord/models/member/GuildMember;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MemberItem implements MGRecyclerDataPayload {
        private final GuildMember guildMember;
        private final boolean isManagable;
        private final String key;
        private final List<GuildRole> roles;
        private final int type;
        private final User user;
        private final String userDisplayName;

        public MemberItem(User user, String str, List<GuildRole> list, boolean z2, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(str, "userDisplayName");
            Intrinsics3.checkNotNullParameter(list, "roles");
            Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
            this.user = user;
            this.userDisplayName = str;
            this.roles = list;
            this.isManagable = z2;
            this.guildMember = guildMember;
            this.key = String.valueOf(user.getId());
            this.type = 1;
        }

        public static /* synthetic */ MemberItem copy$default(MemberItem memberItem, User user, String str, List list, boolean z2, GuildMember guildMember, int i, Object obj) {
            if ((i & 1) != 0) {
                user = memberItem.user;
            }
            if ((i & 2) != 0) {
                str = memberItem.userDisplayName;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                list = memberItem.roles;
            }
            List list2 = list;
            if ((i & 8) != 0) {
                z2 = memberItem.isManagable;
            }
            boolean z3 = z2;
            if ((i & 16) != 0) {
                guildMember = memberItem.guildMember;
            }
            return memberItem.copy(user, str2, list2, z3, guildMember);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUserDisplayName() {
            return this.userDisplayName;
        }

        public final List<GuildRole> component3() {
            return this.roles;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsManagable() {
            return this.isManagable;
        }

        /* renamed from: component5, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final MemberItem copy(User user, String userDisplayName, List<GuildRole> roles, boolean isManagable, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userDisplayName, "userDisplayName");
            Intrinsics3.checkNotNullParameter(roles, "roles");
            Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
            return new MemberItem(user, userDisplayName, roles, isManagable, guildMember);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberItem)) {
                return false;
            }
            MemberItem memberItem = (MemberItem) other;
            return Intrinsics3.areEqual(this.user, memberItem.user) && Intrinsics3.areEqual(this.userDisplayName, memberItem.userDisplayName) && Intrinsics3.areEqual(this.roles, memberItem.roles) && this.isManagable == memberItem.isManagable && Intrinsics3.areEqual(this.guildMember, memberItem.guildMember);
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final List<GuildRole> getRoles() {
            return this.roles;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        public final String getUserDisplayName() {
            return this.userDisplayName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            String str = this.userDisplayName;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<GuildRole> list = this.roles;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isManagable;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            GuildMember guildMember = this.guildMember;
            return i2 + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public final boolean isManagable() {
            return this.isManagable;
        }

        public String toString() {
            StringBuilder sbU = outline.U("MemberItem(user=");
            sbU.append(this.user);
            sbU.append(", userDisplayName=");
            sbU.append(this.userDisplayName);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", isManagable=");
            sbU.append(this.isManagable);
            sbU.append(", guildMember=");
            sbU.append(this.guildMember);
            sbU.append(")");
            return sbU.toString();
        }
    }

    public WidgetServerSettingsMembersModel(Guild guild, Map<Long, GuildRole> map, List<MemberItem> list, GuildRole guildRole, MeUser meUser, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(map, "roles");
        Intrinsics3.checkNotNullParameter(list, "memberItems");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        this.guild = guild;
        this.roles = map;
        this.memberItems = list;
        this.myHighestRole = guildRole;
        this.meUser = meUser;
        this.canKick = z2;
        this.canManageMembers = z3;
    }

    public static /* synthetic */ WidgetServerSettingsMembersModel copy$default(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel, Guild guild, Map map, List list, GuildRole guildRole, MeUser meUser, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsMembersModel.guild;
        }
        if ((i & 2) != 0) {
            map = widgetServerSettingsMembersModel.roles;
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            list = widgetServerSettingsMembersModel.memberItems;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            guildRole = widgetServerSettingsMembersModel.myHighestRole;
        }
        GuildRole guildRole2 = guildRole;
        if ((i & 16) != 0) {
            meUser = widgetServerSettingsMembersModel.meUser;
        }
        MeUser meUser2 = meUser;
        if ((i & 32) != 0) {
            z2 = widgetServerSettingsMembersModel.canKick;
        }
        boolean z4 = z2;
        if ((i & 64) != 0) {
            z3 = widgetServerSettingsMembersModel.canManageMembers;
        }
        return widgetServerSettingsMembersModel.copy(guild, map2, list2, guildRole2, meUser2, z4, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> component2() {
        return this.roles;
    }

    public final List<MemberItem> component3() {
        return this.memberItems;
    }

    /* renamed from: component4, reason: from getter */
    public final GuildRole getMyHighestRole() {
        return this.myHighestRole;
    }

    /* renamed from: component5, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCanKick() {
        return this.canKick;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanManageMembers() {
        return this.canManageMembers;
    }

    public final WidgetServerSettingsMembersModel copy(Guild guild, Map<Long, GuildRole> roles, List<MemberItem> memberItems, GuildRole myHighestRole, MeUser meUser, boolean canKick, boolean canManageMembers) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Intrinsics3.checkNotNullParameter(memberItems, "memberItems");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        return new WidgetServerSettingsMembersModel(guild, roles, memberItems, myHighestRole, meUser, canKick, canManageMembers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsMembersModel)) {
            return false;
        }
        WidgetServerSettingsMembersModel widgetServerSettingsMembersModel = (WidgetServerSettingsMembersModel) other;
        return Intrinsics3.areEqual(this.guild, widgetServerSettingsMembersModel.guild) && Intrinsics3.areEqual(this.roles, widgetServerSettingsMembersModel.roles) && Intrinsics3.areEqual(this.memberItems, widgetServerSettingsMembersModel.memberItems) && Intrinsics3.areEqual(this.myHighestRole, widgetServerSettingsMembersModel.myHighestRole) && Intrinsics3.areEqual(this.meUser, widgetServerSettingsMembersModel.meUser) && this.canKick == widgetServerSettingsMembersModel.canKick && this.canManageMembers == widgetServerSettingsMembersModel.canManageMembers;
    }

    public final boolean getCanKick() {
        return this.canKick;
    }

    public final boolean getCanManageMembers() {
        return this.canManageMembers;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final List<MemberItem> getMemberItems() {
        return this.memberItems;
    }

    public final GuildRole getMyHighestRole() {
        return this.myHighestRole;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        List<MemberItem> list = this.memberItems;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        GuildRole guildRole = this.myHighestRole;
        int iHashCode4 = (iHashCode3 + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        MeUser meUser = this.meUser;
        int iHashCode5 = (iHashCode4 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        boolean z2 = this.canKick;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode5 + i) * 31;
        boolean z3 = this.canManageMembers;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetServerSettingsMembersModel(guild=");
        sbU.append(this.guild);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", memberItems=");
        sbU.append(this.memberItems);
        sbU.append(", myHighestRole=");
        sbU.append(this.myHighestRole);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(", canKick=");
        sbU.append(this.canKick);
        sbU.append(", canManageMembers=");
        return outline.O(sbU, this.canManageMembers, ")");
    }
}
