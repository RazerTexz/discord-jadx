package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.search.network.state.SearchState;
import d0.Tuples;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StorePermissions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010]\u001a\u00020\\¢\u0006\u0004\bq\u0010rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u00020\u00022\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0015\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u00122\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0017\u0010\u0004J!\u0010\u0018\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u0012¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001c\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u00122\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\tj\u0002`\u00140\u0012¢\u0006\u0004\b\u001d\u0010\u0019J'\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0018\u00010\tj\u0004\u0018\u0001`\u00140\u001e2\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\u001f\u0010 J3\u0010!\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u00120\u001e2\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b!\u0010 J'\u0010#\u001a\u0010\u0012\f\u0012\n\u0018\u00010\tj\u0004\u0018\u0001`\u00140\u001e2\n\u0010\"\u001a\u00060\tj\u0002`\u0013¢\u0006\u0004\b#\u0010 J'\u0010$\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u00120\u001e¢\u0006\u0004\b$\u0010%J7\u0010&\u001a,\u0012(\u0012&\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u00120\u00120\u001e¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\u0002H\u0007¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H\u0007¢\u0006\u0004\b(\u0010\u0004J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b-\u0010,J\u001b\u0010.\u001a\u00020\u00022\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b4\u0010\bJ\u0017\u00105\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b5\u0010\bJ\u0017\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0007¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u00022\u0006\u0010;\u001a\u00020:H\u0007¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020>H\u0007¢\u0006\u0004\b@\u0010AJ\u001d\u0010E\u001a\u00020\u00022\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0BH\u0007¢\u0006\u0004\bE\u0010FJ\u0017\u0010I\u001a\u00020\u00022\u0006\u0010H\u001a\u00020GH\u0007¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020KH\u0007¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0002H\u0017¢\u0006\u0004\bO\u0010\u0004R:\u0010Q\u001a&\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u00120P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR@\u0010W\u001a,\u0012(\u0012&\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u00120\u00120V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR*\u0010b\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\tj\u0002`\u00140P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010RR*\u0010c\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\tj\u0002`\u00140\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010RR*\u0010d\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010RR\u0016\u0010f\u001a\u00020e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010n\u001a\u00060\tj\u0002`k8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR:\u0010o\u001a&\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\tj\u0002`\u00140\u00120\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010RR0\u0010p\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\tj\u0002`\u00140\u00120V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010X¨\u0006s"}, d2 = {"Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/StoreV2;", "", "recomputeAllPermissions", "()V", "Lcom/discord/api/channel/Channel;", "channel", "updateChannelPermissions", "(Lcom/discord/api/channel/Channel;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "guildThreads", "updateGuildPermissions", "(JLjava/util/Collection;)V", "", "channels", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "computeChannelPermissions", "(JLjava/lang/Iterable;)Ljava/util/Map;", "restoreFromCache", "getPermissionsByChannel", "()Ljava/util/Map;", "getPermissionsByChannelInternal$app_productionGoogleRelease", "(J)Ljava/util/Map;", "getPermissionsByChannelInternal", "getGuildPermissions", "Lrx/Observable;", "observePermissionsForGuild", "(J)Lrx/Observable;", "observeChannelPermissionsForGuild", "channelId", "observePermissionsForChannel", "observePermissionsForAllChannels", "()Lrx/Observable;", "observeAllPermissions", "init", "handleConnectionOpen", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildAdd", "(Lcom/discord/api/guild/Guild;)V", "handleGuildRemove", "handleGuildRolesChanged", "(J)V", "Lcom/discord/api/guildmember/GuildMember;", "member", "handleGuildMemberAdd", "(Lcom/discord/api/guildmember/GuildMember;)V", "handleChannelOrThreadCreateOrUpdate", "handleChannelOrThreadDelete", "Lcom/discord/models/thread/dto/ModelThreadListSync;", "threadListSync", "handleThreadListSync", "(Lcom/discord/models/thread/dto/ModelThreadListSync;)V", "Lcom/discord/api/thread/ThreadMemberUpdate;", "threadMemberUpdate", "handleThreadMemberUpdate", "(Lcom/discord/api/thread/ThreadMemberUpdate;)V", "Lcom/discord/api/thread/ThreadMembersUpdate;", "threadMembersUpdate", "handleThreadMembersUpdate", "(Lcom/discord/api/thread/ThreadMembersUpdate;)V", "", "Lcom/discord/models/message/Message;", "messages", "handleMessagesLoaded", "(Ljava/util/List;)V", "Lcom/discord/utilities/search/network/state/SearchState;", "searchState", "handleSearchFinish", "(Lcom/discord/utilities/search/network/state/SearchState;)V", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstance", "handleStageInstanceChange", "(Lcom/discord/api/stageinstance/StageInstance;)V", "snapshotData", "", "permissionsForChannels", "Ljava/util/Map;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/utilities/persister/Persister;", "permissionsForChannelsCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/StoreStageInstances;", "storeStageInstances", "Lcom/discord/stores/StoreStageInstances;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "permissionsForGuilds", "permissionsForGuildsSnapshot", "permissionsForChannelsFlattenedSnapshot", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreThreadsJoined;", "storeThreadsJoined", "Lcom/discord/stores/StoreThreadsJoined;", "Lcom/discord/primitives/UserId;", "getMeId", "()J", "meId", "permissionsForChannelsSnapshot", "permissionsForGuildsCache", "<init>", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreThreadsJoined;Lcom/discord/stores/StoreStageInstances;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StorePermissions extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<Long, Long>> permissionsForChannels;
    private final Persister<Map<Long, Map<Long, Long>>> permissionsForChannelsCache;
    private Map<Long, Long> permissionsForChannelsFlattenedSnapshot;
    private Map<Long, ? extends Map<Long, Long>> permissionsForChannelsSnapshot;
    private final Map<Long, Long> permissionsForGuilds;
    private final Persister<Map<Long, Long>> permissionsForGuildsCache;
    private Map<Long, Long> permissionsForGuildsSnapshot;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StoreStageInstances storeStageInstances;
    private final StoreThreadsJoined storeThreadsJoined;
    private final StoreUser storeUser;

    /* compiled from: StorePermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePermissions$observeAllPermissions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends Long>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends Long>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends Long>> invoke2() {
            return StorePermissions.access$getPermissionsForChannels$p(StorePermissions.this);
        }
    }

    /* compiled from: StorePermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0001j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0001j\u0002`\u0004\u0018\u00010\u00000\u00002V\u0010\u0006\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u0000 \u0005*(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0001j\u0002`\u00040\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "kotlin.jvm.PlatformType", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePermissions$observeChannelPermissionsForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends Long>>, Map<Long, ? extends Long>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Long> call(Map<Long, ? extends Map<Long, ? extends Long>> map) {
            return call2((Map<Long, ? extends Map<Long, Long>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Long> call2(Map<Long, ? extends Map<Long, Long>> map) {
            Intrinsics3.checkNotNullExpressionValue(map, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
            Map<Long, Long> mapEmptyMap = map.get(Long.valueOf(this.$guildId));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            return mapEmptyMap;
        }
    }

    /* compiled from: StorePermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0001j\u0002`\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePermissions$observePermissionsForAllChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Long> invoke2() {
            return StorePermissions.access$getPermissionsForChannelsFlattenedSnapshot$p(StorePermissions.this);
        }
    }

    /* compiled from: StorePermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/api/permission/PermissionBit;", "invoke", "()Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePermissions$observePermissionsForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return (Long) StorePermissions.access$getPermissionsForChannelsFlattenedSnapshot$p(StorePermissions.this).get(Long.valueOf(this.$channelId));
        }
    }

    /* compiled from: StorePermissions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/api/permission/PermissionBit;", "invoke", "()Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePermissions$observePermissionsForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return (Long) StorePermissions.access$getPermissionsForGuildsSnapshot$p(StorePermissions.this).get(Long.valueOf(this.$guildId));
        }
    }

    public StorePermissions(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreThreadsJoined storeThreadsJoined, StoreStageInstances storeStageInstances, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        Intrinsics3.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeUser = storeUser;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storeThreadsJoined = storeThreadsJoined;
        this.storeStageInstances = storeStageInstances;
        this.observationDeck = observationDeck;
        this.permissionsForGuilds = new HashMap();
        this.permissionsForGuildsSnapshot = new HashMap();
        this.permissionsForGuildsCache = new Persister<>("STORE_GUILD_PERMISSIONS_V5", new HashMap());
        this.permissionsForChannels = new HashMap();
        this.permissionsForChannelsSnapshot = new HashMap();
        this.permissionsForChannelsCache = new Persister<>("STORE_CHANNEL_PERMISSIONS_BY_GUILD_V5", new HashMap());
        this.permissionsForChannelsFlattenedSnapshot = new HashMap();
    }

    public static final /* synthetic */ Map access$getPermissionsForChannels$p(StorePermissions storePermissions) {
        return storePermissions.permissionsForChannels;
    }

    public static final /* synthetic */ Map access$getPermissionsForChannelsFlattenedSnapshot$p(StorePermissions storePermissions) {
        return storePermissions.permissionsForChannelsFlattenedSnapshot;
    }

    public static final /* synthetic */ Map access$getPermissionsForGuildsSnapshot$p(StorePermissions storePermissions) {
        return storePermissions.permissionsForGuildsSnapshot;
    }

    public static final /* synthetic */ void access$setPermissionsForChannelsFlattenedSnapshot$p(StorePermissions storePermissions, Map map) {
        storePermissions.permissionsForChannelsFlattenedSnapshot = map;
    }

    public static final /* synthetic */ void access$setPermissionsForGuildsSnapshot$p(StorePermissions storePermissions, Map map) {
        storePermissions.permissionsForGuildsSnapshot = map;
    }

    @Store3
    private final Map<Long, Long> computeChannelPermissions(long guildId, Iterable<Channel> channels) {
        Guild guild = this.storeGuilds.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild == null) {
            return Maps6.emptyMap();
        }
        Map<Long, GuildMember> map = this.storeGuilds.getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        Map<Long, GuildRole> map2 = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        Map<Long, StageInstance> stageInstancesForGuildInternal = this.storeStageInstances.getStageInstancesForGuildInternal(guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(channels, 10)), 16));
        for (Channel channel : channels) {
            boolean zHasJoinedInternal = this.storeThreadsJoined.hasJoinedInternal(channel.getId());
            Tuples2 tuples2 = Tuples.to(Long.valueOf(channel.getId()), Long.valueOf(ChannelUtils.B(channel) ? Permission.ALL : PermissionUtils.computePermissions(getMeId(), channel, this.storeChannels.getGuildChannelInternal$app_productionGoogleRelease(channel.getGuildId(), channel.getParentId()), guild.getOwnerId(), map != null ? map.get(Long.valueOf(getMeId())) : null, map2, stageInstancesForGuildInternal, zHasJoinedInternal)));
            linkedHashMap.put(tuples2.getFirst(), tuples2.getSecond());
        }
        return linkedHashMap;
    }

    private final long getMeId() {
        return this.storeUser.getMe().getId();
    }

    @Store3
    private final void recomputeAllPermissions() {
        this.permissionsForGuilds.clear();
        this.permissionsForChannels.clear();
        Collection<Channel> collectionValues = this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().values();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : collectionValues) {
            Long lValueOf = Long.valueOf(((Channel) obj).getGuildId());
            Object arrayList = linkedHashMap.get(lValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(lValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        Set<Long> setKeySet = this.storeChannels.getChannelsByGuildInternal$app_productionGoogleRelease().keySet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setKeySet) {
            if (((Number) obj2).longValue() != 0) {
                arrayList2.add(obj2);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            List listEmptyList = (List) linkedHashMap.get(Long.valueOf(jLongValue));
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            updateGuildPermissions(jLongValue, listEmptyList);
        }
    }

    @Store3
    private final void restoreFromCache() {
        this.permissionsForGuilds.putAll(this.permissionsForGuildsCache.get());
        this.permissionsForChannels.putAll(this.permissionsForChannelsCache.get());
    }

    @Store3
    private final void updateChannelPermissions(Channel channel) {
        if (getMeId() == 0) {
            return;
        }
        long guildId = channel.getGuildId();
        Map<Long, Long> mapEmptyMap = this.permissionsForChannels.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        this.permissionsForChannels.put(Long.valueOf(guildId), Maps6.plus(mapEmptyMap, computeChannelPermissions(guildId, CollectionsJVM.listOf(channel))));
        markChanged();
    }

    @Store3
    private final void updateGuildPermissions(long guildId, Collection<Channel> guildThreads) {
        Map<Long, Channel> map;
        Guild guild;
        if (getMeId() == 0 || (map = this.storeChannels.getChannelsByGuildInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) == null || (guild = this.storeGuilds.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) == null) {
            return;
        }
        Map<Long, GuildMember> map2 = this.storeGuilds.getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        long jComputeNonThreadPermissions = PermissionUtils.computeNonThreadPermissions(getMeId(), guildId, guild.getOwnerId(), map2 != null ? map2.get(Long.valueOf(getMeId())) : null, this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId)), null);
        Long l = this.permissionsForGuilds.get(Long.valueOf(guildId));
        if (l == null || l.longValue() != jComputeNonThreadPermissions) {
            this.permissionsForGuilds.put(Long.valueOf(guildId), Long.valueOf(jComputeNonThreadPermissions));
            markChanged();
        }
        Map<Long, Long> mapComputeChannelPermissions = computeChannelPermissions(guildId, _Collections.plus((Collection) map.values(), (Iterable) guildThreads));
        if (!Intrinsics3.areEqual(this.permissionsForChannels.get(Long.valueOf(guildId)), mapComputeChannelPermissions)) {
            this.permissionsForChannels.put(Long.valueOf(guildId), mapComputeChannelPermissions);
            markChanged();
        }
    }

    public final Map<Long, Long> getGuildPermissions() {
        return this.permissionsForGuildsSnapshot;
    }

    public final Map<Long, Long> getPermissionsByChannel() {
        return this.permissionsForChannelsFlattenedSnapshot;
    }

    @Store3
    public final Map<Long, Long> getPermissionsByChannelInternal$app_productionGoogleRelease(long guildId) {
        Map<Long, Long> map = this.permissionsForChannels.get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    @Store3
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        updateChannelPermissions(channel);
    }

    @Store3
    public final void handleChannelOrThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        long guildId = channel.getGuildId();
        Map<Long, Long> mapEmptyMap = this.permissionsForChannels.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        this.permissionsForChannels.put(Long.valueOf(guildId), Maps6.minus(mapEmptyMap, Long.valueOf(channel.getId())));
        markChanged();
    }

    @Store3
    public final void handleConnectionOpen() {
        recomputeAllPermissions();
        markChanged();
    }

    @Store3
    public final void handleGuildAdd(com.discord.api.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        updateGuildPermissions(guild.getId(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(guild.getId()));
    }

    @Store3
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        if (getMeId() != 0 && member.getUser().getId() == getMeId()) {
            updateGuildPermissions(member.getGuildId(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(member.getGuildId()));
        }
    }

    @Store3
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        long id2 = guild.getId();
        this.permissionsForChannels.remove(Long.valueOf(id2));
        this.permissionsForGuilds.remove(Long.valueOf(id2));
        markChanged();
    }

    @Store3
    public final void handleGuildRolesChanged(long guildId) {
        updateGuildPermissions(guildId, this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(guildId));
    }

    @Store3
    public final void handleMessagesLoaded(List<Message> messages) {
        Intrinsics3.checkNotNullParameter(messages, "messages");
        if (getMeId() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            Channel thread = ((Message) it.next()).getThread();
            if (thread != null) {
                arrayList.add(thread);
            }
        }
        Channel channel = (Channel) _Collections.firstOrNull((List) arrayList);
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        if (lValueOf != null) {
            updateGuildPermissions(lValueOf.longValue(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(lValueOf.longValue()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleSearchFinish(SearchState searchState) {
        Long lValueOf;
        Intrinsics3.checkNotNullParameter(searchState, "searchState");
        if (getMeId() == 0) {
            return;
        }
        List<Message> hits = searchState.getHits();
        if (hits != null) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(hits, 10));
            Iterator<T> it = hits.iterator();
            while (it.hasNext()) {
                arrayList.add(((Message) it.next()).getThread());
            }
            Channel channel = (Channel) _Collections.firstOrNull((List) arrayList);
            lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        }
        if (lValueOf != null) {
            updateGuildPermissions(lValueOf.longValue(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(lValueOf.longValue()));
        }
    }

    @Store3
    public final void handleStageInstanceChange(StageInstance stageInstance) {
        Channel channelInternal$app_productionGoogleRelease;
        Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
        if (getMeId() == 0 || (channelInternal$app_productionGoogleRelease = this.storeChannels.getChannelInternal$app_productionGoogleRelease(stageInstance.getGuildId(), stageInstance.getChannelId())) == null) {
            return;
        }
        updateChannelPermissions(channelInternal$app_productionGoogleRelease);
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync threadListSync) {
        Intrinsics3.checkNotNullParameter(threadListSync, "threadListSync");
        if (getMeId() == 0) {
            return;
        }
        updateGuildPermissions(threadListSync.getGuildId(), this.storeChannels.getThreadsForGuildInternal$app_productionGoogleRelease(threadListSync.getGuildId()));
    }

    @Store3
    public final void handleThreadMemberUpdate(ThreadMemberUpdate threadMemberUpdate) {
        Intrinsics3.checkNotNullParameter(threadMemberUpdate, "threadMemberUpdate");
        Channel guildChannelInternal$app_productionGoogleRelease = this.storeChannels.getGuildChannelInternal$app_productionGoogleRelease(threadMemberUpdate.getGuildId(), threadMemberUpdate.getId());
        if (guildChannelInternal$app_productionGoogleRelease != null) {
            updateChannelPermissions(guildChannelInternal$app_productionGoogleRelease);
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        Channel guildChannelInternal$app_productionGoogleRelease;
        Boolean boolValueOf;
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        if (getMeId() == 0 || (guildChannelInternal$app_productionGoogleRelease = this.storeChannels.getGuildChannelInternal$app_productionGoogleRelease(threadMembersUpdate.getGuildId(), threadMembersUpdate.getId())) == null) {
            return;
        }
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            boolean z2 = true;
            if (listA.isEmpty()) {
                z2 = false;
                boolValueOf = Boolean.valueOf(z2);
            } else {
                Iterator<T> it = listA.iterator();
                while (it.hasNext()) {
                    if (((AugmentedThreadMember) it.next()).getUserId() == getMeId()) {
                        break;
                    }
                }
                z2 = false;
                boolValueOf = Boolean.valueOf(z2);
            }
        } else {
            boolValueOf = null;
        }
        List<Long> listD = threadMembersUpdate.d();
        Boolean boolValueOf2 = listD != null ? Boolean.valueOf(listD.contains(Long.valueOf(getMeId()))) : null;
        Boolean bool = Boolean.TRUE;
        if (Intrinsics3.areEqual(boolValueOf, bool) || Intrinsics3.areEqual(boolValueOf2, bool)) {
            updateChannelPermissions(guildChannelInternal$app_productionGoogleRelease);
        }
    }

    @Store3
    public final void init() {
        restoreFromCache();
        markChanged();
    }

    public final Observable<Map<Long, Map<Long, Long>>> observeAllPermissions() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, Long>> observeChannelPermissionsForGuild(long guildId) {
        Observable<Map<Long, Long>> observableR = observeAllPermissions().G(new AnonymousClass1(guildId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeAllPermissions()\n…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Long>> observePermissionsForAllChannels() {
        Observable<Map<Long, Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observePermissionsForChannel(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<Long> observePermissionsForGuild(long guildId) {
        Observable<Long> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        Iterator<T> it = this.permissionsForChannels.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Map) it.next()).size();
        }
        HashMap map = new HashMap(size, 0.75f);
        Iterator<T> it2 = this.permissionsForChannels.values().iterator();
        while (it2.hasNext()) {
            map.putAll((Map) it2.next());
        }
        this.permissionsForGuildsSnapshot = CollectionExtensions.snapshot$default(this.permissionsForGuilds, 0, 0.0f, 3, null);
        this.permissionsForChannelsSnapshot = CollectionExtensions.snapshot$default(this.permissionsForChannels, 0, 0.0f, 3, null);
        this.permissionsForChannelsFlattenedSnapshot = map;
        this.permissionsForGuildsCache.set(this.permissionsForGuilds, true);
        this.permissionsForChannelsCache.set(this.permissionsForChannels, true);
    }
}
