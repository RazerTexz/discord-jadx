package com.discord.widgets.guildscheduledevent;

import b.d.b.a.outline;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventPickerDateTime.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;", "Ljava/io/Serializable;", "", "component1", "()I", "component2", "component3", "hourOfDay", "minute", "second", "copy", "(III)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getSecond", "getHourOfDay", "getMinute", "<init>", "(III)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerTime, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventPickerDateTime3 implements Serializable {
    private final int hourOfDay;
    private final int minute;
    private final int second;

    public GuildScheduledEventPickerDateTime3(int i, int i2, int i3) {
        this.hourOfDay = i;
        this.minute = i2;
        this.second = i3;
    }

    public static /* synthetic */ GuildScheduledEventPickerDateTime3 copy$default(GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = guildScheduledEventPickerDateTime3.hourOfDay;
        }
        if ((i4 & 2) != 0) {
            i2 = guildScheduledEventPickerDateTime3.minute;
        }
        if ((i4 & 4) != 0) {
            i3 = guildScheduledEventPickerDateTime3.second;
        }
        return guildScheduledEventPickerDateTime3.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHourOfDay() {
        return this.hourOfDay;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMinute() {
        return this.minute;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSecond() {
        return this.second;
    }

    public final GuildScheduledEventPickerDateTime3 copy(int hourOfDay, int minute, int second) {
        return new GuildScheduledEventPickerDateTime3(hourOfDay, minute, second);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventPickerDateTime3)) {
            return false;
        }
        GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3 = (GuildScheduledEventPickerDateTime3) other;
        return this.hourOfDay == guildScheduledEventPickerDateTime3.hourOfDay && this.minute == guildScheduledEventPickerDateTime3.minute && this.second == guildScheduledEventPickerDateTime3.second;
    }

    public final int getHourOfDay() {
        return this.hourOfDay;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getSecond() {
        return this.second;
    }

    public int hashCode() {
        return (((this.hourOfDay * 31) + this.minute) * 31) + this.second;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventPickerTime(hourOfDay=");
        sbU.append(this.hourOfDay);
        sbU.append(", minute=");
        sbU.append(this.minute);
        sbU.append(", second=");
        return outline.B(sbU, this.second, ")");
    }
}
