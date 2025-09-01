package b.i.c.m.d.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_FilesPayload_File;
import b.i.c.m.d.m.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

/* compiled from: FileBackedNativeSessionFile.java */
/* renamed from: b.i.c.m.d.k.u0, reason: use source file name */
/* loaded from: classes3.dex */
public class FileBackedNativeSessionFile implements NativeSessionFile {

    @NonNull
    public final File a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final String f1696b;

    @NonNull
    public final String c;

    public FileBackedNativeSessionFile(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.f1696b = str;
        this.c = str2;
        this.a = file;
    }

    @Override // b.i.c.m.d.k.NativeSessionFile
    @NonNull
    public String a() {
        return this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075 A[ORIG_RETURN, RETURN] */
    @Override // b.i.c.m.d.k.NativeSessionFile
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CrashlyticsReport.c.a b() throws IOException {
        byte[] byteArray;
        InputStream inputStreamH;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr = new byte[8192];
        try {
            inputStreamH = h();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (inputStreamH != null) {
                    try {
                        inputStreamH.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (IOException unused3) {
        }
        if (inputStreamH == null) {
            byteArrayOutputStream.close();
            if (inputStreamH != null) {
                inputStreamH.close();
            }
            byteArray = null;
            if (byteArray != null) {
                return null;
            }
            Objects.requireNonNull(byteArray, "Null contents");
            String str = this.f1696b;
            Objects.requireNonNull(str, "Null filename");
            if (1 != 0) {
                return new AutoValue_CrashlyticsReport_FilesPayload_File(str, byteArray, null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", ""));
        }
        while (true) {
            try {
                int i = inputStreamH.read(bArr);
                if (i <= 0) {
                    break;
                }
                gZIPOutputStream.write(bArr, 0, i);
            } finally {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable unused4) {
                }
            }
        }
        gZIPOutputStream.finish();
        byteArray = byteArrayOutputStream.toByteArray();
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        inputStreamH.close();
        if (byteArray != null) {
        }
    }

    @Override // b.i.c.m.d.k.NativeSessionFile
    @Nullable
    public InputStream h() {
        if (this.a.exists() && this.a.isFile()) {
            try {
                return new FileInputStream(this.a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
