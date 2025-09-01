package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.ranges.Ranges2;

/* compiled from: SpannableString.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\f\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\f\u0010\r\u001a$\u0010\f\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "Landroid/text/Spannable;", "toSpannable", "(Ljava/lang/CharSequence;)Landroid/text/Spannable;", "", "clearSpans", "(Landroid/text/Spannable;)V", "", "start", "end", "", "span", "set", "(Landroid/text/Spannable;IILjava/lang/Object;)V", "Lkotlin/ranges/IntRange;", "range", "(Landroid/text/Spannable;Lkotlin/ranges/IntRange;Ljava/lang/Object;)V", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.text.SpannableStringKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SpannableString {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(Spannable spannable) {
        Intrinsics3.checkNotNullParameter(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        Intrinsics3.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object obj) {
        Intrinsics3.checkNotNullParameter(spannable, "<this>");
        Intrinsics3.checkNotNullParameter(obj, "span");
        spannable.setSpan(obj, i, i2, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "<this>");
        android.text.SpannableString spannableStringValueOf = android.text.SpannableString.valueOf(charSequence);
        Intrinsics3.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void set(Spannable spannable, Ranges2 ranges2, Object obj) {
        Intrinsics3.checkNotNullParameter(spannable, "<this>");
        Intrinsics3.checkNotNullParameter(ranges2, "range");
        Intrinsics3.checkNotNullParameter(obj, "span");
        spannable.setSpan(obj, ranges2.getStart().intValue(), ranges2.getEndInclusive().intValue(), 17);
    }
}
