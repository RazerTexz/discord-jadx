package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class ConstraintTracker<T> {
    private static final String TAG = Logger.tagWithPrefix("ConstraintTracker");
    public final Context mAppContext;
    public T mCurrentState;
    public final TaskExecutor mTaskExecutor;
    private final Object mLock = new Object();
    private final Set<ConstraintListener<T>> mListeners = new LinkedHashSet();

    /* renamed from: androidx.work.impl.constraints.trackers.ConstraintTracker$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ List val$listenersList;

        public AnonymousClass1(List list) {
            this.val$listenersList = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.val$listenersList.iterator();
            while (it.hasNext()) {
                ((ConstraintListener) it.next()).onConstraintChanged(ConstraintTracker.this.mCurrentState);
            }
        }
    }

    public ConstraintTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }

    public void addListener(ConstraintListener<T> constraintListener) {
        synchronized (this.mLock) {
            if (this.mListeners.add(constraintListener)) {
                if (this.mListeners.size() == 1) {
                    this.mCurrentState = getInitialState();
                    Logger.get().debug(TAG, String.format("%s: initial state = %s", getClass().getSimpleName(), this.mCurrentState), new Throwable[0]);
                    startTracking();
                }
                constraintListener.onConstraintChanged(this.mCurrentState);
            }
        }
    }

    public abstract T getInitialState();

    public void removeListener(ConstraintListener<T> constraintListener) {
        synchronized (this.mLock) {
            if (this.mListeners.remove(constraintListener) && this.mListeners.isEmpty()) {
                stopTracking();
            }
        }
    }

    public void setState(T t) {
        synchronized (this.mLock) {
            T t2 = this.mCurrentState;
            if (t2 != t && (t2 == null || !t2.equals(t))) {
                this.mCurrentState = t;
                this.mTaskExecutor.getMainThreadExecutor().execute(new AnonymousClass1(new ArrayList(this.mListeners)));
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
