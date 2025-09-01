package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;

    @GuardedBy("sGnssStatusListeners")
    private static final SimpleArrayMap<Object, Object> sGnssStatusListeners = new SimpleArrayMap<>();

    /* renamed from: androidx.core.location.LocationManagerCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Consumer val$consumer;
        public final /* synthetic */ Location val$location;

        public AnonymousClass1(Consumer consumer, Location location) {
            this.val$consumer = consumer;
            this.val$location = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$consumer.accept(this.val$location);
        }
    }

    /* renamed from: androidx.core.location.LocationManagerCompat$2, reason: invalid class name */
    public class AnonymousClass2 implements CancellationSignal.OnCancelListener {
        public final /* synthetic */ CancellableLocationListener val$listener;

        public AnonymousClass2(CancellableLocationListener cancellableLocationListener) {
            this.val$listener = cancellableLocationListener;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onCancel() {
            this.val$listener.cancel();
        }
    }

    /* renamed from: androidx.core.location.LocationManagerCompat$3, reason: invalid class name */
    public class AnonymousClass3 implements Callable<Boolean> {
        public final /* synthetic */ LocationManager val$locationManager;
        public final /* synthetic */ GpsStatusTransport val$myTransport;

        public AnonymousClass3(LocationManager locationManager, GpsStatusTransport gpsStatusTransport) {
            this.val$locationManager = locationManager;
            this.val$myTransport = gpsStatusTransport;
        }

        @Override // java.util.concurrent.Callable
        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public /* bridge */ /* synthetic */ Boolean call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public Boolean call() {
            return Boolean.valueOf(this.val$locationManager.addGpsStatusListener(this.val$myTransport));
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static String getGnssHardwareModelName(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @DoNotInline
        public static int getGnssYearOfHardware(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @DoNotInline
        public static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {

        /* renamed from: androidx.core.location.LocationManagerCompat$Api30Impl$1, reason: invalid class name */
        public class AnonymousClass1 implements java.util.function.Consumer<Location> {
            public final /* synthetic */ Consumer val$consumer;

            public AnonymousClass1(Consumer consumer) {
                this.val$consumer = consumer;
            }

            @Override // java.util.function.Consumer
            public /* bridge */ /* synthetic */ void accept(Location location) {
                accept2(location);
            }

            /* renamed from: accept, reason: avoid collision after fix types in other method */
            public void accept2(Location location) {
                this.val$consumer.accept(location);
            }
        }

        private Api30Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static void getCurrentLocation(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
            locationManager.getCurrentLocation(str, cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, executor, new AnonymousClass1(consumer));
        }
    }

    public static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler = new Handler(Looper.getMainLooper());

        @Nullable
        public Runnable mTimeoutRunnable;

        @GuardedBy("this")
        private boolean mTriggered;

        /* renamed from: androidx.core.location.LocationManagerCompat$CancellableLocationListener$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
            public void run() {
                CancellableLocationListener cancellableLocationListener = CancellableLocationListener.this;
                cancellableLocationListener.mTimeoutRunnable = null;
                cancellableLocationListener.onLocationChanged((Location) null);
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$CancellableLocationListener$2, reason: invalid class name */
        public class AnonymousClass2 implements Runnable {
            public final /* synthetic */ Consumer val$consumer;
            public final /* synthetic */ Location val$location;

            public AnonymousClass2(Consumer consumer, Location location) {
                this.val$consumer = consumer;
                this.val$location = location;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$consumer.accept(this.val$location);
            }
        }

        public CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mConsumer = consumer;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable runnable = this.mTimeoutRunnable;
            if (runnable != null) {
                this.mTimeoutHandler.removeCallbacks(runnable);
                this.mTimeoutRunnable = null;
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void cancel() {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
                cleanup();
            }
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable Location location) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
                this.mExecutor.execute(new AnonymousClass2(this.mConsumer, location));
                cleanup();
            }
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String str) {
            onLocationChanged((Location) null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void startTimeout(long j) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                AnonymousClass1 anonymousClass1 = new AnonymousClass1();
                this.mTimeoutRunnable = anonymousClass1;
                this.mTimeoutHandler.postDelayed(anonymousClass1, j);
            }
        }
    }

    @RequiresApi(30)
    public static class GnssStatusTransport extends GnssStatus.Callback {
        public final GnssStatusCompat.Callback mCallback;

        public GnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            this.mCallback.onFirstFix(i);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    public static class GpsStatusTransport implements GpsStatus.Listener {
        public final GnssStatusCompat.Callback mCallback;

        @Nullable
        public volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        /* renamed from: androidx.core.location.LocationManagerCompat$GpsStatusTransport$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ Executor val$executor;

            public AnonymousClass1(Executor executor) {
                this.val$executor = executor;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GpsStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                GpsStatusTransport.this.mCallback.onStarted();
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$GpsStatusTransport$2, reason: invalid class name */
        public class AnonymousClass2 implements Runnable {
            public final /* synthetic */ Executor val$executor;

            public AnonymousClass2(Executor executor) {
                this.val$executor = executor;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GpsStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                GpsStatusTransport.this.mCallback.onStopped();
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$GpsStatusTransport$3, reason: invalid class name */
        public class AnonymousClass3 implements Runnable {
            public final /* synthetic */ Executor val$executor;
            public final /* synthetic */ int val$ttff;

            public AnonymousClass3(Executor executor, int i) {
                this.val$executor = executor;
                this.val$ttff = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GpsStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                GpsStatusTransport.this.mCallback.onFirstFix(this.val$ttff);
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$GpsStatusTransport$4, reason: invalid class name */
        public class AnonymousClass4 implements Runnable {
            public final /* synthetic */ Executor val$executor;
            public final /* synthetic */ GnssStatusCompat val$gnssStatus;

            public AnonymousClass4(Executor executor, GnssStatusCompat gnssStatusCompat) {
                this.val$executor = executor;
                this.val$gnssStatus = gnssStatusCompat;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GpsStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                GpsStatusTransport.this.mCallback.onSatelliteStatusChanged(this.val$gnssStatus);
            }
        }

        public GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        @Override // android.location.GpsStatus.Listener
        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            if (i == 1) {
                executor.execute(new AnonymousClass1(executor));
                return;
            }
            if (i == 2) {
                executor.execute(new AnonymousClass2(executor));
                return;
            }
            if (i != 3) {
                if (i == 4 && (gpsStatus = this.mLocationManager.getGpsStatus(null)) != null) {
                    executor.execute(new AnonymousClass4(executor, GnssStatusCompat.wrap(gpsStatus)));
                    return;
                }
                return;
            }
            GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus(null);
            if (gpsStatus2 != null) {
                executor.execute(new AnonymousClass3(executor, gpsStatus2.getTimeToFirstFix()));
            }
        }

        public void register(Executor executor) {
            Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    public static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        public InlineHandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else {
                if (this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                    return;
                }
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    @RequiresApi(24)
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {
        public final GnssStatusCompat.Callback mCallback;

        @Nullable
        public volatile Executor mExecutor;

        /* renamed from: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ Executor val$executor;

            public AnonymousClass1(Executor executor) {
                this.val$executor = executor;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PreRGnssStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                PreRGnssStatusTransport.this.mCallback.onStarted();
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$2, reason: invalid class name */
        public class AnonymousClass2 implements Runnable {
            public final /* synthetic */ Executor val$executor;

            public AnonymousClass2(Executor executor) {
                this.val$executor = executor;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PreRGnssStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                PreRGnssStatusTransport.this.mCallback.onStopped();
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$3, reason: invalid class name */
        public class AnonymousClass3 implements Runnable {
            public final /* synthetic */ Executor val$executor;
            public final /* synthetic */ int val$ttffMillis;

            public AnonymousClass3(Executor executor, int i) {
                this.val$executor = executor;
                this.val$ttffMillis = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PreRGnssStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                PreRGnssStatusTransport.this.mCallback.onFirstFix(this.val$ttffMillis);
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$4, reason: invalid class name */
        public class AnonymousClass4 implements Runnable {
            public final /* synthetic */ Executor val$executor;
            public final /* synthetic */ GnssStatus val$status;

            public AnonymousClass4(Executor executor, GnssStatus gnssStatus) {
                this.val$executor = executor;
                this.val$status = gnssStatus;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PreRGnssStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                PreRGnssStatusTransport.this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(this.val$status));
            }
        }

        public PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new AnonymousClass3(executor, i));
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new AnonymousClass4(executor, gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new AnonymousClass1(executor));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new AnonymousClass2(executor));
        }

        public void register(Executor executor) {
            Preconditions.checkArgument(executor != null, "invalid null executor");
            Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private LocationManagerCompat() {
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) < 10000) {
            executor.execute(new AnonymousClass1(consumer, lastKnownLocation));
            return;
        }
        CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
        locationManager.requestLocationUpdates(str, 0L, 0.0f, cancellableLocationListener, Looper.getMainLooper());
        if (cancellationSignal != null) {
            cancellationSignal.setOnCancelListener(new AnonymousClass2(cancellableLocationListener));
        }
        cancellableLocationListener.startTimeout(30000L);
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssHardwareModelName(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssYearOfHardware(locationManager);
        }
        return 0;
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.isLocationEnabled(locationManager) : locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        return Build.VERSION.SDK_INT >= 30 ? registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback) : registerGnssStatusCallback(locationManager, new InlineHandlerExecutor(handler), callback);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatus.Callback callback2 = (GnssStatusTransport) simpleArrayMap.remove(callback);
                if (callback2 != null) {
                    locationManager.unregisterGnssStatusCallback(callback2);
                }
            }
            return;
        }
        if (i >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap2.remove(callback);
                if (preRGnssStatusTransport != null) {
                    preRGnssStatusTransport.unregister();
                    locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
                }
            }
            return;
        }
        SimpleArrayMap<Object, Object> simpleArrayMap3 = sGnssStatusListeners;
        synchronized (simpleArrayMap3) {
            GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap3.remove(callback);
            if (gpsStatusTransport != null) {
                gpsStatusTransport.unregister();
                locationManager.removeGpsStatusListener(gpsStatusTransport);
            }
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, null, executor, callback);
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(looperMyLooper), executor, callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x010a A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:83:0x00e9, B:84:0x00ff, B:87:0x0102, B:89:0x010a, B:91:0x0112, B:92:0x0118, B:93:0x0119, B:94:0x011e, B:95:0x011f, B:96:0x0125, B:73:0x00d8), top: B:107:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011f A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:83:0x00e9, B:84:0x00ff, B:87:0x0102, B:89:0x010a, B:91:0x0112, B:92:0x0118, B:93:0x0119, B:94:0x011e, B:95:0x011f, B:96:0x0125, B:73:0x00d8), top: B:107:0x0098 }] */
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        boolean z2 = true;
        if (i >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatus.Callback gnssStatusTransport = (GnssStatusTransport) simpleArrayMap.get(callback);
                if (gnssStatusTransport == null) {
                    gnssStatusTransport = new GnssStatusTransport(callback);
                }
                if (!locationManager.registerGnssStatusCallback(executor, gnssStatusTransport)) {
                    return false;
                }
                simpleArrayMap.put(callback, gnssStatusTransport);
                return true;
            }
        }
        if (i >= 24) {
            Preconditions.checkArgument(handler != null);
            SimpleArrayMap<Object, Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap2.get(callback);
                if (preRGnssStatusTransport == null) {
                    preRGnssStatusTransport = new PreRGnssStatusTransport(callback);
                } else {
                    preRGnssStatusTransport.unregister();
                }
                preRGnssStatusTransport.register(executor);
                if (!locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler)) {
                    return false;
                }
                simpleArrayMap2.put(callback, preRGnssStatusTransport);
                return true;
            }
        }
        Preconditions.checkArgument(handler != null);
        SimpleArrayMap<Object, Object> simpleArrayMap3 = sGnssStatusListeners;
        synchronized (simpleArrayMap3) {
            GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap3.get(callback);
            if (gpsStatusTransport == null) {
                gpsStatusTransport = new GpsStatusTransport(locationManager, callback);
            } else {
                gpsStatusTransport.unregister();
            }
            gpsStatusTransport.register(executor);
            FutureTask futureTask = new FutureTask(new AnonymousClass3(locationManager, gpsStatusTransport));
            if (Looper.myLooper() == handler.getLooper()) {
                futureTask.run();
            } else if (!handler.post(futureTask)) {
                throw new IllegalStateException(handler + " is shutting down");
            }
            try {
                try {
                    long nanos = TimeUnit.SECONDS.toNanos(5L);
                    long jNanoTime = System.nanoTime() + nanos;
                    boolean z3 = false;
                    while (((Boolean) futureTask.get(nanos, TimeUnit.NANOSECONDS)).booleanValue()) {
                        try {
                            try {
                                sGnssStatusListeners.put(callback, gpsStatusTransport);
                                if (z3) {
                                    Thread.currentThread().interrupt();
                                }
                                return true;
                            } catch (ExecutionException e) {
                                e = e;
                                if (e.getCause() instanceof RuntimeException) {
                                    if (e.getCause() instanceof Error) {
                                        throw ((Error) e.getCause());
                                    }
                                    throw new IllegalStateException(e);
                                }
                                throw ((RuntimeException) e.getCause());
                            } catch (TimeoutException e2) {
                                e = e2;
                                throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                            }
                        } catch (InterruptedException unused) {
                            nanos = jNanoTime - System.nanoTime();
                            z3 = true;
                        } catch (ExecutionException e3) {
                            e = e3;
                            if (e.getCause() instanceof RuntimeException) {
                            }
                        } catch (TimeoutException e4) {
                            e = e4;
                            throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                        } catch (Throwable th) {
                            th = th;
                            z2 = z3;
                            if (z2) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z3) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (ExecutionException e5) {
                e = e5;
            } catch (TimeoutException e6) {
                e = e6;
            } catch (Throwable th3) {
                th = th3;
                z2 = false;
            }
        }
    }
}
