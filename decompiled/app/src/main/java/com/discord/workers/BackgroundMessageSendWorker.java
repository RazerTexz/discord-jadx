package com.discord.workers;

import android.app.Application;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.m.BlockingObservable;
import kotlin.Metadata;

/* compiled from: BackgroundMessageSendWorker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/workers/BackgroundMessageSendWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class BackgroundMessageSendWorker extends Worker {

    /* compiled from: BackgroundMessageSendWorker.kt */
    public static final class a<T, R> implements Func1<Boolean, Boolean> {
        public static final a j = new a();

        @Override // j0.k.Func1
        public Boolean call(Boolean bool) {
            return Boolean.valueOf(Intrinsics3.areEqual(bool, Boolean.TRUE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMessageSendWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(workerParameters, "params");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Context applicationContext = getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            applicationContext = null;
        }
        Application application = (Application) applicationContext;
        if (application == null) {
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            Intrinsics3.checkNotNullExpressionValue(resultFailure, "Result.failure()");
            return resultFailure;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.initialize(application);
        new BlockingObservable(companion.getMessages().observeInitResendFinished().y(a.j).Z(1)).b();
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        Intrinsics3.checkNotNullExpressionValue(resultSuccess, "Result.success()");
        return resultSuccess;
    }
}
