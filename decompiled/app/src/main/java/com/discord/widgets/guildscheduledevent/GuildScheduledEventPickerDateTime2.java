package com.discord.widgets.guildscheduledevent;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventPickerDateTime.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J.\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;", "Ljava/io/Serializable;", "", "toMillis", "()J", "", "component1", "()I", "component2", "component3", "year", "month", "dayOfMonth", "copy", "(III)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getYear", "getMonth", "getDayOfMonth", "<init>", "(III)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDate, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventPickerDateTime2 implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int dayOfMonth;
    private final int month;
    private final int year;

    /* compiled from: GuildScheduledEventPickerDateTime.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate$Companion;", "", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;", "now", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDate$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final GuildScheduledEventPickerDateTime2 now() {
            Calendar calendar = Calendar.getInstance();
            return new GuildScheduledEventPickerDateTime2(calendar.get(1), calendar.get(2), calendar.get(5));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildScheduledEventPickerDateTime2(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.dayOfMonth = i3;
    }

    public static /* synthetic */ GuildScheduledEventPickerDateTime2 copy$default(GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = guildScheduledEventPickerDateTime2.year;
        }
        if ((i4 & 2) != 0) {
            i2 = guildScheduledEventPickerDateTime2.month;
        }
        if ((i4 & 4) != 0) {
            i3 = guildScheduledEventPickerDateTime2.dayOfMonth;
        }
        return guildScheduledEventPickerDateTime2.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final GuildScheduledEventPickerDateTime2 copy(int year, int month, int dayOfMonth) {
        return new GuildScheduledEventPickerDateTime2(year, month, dayOfMonth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventPickerDateTime2)) {
            return false;
        }
        GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2 = (GuildScheduledEventPickerDateTime2) other;
        return this.year == guildScheduledEventPickerDateTime2.year && this.month == guildScheduledEventPickerDateTime2.month && this.dayOfMonth == guildScheduledEventPickerDateTime2.dayOfMonth;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((this.year * 31) + this.month) * 31) + this.dayOfMonth;
    }

    public final long toMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.year, this.month, this.dayOfMonth, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…, dayOfMonth, 0, 0)\n    }");
        return calendar.getTimeInMillis();
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventPickerDate(year=");
        sbU.append(this.year);
        sbU.append(", month=");
        sbU.append(this.month);
        sbU.append(", dayOfMonth=");
        return outline.B(sbU, this.dayOfMonth, ")");
    }
}
