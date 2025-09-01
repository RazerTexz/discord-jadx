package b.c.a.y;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import b.c.a.LottieComposition;

/* compiled from: LottieCompositionCache.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: b.c.a.y.h, reason: use source file name */
/* loaded from: classes.dex */
public class LottieCompositionCache {
    public static final LottieCompositionCache a = new LottieCompositionCache();

    /* renamed from: b, reason: collision with root package name */
    public final LruCache<String, LottieComposition> f409b = new LruCache<>(20);

    @VisibleForTesting
    public LottieCompositionCache() {
    }
}
