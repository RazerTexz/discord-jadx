package b.i.a.f.h.l;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;
import org.objectweb.asm.Opcodes;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class j2 {
    public static volatile x2<Boolean> a = w2.j;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f1451b = new Object();

    public static boolean a(Context context, Uri uri) {
        ProviderInfo providerInfoResolveContentProvider;
        String authority = uri.getAuthority();
        boolean z2 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb.toString());
            return false;
        }
        if (a.b()) {
            return a.c().booleanValue();
        }
        synchronized (f1451b) {
            if (a.b()) {
                return a.c().booleanValue();
            }
            if ("com.google.android.gms".equals(context.getPackageName()) || ((providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0)) != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName))) {
                boolean z3 = (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & Opcodes.LOR) != 0;
                if (z3) {
                    z2 = true;
                }
            }
            a = x2.a(Boolean.valueOf(z2));
            return a.c().booleanValue();
        }
    }
}
