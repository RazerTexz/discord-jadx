package b.i.a.c.g3.z;

import b.c.a.a0.AnimatableValueParser;

/* compiled from: Projection.java */
/* renamed from: b.i.a.c.g3.z.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class Projection {
    public final a a;

    /* renamed from: b, reason: collision with root package name */
    public final a f1000b;
    public final int c;
    public final boolean d;

    /* compiled from: Projection.java */
    /* renamed from: b.i.a.c.g3.z.h$a */
    public static final class a {
        public final b[] a;

        public a(b... bVarArr) {
            this.a = bVarArr;
        }
    }

    /* compiled from: Projection.java */
    /* renamed from: b.i.a.c.g3.z.h$b */
    public static final class b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1001b;
        public final float[] c;
        public final float[] d;

        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.a = i;
            AnimatableValueParser.j(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.c = fArr;
            this.d = fArr2;
            this.f1001b = i2;
        }
    }

    public Projection(a aVar, int i) {
        this.a = aVar;
        this.f1000b = aVar;
        this.c = i;
        this.d = aVar == aVar;
    }

    public Projection(a aVar, a aVar2, int i) {
        this.a = aVar;
        this.f1000b = aVar2;
        this.c = i;
        this.d = aVar == aVar2;
    }
}
