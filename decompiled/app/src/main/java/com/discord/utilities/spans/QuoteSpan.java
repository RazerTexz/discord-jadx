package com.discord.utilities.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.Px;
import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: QuoteSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010'\u001a\u00020\u000b\u0012\b\b\u0001\u0010%\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJo\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0019\u0010%\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!R\u0019\u0010'\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!¨\u0006+"}, d2 = {"Lcom/discord/utilities/spans/QuoteSpan;", "Landroid/text/style/LeadingMarginSpan;", "Landroid/graphics/Canvas;", "c", "Landroid/graphics/Paint;", "p", "", "draw", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;)V", "", "first", "", "getLeadingMargin", "(Z)I", "x", "dir", "top", "baseline", "bottom", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "start", "end", "Landroid/text/Layout;", "layout", "drawLeadingMargin", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;IIZLandroid/text/Layout;)V", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/RectF;", "gapWidth", "I", "getGapWidth", "()I", "", "radius", "F", "stripeWidth", "getStripeWidth", "stripeColor", "getStripeColor", "<init>", "(III)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class QuoteSpan implements LeadingMarginSpan {
    private final int gapWidth;
    private final float radius;
    private final RectF rect = new RectF();
    private final int stripeColor;
    private final int stripeWidth;

    public QuoteSpan(@ColorInt int i, @IntRange(from = 0) @Px int i2, @IntRange(from = 0) @Px int i3) {
        this.stripeColor = i;
        this.stripeWidth = i2;
        this.gapWidth = i3;
        this.radius = i2;
    }

    private final void draw(Canvas c, Paint p) {
        Paint.Style style = p.getStyle();
        int color = p.getColor();
        p.setStyle(Paint.Style.FILL);
        p.setColor(this.stripeColor);
        RectF rectF = this.rect;
        float f = this.radius;
        c.drawRoundRect(rectF, f, f, p);
        p.setStyle(style);
        p.setColor(color);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x2, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        Intrinsics3.checkNotNullParameter(c, "c");
        Intrinsics3.checkNotNullParameter(p, "p");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(layout, "layout");
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            if (spanned.getSpanStart(this) == start) {
                RectF rectF = this.rect;
                rectF.left = x2;
                rectF.right = (dir * this.stripeWidth) + x2;
                rectF.top = top;
            }
            int spanEnd = spanned.getSpanEnd(this);
            if (spanEnd == end || (spanEnd - 1 == end && text.charAt(end) == '\n')) {
                this.rect.bottom = bottom;
                draw(c, p);
            }
        }
    }

    public final int getGapWidth() {
        return this.gapWidth;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return this.stripeWidth + this.gapWidth;
    }

    public final int getStripeColor() {
        return this.stripeColor;
    }

    public final int getStripeWidth() {
        return this.stripeWidth;
    }
}
