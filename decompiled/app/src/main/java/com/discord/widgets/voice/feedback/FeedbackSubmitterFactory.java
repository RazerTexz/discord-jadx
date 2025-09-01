package com.discord.widgets.voice.feedback;

import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import com.discord.widgets.voice.feedback.call.CallFeedbackSubmitter;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSubmitter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: FeedbackSubmitterFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/voice/feedback/FeedbackSubmitterFactory;", "", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "pendingFeedback", "Lcom/discord/widgets/voice/feedback/FeedbackSubmitter;", "create", "(Lcom/discord/widgets/voice/feedback/PendingFeedback;)Lcom/discord/widgets/voice/feedback/FeedbackSubmitter;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class FeedbackSubmitterFactory {
    public static final FeedbackSubmitterFactory INSTANCE = new FeedbackSubmitterFactory();

    private FeedbackSubmitterFactory() {
    }

    public final FeedbackSubmitter create(PendingFeedback pendingFeedback) {
        Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
        if (pendingFeedback instanceof PendingFeedback.CallFeedback) {
            return new CallFeedbackSubmitter((PendingFeedback.CallFeedback) pendingFeedback, null, 2, null);
        }
        if (pendingFeedback instanceof PendingFeedback.StreamFeedback) {
            return new StreamFeedbackSubmitter((PendingFeedback.StreamFeedback) pendingFeedback, null, 2, null);
        }
        if (pendingFeedback instanceof PendingFeedback.GuildDeleteFeedback) {
            return new GuildDeleteFeedbackSubmitter((PendingFeedback.GuildDeleteFeedback) pendingFeedback);
        }
        throw new NoWhenBranchMatchedException();
    }
}
