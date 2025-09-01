package b.f.m;

import android.util.Log;
import b.f.m.n.NativeLoaderDelegate;
import com.facebook.soloader.SoLoader;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: NativeLoaderToSoLoaderDelegate.java */
/* renamed from: b.f.m.j, reason: use source file name */
/* loaded from: classes3.dex */
public class NativeLoaderToSoLoaderDelegate implements NativeLoaderDelegate {
    @Override // b.f.m.n.NativeLoaderDelegate
    public boolean a(String str, int i) {
        boolean z2;
        boolean zContains;
        int i2 = ((i & 1) != 0 ? 16 : 0) | 0;
        ReentrantReadWriteLock reentrantReadWriteLock = SoLoader.c;
        reentrantReadWriteLock.readLock().lock();
        try {
        } catch (Throwable th) {
            throw th;
        }
        if (SoLoader.d == null) {
            if (!"http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                synchronized (SoLoader.class) {
                    zContains = true ^ SoLoader.h.contains(str);
                    if (zContains) {
                        System.loadLibrary(str);
                    }
                }
                reentrantReadWriteLock.readLock().unlock();
                return zContains;
            }
            reentrantReadWriteLock.readLock().lock();
            try {
                boolean z3 = SoLoader.d != null;
                reentrantReadWriteLock.readLock().unlock();
                if (!z3) {
                    throw new IllegalStateException("SoLoader.init() not yet called");
                }
            } finally {
                SoLoader.c.readLock().unlock();
            }
            throw th;
        }
        reentrantReadWriteLock.readLock().unlock();
        boolean z4 = SoLoader.l;
        String strMapLibraryName = System.mapLibraryName(str);
        boolean zD = false;
        do {
            try {
                zD = SoLoader.d(strMapLibraryName, str, null, i2, null);
                z2 = false;
            } catch (UnsatisfiedLinkError e) {
                int i3 = SoLoader.e;
                SoLoader.c.writeLock().lock();
                try {
                    try {
                        if (SoLoader.g == null || !SoLoader.g.c()) {
                            z2 = false;
                        } else {
                            Log.w("SoLoader", "sApplicationSoSource updated during load: " + strMapLibraryName + ", attempting load again.");
                            SoLoader.e = SoLoader.e + 1;
                            z2 = true;
                        }
                        SoLoader.c.writeLock().unlock();
                        if (SoLoader.e == i3) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                } catch (Throwable th2) {
                    SoLoader.c.writeLock().unlock();
                    throw th2;
                }
            }
        } while (z2);
        return zD;
    }
}
