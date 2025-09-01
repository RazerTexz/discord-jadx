package b.i.c.m.d.o;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;

/* compiled from: CrashlyticsReportPersistence.java */
/* renamed from: b.i.c.m.d.o.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportPersistence2 implements FileFilter {
    public final String a;

    public CrashlyticsReportPersistence2(String str) {
        this.a = str;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String str = this.a;
        Charset charset = CrashlyticsReportPersistence7.a;
        return file.isDirectory() && !file.getName().equals(str);
    }
}
