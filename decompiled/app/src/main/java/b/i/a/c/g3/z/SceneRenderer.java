package b.i.a.c.g3.z;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import androidx.annotation.Nullable;
import androidx.work.Data;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.TimedValueQueue;
import b.i.a.c.g3.VideoFrameMetadataListener;
import b.i.a.c.g3.z.Projection;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SceneRenderer.java */
/* renamed from: b.i.a.c.g3.z.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class SceneRenderer implements VideoFrameMetadataListener, CameraMotionListener {
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public SurfaceTexture f1004s;

    @Nullable
    public byte[] v;
    public final AtomicBoolean j = new AtomicBoolean();
    public final AtomicBoolean k = new AtomicBoolean(true);
    public final ProjectionRenderer l = new ProjectionRenderer();
    public final FrameRotationQueue m = new FrameRotationQueue();
    public final TimedValueQueue<Long> n = new TimedValueQueue<>();
    public final TimedValueQueue<Projection> o = new TimedValueQueue<>();
    public final float[] p = new float[16];
    public final float[] q = new float[16];
    public volatile int t = 0;
    public int u = -1;

    @Override // b.i.a.c.g3.z.CameraMotionListener
    public void a(long j, float[] fArr) {
        this.m.c.a(j, fArr);
    }

    public SurfaceTexture b() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.a();
        ProjectionRenderer projectionRenderer = this.l;
        Objects.requireNonNull(projectionRenderer);
        GlUtil.a aVar = new GlUtil.a(ProjectionRenderer.a, ProjectionRenderer.f1002b);
        projectionRenderer.k = aVar;
        projectionRenderer.l = GLES20.glGetUniformLocation(aVar.a, "uMvpMatrix");
        projectionRenderer.m = GLES20.glGetUniformLocation(projectionRenderer.k.a, "uTexMatrix");
        projectionRenderer.n = GLES20.glGetAttribLocation(projectionRenderer.k.a, "aPosition");
        projectionRenderer.o = GLES20.glGetAttribLocation(projectionRenderer.k.a, "aTexCoords");
        projectionRenderer.p = GLES20.glGetUniformLocation(projectionRenderer.k.a, "uTexture");
        GlUtil.a();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.a();
        this.r = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.r);
        this.f1004s = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new a(this));
        return this.f1004s;
    }

    @Override // b.i.a.c.g3.z.CameraMotionListener
    public void c() {
        this.n.b();
        FrameRotationQueue frameRotationQueue = this.m;
        frameRotationQueue.c.b();
        frameRotationQueue.d = false;
        this.k.set(true);
    }

    @Override // b.i.a.c.g3.VideoFrameMetadataListener
    public void e(long j, long j2, Format2 format2, @Nullable MediaFormat mediaFormat) {
        float f;
        float f2;
        int i;
        int i2;
        ArrayList<Projection.a> arrayListT1;
        int iF;
        this.n.a(j2, Long.valueOf(j));
        byte[] bArr = format2.G;
        int i3 = format2.H;
        byte[] bArr2 = this.v;
        int i4 = this.u;
        this.v = bArr;
        if (i3 == -1) {
            i3 = this.t;
        }
        this.u = i3;
        if (i4 == i3 && Arrays.equals(bArr2, this.v)) {
            return;
        }
        byte[] bArr3 = this.v;
        Projection projection = null;
        if (bArr3 != null) {
            int i5 = this.u;
            ParsableByteArray parsableByteArray = new ParsableByteArray(bArr3);
            try {
                parsableByteArray.F(4);
                iF = parsableByteArray.f();
                parsableByteArray.E(0);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            if (iF == 1886547818) {
                parsableByteArray.F(8);
                int i6 = parsableByteArray.f984b;
                int i7 = parsableByteArray.c;
                while (i6 < i7) {
                    int iF2 = parsableByteArray.f() + i6;
                    if (iF2 > i6 && iF2 <= i7) {
                        int iF3 = parsableByteArray.f();
                        if (iF3 != 2037673328 && iF3 != 1836279920) {
                            parsableByteArray.E(iF2);
                            i6 = iF2;
                        }
                        parsableByteArray.D(iF2);
                        arrayListT1 = AnimatableValueParser.t1(parsableByteArray);
                        break;
                    }
                    break;
                }
                arrayListT1 = null;
            } else {
                arrayListT1 = AnimatableValueParser.t1(parsableByteArray);
            }
            if (arrayListT1 != null) {
                int size = arrayListT1.size();
                if (size == 1) {
                    projection = new Projection(arrayListT1.get(0), i5);
                } else if (size == 2) {
                    projection = new Projection(arrayListT1.get(0), arrayListT1.get(1), i5);
                }
            }
        }
        if (projection == null || !ProjectionRenderer.a(projection)) {
            int i8 = this.u;
            AnimatableValueParser.j(true);
            AnimatableValueParser.j(true);
            AnimatableValueParser.j(true);
            AnimatableValueParser.j(true);
            AnimatableValueParser.j(true);
            float radians = (float) Math.toRadians(180.0f);
            float radians2 = (float) Math.toRadians(360.0f);
            float f3 = radians / 36;
            float f4 = radians2 / 72;
            float[] fArr = new float[15984];
            float[] fArr2 = new float[10656];
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 36; i9 < i12; i12 = 36) {
                float f5 = radians / 2.0f;
                float f6 = (i9 * f3) - f5;
                int i13 = i9 + 1;
                float f7 = (i13 * f3) - f5;
                int i14 = 0;
                while (i14 < 73) {
                    int i15 = i13;
                    int i16 = 0;
                    for (int i17 = 2; i16 < i17; i17 = 2) {
                        if (i16 == 0) {
                            f2 = f7;
                            f = f6;
                        } else {
                            f = f7;
                            f2 = f;
                        }
                        float f8 = i14 * f4;
                        float f9 = f6;
                        int i18 = i10 + 1;
                        float f10 = f4;
                        double d = 50.0f;
                        int i19 = i14;
                        double d2 = (f8 + 3.1415927f) - (radians2 / 2.0f);
                        int i20 = i8;
                        float f11 = radians;
                        double d3 = f;
                        float f12 = f3;
                        fArr[i10] = -((float) (Math.cos(d3) * Math.sin(d2) * d));
                        int i21 = i18 + 1;
                        int i22 = i16;
                        fArr[i18] = (float) (Math.sin(d3) * d);
                        int i23 = i21 + 1;
                        fArr[i21] = (float) (Math.cos(d3) * Math.cos(d2) * d);
                        int i24 = i11 + 1;
                        fArr2[i11] = f8 / radians2;
                        int i25 = i24 + 1;
                        fArr2[i24] = ((i9 + i22) * f12) / f11;
                        if (i19 == 0 && i22 == 0) {
                            i2 = i22;
                            i = i19;
                        } else {
                            i = i19;
                            i2 = i22;
                            if (i != 72 || i2 != 1) {
                            }
                            i11 = i25;
                            i10 = i23;
                            i16 = i2 + 1;
                            i14 = i;
                            f7 = f2;
                            f4 = f10;
                            f6 = f9;
                            radians = f11;
                            f3 = f12;
                            i8 = i20;
                        }
                        System.arraycopy(fArr, i23 - 3, fArr, i23, 3);
                        i23 += 3;
                        System.arraycopy(fArr2, i25 - 2, fArr2, i25, 2);
                        i25 += 2;
                        i11 = i25;
                        i10 = i23;
                        i16 = i2 + 1;
                        i14 = i;
                        f7 = f2;
                        f4 = f10;
                        f6 = f9;
                        radians = f11;
                        f3 = f12;
                        i8 = i20;
                    }
                    i14++;
                    i13 = i15;
                    f7 = f7;
                    i8 = i8;
                }
                i9 = i13;
            }
            projection = new Projection(new Projection.a(new Projection.b(0, fArr, fArr2, 1)), i8);
        }
        this.o.a(j2, projection);
    }
}
