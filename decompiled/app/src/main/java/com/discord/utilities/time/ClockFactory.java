package com.discord.utilities.time;

import android.app.Application;
import b.m.a.AndroidClockFactory;
import b.m.a.g.KronosClockImpl;
import com.lyft.kronos.Clock8;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ClockFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/time/ClockFactory;", "", "Lcom/discord/utilities/time/Clock;", "get", "()Lcom/discord/utilities/time/Clock;", "Landroid/app/Application;", "application", "", "init", "(Landroid/app/Application;)V", "Lcom/discord/utilities/time/NtpClock;", "ntpClock", "Lcom/discord/utilities/time/NtpClock;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ClockFactory {
    public static final ClockFactory INSTANCE = new ClockFactory();
    private static NtpClock ntpClock;

    private ClockFactory() {
    }

    public static final Clock get() {
        NtpClock ntpClock2 = ntpClock;
        if (ntpClock2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("ntpClock");
        }
        return ntpClock2;
    }

    public final void init(Application application) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Clock8 clock8A = AndroidClockFactory.a(application, null, null, 0L, 0L, 0L, 62);
        ((KronosClockImpl) clock8A).a.b();
        ntpClock = new NtpClock(clock8A);
    }
}
