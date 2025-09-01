package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import b.i.b.d.a.ListenableFuture8;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class WorkProgressUpdater implements ProgressUpdater {
    public static final String TAG = Logger.tagWithPrefix("WorkProgressUpdater");
    public final TaskExecutor mTaskExecutor;
    public final WorkDatabase mWorkDatabase;

    /* renamed from: androidx.work.impl.utils.WorkProgressUpdater$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Data val$data;
        public final /* synthetic */ SettableFuture val$future;
        public final /* synthetic */ UUID val$id;

        public AnonymousClass1(UUID uuid, Data data, SettableFuture settableFuture) {
            this.val$id = uuid;
            this.val$data = data;
            this.val$future = settableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            WorkSpec workSpec;
            String string = this.val$id.toString();
            Logger logger = Logger.get();
            String str = WorkProgressUpdater.TAG;
            logger.debug(str, String.format("Updating progress for %s (%s)", this.val$id, this.val$data), new Throwable[0]);
            WorkProgressUpdater.this.mWorkDatabase.beginTransaction();
            try {
                workSpec = WorkProgressUpdater.this.mWorkDatabase.workSpecDao().getWorkSpec(string);
            } finally {
                try {
                } finally {
                }
            }
            if (workSpec == null) {
                throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            }
            if (workSpec.state == WorkInfo.State.RUNNING) {
                WorkProgressUpdater.this.mWorkDatabase.workProgressDao().insert(new WorkProgress(string, this.val$data));
            } else {
                Logger.get().warning(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", string), new Throwable[0]);
            }
            this.val$future.set(null);
            WorkProgressUpdater.this.mWorkDatabase.setTransactionSuccessful();
        }
    }

    public WorkProgressUpdater(@NonNull WorkDatabase workDatabase, @NonNull TaskExecutor taskExecutor) {
        this.mWorkDatabase = workDatabase;
        this.mTaskExecutor = taskExecutor;
    }

    @Override // androidx.work.ProgressUpdater
    @NonNull
    public ListenableFuture8<Void> updateProgress(@NonNull Context context, @NonNull UUID uuid, @NonNull Data data) {
        SettableFuture settableFutureCreate = SettableFuture.create();
        this.mTaskExecutor.executeOnBackgroundThread(new AnonymousClass1(uuid, data, settableFutureCreate));
        return settableFutureCreate;
    }
}
