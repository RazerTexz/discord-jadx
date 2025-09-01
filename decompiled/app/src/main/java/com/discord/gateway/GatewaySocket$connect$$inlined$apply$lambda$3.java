package com.discord.gateway;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: GatewaySocket.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/io/InputStreamReader;", "reader", "", "compressedByteSize", "", "invoke", "(Ljava/io/InputStreamReader;I)V", "com/discord/gateway/GatewaySocket$connect$5$3", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GatewaySocket$connect$$inlined$apply$lambda$3 extends Lambda implements Function2<InputStreamReader, Integer, Unit> {
    public final /* synthetic */ String $gatewayUrl$inlined;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$connect$$inlined$apply$lambda$3(GatewaySocket gatewaySocket, String str) {
        super(2);
        this.this$0 = gatewaySocket;
        this.$gatewayUrl$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(InputStreamReader inputStreamReader, Integer num) {
        invoke(inputStreamReader, num.intValue());
        return Unit.a;
    }

    public final void invoke(InputStreamReader inputStreamReader, int i) {
        Intrinsics3.checkNotNullParameter(inputStreamReader, "reader");
        GatewaySocket.access$handleWebSocketMessage(this.this$0, inputStreamReader, i);
    }
}
