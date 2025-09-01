package com.discord.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.app.AppLog;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import j0.m.BlockingObservable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: CallActionWorker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/workers/CallActionWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CallActionWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallActionWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(workerParameters, "params");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        long j;
        long j2;
        AppLog appLog = AppLog.g;
        String simpleName = CallActionWorker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        StringBuilder sb = new StringBuilder();
        sb.append("Starting for [");
        Data inputData = getInputData();
        Intrinsics3.checkNotNullExpressionValue(inputData, "inputData");
        sb.append(inputData.getKeyValueMap());
        sb.append(']');
        Logger.i$default(appLog, simpleName, sb.toString(), null, 4, null);
        if (!NotificationClient.INSTANCE.isAuthed()) {
            String simpleName2 = CallActionWorker.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
            Logger.d$default(appLog, simpleName2, "Not authenticated. Aborting job request.", null, 4, null);
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            Intrinsics3.checkNotNullExpressionValue(resultFailure, "Result.failure()");
            return resultFailure;
        }
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        if (!NetworkUtils.isDeviceConnected$default(networkUtils, applicationContext, null, null, 6, null)) {
            ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
            Intrinsics3.checkNotNullExpressionValue(resultRetry, "Result.retry()");
            return resultRetry;
        }
        long j3 = getInputData().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        long j4 = getInputData().getLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", -1L);
        try {
            Observable<Void> observableStopRinging = RestAPI.INSTANCE.getApi().stopRinging(j3, j4, (List<Long>) null);
            Objects.requireNonNull(observableStopRinging);
            new BlockingObservable(observableStopRinging).b();
            String simpleName3 = getClass().getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
            j = j4;
            j2 = j3;
            try {
                Logger.d$default(appLog, simpleName3, "Call declined: " + j3 + '-' + j4, null, 4, null);
                ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
                Intrinsics3.checkNotNullExpressionValue(resultSuccess, "Result.success()");
                return resultSuccess;
            } catch (Throwable th) {
                th = th;
                AppLog appLog2 = AppLog.g;
                String simpleName4 = CallActionWorker.class.getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName4, "javaClass.simpleName");
                appLog2.w(simpleName4, "Call declined failure: " + j2 + '-' + j, th);
                ListenableWorker.Result resultRetry2 = getRunAttemptCount() < 3 ? ListenableWorker.Result.retry() : ListenableWorker.Result.failure();
                Intrinsics3.checkNotNullExpressionValue(resultRetry2, "if (runAttemptCount < MA…y() else Result.failure()");
                return resultRetry2;
            }
        } catch (Throwable th2) {
            th = th2;
            j = j4;
            j2 = j3;
        }
    }
}
