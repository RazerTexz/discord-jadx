package b.f.j.q;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* compiled from: Postprocessor.java */
/* renamed from: b.f.j.q.b, reason: use source file name */
/* loaded from: classes3.dex */
public interface Postprocessor {
    String getName();

    CacheKey getPostprocessorCacheKey();

    CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory);
}
