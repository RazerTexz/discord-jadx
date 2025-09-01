package com.discord.utilities.time;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: TimeSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b%\u0010&J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0014\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/discord/utilities/time/TimeSpan;", "", "", "toDays", "()J", "toHours", "toMinutes", "toSeconds", "toMicros", "toMillis", "toNanos", "b", "plus", "(Lcom/discord/utilities/time/TimeSpan;)Lcom/discord/utilities/time/TimeSpan;", "minus", "component1", "Ljava/util/concurrent/TimeUnit;", "component2", "()Ljava/util/concurrent/TimeUnit;", "amount", "unit", "copy", "(JLjava/util/concurrent/TimeUnit;)Lcom/discord/utilities/time/TimeSpan;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/concurrent/TimeUnit;", "getUnit", "J", "getAmount", "<init>", "(JLjava/util/concurrent/TimeUnit;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class TimeSpan {
    private final long amount;
    private final TimeUnit unit;

    public TimeSpan(long j, TimeUnit timeUnit) {
        Intrinsics3.checkNotNullParameter(timeUnit, "unit");
        this.amount = j;
        this.unit = timeUnit;
    }

    public static /* synthetic */ TimeSpan copy$default(TimeSpan timeSpan, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            j = timeSpan.amount;
        }
        if ((i & 2) != 0) {
            timeUnit = timeSpan.unit;
        }
        return timeSpan.copy(j, timeUnit);
    }

    /* renamed from: component1, reason: from getter */
    public final long getAmount() {
        return this.amount;
    }

    /* renamed from: component2, reason: from getter */
    public final TimeUnit getUnit() {
        return this.unit;
    }

    public final TimeSpan copy(long amount, TimeUnit unit) {
        Intrinsics3.checkNotNullParameter(unit, "unit");
        return new TimeSpan(amount, unit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeSpan)) {
            return false;
        }
        TimeSpan timeSpan = (TimeSpan) other;
        return this.amount == timeSpan.amount && Intrinsics3.areEqual(this.unit, timeSpan.unit);
    }

    public final long getAmount() {
        return this.amount;
    }

    public final TimeUnit getUnit() {
        return this.unit;
    }

    public int hashCode() {
        int iA = b.a(this.amount) * 31;
        TimeUnit timeUnit = this.unit;
        return iA + (timeUnit != null ? timeUnit.hashCode() : 0);
    }

    public final TimeSpan minus(TimeSpan b2) {
        Intrinsics3.checkNotNullParameter(b2, "b");
        return new TimeSpan(toNanos() - b2.toNanos(), TimeUnit.NANOSECONDS);
    }

    public final TimeSpan plus(TimeSpan b2) {
        Intrinsics3.checkNotNullParameter(b2, "b");
        return new TimeSpan(b2.toNanos() + toNanos(), TimeUnit.NANOSECONDS);
    }

    public final long toDays() {
        return this.unit.toDays(this.amount);
    }

    public final long toHours() {
        return this.unit.toHours(this.amount);
    }

    public final long toMicros() {
        return this.unit.toMicros(this.amount);
    }

    public final long toMillis() {
        return this.unit.toMillis(this.amount);
    }

    public final long toMinutes() {
        return this.unit.toMinutes(this.amount);
    }

    public final long toNanos() {
        return this.unit.toNanos(this.amount);
    }

    public final long toSeconds() {
        return this.unit.toSeconds(this.amount);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TimeSpan(amount=");
        sbU.append(this.amount);
        sbU.append(", unit=");
        sbU.append(this.unit);
        sbU.append(")");
        return sbU.toString();
    }
}
