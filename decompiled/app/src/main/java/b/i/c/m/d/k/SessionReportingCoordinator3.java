package b.i.c.m.d.k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import b.i.a.b.AutoValue_Event;
import b.i.a.b.Priority3;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.l.LogFileManager;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_CustomAttribute;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Device;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Log;
import b.i.c.m.d.m.CrashlyticsReport;
import b.i.c.m.d.m.ImmutableList3;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import b.i.c.m.d.o.CrashlyticsReportPersistence3;
import b.i.c.m.d.o.CrashlyticsReportPersistence4;
import b.i.c.m.d.o.CrashlyticsReportPersistence7;
import b.i.c.m.d.r.DataTransportCrashlyticsReportSender;
import b.i.c.m.d.r.DataTransportCrashlyticsReportSender3;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.t.TrimmedThrowableData;
import b.i.c.p.h.JsonDataEncoderBuilder4;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: SessionReportingCoordinator.java */
/* renamed from: b.i.c.m.d.k.d1, reason: use source file name */
/* loaded from: classes3.dex */
public class SessionReportingCoordinator3 {
    public final CrashlyticsReportDataCapture a;

    /* renamed from: b, reason: collision with root package name */
    public final CrashlyticsReportPersistence7 f1680b;
    public final DataTransportCrashlyticsReportSender3 c;
    public final LogFileManager d;
    public final UserMetadata e;

    public SessionReportingCoordinator3(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence7 crashlyticsReportPersistence7, DataTransportCrashlyticsReportSender3 dataTransportCrashlyticsReportSender3, LogFileManager logFileManager, UserMetadata userMetadata) {
        this.a = crashlyticsReportDataCapture;
        this.f1680b = crashlyticsReportPersistence7;
        this.c = dataTransportCrashlyticsReportSender3;
        this.d = logFileManager;
        this.e = userMetadata;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [b.i.c.m.d.m.v$d$d$a] */
    public final void a(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j, boolean z2) {
        AutoValue_CrashlyticsReport_Session_Event_Log autoValue_CrashlyticsReport_Session_Event_Log;
        boolean zEquals = str2.equals("crash");
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = this.a;
        int i = crashlyticsReportDataCapture.c.getResources().getConfiguration().orientation;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, crashlyticsReportDataCapture.f);
        Long lValueOf = Long.valueOf(j);
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoI = CommonUtils.i(crashlyticsReportDataCapture.e.d, crashlyticsReportDataCapture.c);
        Boolean boolValueOf = runningAppProcessInfoI != null ? Boolean.valueOf(runningAppProcessInfoI.importance != 100) : null;
        Integer numValueOf = Integer.valueOf(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(crashlyticsReportDataCapture.c(thread, trimmedThrowableData.c, 4));
        if (z2) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(crashlyticsReportDataCapture.c(key, crashlyticsReportDataCapture.f.a(entry.getValue()), 0));
                }
            }
        }
        ImmutableList3 immutableList3 = new ImmutableList3(arrayList);
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052bA = crashlyticsReportDataCapture.a(trimmedThrowableData, 4, 8, 0);
        Long l = 0L;
        String str3 = l == null ? " address" : "";
        if (!str3.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", str3));
        }
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal("0", "0", l.longValue(), null);
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a[] abstractC0051aArr = new CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0051a[1];
        Long l2 = 0L;
        Long l3 = 0L;
        String str4 = crashlyticsReportDataCapture.e.d;
        Objects.requireNonNull(str4, "Null name");
        String str5 = crashlyticsReportDataCapture.e.f1677b;
        String strW = l2 == null ? " baseAddress" : "";
        if (l3 == null) {
            strW = outline.w(strW, " size");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }
        abstractC0051aArr[0] = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(l2.longValue(), l3.longValue(), str4, str5, null);
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList3, abstractC0052bA, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal, new ImmutableList3(Arrays.asList(abstractC0051aArr)), null);
        String str6 = numValueOf == null ? " uiOrientation" : "";
        if (!str6.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", str6));
        }
        AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = new AutoValue_CrashlyticsReport_Session_Event_Application(autoValue_CrashlyticsReport_Session_Event_Application_Execution, null, boolValueOf, numValueOf.intValue(), null);
        BatteryState batteryStateA = BatteryState.a(crashlyticsReportDataCapture.c);
        Float f = batteryStateA.a;
        Double dValueOf = f != null ? Double.valueOf(f.doubleValue()) : null;
        int iB = batteryStateA.b();
        boolean zM = CommonUtils.m(crashlyticsReportDataCapture.c);
        long jP = CommonUtils.p();
        Context context = crashlyticsReportDataCapture.c;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        long j2 = jP - memoryInfo.availMem;
        long jA = CommonUtils.a(Environment.getDataDirectory().getPath());
        AutoValue_CrashlyticsReport_Session_Event_Device.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Device.b();
        bVar.a = dValueOf;
        bVar.f1734b = Integer.valueOf(iB);
        bVar.c = Boolean.valueOf(zM);
        bVar.d = Integer.valueOf(i);
        bVar.e = Long.valueOf(j2);
        bVar.f = Long.valueOf(jA);
        CrashlyticsReport.d.AbstractC0049d.b bVarA = bVar.a();
        String str7 = lValueOf == null ? " timestamp" : "";
        if (!str7.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", str7));
        }
        Long lValueOf2 = Long.valueOf(lValueOf.longValue());
        String strB = this.d.d.b();
        if (strB != null) {
            autoValue_CrashlyticsReport_Session_Event_Log = new AutoValue_CrashlyticsReport_Session_Event_Log(strB, null);
        } else {
            Logger3.a.b("No log data to include with this event.");
            autoValue_CrashlyticsReport_Session_Event_Log = null;
        }
        Map<String, String> mapA = this.e.a();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.ensureCapacity(mapA.size());
        for (Map.Entry<String, String> entry2 : mapA.entrySet()) {
            String key2 = entry2.getKey();
            Objects.requireNonNull(key2, "Null key");
            String value = entry2.getValue();
            Objects.requireNonNull(value, "Null value");
            arrayList2.add(new AutoValue_CrashlyticsReport_CustomAttribute(key2, value, null));
        }
        Collections.sort(arrayList2, SessionReportingCoordinator2.j);
        AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_ApplicationA = autoValue_CrashlyticsReport_Session_Event_Application;
        if (!arrayList2.isEmpty()) {
            AutoValue_CrashlyticsReport_Session_Event_Application.b bVar2 = (AutoValue_CrashlyticsReport_Session_Event_Application.b) autoValue_CrashlyticsReport_Session_Event_Application.e();
            bVar2.f1725b = new ImmutableList3<>(arrayList2);
            autoValue_CrashlyticsReport_Session_Event_ApplicationA = bVar2.a();
        }
        AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application2 = autoValue_CrashlyticsReport_Session_Event_ApplicationA;
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = this.f1680b;
        String str8 = lValueOf2 != null ? "" : " timestamp";
        if (!str8.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", str8));
        }
        AutoValue_CrashlyticsReport_Session_Event autoValue_CrashlyticsReport_Session_Event = new AutoValue_CrashlyticsReport_Session_Event(lValueOf2.longValue(), str2, autoValue_CrashlyticsReport_Session_Event_Application2, bVarA, autoValue_CrashlyticsReport_Session_Event_Log, null);
        int i2 = ((SettingsController) crashlyticsReportPersistence7.k).c().b().a;
        File fileH = crashlyticsReportPersistence7.h(str);
        Objects.requireNonNull(CrashlyticsReportPersistence7.c);
        try {
            CrashlyticsReportPersistence7.l(new File(fileH, outline.y("event", String.format(Locale.US, "%010d", Integer.valueOf(crashlyticsReportPersistence7.f.getAndIncrement())), zEquals ? "_" : "")), ((JsonDataEncoderBuilder4) CrashlyticsReportJsonTransform8.a).a(autoValue_CrashlyticsReport_Session_Event));
        } catch (IOException e) {
            Logger3.a.c("Could not persist event for session " + str, e);
        }
        List<File> listG = CrashlyticsReportPersistence7.g(fileH, CrashlyticsReportPersistence3.a);
        Collections.sort(listG, CrashlyticsReportPersistence4.j);
        int size = listG.size();
        for (File file : listG) {
            if (size <= i2) {
                return;
            }
            CrashlyticsReportPersistence7.k(file);
            size--;
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/concurrent/Executor;Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    public Task b(@NonNull Executor executor, @NonNull int i) {
        if (i == 1) {
            Logger3.a.b("Send via DataTransport disabled. Removing DataTransport reports.");
            this.f1680b.b();
            return b.i.a.f.e.o.f.Z(null);
        }
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = this.f1680b;
        List<File> listE = crashlyticsReportPersistence7.e();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(((ArrayList) listE).size());
        Iterator it = ((ArrayList) crashlyticsReportPersistence7.e()).iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            try {
                arrayList.add(new AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReportPersistence7.c.f(CrashlyticsReportPersistence7.j(file)), file.getName()));
            } catch (IOException e) {
                Logger3.a.c("Could not load report file " + file + "; deleting", e);
                file.delete();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) it2.next();
            CrashlyticsReport crashlyticsReportA = crashlyticsReportWithSessionId.a();
            if ((crashlyticsReportA.h() != null ? (char) 2 : crashlyticsReportA.e() != null ? (char) 3 : (char) 1) != 3 || i == 3) {
                DataTransportCrashlyticsReportSender3 dataTransportCrashlyticsReportSender3 = this.c;
                Objects.requireNonNull(dataTransportCrashlyticsReportSender3);
                CrashlyticsReport crashlyticsReportA2 = crashlyticsReportWithSessionId.a();
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                dataTransportCrashlyticsReportSender3.e.b(new AutoValue_Event(null, crashlyticsReportA2, Priority3.HIGHEST), new DataTransportCrashlyticsReportSender(taskCompletionSource, crashlyticsReportWithSessionId));
                arrayList2.add(taskCompletionSource.a.i(executor, new SessionReportingCoordinator(this)));
            } else {
                Logger3.a.b("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.f1680b.c(crashlyticsReportWithSessionId.b());
            }
        }
        return b.i.a.f.e.o.f.B1(arrayList2);
    }
}
