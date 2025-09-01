package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import b.i.b.d.a.ListenableFuture8;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class WorkForegroundUpdater implements ForegroundUpdater {
    public final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;
    public final WorkSpecDao mWorkSpecDao;

    /* renamed from: androidx.work.impl.utils.WorkForegroundUpdater$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ ForegroundInfo val$foregroundInfo;
        public final /* synthetic */ SettableFuture val$future;
        public final /* synthetic */ UUID val$id;

        public AnonymousClass1(SettableFuture settableFuture, UUID uuid, ForegroundInfo foregroundInfo, Context context) {
            this.val$future = settableFuture;
            this.val$id = uuid;
            this.val$foregroundInfo = foregroundInfo;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.val$future.isCancelled()) {
                    String string = this.val$id.toString();
                    WorkInfo.State state = WorkForegroundUpdater.this.mWorkSpecDao.getState(string);
                    if (state == null || state.isFinished()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    WorkForegroundUpdater.this.mForegroundProcessor.startForeground(string, this.val$foregroundInfo);
                    this.val$context.startService(SystemForegroundDispatcher.createNotifyIntent(this.val$context, string, this.val$foregroundInfo));
                }
                this.val$future.set(null);
            } catch (Throwable th) {
                this.val$future.setException(th);
            }
        }
    }

    public WorkForegroundUpdater(@NonNull WorkDatabase workDatabase, @NonNull ForegroundProcessor foregroundProcessor, @NonNull TaskExecutor taskExecutor) {
        this.mForegroundProcessor = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }

    @Override // androidx.work.ForegroundUpdater
    @NonNull
    public ListenableFuture8<Void> setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo) {
        SettableFuture settableFutureCreate = SettableFuture.create();
        this.mTaskExecutor.executeOnBackgroundThread(new AnonymousClass1(settableFutureCreate, uuid, foregroundInfo, context));
        return settableFutureCreate;
    }
}
