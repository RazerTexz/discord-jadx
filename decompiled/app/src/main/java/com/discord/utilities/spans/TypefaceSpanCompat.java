package com.discord.utilities.spans;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.TypefaceSpan;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TypefaceSpanCompat.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/spans/TypefaceSpanCompat;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/graphics/Paint;", "paint", "", "apply", "(Landroid/graphics/Paint;)V", "Landroid/text/TextPaint;", "drawState", "updateDrawState", "(Landroid/text/TextPaint;)V", "updateMeasureState", "Landroid/graphics/Typeface;", "typeface", "Landroid/graphics/Typeface;", "<init>", "(Landroid/graphics/Typeface;)V", "Monospace", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TypefaceSpanCompat extends MetricAffectingSpan {
    private final Typeface typeface;

    /* compiled from: TypefaceSpanCompat.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/utilities/spans/TypefaceSpanCompat$Monospace;", "Landroid/text/style/TypefaceSpan;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Monospace extends TypefaceSpan {
        public Monospace() {
            super("monospace");
        }
    }

    public TypefaceSpanCompat(Typeface typeface) {
        Intrinsics3.checkNotNullParameter(typeface, "typeface");
        this.typeface = typeface;
    }

    private final void apply(Paint paint) {
        Typeface typeface = paint.getTypeface();
        int style = (typeface != null ? typeface.getStyle() : 0) & (~this.typeface.getStyle());
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.typeface);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint drawState) {
        Intrinsics3.checkNotNullParameter(drawState, "drawState");
        apply(drawState);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        Intrinsics3.checkNotNullParameter(paint, "paint");
        apply(paint);
    }
}
