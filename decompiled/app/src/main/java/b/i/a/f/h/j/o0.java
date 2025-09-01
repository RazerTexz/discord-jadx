package b.i.a.f.h.j;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public final class o0 extends e {
    public static final byte[] l = "\n".getBytes();
    public final String m;
    public final y0 n;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public o0(g gVar) {
        String string;
        super(gVar);
        String str = f.a;
        String str2 = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        if (locale == null) {
            string = null;
        } else {
            String language = locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                StringBuilder sb = new StringBuilder();
                sb.append(language.toLowerCase(locale));
                if (!TextUtils.isEmpty(locale.getCountry())) {
                    sb.append("-");
                    sb.append(locale.getCountry().toLowerCase(locale));
                }
                string = sb.toString();
            }
        }
        this.m = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", str, str2, string, Build.MODEL, Build.ID);
        this.n = new y0(gVar.d);
    }

    public static void S(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, Constants.ENCODING));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, Constants.ENCODING));
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
        b("Network initialized. User agent", this.m);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int O(URL url, byte[] bArr) throws Throwable {
        HttpURLConnection httpURLConnection;
        IOException e;
        HttpURLConnection httpURLConnectionU;
        Objects.requireNonNull(bArr, "null reference");
        a(3, "POST bytes, url", Integer.valueOf(bArr.length), url, null);
        if (Log.isLoggable(e0.f1411b.a, 2)) {
            b("Post payload\n", new String(bArr));
        }
        OutputStream outputStream = null;
        try {
            this.j.f1417b.getPackageName();
            httpURLConnectionU = U(url);
            try {
                try {
                    httpURLConnectionU.setDoOutput(true);
                    httpURLConnectionU.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnectionU.connect();
                    outputStream = httpURLConnectionU.getOutputStream();
                    outputStream.write(bArr);
                    T(httpURLConnectionU);
                    int responseCode = httpURLConnectionU.getResponseCode();
                    if (responseCode == 200) {
                        s().O();
                    }
                    d("POST status", Integer.valueOf(responseCode));
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        A("Error closing http post connection output stream", e2);
                    }
                    httpURLConnectionU.disconnect();
                    return responseCode;
                } catch (IOException e3) {
                    e = e3;
                    x("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            A("Error closing http post connection output stream", e4);
                        }
                    }
                    if (httpURLConnectionU == null) {
                        return 0;
                    }
                    httpURLConnectionU.disconnect();
                    return 0;
                }
            } catch (Throwable th) {
                httpURLConnection = httpURLConnectionU;
                th = th;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                        A("Error closing http post connection output stream", e5);
                    }
                }
                if (httpURLConnection != null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnectionU = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            if (outputStream != null) {
            }
            if (httpURLConnection != null) {
            }
        }
    }

    public final String R(j0 j0Var, boolean z2) throws NumberFormatException {
        long j;
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : j0Var.a.entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    S(sb, key, entry.getValue());
                }
            }
            S(sb, "ht", String.valueOf(j0Var.d));
            Objects.requireNonNull((b.i.a.f.e.o.c) this.j.d);
            S(sb, "qt", String.valueOf(System.currentTimeMillis() - j0Var.d));
            if (z2) {
                AnimatableValueParser.w("_s");
                AnimatableValueParser.o(true, "Short param name required");
                String str = j0Var.a.get("_s");
                if (str == null) {
                    str = "0";
                }
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                S(sb, "z", j != 0 ? String.valueOf(j) : String.valueOf(j0Var.c));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            A("Failed to encode name or value", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        A("Error closing http connection input stream", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T(HttpURLConnection httpURLConnection) throws Throwable {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                do {
                } while (inputStream.read(new byte[1024]) > 0);
                inputStream.close();
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        A("Error closing http connection input stream", e);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public final HttpURLConnection U(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(e0.u.a.intValue());
        httpURLConnection.setReadTimeout(e0.v.a.intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.m);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x014f A[EDGE_INSN: B:237:0x014f->B:64:0x014f BREAK  A[LOOP:0: B:37:0x00c6->B:63:0x0144], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x043c A[EDGE_INSN: B:239:0x043c->B:211:0x043c BREAK  A[LOOP:1: B:139:0x02d0->B:241:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0144 A[LOOP:0: B:37:0x00c6->B:63:0x0144, LOOP_END] */
    /* JADX WARN: Type inference failed for: r16v0, types: [b.i.a.f.h.j.d, b.i.a.f.h.j.e, b.i.a.f.h.j.o0] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v35, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Long> V(List<j0> list) throws Throwable {
        boolean z2;
        String str;
        String strConcat;
        URL url;
        String strL;
        URL url2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnectionU;
        int responseCode;
        boolean z3;
        ?? url3;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream;
        OutputStream outputStream2;
        byte[] byteArray;
        boolean z4;
        x xVar = x.GZIP;
        w wVar = w.NONE;
        b.i.a.f.b.f.b();
        N();
        int iO = 0;
        if (!this.j.e.g().isEmpty() && this.n.b(e0.t.a.intValue() * 1000)) {
            String str2 = e0.n.a;
            z2 = ("BATCH_BY_SESSION".equalsIgnoreCase(str2) ? w.BATCH_BY_SESSION : "BATCH_BY_TIME".equalsIgnoreCase(str2) ? w.BATCH_BY_TIME : "BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(str2) ? w.BATCH_BY_BRUTE_FORCE : "BATCH_BY_COUNT".equalsIgnoreCase(str2) ? w.BATCH_BY_COUNT : "BATCH_BY_SIZE".equalsIgnoreCase(str2) ? w.BATCH_BY_SIZE : wVar) != wVar;
            boolean z5 = ("GZIP".equalsIgnoreCase(e0.o.a) ? xVar : x.NONE) == xVar;
            if (z2) {
                ArrayList arrayList = new ArrayList(list.size());
                for (j0 j0Var : list) {
                    Objects.requireNonNull(j0Var, "null reference");
                    String strR = R(j0Var, !j0Var.f);
                    if (strR != null) {
                        if (strR.length() <= e0.m.a.intValue()) {
                            if (j0Var.f) {
                                String strD = z.d();
                                String strF = z.f();
                                strL = outline.l(strR.length() + outline.b(strF, outline.b(strD, 1)), strD, strF, "?", strR);
                            } else {
                                String strE = z.e();
                                String strF2 = z.f();
                                strL = outline.l(strR.length() + outline.b(strF2, outline.b(strE, 1)), strE, strF2, "?", strR);
                            }
                            try {
                                url2 = new URL(strL);
                            } catch (MalformedURLException e) {
                                A("Error trying to parse the hardcoded host url", e);
                                url2 = null;
                            }
                            if (url2 == null) {
                                H("Failed to build collect GET endpoint url");
                            } else {
                                d("GET request", url2);
                                try {
                                    httpURLConnectionU = U(url2);
                                    try {
                                        try {
                                            httpURLConnectionU.connect();
                                            T(httpURLConnectionU);
                                            responseCode = httpURLConnectionU.getResponseCode();
                                            if (responseCode == 200) {
                                                s().O();
                                            }
                                            d("GET status", Integer.valueOf(responseCode));
                                            httpURLConnectionU.disconnect();
                                        } catch (Throwable th) {
                                            th = th;
                                            httpURLConnection = httpURLConnectionU;
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        x("Network GET connection error", e);
                                        if (httpURLConnectionU != null) {
                                            httpURLConnectionU.disconnect();
                                        }
                                        responseCode = 0;
                                        z3 = responseCode == 200;
                                        if (!z3) {
                                        }
                                        return arrayList;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    httpURLConnectionU = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    httpURLConnection = null;
                                }
                                if (responseCode == 200) {
                                }
                            }
                        } else {
                            String strR2 = R(j0Var, false);
                            if (strR2 == null) {
                                n().O(j0Var, "Error formatting hit for POST upload");
                            } else {
                                byte[] bytes = strR2.getBytes();
                                if (bytes.length > e0.q.a.intValue()) {
                                    n().O(j0Var, "Hit payload exceeds size limit");
                                } else if (j0Var.f) {
                                    String strValueOf = String.valueOf(z.d());
                                    String strValueOf2 = String.valueOf(z.f());
                                    if (strValueOf2.length() != 0) {
                                        strConcat = strValueOf.concat(strValueOf2);
                                        try {
                                            url = new URL(strConcat);
                                        } catch (MalformedURLException e4) {
                                            A("Error trying to parse the hardcoded host url", e4);
                                            url = null;
                                        }
                                        if (url != null) {
                                            H("Failed to build collect POST endpoint url");
                                        } else if (O(url, bytes) == 200) {
                                        }
                                    } else {
                                        str = new String(strValueOf);
                                        strConcat = str;
                                        url = new URL(strConcat);
                                        if (url != null) {
                                        }
                                    }
                                } else {
                                    String strValueOf3 = String.valueOf(z.e());
                                    String strValueOf4 = String.valueOf(z.f());
                                    if (strValueOf4.length() != 0) {
                                        strConcat = strValueOf3.concat(strValueOf4);
                                        url = new URL(strConcat);
                                        if (url != null) {
                                        }
                                    } else {
                                        str = new String(strValueOf3);
                                        strConcat = str;
                                        url = new URL(strConcat);
                                        if (url != null) {
                                        }
                                    }
                                }
                            }
                        }
                        if (!z3) {
                            break;
                        }
                        arrayList.add(Long.valueOf(j0Var.c));
                        if (arrayList.size() >= z.c()) {
                            break;
                        }
                    } else {
                        n().O(j0Var, "Error formatting hit for upload");
                    }
                    if (!z3) {
                    }
                }
                return arrayList;
            }
            AnimatableValueParser.l(!list.isEmpty());
            a(2, "Uploading batched hits. compression, count", Boolean.valueOf(z5), Integer.valueOf(list.size()), null);
            ?? byteArrayOutputStream = new ByteArrayOutputStream();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (j0 j0Var2 : list) {
                Objects.requireNonNull(j0Var2, "null reference");
                int i2 = i + 1;
                if (i2 <= e0.h.a.intValue()) {
                    String strR3 = R(j0Var2, false);
                    if (strR3 != null) {
                        byte[] bytes2 = strR3.getBytes();
                        int length = bytes2.length;
                        if (length <= e0.p.a.intValue()) {
                            if (byteArrayOutputStream.size() > 0) {
                                length++;
                            }
                            if (byteArrayOutputStream.size() + length <= e0.r.a.intValue()) {
                                try {
                                    if (byteArrayOutputStream.size() > 0) {
                                        byteArrayOutputStream.write(l);
                                    }
                                    byteArrayOutputStream.write(bytes2);
                                    i = i2;
                                } catch (IOException e5) {
                                    A("Failed to write payload when batching hits", e5);
                                }
                            }
                            z4 = false;
                            if (!z4) {
                                break;
                            }
                            arrayList2.add(Long.valueOf(j0Var2.c));
                        } else {
                            n().O(j0Var2, "Hit size exceeds the maximum size limit");
                        }
                    } else {
                        n().O(j0Var2, "Error formatting hit");
                    }
                    z4 = true;
                    if (!z4) {
                    }
                } else {
                    z4 = false;
                    if (!z4) {
                    }
                }
            }
            int i3 = i;
            if (i3 == 0) {
                return arrayList2;
            }
            String strValueOf5 = String.valueOf(z.d());
            String strValueOf6 = String.valueOf(e0.l.a);
            try {
                url3 = new URL(strValueOf6.length() != 0 ? strValueOf5.concat(strValueOf6) : new String(strValueOf5));
            } catch (MalformedURLException e6) {
                A("Error trying to parse the hardcoded host url", e6);
                url3 = 0;
            }
            URL url4 = url3;
            if (url4 == null) {
                H("Failed to build batching endpoint url");
            } else {
                if (z5) {
                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                    Objects.requireNonNull(byteArray2, "null reference");
                    try {
                        try {
                            this.j.f1417b.getPackageName();
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                            gZIPOutputStream.write(byteArray2);
                            gZIPOutputStream.close();
                            byteArrayOutputStream2.close();
                            byteArray = byteArrayOutputStream2.toByteArray();
                            a(3, "POST compressed size, ratio %, url", Integer.valueOf(byteArray.length), Long.valueOf((byteArray.length * 100) / byteArray2.length), url4);
                            if (byteArray.length > byteArray2.length) {
                                f("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(byteArray.length), Integer.valueOf(byteArray2.length));
                            }
                            if (Log.isLoggable(e0.f1411b.a, 2)) {
                                String str3 = new String(byteArray2);
                                b("Post payload", str3.length() != 0 ? "\n".concat(str3) : new String("\n"));
                            }
                            byteArrayOutputStream = U(url4);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (IOException e7) {
                        e = e7;
                        byteArrayOutputStream = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection2 = null;
                        outputStream = null;
                        Throwable th5 = th;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e8) {
                                A("Error closing http compressed post connection output stream", e8);
                            }
                        }
                        if (httpURLConnection2 != null) {
                            throw th5;
                        }
                        httpURLConnection2.disconnect();
                        throw th5;
                    }
                    try {
                        byteArrayOutputStream.setDoOutput(true);
                        byteArrayOutputStream.addRequestProperty("Content-Encoding", "gzip");
                        byteArrayOutputStream.setFixedLengthStreamingMode(byteArray.length);
                        byteArrayOutputStream.connect();
                        outputStream2 = byteArrayOutputStream.getOutputStream();
                        try {
                            outputStream2.write(byteArray);
                            outputStream2.close();
                            T(byteArrayOutputStream);
                            int responseCode2 = byteArrayOutputStream.getResponseCode();
                            if (responseCode2 == 200) {
                                s().O();
                            }
                            url3 = "POST status";
                            d("POST status", Integer.valueOf(responseCode2));
                            byteArrayOutputStream.disconnect();
                            iO = responseCode2;
                        } catch (IOException e9) {
                            e = e9;
                            x("Network compressed POST connection error", e);
                            url3 = outputStream2;
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                    url3 = outputStream2;
                                } catch (IOException e10) {
                                    IOException iOException = e10;
                                    A("Error closing http compressed post connection output stream", iOException);
                                    url3 = iOException;
                                }
                            }
                            if (byteArrayOutputStream != 0) {
                                byteArrayOutputStream.disconnect();
                            }
                            if (200 == iO) {
                            }
                        }
                    } catch (IOException e11) {
                        e = e11;
                        outputStream2 = null;
                        x("Network compressed POST connection error", e);
                        url3 = outputStream2;
                        if (outputStream2 != null) {
                        }
                        if (byteArrayOutputStream != 0) {
                        }
                        if (200 == iO) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        url3 = 0;
                        httpURLConnection2 = byteArrayOutputStream;
                        outputStream = url3;
                        Throwable th52 = th;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection2 != null) {
                        }
                    }
                } else {
                    iO = O(url4, byteArrayOutputStream.toByteArray());
                }
                if (200 == iO) {
                    b("Batched upload completed. Hits batched", Integer.valueOf(i3));
                    return arrayList2;
                }
                b("Network error uploading hits. status code", Integer.valueOf(iO));
                if (this.j.e.g().contains(Integer.valueOf(iO))) {
                    D("Server instructed the client to stop batching");
                    this.n.a();
                }
            }
            return Collections.emptyList();
        }
        z2 = false;
        if (z2) {
        }
    }

    public final boolean W() {
        b.i.a.f.b.f.b();
        N();
        NetworkInfo activeNetworkInfo = null;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.j.f1417b.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        C("No network connectivity");
        return false;
    }
}
