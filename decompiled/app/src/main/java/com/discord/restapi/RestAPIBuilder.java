package com.discord.restapi;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import b.a.b.TypeAdapterRegistrar;
import b.d.b.a.outline;
import b.i.d.FieldNamingPolicy;
import b.i.d.GsonBuilder;
import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.UserExperimentDto;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIParams;
import com.google.gson.Gson;
import d0.z.d.Intrinsics3;
import f0.CookieJar2;
import f0.HttpUrl;
import f0.OkHttpClient;
import f0.e0.Util7;
import i0.BuiltInConverters;
import i0.CompletableFutureCallAdapterFactory;
import i0.DefaultCallAdapterFactory;
import i0.OptionalConverterFactory;
import i0.Platform3;
import i0.Retrofit;
import i0.Retrofit2;
import i0.d0.a.RxJavaCallAdapterFactory;
import i0.e0.a.GsonConverterFactory;
import i0.e0.b.ScalarsConverterFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;

/* compiled from: RestAPIBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJM\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015Jg\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/discord/restapi/RestAPIBuilder;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lf0/x;", "client", "Ljava/lang/Class;", "api", "", "baseApiUrl", "", "serializeNulls", "addVersion", "contentType", "buildApi", "(Lf0/x;Ljava/lang/Class;Ljava/lang/String;ZZLjava/lang/String;)Ljava/lang/Object;", "", "timeoutMillis", "", "Lokhttp3/Interceptor;", "interceptors", "buildOkHttpClient", "(Ljava/lang/Long;Ljava/util/List;)Lf0/x;", "apiDefinition", "clientName", "build", "(Ljava/lang/Class;ZJLjava/util/List;Ljava/lang/String;ZLjava/lang/String;)Ljava/lang/Object;", "Ljava/lang/String;", "Lf0/p;", "cookieJar", "Lf0/p;", "<init>", "(Ljava/lang/String;Lf0/p;)V", "Companion", "restapi_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class RestAPIBuilder {
    private static final int API_VERSION = 9;
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT = "text/plain";
    private static final long DEFAULT_TIMEOUT_MILLIS = 10000;
    private final String baseApiUrl;
    private final CookieJar2 cookieJar;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function2<? super String, ? super OkHttpClient, Unit> clientCallback = RestAPIBuilder2.INSTANCE;

    /* compiled from: RestAPIBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\rR:\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/discord/restapi/RestAPIBuilder$Companion;", "", "Lkotlin/Function2;", "", "Lf0/x;", "", "clientCallback", "Lkotlin/jvm/functions/Function2;", "getClientCallback", "()Lkotlin/jvm/functions/Function2;", "setClientCallback", "(Lkotlin/jvm/functions/Function2;)V", "getClientCallback$annotations", "()V", "", "API_VERSION", "I", "CONTENT_TYPE_JSON", "Ljava/lang/String;", "CONTENT_TYPE_TEXT", "", "DEFAULT_TIMEOUT_MILLIS", "J", "<init>", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getClientCallback$annotations() {
        }

        public final Function2<String, OkHttpClient, Unit> getClientCallback() {
            return RestAPIBuilder.access$getClientCallback$cp();
        }

        public final void setClientCallback(Function2<? super String, ? super OkHttpClient, Unit> function2) {
            Intrinsics3.checkNotNullParameter(function2, "<set-?>");
            RestAPIBuilder.access$setClientCallback$cp(function2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RestAPIBuilder(String str, CookieJar2 cookieJar2) {
        Intrinsics3.checkNotNullParameter(str, "baseApiUrl");
        Intrinsics3.checkNotNullParameter(cookieJar2, "cookieJar");
        this.baseApiUrl = str;
        this.cookieJar = cookieJar2;
    }

    public static final /* synthetic */ Function2 access$getClientCallback$cp() {
        return clientCallback;
    }

    public static final /* synthetic */ void access$setClientCallback$cp(Function2 function2) {
        clientCallback = function2;
    }

    public static /* synthetic */ Object build$default(RestAPIBuilder restAPIBuilder, Class cls, boolean z2, long j, List list, String str, boolean z3, String str2, int i, Object obj) {
        return restAPIBuilder.build(cls, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? 10000L : j, (i & 8) != 0 ? null : list, (i & 16) == 0 ? str : null, (i & 32) != 0 ? true : z3, (i & 64) != 0 ? CONTENT_TYPE_JSON : str2);
    }

    private final <T> T buildApi(OkHttpClient client, Class<T> api, String baseApiUrl, boolean serializeNulls, boolean addVersion, String contentType) throws NumberFormatException, SecurityException {
        String str;
        String str2;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.c = FieldNamingPolicy.m;
        Intrinsics3.checkNotNullExpressionValue(gsonBuilder, "GsonBuilder()\n        .s…ER_CASE_WITH_UNDERSCORES)");
        TypeAdapterRegistrar.a(gsonBuilder);
        gsonBuilder.e.add(new Model.TypeAdapterFactory());
        gsonBuilder.e.add(UserExperimentDto.TypeAdapterFactory.INSTANCE);
        gsonBuilder.b(RestAPIParams.ChannelPosition.class, new RestAPIParams.ChannelPosition.Serializer());
        if (serializeNulls) {
            gsonBuilder.g = true;
        }
        Gson gsonA = gsonBuilder.a();
        if (addVersion) {
            str2 = "v9/";
            str = baseApiUrl;
        } else {
            str = baseApiUrl;
            str2 = "";
        }
        String strW = outline.w(str, str2);
        Platform3 platform3 = Platform3.a;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Objects.requireNonNull(client, "client == null");
        arrayList2.add(new RxJavaCallAdapterFactory(null, false));
        arrayList.add(new ScalarsConverterFactory());
        Intrinsics3.checkNotNullExpressionValue(gsonA, "gson");
        arrayList.add(new PayloadJSON.ConverterFactory(gsonA));
        if (Intrinsics3.areEqual(contentType, CONTENT_TYPE_JSON)) {
            arrayList.add(new GsonConverterFactory(gsonA));
        }
        Objects.requireNonNull(strW, "baseUrl == null");
        Intrinsics3.checkParameterIsNotNull(strW, "$this$toHttpUrl");
        HttpUrl.a aVar = new HttpUrl.a();
        aVar.e(null, strW);
        HttpUrl httpUrlB = aVar.b();
        if (!"".equals(httpUrlB.i.get(r4.size() - 1))) {
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrlB);
        }
        Executor executorA = platform3.a();
        ArrayList arrayList3 = new ArrayList(arrayList2);
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executorA);
        arrayList3.addAll(platform3.f3758b ? Arrays.asList(CompletableFutureCallAdapterFactory.a, defaultCallAdapterFactory) : Collections.singletonList(defaultCallAdapterFactory));
        ArrayList arrayList4 = new ArrayList(arrayList.size() + 1 + (platform3.f3758b ? 1 : 0));
        arrayList4.add(new BuiltInConverters());
        arrayList4.addAll(arrayList);
        arrayList4.addAll(platform3.f3758b ? Collections.singletonList(OptionalConverterFactory.a) : Collections.emptyList());
        Retrofit2 retrofit22 = new Retrofit2(client, httpUrlB, Collections.unmodifiableList(arrayList4), Collections.unmodifiableList(arrayList3), executorA, false);
        if (!api.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(api);
        while (!arrayDeque.isEmpty()) {
            Class<T> cls = (Class) arrayDeque.removeFirst();
            if (cls.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls.getName());
                if (cls != api) {
                    sb.append(" which is an interface of ");
                    sb.append(api.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls.getInterfaces());
        }
        if (retrofit22.g) {
            Platform3 platform32 = Platform3.a;
            for (Method method : api.getDeclaredMethods()) {
                if (!(platform32.f3758b && method.isDefault()) && !Modifier.isStatic(method.getModifiers())) {
                    retrofit22.b(method);
                }
            }
        }
        return (T) Proxy.newProxyInstance(api.getClassLoader(), new Class[]{api}, new Retrofit(retrofit22, api));
    }

    public static /* synthetic */ Object buildApi$default(RestAPIBuilder restAPIBuilder, OkHttpClient okHttpClient, Class cls, String str, boolean z2, boolean z3, String str2, int i, Object obj) {
        return restAPIBuilder.buildApi(okHttpClient, cls, str, (i & 8) != 0 ? false : z2, z3, str2);
    }

    private final OkHttpClient buildOkHttpClient(Long timeoutMillis, List<? extends Interceptor> interceptors) {
        OkHttpClient.a aVar = new OkHttpClient.a();
        if (interceptors != null) {
            for (Interceptor interceptor : interceptors) {
                Intrinsics3.checkParameterIsNotNull(interceptor, "interceptor");
                aVar.c.add(interceptor);
            }
        }
        if (timeoutMillis != null) {
            long jLongValue = timeoutMillis.longValue();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            aVar.a(jLongValue, timeUnit);
            long jLongValue2 = timeoutMillis.longValue();
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            aVar.f3691z = Util7.b("timeout", jLongValue2, timeUnit);
            long jLongValue3 = timeoutMillis.longValue();
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            aVar.f3689x = Util7.b("timeout", jLongValue3, timeUnit);
        }
        CookieJar2 cookieJar2 = this.cookieJar;
        Intrinsics3.checkParameterIsNotNull(cookieJar2, "cookieJar");
        aVar.j = cookieJar2;
        return new OkHttpClient(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OkHttpClient buildOkHttpClient$default(RestAPIBuilder restAPIBuilder, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return restAPIBuilder.buildOkHttpClient(l, list);
    }

    public final <T> T build(Class<T> apiDefinition, boolean serializeNulls, long timeoutMillis, List<? extends Interceptor> interceptors, String clientName, boolean addVersion, String contentType) {
        Intrinsics3.checkNotNullParameter(apiDefinition, "apiDefinition");
        Intrinsics3.checkNotNullParameter(contentType, "contentType");
        OkHttpClient okHttpClientBuildOkHttpClient = buildOkHttpClient(Long.valueOf(timeoutMillis), interceptors);
        if (clientName != null) {
            clientCallback.invoke(clientName, okHttpClientBuildOkHttpClient);
        }
        return (T) buildApi(okHttpClientBuildOkHttpClient, apiDefinition, this.baseApiUrl, serializeNulls, addVersion, contentType);
    }
}
