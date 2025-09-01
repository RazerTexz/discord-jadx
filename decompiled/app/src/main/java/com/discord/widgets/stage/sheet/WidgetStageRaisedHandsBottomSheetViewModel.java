package com.discord.widgets.stage.sheet;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
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
import rx.subjects.PublishSubject;

/* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004?@ABB_\u0012\n\u0010'\u001a\u00060\u0003j\u0002`&\u0012\b\b\u0002\u00104\u001a\u000203\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u00107\u001a\u000206\u0012\b\b\u0002\u00109\u001a\u000208\u0012\b\b\u0002\u0010;\u001a\u00020:\u0012\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b=\u0010>J+\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\b¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b!\u0010 J\u0015\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u001cR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\u00060\u0003j\u0002`&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R:\u0010+\u001a&\u0012\f\u0012\n **\u0004\u0018\u00010\u00170\u0017 **\u0012\u0012\f\u0012\n **\u0004\u0018\u00010\u00170\u0017\u0018\u00010)0)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006C"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState;", "", "Lcom/discord/primitives/UserId;", "userId", "", "isSuppressed", "Lrx/Observable;", "Ljava/lang/Void;", "setUserSuppressed", "(JZ)Lrx/Observable;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;)V", "emitDismiss", "()V", "Lcom/discord/utilities/error/Error;", "error", "emitError", "(Lcom/discord/utilities/error/Error;)V", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "isEnabled", "setRequestToSpeakEnabled", "(Z)V", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "participant", "dismissRequestToSpeak", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", "inviteToSpeak", "setSpeakingState", "Lcom/discord/stores/StoreUser;", "usersStore", "Lcom/discord/stores/StoreUser;", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lrx/Subscription;", "lastRequestToSpeakSubscription", "Lrx/Subscription;", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreVoiceParticipants;", "voiceParticipants", "Lcom/discord/stores/StoreVoiceParticipants;", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreStageChannels;", "stageChannelsStore", "Lcom/discord/utilities/time/Clock;", "clock", "storeStateObservable", "<init>", "(JLcom/discord/stores/StoreVoiceParticipants;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreStageChannels;Lcom/discord/utilities/time/Clock;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private Subscription lastRequestToSpeakSubscription;
    private final StoreUser usersStore;
    private final StoreVoiceParticipants voiceParticipants;

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$1, reason: invalid class name */
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
            WidgetStageRaisedHandsBottomSheetViewModel.access$handleStoreState(WidgetStageRaisedHandsBottomSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JI\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreVoiceParticipants;", "voiceParticipants", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreStageChannels;", "stageChannels", "Lcom/discord/utilities/time/Clock;", "clock", "Lrx/Observable;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreVoiceParticipants;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreStageChannels;Lcom/discord/utilities/time/Clock;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreVoiceParticipants storeVoiceParticipants, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreStageChannels storeStageChannels, Clock clock) {
            return companion.observeStoreState(j, storeVoiceParticipants, storeChannels, storeGuilds, storeStageChannels, clock);
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreVoiceParticipants voiceParticipants, StoreChannels channelsStore, StoreGuilds guildsStore, StoreStageChannels stageChannels, Clock clock) {
            Observable<R> observableG = channelsStore.observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableY = observableG.r().Y(new WidgetStageRaisedHandsBottomSheetViewModel2(guildsStore, voiceParticipants, channelId, stageChannels, clock));
            Intrinsics3.checkNotNullExpressionValue(observableY, "channelsStore.observeCha…          }\n            }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event;", "", "<init>", "()V", "Dismiss", "Error", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event$Dismiss;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event$Error;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event$Dismiss;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event$Error;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event;", "Lcom/discord/utilities/error/Error;", "component1", "()Lcom/discord/utilities/error/Error;", "error", "copy", "(Lcom/discord/utilities/error/Error;)Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/error/Error;", "getError", "<init>", "(Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Error extends Event {
            private final com.discord.utilities.error.Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(com.discord.utilities.error.Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ Error copy$default(Error error, com.discord.utilities.error.Error error2, int i, Object obj) {
                if ((i & 1) != 0) {
                    error2 = error.error;
                }
                return error.copy(error2);
            }

            /* renamed from: component1, reason: from getter */
            public final com.discord.utilities.error.Error getError() {
                return this.error;
            }

            public final Error copy(com.discord.utilities.error.Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && Intrinsics3.areEqual(this.error, ((Error) other).error);
                }
                return true;
            }

            public final com.discord.utilities.error.Error getError() {
                return this.error;
            }

            public int hashCode() {
                com.discord.utilities.error.Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Error(error=");
                sbU.append(this.error);
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

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u000fHÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011JT\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0011J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R)\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\nR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u0011R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010\u000eR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u0004\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component2", "()Ljava/util/Map;", "", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem;", "component3", "()Ljava/util/List;", "Lcom/discord/widgets/stage/StageRoles;", "component4-1LxfuJo", "()I", "component4", "channel", "roles", "raisedHandsParticipants", "myStageRoles", "copy-FZjiw-U", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/List;I)Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$StoreState;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getRoles", "I", "getMyStageRoles-1LxfuJo", "Ljava/util/List;", "getRaisedHandsParticipants", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/List;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final int myStageRoles;
        private final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> raisedHandsParticipants;
        private final Map<Long, GuildRole> roles;

        /* JADX WARN: Multi-variable type inference failed */
        private StoreState(Channel channel, Map<Long, GuildRole> map, List<? extends WidgetStageRaisedHandsBottomSheetAdapter.ListItem> list, int i) {
            this.channel = channel;
            this.roles = map;
            this.raisedHandsParticipants = list;
            this.myStageRoles = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: copy-FZjiw-U$default, reason: not valid java name */
        public static /* synthetic */ StoreState m47copyFZjiwU$default(StoreState storeState, Channel channel, Map map, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i2 & 2) != 0) {
                map = storeState.roles;
            }
            if ((i2 & 4) != 0) {
                list = storeState.raisedHandsParticipants;
            }
            if ((i2 & 8) != 0) {
                i = storeState.myStageRoles;
            }
            return storeState.m49copyFZjiwU(channel, map, list, i);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, GuildRole> component2() {
            return this.roles;
        }

        public final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> component3() {
            return this.raisedHandsParticipants;
        }

        /* renamed from: component4-1LxfuJo, reason: not valid java name and from getter */
        public final int getMyStageRoles() {
            return this.myStageRoles;
        }

        /* renamed from: copy-FZjiw-U, reason: not valid java name */
        public final StoreState m49copyFZjiwU(Channel channel, Map<Long, GuildRole> roles, List<? extends WidgetStageRaisedHandsBottomSheetAdapter.ListItem> raisedHandsParticipants, int myStageRoles) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(roles, "roles");
            Intrinsics3.checkNotNullParameter(raisedHandsParticipants, "raisedHandsParticipants");
            return new StoreState(channel, roles, raisedHandsParticipants, myStageRoles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.roles, storeState.roles) && Intrinsics3.areEqual(this.raisedHandsParticipants, storeState.raisedHandsParticipants) && this.myStageRoles == storeState.myStageRoles;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: getMyStageRoles-1LxfuJo, reason: not valid java name */
        public final int m50getMyStageRoles1LxfuJo() {
            return this.myStageRoles;
        }

        public final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> getRaisedHandsParticipants() {
            return this.raisedHandsParticipants;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Map<Long, GuildRole> map = this.roles;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> list = this.raisedHandsParticipants;
            return ((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.myStageRoles;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channel=");
            sbU.append(this.channel);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", raisedHandsParticipants=");
            sbU.append(this.raisedHandsParticipants);
            sbU.append(", myStageRoles=");
            sbU.append(StageRoles.m34toStringimpl(this.myStageRoles));
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ StoreState(Channel channel, Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(channel, map, list, i);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Loaded", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Invalid;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJR\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\bR\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\u0013\u0010\u000bR\u0019\u0010&\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b&\u0010\u000bR\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\u0012\u0010\u000b¨\u0006)"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "component4", "component5", "component6", "channel", "raisedHandsParticipants", "isRequestToSpeakEnabled", "isSpeaker", "isUpdatingRequestToSpeakPermissions", "isTogglingSpeakingState", "copy", "(Lcom/discord/api/channel/Channel;Ljava/util/List;ZZZZ)Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Ljava/util/List;", "getRaisedHandsParticipants", "isEmpty", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/util/List;ZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final boolean isEmpty;
            private final boolean isRequestToSpeakEnabled;
            private final boolean isSpeaker;
            private final boolean isTogglingSpeakingState;
            private final boolean isUpdatingRequestToSpeakPermissions;
            private final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> raisedHandsParticipants;

            public /* synthetic */ Loaded(Channel channel, List list, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, list, z2, z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, List list, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 2) != 0) {
                    list = loaded.raisedHandsParticipants;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    z2 = loaded.isRequestToSpeakEnabled;
                }
                boolean z6 = z2;
                if ((i & 8) != 0) {
                    z3 = loaded.isSpeaker;
                }
                boolean z7 = z3;
                if ((i & 16) != 0) {
                    z4 = loaded.isUpdatingRequestToSpeakPermissions;
                }
                boolean z8 = z4;
                if ((i & 32) != 0) {
                    z5 = loaded.isTogglingSpeakingState;
                }
                return loaded.copy(channel, list2, z6, z7, z8, z5);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> component2() {
                return this.raisedHandsParticipants;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsRequestToSpeakEnabled() {
                return this.isRequestToSpeakEnabled;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsSpeaker() {
                return this.isSpeaker;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsUpdatingRequestToSpeakPermissions() {
                return this.isUpdatingRequestToSpeakPermissions;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsTogglingSpeakingState() {
                return this.isTogglingSpeakingState;
            }

            public final Loaded copy(Channel channel, List<? extends WidgetStageRaisedHandsBottomSheetAdapter.ListItem> raisedHandsParticipants, boolean isRequestToSpeakEnabled, boolean isSpeaker, boolean isUpdatingRequestToSpeakPermissions, boolean isTogglingSpeakingState) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(raisedHandsParticipants, "raisedHandsParticipants");
                return new Loaded(channel, raisedHandsParticipants, isRequestToSpeakEnabled, isSpeaker, isUpdatingRequestToSpeakPermissions, isTogglingSpeakingState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.channel, loaded.channel) && Intrinsics3.areEqual(this.raisedHandsParticipants, loaded.raisedHandsParticipants) && this.isRequestToSpeakEnabled == loaded.isRequestToSpeakEnabled && this.isSpeaker == loaded.isSpeaker && this.isUpdatingRequestToSpeakPermissions == loaded.isUpdatingRequestToSpeakPermissions && this.isTogglingSpeakingState == loaded.isTogglingSpeakingState;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> getRaisedHandsParticipants() {
                return this.raisedHandsParticipants;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> list = this.raisedHandsParticipants;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.isRequestToSpeakEnabled;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean z3 = this.isSpeaker;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isUpdatingRequestToSpeakPermissions;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.isTogglingSpeakingState;
                return i6 + (z5 ? 1 : z5 ? 1 : 0);
            }

            /* renamed from: isEmpty, reason: from getter */
            public final boolean getIsEmpty() {
                return this.isEmpty;
            }

            public final boolean isRequestToSpeakEnabled() {
                return this.isRequestToSpeakEnabled;
            }

            public final boolean isSpeaker() {
                return this.isSpeaker;
            }

            public final boolean isTogglingSpeakingState() {
                return this.isTogglingSpeakingState;
            }

            public final boolean isUpdatingRequestToSpeakPermissions() {
                return this.isUpdatingRequestToSpeakPermissions;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(channel=");
                sbU.append(this.channel);
                sbU.append(", raisedHandsParticipants=");
                sbU.append(this.raisedHandsParticipants);
                sbU.append(", isRequestToSpeakEnabled=");
                sbU.append(this.isRequestToSpeakEnabled);
                sbU.append(", isSpeaker=");
                sbU.append(this.isSpeaker);
                sbU.append(", isUpdatingRequestToSpeakPermissions=");
                sbU.append(this.isUpdatingRequestToSpeakPermissions);
                sbU.append(", isTogglingSpeakingState=");
                return outline.O(sbU, this.isTogglingSpeakingState, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Channel channel, List<? extends WidgetStageRaisedHandsBottomSheetAdapter.ListItem> list, boolean z2, boolean z3, boolean z4, boolean z5) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(list, "raisedHandsParticipants");
                this.channel = channel;
                this.raisedHandsParticipants = list;
                this.isRequestToSpeakEnabled = z2;
                this.isSpeaker = z3;
                this.isUpdatingRequestToSpeakPermissions = z4;
                this.isTogglingSpeakingState = z5;
                this.isEmpty = list.isEmpty();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$dismissRequestToSpeak$1, reason: invalid class name */
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

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "p1", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$inviteToSpeak$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Error, Unit> {
        public AnonymousClass1(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "emitError", "emitError(Lcom/discord/utilities/error/Error;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "p1");
            WidgetStageRaisedHandsBottomSheetViewModel.access$emitError((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver, error);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$inviteToSpeak$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
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

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
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
            WidgetStageRaisedHandsBottomSheetViewModel.access$setLastRequestToSpeakSubscription$p(WidgetStageRaisedHandsBottomSheetViewModel.this, subscription);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$2, reason: invalid class name */
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
            ViewState viewStateAccess$getViewState$p = WidgetStageRaisedHandsBottomSheetViewModel.access$getViewState$p(WidgetStageRaisedHandsBottomSheetViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Loaded)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateAccess$getViewState$p;
            if (loaded != null) {
                WidgetStageRaisedHandsBottomSheetViewModel.access$updateViewState(WidgetStageRaisedHandsBottomSheetViewModel.this, ViewState.Loaded.copy$default(loaded, null, null, false, false, false, false, 47, null));
            }
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ boolean $isEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(boolean z2) {
            super(1);
            this.$isEnabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r10) {
            ViewState viewStateAccess$getViewState$p = WidgetStageRaisedHandsBottomSheetViewModel.access$getViewState$p(WidgetStageRaisedHandsBottomSheetViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Loaded)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateAccess$getViewState$p;
            if (loaded != null) {
                WidgetStageRaisedHandsBottomSheetViewModel.access$updateViewState(WidgetStageRaisedHandsBottomSheetViewModel.this, ViewState.Loaded.copy$default(loaded, null, null, this.$isEnabled, false, false, false, 43, null));
            }
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "p1", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Error, Unit> {
        public AnonymousClass1(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "emitError", "emitError(Lcom/discord/utilities/error/Error;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "p1");
            WidgetStageRaisedHandsBottomSheetViewModel.access$emitError((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver, error);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ViewState viewStateAccess$getViewState$p = WidgetStageRaisedHandsBottomSheetViewModel.access$getViewState$p(WidgetStageRaisedHandsBottomSheetViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Loaded)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateAccess$getViewState$p;
            if (loaded != null) {
                WidgetStageRaisedHandsBottomSheetViewModel.access$updateViewState(WidgetStageRaisedHandsBottomSheetViewModel.this, ViewState.Loaded.copy$default(loaded, null, null, false, false, false, false, 31, null));
            }
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$3, reason: invalid class name */
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

    /* compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "Lrx/Observable;", "Ljava/lang/Void;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setUserSuppressed$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends Void>> {
        public final /* synthetic */ boolean $isSuppressed;
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j, boolean z2) {
            this.$userId = j;
            this.$isSuppressed = z2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Void> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Void> call2(Channel channel) {
            StageChannelAPI stageChannelAPI = StageChannelAPI.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            return ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(stageChannelAPI, channel, this.$userId, this.$isSuppressed, 0L, 8, null), false, 1, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel(long j, StoreVoiceParticipants storeVoiceParticipants, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreStageChannels storeStageChannels, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreVoiceParticipants voiceParticipants = (i & 2) != 0 ? StoreStream.INSTANCE.getVoiceParticipants() : storeVoiceParticipants;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreUser users = (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreStageChannels stageChannels = (i & 32) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels;
        Clock clock2 = (i & 64) != 0 ? ClockFactory.get() : clock;
        this(j, voiceParticipants, channels, users, guilds, stageChannels, clock2, (i & 128) != 0 ? Companion.access$observeStoreState(INSTANCE, j, voiceParticipants, channels, guilds, stageChannels, clock2) : observable);
    }

    public static final /* synthetic */ void access$emitError(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel, Error error) {
        widgetStageRaisedHandsBottomSheetViewModel.emitError(error);
    }

    public static final /* synthetic */ Subscription access$getLastRequestToSpeakSubscription$p(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
        return widgetStageRaisedHandsBottomSheetViewModel.lastRequestToSpeakSubscription;
    }

    public static final /* synthetic */ ViewState access$getViewState$p(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
        return widgetStageRaisedHandsBottomSheetViewModel.getViewState();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel, StoreState storeState) {
        widgetStageRaisedHandsBottomSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$setLastRequestToSpeakSubscription$p(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel, Subscription subscription) {
        widgetStageRaisedHandsBottomSheetViewModel.lastRequestToSpeakSubscription = subscription;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel, ViewState viewState) {
        widgetStageRaisedHandsBottomSheetViewModel.updateViewState(viewState);
    }

    private final void emitDismiss() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    private final void emitError(Error error) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.Error(error));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        updateViewState(new ViewState.Loaded(storeState.getChannel(), storeState.getRaisedHandsParticipants(), PermissionUtils.INSTANCE.canEveryoneRole(Permission.REQUEST_TO_SPEAK, storeState.getChannel(), storeState.getRoles()), StageRoles.m33isSpeakerimpl(storeState.m50getMyStageRoles1LxfuJo()), false, false, 48, null));
    }

    private final Observable<Void> setUserSuppressed(long userId, boolean isSuppressed) {
        Observable<R> observableG = this.channelsStore.observeChannel(this.channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableA = observableG.z().A(new AnonymousClass1(userId, isSuppressed));
        Intrinsics3.checkNotNullExpressionValue(observableA, "channelSingle\n        .f…stSubscribeOn()\n        }");
        return ObservableExtensionsKt.ui$default(observableA, this, null, 2, null);
    }

    public final void dismissRequestToSpeak(StoreVoiceParticipants.VoiceUser participant) {
        Intrinsics3.checkNotNullParameter(participant, "participant");
        ObservableExtensionsKt.appSubscribe$default(setUserSuppressed(participant.getUser().getId(), true), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    public final void inviteToSpeak(StoreVoiceParticipants.VoiceUser participant) {
        Intrinsics3.checkNotNullParameter(participant, "participant");
        ObservableExtensionsKt.appSubscribe$default(setUserSuppressed(participant.getUser().getId(), false), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(this), (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 54, (Object) null);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void setRequestToSpeakEnabled(boolean isEnabled) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, false, false, true, false, 47, null));
            Tuples2<Long, Long> tuples2ComputeAllowDenyUpdateBits = PermissionOverwriteUtils.computeAllowDenyUpdateBits(ChannelUtils.f(loaded.getChannel(), loaded.getChannel().getGuildId()), Permission.REQUEST_TO_SPEAK, isEnabled);
            long jLongValue = tuples2ComputeAllowDenyUpdateBits.component1().longValue();
            long jLongValue2 = tuples2ComputeAllowDenyUpdateBits.component2().longValue();
            Subscription subscription = this.lastRequestToSpeakSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePermissionOverwrites(loaded.getChannel().getId(), loaded.getChannel().getGuildId(), RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(loaded.getChannel().getGuildId(), Long.valueOf(jLongValue), Long.valueOf(jLongValue2))), false, 1, null), this, null, 2, null), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, new AnonymousClass1(), new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass3(isEnabled), 50, (Object) null);
        }
    }

    public final void setSpeakingState(boolean isSuppressed) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, false, false, false, true, 31, null));
            ObservableExtensionsKt.appSubscribe$default(setUserSuppressed(this.usersStore.getMeSnapshot().getId(), isSuppressed), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(this), (Function0) null, new AnonymousClass2(), AnonymousClass3.INSTANCE, 22, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetViewModel(long j, StoreVoiceParticipants storeVoiceParticipants, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreStageChannels storeStageChannels, Clock clock, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeVoiceParticipants, "voiceParticipants");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "usersStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.voiceParticipants = storeVoiceParticipants;
        this.channelsStore = storeChannels;
        this.usersStore = storeUser;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetStageRaisedHandsBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}
