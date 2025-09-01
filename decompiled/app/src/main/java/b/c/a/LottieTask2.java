package b.c.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* renamed from: b.c.a.r, reason: use source file name */
/* loaded from: classes.dex */
public class LottieTask2<T> {
    public static Executor a = Executors.newCachedThreadPool();

    /* renamed from: b, reason: collision with root package name */
    public final Set<LottieListener<T>> f374b = new LinkedHashSet(1);
    public final Set<LottieListener<Throwable>> c = new LinkedHashSet(1);
    public final Handler d = new Handler(Looper.getMainLooper());

    @Nullable
    public volatile LottieResult<T> e = null;

    /* compiled from: LottieTask.java */
    /* renamed from: b.c.a.r$a */
    public class a extends FutureTask<LottieResult<T>> {
        public a(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                LottieTask2.this.c(get());
            } catch (InterruptedException | ExecutionException e) {
                LottieTask2.this.c(new LottieResult<>(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask2(Callable<LottieResult<T>> callable) {
        a.execute(new a(callable));
    }

    public synchronized LottieTask2<T> a(LottieListener<Throwable> lottieListener) {
        if (this.e != null && this.e.f373b != null) {
            lottieListener.a(this.e.f373b);
        }
        this.c.add(lottieListener);
        return this;
    }

    public synchronized LottieTask2<T> b(LottieListener<T> lottieListener) {
        if (this.e != null && this.e.a != null) {
            lottieListener.a(this.e.a);
        }
        this.f374b.add(lottieListener);
        return this;
    }

    public final void c(@Nullable LottieResult<T> lottieResult) {
        if (this.e != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.e = lottieResult;
        this.d.post(new LottieTask(this));
    }
}
