package com.discord.utilities.spans;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BulletSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 -2\u00020\u0001:\u0001-B1\b\u0016\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\"\u0012\b\b\u0002\u0010(\u001a\u00020\u001c¢\u0006\u0004\b)\u0010*B7\b\u0016\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\"\u0012\b\b\u0002\u0010(\u001a\u00020\u001c¢\u0006\u0004\b)\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006Jo\u0010\u0017\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006."}, d2 = {"Lcom/discord/utilities/spans/BulletSpan;", "Landroid/text/style/LeadingMarginSpan;", "", "first", "", "getLeadingMargin", "(Z)I", "Landroid/graphics/Canvas;", "c", "Landroid/graphics/Paint;", "p", "x", "dir", "top", "baseline", "bottom", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "start", "end", "Landroid/text/Layout;", "l", "", "drawLeadingMargin", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;IIZLandroid/text/Layout;)V", "mGapWidth", "I", "mBulletRadius", "Landroid/graphics/Paint$Style;", "mStyle", "Landroid/graphics/Paint$Style;", "mColor", "mWantColor", "Z", "", "mStrokeWidth", "F", "gapWidth", "bulletRadius", "strokeWidth", "style", "<init>", "(IIFLandroid/graphics/Paint$Style;)V", ModelAuditLogEntry.CHANGE_KEY_COLOR, "(IIIFLandroid/graphics/Paint$Style;)V", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BulletSpan implements LeadingMarginSpan {
    public static final int STANDARD_BULLET_RADIUS_PX = 4;
    public static final int STANDARD_GAP_WIDTH_PX = 2;
    public static final float STANDARD_STROKE_WIDTH_PX = 4.0f;
    private static Path sBulletPath;
    private final int mBulletRadius;
    private final int mColor;
    private final int mGapWidth;
    private final float mStrokeWidth;
    private final Paint.Style mStyle;
    private final boolean mWantColor;

    public /* synthetic */ BulletSpan(int i, int i2, float f, Paint.Style style, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 2 : i, (i3 & 2) != 0 ? 4 : i2, (i3 & 4) != 0 ? 4.0f : f, (i3 & 8) != 0 ? Paint.Style.FILL : style);
    }

    @Override // android.text.style.LeadingMarginSpan
    @SuppressLint({"NewApi"})
    public void drawLeadingMargin(Canvas c, Paint p, int x2, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout l) {
        Intrinsics3.checkNotNullParameter(c, "c");
        Intrinsics3.checkNotNullParameter(p, "p");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(l, "l");
        if (((Spanned) text).getSpanStart(this) == start) {
            Paint.Style style = p.getStyle();
            int color = 0;
            if (this.mWantColor) {
                color = p.getColor();
                p.setColor(this.mColor);
            }
            p.setStyle(this.mStyle);
            Paint.Style style2 = this.mStyle;
            if (style2 == Paint.Style.STROKE || style2 == Paint.Style.FILL_AND_STROKE) {
                p.setStrokeWidth(this.mStrokeWidth);
            }
            if (c.isHardwareAccelerated()) {
                if (sBulletPath == null) {
                    Path path = new Path();
                    sBulletPath = path;
                    Intrinsics3.checkNotNull(path);
                    path.addCircle(0.0f, 0.0f, this.mBulletRadius * 1.2f, Path.Direction.CW);
                }
                c.save();
                c.translate((dir * 1.2f * this.mBulletRadius) + x2, (top + bottom) / 2.0f);
                Path path2 = sBulletPath;
                Intrinsics3.checkNotNull(path2);
                c.drawPath(path2, p);
                c.restore();
            } else {
                c.drawCircle((dir * r11) + x2, (top + bottom) / 2.0f, this.mBulletRadius, p);
            }
            if (this.mWantColor) {
                p.setColor(color);
            }
            p.setStyle(style);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return (this.mBulletRadius * 2) + this.mGapWidth;
    }

    public BulletSpan(int i, int i2, float f, Paint.Style style) {
        Intrinsics3.checkNotNullParameter(style, "style");
        this.mGapWidth = i;
        this.mBulletRadius = i2;
        this.mWantColor = false;
        this.mColor = 0;
        this.mStyle = style;
        this.mStrokeWidth = f;
    }

    public /* synthetic */ BulletSpan(int i, int i2, int i3, float f, Paint.Style style, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? 4 : i3, (i4 & 8) != 0 ? 4.0f : f, (i4 & 16) != 0 ? Paint.Style.FILL : style);
    }

    public BulletSpan(int i, int i2, int i3, float f, Paint.Style style) {
        Intrinsics3.checkNotNullParameter(style, "style");
        this.mGapWidth = i;
        this.mBulletRadius = i3;
        this.mWantColor = true;
        this.mColor = i2;
        this.mStyle = style;
        this.mStrokeWidth = f;
    }
}
