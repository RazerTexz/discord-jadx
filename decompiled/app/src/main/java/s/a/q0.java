package s.a;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import d0.t._ArraysJvm;
import java.util.Objects;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.ArrayQueue;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class q0 extends CoroutineDispatcher {
    public static final /* synthetic */ int j = 0;
    public long k;
    public boolean l;
    public ArrayQueue<DispatchedTask<?>> m;

    public final void H(boolean z2) {
        long jI = this.k - I(z2);
        this.k = jI;
        if (jI <= 0 && this.l) {
            shutdown();
        }
    }

    public final long I(boolean z2) {
        if (z2) {
            return Permission.REQUEST_TO_SPEAK;
        }
        return 1L;
    }

    public final void J(DispatchedTask<?> dispatchedTask) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.m;
        if (arrayQueue == null) {
            arrayQueue = new ArrayQueue<>();
            this.m = arrayQueue;
        }
        Object[] objArr = arrayQueue.a;
        int i = arrayQueue.c;
        objArr[i] = dispatchedTask;
        int length = (objArr.length - 1) & (i + 1);
        arrayQueue.c = length;
        int i2 = arrayQueue.f3826b;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            _ArraysJvm.copyInto$default(objArr, objArr2, 0, i2, 0, 10, (Object) null);
            Object[] objArr3 = arrayQueue.a;
            int length3 = objArr3.length;
            int i3 = arrayQueue.f3826b;
            _ArraysJvm.copyInto$default(objArr3, objArr2, length3 - i3, 0, i3, 4, (Object) null);
            arrayQueue.a = objArr2;
            arrayQueue.f3826b = 0;
            arrayQueue.c = length2;
        }
    }

    public final void L(boolean z2) {
        this.k = I(z2) + this.k;
        if (z2) {
            return;
        }
        this.l = true;
    }

    public final boolean N() {
        return this.k >= I(true);
    }

    public long O() {
        if (R()) {
            return 0L;
        }
        return RecyclerView.FOREVER_NS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    public final boolean R() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.m;
        if (arrayQueue != null) {
            int i = arrayQueue.f3826b;
            DispatchedTask dispatchedTask = null;
            if (i != arrayQueue.c) {
                ?? r3 = arrayQueue.a;
                ?? r6 = r3[i];
                r3[i] = 0;
                arrayQueue.f3826b = (i + 1) & (r3.length - 1);
                Objects.requireNonNull(r6, "null cannot be cast to non-null type T");
                dispatchedTask = r6;
            }
            DispatchedTask dispatchedTask2 = dispatchedTask;
            if (dispatchedTask2 != null) {
                dispatchedTask2.run();
                return true;
            }
        }
        return false;
    }

    public void shutdown() {
    }
}
