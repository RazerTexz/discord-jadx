package b.i.c.m.d.k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import b.i.a.b.Encoding2;
import b.i.a.b.Transformer;
import b.i.a.b.TransportFactory;
import b.i.a.b.i.CCTDestination;
import b.i.a.b.j.TransportFactoryImpl;
import b.i.a.b.j.TransportRuntime;
import b.i.c.m.d.CrashlyticsNativeComponent;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.NativeSessionFileProvider;
import b.i.c.m.d.i.AnalyticsEventLogger;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.l.LogFileManager;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_FilesPayload;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Application;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Device;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import b.i.c.m.d.m.CrashlyticsReport;
import b.i.c.m.d.m.ImmutableList3;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import b.i.c.m.d.n.HttpRequestFactory;
import b.i.c.m.d.o.CrashlyticsReportPersistence2;
import b.i.c.m.d.o.CrashlyticsReportPersistence7;
import b.i.c.m.d.o.FileStoreImpl;
import b.i.c.m.d.p.ByteString2;
import b.i.c.m.d.p.ClsFileOutputStream;
import b.i.c.m.d.p.CodedOutputStream2;
import b.i.c.m.d.p.SessionProtobufHelper;
import b.i.c.m.d.q.ReportManager;
import b.i.c.m.d.q.ReportUploader;
import b.i.c.m.d.q.c.Report2;
import b.i.c.m.d.r.DataTransportCrashlyticsReportSender3;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.s.SettingsDataProvider;
import b.i.c.m.d.s.h.AppSettingsData;
import b.i.c.m.d.t.MiddleOutFallbackStrategy;
import b.i.c.m.d.t.RemoveRepeatsStrategy;
import b.i.c.m.d.t.StackTraceTrimmingStrategy;
import b.i.c.m.d.t.TrimmedThrowableData;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes3.dex */
public class x {
    public static final FilenameFilter a = new a("BeginSession");

    /* renamed from: b, reason: collision with root package name */
    public static final FilenameFilter f1699b = new b();
    public static final Comparator<File> c = new c();
    public static final Comparator<File> d = new d();
    public static final Pattern e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    public static final Map<String, String> f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    public static final String[] g = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    public final SessionReportingCoordinator3 A;
    public CrashlyticsUncaughtExceptionHandler B;
    public final Context i;
    public final DataCollectionArbiter j;
    public final CrashlyticsFileMarker k;
    public final UserMetadata l;
    public final CrashlyticsBackgroundWorker m;
    public final HttpRequestFactory n;
    public final IdManager o;
    public final FileStoreImpl p;
    public final AppData q;

    /* renamed from: s, reason: collision with root package name */
    public final j f1700s;
    public final LogFileManager t;
    public final ReportManager u;
    public final ReportUploader.a v;
    public final CrashlyticsNativeComponent w;

    /* renamed from: x, reason: collision with root package name */
    public final StackTraceTrimmingStrategy f1701x;

    /* renamed from: y, reason: collision with root package name */
    public final String f1702y;

    /* renamed from: z, reason: collision with root package name */
    public final AnalyticsEventLogger f1703z;
    public final AtomicInteger h = new AtomicInteger(0);
    public TaskCompletionSource<Boolean> C = new TaskCompletionSource<>();
    public TaskCompletionSource<Boolean> D = new TaskCompletionSource<>();
    public TaskCompletionSource<Void> E = new TaskCompletionSource<>();
    public AtomicBoolean F = new AtomicBoolean(false);
    public final ReportUploader.b r = new h0(this);

    /* compiled from: CrashlyticsController.java */
    public class a extends h {
        public a(String str) {
            super(str);
        }

        @Override // b.i.c.m.d.k.x.h, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    }

    /* compiled from: CrashlyticsController.java */
    public class b implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    }

    /* compiled from: CrashlyticsController.java */
    public class c implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    public class d implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    public class e implements b.i.a.f.n.f<Boolean, Void> {
        public final /* synthetic */ Task a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f1704b;

        public e(Task task, float f) {
            this.a = task;
            this.f1704b = f;
        }

        @Override // b.i.a.f.n.f
        @NonNull
        public Task<Void> a(@Nullable Boolean bool) throws Exception {
            return x.this.m.c(new g0(this, bool));
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static class f implements FilenameFilter {
        public f(a aVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !((b) x.f1699b).accept(file, str) && x.e.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsController.java */
    public interface g {
        void a(CodedOutputStream2 codedOutputStream2) throws Exception;
    }

    /* compiled from: CrashlyticsController.java */
    public static class h implements FilenameFilter {
        public final String a;

        public h(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.a) && !str.endsWith(".cls_temp");
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static class i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ((ClsFileOutputStream.a) ClsFileOutputStream.j).accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static final class j implements LogFileManager.b {
        public final FileStoreImpl a;

        public j(FileStoreImpl fileStoreImpl) {
            this.a = fileStoreImpl;
        }

        public File a() {
            File file = new File(this.a.a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* compiled from: CrashlyticsController.java */
    public final class k implements ReportUploader.c {
        public k(a aVar) {
        }
    }

    /* compiled from: CrashlyticsController.java */
    public final class l implements ReportUploader.a {
        public l(a aVar) {
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static final class m implements Runnable {
        public final Context j;
        public final Report2 k;
        public final ReportUploader l;
        public final boolean m;

        public m(Context context, Report2 report2, ReportUploader reportUploader, boolean z2) {
            this.j = context;
            this.k = report2;
            this.l = reportUploader;
            this.m = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CommonUtils.b(this.j)) {
                Logger3.a.b("Attempting to send crash report at time of crash...");
                this.l.a(this.k, this.m);
            }
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static class n implements FilenameFilter {
        public final String a;

        public n(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(".cls");
            return (str.equals(sb.toString()) || !str.contains(this.a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    public x(Context context, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, HttpRequestFactory httpRequestFactory, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStoreImpl fileStoreImpl, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, ReportManager reportManager, ReportUploader.b bVar, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger, SettingsDataProvider settingsDataProvider) {
        this.i = context;
        this.m = crashlyticsBackgroundWorker;
        this.n = httpRequestFactory;
        this.o = idManager;
        this.j = dataCollectionArbiter;
        this.p = fileStoreImpl;
        this.k = crashlyticsFileMarker;
        this.q = appData;
        this.w = crashlyticsNativeComponent;
        this.f1702y = appData.g.a();
        this.f1703z = analyticsEventLogger;
        UserMetadata userMetadata = new UserMetadata();
        this.l = userMetadata;
        j jVar = new j(fileStoreImpl);
        this.f1700s = jVar;
        LogFileManager logFileManager = new LogFileManager(context, jVar);
        this.t = logFileManager;
        this.u = new ReportManager(new k(null));
        this.v = new l(null);
        MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
        this.f1701x = middleOutFallbackStrategy;
        File file = new File(new File(fileStoreImpl.a.getFilesDir(), ".com.google.firebase.crashlytics").getPath());
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = new CrashlyticsReportDataCapture(context, idManager, appData, middleOutFallbackStrategy);
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = new CrashlyticsReportPersistence7(file, settingsDataProvider);
        CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform8 = DataTransportCrashlyticsReportSender3.a;
        TransportRuntime.b(context);
        TransportFactory transportFactoryC = TransportRuntime.a().c(new CCTDestination(DataTransportCrashlyticsReportSender3.f1746b, DataTransportCrashlyticsReportSender3.c));
        Encoding2 encoding2 = new Encoding2("json");
        Transformer<CrashlyticsReport, byte[]> transformer = DataTransportCrashlyticsReportSender3.d;
        this.A = new SessionReportingCoordinator3(crashlyticsReportDataCapture, crashlyticsReportPersistence7, new DataTransportCrashlyticsReportSender3(((TransportFactoryImpl) transportFactoryC).a("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, encoding2, transformer), transformer), logFileManager, userMetadata);
    }

    public static void A(CodedOutputStream2 codedOutputStream2, File file) throws Throwable {
        if (!file.exists()) {
            Logger3 logger3 = Logger3.a;
            StringBuilder sbU = outline.U("Tried to include a file that doesn't exist: ");
            sbU.append(file.getName());
            logger3.d(sbU.toString());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                e(fileInputStream2, codedOutputStream2, (int) file.length());
                CommonUtils.c(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                CommonUtils.c(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(x xVar) throws Exception {
        String str;
        String str2;
        Integer num;
        Objects.requireNonNull(xVar);
        long j2 = j();
        new CLSUUID(xVar.o);
        String str3 = CLSUUID.f1684b;
        Logger3 logger3 = Logger3.a;
        outline.o0("Opening a new session with ID ", str3, logger3);
        xVar.w.h(str3);
        Locale locale = Locale.US;
        String str4 = String.format(locale, "Crashlytics Android SDK/%s", "17.3.0");
        xVar.z(str3, "BeginSession", new u(xVar, str3, str4, j2));
        xVar.w.d(str3, str4, j2);
        IdManager idManager = xVar.o;
        String str5 = idManager.e;
        AppData appData = xVar.q;
        String str6 = appData.e;
        String str7 = appData.f;
        String strB = idManager.b();
        int iG = DeliveryMechanism.f(xVar.q.c).g();
        xVar.z(str3, "SessionApp", new v(xVar, str5, str6, str7, strB, iG));
        xVar.w.f(str3, str5, str6, str7, strB, iG, xVar.f1702y);
        String str8 = Build.VERSION.RELEASE;
        String str9 = Build.VERSION.CODENAME;
        boolean zU = CommonUtils.u(xVar.i);
        xVar.z(str3, "SessionOS", new w(xVar, str8, str9, zU));
        xVar.w.g(str3, str8, str9, zU);
        Context context = xVar.i;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        CommonUtils.b bVar = CommonUtils.b.UNKNOWN;
        String str10 = Build.CPU_ABI;
        if (TextUtils.isEmpty(str10)) {
            logger3.b("Architecture#getValue()::Build.CPU_ABI returned null or empty");
        } else {
            CommonUtils.b bVar2 = CommonUtils.b.t.get(str10.toLowerCase(locale));
            if (bVar2 != null) {
                bVar = bVar2;
            }
        }
        int iOrdinal = bVar.ordinal();
        String str11 = Build.MODEL;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jP = CommonUtils.p();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean zS = CommonUtils.s(context);
        int iK = CommonUtils.k(context);
        String str12 = Build.MANUFACTURER;
        String str13 = Build.PRODUCT;
        xVar.z(str3, "SessionDevice", new y(xVar, iOrdinal, str11, iAvailableProcessors, jP, blockCount, zS, iK, str12, str13));
        xVar.w.c(str3, iOrdinal, str11, iAvailableProcessors, jP, blockCount, zS, iK, str12, str13);
        xVar.t.a(str3);
        SessionReportingCoordinator3 sessionReportingCoordinator3 = xVar.A;
        String strT = t(str3);
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = sessionReportingCoordinator3.a;
        Objects.requireNonNull(crashlyticsReportDataCapture);
        Charset charset = CrashlyticsReport.a;
        AutoValue_CrashlyticsReport.b bVar3 = new AutoValue_CrashlyticsReport.b();
        bVar3.a = "17.3.0";
        String str14 = crashlyticsReportDataCapture.e.a;
        Objects.requireNonNull(str14, "Null gmpAppId");
        bVar3.f1714b = str14;
        String strB2 = crashlyticsReportDataCapture.d.b();
        Objects.requireNonNull(strB2, "Null installationUuid");
        bVar3.d = strB2;
        String str15 = crashlyticsReportDataCapture.e.e;
        Objects.requireNonNull(str15, "Null buildVersion");
        bVar3.e = str15;
        String str16 = crashlyticsReportDataCapture.e.f;
        Objects.requireNonNull(str16, "Null displayVersion");
        bVar3.f = str16;
        bVar3.c = 4;
        AutoValue_CrashlyticsReport_Session.b bVar4 = new AutoValue_CrashlyticsReport_Session.b();
        bVar4.b(false);
        bVar4.c = Long.valueOf(j2);
        Objects.requireNonNull(strT, "Null identifier");
        bVar4.f1719b = strT;
        String str17 = CrashlyticsReportDataCapture.a;
        Objects.requireNonNull(str17, "Null generator");
        bVar4.a = str17;
        String str18 = crashlyticsReportDataCapture.d.e;
        Objects.requireNonNull(str18, "Null identifier");
        String str19 = crashlyticsReportDataCapture.e.e;
        Objects.requireNonNull(str19, "Null version");
        String str20 = crashlyticsReportDataCapture.e.f;
        String strB3 = crashlyticsReportDataCapture.d.b();
        String strA = crashlyticsReportDataCapture.e.g.a();
        if (strA != null) {
            str2 = strA;
            str = "Unity";
        } else {
            str = null;
            str2 = null;
        }
        bVar4.f = new AutoValue_CrashlyticsReport_Session_Application(str18, str19, str20, null, strB3, str, str2, null);
        Integer num2 = 3;
        Objects.requireNonNull(str8, "Null version");
        Objects.requireNonNull(str9, "Null buildVersion");
        Boolean boolValueOf = Boolean.valueOf(CommonUtils.u(crashlyticsReportDataCapture.c));
        String strW = num2 == null ? " platform" : "";
        if (boolValueOf == null) {
            strW = outline.w(strW, " jailbroken");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }
        bVar4.h = new AutoValue_CrashlyticsReport_Session_OperatingSystem(num2.intValue(), str8, str9, boolValueOf.booleanValue(), null);
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int iIntValue = 7;
        if (!TextUtils.isEmpty(str10) && (num = CrashlyticsReportDataCapture.f1691b.get(str10.toLowerCase(locale))) != null) {
            iIntValue = num.intValue();
        }
        int iAvailableProcessors2 = Runtime.getRuntime().availableProcessors();
        long jP2 = CommonUtils.p();
        long blockCount2 = statFs2.getBlockCount() * statFs2.getBlockSize();
        boolean zS2 = CommonUtils.s(crashlyticsReportDataCapture.c);
        int iK2 = CommonUtils.k(crashlyticsReportDataCapture.c);
        AutoValue_CrashlyticsReport_Session_Device.b bVar5 = new AutoValue_CrashlyticsReport_Session_Device.b();
        bVar5.a = Integer.valueOf(iIntValue);
        Objects.requireNonNull(str11, "Null model");
        bVar5.f1722b = str11;
        bVar5.c = Integer.valueOf(iAvailableProcessors2);
        bVar5.d = Long.valueOf(jP2);
        bVar5.e = Long.valueOf(blockCount2);
        bVar5.f = Boolean.valueOf(zS2);
        bVar5.g = Integer.valueOf(iK2);
        Objects.requireNonNull(str12, "Null manufacturer");
        bVar5.h = str12;
        Objects.requireNonNull(str13, "Null modelClass");
        bVar5.i = str13;
        bVar4.i = bVar5.a();
        bVar4.k = 3;
        bVar3.g = bVar4.a();
        CrashlyticsReport crashlyticsReportA = bVar3.a();
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = sessionReportingCoordinator3.f1680b;
        Objects.requireNonNull(crashlyticsReportPersistence7);
        CrashlyticsReport.d dVarH = crashlyticsReportA.h();
        if (dVarH == null) {
            logger3.b("Could not get session for report");
            return;
        }
        String strG = dVarH.g();
        try {
            File fileH = crashlyticsReportPersistence7.h(strG);
            CrashlyticsReportPersistence7.i(fileH);
            CrashlyticsReportPersistence7.l(new File(fileH, "report"), CrashlyticsReportPersistence7.c.g(crashlyticsReportA));
        } catch (IOException e2) {
            Logger3.a.c("Could not persist report for session " + strG, e2);
        }
    }

    public static Task b(x xVar) throws NumberFormatException, ClassNotFoundException {
        boolean z2;
        Task taskO;
        Objects.requireNonNull(xVar);
        ArrayList arrayList = new ArrayList();
        for (File file : r(xVar.l(), b.i.c.m.d.k.m.a)) {
            try {
                long j2 = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    z2 = true;
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                if (z2) {
                    Logger3.a.b("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
                    taskO = b.i.a.f.e.o.f.Z(null);
                } else {
                    taskO = b.i.a.f.e.o.f.o(new ScheduledThreadPoolExecutor(1), new a0(xVar, j2));
                }
                arrayList.add(taskO);
            } catch (NumberFormatException unused2) {
                Logger3 logger3 = Logger3.a;
                StringBuilder sbU = outline.U("Could not parse timestamp from file ");
                sbU.append(file.getName());
                logger3.b(sbU.toString());
            }
            file.delete();
        }
        return b.i.a.f.e.o.f.B1(arrayList);
    }

    public static void c(@Nullable String str, @NonNull File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (str == null) {
            return;
        }
        CodedOutputStream2 codedOutputStream2I = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                codedOutputStream2I = CodedOutputStream2.i(fileOutputStream);
                ByteString2 byteString2 = SessionProtobufHelper.a;
                ByteString2 byteString2A = ByteString2.a(str);
                codedOutputStream2I.r(7, 2);
                int iB = CodedOutputStream2.b(2, byteString2A);
                codedOutputStream2I.o(CodedOutputStream2.d(iB) + CodedOutputStream2.e(5) + iB);
                codedOutputStream2I.r(5, 2);
                codedOutputStream2I.o(iB);
                codedOutputStream2I.l(2, byteString2A);
                StringBuilder sbU = outline.U("Failed to flush to append to ");
                sbU.append(file.getPath());
                CommonUtils.h(codedOutputStream2I, sbU.toString());
                CommonUtils.c(fileOutputStream, "Failed to close " + file.getPath());
            } catch (Throwable th) {
                th = th;
                StringBuilder sbU2 = outline.U("Failed to flush to append to ");
                sbU2.append(file.getPath());
                CommonUtils.h(codedOutputStream2I, sbU2.toString());
                CommonUtils.c(fileOutputStream, "Failed to close " + file.getPath());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void e(InputStream inputStream, CodedOutputStream2 codedOutputStream2, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i3, i2 - i3);
            if (i4 < 0) {
                break;
            } else {
                i3 += i4;
            }
        }
        Objects.requireNonNull(codedOutputStream2);
        int i5 = codedOutputStream2.k;
        int i6 = codedOutputStream2.l;
        int i7 = i5 - i6;
        if (i7 >= i2) {
            System.arraycopy(bArr, 0, codedOutputStream2.j, i6, i2);
            codedOutputStream2.l += i2;
            return;
        }
        System.arraycopy(bArr, 0, codedOutputStream2.j, i6, i7);
        int i8 = i7 + 0;
        int i9 = i2 - i7;
        codedOutputStream2.l = codedOutputStream2.k;
        codedOutputStream2.j();
        if (i9 > codedOutputStream2.k) {
            codedOutputStream2.m.write(bArr, i8, i9);
        } else {
            System.arraycopy(bArr, i8, codedOutputStream2.j, 0, i9);
            codedOutputStream2.l = i9;
        }
    }

    public static long j() {
        return new Date().getTime() / 1000;
    }

    public static String o(File file) {
        return file.getName().substring(0, 35);
    }

    public static File[] r(File file, FilenameFilter filenameFilter) {
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    @NonNull
    public static String t(@NonNull String str) {
        return str.replaceAll("-", "");
    }

    public static void x(CodedOutputStream2 codedOutputStream2, File[] fileArr, String str) throws Throwable {
        Arrays.sort(fileArr, CommonUtils.c);
        for (File file : fileArr) {
            try {
                Logger3.a.b(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                A(codedOutputStream2, file);
            } catch (Exception e2) {
                if (Logger3.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Error writting non-fatal to session.", e2);
                }
            }
        }
    }

    public final void d(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream == null) {
            return;
        }
        try {
            clsFileOutputStream.a();
        } catch (IOException e2) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Error closing session file stream in the presence of an exception", e2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04a2 A[LOOP:6: B:151:0x04a0->B:152:0x04a2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0646 A[Catch: IOException -> 0x0685, TryCatch #14 {IOException -> 0x0685, blocks: (B:217:0x062d, B:219:0x0646, B:222:0x0669, B:223:0x067d, B:224:0x0684), top: B:250:0x062d }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x067d A[Catch: IOException -> 0x0685, TryCatch #14 {IOException -> 0x0685, blocks: (B:217:0x062d, B:219:0x0646, B:222:0x0669, B:223:0x067d, B:224:0x0684), top: B:250:0x062d }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x06c0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x06d8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x030e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(int i2, boolean z2) throws Exception {
        FileInputStream fileInputStream;
        UserMetadata userMetadata;
        int i3;
        List<File> listF;
        int size;
        String strJ;
        File file;
        String str;
        CrashlyticsReport crashlyticsReportJ;
        CodedOutputStream2 codedOutputStream2I;
        ClsFileOutputStream clsFileOutputStream;
        String str2;
        InputStream inputStreamH;
        int i4 = i2;
        int i5 = (z2 ? 1 : 0) + 8;
        HashSet hashSet = new HashSet();
        File[] fileArrS = s();
        int iMin = Math.min(i5, fileArrS.length);
        for (int i6 = 0; i6 < iMin; i6++) {
            hashSet.add(o(fileArrS[i6]));
        }
        File[] fileArrListFiles = ((j) this.t.c).a().listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                int iLastIndexOf = name.lastIndexOf(".temp");
                if (iLastIndexOf != -1) {
                    name = name.substring(20, iLastIndexOf);
                }
                if (!hashSet.contains(name)) {
                    file2.delete();
                }
            }
        }
        FileInputStream fileInputStream2 = null;
        for (File file3 : r(l(), new f(null))) {
            String name2 = file3.getName();
            Matcher matcher = e.matcher(name2);
            if (!matcher.matches()) {
                Logger3.a.b("Deleting unknown file: " + name2);
                file3.delete();
            } else if (!hashSet.contains(matcher.group(1))) {
                Logger3.a.b("Trimming session file: " + name2);
                file3.delete();
            }
        }
        File[] fileArrS2 = s();
        if (fileArrS2.length <= z2) {
            Logger3.a.b("No open sessions to be closed.");
            return;
        }
        String strO = o(fileArrS2[z2 ? 1 : 0]);
        if (p()) {
            userMetadata = this.l;
        } else {
            File fileB = new MetaDataStore2(l()).b(strO);
            if (fileB.exists()) {
                try {
                    try {
                        fileInputStream = new FileInputStream(fileB);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                }
                try {
                    userMetadata = MetaDataStore2.c(CommonUtils.x(fileInputStream));
                    CommonUtils.c(fileInputStream, "Failed to close user metadata file.");
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    if (Logger3.a.a(6)) {
                        Log.e("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                    }
                    CommonUtils.c(fileInputStream2, "Failed to close user metadata file.");
                    userMetadata = new UserMetadata();
                    z(strO, "SessionUser", new z(this, userMetadata));
                    String str3 = "report";
                    String str4 = "user";
                    if (this.w.e(strO)) {
                    }
                    Logger3.a.b("Closing open sessions.");
                    i3 = z2 ? 1 : 0;
                    while (i3 < fileArrS2.length) {
                    }
                    String str5 = str3;
                    String str6 = str4;
                    if (z2 == 0) {
                    }
                    SessionReportingCoordinator3 sessionReportingCoordinator3 = this.A;
                    long j2 = j();
                    CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = sessionReportingCoordinator3.f1680b;
                    listF = CrashlyticsReportPersistence7.f(crashlyticsReportPersistence7.g, new CrashlyticsReportPersistence2(strT));
                    Collections.sort(listF, CrashlyticsReportPersistence7.d);
                    if (listF.size() > 8) {
                    }
                    while (r6.hasNext()) {
                    }
                    Objects.requireNonNull(((SettingsController) crashlyticsReportPersistence7.k).c().b());
                    ArrayList arrayList = (ArrayList) crashlyticsReportPersistence7.e();
                    size = arrayList.size();
                    if (size > 4) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.c(fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } else {
                userMetadata = new UserMetadata();
            }
        }
        z(strO, "SessionUser", new z(this, userMetadata));
        String str32 = "report";
        String str42 = "user";
        if (this.w.e(strO)) {
            Logger3 logger3 = Logger3.a;
            outline.o0("Finalizing native report for session ", strO, logger3);
            NativeSessionFileProvider nativeSessionFileProviderB = this.w.b(strO);
            File fileD = nativeSessionFileProviderB.d();
            if (fileD == null || !fileD.exists()) {
                logger3.g("No minidump data found for session " + strO);
            } else {
                long jLastModified = fileD.lastModified();
                LogFileManager logFileManager = new LogFileManager(this.i, this.f1700s, strO);
                File file4 = new File(m(), strO);
                if (file4.mkdirs()) {
                    g(jLastModified);
                    File fileL = l();
                    byte[] bArrC = logFileManager.d.c();
                    MetaDataStore2 metaDataStore2 = new MetaDataStore2(fileL);
                    File fileB2 = metaDataStore2.b(strO);
                    File fileA = metaDataStore2.a(strO);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArrC));
                    arrayList2.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProviderB.f()));
                    arrayList2.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProviderB.e()));
                    arrayList2.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProviderB.a()));
                    arrayList2.add(new FileBackedNativeSessionFile("device_meta_file", "device", nativeSessionFileProviderB.c()));
                    arrayList2.add(new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProviderB.b()));
                    arrayList2.add(new FileBackedNativeSessionFile("minidump_file", "minidump", nativeSessionFileProviderB.d()));
                    arrayList2.add(new FileBackedNativeSessionFile("user_meta_file", "user", fileB2));
                    arrayList2.add(new FileBackedNativeSessionFile("keys_file", "keys", fileA));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        NativeSessionFile nativeSessionFile = (NativeSessionFile) it.next();
                        try {
                            inputStreamH = nativeSessionFile.h();
                            if (inputStreamH != null) {
                                try {
                                    b.i.a.f.e.o.f.t0(inputStreamH, new File(file4, nativeSessionFile.a()));
                                } catch (IOException unused) {
                                } catch (Throwable th3) {
                                    th = th3;
                                    CommonUtils.d(inputStreamH);
                                    throw th;
                                }
                            }
                        } catch (IOException unused2) {
                            inputStreamH = null;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamH = null;
                        }
                        CommonUtils.d(inputStreamH);
                    }
                    SessionReportingCoordinator3 sessionReportingCoordinator32 = this.A;
                    String strReplaceAll = strO.replaceAll("-", "");
                    Objects.requireNonNull(sessionReportingCoordinator32);
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        CrashlyticsReport.c.a aVarB = ((NativeSessionFile) it2.next()).b();
                        if (aVarB != null) {
                            arrayList3.add(aVarB);
                        }
                    }
                    CrashlyticsReportPersistence7 crashlyticsReportPersistence72 = sessionReportingCoordinator32.f1680b;
                    AutoValue_CrashlyticsReport_FilesPayload autoValue_CrashlyticsReport_FilesPayload = new AutoValue_CrashlyticsReport_FilesPayload(new ImmutableList3(arrayList3), null, null);
                    Objects.requireNonNull(crashlyticsReportPersistence72);
                    File file5 = new File(crashlyticsReportPersistence72.h(strReplaceAll), "report");
                    File file6 = crashlyticsReportPersistence72.j;
                    try {
                        CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform8 = CrashlyticsReportPersistence7.c;
                        AutoValue_CrashlyticsReport.b bVar = (AutoValue_CrashlyticsReport.b) crashlyticsReportJsonTransform8.f(CrashlyticsReportPersistence7.j(file5)).i();
                        bVar.g = null;
                        bVar.h = autoValue_CrashlyticsReport_FilesPayload;
                        CrashlyticsReport crashlyticsReportA = bVar.a();
                        CrashlyticsReportPersistence7.i(file6);
                        CrashlyticsReportPersistence7.l(new File(file6, strReplaceAll), crashlyticsReportJsonTransform8.g(crashlyticsReportA));
                    } catch (IOException e4) {
                        Logger3.a.c("Could not synthesize final native report file for " + file5, e4);
                    }
                    logFileManager.d.d();
                } else {
                    logger3.b("Couldn't create native sessions directory");
                }
            }
            if (!this.w.a(strO)) {
                outline.o0("Could not finalize native session: ", strO, Logger3.a);
            }
        }
        Logger3.a.b("Closing open sessions.");
        i3 = z2 ? 1 : 0;
        while (i3 < fileArrS2.length) {
            File file7 = fileArrS2[i3];
            String strO2 = o(file7);
            Logger3 logger32 = Logger3.a;
            logger32.b("Closing session: " + strO2);
            logger32.b("Collecting session parts for ID " + strO2);
            File[] fileArrR = r(l(), new h(outline.w(strO2, "SessionCrash")));
            boolean z3 = fileArrR.length > 0;
            Locale locale = Locale.US;
            logger32.b(String.format(locale, "Session %s has fatal exception: %s", strO2, Boolean.valueOf(z3)));
            File[] fileArrR2 = r(l(), new h(outline.w(strO2, "SessionEvent")));
            boolean z4 = fileArrR2.length > 0;
            String str7 = str32;
            logger32.b(String.format(locale, "Session %s has non-fatal exceptions: %s", strO2, Boolean.valueOf(z4)));
            if (z3 || z4) {
                if (fileArrR2.length > i4) {
                    logger32.b(String.format(locale, "Trimming down to %d logged exceptions.", Integer.valueOf(i2)));
                    v(strO2, i4);
                    fileArrR2 = r(l(), new h(outline.w(strO2, "SessionEvent")));
                }
                File file8 = z3 ? fileArrR[0] : null;
                boolean z5 = file8 != null;
                File fileK = z5 ? k() : n();
                if (!fileK.exists()) {
                    fileK.mkdirs();
                }
                try {
                    clsFileOutputStream = new ClsFileOutputStream(fileK, strO2);
                    try {
                        codedOutputStream2I = CodedOutputStream2.i(clsFileOutputStream);
                        try {
                            try {
                                logger32.b("Collecting SessionStart data for session ID " + strO2);
                                A(codedOutputStream2I, file7);
                                str2 = str42;
                            } catch (Exception e5) {
                                e = e5;
                                str2 = str42;
                            }
                            try {
                                codedOutputStream2I.t(4, j());
                                codedOutputStream2I.k(5, z5);
                                codedOutputStream2I.s(11, 1);
                                codedOutputStream2I.m(12, 3);
                                w(codedOutputStream2I, strO2);
                                x(codedOutputStream2I, fileArrR2, strO2);
                                if (z5) {
                                    A(codedOutputStream2I, file8);
                                }
                                CommonUtils.h(codedOutputStream2I, "Error flushing session file stream");
                                CommonUtils.c(clsFileOutputStream, "Failed to close CLS file");
                            } catch (Exception e6) {
                                e = e6;
                                Logger3.a.e("Failed to write session file for session ID: " + strO2, e);
                                CommonUtils.h(codedOutputStream2I, "Error flushing session file stream");
                                d(clsFileOutputStream);
                                Logger3.a.b("Removing session part files for ID " + strO2);
                                File[] fileArrR3 = r(l(), new n(strO2));
                                while (i < r5) {
                                }
                                i3++;
                                str42 = str2;
                                str32 = str7;
                                i4 = i2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            CommonUtils.h(codedOutputStream2I, "Error flushing session file stream");
                            CommonUtils.c(clsFileOutputStream, "Failed to close CLS file");
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str2 = str42;
                        codedOutputStream2I = null;
                    } catch (Throwable th6) {
                        th = th6;
                        codedOutputStream2I = null;
                    }
                } catch (Exception e8) {
                    e = e8;
                    str2 = str42;
                    codedOutputStream2I = null;
                    clsFileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    codedOutputStream2I = null;
                    clsFileOutputStream = null;
                }
            } else {
                outline.o0("No events present for session ID ", strO2, logger32);
                str2 = str42;
            }
            Logger3.a.b("Removing session part files for ID " + strO2);
            File[] fileArrR32 = r(l(), new n(strO2));
            for (File file9 : fileArrR32) {
                file9.delete();
            }
            i3++;
            str42 = str2;
            str32 = str7;
            i4 = i2;
        }
        String str52 = str32;
        String str62 = str42;
        String strT = z2 == 0 ? t(o(fileArrS2[0])) : null;
        SessionReportingCoordinator3 sessionReportingCoordinator33 = this.A;
        long j22 = j();
        CrashlyticsReportPersistence7 crashlyticsReportPersistence73 = sessionReportingCoordinator33.f1680b;
        listF = CrashlyticsReportPersistence7.f(crashlyticsReportPersistence73.g, new CrashlyticsReportPersistence2(strT));
        Collections.sort(listF, CrashlyticsReportPersistence7.d);
        if (listF.size() > 8) {
            Iterator<File> it3 = listF.subList(8, listF.size()).iterator();
            while (it3.hasNext()) {
                CrashlyticsReportPersistence7.k(it3.next());
            }
            listF = listF.subList(0, 8);
        }
        for (File file10 : listF) {
            Logger3 logger33 = Logger3.a;
            StringBuilder sbU = outline.U("Finalizing report for session ");
            sbU.append(file10.getName());
            logger33.b(sbU.toString());
            List<File> listG = CrashlyticsReportPersistence7.g(file10, CrashlyticsReportPersistence7.e);
            if (listG.isEmpty()) {
                StringBuilder sbU2 = outline.U("Session ");
                sbU2.append(file10.getName());
                sbU2.append(" has no events.");
                logger33.b(sbU2.toString());
            } else {
                Collections.sort(listG);
                ArrayList arrayList4 = new ArrayList();
                while (true) {
                    boolean z6 = false;
                    for (File file11 : listG) {
                        try {
                            CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform82 = CrashlyticsReportPersistence7.c;
                            String strJ2 = CrashlyticsReportPersistence7.j(file11);
                            Objects.requireNonNull(crashlyticsReportJsonTransform82);
                            try {
                                JsonReader jsonReader = new JsonReader(new StringReader(strJ2));
                                try {
                                    CrashlyticsReport.d.AbstractC0049d abstractC0049dB = CrashlyticsReportJsonTransform8.b(jsonReader);
                                    jsonReader.close();
                                    arrayList4.add(abstractC0049dB);
                                    if (!z6) {
                                        String name3 = file11.getName();
                                        if (!(name3.startsWith("event") && name3.endsWith("_"))) {
                                            break;
                                        }
                                    }
                                    z6 = true;
                                } catch (Throwable th8) {
                                    try {
                                        jsonReader.close();
                                    } catch (Throwable unused3) {
                                    }
                                    throw th8;
                                }
                            } catch (IllegalStateException e9) {
                                throw new IOException(e9);
                            }
                        } catch (IOException e10) {
                            Logger3.a.c("Could not add event to report for " + file11, e10);
                        }
                    }
                    if (arrayList4.isEmpty()) {
                        Logger3 logger34 = Logger3.a;
                        StringBuilder sbU3 = outline.U("Could not parse event files for session ");
                        sbU3.append(file10.getName());
                        logger34.b(sbU3.toString());
                    } else {
                        File file12 = new File(file10, str62);
                        if (file12.isFile()) {
                            try {
                                strJ = CrashlyticsReportPersistence7.j(file12);
                            } catch (IOException e11) {
                                Logger3 logger35 = Logger3.a;
                                StringBuilder sbU4 = outline.U("Could not read user ID file in ");
                                sbU4.append(file10.getName());
                                logger35.c(sbU4.toString(), e11);
                            }
                            str = str52;
                            file = new File(file10, str);
                            File file13 = !z6 ? crashlyticsReportPersistence73.h : crashlyticsReportPersistence73.i;
                            try {
                                CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform83 = CrashlyticsReportPersistence7.c;
                                crashlyticsReportJ = crashlyticsReportJsonTransform83.f(CrashlyticsReportPersistence7.j(file)).j(j22, z6, strJ);
                                ImmutableList3<CrashlyticsReport.d.AbstractC0049d> immutableList3 = new ImmutableList3<>(arrayList4);
                                if (crashlyticsReportJ.h() != null) {
                                    throw new IllegalStateException("Reports without sessions cannot have events added to them.");
                                }
                                CrashlyticsReport.a aVarI = crashlyticsReportJ.i();
                                AutoValue_CrashlyticsReport_Session.b bVar2 = (AutoValue_CrashlyticsReport_Session.b) crashlyticsReportJ.h().l();
                                bVar2.j = immutableList3;
                                AutoValue_CrashlyticsReport.b bVar3 = (AutoValue_CrashlyticsReport.b) aVarI;
                                bVar3.g = bVar2.a();
                                CrashlyticsReport crashlyticsReportA2 = bVar3.a();
                                CrashlyticsReport.d dVarH = crashlyticsReportA2.h();
                                if (dVarH != null) {
                                    CrashlyticsReportPersistence7.i(file13);
                                    CrashlyticsReportPersistence7.l(new File(file13, dVarH.g()), crashlyticsReportJsonTransform83.g(crashlyticsReportA2));
                                }
                            } catch (IOException e12) {
                                Logger3.a.c("Could not synthesize final report file for " + file, e12);
                            }
                        } else {
                            strJ = null;
                            str = str52;
                            file = new File(file10, str);
                            if (!z6) {
                            }
                            CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform832 = CrashlyticsReportPersistence7.c;
                            crashlyticsReportJ = crashlyticsReportJsonTransform832.f(CrashlyticsReportPersistence7.j(file)).j(j22, z6, strJ);
                            ImmutableList3<CrashlyticsReport.d.AbstractC0049d> immutableList32 = new ImmutableList3<>(arrayList4);
                            if (crashlyticsReportJ.h() != null) {
                            }
                        }
                    }
                }
                CrashlyticsReportPersistence7.k(file10);
                str52 = str;
            }
            str = str52;
            CrashlyticsReportPersistence7.k(file10);
            str52 = str;
        }
        Objects.requireNonNull(((SettingsController) crashlyticsReportPersistence73.k).c().b());
        ArrayList arrayList5 = (ArrayList) crashlyticsReportPersistence73.e();
        size = arrayList5.size();
        if (size > 4) {
            return;
        }
        Iterator it4 = arrayList5.subList(4, size).iterator();
        while (it4.hasNext()) {
            ((File) it4.next()).delete();
        }
    }

    public final void g(long j2) throws IOException {
        try {
            new File(l(), ".ae" + j2).createNewFile();
        } catch (IOException unused) {
            Logger3.a.b("Could not write app exception marker.");
        }
    }

    public boolean h(int i2) {
        this.m.a();
        if (p()) {
            Logger3.a.b("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger3 logger3 = Logger3.a;
        logger3.b("Finalizing previously open sessions.");
        try {
            f(i2, true);
            logger3.b("Closed all previously open sessions");
            return true;
        } catch (Exception e2) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", e2);
            }
            return false;
        }
    }

    @Nullable
    public final String i() {
        File[] fileArrS = s();
        if (fileArrS.length > 0) {
            return o(fileArrS[0]);
        }
        return null;
    }

    public File k() {
        return new File(l(), "fatal-sessions");
    }

    public File l() {
        return this.p.a();
    }

    public File m() {
        return new File(l(), "native-sessions");
    }

    public File n() {
        return new File(l(), "nonfatal-sessions");
    }

    public boolean p() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.B;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.d.get();
    }

    public File[] q() {
        LinkedList linkedList = new LinkedList();
        File fileK = k();
        FilenameFilter filenameFilter = f1699b;
        File[] fileArrListFiles = fileK.listFiles(filenameFilter);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles);
        File[] fileArrListFiles2 = n().listFiles(filenameFilter);
        if (fileArrListFiles2 == null) {
            fileArrListFiles2 = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles2);
        Collections.addAll(linkedList, r(l(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    public final File[] s() {
        File[] fileArrR = r(l(), a);
        Arrays.sort(fileArrR, c);
        return fileArrR;
    }

    public Task<Void> u(float f2, Task<AppSettingsData> task) {
        b.i.a.f.n.c0<Void> c0Var;
        Task taskZ;
        ReportManager reportManager = this.u;
        File[] fileArrQ = x.this.q();
        File[] fileArrListFiles = x.this.m().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        if (!((fileArrQ != null && fileArrQ.length > 0) || fileArrListFiles.length > 0)) {
            Logger3.a.b("No reports are available.");
            this.C.b(Boolean.FALSE);
            return b.i.a.f.e.o.f.Z(null);
        }
        Logger3 logger3 = Logger3.a;
        logger3.b("Unsent reports are available.");
        if (this.j.b()) {
            logger3.b("Automatic data collection is enabled. Allowing upload.");
            this.C.b(Boolean.FALSE);
            taskZ = b.i.a.f.e.o.f.Z(Boolean.TRUE);
        } else {
            logger3.b("Automatic data collection is disabled.");
            logger3.b("Notifying that unsent reports are available.");
            this.C.b(Boolean.TRUE);
            DataCollectionArbiter dataCollectionArbiter = this.j;
            synchronized (dataCollectionArbiter.c) {
                c0Var = dataCollectionArbiter.d.a;
            }
            Task<TContinuationResult> taskQ = c0Var.q(new e0(this));
            logger3.b("Waiting for send/deleteUnsentReports to be called.");
            b.i.a.f.n.c0<Boolean> c0Var2 = this.D.a;
            FilenameFilter filenameFilter = Utils3.a;
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            Utils4 utils4 = new Utils4(taskCompletionSource);
            taskQ.h(utils4);
            c0Var2.h(utils4);
            taskZ = taskCompletionSource.a;
        }
        return taskZ.q(new e(task, f2));
    }

    public final void v(String str, int i2) {
        Utils3.b(l(), new h(outline.w(str, "SessionEvent")), i2, d);
    }

    public final void w(CodedOutputStream2 codedOutputStream2, String str) throws Throwable {
        for (String str2 : g) {
            File[] fileArrR = r(l(), new h(outline.y(str, str2, ".cls")));
            if (fileArrR.length == 0) {
                Logger3.a.b("Can't find " + str2 + " data for session ID " + str);
            } else {
                Logger3.a.b("Collecting " + str2 + " data for session ID " + str);
                A(codedOutputStream2, fileArrR[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01f0 A[LOOP:1: B:30:0x01ee->B:31:0x01f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0306  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(CodedOutputStream2 codedOutputStream2, Thread thread, Throwable th, long j2, String str, boolean z2) throws Exception {
        Thread[] threadArr;
        Map<String, String> mapA;
        Map<String, String> treeMap;
        byte[] bArrC;
        ByteString2 byteString2;
        String str2;
        ByteString2 byteString22;
        ByteString2 byteString23;
        int length;
        int i2;
        ByteString2 byteString24;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.f1701x);
        Context context = this.i;
        BatteryState batteryStateA = BatteryState.a(context);
        Float f2 = batteryStateA.a;
        int iB = batteryStateA.b();
        boolean zM = CommonUtils.m(context);
        int i3 = context.getResources().getConfiguration().orientation;
        long jP = CommonUtils.p();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        long j3 = jP - memoryInfo.availMem;
        long jA = CommonUtils.a(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoI = CommonUtils.i(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.c;
        String str3 = this.q.f1677b;
        String str4 = this.o.e;
        if (z2) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            int i4 = 0;
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i4] = entry.getKey();
                linkedList.add(this.f1701x.a(entry.getValue()));
                i4++;
                threadArr2 = threadArr2;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (CommonUtils.j(context, "com.crashlytics.CollectCustomKeys", true)) {
            mapA = this.l.a();
            if (mapA != null && mapA.size() > 1) {
                treeMap = new TreeMap(mapA);
            }
            bArrC = this.t.d.c();
            ByteString2 byteString25 = SessionProtobufHelper.a;
            ByteString2 byteString2A = ByteString2.a(str4);
            ByteString2 byteString2A2 = str3 != null ? null : ByteString2.a(str3.replace("-", ""));
            if (bArrC == null) {
                int length2 = bArrC.length;
                byteString2 = byteString2A2;
                byte[] bArr = new byte[length2];
                str2 = "";
                System.arraycopy(bArrC, 0, bArr, 0, length2);
                byteString22 = new ByteString2(bArr);
            } else {
                byteString2 = byteString2A2;
                str2 = "";
                Logger3.a.b("No log data to include with this event.");
                byteString22 = null;
            }
            codedOutputStream2.r(10, 2);
            int iB2 = CodedOutputStream2.b(2, ByteString2.a(str)) + CodedOutputStream2.h(1, j2) + 0;
            byteString23 = byteString22;
            String str5 = str2;
            Thread[] threadArr3 = threadArr;
            int iF = SessionProtobufHelper.f(trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, byteString2A, byteString2, treeMap, runningAppProcessInfoI, i3);
            int iD = CodedOutputStream2.d(iF) + CodedOutputStream2.e(3) + iF + iB2;
            int iG = SessionProtobufHelper.g(f2, iB, zM, i3, j3, jA);
            int iD2 = CodedOutputStream2.d(iG) + CodedOutputStream2.e(5) + iG + iD;
            if (byteString23 != null) {
                int iB3 = CodedOutputStream2.b(1, byteString23);
                iD2 += CodedOutputStream2.d(iB3) + CodedOutputStream2.e(6) + iB3;
            }
            codedOutputStream2.o(iD2);
            codedOutputStream2.t(1, j2);
            codedOutputStream2.l(2, ByteString2.a(str));
            codedOutputStream2.r(3, 2);
            ByteString2 byteString26 = byteString2;
            codedOutputStream2.o(SessionProtobufHelper.f(trimmedThrowableData, thread, stackTraceElementArr, threadArr3, linkedList, 8, byteString2A, byteString26, treeMap, runningAppProcessInfoI, i3));
            codedOutputStream2.r(1, 2);
            codedOutputStream2.o(SessionProtobufHelper.e(trimmedThrowableData, thread, stackTraceElementArr, threadArr3, linkedList, 8, byteString2A, byteString26));
            SessionProtobufHelper.m(codedOutputStream2, thread, stackTraceElementArr, 4, true);
            length = threadArr3.length;
            for (i2 = 0; i2 < length; i2++) {
                SessionProtobufHelper.m(codedOutputStream2, threadArr3[i2], (StackTraceElement[]) linkedList.get(i2), 0, false);
            }
            SessionProtobufHelper.l(codedOutputStream2, trimmedThrowableData, 1, 8, 2);
            codedOutputStream2.r(3, 2);
            codedOutputStream2.o(SessionProtobufHelper.d());
            ByteString2 byteString27 = SessionProtobufHelper.a;
            codedOutputStream2.l(1, byteString27);
            codedOutputStream2.l(2, byteString27);
            codedOutputStream2.t(3, 0L);
            codedOutputStream2.r(4, 2);
            byteString24 = byteString2;
            codedOutputStream2.o(SessionProtobufHelper.a(byteString2A, byteString24));
            codedOutputStream2.t(1, 0L);
            codedOutputStream2.t(2, 0L);
            codedOutputStream2.l(3, byteString2A);
            if (byteString24 != null) {
                codedOutputStream2.l(4, byteString24);
            }
            if (treeMap != null && !treeMap.isEmpty()) {
                for (Map.Entry<String, String> entry2 : treeMap.entrySet()) {
                    codedOutputStream2.r(2, 2);
                    codedOutputStream2.o(SessionProtobufHelper.b(entry2.getKey(), entry2.getValue()));
                    codedOutputStream2.l(1, ByteString2.a(entry2.getKey()));
                    String value = entry2.getValue();
                    if (value == null) {
                        value = str5;
                    }
                    codedOutputStream2.l(2, ByteString2.a(value));
                }
            }
            if (runningAppProcessInfoI != null) {
                codedOutputStream2.k(3, runningAppProcessInfoI.importance != 100);
            }
            codedOutputStream2.s(4, i3);
            codedOutputStream2.r(5, 2);
            codedOutputStream2.o(SessionProtobufHelper.g(f2, iB, zM, i3, j3, jA));
            if (f2 != null) {
                float fFloatValue = f2.floatValue();
                codedOutputStream2.o(13);
                int iFloatToRawIntBits = Float.floatToRawIntBits(fFloatValue);
                codedOutputStream2.n(iFloatToRawIntBits & 255);
                codedOutputStream2.n((iFloatToRawIntBits >> 8) & 255);
                codedOutputStream2.n((iFloatToRawIntBits >> 16) & 255);
                codedOutputStream2.n((iFloatToRawIntBits >> 24) & 255);
            }
            codedOutputStream2.o(16);
            codedOutputStream2.o((iB << 1) ^ (iB >> 31));
            codedOutputStream2.k(3, zM);
            codedOutputStream2.s(4, i3);
            codedOutputStream2.t(5, j3);
            codedOutputStream2.t(6, jA);
            if (byteString23 != null) {
                codedOutputStream2.r(6, 2);
                codedOutputStream2.o(CodedOutputStream2.b(1, byteString23));
                codedOutputStream2.l(1, byteString23);
            }
            this.t.d.d();
        }
        mapA = new TreeMap<>();
        treeMap = mapA;
        bArrC = this.t.d.c();
        ByteString2 byteString252 = SessionProtobufHelper.a;
        ByteString2 byteString2A3 = ByteString2.a(str4);
        if (str3 != null) {
        }
        if (bArrC == null) {
        }
        codedOutputStream2.r(10, 2);
        int iB22 = CodedOutputStream2.b(2, ByteString2.a(str)) + CodedOutputStream2.h(1, j2) + 0;
        byteString23 = byteString22;
        String str52 = str2;
        Thread[] threadArr32 = threadArr;
        int iF2 = SessionProtobufHelper.f(trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, byteString2A3, byteString2, treeMap, runningAppProcessInfoI, i3);
        int iD3 = CodedOutputStream2.d(iF2) + CodedOutputStream2.e(3) + iF2 + iB22;
        int iG2 = SessionProtobufHelper.g(f2, iB, zM, i3, j3, jA);
        int iD22 = CodedOutputStream2.d(iG2) + CodedOutputStream2.e(5) + iG2 + iD3;
        if (byteString23 != null) {
        }
        codedOutputStream2.o(iD22);
        codedOutputStream2.t(1, j2);
        codedOutputStream2.l(2, ByteString2.a(str));
        codedOutputStream2.r(3, 2);
        ByteString2 byteString262 = byteString2;
        codedOutputStream2.o(SessionProtobufHelper.f(trimmedThrowableData, thread, stackTraceElementArr, threadArr32, linkedList, 8, byteString2A3, byteString262, treeMap, runningAppProcessInfoI, i3));
        codedOutputStream2.r(1, 2);
        codedOutputStream2.o(SessionProtobufHelper.e(trimmedThrowableData, thread, stackTraceElementArr, threadArr32, linkedList, 8, byteString2A3, byteString262));
        SessionProtobufHelper.m(codedOutputStream2, thread, stackTraceElementArr, 4, true);
        length = threadArr32.length;
        while (i2 < length) {
        }
        SessionProtobufHelper.l(codedOutputStream2, trimmedThrowableData, 1, 8, 2);
        codedOutputStream2.r(3, 2);
        codedOutputStream2.o(SessionProtobufHelper.d());
        ByteString2 byteString272 = SessionProtobufHelper.a;
        codedOutputStream2.l(1, byteString272);
        codedOutputStream2.l(2, byteString272);
        codedOutputStream2.t(3, 0L);
        codedOutputStream2.r(4, 2);
        byteString24 = byteString2;
        codedOutputStream2.o(SessionProtobufHelper.a(byteString2A3, byteString24));
        codedOutputStream2.t(1, 0L);
        codedOutputStream2.t(2, 0L);
        codedOutputStream2.l(3, byteString2A3);
        if (byteString24 != null) {
        }
        if (treeMap != null) {
            while (r3.hasNext()) {
            }
        }
        if (runningAppProcessInfoI != null) {
        }
        codedOutputStream2.s(4, i3);
        codedOutputStream2.r(5, 2);
        codedOutputStream2.o(SessionProtobufHelper.g(f2, iB, zM, i3, j3, jA));
        if (f2 != null) {
        }
        codedOutputStream2.o(16);
        codedOutputStream2.o((iB << 1) ^ (iB >> 31));
        codedOutputStream2.k(3, zM);
        codedOutputStream2.s(4, i3);
        codedOutputStream2.t(5, j3);
        codedOutputStream2.t(6, jA);
        if (byteString23 != null) {
        }
        this.t.d.d();
    }

    public final void z(String str, String str2, g gVar) throws Exception {
        Throwable th;
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream2 codedOutputStream2 = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(l(), str + str2);
            try {
                CodedOutputStream2 codedOutputStream2I = CodedOutputStream2.i(clsFileOutputStream);
                try {
                    gVar.a(codedOutputStream2I);
                    CommonUtils.h(codedOutputStream2I, "Failed to flush to session " + str2 + " file.");
                    CommonUtils.c(clsFileOutputStream, "Failed to close session " + str2 + " file.");
                } catch (Throwable th2) {
                    th = th2;
                    codedOutputStream2 = codedOutputStream2I;
                    CommonUtils.h(codedOutputStream2, "Failed to flush to session " + str2 + " file.");
                    CommonUtils.c(clsFileOutputStream, "Failed to close session " + str2 + " file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            clsFileOutputStream = null;
        }
    }
}
