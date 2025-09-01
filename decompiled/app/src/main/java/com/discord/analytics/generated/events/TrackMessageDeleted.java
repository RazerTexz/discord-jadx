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

/* compiled from: TrackMessageDeleted.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014R\u001b\u0010#\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014R\u001c\u0010%\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0007R\u001b\u0010(\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014R$\u0010+\u001a\u0004\u0018\u00010*8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0012\u001a\u0004\b2\u0010\u0014R\u001b\u00103\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0014R!\u00106\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001058\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001b\u0010:\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0012\u001a\u0004\b;\u0010\u0014R\u001b\u0010<\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0012\u001a\u0004\b=\u0010\u0014R$\u0010?\u001a\u0004\u0018\u00010>8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/discord/analytics/generated/events/TrackMessageDeleted;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "numEmbeds", "Ljava/lang/Long;", "getNumEmbeds", "()Ljava/lang/Long;", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "Ljava/lang/CharSequence;", "getReason", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "numMentions", "getNumMentions", "numAttachments", "getNumAttachments", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "numUrls", "getNumUrls", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "wordCount", "getWordCount", "length", "getLength", "", "urls", "Ljava/util/List;", "getUrls", "()Ljava/util/List;", "messageId", "getMessageId", "authorId", "getAuthorId", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackMessageDeleted implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long messageId = null;
    private final CharSequence reason = null;
    private final Long authorId = null;
    private final Long numUrls = null;
    private final Long numAttachments = null;
    private final Long numEmbeds = null;
    private final Long numMentions = null;
    private final Long length = null;
    private final Long wordCount = null;
    private final List<CharSequence> urls = null;
    private final transient String analyticsSchemaTypeName = "message_deleted";

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
        if (!(other instanceof TrackMessageDeleted)) {
            return false;
        }
        TrackMessageDeleted trackMessageDeleted = (TrackMessageDeleted) other;
        return Intrinsics3.areEqual(this.messageId, trackMessageDeleted.messageId) && Intrinsics3.areEqual(this.reason, trackMessageDeleted.reason) && Intrinsics3.areEqual(this.authorId, trackMessageDeleted.authorId) && Intrinsics3.areEqual(this.numUrls, trackMessageDeleted.numUrls) && Intrinsics3.areEqual(this.numAttachments, trackMessageDeleted.numAttachments) && Intrinsics3.areEqual(this.numEmbeds, trackMessageDeleted.numEmbeds) && Intrinsics3.areEqual(this.numMentions, trackMessageDeleted.numMentions) && Intrinsics3.areEqual(this.length, trackMessageDeleted.length) && Intrinsics3.areEqual(this.wordCount, trackMessageDeleted.wordCount) && Intrinsics3.areEqual(this.urls, trackMessageDeleted.urls);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.reason;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.authorId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numUrls;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numAttachments;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numEmbeds;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numMentions;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.length;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.wordCount;
        int iHashCode9 = (iHashCode8 + (l8 != null ? l8.hashCode() : 0)) * 31;
        List<CharSequence> list = this.urls;
        return iHashCode9 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMessageDeleted(messageId=");
        sbU.append(this.messageId);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", authorId=");
        sbU.append(this.authorId);
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
