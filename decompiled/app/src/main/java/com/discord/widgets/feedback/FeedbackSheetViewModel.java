package com.discord.widgets.feedback;

import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: FeedbackSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0015\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fH&¢\u0006\u0004\b\u0014\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/feedback/FeedbackSheetViewModel;", "", "Lcom/discord/widgets/voice/feedback/FeedbackRating;", "feedbackRating", "", "selectRating", "(Lcom/discord/widgets/voice/feedback/FeedbackRating;)V", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "feedbackIssue", "", "reasonDescription", "selectIssue", "(Lcom/discord/widgets/voice/feedback/FeedbackIssue;Ljava/lang/String;)V", "submitForm", "()V", "Lrx/Observable;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "observeViewState", "()Lrx/Observable;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;", "observeEvents", "Event", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface FeedbackSheetViewModel {

    /* compiled from: FeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void selectRating(FeedbackSheetViewModel feedbackSheetViewModel, FeedbackRating feedbackRating) {
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
        }
    }

    /* compiled from: FeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;", "", "<init>", "()V", "NavigateToIssueDetails", "Submitted", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event$Submitted;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event$NavigateToIssueDetails;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: FeedbackSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event$NavigateToIssueDetails;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "component1", "()Lcom/discord/widgets/voice/feedback/PendingFeedback;", "", "component2", "()Z", "pendingFeedback", "showCxLinkForIssueDetails", "copy", "(Lcom/discord/widgets/voice/feedback/PendingFeedback;Z)Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event$NavigateToIssueDetails;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "getPendingFeedback", "Z", "getShowCxLinkForIssueDetails", "<init>", "(Lcom/discord/widgets/voice/feedback/PendingFeedback;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class NavigateToIssueDetails extends Event {
            private final PendingFeedback pendingFeedback;
            private final boolean showCxLinkForIssueDetails;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToIssueDetails(PendingFeedback pendingFeedback, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
                this.pendingFeedback = pendingFeedback;
                this.showCxLinkForIssueDetails = z2;
            }

            public static /* synthetic */ NavigateToIssueDetails copy$default(NavigateToIssueDetails navigateToIssueDetails, PendingFeedback pendingFeedback, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    pendingFeedback = navigateToIssueDetails.pendingFeedback;
                }
                if ((i & 2) != 0) {
                    z2 = navigateToIssueDetails.showCxLinkForIssueDetails;
                }
                return navigateToIssueDetails.copy(pendingFeedback, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final PendingFeedback getPendingFeedback() {
                return this.pendingFeedback;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getShowCxLinkForIssueDetails() {
                return this.showCxLinkForIssueDetails;
            }

            public final NavigateToIssueDetails copy(PendingFeedback pendingFeedback, boolean showCxLinkForIssueDetails) {
                Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
                return new NavigateToIssueDetails(pendingFeedback, showCxLinkForIssueDetails);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavigateToIssueDetails)) {
                    return false;
                }
                NavigateToIssueDetails navigateToIssueDetails = (NavigateToIssueDetails) other;
                return Intrinsics3.areEqual(this.pendingFeedback, navigateToIssueDetails.pendingFeedback) && this.showCxLinkForIssueDetails == navigateToIssueDetails.showCxLinkForIssueDetails;
            }

            public final PendingFeedback getPendingFeedback() {
                return this.pendingFeedback;
            }

            public final boolean getShowCxLinkForIssueDetails() {
                return this.showCxLinkForIssueDetails;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                PendingFeedback pendingFeedback = this.pendingFeedback;
                int iHashCode = (pendingFeedback != null ? pendingFeedback.hashCode() : 0) * 31;
                boolean z2 = this.showCxLinkForIssueDetails;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("NavigateToIssueDetails(pendingFeedback=");
                sbU.append(this.pendingFeedback);
                sbU.append(", showCxLinkForIssueDetails=");
                return outline.O(sbU, this.showCxLinkForIssueDetails, ")");
            }
        }

        /* compiled from: FeedbackSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event$Submitted;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;", "", "component1", "()Z", "showConfirmation", "copy", "(Z)Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event$Submitted;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowConfirmation", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Submitted extends Event {
            private final boolean showConfirmation;

            public Submitted(boolean z2) {
                super(null);
                this.showConfirmation = z2;
            }

            public static /* synthetic */ Submitted copy$default(Submitted submitted, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = submitted.showConfirmation;
                }
                return submitted.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getShowConfirmation() {
                return this.showConfirmation;
            }

            public final Submitted copy(boolean showConfirmation) {
                return new Submitted(showConfirmation);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Submitted) && this.showConfirmation == ((Submitted) other).showConfirmation;
                }
                return true;
            }

            public final boolean getShowConfirmation() {
                return this.showConfirmation;
            }

            public int hashCode() {
                boolean z2 = this.showConfirmation;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return outline.O(outline.U("Submitted(showConfirmation="), this.showConfirmation, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Observable<Event> observeEvents();

    Observable<ViewState> observeViewState();

    void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription);

    void selectRating(FeedbackRating feedbackRating);

    void submitForm();

    /* compiled from: FeedbackSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0011\u001a\u00020\t\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJJ\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0011\u001a\u00020\t2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\u0013\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000bJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\"\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\bR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010\rR\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b*\u0010\u000b¨\u0006-"}, d2 = {"Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "", "Lcom/discord/widgets/voice/feedback/FeedbackRating;", "component1", "()Lcom/discord/widgets/voice/feedback/FeedbackRating;", "", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "component2", "()Ljava/util/List;", "", "component3", "()I", "component4", "()Ljava/lang/Integer;", "component5", "selectedFeedbackRating", "feedbackIssues", "titleTextResId", "promptTextResId", "issuesHeaderTextResId", "copy", "(Lcom/discord/widgets/voice/feedback/FeedbackRating;Ljava/util/List;ILjava/lang/Integer;I)Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTitleTextResId", "Lcom/discord/widgets/voice/feedback/FeedbackRating;", "getSelectedFeedbackRating", "showFaceRatings", "Z", "getShowFaceRatings", "()Z", "Ljava/util/List;", "getFeedbackIssues", "Ljava/lang/Integer;", "getPromptTextResId", "getIssuesHeaderTextResId", "<init>", "(Lcom/discord/widgets/voice/feedback/FeedbackRating;Ljava/util/List;ILjava/lang/Integer;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final List<FeedbackIssue> feedbackIssues;
        private final int issuesHeaderTextResId;
        private final Integer promptTextResId;
        private final FeedbackRating selectedFeedbackRating;
        private final boolean showFaceRatings;
        private final int titleTextResId;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(FeedbackRating feedbackRating, List<? extends FeedbackIssue> list, @StringRes int i, @StringRes Integer num, @StringRes int i2) {
            Intrinsics3.checkNotNullParameter(feedbackRating, "selectedFeedbackRating");
            Intrinsics3.checkNotNullParameter(list, "feedbackIssues");
            this.selectedFeedbackRating = feedbackRating;
            this.feedbackIssues = list;
            this.titleTextResId = i;
            this.promptTextResId = num;
            this.issuesHeaderTextResId = i2;
            this.showFaceRatings = num != null;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, FeedbackRating feedbackRating, List list, int i, Integer num, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                feedbackRating = viewState.selectedFeedbackRating;
            }
            if ((i3 & 2) != 0) {
                list = viewState.feedbackIssues;
            }
            List list2 = list;
            if ((i3 & 4) != 0) {
                i = viewState.titleTextResId;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                num = viewState.promptTextResId;
            }
            Integer num2 = num;
            if ((i3 & 16) != 0) {
                i2 = viewState.issuesHeaderTextResId;
            }
            return viewState.copy(feedbackRating, list2, i4, num2, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final FeedbackRating getSelectedFeedbackRating() {
            return this.selectedFeedbackRating;
        }

        public final List<FeedbackIssue> component2() {
            return this.feedbackIssues;
        }

        /* renamed from: component3, reason: from getter */
        public final int getTitleTextResId() {
            return this.titleTextResId;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getPromptTextResId() {
            return this.promptTextResId;
        }

        /* renamed from: component5, reason: from getter */
        public final int getIssuesHeaderTextResId() {
            return this.issuesHeaderTextResId;
        }

        public final ViewState copy(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues, @StringRes int titleTextResId, @StringRes Integer promptTextResId, @StringRes int issuesHeaderTextResId) {
            Intrinsics3.checkNotNullParameter(selectedFeedbackRating, "selectedFeedbackRating");
            Intrinsics3.checkNotNullParameter(feedbackIssues, "feedbackIssues");
            return new ViewState(selectedFeedbackRating, feedbackIssues, titleTextResId, promptTextResId, issuesHeaderTextResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.selectedFeedbackRating, viewState.selectedFeedbackRating) && Intrinsics3.areEqual(this.feedbackIssues, viewState.feedbackIssues) && this.titleTextResId == viewState.titleTextResId && Intrinsics3.areEqual(this.promptTextResId, viewState.promptTextResId) && this.issuesHeaderTextResId == viewState.issuesHeaderTextResId;
        }

        public final List<FeedbackIssue> getFeedbackIssues() {
            return this.feedbackIssues;
        }

        public final int getIssuesHeaderTextResId() {
            return this.issuesHeaderTextResId;
        }

        public final Integer getPromptTextResId() {
            return this.promptTextResId;
        }

        public final FeedbackRating getSelectedFeedbackRating() {
            return this.selectedFeedbackRating;
        }

        public final boolean getShowFaceRatings() {
            return this.showFaceRatings;
        }

        public final int getTitleTextResId() {
            return this.titleTextResId;
        }

        public int hashCode() {
            FeedbackRating feedbackRating = this.selectedFeedbackRating;
            int iHashCode = (feedbackRating != null ? feedbackRating.hashCode() : 0) * 31;
            List<FeedbackIssue> list = this.feedbackIssues;
            int iHashCode2 = (((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.titleTextResId) * 31;
            Integer num = this.promptTextResId;
            return ((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.issuesHeaderTextResId;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(selectedFeedbackRating=");
            sbU.append(this.selectedFeedbackRating);
            sbU.append(", feedbackIssues=");
            sbU.append(this.feedbackIssues);
            sbU.append(", titleTextResId=");
            sbU.append(this.titleTextResId);
            sbU.append(", promptTextResId=");
            sbU.append(this.promptTextResId);
            sbU.append(", issuesHeaderTextResId=");
            return outline.B(sbU, this.issuesHeaderTextResId, ")");
        }

        public /* synthetic */ ViewState(FeedbackRating feedbackRating, List list, int i, Integer num, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(feedbackRating, list, i, (i3 & 8) != 0 ? null : num, i2);
        }
    }
}
