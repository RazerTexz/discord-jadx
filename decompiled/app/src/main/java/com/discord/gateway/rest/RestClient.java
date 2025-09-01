package com.discord.gateway.rest;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGateway;
import com.discord.restapi.RestAPIBuilder;
import com.discord.restapi.RestInterceptors2;
import com.discord.restapi.utils.RetryWithDelay;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.SpreadBuilder;
import j0.k.Func1;
import j0.p.Schedulers2;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import okhttp3.Interceptor;
import rx.Observable;

/* compiled from: RestClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/gateway/rest/RestClient;", "", "Lcom/discord/gateway/rest/RestConfig;", "restConfig", "Landroid/content/Context;", "context", "", "init", "(Lcom/discord/gateway/rest/RestConfig;Landroid/content/Context;)V", "Lrx/Observable;", "", "getGateway", "()Lrx/Observable;", "Lcom/discord/gateway/rest/RestApi;", "restApi", "Lcom/discord/gateway/rest/RestApi;", "<init>", "()V", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class RestClient {
    public static final RestClient INSTANCE = new RestClient();
    private static RestApi restApi;

    /* compiled from: RestClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/ModelGateway;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelGateway;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.rest.RestClient$getGateway$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ModelGateway, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ String call(ModelGateway modelGateway) {
            return call2(modelGateway);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(ModelGateway modelGateway) {
            Intrinsics3.checkNotNullExpressionValue(modelGateway, "it");
            return modelGateway.getUrl();
        }
    }

    private RestClient() {
    }

    public final Observable<String> getGateway() {
        RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
        RestApi restApi2 = restApi;
        if (restApi2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("restApi");
        }
        Observable<ModelGateway> observableX = restApi2.getGateway().X(Schedulers2.c());
        Intrinsics3.checkNotNullExpressionValue(observableX, "restApi\n          .getGa…scribeOn(Schedulers.io())");
        Observable<String> observableG = RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, 7, null).G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "restApi\n          .getGa…          .map { it.url }");
        return observableG;
    }

    public final void init(RestConfig restConfig, Context context) {
        Intrinsics3.checkNotNullParameter(restConfig, "restConfig");
        Intrinsics3.checkNotNullParameter(context, "context");
        String baseUrl = restConfig.getBaseUrl();
        RestInterceptors2.HeadersProvider headersProvider = restConfig.getHeadersProvider();
        List<Interceptor> listComponent3 = restConfig.component3();
        RestInterceptors2 restInterceptors2 = new RestInterceptors2(headersProvider);
        PersistentCookieJar persistentCookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(restInterceptors2);
        Object[] array = listComponent3.toArray(new Interceptor[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        spreadBuilder.addSpread(array);
        restApi = (RestApi) RestAPIBuilder.build$default(new RestAPIBuilder(baseUrl, persistentCookieJar), RestApi.class, false, 0L, Collections2.listOf(spreadBuilder.toArray(new Interceptor[spreadBuilder.size()])), null, false, null, 118, null);
    }
}
