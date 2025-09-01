package com.discord.widgets.voice.feedback.stream;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StreamFeedbackSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002>?BG\u0012\n\u00108\u001a\u00060\u001aj\u0002`7\u0012\u000e\u0010:\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`9\u0012\b\b\u0002\u00105\u001a\u000204\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020.0\u0012¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0011R:\u0010!\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010\u00130\u0013  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006@"}, d2 = {"Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel;", "", "showConfirmation", "", "emitSubmittedEvent", "(Z)V", "Lcom/discord/widgets/voice/feedback/FeedbackRating;", "selectedFeedbackRating", "", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "feedbackIssues", "createViewState", "(Lcom/discord/widgets/voice/feedback/FeedbackRating;Ljava/util/List;)Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "onCleared", "()V", "Lrx/Observable;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "feedbackRating", "selectRating", "(Lcom/discord/widgets/voice/feedback/FeedbackRating;)V", "feedbackIssue", "", "reasonDescription", "selectIssue", "(Lcom/discord/widgets/voice/feedback/FeedbackIssue;Ljava/lang/String;)V", "submitForm", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;", "pendingStreamFeedback", "Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;", "issuesUiOptions", "Ljava/util/List;", "submitted", "Z", "submitOnDismiss", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$StoreState;", "mostRecentStoreState", "Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$StoreState;", "Lcom/discord/models/domain/ModelApplicationStream;", "stream", "Lcom/discord/models/domain/ModelApplicationStream;", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreExperiments;", "Lcom/discord/primitives/StreamKey;", "streamKey", "Lcom/discord/primitives/MediaSessionId;", "mediaSessionId", "storeStateObservable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreAnalytics;Lrx/Observable;)V", "Companion", "StoreState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class StreamFeedbackSheetViewModel extends AppViewModel<FeedbackSheetViewModel.ViewState> implements FeedbackSheetViewModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<FeedbackIssue> ISSUES_UI_OPTIONS = Collections2.listOf((Object[]) new FeedbackIssue[]{FeedbackIssue.STREAM_REPORT_ENDED_BLACK, FeedbackIssue.STREAM_REPORT_ENDED_BLURRY, FeedbackIssue.STREAM_REPORT_ENDED_LAGGING, FeedbackIssue.STREAM_REPORT_ENDED_OUT_OF_SYNC, FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_MISSING, FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_POOR, FeedbackIssue.STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY});
    private final PublishSubject<FeedbackSheetViewModel.Event> eventSubject;
    private final List<FeedbackIssue> issuesUiOptions;
    private StoreState mostRecentStoreState;
    private PendingFeedback.StreamFeedback pendingStreamFeedback;
    private final StoreAnalytics storeAnalytics;
    private final StoreExperiments storeExperiments;
    private final ModelApplicationStream stream;
    private boolean submitOnDismiss;
    private boolean submitted;

    /* compiled from: StreamFeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel$1, reason: invalid class name */
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
            StreamFeedbackSheetViewModel.access$setMostRecentStoreState$p(StreamFeedbackSheetViewModel.this, storeState);
        }
    }

    /* compiled from: StreamFeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$Companion;", "", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lrx/Observable;", "Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreExperiments;)Lrx/Observable;", "", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "ISSUES_UI_OPTIONS", "Ljava/util/List;", "getISSUES_UI_OPTIONS", "()Ljava/util/List;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreExperiments storeExperiments) {
            return companion.observeStoreState(storeExperiments);
        }

        private final Observable<StoreState> observeStoreState(StoreExperiments storeExperiments) {
            Observable observableG = storeExperiments.observeUserExperiment("2020-08_feedback_modal_helpdesk_link", true).G(StreamFeedbackSheetViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "storeExperiments\n       …            )\n          }");
            return observableG;
        }

        public final List<FeedbackIssue> getISSUES_UI_OPTIONS() {
            return StreamFeedbackSheetViewModel.access$getISSUES_UI_OPTIONS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StreamFeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$StoreState;", "", "", "component1", "()Z", "shouldShowCxLinkForIssueDetails", "copy", "(Z)Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShouldShowCxLinkForIssueDetails", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StreamFeedbackSheetViewModel(String str, String str2, StoreExperiments storeExperiments, StoreAnalytics storeAnalytics, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreExperiments experiments = (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        this(str, str2, experiments, (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (i & 16) != 0 ? Companion.access$observeStoreState(INSTANCE, experiments) : observable);
    }

    public static final /* synthetic */ List access$getISSUES_UI_OPTIONS$cp() {
        return ISSUES_UI_OPTIONS;
    }

    public static final /* synthetic */ StoreState access$getMostRecentStoreState$p(StreamFeedbackSheetViewModel streamFeedbackSheetViewModel) {
        return streamFeedbackSheetViewModel.mostRecentStoreState;
    }

    public static final /* synthetic */ void access$setMostRecentStoreState$p(StreamFeedbackSheetViewModel streamFeedbackSheetViewModel, StoreState storeState) {
        streamFeedbackSheetViewModel.mostRecentStoreState = storeState;
    }

    private final FeedbackSheetViewModel.ViewState createViewState(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues) {
        return new FeedbackSheetViewModel.ViewState(selectedFeedbackRating, feedbackIssues, R.string.stream_report_a_problem_post_stream, Integer.valueOf(R.string.stream_report_rating_body), R.string.stream_report_placeholder);
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
        PendingFeedback.StreamFeedback streamFeedbackCopy$default = PendingFeedback.StreamFeedback.copy$default(this.pendingStreamFeedback, null, null, feedbackIssue, null, null, 27, null);
        this.pendingStreamFeedback = streamFeedbackCopy$default;
        if (feedbackIssue == FeedbackIssue.OTHER) {
            this.submitOnDismiss = false;
            PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
            StoreState storeState = this.mostRecentStoreState;
            publishSubject.k.onNext(new FeedbackSheetViewModel.Event.NavigateToIssueDetails(streamFeedbackCopy$default, storeState != null ? storeState.getShouldShowCxLinkForIssueDetails() : false));
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
        this.pendingStreamFeedback = PendingFeedback.StreamFeedback.copy$default(this.pendingStreamFeedback, null, feedbackRating, null, null, null, 29, null);
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
        this.storeAnalytics.trackStreamReportProblem(this.pendingStreamFeedback);
        emitSubmittedEvent(selectedFeedbackRating != FeedbackRating.NO_RESPONSE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamFeedbackSheetViewModel(String str, String str2, StoreExperiments storeExperiments, StoreAnalytics storeAnalytics, Observable<StoreState> observable) {
        super(new FeedbackSheetViewModel.ViewState(FeedbackRating.NO_RESPONSE, Collections2.emptyList(), R.string.stream_report_a_problem_post_stream, Integer.valueOf(R.string.stream_report_rating_body), R.string.stream_report_placeholder));
        Intrinsics3.checkNotNullParameter(str, "streamKey");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.storeExperiments = storeExperiments;
        this.storeAnalytics = storeAnalytics;
        this.eventSubject = PublishSubject.k0();
        this.submitOnDismiss = true;
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(str);
        this.stream = modelApplicationStreamDecodeStreamKey;
        this.pendingStreamFeedback = new PendingFeedback.StreamFeedback(modelApplicationStreamDecodeStreamKey, null, null, str2, null, 22, null);
        this.issuesUiOptions = _Collections.plus((Collection<? extends FeedbackIssue>) CollectionsJVM.shuffled(ISSUES_UI_OPTIONS), FeedbackIssue.OTHER);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), StreamFeedbackSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
