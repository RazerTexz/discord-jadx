package b.i.a.c.e3.b0;

import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Comparator {
    public static final /* synthetic */ b j = new b();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        CacheSpan cacheSpan = (CacheSpan) obj;
        CacheSpan cacheSpan2 = (CacheSpan) obj2;
        long j2 = cacheSpan.o;
        long j3 = cacheSpan2.o;
        return j2 - j3 == 0 ? cacheSpan.f(cacheSpan2) : j2 < j3 ? -1 : 1;
    }
}
