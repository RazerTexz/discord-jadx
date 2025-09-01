package b.i.b.b;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ComparisonChain.java */
/* renamed from: b.i.b.b.j, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ComparisonChain {
    public static final ComparisonChain a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ComparisonChain f1646b = new b(-1);
    public static final ComparisonChain c = new b(1);

    /* compiled from: ComparisonChain.java */
    /* renamed from: b.i.b.b.j$a */
    public static class a extends ComparisonChain {
        public a() {
            super(null);
        }

        @Override // b.i.b.b.ComparisonChain
        public ComparisonChain a(int i, int i2) {
            return f(i < i2 ? -1 : i > i2 ? 1 : 0);
        }

        @Override // b.i.b.b.ComparisonChain
        public <T> ComparisonChain b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator) {
            return f(comparator.compare(t, t2));
        }

        @Override // b.i.b.b.ComparisonChain
        public ComparisonChain c(boolean z2, boolean z3) {
            return f(z2 == z3 ? 0 : z2 ? 1 : -1);
        }

        @Override // b.i.b.b.ComparisonChain
        public ComparisonChain d(boolean z2, boolean z3) {
            return f(z3 == z2 ? 0 : z3 ? 1 : -1);
        }

        @Override // b.i.b.b.ComparisonChain
        public int e() {
            return 0;
        }

        public ComparisonChain f(int i) {
            return i < 0 ? ComparisonChain.f1646b : i > 0 ? ComparisonChain.c : ComparisonChain.a;
        }
    }

    /* compiled from: ComparisonChain.java */
    /* renamed from: b.i.b.b.j$b */
    public static final class b extends ComparisonChain {
        public final int d;

        public b(int i) {
            super(null);
            this.d = i;
        }

        @Override // b.i.b.b.ComparisonChain
        public ComparisonChain a(int i, int i2) {
            return this;
        }

        @Override // b.i.b.b.ComparisonChain
        public <T> ComparisonChain b(@NullableDecl T t, @NullableDecl T t2, @NullableDecl Comparator<T> comparator) {
            return this;
        }

        @Override // b.i.b.b.ComparisonChain
        public ComparisonChain c(boolean z2, boolean z3) {
            return this;
        }

        @Override // b.i.b.b.ComparisonChain
        public ComparisonChain d(boolean z2, boolean z3) {
            return this;
        }

        @Override // b.i.b.b.ComparisonChain
        public int e() {
            return this.d;
        }
    }

    public ComparisonChain(a aVar) {
    }

    public abstract ComparisonChain a(int i, int i2);

    public abstract <T> ComparisonChain b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator);

    public abstract ComparisonChain c(boolean z2, boolean z3);

    public abstract ComparisonChain d(boolean z2, boolean z3);

    public abstract int e();
}
