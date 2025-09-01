package com.discord.stores.updates;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import d0.Tuples;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Emitter;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* compiled from: ObservationDeck.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00041234B\u001b\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010*\u001a\u00020)¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJG\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000e\"\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J[\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00182\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000e\"\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u0016\u0010\u001bJE\u0010\u001e\u001a\u00020\u001d2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000e\"\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010!J\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001d0,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00065"}, d2 = {"Lcom/discord/stores/updates/ObservationDeck;", "", "", "message", "", "logBreadcrumb", "(Ljava/lang/String;)V", "", "throwable", "", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "updates", "logNotifyError", "(Ljava/lang/Throwable;Ljava/util/Set;)V", "", "updateSources", "", "updateOnConnect", "Lrx/Emitter$BackpressureMode;", "backpressureMode", "observerName", "Lrx/Observable;", "connectRx", "([Lcom/discord/stores/updates/ObservationDeck$UpdateSource;ZLrx/Emitter$BackpressureMode;Ljava/lang/String;)Lrx/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "generator", "([Lcom/discord/stores/updates/ObservationDeck$UpdateSource;ZLrx/Emitter$BackpressureMode;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lrx/Observable;", "onUpdate", "Lcom/discord/stores/updates/ObservationDeck$Observer;", "connect", "([Lcom/discord/stores/updates/ObservationDeck$UpdateSource;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/discord/stores/updates/ObservationDeck$Observer;", "observer", "(Lcom/discord/stores/updates/ObservationDeck$Observer;Z)Lcom/discord/stores/updates/ObservationDeck$Observer;", "disconnect", "(Lcom/discord/stores/updates/ObservationDeck$Observer;)V", "notify", "(Ljava/util/Set;)V", "Lcom/discord/utilities/logging/Logger;", "logger", "Lcom/discord/utilities/logging/Logger;", "Lcom/discord/stores/updates/ObservationDeck$LogLevel;", "logLevel", "Lcom/discord/stores/updates/ObservationDeck$LogLevel;", "", "observers", "Ljava/util/List;", "<init>", "(Lcom/discord/utilities/logging/Logger;Lcom/discord/stores/updates/ObservationDeck$LogLevel;)V", "Companion", "LogLevel", "Observer", "UpdateSource", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ObservationDeck {
    private static final String LOG_CATEGORY = "ObservationDeck";
    private final LogLevel logLevel;
    private final Logger logger;
    private List<Observer> observers;
    private static final Function0<Unit> ON_UPDATE_EMPTY = ObservationDeck2.INSTANCE;

    /* compiled from: ObservationDeck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/updates/ObservationDeck$LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ERROR", "VERBOSE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum LogLevel {
        NONE,
        ERROR,
        VERBOSE
    }

    /* compiled from: ObservationDeck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/discord/stores/updates/ObservationDeck$Observer;", "", "", "markStale", "()V", "", "toDebugLogString", "()Ljava/lang/String;", "", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "getObservingUpdates", "()Ljava/util/Set;", "observingUpdates", "", "<set-?>", "isStale", "Z", "()Z", "Lkotlin/Function0;", "getOnUpdate", "()Lkotlin/jvm/functions/Function0;", "setOnUpdate", "(Lkotlin/jvm/functions/Function0;)V", "onUpdate", "getName", ModelAuditLogEntry.CHANGE_KEY_NAME, "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Observer {
        private boolean isStale;

        public abstract String getName();

        public abstract Set<UpdateSource> getObservingUpdates();

        public abstract Function0<Unit> getOnUpdate();

        /* renamed from: isStale, reason: from getter */
        public final boolean getIsStale() {
            return this.isStale;
        }

        public final void markStale() {
            this.isStale = true;
            setOnUpdate(ObservationDeck.access$getON_UPDATE_EMPTY$cp());
        }

        public abstract void setOnUpdate(Function0<Unit> function0);

        public final String toDebugLogString() {
            StringBuilder sb = new StringBuilder();
            StringBuilder sbU = outline.U("Observer name: ");
            String name = getName();
            if (name == null) {
                name = "Unknown";
            }
            sbU.append(name);
            sbU.append('\n');
            sb.append(sbU.toString());
            sb.append(_Collections.joinToString$default(getObservingUpdates(), ", ", null, null, 0, null, null, 62, null));
            String string = sb.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "stringBuilder.toString()");
            return string;
        }
    }

    /* compiled from: ObservationDeck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface UpdateSource {
    }

    /* compiled from: ObservationDeck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u00020\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lrx/Emitter;", "", "kotlin.jvm.PlatformType", "emitter", NotificationCompat.CATEGORY_CALL, "(Lrx/Emitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.updates.ObservationDeck$connectRx$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Emitter<Unit>> {
        public final /* synthetic */ Ref$ObjectRef $observer;
        public final /* synthetic */ String $observerName;
        public final /* synthetic */ boolean $updateOnConnect;
        public final /* synthetic */ UpdateSource[] $updateSources;

        /* compiled from: ObservationDeck.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.updates.ObservationDeck$connectRx$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02011 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Emitter $emitter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02011(Emitter emitter) {
                super(0);
                this.$emitter = emitter;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$emitter.onNext(Unit.a);
            }
        }

        public AnonymousClass1(Ref$ObjectRef ref$ObjectRef, boolean z2, String str, UpdateSource[] updateSourceArr) {
            this.$observer = ref$ObjectRef;
            this.$updateOnConnect = z2;
            this.$observerName = str;
            this.$updateSources = updateSourceArr;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Emitter<Unit> emitter) {
            call2(emitter);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Emitter<Unit> emitter) {
            Ref$ObjectRef ref$ObjectRef = this.$observer;
            ObservationDeck observationDeck = ObservationDeck.this;
            boolean z2 = this.$updateOnConnect;
            String str = this.$observerName;
            C02011 c02011 = new C02011(emitter);
            UpdateSource[] updateSourceArr = this.$updateSources;
            ref$ObjectRef.element = (T) observationDeck.connect((UpdateSource[]) Arrays.copyOf(updateSourceArr, updateSourceArr.length), z2, str, c02011);
        }
    }

    /* compiled from: ObservationDeck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.updates.ObservationDeck$connectRx$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Action0 {
        public final /* synthetic */ Ref$ObjectRef $observer;

        public AnonymousClass2(Ref$ObjectRef ref$ObjectRef) {
            this.$observer = ref$ObjectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Action0
        public final void call() {
            Observer observer = (Observer) this.$observer.element;
            if (observer != null) {
                ObservationDeck.this.disconnect(observer);
            }
        }
    }

    /* compiled from: ObservationDeck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Unit;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.updates.ObservationDeck$connectRx$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Unit, T> {
        public final /* synthetic */ Function0 $generator;

        public AnonymousClass3(Function0 function0) {
            this.$generator = function0;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Object call(Unit unit) {
            return call2(unit);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final T call2(Unit unit) {
            return (T) this.$generator.invoke();
        }
    }

    /* compiled from: ObservationDeck.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/updates/ObservationDeck$Observer;", "observer", "", "invoke", "(Lcom/discord/stores/updates/ObservationDeck$Observer;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.updates.ObservationDeck$logNotifyError$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Observer, CharSequence> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Observer observer) {
            return invoke2(observer);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(Observer observer) {
            Intrinsics3.checkNotNullParameter(observer, "observer");
            return observer.toDebugLogString();
        }
    }

    public ObservationDeck() {
        this(null, null, 3, null);
    }

    public ObservationDeck(Logger logger, LogLevel logLevel) {
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(logLevel, "logLevel");
        this.logger = logger;
        this.logLevel = logLevel;
        this.observers = new ArrayList();
    }

    public static final /* synthetic */ Function0 access$getON_UPDATE_EMPTY$cp() {
        return ON_UPDATE_EMPTY;
    }

    public static /* synthetic */ Observer connect$default(ObservationDeck observationDeck, UpdateSource[] updateSourceArr, boolean z2, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return observationDeck.connect(updateSourceArr, z2, str, function0);
    }

    public static /* synthetic */ Observable connectRx$default(ObservationDeck observationDeck, UpdateSource[] updateSourceArr, boolean z2, Emitter.BackpressureMode backpressureMode, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            backpressureMode = Emitter.BackpressureMode.LATEST;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        return observationDeck.connectRx(updateSourceArr, z2, backpressureMode, str);
    }

    private final void logBreadcrumb(String message) {
        if (this.logLevel == LogLevel.VERBOSE) {
            this.logger.recordBreadcrumb(message, LOG_CATEGORY);
        }
    }

    private final void logNotifyError(Throwable throwable, Set<? extends UpdateSource> updates) {
        Logger logger = this.logger;
        Tuples2[] tuples2Arr = new Tuples2[2];
        tuples2Arr[0] = Tuples.to("Update Sources", _Collections.joinToString$default(updates, ", ", null, null, 0, null, null, 62, null));
        List<Observer> list = this.observers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                tuples2Arr[1] = Tuples.to("Observers", _Collections.joinToString$default(arrayList, "\n", null, null, 0, null, AnonymousClass2.INSTANCE, 30, null));
                logger.e("ObservationDeck notify error", throwable, Maps6.mapOf(tuples2Arr));
                return;
            }
            Object next = it.next();
            Observer observer = (Observer) next;
            if ((updates instanceof Collection) && updates.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it2 = updates.iterator();
                while (it2.hasNext()) {
                    if (observer.getObservingUpdates().contains((UpdateSource) it2.next())) {
                        break;
                    }
                }
                z2 = false;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }

    public final synchronized Observer connect(UpdateSource[] updateSources, boolean updateOnConnect, String observerName, Function0<Unit> onUpdate) {
        ObservationDeck3 observationDeck3;
        Intrinsics3.checkNotNullParameter(updateSources, "updateSources");
        Intrinsics3.checkNotNullParameter(onUpdate, "onUpdate");
        observationDeck3 = new ObservationDeck3(updateSources, onUpdate, observerName);
        connect(observationDeck3, updateOnConnect);
        return observationDeck3;
    }

    public final synchronized Observable<Unit> connectRx(UpdateSource[] updateSources, boolean updateOnConnect, Emitter.BackpressureMode backpressureMode, String observerName) {
        Observable<Unit> observableW;
        Intrinsics3.checkNotNullParameter(updateSources, "updateSources");
        Intrinsics3.checkNotNullParameter(backpressureMode, "backpressureMode");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        observableW = Observable.o(new AnonymousClass1(ref$ObjectRef, updateOnConnect, observerName, updateSources), backpressureMode).w(new AnonymousClass2(ref$ObjectRef));
        Intrinsics3.checkNotNullExpressionValue(observableW, "Observable.create<Unit>(…rver?.let(::disconnect) }");
        return observableW;
    }

    public final synchronized void disconnect(Observer observer) {
        Intrinsics3.checkNotNullParameter(observer, "observer");
        logBreadcrumb("disconnect START. observer: " + observer.getName());
        observer.markStale();
        logBreadcrumb("disconnect END. observer: " + observer.getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #2 {all -> 0x007d, blocks: (B:5:0x000e, B:7:0x0016, B:9:0x0025, B:10:0x0045, B:12:0x0049, B:22:0x006e, B:15:0x0051, B:16:0x0055, B:18:0x005b), top: B:44:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0075 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void notify(Set<? extends UpdateSource> updates) {
        String str;
        boolean z2;
        Intrinsics3.checkNotNullParameter(updates, "updates");
        logBreadcrumb("notify START");
        int i = 0;
        while (i < this.observers.size()) {
            try {
                Observer observer = this.observers.get(i);
                if (observer.getIsStale()) {
                    logBreadcrumb("removing observer: " + observer.getName());
                    this.observers.remove(i);
                    i += -1;
                } else if ((updates instanceof Collection) && updates.isEmpty()) {
                    z2 = false;
                    if (!z2) {
                    }
                } else {
                    Iterator<T> it = updates.iterator();
                    while (it.hasNext()) {
                        if (observer.getObservingUpdates().contains((UpdateSource) it.next())) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                        observer.getOnUpdate().invoke();
                    }
                }
                i++;
            } catch (Throwable th) {
                try {
                    if (this.logLevel.compareTo(LogLevel.ERROR) < 0) {
                        throw th;
                    }
                    logNotifyError(th, updates);
                    str = "notify END";
                } catch (Throwable th2) {
                    logBreadcrumb("notify END");
                    throw th2;
                }
            }
        }
        str = "notify END";
        logBreadcrumb(str);
    }

    public static /* synthetic */ Observer connect$default(ObservationDeck observationDeck, Observer observer, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return observationDeck.connect(observer, z2);
    }

    public /* synthetic */ ObservationDeck(Logger logger, LogLevel logLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AppLog.g : logger, (i & 2) != 0 ? LogLevel.NONE : logLevel);
    }

    public static /* synthetic */ Observable connectRx$default(ObservationDeck observationDeck, UpdateSource[] updateSourceArr, boolean z2, Emitter.BackpressureMode backpressureMode, String str, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 2) != 0 ? true : z2;
        if ((i & 4) != 0) {
            backpressureMode = Emitter.BackpressureMode.LATEST;
        }
        Emitter.BackpressureMode backpressureMode2 = backpressureMode;
        if ((i & 8) != 0) {
            str = null;
        }
        return observationDeck.connectRx(updateSourceArr, z3, backpressureMode2, str, function0);
    }

    public final synchronized Observer connect(Observer observer, boolean updateOnConnect) {
        Intrinsics3.checkNotNullParameter(observer, "observer");
        logBreadcrumb("connect START. observer: " + observer.getName());
        this.observers.add(observer);
        if (updateOnConnect) {
            observer.getOnUpdate().invoke();
        }
        logBreadcrumb("connect END. observer: " + observer.getName() + " -- isStale: " + observer.getIsStale());
        return observer;
    }

    public final synchronized <T> Observable<T> connectRx(UpdateSource[] updateSources, boolean updateOnConnect, Emitter.BackpressureMode backpressureMode, String observerName, Function0<? extends T> generator) {
        Observable<T> observable;
        Intrinsics3.checkNotNullParameter(updateSources, "updateSources");
        Intrinsics3.checkNotNullParameter(backpressureMode, "backpressureMode");
        Intrinsics3.checkNotNullParameter(generator, "generator");
        observable = (Observable<T>) connectRx((UpdateSource[]) Arrays.copyOf(updateSources, updateSources.length), updateOnConnect, backpressureMode, observerName).G(new AnonymousClass3(generator));
        Intrinsics3.checkNotNullExpressionValue(observable, "connectRx(\n        *upda…    ).map { generator() }");
        return observable;
    }
}
