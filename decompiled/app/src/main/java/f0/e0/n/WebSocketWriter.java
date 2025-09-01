package f0.e0.n;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import g0.Buffer3;
import g0.Segment2;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import okio.BufferedSink;
import okio.ByteString;
import org.objectweb.asm.Opcodes;

/* compiled from: WebSocketWriter.kt */
/* renamed from: f0.e0.n.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class WebSocketWriter implements Closeable {
    public final Buffer3 j;
    public final Buffer3 k;
    public boolean l;
    public MessageDeflater m;
    public final byte[] n;
    public final Buffer3.a o;
    public final boolean p;
    public final BufferedSink q;
    public final Random r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f3668s;
    public final boolean t;
    public final long u;

    public WebSocketWriter(boolean z2, BufferedSink bufferedSink, Random random, boolean z3, boolean z4, long j) {
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        Intrinsics3.checkParameterIsNotNull(random, "random");
        this.p = z2;
        this.q = bufferedSink;
        this.r = random;
        this.f3668s = z3;
        this.t = z4;
        this.u = j;
        this.j = new Buffer3();
        this.k = bufferedSink.g();
        this.n = z2 ? new byte[4] : null;
        this.o = z2 ? new Buffer3.a() : null;
    }

    public final void a(int i, ByteString byteString) throws IOException {
        ByteString byteStringX = ByteString.j;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                String strQ = (i < 1000 || i >= 5000) ? outline.q("Code must be in range [1000,5000): ", i) : ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) ? null : outline.r("Code ", i, " is reserved and may not be used.");
                if (!(strQ == null)) {
                    if (strQ == null) {
                        Intrinsics3.throwNpe();
                    }
                    throw new IllegalArgumentException(strQ.toString());
                }
            }
            Buffer3 buffer3 = new Buffer3();
            buffer3.X(i);
            if (byteString != null) {
                buffer3.O(byteString);
            }
            byteStringX = buffer3.x();
        }
        try {
            b(8, byteStringX);
        } finally {
            this.l = true;
        }
    }

    public final void b(int i, ByteString byteString) throws IOException {
        if (this.l) {
            throw new IOException("closed");
        }
        int iJ = byteString.j();
        if (!(((long) iJ) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.k.T(i | 128);
        if (this.p) {
            this.k.T(iJ | 128);
            Random random = this.r;
            byte[] bArr = this.n;
            if (bArr == null) {
                Intrinsics3.throwNpe();
            }
            random.nextBytes(bArr);
            this.k.R(this.n);
            if (iJ > 0) {
                Buffer3 buffer3 = this.k;
                long j = buffer3.k;
                buffer3.O(byteString);
                Buffer3 buffer32 = this.k;
                Buffer3.a aVar = this.o;
                if (aVar == null) {
                    Intrinsics3.throwNpe();
                }
                buffer32.u(aVar);
                this.o.b(j);
                WebSocketProtocol.a(this.o, this.n);
                this.o.close();
            }
        } else {
            this.k.T(iJ);
            this.k.O(byteString);
        }
        this.q.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(int i, ByteString byteString) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteString, "data");
        if (this.l) {
            throw new IOException("closed");
        }
        this.j.O(byteString);
        int i2 = i | 128;
        if (this.f3668s && byteString.j() >= this.u) {
            MessageDeflater messageDeflater = this.m;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.t);
                this.m = messageDeflater;
            }
            Buffer3 buffer3 = this.j;
            Intrinsics3.checkParameterIsNotNull(buffer3, "buffer");
            boolean z2 = true;
            if (!(messageDeflater.j.k == 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (messageDeflater.m) {
                messageDeflater.k.reset();
            }
            messageDeflater.l.write(buffer3, buffer3.k);
            messageDeflater.l.flush();
            Buffer3 buffer32 = messageDeflater.j;
            ByteString byteString2 = MessageDeflater2.a;
            long j = buffer32.k - byteString2.j();
            Intrinsics3.checkParameterIsNotNull(byteString2, "bytes");
            int iJ = byteString2.j();
            Intrinsics3.checkParameterIsNotNull(byteString2, "bytes");
            if (j < 0 || iJ < 0 || buffer32.k - j < iJ || byteString2.j() - 0 < iJ) {
                z2 = false;
                if (z2) {
                    messageDeflater.j.T(0);
                } else {
                    Buffer3 buffer33 = messageDeflater.j;
                    long j2 = buffer33.k - 4;
                    Buffer3.a aVar = new Buffer3.a();
                    buffer33.u(aVar);
                    try {
                        aVar.a(j2);
                        d0.y.Closeable.closeFinally(aVar, null);
                    } finally {
                    }
                }
                Buffer3 buffer34 = messageDeflater.j;
                buffer3.write(buffer34, buffer34.k);
                i2 |= 64;
            } else {
                for (int i3 = 0; i3 < iJ; i3++) {
                    if (buffer32.q(i3 + j) != byteString2.m(0 + i3)) {
                        z2 = false;
                        break;
                    }
                }
                if (z2) {
                }
                Buffer3 buffer342 = messageDeflater.j;
                buffer3.write(buffer342, buffer342.k);
                i2 |= 64;
            }
        }
        long j3 = this.j.k;
        this.k.T(i2);
        int i4 = this.p ? 128 : 0;
        if (j3 <= 125) {
            this.k.T(i4 | ((int) j3));
        } else if (j3 <= 65535) {
            this.k.T(i4 | 126);
            this.k.X((int) j3);
        } else {
            this.k.T(i4 | Opcodes.LAND);
            Buffer3 buffer35 = this.k;
            Segment2 segment2N = buffer35.N(8);
            byte[] bArr = segment2N.a;
            int i5 = segment2N.c;
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((j3 >>> 56) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j3 >>> 48) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((j3 >>> 40) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((j3 >>> 32) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) ((j3 >>> 24) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((j3 >>> 16) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((j3 >>> 8) & 255);
            bArr[i12] = (byte) (j3 & 255);
            segment2N.c = i12 + 1;
            buffer35.k += 8;
        }
        if (this.p) {
            Random random = this.r;
            byte[] bArr2 = this.n;
            if (bArr2 == null) {
                Intrinsics3.throwNpe();
            }
            random.nextBytes(bArr2);
            this.k.R(this.n);
            if (j3 > 0) {
                Buffer3 buffer36 = this.j;
                Buffer3.a aVar2 = this.o;
                if (aVar2 == null) {
                    Intrinsics3.throwNpe();
                }
                buffer36.u(aVar2);
                this.o.b(0L);
                WebSocketProtocol.a(this.o, this.n);
                this.o.close();
            }
        }
        this.k.write(this.j, j3);
        this.q.p();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.m;
        if (messageDeflater != null) {
            messageDeflater.l.close();
        }
    }
}
