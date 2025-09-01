package com.discord.utilities.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: NetworkMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0004\b\u0014\u0010\u0012R:\u0010\u0017\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\r0\r \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\r0\r\u0018\u00010\u00150\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/networking/NetworkMonitor;", "", "Landroid/content/Context;", "context", "", "registerConnectivityNetworkMonitor", "(Landroid/content/Context;)V", "registerBroadcastConnectivityNetworkMonitor", "registerBroadcastAirplaneMode", "Landroid/content/Intent;", "intent", "updateNetworkState", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lcom/discord/utilities/networking/NetworkMonitor$State;", "getState", "(Landroid/content/Context;Landroid/content/Intent;)Lcom/discord/utilities/networking/NetworkMonitor$State;", "Lrx/Observable;", "observeState", "()Lrx/Observable;", "", "observeIsConnected", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "networkStateSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/utilities/logging/Logger;", "<init>", "(Landroid/content/Context;Lcom/discord/utilities/logging/Logger;)V", "State", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NetworkMonitor {
    private Logger logger;
    private final BehaviorSubject<State> networkStateSubject;

    /* compiled from: NetworkMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/networking/NetworkMonitor$State;", "", "<init>", "(Ljava/lang/String;I)V", "ONLINE", "OFFLINE", "OFFLINE_AIRPLANE_MODE", "utils_release"}, k = 1, mv = {1, 4, 2})
    public enum State {
        ONLINE,
        OFFLINE,
        OFFLINE_AIRPLANE_MODE
    }

    /* compiled from: NetworkMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/networking/NetworkMonitor$State;", "kotlin.jvm.PlatformType", "state", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/networking/NetworkMonitor$State;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.networking.NetworkMonitor$observeIsConnected$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<State, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(State state) {
            return call2(state);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(State state) {
            return Boolean.valueOf(state == State.ONLINE);
        }
    }

    /* compiled from: NetworkMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/utilities/networking/NetworkMonitor$registerBroadcastAirplaneMode$1", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.networking.NetworkMonitor$registerBroadcastAirplaneMode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(intent, "intent");
            Logger.i$default(NetworkMonitor.access$getLogger$p(NetworkMonitor.this), "[NetworkMonitor]", "Got airplane mode broadcast intent.", null, 4, null);
            NetworkMonitor.updateNetworkState$default(NetworkMonitor.this, context, null, 2, null);
        }
    }

    /* compiled from: NetworkMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/utilities/networking/NetworkMonitor$registerBroadcastConnectivityNetworkMonitor$1", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.networking.NetworkMonitor$registerBroadcastConnectivityNetworkMonitor$1, reason: invalid class name */
    public static final class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(intent, "intent");
            Logger.i$default(NetworkMonitor.access$getLogger$p(NetworkMonitor.this), "[NetworkMonitor]", "Got connectivity action broadcast intent.", null, 4, null);
            NetworkMonitor.access$updateNetworkState(NetworkMonitor.this, context, intent);
        }
    }

    /* compiled from: NetworkMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "registerDeprecatedNetworkCallback"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.networking.NetworkMonitor$registerConnectivityNetworkMonitor$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ConnectivityManager $connectivityManager;
        public final /* synthetic */ NetworkMonitor2 $networkCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ConnectivityManager connectivityManager, NetworkMonitor2 networkMonitor2) {
            super(0);
            this.$connectivityManager = connectivityManager;
            this.$networkCallback = networkMonitor2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                this.$connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.$networkCallback);
            } catch (Exception e) {
                NetworkMonitor.access$getLogger$p(NetworkMonitor.this).i("[NetworkMonitor]", "Unable to register network callback.", e);
            }
        }
    }

    public NetworkMonitor(Context context, Logger logger) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.networkStateSubject = BehaviorSubject.l0(getState$default(this, context, null, 2, null));
        registerConnectivityNetworkMonitor(context);
    }

    public static final /* synthetic */ Logger access$getLogger$p(NetworkMonitor networkMonitor) {
        return networkMonitor.logger;
    }

    public static final /* synthetic */ void access$setLogger$p(NetworkMonitor networkMonitor, Logger logger) {
        networkMonitor.logger = logger;
    }

    public static final /* synthetic */ void access$updateNetworkState(NetworkMonitor networkMonitor, Context context, Intent intent) {
        networkMonitor.updateNetworkState(context, intent);
    }

    private final State getState(Context context, Intent intent) {
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        State state = networkUtils.isDeviceConnected(context, intent, this.logger) ? State.ONLINE : networkUtils.isAirplaneModeOn(context) ? State.OFFLINE_AIRPLANE_MODE : State.OFFLINE;
        Logger.i$default(this.logger, "[NetworkMonitor]", "Updating network state to " + state + ", API: " + Build.VERSION.SDK_INT, null, 4, null);
        return state;
    }

    public static /* synthetic */ State getState$default(NetworkMonitor networkMonitor, Context context, Intent intent, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        return networkMonitor.getState(context, intent);
    }

    private final void registerBroadcastAirplaneMode(Context context) {
        context.registerReceiver(new AnonymousClass1(), new IntentFilter("android.intent.action.AIRPLANE_MODE"));
    }

    private final void registerBroadcastConnectivityNetworkMonitor(Context context) {
        context.registerReceiver(new AnonymousClass1(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private final void registerConnectivityNetworkMonitor(Context context) {
        Object systemService = context.getSystemService("connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            systemService = null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (connectivityManager != null) {
            NetworkMonitor2 networkMonitor2 = new NetworkMonitor2(this, context);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(connectivityManager, networkMonitor2);
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    connectivityManager.registerDefaultNetworkCallback(networkMonitor2);
                } catch (Exception unused) {
                    anonymousClass1.invoke2();
                }
            } else {
                anonymousClass1.invoke2();
            }
            registerBroadcastConnectivityNetworkMonitor(context);
            registerBroadcastAirplaneMode(context);
        }
    }

    private final void updateNetworkState(Context context, Intent intent) {
        this.networkStateSubject.onNext(getState(context, intent));
    }

    public static /* synthetic */ void updateNetworkState$default(NetworkMonitor networkMonitor, Context context, Intent intent, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        networkMonitor.updateNetworkState(context, intent);
    }

    public final Observable<Boolean> observeIsConnected() {
        Observable<Boolean> observableR = observeState().G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeState().map { sta… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = this.networkStateSubject.K().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "networkStateSubject.onBa…().distinctUntilChanged()");
        return observableR;
    }
}
