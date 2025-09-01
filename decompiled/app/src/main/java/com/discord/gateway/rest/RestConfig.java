package com.discord.gateway.rest;

import b.d.b.a.outline;
import com.discord.restapi.RestInterceptors2;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;

/* compiled from: RestConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/gateway/rest/RestConfig;", "", "", "component1", "()Ljava/lang/String;", "Lcom/discord/restapi/RequiredHeadersInterceptor$HeadersProvider;", "component2", "()Lcom/discord/restapi/RequiredHeadersInterceptor$HeadersProvider;", "", "Lokhttp3/Interceptor;", "component3", "()Ljava/util/List;", "baseUrl", "headersProvider", "optionalInterceptors", "copy", "(Ljava/lang/String;Lcom/discord/restapi/RequiredHeadersInterceptor$HeadersProvider;Ljava/util/List;)Lcom/discord/gateway/rest/RestConfig;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getOptionalInterceptors", "Lcom/discord/restapi/RequiredHeadersInterceptor$HeadersProvider;", "getHeadersProvider", "Ljava/lang/String;", "getBaseUrl", "<init>", "(Ljava/lang/String;Lcom/discord/restapi/RequiredHeadersInterceptor$HeadersProvider;Ljava/util/List;)V", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class RestConfig {
    private final String baseUrl;
    private final RestInterceptors2.HeadersProvider headersProvider;
    private final List<Interceptor> optionalInterceptors;

    /* JADX WARN: Multi-variable type inference failed */
    public RestConfig(String str, RestInterceptors2.HeadersProvider headersProvider, List<? extends Interceptor> list) {
        Intrinsics3.checkNotNullParameter(str, "baseUrl");
        Intrinsics3.checkNotNullParameter(headersProvider, "headersProvider");
        Intrinsics3.checkNotNullParameter(list, "optionalInterceptors");
        this.baseUrl = str;
        this.headersProvider = headersProvider;
        this.optionalInterceptors = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestConfig copy$default(RestConfig restConfig, String str, RestInterceptors2.HeadersProvider headersProvider, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restConfig.baseUrl;
        }
        if ((i & 2) != 0) {
            headersProvider = restConfig.headersProvider;
        }
        if ((i & 4) != 0) {
            list = restConfig.optionalInterceptors;
        }
        return restConfig.copy(str, headersProvider, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final RestInterceptors2.HeadersProvider getHeadersProvider() {
        return this.headersProvider;
    }

    public final List<Interceptor> component3() {
        return this.optionalInterceptors;
    }

    public final RestConfig copy(String baseUrl, RestInterceptors2.HeadersProvider headersProvider, List<? extends Interceptor> optionalInterceptors) {
        Intrinsics3.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics3.checkNotNullParameter(headersProvider, "headersProvider");
        Intrinsics3.checkNotNullParameter(optionalInterceptors, "optionalInterceptors");
        return new RestConfig(baseUrl, headersProvider, optionalInterceptors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestConfig)) {
            return false;
        }
        RestConfig restConfig = (RestConfig) other;
        return Intrinsics3.areEqual(this.baseUrl, restConfig.baseUrl) && Intrinsics3.areEqual(this.headersProvider, restConfig.headersProvider) && Intrinsics3.areEqual(this.optionalInterceptors, restConfig.optionalInterceptors);
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final RestInterceptors2.HeadersProvider getHeadersProvider() {
        return this.headersProvider;
    }

    public final List<Interceptor> getOptionalInterceptors() {
        return this.optionalInterceptors;
    }

    public int hashCode() {
        String str = this.baseUrl;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        RestInterceptors2.HeadersProvider headersProvider = this.headersProvider;
        int iHashCode2 = (iHashCode + (headersProvider != null ? headersProvider.hashCode() : 0)) * 31;
        List<Interceptor> list = this.optionalInterceptors;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RestConfig(baseUrl=");
        sbU.append(this.baseUrl);
        sbU.append(", headersProvider=");
        sbU.append(this.headersProvider);
        sbU.append(", optionalInterceptors=");
        return outline.L(sbU, this.optionalInterceptors, ")");
    }

    public /* synthetic */ RestConfig(String str, RestInterceptors2.HeadersProvider headersProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, headersProvider, (i & 4) != 0 ? Collections2.emptyList() : list);
    }
}
