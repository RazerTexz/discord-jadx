package b.i.b.b;

import b.i.b.b.AbstractMapBasedMultimap2;
import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractListMultimap.java */
/* renamed from: b.i.b.b.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap2<K, V> implements Multimap {
    private static final long serialVersionUID = 6588350623831699109L;

    public AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // b.i.b.b.AbstractMultimap, b.i.b.b.Multimap
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

    @Override // b.i.b.b.AbstractMultimap
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }
}
