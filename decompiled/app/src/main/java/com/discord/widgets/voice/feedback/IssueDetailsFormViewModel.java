package com.discord.widgets.voice.feedback;

import b.a.d.AppViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: IssueDetailsFormViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel;", "Lb/a/d/d0;", "", "onCleared", "()V", "Lrx/Observable;", "Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel$Event;", "observeEvents", "()Lrx/Observable;", "", "issueDetails", "submitForm", "(Ljava/lang/String;)V", "Lcom/discord/widgets/voice/feedback/FeedbackSubmitter;", "feedbackSubmitter", "Lcom/discord/widgets/voice/feedback/FeedbackSubmitter;", "", "submitted", "Z", "Lrx/subjects/PublishSubject;", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "pendingFeedback", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "<init>", "(Lcom/discord/widgets/voice/feedback/PendingFeedback;Lcom/discord/widgets/voice/feedback/FeedbackSubmitter;)V", "Event", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class IssueDetailsFormViewModel extends AppViewModel<Unit> {
    private final PublishSubject<Event> eventSubject;
    private final FeedbackSubmitter feedbackSubmitter;
    private final PendingFeedback pendingFeedback;
    private boolean submitted;

    /* compiled from: IssueDetailsFormViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel$Event;", "", "<init>", "()V", "Close", "Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel$Event$Close;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: IssueDetailsFormViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel$Event$Close;", "Lcom/discord/widgets/voice/feedback/IssueDetailsFormViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Close extends Event {
            public static final Close INSTANCE = new Close();

            private Close() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ IssueDetailsFormViewModel(PendingFeedback pendingFeedback, FeedbackSubmitter feedbackSubmitter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendingFeedback, (i & 2) != 0 ? FeedbackSubmitterFactory.INSTANCE.create(pendingFeedback) : feedbackSubmitter);
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        submitForm(null);
    }

    public final void submitForm(String issueDetails) {
        if (this.submitted) {
            return;
        }
        this.submitted = true;
        this.feedbackSubmitter.submit(issueDetails);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Close.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IssueDetailsFormViewModel(PendingFeedback pendingFeedback, FeedbackSubmitter feedbackSubmitter) {
        super(Unit.a);
        Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
        Intrinsics3.checkNotNullParameter(feedbackSubmitter, "feedbackSubmitter");
        this.pendingFeedback = pendingFeedback;
        this.feedbackSubmitter = feedbackSubmitter;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
    }
}
