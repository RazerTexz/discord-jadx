package com.discord.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.api.message.Message;
import com.discord.app.AppLog;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.fcm.NotificationCache;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.fcm.NotificationRenderer;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.m.BlockingObservable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: MessageSendWorker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/discord/workers/MessageSendWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class MessageSendWorker extends Worker {

    /* compiled from: MessageSendWorker.kt */
    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $channelName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, String str) {
            super(1);
            this.$channelId = j;
            this.$channelName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int iIntValue = num.intValue();
            NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
            Context applicationContext = MessageSendWorker.this.getApplicationContext();
            Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
            notificationRenderer.displaySent(applicationContext, this.$channelId, this.$channelName, false, iIntValue);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(workerParameters, "params");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v6, types: [rx.Observable] */
    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        boolean zRestSubscribeOn;
        AppLog appLog = AppLog.g;
        String simpleName = MessageSendWorker.class.getSimpleName();
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
            String simpleName2 = MessageSendWorker.class.getSimpleName();
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
            if (getRunAttemptCount() < 3) {
                ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
                Intrinsics3.checkNotNullExpressionValue(resultRetry, "Result.retry()");
                return resultRetry;
            }
            ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
            Intrinsics3.checkNotNullExpressionValue(resultFailure2, "Result.failure()");
            return resultFailure2;
        }
        long j = getInputData().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        String string = getInputData().getString("com.discord.intent.extra.EXTRA_CHANNEL_NAME");
        if (string == null) {
            string = "";
        }
        String str = string;
        String string2 = getInputData().getString("MESSAGE_CONTENT");
        if (string2 == null) {
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            Intrinsics3.checkNotNullExpressionValue(resultSuccess, "Result.success()");
            return resultSuccess;
        }
        String string3 = getInputData().getString("com.discord.intent.extra.EXTRA_MESSAGE_ID");
        long j2 = getInputData().getLong("com.discord.intent.extra.EXTRA_STICKER_ID", -1L);
        try {
            zRestSubscribeOn = ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().sendMessage(j, new RestAPIParams.Message(string2, string3, null, null, j2 != -1 ? CollectionsJVM.listOf(Long.valueOf(j2)) : null, null, null, null, null, 492, null)), false);
            Observable observableTakeSingleUntilTimeout$default = ObservableExtensionsKt.takeSingleUntilTimeout$default(zRestSubscribeOn, 0L, false, 3, null);
            Objects.requireNonNull(observableTakeSingleUntilTimeout$default);
            Message message = (Message) new BlockingObservable(observableTakeSingleUntilTimeout$default).b();
            NotificationData.DisplayPayload displayPayload = NotificationCache.INSTANCE.get(j);
            try {
                if (displayPayload == null) {
                    ListenableWorker.Result resultFailure3 = ListenableWorker.Result.failure();
                    Intrinsics3.checkNotNullExpressionValue(resultFailure3, "Result.failure()");
                    return resultFailure3;
                }
                NotificationData notificationData = (NotificationData) _Collections.lastOrNull((List) displayPayload.getExtras());
                if (notificationData == null) {
                    ListenableWorker.Result resultFailure4 = ListenableWorker.Result.failure();
                    Intrinsics3.checkNotNullExpressionValue(resultFailure4, "Result.failure()");
                    return resultFailure4;
                }
                Intrinsics3.checkNotNullExpressionValue(message, "message");
                NotificationData notificationDataCopyForDirectReply = notificationData.copyForDirectReply(message);
                NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
                Context applicationContext2 = getApplicationContext();
                Intrinsics3.checkNotNullExpressionValue(applicationContext2, "applicationContext");
                notificationRenderer.display(applicationContext2, notificationDataCopyForDirectReply, notificationClient.getSettings$app_productionGoogleRelease());
                String simpleName3 = getClass().getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
                Logger.d$default(appLog, simpleName3, "Direct reply: " + j + '-' + message.getId(), null, 4, null);
                StoreStream.INSTANCE.getAnalytics().ackMessage(j);
                ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
                Intrinsics3.checkNotNullExpressionValue(resultSuccess2, "Result.success()");
                return resultSuccess2;
            } catch (Throwable th) {
                th = th;
                AppLog appLog2 = AppLog.g;
                String simpleName4 = MessageSendWorker.class.getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName4, "javaClass.simpleName");
                appLog2.w(simpleName4, "Direct reply failure: " + j, th);
                NotificationCache.INSTANCE.remove(j, zRestSubscribeOn, new b(j, str));
                ListenableWorker.Result resultFailure5 = ListenableWorker.Result.failure();
                Intrinsics3.checkNotNullExpressionValue(resultFailure5, "Result.failure()");
                return resultFailure5;
            }
        } catch (Throwable th2) {
            th = th2;
            zRestSubscribeOn = 0;
        }
    }
}
