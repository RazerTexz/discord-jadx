package com.discord.utilities.color;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: ColorCompat.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a%\u0010\f\u001a\u00020\u0003*\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000f\u001a\u00020\u0003*\u00020\u000e2\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u0013\u001a\u00020\u0001*\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroid/widget/ImageView;", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "", "tintWithColor", "(Landroid/widget/ImageView;I)V", "colorResId", "tintWithColorResource", "Landroid/graphics/drawable/Drawable;", "tint", "", "isGlobalTint", "setTint", "(Landroid/graphics/drawable/Drawable;IZ)V", "Landroid/widget/TextView;", "setDrawableColor", "(Landroid/widget/TextView;I)V", "Landroidx/fragment/app/Fragment;", "colorResourceId", "getColor", "(Landroidx/fragment/app/Fragment;I)I", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.color.ColorCompatKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ColorCompat2 {
    @ColorInt
    public static final int getColor(Fragment fragment, @ColorRes int i) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$getColor");
        return ColorCompat.getColor(fragment, i);
    }

    public static final void setDrawableColor(TextView textView, @ColorInt int i) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setDrawableColor");
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        Intrinsics3.checkNotNullExpressionValue(compoundDrawables, "compoundDrawables");
        Iterator it = _Arrays.filterNotNull(compoundDrawables).iterator();
        while (it.hasNext()) {
            ((Drawable) it.next()).setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        }
    }

    public static final void setTint(Drawable drawable, @ColorInt int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(drawable, "$this$setTint");
        if (!z2) {
            drawable.mutate();
        }
        DrawableCompat.setTint(drawable, i);
    }

    public static /* synthetic */ void setTint$default(Drawable drawable, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        setTint(drawable, i, z2);
    }

    public static final void tintWithColor(ImageView imageView, int i) {
        Intrinsics3.checkNotNullParameter(imageView, "$this$tintWithColor");
        imageView.setImageTintList(ColorStateList.valueOf(i));
    }

    public static final void tintWithColorResource(ImageView imageView, int i) {
        Intrinsics3.checkNotNullParameter(imageView, "$this$tintWithColorResource");
        tintWithColor(imageView, ColorCompat.getColor(imageView, i));
    }
}
