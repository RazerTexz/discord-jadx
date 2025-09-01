package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.collections.ShallowPartitionCollection;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.GlobalRoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import com.discord.widgets.chat.input.autocomplete.RoleAutocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func8;

/* compiled from: UserMentionableSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0001<B/\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b:\u0010;J»\u0001\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u00060\u0002j\u0002`\u00032\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\n0\t2\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\f0\t2\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u000e0\t2\u0016\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00100\t2\u000e\u0010\u0013\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018Ja\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\t2\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u000e0\t2\u0016\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00100\t2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\t0\u001e2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010'\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010,\u001a\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u00101\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0019\u00106\u001a\u0002058\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/sources/UserAutocompletableSource;", "", "", "Lcom/discord/primitives/UserId;", "myId", "Lcom/discord/api/channel/Channel;", "channel", "parentChannel", "guildOwnerId", "", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/models/member/GuildMember;", "members", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/presence/Presence;", "presences", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "createAutocompletablesForUsers", "(JLcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;)Ljava/util/Map;", "", "Lcom/discord/api/channel/ChannelRecipientNick;", "nicks", "createAutocompletablesForDmUsers", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/List;)Ljava/util/Map;", "Lrx/Observable;", "observeUserAutocompletables", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "getStoreChannels", "()Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "getStorePermissions", "()Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/StoreUserPresence;", "storePresences", "Lcom/discord/stores/StoreUserPresence;", "getStorePresences", "()Lcom/discord/stores/StoreUserPresence;", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lcom/discord/stores/StoreUser;", "getStoreUsers", "()Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "getStoreGuilds", "()Lcom/discord/stores/StoreGuilds;", "<init>", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUserPresence;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreChannels;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource, reason: use source file name */
/* loaded from: classes2.dex */
public final class UserMentionableSource {
    private static final int PARTITION_HUGE_GUILD_SIZE = 3000;
    private static final int PARTITION_IDEAL_PARTITION_SIZE = 100;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUserPresence storePresences;
    private final StoreUser storeUsers;

    /* compiled from: UserMentionableSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/guild/Guild;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource$observeUserAutocompletables$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Guild, Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Long call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(Guild guild) {
            return Long.valueOf(guild.getOwnerId());
        }
    }

    /* compiled from: UserMentionableSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001a\u001a.\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016 \u0002*\u0016\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u00050\u00052\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00000\u00002.\u0010\b\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007 \u0002*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u000526\u0010\u000b\u001a2\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\tj\u0002`\n \u0002*\u0018\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\tj\u0002`\n\u0018\u00010\u00050\u00052.\u0010\r\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\f \u0002*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u00050\u000526\u0010\u0010\u001a2\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\u000ej\u0002`\u000f \u0002*\u0018\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0018\u00010\u00050\u00052\u000e\u0010\u0012\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\n¢\u0006\u0004\b\u0018\u0010\u0019"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "myId", "guildOwnerId", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presences", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/api/channel/Channel;", "parentChannel", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Lcom/discord/api/channel/Channel;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource$observeUserAutocompletables$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Long, Long, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Long, Channel, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func8
        public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Long l, Long l2, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, ? extends Presence> map4, Long l3, Channel channel) {
            return call2(l, l2, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, map3, (Map<Long, Presence>) map4, l3, channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Long l, Long l2, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Long l3, Channel channel) {
            UserMentionableSource userMentionableSource = UserMentionableSource.this;
            Intrinsics3.checkNotNullExpressionValue(l, "myId");
            long jLongValue = l.longValue();
            Channel channel2 = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(l2, "guildOwnerId");
            long jLongValue2 = l2.longValue();
            Intrinsics3.checkNotNullExpressionValue(map, "roles");
            Intrinsics3.checkNotNullExpressionValue(map2, "members");
            Intrinsics3.checkNotNullExpressionValue(map3, "users");
            Intrinsics3.checkNotNullExpressionValue(map4, "presences");
            return UserMentionableSource.access$createAutocompletablesForUsers(userMentionableSource, jLongValue, channel2, channel, jLongValue2, map, map2, map3, map4, l3);
        }
    }

    /* compiled from: UserMentionableSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0014 \u0001*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "it", "", "Lcom/discord/primitives/UserId;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/User;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource$observeUserAutocompletables$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<User, Long> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Long call(User user) {
            return call2(user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(User user) {
            return Long.valueOf(user.getId());
        }
    }

    /* compiled from: UserMentionableSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0010\t\u001a:\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002 \u0003*\u001c\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0018\u00010\u00040\u00002>\u0010\u0005\u001a:\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002 \u0003*\u001c\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0018\u00010\u00040\u00002\u0018\u0010\u0006\u001a\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "", "recipients", "meId", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/lang/Long;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource$observeUserAutocompletables$4, reason: invalid class name */
    public static final class AnonymousClass4<T1, T2, R> implements Func2<List<Long>, Long, List<Long>> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<Long> call(List<Long> list, Long l) {
            return call2(list, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Long> call2(List<Long> list, Long l) {
            list.add(l);
            return list;
        }
    }

    /* compiled from: UserMentionableSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001ar\u00122\b\u0001\u0012.\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t \u0003*\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00070\u0007 \u0003*8\u00122\b\u0001\u0012.\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t \u0003*\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00062>\u0010\u0005\u001a:\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002 \u0003*\u001c\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0018\u00010\u00040\u0000H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "", "recipientIds", "Lrx/Observable;", "", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource$observeUserAutocompletables$5, reason: invalid class name */
    public static final class AnonymousClass5<T, R> implements Func1<List<Long>, Observable<? extends Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: UserMentionableSource.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a.\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n \u0004*\u0016\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\u00000\u00002.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u000026\u0010\b\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "users", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presences", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource$observeUserAutocompletables$5$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, R> implements Func2<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
            public AnonymousClass1() {
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2) {
                return call2(map, (Map<Long, Presence>) map2);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Map<Long, ? extends User> map, Map<Long, Presence> map2) {
                UserMentionableSource userMentionableSource = UserMentionableSource.this;
                Intrinsics3.checkNotNullExpressionValue(map, "users");
                Intrinsics3.checkNotNullExpressionValue(map2, "presences");
                return UserMentionableSource.access$createAutocompletablesForDmUsers(userMentionableSource, map, map2, AnonymousClass5.this.$channel.q());
            }
        }

        public AnonymousClass5(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> call(List<Long> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<LeadingIdentifier, TreeSet<Autocompletable>>> call2(List<Long> list) {
            StoreUser storeUsers = UserMentionableSource.this.getStoreUsers();
            Intrinsics3.checkNotNullExpressionValue(list, "recipientIds");
            return Observable.j(storeUsers.observeUsers(list), UserMentionableSource.this.getStorePresences().observePresencesForUsers(list), new AnonymousClass1()).r();
        }
    }

    public UserMentionableSource(StoreUser storeUser, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreChannels storeChannels) {
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storePresences");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storePresences = storeUserPresence;
        this.storePermissions = storePermissions;
        this.storeChannels = storeChannels;
    }

    public static final /* synthetic */ Map access$createAutocompletablesForDmUsers(UserMentionableSource userMentionableSource, Map map, Map map2, List list) {
        return userMentionableSource.createAutocompletablesForDmUsers(map, map2, list);
    }

    public static final /* synthetic */ Map access$createAutocompletablesForUsers(UserMentionableSource userMentionableSource, long j, Channel channel, Channel channel2, long j2, Map map, Map map2, Map map3, Map map4, Long l) {
        return userMentionableSource.createAutocompletablesForUsers(j, channel, channel2, j2, map, map2, map3, map4, l);
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createAutocompletablesForDmUsers(Map<Long, ? extends User> users, Map<Long, Presence> presences, List<ChannelRecipientNick> nicks) {
        ChannelRecipientNick channelRecipientNick;
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        for (User user : users.values()) {
            String nick = null;
            if (nicks != null) {
                int size = nicks.size();
                channelRecipientNick = null;
                for (int i = 0; i < size; i++) {
                    if (nicks.get(i).getId() == user.getId()) {
                        channelRecipientNick = nicks.get(i);
                    }
                }
            } else {
                channelRecipientNick = null;
            }
            if (channelRecipientNick != null) {
                nick = channelRecipientNick.getNick();
            }
            treeSet.add(new UserAutocompletable(user, null, nick, (Presence) outline.f(user, presences), false, 16, null));
        }
        return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.MENTION, treeSet));
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createAutocompletablesForUsers(long myId, Channel channel, Channel parentChannel, long guildOwnerId, Map<Long, GuildRole> roles, Map<Long, GuildMember> members, Map<Long, ? extends User> users, Map<Long, Presence> presences, Long permissions) {
        Collection arrayList;
        boolean zCan;
        boolean zCan2;
        if (members.size() > 3000) {
            int size = members.size() / 100;
            arrayList = ShallowPartitionCollection.INSTANCE.withArrayListPartions(size, new UserMentionableSource2(size));
        } else {
            arrayList = new ArrayList(members.size());
        }
        boolean zCanEveryone = PermissionUtils.canEveryone(Permission.VIEW_CHANNEL, channel, parentChannel, roles);
        for (Map.Entry<Long, GuildMember> entry : members.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            GuildMember value = entry.getValue();
            if (zCanEveryone || (zCan2 = PermissionUtils.can(Permission.VIEW_CHANNEL, Long.valueOf(PermissionUtils.computePermissions(jLongValue, channel, parentChannel, guildOwnerId, value, roles, null, true))))) {
                User user = users.get(Long.valueOf(jLongValue));
                if (user != null) {
                    arrayList.add(new UserAutocompletable(user, value, value.getNick(), presences.get(Long.valueOf(jLongValue)), false, 16, null));
                }
            } else {
                User user2 = users.get(Long.valueOf(jLongValue));
                if (user2 != null) {
                    arrayList.add(new UserAutocompletable(user2, value, value.getNick(), presences.get(Long.valueOf(jLongValue)), zCan2));
                }
            }
        }
        if (members.get(Long.valueOf(myId)) != null) {
            zCan = PermissionUtils.can(Permission.MENTION_EVERYONE, permissions);
            if (zCan) {
                GlobalRoleAutocompletable.Companion companion = GlobalRoleAutocompletable.INSTANCE;
                arrayList.add(companion.getHere());
                arrayList.add(companion.getEveryone());
            }
        } else {
            zCan = false;
        }
        for (GuildRole guildRole : roles.values()) {
            if (guildRole.getId() != channel.getGuildId()) {
                arrayList.add(new RoleAutocompletable(guildRole, guildRole.getMentionable() || zCan));
            }
        }
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        treeSet.addAll(arrayList);
        return MapsJVM.mapOf(Tuples.to(LeadingIdentifier.MENTION, treeSet));
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StorePermissions getStorePermissions() {
        return this.storePermissions;
    }

    public final StoreUserPresence getStorePresences() {
        return this.storePresences;
    }

    public final StoreUser getStoreUsers() {
        return this.storeUsers;
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeUserAutocompletables(Channel channel) {
        Observable observableY;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        long guildId = channel.getGuildId();
        if (UserMentionableSource3.access$isTextOrVoiceChannel(channel)) {
            Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(this.storeUsers.observeMeId());
            Observable<R> observableG = this.storeGuilds.observeGuild(guildId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable observableR = observableG.G(AnonymousClass1.INSTANCE).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "storeGuilds.observeGuild… }.distinctUntilChanged()");
            Observable observableComputationLatest2 = ObservableExtensionsKt.computationLatest(observableR);
            Observable observableComputationLatest3 = ObservableExtensionsKt.computationLatest(this.storeGuilds.observeRoles(guildId));
            Observable<Map<Long, GuildMember>> observableObserveComputed = this.storeGuilds.observeComputed(guildId);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Observable observableComputationLatest4 = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(observableObserveComputed, 5L, timeUnit));
            Observable observableComputationLatest5 = ObservableExtensionsKt.computationLatest(this.storeUsers.observeAllUsers());
            Observable observableComputationLatest6 = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(this.storePresences.observeAllPresences(), 10L, timeUnit));
            Observable<Long> observableR2 = this.storePermissions.observePermissionsForChannel(channel.getId()).r();
            Intrinsics3.checkNotNullExpressionValue(observableR2, "storePermissions.observe…d).distinctUntilChanged()");
            Observable observableComputationLatest7 = ObservableExtensionsKt.computationLatest(observableR2);
            Observable<Channel> observableR3 = this.storeChannels.observeChannel(channel.getParentId()).r();
            Intrinsics3.checkNotNullExpressionValue(observableR3, "storeChannels.observeCha…d).distinctUntilChanged()");
            observableY = Observable.d(observableComputationLatest, observableComputationLatest2, observableComputationLatest3, observableComputationLatest4, observableComputationLatest5, observableComputationLatest6, observableComputationLatest7, ObservableExtensionsKt.computationLatest(observableR3), new AnonymousClass2(channel));
        } else {
            observableY = UserMentionableSource3.access$isDmOrGroupDm(channel) ? Observable.j(Observable.B(ChannelUtils.g(channel)).G(AnonymousClass3.INSTANCE).f0(), this.storeUsers.observeMeId(), AnonymousClass4.INSTANCE).Y(new AnonymousClass5(channel)) : new ScalarSynchronousObservable(Maps6.emptyMap());
        }
        Intrinsics3.checkNotNullExpressionValue(observableY, "when {\n      // Guild Ch…vable.just(mapOf())\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableR4 = ObservableExtensionsKt.computationLatest(observableY).r();
        Intrinsics3.checkNotNullExpressionValue(observableR4, "when {\n      // Guild Ch…  .distinctUntilChanged()");
        return observableR4;
    }
}
