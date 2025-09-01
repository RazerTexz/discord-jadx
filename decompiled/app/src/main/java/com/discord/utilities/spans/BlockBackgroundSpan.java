package com.discord.utilities.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.style.LineBackgroundSpan;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: BlockBackgroundSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010#\u001a\u00020\t\u0012\b\b\u0001\u0010$\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006Jg\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/discord/utilities/spans/BlockBackgroundSpan;", "Landroid/text/style/LineBackgroundSpan;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Paint;", "paint", "", "left", "right", "top", "baseline", "bottom", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "start", "end", "lnum", "drawBackground", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;III)V", "", "radius", "F", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/RectF;", "leftMargin", "I", "getLeftMargin", "()I", "fillColor", "strokeColor", "strokeWidth", "strokeRadius", "<init>", "(IIIII)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BlockBackgroundSpan implements LineBackgroundSpan {
    private final Paint fillPaint;
    private final int leftMargin;
    private final float radius;
    private final RectF rect;
    private final Paint strokePaint;

    public BlockBackgroundSpan(@ColorInt int i, @ColorInt int i2, int i3, int i4, int i5) {
        this.leftMargin = i5;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        this.fillPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(i2);
        paint2.setStrokeWidth(i3);
        paint2.setAntiAlias(true);
        this.strokePaint = paint2;
        this.rect = new RectF();
        this.radius = i4;
    }

    public final void draw(Canvas canvas) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        RectF rectF = this.rect;
        float f = this.radius;
        canvas.drawRoundRect(rectF, f, f, this.fillPaint);
        RectF rectF2 = this.rect;
        float f2 = this.radius;
        canvas.drawRoundRect(rectF2, f2, f2, this.strokePaint);
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lnum) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        Intrinsics3.checkNotNullParameter(paint, "paint");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        if (((Spanned) (!(text instanceof Spanned) ? null : text)) != null) {
            Spanned spanned = (Spanned) text;
            if (spanned.getSpanStart(this) == start) {
                RectF rectF = this.rect;
                rectF.left = left + this.leftMargin;
                rectF.top = top;
            }
            if (spanned.getSpanEnd(this) == end) {
                RectF rectF2 = this.rect;
                rectF2.right = right;
                rectF2.bottom = bottom;
                draw(canvas);
            }
        }
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }
}
