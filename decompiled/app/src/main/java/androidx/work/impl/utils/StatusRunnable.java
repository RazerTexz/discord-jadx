package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import b.i.b.d.a.ListenableFuture8;
import java.util.List;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class StatusRunnable<T> implements Runnable {
    private final SettableFuture<T> mFuture = SettableFuture.create();

    /* renamed from: androidx.work.impl.utils.StatusRunnable$1, reason: invalid class name */
    public class AnonymousClass1 extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ List val$ids;
        public final /* synthetic */ WorkManagerImpl val$workManager;

        public AnonymousClass1(WorkManagerImpl workManagerImpl, List list) {
            this.val$workManager = workManagerImpl;
            this.val$ids = list;
        }

        @Override // androidx.work.impl.utils.StatusRunnable
        public /* bridge */ /* synthetic */ List<WorkInfo> runInternal() {
            return runInternal2();
        }

        @Override // androidx.work.impl.utils.StatusRunnable
        /* renamed from: runInternal, reason: avoid collision after fix types in other method */
        public List<WorkInfo> runInternal2() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.val$workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForIds(this.val$ids));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$2, reason: invalid class name */
    public class AnonymousClass2 extends StatusRunnable<WorkInfo> {
        public final /* synthetic */ UUID val$id;
        public final /* synthetic */ WorkManagerImpl val$workManager;

        public AnonymousClass2(WorkManagerImpl workManagerImpl, UUID uuid) {
            this.val$workManager = workManagerImpl;
            this.val$id = uuid;
        }

        @Override // androidx.work.impl.utils.StatusRunnable
        public /* bridge */ /* synthetic */ WorkInfo runInternal() {
            return runInternal();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.work.impl.utils.StatusRunnable
        public WorkInfo runInternal() {
            WorkSpec.WorkInfoPojo workStatusPojoForId = this.val$workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForId(this.val$id.toString());
            if (workStatusPojoForId != null) {
                return workStatusPojoForId.toWorkInfo();
            }
            return null;
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$3, reason: invalid class name */
    public class AnonymousClass3 extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ String val$tag;
        public final /* synthetic */ WorkManagerImpl val$workManager;

        public AnonymousClass3(WorkManagerImpl workManagerImpl, String str) {
            this.val$workManager = workManagerImpl;
            this.val$tag = str;
        }

        @Override // androidx.work.impl.utils.StatusRunnable
        public /* bridge */ /* synthetic */ List<WorkInfo> runInternal() {
            return runInternal2();
        }

        @Override // androidx.work.impl.utils.StatusRunnable
        /* renamed from: runInternal, reason: avoid collision after fix types in other method */
        public List<WorkInfo> runInternal2() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.val$workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForTag(this.val$tag));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$4, reason: invalid class name */
    public class AnonymousClass4 extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ String val$name;
        public final /* synthetic */ WorkManagerImpl val$workManager;

        public AnonymousClass4(WorkManagerImpl workManagerImpl, String str) {
            this.val$workManager = workManagerImpl;
            this.val$name = str;
        }

        @Override // androidx.work.impl.utils.StatusRunnable
        public /* bridge */ /* synthetic */ List<WorkInfo> runInternal() {
            return runInternal2();
        }

        @Override // androidx.work.impl.utils.StatusRunnable
        /* renamed from: runInternal, reason: avoid collision after fix types in other method */
        public List<WorkInfo> runInternal2() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.val$workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForName(this.val$name));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$5, reason: invalid class name */
    public class AnonymousClass5 extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ WorkQuery val$querySpec;
        public final /* synthetic */ WorkManagerImpl val$workManager;

        public AnonymousClass5(WorkManagerImpl workManagerImpl, WorkQuery workQuery) {
            this.val$workManager = workManagerImpl;
            this.val$querySpec = workQuery;
        }

        @Override // androidx.work.impl.utils.StatusRunnable
        public /* bridge */ /* synthetic */ List<WorkInfo> runInternal() {
            return runInternal2();
        }

        @Override // androidx.work.impl.utils.StatusRunnable
        /* renamed from: runInternal, reason: avoid collision after fix types in other method */
        public List<WorkInfo> runInternal2() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.val$workManager.getWorkDatabase().rawWorkInfoDao().getWorkInfoPojos(RawQueries.workQueryToRawQuery(this.val$querySpec)));
        }
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forStringIds(@NonNull WorkManagerImpl workManagerImpl, @NonNull List<String> list) {
        return new AnonymousClass1(workManagerImpl, list);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forTag(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        return new AnonymousClass3(workManagerImpl, str);
    }

    @NonNull
    public static StatusRunnable<WorkInfo> forUUID(@NonNull WorkManagerImpl workManagerImpl, @NonNull UUID uuid) {
        return new AnonymousClass2(workManagerImpl, uuid);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forUniqueWork(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        return new AnonymousClass4(workManagerImpl, str);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forWorkQuerySpec(@NonNull WorkManagerImpl workManagerImpl, @NonNull WorkQuery workQuery) {
        return new AnonymousClass5(workManagerImpl, workQuery);
    }

    @NonNull
    public ListenableFuture8<T> getFuture() {
        return this.mFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.mFuture.set(runInternal());
        } catch (Throwable th) {
            this.mFuture.setException(th);
        }
    }

    @WorkerThread
    public abstract T runInternal();
}
