package b.i.c.m.d.k;

import b.i.c.m.d.m.CrashlyticsReport;
import java.util.Comparator;

/* compiled from: SessionReportingCoordinator.java */
/* renamed from: b.i.c.m.d.k.c1, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class SessionReportingCoordinator2 implements Comparator {
    public static final SessionReportingCoordinator2 j = new SessionReportingCoordinator2();

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((CrashlyticsReport.b) obj).a().compareTo(((CrashlyticsReport.b) obj2).a());
    }
}
