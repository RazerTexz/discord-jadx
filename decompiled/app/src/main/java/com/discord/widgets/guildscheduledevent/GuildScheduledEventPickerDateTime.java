package com.discord.widgets.guildscheduledevent;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: GuildScheduledEventPickerDateTime.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDateTime;", "", "Ljava/util/Calendar;", "Lkotlin/Pair;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;", "toGuildScheduledEventPickerDateTime", "(Ljava/util/Calendar;)Lkotlin/Pair;", "Lcom/discord/api/utcdatetime/UtcDateTime;", "utcDateTime", "fromUtcDateTime", "(Lcom/discord/api/utcdatetime/UtcDateTime;)Lkotlin/Pair;", "date", "time", "", "toMillis", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;)J", "", "toUtcDateString", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;)Ljava/lang/String;", "generateAppropriateStartDateTime", "()Lkotlin/Pair;", "startDate", "startTime", "generateDefaultEndDateTime", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;)Lkotlin/Pair;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventPickerDateTime {
    public static final GuildScheduledEventPickerDateTime INSTANCE = new GuildScheduledEventPickerDateTime();

    private GuildScheduledEventPickerDateTime() {
    }

    private final Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> toGuildScheduledEventPickerDateTime(Calendar calendar) {
        return new Tuples2<>(new GuildScheduledEventPickerDateTime2(calendar.get(1), calendar.get(2), calendar.get(5)), new GuildScheduledEventPickerDateTime3(calendar.get(11), calendar.get(12), calendar.get(13)));
    }

    public final Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> fromUtcDateTime(UtcDateTime utcDateTime) {
        Intrinsics3.checkNotNullParameter(utcDateTime, "utcDateTime");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(utcDateTime.getDateTimeMillis());
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…teTime.dateTimeMillis\n  }");
        return toGuildScheduledEventPickerDateTime(calendar);
    }

    public final Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> generateAppropriateStartDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, 2);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…endar.HOUR_OF_DAY, 2)\n  }");
        return toGuildScheduledEventPickerDateTime(calendar);
    }

    public final Tuples2<GuildScheduledEventPickerDateTime2, GuildScheduledEventPickerDateTime3> generateDefaultEndDateTime(GuildScheduledEventPickerDateTime2 startDate, GuildScheduledEventPickerDateTime3 startTime) {
        Intrinsics3.checkNotNullParameter(startDate, "startDate");
        Intrinsics3.checkNotNullParameter(startTime, "startTime");
        Calendar calendar = Calendar.getInstance();
        calendar.set(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), startTime.getHourOfDay(), startTime.getMinute(), startTime.getSecond());
        calendar.add(11, 1);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…r.HOUR_OF_DAY, 1)\n      }");
        return toGuildScheduledEventPickerDateTime(calendar);
    }

    public final long toMillis(GuildScheduledEventPickerDateTime2 date, GuildScheduledEventPickerDateTime3 time) {
        Intrinsics3.checkNotNullParameter(date, "date");
        Intrinsics3.checkNotNullParameter(time, "time");
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonth(), date.getDayOfMonth(), time.getHourOfDay(), time.getMinute(), time.getSecond());
        calendar.clear(14);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().a…ndar.MILLISECOND)\n      }");
        return calendar.getTimeInMillis();
    }

    public final String toUtcDateString(GuildScheduledEventPickerDateTime2 date, GuildScheduledEventPickerDateTime3 time) {
        Intrinsics3.checkNotNullParameter(date, "date");
        Intrinsics3.checkNotNullParameter(time, "time");
        String uTCDateTime$default = TimeUtils.toUTCDateTime$default(Long.valueOf(toMillis(date, time)), null, 2, null);
        Intrinsics3.checkNotNull(uTCDateTime$default);
        return uTCDateTime$default;
    }
}
