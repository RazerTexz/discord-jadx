package com.discord.stores;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreGatewayConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "", "properties", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGatewayConnection$buildGatewaySocket$socket$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGatewayConnection5 extends Lambda implements Function1<Map<String, ? extends Object>, Unit> {
    public static final StoreGatewayConnection5 INSTANCE = new StoreGatewayConnection5();

    public StoreGatewayConnection5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Object> map) {
        invoke2(map);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, ? extends Object> map) {
        Intrinsics3.checkNotNullParameter(map, "properties");
        AnalyticsTracker.readyPayloadReceived(map);
    }
}
