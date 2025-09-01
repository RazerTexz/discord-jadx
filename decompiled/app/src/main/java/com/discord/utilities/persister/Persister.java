package com.discord.utilities.persister;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeElapsed;
import com.discord.widgets.chat.input.MentionUtils;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import d0.t.Collections2;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/* compiled from: Persister.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 4*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u000245B\u0017\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0004\b2\u00103J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00028\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001cR\u001c\u0010(\u001a\u00028\u00008B@\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0005\u001a\u0004\b&\u0010\u0007R\u0016\u0010,\u001a\u00020)8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0019\u0010.\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/discord/utilities/persister/Persister;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "persist", "()V", "get", "()Ljava/lang/Object;", "Lrx/Observable;", "getObservable", "()Lrx/Observable;", "newValue", "", "set", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "Lkotlin/Function1;", "setter", "getAndSet", "(ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "clear", "(Z)Ljava/lang/Object;", "Lrx/subjects/Subject;", "valueSubject", "Lrx/subjects/Subject;", "valueDirty", "Z", "valueUnset", "value", "Ljava/lang/Object;", "Ljava/io/File;", "getFileInput", "()Ljava/io/File;", "fileInput", "Lcom/esotericsoftware/kryo/io/Input;", "getFileInputStream", "()Lcom/esotericsoftware/kryo/io/Input;", "fileInputStream", "defaultValue", "getFileValue", "getFileValue$annotations", "fileValue", "Ljava/io/FileOutputStream;", "getFileOutput", "()Ljava/io/FileOutputStream;", "fileOutput", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "Companion", "Preloader", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class Persister<T> {
    private static Clock clock;

    @SuppressLint({"StaticFieldLeak"})
    private static Context context;
    private static boolean initialized;
    private static Preloader preferencesPreloader;
    private final T defaultValue;
    private final String key;
    private T value;
    private boolean valueDirty;
    private Subject<T, T> valueSubject;
    private boolean valueUnset;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function3<? super Integer, ? super String, ? super Exception, Unit> logger = Persister6.INSTANCE;
    private static Function1<? super Kryo, Unit> kryoConfig = Persister4.INSTANCE;
    private static final Persister5 kryos = new Persister5();
    private static final List<WeakReference<Persister<?>>> preferences = new CopyOnWriteArrayList();

    /* compiled from: Persister.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001+\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b6\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0004R.\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRB\u0010!\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\f\u0012\n\u0018\u00010\u001fj\u0004\u0018\u0001` \u0012\u0004\u0012\u00020\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010'R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\t\u0010(R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R&\u00101\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003000/0.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/discord/utilities/persister/Persister$Companion;", "", "", "persistAll", "()V", "", "availableBytes", "()J", "Landroid/content/Context;", "context", "Lcom/discord/utilities/time/Clock;", "clock", "Lrx/Observable;", "", "persistenceStrategy", "init", "(Landroid/content/Context;Lcom/discord/utilities/time/Clock;Lrx/Observable;)V", "isPreloaded", "()Lrx/Observable;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "Lkotlin/Function1;", "Lcom/esotericsoftware/kryo/Kryo;", "kryoConfig", "Lkotlin/jvm/functions/Function1;", "getKryoConfig", "()Lkotlin/jvm/functions/Function1;", "setKryoConfig", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function3;", "", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logger", "Lkotlin/jvm/functions/Function3;", "getLogger", "()Lkotlin/jvm/functions/Function3;", "setLogger", "(Lkotlin/jvm/functions/Function3;)V", "Lcom/discord/utilities/time/Clock;", "Landroid/content/Context;", "initialized", "Z", "com/discord/utilities/persister/Persister$Companion$kryos$1", "kryos", "Lcom/discord/utilities/persister/Persister$Companion$kryos$1;", "", "Ljava/lang/ref/WeakReference;", "Lcom/discord/utilities/persister/Persister;", "preferences", "Ljava/util/List;", "Lcom/discord/utilities/persister/Persister$Preloader;", "preferencesPreloader", "Lcom/discord/utilities/persister/Persister$Preloader;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ long access$availableBytes(Companion companion) {
            return companion.availableBytes();
        }

        public static final /* synthetic */ void access$persistAll(Companion companion) {
            companion.persistAll();
        }

        private final long availableBytes() {
            Context contextAccess$getContext$cp = Persister.access$getContext$cp();
            if (contextAccess$getContext$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("context");
            }
            Object systemService = contextAccess$getContext$cp.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (!(systemService instanceof ActivityManager)) {
                systemService = null;
            }
            ActivityManager activityManager = (ActivityManager) systemService;
            if (activityManager == null) {
                return RecyclerView.FOREVER_NS;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        }

        private final void persistAll() {
            Iterator<T> it = Persister.access$getPreferences$cp().iterator();
            while (it.hasNext()) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(((WeakReference) it.next()).get());
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(weakPreference.get())");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(scalarSynchronousObservable), Persister.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, Persister7.INSTANCE, 62, (Object) null);
            }
        }

        public final Function1<Kryo, Unit> getKryoConfig() {
            return Persister.access$getKryoConfig$cp();
        }

        public final Function3<Integer, String, Exception, Unit> getLogger() {
            return Persister.access$getLogger$cp();
        }

        public final void init(Context context, Clock clock, Observable<Boolean> persistenceStrategy) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(clock, "clock");
            Intrinsics3.checkNotNullParameter(persistenceStrategy, "persistenceStrategy");
            if (Persister.access$getInitialized$cp()) {
                return;
            }
            Persister.access$setInitialized$cp(true);
            Persister.access$setContext$cp(context);
            Persister.access$setClock$cp(clock);
            Persister.access$setPreferencesPreloader$cp(new Preloader(clock));
            Observable<Boolean> observableY = persistenceStrategy.y(Persister2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "persistenceStrategy\n    …er { persist -> persist }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableY), Persister.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, Persister3.INSTANCE, 62, (Object) null);
        }

        public final Observable<Boolean> isPreloaded() {
            Preloader preloaderAccess$getPreferencesPreloader$cp = Persister.access$getPreferencesPreloader$cp();
            if (preloaderAccess$getPreferencesPreloader$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("preferencesPreloader");
            }
            return preloaderAccess$getPreferencesPreloader$cp.isPreloaded();
        }

        public final void reset() {
            Iterator<T> it = Persister.access$getPreferences$cp().iterator();
            while (it.hasNext()) {
                Persister persister = (Persister) ((WeakReference) it.next()).get();
                if (persister != null) {
                    Persister.clear$default(persister, false, 1, null);
                }
            }
        }

        public final void setKryoConfig(Function1<? super Kryo, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "<set-?>");
            Persister.access$setKryoConfig$cp(function1);
        }

        public final void setLogger(Function3<? super Integer, ? super String, ? super Exception, Unit> function3) {
            Intrinsics3.checkNotNullParameter(function3, "<set-?>");
            Persister.access$setLogger$cp(function3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Persister.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0005\u001a\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\f\u0010\u0006R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fRB\u0010\u0012\u001a.\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0011*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0011*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00030\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/discord/utilities/persister/Persister$Preloader;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/persister/Persister;", "", "handlePreload", "(Lcom/discord/utilities/persister/Persister;)V", "Lrx/Observable;", "", "isPreloaded", "()Lrx/Observable;", "preference", "preload", "Lcom/discord/utilities/time/TimeElapsed;", "preloadTime", "Lcom/discord/utilities/time/TimeElapsed;", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "preloadSubject", "Lrx/subjects/SerializedSubject;", "", "", "preloadCacheKeys", "Ljava/util/List;", "Lcom/discord/utilities/time/Clock;", "clock", "<init>", "(Lcom/discord/utilities/time/Clock;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Preloader {
        private final List<String> preloadCacheKeys;
        private final SerializedSubject<Persister<?>, Persister<?>> preloadSubject;
        private final TimeElapsed preloadTime;

        /* compiled from: Persister.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/persister/Persister;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/persister/Persister;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.persister.Persister$Preloader$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Persister<?>, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Persister<?> persister) {
                return call2(persister);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Persister<?> persister) {
                return Boolean.valueOf(persister == null);
            }
        }

        /* compiled from: Persister.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/persister/Persister;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/utilities/persister/Persister;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.persister.Persister$Preloader$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Persister<?>, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Persister<?> persister) {
                invoke2(persister);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Persister<?> persister) {
                if (persister != null) {
                    Preloader.access$handlePreload(Preloader.this, persister);
                }
            }
        }

        public Preloader(Clock clock) {
            Intrinsics3.checkNotNullParameter(clock, "clock");
            this.preloadTime = new TimeElapsed(clock, 0L, 2, null);
            SerializedSubject<Persister<?>, Persister<?>> serializedSubject = new SerializedSubject<>(BehaviorSubject.k0());
            this.preloadSubject = serializedSubject;
            this.preloadCacheKeys = Collections2.mutableListOf("STORE_USER_RELATIONSHIPS_V9", "STORE_CHANNELS_V26", "STORE_GUILDS_V34");
            Observable<Persister<?>> observableB0 = serializedSubject.b0(AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableB0, "preloadSubject\n          .takeUntil { it == null }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableB0), Preloader.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        }

        public static final /* synthetic */ void access$handlePreload(Preloader preloader, Persister persister) {
            preloader.handlePreload(persister);
        }

        private final synchronized <T> void handlePreload(Persister<T> persister) {
            if (this.preloadCacheKeys.contains(persister.getKey())) {
                this.preloadCacheKeys.remove(persister.getKey());
                persister.get();
            }
            if (this.preloadCacheKeys.isEmpty()) {
                this.preloadSubject.k.onNext(null);
                Persister.INSTANCE.getLogger().invoke(4, "Preloaded preferences in " + this.preloadTime.getSeconds() + " seconds.", null);
            }
        }

        public final Observable<Boolean> isPreloaded() {
            Observable<Boolean> observableR = this.preloadSubject.G(Persister8.INSTANCE).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "preloadSubject\n         …  .distinctUntilChanged()");
            return observableR;
        }

        public final synchronized <T> void preload(Persister<T> preference) {
            Intrinsics3.checkNotNullParameter(preference, "preference");
            if (this.preloadCacheKeys.contains(preference.getKey())) {
                this.preloadSubject.k.onNext(preference);
            }
        }
    }

    /* compiled from: Persister.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lrx/subjects/Subject;", "invoke", "()Lrx/subjects/Subject;", "createSubject"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.persister.Persister$getObservable$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Subject<T, T>> {

        /* compiled from: Persister.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.persister.Persister$getObservable$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02201 extends Lambda implements Function1 {
            public final /* synthetic */ SerializedSubject $subject;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02201(SerializedSubject serializedSubject) {
                super(1);
                this.$subject = serializedSubject;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Void) obj);
                return Unit.a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(Void r2) {
                SerializedSubject serializedSubject = this.$subject;
                serializedSubject.k.onNext(Persister.this.get());
            }
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final Subject<T, T> invoke() {
            SerializedSubject serializedSubject = new SerializedSubject(BehaviorSubject.k0());
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(null)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(scalarSynchronousObservable), Persister.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C02201(serializedSubject), 62, (Object) null);
            return serializedSubject;
        }
    }

    public Persister(String str, T t) {
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(t, "defaultValue");
        this.key = str;
        this.defaultValue = t;
        this.value = t;
        this.valueUnset = true;
        preferences.add(new WeakReference<>(this));
        Preloader preloader = preferencesPreloader;
        if (preloader == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("preferencesPreloader");
        }
        preloader.preload(this);
    }

    public static final /* synthetic */ Clock access$getClock$cp() {
        return clock;
    }

    public static final /* synthetic */ Context access$getContext$cp() {
        return context;
    }

    public static final /* synthetic */ boolean access$getInitialized$cp() {
        return initialized;
    }

    public static final /* synthetic */ Function1 access$getKryoConfig$cp() {
        return kryoConfig;
    }

    public static final /* synthetic */ Function3 access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ List access$getPreferences$cp() {
        return preferences;
    }

    public static final /* synthetic */ Preloader access$getPreferencesPreloader$cp() {
        return preferencesPreloader;
    }

    public static final /* synthetic */ void access$persist(Persister persister) {
        persister.persist();
    }

    public static final /* synthetic */ void access$setClock$cp(Clock clock2) {
        clock = clock2;
    }

    public static final /* synthetic */ void access$setContext$cp(Context context2) {
        context = context2;
    }

    public static final /* synthetic */ void access$setInitialized$cp(boolean z2) {
        initialized = z2;
    }

    public static final /* synthetic */ void access$setKryoConfig$cp(Function1 function1) {
        kryoConfig = function1;
    }

    public static final /* synthetic */ void access$setLogger$cp(Function3 function3) {
        logger = function3;
    }

    public static final /* synthetic */ void access$setPreferencesPreloader$cp(Preloader preloader) {
        preferencesPreloader = preloader;
    }

    public static /* synthetic */ Object clear$default(Persister persister, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return persister.clear(z2);
    }

    public static /* synthetic */ Object getAndSet$default(Persister persister, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return persister.getAndSet(z2, function1);
    }

    private final File getFileInput() {
        StringBuilder sb = new StringBuilder();
        Context context2 = context;
        if (context2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("context");
        }
        sb.append(context2.getFilesDir());
        sb.append(MentionUtils.SLASH_CHAR);
        sb.append(this.key);
        return new File(sb.toString());
    }

    private final Input getFileInputStream() {
        File fileInput = getFileInput();
        if (!fileInput.exists() || fileInput.length() >= Companion.access$availableBytes(INSTANCE)) {
            return null;
        }
        return new Input(new FileInputStream(fileInput));
    }

    private final FileOutputStream getFileOutput() throws FileNotFoundException {
        Context context2 = context;
        if (context2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("context");
        }
        FileOutputStream fileOutputStreamOpenFileOutput = context2.openFileOutput(this.key, 0);
        Intrinsics3.checkNotNullExpressionValue(fileOutputStreamOpenFileOutput, "context.openFileOutput(key, Context.MODE_PRIVATE)");
        return fileOutputStreamOpenFileOutput;
    }

    private final T getFileValue() {
        T t;
        try {
            Input fileInputStream = getFileInputStream();
            if (fileInputStream != null) {
                try {
                    Kryo kryo = kryos.get();
                    if (kryo != null) {
                        Object classAndObject = kryo.readClassAndObject(fileInputStream);
                        t = !(classAndObject instanceof Object) ? (T) null : classAndObject;
                        if (t == null) {
                            t = this.value;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Found " + classAndObject.getClass() + " for " + this.key + ", ");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("but expecting ");
                            sb2.append(t.getClass());
                            sb2.append('\"');
                            sb.append(sb2.toString());
                            String string = sb.toString();
                            Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …              .toString()");
                            logger.invoke(6, "Unable to cast deserialized preference " + this.key + '.', new Exception(string));
                        }
                    } else {
                        t = this.value;
                    }
                    Closeable.closeFinally(fileInputStream, null);
                    if (t != null) {
                        return (T) t;
                    }
                } finally {
                }
            }
            return this.value;
        } catch (Exception e) {
            logger.invoke(5, outline.H(outline.U("Unable to deserialize preference "), this.key, '.'), new Exception(this.key, e));
            return this.value;
        }
    }

    private static /* synthetic */ void getFileValue$annotations() {
    }

    public static final Observable<Boolean> isPreloaded() {
        return INSTANCE.isPreloaded();
    }

    private final synchronized void persist() {
        if (this.valueDirty) {
            this.valueDirty = false;
            try {
                Output output = new Output(getFileOutput());
                try {
                    Kryo kryo = kryos.get();
                    if (kryo != null) {
                        kryo.writeClassAndObject(output, this.value);
                    }
                    Closeable.closeFinally(output, null);
                } finally {
                }
            } catch (Exception e) {
                logger.invoke(5, "Unable to serialize preference " + this.key + '.', new Exception(this.key, e));
            }
        }
    }

    public static final void reset() {
        INSTANCE.reset();
    }

    public static /* synthetic */ Object set$default(Persister persister, Object obj, boolean z2, int i, Object obj2) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return persister.set(obj, z2);
    }

    public final T clear() {
        return (T) clear$default(this, false, 1, null);
    }

    public final T clear(boolean persist) {
        return set(this.defaultValue, persist);
    }

    public final synchronized T get() {
        if (this.valueUnset) {
            this.valueUnset = false;
            this.value = getFileValue();
        }
        return this.value;
    }

    public final T getAndSet(Function1<? super T, ? extends T> function1) {
        return (T) getAndSet$default(this, false, function1, 1, null);
    }

    public final synchronized T getAndSet(boolean persist, Function1<? super T, ? extends T> setter) {
        Intrinsics3.checkNotNullParameter(setter, "setter");
        return set(setter.invoke(get()), persist);
    }

    public final String getKey() {
        return this.key;
    }

    public final synchronized Observable<T> getObservable() {
        Subject<T, T> subjectInvoke;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        subjectInvoke = this.valueSubject;
        if (subjectInvoke == null) {
            subjectInvoke = anonymousClass1.invoke();
            this.valueSubject = subjectInvoke;
        }
        return subjectInvoke;
    }

    public final T set(T t) {
        return (T) set$default(this, t, false, 2, null);
    }

    public final synchronized T set(T newValue, boolean persist) {
        T t;
        Intrinsics3.checkNotNullParameter(newValue, "newValue");
        this.valueDirty = true;
        this.valueUnset = false;
        t = this.value;
        this.value = newValue;
        Subject<T, T> subject = this.valueSubject;
        if (subject != null) {
            subject.onNext(newValue);
        }
        if (persist) {
            persist();
        }
        return t;
    }
}
