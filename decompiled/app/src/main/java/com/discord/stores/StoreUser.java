package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.message.Message;
import com.discord.api.premium.PremiumTier;
import com.discord.api.presence.Presence;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.user.UserRequestManager;
import com.discord.utilities.user.UserUtils;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: StoreUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001BB\u0012\u0013\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u007f\u0012\u0006\u0010p\u001a\u00020o\u0012\n\b\u0002\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\u000e\b\u0002\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00130t¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\r\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00072\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00100\u000fH\u0001¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00100\u000f0\u001e¢\u0006\u0004\b\u001f\u0010 J5\u0010\"\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00100\u000f0\u001e2\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u0007¢\u0006\u0004\b\"\u0010#J=\u0010\"\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00100\u000f0\u001e2\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00072\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b\"\u0010&J!\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001e2\n\u0010'\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b(\u0010)J7\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00072\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b\u0011\u0010*J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e2\b\b\u0002\u0010+\u001a\u00020$H\u0007¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u001e¢\u0006\u0004\b.\u0010 J5\u00100\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020/0\u000f0\u001e2\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u0007¢\u0006\u0004\b0\u0010#J\u001f\u00103\u001a\u00020\u00042\u0010\u00102\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t01¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010/H\u0007¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<H\u0007¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H\u0007¢\u0006\u0004\bB\u0010CJ\u001d\u0010F\u001a\u00020\u00042\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D01H\u0007¢\u0006\u0004\bF\u00104J\u0017\u0010H\u001a\u00020\u00042\u0006\u0010G\u001a\u00020DH\u0007¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bJ\u0010\u0006J\u0017\u0010M\u001a\u00020\u00042\u0006\u0010L\u001a\u00020KH\u0007¢\u0006\u0004\bM\u0010NJ\u0017\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020OH\u0007¢\u0006\u0004\bQ\u0010RJ\u0017\u0010U\u001a\u00020\u00042\u0006\u0010T\u001a\u00020SH\u0007¢\u0006\u0004\bU\u0010VJ\u0017\u0010Y\u001a\u00020\u00042\u0006\u0010X\u001a\u00020WH\u0007¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001a\u00020\u00042\u0006\u00109\u001a\u00020[H\u0007¢\u0006\u0004\b\\\u0010]J\u0017\u0010`\u001a\u00020\u00042\u0006\u0010_\u001a\u00020^H\u0007¢\u0006\u0004\b`\u0010aJ\u0017\u0010d\u001a\u00020\u00042\u0006\u0010c\u001a\u00020bH\u0007¢\u0006\u0004\bd\u0010eJ\u0017\u0010h\u001a\u00020\u00042\u0006\u0010g\u001a\u00020fH\u0007¢\u0006\u0004\bh\u0010iJ\u001d\u0010l\u001a\u00020\u00042\f\u0010k\u001a\b\u0012\u0004\u0012\u00020j01H\u0007¢\u0006\u0004\bl\u00104J\u000f\u0010m\u001a\u00020\u0004H\u0017¢\u0006\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010sR\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00130t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001a\u00020w8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R&\u0010|\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010{R%\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u007f8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001a\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/user/User;", "user", "", "updateUser", "(Lcom/discord/api/user/User;)V", "", "", "Lcom/discord/primitives/UserId;", "totalUserIds", "", "existingUserIds", "fetchMissing", "(Ljava/util/Collection;Ljava/util/Set;)V", "", "Lcom/discord/models/user/User;", "getUsers", "()Ljava/util/Map;", "Lcom/discord/models/user/MeUser;", "getMe", "()Lcom/discord/models/user/MeUser;", "getMeInternal$app_productionGoogleRelease", "getMeInternal", "getUsersInternal$app_productionGoogleRelease", "getUsersInternal", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "Lrx/Observable;", "observeAllUsers", "()Lrx/Observable;", "userIds", "observeUsers", "(Ljava/util/Collection;)Lrx/Observable;", "", "fetchUserIfMissing", "(Ljava/util/Collection;Z)Lrx/Observable;", "userId", "observeUser", "(J)Lrx/Observable;", "(Ljava/util/Collection;Z)Ljava/util/Map;", "emitEmpty", "observeMe", "(Z)Lrx/Observable;", "observeMeId", "", "observeUsernames", "", "users", "fetchUsers", "(Ljava/util/List;)V", "authToken", "handleAuthToken", "(Ljava/lang/String;)V", "Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;", "chunk", "handleMessagesLoaded", "(Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/models/domain/ModelUserRelationship;", "relationship", "handleUserRelationshipAdd", "(Lcom/discord/models/domain/ModelUserRelationship;)V", "Lcom/discord/api/friendsuggestions/FriendSuggestion;", "loadedSuggestions", "handleFriendSuggestionsLoaded", "suggestion", "handleFriendSuggestionCreate", "(Lcom/discord/api/friendsuggestions/FriendSuggestion;)V", "handleUserUpdated", "Lcom/discord/api/presence/Presence;", "presence", "handlePresenceUpdate", "(Lcom/discord/api/presence/Presence;)V", "Lcom/discord/api/channel/Channel;", "channel", "handleChannelCreated", "(Lcom/discord/api/channel/Channel;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildAddOrSync", "(Lcom/discord/api/guild/Guild;)V", "Lcom/discord/api/guildmember/GuildMember;", "member", "handleGuildMemberAdd", "(Lcom/discord/api/guildmember/GuildMember;)V", "Lcom/discord/api/guildmember/GuildMembersChunk;", "handleGuildMembersChunk", "(Lcom/discord/api/guildmember/GuildMembersChunk;)V", "Lcom/discord/api/thread/ThreadMemberListUpdate;", "threadMemberListUpdate", "handleThreadMemberListUpdate", "(Lcom/discord/api/thread/ThreadMemberListUpdate;)V", "Lcom/discord/api/thread/ThreadMembersUpdate;", "threadMembersUpdate", "handleThreadMembersUpdate", "(Lcom/discord/api/thread/ThreadMembersUpdate;)V", "Lcom/discord/api/message/Message;", "message", "handleMessageCreateOrUpdate", "(Lcom/discord/api/message/Message;)V", "Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUser;", "apiGuildScheduledEventUsers", "handleGuildScheduledEventUsersFetch", "snapshotData", "()V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/utilities/collections/SnowflakePartitionMap$CopiablePartitionMap;", "Lcom/discord/utilities/collections/SnowflakePartitionMap$CopiablePartitionMap;", "Lcom/discord/utilities/persister/Persister;", "meCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/utilities/user/UserRequestManager;", "userRequestManager", "Lcom/discord/utilities/user/UserRequestManager;", "meSnapshot", "Lcom/discord/models/user/MeUser;", "usersSnapshot", "Ljava/util/Map;", "me", "Lkotlin/Function1;", "notifyUserUpdated", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lkotlin/jvm/functions/Function1;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/persister/Persister;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUser extends StoreV2 {
    private final Dispatcher dispatcher;
    private MeUser me;
    private final Persister<MeUser> meCache;
    private MeUser meSnapshot;
    private final Function1<User, Unit> notifyUserUpdated;
    private final ObservationDeck observationDeck;
    private final UserRequestManager userRequestManager;
    private final SnowflakePartitionMap.CopiablePartitionMap<com.discord.models.user.User> users;
    private Map<Long, ? extends com.discord.models.user.User> usersSnapshot;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObservationDeck.UpdateSource MeUpdate = new StoreUser2();
    private static final ObservationDeck.UpdateSource UsersUpdate = new StoreUser3();
    private static final MeUser EMPTY_ME_USER = new MeUser(0, "EMPTY_USERNAME", null, null, false, false, 0, PremiumTier.NONE, null, false, false, null, 0, 0, null, NsfwAllowance.UNKNOWN, null, null, 204800, null);

    /* compiled from: StoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/stores/StoreUser$Companion;", "", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "MeUpdate", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "getMeUpdate", "()Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "UsersUpdate", "getUsersUpdate", "Lcom/discord/models/user/MeUser;", "EMPTY_ME_USER", "Lcom/discord/models/user/MeUser;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ObservationDeck.UpdateSource getMeUpdate() {
            return StoreUser.access$getMeUpdate$cp();
        }

        public final ObservationDeck.UpdateSource getUsersUpdate() {
            return StoreUser.access$getUsersUpdate$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUser$fetchUsers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $users;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$users = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUser storeUser = StoreUser.this;
            StoreUser.access$fetchMissing(storeUser, this.$users, storeUser.getUsers().keySet());
        }
    }

    /* compiled from: StoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUser$observeAllUsers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends com.discord.models.user.User>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.user.User> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends com.discord.models.user.User> invoke2() {
            return StoreUser.this.getUsers();
        }
    }

    /* compiled from: StoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/user/MeUser;", "invoke", "()Lcom/discord/models/user/MeUser;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUser$observeMe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<MeUser> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MeUser invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MeUser invoke() {
            return StoreUser.access$getMe$p(StoreUser.this);
        }
    }

    /* compiled from: StoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUser$observeMe$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<MeUser, Boolean> {
        public final /* synthetic */ boolean $emitEmpty;

        public AnonymousClass2(boolean z2) {
            this.$emitEmpty = z2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            return Boolean.valueOf(meUser != StoreUser.access$getEMPTY_ME_USER$cp() || this.$emitEmpty);
        }
    }

    /* compiled from: StoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/primitives/UserId;", "invoke", "()J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUser$observeMeId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreUser.access$getMe$p(StoreUser.this).getId();
        }
    }

    /* compiled from: StoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "user", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/user/User;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUser$observeUser$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends com.discord.models.user.User>, com.discord.models.user.User> {
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j) {
            this.$userId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ com.discord.models.user.User call(Map<Long, ? extends com.discord.models.user.User> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final com.discord.models.user.User call2(Map<Long, ? extends com.discord.models.user.User> map) {
            Intrinsics3.checkNotNullParameter(map, "user");
            return map.get(Long.valueOf(this.$userId));
        }
    }

    /* compiled from: StoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "user", "", "invoke", "(Lcom/discord/models/user/User;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUser$observeUsernames$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<com.discord.models.user.User, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(com.discord.models.user.User user) {
            return invoke2(user);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(com.discord.models.user.User user) {
            Intrinsics3.checkNotNull(user);
            return user.getUsername();
        }
    }

    /* compiled from: StoreUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "userMap", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUser$observeUsers$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Map<Long, ? extends com.discord.models.user.User>> {
        public final /* synthetic */ boolean $fetchUserIfMissing;
        public final /* synthetic */ Collection $userIds;

        public AnonymousClass1(boolean z2, Collection collection) {
            this.$fetchUserIfMissing = z2;
            this.$userIds = collection;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Map<Long, ? extends com.discord.models.user.User> map) {
            call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Map<Long, ? extends com.discord.models.user.User> map) {
            if (this.$fetchUserIfMissing) {
                StoreUser.access$fetchMissing(StoreUser.this, this.$userIds, map.keySet());
            }
        }
    }

    public /* synthetic */ StoreUser(Function1 function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? new Persister("STORE_USERS_ME_V13", EMPTY_ME_USER) : persister);
    }

    public static final /* synthetic */ void access$fetchMissing(StoreUser storeUser, Collection collection, Set set) {
        storeUser.fetchMissing(collection, set);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUser storeUser) {
        return storeUser.dispatcher;
    }

    public static final /* synthetic */ MeUser access$getEMPTY_ME_USER$cp() {
        return EMPTY_ME_USER;
    }

    public static final /* synthetic */ MeUser access$getMe$p(StoreUser storeUser) {
        return storeUser.me;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getMeUpdate$cp() {
        return MeUpdate;
    }

    public static final /* synthetic */ Function1 access$getNotifyUserUpdated$p(StoreUser storeUser) {
        return storeUser.notifyUserUpdated;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getUsersUpdate$cp() {
        return UsersUpdate;
    }

    public static final /* synthetic */ void access$setMe$p(StoreUser storeUser, MeUser meUser) {
        storeUser.me = meUser;
    }

    @Store3
    private final void fetchMissing(Collection<Long> totalUserIds, Set<Long> existingUserIds) {
        HashSet hashSet = new HashSet();
        Iterator<Long> it = totalUserIds.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (!existingUserIds.contains(Long.valueOf(jLongValue))) {
                hashSet.add(Long.valueOf(jLongValue));
            }
        }
        this.userRequestManager.requestUsers(hashSet);
    }

    public static /* synthetic */ Observable observeMe$default(StoreUser storeUser, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return storeUser.observeMe(z2);
    }

    @Store3
    private final void updateUser(User user) {
        CoreUser coreUser = new CoreUser(user);
        if (!Intrinsics3.areEqual(coreUser, this.users.get(Long.valueOf(user.getId())))) {
            this.users.put(Long.valueOf(user.getId()), coreUser);
            markChanged(UsersUpdate);
        }
    }

    public final void fetchUsers(List<Long> users) {
        Intrinsics3.checkNotNullParameter(users, "users");
        this.dispatcher.schedule(new AnonymousClass1(users));
    }

    /* renamed from: getMe, reason: from getter */
    public final MeUser getMeSnapshot() {
        return this.meSnapshot;
    }

    @Store3
    /* renamed from: getMeInternal$app_productionGoogleRelease, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final Map<Long, com.discord.models.user.User> getUsers() {
        return this.usersSnapshot;
    }

    @Store3
    public final Map<Long, com.discord.models.user.User> getUsersInternal$app_productionGoogleRelease() {
        return this.users;
    }

    @Store3
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            markChanged(MeUpdate);
            this.me = EMPTY_ME_USER;
        }
    }

    @Store3
    public final void handleChannelCreated(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        List<User> listZ = channel.z();
        if (listZ != null) {
            Iterator<T> it = listZ.iterator();
            while (it.hasNext()) {
                updateUser((User) it.next());
            }
        }
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.users.clear();
        User me2 = payload.getMe();
        Intrinsics3.checkNotNullExpressionValue(me2, "payload.me");
        MeUser meUser = new MeUser(me2);
        this.me = meUser;
        this.users.put(Long.valueOf(meUser.getId()), meUser);
        for (Channel channel : payload.getPrivateChannels()) {
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            for (com.discord.models.user.User user : ChannelUtils.g(channel)) {
                this.users.put(Long.valueOf(user.getId()), user);
            }
        }
        for (ModelUserRelationship modelUserRelationship : payload.getRelationships()) {
            Intrinsics3.checkNotNullExpressionValue(modelUserRelationship, "relationship");
            if (modelUserRelationship.getUser() != null) {
                SnowflakePartitionMap.CopiablePartitionMap<com.discord.models.user.User> copiablePartitionMap = this.users;
                Long lValueOf = Long.valueOf(modelUserRelationship.getUser().getId());
                User user2 = modelUserRelationship.getUser();
                Intrinsics3.checkNotNullExpressionValue(user2, "relationship.user");
                copiablePartitionMap.put(lValueOf, new CoreUser(user2));
            }
        }
        Iterator<Guild> it = payload.getGuilds().iterator();
        while (it.hasNext()) {
            List<GuildMember> listV = it.next().v();
            if (listV != null) {
                for (GuildMember guildMember : listV) {
                    this.users.put(Long.valueOf(guildMember.getUser().getId()), new CoreUser(guildMember.getUser()));
                }
            }
        }
        StringBuilder sbU = outline.U("Discovered ");
        sbU.append(this.users.size());
        sbU.append(" initial users.");
        AppLog.i(sbU.toString());
        AppLog.g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(meUser));
        markChanged(MeUpdate, UsersUpdate);
    }

    @Store3
    public final void handleFriendSuggestionCreate(FriendSuggestion suggestion) {
        Intrinsics3.checkNotNullParameter(suggestion, "suggestion");
        updateUser(suggestion.getSuggestedUser());
    }

    @Store3
    public final void handleFriendSuggestionsLoaded(List<FriendSuggestion> loadedSuggestions) {
        Intrinsics3.checkNotNullParameter(loadedSuggestions, "loadedSuggestions");
        Iterator<T> it = loadedSuggestions.iterator();
        while (it.hasNext()) {
            updateUser(((FriendSuggestion) it.next()).getSuggestedUser());
        }
    }

    @Store3
    public final void handleGuildAddOrSync(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<GuildMember> listV = guild.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            while (it.hasNext()) {
                updateUser(((GuildMember) it.next()).getUser());
            }
        }
    }

    @Store3
    public final void handleGuildMemberAdd(GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        updateUser(member.getUser());
    }

    @Store3
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        Iterator<GuildMember> it = chunk.b().iterator();
        while (it.hasNext()) {
            updateUser(it.next().getUser());
        }
    }

    @Store3
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers) {
        Intrinsics3.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            User userC = ((ApiGuildScheduledEventUser) it.next()).getUser();
            if (userC != null) {
                updateUser(userC);
            }
        }
    }

    @Store3
    public final void handleMessageCreateOrUpdate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        List<User> listT = message.t();
        if (listT != null) {
            Iterator<T> it = listT.iterator();
            while (it.hasNext()) {
                updateUser((User) it.next());
            }
        }
        Long flags = message.getFlags();
        if (((flags != null ? flags.longValue() : 0L) & 16) != 0) {
            this.me = MeUser.copy$default(this.me, 0L, null, null, null, false, false, 0, null, null, false, false, null, this.me.getFlags() | 8192, 0, null, null, null, null, 258047, null);
            markChanged(MeUpdate);
        }
    }

    @Store3
    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        for (com.discord.models.message.Message message : chunk.getMessages()) {
            User author = message.getAuthor();
            if (author != null) {
                updateUser(author);
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                Iterator<T> it = mentions.iterator();
                while (it.hasNext()) {
                    updateUser((User) it.next());
                }
            }
        }
    }

    @Store3
    public final void handlePresenceUpdate(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        User user = presence.getUser();
        if ((user != null ? user.getDiscriminator() : null) != null) {
            updateUser(user);
        }
    }

    @Store3
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            for (ThreadListMember threadListMember : listB) {
                GuildMember guildMemberA = threadListMember.getMember();
                if (guildMemberA != null) {
                    updateUser(guildMemberA.getUser());
                }
                Presence presenceB = threadListMember.getPresence();
                User user = presenceB != null ? presenceB.getUser() : null;
                if (user != null) {
                    updateUser(user);
                }
            }
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            for (AugmentedThreadMember augmentedThreadMember : listA) {
                GuildMember member = augmentedThreadMember.getMember();
                if (member != null) {
                    updateUser(member.getUser());
                }
                Presence presence = augmentedThreadMember.getPresence();
                User user = presence != null ? presence.getUser() : null;
                if (user != null) {
                    updateUser(user);
                }
            }
        }
    }

    @Store3
    public final void handleUserRelationshipAdd(ModelUserRelationship relationship) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        User user = relationship.getUser();
        Intrinsics3.checkNotNullExpressionValue(user, "relationship.user");
        updateUser(user);
    }

    @Store3
    public final void handleUserUpdated(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        updateUser(user);
        if (this.me.getId() == user.getId()) {
            this.me = MeUser.INSTANCE.merge(this.me, user);
            markChanged(MeUpdate);
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.me = this.meCache.get();
        markChanged(MeUpdate);
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeAllUsers() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<MeUser> observeMe() {
        return observeMe$default(this, false, 1, null);
    }

    public final Observable<MeUser> observeMe(boolean emitEmpty) {
        Observable<MeUser> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new AnonymousClass1(), 14, null).y(new AnonymousClass2(emitEmpty)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observeMeId() {
        Observable<Long> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<com.discord.models.user.User> observeUser(long userId) {
        Observable<com.discord.models.user.User> observableR = observeAllUsers().G(new AnonymousClass1(userId)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeAllUsers()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, String>> observeUsernames(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable observableK = observeAllUsers().k(o.b(userIds, AnonymousClass1.INSTANCE));
        Intrinsics3.checkNotNullExpressionValue(observableK, "observeAllUsers()\n      …er!!.username }\n        )");
        return observableK;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        return observeUsers(userIds, false);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        if (getUpdateSources().contains(UsersUpdate)) {
            this.usersSnapshot = this.users.fastCopy();
        }
        if (getUpdateSources().contains(MeUpdate)) {
            MeUser meUser = this.me;
            this.meSnapshot = meUser;
            Persister.set$default(this.meCache, meUser, false, 2, null);
        }
    }

    public final Map<Long, com.discord.models.user.User> getUsers(Collection<Long> userIds, boolean fetchUserIfMissing) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Map<Long, ? extends com.discord.models.user.User> map = this.usersSnapshot;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            com.discord.models.user.User user = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (user != null) {
                arrayList.add(user);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((com.discord.models.user.User) obj).getId()), obj);
        }
        if (fetchUserIfMissing) {
            fetchMissing(userIds, linkedHashMap.keySet());
        }
        return linkedHashMap;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(Collection<Long> userIds, boolean fetchUserIfMissing) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, com.discord.models.user.User>> observableU = observeAllUsers().k(o.a(userIds)).u(new AnonymousClass1(fetchUserIfMissing, userIds));
        Intrinsics3.checkNotNullExpressionValue(observableU, "observeAllUsers()\n      …ys)\n          }\n        }");
        return observableU;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreUser(Function1<? super User, Unit> function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister<MeUser> persister) {
        Intrinsics3.checkNotNullParameter(function1, "notifyUserUpdated");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(persister, "meCache");
        this.notifyUserUpdated = function1;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.meCache = persister;
        MeUser meUser = EMPTY_ME_USER;
        this.me = meUser;
        this.users = new SnowflakePartitionMap.CopiablePartitionMap<>(0, 1, null);
        this.meSnapshot = meUser;
        this.usersSnapshot = Maps6.emptyMap();
        this.userRequestManager = new UserRequestManager(new StoreUser4(this));
    }
}
