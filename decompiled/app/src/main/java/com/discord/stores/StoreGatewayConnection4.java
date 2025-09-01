package com.discord.stores;

import com.discord.gateway.GatewaySocket;
import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreGatewayConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/gateway/GatewaySocket$IdentifyData;", "invoke", "()Lcom/discord/gateway/GatewaySocket$IdentifyData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGatewayConnection$buildGatewaySocket$socket$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreGatewayConnection4 extends FunctionReferenceImpl implements Function0<GatewaySocket.IdentifyData> {
    public StoreGatewayConnection4(StoreGatewayConnection storeGatewayConnection) {
        super(0, storeGatewayConnection, StoreGatewayConnection.class, "getIdentifyData", "getIdentifyData()Lcom/discord/gateway/GatewaySocket$IdentifyData;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GatewaySocket.IdentifyData invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GatewaySocket.IdentifyData invoke() {
        return StoreGatewayConnection.access$getIdentifyData((StoreGatewayConnection) this.receiver);
    }
}
