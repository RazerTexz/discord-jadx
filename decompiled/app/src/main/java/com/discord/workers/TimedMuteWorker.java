package com.discord.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import j0.m.BlockingObservable;
import java.util.Objects;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: TimedMuteWorker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/discord/workers/TimedMuteWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "Lcom/discord/utilities/time/Clock;", "a", "Lcom/discord/utilities/time/Clock;", "getClock", "()Lcom/discord/utilities/time/Clock;", "setClock", "(Lcom/discord/utilities/time/Clock;)V", "clock", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TimedMuteWorker extends Worker {

    /* renamed from: a, reason: from kotlin metadata */
    public Clock clock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimedMuteWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(workerParameters, "params");
        this.clock = ClockFactory.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ae  */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ListenableWorker.Result doWork() {
        String str;
        long j;
        long j2;
        AppLog appLog = AppLog.g;
        String simpleName = TimedMuteWorker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        StringBuilder sb = new StringBuilder();
        sb.append("Starting for [");
        Data inputData = getInputData();
        Intrinsics3.checkNotNullExpressionValue(inputData, "inputData");
        sb.append(inputData.getKeyValueMap());
        sb.append(']');
        Logger.i$default(appLog, simpleName, sb.toString(), null, 4, null);
        NotificationClient notificationClient = NotificationClient.INSTANCE;
        if (!notificationClient.isAuthed()) {
            String simpleName2 = TimedMuteWorker.class.getSimpleName();
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
        long j3 = getInputData().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j4 = getInputData().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        long j5 = getInputData().getLong("com.discord.intent.extra.EXTRA_UNTIL_TIMESTAMP_MS", 0L);
        if (j3 == -1 || j4 == -1) {
            ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
            Intrinsics3.checkNotNullExpressionValue(resultFailure2, "Result.failure()");
            return resultFailure2;
        }
        if (this.clock.currentTimeMillis() > j5) {
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            Intrinsics3.checkNotNullExpressionValue(resultSuccess, "Result.success()");
            return resultSuccess;
        }
        String uTCDateTime$default = TimeUtils.toUTCDateTime$default(Long.valueOf(j5), null, 2, null);
        try {
            Observable<ModelNotificationSettings> observableUpdateUserGuildSettings = RestAPI.INSTANCE.getApi().updateUserGuildSettings(j3, new RestAPIParams.UserGuildSettings(j4, new RestAPIParams.UserGuildSettings.ChannelOverride(Boolean.TRUE, new ModelMuteConfig(uTCDateTime$default), null, null, 12, null)));
            Objects.requireNonNull(observableUpdateUserGuildSettings);
            ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) new BlockingObservable(observableUpdateUserGuildSettings).b();
            String simpleName3 = getClass().getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
            str = uTCDateTime$default;
            try {
                Logger.d$default(appLog, simpleName3, "Muted: " + j3 + '-' + j4 + " until " + uTCDateTime$default, null, 4, null);
                j = j4;
                j2 = j3;
                try {
                    NotificationClient.clear$default(notificationClient, j, getApplicationContext(), false, 4, null);
                    StoreAnalytics analytics = StoreStream.INSTANCE.getAnalytics();
                    Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "notifSettings");
                    analytics.onNotificationSettingsUpdated(modelNotificationSettings, Long.valueOf(j));
                    ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
                    Intrinsics3.checkNotNullExpressionValue(resultSuccess2, "Result.success()");
                    return resultSuccess2;
                } catch (Throwable th) {
                    th = th;
                    AppLog appLog2 = AppLog.g;
                    String simpleName4 = TimedMuteWorker.class.getSimpleName();
                    Intrinsics3.checkNotNullExpressionValue(simpleName4, "javaClass.simpleName");
                    appLog2.w(simpleName4, "Mute failure: " + j2 + '-' + j + " until " + str, th);
                    ListenableWorker.Result resultRetry2 = getRunAttemptCount() >= 3 ? ListenableWorker.Result.retry() : ListenableWorker.Result.failure();
                    Intrinsics3.checkNotNullExpressionValue(resultRetry2, "if (runAttemptCount < MA…y() else Result.failure()");
                    return resultRetry2;
                }
            } catch (Throwable th2) {
                th = th2;
                j = j4;
                j2 = j3;
                AppLog appLog22 = AppLog.g;
                String simpleName42 = TimedMuteWorker.class.getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName42, "javaClass.simpleName");
                appLog22.w(simpleName42, "Mute failure: " + j2 + '-' + j + " until " + str, th);
                if (getRunAttemptCount() >= 3) {
                }
                Intrinsics3.checkNotNullExpressionValue(resultRetry2, "if (runAttemptCount < MA…y() else Result.failure()");
                return resultRetry2;
            }
        } catch (Throwable th3) {
            th = th3;
            str = uTCDateTime$default;
        }
    }
}
