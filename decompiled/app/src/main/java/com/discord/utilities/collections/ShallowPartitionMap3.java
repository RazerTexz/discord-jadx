package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ShallowPartitionMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "it", "", "invoke", "(Ljava/util/Map$Entry;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.collections.ShallowPartitionMap$entries$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ShallowPartitionMap3<K, V> extends Lambda implements Function1<Map.Entry<K, V>, Integer> {
    public final /* synthetic */ ShallowPartitionMap this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShallowPartitionMap3(ShallowPartitionMap shallowPartitionMap) {
        super(1);
        this.this$0 = shallowPartitionMap;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return Integer.valueOf(invoke((Map.Entry) obj));
    }

    public final int invoke(Map.Entry<K, V> entry) {
        Intrinsics3.checkNotNullParameter(entry, "it");
        return this.this$0.getPartitionStrategy().invoke(entry.getKey()).intValue();
    }
}
