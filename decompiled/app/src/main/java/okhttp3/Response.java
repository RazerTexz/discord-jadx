package okhttp3;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import f0.Handshake;
import f0.Protocol2;
import f0.e0.g.Exchange;
import java.io.Closeable;
import java.util.Objects;
import kotlin.Metadata;
import okhttp3.Headers;

/* compiled from: Response.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001CB}\b\u0000\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u00100\u001a\u00020-\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010:\u001a\u000207\u0012\b\u0010?\u001a\u0004\u0018\u00010<\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010#\u001a\u00020\r\u0012\b\u0010'\u001a\u0004\u0018\u00010$¢\u0006\u0004\bA\u0010BJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\r8\u0007@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00168\u0007@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u0019\u0010\u001f\u001a\u00020\u00058\u0007@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010!\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015R\u0019\u0010#\u001a\u00020\r8\u0007@\u0006¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u001e\u0010'\u001a\u0004\u0018\u00010$8\u0001@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0013\u0010,\u001a\u00020)8F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0019\u00100\u001a\u00020-8\u0007@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0019\u00105\u001a\u0002028\u0007@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u0010:\u001a\u0002078\u0007@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u0004\u0018\u00010<8\u0007@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", "", "close", "()V", "", "toString", "()Ljava/lang/String;", "Lf0/v;", "n", "Lf0/v;", "handshake", "()Lf0/v;", "", "t", "J", "sentRequestAtMillis", "()J", "q", "Lokhttp3/Response;", "networkResponse", "()Lokhttp3/Response;", "Lf0/y;", "k", "Lf0/y;", "protocol", "()Lf0/y;", "r", "cacheResponse", "l", "Ljava/lang/String;", "message", "s", "priorResponse", "u", "receivedResponseAtMillis", "Lf0/e0/g/c;", "v", "Lf0/e0/g/c;", "exchange", "()Lf0/e0/g/c;", "", "b", "()Z", "isSuccessful", "", "m", "I", ModelAuditLogEntry.CHANGE_KEY_CODE, "()I", "Lokhttp3/Request;", "j", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "Lokhttp3/Headers;", "o", "Lokhttp3/Headers;", "headers", "()Lokhttp3/Headers;", "Lokhttp3/ResponseBody;", "p", "Lokhttp3/ResponseBody;", "body", "()Lokhttp3/ResponseBody;", "<init>", "(Lokhttp3/Request;Lf0/y;Ljava/lang/String;ILf0/v;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLf0/e0/g/c;)V", "a", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Response implements Closeable {

    /* renamed from: j, reason: from kotlin metadata */
    public final Request request;

    /* renamed from: k, reason: from kotlin metadata */
    public final Protocol2 protocol;

    /* renamed from: l, reason: from kotlin metadata */
    public final String message;

    /* renamed from: m, reason: from kotlin metadata */
    public final int code;

    /* renamed from: n, reason: from kotlin metadata */
    public final Handshake handshake;

    /* renamed from: o, reason: from kotlin metadata */
    public final Headers headers;

    /* renamed from: p, reason: from kotlin metadata */
    public final ResponseBody body;

    /* renamed from: q, reason: from kotlin metadata */
    public final Response networkResponse;

    /* renamed from: r, reason: from kotlin metadata */
    public final Response cacheResponse;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final Response priorResponse;

    /* renamed from: t, reason: from kotlin metadata */
    public final long sentRequestAtMillis;

    /* renamed from: u, reason: from kotlin metadata */
    public final long receivedResponseAtMillis;

    /* renamed from: v, reason: from kotlin metadata */
    public final Exchange exchange;

    public Response(Request request, Protocol2 protocol2, String str, int i, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j2, Exchange exchange) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
        Intrinsics3.checkParameterIsNotNull(str, "message");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        this.request = request;
        this.protocol = protocol2;
        this.message = str;
        this.code = i;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange;
    }

    public static String a(Response response, String str, String str2, int i) {
        int i2 = i & 2;
        Objects.requireNonNull(response);
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strC = response.headers.c(str);
        if (strC != null) {
            return strC;
        }
        return null;
    }

    public final boolean b() {
        int i = this.code;
        return 200 <= i && 299 >= i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        responseBody.close();
    }

    public String toString() {
        StringBuilder sbU = outline.U("Response{protocol=");
        sbU.append(this.protocol);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", url=");
        sbU.append(this.request.url);
        sbU.append('}');
        return sbU.toString();
    }

    /* compiled from: Response.kt */
    public static class a {
        public Request a;

        /* renamed from: b, reason: collision with root package name */
        public Protocol2 f3816b;
        public int c;
        public String d;
        public Handshake e;
        public Headers.a f;
        public ResponseBody g;
        public Response h;
        public Response i;
        public Response j;
        public long k;
        public long l;
        public Exchange m;

        public a() {
            this.c = -1;
            this.f = new Headers.a();
        }

        public Response a() {
            int i = this.c;
            if (!(i >= 0)) {
                StringBuilder sbU = outline.U("code < 0: ");
                sbU.append(this.c);
                throw new IllegalStateException(sbU.toString().toString());
            }
            Request request = this.a;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            Protocol2 protocol2 = this.f3816b;
            if (protocol2 == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.d;
            if (str != null) {
                return new Response(request, protocol2, str, i, this.e, this.f.c(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public a b(Response response) {
            c("cacheResponse", response);
            this.i = response;
            return this;
        }

        public final void c(String str, Response response) {
            if (response != null) {
                if (!(response.body == null)) {
                    throw new IllegalArgumentException(outline.w(str, ".body != null").toString());
                }
                if (!(response.networkResponse == null)) {
                    throw new IllegalArgumentException(outline.w(str, ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse == null)) {
                    throw new IllegalArgumentException(outline.w(str, ".cacheResponse != null").toString());
                }
                if (!(response.priorResponse == null)) {
                    throw new IllegalArgumentException(outline.w(str, ".priorResponse != null").toString());
                }
            }
        }

        public a d(Headers headers) {
            Intrinsics3.checkParameterIsNotNull(headers, "headers");
            this.f = headers.e();
            return this;
        }

        public a e(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "message");
            this.d = str;
            return this;
        }

        public a f(Protocol2 protocol2) {
            Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
            this.f3816b = protocol2;
            return this;
        }

        public a g(Request request) {
            Intrinsics3.checkParameterIsNotNull(request, "request");
            this.a = request;
            return this;
        }

        public a(Response response) {
            Intrinsics3.checkParameterIsNotNull(response, "response");
            this.c = -1;
            this.a = response.request;
            this.f3816b = response.protocol;
            this.c = response.code;
            this.d = response.message;
            this.e = response.handshake;
            this.f = response.headers.e();
            this.g = response.body;
            this.h = response.networkResponse;
            this.i = response.cacheResponse;
            this.j = response.priorResponse;
            this.k = response.sentRequestAtMillis;
            this.l = response.receivedResponseAtMillis;
            this.m = response.exchange;
        }
    }
}
