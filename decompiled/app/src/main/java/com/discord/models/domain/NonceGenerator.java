package com.discord.models.domain;

import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NonceGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/discord/models/domain/NonceGenerator;", "", "", "nonce", "()J", "<init>", "()V", "Companion", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class NonceGenerator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static long previousNonce;

    /* compiled from: NonceGenerator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/models/domain/NonceGenerator$Companion;", "", "Lcom/discord/utilities/time/Clock;", "clock", "", "computeNonce", "(Lcom/discord/utilities/time/Clock;)J", "previousNonce", "J", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ long computeNonce$default(Companion companion, Clock clock, int i, Object obj) {
            if ((i & 1) != 0) {
                clock = ClockFactory.get();
            }
            return companion.computeNonce(clock);
        }

        public final synchronized long computeNonce(Clock clock) {
            long jCurrentTimeMillis;
            Intrinsics3.checkNotNullParameter(clock, "clock");
            jCurrentTimeMillis = ((clock.currentTimeMillis() + 1471228928) - SnowflakeUtils.DISCORD_EPOCH) << 22;
            if (jCurrentTimeMillis <= NonceGenerator.access$getPreviousNonce$cp()) {
                jCurrentTimeMillis = NonceGenerator.access$getPreviousNonce$cp() + 1;
            }
            NonceGenerator.access$setPreviousNonce$cp(jCurrentTimeMillis);
            return jCurrentTimeMillis;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ long access$getPreviousNonce$cp() {
        return previousNonce;
    }

    public static final /* synthetic */ void access$setPreviousNonce$cp(long j) {
        previousNonce = j;
    }

    public static final synchronized long computeNonce(Clock clock) {
        return INSTANCE.computeNonce(clock);
    }

    public final long nonce() {
        return Companion.computeNonce$default(INSTANCE, null, 1, null);
    }
}
