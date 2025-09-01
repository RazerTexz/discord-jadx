package com.discord.stores;

import androidx.annotation.VisibleForTesting;
import com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.Progressions2;
import kotlin.ranges.Ranges2;

/* compiled from: StoreGuildSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u0010\u001a\u00060\u0007j\u0002`\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u0010\u001a\u00060\u0007j\u0002`\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u000eJ-\u0010\u0019\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u0016\u001a\u00060\u0007j\u0002`\u00152\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001b\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u0016\u001a\u00060\u0007j\u0002`\u0015¢\u0006\u0004\b\u001b\u0010\u0012J%\u0010\u001c\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u0010\u001a\u00060\u0007j\u0002`\u000f¢\u0006\u0004\b\u001c\u0010\u0012J%\u0010\u001d\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u0010\u001a\u00060\u0007j\u0002`\u000f¢\u0006\u0004\b\u001d\u0010\u0012R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/discord/stores/StoreGuildSubscriptions;", "Lcom/discord/stores/StoreV2;", "", "isConnectionReady", "", "handleConnectionReady", "(Z)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "handleGuildSelect", "(J)V", "handleGuildRemove", "handlePreLogout", "()V", "Lcom/discord/primitives/UserId;", "userId", "handleSubscribeMember", "(JJ)V", "handleUnsubscribeMember", "snapshotData", "Lcom/discord/primitives/ChannelId;", "channelId", "Lkotlin/ranges/IntRange;", "range", "subscribeChannelRange", "(JJLkotlin/ranges/IntRange;)V", "subscribeThread", "subscribeUser", "unsubscribeUser", "Lcom/discord/stores/StoreStream;", "storeStream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/utilities/lazy/subscriptions/GuildSubscriptionsManager;", "subscriptionsManager", "Lcom/discord/utilities/lazy/subscriptions/GuildSubscriptionsManager;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;)V", "RangeComputer", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final StoreStream storeStream;
    private final GuildSubscriptionsManager subscriptionsManager;

    /* compiled from: StoreGuildSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/stores/StoreGuildSubscriptions$RangeComputer;", "", "Lkotlin/ranges/IntRange;", "range", "", "chunkSize", "", "computeRanges", "(Lkotlin/ranges/IntRange;I)Ljava/util/List;", "DEFAULT_CHUNK_SIZE", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    @VisibleForTesting
    public static final class RangeComputer {
        private static final int DEFAULT_CHUNK_SIZE = 100;
        public static final RangeComputer INSTANCE = new RangeComputer();

        private RangeComputer() {
        }

        public static /* synthetic */ List computeRanges$default(RangeComputer rangeComputer, Ranges2 ranges2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 100;
            }
            return rangeComputer.computeRanges(ranges2, i);
        }

        public final List<Ranges2> computeRanges(Ranges2 range, int chunkSize) {
            Intrinsics3.checkNotNullParameter(range, "range");
            ArrayList arrayList = new ArrayList(3);
            int iInvoke = StoreGuildSubscriptions2.INSTANCE.invoke(range.getFirst(), chunkSize);
            if (iInvoke > 0) {
                arrayList.add(_Ranges.until(0, chunkSize));
            }
            Progressions2 progressions2Step = _Ranges.step(_Ranges.until(iInvoke, range.getLast()), chunkSize);
            int first = progressions2Step.getFirst();
            int last = progressions2Step.getLast();
            int step = progressions2Step.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    arrayList.add(_Ranges.until(first, first + chunkSize));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
            return arrayList;
        }
    }

    /* compiled from: StoreGuildSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSubscriptions$subscribeChannelRange$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Ranges2 $range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ranges2 ranges2, long j, long j2) {
            super(0);
            this.$range = ranges2;
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.access$getSubscriptionsManager$p(StoreGuildSubscriptions.this).subscribeChannel(this.$guildId, this.$channelId, RangeComputer.computeRanges$default(RangeComputer.INSTANCE, this.$range, 0, 2, null));
            StoreGuildSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSubscriptions$subscribeThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.access$getSubscriptionsManager$p(StoreGuildSubscriptions.this).subscribeThread(this.$guildId, this.$channelId);
            StoreGuildSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSubscriptions$subscribeUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.handleSubscribeMember(this.$guildId, this.$userId);
        }
    }

    /* compiled from: StoreGuildSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildSubscriptions$unsubscribeUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSubscriptions.this.handleUnsubscribeMember(this.$guildId, this.$userId);
        }
    }

    public StoreGuildSubscriptions(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.subscriptionsManager = new GuildSubscriptionsManager(new StoreGuildSubscriptions3(this));
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreGuildSubscriptions storeGuildSubscriptions) {
        return storeGuildSubscriptions.storeStream;
    }

    public static final /* synthetic */ GuildSubscriptionsManager access$getSubscriptionsManager$p(StoreGuildSubscriptions storeGuildSubscriptions) {
        return storeGuildSubscriptions.subscriptionsManager;
    }

    @Store3
    public final void handleConnectionReady(boolean isConnectionReady) {
        if (!isConnectionReady) {
            this.subscriptionsManager.retainAll(Collections2.listOf((Object[]) new Long[]{Long.valueOf(this.storeStream.getGuildSelected().getSelectedGuildId()), Long.valueOf(this.storeStream.getRtcConnection().getConnectedGuildId())}));
            markChanged();
            return;
        }
        long selectedGuildId = this.storeStream.getGuildSelected().getSelectedGuildId();
        if (selectedGuildId > 0) {
            handleGuildSelect(selectedGuildId);
        }
        this.subscriptionsManager.queueExistingSubscriptions();
        markChanged();
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        this.subscriptionsManager.remove(guildId);
        markChanged();
    }

    @Store3
    public final void handleGuildSelect(long guildId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.subscribeTyping(guildId);
        this.subscriptionsManager.subscribeActivities(guildId);
        this.subscriptionsManager.subscribeThreads(guildId);
        markChanged();
    }

    @Store3
    public final void handlePreLogout() {
        this.subscriptionsManager.reset();
        markChanged();
    }

    @Store3
    public final void handleSubscribeMember(long guildId, long userId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.subscribeMember(guildId, userId);
        markChanged();
    }

    @Store3
    public final void handleUnsubscribeMember(long guildId, long userId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.unsubscribeMember(guildId, userId);
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.subscriptionsManager.flush();
    }

    public final void subscribeChannelRange(long guildId, long channelId, Ranges2 range) {
        Intrinsics3.checkNotNullParameter(range, "range");
        if (guildId <= 0 || channelId <= 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(range, guildId, channelId));
    }

    public final void subscribeThread(long guildId, long channelId) {
        if (guildId <= 0 || channelId <= 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId, channelId));
    }

    public final void subscribeUser(long guildId, long userId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, userId));
    }

    public final void unsubscribeUser(long guildId, long userId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, userId));
    }
}
