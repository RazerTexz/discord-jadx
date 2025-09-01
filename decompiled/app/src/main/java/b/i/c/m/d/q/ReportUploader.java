package b.i.c.m.d.q;

import android.util.Log;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.BackgroundPriorityRunnable;
import b.i.c.m.d.k.x;
import b.i.c.m.d.q.c.CreateReportRequest;
import b.i.c.m.d.q.c.Report2;
import b.i.c.m.d.q.d.CreateReportSpiCall;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: ReportUploader.java */
/* renamed from: b.i.c.m.d.q.b, reason: use source file name */
/* loaded from: classes3.dex */
public class ReportUploader {
    public static final short[] a = {10, 20, 30, 60, 120, 300};

    /* renamed from: b, reason: collision with root package name */
    public final CreateReportSpiCall f1741b;

    @Nullable
    public final String c;
    public final String d;
    public final int e;
    public final ReportManager f;
    public final a g;
    public Thread h;

    /* compiled from: ReportUploader.java */
    /* renamed from: b.i.c.m.d.q.b$a */
    public interface a {
    }

    /* compiled from: ReportUploader.java */
    /* renamed from: b.i.c.m.d.q.b$b */
    public interface b {
    }

    /* compiled from: ReportUploader.java */
    /* renamed from: b.i.c.m.d.q.b$c */
    public interface c {
    }

    /* compiled from: ReportUploader.java */
    /* renamed from: b.i.c.m.d.q.b$d */
    public class d extends BackgroundPriorityRunnable {
        public final List<Report2> j;
        public final boolean k;
        public final float l;

        public d(List<Report2> list, boolean z2, float f) {
            this.j = list;
            this.k = z2;
            this.l = f;
        }

        @Override // b.i.c.m.d.k.BackgroundPriorityRunnable
        public void a() {
            try {
                b(this.j, this.k);
            } catch (Exception e) {
                if (Logger3.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "An unexpected error occurred while attempting to upload crash reports.", e);
                }
            }
            ReportUploader.this.h = null;
        }

        public final void b(List<Report2> list, boolean z2) throws InterruptedException {
            Logger3 logger3 = Logger3.a;
            StringBuilder sbU = outline.U("Starting report processing in ");
            sbU.append(this.l);
            sbU.append(" second(s)...");
            logger3.b(sbU.toString());
            float f = this.l;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (x.this.p()) {
                return;
            }
            int i = 0;
            while (list.size() > 0 && !x.this.p()) {
                Logger3 logger32 = Logger3.a;
                StringBuilder sbU2 = outline.U("Attempting to send ");
                sbU2.append(list.size());
                sbU2.append(" report(s)");
                logger32.b(sbU2.toString());
                ArrayList arrayList = new ArrayList();
                for (Report2 report2 : list) {
                    if (!ReportUploader.this.a(report2, z2)) {
                        arrayList.add(report2);
                    }
                }
                if (arrayList.size() > 0) {
                    int i2 = i + 1;
                    long j = ReportUploader.a[Math.min(i, r8.length - 1)];
                    Logger3.a.b("Report submission: scheduling delayed retry in " + j + " seconds");
                    try {
                        Thread.sleep(j * 1000);
                        i = i2;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                list = arrayList;
            }
        }
    }

    public ReportUploader(@Nullable String str, String str2, int i, ReportManager reportManager, CreateReportSpiCall createReportSpiCall, a aVar) {
        if (createReportSpiCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f1741b = createReportSpiCall;
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = reportManager;
        this.g = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:6:0x0011, B:19:0x0053, B:9:0x001a, B:11:0x0020, B:13:0x0027, B:17:0x0040), top: B:25:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Report2 report2, boolean z2) {
        CreateReportRequest createReportRequest;
        int i;
        boolean zA;
        try {
            createReportRequest = new CreateReportRequest(this.c, this.d, report2);
            i = this.e;
        } catch (Exception e) {
            Logger3.a.e("Error occurred sending report " + report2, e);
        }
        if (i == 3) {
            Logger3.a.b("Report configured to be sent via DataTransport.");
        } else {
            if (i != 2 || report2.d() != 1) {
                zA = this.f1741b.a(createReportRequest, z2);
                Logger3 logger3 = Logger3.a;
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics Reports Endpoint upload ");
                sb.append(zA ? "complete: " : "FAILED: ");
                sb.append(report2.a());
                logger3.f(sb.toString());
                if (zA) {
                    Objects.requireNonNull(this.f);
                    report2.remove();
                    return true;
                }
                return false;
            }
            Logger3.a.b("Report configured to be sent via DataTransport.");
        }
        zA = true;
        if (zA) {
        }
        return false;
    }
}
