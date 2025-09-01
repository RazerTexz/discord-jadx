package com.discord.utilities.fresco;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import b.f.b.a.SimpleCacheKey;
import b.f.j.q.BasePostprocessor;
import com.facebook.cache.common.CacheKey;
import d0.z.d.Intrinsics3;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;

/* compiled from: GrayscalePostprocessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/fresco/GrayscalePostprocessor;", "Lb/f/j/q/a;", "Landroid/graphics/Bitmap;", "destBitmap", "sourceBitmap", "", "process", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "", "getName", "()Ljava/lang/String;", "Lcom/facebook/cache/common/CacheKey;", "getPostprocessorCacheKey", "()Lcom/facebook/cache/common/CacheKey;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GrayscalePostprocessor extends BasePostprocessor {
    @Override // b.f.j.q.BasePostprocessor, b.f.j.q.Postprocessor
    public String getName() {
        String simpleName = GrayscalePostprocessor.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // b.f.j.q.BasePostprocessor, b.f.j.q.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey(getName());
    }

    @Override // b.f.j.q.BasePostprocessor
    public void process(Bitmap destBitmap, Bitmap sourceBitmap) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.process(destBitmap, sourceBitmap);
        if (destBitmap == null || sourceBitmap == null) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        new Canvas(destBitmap).drawBitmap(sourceBitmap, 0.0f, 0.0f, paint);
    }
}
