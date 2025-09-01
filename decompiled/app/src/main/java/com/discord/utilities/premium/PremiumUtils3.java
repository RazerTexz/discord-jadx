package com.discord.utilities.premium;

import com.discord.api.premium.PremiumTier;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: PremiumUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/discord/api/premium/PremiumTier;", "", "grantsAccessToPremiumStickers", "(Lcom/discord/api/premium/PremiumTier;)Z", "grantsAccessToCustomTagAndAnimatedAvatarFeatures", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.premium.PremiumUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class PremiumUtils3 {
    public static final boolean grantsAccessToCustomTagAndAnimatedAvatarFeatures(PremiumTier premiumTier) {
        Intrinsics3.checkNotNullParameter(premiumTier, "$this$grantsAccessToCustomTagAndAnimatedAvatarFeatures");
        return premiumTier == PremiumTier.TIER_1 || premiumTier == PremiumTier.TIER_2;
    }

    public static final boolean grantsAccessToPremiumStickers(PremiumTier premiumTier) {
        Intrinsics3.checkNotNullParameter(premiumTier, "$this$grantsAccessToPremiumStickers");
        return premiumTier == PremiumTier.TIER_2 || premiumTier == PremiumTier.TIER_0;
    }
}
