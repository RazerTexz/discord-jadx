package com.discord.utilities.analytics;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppStartAnalyticsTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/discord/utilities/analytics/AppStartAnalyticsTracker;", "", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "uriCanBeRouted", "isNotificationRoute", "", "appOpen", "(Landroid/net/Uri;ZZ)V", "", "screenName", "", "Lcom/discord/primitives/Timestamp;", "time", "appUiViewed", "(Ljava/lang/String;J)V", "Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "tracker", "Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "Lcom/discord/stores/StoreUserSettingsSystem;", "storeUserSettingsSystem", "Lcom/discord/stores/StoreUserSettingsSystem;", "appOpenTimestamp", "Ljava/lang/Long;", "openAppLoadId", "Ljava/lang/String;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "<init>", "(Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreUserSettingsSystem;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AppStartAnalyticsTracker {
    private static final String APP_FIRST_LAUNCHED = "app_first_launched";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy instance$delegate = LazyJVM.lazy(AppStartAnalyticsTracker2.INSTANCE);
    private Long appOpenTimestamp;
    private final Clock clock;
    private final String openAppLoadId;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private final AnalyticsUtils.Tracker tracker;

    /* compiled from: AppStartAnalyticsTracker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/analytics/AppStartAnalyticsTracker$Companion;", "", "", "", "map", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "insertUriProperties", "(Ljava/util/Map;Landroid/net/Uri;)Ljava/util/Map;", "Lcom/discord/utilities/analytics/AppStartAnalyticsTracker;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/discord/utilities/analytics/AppStartAnalyticsTracker;", "instance", "APP_FIRST_LAUNCHED", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Map access$insertUriProperties(Companion companion, Map map, Uri uri) {
            return companion.insertUriProperties(map, uri);
        }

        private final Map<String, Object> insertUriProperties(Map<String, Object> map, Uri uri) {
            String host = uri.getHost();
            if (host != null) {
                Intrinsics3.checkNotNullExpressionValue(host, "it");
                map.put("uri_host", host);
            }
            String scheme = uri.getScheme();
            if (scheme != null) {
                Intrinsics3.checkNotNullExpressionValue(scheme, "it");
                map.put("uri_scheme", scheme);
            }
            String path = uri.getPath();
            if (!(path == null || path.length() == 0)) {
                if (path.length() > 100) {
                    path = path.substring(0, 99);
                    Intrinsics3.checkNotNullExpressionValue(path, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                map.put("uri_path", path);
            }
            return map;
        }

        public final AppStartAnalyticsTracker getInstance() {
            Lazy lazyAccess$getInstance$cp = AppStartAnalyticsTracker.access$getInstance$cp();
            Companion companion = AppStartAnalyticsTracker.INSTANCE;
            return (AppStartAnalyticsTracker) lazyAccess$getInstance$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AppStartAnalyticsTracker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.analytics.AppStartAnalyticsTracker$appOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends Object>> {
        public final /* synthetic */ boolean $isNotificationRoute;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ boolean $uriCanBeRouted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, boolean z3, Uri uri) {
            super(0);
            this.$isNotificationRoute = z2;
            this.$uriCanBeRouted = z3;
            this.$uri = uri;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends Object> invoke2() {
            Tuples2[] tuples2Arr = new Tuples2[2];
            tuples2Arr[0] = Tuples.to("opened_from", this.$isNotificationRoute ? "notification" : this.$uriCanBeRouted ? Constants.DEEPLINK : "launcher");
            tuples2Arr[1] = Tuples.to("theme", AppStartAnalyticsTracker.access$getStoreUserSettingsSystem$p(AppStartAnalyticsTracker.this).getTheme());
            Map<String, ? extends Object> mapMutableMapOf = Maps6.mutableMapOf(tuples2Arr);
            Companion.access$insertUriProperties(AppStartAnalyticsTracker.INSTANCE, mapMutableMapOf, this.$uri);
            if (AppStartAnalyticsTracker.access$getAppOpenTimestamp$p(AppStartAnalyticsTracker.this) == null) {
                mapMutableMapOf.put("load_id", AppStartAnalyticsTracker.access$getOpenAppLoadId$p(AppStartAnalyticsTracker.this));
                AppStartAnalyticsTracker appStartAnalyticsTracker = AppStartAnalyticsTracker.this;
                AppStartAnalyticsTracker.access$setAppOpenTimestamp$p(appStartAnalyticsTracker, Long.valueOf(AppStartAnalyticsTracker.access$getClock$p(appStartAnalyticsTracker).currentTimeMillis()));
            }
            return mapMutableMapOf;
        }
    }

    public AppStartAnalyticsTracker(AnalyticsUtils.Tracker tracker, Clock clock, StoreUserSettingsSystem storeUserSettingsSystem) {
        Intrinsics3.checkNotNullParameter(tracker, "tracker");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        this.tracker = tracker;
        this.clock = clock;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        String string = UUID.randomUUID().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.openAppLoadId = string;
    }

    public static final /* synthetic */ Long access$getAppOpenTimestamp$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.appOpenTimestamp;
    }

    public static final /* synthetic */ Clock access$getClock$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.clock;
    }

    public static final /* synthetic */ Lazy access$getInstance$cp() {
        return instance$delegate;
    }

    public static final /* synthetic */ String access$getOpenAppLoadId$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.openAppLoadId;
    }

    public static final /* synthetic */ StoreUserSettingsSystem access$getStoreUserSettingsSystem$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.storeUserSettingsSystem;
    }

    public static final /* synthetic */ void access$setAppOpenTimestamp$p(AppStartAnalyticsTracker appStartAnalyticsTracker, Long l) {
        appStartAnalyticsTracker.appOpenTimestamp = l;
    }

    public final void appOpen(Uri uri, boolean uriCanBeRouted, boolean isNotificationRoute) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        this.tracker.track(Tuples.to("app_opened", null), 300000L, new AnonymousClass1(isNotificationRoute, uriCanBeRouted, uri));
        Persister persister = new Persister(APP_FIRST_LAUNCHED, Boolean.TRUE);
        if (((Boolean) persister.get()).booleanValue()) {
            this.tracker.track(APP_FIRST_LAUNCHED, MapsJVM.mapOf(Tuples.to("platform", "Android")));
            persister.set(Boolean.FALSE, true);
        }
    }

    public final void appUiViewed(String screenName, long time) {
        Intrinsics3.checkNotNullParameter(screenName, "screenName");
        Long l = this.appOpenTimestamp;
        this.tracker.track("app_ui_viewed", Maps6.mutableMapOf(Tuples.to("screen_name", screenName), Tuples.to("load_id", this.openAppLoadId), Tuples.to("duration_ms_since_app_opened", Long.valueOf(l != null ? time - l.longValue() : -1L)), Tuples.to("has_cached_data", Boolean.TRUE), Tuples.to("theme", this.storeUserSettingsSystem.getTheme())));
    }
}
