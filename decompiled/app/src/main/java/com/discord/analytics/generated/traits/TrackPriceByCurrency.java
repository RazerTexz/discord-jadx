package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackPriceByCurrency.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010R\u001b\u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010R\u001b\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0010R\u001b\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010R\u001b\u0010'\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010R\u001b\u0010)\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010R\u001b\u0010+\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u0010R\u001b\u0010-\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010\u0010R\u001b\u0010/\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u0010R\u001b\u00101\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010R\u001b\u00103\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b4\u0010\u0010R\u001b\u00105\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u000e\u001a\u0004\b6\u0010\u0010R\u001b\u00107\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u000e\u001a\u0004\b8\u0010\u0010R\u001b\u00109\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0010¨\u0006;"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackPriceByCurrency;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "regularPriceUsd", "Ljava/lang/Long;", "getRegularPriceUsd", "()Ljava/lang/Long;", "priceEur", "getPriceEur", "priceCad", "getPriceCad", "regularPriceBrl", "getRegularPriceBrl", "pricePln", "getPricePln", "regularPriceGbp", "getRegularPriceGbp", "regularPriceRub", "getRegularPriceRub", "regularPriceTry", "getRegularPriceTry", "regularPriceJpy", "getRegularPriceJpy", "regularPriceEur", "getRegularPriceEur", "regularPriceCad", "getRegularPriceCad", "priceAud", "getPriceAud", "priceNok", "getPriceNok", "priceTry", "getPriceTry", "priceRub", "getPriceRub", "priceUsd", "getPriceUsd", "priceBrl", "getPriceBrl", "regularPriceNok", "getRegularPriceNok", "regularPricePln", "getRegularPricePln", "priceJpy", "getPriceJpy", "priceGbp", "getPriceGbp", "regularPriceAud", "getRegularPriceAud", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackPriceByCurrency {
    private final Long priceUsd = null;
    private final Long priceCad = null;
    private final Long priceAud = null;
    private final Long priceEur = null;
    private final Long priceJpy = null;
    private final Long priceRub = null;
    private final Long priceGbp = null;
    private final Long priceNok = null;
    private final Long priceBrl = null;
    private final Long pricePln = null;
    private final Long priceTry = null;
    private final Long regularPriceUsd = null;
    private final Long regularPriceCad = null;
    private final Long regularPriceAud = null;
    private final Long regularPriceEur = null;
    private final Long regularPriceJpy = null;
    private final Long regularPriceRub = null;
    private final Long regularPriceGbp = null;
    private final Long regularPriceNok = null;
    private final Long regularPriceBrl = null;
    private final Long regularPricePln = null;
    private final Long regularPriceTry = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPriceByCurrency)) {
            return false;
        }
        TrackPriceByCurrency trackPriceByCurrency = (TrackPriceByCurrency) other;
        return Intrinsics3.areEqual(this.priceUsd, trackPriceByCurrency.priceUsd) && Intrinsics3.areEqual(this.priceCad, trackPriceByCurrency.priceCad) && Intrinsics3.areEqual(this.priceAud, trackPriceByCurrency.priceAud) && Intrinsics3.areEqual(this.priceEur, trackPriceByCurrency.priceEur) && Intrinsics3.areEqual(this.priceJpy, trackPriceByCurrency.priceJpy) && Intrinsics3.areEqual(this.priceRub, trackPriceByCurrency.priceRub) && Intrinsics3.areEqual(this.priceGbp, trackPriceByCurrency.priceGbp) && Intrinsics3.areEqual(this.priceNok, trackPriceByCurrency.priceNok) && Intrinsics3.areEqual(this.priceBrl, trackPriceByCurrency.priceBrl) && Intrinsics3.areEqual(this.pricePln, trackPriceByCurrency.pricePln) && Intrinsics3.areEqual(this.priceTry, trackPriceByCurrency.priceTry) && Intrinsics3.areEqual(this.regularPriceUsd, trackPriceByCurrency.regularPriceUsd) && Intrinsics3.areEqual(this.regularPriceCad, trackPriceByCurrency.regularPriceCad) && Intrinsics3.areEqual(this.regularPriceAud, trackPriceByCurrency.regularPriceAud) && Intrinsics3.areEqual(this.regularPriceEur, trackPriceByCurrency.regularPriceEur) && Intrinsics3.areEqual(this.regularPriceJpy, trackPriceByCurrency.regularPriceJpy) && Intrinsics3.areEqual(this.regularPriceRub, trackPriceByCurrency.regularPriceRub) && Intrinsics3.areEqual(this.regularPriceGbp, trackPriceByCurrency.regularPriceGbp) && Intrinsics3.areEqual(this.regularPriceNok, trackPriceByCurrency.regularPriceNok) && Intrinsics3.areEqual(this.regularPriceBrl, trackPriceByCurrency.regularPriceBrl) && Intrinsics3.areEqual(this.regularPricePln, trackPriceByCurrency.regularPricePln) && Intrinsics3.areEqual(this.regularPriceTry, trackPriceByCurrency.regularPriceTry);
    }

    public int hashCode() {
        Long l = this.priceUsd;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.priceCad;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.priceAud;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.priceEur;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.priceJpy;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.priceRub;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.priceGbp;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.priceNok;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.priceBrl;
        int iHashCode9 = (iHashCode8 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.pricePln;
        int iHashCode10 = (iHashCode9 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.priceTry;
        int iHashCode11 = (iHashCode10 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.regularPriceUsd;
        int iHashCode12 = (iHashCode11 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.regularPriceCad;
        int iHashCode13 = (iHashCode12 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.regularPriceAud;
        int iHashCode14 = (iHashCode13 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.regularPriceEur;
        int iHashCode15 = (iHashCode14 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.regularPriceJpy;
        int iHashCode16 = (iHashCode15 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.regularPriceRub;
        int iHashCode17 = (iHashCode16 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.regularPriceGbp;
        int iHashCode18 = (iHashCode17 + (l18 != null ? l18.hashCode() : 0)) * 31;
        Long l19 = this.regularPriceNok;
        int iHashCode19 = (iHashCode18 + (l19 != null ? l19.hashCode() : 0)) * 31;
        Long l20 = this.regularPriceBrl;
        int iHashCode20 = (iHashCode19 + (l20 != null ? l20.hashCode() : 0)) * 31;
        Long l21 = this.regularPricePln;
        int iHashCode21 = (iHashCode20 + (l21 != null ? l21.hashCode() : 0)) * 31;
        Long l22 = this.regularPriceTry;
        return iHashCode21 + (l22 != null ? l22.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPriceByCurrency(priceUsd=");
        sbU.append(this.priceUsd);
        sbU.append(", priceCad=");
        sbU.append(this.priceCad);
        sbU.append(", priceAud=");
        sbU.append(this.priceAud);
        sbU.append(", priceEur=");
        sbU.append(this.priceEur);
        sbU.append(", priceJpy=");
        sbU.append(this.priceJpy);
        sbU.append(", priceRub=");
        sbU.append(this.priceRub);
        sbU.append(", priceGbp=");
        sbU.append(this.priceGbp);
        sbU.append(", priceNok=");
        sbU.append(this.priceNok);
        sbU.append(", priceBrl=");
        sbU.append(this.priceBrl);
        sbU.append(", pricePln=");
        sbU.append(this.pricePln);
        sbU.append(", priceTry=");
        sbU.append(this.priceTry);
        sbU.append(", regularPriceUsd=");
        sbU.append(this.regularPriceUsd);
        sbU.append(", regularPriceCad=");
        sbU.append(this.regularPriceCad);
        sbU.append(", regularPriceAud=");
        sbU.append(this.regularPriceAud);
        sbU.append(", regularPriceEur=");
        sbU.append(this.regularPriceEur);
        sbU.append(", regularPriceJpy=");
        sbU.append(this.regularPriceJpy);
        sbU.append(", regularPriceRub=");
        sbU.append(this.regularPriceRub);
        sbU.append(", regularPriceGbp=");
        sbU.append(this.regularPriceGbp);
        sbU.append(", regularPriceNok=");
        sbU.append(this.regularPriceNok);
        sbU.append(", regularPriceBrl=");
        sbU.append(this.regularPriceBrl);
        sbU.append(", regularPricePln=");
        sbU.append(this.regularPricePln);
        sbU.append(", regularPriceTry=");
        return outline.G(sbU, this.regularPriceTry, ")");
    }
}
