package androidx.core.graphics.drawable;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ColorDrawable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Landroid/graphics/drawable/ColorDrawable;", "toDrawable", "(I)Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/Color;", "(Landroid/graphics/Color;)Landroid/graphics/drawable/ColorDrawable;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.drawable.ColorDrawableKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ColorDrawable {
    public static final android.graphics.drawable.ColorDrawable toDrawable(@ColorInt int i) {
        return new android.graphics.drawable.ColorDrawable(i);
    }

    @RequiresApi(26)
    public static final android.graphics.drawable.ColorDrawable toDrawable(Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return new android.graphics.drawable.ColorDrawable(color.toArgb());
    }
}
