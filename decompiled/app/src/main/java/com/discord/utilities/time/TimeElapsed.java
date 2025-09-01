package com.discord.utilities.time;

import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TimeElapsed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/time/TimeElapsed;", "", "", "seconds$delegate", "Lkotlin/Lazy;", "getSeconds", "()F", "seconds", "", "milliseconds$delegate", "getMilliseconds", "()J", "milliseconds", "startTime", "J", "Lcom/discord/utilities/time/Clock;", "clock", "<init>", "(Lcom/discord/utilities/time/Clock;J)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TimeElapsed {

    /* renamed from: milliseconds$delegate, reason: from kotlin metadata */
    private final Lazy milliseconds;

    /* renamed from: seconds$delegate, reason: from kotlin metadata */
    private final Lazy seconds;
    private final long startTime;

    public TimeElapsed(Clock clock, long j) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.startTime = j;
        this.milliseconds = LazyJVM.lazy(new TimeElapsed2(this, clock));
        this.seconds = LazyJVM.lazy(new TimeElapsed3(this));
    }

    public static final /* synthetic */ long access$getStartTime$p(TimeElapsed timeElapsed) {
        return timeElapsed.startTime;
    }

    public final long getMilliseconds() {
        return ((Number) this.milliseconds.getValue()).longValue();
    }

    public final float getSeconds() {
        return ((Number) this.seconds.getValue()).floatValue();
    }

    public /* synthetic */ TimeElapsed(Clock clock, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clock, (i & 2) != 0 ? clock.currentTimeMillis() : j);
    }
}
