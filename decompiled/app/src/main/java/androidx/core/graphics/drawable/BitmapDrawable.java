package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: BitmapDrawable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/graphics/Bitmap;", "Landroid/content/res/Resources;", "resources", "Landroid/graphics/drawable/BitmapDrawable;", "toDrawable", "(Landroid/graphics/Bitmap;Landroid/content/res/Resources;)Landroid/graphics/drawable/BitmapDrawable;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.drawable.BitmapDrawableKt, reason: use source file name */
/* loaded from: classes.dex */
public final class BitmapDrawable {
    public static final android.graphics.drawable.BitmapDrawable toDrawable(Bitmap bitmap, Resources resources) {
        Intrinsics3.checkNotNullParameter(bitmap, "<this>");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        return new android.graphics.drawable.BitmapDrawable(resources, bitmap);
    }
}
