package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: CollectionExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a7\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\n¢\u0006\u0004\b\f\u0010\r\u001aY\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0013\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "collection", "Lkotlin/Function2;", "", "comparator", "equals", "(Ljava/util/Collection;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Z", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "filterNonNullValues", "(Ljava/util/Map;)Ljava/util/Map;", "", "initialCapacity", "", "loadFactor", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "snapshot", "(Ljava/util/Map;IF)Ljava/util/HashMap;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.collections.CollectionExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class CollectionExtensions {
    public static final <T> boolean equals(Collection<? extends T> collection, Collection<? extends T> collection2, Function2<? super T, ? super T, Boolean> function2) {
        Intrinsics3.checkNotNullParameter(collection, "$this$equals");
        Intrinsics3.checkNotNullParameter(collection2, "collection");
        Intrinsics3.checkNotNullParameter(function2, "comparator");
        if (collection.size() != collection2.size()) {
            return false;
        }
        int i = 0;
        for (Object obj : collection) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            if (!function2.invoke(obj, (Object) _Collections.elementAt(collection2, i)).booleanValue()) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> filterNonNullValues(Map<K, ? extends V> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$filterNonNullValues");
        HashMap map2 = new HashMap(map.size());
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                map2.put(key, value);
            }
        }
        return map2;
    }

    public static final <K, V> HashMap<K, V> snapshot(Map<K, ? extends V> map, int i, float f) {
        Intrinsics3.checkNotNullParameter(map, "$this$snapshot");
        HashMap<K, V> map2 = new HashMap<>(i, f);
        map2.putAll(map);
        return map2;
    }

    public static /* synthetic */ HashMap snapshot$default(Map map, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = _Ranges.coerceAtLeast(map.size(), 1);
        }
        if ((i2 & 2) != 0) {
            f = 0.75f;
        }
        return snapshot(map, i, f);
    }
}
