package b.i.c.m.d.k;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class m implements FilenameFilter {
    public static final m a = new m();

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        FilenameFilter filenameFilter = x.a;
        return str.startsWith(".ae");
    }
}
