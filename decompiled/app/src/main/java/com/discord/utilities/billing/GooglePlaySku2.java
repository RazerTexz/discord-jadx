package com.discord.utilities.billing;

import com.discord.utilities.billing.GooglePlaySku;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: GooglePlaySku.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/billing/GooglePlaySku;", "Lcom/discord/utilities/billing/GooglePlaySku$Section;", "getSection", "(Lcom/discord/utilities/billing/GooglePlaySku;)Lcom/discord/utilities/billing/GooglePlaySku$Section;", "", "isBundledSku", "(Lcom/discord/utilities/billing/GooglePlaySku;)Z", "isTier1", "isTier2", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.billing.GooglePlaySkuKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GooglePlaySku2 {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.billing.GooglePlaySkuKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GooglePlaySku.Type.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_2.ordinal()] = 1;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_1.ordinal()] = 2;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD.ordinal()] = 3;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD.ordinal()] = 4;
            iArr[GooglePlaySku.Type.PREMIUM_GUILD.ordinal()] = 5;
        }
    }

    public static final GooglePlaySku.Section getSection(GooglePlaySku googlePlaySku) {
        Intrinsics3.checkNotNullParameter(googlePlaySku, "$this$getSection");
        int iOrdinal = googlePlaySku.getType().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return GooglePlaySku.Section.PREMIUM;
        }
        if (iOrdinal == 2 || iOrdinal == 3) {
            return GooglePlaySku.Section.PREMIUM_AND_PREMIUM_GUILD;
        }
        if (iOrdinal == 4) {
            return GooglePlaySku.Section.PREMIUM_GUILD;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isBundledSku(GooglePlaySku googlePlaySku) {
        Intrinsics3.checkNotNullParameter(googlePlaySku, "$this$isBundledSku");
        return googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD || googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
    }

    public static final boolean isTier1(GooglePlaySku googlePlaySku) {
        Intrinsics3.checkNotNullParameter(googlePlaySku, "$this$isTier1");
        return googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1 || googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
    }

    public static final boolean isTier2(GooglePlaySku googlePlaySku) {
        Intrinsics3.checkNotNullParameter(googlePlaySku, "$this$isTier2");
        return googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_2 || googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD;
    }
}
