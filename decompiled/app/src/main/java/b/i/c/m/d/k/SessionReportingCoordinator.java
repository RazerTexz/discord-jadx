package b.i.c.m.d.k;

import android.util.Log;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import com.google.android.gms.tasks.Task;
import java.util.Objects;

/* compiled from: SessionReportingCoordinator.java */
/* renamed from: b.i.c.m.d.k.b1, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class SessionReportingCoordinator implements b.i.a.f.n.a {
    public final SessionReportingCoordinator3 a;

    public SessionReportingCoordinator(SessionReportingCoordinator3 sessionReportingCoordinator3) {
        this.a = sessionReportingCoordinator3;
    }

    @Override // b.i.a.f.n.a
    public Object a(Task task) {
        boolean z2;
        SessionReportingCoordinator3 sessionReportingCoordinator3 = this.a;
        Objects.requireNonNull(sessionReportingCoordinator3);
        if (task.p()) {
            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) task.l();
            Logger3 logger3 = Logger3.a;
            StringBuilder sbU = outline.U("Crashlytics report successfully enqueued to DataTransport: ");
            sbU.append(crashlyticsReportWithSessionId.b());
            logger3.b(sbU.toString());
            sessionReportingCoordinator3.f1680b.c(crashlyticsReportWithSessionId.b());
            z2 = true;
        } else {
            Logger3 logger32 = Logger3.a;
            Exception excK = task.k();
            if (logger32.a(3)) {
                Log.d("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", excK);
            }
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
