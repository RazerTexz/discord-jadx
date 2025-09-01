package b.i.c.j.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import b.i.a.f.h.l.b0;
import b.i.a.f.h.l.g;
import b.i.c.j.a.a;
import b.i.c.j.a.c.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* loaded from: classes3.dex */
public class b implements b.i.c.j.a.a {
    public static volatile b.i.c.j.a.a a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.a.f.i.a.a f1656b;
    public final Map<String, ?> c;

    /* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
    public class a implements a.InterfaceC0046a {
        public a(b bVar, String str) {
        }
    }

    public b(b.i.a.f.i.a.a aVar) {
        Objects.requireNonNull(aVar, "null reference");
        this.f1656b = aVar;
        this.c = new ConcurrentHashMap();
    }

    @Override // b.i.c.j.a.a
    public void a(@NonNull String str, @NonNull String str2, Bundle bundle) {
        boolean z2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (c.a(str)) {
            boolean z3 = false;
            if (c.f1658b.contains(str2)) {
                z2 = false;
                break;
            }
            Iterator<String> it = c.d.iterator();
            while (it.hasNext()) {
                if (bundle2.containsKey(it.next())) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            if (z2) {
                if (!"_cmp".equals(str2)) {
                    z3 = true;
                } else if (c.a(str)) {
                    Iterator<String> it2 = c.d.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            char c = 65535;
                            int iHashCode = str.hashCode();
                            if (iHashCode != 101200) {
                                if (iHashCode != 101230) {
                                    if (iHashCode == 3142703 && str.equals("fiam")) {
                                        c = 2;
                                    }
                                } else if (str.equals("fdl")) {
                                    c = 1;
                                }
                            } else if (str.equals("fcm")) {
                                c = 0;
                            }
                            if (c == 0) {
                                bundle2.putString("_cis", "fcm_integration");
                            } else if (c == 1) {
                                bundle2.putString("_cis", "fdl_integration");
                            } else if (c == 2) {
                                bundle2.putString("_cis", "fiam_integration");
                            }
                        } else if (bundle2.containsKey(it2.next())) {
                            break;
                        }
                    }
                }
                if (z3) {
                    if ("clx".equals(str) && "_ae".equals(str2)) {
                        bundle2.putLong("_r", 1L);
                    }
                    this.f1656b.a.c(str, str2, bundle2, true, true, null);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    @Override // b.i.c.j.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(@NonNull String str, @NonNull String str2, Object obj) {
        if (c.a(str)) {
            boolean z2 = true;
            if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
                if (!str.equals("fcm") && !str.equals("frc")) {
                    z2 = false;
                    break;
                }
            } else if ("_ln".equals(str2)) {
                if (!str.equals("fcm") && !str.equals("fiam")) {
                }
            } else if (!c.e.contains(str2)) {
                Iterator<String> it = c.f.iterator();
                while (it.hasNext()) {
                    if (str2.matches(it.next())) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                g gVar = this.f1656b.a;
                Objects.requireNonNull(gVar);
                gVar.e.execute(new b0(gVar, str, str2, obj, true));
            }
        }
    }

    @Override // b.i.c.j.a.a
    @WorkerThread
    public a.InterfaceC0046a c(@NonNull String str, a.b bVar) {
        Objects.requireNonNull(bVar, "null reference");
        if (!c.a(str)) {
            return null;
        }
        if ((str.isEmpty() || !this.c.containsKey(str) || this.c.get(str) == null) ? false : true) {
            return null;
        }
        b.i.a.f.i.a.a aVar = this.f1656b;
        Object bVar2 = "fiam".equals(str) ? new b.i.c.j.a.c.b(aVar, bVar) : ("crash".equals(str) || "clx".equals(str)) ? new b.i.c.j.a.c.d(aVar, bVar) : null;
        if (bVar2 == null) {
            return null;
        }
        this.c.put(str, bVar2);
        return new a(this, str);
    }
}
