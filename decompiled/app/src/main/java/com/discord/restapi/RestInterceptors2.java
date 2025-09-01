package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import f0.HttpUrl;
import f0.e0.Util7;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* compiled from: RestInterceptors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/restapi/RequiredHeadersInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/discord/restapi/RequiredHeadersInterceptor$HeadersProvider;", "headersProvider", "Lcom/discord/restapi/RequiredHeadersInterceptor$HeadersProvider;", "<init>", "(Lcom/discord/restapi/RequiredHeadersInterceptor$HeadersProvider;)V", "HeadersProvider", "restapi_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.restapi.RequiredHeadersInterceptor, reason: use source file name */
/* loaded from: classes.dex */
public final class RestInterceptors2 implements Interceptor {
    private final HeadersProvider headersProvider;

    /* compiled from: RestInterceptors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/discord/restapi/RequiredHeadersInterceptor$HeadersProvider;", "", "", "getAuthToken", "()Ljava/lang/String;", "getFingerprint", "getLocale", "getAcceptLanguages", "getUserAgent", "getSpotifyToken", "restapi_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider */
    public interface HeadersProvider {
        String getAcceptLanguages();

        String getAuthToken();

        String getFingerprint();

        String getLocale();

        String getSpotifyToken();

        String getUserAgent();
    }

    public RestInterceptors2(HeadersProvider headersProvider) {
        Intrinsics3.checkNotNullParameter(headersProvider, "headersProvider");
        this.headersProvider = headersProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkNotNullParameter(chain, "chain");
        String authToken = this.headersProvider.getAuthToken();
        String fingerprint = this.headersProvider.getFingerprint();
        String locale = this.headersProvider.getLocale();
        String userAgent = this.headersProvider.getUserAgent();
        String acceptLanguages = this.headersProvider.getAcceptLanguages();
        Request requestC = chain.c();
        Intrinsics3.checkParameterIsNotNull(requestC, "request");
        new LinkedHashMap();
        HttpUrl httpUrl = requestC.url;
        String str = requestC.method;
        RequestBody requestBody = requestC.body;
        Map linkedHashMap = requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : Maps6.toMutableMap(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.a aVarE = requestC.headers.e();
        Intrinsics3.checkParameterIsNotNull("User-Agent", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(userAgent, "value");
        aVarE.a("User-Agent", userAgent);
        if (authToken != null) {
            Intrinsics3.checkParameterIsNotNull("Authorization", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(authToken, "value");
            aVarE.a("Authorization", authToken);
        }
        if (fingerprint != null) {
            Intrinsics3.checkParameterIsNotNull("X-Fingerprint", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(fingerprint, "value");
            aVarE.a("X-Fingerprint", fingerprint);
        }
        if (locale != null) {
            Intrinsics3.checkParameterIsNotNull("X-Discord-Locale", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(locale, "value");
            aVarE.a("X-Discord-Locale", locale);
        }
        if (acceptLanguages != null) {
            Intrinsics3.checkParameterIsNotNull("Accept-Language", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(acceptLanguages, "value");
            aVarE.a("Accept-Language", acceptLanguages);
        }
        if (httpUrl != null) {
            return chain.a(new Request(httpUrl, str, aVarE.c(), requestBody, Util7.A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
