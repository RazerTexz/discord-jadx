package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class CancelWorkRunnable implements Runnable {
    private final OperationImpl mOperation = new OperationImpl();

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$1, reason: invalid class name */
    public class AnonymousClass1 extends CancelWorkRunnable {
        public final /* synthetic */ UUID val$id;
        public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

        public AnonymousClass1(WorkManagerImpl workManagerImpl, UUID uuid) {
            this.val$workManagerImpl = workManagerImpl;
            this.val$id = uuid;
        }

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        @WorkerThread
        public void runInternal() {
            WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                cancel(this.val$workManagerImpl, this.val$id.toString());
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                reschedulePendingWorkers(this.val$workManagerImpl);
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$2, reason: invalid class name */
    public class AnonymousClass2 extends CancelWorkRunnable {
        public final /* synthetic */ String val$tag;
        public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

        public AnonymousClass2(WorkManagerImpl workManagerImpl, String str) {
            this.val$workManagerImpl = workManagerImpl;
            this.val$tag = str;
        }

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        @WorkerThread
        public void runInternal() {
            WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithTag(this.val$tag).iterator();
                while (it.hasNext()) {
                    cancel(this.val$workManagerImpl, it.next());
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                reschedulePendingWorkers(this.val$workManagerImpl);
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$3, reason: invalid class name */
    public class AnonymousClass3 extends CancelWorkRunnable {
        public final /* synthetic */ boolean val$allowReschedule;
        public final /* synthetic */ String val$name;
        public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

        public AnonymousClass3(WorkManagerImpl workManagerImpl, String str, boolean z2) {
            this.val$workManagerImpl = workManagerImpl;
            this.val$name = str;
            this.val$allowReschedule = z2;
        }

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        @WorkerThread
        public void runInternal() {
            WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithName(this.val$name).iterator();
                while (it.hasNext()) {
                    cancel(this.val$workManagerImpl, it.next());
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (this.val$allowReschedule) {
                    reschedulePendingWorkers(this.val$workManagerImpl);
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$4, reason: invalid class name */
    public class AnonymousClass4 extends CancelWorkRunnable {
        public final /* synthetic */ WorkManagerImpl val$workManagerImpl;

        public AnonymousClass4(WorkManagerImpl workManagerImpl) {
            this.val$workManagerImpl = workManagerImpl;
        }

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        @WorkerThread
        public void runInternal() {
            WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                Iterator<String> it = workDatabase.workSpecDao().getAllUnfinishedWork().iterator();
                while (it.hasNext()) {
                    cancel(this.val$workManagerImpl, it.next());
                }
                new PreferenceUtils(this.val$workManagerImpl.getWorkDatabase()).setLastCancelAllTimeMillis(System.currentTimeMillis());
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
    }

    public static CancelWorkRunnable forAll(@NonNull WorkManagerImpl workManagerImpl) {
        return new AnonymousClass4(workManagerImpl);
    }

    public static CancelWorkRunnable forId(@NonNull UUID uuid, @NonNull WorkManagerImpl workManagerImpl) {
        return new AnonymousClass1(workManagerImpl, uuid);
    }

    public static CancelWorkRunnable forName(@NonNull String str, @NonNull WorkManagerImpl workManagerImpl, boolean z2) {
        return new AnonymousClass3(workManagerImpl, str, z2);
    }

    public static CancelWorkRunnable forTag(@NonNull String str, @NonNull WorkManagerImpl workManagerImpl) {
        return new AnonymousClass2(workManagerImpl, str);
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String str) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State state = workSpecDao.getState(str2);
            if (state != WorkInfo.State.SUCCEEDED && state != WorkInfo.State.FAILED) {
                workSpecDao.setState(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(dependencyDao.getDependentWorkIds(str2));
        }
    }

    public void cancel(WorkManagerImpl workManagerImpl, String str) {
        iterativelyCancelWorkAndDependents(workManagerImpl.getWorkDatabase(), str);
        workManagerImpl.getProcessor().stopAndCancelWork(str);
        Iterator<Scheduler> it = workManagerImpl.getSchedulers().iterator();
        while (it.hasNext()) {
            it.next().cancel(str);
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    public void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            runInternal();
            this.mOperation.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.mOperation.setState(new Operation.State.FAILURE(th));
        }
    }

    public abstract void runInternal();
}
