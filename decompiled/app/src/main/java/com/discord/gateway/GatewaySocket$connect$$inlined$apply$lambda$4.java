package com.discord.gateway;

import com.discord.utilities.websocket.RawMessageHandler;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GatewaySocket.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/discord/gateway/GatewaySocket$connect$5$4", "Lcom/discord/utilities/websocket/RawMessageHandler;", "", "rawMessage", "", "onRawMessage", "(Ljava/lang/String;)V", "", "throwable", "onRawMessageInflateFailed", "(Ljava/lang/Throwable;)V", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GatewaySocket$connect$$inlined$apply$lambda$4 implements RawMessageHandler {
    public final /* synthetic */ String $gatewayUrl$inlined;
    public final /* synthetic */ GatewaySocket this$0;

    public GatewaySocket$connect$$inlined$apply$lambda$4(GatewaySocket gatewaySocket, String str) {
        this.this$0 = gatewaySocket;
        this.$gatewayUrl$inlined = str;
    }

    @Override // com.discord.utilities.websocket.RawMessageHandler
    public void onRawMessage(String rawMessage) {
        Intrinsics3.checkNotNullParameter(rawMessage, "rawMessage");
        GatewaySocket.access$getGatewaySocketLogger$p(this.this$0).logInboundMessage(rawMessage);
    }

    @Override // com.discord.utilities.websocket.RawMessageHandler
    public void onRawMessageInflateFailed(Throwable throwable) {
        Intrinsics3.checkNotNullParameter(throwable, "throwable");
        GatewaySocket.access$getGatewaySocketLogger$p(this.this$0).logMessageInflateFailed(throwable);
    }
}
