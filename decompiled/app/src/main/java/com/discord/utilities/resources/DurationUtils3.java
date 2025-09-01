package com.discord.utilities.resources;

import android.content.Context;
import android.widget.TextView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: DurationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\r\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/content/Context;", "Lcom/discord/utilities/resources/DurationUnit;", "unit", "", "quantity", "", "formatDuration", "(Landroid/content/Context;Lcom/discord/utilities/resources/DurationUnit;I)Ljava/lang/CharSequence;", "inviteExpirationDurationSeconds", "formatInviteExpireAfterString", "(Landroid/content/Context;I)Ljava/lang/CharSequence;", "Landroid/widget/TextView;", "", "setDurationText", "(Landroid/widget/TextView;Lcom/discord/utilities/resources/DurationUnit;I)V", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.resources.DurationUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class DurationUtils3 {
    public static final CharSequence formatDuration(Context context, DurationUtils2 durationUtils2, int i) {
        Intrinsics3.checkNotNullParameter(context, "$this$formatDuration");
        Intrinsics3.checkNotNullParameter(durationUtils2, "unit");
        return FormatUtils.h(context, durationUtils2.getStringRes(), new Object[]{StringResourceUtils.getI18nPluralString(context, durationUtils2.getQuantityPluralRes(), i, Integer.valueOf(i))}, null, 4);
    }

    public static final CharSequence formatInviteExpireAfterString(Context context, int i) {
        Intrinsics3.checkNotNullParameter(context, "$this$formatInviteExpireAfterString");
        if (i == 0) {
            return FormatUtils.h(context, R.string.no_user_limit, new Object[0], null, 4);
        }
        if (i == 1800) {
            return formatDuration(context, DurationUtils2.MINS, 30);
        }
        if (i == 3600) {
            return formatDuration(context, DurationUtils2.HOURS, 1);
        }
        if (i == 21600) {
            return formatDuration(context, DurationUtils2.HOURS, 6);
        }
        if (i == 43200) {
            return formatDuration(context, DurationUtils2.HOURS, 12);
        }
        if (i == 86400) {
            return formatDuration(context, DurationUtils2.DAYS, 1);
        }
        if (i == 604800) {
            return formatDuration(context, DurationUtils2.DAYS, 7);
        }
        throw new IllegalArgumentException(outline.q("Invalid expiration duration ", i));
    }

    public static final void setDurationText(TextView textView, DurationUtils2 durationUtils2, int i) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setDurationText");
        Intrinsics3.checkNotNullParameter(durationUtils2, "unit");
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView.setText(formatDuration(context, durationUtils2, i));
    }
}
