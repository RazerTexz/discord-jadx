package com.discord.widgets.voice.feedback.call;

import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.feedback.FeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* compiled from: CallFeedbackSubmitter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/voice/feedback/call/CallFeedbackSubmitter;", "Lcom/discord/widgets/voice/feedback/FeedbackSubmitter;", "", "issueDetails", "", "submit", "(Ljava/lang/String;)V", "Lcom/discord/stores/StoreAnalytics;", "analyticsStore", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;", "pendingCallFeedback", "Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;", "getPendingCallFeedback", "()Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;", "setPendingCallFeedback", "(Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;)V", "<init>", "(Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;Lcom/discord/stores/StoreAnalytics;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CallFeedbackSubmitter implements FeedbackSubmitter {
    private final StoreAnalytics analyticsStore;
    private PendingFeedback.CallFeedback pendingCallFeedback;

    public CallFeedbackSubmitter(PendingFeedback.CallFeedback callFeedback, StoreAnalytics storeAnalytics) {
        Intrinsics3.checkNotNullParameter(callFeedback, "pendingCallFeedback");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        this.pendingCallFeedback = callFeedback;
        this.analyticsStore = storeAnalytics;
    }

    public final PendingFeedback.CallFeedback getPendingCallFeedback() {
        return this.pendingCallFeedback;
    }

    public final void setPendingCallFeedback(PendingFeedback.CallFeedback callFeedback) {
        Intrinsics3.checkNotNullParameter(callFeedback, "<set-?>");
        this.pendingCallFeedback = callFeedback;
    }

    @Override // com.discord.widgets.voice.feedback.FeedbackSubmitter
    public void submit(String issueDetails) {
        this.analyticsStore.trackCallReportProblem(issueDetails != null ? PendingFeedback.CallFeedback.copy$default(this.pendingCallFeedback, 0L, null, null, null, null, null, null, issueDetails, Opcodes.LAND, null) : this.pendingCallFeedback);
    }

    public /* synthetic */ CallFeedbackSubmitter(PendingFeedback.CallFeedback callFeedback, StoreAnalytics storeAnalytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(callFeedback, (i & 2) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics);
    }
}
