package b.i.a.f.h.l;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class y1 implements b2 {

    @GuardedBy("ConfigurationContentLoader.class")
    public static final Map<Uri, y1> a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f1503b = {"key", "value"};
    public final ContentResolver c;
    public final Uri d;
    public final ContentObserver e;
    public final Object f;
    public volatile Map<String, String> g;

    @GuardedBy("this")
    public final List<z1> h;

    public y1(ContentResolver contentResolver, Uri uri) {
        a2 a2Var = new a2(this);
        this.e = a2Var;
        this.f = new Object();
        this.h = new ArrayList();
        Objects.requireNonNull(contentResolver);
        Objects.requireNonNull(uri);
        this.c = contentResolver;
        this.d = uri;
        contentResolver.registerContentObserver(uri, false, a2Var);
    }

    public static y1 a(ContentResolver contentResolver, Uri uri) {
        y1 y1Var;
        synchronized (y1.class) {
            Map<Uri, y1> map = a;
            y1Var = map.get(uri);
            if (y1Var == null) {
                try {
                    y1 y1Var2 = new y1(contentResolver, uri);
                    try {
                        map.put(uri, y1Var2);
                    } catch (SecurityException unused) {
                    }
                    y1Var = y1Var2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return y1Var;
    }

    public static synchronized void c() {
        for (y1 y1Var : a.values()) {
            y1Var.c.unregisterContentObserver(y1Var.e);
        }
        a.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, String> b() {
        Map<String, String> map;
        Map<String, String> map2;
        Map<String, String> map3 = this.g;
        Map<String, String> map4 = map3;
        if (map3 == null) {
            synchronized (this.f) {
                Map<String, String> map5 = this.g;
                map = map5;
                if (map5 == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map2 = (Map) b.i.a.f.e.o.f.T1(new x1(this));
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                        Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        map2 = null;
                    }
                    this.g = map2;
                    threadPolicyAllowThreadDiskReads = map2;
                    map = threadPolicyAllowThreadDiskReads;
                }
            }
            map4 = map;
        }
        return map4 != null ? map4 : Collections.emptyMap();
    }

    @Override // b.i.a.f.h.l.b2
    public final /* synthetic */ Object g(String str) {
        return b().get(str);
    }
}
