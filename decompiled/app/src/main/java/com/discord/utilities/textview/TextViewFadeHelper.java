package com.discord.utilities.textview;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.widget.TextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TextViewFadeHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u00060\u0012R\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/utilities/textview/TextViewFadeHelper;", "", "", "updateFade", "()V", "Landroid/widget/TextView;", "registerFadeHelper", "()Landroid/widget/TextView;", "textView", "Landroid/widget/TextView;", "getTextView", "", "lineWidth", "Ljava/lang/Float;", "getLineWidth", "()Ljava/lang/Float;", "setLineWidth", "(Ljava/lang/Float;)V", "Lcom/discord/utilities/textview/TextViewFadeHelper$LinearGradientSpan;", "span", "Lcom/discord/utilities/textview/TextViewFadeHelper$LinearGradientSpan;", "getSpan", "()Lcom/discord/utilities/textview/TextViewFadeHelper$LinearGradientSpan;", "<init>", "(Landroid/widget/TextView;)V", "LinearGradientSpan", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TextViewFadeHelper {
    private Float lineWidth;
    private final LinearGradientSpan span;
    private final TextView textView;

    /* compiled from: TextViewFadeHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/utilities/textview/TextViewFadeHelper$LinearGradientSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "Landroid/text/TextPaint;", "tp", "", "updateDrawState", "(Landroid/text/TextPaint;)V", "<init>", "(Lcom/discord/utilities/textview/TextViewFadeHelper;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class LinearGradientSpan extends CharacterStyle implements UpdateAppearance {
        public LinearGradientSpan() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint tp) {
            Float lineWidth;
            if (tp == null || (lineWidth = TextViewFadeHelper.this.getLineWidth()) == null) {
                return;
            }
            float fFloatValue = lineWidth.floatValue();
            tp.bgColor = 0;
            tp.setShader(new LinearGradient(0.0f, 0.0f, fFloatValue, 0.0f, TextViewFadeHelper.this.getTextView().getCurrentTextColor(), Color.parseColor("#00000000"), Shader.TileMode.CLAMP));
        }
    }

    public TextViewFadeHelper(TextView textView) {
        Intrinsics3.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.span = new LinearGradientSpan();
    }

    public static final /* synthetic */ void access$updateFade(TextViewFadeHelper textViewFadeHelper) {
        textViewFadeHelper.updateFade();
    }

    private final void updateFade() {
        Layout layout = this.textView.getLayout();
        if (layout != null) {
            CharSequence text = this.textView.getText();
            if (!(text instanceof Spannable)) {
                text = null;
            }
            Spannable spannable = (Spannable) text;
            if (spannable != null) {
                int lineCount = this.textView.getLineCount();
                int maxLines = this.textView.getMaxLines();
                int spanStart = spannable.getSpanStart(this.span);
                int spanEnd = spannable.getSpanEnd(this.span);
                boolean z2 = (spanStart == -1 || spanEnd == -1) ? false : true;
                if (lineCount <= maxLines && z2) {
                    spannable.removeSpan(this.span);
                } else {
                    if (lineCount <= maxLines) {
                        return;
                    }
                    int i = maxLines - 1;
                    int lineStart = layout.getLineStart(i);
                    int lineEnd = layout.getLineEnd(i);
                    float lineWidth = layout.getLineWidth(i);
                    if (z2) {
                        if (spanStart == lineStart && spanEnd == lineEnd && Intrinsics3.areEqual(this.lineWidth, lineWidth)) {
                            return;
                        } else {
                            spannable.removeSpan(this.span);
                        }
                    }
                    this.lineWidth = Float.valueOf(lineWidth);
                    spannable.setSpan(this.span, lineStart, lineEnd, 0);
                }
                this.textView.setText(spannable);
            }
        }
    }

    public final Float getLineWidth() {
        return this.lineWidth;
    }

    public final LinearGradientSpan getSpan() {
        return this.span;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final TextView registerFadeHelper() {
        TextView textView = this.textView;
        textView.addOnAttachStateChangeListener(new TextViewFadeHelper4(textView, new TextViewFadeHelper2(this), new TextViewFadeHelper3(this)));
        return textView;
    }

    public final void setLineWidth(Float f) {
        this.lineWidth = f;
    }
}
