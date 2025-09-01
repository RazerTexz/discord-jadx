package b.i.b.b;

import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Maps.java */
/* renamed from: b.i.b.b.z, reason: use source file name */
/* loaded from: classes3.dex */
public class Maps5<K, V> extends AbstractCollection<V> {

    @Weak
    public final Map<K, V> j;

    public Maps5(Map<K, V> map) {
        this.j = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return this.j.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new Maps2(this.j.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map.Entry<K, V> entry : this.j.entrySet()) {
                if (b.i.a.f.e.o.f.V(obj, entry.getValue())) {
                    this.j.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            Objects.requireNonNull(collection);
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry<K, V> entry : this.j.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.j.keySet().removeAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        try {
            Objects.requireNonNull(collection);
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet hashSet = new HashSet();
            for (Map.Entry<K, V> entry : this.j.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.j.keySet().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.j.size();
    }
}
