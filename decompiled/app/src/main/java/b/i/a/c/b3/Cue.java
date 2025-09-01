package b.i.a.c.b3;

import android.graphics.Bitmap;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Bundleable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: Cue.java */
/* renamed from: b.i.a.c.b3.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class Cue implements Bundleable {
    public static final Cue j = new Cue("", null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
    public static final Bundleable.a<Cue> k = b.i.a.c.b3.a.a;
    public final int A;
    public final float B;

    @Nullable
    public final CharSequence l;

    @Nullable
    public final Layout.Alignment m;

    @Nullable
    public final Layout.Alignment n;

    @Nullable
    public final Bitmap o;
    public final float p;
    public final int q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public final float f838s;
    public final int t;
    public final float u;
    public final float v;
    public final boolean w;

    /* renamed from: x, reason: collision with root package name */
    public final int f839x;

    /* renamed from: y, reason: collision with root package name */
    public final int f840y;

    /* renamed from: z, reason: collision with root package name */
    public final float f841z;

    public Cue(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z2, int i5, int i6, float f6, a aVar) {
        if (charSequence == null) {
            Objects.requireNonNull(bitmap);
        } else {
            AnimatableValueParser.j(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.l = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.l = charSequence.toString();
        } else {
            this.l = null;
        }
        this.m = alignment;
        this.n = alignment2;
        this.o = bitmap;
        this.p = f;
        this.q = i;
        this.r = i2;
        this.f838s = f2;
        this.t = i3;
        this.u = f4;
        this.v = f5;
        this.w = z2;
        this.f839x = i5;
        this.f840y = i4;
        this.f841z = f3;
        this.A = i6;
        this.B = f6;
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public b a() {
        return new b(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || Cue.class != obj.getClass()) {
            return false;
        }
        Cue cue = (Cue) obj;
        return TextUtils.equals(this.l, cue.l) && this.m == cue.m && this.n == cue.n && ((bitmap = this.o) != null ? !((bitmap2 = cue.o) == null || !bitmap.sameAs(bitmap2)) : cue.o == null) && this.p == cue.p && this.q == cue.q && this.r == cue.r && this.f838s == cue.f838s && this.t == cue.t && this.u == cue.u && this.v == cue.v && this.w == cue.w && this.f839x == cue.f839x && this.f840y == cue.f840y && this.f841z == cue.f841z && this.A == cue.A && this.B == cue.B;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.l, this.m, this.n, this.o, Float.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r), Float.valueOf(this.f838s), Integer.valueOf(this.t), Float.valueOf(this.u), Float.valueOf(this.v), Boolean.valueOf(this.w), Integer.valueOf(this.f839x), Integer.valueOf(this.f840y), Float.valueOf(this.f841z), Integer.valueOf(this.A), Float.valueOf(this.B)});
    }

    /* compiled from: Cue.java */
    /* renamed from: b.i.a.c.b3.b$b */
    public static final class b {

        @Nullable
        public CharSequence a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public Bitmap f842b;

        @Nullable
        public Layout.Alignment c;

        @Nullable
        public Layout.Alignment d;
        public float e;
        public int f;
        public int g;
        public float h;
        public int i;
        public int j;
        public float k;
        public float l;
        public float m;
        public boolean n;

        @ColorInt
        public int o;
        public int p;
        public float q;

        public b() {
            this.a = null;
            this.f842b = null;
            this.c = null;
            this.d = null;
            this.e = -3.4028235E38f;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = -3.4028235E38f;
            this.i = Integer.MIN_VALUE;
            this.j = Integer.MIN_VALUE;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = -3.4028235E38f;
            this.n = false;
            this.o = ViewCompat.MEASURED_STATE_MASK;
            this.p = Integer.MIN_VALUE;
        }

        public Cue a() {
            return new Cue(this.a, this.c, this.d, this.f842b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, null);
        }

        public b(Cue cue, a aVar) {
            this.a = cue.l;
            this.f842b = cue.o;
            this.c = cue.m;
            this.d = cue.n;
            this.e = cue.p;
            this.f = cue.q;
            this.g = cue.r;
            this.h = cue.f838s;
            this.i = cue.t;
            this.j = cue.f840y;
            this.k = cue.f841z;
            this.l = cue.u;
            this.m = cue.v;
            this.n = cue.w;
            this.o = cue.f839x;
            this.p = cue.A;
            this.q = cue.B;
        }
    }
}
