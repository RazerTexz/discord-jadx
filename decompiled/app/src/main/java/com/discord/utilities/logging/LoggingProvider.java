package com.discord.utilities.logging;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: LoggingProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/utilities/logging/LoggingProvider;", "", "Lcom/discord/utilities/logging/Logger;", "logger", "", "init", "(Lcom/discord/utilities/logging/Logger;)V", "get", "()Lcom/discord/utilities/logging/Logger;", "Lcom/discord/utilities/logging/Logger;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class LoggingProvider {
    public static final LoggingProvider INSTANCE = new LoggingProvider();
    private static Logger logger;

    private LoggingProvider() {
    }

    public final Logger get() {
        Logger logger2 = logger;
        if (logger2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("logger");
        }
        return logger2;
    }

    public final void init(Logger logger2) {
        Intrinsics3.checkNotNullParameter(logger2, "logger");
        logger = logger2;
    }
}
