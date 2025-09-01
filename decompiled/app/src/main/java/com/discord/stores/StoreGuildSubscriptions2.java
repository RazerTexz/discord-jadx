package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreGuildSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "chunkSize", "invoke", "(II)I", "roundDownToNearestChunk"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuildSubscriptions$RangeComputer$computeRanges$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuildSubscriptions2 extends Lambda implements Function2<Integer, Integer, Integer> {
    public static final StoreGuildSubscriptions2 INSTANCE = new StoreGuildSubscriptions2();

    public StoreGuildSubscriptions2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, Integer num2) {
        return Integer.valueOf(invoke(num.intValue(), num2.intValue()));
    }

    public final int invoke(int i, int i2) {
        return (i / i2) * i2;
    }
}
