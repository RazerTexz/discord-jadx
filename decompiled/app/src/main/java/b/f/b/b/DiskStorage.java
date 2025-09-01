package b.f.b.b;

import b.f.a.FileBinaryResource;
import java.io.IOException;
import java.util.Collection;

/* compiled from: DiskStorage.java */
/* renamed from: b.f.b.b.c, reason: use source file name */
/* loaded from: classes.dex */
public interface DiskStorage {

    /* compiled from: DiskStorage.java */
    /* renamed from: b.f.b.b.c$a */
    public interface a {
        long a();

        String getId();

        long getSize();
    }

    /* compiled from: DiskStorage.java */
    /* renamed from: b.f.b.b.c$b */
    public interface b {
    }

    void a();

    b b(String str, Object obj) throws IOException;

    boolean c(String str, Object obj) throws IOException;

    FileBinaryResource d(String str, Object obj) throws IOException;

    Collection<a> e() throws IOException;

    long f(String str) throws IOException;

    long g(a aVar) throws IOException;

    boolean isExternal();
}
