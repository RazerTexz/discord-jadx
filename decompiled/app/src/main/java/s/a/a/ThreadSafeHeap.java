package s.a.a;

import d0.z.d.Intrinsics3;
import java.lang.Comparable;
import java.util.Arrays;
import s.a.a.ThreadSafeHeap2;
import s.a.r0;

/* compiled from: ThreadSafeHeap.kt */
/* renamed from: s.a.a.v, reason: use source file name */
/* loaded from: classes3.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeap2 & Comparable<? super T>> {
    public volatile int _size = 0;
    public T[] a;

    public final void a(T t) {
        r0.c cVar = (r0.c) t;
        cVar.g(this);
        T[] tArr = this.a;
        if (tArr == null) {
            tArr = (T[]) new ThreadSafeHeap2[4];
            this.a = tArr;
        } else if (this._size >= tArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(tArr, this._size * 2);
            Intrinsics3.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr = (T[]) ((ThreadSafeHeap2[]) objArrCopyOf);
            this.a = tArr;
        }
        int i = this._size;
        this._size = i + 1;
        tArr[i] = t;
        cVar.k = i;
        d(i);
    }

    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T c(int i) {
        T[] tArr = this.a;
        Intrinsics3.checkNotNull(tArr);
        this._size--;
        if (i < this._size) {
            e(i, this._size);
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                Intrinsics3.checkNotNull(t);
                T t2 = tArr[i2];
                Intrinsics3.checkNotNull(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    e(i, i2);
                    d(i2);
                } else {
                    while (true) {
                        int i3 = (i * 2) + 1;
                        if (i3 >= this._size) {
                            break;
                        }
                        T[] tArr2 = this.a;
                        Intrinsics3.checkNotNull(tArr2);
                        int i4 = i3 + 1;
                        if (i4 < this._size) {
                            T t3 = tArr2[i4];
                            Intrinsics3.checkNotNull(t3);
                            T t4 = tArr2[i3];
                            Intrinsics3.checkNotNull(t4);
                            if (((Comparable) t3).compareTo(t4) < 0) {
                                i3 = i4;
                            }
                        }
                        T t5 = tArr2[i];
                        Intrinsics3.checkNotNull(t5);
                        T t6 = tArr2[i3];
                        Intrinsics3.checkNotNull(t6);
                        if (((Comparable) t5).compareTo(t6) <= 0) {
                            break;
                        }
                        e(i, i3);
                        i = i3;
                    }
                }
            }
        }
        T t7 = tArr[this._size];
        Intrinsics3.checkNotNull(t7);
        t7.g(null);
        t7.f(-1);
        tArr[this._size] = null;
        return t7;
    }

    public final void d(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            Intrinsics3.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics3.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics3.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            e(i, i2);
            i = i2;
        }
    }

    public final void e(int i, int i2) {
        T[] tArr = this.a;
        Intrinsics3.checkNotNull(tArr);
        T t = tArr[i2];
        Intrinsics3.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics3.checkNotNull(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.f(i);
        t2.f(i2);
    }
}
