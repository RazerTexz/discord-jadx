package s.a.c2;

import b.d.b.a.outline;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import s.a.a.Symbol3;

/* compiled from: ArrayChannel.kt */
/* renamed from: s.a.c2.d, reason: use source file name */
/* loaded from: classes3.dex */
public class ArrayChannel<E> extends AbstractChannel<E> {
    public final ReentrantLock m;
    public Object[] n;
    public int o;
    public final int p;
    public final BufferOverflow q;
    public volatile int size;

    public ArrayChannel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(function1);
        this.p = i;
        this.q = bufferOverflow;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(outline.r("ArrayChannel capacity must be at least 1, but ", i, " was specified").toString());
        }
        this.m = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        _ArraysJvm.fill$default(objArr, AbstractChannel2.a, 0, 0, 6, null);
        this.n = objArr;
        this.size = 0;
    }

    @Override // s.a.c2.AbstractChannel3
    public Object c(AbstractChannel7 abstractChannel7) {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            return super.c(abstractChannel7);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s.a.c2.AbstractChannel3
    public String d() {
        StringBuilder sbU = outline.U("(buffer:capacity=");
        sbU.append(this.p);
        sbU.append(",size=");
        return outline.A(sbU, this.size, ')');
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean h() {
        return false;
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean i() {
        return this.size == this.p && this.q == BufferOverflow.SUSPEND;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0038 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    @Override // s.a.c2.AbstractChannel3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object k(E e) {
        Symbol3 symbol3;
        AbstractChannel6<E> abstractChannel6N;
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            int i = this.size;
            AbstractChannel4<?> abstractChannel4E = e();
            if (abstractChannel4E != null) {
                return abstractChannel4E;
            }
            if (i >= this.p) {
                int iOrdinal = this.q.ordinal();
                if (iOrdinal == 0) {
                    symbol3 = AbstractChannel2.c;
                } else if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    symbol3 = AbstractChannel2.f3834b;
                }
                if (symbol3 == null) {
                    return symbol3;
                }
                if (i == 0) {
                    do {
                        abstractChannel6N = n();
                        if (abstractChannel6N != null) {
                            if (abstractChannel6N instanceof AbstractChannel4) {
                                this.size = i;
                                Intrinsics3.checkNotNull(abstractChannel6N);
                                return abstractChannel6N;
                            }
                            Intrinsics3.checkNotNull(abstractChannel6N);
                        }
                    } while (abstractChannel6N.d(e, null) == null);
                    this.size = i;
                    reentrantLock.unlock();
                    Intrinsics3.checkNotNull(abstractChannel6N);
                    abstractChannel6N.c(e);
                    Intrinsics3.checkNotNull(abstractChannel6N);
                    return abstractChannel6N.b();
                }
                w(i, e);
                return AbstractChannel2.f3834b;
            }
            this.size = i + 1;
            symbol3 = null;
            if (symbol3 == null) {
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s.a.c2.AbstractChannel
    public boolean r(AbstractChannel5<? super E> abstractChannel5) {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            return super.r(abstractChannel5);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s.a.c2.AbstractChannel
    public final boolean s() {
        return false;
    }

    @Override // s.a.c2.AbstractChannel
    public final boolean t() {
        return this.size == 0;
    }

    @Override // s.a.c2.AbstractChannel
    public void u(boolean z2) {
        Function1<E, Unit> function1 = this.l;
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            int i = this.size;
            OnUndeliveredElement onUndeliveredElementP = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.n[this.o];
                if (function1 != null && obj != AbstractChannel2.a) {
                    onUndeliveredElementP = b.i.a.f.e.o.f.p(function1, obj, onUndeliveredElementP);
                }
                Object[] objArr = this.n;
                int i3 = this.o;
                objArr[i3] = AbstractChannel2.a;
                this.o = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            reentrantLock.unlock();
            super.u(z2);
            if (onUndeliveredElementP != null) {
                throw onUndeliveredElementP;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // s.a.c2.AbstractChannel
    public Object v() {
        ReentrantLock reentrantLock = this.m;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object objE = e();
                if (objE == null) {
                    objE = AbstractChannel2.d;
                }
                return objE;
            }
            Object[] objArr = this.n;
            int i2 = this.o;
            Object obj = objArr[i2];
            AbstractChannel7 abstractChannel7 = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object objR = AbstractChannel2.d;
            boolean z2 = false;
            if (i == this.p) {
                AbstractChannel7 abstractChannel72 = null;
                while (true) {
                    AbstractChannel7 abstractChannel7Q = q();
                    if (abstractChannel7Q == null) {
                        abstractChannel7 = abstractChannel72;
                        break;
                    }
                    Intrinsics3.checkNotNull(abstractChannel7Q);
                    if (abstractChannel7Q.t(null) != null) {
                        Intrinsics3.checkNotNull(abstractChannel7Q);
                        objR = abstractChannel7Q.r();
                        abstractChannel7 = abstractChannel7Q;
                        z2 = true;
                        break;
                    }
                    Intrinsics3.checkNotNull(abstractChannel7Q);
                    abstractChannel7Q.u();
                    abstractChannel72 = abstractChannel7Q;
                }
            }
            if (objR != AbstractChannel2.d && !(objR instanceof AbstractChannel4)) {
                this.size = i;
                Object[] objArr2 = this.n;
                objArr2[(this.o + i) % objArr2.length] = objR;
            }
            this.o = (this.o + 1) % this.n.length;
            if (z2) {
                Intrinsics3.checkNotNull(abstractChannel7);
                abstractChannel7.q();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void w(int i, E e) {
        int i2 = this.p;
        if (i >= i2) {
            Object[] objArr = this.n;
            int i3 = this.o;
            objArr[i3 % objArr.length] = null;
            objArr[(i + i3) % objArr.length] = e;
            this.o = (i3 + 1) % objArr.length;
            return;
        }
        Object[] objArr2 = this.n;
        if (i >= objArr2.length) {
            int iMin = Math.min(objArr2.length * 2, i2);
            Object[] objArr3 = new Object[iMin];
            for (int i4 = 0; i4 < i; i4++) {
                Object[] objArr4 = this.n;
                objArr3[i4] = objArr4[(this.o + i4) % objArr4.length];
            }
            _ArraysJvm.fill((Symbol3[]) objArr3, AbstractChannel2.a, i, iMin);
            this.n = objArr3;
            this.o = 0;
        }
        Object[] objArr5 = this.n;
        objArr5[(this.o + i) % objArr5.length] = e;
    }
}
