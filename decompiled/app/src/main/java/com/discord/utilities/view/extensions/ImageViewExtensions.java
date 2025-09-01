package com.discord.utilities.view.extensions;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ImageViewExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/widget/ImageView;", "", "saturation", "", "setSaturation", "(Landroid/widget/ImageView;F)V", "", "grayscale", "setGrayscale", "(Landroid/widget/ImageView;Z)V", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.extensions.ImageViewExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ImageViewExtensions {
    public static final void setGrayscale(ImageView imageView, boolean z2) {
        Intrinsics3.checkNotNullParameter(imageView, "$this$setGrayscale");
        setSaturation(imageView, z2 ? 0.0f : 1.0f);
    }

    public static final void setSaturation(ImageView imageView, @FloatRange(from = 0.0d, to = 3.4028234663852886E38d) float f) {
        Intrinsics3.checkNotNullParameter(imageView, "$this$setSaturation");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(f);
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }
}
