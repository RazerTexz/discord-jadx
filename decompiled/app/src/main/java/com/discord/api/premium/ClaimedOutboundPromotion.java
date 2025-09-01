package com.discord.api.premium;

import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: ClaimedOutboundPromotion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001f\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/api/premium/ClaimedOutboundPromotion;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/UserId;", "userId", "J", "getUserId", "()J", "Lcom/discord/api/utcdatetime/UtcDateTime;", "claimedAt", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getClaimedAt", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "d", "redemptionLink", "Lcom/discord/api/premium/OutboundPromotion;", "promotion", "Lcom/discord/api/premium/OutboundPromotion;", "b", "()Lcom/discord/api/premium/OutboundPromotion;", "c", "redeemByDate", ModelAuditLogEntry.CHANGE_KEY_CODE, "Ljava/lang/String;", "a", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ClaimedOutboundPromotion {
    private final UtcDateTime claimedAt;
    private final String code;
    private final OutboundPromotion promotion;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final OutboundPromotion getPromotion() {
        return this.promotion;
    }

    public final UtcDateTime c() {
        return new UtcDateTime(TimeUnit.DAYS.toMillis(30L) + this.promotion.getEndDate().getDateTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String d() throws UnsupportedEncodingException {
        String outboundRedemptionPageLink;
        String outboundRedemptionUrlFormat = this.promotion.getOutboundRedemptionUrlFormat();
        if (outboundRedemptionUrlFormat != null) {
            String strEncode = URLEncoder.encode(this.code, Constants.ENCODING);
            Intrinsics3.checkNotNullExpressionValue(strEncode, "URLEncoder.encode(code, \"UTF-8\")");
            outboundRedemptionPageLink = StringsJVM.replace$default(outboundRedemptionUrlFormat, "{code}", strEncode, false, 4, (Object) null);
            if (outboundRedemptionPageLink == null) {
                outboundRedemptionPageLink = this.promotion.getOutboundRedemptionPageLink();
            }
        }
        return outboundRedemptionPageLink != null ? outboundRedemptionPageLink : "";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClaimedOutboundPromotion)) {
            return false;
        }
        ClaimedOutboundPromotion claimedOutboundPromotion = (ClaimedOutboundPromotion) other;
        return Intrinsics3.areEqual(this.code, claimedOutboundPromotion.code) && this.userId == claimedOutboundPromotion.userId && Intrinsics3.areEqual(this.claimedAt, claimedOutboundPromotion.claimedAt) && Intrinsics3.areEqual(this.promotion, claimedOutboundPromotion.promotion);
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.userId;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        UtcDateTime utcDateTime = this.claimedAt;
        int iHashCode2 = (i + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        OutboundPromotion outboundPromotion = this.promotion;
        return iHashCode2 + (outboundPromotion != null ? outboundPromotion.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ClaimedOutboundPromotion(code=");
        sbU.append(this.code);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", claimedAt=");
        sbU.append(this.claimedAt);
        sbU.append(", promotion=");
        sbU.append(this.promotion);
        sbU.append(")");
        return sbU.toString();
    }
}
