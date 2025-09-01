package com.discord.utilities.fcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import b.d.b.a.outline;
import com.discord.app.AppLog;
import com.discord.app.DiscordConnectService;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.workers.CallActionWorker;
import com.discord.workers.MessageAckWorker;
import com.discord.workers.MessageSendWorker;
import com.discord.workers.TimedMuteWorker;
import d0.Tuples;
import d0.g0.StringNumberConversions;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotificationActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u000f\u0010\fJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/fcm/NotificationActions;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "isAcceptingCall", "", "executeCallAction", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "enqueueAckMessage", "(Landroid/content/Context;Landroid/content/Intent;)V", "enqueueDirectReply", "enqueueTimedMute", "onReceive", "enqueue", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NotificationActions extends BroadcastReceiver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NOTIFICATION_CHANNEL_ID = "com.discord.NOTIFICATION_DELETED_CHANNEL_ID";
    private static final String NOTIFICATION_ID = "com.discord.NOTIFICATION_ID";

    /* compiled from: NotificationActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0017\u001a\u00060\u0004j\u0002`\u00162\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0019\u001a\u00060\u0004j\u0002`\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u000f\u001a\u00060\u0004j\u0002`\u000e2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006&"}, d2 = {"Lcom/discord/utilities/fcm/NotificationActions$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Landroid/content/Intent;", "delete", "(Landroid/content/Context;J)Landroid/content/Intent;", "", "notificationId", "cancel", "(Landroid/content/Context;I)Landroid/content/Intent;", "Lcom/discord/primitives/MessageId;", "messageId", "markAsRead", "(Landroid/content/Context;JJ)Landroid/content/Intent;", "", "channelName", "directReply", "(Landroid/content/Context;JLjava/lang/CharSequence;)Landroid/content/Intent;", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/Timestamp;", "untilTimestamp", "timedMute", "(Landroid/content/Context;JJJ)Landroid/content/Intent;", "", "isAcceptingCall", "callAction", "(Landroid/content/Context;JJZ)Landroid/content/Intent;", "", "NOTIFICATION_CHANNEL_ID", "Ljava/lang/String;", "NOTIFICATION_ID", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Intent callAction(Context context, long channelId, long messageId, boolean isAcceptingCall) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/channel/call/" + (isAcceptingCall ? "accept" : "decline") + "?channelId=" + channelId + "&messageId=" + messageId), context, NotificationActions.class);
        }

        public final Intent cancel(Context context, int notificationId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent("com.discord.intent.action.NOTIFICATION_CANCEL", Uri.parse("discord://action/notif/cancel?id=" + notificationId), context, NotificationActions.class).putExtra(NotificationActions.NOTIFICATION_ID, notificationId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent(\n          Intent…ATION_ID, notificationId)");
            return intentPutExtra;
        }

        public final Intent delete(Context context, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent("com.discord.intent.action.NOTIFICATION_DELETED", Uri.parse("discord://action/notif/delete?channelId=" + channelId), context, NotificationActions.class).putExtra(NotificationActions.NOTIFICATION_CHANNEL_ID, channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent(\n          Intent…ON_CHANNEL_ID, channelId)");
            return intentPutExtra;
        }

        public final Intent directReply(Context context, long channelId, CharSequence channelName) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/message/reply?channelId=" + channelId), context, NotificationActions.class);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_NAME", channelName);
            return intent;
        }

        public final Intent markAsRead(Context context, long channelId, long messageId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/message/ack?channelId=" + channelId + "&messageId=" + messageId), context, NotificationActions.class);
        }

        public final Intent timedMute(Context context, long guildId, long channelId, long untilTimestamp) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return new Intent("com.discord.intent.action.ENQUEUE_WORK", Uri.parse("discord://action/channel/mute").buildUpon().appendQueryParameter("guildId", String.valueOf(guildId)).appendQueryParameter("channelId", String.valueOf(channelId)).appendQueryParameter("until", String.valueOf(untilTimestamp)).build(), context, NotificationActions.class);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void enqueueAckMessage(Context context, Intent intent) throws Throwable {
        Long longOrNull;
        Long longOrNull2;
        Uri data = intent.getData();
        if (data != null) {
            Intrinsics3.checkNotNullExpressionValue(data, "intent.data ?: return");
            String queryParameter = data.getQueryParameter("channelId");
            if (queryParameter == null || (longOrNull = StringNumberConversions.toLongOrNull(queryParameter)) == null) {
                return;
            }
            long jLongValue = longOrNull.longValue();
            String queryParameter2 = data.getQueryParameter("messageId");
            if (queryParameter2 == null || (longOrNull2 = StringNumberConversions.toLongOrNull(queryParameter2)) == null) {
                return;
            }
            long jLongValue2 = longOrNull2.longValue();
            Intrinsics3.checkNotNullParameter(context, "context");
            Data dataBuild = new Data.Builder().putAll(Maps6.mapOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue)), Tuples.to("com.discord.intent.extra.EXTRA_MESSAGE_ID", Long.valueOf(jLongValue2)))).build();
            Intrinsics3.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(MessageAckWorker.class).setInputData(dataBuild).setBackoffCriteria(BackoffPolicy.LINEAR, 1L, TimeUnit.SECONDS).addTag("message").addTag("ack").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
            NotificationClient.clear$default(NotificationClient.INSTANCE, jLongValue, context, false, 4, null);
        }
    }

    private final void enqueueDirectReply(Context context, Intent intent) throws Throwable {
        String queryParameter;
        Long longOrNull;
        CharSequence charSequence;
        String string;
        Uri data = intent.getData();
        if (data == null || (queryParameter = data.getQueryParameter("channelId")) == null || (longOrNull = StringNumberConversions.toLongOrNull(queryParameter)) == null) {
            return;
        }
        long jLongValue = longOrNull.longValue();
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("com.discord.intent.extra.EXTRA_CHANNEL_NAME");
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent != null && (charSequence = resultsFromIntent.getCharSequence("discord_notif_text_input")) != null) {
            Intrinsics3.checkNotNullExpressionValue(charSequence, "it");
            if (!(!StringsJVM.isBlank(charSequence))) {
                charSequence = null;
            }
            if (charSequence != null && (string = charSequence.toString()) != null) {
                NotificationCache.INSTANCE.setIgnoreNextClearForAck(jLongValue, true);
                Intrinsics3.checkNotNullParameter(context, "context");
                Intrinsics3.checkNotNullParameter(string, "message");
                Data.Builder builder = new Data.Builder();
                Tuples2[] tuples2Arr = new Tuples2[5];
                tuples2Arr[0] = Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue));
                tuples2Arr[1] = Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_NAME", charSequenceExtra != null ? charSequenceExtra.toString() : null);
                tuples2Arr[2] = Tuples.to("com.discord.intent.extra.EXTRA_MESSAGE_ID", null);
                tuples2Arr[3] = Tuples.to("MESSAGE_CONTENT", string);
                tuples2Arr[4] = Tuples.to("com.discord.intent.extra.EXTRA_STICKER_ID", null);
                Data dataBuild = builder.putAll(Maps6.mapOf(tuples2Arr)).build();
                Intrinsics3.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
                OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(MessageSendWorker.class).setInputData(dataBuild).addTag("message").addTag("send").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
                Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
                WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
                return;
            }
        }
        NotificationClient.clear$default(NotificationClient.INSTANCE, jLongValue, context, false, 4, null);
    }

    private final void enqueueTimedMute(Context context, Intent intent) throws Throwable {
        Long longOrNull;
        Long longOrNull2;
        Long longOrNull3;
        Uri data = intent.getData();
        if (data != null) {
            Intrinsics3.checkNotNullExpressionValue(data, "intent.data ?: return");
            String queryParameter = data.getQueryParameter("guildId");
            if (queryParameter == null || (longOrNull = StringNumberConversions.toLongOrNull(queryParameter)) == null) {
                return;
            }
            long jLongValue = longOrNull.longValue();
            String queryParameter2 = data.getQueryParameter("channelId");
            if (queryParameter2 == null || (longOrNull2 = StringNumberConversions.toLongOrNull(queryParameter2)) == null) {
                return;
            }
            long jLongValue2 = longOrNull2.longValue();
            String queryParameter3 = data.getQueryParameter("until");
            if (queryParameter3 == null || (longOrNull3 = StringNumberConversions.toLongOrNull(queryParameter3)) == null) {
                return;
            }
            long jLongValue3 = longOrNull3.longValue();
            Intrinsics3.checkNotNullParameter(context, "context");
            Data dataBuild = new Data.Builder().putAll(Maps6.mapOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(jLongValue)), Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue2)), Tuples.to("com.discord.intent.extra.EXTRA_UNTIL_TIMESTAMP_MS", Long.valueOf(jLongValue3)))).build();
            Intrinsics3.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(TimedMuteWorker.class).setInputData(dataBuild).setBackoffCriteria(BackoffPolicy.LINEAR, 1L, TimeUnit.SECONDS).addTag("channel").addTag(ModelAuditLogEntry.CHANGE_KEY_MUTE).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
            WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
            NotificationClient.clear$default(NotificationClient.INSTANCE, jLongValue2, context, false, 4, null);
        }
    }

    @RequiresApi(24)
    private final void executeCallAction(Context context, Intent intent, boolean isAcceptingCall) throws Throwable {
        Long longOrNull;
        Long longOrNull2;
        Uri data = intent.getData();
        if (data != null) {
            Intrinsics3.checkNotNullExpressionValue(data, "intent.data ?: return");
            String queryParameter = data.getQueryParameter("channelId");
            if (queryParameter == null || (longOrNull = StringNumberConversions.toLongOrNull(queryParameter)) == null) {
                return;
            }
            long jLongValue = longOrNull.longValue();
            String queryParameter2 = data.getQueryParameter("messageId");
            if (queryParameter2 == null || (longOrNull2 = StringNumberConversions.toLongOrNull(queryParameter2)) == null) {
                return;
            }
            long jLongValue2 = longOrNull2.longValue();
            if (isAcceptingCall) {
                DiscordConnectService.INSTANCE.b(context, jLongValue);
            } else {
                Intrinsics3.checkNotNullParameter(context, "context");
                Data dataBuild = new Data.Builder().putAll(Maps6.mapOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(jLongValue)), Tuples.to("com.discord.intent.extra.EXTRA_MESSAGE_ID", Long.valueOf(jLongValue2)))).build();
                Intrinsics3.checkNotNullExpressionValue(dataBuild, "Data.Builder()\n         …     )\n          .build()");
                OneTimeWorkRequest.Builder inputData = new OneTimeWorkRequest.Builder(CallActionWorker.class).setInputData(dataBuild);
                BackoffPolicy backoffPolicy = BackoffPolicy.LINEAR;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                OneTimeWorkRequest oneTimeWorkRequestBuild = inputData.setBackoffCriteria(backoffPolicy, 1L, timeUnit).addTag(NotificationCompat.CATEGORY_CALL).addTag("decline").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setTriggerContentMaxDelay(10L, timeUnit).build()).build();
                Intrinsics3.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
                WorkManager.getInstance(context).enqueue(oneTimeWorkRequestBuild);
            }
            NotificationClient.clear$default(NotificationClient.INSTANCE, jLongValue, context, false, 4, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @RequiresApi(24)
    public final void enqueue(Context context, Intent intent) throws Throwable {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Uri data = intent.getData();
        if (!Intrinsics3.areEqual(data != null ? data.getAuthority() : null, "action")) {
            data = null;
        }
        if (data != null) {
            Intrinsics3.checkNotNullExpressionValue(data, "intent.data.takeIf { it?…y == \"action\" } ?: return");
            String path = data.getPath();
            if (path != null) {
                switch (path.hashCode()) {
                    case -1030684332:
                        if (path.equals("/channel/mute")) {
                            enqueueTimedMute(context, intent);
                            return;
                        }
                        break;
                    case -581403885:
                        if (path.equals("/message/reply")) {
                            enqueueDirectReply(context, intent);
                            return;
                        }
                        break;
                    case 254025278:
                        if (path.equals("/channel/call/accept")) {
                            executeCallAction(context, intent, true);
                            return;
                        }
                        break;
                    case 897701618:
                        if (path.equals("/message/ack")) {
                            enqueueAckMessage(context, intent);
                            return;
                        }
                        break;
                    case 2004820096:
                        if (path.equals("/channel/call/decline")) {
                            executeCallAction(context, intent, false);
                            return;
                        }
                        break;
                }
            }
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Unknown work action ");
            sbU.append(data.getPath());
            Logger.w$default(appLog, sbU.toString(), null, 2, null);
        }
    }

    @Override // android.content.BroadcastReceiver
    @RequiresApi(24)
    public void onReceive(Context context, Intent intent) throws Throwable {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(intent, "intent");
        AppLog.i("Got notification action: " + intent);
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        int iHashCode = action.hashCode();
        if (iHashCode == -1599864135) {
            if (action.equals("com.discord.intent.action.NOTIFICATION_CANCEL")) {
                AppLog.i("Got notification cancel: " + intent);
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    NotificationManagerCompat.from(context).cancel(extras.getInt(NOTIFICATION_ID));
                    return;
                }
                return;
            }
            return;
        }
        if (iHashCode != -1350900838) {
            if (iHashCode == -26919171 && action.equals("com.discord.intent.action.ENQUEUE_WORK")) {
                enqueue(context, intent);
                return;
            }
            return;
        }
        if (action.equals("com.discord.intent.action.NOTIFICATION_DELETED")) {
            AppLog.i("Got notification deleted: " + intent);
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                NotificationClient.clear$default(NotificationClient.INSTANCE, extras2.getLong(NOTIFICATION_CHANNEL_ID), context, false, 4, null);
            }
        }
    }
}
