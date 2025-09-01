package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import f0.CacheControl;
import f0.HttpUrl;
import f0.e0.Util7;
import f0.e0.h.HttpMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Tuples2;
import okhttp3.Headers;

/* compiled from: Request.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0010BC\b\u0000\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001f\u0012\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R,\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\b8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0012\u001a\u00020\u000f8G@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u00138\u0007@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001a\u001a\u00020\u00178\u0007@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001e\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0007@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010$¨\u0006("}, d2 = {"Lokhttp3/Request;", "", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "b", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "", "Ljava/lang/Class;", "f", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", ModelAuditLogEntry.CHANGE_KEY_TAGS, "Lf0/d;", "a", "()Lf0/d;", "cacheControl", "Lf0/w;", "Lf0/w;", "url", "()Lf0/w;", "Lokhttp3/Headers;", "d", "Lokhttp3/Headers;", "headers", "()Lokhttp3/Headers;", "c", "Ljava/lang/String;", "method", "Lokhttp3/RequestBody;", "e", "Lokhttp3/RequestBody;", "body", "()Lokhttp3/RequestBody;", "Lf0/d;", "lazyCacheControl", "<init>", "(Lf0/w;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Request {

    /* renamed from: a, reason: from kotlin metadata */
    public CacheControl lazyCacheControl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final HttpUrl url;

    /* renamed from: c, reason: from kotlin metadata */
    public final String method;

    /* renamed from: d, reason: from kotlin metadata */
    public final Headers headers;

    /* renamed from: e, reason: from kotlin metadata */
    public final RequestBody body;

    /* renamed from: f, reason: from kotlin metadata */
    public final Map<Class<?>, Object> tags;

    public Request(HttpUrl httpUrl, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(str, "method");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        Intrinsics3.checkParameterIsNotNull(map, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    public final CacheControl a() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlB = CacheControl.a.b(this.headers);
        this.lazyCacheControl = cacheControlB;
        return cacheControlB;
    }

    public final String b(String name) {
        Intrinsics3.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.headers.c(name);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Request{method=");
        sbU.append(this.method);
        sbU.append(", url=");
        sbU.append(this.url);
        if (this.headers.size() != 0) {
            sbU.append(", headers=[");
            int i = 0;
            for (Tuples2<? extends String, ? extends String> tuples2 : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                Tuples2<? extends String, ? extends String> tuples22 = tuples2;
                String strComponent1 = tuples22.component1();
                String strComponent2 = tuples22.component2();
                if (i > 0) {
                    sbU.append(", ");
                }
                sbU.append(strComponent1);
                sbU.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                sbU.append(strComponent2);
                i = i2;
            }
            sbU.append(']');
        }
        if (!this.tags.isEmpty()) {
            sbU.append(", tags=");
            sbU.append(this.tags);
        }
        sbU.append('}');
        String string = sbU.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* compiled from: Request.kt */
    public static class a {
        public HttpUrl a;

        /* renamed from: b, reason: collision with root package name */
        public String f3813b;
        public Headers.a c;
        public RequestBody d;
        public Map<Class<?>, Object> e;

        public a() {
            this.e = new LinkedHashMap();
            this.f3813b = ShareTarget.METHOD_GET;
            this.c = new Headers.a();
        }

        public Request a() {
            HttpUrl httpUrl = this.a;
            if (httpUrl != null) {
                return new Request(httpUrl, this.f3813b, this.c.c(), this.d, Util7.A(this.e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a b(String str, String str2) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            Headers.a aVar = this.c;
            Objects.requireNonNull(aVar);
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            Headers.Companion bVar = Headers.INSTANCE;
            bVar.a(str);
            bVar.b(str2, str);
            aVar.d(str);
            aVar.b(str, str2);
            return this;
        }

        public a c(String str, RequestBody requestBody) {
            Intrinsics3.checkParameterIsNotNull(str, "method");
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (requestBody == null) {
                Intrinsics3.checkParameterIsNotNull(str, "method");
                if (!(!(Intrinsics3.areEqual(str, ShareTarget.METHOD_POST) || Intrinsics3.areEqual(str, "PUT") || Intrinsics3.areEqual(str, "PATCH") || Intrinsics3.areEqual(str, "PROPPATCH") || Intrinsics3.areEqual(str, "REPORT")))) {
                    throw new IllegalArgumentException(outline.y("method ", str, " must have a request body.").toString());
                }
            } else if (!HttpMethod.a(str)) {
                throw new IllegalArgumentException(outline.y("method ", str, " must not have a request body.").toString());
            }
            this.f3813b = str;
            this.d = requestBody;
            return this;
        }

        public a d(String str) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.c.d(str);
            return this;
        }

        public <T> a e(Class<? super T> cls, T t) {
            Intrinsics3.checkParameterIsNotNull(cls, "type");
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.e;
                T tCast = cls.cast(t);
                if (tCast == null) {
                    Intrinsics3.throwNpe();
                }
                map.put(cls, tCast);
            }
            return this;
        }

        public a f(String str) throws NumberFormatException {
            Intrinsics3.checkParameterIsNotNull(str, "url");
            if (StringsJVM.startsWith(str, "ws:", true)) {
                StringBuilder sbU = outline.U("http:");
                String strSubstring = str.substring(3);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sbU.append(strSubstring);
                str = sbU.toString();
            } else if (StringsJVM.startsWith(str, "wss:", true)) {
                StringBuilder sbU2 = outline.U("https:");
                String strSubstring2 = str.substring(4);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                sbU2.append(strSubstring2);
                str = sbU2.toString();
            }
            Intrinsics3.checkParameterIsNotNull(str, "$this$toHttpUrl");
            HttpUrl.a aVar = new HttpUrl.a();
            aVar.e(null, str);
            g(aVar.b());
            return this;
        }

        public a g(HttpUrl httpUrl) {
            Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
            this.a = httpUrl;
            return this;
        }

        public a(Request request) {
            Map<Class<?>, Object> mutableMap;
            Intrinsics3.checkParameterIsNotNull(request, "request");
            this.e = new LinkedHashMap();
            this.a = request.url;
            this.f3813b = request.method;
            this.d = request.body;
            if (request.tags.isEmpty()) {
                mutableMap = new LinkedHashMap<>();
            } else {
                mutableMap = Maps6.toMutableMap(request.tags);
            }
            this.e = mutableMap;
            this.c = request.headers.e();
        }
    }
}
