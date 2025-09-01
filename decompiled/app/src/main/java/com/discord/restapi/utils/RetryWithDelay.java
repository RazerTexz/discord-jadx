package com.discord.restapi.utils;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.HttpException;
import rx.Observable;

/* compiled from: RetryWithDelay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJE\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010JY\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/discord/restapi/utils/RetryWithDelay;", "", "Lrx/Observable;", "", "", "delayMillis", "", "maxHalfLives", "maxRetries", "Lkotlin/Function1;", "", "retryPredicate", "retryWithDelay", "(Lrx/Observable;JLjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lrx/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "restRetry", "(Lrx/Observable;JLjava/lang/Integer;Ljava/lang/Integer;)Lrx/Observable;", "predicate", "<init>", "()V", "restapi_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class RetryWithDelay {
    public static final RetryWithDelay INSTANCE = new RetryWithDelay();

    /* compiled from: RetryWithDelay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "throwable", "", "invoke", "(Ljava/lang/Throwable;)Z", "isNetworkError"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Throwable, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(invoke2(th));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Throwable th) {
            Response response;
            Request request;
            String str;
            Intrinsics3.checkNotNullParameter(th, "throwable");
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                int iA = httpException.a();
                retrofit2.Response<?> response2 = httpException.j;
                if ((response2 != null && (response = response2.a) != null && (request = response.request) != null && (str = request.method) != null && (!Intrinsics3.areEqual(str, ShareTarget.METHOD_GET))) || iA == 401 || iA == 429 || iA == 503 || iA == 403 || iA == 404) {
                    return false;
                }
            } else if (th instanceof TimeoutException) {
                return false;
            }
            return th instanceof IOException;
        }
    }

    /* compiled from: RetryWithDelay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0010\u0007\u001a\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00002.\u0010\u0004\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Observable;", "", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lrx/Observable;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Observable<? extends Throwable>, Observable<?>> {
        public final /* synthetic */ long $delayMillis;
        public final /* synthetic */ Integer $maxHalfLives;
        public final /* synthetic */ Integer $maxRetries;

        /* compiled from: RetryWithDelay.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "p1", "", "invoke", "(Ljava/lang/Throwable;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$2$1, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Throwable, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1, null, "isNetworkError", "invoke(Ljava/lang/Throwable;)Z", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
                return Boolean.valueOf(invoke2(th));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Throwable th) {
                Intrinsics3.checkNotNullParameter(th, "p1");
                return AnonymousClass1.INSTANCE.invoke2(th);
            }
        }

        public AnonymousClass2(long j, Integer num, Integer num2) {
            this.$delayMillis = j;
            this.$maxHalfLives = num;
            this.$maxRetries = num2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<?> call(Observable<? extends Throwable> observable) {
            return call2(observable);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<?> call2(Observable<? extends Throwable> observable) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(observable, "it");
            return RetryWithDelay.access$retryWithDelay(retryWithDelay, observable, this.$delayMillis, this.$maxHalfLives, this.$maxRetries, AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: RetryWithDelay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0010\u0007\u001a\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00002.\u0010\u0004\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lrx/Observable;", "", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lrx/Observable;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Observable<? extends Throwable>, Observable<?>> {
        public final /* synthetic */ long $delayMillis;
        public final /* synthetic */ Integer $maxHalfLives;
        public final /* synthetic */ Integer $maxRetries;
        public final /* synthetic */ Function1 $predicate;

        public AnonymousClass3(long j, Integer num, Integer num2, Function1 function1) {
            this.$delayMillis = j;
            this.$maxHalfLives = num;
            this.$maxRetries = num2;
            this.$predicate = function1;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<?> call(Observable<? extends Throwable> observable) {
            return call2(observable);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<?> call2(Observable<? extends Throwable> observable) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(observable, "it");
            return RetryWithDelay.access$retryWithDelay(retryWithDelay, observable, this.$delayMillis, this.$maxHalfLives, this.$maxRetries, this.$predicate);
        }
    }

    /* compiled from: RetryWithDelay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.restapi.utils.RetryWithDelay$retryWithDelay$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Throwable, Observable<? extends Object>> {
        public final /* synthetic */ Ref$LongRef $currentDelayMillis;
        public final /* synthetic */ Ref$IntRef $currentHalfLife;
        public final /* synthetic */ Ref$IntRef $currentRetry;
        public final /* synthetic */ int $maxHalfLives;
        public final /* synthetic */ int $maxRetries;
        public final /* synthetic */ Function1 $retryPredicate;

        public AnonymousClass1(int i, Ref$IntRef ref$IntRef, Function1 function1, int i2, Ref$IntRef ref$IntRef2, Ref$LongRef ref$LongRef) {
            this.$maxRetries = i;
            this.$currentRetry = ref$IntRef;
            this.$retryPredicate = function1;
            this.$maxHalfLives = i2;
            this.$currentHalfLife = ref$IntRef2;
            this.$currentDelayMillis = ref$LongRef;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Object> call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Object> call2(Throwable th) {
            Ref$IntRef ref$IntRef = this.$currentRetry;
            int i = ref$IntRef.element;
            ref$IntRef.element = i + 1;
            if (i < this.$maxRetries) {
                Function1 function1 = this.$retryPredicate;
                Intrinsics3.checkNotNullExpressionValue(th, "it");
                if (((Boolean) function1.invoke(th)).booleanValue()) {
                    Ref$IntRef ref$IntRef2 = this.$currentHalfLife;
                    int i2 = ref$IntRef2.element;
                    int i3 = i2 + 1;
                    ref$IntRef2.element = i3;
                    if (i2 < this.$maxHalfLives && i3 > 1) {
                        this.$currentDelayMillis.element *= 2;
                    }
                    return Observable.d0(this.$currentDelayMillis.element, TimeUnit.MILLISECONDS);
                }
            }
            return Observable.x(th);
        }
    }

    private RetryWithDelay() {
    }

    public static final /* synthetic */ Observable access$retryWithDelay(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, Function1 function1) {
        return retryWithDelay.retryWithDelay(observable, j, num, num2, function1);
    }

    public static /* synthetic */ Observable restRetry$default(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            num = 3;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = 3;
        }
        return retryWithDelay.restRetry(observable, j2, num3, num2);
    }

    private final Observable<Object> retryWithDelay(Observable<? extends Throwable> observable, long j, Integer num, Integer num2, Function1<? super Throwable, Boolean> function1) {
        int iIntValue = num2 != null ? num2.intValue() : Integer.MAX_VALUE;
        int iIntValue2 = num != null ? num.intValue() : Integer.MAX_VALUE;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = 0;
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = j;
        Observable<R> observableA = observable.A(new AnonymousClass1(iIntValue, ref$IntRef, function1, iIntValue2, ref$IntRef2, ref$LongRef));
        Intrinsics3.checkNotNullExpressionValue(observableA, "flatMap {\n      if (curr…able.error<Any>(it)\n    }");
        return observableA;
    }

    public final <T> Observable<T> restRetry(Observable<T> observable, long j, Integer num, Integer num2) {
        Intrinsics3.checkNotNullParameter(observable, "$this$restRetry");
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Observable<T> observableO = observable.O(new AnonymousClass2(j, num, num2));
        Intrinsics3.checkNotNullExpressionValue(observableO, "retryWhen { it.retryWith…ries, ::isNetworkError) }");
        return observableO;
    }

    public static /* synthetic */ Observable restRetry$default(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            num = 3;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = 3;
        }
        return retryWithDelay.restRetry(observable, j2, num3, num2, function1);
    }

    public final <T> Observable<T> restRetry(Observable<T> observable, long j, Integer num, Integer num2, Function1<? super Throwable, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$restRetry");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        Observable<T> observableO = observable.O(new AnonymousClass3(j, num, num2, function1));
        Intrinsics3.checkNotNullExpressionValue(observableO, "retryWhen { it.retryWith… maxRetries, predicate) }");
        return observableO;
    }
}
