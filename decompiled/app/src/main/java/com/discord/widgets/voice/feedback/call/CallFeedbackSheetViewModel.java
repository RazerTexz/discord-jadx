package com.discord.widgets.voice.feedback.call;

import a0.a.a.b;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: CallFeedbackSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00039:;B3\u0012\u0006\u00105\u001a\u000204\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020+0\u0012¢\u0006\u0004\b7\u00108J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R:\u0010%\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\u00130\u0013 $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\u00130\u0013\u0018\u00010#0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010 R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u0006<"}, d2 = {"Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel;", "", "showConfirmation", "", "emitSubmittedEvent", "(Z)V", "Lcom/discord/widgets/voice/feedback/FeedbackRating;", "selectedFeedbackRating", "", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "feedbackIssues", "createViewState", "(Lcom/discord/widgets/voice/feedback/FeedbackRating;Ljava/util/List;)Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "onCleared", "()V", "Lrx/Observable;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "feedbackRating", "selectRating", "(Lcom/discord/widgets/voice/feedback/FeedbackRating;)V", "feedbackIssue", "", "reasonDescription", "selectIssue", "(Lcom/discord/widgets/voice/feedback/FeedbackIssue;Ljava/lang/String;)V", "submitForm", "submitOnDismiss", "Z", "issuesUiOptions", "Ljava/util/List;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreExperiments;", "submitted", "Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$StoreState;", "mostRecentStoreState", "Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$StoreState;", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;", "pendingCallFeedback", "Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;", "Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$Config;", "config", "storeStateObservable", "<init>", "(Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$Config;Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreExperiments;Lrx/Observable;)V", "Companion", "Config", "StoreState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CallFeedbackSheetViewModel extends AppViewModel<FeedbackSheetViewModel.ViewState> implements FeedbackSheetViewModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<FeedbackIssue> ISSUES_UI_OPTIONS;
    private static final Map<FeedbackIssue, Integer> REASON_CODES;
    private final PublishSubject<FeedbackSheetViewModel.Event> eventSubject;
    private final List<FeedbackIssue> issuesUiOptions;
    private StoreState mostRecentStoreState;
    private PendingFeedback.CallFeedback pendingCallFeedback;
    private final StoreAnalytics storeAnalytics;
    private final StoreExperiments storeExperiments;
    private boolean submitOnDismiss;
    private boolean submitted;

    /* compiled from: CallFeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$1, reason: invalid class name */
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
            CallFeedbackSheetViewModel.access$setMostRecentStoreState$p(CallFeedbackSheetViewModel.this, storeState);
        }
    }

    /* compiled from: CallFeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R.\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$Companion;", "", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lrx/Observable;", "Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreExperiments;)Lrx/Observable;", "", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "", "REASON_CODES", "Ljava/util/Map;", "getREASON_CODES", "()Ljava/util/Map;", "getREASON_CODES$annotations", "()V", "", "ISSUES_UI_OPTIONS", "Ljava/util/List;", "getISSUES_UI_OPTIONS", "()Ljava/util/List;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreExperiments storeExperiments) {
            return companion.observeStoreState(storeExperiments);
        }

        @VisibleForTesting
        public static /* synthetic */ void getREASON_CODES$annotations() {
        }

        private final Observable<StoreState> observeStoreState(StoreExperiments storeExperiments) {
            Observable observableG = storeExperiments.observeUserExperiment("2020-08_feedback_modal_helpdesk_link", true).G(CallFeedbackSheetViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "storeExperiments\n       …            )\n          }");
            return observableG;
        }

        public final List<FeedbackIssue> getISSUES_UI_OPTIONS() {
            return CallFeedbackSheetViewModel.access$getISSUES_UI_OPTIONS$cp();
        }

        public final Map<FeedbackIssue, Integer> getREASON_CODES() {
            return CallFeedbackSheetViewModel.access$getREASON_CODES$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CallFeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B=\u0012\n\u0010\u0017\u001a\u00060\u000bj\u0002`\f\u0012\u000e\u0010\u0018\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u0012\u000e\u0010\u0019\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b+\u0010-J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\r\u001a\u00060\u000bj\u0002`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0012J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016JN\u0010\u001b\u001a\u00020\u00002\f\b\u0002\u0010\u0017\u001a\u00060\u000bj\u0002`\f2\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00102\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0012J\u0010\u0010\u001e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001e\u0010\nJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R!\u0010\u0018\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\u0012R\u001d\u0010\u0017\u001a\u00060\u000bj\u0002`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u000eR!\u0010\u0019\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b(\u0010\u0012R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010\u0016¨\u0006/"}, d2 = {"Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$Config;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "Lcom/discord/primitives/RtcConnectionId;", "component2", "()Ljava/lang/String;", "Lcom/discord/primitives/MediaSessionId;", "component3", "component4", "()Ljava/lang/Long;", "channelId", "rtcConnectionId", "mediaSessionId", "callDurationMs", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$Config;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRtcConnectionId", "J", "getChannelId", "getMediaSessionId", "Ljava/lang/Long;", "getCallDurationMs", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "(Landroid/os/Parcel;)V", "CREATOR", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Config implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long callDurationMs;
        private final long channelId;
        private final String mediaSessionId;
        private final String rtcConnectionId;

        /* compiled from: CallFeedbackSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$Config$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$Config;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$Config;", "", "size", "", "newArray", "(I)[Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$Config;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$Config$CREATOR, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator<Config> {
            private Companion() {
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Config createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Config[] newArray(int i) {
                return newArray(i);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Config createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "parcel");
                return new Config(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Config[] newArray(int size) {
                return new Config[size];
            }
        }

        public Config(long j, String str, String str2, Long l) {
            this.channelId = j;
            this.rtcConnectionId = str;
            this.mediaSessionId = str2;
            this.callDurationMs = l;
        }

        public static /* synthetic */ Config copy$default(Config config, long j, String str, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = config.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = config.rtcConnectionId;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = config.mediaSessionId;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                l = config.callDurationMs;
            }
            return config.copy(j2, str3, str4, l);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRtcConnectionId() {
            return this.rtcConnectionId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getCallDurationMs() {
            return this.callDurationMs;
        }

        public final Config copy(long channelId, String rtcConnectionId, String mediaSessionId, Long callDurationMs) {
            return new Config(channelId, rtcConnectionId, mediaSessionId, callDurationMs);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.channelId == config.channelId && Intrinsics3.areEqual(this.rtcConnectionId, config.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, config.mediaSessionId) && Intrinsics3.areEqual(this.callDurationMs, config.callDurationMs);
        }

        public final Long getCallDurationMs() {
            return this.callDurationMs;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final String getRtcConnectionId() {
            return this.rtcConnectionId;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            String str = this.rtcConnectionId;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.mediaSessionId;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.callDurationMs;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Config(channelId=");
            sbU.append(this.channelId);
            sbU.append(", rtcConnectionId=");
            sbU.append(this.rtcConnectionId);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", callDurationMs=");
            return outline.G(sbU, this.callDurationMs, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.channelId);
            parcel.writeString(this.rtcConnectionId);
            parcel.writeString(this.mediaSessionId);
            parcel.writeValue(this.callDurationMs);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Config(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            String string2 = parcel.readString();
            Object value = parcel.readValue(Long.TYPE.getClassLoader());
            this(j, string, string2, (Long) (value instanceof Long ? value : null));
        }
    }

    /* compiled from: CallFeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$StoreState;", "", "", "component1", "()Z", "shouldShowCxLinkForIssueDetails", "copy", "(Z)Lcom/discord/widgets/voice/feedback/call/CallFeedbackSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShouldShowCxLinkForIssueDetails", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final boolean shouldShowCxLinkForIssueDetails;

        public StoreState(boolean z2) {
            this.shouldShowCxLinkForIssueDetails = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.shouldShowCxLinkForIssueDetails;
            }
            return storeState.copy(z2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShouldShowCxLinkForIssueDetails() {
            return this.shouldShowCxLinkForIssueDetails;
        }

        public final StoreState copy(boolean shouldShowCxLinkForIssueDetails) {
            return new StoreState(shouldShowCxLinkForIssueDetails);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && this.shouldShowCxLinkForIssueDetails == ((StoreState) other).shouldShowCxLinkForIssueDetails;
            }
            return true;
        }

        public final boolean getShouldShowCxLinkForIssueDetails() {
            return this.shouldShowCxLinkForIssueDetails;
        }

        public int hashCode() {
            boolean z2 = this.shouldShowCxLinkForIssueDetails;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return outline.O(outline.U("StoreState(shouldShowCxLinkForIssueDetails="), this.shouldShowCxLinkForIssueDetails, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            FeedbackRating.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedbackRating.NO_RESPONSE.ordinal()] = 1;
            iArr[FeedbackRating.GOOD.ordinal()] = 2;
            FeedbackRating feedbackRating = FeedbackRating.NEUTRAL;
            iArr[feedbackRating.ordinal()] = 3;
            FeedbackRating feedbackRating2 = FeedbackRating.BAD;
            iArr[feedbackRating2.ordinal()] = 4;
            FeedbackRating.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[feedbackRating.ordinal()] = 1;
            iArr2[feedbackRating2.ordinal()] = 2;
        }
    }

    static {
        FeedbackIssue feedbackIssue = FeedbackIssue.COULD_NOT_HEAR_AUDIO;
        FeedbackIssue feedbackIssue2 = FeedbackIssue.NOBODY_COULD_HEAR_ME;
        FeedbackIssue feedbackIssue3 = FeedbackIssue.AUDIO_ECHOS;
        FeedbackIssue feedbackIssue4 = FeedbackIssue.AUDIO_ROBOTIC;
        FeedbackIssue feedbackIssue5 = FeedbackIssue.AUDIO_CUT_IN_AND_OUT;
        FeedbackIssue feedbackIssue6 = FeedbackIssue.VOLUME_TOO_LOW_OR_HIGH;
        FeedbackIssue feedbackIssue7 = FeedbackIssue.BACKGROUND_NOISE_TOO_LOUD;
        FeedbackIssue feedbackIssue8 = FeedbackIssue.SPEAKERPHONE_ISSUE;
        FeedbackIssue feedbackIssue9 = FeedbackIssue.HEADSET_OR_BLUETOOTH_ISSUE;
        ISSUES_UI_OPTIONS = Collections2.listOf((Object[]) new FeedbackIssue[]{feedbackIssue, feedbackIssue2, feedbackIssue3, feedbackIssue4, feedbackIssue5, feedbackIssue6, feedbackIssue7, feedbackIssue8, feedbackIssue9});
        REASON_CODES = Maps6.mapOf(Tuples.to(FeedbackIssue.OTHER, 1), Tuples.to(feedbackIssue, 2), Tuples.to(feedbackIssue2, 3), Tuples.to(feedbackIssue3, 4), Tuples.to(feedbackIssue4, 5), Tuples.to(feedbackIssue5, 6), Tuples.to(feedbackIssue6, 7), Tuples.to(feedbackIssue7, 8), Tuples.to(feedbackIssue8, 9), Tuples.to(feedbackIssue9, 10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CallFeedbackSheetViewModel(Config config, StoreAnalytics storeAnalytics, StoreExperiments storeExperiments, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeAnalytics = (i & 2) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        storeExperiments = (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        this(config, storeAnalytics, storeExperiments, (i & 8) != 0 ? Companion.access$observeStoreState(INSTANCE, storeExperiments) : observable);
    }

    public static final /* synthetic */ List access$getISSUES_UI_OPTIONS$cp() {
        return ISSUES_UI_OPTIONS;
    }

    public static final /* synthetic */ StoreState access$getMostRecentStoreState$p(CallFeedbackSheetViewModel callFeedbackSheetViewModel) {
        return callFeedbackSheetViewModel.mostRecentStoreState;
    }

    public static final /* synthetic */ Map access$getREASON_CODES$cp() {
        return REASON_CODES;
    }

    public static final /* synthetic */ void access$setMostRecentStoreState$p(CallFeedbackSheetViewModel callFeedbackSheetViewModel, StoreState storeState) {
        callFeedbackSheetViewModel.mostRecentStoreState = storeState;
    }

    private final FeedbackSheetViewModel.ViewState createViewState(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues) {
        return new FeedbackSheetViewModel.ViewState(selectedFeedbackRating, feedbackIssues, R.string.call_feedback_sheet_title, Integer.valueOf(R.string.call_feedback_prompt), R.string.call_feedback_issue_section_header);
    }

    private final void emitSubmittedEvent(boolean showConfirmation) {
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FeedbackSheetViewModel.Event.Submitted(showConfirmation));
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public Observable<FeedbackSheetViewModel.Event> observeEvents() {
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        if (this.submitOnDismiss) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription) {
        PendingFeedback.CallFeedback callFeedbackCopy$default = PendingFeedback.CallFeedback.copy$default(this.pendingCallFeedback, 0L, null, null, null, null, REASON_CODES.get(feedbackIssue), reasonDescription, null, Opcodes.IF_ICMPEQ, null);
        this.pendingCallFeedback = callFeedbackCopy$default;
        if (feedbackIssue == FeedbackIssue.OTHER) {
            this.submitOnDismiss = false;
            PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
            StoreState storeState = this.mostRecentStoreState;
            publishSubject.k.onNext(new FeedbackSheetViewModel.Event.NavigateToIssueDetails(callFeedbackCopy$default, storeState != null ? storeState.getShouldShowCxLinkForIssueDetails() : false));
            return;
        }
        int iOrdinal = requireViewState().getSelectedFeedbackRating().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectRating(FeedbackRating feedbackRating) {
        Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
        this.pendingCallFeedback = PendingFeedback.CallFeedback.copy$default(this.pendingCallFeedback, 0L, null, null, null, feedbackRating, null, null, null, 239, null);
        int iOrdinal = feedbackRating.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2) {
                updateViewState(createViewState(feedbackRating, this.issuesUiOptions));
                return;
            } else if (iOrdinal != 3) {
                return;
            }
        }
        selectIssue(null, null);
        updateViewState(createViewState(feedbackRating, Collections2.emptyList()));
        submitForm();
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void submitForm() {
        if (this.submitted) {
            return;
        }
        this.submitted = true;
        FeedbackRating selectedFeedbackRating = requireViewState().getSelectedFeedbackRating();
        this.storeAnalytics.trackCallReportProblem(this.pendingCallFeedback);
        emitSubmittedEvent(selectedFeedbackRating != FeedbackRating.NO_RESPONSE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallFeedbackSheetViewModel(Config config, StoreAnalytics storeAnalytics, StoreExperiments storeExperiments, Observable<StoreState> observable) {
        super(new FeedbackSheetViewModel.ViewState(FeedbackRating.NO_RESPONSE, Collections2.emptyList(), R.string.call_feedback_sheet_title, Integer.valueOf(R.string.call_feedback_prompt), R.string.call_feedback_issue_section_header));
        Intrinsics3.checkNotNullParameter(config, "config");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.storeAnalytics = storeAnalytics;
        this.storeExperiments = storeExperiments;
        this.eventSubject = PublishSubject.k0();
        this.submitOnDismiss = true;
        this.pendingCallFeedback = new PendingFeedback.CallFeedback(config.getChannelId(), config.getRtcConnectionId(), config.getCallDurationMs(), config.getMediaSessionId(), null, null, null, null, 240, null);
        this.issuesUiOptions = _Collections.plus((Collection<? extends FeedbackIssue>) CollectionsJVM.shuffled(ISSUES_UI_OPTIONS), FeedbackIssue.OTHER);
        storeAnalytics.trackShowCallFeedbackSheet(config.getChannelId());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), CallFeedbackSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
