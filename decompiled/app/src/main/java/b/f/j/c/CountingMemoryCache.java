package b.f.j.c;

import androidx.annotation.VisibleForTesting;
import b.f.d.g.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* compiled from: CountingMemoryCache.java */
/* renamed from: b.f.j.c.m, reason: use source file name */
/* loaded from: classes.dex */
public interface CountingMemoryCache<K, V> extends MemoryCache<K, V>, MemoryTrimmable {

    /* compiled from: CountingMemoryCache.java */
    @VisibleForTesting
    /* renamed from: b.f.j.c.m$a */
    public static class a<K, V> {
        public final K a;

        /* renamed from: b, reason: collision with root package name */
        public final CloseableReference<V> f558b;
        public int c;
        public boolean d;
        public final b<K> e;
        public int f;

        public a(K k, CloseableReference<V> closeableReference, b<K> bVar, int i) {
            Objects.requireNonNull(k);
            this.a = k;
            CloseableReference<V> closeableReferenceN = CloseableReference.n(closeableReference);
            Objects.requireNonNull(closeableReferenceN);
            this.f558b = closeableReferenceN;
            this.c = 0;
            this.d = false;
            this.e = bVar;
            this.f = i;
        }
    }

    /* compiled from: CountingMemoryCache.java */
    /* renamed from: b.f.j.c.m$b */
    public interface b<K> {
    }

    CloseableReference<V> b(K k);

    CloseableReference<V> c(K k, CloseableReference<V> closeableReference, b<K> bVar);
}
