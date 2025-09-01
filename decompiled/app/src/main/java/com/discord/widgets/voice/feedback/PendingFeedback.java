package com.discord.widgets.voice.feedback;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PendingFeedback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/voice/feedback/PendingFeedback;", "Ljava/io/Serializable;", "<init>", "()V", "CallFeedback", "GuildDeleteFeedback", "StreamFeedback", "Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;", "Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;", "Lcom/discord/widgets/voice/feedback/PendingFeedback$GuildDeleteFeedback;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class PendingFeedback implements Serializable {

    /* compiled from: PendingFeedback.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/discord/widgets/voice/feedback/PendingFeedback$GuildDeleteFeedback;", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "component2", "()Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "", "component3", "()Ljava/lang/String;", "guildId", ModelAuditLogEntry.CHANGE_KEY_REASON, "issueDetails", "copy", "(JLcom/discord/widgets/voice/feedback/FeedbackIssue;Ljava/lang/String;)Lcom/discord/widgets/voice/feedback/PendingFeedback$GuildDeleteFeedback;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "getReason", "J", "getGuildId", "Ljava/lang/String;", "getIssueDetails", "<init>", "(JLcom/discord/widgets/voice/feedback/FeedbackIssue;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildDeleteFeedback extends PendingFeedback {
        private final long guildId;
        private final String issueDetails;
        private final FeedbackIssue reason;

        public /* synthetic */ GuildDeleteFeedback(long j, FeedbackIssue feedbackIssue, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : feedbackIssue, (i & 4) != 0 ? null : str);
        }

        public static /* synthetic */ GuildDeleteFeedback copy$default(GuildDeleteFeedback guildDeleteFeedback, long j, FeedbackIssue feedbackIssue, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = guildDeleteFeedback.guildId;
            }
            if ((i & 2) != 0) {
                feedbackIssue = guildDeleteFeedback.reason;
            }
            if ((i & 4) != 0) {
                str = guildDeleteFeedback.issueDetails;
            }
            return guildDeleteFeedback.copy(j, feedbackIssue, str);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final FeedbackIssue getReason() {
            return this.reason;
        }

        /* renamed from: component3, reason: from getter */
        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final GuildDeleteFeedback copy(long guildId, FeedbackIssue reason, String issueDetails) {
            return new GuildDeleteFeedback(guildId, reason, issueDetails);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildDeleteFeedback)) {
                return false;
            }
            GuildDeleteFeedback guildDeleteFeedback = (GuildDeleteFeedback) other;
            return this.guildId == guildDeleteFeedback.guildId && Intrinsics3.areEqual(this.reason, guildDeleteFeedback.reason) && Intrinsics3.areEqual(this.issueDetails, guildDeleteFeedback.issueDetails);
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final FeedbackIssue getReason() {
            return this.reason;
        }

        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            FeedbackIssue feedbackIssue = this.reason;
            int iHashCode = (iA + (feedbackIssue != null ? feedbackIssue.hashCode() : 0)) * 31;
            String str = this.issueDetails;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildDeleteFeedback(guildId=");
            sbU.append(this.guildId);
            sbU.append(", reason=");
            sbU.append(this.reason);
            sbU.append(", issueDetails=");
            return outline.J(sbU, this.issueDetails, ")");
        }

        public GuildDeleteFeedback(long j, FeedbackIssue feedbackIssue, String str) {
            super(null);
            this.guildId = j;
            this.reason = feedbackIssue;
            this.issueDetails = str;
        }
    }

    private PendingFeedback() {
    }

    /* compiled from: PendingFeedback.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\u0010\u0016\u001a\u00060\u0002j\u0002`\u0003\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b5\u00106J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\tJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0015\u0010\tJ|\u0010\u001e\u001a\u00020\u00002\f\b\u0002\u0010\u0016\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010\tJ\u0010\u0010!\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b)\u0010\tR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010(\u001a\u0004\b*\u0010\tR\u001d\u0010\u0016\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u0005R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b.\u0010\u000bR\u0019\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\u0010R!\u0010\u0019\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b1\u0010\tR!\u0010\u0017\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b2\u0010\tR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b4\u0010\u0013¨\u00067"}, d2 = {"Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "Lcom/discord/primitives/RtcConnectionId;", "component2", "()Ljava/lang/String;", "component3", "()Ljava/lang/Long;", "Lcom/discord/primitives/MediaSessionId;", "component4", "Lcom/discord/widgets/voice/feedback/FeedbackRating;", "component5", "()Lcom/discord/widgets/voice/feedback/FeedbackRating;", "", "component6", "()Ljava/lang/Integer;", "component7", "component8", "channelId", "rtcConnectionId", "durationMs", "mediaSessionId", "feedbackRating", "reasonCode", "reasonDescription", "issueDetails", "copy", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/discord/widgets/voice/feedback/FeedbackRating;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/voice/feedback/PendingFeedback$CallFeedback;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReasonDescription", "getIssueDetails", "J", "getChannelId", "Ljava/lang/Long;", "getDurationMs", "Lcom/discord/widgets/voice/feedback/FeedbackRating;", "getFeedbackRating", "getMediaSessionId", "getRtcConnectionId", "Ljava/lang/Integer;", "getReasonCode", "<init>", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/discord/widgets/voice/feedback/FeedbackRating;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CallFeedback extends PendingFeedback {
        private final long channelId;
        private final Long durationMs;
        private final FeedbackRating feedbackRating;
        private final String issueDetails;
        private final String mediaSessionId;
        private final Integer reasonCode;
        private final String reasonDescription;
        private final String rtcConnectionId;

        public /* synthetic */ CallFeedback(long j, String str, Long l, String str2, FeedbackRating feedbackRating, Integer num, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? FeedbackRating.NO_RESPONSE : feedbackRating, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4);
        }

        public static /* synthetic */ CallFeedback copy$default(CallFeedback callFeedback, long j, String str, Long l, String str2, FeedbackRating feedbackRating, Integer num, String str3, String str4, int i, Object obj) {
            return callFeedback.copy((i & 1) != 0 ? callFeedback.channelId : j, (i & 2) != 0 ? callFeedback.rtcConnectionId : str, (i & 4) != 0 ? callFeedback.durationMs : l, (i & 8) != 0 ? callFeedback.mediaSessionId : str2, (i & 16) != 0 ? callFeedback.feedbackRating : feedbackRating, (i & 32) != 0 ? callFeedback.reasonCode : num, (i & 64) != 0 ? callFeedback.reasonDescription : str3, (i & 128) != 0 ? callFeedback.issueDetails : str4);
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
        public final Long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: component4, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        /* renamed from: component5, reason: from getter */
        public final FeedbackRating getFeedbackRating() {
            return this.feedbackRating;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getReasonCode() {
            return this.reasonCode;
        }

        /* renamed from: component7, reason: from getter */
        public final String getReasonDescription() {
            return this.reasonDescription;
        }

        /* renamed from: component8, reason: from getter */
        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final CallFeedback copy(long channelId, String rtcConnectionId, Long durationMs, String mediaSessionId, FeedbackRating feedbackRating, Integer reasonCode, String reasonDescription, String issueDetails) {
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
            return new CallFeedback(channelId, rtcConnectionId, durationMs, mediaSessionId, feedbackRating, reasonCode, reasonDescription, issueDetails);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallFeedback)) {
                return false;
            }
            CallFeedback callFeedback = (CallFeedback) other;
            return this.channelId == callFeedback.channelId && Intrinsics3.areEqual(this.rtcConnectionId, callFeedback.rtcConnectionId) && Intrinsics3.areEqual(this.durationMs, callFeedback.durationMs) && Intrinsics3.areEqual(this.mediaSessionId, callFeedback.mediaSessionId) && Intrinsics3.areEqual(this.feedbackRating, callFeedback.feedbackRating) && Intrinsics3.areEqual(this.reasonCode, callFeedback.reasonCode) && Intrinsics3.areEqual(this.reasonDescription, callFeedback.reasonDescription) && Intrinsics3.areEqual(this.issueDetails, callFeedback.issueDetails);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Long getDurationMs() {
            return this.durationMs;
        }

        public final FeedbackRating getFeedbackRating() {
            return this.feedbackRating;
        }

        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final Integer getReasonCode() {
            return this.reasonCode;
        }

        public final String getReasonDescription() {
            return this.reasonDescription;
        }

        public final String getRtcConnectionId() {
            return this.rtcConnectionId;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            String str = this.rtcConnectionId;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            Long l = this.durationMs;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            String str2 = this.mediaSessionId;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            FeedbackRating feedbackRating = this.feedbackRating;
            int iHashCode4 = (iHashCode3 + (feedbackRating != null ? feedbackRating.hashCode() : 0)) * 31;
            Integer num = this.reasonCode;
            int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
            String str3 = this.reasonDescription;
            int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.issueDetails;
            return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CallFeedback(channelId=");
            sbU.append(this.channelId);
            sbU.append(", rtcConnectionId=");
            sbU.append(this.rtcConnectionId);
            sbU.append(", durationMs=");
            sbU.append(this.durationMs);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", feedbackRating=");
            sbU.append(this.feedbackRating);
            sbU.append(", reasonCode=");
            sbU.append(this.reasonCode);
            sbU.append(", reasonDescription=");
            sbU.append(this.reasonDescription);
            sbU.append(", issueDetails=");
            return outline.J(sbU, this.issueDetails, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallFeedback(long j, String str, Long l, String str2, FeedbackRating feedbackRating, Integer num, String str3, String str4) {
            super(null);
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
            this.channelId = j;
            this.rtcConnectionId = str;
            this.durationMs = l;
            this.mediaSessionId = str2;
            this.feedbackRating = feedbackRating;
            this.reasonCode = num;
            this.reasonDescription = str3;
            this.issueDetails = str4;
        }
    }

    /* compiled from: PendingFeedback.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJN\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR!\u0010\u0013\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\u000eR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b\"\u0010\u000eR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\nR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\u0007¨\u0006+"}, d2 = {"Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;", "Lcom/discord/widgets/voice/feedback/PendingFeedback;", "Lcom/discord/models/domain/ModelApplicationStream;", "component1", "()Lcom/discord/models/domain/ModelApplicationStream;", "Lcom/discord/widgets/voice/feedback/FeedbackRating;", "component2", "()Lcom/discord/widgets/voice/feedback/FeedbackRating;", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "component3", "()Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "", "Lcom/discord/primitives/MediaSessionId;", "component4", "()Ljava/lang/String;", "component5", "stream", "feedbackRating", "issue", "mediaSessionId", "issueDetails", "copy", "(Lcom/discord/models/domain/ModelApplicationStream;Lcom/discord/widgets/voice/feedback/FeedbackRating;Lcom/discord/widgets/voice/feedback/FeedbackIssue;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/voice/feedback/PendingFeedback$StreamFeedback;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMediaSessionId", "getIssueDetails", "Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "getIssue", "Lcom/discord/models/domain/ModelApplicationStream;", "getStream", "Lcom/discord/widgets/voice/feedback/FeedbackRating;", "getFeedbackRating", "<init>", "(Lcom/discord/models/domain/ModelApplicationStream;Lcom/discord/widgets/voice/feedback/FeedbackRating;Lcom/discord/widgets/voice/feedback/FeedbackIssue;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StreamFeedback extends PendingFeedback {
        private final FeedbackRating feedbackRating;
        private final FeedbackIssue issue;
        private final String issueDetails;
        private final String mediaSessionId;
        private final ModelApplicationStream stream;

        public /* synthetic */ StreamFeedback(ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, FeedbackIssue feedbackIssue, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(modelApplicationStream, (i & 2) != 0 ? FeedbackRating.NO_RESPONSE : feedbackRating, (i & 4) != 0 ? null : feedbackIssue, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
        }

        public static /* synthetic */ StreamFeedback copy$default(StreamFeedback streamFeedback, ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, FeedbackIssue feedbackIssue, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelApplicationStream = streamFeedback.stream;
            }
            if ((i & 2) != 0) {
                feedbackRating = streamFeedback.feedbackRating;
            }
            FeedbackRating feedbackRating2 = feedbackRating;
            if ((i & 4) != 0) {
                feedbackIssue = streamFeedback.issue;
            }
            FeedbackIssue feedbackIssue2 = feedbackIssue;
            if ((i & 8) != 0) {
                str = streamFeedback.mediaSessionId;
            }
            String str3 = str;
            if ((i & 16) != 0) {
                str2 = streamFeedback.issueDetails;
            }
            return streamFeedback.copy(modelApplicationStream, feedbackRating2, feedbackIssue2, str3, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        /* renamed from: component2, reason: from getter */
        public final FeedbackRating getFeedbackRating() {
            return this.feedbackRating;
        }

        /* renamed from: component3, reason: from getter */
        public final FeedbackIssue getIssue() {
            return this.issue;
        }

        /* renamed from: component4, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final StreamFeedback copy(ModelApplicationStream stream, FeedbackRating feedbackRating, FeedbackIssue issue, String mediaSessionId, String issueDetails) {
            Intrinsics3.checkNotNullParameter(stream, "stream");
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
            return new StreamFeedback(stream, feedbackRating, issue, mediaSessionId, issueDetails);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreamFeedback)) {
                return false;
            }
            StreamFeedback streamFeedback = (StreamFeedback) other;
            return Intrinsics3.areEqual(this.stream, streamFeedback.stream) && Intrinsics3.areEqual(this.feedbackRating, streamFeedback.feedbackRating) && Intrinsics3.areEqual(this.issue, streamFeedback.issue) && Intrinsics3.areEqual(this.mediaSessionId, streamFeedback.mediaSessionId) && Intrinsics3.areEqual(this.issueDetails, streamFeedback.issueDetails);
        }

        public final FeedbackRating getFeedbackRating() {
            return this.feedbackRating;
        }

        public final FeedbackIssue getIssue() {
            return this.issue;
        }

        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        public int hashCode() {
            ModelApplicationStream modelApplicationStream = this.stream;
            int iHashCode = (modelApplicationStream != null ? modelApplicationStream.hashCode() : 0) * 31;
            FeedbackRating feedbackRating = this.feedbackRating;
            int iHashCode2 = (iHashCode + (feedbackRating != null ? feedbackRating.hashCode() : 0)) * 31;
            FeedbackIssue feedbackIssue = this.issue;
            int iHashCode3 = (iHashCode2 + (feedbackIssue != null ? feedbackIssue.hashCode() : 0)) * 31;
            String str = this.mediaSessionId;
            int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.issueDetails;
            return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StreamFeedback(stream=");
            sbU.append(this.stream);
            sbU.append(", feedbackRating=");
            sbU.append(this.feedbackRating);
            sbU.append(", issue=");
            sbU.append(this.issue);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", issueDetails=");
            return outline.J(sbU, this.issueDetails, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StreamFeedback(ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, FeedbackIssue feedbackIssue, String str, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(modelApplicationStream, "stream");
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
            this.stream = modelApplicationStream;
            this.feedbackRating = feedbackRating;
            this.issue = feedbackIssue;
            this.mediaSessionId = str;
            this.issueDetails = str2;
        }
    }

    public /* synthetic */ PendingFeedback(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
