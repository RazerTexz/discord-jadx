package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.Tuples;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;

/* compiled from: StoreMessageAck.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 i2\u00020\u0001:\u0003jikB'\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010e\u001a\u00020d¢\u0006\u0004\bg\u0010hJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ5\u0010\u000f\u001a(\u0012$\u0012\"\u0012\u000e\u0012\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f\u0012\u000e\u0012\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f0\u000b0\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0015\u001a\u00020\u00072\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f2\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\fH\u0003¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u00072\n\u0010\u0017\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0003¢\u0006\u0004\b\u001a\u0010\u001bJW\u0010#\u001a\u0004\u0018\u00010\"2\n\u0010\u0017\u001a\u00060\rj\u0002`\u000e2\u0016\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u001d0\u001c2\u0016\u0010\u001f\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020 H\u0003¢\u0006\u0004\b#\u0010$J#\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\n2\n\u0010\u0017\u001a\u00060\rj\u0002`\u000eH\u0002¢\u0006\u0004\b%\u0010&J3\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\n*\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010)J#\u0010,\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020'0\n2\b\b\u0002\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u001d\u0010.\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00180\u001c¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00180\u001cH\u0007¢\u0006\u0004\b0\u0010/J#\u00101\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00180\u001c0\n¢\u0006\u0004\b1\u0010\u0010J\u001b\u00102\u001a\u0004\u0018\u00010\u00182\n\u0010\u0017\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b2\u00103J!\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\n2\n\u0010\u0017\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b4\u0010&J+\u00105\u001a\u00020\u00072\n\u0010\u0017\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b5\u00106J%\u00109\u001a\u00020\u00072\n\u0010\u0017\u001a\u00060\rj\u0002`\u000e2\n\u00108\u001a\u00060\rj\u0002`7¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020?H\u0007¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0007H\u0007¢\u0006\u0004\bC\u0010\u0012J\u000f\u0010D\u001a\u00020\u0007H\u0007¢\u0006\u0004\bD\u0010\u0012J\u0017\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020EH\u0007¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020KH\u0007¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0007H\u0007¢\u0006\u0004\bO\u0010\u0012J\u000f\u0010P\u001a\u00020\u0007H\u0016¢\u0006\u0004\bP\u0010\u0012R\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR&\u0010X\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00180W8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R,\u0010a\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00180\u001c0`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR&\u0010c\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00180\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010YR\u0016\u0010e\u001a\u00020d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010f¨\u0006l"}, d2 = {"Lcom/discord/stores/StoreMessageAck;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/channel/Channel;", "channel", "", "isLockedAck", "clearLock", "", "internalAck", "(Lcom/discord/api/channel/Channel;ZZ)V", "Lrx/Observable;", "Lkotlin/Pair;", "", "", "Lcom/discord/primitives/ChannelId;", "observeActiveThreadIdsWithPrevious", "()Lrx/Observable;", "pruneAcks", "()V", "oldThreadIds", "newThreadIds", "updateThreadAcks", "(Ljava/util/Set;Ljava/util/Set;)V", "channelId", "Lcom/discord/stores/StoreMessageAck$Ack;", "ackNewer", "updateAcks", "(JLcom/discord/stores/StoreMessageAck$Ack;)V", "", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "activeAndJoinedThreads", "activeForumThreads", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "getThreadAckStateInternal", "(JLjava/util/Map;Ljava/util/Map;Lcom/discord/stores/StoreChannels;)Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "observeThreadAckState", "(J)Lrx/Observable;", "Lcom/discord/stores/StoreMessageAck$PendingAck;", "getPendingAck", "(Lrx/Observable;ZZ)Lrx/Observable;", "", "mentionCount", "postPendingAck", "(Lrx/Observable;I)V", "getAll", "()Ljava/util/Map;", "getAllInternal", "observeAll", "getForChannel", "(J)Lcom/discord/stores/StoreMessageAck$Ack;", "observeForChannel", "ack", "(JZZ)V", "Lcom/discord/primitives/MessageId;", "messageId", "markUnread", "(JJ)V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handlePreLogout", "handleGuildCreate", "Lcom/discord/api/message/Message;", "message", "handleMessageCreate", "(Lcom/discord/api/message/Message;)V", "handleThreadCreateOrUpdate", "(Lcom/discord/api/channel/Channel;)V", "Lcom/discord/models/domain/ModelReadState;", "readState", "handleMessageAck", "(Lcom/discord/models/domain/ModelReadState;)V", "handleChannelSelected", "snapshotData", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lrx/Subscription;", "threadSyncSubscription", "Lrx/Subscription;", "", "acks", "Ljava/util/Map;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/utilities/persister/Persister;", "acksPersister", "Lcom/discord/utilities/persister/Persister;", "acksSnapshot", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;)V", "Companion", "Ack", "PendingAck", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMessageAck extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<Long, Ack> acks;
    private final Persister<Map<Long, Ack>> acksPersister;
    private Map<Long, Ack> acksSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreStream stream;
    private Subscription threadSyncSubscription;

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dB#\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010 J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ2\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\f\u0010\bR\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001b\u0010\b¨\u0006!"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Ack;", "", "", "Lcom/discord/primitives/MessageId;", "component1", "()J", "", "component2", "()Z", "component3", "messageId", "viewed", "isLockedAck", "copy", "(JZZ)Lcom/discord/stores/StoreMessageAck$Ack;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "J", "getMessageId", "getViewed", "<init>", "(JZZ)V", "Lcom/discord/models/domain/ModelReadState;", "readState", "(Lcom/discord/models/domain/ModelReadState;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Ack {
        private final boolean isLockedAck;
        private final long messageId;
        private final boolean viewed;

        public Ack(long j, boolean z2, boolean z3) {
            this.messageId = j;
            this.viewed = z2;
            this.isLockedAck = z3;
        }

        public static /* synthetic */ Ack copy$default(Ack ack, long j, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = ack.messageId;
            }
            if ((i & 2) != 0) {
                z2 = ack.viewed;
            }
            if ((i & 4) != 0) {
                z3 = ack.isLockedAck;
            }
            return ack.copy(j, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getViewed() {
            return this.viewed;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsLockedAck() {
            return this.isLockedAck;
        }

        public final Ack copy(long messageId, boolean viewed, boolean isLockedAck) {
            return new Ack(messageId, viewed, isLockedAck);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ack)) {
                return false;
            }
            Ack ack = (Ack) other;
            return this.messageId == ack.messageId && this.viewed == ack.viewed && this.isLockedAck == ack.isLockedAck;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public final boolean getViewed() {
            return this.viewed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.messageId) * 31;
            boolean z2 = this.viewed;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iA + i) * 31;
            boolean z3 = this.isLockedAck;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isLockedAck() {
            return this.isLockedAck;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Ack(messageId=");
            sbU.append(this.messageId);
            sbU.append(", viewed=");
            sbU.append(this.viewed);
            sbU.append(", isLockedAck=");
            return outline.O(sbU, this.isLockedAck, ")");
        }

        public Ack(ModelReadState modelReadState, boolean z2, boolean z3) {
            this(modelReadState != null ? modelReadState.getLastMessageId() : 0L, z2, z3);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u0003*\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0003*\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Companion;", "", "Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "", "isThreadAndUnableToAck", "(Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;)Z", "isThreadAndAbleToAck", "isNonThreadChannel", "<init>", "()V", "ThreadAckState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "", "<init>", "()V", "NotThread", "Thread", "Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState$Thread;", "Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState$NotThread;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static abstract class ThreadAckState {

            /* compiled from: StoreMessageAck.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState$NotThread;", "Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final class NotThread extends ThreadAckState {
                public static final NotThread INSTANCE = new NotThread();

                private NotThread() {
                    super(null);
                }
            }

            /* compiled from: StoreMessageAck.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState$Thread;", "Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "", "component1", "()Z", "canAckThread", "copy", "(Z)Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState$Thread;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanAckThread", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class Thread extends ThreadAckState {
                private final boolean canAckThread;

                public Thread(boolean z2) {
                    super(null);
                    this.canAckThread = z2;
                }

                public static /* synthetic */ Thread copy$default(Thread thread, boolean z2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z2 = thread.canAckThread;
                    }
                    return thread.copy(z2);
                }

                /* renamed from: component1, reason: from getter */
                public final boolean getCanAckThread() {
                    return this.canAckThread;
                }

                public final Thread copy(boolean canAckThread) {
                    return new Thread(canAckThread);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof Thread) && this.canAckThread == ((Thread) other).canAckThread;
                    }
                    return true;
                }

                public final boolean getCanAckThread() {
                    return this.canAckThread;
                }

                public int hashCode() {
                    boolean z2 = this.canAckThread;
                    if (z2) {
                        return 1;
                    }
                    return z2 ? 1 : 0;
                }

                public String toString() {
                    return outline.O(outline.U("Thread(canAckThread="), this.canAckThread, ")");
                }
            }

            private ThreadAckState() {
            }

            public /* synthetic */ ThreadAckState(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        public final boolean isNonThreadChannel(ThreadAckState threadAckState) {
            return threadAckState instanceof ThreadAckState.NotThread;
        }

        public final boolean isThreadAndAbleToAck(ThreadAckState threadAckState) {
            return (threadAckState instanceof ThreadAckState.Thread) && ((ThreadAckState.Thread) threadAckState).getCanAckThread();
        }

        public final boolean isThreadAndUnableToAck(ThreadAckState threadAckState) {
            return (threadAckState instanceof ThreadAckState.Thread) && !((ThreadAckState.Thread) threadAckState).getCanAckThread();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/discord/stores/StoreMessageAck$PendingAck;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/stores/StoreMessageAck$Ack;", "component2", "()Lcom/discord/stores/StoreMessageAck$Ack;", "channelId", "ack", "copy", "(JLcom/discord/stores/StoreMessageAck$Ack;)Lcom/discord/stores/StoreMessageAck$PendingAck;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreMessageAck$Ack;", "getAck", "J", "getChannelId", "<init>", "(JLcom/discord/stores/StoreMessageAck$Ack;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PendingAck {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final PendingAck EMPTY = new PendingAck(0, new Ack(0L, false, false));
        private final Ack ack;
        private final long channelId;

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreMessageAck$PendingAck$Companion;", "", "Lcom/discord/stores/StoreMessageAck$PendingAck;", "EMPTY", "Lcom/discord/stores/StoreMessageAck$PendingAck;", "getEMPTY", "()Lcom/discord/stores/StoreMessageAck$PendingAck;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final PendingAck getEMPTY() {
                return PendingAck.access$getEMPTY$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public PendingAck(long j, Ack ack) {
            Intrinsics3.checkNotNullParameter(ack, "ack");
            this.channelId = j;
            this.ack = ack;
        }

        public static final /* synthetic */ PendingAck access$getEMPTY$cp() {
            return EMPTY;
        }

        public static /* synthetic */ PendingAck copy$default(PendingAck pendingAck, long j, Ack ack, int i, Object obj) {
            if ((i & 1) != 0) {
                j = pendingAck.channelId;
            }
            if ((i & 2) != 0) {
                ack = pendingAck.ack;
            }
            return pendingAck.copy(j, ack);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final Ack getAck() {
            return this.ack;
        }

        public final PendingAck copy(long channelId, Ack ack) {
            Intrinsics3.checkNotNullParameter(ack, "ack");
            return new PendingAck(channelId, ack);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingAck)) {
                return false;
            }
            PendingAck pendingAck = (PendingAck) other;
            return this.channelId == pendingAck.channelId && Intrinsics3.areEqual(this.ack, pendingAck.ack);
        }

        public final Ack getAck() {
            return this.ack;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            Ack ack = this.ack;
            return iA + (ack != null ? ack.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("PendingAck(channelId=");
            sbU.append(this.channelId);
            sbU.append(", ack=");
            sbU.append(this.ack);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$ack$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $clearLock;
        public final /* synthetic */ boolean $isLockedAck;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2, boolean z3) {
            super(0);
            this.$channelId = j;
            this.$isLockedAck = z2;
            this.$clearLock = z3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreMessageAck.access$getStream$p(StoreMessageAck.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                if (channelFindChannelByIdInternal$app_productionGoogleRelease.getType() != 4) {
                    StoreMessageAck.access$internalAck(StoreMessageAck.this, channelFindChannelByIdInternal$app_productionGoogleRelease, this.$isLockedAck, this.$clearLock);
                    return;
                }
                Iterator<T> it = StoreMessageAck.access$getStream$p(StoreMessageAck.this).getChannels().findChannelsByCategoryInternal$app_productionGoogleRelease(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getId()).iterator();
                while (it.hasNext()) {
                    StoreMessageAck.access$internalAck(StoreMessageAck.this, (Channel) it.next(), this.$isLockedAck, this.$clearLock);
                }
            }
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Ack;", "currentAck", "", "Lcom/discord/primitives/MessageId;", "mostRecentMessageId", "", "invoke", "(Lcom/discord/stores/StoreMessageAck$Ack;J)Z", "isUpdateRequired"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$getPendingAck$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Ack, Long, Boolean> {
        public final /* synthetic */ boolean $clearLock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(2);
            this.$clearLock = z2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(Ack ack, Long l) {
            return Boolean.valueOf(invoke(ack, l.longValue()));
        }

        public final boolean invoke(Ack ack, long j) {
            boolean zIsNewer = MessageUtils.isNewer(ack != null ? Long.valueOf(ack.getMessageId()) : null, Long.valueOf(j));
            boolean z2 = ack == null || !ack.isLockedAck();
            if (zIsNewer) {
                return this.$clearLock || z2;
            }
            return false;
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "channelId", "Lrx/Observable;", "Lcom/discord/stores/StoreMessageAck$PendingAck;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$getPendingAck$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Long, Observable<? extends PendingAck>> {
        public final /* synthetic */ boolean $isLockedAck;
        public final /* synthetic */ AnonymousClass1 $isUpdateRequired$1;

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\b0\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0018\u0010\u0005\u001a\u0014 \u0004*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Ack;", "ack", "", "Lcom/discord/primitives/MessageId;", "kotlin.jvm.PlatformType", "mostRecentMessageId", "Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "threadAckState", "Lcom/discord/stores/StoreMessageAck$PendingAck;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMessageAck$Ack;Ljava/lang/Long;Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;)Lcom/discord/stores/StoreMessageAck$PendingAck;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageAck$getPendingAck$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Ack, Long, Companion.ThreadAckState, PendingAck> {
            public final /* synthetic */ Long $channelId;

            public AnonymousClass1(Long l) {
                this.$channelId = l;
            }

            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ PendingAck call(Ack ack, Long l, Companion.ThreadAckState threadAckState) {
                return call2(ack, l, threadAckState);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
            
                if (r8.invoke(r6, r7.longValue()) != false) goto L14;
             */
            /* renamed from: call, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final PendingAck call2(Ack ack, Long l, Companion.ThreadAckState threadAckState) {
                Companion companion = StoreMessageAck.INSTANCE;
                if (companion.isNonThreadChannel(threadAckState) || companion.isThreadAndAbleToAck(threadAckState)) {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    if (!anonymousClass2.$isLockedAck) {
                        AnonymousClass1 anonymousClass1 = anonymousClass2.$isUpdateRequired$1;
                        Intrinsics3.checkNotNullExpressionValue(l, "mostRecentMessageId");
                    }
                    Long l2 = this.$channelId;
                    Intrinsics3.checkNotNullExpressionValue(l2, "channelId");
                    long jLongValue = l2.longValue();
                    Intrinsics3.checkNotNullExpressionValue(l, "mostRecentMessageId");
                    return new PendingAck(jLongValue, new Ack(l.longValue(), true, AnonymousClass2.this.$isLockedAck));
                }
                return PendingAck.INSTANCE.getEMPTY();
            }
        }

        public AnonymousClass2(boolean z2, AnonymousClass1 anonymousClass1) {
            this.$isLockedAck = z2;
            this.$isUpdateRequired$1 = anonymousClass1;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends PendingAck> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends PendingAck> call2(Long l) {
            if (l.longValue() <= 0) {
                return new ScalarSynchronousObservable(PendingAck.INSTANCE.getEMPTY());
            }
            StoreMessageAck messageAck = StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessageAck();
            Intrinsics3.checkNotNullExpressionValue(l, "channelId");
            return Observable.i(messageAck.observeForChannel(l.longValue()), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessagesMostRecent().observeRecentMessageIds(l.longValue()), StoreMessageAck.access$observeThreadAckState(StoreMessageAck.this, l.longValue()), new AnonymousClass1(l));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreMessageAck.access$setThreadSyncSubscription$p(StoreMessageAck.this, subscription);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "", "", "Lcom/discord/primitives/ChannelId;", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Set $newThreadIds;
            public final /* synthetic */ Set $oldThreadIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Set set, Set set2) {
                super(0);
                this.$oldThreadIds = set;
                this.$newThreadIds = set2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageAck.access$updateThreadAcks(StoreMessageAck.this, this.$oldThreadIds, this.$newThreadIds);
            }
        }

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> tuples2) {
            invoke2((Tuples2<? extends Set<Long>, ? extends Set<Long>>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends Set<Long>, ? extends Set<Long>> tuples2) {
            Intrinsics3.checkNotNullParameter(tuples2, "<name for destructuring parameter 0>");
            StoreMessageAck.access$getDispatcher$p(StoreMessageAck.this).schedule(new AnonymousClass1(tuples2.component1(), tuples2.component2()));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a>\u0012\u0018\b\u0001\u0012\u0014 \u0001*\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\u0004j\u0002`\u0005 \u0001*\u001e\u0012\u0018\b\u0001\u0012\u0014 \u0001*\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\u0004j\u0002`\u0005\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "kotlin.jvm.PlatformType", "selectedChannel", "Lrx/Observable;", "", "Lcom/discord/primitives/ChannelId;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends Long>> {

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageAck$init$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01511<T, R> implements Func1<StoreMessagesLoader.ChannelLoadedState, Boolean> {
            public static final C01511 INSTANCE = new C01511();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                return call2(channelLoadedState);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                return Boolean.valueOf(channelLoadedState.isInitialMessagesLoaded() && !channelLoadedState.isLoadingMessages());
            }
        }

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreChat$InteractionState;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreChat$InteractionState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageAck$init$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<StoreChat.InteractionState, Boolean> {
            public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

            public AnonymousClass2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                this.$selectedChannel = resolvedSelectedChannel;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(StoreChat.InteractionState interactionState) {
                return call2(interactionState);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(StoreChat.InteractionState interactionState) {
                return Boolean.valueOf(interactionState.getChannelId() == this.$selectedChannel.getId());
            }
        }

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\r\u001a\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u00022\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "detachedChannels", "", "isLoadingSettled", "Lcom/discord/stores/StoreChat$InteractionState;", "interactionState", "Lcom/discord/stores/StoreMessageAck$Ack;", "existingAck", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;Ljava/lang/Boolean;Lcom/discord/stores/StoreChat$InteractionState;Lcom/discord/stores/StoreMessageAck$Ack;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageAck$init$1$3, reason: invalid class name */
        public static final class AnonymousClass3<T1, T2, T3, T4, R> implements Func4<Set<? extends Long>, Boolean, StoreChat.InteractionState, Ack, Long> {
            public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

            public AnonymousClass3(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                this.$selectedChannel = resolvedSelectedChannel;
            }

            @Override // rx.functions.Func4
            public /* bridge */ /* synthetic */ Long call(Set<? extends Long> set, Boolean bool, StoreChat.InteractionState interactionState, Ack ack) {
                return call2((Set<Long>) set, bool, interactionState, ack);
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
            /* renamed from: call, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Long call2(Set<Long> set, Boolean bool, StoreChat.InteractionState interactionState, Ack ack) {
                long channelId;
                Channel maybeChannel = this.$selectedChannel.getMaybeChannel();
                boolean z2 = maybeChannel != null && ChannelUtils.o(maybeChannel);
                if (interactionState.isAtBottomIgnoringTouch()) {
                    Intrinsics3.checkNotNullExpressionValue(bool, "isLoadingSettled");
                    channelId = (!bool.booleanValue() || set.contains(Long.valueOf(interactionState.getChannelId())) || z2 || (ack != null && ack.isLockedAck())) ? 0L : interactionState.getChannelId();
                }
                return Long.valueOf(channelId);
            }
        }

        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Long> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            return call2(resolvedSelectedChannel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Long> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            return Observable.h(StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessages().getAllDetached().p(50L, TimeUnit.MILLISECONDS), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessagesLoader().getMessagesLoadedState(resolvedSelectedChannel.getId()).G(C01511.INSTANCE).r(), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getChat().observeInteractionState().y(new AnonymousClass2(resolvedSelectedChannel)), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessageAck().observeForChannel(resolvedSelectedChannel.getId()), new AnonymousClass3(resolvedSelectedChannel));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$markUnread$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends Message>, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list) {
            return call2((List<Message>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<Message> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            return Boolean.valueOf(!list.isEmpty());
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a^\u0012 \u0012\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0003*.\u0012 \u0012\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00070\u00072\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "kotlin.jvm.PlatformType", "channelMessages", "Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "threadState", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$markUnread$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<? extends Message>, Companion.ThreadAckState, Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState> call(List<? extends Message> list, Companion.ThreadAckState threadAckState) {
            return call2((List<Message>) list, threadAckState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<List<Message>, Companion.ThreadAckState> call2(List<Message> list, Companion.ThreadAckState threadAckState) {
            return new Tuples2<>(list, threadAckState);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072b\u0010\u0006\u001a^\u0012 \u0012\u001e\u0012\b\u0012\u00060\u0002j\u0002`\u0003 \u0004*\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0004*.\u0012 \u0012\u001e\u0012\b\u0012\u00060\u0002j\u0002`\u0003 \u0004*\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/Pair;", "", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "kotlin.jvm.PlatformType", "Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$markUnread$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState>, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageAck$markUnread$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $channelMessages;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$channelMessages = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object obj;
                List list = this.$channelMessages;
                ArrayList arrayListA0 = outline.a0(list, "channelMessages");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((Message) next).getId() < AnonymousClass3.this.$messageId) {
                        arrayListA0.add(next);
                    }
                }
                Iterator it2 = arrayListA0.iterator();
                if (it2.hasNext()) {
                    Object next2 = it2.next();
                    if (it2.hasNext()) {
                        long id2 = ((Message) next2).getId();
                        do {
                            Object next3 = it2.next();
                            long id3 = ((Message) next3).getId();
                            if (id2 < id3) {
                                next2 = next3;
                                id2 = id3;
                            }
                        } while (it2.hasNext());
                    }
                    obj = next2;
                } else {
                    obj = null;
                }
                Message message = (Message) obj;
                List list2 = this.$channelMessages;
                ArrayList arrayListA02 = outline.a0(list2, "channelMessages");
                for (Object obj2 : list2) {
                    if (((Message) obj2).getId() >= AnonymousClass3.this.$messageId) {
                        arrayListA02.add(obj2);
                    }
                }
                Ack ack = new Ack(message != null ? message.getId() : (((AnonymousClass3.this.$messageId >>> 22) - 1) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, true);
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreMessageAck.access$updateAcks(StoreMessageAck.this, anonymousClass3.$channelId, ack);
                int iProcessMarkUnread$app_productionGoogleRelease = StoreStream.INSTANCE.getMentions().processMarkUnread$app_productionGoogleRelease(AnonymousClass3.this.$channelId, arrayListA02);
                StoreMessageAck storeMessageAck = StoreMessageAck.this;
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new PendingAck(AnonymousClass3.this.$channelId, ack));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(PendingAck(channelId, ack))");
                StoreMessageAck.access$postPendingAck(storeMessageAck, scalarSynchronousObservable, iProcessMarkUnread$app_productionGoogleRelease);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j, long j2) {
            super(1);
            this.$messageId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState> tuples2) {
            invoke2((Tuples2<? extends List<Message>, ? extends Companion.ThreadAckState>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends List<Message>, ? extends Companion.ThreadAckState> tuples2) {
            List<Message> listComponent1 = tuples2.component1();
            if (StoreMessageAck.INSTANCE.isThreadAndUnableToAck(tuples2.component2())) {
                return;
            }
            StoreMessageAck.access$getDispatcher$p(StoreMessageAck.this).schedule(new AnonymousClass1(listComponent1));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\u0010\u000b\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0004*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\b0\b2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0006 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "kotlin.jvm.PlatformType", "activeJoinedThreads", "Lcom/discord/api/channel/Channel;", "activeForumThreads", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$observeActiveThreadIdsWithPrevious$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Map<Long, ? extends Channel>, Set<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map, Map<Long, ? extends Channel> map2) {
            return call2((Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map, (Map<Long, Channel>) map2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Set<Long> call2(Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map, Map<Long, Channel> map2) {
            return _Sets.plus((Set) map.keySet(), (Iterable) map2.keySet());
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\t\u001aJ\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001 \u0004*$\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001\u0018\u00010\u00000\u00002N\u0010\u0005\u001aJ\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001 \u0004*$\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001\u0018\u00010\u00000\u00002\"\u0010\u0006\u001a\u001e\u0012\b\u0012\u00060\u0002j\u0002`\u0003 \u0004*\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Pair;", "", "", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "accumulator", "threadIds", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;Ljava/util/Set;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$observeActiveThreadIdsWithPrevious$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Set<? extends Long>, Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> call(Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> tuples2, Set<? extends Long> set) {
            return call2((Tuples2<? extends Set<Long>, ? extends Set<Long>>) tuples2, (Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<Set<Long>, Set<Long>> call2(Tuples2<? extends Set<Long>, ? extends Set<Long>> tuples2, Set<Long> set) {
            return new Tuples2<>(tuples2.getSecond(), set);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreMessageAck$Ack;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$observeAll$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Ack>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Ack> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Ack> invoke2() {
            return StoreMessageAck.this.getAll();
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Ack;", "invoke", "()Lcom/discord/stores/StoreMessageAck$Ack;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$observeForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Ack> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Ack invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Ack invoke() {
            return StoreMessageAck.this.getForChannel(this.$channelId);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "invoke", "()Lcom/discord/stores/StoreMessageAck$Companion$ThreadAckState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$observeThreadAckState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Companion.ThreadAckState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Companion.ThreadAckState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Companion.ThreadAckState invoke() {
            StoreMessageAck storeMessageAck = StoreMessageAck.this;
            return StoreMessageAck.getThreadAckStateInternal$default(storeMessageAck, this.$channelId, StoreMessageAck.access$getStream$p(storeMessageAck).getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease(), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease(), null, 8, null);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreMessageAck$PendingAck;", "pendingAck", "", "invoke", "(Lcom/discord/stores/StoreMessageAck$PendingAck;)V", "postChannelMessagesAck"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<PendingAck, Unit> {
        public final /* synthetic */ int $mentionCount;

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01521 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Ack $ack;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01521(long j, Ack ack) {
                super(0);
                this.$channelId = j;
                this.$ack = ack;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageAck.access$updateAcks(StoreMessageAck.this, this.$channelId, this.$ack);
            }
        }

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T> implements Action1<Void> {
            public final /* synthetic */ long $channelId;

            public AnonymousClass2(long j) {
                this.$channelId = j;
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Void r1) {
                call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r3) {
                StoreStream.INSTANCE.getAnalytics().ackMessage(this.$channelId);
            }
        }

        /* compiled from: StoreMessageAck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$mentionCount = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PendingAck pendingAck) {
            invoke2(pendingAck);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PendingAck pendingAck) {
            Intrinsics3.checkNotNullParameter(pendingAck, "pendingAck");
            long channelId = pendingAck.getChannelId();
            Ack ack = pendingAck.getAck();
            StoreMessageAck.access$getDispatcher$p(StoreMessageAck.this).schedule(new C01521(channelId, ack));
            Observable observableU = ObservableExtensionsKt.restSubscribeOn$default(StoreMessageAck.access$getRestAPI$p(StoreMessageAck.this).postChannelMessagesAck(channelId, Long.valueOf(ack.getMessageId()), new RestAPIParams.ChannelMessagesAck(Boolean.valueOf(ack.isLockedAck()), Integer.valueOf(this.$mentionCount))), false, 1, null).u(new AnonymousClass2(channelId));
            Intrinsics3.checkNotNullExpressionValue(observableU, "restAPI\n          .postC…).ackMessage(channelId) }");
            ObservableExtensionsKt.appSubscribe$default(observableU, (Context) null, "REST: ack", (Function1) null, AnonymousClass3.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreMessageAck$PendingAck;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMessageAck$PendingAck;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<PendingAck, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(PendingAck pendingAck) {
            return call2(pendingAck);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(PendingAck pendingAck) {
            return Boolean.valueOf(!Intrinsics3.areEqual(pendingAck, PendingAck.INSTANCE.getEMPTY()));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreMessageAck$PendingAck;", "p1", "", "invoke", "(Lcom/discord/stores/StoreMessageAck$PendingAck;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<PendingAck, Unit> {
        public final /* synthetic */ AnonymousClass1 $postChannelMessagesAck$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1) {
            super(1, null, "postChannelMessagesAck", "invoke(Lcom/discord/stores/StoreMessageAck$PendingAck;)V", 0);
            this.$postChannelMessagesAck$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PendingAck pendingAck) {
            invoke2(pendingAck);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PendingAck pendingAck) {
            Intrinsics3.checkNotNullParameter(pendingAck, "p1");
            this.$postChannelMessagesAck$1.invoke2(pendingAck);
        }
    }

    public StoreMessageAck(StoreStream storeStream, ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.stream = storeStream;
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        Persister<Map<Long, Ack>> persister = new Persister<>("MOST_RECENT_ACKS_V3", new HashMap());
        this.acksPersister = persister;
        this.acksSnapshot = persister.get();
        this.acks = new HashMap(this.acksSnapshot);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.restAPI;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.stream;
    }

    public static final /* synthetic */ Subscription access$getThreadSyncSubscription$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.threadSyncSubscription;
    }

    public static final /* synthetic */ void access$internalAck(StoreMessageAck storeMessageAck, Channel channel, boolean z2, boolean z3) {
        storeMessageAck.internalAck(channel, z2, z3);
    }

    public static final /* synthetic */ Observable access$observeThreadAckState(StoreMessageAck storeMessageAck, long j) {
        return storeMessageAck.observeThreadAckState(j);
    }

    public static final /* synthetic */ void access$postPendingAck(StoreMessageAck storeMessageAck, Observable observable, int i) {
        storeMessageAck.postPendingAck(observable, i);
    }

    public static final /* synthetic */ void access$setThreadSyncSubscription$p(StoreMessageAck storeMessageAck, Subscription subscription) {
        storeMessageAck.threadSyncSubscription = subscription;
    }

    public static final /* synthetic */ void access$updateAcks(StoreMessageAck storeMessageAck, long j, Ack ack) {
        storeMessageAck.updateAcks(j, ack);
    }

    public static final /* synthetic */ void access$updateThreadAcks(StoreMessageAck storeMessageAck, Set set, Set set2) {
        storeMessageAck.updateThreadAcks(set, set2);
    }

    public static /* synthetic */ void ack$default(StoreMessageAck storeMessageAck, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z3 = false;
        }
        storeMessageAck.ack(j, z2, z3);
    }

    private final Observable<PendingAck> getPendingAck(Observable<Long> observable, boolean z2, boolean z3) {
        Observable observableY = observable.Y(new AnonymousClass2(z2, new AnonymousClass1(z3)));
        Intrinsics3.checkNotNullExpressionValue(observableY, "switchMap { channelId ->…gAck.EMPTY)\n      }\n    }");
        return observableY;
    }

    @Store3
    private final Companion.ThreadAckState getThreadAckStateInternal(long channelId, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeAndJoinedThreads, Map<Long, Channel> activeForumThreads, StoreChannels storeChannels) {
        Channel channel = storeChannels.getChannel(channelId);
        if (channel != null) {
            return !ChannelUtils.H(channel) ? Companion.ThreadAckState.NotThread.INSTANCE : (activeAndJoinedThreads.containsKey(Long.valueOf(channelId)) || activeForumThreads.containsKey(Long.valueOf(channelId))) ? new Companion.ThreadAckState.Thread(true) : new Companion.ThreadAckState.Thread(false);
        }
        return null;
    }

    public static /* synthetic */ Companion.ThreadAckState getThreadAckStateInternal$default(StoreMessageAck storeMessageAck, long j, Map map, Map map2, StoreChannels storeChannels, int i, Object obj) {
        if ((i & 8) != 0) {
            storeChannels = storeMessageAck.stream.getChannels();
        }
        return storeMessageAck.getThreadAckStateInternal(j, map, map2, storeChannels);
    }

    private final void internalAck(Channel channel, boolean isLockedAck, boolean clearLock) {
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Long.valueOf(channel.getId()));
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(channel.id)");
        postPendingAck$default(this, ObservableExtensionsKt.takeSingleUntilTimeout$default(getPendingAck(scalarSynchronousObservable, isLockedAck, clearLock), 0L, false, 1, null), 0, 1, null);
    }

    private final Observable<Tuples2<Set<Long>, Set<Long>>> observeActiveThreadIdsWithPrevious() {
        Observable observableJ = Observable.j(this.stream.getThreadsActiveJoined().observeAllActiveJoinedThreadsById(), this.stream.getThreadsActive().observeAllActiveForumThreadsById(), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…veForumThreads.keys\n    }");
        Observable<Tuples2<Set<Long>, Set<Long>>> observableQ = ObservableExtensionsKt.leadingEdgeThrottle(observableJ, 1L, TimeUnit.SECONDS).r().Q(new Tuples2(Sets5.emptySet(), Sets5.emptySet()), AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableQ, "Observable.combineLatest…ond, threadIds)\n        }");
        return observableQ;
    }

    private final Observable<Companion.ThreadAckState> observeThreadAckState(long channelId) {
        Observable<Companion.ThreadAckState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getThreadsActiveJoined(), this.stream.getThreadsActive()}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    private final void postPendingAck(Observable<PendingAck> observable, int i) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i);
        Observable<PendingAck> observableY = observable.y(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "filter { it != PendingAck.EMPTY }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableY), observable.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(anonymousClass1), 62, (Object) null);
    }

    public static /* synthetic */ void postPendingAck$default(StoreMessageAck storeMessageAck, Observable observable, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        storeMessageAck.postPendingAck(observable, i);
    }

    @Store3
    private final void pruneAcks() {
        if (!this.stream.getGuilds().getUnavailableGuildsInternal$app_productionGoogleRelease().isEmpty()) {
            return;
        }
        Map<Long, Channel> channelsByIdInternal$app_productionGoogleRelease = this.stream.getChannels().getChannelsByIdInternal$app_productionGoogleRelease();
        Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeJoinedThreadsInternal$app_productionGoogleRelease = this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease();
        Map<Long, Channel> allForumThreadsByIdInternal$app_productionGoogleRelease = this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease();
        Iterator<Long> it = this.acks.keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (!channelsByIdInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) && !activeJoinedThreadsInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) && !allForumThreadsByIdInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue))) {
                it.remove();
                markChanged();
            }
        }
    }

    @Store3
    private final void updateAcks(long channelId, Ack ackNewer) {
        if (INSTANCE.isThreadAndUnableToAck(getThreadAckStateInternal$default(this, channelId, this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease(), this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease(), null, 8, null))) {
            return;
        }
        Ack ack = this.acks.get(Long.valueOf(channelId));
        if (ack == null || MessageUtils.compareMessages(Long.valueOf(ack.getMessageId()), Long.valueOf(ackNewer.getMessageId())) != 0 || (ackNewer.isLockedAck() && !ack.isLockedAck())) {
            this.acks.put(Long.valueOf(channelId), ackNewer);
            markChanged();
        }
    }

    @Store3
    private final void updateThreadAcks(Set<Long> oldThreadIds, Set<Long> newThreadIds) {
        Channel channel;
        UtcDateTime joinTimestamp;
        if (this.stream.getGuilds().getUnavailableGuildsInternal$app_productionGoogleRelease().isEmpty()) {
            Iterator it = _Sets.minus((Set) oldThreadIds, (Iterable) newThreadIds).iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                if (this.acks.containsKey(Long.valueOf(jLongValue)) && this.acks.remove(Long.valueOf(jLongValue)) != null) {
                    markChanged();
                }
            }
        }
        Map<Long, Long> guildsJoinedAtInternal$app_productionGoogleRelease = this.stream.getGuilds().getGuildsJoinedAtInternal$app_productionGoogleRelease();
        Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeJoinedThreadsInternal$app_productionGoogleRelease = this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease();
        Map<Long, Channel> allForumThreadsByIdInternal$app_productionGoogleRelease = this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease();
        Iterator it2 = _Sets.minus((Set) newThreadIds, (Iterable) oldThreadIds).iterator();
        while (it2.hasNext()) {
            long jLongValue2 = ((Number) it2.next()).longValue();
            if (!this.acks.containsKey(Long.valueOf(jLongValue2))) {
                if (INSTANCE.isThreadAndAbleToAck(getThreadAckStateInternal$default(this, jLongValue2, activeJoinedThreadsInternal$app_productionGoogleRelease, allForumThreadsByIdInternal$app_productionGoogleRelease, null, 8, null))) {
                    StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread = activeJoinedThreadsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue2));
                    if (activeJoinedThread == null || (channel = activeJoinedThread.getChannel()) == null) {
                        channel = allForumThreadsByIdInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue2));
                    }
                    Channel channel2 = channel;
                    if (channel2 != null) {
                        this.acks.put(Long.valueOf(jLongValue2), new Ack((ThreadUtils.getThreadAckMessageTimestamp$default(ThreadUtils.INSTANCE, channel2, (Long) outline.c(channel2, guildsJoinedAtInternal$app_productionGoogleRelease), (activeJoinedThread == null || (joinTimestamp = activeJoinedThread.getJoinTimestamp()) == null) ? null : Long.valueOf(joinTimestamp.getDateTimeMillis()), null, 4, null) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, false));
                        markChanged();
                    }
                }
            }
        }
    }

    public final void ack(long channelId, boolean isLockedAck, boolean clearLock) {
        this.dispatcher.schedule(new AnonymousClass1(channelId, isLockedAck, clearLock));
    }

    public final Map<Long, Ack> getAll() {
        return this.acksSnapshot;
    }

    @Store3
    public final Map<Long, Ack> getAllInternal() {
        return this.acks;
    }

    public final Ack getForChannel(long channelId) {
        return getAll().get(Long.valueOf(channelId));
    }

    @Store3
    public final void handleChannelSelected() {
        for (Map.Entry<Long, Ack> entry : this.acks.entrySet()) {
            this.acks.put(Long.valueOf(entry.getKey().longValue()), Ack.copy$default(entry.getValue(), 0L, false, false, 3, null));
        }
        markChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleConnectionOpen(ModelPayload payload) {
        long dateTimeMillis;
        Object next;
        UtcDateTime joinedAt;
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState, "payload.readState");
        if (!readState.isPartial()) {
            this.acks.clear();
        }
        Map<Long, Ack> map = this.acks;
        ModelPayload.VersionedReadStates readState2 = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState2, "payload.readState");
        List<ModelReadState> entries = readState2.getEntries();
        Intrinsics3.checkNotNullExpressionValue(entries, "payload.readState.entries");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(entries, 10)), 16));
        for (ModelReadState modelReadState : entries) {
            Tuples2 tuples2 = Tuples.to(Long.valueOf(modelReadState.getChannelId()), new Ack(modelReadState, false, false));
            linkedHashMap.put(tuples2.getFirst(), tuples2.getSecond());
        }
        map.putAll(linkedHashMap);
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<GuildMember> listV = guild.v();
            if (listV != null) {
                Iterator<T> it = listV.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((GuildMember) next).getUser().getId() == payload.getMe().getId()) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                GuildMember guildMember = (GuildMember) next;
                dateTimeMillis = (guildMember == null || (joinedAt = guildMember.getJoinedAt()) == null) ? 0L : joinedAt.getDateTimeMillis();
            }
            List<Channel> listG = guild.g();
            if (listG != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listG) {
                    Channel channel = (Channel) obj;
                    Intrinsics3.checkNotNullParameter(channel, "$this$isTextyOrVoiceChannel");
                    if ((ChannelUtils.v(channel) || ChannelUtils.J(channel)) && !this.acks.containsKey(Long.valueOf(channel.getId()))) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<Channel> arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if ((((Channel) obj2).getLastMessageId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH < dateTimeMillis) {
                        arrayList2.add(obj2);
                    }
                }
                for (Channel channel2 : arrayList2) {
                    this.acks.put(Long.valueOf(channel2.getId()), new Ack(channel2.getLastMessageId(), false, false));
                }
            }
        }
        pruneAcks();
        Subscription subscription = this.threadSyncSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observeActiveThreadIdsWithPrevious()), StoreMessageAck.class, (Context) null, new AnonymousClass3(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 58, (Object) null);
        markChanged();
    }

    @Store3
    public final void handleGuildCreate() {
        pruneAcks();
    }

    @Store3
    public final void handleMessageAck(ModelReadState readState) {
        Intrinsics3.checkNotNullParameter(readState, "readState");
        updateAcks(readState.getChannelId(), new Ack(readState, false, false));
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author == null || author.getId() != this.stream.getUsers().getMe().getId()) {
            return;
        }
        updateAcks(message.getChannelId(), new Ack(message.getId(), false, false));
    }

    @Store3
    public final void handlePreLogout() {
        Subscription subscription = this.threadSyncSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.threadSyncSubscription = null;
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Channel channelFindChannelById;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        boolean z2 = channel.getOwnerId() == this.stream.getUsers().getMe().getId();
        if (ChannelUtils.H(channel) && !ChannelUtils.j(channel) && z2 && (channelFindChannelById = this.stream.getChannels().findChannelById(channel.getParentId())) != null && ChannelUtils.q(channelFindChannelById)) {
            updateAcks(channelFindChannelById.getId(), new Ack(channel.getId(), false, false));
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Observable<R> observableY = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().r().Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get… 0L\n          }\n        }");
        Observable<Long> observableP = ObservableExtensionsKt.computationLatest(observableY).p(500L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "StoreStream\n        .get…0, TimeUnit.MILLISECONDS)");
        postPendingAck$default(this, getPendingAck(observableP, false, false), 0, 1, null);
    }

    public final void markUnread(long channelId, long messageId) {
        Observable observableJ = Observable.j(this.stream.getMessages().observeMessagesForChannel(channelId).y(AnonymousClass1.INSTANCE), observeThreadAckState(channelId), AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…lMessages, threadState) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout(observableJ, 10L, false), StoreMessageAck.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(messageId, channelId), 62, (Object) null);
    }

    public final Observable<Map<Long, Ack>> observeAll() {
        Observable<Map<Long, Ack>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Ack> observeForChannel(long channelId) {
        Observable<Ack> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashMap mapSnapshot$default = CollectionExtensions.snapshot$default(this.acks, 0, 0.0f, 3, null);
        this.acksSnapshot = mapSnapshot$default;
        Persister.set$default(this.acksPersister, mapSnapshot$default, false, 2, null);
    }
}
