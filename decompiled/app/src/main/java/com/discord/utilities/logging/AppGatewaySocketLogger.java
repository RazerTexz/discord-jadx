package com.discord.utilities.logging;

import com.discord.gateway.GatewaySocketLogger;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppGatewaySocketLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/logging/AppGatewaySocketLogger;", "Lcom/discord/gateway/GatewaySocketLogger;", "", "rawMessage", "", "logInboundMessage", "(Ljava/lang/String;)V", "logOutboundMessage", "", "throwable", "logMessageInflateFailed", "(Ljava/lang/Throwable;)V", "Lcom/discord/gateway/GatewaySocketLogger$LogLevel;", "logLevel", "Lcom/discord/gateway/GatewaySocketLogger$LogLevel;", "getLogLevel", "()Lcom/discord/gateway/GatewaySocketLogger$LogLevel;", "<init>", "()V", "Companion", "flipper_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AppGatewaySocketLogger implements GatewaySocketLogger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AppGatewaySocketLogger INSTANCE = new AppGatewaySocketLogger();
    private final GatewaySocketLogger.LogLevel logLevel = GatewaySocketLogger.LogLevel.NONE;

    /* compiled from: AppGatewaySocketLogger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/logging/AppGatewaySocketLogger$Companion;", "", "Lcom/discord/utilities/logging/AppGatewaySocketLogger;", "INSTANCE", "Lcom/discord/utilities/logging/AppGatewaySocketLogger;", "getINSTANCE", "()Lcom/discord/utilities/logging/AppGatewaySocketLogger;", "<init>", "()V", "flipper_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final AppGatewaySocketLogger getINSTANCE() {
            return AppGatewaySocketLogger.access$getINSTANCE$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ AppGatewaySocketLogger access$getINSTANCE$cp() {
        return INSTANCE;
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public GatewaySocketLogger.LogLevel getLogLevel() {
        return this.logLevel;
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logInboundMessage(String rawMessage) {
        Intrinsics3.checkNotNullParameter(rawMessage, "rawMessage");
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logMessageInflateFailed(Throwable throwable) {
        Intrinsics3.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.discord.gateway.GatewaySocketLogger
    public void logOutboundMessage(String rawMessage) {
        Intrinsics3.checkNotNullParameter(rawMessage, "rawMessage");
    }
}
