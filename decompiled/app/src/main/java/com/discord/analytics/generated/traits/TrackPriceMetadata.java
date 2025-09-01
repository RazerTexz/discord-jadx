package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackPriceMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackPriceMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "regularPrice", "Ljava/lang/Long;", "getRegularPrice", "()Ljava/lang/Long;", "price", "getPrice", "", "currency", "Ljava/lang/CharSequence;", "getCurrency", "()Ljava/lang/CharSequence;", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackPriceMetadata {
    private final Long price = null;
    private final Long regularPrice = null;
    private final CharSequence currency = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPriceMetadata)) {
            return false;
        }
        TrackPriceMetadata trackPriceMetadata = (TrackPriceMetadata) other;
        return Intrinsics3.areEqual(this.price, trackPriceMetadata.price) && Intrinsics3.areEqual(this.regularPrice, trackPriceMetadata.regularPrice) && Intrinsics3.areEqual(this.currency, trackPriceMetadata.currency);
    }

    public int hashCode() {
        Long l = this.price;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.regularPrice;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.currency;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPriceMetadata(price=");
        sbU.append(this.price);
        sbU.append(", regularPrice=");
        sbU.append(this.regularPrice);
        sbU.append(", currency=");
        return outline.E(sbU, this.currency, ")");
    }
}
