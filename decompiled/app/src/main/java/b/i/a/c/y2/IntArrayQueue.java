package b.i.a.c.y2;

import java.util.NoSuchElementException;

/* compiled from: IntArrayQueue.java */
/* renamed from: b.i.a.c.y2.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class IntArrayQueue {
    public int a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f1313b = -1;
    public int c = 0;
    public int[] d = new int[16];
    public int e;

    public IntArrayQueue() {
        this.e = r0.length - 1;
    }

    public void a(int i) {
        int i2 = this.c;
        int[] iArr = this.d;
        if (i2 == iArr.length) {
            int length = iArr.length << 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i3 = this.a;
            int i4 = length2 - i3;
            System.arraycopy(iArr, i3, iArr2, 0, i4);
            System.arraycopy(this.d, 0, iArr2, i4, i3);
            this.a = 0;
            this.f1313b = this.c - 1;
            this.d = iArr2;
            this.e = length - 1;
        }
        int i5 = (this.f1313b + 1) & this.e;
        this.f1313b = i5;
        this.d[i5] = i;
        this.c++;
    }

    public int b() {
        int i = this.c;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.d;
        int i2 = this.a;
        int i3 = iArr[i2];
        this.a = (i2 + 1) & this.e;
        this.c = i - 1;
        return i3;
    }
}
