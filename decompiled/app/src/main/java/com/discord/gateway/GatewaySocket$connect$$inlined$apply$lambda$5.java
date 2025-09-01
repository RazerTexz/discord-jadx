package com.discord.gateway;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GatewaySocket.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/websocket/WebSocket$Error;", "it", "", "invoke", "(Lcom/discord/utilities/websocket/WebSocket$Error;)V", "com/discord/gateway/GatewaySocket$connect$5$5", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GatewaySocket$connect$$inlined$apply$lambda$5 extends Lambda implements Function1<WebSocket.Error, Unit> {
    public final /* synthetic */ String $gatewayUrl$inlined;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$connect$$inlined$apply$lambda$5(GatewaySocket gatewaySocket, String str) {
        super(1);
        this.this$0 = gatewaySocket;
        this.$gatewayUrl$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WebSocket.Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WebSocket.Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        GatewaySocket.access$handleWebSocketError(this.this$0);
    }
}
