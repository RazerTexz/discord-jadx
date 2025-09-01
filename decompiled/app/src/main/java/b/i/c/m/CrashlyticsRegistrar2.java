package b.i.c.m;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.c.FirebaseApp2;
import b.i.c.j.a.a;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import b.i.c.m.d.CrashlyticsNativeComponent;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.MissingNativeComponent;
import b.i.c.m.d.Onboarding3;
import b.i.c.m.d.Onboarding4;
import b.i.c.m.d.i.BlockingAnalyticsEventLogger;
import b.i.c.m.d.i.BreadcrumbAnalyticsEventReceiver;
import b.i.c.m.d.i.CrashlyticsOriginAnalyticsEventLogger;
import b.i.c.m.d.i.UnavailableAnalyticsEventLogger;
import b.i.c.m.d.j.DisabledBreadcrumbSource;
import b.i.c.m.d.k.AppData;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.k.CrashlyticsCore3;
import b.i.c.m.d.k.CrashlyticsCore4;
import b.i.c.m.d.k.CrashlyticsFileMarker;
import b.i.c.m.d.k.CrashlyticsUncaughtExceptionHandler;
import b.i.c.m.d.k.DataCollectionArbiter;
import b.i.c.m.d.k.DeliveryMechanism;
import b.i.c.m.d.k.IdManager;
import b.i.c.m.d.k.SystemCurrentTimeProvider;
import b.i.c.m.d.k.Utils3;
import b.i.c.m.d.k.b0;
import b.i.c.m.d.k.r;
import b.i.c.m.d.k.x;
import b.i.c.m.d.n.HttpRequestFactory;
import b.i.c.m.d.o.FileStoreImpl;
import b.i.c.m.d.s.CachedSettingsIo;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.s.SettingsJsonParser;
import b.i.c.m.d.s.h.SettingsRequest;
import b.i.c.m.d.s.i.DefaultSettingsSpiCall;
import b.i.c.m.d.u.ResourceUnityVersionProvider;
import b.i.c.u.g;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: CrashlyticsRegistrar.java */
/* renamed from: b.i.c.m.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsRegistrar2 implements ComponentFactory {
    public final CrashlyticsRegistrar a;

    public CrashlyticsRegistrar2(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.a = crashlyticsRegistrar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03a0  */
    /* JADX WARN: Type inference failed for: r3v21, types: [b.i.c.m.d.i.b, b.i.c.m.d.i.d] */
    /* JADX WARN: Type inference failed for: r4v31, types: [b.i.c.m.d.i.b, b.i.c.m.d.i.c] */
    /* JADX WARN: Type inference failed for: r5v7, types: [b.i.c.m.d.i.e] */
    @Override // b.i.c.l.ComponentFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(ComponentContainer componentContainer) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        DisabledBreadcrumbSource disabledBreadcrumbSource;
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger;
        boolean z2;
        String str;
        boolean z3;
        ExecutorService executorService;
        boolean z4;
        FileStoreImpl fileStoreImpl;
        HttpRequestFactory httpRequestFactory;
        ResourceUnityVersionProvider resourceUnityVersionProvider;
        String packageName;
        String strC;
        String string;
        String str2;
        boolean zExists;
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger2;
        DisabledBreadcrumbSource disabledBreadcrumbSource2;
        Objects.requireNonNull(this.a);
        FirebaseApp2 firebaseApp2 = (FirebaseApp2) componentContainer.a(FirebaseApp2.class);
        CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent) componentContainer.a(CrashlyticsNativeComponent.class);
        b.i.c.j.a.a aVar = (b.i.c.j.a.a) componentContainer.a(b.i.c.j.a.a.class);
        g gVar = (g) componentContainer.a(g.class);
        firebaseApp2.a();
        Context context = firebaseApp2.d;
        IdManager idManager = new IdManager(context, context.getPackageName(), gVar);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp2);
        CrashlyticsNativeComponent missingNativeComponent = crashlyticsNativeComponent == null ? new MissingNativeComponent() : crashlyticsNativeComponent;
        Onboarding4 onboarding4 = new Onboarding4(firebaseApp2, context, idManager, dataCollectionArbiter);
        if (aVar != null) {
            Logger3 logger3 = Logger3.a;
            logger3.b("Firebase Analytics is available.");
            ?? crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(aVar);
            CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
            a.InterfaceC0046a interfaceC0046aC = aVar.c("clx", crashlyticsAnalyticsListener);
            if (interfaceC0046aC == null) {
                logger3.b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
                interfaceC0046aC = aVar.c("crash", crashlyticsAnalyticsListener);
                if (interfaceC0046aC != null) {
                    logger3.g("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
                }
            }
            if (interfaceC0046aC != null) {
                logger3.b("Firebase Analytics listener registered successfully.");
                ?? breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
                ?? blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
                crashlyticsAnalyticsListener.f1672b = breadcrumbAnalyticsEventReceiver;
                crashlyticsAnalyticsListener.a = blockingAnalyticsEventLogger;
                unavailableAnalyticsEventLogger2 = blockingAnalyticsEventLogger;
                disabledBreadcrumbSource2 = breadcrumbAnalyticsEventReceiver;
            } else {
                logger3.b("Firebase Analytics listener registration failed.");
                disabledBreadcrumbSource2 = new DisabledBreadcrumbSource();
                unavailableAnalyticsEventLogger2 = crashlyticsOriginAnalyticsEventLogger;
            }
            disabledBreadcrumbSource = disabledBreadcrumbSource2;
            unavailableAnalyticsEventLogger = unavailableAnalyticsEventLogger2;
        } else {
            Logger3.a.b("Firebase Analytics is unavailable.");
            disabledBreadcrumbSource = new DisabledBreadcrumbSource();
            unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
        }
        CrashlyticsCore3 crashlyticsCore3 = new CrashlyticsCore3(firebaseApp2, idManager, missingNativeComponent, dataCollectionArbiter, disabledBreadcrumbSource, unavailableAnalyticsEventLogger, f.n("Crashlytics Exception Handler"));
        try {
            onboarding4.i = onboarding4.l.c();
            onboarding4.d = context.getPackageManager();
            String packageName2 = context.getPackageName();
            onboarding4.e = packageName2;
            PackageInfo packageInfo = onboarding4.d.getPackageInfo(packageName2, 0);
            onboarding4.f = packageInfo;
            onboarding4.g = Integer.toString(packageInfo.versionCode);
            String str3 = onboarding4.f.versionName;
            if (str3 == null) {
                str3 = "0.0";
            }
            onboarding4.h = str3;
            onboarding4.j = onboarding4.d.getApplicationLabel(context.getApplicationInfo()).toString();
            onboarding4.k = Integer.toString(context.getApplicationInfo().targetSdkVersion);
            z2 = true;
        } catch (PackageManager.NameNotFoundException e) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Failed init", e);
            }
            z2 = false;
        }
        if (!z2) {
            Logger3.a.d("Unable to start Crashlytics.");
            return null;
        }
        ExecutorService executorServiceN = f.n("com.google.firebase.crashlytics.startup");
        firebaseApp2.a();
        String str4 = firebaseApp2.f.f1655b;
        IdManager idManager2 = onboarding4.l;
        HttpRequestFactory httpRequestFactory2 = onboarding4.a;
        String str5 = onboarding4.g;
        String str6 = onboarding4.h;
        String strC2 = onboarding4.c();
        DataCollectionArbiter dataCollectionArbiter2 = onboarding4.m;
        String strC3 = idManager2.c();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        SettingsJsonParser settingsJsonParser = new SettingsJsonParser(systemCurrentTimeProvider);
        CachedSettingsIo cachedSettingsIo = new CachedSettingsIo(context);
        Locale locale = Locale.US;
        SettingsController settingsController = new SettingsController(context, new SettingsRequest(str4, String.format(locale, "%s/%s", idManager2.e(Build.MANUFACTURER), idManager2.e(Build.MODEL)), idManager2.e(Build.VERSION.INCREMENTAL), idManager2.e(Build.VERSION.RELEASE), idManager2, CommonUtils.f(CommonUtils.l(context), str4, str6, str5), str6, str5, DeliveryMechanism.f(strC3).g()), systemCurrentTimeProvider, settingsJsonParser, cachedSettingsIo, new DefaultSettingsSpiCall(strC2, String.format(locale, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str4), httpRequestFactory2), dataCollectionArbiter2);
        settingsController.d(1, executorServiceN).i(executorServiceN, new Onboarding3(onboarding4));
        String strL = CommonUtils.l(crashlyticsCore3.a);
        Logger3 logger32 = Logger3.a;
        outline.o0("Mapping file ID is: ", strL, logger32);
        if (CommonUtils.j(crashlyticsCore3.a, "com.crashlytics.RequireBuildId", true)) {
            if (CommonUtils.t(strL)) {
                str = "FirebaseCrashlytics";
                Log.e(str, ".");
                Log.e(str, ".     |  | ");
                Log.e(str, ".     |  |");
                Log.e(str, ".     |  |");
                Log.e(str, ".   \\ |  | /");
                Log.e(str, ".    \\    /");
                Log.e(str, ".     \\  /");
                Log.e(str, ".      \\/");
                Log.e(str, ".");
                Log.e(str, "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
                Log.e(str, ".");
                Log.e(str, ".      /\\");
                Log.e(str, ".     /  \\");
                Log.e(str, ".    /    \\");
                Log.e(str, ".   / |  | \\");
                Log.e(str, ".     |  |");
                Log.e(str, ".     |  |");
                Log.e(str, ".     |  |");
                Log.e(str, ".");
                z3 = false;
            }
            if (z3) {
                throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
            }
            FirebaseApp2 firebaseApp22 = crashlyticsCore3.f1689b;
            firebaseApp22.a();
            String str7 = firebaseApp22.f.f1655b;
            try {
                logger32.f("Initializing Crashlytics 17.3.0");
                Context context2 = crashlyticsCore3.a;
                fileStoreImpl = new FileStoreImpl(context2);
                crashlyticsCore3.f = new CrashlyticsFileMarker("crash_marker", fileStoreImpl);
                crashlyticsCore3.e = new CrashlyticsFileMarker("initialization_marker", fileStoreImpl);
                httpRequestFactory = new HttpRequestFactory();
                resourceUnityVersionProvider = new ResourceUnityVersionProvider(context2);
                IdManager idManager3 = crashlyticsCore3.i;
                packageName = context2.getPackageName();
                strC = idManager3.c();
                PackageInfo packageInfo2 = context2.getPackageManager().getPackageInfo(packageName, 0);
                string = Integer.toString(packageInfo2.versionCode);
                str2 = packageInfo2.versionName;
                if (str2 == null) {
                    str2 = "0.0";
                }
                executorService = executorServiceN;
            } catch (Exception e2) {
                e = e2;
                executorService = executorServiceN;
            }
            try {
                AppData appData = new AppData(str7, strL, strC, packageName, string, str2, resourceUnityVersionProvider);
                logger32.b("Installer package name is: " + strC);
                crashlyticsCore3.h = new x(crashlyticsCore3.a, crashlyticsCore3.m, httpRequestFactory, crashlyticsCore3.i, crashlyticsCore3.c, fileStoreImpl, crashlyticsCore3.f, appData, null, null, crashlyticsCore3.n, crashlyticsCore3.k, settingsController);
                zExists = crashlyticsCore3.e.b().exists();
                try {
                    crashlyticsCore3.g = Boolean.TRUE.equals((Boolean) Utils3.a(crashlyticsCore3.m.b(new CrashlyticsCore4(crashlyticsCore3))));
                } catch (Exception unused) {
                    crashlyticsCore3.g = false;
                }
                x xVar = crashlyticsCore3.h;
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                xVar.m.b(new r(xVar));
                CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new b0(xVar), settingsController, defaultUncaughtExceptionHandler);
                xVar.B = crashlyticsUncaughtExceptionHandler;
                Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
            } catch (Exception e3) {
                e = e3;
                if (Logger3.a.a(6)) {
                    Log.e(str, "Crashlytics was not started due to an exception during initialization", e);
                }
                crashlyticsCore3.h = null;
                z4 = false;
                f.o(executorService, new FirebaseCrashlytics2(onboarding4, executorService, settingsController, z4, crashlyticsCore3));
                return new FirebaseCrashlytics(crashlyticsCore3);
            }
            if (!zExists || !CommonUtils.b(crashlyticsCore3.a)) {
                Logger3.a.b("Exception handling initialization successful");
                z4 = true;
                f.o(executorService, new FirebaseCrashlytics2(onboarding4, executorService, settingsController, z4, crashlyticsCore3));
                return new FirebaseCrashlytics(crashlyticsCore3);
            }
            Logger3.a.b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            crashlyticsCore3.b(settingsController);
            z4 = false;
            f.o(executorService, new FirebaseCrashlytics2(onboarding4, executorService, settingsController, z4, crashlyticsCore3));
            return new FirebaseCrashlytics(crashlyticsCore3);
        }
        logger32.b("Configured not to require a build ID.");
        z3 = true;
        str = "FirebaseCrashlytics";
        if (z3) {
        }
    }
}
