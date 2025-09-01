package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.t._Collections;
import d0.z.d.CollectionToArray;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers5;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LeastRecentlyAddedSet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B+\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u001bj\b\u0012\u0004\u0012\u00028\u0000`\u001c¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0004\b\u0011\u0010\u0006J\u001e\u0010\u0012\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0006J\u001e\u0010\u0019\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0001¢\u0006\u0004\b\u0019\u0010\rJ\u001e\u0010\u001a\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0001¢\u0006\u0004\b\u001a\u0010\rR&\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u001bj\b\u0012\u0004\u0012\u00028\u0000`\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0019\u0010 \u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u001f8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010#¨\u0006("}, d2 = {"Lcom/discord/utilities/collections/LeastRecentlyAddedSet;", ExifInterface.LONGITUDE_EAST, "", "element", "", "add", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "", "clear", "()V", "contains", "containsAll", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "remove", "removeAll", "retainAll", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "_set", "Ljava/util/LinkedHashSet;", "", "maxSize", "I", "getMaxSize", "()I", "getSize", "size", "<init>", "(ILjava/util/LinkedHashSet;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class LeastRecentlyAddedSet<E> implements Set<E>, KMarkers5 {
    private final LinkedHashSet<E> _set;
    private final int maxSize;

    public LeastRecentlyAddedSet() {
        this(0, null, 3, null);
    }

    public LeastRecentlyAddedSet(int i, LinkedHashSet<E> linkedHashSet) {
        Intrinsics3.checkNotNullParameter(linkedHashSet, "_set");
        this.maxSize = i;
        this._set = linkedHashSet;
    }

    @Override // java.util.Set, java.util.Collection
    public synchronized boolean add(E element) {
        boolean zRemove;
        zRemove = this._set.remove(element);
        Iterator<E> it = this._set.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "_set.iterator()");
        while (this._set.size() >= this.maxSize) {
            it.next();
            it.remove();
        }
        this._set.add(element);
        return !zRemove;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        return this._set.addAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this._set.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return this._set.contains(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        return this._set.containsAll(elements);
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public int getSize() {
        return this._set.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this._set.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it = this._set.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator(...)");
        return it;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        return this._set.remove(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        return this._set.removeAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        return this._set.retainAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        StringBuilder sbU = outline.U("LRA Set ");
        sbU.append(_Collections.toList(this._set));
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LeastRecentlyAddedSet(int i, LinkedHashSet linkedHashSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        i = (i2 & 1) != 0 ? 3 : i;
        this(i, (i2 & 2) != 0 ? new LinkedHashSet(i) : linkedHashSet);
    }
}
