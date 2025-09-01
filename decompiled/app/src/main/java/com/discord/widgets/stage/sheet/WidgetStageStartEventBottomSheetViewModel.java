package com.discord.widgets.stage.sheet;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageChannelAPI;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004-./0B7\u0012\n\u0010$\u001a\u00060\"j\u0002`#\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR:\u0010 \u001a&\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00100\u0010 \u001f*\u0012\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\u00060\"j\u0002`#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010)¨\u00061"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;)V", "setSelfSpeaker", "()V", "Lcom/discord/api/channel/Channel;", "channel", "emitSetStatusSuccessEvent", "(Lcom/discord/api/channel/Channel;)V", "emitSetStatusFailureEvent", "Lrx/Observable;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "setTopic", "(Ljava/lang/String;)V", "", "microphonePermissionGranted", "openStage", "(Z)V", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lcom/discord/stores/StoreStageInstances;", "stageInstanceStore", "Lcom/discord/stores/StoreStageInstances;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;", "storeStateObservable", "<init>", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreStageInstances;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private final StoreStageInstances stageInstanceStore;
    private StoreState storeState;

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$1, reason: invalid class name */
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
            WidgetStageStartEventBottomSheetViewModel.access$handleStoreState(WidgetStageStartEventBottomSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreStageInstances;", "stageInstanceStore", "Lrx/Observable;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreStageInstances;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances) {
            return companion.observeStoreState(j, storeChannels, storeStageInstances);
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreChannels channelsStore, StoreStageInstances stageInstanceStore) {
            Observable<R> observableG = channelsStore.observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableJ = Observable.j(observableG, stageInstanceStore.observeStageInstanceForChannel(channelId).z(), WidgetStageStartEventBottomSheetViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest… stageInstance)\n        }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event;", "", "<init>", "()V", "InvalidTopic", "SetTopicFailure", "SetTopicSuccess", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event;", "", "component1", "()I", "failureMessageStringRes", "copy", "(I)Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event$InvalidTopic;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getFailureMessageStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class InvalidTopic extends Event {
            private final int failureMessageStringRes;

            public InvalidTopic(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ InvalidTopic copy$default(InvalidTopic invalidTopic, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = invalidTopic.failureMessageStringRes;
                }
                return invalidTopic.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final InvalidTopic copy(int failureMessageStringRes) {
                return new InvalidTopic(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof InvalidTopic) && this.failureMessageStringRes == ((InvalidTopic) other).failureMessageStringRes;
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
                return outline.B(outline.U("InvalidTopic(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event;", "", "component1", "()I", "failureMessageStringRes", "copy", "(I)Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event$SetTopicFailure;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getFailureMessageStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SetTopicFailure extends Event {
            private final int failureMessageStringRes;

            public SetTopicFailure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ SetTopicFailure copy$default(SetTopicFailure setTopicFailure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = setTopicFailure.failureMessageStringRes;
                }
                return setTopicFailure.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final SetTopicFailure copy(int failureMessageStringRes) {
                return new SetTopicFailure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetTopicFailure) && this.failureMessageStringRes == ((SetTopicFailure) other).failureMessageStringRes;
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
                return outline.B(outline.U("SetTopicFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "channel", "copy", "(Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$Event$SetTopicSuccess;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SetTopicSuccess extends Event {
            private final Channel channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetTopicSuccess(Channel channel) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
            }

            public static /* synthetic */ SetTopicSuccess copy$default(SetTopicSuccess setTopicSuccess, Channel channel, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = setTopicSuccess.channel;
                }
                return setTopicSuccess.copy(channel);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final SetTopicSuccess copy(Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new SetTopicSuccess(channel);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetTopicSuccess) && Intrinsics3.areEqual(this.channel, ((SetTopicSuccess) other).channel);
                }
                return true;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public int hashCode() {
                Channel channel = this.channel;
                if (channel != null) {
                    return channel.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SetTopicSuccess(channel=");
                sbU.append(this.channel);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/api/stageinstance/StageInstance;", "component2", "()Lcom/discord/api/stageinstance/StageInstance;", "channel", "stageInstance", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/stageinstance/StageInstance;)Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/stageinstance/StageInstance;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final StageInstance stageInstance;

        public StoreState(Channel channel, StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.stageInstance = stageInstance;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, StageInstance stageInstance, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i & 2) != 0) {
                stageInstance = storeState.stageInstance;
            }
            return storeState.copy(channel, stageInstance);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final StoreState copy(Channel channel, StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new StoreState(channel, stageInstance);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.stageInstance, storeState.stageInstance);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            StageInstance stageInstance = this.stageInstance;
            return iHashCode + (stageInstance != null ? stageInstance.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channel=");
            sbU.append(this.channel);
            sbU.append(", stageInstance=");
            sbU.append(this.stageInstance);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Loaded", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\n¨\u0006!"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Ljava/lang/String;", "Lcom/discord/api/stageinstance/StageInstance;", "component3", "()Lcom/discord/api/stageinstance/StageInstance;", "channel", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "stageInstance", "copy", "(Lcom/discord/api/channel/Channel;Ljava/lang/String;Lcom/discord/api/stageinstance/StageInstance;)Lcom/discord/widgets/stage/sheet/WidgetStageStartEventBottomSheetViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Ljava/lang/String;", "getTopic", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/lang/String;Lcom/discord/api/stageinstance/StageInstance;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final StageInstance stageInstance;
            private final String topic;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Channel channel, String str, StageInstance stageInstance) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                this.channel = channel;
                this.topic = str;
                this.stageInstance = stageInstance;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, String str, StageInstance stageInstance, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 2) != 0) {
                    str = loaded.topic;
                }
                if ((i & 4) != 0) {
                    stageInstance = loaded.stageInstance;
                }
                return loaded.copy(channel, str, stageInstance);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final String getTopic() {
                return this.topic;
            }

            /* renamed from: component3, reason: from getter */
            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final Loaded copy(Channel channel, String topic, StageInstance stageInstance) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
                return new Loaded(channel, topic, stageInstance);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.channel, loaded.channel) && Intrinsics3.areEqual(this.topic, loaded.topic) && Intrinsics3.areEqual(this.stageInstance, loaded.stageInstance);
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final String getTopic() {
                return this.topic;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                String str = this.topic;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                StageInstance stageInstance = this.stageInstance;
                return iHashCode2 + (stageInstance != null ? stageInstance.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(channel=");
                sbU.append(this.channel);
                sbU.append(", topic=");
                sbU.append(this.topic);
                sbU.append(", stageInstance=");
                sbU.append(this.stageInstance);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
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
            WidgetStageStartEventBottomSheetViewModel.access$emitSetStatusFailureEvent(WidgetStageStartEventBottomSheetViewModel.this);
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/stageinstance/StageInstance;", "it", "", "invoke", "(Lcom/discord/api/stageinstance/StageInstance;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StageInstance, Unit> {
        public final /* synthetic */ boolean $microphonePermissionGranted;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, ViewState.Loaded loaded) {
            super(1);
            this.$microphonePermissionGranted = z2;
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(stageInstance, "it");
            if (this.$microphonePermissionGranted) {
                WidgetStageStartEventBottomSheetViewModel.access$setSelfSpeaker(WidgetStageStartEventBottomSheetViewModel.this);
            }
            WidgetStageStartEventBottomSheetViewModel.access$emitSetStatusSuccessEvent(WidgetStageStartEventBottomSheetViewModel.this, this.$viewState.getChannel());
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            WidgetStageStartEventBottomSheetViewModel.access$emitSetStatusFailureEvent(WidgetStageStartEventBottomSheetViewModel.this);
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/stageinstance/StageInstance;", "it", "", "invoke", "(Lcom/discord/api/stageinstance/StageInstance;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$openStage$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<StageInstance, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(stageInstance, "it");
            WidgetStageStartEventBottomSheetViewModel.access$emitSetStatusSuccessEvent(WidgetStageStartEventBottomSheetViewModel.this, this.$viewState.getChannel());
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$setSelfSpeaker$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
        }
    }

    /* compiled from: WidgetStageStartEventBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel$setSelfSpeaker$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

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
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetStageStartEventBottomSheetViewModel(long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreStageInstances stageInstances = (i & 4) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances;
        this(j, channels, stageInstances, (i & 8) != 0 ? Companion.access$observeStoreState(INSTANCE, j, channels, stageInstances) : observable);
    }

    public static final /* synthetic */ void access$emitSetStatusFailureEvent(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel) {
        widgetStageStartEventBottomSheetViewModel.emitSetStatusFailureEvent();
    }

    public static final /* synthetic */ void access$emitSetStatusSuccessEvent(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel, Channel channel) {
        widgetStageStartEventBottomSheetViewModel.emitSetStatusSuccessEvent(channel);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel, StoreState storeState) {
        widgetStageStartEventBottomSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$setSelfSpeaker(WidgetStageStartEventBottomSheetViewModel widgetStageStartEventBottomSheetViewModel) {
        widgetStageStartEventBottomSheetViewModel.setSelfSpeaker();
    }

    private final void emitSetStatusFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetTopicFailure(R.string.default_failure_to_perform_action_message));
    }

    private final void emitSetStatusSuccessEvent(Channel channel) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetTopicSuccess(channel));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        String topic;
        this.storeState = storeState;
        Channel channel = storeState.getChannel();
        StageInstance stageInstance = storeState.getStageInstance();
        if (stageInstance == null || (topic = stageInstance.getTopic()) == null) {
            topic = "";
        }
        updateViewState(new ViewState.Loaded(channel, topic, storeState.getStageInstance()));
    }

    private final void setSelfSpeaker() {
        Channel channel;
        StoreState storeState = this.storeState;
        if (storeState == null || (channel = storeState.getChannel()) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(channel, false), false, 1, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, AnonymousClass2.INSTANCE, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 54, (Object) null);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void openStage(boolean microphonePermissionGranted) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            String topic = loaded.getTopic();
            Objects.requireNonNull(topic, "null cannot be cast to non-null type kotlin.CharSequence");
            String string = Strings4.trim(topic).toString();
            String str = string.length() > 0 ? string : null;
            if (str == null) {
                this.eventSubject.k.onNext(new Event.InvalidTopic(R.string.start_stage_channel_event_modal_topic_required));
            } else if (loaded.getStageInstance() == null) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.startStageInstance$default(StageChannelAPI.INSTANCE, this.channelId, str, StageInstancePrivacyLevel.GUILD_ONLY, false, null, 16, null), false, 1, null), this, null, 2, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(microphonePermissionGranted, loaded), 54, (Object) null);
            } else {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.updateStageInstance$default(StageChannelAPI.INSTANCE, this.channelId, str, null, 4, null), false, 1, null), this, null, 2, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass4(loaded), 54, (Object) null);
            }
        }
    }

    public final void setTopic(String topic) {
        Intrinsics3.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, topic, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheetViewModel(long j, StoreChannels storeChannels, StoreStageInstances storeStageInstances, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeStageInstances, "stageInstanceStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.channelsStore = storeChannels;
        this.stageInstanceStore = storeStageInstances;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetStageStartEventBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}
