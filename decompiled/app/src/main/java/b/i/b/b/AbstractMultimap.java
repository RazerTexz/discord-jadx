package b.i.b.b;

import b.i.b.b.AbstractMapBasedMultimap2;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractMultimap.java */
/* renamed from: b.i.b.b.g, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractMultimap<K, V> implements Multimap<K, V> {

    @MonotonicNonNullDecl
    public transient Set<K> j;

    @MonotonicNonNullDecl
    public transient Collection<V> k;

    @MonotonicNonNullDecl
    public transient Map<K, Collection<V>> l;

    /* compiled from: AbstractMultimap.java */
    /* renamed from: b.i.b.b.g$a */
    public class a extends AbstractCollection<V> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ((AbstractMapBasedMultimap2) AbstractMultimap.this).d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            Iterator<Collection<V>> it = AbstractMultimap.this.a().values().iterator();
            while (it.hasNext()) {
                if (it.next().contains(obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = (AbstractMapBasedMultimap2) AbstractMultimap.this;
            Objects.requireNonNull(abstractMapBasedMultimap2);
            return new AbstractMapBasedMultimap(abstractMapBasedMultimap2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ((AbstractMapBasedMultimap2) AbstractMultimap.this).n;
        }
    }

    @Override // b.i.b.b.Multimap
    public Map<K, Collection<V>> a() {
        Map<K, Collection<V>> dVar = this.l;
        if (dVar == null) {
            Multimaps multimaps = (Multimaps) this;
            Map<K, Collection<V>> map = multimaps.m;
            dVar = map instanceof NavigableMap ? new AbstractMapBasedMultimap2.d((NavigableMap) multimaps.m) : map instanceof SortedMap ? new AbstractMapBasedMultimap2.g((SortedMap) multimaps.m) : new AbstractMapBasedMultimap2.a(multimaps.m);
            this.l = dVar;
        }
        return dVar;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Multimap) {
            return ((AbstractListMultimap) this).a().equals(((Multimap) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
