package b.i.c.u.o;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.FirebaseApp2;
import b.i.c.u.o.AutoValue_PersistedInstallationEntry;
import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PersistedInstallation.java */
/* renamed from: b.i.c.u.o.c, reason: use source file name */
/* loaded from: classes3.dex */
public class PersistedInstallation {
    public final File a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FirebaseApp2 f1787b;

    /* compiled from: PersistedInstallation.java */
    /* renamed from: b.i.c.u.o.c$a */
    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(@NonNull FirebaseApp2 firebaseApp2) {
        firebaseApp2.a();
        File filesDir = firebaseApp2.d.getFilesDir();
        StringBuilder sbU = outline.U("PersistedInstallation.");
        sbU.append(firebaseApp2.c());
        sbU.append(".json");
        this.a = new File(filesDir, sbU.toString());
        this.f1787b = firebaseApp2;
    }

    @NonNull
    public PersistedInstallationEntry a(@NonNull PersistedInstallationEntry persistedInstallationEntry) throws JSONException, IOException {
        File fileCreateTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", persistedInstallationEntry.c());
            jSONObject.put("Status", persistedInstallationEntry.f().ordinal());
            jSONObject.put("AuthToken", persistedInstallationEntry.a());
            jSONObject.put("RefreshToken", persistedInstallationEntry.e());
            jSONObject.put("TokenCreationEpochInSecs", persistedInstallationEntry.g());
            jSONObject.put("ExpiresInSecs", persistedInstallationEntry.b());
            jSONObject.put("FisError", persistedInstallationEntry.d());
            FirebaseApp2 firebaseApp2 = this.f1787b;
            firebaseApp2.a();
            fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", firebaseApp2.d.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(Constants.ENCODING));
            fileOutputStream.close();
        } catch (IOException | JSONException unused) {
        }
        if (fileCreateTempFile.renameTo(this.a)) {
            return persistedInstallationEntry;
        }
        throw new IOException("unable to rename the tmpfile to PersistedInstallation");
    }

    @NonNull
    public PersistedInstallationEntry b() throws IOException {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(this.a);
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 16384);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused2) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        a aVar = a.ATTEMPT_MIGRATION;
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i2 = PersistedInstallationEntry.a;
        AutoValue_PersistedInstallationEntry.b bVar = new AutoValue_PersistedInstallationEntry.b();
        bVar.d(0L);
        bVar.b(aVar);
        bVar.c(0L);
        bVar.a = strOptString;
        bVar.b(a.values()[iOptInt]);
        bVar.c = strOptString2;
        bVar.d = strOptString3;
        bVar.d(jOptLong);
        bVar.c(jOptLong2);
        bVar.g = strOptString4;
        return bVar.a();
    }
}
