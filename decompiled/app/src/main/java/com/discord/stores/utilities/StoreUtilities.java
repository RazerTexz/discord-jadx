package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreUtilities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aw\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "snapshot", "", "dirtyKeys", "Lkotlin/Function2;", "snapshotDirtyValue", "snapshotDirtyKeys", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.stores.utilities.StoreUtilitiesKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreUtilities {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> snapshotDirtyKeys(Map<K, ? extends V> map, Map<K, ? extends V> map2, Set<K> set, Function2<? super K, ? super V, ? extends V> function2) {
        Intrinsics3.checkNotNullParameter(map, "$this$snapshotDirtyKeys");
        Intrinsics3.checkNotNullParameter(map2, "snapshot");
        Intrinsics3.checkNotNullParameter(set, "dirtyKeys");
        Intrinsics3.checkNotNullParameter(function2, "snapshotDirtyValue");
        if (!(!set.isEmpty())) {
            return map2;
        }
        HashMap map3 = new HashMap(map.size());
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            Object key = entry.getKey();
            V value = entry.getValue();
            if (set.contains(key)) {
                map3.put(key, function2.invoke(key, value));
            } else {
                Object obj = map2.get(key);
                if (obj != null) {
                    map3.put(key, obj);
                }
            }
        }
        return map3;
    }
}
