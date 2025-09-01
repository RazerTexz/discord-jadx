package b.i.a.f.e.o;

import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.RecentlyNullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public class g {
    public static String a;

    /* renamed from: b, reason: collision with root package name */
    public static int f1398b;

    @RecentlyNullable
    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        if (a == null) {
            if (f1398b == 0) {
                f1398b = Process.myPid();
            }
            int i = f1398b;
            String strTrim = null;
            strTrim = null;
            strTrim = null;
            BufferedReader bufferedReader2 = null;
            strTrim = null;
            try {
                if (i > 0) {
                    try {
                        StringBuilder sb = new StringBuilder(25);
                        sb.append("/proc/");
                        sb.append(i);
                        sb.append("/cmdline");
                        String string = sb.toString();
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(string));
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (IOException unused) {
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        String line = bufferedReader.readLine();
                        Objects.requireNonNull(line, "null reference");
                        strTrim = line.trim();
                        bufferedReader.close();
                    } catch (IOException unused2) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        a = strTrim;
                        return a;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException unused4) {
            }
            a = strTrim;
        }
        return a;
    }
}
