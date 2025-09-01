package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: ShallowPartitionMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0000\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "key", "", "invoke", "(Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.collections.ShallowPartitionMap$Companion$getHashCodePartitionStrategy$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ShallowPartitionMap2<K> extends Lambda implements Function1<K, Integer> {
    public final /* synthetic */ int $numPartitions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShallowPartitionMap2(int i) {
        super(1);
        this.$numPartitions = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke2((ShallowPartitionMap2<K>) obj));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(K k) {
        int iHashCode = k != null ? k.hashCode() : 0;
        return Math.abs(iHashCode ^ (iHashCode >>> 16)) % this.$numPartitions;
    }
}
