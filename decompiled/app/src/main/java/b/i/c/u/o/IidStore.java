package b.i.c.u.o;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.FirebaseApp2;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: IidStore.java */
/* renamed from: b.i.c.u.o.b, reason: use source file name */
/* loaded from: classes3.dex */
public class IidStore {
    public static final String[] a = {"*", "FCM", "GCM", ""};

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("iidPrefs")
    public final SharedPreferences f1786b;
    public final String c;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IidStore(@NonNull FirebaseApp2 firebaseApp2) {
        firebaseApp2.a();
        this.f1786b = firebaseApp2.d.getSharedPreferences("com.google.android.gms.appid", 0);
        firebaseApp2.a();
        String str = firebaseApp2.f.e;
        if (str == null) {
            firebaseApp2.a();
            str = firebaseApp2.f.f1655b;
            if (str.startsWith("1:") || str.startsWith("2:")) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length != 4) {
                    str = null;
                } else {
                    str = strArrSplit[1];
                    if (str.isEmpty()) {
                    }
                }
            }
        }
        this.c = str;
    }

    @Nullable
    public final String a() {
        PublicKey publicKeyGeneratePublic;
        synchronized (this.f1786b) {
            String strEncodeToString = null;
            String string = this.f1786b.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            try {
                publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 8)));
            } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                Log.w("ContentValues", "Invalid key stored " + e);
                publicKeyGeneratePublic = null;
            }
            if (publicKeyGeneratePublic == null) {
                return null;
            }
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(publicKeyGeneratePublic.getEncoded());
                bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & 255);
                strEncodeToString = Base64.encodeToString(bArrDigest, 0, 8, 11);
            } catch (NoSuchAlgorithmException unused) {
                Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            }
            return strEncodeToString;
        }
    }
}
