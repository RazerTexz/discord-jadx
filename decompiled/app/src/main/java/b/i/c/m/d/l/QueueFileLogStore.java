package b.i.c.m.d.l;

import b.i.c.m.d.l.QueueFile;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: QueueFileLogStore.java */
/* renamed from: b.i.c.m.d.l.d, reason: use source file name */
/* loaded from: classes3.dex */
public class QueueFileLogStore implements QueueFile.d {
    public final /* synthetic */ byte[] a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int[] f1710b;

    public QueueFileLogStore(QueueFileLogStore2 queueFileLogStore2, byte[] bArr, int[] iArr) {
        this.a = bArr;
        this.f1710b = iArr;
    }

    @Override // b.i.c.m.d.l.QueueFile.d
    public void a(InputStream inputStream, int i) throws IOException {
        try {
            inputStream.read(this.a, this.f1710b[0], i);
            int[] iArr = this.f1710b;
            iArr[0] = iArr[0] + i;
        } finally {
            inputStream.close();
        }
    }
}
