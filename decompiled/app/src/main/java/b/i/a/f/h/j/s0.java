package b.i.a.f.h.j;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class s0 {
    public static Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static b.i.a.f.m.a f1426b;
    public static Boolean c;

    public static boolean a(Context context) throws PackageManager.NameNotFoundException {
        Objects.requireNonNull(context, "null reference");
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zA = z0.a(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        c = Boolean.valueOf(zA);
        return zA;
    }
}
