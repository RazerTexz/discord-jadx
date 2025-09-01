package f0.f0;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.analytics.utils.RegistrationSteps;
import d0.g0.StringsJVM;
import d0.t.Sets5;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import f0.Connection2;
import f0.e0.g.RealConnection4;
import f0.e0.h.HttpHeaders;
import f0.e0.h.RealInterceptorChain;
import g0.Buffer3;
import g0.BufferedSource;
import g0.GzipSource;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: HttpLoggingInterceptor.kt */
/* renamed from: f0.f0.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public volatile Set<String> f3669b;
    public volatile a c;
    public final b d;

    /* compiled from: HttpLoggingInterceptor.kt */
    /* renamed from: f0.f0.a$a */
    public enum a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.kt */
    /* renamed from: f0.f0.a$b */
    public interface b {
        void log(String str);
    }

    public HttpLoggingInterceptor(b bVar) {
        Intrinsics3.checkParameterIsNotNull(bVar, "logger");
        this.d = bVar;
        this.f3669b = Sets5.emptySet();
        this.c = a.NONE;
    }

    public final boolean a(Headers headers) {
        String strC = headers.c("Content-Encoding");
        return (strC == null || StringsJVM.equals(strC, RegistrationSteps.IDENTITY, true) || StringsJVM.equals(strC, "gzip", true)) ? false : true;
    }

    public final void b(Headers headers, int i) {
        int i2 = i * 2;
        String str = this.f3669b.contains(headers.namesAndValues[i2]) ? "██" : headers.namesAndValues[i2 + 1];
        this.d.log(headers.namesAndValues[i2] + ": " + str);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        String string;
        String str;
        String string2;
        Charset charsetA;
        Charset charsetA2;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        a aVar = this.c;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.f;
        if (aVar == a.NONE) {
            return realInterceptorChain.a(request);
        }
        boolean z2 = aVar == a.BODY;
        boolean z3 = z2 || aVar == a.HEADERS;
        RequestBody requestBody = request.body;
        Connection2 connection2B = realInterceptorChain.b();
        StringBuilder sbU = outline.U("--> ");
        sbU.append(request.method);
        sbU.append(' ');
        sbU.append(request.url);
        if (connection2B != null) {
            StringBuilder sbU2 = outline.U(" ");
            sbU2.append(((RealConnection4) connection2B).m());
            string = sbU2.toString();
        } else {
            string = "";
        }
        sbU.append(string);
        String string3 = sbU.toString();
        if (!z3 && requestBody != null) {
            StringBuilder sbX = outline.X(string3, " (");
            sbX.append(requestBody.contentLength());
            sbX.append("-byte body)");
            string3 = sbX.toString();
        }
        this.d.log(string3);
        if (z3) {
            Headers headers = request.headers;
            if (requestBody != null) {
                MediaType mediaTypeContentType = requestBody.contentType();
                if (mediaTypeContentType != null && headers.c("Content-Type") == null) {
                    this.d.log("Content-Type: " + mediaTypeContentType);
                }
                if (requestBody.contentLength() != -1 && headers.c("Content-Length") == null) {
                    b bVar = this.d;
                    StringBuilder sbU3 = outline.U("Content-Length: ");
                    sbU3.append(requestBody.contentLength());
                    bVar.log(sbU3.toString());
                }
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                b(headers, i);
            }
            if (!z2 || requestBody == null) {
                b bVar2 = this.d;
                StringBuilder sbU4 = outline.U("--> END ");
                sbU4.append(request.method);
                bVar2.log(sbU4.toString());
            } else if (a(request.headers)) {
                b bVar3 = this.d;
                StringBuilder sbU5 = outline.U("--> END ");
                sbU5.append(request.method);
                sbU5.append(" (encoded body omitted)");
                bVar3.log(sbU5.toString());
            } else if (requestBody.isDuplex()) {
                b bVar4 = this.d;
                StringBuilder sbU6 = outline.U("--> END ");
                sbU6.append(request.method);
                sbU6.append(" (duplex request body omitted)");
                bVar4.log(sbU6.toString());
            } else if (requestBody.isOneShot()) {
                b bVar5 = this.d;
                StringBuilder sbU7 = outline.U("--> END ");
                sbU7.append(request.method);
                sbU7.append(" (one-shot body omitted)");
                bVar5.log(sbU7.toString());
            } else {
                Buffer3 buffer3 = new Buffer3();
                requestBody.writeTo(buffer3);
                MediaType mediaTypeContentType2 = requestBody.contentType();
                if (mediaTypeContentType2 == null || (charsetA2 = mediaTypeContentType2.a(StandardCharsets.UTF_8)) == null) {
                    charsetA2 = StandardCharsets.UTF_8;
                    Intrinsics3.checkExpressionValueIsNotNull(charsetA2, "UTF_8");
                }
                this.d.log("");
                if (f.F0(buffer3)) {
                    this.d.log(buffer3.M(charsetA2));
                    b bVar6 = this.d;
                    StringBuilder sbU8 = outline.U("--> END ");
                    sbU8.append(request.method);
                    sbU8.append(" (");
                    sbU8.append(requestBody.contentLength());
                    sbU8.append("-byte body)");
                    bVar6.log(sbU8.toString());
                } else {
                    b bVar7 = this.d;
                    StringBuilder sbU9 = outline.U("--> END ");
                    sbU9.append(request.method);
                    sbU9.append(" (binary ");
                    sbU9.append(requestBody.contentLength());
                    sbU9.append("-byte body omitted)");
                    bVar7.log(sbU9.toString());
                }
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseA = realInterceptorChain.a(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBody = responseA.body;
            if (responseBody == null) {
                Intrinsics3.throwNpe();
            }
            long jA = responseBody.a();
            String str2 = jA != -1 ? jA + "-byte" : "unknown-length";
            b bVar8 = this.d;
            StringBuilder sbU10 = outline.U("<-- ");
            sbU10.append(responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
            if (responseA.message.length() == 0) {
                str = "-byte body omitted)";
                string2 = "";
            } else {
                String str3 = responseA.message;
                StringBuilder sb = new StringBuilder();
                str = "-byte body omitted)";
                sb.append(String.valueOf(' '));
                sb.append(str3);
                string2 = sb.toString();
            }
            sbU10.append(string2);
            sbU10.append(' ');
            sbU10.append(responseA.request.url);
            sbU10.append(" (");
            sbU10.append(millis);
            sbU10.append("ms");
            sbU10.append(!z3 ? outline.y(", ", str2, " body") : "");
            sbU10.append(')');
            bVar8.log(sbU10.toString());
            if (z3) {
                Headers headers2 = responseA.headers;
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b(headers2, i2);
                }
                if (!z2 || !HttpHeaders.a(responseA)) {
                    this.d.log("<-- END HTTP");
                } else if (a(responseA.headers)) {
                    this.d.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource bufferedSourceC = responseBody.c();
                    bufferedSourceC.j(RecyclerView.FOREVER_NS);
                    Buffer3 buffer3G = bufferedSourceC.g();
                    Long l = null;
                    if (StringsJVM.equals("gzip", headers2.c("Content-Encoding"), true)) {
                        Long lValueOf = Long.valueOf(buffer3G.k);
                        GzipSource gzipSource = new GzipSource(buffer3G.b());
                        try {
                            buffer3G = new Buffer3();
                            buffer3G.P(gzipSource);
                            Closeable.closeFinally(gzipSource, null);
                            l = lValueOf;
                        } finally {
                        }
                    }
                    MediaType mediaTypeB = responseBody.b();
                    if (mediaTypeB == null || (charsetA = mediaTypeB.a(StandardCharsets.UTF_8)) == null) {
                        charsetA = StandardCharsets.UTF_8;
                        Intrinsics3.checkExpressionValueIsNotNull(charsetA, "UTF_8");
                    }
                    if (!f.F0(buffer3G)) {
                        this.d.log("");
                        b bVar9 = this.d;
                        StringBuilder sbU11 = outline.U("<-- END HTTP (binary ");
                        sbU11.append(buffer3G.k);
                        sbU11.append(str);
                        bVar9.log(sbU11.toString());
                        return responseA;
                    }
                    if (jA != 0) {
                        this.d.log("");
                        this.d.log(buffer3G.b().M(charsetA));
                    }
                    if (l != null) {
                        b bVar10 = this.d;
                        StringBuilder sbU12 = outline.U("<-- END HTTP (");
                        sbU12.append(buffer3G.k);
                        sbU12.append("-byte, ");
                        sbU12.append(l);
                        sbU12.append("-gzipped-byte body)");
                        bVar10.log(sbU12.toString());
                    } else {
                        b bVar11 = this.d;
                        StringBuilder sbU13 = outline.U("<-- END HTTP (");
                        sbU13.append(buffer3G.k);
                        sbU13.append("-byte body)");
                        bVar11.log(sbU13.toString());
                    }
                }
            }
            return responseA;
        } catch (Exception e) {
            this.d.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }
}
