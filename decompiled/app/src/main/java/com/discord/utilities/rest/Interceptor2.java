package com.discord.utilities.rest;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticSuperProperties;
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

/* compiled from: Interceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"okhttp3/Interceptor$Companion$invoke$1", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "okhttp"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rest.RestAPI$Companion$buildAnalyticsInterceptor$$inlined$invoke$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Interceptor2 implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        Request requestC = chain.c();
        Intrinsics3.checkParameterIsNotNull(requestC, "request");
        new LinkedHashMap();
        HttpUrl httpUrl = requestC.url;
        String str = requestC.method;
        RequestBody requestBody = requestC.body;
        Map linkedHashMap = requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : Maps6.toMutableMap(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.a aVarE = requestC.headers.e();
        String superPropertiesStringBase64 = AnalyticSuperProperties.INSTANCE.getSuperPropertiesStringBase64();
        Intrinsics3.checkParameterIsNotNull("X-Super-Properties", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(superPropertiesStringBase64, "value");
        aVarE.a("X-Super-Properties", superPropertiesStringBase64);
        if (httpUrl != null) {
            return chain.a(new Request(httpUrl, str, aVarE.c(), requestBody, Util7.A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
