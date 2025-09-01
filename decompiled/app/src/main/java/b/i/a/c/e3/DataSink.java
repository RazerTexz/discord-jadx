package b.i.a.c.e3;

import java.io.IOException;

/* compiled from: DataSink.java */
/* renamed from: b.i.a.c.e3.j, reason: use source file name */
/* loaded from: classes3.dex */
public interface DataSink {
    void a(DataSpec dataSpec) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
