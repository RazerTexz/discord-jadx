package d0.t;

import d0.z.d.g0.KMarkers;
import java.util.Map;

/* compiled from: MapWithDefault.kt */
/* renamed from: d0.t.e0, reason: use source file name */
/* loaded from: classes3.dex */
public interface MapWithDefault<K, V> extends Map<K, V>, KMarkers {
    V getOrImplicitDefault(K k);
}
