package com.discord.widgets.forums;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreForumPostReadStates;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActive;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.f0._Sequences2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.subjects.BehaviorSubject;

/* compiled from: ForumPostReadStateManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u00014B\t\b\u0002¢\u0006\u0004\b2\u00103J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\u000e\u0010\u000e\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019JY\u0010$\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020#0\"0!2\n\u0010\u001b\u001a\u00060\u000bj\u0002`\u001a2\n\u0010\u001c\u001a\u00060\u000bj\u0002`\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b$\u0010%R\u001a\u0010&\u001a\u00060\u000bj\u0002`\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R \u0010)\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\u001a0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010-\u001a\u00060\u000bj\u0002`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010'R\u001e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R&\u00100\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\b0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/discord/widgets/forums/ForumPostReadStateManager;", "", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "handleSubscription", "(Lrx/Subscription;)V", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/StoreMessageAck$Ack;", "observeForumChannelAckBeforeChannelSelect", "()Lrx/subjects/BehaviorSubject;", "", "Lcom/discord/primitives/ChannelId;", "channelId1", "channelId2", "", "compareChannelIds", "(Ljava/lang/Long;Ljava/lang/Long;)I", "Lcom/discord/stores/StoreMessageAck;", "storeMessageAck", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreThreadsActive;", "storeThreadsActive", "initialize", "(Lcom/discord/stores/StoreMessageAck;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreThreadsActive;)V", "Lcom/discord/primitives/GuildId;", "guildId", "channelId", "Lcom/discord/stores/StoreReadStates;", "storeReadStates", "Lcom/discord/stores/StoreForumPostReadStates;", "storeForumPostReadStates", "Lrx/Observable;", "", "Lcom/discord/widgets/forums/ForumPostReadState;", "observeForumPostReadStates", "(JJLcom/discord/stores/StoreReadStates;Lcom/discord/stores/StoreThreadsActive;Lcom/discord/stores/StoreForumPostReadStates;)Lrx/Observable;", "lastSyncedGuildId", "J", "", "internalThreadSyncedGuilds", "Ljava/util/Set;", "forumChannelAckSubscription", "Lrx/Subscription;", "lastSelectedChannelId", "forumChannelAckBeforeChannelSelect", "Lrx/subjects/BehaviorSubject;", "internalMessageAcks", "Ljava/util/Map;", "<init>", "()V", "ManagerInitializeState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ForumPostReadStateManager {
    public static final ForumPostReadStateManager INSTANCE = new ForumPostReadStateManager();
    private static final BehaviorSubject<StoreMessageAck.Ack> forumChannelAckBeforeChannelSelect;
    private static Subscription forumChannelAckSubscription;
    private static Map<Long, StoreMessageAck.Ack> internalMessageAcks;
    private static final Set<Long> internalThreadSyncedGuilds;
    private static long lastSelectedChannelId;
    private static long lastSyncedGuildId;

    /* compiled from: ForumPostReadStateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\f0\u000b¢\u0006\u0004\b$\u0010%J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u0012\u001a\u00020\u00002\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\b\b\u0002\u0010\u0010\u001a\u00020\b2\u0012\b\u0002\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR#\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR)\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\n¨\u0006&"}, d2 = {"Lcom/discord/widgets/forums/ForumPostReadStateManager$ManagerInitializeState;", "", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreMessageAck$Ack;", "component1", "()Ljava/util/Map;", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "component2", "()Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "", "Lcom/discord/primitives/GuildId;", "component3", "()Ljava/util/Set;", "messageAcks", "resolvedSelectedChannel", "threadSyncedGuilds", "copy", "(Ljava/util/Map;Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;Ljava/util/Set;)Lcom/discord/widgets/forums/ForumPostReadStateManager$ManagerInitializeState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getThreadSyncedGuilds", "Ljava/util/Map;", "getMessageAcks", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "getResolvedSelectedChannel", "<init>", "(Ljava/util/Map;Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ManagerInitializeState {
        private final Map<Long, StoreMessageAck.Ack> messageAcks;
        private final StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel;
        private final Set<Long> threadSyncedGuilds;

        public ManagerInitializeState(Map<Long, StoreMessageAck.Ack> map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> set) {
            Intrinsics3.checkNotNullParameter(map, "messageAcks");
            Intrinsics3.checkNotNullParameter(resolvedSelectedChannel, "resolvedSelectedChannel");
            Intrinsics3.checkNotNullParameter(set, "threadSyncedGuilds");
            this.messageAcks = map;
            this.resolvedSelectedChannel = resolvedSelectedChannel;
            this.threadSyncedGuilds = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ManagerInitializeState copy$default(ManagerInitializeState managerInitializeState, Map map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                map = managerInitializeState.messageAcks;
            }
            if ((i & 2) != 0) {
                resolvedSelectedChannel = managerInitializeState.resolvedSelectedChannel;
            }
            if ((i & 4) != 0) {
                set = managerInitializeState.threadSyncedGuilds;
            }
            return managerInitializeState.copy(map, resolvedSelectedChannel, set);
        }

        public final Map<Long, StoreMessageAck.Ack> component1() {
            return this.messageAcks;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreChannelsSelected.ResolvedSelectedChannel getResolvedSelectedChannel() {
            return this.resolvedSelectedChannel;
        }

        public final Set<Long> component3() {
            return this.threadSyncedGuilds;
        }

        public final ManagerInitializeState copy(Map<Long, StoreMessageAck.Ack> messageAcks, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> threadSyncedGuilds) {
            Intrinsics3.checkNotNullParameter(messageAcks, "messageAcks");
            Intrinsics3.checkNotNullParameter(resolvedSelectedChannel, "resolvedSelectedChannel");
            Intrinsics3.checkNotNullParameter(threadSyncedGuilds, "threadSyncedGuilds");
            return new ManagerInitializeState(messageAcks, resolvedSelectedChannel, threadSyncedGuilds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ManagerInitializeState)) {
                return false;
            }
            ManagerInitializeState managerInitializeState = (ManagerInitializeState) other;
            return Intrinsics3.areEqual(this.messageAcks, managerInitializeState.messageAcks) && Intrinsics3.areEqual(this.resolvedSelectedChannel, managerInitializeState.resolvedSelectedChannel) && Intrinsics3.areEqual(this.threadSyncedGuilds, managerInitializeState.threadSyncedGuilds);
        }

        public final Map<Long, StoreMessageAck.Ack> getMessageAcks() {
            return this.messageAcks;
        }

        public final StoreChannelsSelected.ResolvedSelectedChannel getResolvedSelectedChannel() {
            return this.resolvedSelectedChannel;
        }

        public final Set<Long> getThreadSyncedGuilds() {
            return this.threadSyncedGuilds;
        }

        public int hashCode() {
            Map<Long, StoreMessageAck.Ack> map = this.messageAcks;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.resolvedSelectedChannel;
            int iHashCode2 = (iHashCode + (resolvedSelectedChannel != null ? resolvedSelectedChannel.hashCode() : 0)) * 31;
            Set<Long> set = this.threadSyncedGuilds;
            return iHashCode2 + (set != null ? set.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ManagerInitializeState(messageAcks=");
            sbU.append(this.messageAcks);
            sbU.append(", resolvedSelectedChannel=");
            sbU.append(this.resolvedSelectedChannel);
            sbU.append(", threadSyncedGuilds=");
            return outline.N(sbU, this.threadSyncedGuilds, ")");
        }
    }

    /* compiled from: ForumPostReadStateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\n \u0004*\u0004\u0018\u00010\u000b0\u000b2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\"\u0010\n\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\t \u0004*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\t\u0018\u00010\b0\bH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreMessageAck$Ack;", "kotlin.jvm.PlatformType", "messageAcks", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "resolvedSelectedChannel", "", "Lcom/discord/primitives/GuildId;", "threadSyncedGuilds", "Lcom/discord/widgets/forums/ForumPostReadStateManager$ManagerInitializeState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;Ljava/util/Set;)Lcom/discord/widgets/forums/ForumPostReadStateManager$ManagerInitializeState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$initialize$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreMessageAck.Ack>, StoreChannelsSelected.ResolvedSelectedChannel, Set<? extends Long>, ManagerInitializeState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ ManagerInitializeState call(Map<Long, ? extends StoreMessageAck.Ack> map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<? extends Long> set) {
            return call2((Map<Long, StoreMessageAck.Ack>) map, resolvedSelectedChannel, (Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ManagerInitializeState call2(Map<Long, StoreMessageAck.Ack> map, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Set<Long> set) {
            Intrinsics3.checkNotNullExpressionValue(map, "messageAcks");
            Intrinsics3.checkNotNullExpressionValue(resolvedSelectedChannel, "resolvedSelectedChannel");
            Intrinsics3.checkNotNullExpressionValue(set, "threadSyncedGuilds");
            return new ManagerInitializeState(map, resolvedSelectedChannel, set);
        }
    }

    /* compiled from: ForumPostReadStateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "p1", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$initialize$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Subscription, Unit> {
        public AnonymousClass2(ForumPostReadStateManager forumPostReadStateManager) {
            super(1, forumPostReadStateManager, ForumPostReadStateManager.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "p1");
            ForumPostReadStateManager.access$handleSubscription((ForumPostReadStateManager) this.receiver, subscription);
        }
    }

    /* compiled from: ForumPostReadStateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/forums/ForumPostReadStateManager$ManagerInitializeState;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", "invoke", "(Lcom/discord/widgets/forums/ForumPostReadStateManager$ManagerInitializeState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$initialize$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ManagerInitializeState, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ManagerInitializeState managerInitializeState) {
            invoke2(managerInitializeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ManagerInitializeState managerInitializeState) {
            Map<Long, StoreMessageAck.Ack> mapComponent1 = managerInitializeState.component1();
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = managerInitializeState.getResolvedSelectedChannel();
            Set<Long> setComponent3 = managerInitializeState.component3();
            Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
            if (maybeChannel == null || !ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, maybeChannel.getGuildId(), null, 2, null)) {
                return;
            }
            boolean z2 = setComponent3.contains(Long.valueOf(maybeChannel.getGuildId())) && maybeChannel.getGuildId() != ForumPostReadStateManager.access$getLastSyncedGuildId$p(ForumPostReadStateManager.INSTANCE);
            boolean z3 = ChannelUtils.q(maybeChannel) && maybeChannel.getId() != ForumPostReadStateManager.access$getLastSelectedChannelId$p(ForumPostReadStateManager.INSTANCE);
            if (z2) {
                ForumPostReadStateManager forumPostReadStateManager = ForumPostReadStateManager.INSTANCE;
                ForumPostReadStateManager.access$setInternalMessageAcks$p(forumPostReadStateManager, mapComponent1);
                ForumPostReadStateManager.access$setLastSyncedGuildId$p(forumPostReadStateManager, maybeChannel.getGuildId());
            }
            if (z3 || z2) {
                ForumPostReadStateManager forumPostReadStateManager2 = ForumPostReadStateManager.INSTANCE;
                ForumPostReadStateManager.access$getForumChannelAckBeforeChannelSelect$p(forumPostReadStateManager2).onNext(ForumPostReadStateManager.access$getInternalMessageAcks$p(forumPostReadStateManager2).get(Long.valueOf(maybeChannel.getId())));
            }
            ForumPostReadStateManager forumPostReadStateManager3 = ForumPostReadStateManager.INSTANCE;
            ForumPostReadStateManager.access$setLastSelectedChannelId$p(forumPostReadStateManager3, resolvedSelectedChannel.getId());
            ForumPostReadStateManager.access$setInternalMessageAcks$p(forumPostReadStateManager3, mapComponent1);
        }
    }

    /* compiled from: ForumPostReadStateManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u000b \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00000\u00002.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002\"\u0010\u0007\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0004*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00060\u00062\"\u0010\b\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0004*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00060\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "activeThreads", "", "persistedThreadIds", "unreadChannelIds", "Lcom/discord/stores/StoreMessageAck$Ack;", "forumChannelAck", "Lcom/discord/widgets/forums/ForumPostReadState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;Lcom/discord/stores/StoreMessageAck$Ack;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$observeForumPostReadStates$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends Channel>, Set<? extends Long>, Set<? extends Long>, StoreMessageAck.Ack, Map<Long, ? extends ForumPostReadState>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: ForumPostReadStateManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/widgets/forums/ForumPostReadState;", "invoke", "(J)Lcom/discord/widgets/forums/ForumPostReadState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.forums.ForumPostReadStateManager$observeForumPostReadStates$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02881 extends Lambda implements Function1<Long, ForumPostReadState> {
            public final /* synthetic */ StoreMessageAck.Ack $forumChannelAck;
            public final /* synthetic */ Set $persistedThreadIds;
            public final /* synthetic */ Set $unreadChannelIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02881(StoreMessageAck.Ack ack, Set set, Set set2) {
                super(1);
                this.$forumChannelAck = ack;
                this.$persistedThreadIds = set;
                this.$unreadChannelIds = set2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ForumPostReadState invoke(Long l) {
                return invoke(l.longValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final ForumPostReadState invoke(long j) {
                boolean z2;
                if (this.$persistedThreadIds.contains(Long.valueOf(j))) {
                    z2 = true;
                } else {
                    StoreMessageAck.Ack ack = this.$forumChannelAck;
                    if ((ack != null ? Long.valueOf(ack.getMessageId()) : null) != null && ForumPostReadStateManager.access$compareChannelIds(ForumPostReadStateManager.INSTANCE, Long.valueOf(j), Long.valueOf(this.$forumChannelAck.getMessageId())) > 0) {
                        z2 = false;
                    }
                }
                return new ForumPostReadState(j, z2, this.$unreadChannelIds.contains(Long.valueOf(j)));
            }
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ Map<Long, ? extends ForumPostReadState> call(Map<Long, ? extends Channel> map, Set<? extends Long> set, Set<? extends Long> set2, StoreMessageAck.Ack ack) {
            return call2((Map<Long, Channel>) map, (Set<Long>) set, (Set<Long>) set2, ack);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, ForumPostReadState> call2(Map<Long, Channel> map, Set<Long> set, Set<Long> set2, StoreMessageAck.Ack ack) {
            Sequence map2 = _Sequences2.map(_Collections.asSequence(map.keySet()), new C02881(ack, set, set2));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : map2) {
                linkedHashMap.put(Long.valueOf(((ForumPostReadState) obj).getChannelId()), obj);
            }
            return linkedHashMap;
        }
    }

    static {
        BehaviorSubject<StoreMessageAck.Ack> behaviorSubjectK0 = BehaviorSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        forumChannelAckBeforeChannelSelect = behaviorSubjectK0;
        internalMessageAcks = Maps6.emptyMap();
        internalThreadSyncedGuilds = new LinkedHashSet();
    }

    private ForumPostReadStateManager() {
    }

    public static final /* synthetic */ int access$compareChannelIds(ForumPostReadStateManager forumPostReadStateManager, Long l, Long l2) {
        return forumPostReadStateManager.compareChannelIds(l, l2);
    }

    public static final /* synthetic */ BehaviorSubject access$getForumChannelAckBeforeChannelSelect$p(ForumPostReadStateManager forumPostReadStateManager) {
        return forumChannelAckBeforeChannelSelect;
    }

    public static final /* synthetic */ Map access$getInternalMessageAcks$p(ForumPostReadStateManager forumPostReadStateManager) {
        return internalMessageAcks;
    }

    public static final /* synthetic */ long access$getLastSelectedChannelId$p(ForumPostReadStateManager forumPostReadStateManager) {
        return lastSelectedChannelId;
    }

    public static final /* synthetic */ long access$getLastSyncedGuildId$p(ForumPostReadStateManager forumPostReadStateManager) {
        return lastSyncedGuildId;
    }

    public static final /* synthetic */ void access$handleSubscription(ForumPostReadStateManager forumPostReadStateManager, Subscription subscription) {
        forumPostReadStateManager.handleSubscription(subscription);
    }

    public static final /* synthetic */ void access$setInternalMessageAcks$p(ForumPostReadStateManager forumPostReadStateManager, Map map) {
        internalMessageAcks = map;
    }

    public static final /* synthetic */ void access$setLastSelectedChannelId$p(ForumPostReadStateManager forumPostReadStateManager, long j) {
        lastSelectedChannelId = j;
    }

    public static final /* synthetic */ void access$setLastSyncedGuildId$p(ForumPostReadStateManager forumPostReadStateManager, long j) {
        lastSyncedGuildId = j;
    }

    private final int compareChannelIds(Long channelId1, Long channelId2) {
        long jLongValue = channelId1 != null ? channelId1.longValue() : 0L;
        long jLongValue2 = channelId2 != null ? channelId2.longValue() : 0L;
        if (jLongValue == jLongValue2) {
            return 0;
        }
        return jLongValue < jLongValue2 ? -1 : 1;
    }

    private final void handleSubscription(Subscription subscription) {
        forumChannelAckSubscription = subscription;
    }

    public static /* synthetic */ void initialize$default(ForumPostReadStateManager forumPostReadStateManager, StoreMessageAck storeMessageAck, StoreChannelsSelected storeChannelsSelected, StoreThreadsActive storeThreadsActive, int i, Object obj) {
        if ((i & 1) != 0) {
            storeMessageAck = StoreStream.INSTANCE.getMessageAck();
        }
        if ((i & 2) != 0) {
            storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
        }
        if ((i & 4) != 0) {
            storeThreadsActive = StoreStream.INSTANCE.getThreadsActive();
        }
        forumPostReadStateManager.initialize(storeMessageAck, storeChannelsSelected, storeThreadsActive);
    }

    private final BehaviorSubject<StoreMessageAck.Ack> observeForumChannelAckBeforeChannelSelect() {
        return forumChannelAckBeforeChannelSelect;
    }

    public static /* synthetic */ Observable observeForumPostReadStates$default(ForumPostReadStateManager forumPostReadStateManager, long j, long j2, StoreReadStates storeReadStates, StoreThreadsActive storeThreadsActive, StoreForumPostReadStates storeForumPostReadStates, int i, Object obj) {
        return forumPostReadStateManager.observeForumPostReadStates(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getReadStates() : storeReadStates, (i & 8) != 0 ? StoreStream.INSTANCE.getThreadsActive() : storeThreadsActive, (i & 16) != 0 ? StoreStream.INSTANCE.getForumPostReadStates() : storeForumPostReadStates);
    }

    public final void initialize(StoreMessageAck storeMessageAck, StoreChannelsSelected storeChannelsSelected, StoreThreadsActive storeThreadsActive) {
        Intrinsics3.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Subscription subscription = forumChannelAckSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable observableI = Observable.i(storeMessageAck.observeAll(), storeChannelsSelected.observeResolvedSelectedChannel(), storeThreadsActive.observeThreadSyncedGuilds(), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…threadSyncedGuilds)\n    }");
        ObservableExtensionsKt.appSubscribe$default(observableI, ForumPostReadStateManager.class, (Context) null, new AnonymousClass2(this), (Function1) null, (Function0) null, (Function0) null, AnonymousClass3.INSTANCE, 58, (Object) null);
    }

    public final Observable<Map<Long, ForumPostReadState>> observeForumPostReadStates(long guildId, long channelId, StoreReadStates storeReadStates, StoreThreadsActive storeThreadsActive, StoreForumPostReadStates storeForumPostReadStates) {
        Intrinsics3.checkNotNullParameter(storeReadStates, "storeReadStates");
        Intrinsics3.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Intrinsics3.checkNotNullParameter(storeForumPostReadStates, "storeForumPostReadStates");
        Observable<Map<Long, ForumPostReadState>> observableH = Observable.h(storeThreadsActive.observeActiveThreadsForChannel(guildId, Long.valueOf(channelId)), storeForumPostReadStates.observeThreadIdsWithPersistedReadStates(), storeReadStates.getUnreadChannelIds(), observeForumChannelAckBeforeChannelSelect(), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…By { it.channelId }\n    }");
        return observableH;
    }
}
