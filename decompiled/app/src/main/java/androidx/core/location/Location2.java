package androidx.core.location;

import android.location.Location;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Location.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/location/Location;", "", "component1", "(Landroid/location/Location;)D", "component2", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.location.LocationKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Location2 {
    public static final double component1(Location location) {
        Intrinsics3.checkNotNullParameter(location, "<this>");
        return location.getLatitude();
    }

    public static final double component2(Location location) {
        Intrinsics3.checkNotNullParameter(location, "<this>");
        return location.getLongitude();
    }
}
