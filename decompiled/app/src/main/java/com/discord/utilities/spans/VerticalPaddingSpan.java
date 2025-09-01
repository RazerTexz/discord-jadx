package com.discord.utilities.spans;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.style.LineHeightSpan;
import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: VerticalPaddingSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/utilities/spans/VerticalPaddingSpan;", "Landroid/text/style/LineHeightSpan;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "start", "end", "spanstartv", "v", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetrics", "", "chooseHeight", "(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V", "origAscent", "I", "paddingTop", "origBottom", "origTop", "origDescent", "", "initialized", "Z", "paddingBottom", "getPaddingBottom", "()I", "<init>", "(II)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VerticalPaddingSpan implements LineHeightSpan {
    private boolean initialized;
    private final int paddingBottom;
    private final int paddingTop;
    private int origTop = -1;
    private int origAscent = -1;
    private int origBottom = -1;
    private int origDescent = -1;

    public VerticalPaddingSpan(int i, int i2) {
        this.paddingTop = i;
        this.paddingBottom = i2;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int v, Paint.FontMetricsInt fontMetrics) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(fontMetrics, "fontMetrics");
        if (((Spanned) (!(text instanceof Spanned) ? null : text)) != null) {
            if (!this.initialized) {
                this.origTop = fontMetrics.top;
                this.origAscent = fontMetrics.ascent;
                this.origBottom = fontMetrics.bottom;
                this.origDescent = fontMetrics.descent;
                this.initialized = true;
            }
            Spanned spanned = (Spanned) text;
            if (spanned.getSpanStart(this) == start) {
                int i = fontMetrics.top;
                int i2 = this.paddingTop;
                fontMetrics.top = i - i2;
                fontMetrics.ascent -= i2;
            } else {
                fontMetrics.top = this.origTop;
                fontMetrics.ascent = this.origAscent;
            }
            if (spanned.getSpanEnd(this) != end) {
                fontMetrics.bottom = this.origBottom;
                fontMetrics.descent = this.origDescent;
            } else {
                int i3 = fontMetrics.bottom;
                int i4 = this.paddingBottom;
                fontMetrics.bottom = i3 + i4;
                fontMetrics.descent += i4;
            }
        }
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }
}
