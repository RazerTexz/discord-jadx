package b.i.a.f.i.b;

import androidx.annotation.WorkerThread;
import b.c.a.a0.AnimatableValueParser;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
@WorkerThread
/* loaded from: classes3.dex */
public final class c4 implements Runnable {
    public final URL j;
    public final byte[] k;
    public final z3 l;
    public final String m;
    public final Map<String, String> n;
    public final /* synthetic */ x3 o;

    public c4(x3 x3Var, String str, URL url, byte[] bArr, Map<String, String> map, z3 z3Var) {
        this.o = x3Var;
        AnimatableValueParser.w(str);
        this.j = url;
        this.k = bArr;
        this.l = z3Var;
        this.m = str;
        this.n = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnectionS;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        Throwable th;
        IOException iOException;
        int i;
        int i2;
        Map<String, List<String>> headerFields;
        this.o.a();
        OutputStream outputStream = null;
        try {
            httpURLConnectionS = this.o.s(this.j);
        } catch (IOException e) {
            e = e;
            httpURLConnectionS = null;
            map2 = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionS = null;
            map = null;
        }
        try {
            Map<String, String> map3 = this.n;
            if (map3 != null) {
                for (Map.Entry<String, String> entry : map3.entrySet()) {
                    httpURLConnectionS.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            if (this.k != null) {
                byte[] bArrT = this.o.m().T(this.k);
                this.o.g().n.b("Uploading data. size", Integer.valueOf(bArrT.length));
                httpURLConnectionS.setDoOutput(true);
                httpURLConnectionS.addRequestProperty("Content-Encoding", "gzip");
                httpURLConnectionS.setFixedLengthStreamingMode(bArrT.length);
                httpURLConnectionS.connect();
                OutputStream outputStream2 = httpURLConnectionS.getOutputStream();
                try {
                    outputStream2.write(bArrT);
                    outputStream2.close();
                } catch (IOException e2) {
                    map2 = null;
                    iOException = e2;
                    outputStream = outputStream2;
                    i2 = 0;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            this.o.g().f.c("Error closing HTTP compressed POST connection output stream. appId", q3.s(this.m), e3);
                        }
                    }
                    if (httpURLConnectionS != null) {
                        httpURLConnectionS.disconnect();
                    }
                    this.o.f().v(new y3(this.m, this.l, i2, iOException, null, map2, null));
                } catch (Throwable th3) {
                    map = null;
                    th = th3;
                    outputStream = outputStream2;
                    i = 0;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            this.o.g().f.c("Error closing HTTP compressed POST connection output stream. appId", q3.s(this.m), e4);
                        }
                    }
                    if (httpURLConnectionS != null) {
                        httpURLConnectionS.disconnect();
                    }
                    this.o.f().v(new y3(this.m, this.l, i, null, null, map, null));
                    throw th;
                }
            }
            int responseCode = httpURLConnectionS.getResponseCode();
            try {
                headerFields = httpURLConnectionS.getHeaderFields();
            } catch (IOException e5) {
                e = e5;
                map2 = null;
                i2 = responseCode;
            } catch (Throwable th4) {
                map = null;
                th = th4;
                i = responseCode;
            }
            try {
                byte[] bArrT2 = x3.t(httpURLConnectionS);
                httpURLConnectionS.disconnect();
                this.o.f().v(new y3(this.m, this.l, responseCode, null, bArrT2, headerFields, null));
            } catch (IOException e6) {
                e = e6;
                i2 = responseCode;
                map2 = headerFields;
                iOException = e;
                if (outputStream != null) {
                }
                if (httpURLConnectionS != null) {
                }
                this.o.f().v(new y3(this.m, this.l, i2, iOException, null, map2, null));
            } catch (Throwable th5) {
                th = th5;
                i = responseCode;
                map = headerFields;
                if (outputStream != null) {
                }
                if (httpURLConnectionS != null) {
                }
                this.o.f().v(new y3(this.m, this.l, i, null, null, map, null));
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            map2 = null;
            iOException = e;
            i2 = 0;
            if (outputStream != null) {
            }
            if (httpURLConnectionS != null) {
            }
            this.o.f().v(new y3(this.m, this.l, i2, iOException, null, map2, null));
        } catch (Throwable th6) {
            th = th6;
            map = null;
            th = th;
            i = 0;
            if (outputStream != null) {
            }
            if (httpURLConnectionS != null) {
            }
            this.o.f().v(new y3(this.m, this.l, i, null, null, map, null));
            throw th;
        }
    }
}
