package com.discord.utilities.resources;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import d0.Tuples;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: DurationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/resources/MillisecondsFormatter;", "", "Landroid/content/Context;", "", "millis", "", "formatDurationInMillis", "(Landroid/content/Context;J)Ljava/lang/CharSequence;", "MS_IN_MINUTE", "J", "MS_IN_MONTH", "MS_IN_WEEK", "MS_IN_HOUR", "MS_IN_DAY", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.resources.MillisecondsFormatter, reason: use source file name */
/* loaded from: classes2.dex */
public final class DurationUtils4 {
    public static final DurationUtils4 INSTANCE = new DurationUtils4();
    private static final long MS_IN_DAY = 86400000;
    private static final long MS_IN_HOUR = 3600000;
    private static final long MS_IN_MINUTE = 60000;
    private static final long MS_IN_MONTH = 2592000000L;
    private static final long MS_IN_WEEK = 604800000;

    private DurationUtils4() {
    }

    public final CharSequence formatDurationInMillis(Context context, long j) {
        Intrinsics3.checkNotNullParameter(context, "$this$formatDurationInMillis");
        return DurationUtils3.formatDuration(context, (DurationUtils2) ((2592000000L <= j && RecyclerView.FOREVER_NS >= j) ? Tuples.to(DurationUtils2.MONTHS, 2592000000L) : (MS_IN_WEEK <= j && 2592000000L >= j) ? Tuples.to(DurationUtils2.WEEKS, Long.valueOf(MS_IN_WEEK)) : (MS_IN_DAY <= j && MS_IN_WEEK >= j) ? Tuples.to(DurationUtils2.DAYS, Long.valueOf(MS_IN_DAY)) : (MS_IN_HOUR <= j && MS_IN_DAY >= j) ? Tuples.to(DurationUtils2.HOURS, Long.valueOf(MS_IN_HOUR)) : Tuples.to(DurationUtils2.MINUTES, 60000L)).component1(), MathJVM.roundToInt(j / ((Number) r0.component2()).longValue()));
    }
}
