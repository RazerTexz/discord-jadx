package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackMessageDeletedByAdmin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014R\u001c\u0010)\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0007R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0014R\u001b\u00105\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0012\u001a\u0004\b6\u0010\u0014R\u001b\u00107\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0012\u001a\u0004\b8\u0010\u0014R\u001b\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R!\u0010?\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/discord/analytics/generated/events/TrackMessageDeletedByAdmin;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "numAttachments", "Ljava/lang/Long;", "getNumAttachments", "()Ljava/lang/Long;", "numUrls", "getNumUrls", "messageId", "getMessageId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "numMentions", "getNumMentions", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "wordCount", "getWordCount", "length", "getLength", "numEmbeds", "getNumEmbeds", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "Ljava/lang/CharSequence;", "getReason", "()Ljava/lang/CharSequence;", "", "urls", "Ljava/util/List;", "getUrls", "()Ljava/util/List;", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackMessageDeletedByAdmin implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long messageId = null;
    private final CharSequence reason = null;
    private final Long numUrls = null;
    private final Long numAttachments = null;
    private final Long numEmbeds = null;
    private final Long numMentions = null;
    private final Long length = null;
    private final Long wordCount = null;
    private final List<CharSequence> urls = null;
    private final transient String analyticsSchemaTypeName = "message_deleted_by_admin";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMessageDeletedByAdmin)) {
            return false;
        }
        TrackMessageDeletedByAdmin trackMessageDeletedByAdmin = (TrackMessageDeletedByAdmin) other;
        return Intrinsics3.areEqual(this.messageId, trackMessageDeletedByAdmin.messageId) && Intrinsics3.areEqual(this.reason, trackMessageDeletedByAdmin.reason) && Intrinsics3.areEqual(this.numUrls, trackMessageDeletedByAdmin.numUrls) && Intrinsics3.areEqual(this.numAttachments, trackMessageDeletedByAdmin.numAttachments) && Intrinsics3.areEqual(this.numEmbeds, trackMessageDeletedByAdmin.numEmbeds) && Intrinsics3.areEqual(this.numMentions, trackMessageDeletedByAdmin.numMentions) && Intrinsics3.areEqual(this.length, trackMessageDeletedByAdmin.length) && Intrinsics3.areEqual(this.wordCount, trackMessageDeletedByAdmin.wordCount) && Intrinsics3.areEqual(this.urls, trackMessageDeletedByAdmin.urls);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.reason;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.numUrls;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numAttachments;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numEmbeds;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numMentions;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.length;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.wordCount;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        List<CharSequence> list = this.urls;
        return iHashCode8 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMessageDeletedByAdmin(messageId=");
        sbU.append(this.messageId);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", numUrls=");
        sbU.append(this.numUrls);
        sbU.append(", numAttachments=");
        sbU.append(this.numAttachments);
        sbU.append(", numEmbeds=");
        sbU.append(this.numEmbeds);
        sbU.append(", numMentions=");
        sbU.append(this.numMentions);
        sbU.append(", length=");
        sbU.append(this.length);
        sbU.append(", wordCount=");
        sbU.append(this.wordCount);
        sbU.append(", urls=");
        return outline.L(sbU, this.urls, ")");
    }
}
