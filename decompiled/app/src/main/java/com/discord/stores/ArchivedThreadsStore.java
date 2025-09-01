package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadListing;
import com.discord.api.thread.ThreadMetadata;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: ArchivedThreadsStore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u000201B)\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\f\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0012\u0010\u0011J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J=\u0010\u0017\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R2\u0010&\u001a\u001e\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00130$\u0012\u0004\u0012\u00020%0#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R2\u0010(\u001a\u001e\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00130$\u0012\u0004\u0012\u00020\u000f0#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R2\u0010*\u001a\u001e\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00130$\u0012\u0004\u0012\u00020\u000f0)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010'R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore;", "Lcom/discord/stores/StoreV2;", "", "handleConnectionOpen", "()V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "reload", "Lkotlin/Function0;", "onTerminated", "fetchGuildForumThreadListing", "(JZLkotlin/jvm/functions/Function0;)V", "Lrx/Observable;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "observeGuildForumThreadListing", "(J)Lrx/Observable;", "loadAndObserveGuildForumThreadListing", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType;", "threadListingType", "loadAndObserveThreadListing", "(JLcom/discord/stores/ArchivedThreadsStore$ThreadListingType;)Lrx/Observable;", "fetchListing", "(JLcom/discord/stores/ArchivedThreadsStore$ThreadListingType;ZLkotlin/jvm/functions/Function0;)V", "snapshotData", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreStream;", "storeStream", "Lcom/discord/stores/StoreStream;", "", "Lkotlin/Pair;", "Lrx/Subscription;", "fetchSubscriptions", "Ljava/util/Map;", "listings", "", "listingsSnapshot", "Lcom/discord/stores/StoreForumPostMessages;", "storeForumPostMessages", "Lcom/discord/stores/StoreForumPostMessages;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreForumPostMessages;Lcom/discord/stores/updates/ObservationDeck;)V", "ThreadListingState", "ThreadListingType", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ArchivedThreadsStore extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Tuples2<Long, ThreadListingType>, Subscription> fetchSubscriptions;
    private Map<Tuples2<Long, ThreadListingType>, ThreadListingState> listings;
    private Map<Tuples2<Long, ThreadListingType>, ? extends ThreadListingState> listingsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreForumPostMessages storeForumPostMessages;
    private final StoreStream storeStream;

    /* compiled from: ArchivedThreadsStore.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "", "<init>", "()V", "Error", "Listing", "Uninitialized", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState$Uninitialized;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState$Error;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState$Listing;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ThreadListingState {

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState$Error;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ThreadListingState {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ4\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState$Listing;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "component3", "threads", "hasMore", "isLoadingMore", "copy", "(Ljava/util/List;ZZ)Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState$Listing;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getThreads", "Z", "getHasMore", "<init>", "(Ljava/util/List;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Listing extends ThreadListingState {
            private final boolean hasMore;
            private final boolean isLoadingMore;
            private final List<Channel> threads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Listing(List<Channel> list, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "threads");
                this.threads = list;
                this.hasMore = z2;
                this.isLoadingMore = z3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Listing copy$default(Listing listing, List list, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = listing.threads;
                }
                if ((i & 2) != 0) {
                    z2 = listing.hasMore;
                }
                if ((i & 4) != 0) {
                    z3 = listing.isLoadingMore;
                }
                return listing.copy(list, z2, z3);
            }

            public final List<Channel> component1() {
                return this.threads;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getHasMore() {
                return this.hasMore;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsLoadingMore() {
                return this.isLoadingMore;
            }

            public final Listing copy(List<Channel> threads, boolean hasMore, boolean isLoadingMore) {
                Intrinsics3.checkNotNullParameter(threads, "threads");
                return new Listing(threads, hasMore, isLoadingMore);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Listing)) {
                    return false;
                }
                Listing listing = (Listing) other;
                return Intrinsics3.areEqual(this.threads, listing.threads) && this.hasMore == listing.hasMore && this.isLoadingMore == listing.isLoadingMore;
            }

            public final boolean getHasMore() {
                return this.hasMore;
            }

            public final List<Channel> getThreads() {
                return this.threads;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                List<Channel> list = this.threads;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                boolean z2 = this.hasMore;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.isLoadingMore;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isLoadingMore() {
                return this.isLoadingMore;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Listing(threads=");
                sbU.append(this.threads);
                sbU.append(", hasMore=");
                sbU.append(this.hasMore);
                sbU.append(", isLoadingMore=");
                return outline.O(sbU, this.isLoadingMore, ")");
            }
        }

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState$Uninitialized;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ThreadListingState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ThreadListingState() {
        }

        public /* synthetic */ ThreadListingState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ArchivedThreadsStore.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\n\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/api/channel/Channel;", "threads", "Lrx/Observable;", "Lcom/discord/api/thread/ThreadListing;", "fetchNext", "(JLjava/util/List;)Lrx/Observable;", "<init>", "(Ljava/lang/String;I)V", "Companion", "MY_ARCHIVED_PRIVATE_THREADS", "ALL_ARCHIVED_PUBLIC_THREADS", "ALL_ARCHIVED_PRIVATE_THREADS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ThreadListingType {
        private static final /* synthetic */ ThreadListingType[] $VALUES;
        public static final ThreadListingType ALL_ARCHIVED_PRIVATE_THREADS;
        public static final ThreadListingType ALL_ARCHIVED_PUBLIC_THREADS;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ThreadListingType MY_ARCHIVED_PRIVATE_THREADS;

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PRIVATE_THREADS;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/api/channel/Channel;", "threads", "Lrx/Observable;", "Lcom/discord/api/thread/ThreadListing;", "fetchNext", "(JLjava/util/List;)Lrx/Observable;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ALL_ARCHIVED_PRIVATE_THREADS extends ThreadListingType {
            public ALL_ARCHIVED_PRIVATE_THREADS(String str, int i) {
                super(str, i, null);
            }

            @Override // com.discord.stores.ArchivedThreadsStore.ThreadListingType
            public Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads) {
                Intrinsics3.checkNotNullParameter(threads, "threads");
                try {
                    return RestAPI.INSTANCE.getApi().getAllPrivateArchivedThreads(channelId, Companion.access$getLastArchiveTimestamp(ThreadListingType.INSTANCE, threads));
                } catch (IllegalStateException e) {
                    Observable<ThreadListing> observableX = Observable.x(e);
                    Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(e)");
                    return observableX;
                }
            }
        }

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType$ALL_ARCHIVED_PUBLIC_THREADS;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/api/channel/Channel;", "threads", "Lrx/Observable;", "Lcom/discord/api/thread/ThreadListing;", "fetchNext", "(JLjava/util/List;)Lrx/Observable;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ALL_ARCHIVED_PUBLIC_THREADS extends ThreadListingType {
            public ALL_ARCHIVED_PUBLIC_THREADS(String str, int i) {
                super(str, i, null);
            }

            @Override // com.discord.stores.ArchivedThreadsStore.ThreadListingType
            public Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads) {
                Intrinsics3.checkNotNullParameter(threads, "threads");
                try {
                    return RestAPI.INSTANCE.getApi().getAllPublicArchivedThreads(channelId, Companion.access$getLastArchiveTimestamp(ThreadListingType.INSTANCE, threads));
                } catch (IllegalStateException e) {
                    Observable<ThreadListing> observableX = Observable.x(e);
                    Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(e)");
                    return observableX;
                }
            }
        }

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType$Companion;", "", "", "Lcom/discord/api/channel/Channel;", "threads", "", "getLastArchiveTimestamp", "(Ljava/util/List;)Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ String access$getLastArchiveTimestamp(Companion companion, List list) {
                return companion.getLastArchiveTimestamp(list);
            }

            private final String getLastArchiveTimestamp(List<Channel> threads) {
                String archiveTimestamp;
                if (threads.isEmpty()) {
                    return null;
                }
                ThreadMetadata threadMetadata = ((Channel) _Collections.last((List) threads)).getThreadMetadata();
                if (threadMetadata == null || (archiveTimestamp = threadMetadata.getArchiveTimestamp()) == null) {
                    throw new IllegalStateException("Thread missing threadMetadata");
                }
                return archiveTimestamp;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType$MY_ARCHIVED_PRIVATE_THREADS;", "Lcom/discord/stores/ArchivedThreadsStore$ThreadListingType;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/api/channel/Channel;", "threads", "Lrx/Observable;", "Lcom/discord/api/thread/ThreadListing;", "fetchNext", "(JLjava/util/List;)Lrx/Observable;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class MY_ARCHIVED_PRIVATE_THREADS extends ThreadListingType {
            public MY_ARCHIVED_PRIVATE_THREADS(String str, int i) {
                super(str, i, null);
            }

            @Override // com.discord.stores.ArchivedThreadsStore.ThreadListingType
            public Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads) {
                Intrinsics3.checkNotNullParameter(threads, "threads");
                Channel channel = (Channel) _Collections.lastOrNull((List) threads);
                return RestAPI.INSTANCE.getApi().getMyPrivateArchivedThreads(channelId, channel != null ? Long.valueOf(channel.getId()) : null);
            }
        }

        static {
            MY_ARCHIVED_PRIVATE_THREADS my_archived_private_threads = new MY_ARCHIVED_PRIVATE_THREADS("MY_ARCHIVED_PRIVATE_THREADS", 0);
            MY_ARCHIVED_PRIVATE_THREADS = my_archived_private_threads;
            ALL_ARCHIVED_PUBLIC_THREADS all_archived_public_threads = new ALL_ARCHIVED_PUBLIC_THREADS("ALL_ARCHIVED_PUBLIC_THREADS", 1);
            ALL_ARCHIVED_PUBLIC_THREADS = all_archived_public_threads;
            ALL_ARCHIVED_PRIVATE_THREADS all_archived_private_threads = new ALL_ARCHIVED_PRIVATE_THREADS("ALL_ARCHIVED_PRIVATE_THREADS", 2);
            ALL_ARCHIVED_PRIVATE_THREADS = all_archived_private_threads;
            $VALUES = new ThreadListingType[]{my_archived_private_threads, all_archived_public_threads, all_archived_private_threads};
            INSTANCE = new Companion(null);
        }

        private ThreadListingType(String str, int i) {
        }

        public static ThreadListingType valueOf(String str) {
            return (ThreadListingType) Enum.valueOf(ThreadListingType.class, str);
        }

        public static ThreadListingType[] values() {
            return (ThreadListingType[]) $VALUES.clone();
        }

        public abstract Observable<ThreadListing> fetchNext(long channelId, List<Channel> threads);

        public /* synthetic */ ThreadListingType(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }
    }

    /* compiled from: ArchivedThreadsStore.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Function0 $onTerminated;
        public final /* synthetic */ boolean $reload;
        public final /* synthetic */ ThreadListingType $threadListingType;

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00701 extends Lambda implements Function1<Subscription, Unit> {
            public final /* synthetic */ Tuples2 $key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00701(Tuples2 tuples2) {
                super(1);
                this.$key = tuples2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
                invoke2(subscription);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Subscription subscription) {
                Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
                ArchivedThreadsStore.access$getFetchSubscriptions$p(ArchivedThreadsStore.this).put(this.$key, subscription);
            }
        }

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ Tuples2 $key;

            /* compiled from: ArchivedThreadsStore.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C00711 extends Lambda implements Function0<Unit> {
                public C00711() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ArchivedThreadsStore.access$getListings$p(ArchivedThreadsStore.this).put(AnonymousClass2.this.$key, ThreadListingState.Error.INSTANCE);
                    ArchivedThreadsStore.this.markChanged();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Tuples2 tuples2) {
                super(1);
                this.$key = tuples2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                ArchivedThreadsStore.access$getDispatcher$p(ArchivedThreadsStore.this).schedule(new C00711());
            }
        }

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0 function0 = AnonymousClass1.this.$onTerminated;
                if (function0 != null) {
                }
            }
        }

        /* compiled from: ArchivedThreadsStore.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/thread/ThreadListing;", "result", "", "invoke", "(Lcom/discord/api/thread/ThreadListing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends Lambda implements Function1<ThreadListing, Unit> {
            public final /* synthetic */ List $currentThreads;
            public final /* synthetic */ Tuples2 $key;

            /* compiled from: ArchivedThreadsStore.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.ArchivedThreadsStore$fetchListing$1$4$1, reason: invalid class name and collision with other inner class name */
            public static final class C00721 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ThreadListing $result;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00721(ThreadListing threadListing) {
                    super(0);
                    this.$result = threadListing;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Iterator<T> it = this.$result.c().iterator();
                    while (it.hasNext()) {
                        ArchivedThreadsStore.access$getStoreStream$p(ArchivedThreadsStore.this).handleThreadCreateOrUpdate((Channel) it.next());
                    }
                    Map mapAccess$getListings$p = ArchivedThreadsStore.access$getListings$p(ArchivedThreadsStore.this);
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    mapAccess$getListings$p.put(anonymousClass4.$key, new ThreadListingState.Listing(_Collections.plus((Collection) anonymousClass4.$currentThreads, (Iterable) this.$result.c()), this.$result.getHasMore(), false));
                    List<Message> listA = this.$result.a();
                    if (listA != null) {
                        ArchivedThreadsStore.access$getStoreForumPostMessages$p(ArchivedThreadsStore.this).bulkCreateFirstMessage(listA);
                    }
                    ArchivedThreadsStore.this.markChanged();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(Tuples2 tuples2, List list) {
                super(1);
                this.$key = tuples2;
                this.$currentThreads = list;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ThreadListing threadListing) {
                invoke2(threadListing);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ThreadListing threadListing) {
                Intrinsics3.checkNotNullParameter(threadListing, "result");
                ArchivedThreadsStore.access$getDispatcher$p(ArchivedThreadsStore.this).schedule(new C00721(threadListing));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, ThreadListingType threadListingType, boolean z2, Function0 function0) {
            super(0);
            this.$channelId = j;
            this.$threadListingType = threadListingType;
            this.$reload = z2;
            this.$onTerminated = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Tuples2 tuples2 = new Tuples2(Long.valueOf(this.$channelId), this.$threadListingType);
            ThreadListingState threadListingState = (ThreadListingState) ArchivedThreadsStore.access$getListings$p(ArchivedThreadsStore.this).get(tuples2);
            boolean z2 = threadListingState instanceof ThreadListingState.Listing;
            List<Channel> listEmptyList = (!z2 || this.$reload) ? Collections2.emptyList() : ((ThreadListingState.Listing) threadListingState).getThreads();
            ArchivedThreadsStore.access$getListings$p(ArchivedThreadsStore.this).put(tuples2, z2 ? ThreadListingState.Listing.copy$default((ThreadListingState.Listing) threadListingState, null, false, true, 3, null) : new ThreadListingState.Listing(listEmptyList, true, true));
            ArchivedThreadsStore.this.markChanged();
            Subscription subscription = (Subscription) ArchivedThreadsStore.access$getFetchSubscriptions$p(ArchivedThreadsStore.this).get(tuples2);
            if (subscription != null) {
                subscription.unsubscribe();
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RetryWithDelay.restRetry$default(RetryWithDelay.INSTANCE, this.$threadListingType.fetchNext(this.$channelId, listEmptyList), 0L, null, null, 7, null), false, 1, null), ArchivedThreadsStore.this.getClass(), (Context) null, new C00701(tuples2), new AnonymousClass2(tuples2), (Function0) null, new AnonymousClass3(), new AnonymousClass4(tuples2, listEmptyList), 18, (Object) null);
        }
    }

    /* compiled from: ArchivedThreadsStore.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "invoke", "()Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.ArchivedThreadsStore$loadAndObserveThreadListing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ThreadListingState> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ ThreadListingType $threadListingType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, ThreadListingType threadListingType) {
            super(0);
            this.$channelId = j;
            this.$threadListingType = threadListingType;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ThreadListingState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ThreadListingState invoke() {
            ThreadListingState threadListingState = (ThreadListingState) ArchivedThreadsStore.access$getListingsSnapshot$p(ArchivedThreadsStore.this).get(new Tuples2(Long.valueOf(this.$channelId), this.$threadListingType));
            return threadListingState != null ? threadListingState : ThreadListingState.Uninitialized.INSTANCE;
        }
    }

    /* compiled from: ArchivedThreadsStore.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "invoke", "()Lcom/discord/stores/ArchivedThreadsStore$ThreadListingState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.ArchivedThreadsStore$observeGuildForumThreadListing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ThreadListingState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ThreadListingState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ThreadListingState invoke() {
            ThreadListingState threadListingState = (ThreadListingState) ArchivedThreadsStore.access$getListingsSnapshot$p(ArchivedThreadsStore.this).get(new Tuples2(Long.valueOf(this.$channelId), ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS));
            return threadListingState != null ? threadListingState : ThreadListingState.Uninitialized.INSTANCE;
        }
    }

    public /* synthetic */ ArchivedThreadsStore(StoreStream storeStream, Dispatcher dispatcher, StoreForumPostMessages storeForumPostMessages, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeForumPostMessages, (i & 8) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.dispatcher;
    }

    public static final /* synthetic */ Map access$getFetchSubscriptions$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.fetchSubscriptions;
    }

    public static final /* synthetic */ Map access$getListings$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.listings;
    }

    public static final /* synthetic */ Map access$getListingsSnapshot$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.listingsSnapshot;
    }

    public static final /* synthetic */ StoreForumPostMessages access$getStoreForumPostMessages$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.storeForumPostMessages;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(ArchivedThreadsStore archivedThreadsStore) {
        return archivedThreadsStore.storeStream;
    }

    public static final /* synthetic */ void access$setFetchSubscriptions$p(ArchivedThreadsStore archivedThreadsStore, Map map) {
        archivedThreadsStore.fetchSubscriptions = map;
    }

    public static final /* synthetic */ void access$setListings$p(ArchivedThreadsStore archivedThreadsStore, Map map) {
        archivedThreadsStore.listings = map;
    }

    public static final /* synthetic */ void access$setListingsSnapshot$p(ArchivedThreadsStore archivedThreadsStore, Map map) {
        archivedThreadsStore.listingsSnapshot = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchGuildForumThreadListing$default(ArchivedThreadsStore archivedThreadsStore, long j, boolean z2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        archivedThreadsStore.fetchGuildForumThreadListing(j, z2, function0);
    }

    public static /* synthetic */ void fetchListing$default(ArchivedThreadsStore archivedThreadsStore, long j, ThreadListingType threadListingType, boolean z2, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? false : z2;
        if ((i & 8) != 0) {
            function0 = null;
        }
        archivedThreadsStore.fetchListing(j, threadListingType, z3, function0);
    }

    public final void fetchGuildForumThreadListing(long channelId, boolean reload, Function0<Unit> onTerminated) {
        fetchListing(channelId, ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS, reload, onTerminated);
    }

    public final void fetchListing(long channelId, ThreadListingType threadListingType, boolean reload, Function0<Unit> onTerminated) {
        Intrinsics3.checkNotNullParameter(threadListingType, "threadListingType");
        this.dispatcher.schedule(new AnonymousClass1(channelId, threadListingType, reload, onTerminated));
    }

    @Store3
    public final void handleConnectionOpen() {
        this.listings = new HashMap();
        Iterator<T> it = this.fetchSubscriptions.values().iterator();
        while (it.hasNext()) {
            ((Subscription) it.next()).unsubscribe();
        }
        this.fetchSubscriptions = new HashMap();
        markChanged();
    }

    public final Observable<ThreadListingState> loadAndObserveGuildForumThreadListing(long channelId) {
        fetchGuildForumThreadListing$default(this, channelId, false, null, 6, null);
        return observeGuildForumThreadListing(channelId);
    }

    public final Observable<ThreadListingState> loadAndObserveThreadListing(long channelId, ThreadListingType threadListingType) {
        Intrinsics3.checkNotNullParameter(threadListingType, "threadListingType");
        fetchListing$default(this, channelId, threadListingType, true, null, 8, null);
        Observable<ThreadListingState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId, threadListingType), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ThreadListingState> observeGuildForumThreadListing(long channelId) {
        Observable<ThreadListingState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.listingsSnapshot = new HashMap(this.listings);
    }

    public ArchivedThreadsStore(StoreStream storeStream, Dispatcher dispatcher, StoreForumPostMessages storeForumPostMessages, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.storeForumPostMessages = storeForumPostMessages;
        this.observationDeck = observationDeck;
        this.listings = new HashMap();
        this.listingsSnapshot = new HashMap();
        this.fetchSubscriptions = new HashMap();
    }
}
