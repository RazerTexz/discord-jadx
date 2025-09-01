package com.discord.utilities.colors;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: ColorPickerUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/colors/ColorPickerUtils;", "", "Landroid/content/res/Resources;", "", "initialColor", "", "getColorsToDisplayForPicker", "(Landroid/content/res/Resources;I)[I", "Landroid/content/Context;", "context", "titleResId", "Lcom/jaredrummler/android/colorpicker/ColorPickerDialog;", "buildColorPickerDialog", "(Landroid/content/Context;II)Lcom/jaredrummler/android/colorpicker/ColorPickerDialog;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ColorPickerUtils {
    public static final ColorPickerUtils INSTANCE = new ColorPickerUtils();

    private ColorPickerUtils() {
    }

    @ColorInt
    private static final int[] getColorsToDisplayForPicker(Resources resources, @ColorInt int i) throws Resources.NotFoundException {
        int[] intArray = resources.getIntArray(R.array.color_picker_palette);
        Intrinsics3.checkNotNullExpressionValue(intArray, "getIntArray(com.discord.…ray.color_picker_palette)");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (int i2 : intArray) {
            arrayList.add(Integer.valueOf(i2));
            if (i2 == i) {
                z2 = true;
            }
        }
        if (!z2) {
            arrayList.add(Integer.valueOf(i));
        }
        return _Collections.toIntArray(arrayList);
    }

    public final ColorPickerDialog buildColorPickerDialog(Context context, @StringRes int titleResId, @ColorInt int initialColor) {
        Intrinsics3.checkNotNullParameter(context, "context");
        int[] iArr = ColorPickerDialog.j;
        ColorPickerDialog.k kVar = new ColorPickerDialog.k();
        kVar.h = initialColor;
        kVar.f3148s = ColorCompat.getThemedColor(context, R.attr.colorBackgroundPrimary);
        kVar.i = false;
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        kVar.g = getColorsToDisplayForPicker(resources, initialColor);
        kVar.a = titleResId;
        kVar.r = ColorCompat.getThemedColor(context, R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        kVar.f3149x = fontUtils.getThemedFontResId(context, R.attr.font_display_bold);
        kVar.o = ColorCompat.getThemedColor(context, R.attr.colorBackgroundAccent);
        kVar.c = R.string.color_picker_custom;
        kVar.v = ColorCompat.getColor(context, R.color.white);
        kVar.f3147b = R.string.color_picker_presets;
        kVar.p = ColorCompat.getThemedColor(context, R.attr.color_brand);
        kVar.d = R.string.select;
        kVar.l = true;
        kVar.e = R.string.reset;
        kVar.w = ColorCompat.getColor(context, R.color.white);
        kVar.f3150y = fontUtils.getThemedFontResId(context, R.attr.font_primary_semibold);
        kVar.q = ColorCompat.getThemedColor(context, R.attr.colorBackgroundModifierAccent);
        kVar.t = ColorCompat.getThemedColor(context, R.attr.colorTextMuted);
        kVar.u = R.drawable.drawable_cpv_edit_text_background;
        kVar.f3151z = fontUtils.getThemedFontResId(context, R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogA = kVar.a();
        Intrinsics3.checkNotNullExpressionValue(colorPickerDialogA, "ColorPickerDialog.newBui…mal))\n          .create()");
        return colorPickerDialogA;
    }
}
