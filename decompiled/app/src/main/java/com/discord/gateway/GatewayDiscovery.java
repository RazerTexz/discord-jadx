package com.discord.gateway;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.discord.utilities.networking.Backoff;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;

/* compiled from: GatewayDiscovery.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001eBA\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ5\u0010\b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/discord/gateway/GatewayDiscovery;", "", "Lkotlin/Function1;", "", "", "onSuccess", "", "onFailure", "discoverGatewayUrl", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lrx/Subscription;", "gatewayUrlDiscoverySubscription", "Lrx/Subscription;", "log", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/utilities/networking/Backoff;", "backoff", "Lcom/discord/utilities/networking/Backoff;", "Lrx/Observable;", "gatewayUrlProvider", "Lrx/Observable;", "gatewayUrl", "Ljava/lang/String;", "Lrx/Scheduler;", "scheduler", "Lrx/Scheduler;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lrx/Scheduler;Lcom/discord/utilities/networking/Backoff;Lkotlin/jvm/functions/Function1;Lrx/Observable;)V", "Cache", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GatewayDiscovery {
    private final Backoff backoff;
    private String gatewayUrl;
    private Subscription gatewayUrlDiscoverySubscription;
    private final Observable<String> gatewayUrlProvider;
    private final Function1<String, Unit> log;
    private final Scheduler scheduler;

    /* compiled from: GatewayDiscovery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/gateway/GatewayDiscovery$Cache;", "", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "", "getGatewayUrl", "()Ljava/lang/String;", "gatewayUrl", "setGatewayUrl", "(Ljava/lang/String;)V", Cache.GATEWAY_URL_CACHE_KEY, "Ljava/lang/String;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "()V", "gateway_release"}, k = 1, mv = {1, 4, 2})
    public static final class Cache {
        private static final String GATEWAY_URL_CACHE_KEY = "GATEWAY_URL_CACHE_KEY";
        public static final Cache INSTANCE = new Cache();
        private static SharedPreferences sharedPreferences;

        private Cache() {
        }

        public final String getGatewayUrl() {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("sharedPreferences");
            }
            return sharedPreferences2.getString(GATEWAY_URL_CACHE_KEY, null);
        }

        public final void init(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Intrinsics3.checkNotNullExpressionValue(defaultSharedPreferences, "PreferenceManager.getDef…haredPreferences(context)");
            sharedPreferences = defaultSharedPreferences;
        }

        public final void setGatewayUrl(String gatewayUrl) {
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("sharedPreferences");
            }
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putString(GATEWAY_URL_CACHE_KEY, gatewayUrl);
            editorEdit.apply();
        }
    }

    /* compiled from: GatewayDiscovery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "throwable", "", "invoke", "(Ljava/lang/Throwable;)V", "handleFailure"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ Function1 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$onFailure = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "throwable");
            GatewayDiscovery.access$setGatewayUrl$p(GatewayDiscovery.this, null);
            Cache.INSTANCE.setGatewayUrl(null);
            this.$onFailure.invoke(th);
        }
    }

    /* compiled from: GatewayDiscovery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "gatewayUrl", "", "invoke", "(Ljava/lang/String;)V", "handleSuccess"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ AnonymousClass1 $handleFailure$1;
        public final /* synthetic */ Function1 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnonymousClass1 anonymousClass1, Function1 function1) {
            super(1);
            this.$handleFailure$1 = anonymousClass1;
            this.$onSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            if (str == null) {
                this.$handleFailure$1.invoke2(new Throwable("Malformed gateway url."));
                return;
            }
            GatewayDiscovery.access$setGatewayUrl$p(GatewayDiscovery.this, str);
            Cache.INSTANCE.setGatewayUrl(str);
            GatewayDiscovery.access$getLog$p(GatewayDiscovery.this).invoke("Discovered gateway url: " + str);
            this.$onSuccess.invoke(str);
        }
    }

    /* compiled from: GatewayDiscovery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public final /* synthetic */ AnonymousClass2 $handleSuccess$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass2 anonymousClass2) {
            super(1, null, "handleSuccess", "invoke(Ljava/lang/String;)V", 0);
            this.$handleSuccess$2 = anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            this.$handleSuccess$2.invoke2(str);
        }
    }

    /* compiled from: GatewayDiscovery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.gateway.GatewayDiscovery$discoverGatewayUrl$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public final /* synthetic */ AnonymousClass1 $handleFailure$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AnonymousClass1 anonymousClass1) {
            super(1, null, "handleFailure", "invoke(Ljava/lang/Throwable;)V", 0);
            this.$handleFailure$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "p1");
            this.$handleFailure$1.invoke2(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GatewayDiscovery(Context context, Scheduler scheduler, Backoff backoff, Function1<? super String, Unit> function1, Observable<String> observable) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics3.checkNotNullParameter(backoff, "backoff");
        Intrinsics3.checkNotNullParameter(function1, "log");
        Intrinsics3.checkNotNullParameter(observable, "gatewayUrlProvider");
        this.scheduler = scheduler;
        this.backoff = backoff;
        this.log = function1;
        this.gatewayUrlProvider = observable;
        Cache cache = Cache.INSTANCE;
        cache.init(context);
        this.gatewayUrl = cache.getGatewayUrl();
    }

    public static final /* synthetic */ String access$getGatewayUrl$p(GatewayDiscovery gatewayDiscovery) {
        return gatewayDiscovery.gatewayUrl;
    }

    public static final /* synthetic */ Function1 access$getLog$p(GatewayDiscovery gatewayDiscovery) {
        return gatewayDiscovery.log;
    }

    public static final /* synthetic */ void access$setGatewayUrl$p(GatewayDiscovery gatewayDiscovery, String str) {
        gatewayDiscovery.gatewayUrl = str;
    }

    public final void discoverGatewayUrl(Function1<? super String, Unit> onSuccess, Function1<? super Throwable, Unit> onFailure) {
        String str;
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        if (!this.backoff.hasReachedFailureThreshold() && (str = this.gatewayUrl) != null) {
            this.log.invoke("Using sticky gateway url: " + str);
            onSuccess.invoke(str);
            return;
        }
        this.log.invoke("Discovering gateway url.");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(onFailure);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(anonymousClass1, onSuccess);
        Subscription subscription = this.gatewayUrlDiscoverySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.gatewayUrlDiscoverySubscription = this.gatewayUrlProvider.J(this.scheduler).W(new GatewayDiscovery2(new AnonymousClass3(anonymousClass2)), new GatewayDiscovery2(new AnonymousClass4(anonymousClass1)));
    }
}
