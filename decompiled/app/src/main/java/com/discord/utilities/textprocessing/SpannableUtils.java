package com.discord.utilities.textprocessing;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import androidx.annotation.AttrRes;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SpannableUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a+\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/text/SpannableStringBuilder;", "Landroid/content/Context;", "context", "", "fontResId", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "appendWithFont", "(Landroid/text/SpannableStringBuilder;Landroid/content/Context;ILjava/lang/CharSequence;)V", "", "span", "appendWithSpan", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textprocessing.SpannableUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class SpannableUtils {
    public static final void appendWithFont(SpannableStringBuilder spannableStringBuilder, Context context, @AttrRes int i, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "$this$appendWithFont");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Typeface themedFont = FontUtils.INSTANCE.getThemedFont(context, i);
        if (themedFont != null) {
            appendWithSpan(spannableStringBuilder, new TypefaceSpanCompat(themedFont), charSequence);
        } else {
            spannableStringBuilder.append(charSequence);
        }
    }

    public static final void appendWithSpan(SpannableStringBuilder spannableStringBuilder, Object obj, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "$this$appendWithSpan");
        Intrinsics3.checkNotNullParameter(obj, "span");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 33);
    }
}
