package com.discord.utilities.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;
import com.discord.utilities.color.ColorCompat2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: DrawableCompat.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u001a'\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0004\u001a\u00020\u0001*\u00020\u00062\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0007\u001a3\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u00012\b\b\u0001\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a9\u0010\u0017\u001a\u00020\u0010*\u00020\u000f2\b\b\u0003\u0010\u0013\u001a\u00020\u00012\b\b\u0003\u0010\u0014\u001a\u00020\u00012\b\b\u0003\u0010\u0015\u001a\u00020\u00012\b\b\u0003\u0010\u0016\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001aA\u0010\u0017\u001a\u00020\u0010*\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroid/content/Context;", "", "attrResId", "defaultResId", "getThemedDrawableRes", "(Landroid/content/Context;II)I", "Landroid/view/View;", "(Landroid/view/View;II)I", "resId", "tint", "", "isGlobalTint", "Landroid/graphics/drawable/Drawable;", "getDrawable", "(Landroid/content/Context;IIZ)Landroid/graphics/drawable/Drawable;", "Landroid/widget/TextView;", "", "applyCompoundDrawablesTint", "(Landroid/widget/TextView;)V", "start", "top", "end", "bottom", "setCompoundDrawablesCompat", "(Landroid/widget/TextView;IIII)V", "(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "utils_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DrawableCompat {
    private static final void applyCompoundDrawablesTint(TextView textView) {
        ColorStateList compoundDrawableTintList = TextViewCompat.getCompoundDrawableTintList(textView);
        if (compoundDrawableTintList != null) {
            TextViewCompat.setCompoundDrawableTintList(textView, compoundDrawableTintList);
        }
    }

    public static final Drawable getDrawable(Context context, @DrawableRes int i, @ColorInt int i2) {
        return getDrawable$default(context, i, i2, false, 4, null);
    }

    public static final Drawable getDrawable(Context context, @DrawableRes int i, @ColorInt int i2, boolean z2) {
        Intrinsics3.checkNotNullParameter(context, "$this$getDrawable");
        Drawable drawable = AppCompatResources.getDrawable(context, i);
        if (drawable != null) {
            ColorCompat2.setTint(drawable, i2, z2);
        }
        return drawable;
    }

    public static /* synthetic */ Drawable getDrawable$default(Context context, int i, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return getDrawable(context, i, i2, z2);
    }

    public static final int getThemedDrawableRes(Context context, @AttrRes int i) {
        return getThemedDrawableRes$default(context, i, 0, 2, (Object) null);
    }

    public static final int getThemedDrawableRes(Context context, @AttrRes int i, int i2) {
        Intrinsics3.checkNotNullParameter(context, "$this$getThemedDrawableRes");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(intArrayOf(attrResId))");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    @DrawableRes
    public static final int getThemedDrawableRes(View view, @AttrRes int i) {
        return getThemedDrawableRes$default(view, i, 0, 2, (Object) null);
    }

    public static /* synthetic */ int getThemedDrawableRes$default(Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return getThemedDrawableRes(context, i, i2);
    }

    public static final void setCompoundDrawablesCompat(TextView textView, @DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setCompoundDrawablesCompat");
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, i, i2, i3, i4);
        applyCompoundDrawablesTint(textView);
    }

    public static /* synthetic */ void setCompoundDrawablesCompat$default(TextView textView, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        setCompoundDrawablesCompat(textView, i, i2, i3, i4);
    }

    public static /* synthetic */ int getThemedDrawableRes$default(View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return getThemedDrawableRes(view, i, i2);
    }

    public static /* synthetic */ void setCompoundDrawablesCompat$default(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = null;
        }
        if ((i & 2) != 0) {
            drawable2 = null;
        }
        if ((i & 4) != 0) {
            drawable3 = null;
        }
        if ((i & 8) != 0) {
            drawable4 = null;
        }
        setCompoundDrawablesCompat(textView, drawable, drawable2, drawable3, drawable4);
    }

    @DrawableRes
    public static final int getThemedDrawableRes(View view, @AttrRes int i, int i2) {
        Intrinsics3.checkNotNullParameter(view, "$this$getThemedDrawableRes");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        return getThemedDrawableRes(context, i, i2);
    }

    public static final void setCompoundDrawablesCompat(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setCompoundDrawablesCompat");
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, drawable, drawable2, drawable3, drawable4);
        applyCompoundDrawablesTint(textView);
    }
}
