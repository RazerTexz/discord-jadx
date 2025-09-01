package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationClient {
    public final Context mAppContext;
    public int mClientId;
    public final Executor mExecutor;
    public final InvalidationTracker mInvalidationTracker;
    public final String mName;
    public final InvalidationTracker.Observer mObserver;
    public final Runnable mRemoveObserverRunnable;

    @Nullable
    public IMultiInstanceInvalidationService mService;
    public final ServiceConnection mServiceConnection;
    public final Runnable mSetUpRunnable;
    private final Runnable mTearDownRunnable;
    public final IMultiInstanceInvalidationCallback mCallback = new AnonymousClass1();
    public final AtomicBoolean mStopped = new AtomicBoolean(false);

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$1, reason: invalid class name */
    public class AnonymousClass1 extends IMultiInstanceInvalidationCallback.Stub {

        /* renamed from: androidx.room.MultiInstanceInvalidationClient$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00061 implements Runnable {
            public final /* synthetic */ String[] val$tables;

            public RunnableC00061(String[] strArr) {
                this.val$tables = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                MultiInstanceInvalidationClient.this.mInvalidationTracker.notifyObserversByTableNames(this.val$tables);
            }
        }

        public AnonymousClass1() {
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(String[] strArr) {
            MultiInstanceInvalidationClient.this.mExecutor.execute(new RunnableC00061(strArr));
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$2, reason: invalid class name */
    public class AnonymousClass2 implements ServiceConnection {
        public AnonymousClass2() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MultiInstanceInvalidationClient.this.mService = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mSetUpRunnable);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mExecutor.execute(multiInstanceInvalidationClient.mRemoveObserverRunnable);
            MultiInstanceInvalidationClient.this.mService = null;
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
                if (iMultiInstanceInvalidationService != null) {
                    multiInstanceInvalidationClient.mClientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.mCallback, multiInstanceInvalidationClient.mName);
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                    multiInstanceInvalidationClient2.mInvalidationTracker.addObserver(multiInstanceInvalidationClient2.mObserver);
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e);
            }
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mInvalidationTracker.removeObserver(multiInstanceInvalidationClient.mObserver);
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$5, reason: invalid class name */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.mInvalidationTracker.removeObserver(multiInstanceInvalidationClient.mObserver);
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient2.mService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(multiInstanceInvalidationClient2.mCallback, multiInstanceInvalidationClient2.mClientId);
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e);
            }
            MultiInstanceInvalidationClient multiInstanceInvalidationClient3 = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient3.mAppContext.unbindService(multiInstanceInvalidationClient3.mServiceConnection);
        }
    }

    /* renamed from: androidx.room.MultiInstanceInvalidationClient$6, reason: invalid class name */
    public class AnonymousClass6 extends InvalidationTracker.Observer {
        public AnonymousClass6(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public boolean isRemote() {
            return true;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            if (MultiInstanceInvalidationClient.this.mStopped.get()) {
                return;
            }
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.broadcastInvalidation(multiInstanceInvalidationClient.mClientId, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e) {
                Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e);
            }
        }
    }

    public MultiInstanceInvalidationClient(Context context, String str, InvalidationTracker invalidationTracker, Executor executor) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.mServiceConnection = anonymousClass2;
        this.mSetUpRunnable = new AnonymousClass3();
        this.mRemoveObserverRunnable = new AnonymousClass4();
        this.mTearDownRunnable = new AnonymousClass5();
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mName = str;
        this.mInvalidationTracker = invalidationTracker;
        this.mExecutor = executor;
        this.mObserver = new AnonymousClass6((String[]) invalidationTracker.mTableIdLookup.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, (Class<?>) MultiInstanceInvalidationService.class), anonymousClass2, 1);
    }

    public void stop() {
        if (this.mStopped.compareAndSet(false, true)) {
            this.mExecutor.execute(this.mTearDownRunnable);
        }
    }
}
