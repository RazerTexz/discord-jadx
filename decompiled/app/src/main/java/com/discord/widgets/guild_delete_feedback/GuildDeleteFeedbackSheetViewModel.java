package com.discord.widgets.guild_delete_feedback;

import b.a.d.AppViewModel;
import com.discord.R;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: GuildDeleteFeedbackSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001!B\u0013\u0012\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R:\u0010\u001a\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u000f0\u000f \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00180\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/discord/widgets/guild_delete_feedback/GuildDeleteFeedbackSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel;", "", "onCleared", "()V", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "feedbackIssue", "", "reasonDescription", "selectIssue", "(Lcom/discord/widgets/voice/feedback/FeedbackIssue;Ljava/lang/String;)V", "submitForm", "Lrx/Observable;", "Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "Lcom/discord/widgets/voice/feedback/PendingFeedback$GuildDeleteFeedback;", "pendingFeedback", "Lcom/discord/widgets/voice/feedback/PendingFeedback$GuildDeleteFeedback;", "", "submitted", "Z", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "", "Lcom/discord/primitives/GuildId;", "guildId", "<init>", "(J)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetViewModel extends AppViewModel<FeedbackSheetViewModel.ViewState> implements FeedbackSheetViewModel {
    private static final List<FeedbackIssue> REASONS = Collections2.listOf((Object[]) new FeedbackIssue[]{FeedbackIssue.GUILD_DELETE_TOO_HARD, FeedbackIssue.GUILD_DELETE_TEST, FeedbackIssue.GUILD_DELETE_ACCIDENT, FeedbackIssue.GUILD_DELETE_TEMPLATE, FeedbackIssue.GUILD_DELETE_LONELY, FeedbackIssue.GUILD_DELETE_INACTIVE});
    private final PublishSubject<FeedbackSheetViewModel.Event> eventSubject;
    private PendingFeedback.GuildDeleteFeedback pendingFeedback;
    private boolean submitted;

    public GuildDeleteFeedbackSheetViewModel(long j) {
        super(new FeedbackSheetViewModel.ViewState(FeedbackRating.NO_RESPONSE, _Collections.plus((Collection<? extends FeedbackIssue>) CollectionsJVM.shuffled(REASONS), FeedbackIssue.GUILD_DELETE_OTHER), R.string.guild_delete_feedback_header, null, R.string.guild_delete_feedback_body, 8, null));
        this.eventSubject = PublishSubject.k0();
        this.pendingFeedback = new PendingFeedback.GuildDeleteFeedback(j, null, null, 6, null);
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
        submitForm();
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription) {
        PendingFeedback.GuildDeleteFeedback guildDeleteFeedbackCopy$default = PendingFeedback.GuildDeleteFeedback.copy$default(this.pendingFeedback, 0L, feedbackIssue, null, 5, null);
        this.pendingFeedback = guildDeleteFeedbackCopy$default;
        if (feedbackIssue != FeedbackIssue.GUILD_DELETE_OTHER) {
            submitForm();
            return;
        }
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FeedbackSheetViewModel.Event.NavigateToIssueDetails(guildDeleteFeedbackCopy$default, false));
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectRating(FeedbackRating feedbackRating) {
        Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
        FeedbackSheetViewModel.DefaultImpls.selectRating(this, feedbackRating);
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void submitForm() {
        if (this.submitted) {
            return;
        }
        this.submitted = true;
        boolean z2 = this.pendingFeedback.getReason() != null;
        if (z2) {
            new GuildDeleteFeedbackSubmitter(this.pendingFeedback).submit(null);
        } else {
            new GuildDeleteFeedbackSubmitter(this.pendingFeedback).skip();
        }
        this.eventSubject.k.onNext(new FeedbackSheetViewModel.Event.Submitted(z2));
    }
}
