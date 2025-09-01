package b.i.a.c.y2;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;
import b.i.a.c.v2.CryptoInfo;
import b.i.a.c.y2.AsynchronousMediaCodecBufferEnqueuer2;
import b.i.a.c.y2.MediaCodecAdapter;
import b.i.b.a.Supplier2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* compiled from: AsynchronousMediaCodecAdapter.java */
@RequiresApi(23)
/* renamed from: b.i.a.c.y2.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {
    public final MediaCodec a;

    /* renamed from: b, reason: collision with root package name */
    public final AsynchronousMediaCodecCallback f1306b;
    public final AsynchronousMediaCodecBufferEnqueuer2 c;
    public final boolean d;
    public boolean e;
    public int f = 0;

    @Nullable
    public Surface g;

    /* compiled from: AsynchronousMediaCodecAdapter.java */
    /* renamed from: b.i.a.c.y2.l$b */
    public static final class b implements MediaCodecAdapter.b {
        public final Supplier2<HandlerThread> a;

        /* renamed from: b, reason: collision with root package name */
        public final Supplier2<HandlerThread> f1307b;

        public b(int i, boolean z2) {
            b.i.a.c.y2.a aVar = new b.i.a.c.y2.a(i);
            b.i.a.c.y2.b bVar = new b.i.a.c.y2.b(i);
            this.a = aVar;
            this.f1307b = bVar;
        }

        @Override // b.i.a.c.y2.MediaCodecAdapter.b
        public /* bridge */ /* synthetic */ MediaCodecAdapter a(MediaCodecAdapter.a aVar) throws IOException {
            return b(aVar);
        }

        public AsynchronousMediaCodecAdapter b(MediaCodecAdapter.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            String str = aVar.a.a;
            AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter = null;
            try {
                String strValueOf = String.valueOf(str);
                AnimatableValueParser.f(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter2 = new AsynchronousMediaCodecAdapter(mediaCodecCreateByCodecName, this.a.get(), this.f1307b.get(), false, null);
                    try {
                        AnimatableValueParser.d0();
                        AsynchronousMediaCodecAdapter.k(asynchronousMediaCodecAdapter2, aVar.f1314b, aVar.d, aVar.e, 0, false);
                        return asynchronousMediaCodecAdapter2;
                    } catch (Exception e) {
                        e = e;
                        asynchronousMediaCodecAdapter = asynchronousMediaCodecAdapter2;
                        if (asynchronousMediaCodecAdapter != null) {
                            asynchronousMediaCodecAdapter.release();
                        } else if (mediaCodecCreateByCodecName != null) {
                            mediaCodecCreateByCodecName.release();
                        }
                        throw e;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                mediaCodecCreateByCodecName = null;
            }
        }
    }

    public AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z2, a aVar) {
        this.a = mediaCodec;
        this.f1306b = new AsynchronousMediaCodecCallback(handlerThread);
        this.c = new AsynchronousMediaCodecBufferEnqueuer2(mediaCodec, handlerThread2);
        this.d = z2;
    }

    public static void k(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, boolean z2) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = asynchronousMediaCodecAdapter.f1306b;
        MediaCodec mediaCodec = asynchronousMediaCodecAdapter.a;
        AnimatableValueParser.D(asynchronousMediaCodecCallback.c == null);
        asynchronousMediaCodecCallback.f1310b.start();
        Handler handler = new Handler(asynchronousMediaCodecCallback.f1310b.getLooper());
        mediaCodec.setCallback(asynchronousMediaCodecCallback, handler);
        asynchronousMediaCodecCallback.c = handler;
        AnimatableValueParser.f("configureCodec");
        asynchronousMediaCodecAdapter.a.configure(mediaFormat, surface, mediaCrypto, i);
        AnimatableValueParser.d0();
        if (z2) {
            asynchronousMediaCodecAdapter.g = asynchronousMediaCodecAdapter.a.createInputSurface();
        }
        AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = asynchronousMediaCodecAdapter.c;
        if (!asynchronousMediaCodecBufferEnqueuer2.h) {
            asynchronousMediaCodecBufferEnqueuer2.d.start();
            asynchronousMediaCodecBufferEnqueuer2.e = new AsynchronousMediaCodecBufferEnqueuer(asynchronousMediaCodecBufferEnqueuer2, asynchronousMediaCodecBufferEnqueuer2.d.getLooper());
            asynchronousMediaCodecBufferEnqueuer2.h = true;
        }
        AnimatableValueParser.f("startCodec");
        asynchronousMediaCodecAdapter.a.start();
        AnimatableValueParser.d0();
        asynchronousMediaCodecAdapter.f = 1;
    }

    public static String l(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public boolean a() {
        return false;
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void b(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = this.c;
        asynchronousMediaCodecBufferEnqueuer2.f();
        AsynchronousMediaCodecBufferEnqueuer2.a aVarE = AsynchronousMediaCodecBufferEnqueuer2.e();
        aVarE.a = i;
        aVarE.f1309b = i2;
        aVarE.c = 0;
        aVarE.e = j;
        aVarE.f = i3;
        MediaCodec.CryptoInfo cryptoInfo2 = aVarE.d;
        cryptoInfo2.numSubSamples = cryptoInfo.f;
        cryptoInfo2.numBytesOfClearData = AsynchronousMediaCodecBufferEnqueuer2.c(cryptoInfo.d, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = AsynchronousMediaCodecBufferEnqueuer2.c(cryptoInfo.e, cryptoInfo2.numBytesOfEncryptedData);
        byte[] bArrB = AsynchronousMediaCodecBufferEnqueuer2.b(cryptoInfo.f1141b, cryptoInfo2.key);
        Objects.requireNonNull(bArrB);
        cryptoInfo2.key = bArrB;
        byte[] bArrB2 = AsynchronousMediaCodecBufferEnqueuer2.b(cryptoInfo.a, cryptoInfo2.iv);
        Objects.requireNonNull(bArrB2);
        cryptoInfo2.iv = bArrB2;
        cryptoInfo2.mode = cryptoInfo.c;
        if (Util2.a >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.g, cryptoInfo.h));
        }
        asynchronousMediaCodecBufferEnqueuer2.e.obtainMessage(1, aVarE).sendToTarget();
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void c(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public int d() {
        int iB;
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f1306b;
        synchronized (asynchronousMediaCodecCallback.a) {
            iB = -1;
            if (!asynchronousMediaCodecCallback.b()) {
                IllegalStateException illegalStateException = asynchronousMediaCodecCallback.m;
                if (illegalStateException != null) {
                    asynchronousMediaCodecCallback.m = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = asynchronousMediaCodecCallback.j;
                if (codecException != null) {
                    asynchronousMediaCodecCallback.j = null;
                    throw codecException;
                }
                IntArrayQueue intArrayQueue = asynchronousMediaCodecCallback.d;
                if (!(intArrayQueue.c == 0)) {
                    iB = intArrayQueue.b();
                }
            }
        }
        return iB;
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public int e(MediaCodec.BufferInfo bufferInfo) {
        int iB;
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f1306b;
        synchronized (asynchronousMediaCodecCallback.a) {
            iB = -1;
            if (!asynchronousMediaCodecCallback.b()) {
                IllegalStateException illegalStateException = asynchronousMediaCodecCallback.m;
                if (illegalStateException != null) {
                    asynchronousMediaCodecCallback.m = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = asynchronousMediaCodecCallback.j;
                if (codecException != null) {
                    asynchronousMediaCodecCallback.j = null;
                    throw codecException;
                }
                IntArrayQueue intArrayQueue = asynchronousMediaCodecCallback.e;
                if (!(intArrayQueue.c == 0)) {
                    iB = intArrayQueue.b();
                    if (iB >= 0) {
                        AnimatableValueParser.H(asynchronousMediaCodecCallback.h);
                        MediaCodec.BufferInfo bufferInfoRemove = asynchronousMediaCodecCallback.f.remove();
                        bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
                    } else if (iB == -2) {
                        asynchronousMediaCodecCallback.h = asynchronousMediaCodecCallback.g.remove();
                    }
                }
            }
        }
        return iB;
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void f(MediaCodecAdapter.c cVar, Handler handler) {
        m();
        this.a.setOnFrameRenderedListener(new c(this, cVar), handler);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void flush() {
        this.c.d();
        this.a.flush();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f1306b;
        MediaCodec mediaCodec = this.a;
        Objects.requireNonNull(mediaCodec);
        j jVar = new j(mediaCodec);
        synchronized (asynchronousMediaCodecCallback.a) {
            asynchronousMediaCodecCallback.k++;
            Handler handler = asynchronousMediaCodecCallback.c;
            int i = Util2.a;
            handler.post(new d(asynchronousMediaCodecCallback, jVar));
        }
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void g(int i) {
        m();
        this.a.setVideoScalingMode(i);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f1306b;
        synchronized (asynchronousMediaCodecCallback.a) {
            mediaFormat = asynchronousMediaCodecCallback.h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    @Nullable
    public ByteBuffer h(int i) {
        return this.a.getInputBuffer(i);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void i(Surface surface) {
        m();
        this.a.setOutputSurface(surface);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    @Nullable
    public ByteBuffer j(int i) {
        return this.a.getOutputBuffer(i);
    }

    public final void m() {
        if (this.d) {
            try {
                this.c.a();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = this.c;
        asynchronousMediaCodecBufferEnqueuer2.f();
        AsynchronousMediaCodecBufferEnqueuer2.a aVarE = AsynchronousMediaCodecBufferEnqueuer2.e();
        aVarE.a = i;
        aVarE.f1309b = i2;
        aVarE.c = i3;
        aVarE.e = j;
        aVarE.f = i4;
        Handler handler = asynchronousMediaCodecBufferEnqueuer2.e;
        int i5 = Util2.a;
        handler.obtainMessage(0, aVarE).sendToTarget();
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void release() {
        try {
            if (this.f == 1) {
                AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = this.c;
                if (asynchronousMediaCodecBufferEnqueuer2.h) {
                    asynchronousMediaCodecBufferEnqueuer2.d();
                    asynchronousMediaCodecBufferEnqueuer2.d.quit();
                }
                asynchronousMediaCodecBufferEnqueuer2.h = false;
                AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f1306b;
                synchronized (asynchronousMediaCodecCallback.a) {
                    asynchronousMediaCodecCallback.l = true;
                    asynchronousMediaCodecCallback.f1310b.quit();
                    asynchronousMediaCodecCallback.a();
                }
            }
            this.f = 2;
        } finally {
            Surface surface = this.g;
            if (surface != null) {
                surface.release();
            }
            if (!this.e) {
                this.a.release();
                this.e = true;
            }
        }
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void releaseOutputBuffer(int i, boolean z2) {
        this.a.releaseOutputBuffer(i, z2);
    }

    @Override // b.i.a.c.y2.MediaCodecAdapter
    public void setParameters(Bundle bundle) {
        m();
        this.a.setParameters(bundle);
    }
}
