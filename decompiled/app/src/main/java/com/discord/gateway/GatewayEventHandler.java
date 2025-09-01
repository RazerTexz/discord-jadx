package com.discord.gateway;

import kotlin.Metadata;

/* compiled from: GatewayEventHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0001H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/discord/gateway/GatewayEventHandler;", "", "", "authenticationFailed", "", "handleDisconnect", "(Z)V", "", "type", "data", "handleDispatch", "(Ljava/lang/String;Ljava/lang/Object;)V", "connected", "handleConnected", "connectionReady", "handleConnectionReady", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public interface GatewayEventHandler {
    void handleConnected(boolean connected);

    void handleConnectionReady(boolean connectionReady);

    void handleDisconnect(boolean authenticationFailed);

    void handleDispatch(String type, Object data);
}
