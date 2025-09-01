package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.collections.ShallowPartitionImmutableCollection;
import d0.a0.MathJVM;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: ShallowPartitionMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 =*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0002=>B5\u0012\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030+\u0012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f00¢\u0006\u0004\b:\u0010;B'\b\u0016\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f00¢\u0006\u0004\b:\u0010<J#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\f\u0010\nJ\u001a\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u00020\u00112\u0014\u0010\u0017\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010 \u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R(\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%0$8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000$8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R.\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030+8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R(\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f008\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R*\u00106\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001f8\u0016@TX\u0096\u000e¢\u0006\u0012\n\u0004\b6\u0010!\u001a\u0004\b7\u0010#\"\u0004\b8\u00109¨\u0006?"}, d2 = {"Lcom/discord/utilities/collections/ShallowPartitionMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", "getPartition", "(Ljava/lang/Object;)Ljava/util/Map;", "getPartitionForWrite", "", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "()Z", "", "clear", "()V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "from", "putAll", "(Ljava/util/Map;)V", "remove", "", "getValues", "()Ljava/util/Collection;", "values", "", "numPartitions", "I", "getNumPartitions", "()I", "", "", "getEntries", "()Ljava/util/Set;", "entries", "getKeys", "keys", "", "partitions", "Ljava/util/List;", "getPartitions", "()Ljava/util/List;", "Lkotlin/Function1;", "partitionStrategy", "Lkotlin/jvm/functions/Function1;", "getPartitionStrategy", "()Lkotlin/jvm/functions/Function1;", "<set-?>", "size", "getSize", "setSize", "(I)V", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "(ILkotlin/jvm/functions/Function1;)V", "Companion", "CopiablePartitionMap", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class ShallowPartitionMap<K, V> implements Map<K, V>, KMarkers4 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int numPartitions;
    private final Function1<K, Integer> partitionStrategy;
    private final List<Map<K, V>> partitions;
    private int size;

    /* compiled from: ShallowPartitionMap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00030\u0005\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007JW\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\r\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\b2\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/collections/ShallowPartitionMap$Companion;", "", "K", "", "numPartitions", "Lkotlin/Function1;", "getHashCodePartitionStrategy", "(I)Lkotlin/jvm/functions/Function1;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "mapSize", "partitionSize", "partitionCount", "partitionStrategy", "Lcom/discord/utilities/collections/ShallowPartitionMap;", "create", "(IIILkotlin/jvm/functions/Function1;)Lcom/discord/utilities/collections/ShallowPartitionMap;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShallowPartitionMap create$default(Companion companion, int i, int i2, int i3, Function1 function1, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i2 = 100;
            }
            if ((i4 & 4) != 0) {
                i3 = MathJVM.roundToInt((float) Math.ceil((i > 0 ? i : 1) / i2));
            }
            if ((i4 & 8) != 0) {
                function1 = companion.getHashCodePartitionStrategy(i3);
            }
            return companion.create(i, i2, i3, function1);
        }

        private final <K> Function1<K, Integer> getHashCodePartitionStrategy(int numPartitions) {
            return new ShallowPartitionMap2(numPartitions);
        }

        public final <K, V> ShallowPartitionMap<K, V> create(int mapSize, int partitionSize, int partitionCount, Function1<? super K, Integer> partitionStrategy) {
            Intrinsics3.checkNotNullParameter(partitionStrategy, "partitionStrategy");
            Ranges2 ranges2 = new Ranges2(0, partitionCount);
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2, 10));
            Iterator<Integer> it = ranges2.iterator();
            while (it.hasNext()) {
                ((Iterators4) it).nextInt();
                arrayList.add(new HashMap(partitionSize));
            }
            return new ShallowPartitionMap<>(arrayList, partitionStrategy);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ShallowPartitionMap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00190\u001e¢\u0006\u0004\b \u0010!J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00052\u0006\u0010\u0004\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ7\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u000b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u000bH\u0004¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010RN\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u000b2\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u000b8\u0004@DX\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/discord/utilities/collections/ShallowPartitionMap$CopiablePartitionMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/discord/utilities/collections/ShallowPartitionMap;", "key", "", "getPartitionForWrite", "(Ljava/lang/Object;)Ljava/util/Map;", "", "clear", "()V", "", "defensiveCopy", "(Ljava/util/List;)Ljava/util/List;", "", "fastCopy", "()Ljava/util/Map;", "value", "defensiveCopyPartitions", "Ljava/util/List;", "getDefensiveCopyPartitions", "()Ljava/util/List;", "setDefensiveCopyPartitions", "(Ljava/util/List;)V", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "dirtyPartitionIndices", "Ljava/util/HashSet;", "numPartitions", "Lkotlin/Function1;", "partitionStrategy", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static class CopiablePartitionMap<K, V> extends ShallowPartitionMap<K, V> {
        private List<? extends Map<K, V>> defensiveCopyPartitions;
        private final HashSet<Integer> dirtyPartitionIndices;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CopiablePartitionMap(int i, Function1<? super K, Integer> function1) {
            super(i, function1);
            Intrinsics3.checkNotNullParameter(function1, "partitionStrategy");
            this.dirtyPartitionIndices = _Collections.toHashSet(Collections2.getIndices(getPartitions()));
            this.defensiveCopyPartitions = defensiveCopy(getPartitions());
        }

        @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
        public void clear() {
            MutableCollections.addAll(this.dirtyPartitionIndices, Collections2.getIndices(getPartitions()));
            super.clear();
        }

        public final List<Map<K, V>> defensiveCopy(List<? extends Map<K, V>> list) {
            Intrinsics3.checkNotNullParameter(list, "$this$defensiveCopy");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                Object map = (Map) obj;
                if (this.dirtyPartitionIndices.contains(Integer.valueOf(i))) {
                    map = new HashMap(getPartitions().get(i));
                }
                arrayList.add(map);
                i = i2;
            }
            return arrayList;
        }

        public Map<K, V> fastCopy() {
            setDefensiveCopyPartitions(defensiveCopy(this.defensiveCopyPartitions));
            return new ShallowPartitionMap(this.defensiveCopyPartitions, getPartitionStrategy());
        }

        public final List<Map<K, V>> getDefensiveCopyPartitions() {
            return this.defensiveCopyPartitions;
        }

        @Override // com.discord.utilities.collections.ShallowPartitionMap
        public Map<K, V> getPartitionForWrite(K key) {
            int iIntValue = getPartitionStrategy().invoke(key).intValue();
            this.dirtyPartitionIndices.add(Integer.valueOf(iIntValue));
            return getPartitions().get(iIntValue);
        }

        public final void setDefensiveCopyPartitions(List<? extends Map<K, V>> list) {
            Intrinsics3.checkNotNullParameter(list, "value");
            this.defensiveCopyPartitions = list;
            this.dirtyPartitionIndices.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShallowPartitionMap(List<? extends Map<K, V>> list, Function1<? super K, Integer> function1) {
        Intrinsics3.checkNotNullParameter(list, "partitions");
        Intrinsics3.checkNotNullParameter(function1, "partitionStrategy");
        this.partitions = list;
        this.partitionStrategy = function1;
        this.numPartitions = list.size();
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Map) it.next()).size();
        }
        this.size = size;
    }

    private final Map<K, V> getPartition(K key) {
        return this.partitions.get(this.partitionStrategy.invoke(key).intValue());
    }

    @Override // java.util.Map
    public void clear() {
        Iterator<T> it = this.partitions.iterator();
        while (it.hasNext()) {
            ((Map) it.next()).clear();
        }
        setSize(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return getPartition(key).containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        List<Map<K, V>> list = this.partitions;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Map) it.next()).containsValue(value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object key) {
        return getPartition(key).get(key);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        List<Map<K, V>> list = this.partitions;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map) it.next()).entrySet());
        }
        return new ShallowPartitionImmutableCollection.Set(arrayList, new ShallowPartitionMap3(this));
    }

    public Set<K> getKeys() {
        List<Map<K, V>> list = this.partitions;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map) it.next()).keySet());
        }
        return new ShallowPartitionImmutableCollection.Set(arrayList, this.partitionStrategy);
    }

    public final int getNumPartitions() {
        return this.numPartitions;
    }

    public Map<K, V> getPartitionForWrite(K key) {
        return this.partitions.get(this.partitionStrategy.invoke(key).intValue());
    }

    public final Function1<K, Integer> getPartitionStrategy() {
        return this.partitionStrategy;
    }

    public final List<Map<K, V>> getPartitions() {
        return this.partitions;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        List<Map<K, V>> list = this.partitions;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map) it.next()).values());
        }
        return new ShallowPartitionImmutableCollection(arrayList, null, 2, null);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        V vPut = getPartitionForWrite(key).put(key, value);
        if (vPut == null) {
            setSize(size() + 1);
        }
        return vPut;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics3.checkNotNullParameter(from, "from");
        for (Map.Entry<? extends K, ? extends V> entry : from.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object key) {
        V vRemove = getPartitionForWrite(key).remove(key);
        if (vRemove == null) {
            return null;
        }
        setSize(size() - 1);
        return vRemove;
    }

    public void setSize(int i) {
        this.size = i;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public /* synthetic */ ShallowPartitionMap(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 200 : i, function1);
    }

    public ShallowPartitionMap(int i, Function1<? super K, Integer> function1) {
        Intrinsics3.checkNotNullParameter(function1, "partitionStrategy");
        Ranges2 ranges2Until = _Ranges.until(0, i);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
        Iterator<Integer> it = ranges2Until.iterator();
        while (it.hasNext()) {
            ((Iterators4) it).nextInt();
            arrayList.add(new HashMap());
        }
        this(arrayList, function1);
    }
}
