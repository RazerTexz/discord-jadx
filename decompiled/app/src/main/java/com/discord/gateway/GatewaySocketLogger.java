package com.discord.gateway;

import kotlin.Metadata;

/* compiled from: GatewaySocketLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/gateway/GatewaySocketLogger;", "", "", "rawMessage", "", "logInboundMessage", "(Ljava/lang/String;)V", "logOutboundMessage", "", "throwable", "logMessageInflateFailed", "(Ljava/lang/Throwable;)V", "Lcom/discord/gateway/GatewaySocketLogger$LogLevel;", "getLogLevel", "()Lcom/discord/gateway/GatewaySocketLogger$LogLevel;", "logLevel", "LogLevel", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public interface GatewaySocketLogger {

    /* compiled from: GatewaySocketLogger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/gateway/GatewaySocketLogger$LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "VERBOSE", "gateway_release"}, k = 1, mv = {1, 4, 2})
    public enum LogLevel {
        NONE,
        VERBOSE
    }

    LogLevel getLogLevel();

    void logInboundMessage(String rawMessage);

    void logMessageInflateFailed(Throwable throwable);

    void logOutboundMessage(String rawMessage);
}
