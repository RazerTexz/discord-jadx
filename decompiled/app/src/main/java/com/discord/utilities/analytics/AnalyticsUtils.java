package com.discord.utilities.analytics;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import b.i.a.f.h.l.g;
import b.i.a.f.h.l.n;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.channel.Channel;
import com.discord.api.science.AnalyticsSchema;
import com.discord.api.science.Science;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.device.RtcCameraConfig;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import d0.LazyJVM;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: AnalyticsUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b*\u00020\n8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b*\u00020\u00108@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/analytics/AnalyticsUtils;", "", "Landroid/app/Application;", "context", "", "initAppOpen", "(Landroid/app/Application;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "fireBaseInstance", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "Lcom/discord/api/channel/Channel;", "", "", "getProperties$app_productionGoogleRelease", "(Lcom/discord/api/channel/Channel;)Ljava/util/Map;", "properties", "Lcom/discord/rtcconnection/RtcConnection;", "(Lcom/discord/rtcconnection/RtcConnection;)Ljava/util/Map;", "<init>", "()V", "Tracker", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AnalyticsUtils {
    public static final AnalyticsUtils INSTANCE = new AnalyticsUtils();
    private static FirebaseAnalytics fireBaseInstance;

    /* compiled from: AnalyticsUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/MeUser;", "meUser", "", "invoke", "(Lcom/discord/models/user/MeUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.analytics.AnalyticsUtils$initAppOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            if (Intrinsics3.areEqual(meUser, UserUtils.INSTANCE.getEMPTY_USER())) {
                AppLog.g(0L, null, null);
                FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
                if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
                    g gVar = firebaseAnalyticsAccess$getFireBaseInstance$p.f3109b;
                    Objects.requireNonNull(gVar);
                    gVar.e.execute(new n(gVar, null));
                    return;
                }
                return;
            }
            FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p2 = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
            if (firebaseAnalyticsAccess$getFireBaseInstance$p2 != null) {
                String strValueOf = String.valueOf(meUser.getId());
                g gVar2 = firebaseAnalyticsAccess$getFireBaseInstance$p2.f3109b;
                Objects.requireNonNull(gVar2);
                gVar2.e.execute(new n(gVar2, strValueOf));
            }
            AppLog.g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername());
        }
    }

    private AnalyticsUtils() {
    }

    public static final /* synthetic */ FirebaseAnalytics access$getFireBaseInstance$p(AnalyticsUtils analyticsUtils) {
        return fireBaseInstance;
    }

    public static final /* synthetic */ void access$setFireBaseInstance$p(AnalyticsUtils analyticsUtils, FirebaseAnalytics firebaseAnalytics) {
        fireBaseInstance = firebaseAnalytics;
    }

    public final Map<String, Object> getProperties$app_productionGoogleRelease(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$properties");
        Tuples2[] tuples2Arr = new Tuples2[3];
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
        tuples2Arr[1] = Tuples.to("channel_type", Integer.valueOf(channel.getType()));
        List<User> listZ = channel.z();
        tuples2Arr[2] = Tuples.to("channel_size_total", Integer.valueOf(listZ != null ? listZ.size() : 0));
        return Maps6.mapOf(tuples2Arr);
    }

    @MainThread
    public final void initAppOpen(Application context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (fireBaseInstance != null) {
            return;
        }
        fireBaseInstance = FirebaseAnalytics.getInstance(context);
        ObservableExtensionsKt.appSubscribe$default(StoreStream.INSTANCE.getUsers().observeMe(true), AnalyticsUtils.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
        RtcCameraConfig.INSTANCE.init();
    }

    /* compiled from: AnalyticsUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00018B%\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020&\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020 03¢\u0006\u0004\b6\u00107J)\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\n*\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015JI\u0010\u0019\u001a\u00020\u000f2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u00052\u0006\u0010\u0016\u001a\u00020\u00042\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b0\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00032\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0019\u0010\u001cJ\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0019\u0010\u001fJ\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020 ¢\u0006\u0004\b\u0019\u0010!J)\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0004\b\"\u0010\u001cR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010)R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010*R\u0016\u0010-\u001a\u00020\u00078@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00078B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010,R4\u00101\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u0005\u0012\u0004\u0012\u00020\u0004008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020 038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "", "Lkotlin/Pair;", "", "", "Lcom/discord/utilities/analytics/ThrottleKey;", "throttleKey", "", "isEventThrottled", "(Lkotlin/Pair;)Z", "Landroid/os/Bundle;", "", "properties", "putMap", "(Landroid/os/Bundle;Ljava/util/Map;)Landroid/os/Bundle;", "", "drainEventsQueue", "()V", "analyticsToken", "fingerprinted", "setTrackingData", "(Ljava/lang/String;Z)V", "throttleTimeMs", "Lkotlin/Function0;", "lazyPropertyProvider", "track", "(Lkotlin/Pair;JLkotlin/jvm/functions/Function0;)V", "event", "(Ljava/lang/String;Ljava/util/Map;)V", "Lcom/discord/api/science/AnalyticsSchema;", "analyticsSchema", "(Lcom/discord/api/science/AnalyticsSchema;)V", "Lcom/discord/api/science/Science$Event;", "(Lcom/discord/api/science/Science$Event;)V", "trackFireBase", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Z", "Ljava/lang/String;", "isAuthed$app_productionGoogleRelease", "()Z", "isAuthed", "getCanDrain", "canDrain", "Ljava/util/concurrent/ConcurrentHashMap;", "eventsThrottledUntilMillis", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "eventsQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "<init>", "(Lcom/discord/utilities/time/Clock;Lcom/discord/utilities/rest/RestAPI;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Tracker {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy instance$delegate = LazyJVM.lazy(AnalyticsUtils2.INSTANCE);
        private String analyticsToken;
        private final Clock clock;
        private final ConcurrentLinkedQueue<Science.Event> eventsQueue;
        private final ConcurrentHashMap<Tuples2<String, Long>, Long> eventsThrottledUntilMillis;
        private boolean fingerprinted;
        private final RestAPI restAPI;

        /* compiled from: AnalyticsUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker$Companion;", "", "Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "instance", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Tracker getInstance() {
                Lazy lazyAccess$getInstance$cp = Tracker.access$getInstance$cp();
                Companion companion = Tracker.INSTANCE;
                return (Tracker) lazyAccess$getInstance$cp.getValue();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Tracker(Clock clock, RestAPI restAPI, ConcurrentLinkedQueue<Science.Event> concurrentLinkedQueue) {
            Intrinsics3.checkNotNullParameter(clock, "clock");
            Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
            Intrinsics3.checkNotNullParameter(concurrentLinkedQueue, "eventsQueue");
            this.clock = clock;
            this.restAPI = restAPI;
            this.eventsQueue = concurrentLinkedQueue;
            this.eventsThrottledUntilMillis = new ConcurrentHashMap<>();
        }

        public static final /* synthetic */ void access$drainEventsQueue(Tracker tracker) {
            tracker.drainEventsQueue();
        }

        public static final /* synthetic */ ConcurrentLinkedQueue access$getEventsQueue$p(Tracker tracker) {
            return tracker.eventsQueue;
        }

        public static final /* synthetic */ Lazy access$getInstance$cp() {
            return instance$delegate;
        }

        private final synchronized void drainEventsQueue() {
            if (getCanDrain()) {
                ArrayList arrayList = new ArrayList(this.eventsQueue);
                this.eventsQueue.clear();
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.science(new Science(this.analyticsToken, arrayList)), false, 1, null), getClass(), (Context) null, (Function1) null, new AnalyticsUtils4(this, arrayList), (Function0) null, (Function0) null, AnalyticsUtils3.INSTANCE, 54, (Object) null);
            }
        }

        private final boolean getCanDrain() {
            return (this.eventsQueue.isEmpty() ^ true) && (this.fingerprinted || isAuthed$app_productionGoogleRelease());
        }

        private final boolean isEventThrottled(Tuples2<String, Long> throttleKey) {
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            Long l = this.eventsThrottledUntilMillis.get(throttleKey);
            if (l == null) {
                l = 0L;
            }
            Intrinsics3.checkNotNullExpressionValue(l, "eventsThrottledUntilMillis[throttleKey] ?: 0");
            return jCurrentTimeMillis < l.longValue();
        }

        private final Bundle putMap(Bundle bundle, Map<String, ? extends Object> map) {
            try {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        bundle.putString(key, (String) value);
                    } else if (value instanceof Integer) {
                        bundle.putInt(key, ((Number) value).intValue());
                    } else if (value instanceof Long) {
                        bundle.putLong(key, ((Number) value).longValue());
                    } else if (value instanceof Double) {
                        bundle.putDouble(key, ((Number) value).doubleValue());
                    } else if (value instanceof Float) {
                        bundle.putFloat(key, ((Number) value).floatValue());
                    }
                }
            } catch (Throwable th) {
                Logger.e$default(AppLog.g, bundle.getClass().getSimpleName() + " putMap", th, null, 4, null);
            }
            return bundle;
        }

        public static /* synthetic */ void setTrackingData$default(Tracker tracker, String str, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            tracker.setTrackingData(str, z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void track$default(Tracker tracker, String str, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            tracker.track(str, map);
        }

        public final boolean isAuthed$app_productionGoogleRelease() {
            String str = this.analyticsToken;
            return !(str == null || StringsJVM.isBlank(str));
        }

        public final synchronized void setTrackingData(String analyticsToken, boolean fingerprinted) {
            drainEventsQueue();
            this.analyticsToken = analyticsToken;
            this.fingerprinted = fingerprinted;
            drainEventsQueue();
        }

        public final void track(Tuples2<String, Long> throttleKey, long throttleTimeMs, Function0<? extends Map<String, ? extends Object>> lazyPropertyProvider) {
            Intrinsics3.checkNotNullParameter(throttleKey, "throttleKey");
            Intrinsics3.checkNotNullParameter(lazyPropertyProvider, "lazyPropertyProvider");
            if (isEventThrottled(throttleKey)) {
                return;
            }
            track(throttleKey.component1(), lazyPropertyProvider.invoke());
            this.eventsThrottledUntilMillis.put(throttleKey, Long.valueOf(this.clock.currentTimeMillis() + throttleTimeMs));
        }

        public final void trackFireBase(String event, Map<String, ? extends Object> properties) {
            Intrinsics3.checkNotNullParameter(event, "event");
            Intrinsics3.checkNotNullParameter(properties, "properties");
            Bundle bundlePutMap = putMap(new Bundle(), properties);
            FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
            if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
                firebaseAnalyticsAccess$getFireBaseInstance$p.f3109b.c(null, event, bundlePutMap, false, true, null);
            }
        }

        public final void track(String event, Map<String, ? extends Object> properties) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (properties == null) {
                properties = Maps6.emptyMap();
            }
            track(new Science.Event.MapObject(event, properties));
        }

        public final void track(AnalyticsSchema analyticsSchema) {
            Intrinsics3.checkNotNullParameter(analyticsSchema, "analyticsSchema");
            if (analyticsSchema instanceof TrackGuild2) {
                TrackGuild2 trackGuild2 = (TrackGuild2) analyticsSchema;
                trackGuild2.c(AnalyticsUtils6.access$fill(trackGuild2.getTrackGuild()));
            }
            track(new Science.Event.SchemaObject(analyticsSchema));
        }

        public final void track(Science.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            this.eventsQueue.add(event);
            Observable<Long> observableD0 = Observable.d0(1500L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…0, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(observableD0, Tracker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnalyticsUtils5(this), 62, (Object) null);
        }
    }

    public final Map<String, String> getProperties$app_productionGoogleRelease(RtcConnection rtcConnection) {
        Intrinsics3.checkNotNullParameter(rtcConnection, "$this$properties");
        return MapsJVM.mapOf(Tuples.to("rtc_connection_id", rtcConnection.id));
    }
}
