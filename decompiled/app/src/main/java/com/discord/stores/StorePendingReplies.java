package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.MessageReference;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.message.Message;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.SnowflakePartitionMap;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StorePendingReplies.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001.B\u0019\u0012\u0006\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010*\u001a\u00020)¢\u0006\u0004\b,\u0010-J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0015\u001a\u00020\u00122\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00122\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0012H\u0017¢\u0006\u0004\b\u001f\u0010\u001eR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R&\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/discord/stores/StorePendingReplies;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StorePendingReplies$PendingReply;", "getPendingReply", "(J)Lcom/discord/stores/StorePendingReplies$PendingReply;", "Lrx/Observable;", "observePendingReply", "(J)Lrx/Observable;", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/models/message/Message;", "message", "", "shouldMention", "showMentionToggle", "", "onCreatePendingReply", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/message/Message;ZZ)V", "onSetPendingReplyShouldMention", "(JZ)V", "onDeletePendingReply", "(J)V", "Lcom/discord/models/domain/ModelMessageDelete;", "messageDeleteBulk", "handleMessageDelete", "(Lcom/discord/models/domain/ModelMessageDelete;)V", "handlePreLogout", "()V", "snapshotData", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "pendingRepliesSnapshot", "Ljava/util/Map;", "Lcom/discord/utilities/collections/SnowflakePartitionMap$CopiablePartitionMap;", "pendingReplies", "Lcom/discord/utilities/collections/SnowflakePartitionMap$CopiablePartitionMap;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "PendingReply", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StorePendingReplies extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final SnowflakePartitionMap.CopiablePartitionMap<PendingReply> pendingReplies;
    private Map<Long, PendingReply> pendingRepliesSnapshot;

    /* compiled from: StorePendingReplies.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010 R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/discord/stores/StorePendingReplies$PendingReply;", "", "Lcom/discord/api/message/MessageReference;", "component1", "()Lcom/discord/api/message/MessageReference;", "Lcom/discord/models/message/Message;", "component2", "()Lcom/discord/models/message/Message;", "", "component3", "()Z", "component4", "messageReference", "originalMessage", "shouldMention", "showMentionToggle", "copy", "(Lcom/discord/api/message/MessageReference;Lcom/discord/models/message/Message;ZZ)Lcom/discord/stores/StorePendingReplies$PendingReply;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/message/Message;", "getOriginalMessage", "Z", "getShouldMention", "setShouldMention", "(Z)V", "getShowMentionToggle", "Lcom/discord/api/message/MessageReference;", "getMessageReference", "<init>", "(Lcom/discord/api/message/MessageReference;Lcom/discord/models/message/Message;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PendingReply {
        private final MessageReference messageReference;
        private final Message originalMessage;
        private boolean shouldMention;
        private final boolean showMentionToggle;

        public PendingReply(MessageReference messageReference, Message message, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(messageReference, "messageReference");
            Intrinsics3.checkNotNullParameter(message, "originalMessage");
            this.messageReference = messageReference;
            this.originalMessage = message;
            this.shouldMention = z2;
            this.showMentionToggle = z3;
        }

        public static /* synthetic */ PendingReply copy$default(PendingReply pendingReply, MessageReference messageReference, Message message, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                messageReference = pendingReply.messageReference;
            }
            if ((i & 2) != 0) {
                message = pendingReply.originalMessage;
            }
            if ((i & 4) != 0) {
                z2 = pendingReply.shouldMention;
            }
            if ((i & 8) != 0) {
                z3 = pendingReply.showMentionToggle;
            }
            return pendingReply.copy(messageReference, message, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final MessageReference getMessageReference() {
            return this.messageReference;
        }

        /* renamed from: component2, reason: from getter */
        public final Message getOriginalMessage() {
            return this.originalMessage;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShouldMention() {
            return this.shouldMention;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getShowMentionToggle() {
            return this.showMentionToggle;
        }

        public final PendingReply copy(MessageReference messageReference, Message originalMessage, boolean shouldMention, boolean showMentionToggle) {
            Intrinsics3.checkNotNullParameter(messageReference, "messageReference");
            Intrinsics3.checkNotNullParameter(originalMessage, "originalMessage");
            return new PendingReply(messageReference, originalMessage, shouldMention, showMentionToggle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingReply)) {
                return false;
            }
            PendingReply pendingReply = (PendingReply) other;
            return Intrinsics3.areEqual(this.messageReference, pendingReply.messageReference) && Intrinsics3.areEqual(this.originalMessage, pendingReply.originalMessage) && this.shouldMention == pendingReply.shouldMention && this.showMentionToggle == pendingReply.showMentionToggle;
        }

        public final MessageReference getMessageReference() {
            return this.messageReference;
        }

        public final Message getOriginalMessage() {
            return this.originalMessage;
        }

        public final boolean getShouldMention() {
            return this.shouldMention;
        }

        public final boolean getShowMentionToggle() {
            return this.showMentionToggle;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MessageReference messageReference = this.messageReference;
            int iHashCode = (messageReference != null ? messageReference.hashCode() : 0) * 31;
            Message message = this.originalMessage;
            int iHashCode2 = (iHashCode + (message != null ? message.hashCode() : 0)) * 31;
            boolean z2 = this.shouldMention;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.showMentionToggle;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final void setShouldMention(boolean z2) {
            this.shouldMention = z2;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PendingReply(messageReference=");
            sbU.append(this.messageReference);
            sbU.append(", originalMessage=");
            sbU.append(this.originalMessage);
            sbU.append(", shouldMention=");
            sbU.append(this.shouldMention);
            sbU.append(", showMentionToggle=");
            return outline.O(sbU, this.showMentionToggle, ")");
        }
    }

    /* compiled from: StorePendingReplies.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StorePendingReplies$PendingReply;", "invoke", "()Lcom/discord/stores/StorePendingReplies$PendingReply;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePendingReplies$observePendingReply$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<PendingReply> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ PendingReply invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PendingReply invoke() {
            return StorePendingReplies.this.getPendingReply(this.$channelId);
        }
    }

    /* compiled from: StorePendingReplies.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePendingReplies$onCreatePendingReply$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Message $message;
        public final /* synthetic */ boolean $shouldMention;
        public final /* synthetic */ boolean $showMentionToggle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, Message message, boolean z2, boolean z3) {
            super(0);
            this.$channel = channel;
            this.$message = message;
            this.$shouldMention = z2;
            this.$showMentionToggle = z3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StorePendingReplies.access$getPendingReplies$p(StorePendingReplies.this).put(Long.valueOf(this.$channel.getId()), new PendingReply(new MessageReference(ChannelUtils.B(this.$channel) ? null : Long.valueOf(this.$channel.getGuildId()), Long.valueOf(this.$channel.getId()), Long.valueOf(this.$message.getId())), this.$message, this.$shouldMention, this.$showMentionToggle));
            StorePendingReplies.this.markChanged();
        }
    }

    /* compiled from: StorePendingReplies.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePendingReplies$onDeletePendingReply$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StorePendingReplies.access$getPendingReplies$p(StorePendingReplies.this).remove(Long.valueOf(this.$channelId));
            StorePendingReplies.this.markChanged();
        }
    }

    /* compiled from: StorePendingReplies.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StorePendingReplies$onSetPendingReplyShouldMention$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $shouldMention;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2) {
            super(0);
            this.$channelId = j;
            this.$shouldMention = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PendingReply pendingReply = (PendingReply) StorePendingReplies.access$getPendingReplies$p(StorePendingReplies.this).get(Long.valueOf(this.$channelId));
            if (pendingReply != null) {
                StorePendingReplies.access$getPendingReplies$p(StorePendingReplies.this).put(Long.valueOf(this.$channelId), PendingReply.copy$default(pendingReply, null, null, this.$shouldMention, false, 11, null));
                StorePendingReplies.this.markChanged();
            }
        }
    }

    public /* synthetic */ StorePendingReplies(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ SnowflakePartitionMap.CopiablePartitionMap access$getPendingReplies$p(StorePendingReplies storePendingReplies) {
        return storePendingReplies.pendingReplies;
    }

    public static /* synthetic */ void onCreatePendingReply$default(StorePendingReplies storePendingReplies, Channel channel, Message message, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        storePendingReplies.onCreatePendingReply(channel, message, z2, z3);
    }

    public final PendingReply getPendingReply(long channelId) {
        return this.pendingRepliesSnapshot.get(Long.valueOf(channelId));
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        Intrinsics3.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        PendingReply pendingReply = this.pendingReplies.get(Long.valueOf(messageDeleteBulk.getChannelId()));
        if (pendingReply == null || !messageDeleteBulk.getMessageIds().contains(pendingReply.getMessageReference().getMessageId())) {
            return;
        }
        this.pendingReplies.remove(Long.valueOf(messageDeleteBulk.getChannelId()));
        markChanged();
    }

    @Store3
    public final void handlePreLogout() {
        this.pendingReplies.clear();
        markChanged();
    }

    public final Observable<PendingReply> observePendingReply(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final void onCreatePendingReply(Channel channel, Message message, boolean shouldMention, boolean showMentionToggle) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(message, "message");
        this.dispatcher.schedule(new AnonymousClass1(channel, message, shouldMention, showMentionToggle));
    }

    public final void onDeletePendingReply(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    public final void onSetPendingReplyShouldMention(long channelId, boolean shouldMention) {
        this.dispatcher.schedule(new AnonymousClass1(channelId, shouldMention));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.pendingRepliesSnapshot = this.pendingReplies.fastCopy();
    }

    public StorePendingReplies(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pendingReplies = new SnowflakePartitionMap.CopiablePartitionMap<>(0, 1, null);
        this.pendingRepliesSnapshot = Maps6.emptyMap();
    }
}
