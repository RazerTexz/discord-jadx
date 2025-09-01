package com.discord.stores.utilities;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.testing.TestUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.net.UnknownHostException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import retrofit2.HttpException;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: RestCallState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001au\u0010\f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u001a\b\u0002\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\u00060\u00042\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\f\u0010\r\u001a7\u0010\u0010\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0010\u0010\u0011\u001aA\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u000e2\u0016\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0004¢\u0006\u0004\b\u0015\u0010\u0016\u001aC\u0010\u001a\u001a\u0004\u0018\u00010\u0013\"\u0004\b\u0000\u0010\u00002\u0016\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0015\u0010\u001d\u001a\u00020\u001c*\u0006\u0012\u0002\b\u00030\u0012¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/stores/utilities/RestCallState;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/discord/stores/utilities/Loading;", "", "onLoading", "Lcom/discord/stores/utilities/Failure;", "onFailure", "Lcom/discord/stores/utilities/Success;", "onSuccess", "handleResponse", "(Lcom/discord/stores/utilities/RestCallState;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lrx/Observable;", "resultHandler", "executeRequest", "(Lrx/Observable;Lkotlin/jvm/functions/Function1;)V", "Lretrofit2/Response;", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "networkActionProvider", "logNetworkAction", "(Lrx/Observable;Lkotlin/jvm/functions/Function1;)Lrx/Observable;", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "metadata", "body", "getSchema", "(Lkotlin/jvm/functions/Function1;Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;Ljava/lang/Object;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "Lokhttp3/Request;", "getRequest", "(Lretrofit2/Response;)Lokhttp3/Request;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.stores.utilities.RestCallStateKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class RestCallState5 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RestCallState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "response", "", "invoke", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((AnonymousClass1<T>) obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$resultHandler.invoke(new RestCallState6(t));
        }
    }

    /* compiled from: RestCallState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            this.$resultHandler.invoke(new RestCallState3(error));
        }
    }

    /* compiled from: RestCallState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/stores/utilities/Loading;", "it", "", "invoke", "(Lcom/discord/stores/utilities/Loading;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState4, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState4 restCallState4) {
            invoke2(restCallState4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState4 restCallState4) {
            Intrinsics3.checkNotNullParameter(restCallState4, "it");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RestCallState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/stores/utilities/Failure;", "failure", "", "invoke", "(Lcom/discord/stores/utilities/Failure;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends Lambda implements Function1<RestCallState3<? extends T>, Unit> {
        public final /* synthetic */ Context $context;

        /* compiled from: RestCallState.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements Runnable {
            public final /* synthetic */ RestCallState3 $failure;

            public AnonymousClass1(RestCallState3 restCallState3) {
                this.$failure = restCallState3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.$failure.getError().showToasts(AnonymousClass2.this.$context);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((RestCallState3) obj);
            return Unit.a;
        }

        public final void invoke(RestCallState3<? extends T> restCallState3) {
            Intrinsics3.checkNotNullParameter(restCallState3, "failure");
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1(restCallState3));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RestCallState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/stores/utilities/Success;", "it", "", "invoke", "(Lcom/discord/stores/utilities/Success;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$3, reason: invalid class name */
    public static final class AnonymousClass3<T> extends Lambda implements Function1<RestCallState6<? extends T>, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((RestCallState6) obj);
            return Unit.a;
        }

        public final void invoke(RestCallState6<? extends T> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
        }
    }

    /* compiled from: RestCallState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/Response;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lretrofit2/Response;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Response<T>, T> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Response) obj);
        }

        public final T call(Response<T> response) {
            return response.f3824b;
        }
    }

    /* compiled from: RestCallState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/Response;", "kotlin.jvm.PlatformType", "response", "", NotificationCompat.CATEGORY_CALL, "(Lretrofit2/Response;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Response<T>> {
        public final /* synthetic */ Function1 $networkActionProvider;
        public final /* synthetic */ AnalyticsUtils.Tracker $tracker;

        public AnonymousClass2(Function1 function1, AnalyticsUtils.Tracker tracker) {
            this.$networkActionProvider = function1;
            this.$tracker = tracker;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Response) obj);
        }

        public final void call(Response<T> response) {
            TrackNetworkMetadata2 schema;
            Intrinsics3.checkNotNullExpressionValue(response, "response");
            if (!response.a()) {
                throw new HttpException(response);
            }
            Request request = RestCallState5.getRequest(response);
            if (!GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled() || (schema = RestCallState5.getSchema(this.$networkActionProvider, new TrackNetworkMetadata(request.url.l, request.method, Long.valueOf(response.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String), null, null, 24), response.f3824b)) == null) {
                return;
            }
            this.$tracker.track(schema);
        }
    }

    /* compiled from: RestCallState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "throwable", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Throwable> {
        public final /* synthetic */ Function1 $networkActionProvider;
        public final /* synthetic */ AnalyticsUtils.Tracker $tracker;

        public AnonymousClass3(Function1 function1, AnalyticsUtils.Tracker tracker) {
            this.$networkActionProvider = function1;
            this.$tracker = tracker;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void call2(Throwable th) {
            TrackNetworkMetadata trackNetworkMetadata;
            TrackNetworkMetadata2 schema$default;
            Request request;
            if (GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled()) {
                if (th instanceof HttpException) {
                    HttpException httpException = (HttpException) th;
                    Response<?> response = httpException.j;
                    if (response == null || (request = RestCallState5.getRequest(response)) == null) {
                        trackNetworkMetadata = null;
                    } else {
                        String str = request.url.l;
                        String str2 = request.method;
                        Long lValueOf = httpException.j != null ? Long.valueOf(r0.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                        Long lValueOf2 = httpException.j != null ? Long.valueOf(r0.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                        Response<?> response2 = httpException.j;
                        String str3 = response2 != null ? response2.a.message : null;
                        if (str3 == null) {
                            str3 = "";
                        }
                        trackNetworkMetadata = new TrackNetworkMetadata(str, str2, lValueOf, lValueOf2, str3);
                    }
                } else if (th instanceof UnknownHostException) {
                    trackNetworkMetadata = new TrackNetworkMetadata(null, null, null, null, ((UnknownHostException) th).getLocalizedMessage(), 15);
                }
                if (trackNetworkMetadata == null || (schema$default = RestCallState5.getSchema$default(this.$networkActionProvider, trackNetworkMetadata, null, 4, null)) == null) {
                    return;
                }
                this.$tracker.track(schema$default);
            }
        }
    }

    /* compiled from: RestCallState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/Response;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lretrofit2/Response;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Response<T>, T> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Response) obj);
        }

        public final T call(Response<T> response) {
            return response.f3824b;
        }
    }

    public static final <T> void executeRequest(Observable<T> observable, Function1<? super RestCallState<? extends T>, Unit> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$executeRequest");
        Intrinsics3.checkNotNullParameter(function1, "resultHandler");
        function1.invoke(RestCallState4.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), observable.getClass(), (Context) null, (Function1) null, new AnonymousClass2(function1), (Function0) null, (Function0) null, new AnonymousClass1(function1), 54, (Object) null);
    }

    public static final Request getRequest(Response<?> response) {
        Intrinsics3.checkNotNullParameter(response, "$this$getRequest");
        okhttp3.Response response2 = response.a;
        Objects.requireNonNull(response2, "null cannot be cast to non-null type okhttp3.Response");
        return response2.request;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> TrackNetworkMetadata2 getSchema(Function1<? super T, ? extends TrackNetworkMetadata2> function1, TrackNetworkMetadata trackNetworkMetadata, T t) {
        Intrinsics3.checkNotNullParameter(function1, "networkActionProvider");
        TrackNetworkMetadata2 trackNetworkMetadata2Invoke = function1.invoke(t);
        if (trackNetworkMetadata2Invoke != null) {
            trackNetworkMetadata2Invoke.b(trackNetworkMetadata);
        }
        return trackNetworkMetadata2Invoke;
    }

    public static /* synthetic */ TrackNetworkMetadata2 getSchema$default(Function1 function1, TrackNetworkMetadata trackNetworkMetadata, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return getSchema(function1, trackNetworkMetadata, obj);
    }

    @MainThread
    public static final <T> void handleResponse(RestCallState<? extends T> restCallState, Context context, Function1<? super RestCallState4, Unit> function1, Function1<? super RestCallState3<? extends T>, Unit> function12, Function1<? super RestCallState6<? extends T>, Unit> function13) {
        Intrinsics3.checkNotNullParameter(restCallState, "$this$handleResponse");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(function1, "onLoading");
        Intrinsics3.checkNotNullParameter(function12, "onFailure");
        Intrinsics3.checkNotNullParameter(function13, "onSuccess");
        if (restCallState instanceof RestCallState4) {
            function1.invoke(restCallState);
        } else if (restCallState instanceof RestCallState6) {
            function13.invoke(restCallState);
        } else if (restCallState instanceof RestCallState3) {
            function12.invoke(restCallState);
        }
    }

    public static /* synthetic */ void handleResponse$default(RestCallState restCallState, Context context, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        if ((i & 4) != 0) {
            function12 = new AnonymousClass2(context);
        }
        if ((i & 8) != 0) {
            function13 = AnonymousClass3.INSTANCE;
        }
        handleResponse(restCallState, context, function1, function12, function13);
    }

    public static final <T> Observable<T> logNetworkAction(Observable<Response<T>> observable, Function1<? super T, ? extends TrackNetworkMetadata2> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$logNetworkAction");
        Intrinsics3.checkNotNullParameter(function1, "networkActionProvider");
        if (TestUtils.getIS_JUNIT_TEST()) {
            Observable<T> observable2 = (Observable<T>) observable.G(AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observable2, "map { it.body() }");
            return observable2;
        }
        AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        Observable<T> observable3 = (Observable<T>) observable.u(new AnonymousClass2(function1, tracker)).t(new AnonymousClass3(function1, tracker)).G(AnonymousClass4.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observable3, "doOnNext { response ->\n …rectly.\n    it.body()\n  }");
        return observable3;
    }
}
