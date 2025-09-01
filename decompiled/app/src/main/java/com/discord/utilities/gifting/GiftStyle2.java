package com.discord.utilities.gifting;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GiftStyle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/utilities/gifting/GiftStyle;", "invoke", "()[Lcom/discord/utilities/gifting/GiftStyle;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.gifting.GiftStyle$Companion$values$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GiftStyle2 extends Lambda implements Function0<GiftStyle[]> {
    public static final GiftStyle2 INSTANCE = new GiftStyle2();

    public GiftStyle2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GiftStyle[] invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GiftStyle[] invoke2() {
        return GiftStyle.values();
    }
}
