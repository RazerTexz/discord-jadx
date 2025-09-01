package b.f.m;

import android.content.Context;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.m.UnpackingSoSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: ExoSoSource.java */
/* renamed from: b.f.m.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExoSoSource extends UnpackingSoSource {

    /* compiled from: ExoSoSource.java */
    /* renamed from: b.f.m.e$b */
    public final class b extends UnpackingSoSource.f {
        public final c[] j;

        /* compiled from: ExoSoSource.java */
        /* renamed from: b.f.m.e$b$a */
        public final class a extends UnpackingSoSource.e {
            public int j;

            public a(a aVar) {
            }

            @Override // b.f.m.UnpackingSoSource.e
            public boolean a() {
                return this.j < b.this.j.length;
            }

            @Override // b.f.m.UnpackingSoSource.e
            public UnpackingSoSource.d b() throws IOException {
                c[] cVarArr = b.this.j;
                int i = this.j;
                this.j = i + 1;
                c cVar = cVarArr[i];
                FileInputStream fileInputStream = new FileInputStream(cVar.l);
                try {
                    return new UnpackingSoSource.d(cVar, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d8, code lost:
        
            throw new java.lang.RuntimeException("illegal line in exopackage metadata: [" + r10 + "]");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(ExoSoSource exoSoSource, UnpackingSoSource unpackingSoSource) throws IOException {
            boolean z2;
            Context context = exoSoSource.c;
            StringBuilder sbU = outline.U("/data/local/tmp/exopackage/");
            sbU.append(context.getPackageName());
            sbU.append("/native-libs/");
            File file = new File(sbU.toString());
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            loop0: for (String str : AnimatableValueParser.C0()) {
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    linkedHashSet.add(str);
                    File file3 = new File(file2, "metadata.txt");
                    if (file3.isFile()) {
                        FileReader fileReader = new FileReader(file3);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        bufferedReader.close();
                                        fileReader.close();
                                        break;
                                    }
                                    if (line.length() != 0) {
                                        int iIndexOf = line.indexOf(32);
                                        if (iIndexOf == -1) {
                                            break loop0;
                                        }
                                        String str2 = line.substring(0, iIndexOf) + ".so";
                                        int size = arrayList.size();
                                        int i = 0;
                                        while (true) {
                                            if (i >= size) {
                                                z2 = false;
                                                break;
                                            } else {
                                                if (((c) arrayList.get(i)).j.equals(str2)) {
                                                    z2 = true;
                                                    break;
                                                }
                                                i++;
                                            }
                                        }
                                        if (!z2) {
                                            String strSubstring = line.substring(iIndexOf + 1);
                                            arrayList.add(new c(str2, strSubstring, new File(file2, strSubstring)));
                                        }
                                    }
                                } finally {
                                }
                            }
                        } finally {
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.j = (c[]) arrayList.toArray(new c[arrayList.size()]);
        }

        @Override // b.f.m.UnpackingSoSource.f
        public UnpackingSoSource.c a() throws IOException {
            return new UnpackingSoSource.c(this.j);
        }

        @Override // b.f.m.UnpackingSoSource.f
        public UnpackingSoSource.e b() throws IOException {
            return new a(null);
        }
    }

    /* compiled from: ExoSoSource.java */
    /* renamed from: b.f.m.e$c */
    public static final class c extends UnpackingSoSource.b {
        public final File l;

        public c(String str, String str2, File file) {
            super(str, str2);
            this.l = file;
        }
    }

    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    @Override // b.f.m.UnpackingSoSource
    public UnpackingSoSource.f i() throws IOException {
        return new b(this, this);
    }
}
