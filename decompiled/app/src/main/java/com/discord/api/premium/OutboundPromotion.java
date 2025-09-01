package com.discord.api.premium;

import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: OutboundPromotion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001d\u0010\u001a\u001a\u00060\u0018j\u0002`\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u0004R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u0004¨\u0006$"}, d2 = {"Lcom/discord/api/premium/OutboundPromotion;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "outboundRedemptionUrlFormat", "Ljava/lang/String;", "e", "Lcom/discord/api/utcdatetime/UtcDateTime;", "startDate", "Lcom/discord/api/utcdatetime/UtcDateTime;", "h", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "outboundTitle", "g", "endDate", "a", "", "Lcom/discord/primitives/PromoId;", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "b", "()J", "outboundRedemptionPageLink", "d", "outboundTermsAndConditions", "f", "outboundRedemptionModalBody", "c", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class OutboundPromotion {
    private final UtcDateTime endDate;
    private final long id;
    private final String outboundRedemptionModalBody;
    private final String outboundRedemptionPageLink;
    private final String outboundRedemptionUrlFormat;
    private final String outboundTermsAndConditions;
    private final String outboundTitle;
    private final UtcDateTime startDate;

    /* renamed from: a, reason: from getter */
    public final UtcDateTime getEndDate() {
        return this.endDate;
    }

    /* renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final String getOutboundRedemptionModalBody() {
        return this.outboundRedemptionModalBody;
    }

    /* renamed from: d, reason: from getter */
    public final String getOutboundRedemptionPageLink() {
        return this.outboundRedemptionPageLink;
    }

    /* renamed from: e, reason: from getter */
    public final String getOutboundRedemptionUrlFormat() {
        return this.outboundRedemptionUrlFormat;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundPromotion)) {
            return false;
        }
        OutboundPromotion outboundPromotion = (OutboundPromotion) other;
        return this.id == outboundPromotion.id && Intrinsics3.areEqual(this.startDate, outboundPromotion.startDate) && Intrinsics3.areEqual(this.endDate, outboundPromotion.endDate) && Intrinsics3.areEqual(this.outboundTitle, outboundPromotion.outboundTitle) && Intrinsics3.areEqual(this.outboundRedemptionModalBody, outboundPromotion.outboundRedemptionModalBody) && Intrinsics3.areEqual(this.outboundRedemptionPageLink, outboundPromotion.outboundRedemptionPageLink) && Intrinsics3.areEqual(this.outboundRedemptionUrlFormat, outboundPromotion.outboundRedemptionUrlFormat) && Intrinsics3.areEqual(this.outboundTermsAndConditions, outboundPromotion.outboundTermsAndConditions);
    }

    /* renamed from: f, reason: from getter */
    public final String getOutboundTermsAndConditions() {
        return this.outboundTermsAndConditions;
    }

    /* renamed from: g, reason: from getter */
    public final String getOutboundTitle() {
        return this.outboundTitle;
    }

    /* renamed from: h, reason: from getter */
    public final UtcDateTime getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        UtcDateTime utcDateTime = this.startDate;
        int iHashCode = (i + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.endDate;
        int iHashCode2 = (iHashCode + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0)) * 31;
        String str = this.outboundTitle;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.outboundRedemptionModalBody;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.outboundRedemptionPageLink;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.outboundRedemptionUrlFormat;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.outboundTermsAndConditions;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OutboundPromotion(id=");
        sbU.append(this.id);
        sbU.append(", startDate=");
        sbU.append(this.startDate);
        sbU.append(", endDate=");
        sbU.append(this.endDate);
        sbU.append(", outboundTitle=");
        sbU.append(this.outboundTitle);
        sbU.append(", outboundRedemptionModalBody=");
        sbU.append(this.outboundRedemptionModalBody);
        sbU.append(", outboundRedemptionPageLink=");
        sbU.append(this.outboundRedemptionPageLink);
        sbU.append(", outboundRedemptionUrlFormat=");
        sbU.append(this.outboundRedemptionUrlFormat);
        sbU.append(", outboundTermsAndConditions=");
        return outline.J(sbU, this.outboundTermsAndConditions, ")");
    }
}
