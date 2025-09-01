package b.a.k.e;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.ColorInt;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ClickableSpan.kt */
/* renamed from: b.a.k.e.a, reason: use source file name */
/* loaded from: classes.dex */
public final class ClickableSpan2 extends ClickableSpan {
    public final Function1<View, Unit> j;
    public final Integer k;

    /* JADX WARN: Multi-variable type inference failed */
    public ClickableSpan2(Function1<? super View, Unit> function1, @ColorInt Integer num) {
        Intrinsics3.checkNotNullParameter(function1, "clickHandler");
        this.j = function1;
        this.k = num;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Intrinsics3.checkNotNullParameter(view, "widget");
        this.j.invoke(view);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics3.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        Integer num = this.k;
        if (num != null) {
            textPaint.setColor(num.intValue());
        }
        textPaint.setUnderlineText(false);
    }
}
