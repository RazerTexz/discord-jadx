package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.collections.ShallowPartitionMap;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* compiled from: SnowflakePartitionMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\f\rB!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/collections/SnowflakePartitionMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/discord/utilities/collections/ShallowPartitionMap;", "", "", "", "partitions", "<init>", "(Ljava/util/List;)V", "", "numPartitions", "(I)V", "Companion", "CopiablePartitionMap", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SnowflakePartitionMap<V> extends ShallowPartitionMap<Long, V> {
    private static final int PARTITION_SIZE = 256;
    private static final Function1<Long, Integer> PARTITION_SNOWFLAKE_ID_STRATEGY = SnowflakePartitionMap2.INSTANCE;

    /* compiled from: SnowflakePartitionMap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/collections/SnowflakePartitionMap$CopiablePartitionMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/discord/utilities/collections/ShallowPartitionMap$CopiablePartitionMap;", "", "", "fastCopy", "()Ljava/util/Map;", "", "numPartitions", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class CopiablePartitionMap<V> extends ShallowPartitionMap.CopiablePartitionMap<Long, V> {
        public CopiablePartitionMap() {
            this(0, 1, null);
        }

        public /* synthetic */ CopiablePartitionMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 256 : i);
        }

        public /* bridge */ boolean containsKey(long j) {
            return super.containsKey(Long.valueOf(j));
        }

        @Override // com.discord.utilities.collections.ShallowPartitionMap.CopiablePartitionMap
        public Map<Long, V> fastCopy() {
            setDefensiveCopyPartitions(defensiveCopy(getDefensiveCopyPartitions()));
            return new SnowflakePartitionMap(getDefensiveCopyPartitions());
        }

        public /* bridge */ Object get(long j) {
            return super.get(Long.valueOf(j));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ Object getOrDefault(long j, Object obj) {
            return super.getOrDefault((Object) Long.valueOf(j), (Long) obj);
        }

        public /* bridge */ Object remove(long j) {
            return super.remove(Long.valueOf(j));
        }

        public CopiablePartitionMap(int i) {
            super(i, SnowflakePartitionMap.access$getPARTITION_SNOWFLAKE_ID_STRATEGY$cp());
        }

        @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Long) {
                return containsKey(((Number) obj).longValue());
            }
            return false;
        }

        @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
        public final /* bridge */ V get(Object obj) {
            if (obj instanceof Long) {
                return (V) get(((Number) obj).longValue());
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return obj instanceof Long ? getOrDefault(((Number) obj).longValue(), obj2) : obj2;
        }

        @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
        public final /* bridge */ V remove(Object obj) {
            if (obj instanceof Long) {
                return (V) remove(((Number) obj).longValue());
            }
            return null;
        }

        public /* bridge */ boolean remove(long j, Object obj) {
            return super.remove(Long.valueOf(j), obj);
        }

        @Override // java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (obj instanceof Long) {
                return remove(((Number) obj).longValue(), obj2);
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnowflakePartitionMap(List<? extends Map<Long, V>> list) {
        super(list, PARTITION_SNOWFLAKE_ID_STRATEGY);
        Intrinsics3.checkNotNullParameter(list, "partitions");
    }

    public static final /* synthetic */ Function1 access$getPARTITION_SNOWFLAKE_ID_STRATEGY$cp() {
        return PARTITION_SNOWFLAKE_ID_STRATEGY;
    }

    public /* bridge */ boolean containsKey(long j) {
        return super.containsKey(Long.valueOf(j));
    }

    public /* bridge */ Object get(long j) {
        return super.get(Long.valueOf(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ Object getOrDefault(long j, Object obj) {
        return super.getOrDefault((Object) Long.valueOf(j), (Long) obj);
    }

    public /* bridge */ Object remove(long j) {
        return super.remove(Long.valueOf(j));
    }

    public SnowflakePartitionMap(int i) {
        Ranges2 ranges2Until = _Ranges.until(0, i);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
        Iterator<Integer> it = ranges2Until.iterator();
        while (it.hasNext()) {
            ((Iterators4) it).nextInt();
            arrayList.add(new HashMap());
        }
        this(arrayList);
    }

    @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof Long) {
            return containsKey(((Number) obj).longValue());
        }
        return false;
    }

    @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
    public final /* bridge */ V get(Object obj) {
        if (obj instanceof Long) {
            return (V) get(((Number) obj).longValue());
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return obj instanceof Long ? getOrDefault(((Number) obj).longValue(), obj2) : obj2;
    }

    @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
    public final /* bridge */ V remove(Object obj) {
        if (obj instanceof Long) {
            return (V) remove(((Number) obj).longValue());
        }
        return null;
    }

    public /* bridge */ boolean remove(long j, Object obj) {
        return super.remove(Long.valueOf(j), obj);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (obj instanceof Long) {
            return remove(((Number) obj).longValue(), obj2);
        }
        return false;
    }
}
