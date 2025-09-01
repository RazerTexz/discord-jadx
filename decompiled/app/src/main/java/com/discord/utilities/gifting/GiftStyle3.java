package com.discord.utilities.gifting;

import com.discord.models.domain.ModelGift;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GiftStyle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/models/domain/ModelGift;", "Lcom/discord/utilities/gifting/GiftStyle;", "getCustomStyle", "(Lcom/discord/models/domain/ModelGift;)Lcom/discord/utilities/gifting/GiftStyle;", "", "hasCustomStyle", "(Lcom/discord/models/domain/ModelGift;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.gifting.GiftStyleKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GiftStyle3 {
    public static final GiftStyle getCustomStyle(ModelGift modelGift) {
        Intrinsics3.checkNotNullParameter(modelGift, "$this$getCustomStyle");
        return GiftStyle.INSTANCE.from(modelGift);
    }

    public static final boolean hasCustomStyle(ModelGift modelGift) {
        Intrinsics3.checkNotNullParameter(modelGift, "$this$hasCustomStyle");
        return getCustomStyle(modelGift) != null;
    }
}
