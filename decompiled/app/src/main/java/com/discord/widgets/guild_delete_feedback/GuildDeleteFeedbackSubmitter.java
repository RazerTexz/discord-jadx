package com.discord.widgets.guild_delete_feedback;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildDeleteFeedbackSubmitter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/guild_delete_feedback/GuildDeleteFeedbackSubmitter;", "Lcom/discord/widgets/voice/feedback/FeedbackSubmitter;", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "issue", "", "getReasonFromFeedbackIssue", "(Lcom/discord/widgets/voice/feedback/FeedbackIssue;)Ljava/lang/String;", "issueDetails", "", "submit", "(Ljava/lang/String;)V", "skip", "()V", "Lcom/discord/widgets/voice/feedback/PendingFeedback$GuildDeleteFeedback;", "pendingFeedback", "Lcom/discord/widgets/voice/feedback/PendingFeedback$GuildDeleteFeedback;", "getPendingFeedback", "()Lcom/discord/widgets/voice/feedback/PendingFeedback$GuildDeleteFeedback;", "<init>", "(Lcom/discord/widgets/voice/feedback/PendingFeedback$GuildDeleteFeedback;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildDeleteFeedbackSubmitter implements FeedbackSubmitter {
    private final PendingFeedback.GuildDeleteFeedback pendingFeedback;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FeedbackIssue.values();
            int[] iArr = new int[24];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedbackIssue.GUILD_DELETE_TOO_HARD.ordinal()] = 1;
            iArr[FeedbackIssue.GUILD_DELETE_TEST.ordinal()] = 2;
            iArr[FeedbackIssue.GUILD_DELETE_ACCIDENT.ordinal()] = 3;
            iArr[FeedbackIssue.GUILD_DELETE_TEMPLATE.ordinal()] = 4;
            iArr[FeedbackIssue.GUILD_DELETE_LONELY.ordinal()] = 5;
            iArr[FeedbackIssue.GUILD_DELETE_INACTIVE.ordinal()] = 6;
            iArr[FeedbackIssue.GUILD_DELETE_OTHER.ordinal()] = 7;
        }
    }

    public GuildDeleteFeedbackSubmitter(PendingFeedback.GuildDeleteFeedback guildDeleteFeedback) {
        Intrinsics3.checkNotNullParameter(guildDeleteFeedback, "pendingFeedback");
        this.pendingFeedback = guildDeleteFeedback;
    }

    private final String getReasonFromFeedbackIssue(FeedbackIssue issue) {
        if (issue != null) {
            switch (issue.ordinal()) {
                case 17:
                    return "Too hard";
                case 18:
                    return "Testing purposes";
                case 19:
                    return "Created on accident";
                case 20:
                    return "Curious about server/template";
                case 21:
                    return "Empty server";
                case 22:
                    return "Inactive server";
                case 23:
                    return "Other";
            }
        }
        return null;
    }

    public final PendingFeedback.GuildDeleteFeedback getPendingFeedback() {
        return this.pendingFeedback;
    }

    public final void skip() {
        AnalyticsTracker.INSTANCE.userReportSubmitted("Guild Deletion", this.pendingFeedback.getGuildId(), null, null, true);
    }

    @Override // com.discord.widgets.voice.feedback.FeedbackSubmitter
    public void submit(String issueDetails) {
        AnalyticsTracker.INSTANCE.userReportSubmitted("Guild Deletion", this.pendingFeedback.getGuildId(), getReasonFromFeedbackIssue(this.pendingFeedback.getReason()), issueDetails, false);
    }
}
