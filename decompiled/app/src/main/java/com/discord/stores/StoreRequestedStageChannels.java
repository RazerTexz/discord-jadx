package com.discord.stores;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Result3;
import d0.t.Maps6;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import rx.Observable;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* compiled from: StoreRequestedStageChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u000389:B#\u0012\u0006\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010.\u001a\u00020-\u0012\b\b\u0002\u00104\u001a\u000203¢\u0006\u0004\b6\u00107J)\u0010\t\u001a\u00020\b2\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000e\u001a\u00020\b2\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00110\u00100\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00182\n\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\b2\n\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\b2\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\"R&\u0010#\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010)\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R&\u0010,\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00110+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010$R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/discord/stores/StoreRequestedStageChannels;", "Lcom/discord/stores/StoreV2;", "", "", "Lcom/discord/primitives/ChannelId;", "channelIds", "Lcom/discord/stores/StoreRequestedStageChannels$FetchStatus;", "status", "", "updateStatus", "(Ljava/util/Set;Lcom/discord/stores/StoreRequestedStageChannels$FetchStatus;)V", "", "Lcom/discord/api/stageinstance/RecommendedStageInstance;", "stageInstances", "onLoaded", "(Ljava/util/Set;Ljava/util/List;)V", "", "Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "getRequestedInstanceStatesByChannel", "()Ljava/util/Map;", "channelId", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstanceForChannel", "(J)Lcom/discord/api/stageinstance/StageInstance;", "Lrx/Observable;", "observeRequestedStageChannels", "()Lrx/Observable;", "observeRequestedStageChannel", "(J)Lrx/Observable;", "enqueueStageChannelFetch", "(J)V", "fetchStageChannels", "(Ljava/util/Set;)V", "snapshotData", "()V", "requestedStageChannelsSnapshot", "Ljava/util/Map;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "enqueuedChannelFetches", "Ljava/util/Set;", "", "requestedStageChannels", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lkotlinx/coroutines/Job;", "enqueuedChannelFetchJob", "Lkotlinx/coroutines/Job;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/rest/RestAPI;)V", "Companion", "FetchStatus", "StageInstanceState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreRequestedStageChannels extends StoreV2 {
    private static final long ENQUEUE_DEBOUNCE_DELAY_MS = 22;
    private final Dispatcher dispatcher;
    private Job enqueuedChannelFetchJob;
    private Set<Long> enqueuedChannelFetches;
    private final ObservationDeck observationDeck;
    private final Map<Long, StageInstanceState> requestedStageChannels;
    private Map<Long, StageInstanceState> requestedStageChannelsSnapshot;
    private final RestAPI restAPI;

    /* compiled from: StoreRequestedStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreRequestedStageChannels$FetchStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ERROR", "LOADING", "LOADED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum FetchStatus {
        ERROR,
        LOADING,
        LOADED
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\tR\u0019\u0010\u000e\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\f¨\u0006 "}, d2 = {"Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "", "", "isLoading", "()Z", "isError", "isLoaded", "Lcom/discord/api/stageinstance/RecommendedStageInstance;", "component1", "()Lcom/discord/api/stageinstance/RecommendedStageInstance;", "Lcom/discord/stores/StoreRequestedStageChannels$FetchStatus;", "component2", "()Lcom/discord/stores/StoreRequestedStageChannels$FetchStatus;", "stageInstance", "status", "copy", "(Lcom/discord/api/stageinstance/RecommendedStageInstance;Lcom/discord/stores/StoreRequestedStageChannels$FetchStatus;)Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/stageinstance/RecommendedStageInstance;", "getStageInstance", "Lcom/discord/stores/StoreRequestedStageChannels$FetchStatus;", "getStatus", "<init>", "(Lcom/discord/api/stageinstance/RecommendedStageInstance;Lcom/discord/stores/StoreRequestedStageChannels$FetchStatus;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StageInstanceState {
        private final RecommendedStageInstance stageInstance;
        private final FetchStatus status;

        public StageInstanceState(RecommendedStageInstance recommendedStageInstance, FetchStatus fetchStatus) {
            Intrinsics3.checkNotNullParameter(fetchStatus, "status");
            this.stageInstance = recommendedStageInstance;
            this.status = fetchStatus;
        }

        public static /* synthetic */ StageInstanceState copy$default(StageInstanceState stageInstanceState, RecommendedStageInstance recommendedStageInstance, FetchStatus fetchStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                recommendedStageInstance = stageInstanceState.stageInstance;
            }
            if ((i & 2) != 0) {
                fetchStatus = stageInstanceState.status;
            }
            return stageInstanceState.copy(recommendedStageInstance, fetchStatus);
        }

        /* renamed from: component1, reason: from getter */
        public final RecommendedStageInstance getStageInstance() {
            return this.stageInstance;
        }

        /* renamed from: component2, reason: from getter */
        public final FetchStatus getStatus() {
            return this.status;
        }

        public final StageInstanceState copy(RecommendedStageInstance stageInstance, FetchStatus status) {
            Intrinsics3.checkNotNullParameter(status, "status");
            return new StageInstanceState(stageInstance, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StageInstanceState)) {
                return false;
            }
            StageInstanceState stageInstanceState = (StageInstanceState) other;
            return Intrinsics3.areEqual(this.stageInstance, stageInstanceState.stageInstance) && Intrinsics3.areEqual(this.status, stageInstanceState.status);
        }

        public final RecommendedStageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final FetchStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            RecommendedStageInstance recommendedStageInstance = this.stageInstance;
            int iHashCode = (recommendedStageInstance != null ? recommendedStageInstance.hashCode() : 0) * 31;
            FetchStatus fetchStatus = this.status;
            return iHashCode + (fetchStatus != null ? fetchStatus.hashCode() : 0);
        }

        public final boolean isError() {
            return this.status == FetchStatus.ERROR;
        }

        public final boolean isLoaded() {
            return this.status == FetchStatus.LOADED;
        }

        public final boolean isLoading() {
            return this.status == FetchStatus.LOADING;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StageInstanceState(stageInstance=");
            sbU.append(this.stageInstance);
            sbU.append(", status=");
            sbU.append(this.status);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    @DebugMetadata(c = "com.discord.stores.StoreRequestedStageChannels$enqueueStageChannelFetch$1", f = "StoreRequestedStageChannels.kt", l = {60}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRequestedStageChannels$enqueueStageChannelFetch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return StoreRequestedStageChannels.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                this.label = 1;
                if (f.P(StoreRequestedStageChannels.ENQUEUE_DEBOUNCE_DELAY_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            Set<Long> setAccess$getEnqueuedChannelFetches$p = StoreRequestedStageChannels.access$getEnqueuedChannelFetches$p(StoreRequestedStageChannels.this);
            StoreRequestedStageChannels.access$setEnqueuedChannelFetches$p(StoreRequestedStageChannels.this, new LinkedHashSet());
            StoreRequestedStageChannels.this.fetchStageChannels(setAccess$getEnqueuedChannelFetches$p);
            return Unit.a;
        }
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Set $channelIds;

        /* compiled from: StoreRequestedStageChannels.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01661 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ Set $channelIdsToRequest;

            /* compiled from: StoreRequestedStageChannels.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01671 extends Lambda implements Function0<Unit> {
                public C01671() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C01661 c01661 = C01661.this;
                    StoreRequestedStageChannels.access$updateStatus(StoreRequestedStageChannels.this, c01661.$channelIdsToRequest, FetchStatus.ERROR);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01661(Set set) {
                super(1);
                this.$channelIdsToRequest = set;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreRequestedStageChannels.access$getDispatcher$p(StoreRequestedStageChannels.this).schedule(new C01671());
            }
        }

        /* compiled from: StoreRequestedStageChannels.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/stageinstance/RecommendedStageInstance;", "stageInstances", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends RecommendedStageInstance>, Unit> {
            public final /* synthetic */ Set $channelIdsToRequest;

            /* compiled from: StoreRequestedStageChannels.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreRequestedStageChannels$fetchStageChannels$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01681 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $stageInstances;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01681(List list) {
                    super(0);
                    this.$stageInstances = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    StoreRequestedStageChannels.access$onLoaded(StoreRequestedStageChannels.this, anonymousClass2.$channelIdsToRequest, this.$stageInstances);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Set set) {
                super(1);
                this.$channelIdsToRequest = set;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RecommendedStageInstance> list) {
                invoke2((List<RecommendedStageInstance>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<RecommendedStageInstance> list) {
                Intrinsics3.checkNotNullParameter(list, "stageInstances");
                StoreRequestedStageChannels.access$getDispatcher$p(StoreRequestedStageChannels.this).schedule(new C01681(list));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Set set) {
            super(0);
            this.$channelIds = set;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set set = this.$channelIds;
            ArrayList arrayList = new ArrayList();
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Set<Long> set2 = _Collections.toSet(arrayList);
                    StoreRequestedStageChannels.access$updateStatus(StoreRequestedStageChannels.this, set2, FetchStatus.LOADING);
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreRequestedStageChannels.access$getRestAPI$p(StoreRequestedStageChannels.this).getStageInstancesForChannels(set2), false, 1, null), StoreRequestedStageChannels.this.getClass(), (Context) null, (Function1) null, new C01661(set2), (Function0) null, (Function0) null, new AnonymousClass2(set2), 54, (Object) null);
                    return;
                } else {
                    Object next = it.next();
                    StageInstanceState stageInstanceState = (StageInstanceState) StoreRequestedStageChannels.access$getRequestedStageChannelsSnapshot$p(StoreRequestedStageChannels.this).get(Long.valueOf(((Number) next).longValue()));
                    if (stageInstanceState == null || !stageInstanceState.isLoading()) {
                        arrayList.add(next);
                    }
                }
            }
        }
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\u0004\u0018\u00010\u00032.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRequestedStageChannels$observeRequestedStageChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends StageInstanceState>, StageInstanceState> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ StageInstanceState call(Map<Long, ? extends StageInstanceState> map) {
            return call2((Map<Long, StageInstanceState>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StageInstanceState call2(Map<Long, StageInstanceState> map) {
            return map.get(Long.valueOf(this.$channelId));
        }
    }

    /* compiled from: StoreRequestedStageChannels.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreRequestedStageChannels$StageInstanceState;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreRequestedStageChannels$observeRequestedStageChannels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends StageInstanceState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends StageInstanceState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends StageInstanceState> invoke2() {
            return StoreRequestedStageChannels.this.getRequestedInstanceStatesByChannel();
        }
    }

    public /* synthetic */ StoreRequestedStageChannels(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.dispatcher;
    }

    public static final /* synthetic */ Set access$getEnqueuedChannelFetches$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.enqueuedChannelFetches;
    }

    public static final /* synthetic */ Map access$getRequestedStageChannelsSnapshot$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.requestedStageChannelsSnapshot;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreRequestedStageChannels storeRequestedStageChannels) {
        return storeRequestedStageChannels.restAPI;
    }

    public static final /* synthetic */ void access$onLoaded(StoreRequestedStageChannels storeRequestedStageChannels, Set set, List list) {
        storeRequestedStageChannels.onLoaded(set, list);
    }

    public static final /* synthetic */ void access$setEnqueuedChannelFetches$p(StoreRequestedStageChannels storeRequestedStageChannels, Set set) {
        storeRequestedStageChannels.enqueuedChannelFetches = set;
    }

    public static final /* synthetic */ void access$setRequestedStageChannelsSnapshot$p(StoreRequestedStageChannels storeRequestedStageChannels, Map map) {
        storeRequestedStageChannels.requestedStageChannelsSnapshot = map;
    }

    public static final /* synthetic */ void access$updateStatus(StoreRequestedStageChannels storeRequestedStageChannels, Set set, FetchStatus fetchStatus) {
        storeRequestedStageChannels.updateStatus(set, fetchStatus);
    }

    @Store3
    private final void onLoaded(Set<Long> channelIds, List<RecommendedStageInstance> stageInstances) {
        Set mutableSet = _Collections.toMutableSet(channelIds);
        for (RecommendedStageInstance recommendedStageInstance : stageInstances) {
            this.requestedStageChannels.put(Long.valueOf(recommendedStageInstance.getInstance().getChannelId()), new StageInstanceState(recommendedStageInstance, FetchStatus.LOADED));
            mutableSet.remove(Long.valueOf(recommendedStageInstance.getInstance().getChannelId()));
        }
        Iterator it = mutableSet.iterator();
        while (it.hasNext()) {
            this.requestedStageChannels.put(Long.valueOf(((Number) it.next()).longValue()), new StageInstanceState(null, FetchStatus.LOADED));
        }
        markChanged();
    }

    @Store3
    private final void updateStatus(Set<Long> channelIds, FetchStatus status) {
        Iterator<T> it = channelIds.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            StageInstanceState stageInstanceState = this.requestedStageChannels.get(Long.valueOf(jLongValue));
            this.requestedStageChannels.put(Long.valueOf(jLongValue), new StageInstanceState(stageInstanceState != null ? stageInstanceState.getStageInstance() : null, status));
        }
        markChanged();
    }

    @MainThread
    public final void enqueueStageChannelFetch(long channelId) {
        StageInstanceState stageInstanceState = this.requestedStageChannelsSnapshot.get(Long.valueOf(channelId));
        if (stageInstanceState == null || stageInstanceState.isError()) {
            this.enqueuedChannelFetches.add(Long.valueOf(channelId));
            Job job = this.enqueuedChannelFetchJob;
            if (job == null || !job.a()) {
                CoroutineScope2 coroutineScope2 = CoroutineScope2.j;
                CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                this.enqueuedChannelFetchJob = f.H0(coroutineScope2, MainDispatchers.f3830b, null, new AnonymousClass1(null), 2, null);
            }
        }
    }

    public final void fetchStageChannels(Set<Long> channelIds) {
        Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
        this.dispatcher.schedule(new AnonymousClass1(channelIds));
    }

    public final Map<Long, StageInstanceState> getRequestedInstanceStatesByChannel() {
        return this.requestedStageChannelsSnapshot;
    }

    public final StageInstance getStageInstanceForChannel(long channelId) {
        RecommendedStageInstance stageInstance;
        StageInstanceState stageInstanceState = getRequestedInstanceStatesByChannel().get(Long.valueOf(channelId));
        if (stageInstanceState == null || (stageInstance = stageInstanceState.getStageInstance()) == null) {
            return null;
        }
        return stageInstance.getInstance();
    }

    public final Observable<StageInstanceState> observeRequestedStageChannel(long channelId) {
        Observable observableG = observeRequestedStageChannels().G(new AnonymousClass1(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableG, "observeRequestedStageCha…s().map { it[channelId] }");
        return observableG;
    }

    public final Observable<Map<Long, StageInstanceState>> observeRequestedStageChannels() {
        Observable<Map<Long, StageInstanceState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.requestedStageChannelsSnapshot = Maps6.toMap(this.requestedStageChannels);
    }

    public StoreRequestedStageChannels(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.requestedStageChannels = new LinkedHashMap();
        this.requestedStageChannelsSnapshot = Maps6.emptyMap();
        this.enqueuedChannelFetches = new LinkedHashSet();
    }
}
