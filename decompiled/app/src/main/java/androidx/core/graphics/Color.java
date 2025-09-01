package androidx.core.graphics;

import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Color.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u0002\u001a\u00020\n*\u00020\nH\u0086\n¢\u0006\u0004\b\u0002\u0010\u000b\u001a\u0014\u0010\u0004\u001a\u00020\n*\u00020\nH\u0086\n¢\u0006\u0004\b\u0004\u0010\u000b\u001a\u0014\u0010\u0005\u001a\u00020\n*\u00020\nH\u0086\n¢\u0006\u0004\b\u0005\u0010\u000b\u001a\u0014\u0010\u0006\u001a\u00020\n*\u00020\nH\u0086\n¢\u0006\u0004\b\u0006\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\nH\u0087\b¢\u0006\u0004\b\f\u0010\r\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\nH\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u000eH\u0087\n¢\u0006\u0004\b\u0002\u0010\u0011\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u000eH\u0087\n¢\u0006\u0004\b\u0004\u0010\u0011\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u000eH\u0087\n¢\u0006\u0004\b\u0005\u0010\u0011\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u000eH\u0087\n¢\u0006\u0004\b\u0006\u0010\u0011\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u000eH\u0087\b¢\u0006\u0004\b\f\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\n*\u00020\u000eH\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0017\u001a\u00020\u000e*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0087\f¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0017\u001a\u00020\u000e*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0019H\u0087\f¢\u0006\u0004\b\u0017\u0010\u001a\u001a\u001c\u0010\u0017\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0087\f¢\u0006\u0004\b\u0017\u0010\u001b\u001a\u001c\u0010\u0017\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0019H\u0087\f¢\u0006\u0004\b\u0017\u0010\u001c\u001a\u001c\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0087\f¢\u0006\u0004\b\u0017\u0010\u001d\u001a\u001c\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0019H\u0087\f¢\u0006\u0004\b\u0017\u0010\u001e\u001a\u0014\u0010\u0013\u001a\u00020\n*\u00020\u001fH\u0087\b¢\u0006\u0004\b\u0013\u0010 \"\u0018\u0010\"\u001a\u00020\n*\u00020\n8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u000b\"\u0018\u0010$\u001a\u00020\n*\u00020\n8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u000b\"\u0018\u0010&\u001a\u00020%*\u00020\u000e8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0018\u0010$\u001a\u00020\u0001*\u00020\u000e8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u0011\"\u0018\u0010)\u001a\u00020\u0001*\u00020\u000e8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010\u0011\"\u0018\u0010+\u001a\u00020\u0001*\u00020\u000e8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010\u0011\"\u0018\u0010-\u001a\u00020\n*\u00020\n8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\u000b\"\u0018\u0010.\u001a\u00020%*\u00020\u000e8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010'\"\u0018\u0010-\u001a\u00020\u0001*\u00020\u000e8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\u0011\"\u0018\u0010\u0016\u001a\u00020\u0019*\u00020\u000e8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0018\u0010)\u001a\u00020\n*\u00020\n8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010\u000b\"\u0018\u0010+\u001a\u00020\u0001*\u00020\n8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b*\u00101\"\u0018\u0010\"\u001a\u00020\u0001*\u00020\u000e8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u0011¨\u00062"}, d2 = {"Landroid/graphics/Color;", "", "component1", "(Landroid/graphics/Color;)F", "component2", "component3", "component4", "c", "plus", "(Landroid/graphics/Color;Landroid/graphics/Color;)Landroid/graphics/Color;", "", "(I)I", "toColor", "(I)Landroid/graphics/Color;", "", "toColorLong", "(I)J", "(J)F", "(J)Landroid/graphics/Color;", "toColorInt", "(J)I", "Landroid/graphics/ColorSpace$Named;", "colorSpace", "convertTo", "(ILandroid/graphics/ColorSpace$Named;)J", "Landroid/graphics/ColorSpace;", "(ILandroid/graphics/ColorSpace;)J", "(JLandroid/graphics/ColorSpace$Named;)J", "(JLandroid/graphics/ColorSpace;)J", "(Landroid/graphics/Color;Landroid/graphics/ColorSpace$Named;)Landroid/graphics/Color;", "(Landroid/graphics/Color;Landroid/graphics/ColorSpace;)Landroid/graphics/Color;", "", "(Ljava/lang/String;)I", "getAlpha", Key.ALPHA, "getRed", "red", "", "isWideGamut", "(J)Z", "getBlue", "blue", "getLuminance", "luminance", "getGreen", "green", "isSrgb", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "(I)F", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.ColorKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Color {
    @RequiresApi(26)
    public static final float component1(android.graphics.Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(android.graphics.Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(android.graphics.Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(android.graphics.Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace.Named named) {
        Intrinsics3.checkNotNullParameter(named, "colorSpace");
        return android.graphics.Color.convert(i, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j) {
        return android.graphics.Color.alpha(j);
    }

    public static final int getAlpha(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j) {
        return android.graphics.Color.blue(j);
    }

    public static final int getBlue(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j) {
        ColorSpace colorSpace = android.graphics.Color.colorSpace(j);
        Intrinsics3.checkNotNullExpressionValue(colorSpace, "colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j) {
        return android.graphics.Color.green(j);
    }

    public static final int getGreen(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i) {
        return android.graphics.Color.luminance(i);
    }

    @RequiresApi(26)
    public static final float getRed(long j) {
        return android.graphics.Color.red(j);
    }

    public static final int getRed(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j) {
        return android.graphics.Color.isSrgb(j);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j) {
        return android.graphics.Color.isWideGamut(j);
    }

    @RequiresApi(26)
    public static final android.graphics.Color plus(android.graphics.Color color, android.graphics.Color color2) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        Intrinsics3.checkNotNullParameter(color2, "c");
        android.graphics.Color colorCompositeColors = ColorUtils.compositeColors(color2, color);
        Intrinsics3.checkNotNullExpressionValue(colorCompositeColors, "compositeColors(c, this)");
        return colorCompositeColors;
    }

    @RequiresApi(26)
    public static final android.graphics.Color toColor(@ColorInt int i) {
        android.graphics.Color colorValueOf = android.graphics.Color.valueOf(i);
        Intrinsics3.checkNotNullExpressionValue(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j) {
        return android.graphics.Color.toArgb(j);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i) {
        return android.graphics.Color.pack(i);
    }

    @RequiresApi(26)
    public static final float component1(long j) {
        return android.graphics.Color.red(j);
    }

    @RequiresApi(26)
    public static final float component2(long j) {
        return android.graphics.Color.green(j);
    }

    @RequiresApi(26)
    public static final float component3(long j) {
        return android.graphics.Color.blue(j);
    }

    @RequiresApi(26)
    public static final float component4(long j) {
        return android.graphics.Color.alpha(j);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace colorSpace) {
        Intrinsics3.checkNotNullParameter(colorSpace, "colorSpace");
        return android.graphics.Color.convert(i, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j) {
        return android.graphics.Color.luminance(j);
    }

    @RequiresApi(26)
    public static final android.graphics.Color toColor(long j) {
        android.graphics.Color colorValueOf = android.graphics.Color.valueOf(j);
        Intrinsics3.checkNotNullExpressionValue(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    public static final int toColorInt(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        return android.graphics.Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace.Named named) {
        Intrinsics3.checkNotNullParameter(named, "colorSpace");
        return android.graphics.Color.convert(j, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace colorSpace) {
        Intrinsics3.checkNotNullParameter(colorSpace, "colorSpace");
        return android.graphics.Color.convert(j, colorSpace);
    }

    @RequiresApi(26)
    public static final android.graphics.Color convertTo(android.graphics.Color color, ColorSpace.Named named) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        Intrinsics3.checkNotNullParameter(named, "colorSpace");
        android.graphics.Color colorConvert = color.convert(ColorSpace.get(named));
        Intrinsics3.checkNotNullExpressionValue(colorConvert, "convert(ColorSpace.get(colorSpace))");
        return colorConvert;
    }

    @RequiresApi(26)
    public static final android.graphics.Color convertTo(android.graphics.Color color, ColorSpace colorSpace) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        Intrinsics3.checkNotNullParameter(colorSpace, "colorSpace");
        android.graphics.Color colorConvert = color.convert(colorSpace);
        Intrinsics3.checkNotNullExpressionValue(colorConvert, "convert(colorSpace)");
        return colorConvert;
    }
}
