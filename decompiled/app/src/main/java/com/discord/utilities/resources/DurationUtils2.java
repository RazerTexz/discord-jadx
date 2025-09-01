package com.discord.utilities.resources;

import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import com.discord.R;
import kotlin.Metadata;

/* compiled from: DurationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/resources/DurationUnit;", "", "", "stringRes", "I", "getStringRes$app_productionGoogleRelease", "()I", "quantityPluralRes", "getQuantityPluralRes$app_productionGoogleRelease", "<init>", "(Ljava/lang/String;III)V", "SECONDS", "MINUTES", "MINS", "HOURS", "DAYS", "WEEKS", "MONTHS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.resources.DurationUnit, reason: use source file name */
/* loaded from: classes2.dex */
public enum DurationUtils2 {
    SECONDS(R.string.duration_seconds, R.plurals.duration_seconds_seconds),
    MINUTES(R.string.duration_minutes, R.plurals.duration_minutes_minutes),
    MINS(R.string.duration_mins, R.plurals.duration_mins_mins),
    HOURS(R.string.duration_hours, R.plurals.duration_hours_hours),
    DAYS(R.string.duration_days, R.plurals.duration_days_days),
    WEEKS(R.string.duration_weeks, R.plurals.duration_weeks_weeks),
    MONTHS(R.string.duration_months, R.plurals.duration_months_months);

    private final int quantityPluralRes;
    private final int stringRes;

    DurationUtils2(@StringRes int i, @PluralsRes int i2) {
        this.stringRes = i;
        this.quantityPluralRes = i2;
    }

    /* renamed from: getQuantityPluralRes$app_productionGoogleRelease, reason: from getter */
    public final int getQuantityPluralRes() {
        return this.quantityPluralRes;
    }

    /* renamed from: getStringRes$app_productionGoogleRelease, reason: from getter */
    public final int getStringRes() {
        return this.stringRes;
    }
}
