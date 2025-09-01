package b.i.c.w;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import b.i.c.FirebaseApp2;
import b.i.c.p.DataEncoder;
import b.i.c.p.h.JsonDataEncoderBuilder4;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import b.i.c.w.m;
import com.google.firebase.messaging.FirebaseMessagingService;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* loaded from: classes3.dex */
public class q {
    public static final DataEncoder a;

    static {
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = new JsonDataEncoderBuilder5();
        jsonDataEncoderBuilder5.f1761b.put(m.b.class, new m.c());
        jsonDataEncoderBuilder5.c.remove(m.b.class);
        jsonDataEncoderBuilder5.f1761b.put(m.class, new m.a());
        jsonDataEncoderBuilder5.c.remove(m.class);
        a = new JsonDataEncoderBuilder4(jsonDataEncoderBuilder5);
    }

    @Nullable
    public static String a(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    @VisibleForTesting
    public static void b(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString("label", stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra4)) {
            bundle.putString("message_channel", stringExtra4);
        }
        String strA = a(intent);
        if (strA != null) {
            bundle.putString("_nt", strA);
        }
        String stringExtra5 = intent.getStringExtra("google.c.a.ts");
        if (stringExtra5 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(stringExtra5));
            } catch (NumberFormatException e) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
            }
        }
        String stringExtra6 = intent.hasExtra("google.c.a.udt") ? intent.getStringExtra("google.c.a.udt") : null;
        if (stringExtra6 != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(stringExtra6));
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
            }
        }
        String str2 = (intent.getExtras() == null || !r.f(intent.getExtras())) ? "data" : "display";
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", str2);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String strValueOf = String.valueOf(bundle);
            Log.d("FirebaseMessaging", outline.l(strValueOf.length() + str.length() + 37, "Logging to scion event=", str, " scionPayload=", strValueOf));
        }
        FirebaseApp2 firebaseApp2B = FirebaseApp2.b();
        firebaseApp2B.a();
        b.i.c.j.a.a aVar = (b.i.c.j.a.a) firebaseApp2B.g.a(b.i.c.j.a.a.class);
        if (aVar != null) {
            aVar.a("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    public static boolean c(Intent intent) {
        if (intent == null || FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction())) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }
}
