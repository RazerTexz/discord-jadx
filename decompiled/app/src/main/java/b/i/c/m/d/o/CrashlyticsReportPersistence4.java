package b.i.c.m.d.o;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;

/* compiled from: CrashlyticsReportPersistence.java */
/* renamed from: b.i.c.m.d.o.d, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence4 implements Comparator {
    public static final CrashlyticsReportPersistence4 j = new CrashlyticsReportPersistence4();

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Charset charset = CrashlyticsReportPersistence7.a;
        String name = ((File) obj).getName();
        int i = CrashlyticsReportPersistence7.f1738b;
        return name.substring(0, i).compareTo(((File) obj2).getName().substring(0, i));
    }
}
