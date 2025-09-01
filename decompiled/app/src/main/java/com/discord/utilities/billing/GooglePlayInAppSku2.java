package com.discord.utilities.billing;

import com.discord.models.domain.ModelSku4;
import d0.t.Collections2;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GooglePlayInAppSku.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\"\u0019\u0010\u0001\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u0019\u0010\u0007\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\u0004\"\u0019\u0010\t\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0004\"\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/billing/GooglePlayInAppSku;", "premiumTier1Year", "Lcom/discord/utilities/billing/GooglePlayInAppSku;", "getPremiumTier1Year", "()Lcom/discord/utilities/billing/GooglePlayInAppSku;", "premiumTier2Year", "getPremiumTier2Year", "premiumTier1Month", "getPremiumTier1Month", "premiumTier2Month", "getPremiumTier2Month", "", "premiumGifts", "Ljava/util/List;", "getPremiumGifts", "()Ljava/util/List;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.billing.GooglePlayInAppSkuKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GooglePlayInAppSku2 {
    private static final List<GooglePlayInAppSku> premiumGifts;
    private static final GooglePlayInAppSku premiumTier1Month;
    private static final GooglePlayInAppSku premiumTier1Year;
    private static final GooglePlayInAppSku premiumTier2Month;
    private static final GooglePlayInAppSku premiumTier2Year;

    static {
        GooglePlayInAppSku4 googlePlayInAppSku4 = GooglePlayInAppSku4.PREMIUM_GIFT;
        Long lValueOf = Long.valueOf(ModelSku4.PREMIUM_TIER_1_SKU_ID);
        GooglePlayInAppSku googlePlayInAppSku = new GooglePlayInAppSku("premium_month_tier_1", googlePlayInAppSku4, null, lValueOf, 4, null);
        premiumTier1Month = googlePlayInAppSku;
        GooglePlayInAppSku googlePlayInAppSku2 = new GooglePlayInAppSku("premium_year_tier_1", googlePlayInAppSku4, null, lValueOf, 4, null);
        premiumTier1Year = googlePlayInAppSku2;
        Long lValueOf2 = Long.valueOf(ModelSku4.PREMIUM_TIER_2_SKU_ID);
        GooglePlayInAppSku googlePlayInAppSku3 = new GooglePlayInAppSku("premium_month_tier_2", googlePlayInAppSku4, null, lValueOf2, 4, null);
        premiumTier2Month = googlePlayInAppSku3;
        GooglePlayInAppSku googlePlayInAppSku5 = new GooglePlayInAppSku("premium_year_tier_2", googlePlayInAppSku4, null, lValueOf2, 4, null);
        premiumTier2Year = googlePlayInAppSku5;
        premiumGifts = Collections2.listOf((Object[]) new GooglePlayInAppSku[]{googlePlayInAppSku, googlePlayInAppSku2, googlePlayInAppSku3, googlePlayInAppSku5});
    }

    public static final List<GooglePlayInAppSku> getPremiumGifts() {
        return premiumGifts;
    }

    public static final GooglePlayInAppSku getPremiumTier1Month() {
        return premiumTier1Month;
    }

    public static final GooglePlayInAppSku getPremiumTier1Year() {
        return premiumTier1Year;
    }

    public static final GooglePlayInAppSku getPremiumTier2Month() {
        return premiumTier2Month;
    }

    public static final GooglePlayInAppSku getPremiumTier2Year() {
        return premiumTier2Year;
    }
}
