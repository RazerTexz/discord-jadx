package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreRtcRegion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreRtcRegion$handleConnectionOpen$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreRtcRegion3 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ StoreRtcRegion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRtcRegion3(StoreRtcRegion storeRtcRegion) {
        super(1);
        this.this$0 = storeRtcRegion;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        StoreRtcRegion.access$fetchRtcLatencyTestRegionsIps(this.this$0);
    }
}
