package b.g.a.c.i0;

/* compiled from: LookupCache.java */
/* renamed from: b.g.a.c.i0.j, reason: use source file name */
/* loaded from: classes3.dex */
public interface LookupCache<K, V> {
    V get(Object obj);

    V putIfAbsent(K k, V v);
}
