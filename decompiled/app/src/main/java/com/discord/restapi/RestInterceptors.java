package com.discord.restapi;

import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import f0.HttpUrl;
import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: RestInterceptors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/restapi/BreadcrumbInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/utilities/logging/Logger;", "<init>", "(Lcom/discord/utilities/logging/Logger;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.restapi.BreadcrumbInterceptor, reason: use source file name */
/* loaded from: classes.dex */
public final class RestInterceptors implements Interceptor {
    private final Logger logger;

    public RestInterceptors(Logger logger) {
        Intrinsics3.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkNotNullParameter(chain, "chain");
        Request requestC = chain.c();
        String str = requestC.method;
        HttpUrl httpUrl = requestC.url;
        this.logger.recordBreadcrumb("HTTP[" + str + "] - " + httpUrl, "http");
        return chain.a(chain.c());
    }
}
