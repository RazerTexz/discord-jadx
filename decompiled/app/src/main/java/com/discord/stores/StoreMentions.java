package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.permission.Permission;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010o\u001a\u00020n\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010r\u001a\u00020q\u0012\b\b\u0002\u0010u\u001a\u00020t¢\u0006\u0004\bx\u0010yJ\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0016\u001a\u00020\u00142\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102\u0012\u0010\u0013\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0012\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0016\u001a\u00020\u0014*\u00020\u0018H\u0003¢\u0006\u0004\b\u0016\u0010\u0019J\u0013\u0010\u0016\u001a\u00020\u0014*\u00020\u001aH\u0003¢\u0006\u0004\b\u0016\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00142\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001e\u0010\u000bJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001f¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\b0\u001f¢\u0006\u0004\b\"\u0010!J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&J\u001b\u0010(\u001a\u00020\u00052\n\u0010'\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b(\u0010\u0007J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010$\u001a\u00020-H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u001aH\u0007¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u000207H\u0007¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020?H\u0007¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\bC\u0010,J\u0017\u0010E\u001a\u00020\u00052\u0006\u0010$\u001a\u00020DH\u0007¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0005H\u0017¢\u0006\u0004\bG\u0010HJ)\u0010L\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010H\u0001¢\u0006\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001a\u0010Q\u001a\u00060\u0002j\u0002`P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u0002000V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR&\u0010Y\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010\\\u001a\u00020[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R \u0010_\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030^8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001a\u00020a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR&\u0010d\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010ZR*\u0010g\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`f0e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR&\u0010j\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`i\u0012\u0004\u0012\u00020\u00180e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010hR\u001a\u0010'\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010RR,\u0010l\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\b0k8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010o\u001a\u00020n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010r\u001a\u00020q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010u\u001a\u00020t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR,\u0010w\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00120\u00100e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010h¨\u0006z"}, d2 = {"Lcom/discord/stores/StoreMentions;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "removeAllMessagesForChannel", "(J)V", "", "", "computeMentionCounts", "()Ljava/util/Map;", "Lcom/discord/api/user/User;", "author", "Lcom/discord/api/utcdatetime/UtcDateTime;", "editedTimestamp", "", "mentions", "Lcom/discord/primitives/RoleId;", "mentionRoles", "", "mentionEveryone", "hasMention", "(JLcom/discord/api/user/User;Lcom/discord/api/utcdatetime/UtcDateTime;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Z", "Lcom/discord/models/message/Message;", "(Lcom/discord/models/message/Message;)Z", "Lcom/discord/api/message/Message;", "(Lcom/discord/api/message/Message;)Z", "isMentionableChannel", "(J)Z", "getMentionCounts", "Lrx/Observable;", "observeTotalMentions", "()Lrx/Observable;", "observeMentionCounts", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "selectedChannelId", "handleChannelSelected", "Lcom/discord/api/channel/Channel;", "channel", "handleChannelOrThreadCreateOrUpdate", "(Lcom/discord/api/channel/Channel;)V", "Lcom/discord/models/thread/dto/ModelThreadListSync;", "handleThreadListSync", "(Lcom/discord/models/thread/dto/ModelThreadListSync;)V", "Lcom/discord/models/domain/ModelReadState;", "readState", "handleMessageAck", "(Lcom/discord/models/domain/ModelReadState;)V", "message", "handleMessageCreateOrUpdate", "(Lcom/discord/api/message/Message;)V", "Lcom/discord/models/domain/ModelMessageDelete;", "messageDeleteBulk", "handleMessageDeleted", "(Lcom/discord/models/domain/ModelMessageDelete;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildAdd", "(Lcom/discord/api/guild/Guild;)V", "Lcom/discord/api/guildmember/GuildMember;", "member", "handleGuildMemberAdd", "(Lcom/discord/api/guildmember/GuildMember;)V", "handleChannelOrThreadDelete", "Lcom/discord/api/thread/ThreadMembersUpdate;", "handleThreadMembersUpdate", "(Lcom/discord/api/thread/ThreadMembersUpdate;)V", "snapshotData", "()V", "messagesAfter", "processMarkUnread$app_productionGoogleRelease", "(JLjava/util/List;)I", "processMarkUnread", "Lcom/discord/stores/StoreUserRelationships;", "storeUserRelationships", "Lcom/discord/stores/StoreUserRelationships;", "Lcom/discord/primitives/UserId;", "myId", "J", "Lcom/discord/stores/StoreUserGuildSettings;", "storeUserGuildSettings", "Lcom/discord/stores/StoreUserGuildSettings;", "Ljava/util/ArrayList;", "serverInitReadStates", "Ljava/util/ArrayList;", "countsEmpty", "Ljava/util/Map;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Ljava/util/HashSet;", "privateChannels", "Ljava/util/HashSet;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "countsSnapshot", "Ljava/util/HashMap;", "Lcom/discord/primitives/GuildId;", "channelGuildIds", "Ljava/util/HashMap;", "Lcom/discord/primitives/MessageId;", "mentionedMessages", "Lcom/discord/utilities/persister/Persister;", "countsCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/StoreMessageAck;", "storeMessageAck", "Lcom/discord/stores/StoreMessageAck;", "Lcom/discord/stores/StoreThreadsJoined;", "storeThreadsJoined", "Lcom/discord/stores/StoreThreadsJoined;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "myRoleIds", "<init>", "(Lcom/discord/stores/StoreUserRelationships;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreMessageAck;Lcom/discord/stores/StoreUserGuildSettings;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreThreadsJoined;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMentions extends StoreV2 {
    private final HashMap<Long, Long> channelGuildIds;
    private final Persister<Map<Long, Integer>> countsCache;
    private final Map<Long, Integer> countsEmpty;
    private Map<Long, Integer> countsSnapshot;
    private final HashMap<Long, Message> mentionedMessages;
    private long myId;
    private final HashMap<Long, List<Long>> myRoleIds;
    private final ObservationDeck observationDeck;
    private final HashSet<Long> privateChannels;
    private long selectedChannelId;
    private final ArrayList<ModelReadState> serverInitReadStates;
    private final StoreChannels storeChannels;
    private final StoreMessageAck storeMessageAck;
    private final StorePermissions storePermissions;
    private final StoreThreadsJoined storeThreadsJoined;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreUserRelationships storeUserRelationships;

    /* compiled from: StoreMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelReadState;", "readState", "", "invoke", "(Lcom/discord/models/domain/ModelReadState;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMentions$handleConnectionOpen$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ModelReadState, Boolean> {
        public final /* synthetic */ HashSet $newReadStateChannelIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(HashSet hashSet) {
            super(1);
            this.$newReadStateChannelIds = hashSet;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
            return Boolean.valueOf(invoke2(modelReadState));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelReadState modelReadState) {
            Intrinsics3.checkNotNullParameter(modelReadState, "readState");
            return this.$newReadStateChannelIds.contains(Long.valueOf(modelReadState.getChannelId()));
        }
    }

    /* compiled from: StoreMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelReadState;", "readState", "", "invoke", "(Lcom/discord/models/domain/ModelReadState;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMentions$handleConnectionOpen$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<ModelReadState, Boolean> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
            return Boolean.valueOf(invoke2(modelReadState));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelReadState modelReadState) {
            Intrinsics3.checkNotNullParameter(modelReadState, "readState");
            return !StoreMentions.access$getStoreChannels$p(StoreMentions.this).getChannelNamesInternal$app_productionGoogleRelease().containsKey(Long.valueOf(modelReadState.getChannelId()));
        }
    }

    /* compiled from: StoreMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelReadState;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelReadState;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMentions$handleMessageAck$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelReadState, Boolean> {
        public final /* synthetic */ ModelReadState $readState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelReadState modelReadState) {
            super(1);
            this.$readState = modelReadState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
            return Boolean.valueOf(invoke2(modelReadState));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelReadState modelReadState) {
            Intrinsics3.checkNotNullParameter(modelReadState, "it");
            return modelReadState.getChannelId() == this.$readState.getChannelId();
        }
    }

    /* compiled from: StoreMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMentions$observeMentionCounts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Integer>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Integer> invoke2() {
            return StoreMentions.this.getMentionCounts();
        }
    }

    /* compiled from: StoreMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMentions$observeTotalMentions$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Integer>, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Integer call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Integer call2(Map<Long, Integer> map) {
            return Integer.valueOf(_Collections.sumOfInt(map.values()));
        }
    }

    public /* synthetic */ StoreMentions(StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessageAck storeMessageAck, StoreUserGuildSettings storeUserGuildSettings, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUserRelationships, storePermissions, storeMessageAck, storeUserGuildSettings, storeChannels, storeThreadsJoined, (i & 64) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreMentions storeMentions) {
        return storeMentions.storeChannels;
    }

    @Store3
    private final Map<Long, Integer> computeMentionCounts() {
        StoreMessageAck.Ack ack;
        if (this.serverInitReadStates.isEmpty() && this.mentionedMessages.isEmpty()) {
            return this.countsEmpty;
        }
        HashMap map = new HashMap();
        Map<Long, StoreMessageAck.Ack> allInternal = this.storeMessageAck.getAllInternal();
        Iterator<ModelReadState> it = this.serverInitReadStates.iterator();
        while (it.hasNext()) {
            ModelReadState next = it.next();
            long channelId = next.getChannelId();
            long lastMessageId = next.getLastMessageId();
            int mentionCount = next.getMentionCount();
            if (mentionCount >= 1 && isMentionableChannel(channelId) && (ack = allInternal.get(Long.valueOf(channelId))) != null && ack.getMessageId() <= lastMessageId) {
                Long lValueOf = Long.valueOf(channelId);
                Integer num = (Integer) map.get(Long.valueOf(channelId));
                if (num == null) {
                    num = 0;
                }
                map.put(lValueOf, Integer.valueOf(num.intValue() + mentionCount));
            }
        }
        for (Message message : this.mentionedMessages.values()) {
            long channelId2 = message.getChannelId();
            User author = message.getAuthor();
            if (!ModelUserRelationship.isType(this.storeUserRelationships.getRelationships().get(author != null ? Long.valueOf(author.getId()) : null), 2) && isMentionableChannel(channelId2)) {
                StoreMessageAck.Ack ack2 = allInternal.get(Long.valueOf(channelId2));
                if (ack2 == null || ack2.getMessageId() < message.getId()) {
                    Long lValueOf2 = Long.valueOf(channelId2);
                    Integer num2 = (Integer) map.get(Long.valueOf(channelId2));
                    if (num2 == null) {
                        num2 = 0;
                    }
                    map.put(lValueOf2, Integer.valueOf(num2.intValue() + 1));
                }
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6 A[RETURN] */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean hasMention(long channelId, User author, UtcDateTime editedTimestamp, List<User> mentions, List<Long> mentionRoles, Boolean mentionEveryone) {
        List<Long> list;
        boolean z2;
        ModelNotificationSettings modelNotificationSettings;
        ModelNotificationSettings.ChannelOverride channelOverride;
        Long l = this.channelGuildIds.get(Long.valueOf(channelId));
        if (l == null) {
            l = 0L;
        }
        Intrinsics3.checkNotNullExpressionValue(l, "channelGuildIds[channelId] ?: 0");
        long jLongValue = l.longValue();
        if (author == null || author.getId() != this.myId) {
            if ((editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) <= 0) {
                Channel channel = this.storeChannels.getChannel(channelId);
                if (channel != null && ChannelUtils.H(channel) && !this.storeThreadsJoined.hasJoined(channelId)) {
                    return false;
                }
                Map<Long, ModelNotificationSettings> guildSettingsInternal$app_productionGoogleRelease = this.storeUserGuildSettings.getGuildSettingsInternal$app_productionGoogleRelease();
                if (this.privateChannels.contains(Long.valueOf(channelId)) && ((modelNotificationSettings = guildSettingsInternal$app_productionGoogleRelease.get(0L)) == null || (channelOverride = modelNotificationSettings.getChannelOverride(channelId)) == null || !channelOverride.isMuted())) {
                    return true;
                }
                if (mentions != null) {
                    if (mentions.isEmpty()) {
                        z2 = false;
                        if (z2) {
                            return true;
                        }
                    } else {
                        Iterator<T> it = mentions.iterator();
                        while (it.hasNext()) {
                            if (((User) it.next()).getId() == this.myId) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                ModelNotificationSettings modelNotificationSettings2 = guildSettingsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue));
                if ((modelNotificationSettings2 == null || !modelNotificationSettings2.isSuppressRoles()) && (list = this.myRoleIds.get(Long.valueOf(jLongValue))) != null && mentionRoles != null) {
                    Iterator<T> it2 = mentionRoles.iterator();
                    if (it2.hasNext()) {
                        return list.contains(Long.valueOf(((Number) it2.next()).longValue()));
                    }
                }
                if (!Intrinsics3.areEqual(mentionEveryone, Boolean.TRUE)) {
                    return false;
                }
                ModelNotificationSettings modelNotificationSettings3 = guildSettingsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue));
                return modelNotificationSettings3 == null || !modelNotificationSettings3.isSuppressEveryone();
            }
        }
        return false;
    }

    @Store3
    private final boolean isMentionableChannel(long channelId) {
        StoreMessageAck.Ack ack = this.storeMessageAck.getAllInternal().get(Long.valueOf(channelId));
        boolean zIsLockedAck = ack != null ? ack.isLockedAck() : false;
        if (channelId == this.selectedChannelId && !zIsLockedAck) {
            return false;
        }
        return this.privateChannels.contains(Long.valueOf(channelId)) || PermissionUtils.can(Permission.VIEW_CHANNEL, this.storePermissions.getPermissionsByChannel().get(Long.valueOf(channelId)));
    }

    @Store3
    private final void removeAllMessagesForChannel(long channelId) {
        HashMap<Long, Message> map = this.mentionedMessages;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Message> entry : map.entrySet()) {
            if (entry.getValue().getChannelId() == channelId) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            this.mentionedMessages.remove(Long.valueOf(((Number) it.next()).longValue()));
            markChanged();
        }
    }

    public final Map<Long, Integer> getMentionCounts() {
        return this.countsSnapshot;
    }

    @Store3
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channelGuildIds.put(Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()));
        if (!ChannelUtils.B(channel) || ChannelUtils.y(channel)) {
            return;
        }
        this.privateChannels.add(Long.valueOf(channel.getId()));
    }

    @Store3
    public final void handleChannelOrThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channelGuildIds.remove(Long.valueOf(channel.getId()));
        this.privateChannels.remove(Long.valueOf(channel.getId()));
        removeAllMessagesForChannel(channel.getId());
    }

    @Store3
    public final void handleChannelSelected(long selectedChannelId) {
        this.selectedChannelId = selectedChannelId;
        markChanged();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.privateChannels.clear();
        this.mentionedMessages.clear();
        this.channelGuildIds.clear();
        this.myRoleIds.clear();
        this.myId = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            handleGuildAdd(guild);
        }
        HashSet<Long> hashSet = this.privateChannels;
        List<Channel> privateChannels = payload.getPrivateChannels();
        ArrayList arrayListA0 = outline.a0(privateChannels, "payload.privateChannels");
        for (Object obj : privateChannels) {
            Intrinsics3.checkNotNullExpressionValue((Channel) obj, "it");
            if (!ChannelUtils.y(r4)) {
                arrayListA0.add(obj);
            }
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayListA0, 10));
        Iterator it = arrayListA0.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Channel) it.next()).getId()));
        }
        hashSet.addAll(arrayList);
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState, "payload.readState");
        if (readState.isPartial()) {
            ModelPayload.VersionedReadStates readState2 = payload.getReadState();
            Intrinsics3.checkNotNullExpressionValue(readState2, "payload.readState");
            List<ModelReadState> entries = readState2.getEntries();
            Intrinsics3.checkNotNullExpressionValue(entries, "payload.readState.entries");
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(entries, 10));
            Iterator<T> it2 = entries.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Long.valueOf(((ModelReadState) it2.next()).getChannelId()));
            }
            MutableCollections.removeAll((List) this.serverInitReadStates, (Function1) new AnonymousClass3(_Collections.toHashSet(arrayList2)));
        } else {
            this.serverInitReadStates.clear();
        }
        ArrayList<ModelReadState> arrayList3 = this.serverInitReadStates;
        ModelPayload.VersionedReadStates readState3 = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState3, "payload.readState");
        List<ModelReadState> entries2 = readState3.getEntries();
        Intrinsics3.checkNotNullExpressionValue(entries2, "payload.readState.entries");
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : entries2) {
            if (((ModelReadState) obj2).isMentioned()) {
                arrayList4.add(obj2);
            }
        }
        arrayList3.addAll(arrayList4);
        MutableCollections.removeAll((List) this.serverInitReadStates, (Function1) new AnonymousClass5());
        markChanged();
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Object next;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<GuildMember> listV = guild.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((GuildMember) next).getUser().getId() == this.myId) {
                        break;
                    }
                }
            }
            GuildMember guildMember = (GuildMember) next;
            if (guildMember != null) {
                this.myRoleIds.put(Long.valueOf(guild.getId()), guildMember.l());
            }
        }
        List<Channel> listG = guild.g();
        if (listG != null) {
            Iterator<T> it2 = listG.iterator();
            while (it2.hasNext()) {
                this.channelGuildIds.put(Long.valueOf(((Channel) it2.next()).getId()), Long.valueOf(guild.getId()));
            }
        }
        List<Channel> listN = guild.N();
        if (listN != null) {
            Iterator<T> it3 = listN.iterator();
            while (it3.hasNext()) {
                this.channelGuildIds.put(Long.valueOf(((Channel) it3.next()).getId()), Long.valueOf(guild.getId()));
            }
        }
    }

    @Store3
    public final void handleGuildMemberAdd(GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        long id2 = member.getUser().getId();
        if (id2 == this.myId) {
            this.myRoleIds.put(Long.valueOf(id2), member.l());
        }
    }

    @Store3
    public final void handleMessageAck(ModelReadState readState) {
        Intrinsics3.checkNotNullParameter(readState, "readState");
        MutableCollections.removeAll((List) this.serverInitReadStates, (Function1) new AnonymousClass1(readState));
        this.serverInitReadStates.add(readState);
        markChanged();
    }

    @Store3
    public final void handleMessageCreateOrUpdate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (hasMention(message)) {
            this.mentionedMessages.put(Long.valueOf(message.getId()), new Message(message));
            markChanged();
        }
    }

    @Store3
    public final void handleMessageDeleted(ModelMessageDelete messageDeleteBulk) {
        Intrinsics3.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        if (this.privateChannels.contains(Long.valueOf(messageDeleteBulk.getChannelId()))) {
            List<Long> messageIds = messageDeleteBulk.getMessageIds();
            Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
            for (Long l : messageIds) {
                HashMap<Long, Message> map = this.mentionedMessages;
                Intrinsics3.checkNotNullExpressionValue(l, "it");
                map.remove(l);
            }
            markChanged();
        }
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        Iterator<Channel> it = payload.getThreads().iterator();
        while (it.hasNext()) {
            this.channelGuildIds.put(Long.valueOf(it.next().getId()), Long.valueOf(payload.getGuildId()));
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Long> listD = payload.d();
        if (listD == null || !listD.contains(Long.valueOf(this.myId))) {
            return;
        }
        removeAllMessagesForChannel(payload.getId());
    }

    public final Observable<Map<Long, Integer>> observeMentionCounts() {
        Observable<Map<Long, Integer>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeTotalMentions() {
        Observable observableG = observeMentionCounts().G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "observeMentionCounts()\n … .map { it.values.sum() }");
        return observableG;
    }

    @Store3
    public final int processMarkUnread$app_productionGoogleRelease(long channelId, List<Message> messagesAfter) {
        Intrinsics3.checkNotNullParameter(messagesAfter, "messagesAfter");
        int i = 0;
        for (Message message : messagesAfter) {
            if (!this.mentionedMessages.containsKey(Long.valueOf(message.getId())) && hasMention(message)) {
                this.mentionedMessages.put(Long.valueOf(message.getId()), message);
                i++;
            }
        }
        MutableCollections.removeAll((List) this.serverInitReadStates, (Function1) new StoreMentions2(channelId));
        markChanged();
        return i;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Integer> mapComputeMentionCounts = computeMentionCounts();
        Persister.set$default(this.countsCache, mapComputeMentionCounts, false, 2, null);
        this.countsSnapshot = mapComputeMentionCounts;
    }

    public StoreMentions(StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessageAck storeMessageAck, StoreUserGuildSettings storeUserGuildSettings, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeUserRelationships = storeUserRelationships;
        this.storePermissions = storePermissions;
        this.storeMessageAck = storeMessageAck;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.storeChannels = storeChannels;
        this.storeThreadsJoined = storeThreadsJoined;
        this.observationDeck = observationDeck;
        HashMap map = new HashMap();
        this.countsEmpty = map;
        this.countsCache = new Persister<>("CHANNEL_MENTION_COUNTS_V6", map);
        this.countsSnapshot = Maps6.emptyMap();
        this.serverInitReadStates = new ArrayList<>();
        this.mentionedMessages = new HashMap<>();
        this.privateChannels = new HashSet<>();
        this.myRoleIds = new HashMap<>();
        this.channelGuildIds = new HashMap<>();
    }

    @Store3
    private final boolean hasMention(Message message) {
        return hasMention(message.getChannelId(), message.getAuthor(), message.getEditedTimestamp(), message.getMentions(), message.getMentionRoles(), message.getMentionEveryone());
    }

    @Store3
    private final boolean hasMention(com.discord.api.message.Message message) {
        return hasMention(message.getChannelId(), message.getAuthor(), message.getEditedTimestamp(), message.t(), message.s(), message.getMentionEveryone());
    }
}
