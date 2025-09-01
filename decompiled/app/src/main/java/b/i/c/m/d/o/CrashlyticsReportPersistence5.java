package b.i.c.m.d.o;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;

/* compiled from: CrashlyticsReportPersistence.java */
/* renamed from: b.i.c.m.d.o.e, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence5 implements Comparator {
    public static final CrashlyticsReportPersistence5 j = new CrashlyticsReportPersistence5();

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Charset charset = CrashlyticsReportPersistence7.a;
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
