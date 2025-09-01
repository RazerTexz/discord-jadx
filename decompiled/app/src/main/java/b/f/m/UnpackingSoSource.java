package b.f.m;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.facebook.soloader.SysUtil$LollipopSysdeps;
import java.io.Closeable;
import java.io.DataInput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: UnpackingSoSource.java */
/* renamed from: b.f.m.m, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class UnpackingSoSource extends DirectorySoSource {
    public final Context c;
    public String d;
    public final Map<String, Object> e;

    /* compiled from: UnpackingSoSource.java */
    /* renamed from: b.f.m.m$a */
    public class a implements Runnable {
        public final /* synthetic */ File j;
        public final /* synthetic */ byte[] k;
        public final /* synthetic */ c l;
        public final /* synthetic */ File m;
        public final /* synthetic */ FileLocker n;

        public a(File file, byte[] bArr, c cVar, File file2, FileLocker fileLocker) {
            this.j = file;
            this.k = bArr;
            this.l = cVar;
            this.m = file2;
            this.n = fileLocker;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    Log.v("fb-UnpackingSoSource", "starting syncer worker");
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.j, "rw");
                    try {
                        randomAccessFile.write(this.k);
                        randomAccessFile.setLength(randomAccessFile.getFilePointer());
                        randomAccessFile.close();
                        randomAccessFile = new RandomAccessFile(new File(UnpackingSoSource.this.a, "dso_manifest"), "rw");
                        try {
                            c cVar = this.l;
                            Objects.requireNonNull(cVar);
                            randomAccessFile.writeByte(1);
                            randomAccessFile.writeInt(cVar.a.length);
                            int i = 0;
                            while (true) {
                                b[] bVarArr = cVar.a;
                                if (i >= bVarArr.length) {
                                    randomAccessFile.close();
                                    AnimatableValueParser.m0(UnpackingSoSource.this.a);
                                    UnpackingSoSource.l(this.m, (byte) 1);
                                    return;
                                } else {
                                    randomAccessFile.writeUTF(bVarArr[i].j);
                                    randomAccessFile.writeUTF(cVar.a[i].k);
                                    i++;
                                }
                            }
                        } finally {
                        }
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                } finally {
                    Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + UnpackingSoSource.this.a + " (from syncer thread)");
                    this.n.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: UnpackingSoSource.java */
    /* renamed from: b.f.m.m$b */
    public static class b {
        public final String j;
        public final String k;

        public b(String str, String str2) {
            this.j = str;
            this.k = str2;
        }
    }

    /* compiled from: UnpackingSoSource.java */
    /* renamed from: b.f.m.m$c */
    public static final class c {
        public final b[] a;

        public c(b[] bVarArr) {
            this.a = bVarArr;
        }

        public static final c a(DataInput dataInput) throws IOException {
            if (dataInput.readByte() != 1) {
                throw new RuntimeException("wrong dso manifest version");
            }
            int i = dataInput.readInt();
            if (i < 0) {
                throw new RuntimeException("illegal number of shared libraries");
            }
            b[] bVarArr = new b[i];
            for (int i2 = 0; i2 < i; i2++) {
                bVarArr[i2] = new b(dataInput.readUTF(), dataInput.readUTF());
            }
            return new c(bVarArr);
        }
    }

    /* compiled from: UnpackingSoSource.java */
    /* renamed from: b.f.m.m$d */
    public static final class d implements Closeable {
        public final b j;
        public final InputStream k;

        public d(b bVar, InputStream inputStream) {
            this.j = bVar;
            this.k = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.k.close();
        }
    }

    /* compiled from: UnpackingSoSource.java */
    /* renamed from: b.f.m.m$e */
    public static abstract class e implements Closeable {
        public abstract boolean a();

        public abstract d b() throws IOException;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    /* compiled from: UnpackingSoSource.java */
    /* renamed from: b.f.m.m$f */
    public static abstract class f implements Closeable {
        public abstract c a() throws IOException;

        public abstract e b() throws IOException;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    public UnpackingSoSource(Context context, String str) {
        super(new File(outline.K(new StringBuilder(), context.getApplicationInfo().dataDir, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, str)), 1);
        this.e = new HashMap();
        this.c = context;
    }

    public static void l(File file, byte b2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b2);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // b.f.m.DirectorySoSource, b.f.m.SoSource
    public int a(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int iC;
        synchronized (h(str)) {
            iC = c(str, i, this.a, threadPolicy);
        }
        return iC;
    }

    @Override // b.f.m.SoSource
    public void b(int i) throws IOException {
        File file = this.a;
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
        FileLocker fileLocker = new FileLocker(new File(this.a, "dso_lock"));
        try {
            Log.v("fb-UnpackingSoSource", "locked dso store " + this.a);
            if (j(fileLocker, i, g())) {
                fileLocker = null;
            } else {
                Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.a);
            }
            if (fileLocker != null) {
                return;
            }
            StringBuilder sbU = outline.U("not releasing dso store lock for ");
            sbU.append(this.a);
            sbU.append(" (syncer thread started)");
            Log.v("fb-UnpackingSoSource", sbU.toString());
        } finally {
            StringBuilder sbU2 = outline.U("releasing dso store lock for ");
            sbU2.append(this.a);
            Log.v("fb-UnpackingSoSource", sbU2.toString());
            fileLocker.close();
        }
    }

    public final void d(b[] bVarArr) throws IOException {
        String[] list = this.a.list();
        if (list == null) {
            StringBuilder sbU = outline.U("unable to list directory ");
            sbU.append(this.a);
            throw new IOException(sbU.toString());
        }
        for (String str : list) {
            if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                boolean z2 = false;
                for (int i = 0; !z2 && i < bVarArr.length; i++) {
                    if (bVarArr[i].j.equals(str)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    File file = new File(this.a, str);
                    Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + file);
                    AnimatableValueParser.b0(file);
                }
            }
        }
    }

    public final void e(d dVar, byte[] bArr) throws IOException {
        StringBuilder sbU = outline.U("extracting DSO ");
        sbU.append(dVar.j.j);
        Log.i("fb-UnpackingSoSource", sbU.toString());
        try {
            if (this.a.setWritable(true)) {
                f(dVar, bArr);
            } else {
                throw new IOException("cannot make directory writable for us: " + this.a);
            }
        } finally {
            if (!this.a.setWritable(false)) {
                StringBuilder sbU2 = outline.U("error removing ");
                sbU2.append(this.a.getCanonicalPath());
                sbU2.append(" write permission");
                Log.w("fb-UnpackingSoSource", sbU2.toString());
            }
        }
    }

    public final void f(d dVar, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.a, dVar.j.j);
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (file.exists() && !file.setWritable(true)) {
                    Log.w("fb-UnpackingSoSource", "error adding write permission to: " + file);
                }
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException e2) {
                    Log.w("fb-UnpackingSoSource", "error overwriting " + file + " trying to delete and start over", e2);
                    AnimatableValueParser.b0(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                }
                randomAccessFile2 = randomAccessFile;
                int iAvailable = dVar.k.available();
                if (iAvailable > 1) {
                    SysUtil$LollipopSysdeps.fallocateIfSupported(randomAccessFile2.getFD(), iAvailable);
                }
                InputStream inputStream = dVar.k;
                int i = 0;
                while (i < Integer.MAX_VALUE) {
                    int i2 = inputStream.read(bArr, 0, Math.min(bArr.length, Integer.MAX_VALUE - i));
                    if (i2 == -1) {
                        break;
                    }
                    randomAccessFile2.write(bArr, 0, i2);
                    i += i2;
                }
                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                if (!file.setExecutable(true, false)) {
                    throw new IOException("cannot make file executable: " + file);
                }
                if (!file.setWritable(false)) {
                    Log.w("fb-UnpackingSoSource", "error removing " + file + " write permission");
                }
                randomAccessFile2.close();
            } catch (IOException e3) {
                AnimatableValueParser.b0(file);
                throw e3;
            }
        } catch (Throwable th) {
            if (!file.setWritable(false)) {
                Log.w("fb-UnpackingSoSource", "error removing " + file + " write permission");
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    public byte[] g() throws IOException {
        Parcel parcelObtain = Parcel.obtain();
        f fVarI = i();
        try {
            b[] bVarArr = fVarI.a().a;
            parcelObtain.writeByte((byte) 1);
            parcelObtain.writeInt(bVarArr.length);
            for (int i = 0; i < bVarArr.length; i++) {
                parcelObtain.writeString(bVarArr[i].j);
                parcelObtain.writeString(bVarArr[i].k);
            }
            fVarI.close();
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fVarI != null) {
                    try {
                        fVarI.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public final Object h(String str) {
        Object obj;
        synchronized (this.e) {
            obj = this.e.get(str);
            if (obj == null) {
                obj = new Object();
                this.e.put(str, obj);
            }
        }
        return obj;
    }

    public abstract f i() throws IOException;

    public final boolean j(FileLocker fileLocker, int i, byte[] bArr) throws IOException {
        byte b2;
        File file = new File(this.a, "dso_state");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            b2 = randomAccessFile.readByte();
        } catch (EOFException unused) {
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
            }
        }
        if (b2 != 1) {
            Log.v("fb-UnpackingSoSource", "dso store " + this.a + " regeneration interrupted: wiping clean");
            b2 = 0;
        }
        randomAccessFile.close();
        File file2 = new File(this.a, "dso_deps");
        c cVarA = null;
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            int length = (int) randomAccessFile.length();
            byte[] bArr2 = new byte[length];
            if (randomAccessFile.read(bArr2) != length) {
                Log.v("fb-UnpackingSoSource", "short read of so store deps file: marking unclean");
                b2 = 0;
            }
            if (!Arrays.equals(bArr2, bArr)) {
                Log.v("fb-UnpackingSoSource", "deps mismatch on deps store: regenerating");
                b2 = 0;
            }
            if (b2 == 0 || (i & 2) != 0) {
                Log.v("fb-UnpackingSoSource", "so store dirty: regenerating");
                l(file, (byte) 0);
                f fVarI = i();
                try {
                    cVarA = fVarI.a();
                    try {
                        k(b2, cVarA, fVarI.b());
                        fVarI.close();
                    } finally {
                    }
                } finally {
                }
            }
            c cVar = cVarA;
            randomAccessFile.close();
            if (cVar == null) {
                return false;
            }
            a aVar = new a(file2, bArr, cVar, file, fileLocker);
            if ((i & 1) != 0) {
                StringBuilder sbU = outline.U("SoSync:");
                sbU.append(this.a.getName());
                new Thread(aVar, sbU.toString()).start();
            } else {
                aVar.run();
            }
            return true;
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
            }
        }
    }

    public final void k(byte b2, c cVar, e eVar) throws IOException {
        c cVarA;
        StringBuilder sbU = outline.U("regenerating DSO store ");
        sbU.append(getClass().getName());
        Log.v("fb-UnpackingSoSource", sbU.toString());
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.a, "dso_manifest"), "rw");
        try {
            if (b2 == 1) {
                try {
                    cVarA = c.a(randomAccessFile);
                } catch (Exception e2) {
                    Log.i("fb-UnpackingSoSource", "error reading existing DSO manifest", e2);
                }
            } else {
                cVarA = null;
            }
            if (cVarA == null) {
                cVarA = new c(new b[0]);
            }
            d(cVar.a);
            byte[] bArr = new byte[32768];
            while (eVar.a()) {
                d dVarB = eVar.b();
                boolean z2 = true;
                int i = 0;
                while (z2) {
                    try {
                        b[] bVarArr = cVarA.a;
                        if (i >= bVarArr.length) {
                            break;
                        }
                        if (bVarArr[i].j.equals(dVarB.j.j) && cVarA.a[i].k.equals(dVarB.j.k)) {
                            z2 = false;
                        }
                        i++;
                    } finally {
                    }
                }
                if (z2) {
                    e(dVarB, bArr);
                }
                if (dVarB != null) {
                    dVarB.k.close();
                }
            }
            randomAccessFile.close();
            Log.v("fb-UnpackingSoSource", "Finished regenerating DSO store " + getClass().getName());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
