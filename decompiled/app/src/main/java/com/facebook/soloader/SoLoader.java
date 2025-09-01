package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.m.ApkSoSource;
import b.f.m.ApplicationSoSource;
import b.f.m.DirectorySoSource;
import b.f.m.DoNotOptimize;
import b.f.m.ExoSoSource;
import b.f.m.NativeLoaderToSoLoaderDelegate;
import b.f.m.SoFileLoader;
import b.f.m.SoSource;
import b.f.m.UnpackingSoSource;
import b.f.m.n.NativeLoader;
import com.adjust.sdk.Constants;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.objectweb.asm.Opcodes;

/* loaded from: classes3.dex */
public class SoLoader {

    /* renamed from: b, reason: collision with root package name */
    public static SoFileLoader f2906b;
    public static UnpackingSoSource[] f;
    public static ApplicationSoSource g;
    public static int k;
    public static boolean l;
    public static final ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    public static SoSource[] d = null;
    public static volatile int e = 0;
    public static final HashSet<String> h = new HashSet<>();
    public static final Map<String, Object> i = new HashMap();
    public static final Set<String> j = Collections.newSetFromMap(new ConcurrentHashMap());
    public static final boolean a = true;

    @DoNotOptimize
    @TargetApi(14)
    public static class Api14Utils {
        private Api14Utils() {
        }

        public static String a() throws NoSuchMethodException, SecurityException {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            }
            StringBuilder sbU = outline.U("ClassLoader ");
            sbU.append(classLoader.getClass().getName());
            sbU.append(" should be of type BaseDexClassLoader");
            throw new IllegalStateException(sbU.toString());
        }
    }

    public static class a implements SoFileLoader {
        public final /* synthetic */ boolean a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f2907b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Runtime d;
        public final /* synthetic */ Method e;

        public a(boolean z2, String str, String str2, Runtime runtime, Method method) {
            this.a = z2;
            this.f2907b = str;
            this.c = str2;
            this.d = runtime;
            this.e = method;
        }

        public final String a(String str) throws NoSuchAlgorithmException, IOException {
            try {
                File file = new File(str);
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            String str2 = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                            fileInputStream.close();
                            return str2;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e) {
                return e.toString();
            } catch (SecurityException e2) {
                return e2.toString();
            } catch (NoSuchAlgorithmException e3) {
                return e3.toString();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(String str, int i) throws Throwable {
            String str2;
            if (!this.a) {
                System.load(str);
                return;
            }
            a aVar = null;
            String str3 = (i & 4) == 4 ? this.f2907b : this.c;
            try {
                try {
                    synchronized (this.d) {
                        try {
                            str2 = (String) this.e.invoke(this.d, str, SoLoader.class.getClassLoader(), str3);
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            if (str2 != null) {
                                throw new UnsatisfiedLinkError(str2);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            while (true) {
                                try {
                                    try {
                                        break;
                                    } catch (IllegalAccessException e) {
                                        e = e;
                                        throw new RuntimeException("Error: Cannot load " + str, e);
                                    } catch (IllegalArgumentException e2) {
                                        e = e2;
                                        throw new RuntimeException("Error: Cannot load " + str, e);
                                    } catch (InvocationTargetException e3) {
                                        e = e3;
                                        throw new RuntimeException("Error: Cannot load " + str, e);
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            throw th;
                        }
                    }
                    if (str2 != null) {
                        StringBuilder sbY = outline.Y("Error when loading lib: ", str2, " lib hash: ");
                        sbY.append(a(str));
                        sbY.append(" search path is ");
                        sbY.append(str3);
                        Log.e("SoLoader", sbY.toString());
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (0 != 0) {
                        StringBuilder sbY2 = outline.Y("Error when loading lib: ", null, " lib hash: ");
                        sbY2.append(aVar.a(str));
                        sbY2.append(" search path is ");
                        sbY2.append(str3);
                        Log.e("SoLoader", sbY2.toString());
                    }
                    throw th;
                }
            } catch (IllegalAccessException e4) {
                e = e4;
                throw new RuntimeException("Error: Cannot load " + str, e);
            } catch (IllegalArgumentException e5) {
                e = e5;
                throw new RuntimeException("Error: Cannot load " + str, e);
            } catch (InvocationTargetException e6) {
                e = e6;
                throw new RuntimeException("Error: Cannot load " + str, e);
            } catch (Throwable th5) {
                th = th5;
                aVar = this;
                if (0 != 0) {
                }
                throw th;
            }
        }
    }

    public static final class b extends UnsatisfiedLinkError {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Throwable th, String str) {
            StringBuilder sbU = outline.U("APK was built for a different platform. Supported ABIs: ");
            sbU.append(Arrays.toString(AnimatableValueParser.C0()));
            sbU.append(" error: ");
            sbU.append(str);
            super(sbU.toString());
            initCause(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        android.util.Log.d("SoLoader", "Trying backup SoSource for " + r11);
        r5 = com.facebook.soloader.SoLoader.f;
        r6 = r5.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        if (r7 >= r6) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        r8 = r5[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
    
        monitor-enter(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r9 = r8.h(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        monitor-enter(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        r8.d = r11;
        r8.b(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        monitor-exit(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
    
        monitor-exit(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        r8 = r8.a(r11, r12, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        if (r8 != 1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
    
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
    
        if (com.facebook.soloader.SoLoader.a == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
    
        android.os.Trace.endSection();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r3 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        android.os.StrictMode.setThreadPolicy(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a8, code lost:
    
        if (r0 == 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00aa, code lost:
    
        if (r0 != 3) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ac, code lost:
    
        r11 = b.d.b.a.outline.X("couldn't find DSO to load: ", r11);
        r12.readLock().lock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bc, code lost:
    
        if (r2 >= com.facebook.soloader.SoLoader.d.length) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00be, code lost:
    
        r11.append("\n\tSoSource ");
        r11.append(r2);
        r11.append(": ");
        r11.append(com.facebook.soloader.SoLoader.d[r2].toString());
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d9, code lost:
    
        r12 = com.facebook.soloader.SoLoader.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00db, code lost:
    
        if (r12 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dd, code lost:
    
        r12 = b.f.m.ApplicationSoSource.d(r12.e());
        r11.append("\n\tNative lib dir: ");
        r11.append(r12.getAbsolutePath());
        r11.append("\n");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f6, code lost:
    
        com.facebook.soloader.SoLoader.c.readLock().unlock();
        r11.append(" result: ");
        r11.append(r0);
        r11 = r11.toString();
        android.util.Log.e("SoLoader", r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0115, code lost:
    
        throw new java.lang.UnsatisfiedLinkError(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0116, code lost:
    
        r12 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011e, code lost:
    
        android.os.Trace.endSection();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0123, code lost:
    
        android.os.StrictMode.setThreadPolicy(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0138, code lost:
    
        r13 = r12.toString();
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws UnsatisfiedLinkError {
        boolean z2;
        int iA;
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (d == null) {
                Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
                throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
            }
            reentrantReadWriteLock.readLock().unlock();
            int i3 = 0;
            if (threadPolicy == null) {
                threadPolicy = StrictMode.allowThreadDiskReads();
                z2 = true;
            } else {
                z2 = false;
            }
            if (a) {
                Api18TraceUtils.a("SoLoader.loadLibrary[", str, "]");
            }
            try {
                reentrantReadWriteLock.readLock().lock();
                iA = 0;
                int i4 = 0;
                while (true) {
                    if (iA == 0) {
                        try {
                            SoSource[] soSourceArr = d;
                            if (i4 < soSourceArr.length) {
                                iA = soSourceArr[i4].a(str, i2, threadPolicy);
                                if (iA == 3 && f != null) {
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                        } catch (Throwable th) {
                            i3 = iA;
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                iA = i3;
                if (a) {
                }
                if (z2) {
                }
                if (iA != 0) {
                }
                StringBuilder sbX = outline.X("couldn't find DSO to load: ", str);
                String message = th.getMessage();
                if (message == null) {
                }
                sbX.append(" caused by: ");
                sbX.append(message);
                th.printStackTrace();
                sbX.append(" result: ");
                sbX.append(iA);
                String string = sbX.toString();
                Log.e("SoLoader", string);
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(string);
                unsatisfiedLinkError.initCause(th);
                throw unsatisfiedLinkError;
            }
        } finally {
            c.readLock().unlock();
        }
    }

    public static synchronized void b(SoFileLoader soFileLoader) {
        Method declaredMethod;
        String strJoin;
        if (soFileLoader != null) {
            f2906b = soFileLoader;
            return;
        }
        Runtime runtime = Runtime.getRuntime();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23 || i2 > 27) {
            declaredMethod = null;
        } else {
            try {
                declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException | SecurityException e2) {
                Log.w("SoLoader", "Cannot get nativeLoad method", e2);
            }
        }
        boolean z2 = declaredMethod != null;
        String strA = z2 ? Api14Utils.a() : null;
        if (strA == null) {
            strJoin = null;
        } else {
            String[] strArrSplit = strA.split(":");
            ArrayList arrayList = new ArrayList(strArrSplit.length);
            for (String str : strArrSplit) {
                if (!str.contains("!")) {
                    arrayList.add(str);
                }
            }
            strJoin = TextUtils.join(":", arrayList);
        }
        f2906b = new a(z2, strA, strJoin, runtime, declaredMethod);
    }

    public static void c(Context context, int i2) throws IOException {
        int i3;
        boolean zIs64Bit;
        c.writeLock().lock();
        try {
            if (d == null) {
                Log.d("SoLoader", "init start");
                k = i2;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        zIs64Bit = SysUtil$MarshmallowSysdeps.is64Bit();
                    } else {
                        try {
                            zIs64Bit = SysUtil$LollipopSysdeps.is64Bit();
                        } catch (Exception e2) {
                            Log.e("SysUtil", String.format("Could not read /proc/self/exe. Err msg: %s", e2.getMessage()));
                            zIs64Bit = false;
                        }
                    }
                    str = zIs64Bit ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                for (String str2 : str.split(":")) {
                    Log.d("SoLoader", "adding system library source: " + str2);
                    arrayList.add(new DirectorySoSource(new File(str2), 2));
                }
                if (context != null) {
                    if ((i2 & 1) != 0) {
                        f = null;
                        Log.d("SoLoader", "adding exo package source: lib-main");
                        arrayList.add(0, new ExoSoSource(context, "lib-main"));
                    } else {
                        if (l) {
                            i3 = 0;
                        } else {
                            g = new ApplicationSoSource(context, 0);
                            Log.d("SoLoader", "adding application source: " + g.toString());
                            arrayList.add(0, g);
                            i3 = 1;
                        }
                        if ((k & 8) != 0) {
                            f = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            ApkSoSource apkSoSource = new ApkSoSource(context, file, "lib-main", i3);
                            arrayList2.add(apkSoSource);
                            Log.d("SoLoader", "adding backup source from : " + apkSoSource.toString());
                            if (context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d("SoLoader", "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    File file2 = new File(strArr[i4]);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("lib-");
                                    sb.append(i5);
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context, file2, sb.toString(), i3);
                                    Log.d("SoLoader", "adding backup source: " + apkSoSource2.toString());
                                    arrayList2.add(apkSoSource2);
                                    i4++;
                                    i5++;
                                }
                            }
                            f = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                ReentrantReadWriteLock reentrantReadWriteLock = c;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    int i6 = (k & 2) != 0 ? 1 : 0;
                    reentrantReadWriteLock.writeLock().unlock();
                    int length2 = soSourceArr.length;
                    while (true) {
                        int i7 = length2 - 1;
                        if (length2 <= 0) {
                            break;
                        }
                        Log.d("SoLoader", "Preparing SO source: " + soSourceArr[i7]);
                        soSourceArr[i7].b(i6);
                        length2 = i7;
                    }
                    d = soSourceArr;
                    e++;
                    Log.d("SoLoader", "init finish: " + d.length + " SO sources prepared");
                } finally {
                    c.writeLock().unlock();
                }
            }
        } finally {
            Log.d("SoLoader", "init exiting");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b8 A[Catch: all -> 0x0137, PHI: r3
      0x00b8: PHI (r3v5 boolean) = (r3v2 boolean), (r3v3 boolean), (r3v3 boolean) binds: [B:22:0x0044, B:33:0x005b, B:38:0x0091] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bc A[Catch: all -> 0x0137, TryCatch #5 {, blocks: (B:23:0x0046, B:28:0x0050, B:34:0x005d, B:35:0x0076, B:41:0x0094, B:43:0x0096, B:45:0x009c, B:47:0x00a4, B:48:0x00b3, B:49:0x00b4, B:52:0x00b7, B:53:0x00b8, B:55:0x00bc, B:57:0x00c2, B:62:0x00cf, B:64:0x00d3, B:72:0x0124, B:74:0x0128, B:75:0x012b, B:76:0x012c, B:36:0x0077, B:37:0x0090, B:24:0x0047, B:27:0x004f, B:32:0x005a, B:65:0x00da, B:66:0x00fc, B:70:0x0100, B:71:0x0123), top: B:96:0x0046, outer: #6, inners: #0, #2, #3, #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(String str, String str2, String str3, int i2, StrictMode.ThreadPolicy threadPolicy) {
        boolean z2;
        Object obj;
        boolean z3 = false;
        if (!TextUtils.isEmpty(str2) && j.contains(str2)) {
            return false;
        }
        synchronized (SoLoader.class) {
            HashSet<String> hashSet = h;
            if (!hashSet.contains(str)) {
                z2 = false;
            } else {
                if (str3 == null) {
                    return false;
                }
                z2 = true;
            }
            Map<String, Object> map = i;
            if (map.containsKey(str)) {
                obj = map.get(str);
            } else {
                Object obj2 = new Object();
                map.put(str, obj2);
                obj = obj2;
            }
            ReentrantReadWriteLock reentrantReadWriteLock = c;
            reentrantReadWriteLock.readLock().lock();
            try {
                synchronized (obj) {
                    if (!z2) {
                        synchronized (SoLoader.class) {
                            if (hashSet.contains(str)) {
                                if (str3 == null) {
                                    reentrantReadWriteLock.readLock().unlock();
                                    return false;
                                }
                                z2 = true;
                            }
                            if (z2) {
                                if ((i2 & 16) == 0) {
                                }
                                reentrantReadWriteLock.readLock().unlock();
                                return !z2;
                            }
                            try {
                                Log.d("SoLoader", "About to load: " + str);
                                a(str, i2, threadPolicy);
                                synchronized (SoLoader.class) {
                                    Log.d("SoLoader", "Loaded: " + str);
                                    hashSet.add(str);
                                }
                                if ((i2 & 16) == 0) {
                                    if (!TextUtils.isEmpty(str2) && j.contains(str2)) {
                                        z3 = true;
                                    }
                                    if (str3 != null && !z3) {
                                        if (a) {
                                            Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[", str2, "]");
                                        }
                                        try {
                                            try {
                                                Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                                AnimatableValueParser.Q0(str2);
                                                throw null;
                                            } catch (UnsatisfiedLinkError e2) {
                                                throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e2);
                                            }
                                        } catch (Throwable th) {
                                            if (a) {
                                                Trace.endSection();
                                            }
                                            throw th;
                                        }
                                    }
                                }
                                reentrantReadWriteLock.readLock().unlock();
                                return !z2;
                            } catch (UnsatisfiedLinkError e3) {
                                String message = e3.getMessage();
                                if (message == null || !message.contains("unexpected e_machine:")) {
                                    throw e3;
                                }
                                throw new b(e3, message.substring(message.lastIndexOf("unexpected e_machine:")));
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                c.readLock().unlock();
                throw th2;
            }
        }
    }

    public static void init(Context context, int i2) throws IOException {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        boolean z2 = false;
        if ((i2 & 32) == 0 && context != null) {
            try {
                if ((context.getApplicationInfo().flags & Opcodes.LOR) != 0) {
                    z2 = true;
                }
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            }
        }
        l = z2;
        b(null);
        c(context, i2);
        NativeLoader.a(new NativeLoaderToSoLoaderDelegate());
    }
}
