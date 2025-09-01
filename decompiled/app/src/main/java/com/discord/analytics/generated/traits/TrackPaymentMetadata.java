package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackPaymentMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "price", "Ljava/lang/Long;", "getPrice", "()Ljava/lang/Long;", "", "paymentType", "Ljava/lang/CharSequence;", "getPaymentType", "()Ljava/lang/CharSequence;", "isGift", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "regularPrice", "getRegularPrice", "currency", "getCurrency", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackPaymentMetadata {
    private final CharSequence paymentType = null;
    private final Long price = null;
    private final Long regularPrice = null;
    private final CharSequence currency = null;
    private final Boolean isGift = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentMetadata)) {
            return false;
        }
        TrackPaymentMetadata trackPaymentMetadata = (TrackPaymentMetadata) other;
        return Intrinsics3.areEqual(this.paymentType, trackPaymentMetadata.paymentType) && Intrinsics3.areEqual(this.price, trackPaymentMetadata.price) && Intrinsics3.areEqual(this.regularPrice, trackPaymentMetadata.regularPrice) && Intrinsics3.areEqual(this.currency, trackPaymentMetadata.currency) && Intrinsics3.areEqual(this.isGift, trackPaymentMetadata.isGift);
    }

    public int hashCode() {
        CharSequence charSequence = this.paymentType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.price;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.regularPrice;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.currency;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.isGift;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPaymentMetadata(paymentType=");
        sbU.append(this.paymentType);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", regularPrice=");
        sbU.append(this.regularPrice);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", isGift=");
        return outline.D(sbU, this.isGift, ")");
    }
}
