package b.i.a.c.x2.k0;

import b.c.a.a0.AnimatableValueParser;
import java.util.Arrays;

/* compiled from: NalUnitTargetBuffer.java */
/* renamed from: b.i.a.c.x2.k0.w, reason: use source file name */
/* loaded from: classes3.dex */
public final class NalUnitTargetBuffer {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1281b;
    public boolean c;
    public byte[] d;
    public int e;

    public NalUnitTargetBuffer(int i, int i2) {
        this.a = i;
        byte[] bArr = new byte[i2 + 3];
        this.d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f1281b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.d;
            int length = bArr2.length;
            int i4 = this.e;
            if (length < i4 + i3) {
                this.d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.d, this.e, i3);
            this.e += i3;
        }
    }

    public boolean b(int i) {
        if (!this.f1281b) {
            return false;
        }
        this.e -= i;
        this.f1281b = false;
        this.c = true;
        return true;
    }

    public void c() {
        this.f1281b = false;
        this.c = false;
    }

    public void d(int i) {
        AnimatableValueParser.D(!this.f1281b);
        boolean z2 = i == this.a;
        this.f1281b = z2;
        if (z2) {
            this.e = 3;
            this.c = false;
        }
    }
}
