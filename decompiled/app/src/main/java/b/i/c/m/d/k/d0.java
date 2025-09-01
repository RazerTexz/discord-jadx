package b.i.c.m.d.k;

import android.util.Log;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.p.ClsFileOutputStream;
import b.i.c.m.d.p.CodedOutputStream2;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.s.SettingsDataProvider;
import b.i.c.m.d.s.h.Settings2;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes3.dex */
public class d0 implements Callable<Task<Void>> {
    public final /* synthetic */ Date j;
    public final /* synthetic */ Throwable k;
    public final /* synthetic */ Thread l;
    public final /* synthetic */ SettingsDataProvider m;
    public final /* synthetic */ x n;

    public d0(x xVar, Date date, Throwable th, Thread thread, SettingsDataProvider settingsDataProvider) {
        this.n = xVar;
        this.j = date;
        this.k = th;
        this.l = thread;
        this.m = settingsDataProvider;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0127  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Task<Void> call() throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream2 codedOutputStream2I;
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        long time = this.j.getTime() / 1000;
        String strI = this.n.i();
        CodedOutputStream2 codedOutputStream2 = null;
        if (strI == null) {
            Logger3.a.d("Tried to write a fatal exception while no session was open.");
            return b.i.a.f.e.o.f.Z(null);
        }
        this.n.k.a();
        SessionReportingCoordinator3 sessionReportingCoordinator3 = this.n.A;
        Throwable th = this.k;
        Thread thread = this.l;
        String strReplaceAll = strI.replaceAll("-", "");
        Objects.requireNonNull(sessionReportingCoordinator3);
        outline.o0("Persisting fatal event for session ", strReplaceAll, Logger3.a);
        sessionReportingCoordinator3.a(th, thread, strReplaceAll, "crash", time, true);
        x xVar = this.n;
        Thread thread2 = this.l;
        Throwable th2 = this.k;
        Objects.requireNonNull(xVar);
        try {
            clsFileOutputStream = new ClsFileOutputStream(xVar.l(), strI + "SessionCrash");
            try {
                codedOutputStream2I = CodedOutputStream2.i(clsFileOutputStream);
                try {
                    try {
                        xVar.y(codedOutputStream2I, thread2, th2, time, "crash", true);
                    } catch (Exception e) {
                        e = e;
                        if (Logger3.a.a(6)) {
                            Log.e("FirebaseCrashlytics", "An error occurred in the fatal exception logger", e);
                        }
                        CommonUtils.h(codedOutputStream2I, "Failed to flush to session begin file.");
                        CommonUtils.c(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                        this.n.g(this.j.getTime());
                        Settings2 settings2C = ((SettingsController) this.m).c();
                        int i = settings2C.b().a;
                        Objects.requireNonNull(settings2C.b());
                        this.n.f(i, false);
                        x.a(this.n);
                        x xVar2 = this.n;
                        File fileM = xVar2.m();
                        File fileK = xVar2.k();
                        Comparator<File> comparator = x.d;
                        FilenameFilter filenameFilter = Utils3.a;
                        ArrayList arrayList = new ArrayList();
                        fileArrListFiles = fileM.listFiles();
                        FilenameFilter filenameFilter2 = Utils3.a;
                        fileArrListFiles2 = fileK.listFiles(filenameFilter2);
                        if (fileArrListFiles == null) {
                        }
                        if (fileArrListFiles2 == null) {
                        }
                        arrayList.addAll(Arrays.asList(fileArrListFiles));
                        arrayList.addAll(Arrays.asList(fileArrListFiles2));
                        int iC = 4 - Utils3.c(arrayList, 4, comparator);
                        Utils3.b(xVar2.l(), x.f1699b, iC - Utils3.b(xVar2.n(), filenameFilter2, iC, comparator), comparator);
                        if (this.n.j.b()) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    codedOutputStream2 = codedOutputStream2I;
                    CommonUtils.h(codedOutputStream2, "Failed to flush to session begin file.");
                    CommonUtils.c(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                codedOutputStream2I = null;
            } catch (Throwable th4) {
                th = th4;
                CommonUtils.h(codedOutputStream2, "Failed to flush to session begin file.");
                CommonUtils.c(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            codedOutputStream2I = null;
            clsFileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            clsFileOutputStream = null;
        }
        CommonUtils.h(codedOutputStream2I, "Failed to flush to session begin file.");
        CommonUtils.c(clsFileOutputStream, "Failed to close fatal exception file output stream.");
        this.n.g(this.j.getTime());
        Settings2 settings2C2 = ((SettingsController) this.m).c();
        int i2 = settings2C2.b().a;
        Objects.requireNonNull(settings2C2.b());
        this.n.f(i2, false);
        x.a(this.n);
        x xVar22 = this.n;
        File fileM2 = xVar22.m();
        File fileK2 = xVar22.k();
        Comparator<File> comparator2 = x.d;
        FilenameFilter filenameFilter3 = Utils3.a;
        ArrayList arrayList2 = new ArrayList();
        fileArrListFiles = fileM2.listFiles();
        FilenameFilter filenameFilter22 = Utils3.a;
        fileArrListFiles2 = fileK2.listFiles(filenameFilter22);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        if (fileArrListFiles2 == null) {
            fileArrListFiles2 = new File[0];
        }
        arrayList2.addAll(Arrays.asList(fileArrListFiles));
        arrayList2.addAll(Arrays.asList(fileArrListFiles2));
        int iC2 = 4 - Utils3.c(arrayList2, 4, comparator2);
        Utils3.b(xVar22.l(), x.f1699b, iC2 - Utils3.b(xVar22.n(), filenameFilter22, iC2, comparator2), comparator2);
        if (this.n.j.b()) {
            return b.i.a.f.e.o.f.Z(null);
        }
        Executor executor = this.n.m.a;
        return ((SettingsController) this.m).a().r(executor, new c0(this, executor));
    }
}
