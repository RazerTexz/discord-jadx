package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
/* loaded from: classes.dex */
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private final int mDestructAfterMillisec;

    @GuardedBy("mLock")
    private Handler mHandler;
    private final int mPriority;

    @GuardedBy("mLock")
    private HandlerThread mThread;
    private final String mThreadName;
    private final Object mLock = new Object();
    private Handler.Callback mCallback = new AnonymousClass1();

    @GuardedBy("mLock")
    private int mGeneration = 0;

    /* renamed from: androidx.core.provider.SelfDestructiveThread$1, reason: invalid class name */
    public class AnonymousClass1 implements Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SelfDestructiveThread.this.onDestruction();
                return true;
            }
            if (i != 1) {
                return true;
            }
            SelfDestructiveThread.this.onInvokeRunnable((Runnable) message.obj);
            return true;
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Callable val$callable;
        public final /* synthetic */ Handler val$calleeHandler;
        public final /* synthetic */ ReplyCallback val$reply;

        /* renamed from: androidx.core.provider.SelfDestructiveThread$2$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ Object val$result;

            public AnonymousClass1(Object obj) {
                this.val$result = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2.this.val$reply.onReply(this.val$result);
            }
        }

        public AnonymousClass2(Callable callable, Handler handler, ReplyCallback replyCallback) {
            this.val$callable = callable;
            this.val$calleeHandler = handler;
            this.val$reply = replyCallback;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            Object objCall;
            try {
                objCall = this.val$callable.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.val$calleeHandler.post(new AnonymousClass1(objCall));
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public final /* synthetic */ Callable val$callable;
        public final /* synthetic */ Condition val$cond;
        public final /* synthetic */ AtomicReference val$holder;
        public final /* synthetic */ ReentrantLock val$lock;
        public final /* synthetic */ AtomicBoolean val$running;

        public AnonymousClass3(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.val$holder = atomicReference;
            this.val$callable = callable;
            this.val$lock = reentrantLock;
            this.val$running = atomicBoolean;
            this.val$cond = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$holder.set(this.val$callable.call());
            } catch (Exception unused) {
            }
            this.val$lock.lock();
            try {
                this.val$running.set(false);
                this.val$cond.signal();
            } finally {
                this.val$lock.unlock();
            }
        }
    }

    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        this.mThreadName = str;
        this.mPriority = i;
        this.mDestructAfterMillisec = i2;
    }

    private void post(Runnable runnable) {
        synchronized (this.mLock) {
            if (this.mThread == null) {
                HandlerThread handlerThread = new HandlerThread(this.mThreadName, this.mPriority);
                this.mThread = handlerThread;
                handlerThread.start();
                this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
                this.mGeneration++;
            }
            this.mHandler.removeMessages(0);
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    @VisibleForTesting
    public int getGeneration() {
        int i;
        synchronized (this.mLock) {
            i = this.mGeneration;
        }
        return i;
    }

    @VisibleForTesting
    public boolean isRunning() {
        boolean z2;
        synchronized (this.mLock) {
            z2 = this.mThread != null;
        }
        return z2;
    }

    public void onDestruction() {
        synchronized (this.mLock) {
            if (this.mHandler.hasMessages(1)) {
                return;
            }
            this.mThread.quit();
            this.mThread = null;
            this.mHandler = null;
        }
    }

    public void onInvokeRunnable(Runnable runnable) {
        runnable.run();
        synchronized (this.mLock) {
            this.mHandler.removeMessages(0);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.mDestructAfterMillisec);
        }
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        post(new AnonymousClass2(callable, CalleeHandler.create(), replyCallback));
    }

    public <T> T postAndWait(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionNewCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        post(new AnonymousClass3(atomicReference, callable, reentrantLock, atomicBoolean, conditionNewCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
