package com.discord.widgets.voice.feedback.stream;

import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.feedback.FeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StreamFeedbackSubmitter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/voice/feedback/stream/StreamFeedbackSubmitter;", "Lcom/discord/widgets/voice/feedback/FeedbackSubmitter;", "", "issueDetails", "", "submit", "(Ljava/lang/String;)V", "Lcom/discord/stores/StoreAnalytics;", "analyticsStore", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;", "pendingStreamFeedback", "Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;", "getPendingStreamFeedback", "()Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;", "setPendingStreamFeedback", "(Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;)V", "<init>", "(Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;Lcom/discord/stores/StoreAnalytics;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class StreamFeedbackSubmitter implements FeedbackSubmitter {
    private final StoreAnalytics analyticsStore;
    private PendingFeedback.StreamFeedback pendingStreamFeedback;

    public StreamFeedbackSubmitter(PendingFeedback.StreamFeedback streamFeedback, StoreAnalytics storeAnalytics) {
        Intrinsics3.checkNotNullParameter(streamFeedback, "pendingStreamFeedback");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        this.pendingStreamFeedback = streamFeedback;
        this.analyticsStore = storeAnalytics;
    }

    public final PendingFeedback.StreamFeedback getPendingStreamFeedback() {
        return this.pendingStreamFeedback;
    }

    public final void setPendingStreamFeedback(PendingFeedback.StreamFeedback streamFeedback) {
        Intrinsics3.checkNotNullParameter(streamFeedback, "<set-?>");
        this.pendingStreamFeedback = streamFeedback;
    }

    @Override // com.discord.widgets.voice.feedback.FeedbackSubmitter
    public void submit(String issueDetails) {
        this.analyticsStore.trackStreamReportProblem(issueDetails != null ? PendingFeedback.StreamFeedback.copy$default(this.pendingStreamFeedback, null, null, null, null, issueDetails, 15, null) : this.pendingStreamFeedback);
    }

    public /* synthetic */ StreamFeedbackSubmitter(PendingFeedback.StreamFeedback streamFeedback, StoreAnalytics storeAnalytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(streamFeedback, (i & 2) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics);
    }
}
