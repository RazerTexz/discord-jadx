package b.f.m;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* compiled from: ApplicationSoSource.java */
/* renamed from: b.f.m.b, reason: use source file name */
/* loaded from: classes3.dex */
public class ApplicationSoSource extends SoSource {
    public Context a;

    /* renamed from: b, reason: collision with root package name */
    public int f652b;
    public DirectorySoSource c;

    public ApplicationSoSource(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        if (applicationContext == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.a = context;
        }
        this.f652b = i;
        this.c = new DirectorySoSource(new File(this.a.getApplicationInfo().nativeLibraryDir), i);
    }

    public static File d(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    @Override // b.f.m.SoSource
    public int a(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.c.a(str, i, threadPolicy);
    }

    @Override // b.f.m.SoSource
    public void b(int i) throws IOException {
        this.c.b(i);
    }

    public boolean c() throws IOException {
        File file = this.c.a;
        Context contextE = e();
        File fileD = d(contextE);
        if (file.equals(fileD)) {
            return false;
        }
        Log.d("SoLoader", "Native library directory updated from " + file + " to " + fileD);
        int i = this.f652b | 1;
        this.f652b = i;
        this.c = new DirectorySoSource(fileD, i);
        this.a = contextE;
        return true;
    }

    public Context e() {
        try {
            Context context = this.a;
            return context.createPackageContext(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // b.f.m.SoSource
    public String toString() {
        return this.c.toString();
    }
}
