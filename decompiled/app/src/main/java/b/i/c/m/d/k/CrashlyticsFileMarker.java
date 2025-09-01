package b.i.c.m.d.k;

import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.o.FileStoreImpl;
import java.io.File;
import java.io.IOException;

/* compiled from: CrashlyticsFileMarker.java */
/* renamed from: b.i.c.m.d.k.m0, reason: use source file name */
/* loaded from: classes3.dex */
public class CrashlyticsFileMarker {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final FileStoreImpl f1690b;

    public CrashlyticsFileMarker(String str, FileStoreImpl fileStoreImpl) {
        this.a = str;
        this.f1690b = fileStoreImpl;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e) {
            Logger3 logger3 = Logger3.a;
            StringBuilder sbU = outline.U("Error creating marker: ");
            sbU.append(this.a);
            logger3.e(sbU.toString(), e);
            return false;
        }
    }

    public final File b() {
        return new File(this.f1690b.a(), this.a);
    }
}
