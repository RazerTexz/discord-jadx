package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t._Collections;
import d0.z.d.CollectionToArray;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: ShallowPartitionCollection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0016\u0018\u0000 /*\u0004\b\u0000\u0010\u0001*\u0010\b\u0001\u0010\u0003 \u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001/B)\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010(\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0#¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u001d\u0010\u0015\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ\u001d\u0010\u0017\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0013J\u001d\u0010\u0018\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0#8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010(8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/discord/utilities/collections/ShallowPartitionCollection;", ExifInterface.LONGITUDE_EAST, "", ExifInterface.GPS_DIRECTION_TRUE, "key", "getPartition", "(Ljava/lang/Object;)Ljava/util/Collection;", "", "isEmpty", "()Z", "Lcom/discord/utilities/collections/MutablePartitionedIterator;", "iterator", "()Lcom/discord/utilities/collections/MutablePartitionedIterator;", "element", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "add", "addAll", "remove", "removeAll", "retainAll", "", "clear", "()V", "", "size", "I", "getSize", "()I", "setSize", "(I)V", "Lkotlin/Function1;", "partitionStrategy", "Lkotlin/jvm/functions/Function1;", "getPartitionStrategy", "()Lkotlin/jvm/functions/Function1;", "", "partitions", "Ljava/util/List;", "getPartitions", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class ShallowPartitionCollection<E, T extends Collection<E>> implements Collection<E>, KMarkers2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<E, Integer> partitionStrategy;
    private final List<T> partitions;
    private int size;

    /* compiled from: ShallowPartitionCollection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJO\u0010\n\u001a\u001e\u0012\u0004\u0012\u00028\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00020\bj\b\u0012\u0004\u0012\u00028\u0002`\t0\u0007\"\u0004\b\u0002\u0010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/collections/ShallowPartitionCollection$Companion;", "", ExifInterface.LONGITUDE_EAST, "", "numPartitions", "Lkotlin/Function1;", "partitionStrategy", "Lcom/discord/utilities/collections/ShallowPartitionCollection;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "withArrayListPartions", "(ILkotlin/jvm/functions/Function1;)Lcom/discord/utilities/collections/ShallowPartitionCollection;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ShallowPartitionCollection withArrayListPartions$default(Companion companion, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 40;
            }
            return companion.withArrayListPartions(i, function1);
        }

        public final <E> ShallowPartitionCollection<E, ArrayList<E>> withArrayListPartions(int numPartitions, Function1<? super E, Integer> partitionStrategy) {
            Intrinsics3.checkNotNullParameter(partitionStrategy, "partitionStrategy");
            Ranges2 ranges2Until = _Ranges.until(0, numPartitions);
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
            Iterator<Integer> it = ranges2Until.iterator();
            while (it.hasNext()) {
                ((Iterators4) it).nextInt();
                arrayList.add(new ArrayList());
            }
            return new ShallowPartitionCollection<>(arrayList, partitionStrategy);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShallowPartitionCollection(List<? extends T> list, Function1<? super E, Integer> function1) {
        Intrinsics3.checkNotNullParameter(list, "partitions");
        Intrinsics3.checkNotNullParameter(function1, "partitionStrategy");
        this.partitions = list;
        this.partitionStrategy = function1;
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        this.size = size;
    }

    private final T getPartition(E key) {
        return this.partitions.get(this.partitionStrategy.invoke(key).intValue());
    }

    public static final <E> ShallowPartitionCollection<E, ArrayList<E>> withArrayListPartions(int i, Function1<? super E, Integer> function1) {
        return INSTANCE.withArrayListPartions(i, function1);
    }

    @Override // java.util.Collection
    public boolean add(E element) {
        boolean zAdd = getPartition(element).add(element);
        if (zAdd) {
            setSize(size() + 1);
        }
        return zAdd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            while (it.hasNext()) {
                z2 = add(it.next()) || z2;
            }
            return z2;
        }
    }

    @Override // java.util.Collection
    public void clear() {
        Iterator<T> it = this.partitions.iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        setSize(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean contains(Object element) {
        return getPartition(element).contains(element);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics3.checkNotNullParameter(elements, "elements");
        Iterator<T> it = this.partitions.iterator();
        while (it.hasNext()) {
            elements = _Collections.minus((Iterable) elements, (Iterable) it.next());
        }
        return elements.isEmpty();
    }

    public final Function1<E, Integer> getPartitionStrategy() {
        return this.partitionStrategy;
    }

    public final List<T> getPartitions() {
        return this.partitions;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean remove(Object element) {
        boolean zRemove = getPartition(element).remove(element);
        if (zRemove) {
            setSize(size() - 1);
        }
        return zRemove;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            while (it.hasNext()) {
                z2 = remove(it.next()) || z2;
            }
            return z2;
        }
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(elements, "elements");
        Iterator<T> it = this.partitions.iterator();
        while (true) {
            while (it.hasNext()) {
                z2 = ((Collection) it.next()).retainAll(elements) || z2;
            }
            return z2;
        }
    }

    public void setSize(int i) {
        this.size = i;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public MutablePartitionedIterator<E> iterator() {
        return new MutablePartitionedIterator<>(this.partitions.iterator());
    }
}
