package androidx.core.text;

import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SpannableStringBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a'\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a?\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a3\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\b2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\r\u001a+\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000f\u001a+\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000f\u001a5\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0014\u001a+\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u000f\u001a3\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a+\u0010\u001b\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000f\u001a+\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "builderAction", "Landroid/text/SpannedString;", "buildSpannedString", "(Lkotlin/jvm/functions/Function1;)Landroid/text/SpannedString;", "", "", "spans", "inSpans", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "span", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "bold", "(Landroid/text/SpannableStringBuilder;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "underline", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "(Landroid/text/SpannableStringBuilder;ILkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "backgroundColor", "strikeThrough", "", "proportion", "scale", "(Landroid/text/SpannableStringBuilder;FLkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "superscript", "subscript", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.text.SpannableStringBuilderKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SpannableStringBuilder {
    public static final android.text.SpannableStringBuilder backgroundColor(android.text.SpannableStringBuilder spannableStringBuilder, @ColorInt int i, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder bold(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannedString buildSpannedString(Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        function1.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    public static final android.text.SpannableStringBuilder color(android.text.SpannableStringBuilder spannableStringBuilder, @ColorInt int i, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder inSpans(android.text.SpannableStringBuilder spannableStringBuilder, Object[] objArr, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(objArr, "spans");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        int length2 = objArr.length;
        int i = 0;
        while (i < length2) {
            Object obj = objArr[i];
            i++;
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder italic(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder scale(android.text.SpannableStringBuilder spannableStringBuilder, float f, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder strikeThrough(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder subscript(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder superscript(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder underline(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder inSpans(android.text.SpannableStringBuilder spannableStringBuilder, Object obj, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(obj, "span");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
