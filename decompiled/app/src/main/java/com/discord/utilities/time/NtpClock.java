package com.discord.utilities.time;

import com.lyft.kronos.Clock8;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: NtpClock.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/utilities/time/NtpClock;", "Lcom/discord/utilities/time/Clock;", "", "currentTimeMillis", "()J", "Lcom/lyft/kronos/KronosClock;", "kronosClock", "Lcom/lyft/kronos/KronosClock;", "getKronosClock", "()Lcom/lyft/kronos/KronosClock;", "<init>", "(Lcom/lyft/kronos/KronosClock;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NtpClock implements Clock {
    private final Clock8 kronosClock;

    public NtpClock(Clock8 clock8) {
        Intrinsics3.checkNotNullParameter(clock8, "kronosClock");
        this.kronosClock = clock8;
    }

    @Override // com.discord.utilities.time.Clock
    public long currentTimeMillis() {
        return this.kronosClock.a();
    }

    public final Clock8 getKronosClock() {
        return this.kronosClock;
    }
}
