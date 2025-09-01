package com.discord.widgets.chat.list;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.stores.StoreChannelFollowerStats;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: PublishActionDialogViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\"#$%BC\u0012\n\u0010\u0015\u001a\u00060\u0010j\u0002`\u0014\u0012\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\tR\u001a\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00060\u0010j\u0002`\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R:\u0010\u001b\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\f0\f \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\f0\f\u0018\u00010\u00190\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$StoreState;)V", "emitSuccessActionEvent", "()V", "emitFailureEvent", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;", "observeEvents", "()Lrx/Observable;", "publishMessage", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lcom/discord/primitives/MessageId;", "messageId", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreChannelFollowerStats;", "storeChannelFollowerStats", "storeObservable", "<init>", "(JJLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreChannelFollowerStats;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PublishActionDialogViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final PublishSubject<Event> eventSubject;
    private final long messageId;
    private final RestAPI restAPI;

    /* compiled from: PublishActionDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            PublishActionDialogViewModel.access$handleStoreState(PublishActionDialogViewModel.this, storeState);
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreChannelFollowerStats;", "storeChannelFollowerStats", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$StoreState;", "observeChannelFollowerStatsStoreState", "(JLcom/discord/stores/StoreChannelFollowerStats;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeChannelFollowerStatsStoreState(Companion companion, long j, StoreChannelFollowerStats storeChannelFollowerStats) {
            return companion.observeChannelFollowerStatsStoreState(j, storeChannelFollowerStats);
        }

        private final Observable<StoreState> observeChannelFollowerStatsStoreState(long channelId, StoreChannelFollowerStats storeChannelFollowerStats) {
            Observable<StoreState> observableR = storeChannelFollowerStats.observeChannelFollowerStats(channelId).G(PublishActionDialogViewModel2.INSTANCE).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "storeChannelFollowerStat…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;", "", "<init>", "()V", "Failure", "Success", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event$Failure;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event$Success;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: PublishActionDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event$Failure;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;", "", "component1", "()I", "failureMessageStringRes", "copy", "(I)Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event$Failure;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getFailureMessageStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Failure extends Event {
            private final int failureMessageStringRes;

            public Failure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = failure.failureMessageStringRes;
                }
                return failure.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final Failure copy(int failureMessageStringRes) {
                return new Failure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Failure) && this.failureMessageStringRes == ((Failure) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("Failure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: PublishActionDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event$Success;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;", "", "component1", "()I", "successMessageStringRes", "copy", "(I)Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event$Success;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getSuccessMessageStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Success extends Event {
            private final int successMessageStringRes;

            public Success(int i) {
                super(null);
                this.successMessageStringRes = i;
            }

            public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = success.successMessageStringRes;
                }
                return success.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public final Success copy(int successMessageStringRes) {
                return new Success(successMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && this.successMessageStringRes == ((Success) other).successMessageStringRes;
                }
                return true;
            }

            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public int hashCode() {
                return this.successMessageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("Success(successMessageStringRes="), this.successMessageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$StoreState;", "", "Lcom/discord/models/domain/ModelChannelFollowerStats;", "followerStats", "Lcom/discord/models/domain/ModelChannelFollowerStats;", "getFollowerStats", "()Lcom/discord/models/domain/ModelChannelFollowerStats;", "<init>", "(Lcom/discord/models/domain/ModelChannelFollowerStats;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class StoreState {
        private final ModelChannelFollowerStats followerStats;

        public StoreState(ModelChannelFollowerStats modelChannelFollowerStats) {
            this.followerStats = modelChannelFollowerStats;
        }

        public final ModelChannelFollowerStats getFollowerStats() {
            return this.followerStats;
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;", "", "<init>", "()V", "LoadedHasFollowers", "LoadedNoFollowers", "Loading", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState$Loading;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState$LoadedNoFollowers;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState$LoadedHasFollowers;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: PublishActionDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState$LoadedHasFollowers;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;", "Lcom/discord/models/domain/ModelChannelFollowerStats;", "component1", "()Lcom/discord/models/domain/ModelChannelFollowerStats;", "followerStats", "copy", "(Lcom/discord/models/domain/ModelChannelFollowerStats;)Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState$LoadedHasFollowers;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelChannelFollowerStats;", "getFollowerStats", "<init>", "(Lcom/discord/models/domain/ModelChannelFollowerStats;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LoadedHasFollowers extends ViewState {
            private final ModelChannelFollowerStats followerStats;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadedHasFollowers(ModelChannelFollowerStats modelChannelFollowerStats) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelChannelFollowerStats, "followerStats");
                this.followerStats = modelChannelFollowerStats;
            }

            public static /* synthetic */ LoadedHasFollowers copy$default(LoadedHasFollowers loadedHasFollowers, ModelChannelFollowerStats modelChannelFollowerStats, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelChannelFollowerStats = loadedHasFollowers.followerStats;
                }
                return loadedHasFollowers.copy(modelChannelFollowerStats);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelChannelFollowerStats getFollowerStats() {
                return this.followerStats;
            }

            public final LoadedHasFollowers copy(ModelChannelFollowerStats followerStats) {
                Intrinsics3.checkNotNullParameter(followerStats, "followerStats");
                return new LoadedHasFollowers(followerStats);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LoadedHasFollowers) && Intrinsics3.areEqual(this.followerStats, ((LoadedHasFollowers) other).followerStats);
                }
                return true;
            }

            public final ModelChannelFollowerStats getFollowerStats() {
                return this.followerStats;
            }

            public int hashCode() {
                ModelChannelFollowerStats modelChannelFollowerStats = this.followerStats;
                if (modelChannelFollowerStats != null) {
                    return modelChannelFollowerStats.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("LoadedHasFollowers(followerStats=");
                sbU.append(this.followerStats);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: PublishActionDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState$LoadedNoFollowers;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class LoadedNoFollowers extends ViewState {
            public static final LoadedNoFollowers INSTANCE = new LoadedNoFollowers();

            private LoadedNoFollowers() {
                super(null);
            }
        }

        /* compiled from: PublishActionDialogViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState$Loading;", "Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$publishMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            PublishActionDialogViewModel.access$emitSuccessActionEvent(PublishActionDialogViewModel.this);
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$publishMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishActionDialogViewModel.access$emitFailureEvent(PublishActionDialogViewModel.this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PublishActionDialogViewModel(long j, long j2, RestAPI restAPI, StoreChannelFollowerStats storeChannelFollowerStats, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreChannelFollowerStats channelFollowerStats = (i & 8) != 0 ? StoreStream.INSTANCE.getChannelFollowerStats() : storeChannelFollowerStats;
        this(j, j2, api, channelFollowerStats, (i & 16) != 0 ? Companion.access$observeChannelFollowerStatsStoreState(INSTANCE, j2, channelFollowerStats) : observable);
    }

    public static final /* synthetic */ void access$emitFailureEvent(PublishActionDialogViewModel publishActionDialogViewModel) {
        publishActionDialogViewModel.emitFailureEvent();
    }

    public static final /* synthetic */ void access$emitSuccessActionEvent(PublishActionDialogViewModel publishActionDialogViewModel) {
        publishActionDialogViewModel.emitSuccessActionEvent();
    }

    public static final /* synthetic */ void access$handleStoreState(PublishActionDialogViewModel publishActionDialogViewModel, StoreState storeState) {
        publishActionDialogViewModel.handleStoreState(storeState);
    }

    private final void emitFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.Failure(R.string.default_failure_to_perform_action_message));
    }

    private final void emitSuccessActionEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.Success(R.string.message_published));
    }

    private final void handleStoreState(StoreState storeState) {
        Integer guildsFollowing;
        ModelChannelFollowerStats followerStats = storeState.getFollowerStats();
        int iIntValue = (followerStats == null || (guildsFollowing = followerStats.getGuildsFollowing()) == null) ? 0 : guildsFollowing.intValue();
        if ((followerStats != null ? followerStats.getGuildsFollowing() : null) == null || iIntValue <= 0) {
            updateViewState(ViewState.LoadedNoFollowers.INSTANCE);
        } else {
            updateViewState(new ViewState.LoadedHasFollowers(followerStats));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void publishMessage() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.crosspostMessage(this.channelId, Long.valueOf(this.messageId)), false, 1, null), this, null, 2, null), PublishActionDialogViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialogViewModel(long j, long j2, RestAPI restAPI, StoreChannelFollowerStats storeChannelFollowerStats, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeChannelFollowerStats, "storeChannelFollowerStats");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.messageId = j;
        this.channelId = j2;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        storeChannelFollowerStats.fetchChannelFollowerStats(j2);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), PublishActionDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
