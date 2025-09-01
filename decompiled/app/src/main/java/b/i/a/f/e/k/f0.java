package b.i.a.f.e.k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public final class f0 {
    public static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f1386b;

    @Nullable
    public static String c;
    public static int d;

    public static void a(Context context) {
        Bundle bundle;
        synchronized (a) {
            if (f1386b) {
                return;
            }
            f1386b = true;
            try {
                bundle = b.i.a.f.e.p.b.a(context).a(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            c = bundle.getString("com.google.app.id");
            d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
