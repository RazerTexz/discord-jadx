package com.discord.utilities.birthday;

import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import java.util.Calendar;
import kotlin.Metadata;

/* compiled from: BirthdayHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/birthday/BirthdayHelper;", "", "", "years", "", "subtractYearsFromToday", "(I)J", "defaultInputAge", "()J", "getMaxDateOfBirth", "dateOfBirth", "getAge", "(J)I", "USER_MIN_AGE_NSFW", "I", "USER_DEFAULT_AGE", "", "DATE_OF_BIRTH_KEY", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BirthdayHelper {
    public static final String DATE_OF_BIRTH_KEY = "date_of_birth";
    public static final BirthdayHelper INSTANCE = new BirthdayHelper();
    public static final int USER_DEFAULT_AGE = 10;
    public static final int USER_MIN_AGE_NSFW = 18;

    private BirthdayHelper() {
    }

    public final long defaultInputAge() {
        return subtractYearsFromToday(10);
    }

    public final int getAge(long dateOfBirth) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "nowCalendar");
        calendar.setTimeInMillis(jCurrentTimeMillis);
        Intrinsics3.checkNotNullExpressionValue(calendar2, "dobCalendar");
        calendar2.setTimeInMillis(dateOfBirth);
        return (calendar2.get(2) > calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) > calendar.get(5))) ? (calendar.get(1) - calendar2.get(1)) - 1 : calendar.get(1) - calendar2.get(1);
    }

    public final long getMaxDateOfBirth() {
        return subtractYearsFromToday(3);
    }

    public final long subtractYearsFromToday(int years) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "calendar");
        calendar.setTimeInMillis(jCurrentTimeMillis);
        calendar.set(1, calendar.get(1) - years);
        return calendar.getTimeInMillis();
    }
}
