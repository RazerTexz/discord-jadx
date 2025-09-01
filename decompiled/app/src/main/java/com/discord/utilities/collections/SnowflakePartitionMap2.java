package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SnowflakePartitionMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "it", "", "invoke", "(J)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.collections.SnowflakePartitionMap$Companion$PARTITION_SNOWFLAKE_ID_STRATEGY$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SnowflakePartitionMap2 extends Lambda implements Function1<Long, Integer> {
    public static final SnowflakePartitionMap2 INSTANCE = new SnowflakePartitionMap2();

    public SnowflakePartitionMap2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Long l) {
        return Integer.valueOf(invoke(l.longValue()));
    }

    public final int invoke(long j) {
        return (int) ((j >>> 22) % 256);
    }
}
