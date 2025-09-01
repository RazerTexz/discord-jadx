package com.discord.utilities.fcm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.outline;
import b.i.a.f.n.c;
import b.i.c.FirebaseApp2;
import b.i.c.w.i;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import d0.Tuples;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotificationClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002>?B\t\b\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010#\u001a\u00020\u00042\n\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$J\u000f\u0010'\u001a\u00020\u000fH\u0000¢\u0006\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010)R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010+R\u0016\u0010,\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b,\u0010)R\u0016\u0010-\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010.R\u0016\u0010/\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b/\u0010)R\u0016\u00100\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b0\u0010)R\u0013\u00101\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b1\u0010\tR\u0016\u00102\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b2\u0010)R\u0016\u00103\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b3\u0010)R$\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00040\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b6\u0010)R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00107R\u0016\u00108\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b8\u0010)R\u0016\u00109\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b9\u0010)R\u0016\u0010:\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b:\u0010)R\u0016\u0010;\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b;\u0010)¨\u0006@"}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient;", "", "Landroid/app/Application;", "application", "", "init", "(Landroid/app/Application;)V", "", "isOsLevelNotificationEnabled", "()Z", "Lkotlin/Function1;", "", "onDeviceRegistrationIdReceived", "setRegistrationIdReceived", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "settings", "isBackgrounded", "updateSettings$app_productionGoogleRelease", "(Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;Z)V", "updateSettings", "Landroid/content/Intent;", "intent", "", "buildTrackingData", "(Landroid/content/Intent;)Ljava/util/Map;", "token", "onNewToken", "(Ljava/lang/String;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Landroid/content/Context;", "context", "isAckRequest", "clear", "(JLandroid/content/Context;Z)V", "getSettings$app_productionGoogleRelease", "()Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "getSettings", "NOTIF_CHANNEL_MESSAGES", "Ljava/lang/String;", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/utilities/persister/Persister;", "NOTIF_GENERAL", "NOTIF_GUILD_SCHEDULED_EVENT_START", "Z", "NOTIF_CHANNEL_MEDIA_CONNECTIONS", "IGNORED_NOTIFICATION_TYPE", "isAuthed", "NOTIF_CHANNEL_FORUM_POST_CREATE", "NOTIF_CHANNEL_MESSAGES_DIRECT", "tokenCallback", "Lkotlin/jvm/functions/Function1;", "NOTIF_CHANNEL_CALLS", "Landroid/content/Context;", "NOTIF_CHANNEL_STAGE_START", "NOTIF_GENERAL_HIGH_PRIO", "NOTIF_CHANNEL_GAME_DETECTION", "NOTIF_CHANNEL_SOCIAL", "<init>", "()V", "FCMMessagingService", "SettingsV2", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public final class NotificationClient {
    public static final String IGNORED_NOTIFICATION_TYPE = "top_messages_push";
    public static final String NOTIF_CHANNEL_CALLS = "Calls";
    public static final String NOTIF_CHANNEL_FORUM_POST_CREATE = "Forum Post Create";
    public static final String NOTIF_CHANNEL_GAME_DETECTION = "Game Detection";
    public static final String NOTIF_CHANNEL_MEDIA_CONNECTIONS = "Media Connections";
    public static final String NOTIF_CHANNEL_MESSAGES = "Messages";
    public static final String NOTIF_CHANNEL_MESSAGES_DIRECT = "DirectMessages";
    public static final String NOTIF_CHANNEL_SOCIAL = "Social";
    public static final String NOTIF_CHANNEL_STAGE_START = "Stage Live";
    public static final String NOTIF_GENERAL = "General";
    public static final String NOTIF_GENERAL_HIGH_PRIO = "GeneralHigh";
    public static final String NOTIF_GUILD_SCHEDULED_EVENT_START = "Guild Event Live";
    private static Context context;
    private static String token;
    public static final NotificationClient INSTANCE = new NotificationClient();
    private static final Persister<SettingsV2> settings = new Persister<>("NOTIFICATION_CLIENT_SETTINGS_V3", new SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null));
    private static Function1<? super String, Unit> tokenCallback = NotificationClient2.INSTANCE;
    private static boolean isBackgrounded = true;

    /* compiled from: NotificationClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient$FCMMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "", "token", "", "onNewToken", "(Ljava/lang/String;)V", "Lcom/google/firebase/messaging/RemoteMessage;", "remoteMessage", "onMessageReceived", "(Lcom/google/firebase/messaging/RemoteMessage;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class FCMMessagingService extends FirebaseMessagingService {
        @Override // com.google.firebase.messaging.FirebaseMessagingService
        public void onMessageReceived(RemoteMessage remoteMessage) {
            Intrinsics3.checkNotNullParameter(remoteMessage, "remoteMessage");
            super.onMessageReceived(remoteMessage);
            if (remoteMessage.k == null) {
                Bundle bundle = remoteMessage.j;
                ArrayMap arrayMap = new ArrayMap();
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                            arrayMap.put(str, str2);
                        }
                    }
                }
                remoteMessage.k = arrayMap;
            }
            Map<String, String> map = remoteMessage.k;
            Intrinsics3.checkNotNullExpressionValue(map, "remoteMessage.data");
            AppLog.i("Got notification: " + map);
            NotificationData notificationData = new NotificationData(map);
            SettingsV2 settings$app_productionGoogleRelease = NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease();
            Iterator<Long> it = notificationData.getAckChannelIds().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                NotificationClient notificationClient = NotificationClient.INSTANCE;
                notificationClient.clear(jLongValue, NotificationClient.access$getContext$p(notificationClient), true);
            }
            NotificationClient notificationClient2 = NotificationClient.INSTANCE;
            Context contextAccess$getContext$p = NotificationClient.access$getContext$p(notificationClient2);
            if (contextAccess$getContext$p == null) {
                Logger.e$default(AppLog.g, "Not showing notification because context was null.", null, null, 6, null);
                return;
            }
            if (!notificationData.isValid() || !settings$app_productionGoogleRelease.getIsAuthed()) {
                if (Intrinsics3.areEqual(notificationData.getType(), NotificationData.TYPE_MESSAGE_CREATE)) {
                    Logger.e$default(AppLog.g, "Not showing invalid notification", null, Maps6.mapOf(Tuples.to("messageId", String.valueOf(notificationData.getMessageId())), Tuples.to("channelId", String.valueOf(notificationData.getChannelId())), Tuples.to("isAuthed", String.valueOf(settings$app_productionGoogleRelease.getIsAuthed())), Tuples.to("type", notificationData.getType())), 2, null);
                    return;
                }
                return;
            }
            if (Intrinsics3.areEqual(notificationData.getTrackingType(), NotificationClient.IGNORED_NOTIFICATION_TYPE)) {
                Tuples2[] tuples2Arr = new Tuples2[5];
                String trackingType = notificationData.getTrackingType();
                if (trackingType == null) {
                    trackingType = notificationData.getType();
                }
                tuples2Arr[0] = Tuples.to("notif_type", trackingType);
                tuples2Arr[1] = Tuples.to("notif_user_id", Long.valueOf(notificationData.getUserId()));
                tuples2Arr[2] = Tuples.to("message_id", Long.valueOf(notificationData.getMessageId()));
                tuples2Arr[3] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(notificationData.getGuildId()));
                tuples2Arr[4] = Tuples.to("notification_id", notificationData.getNotificationId());
                AnalyticsTracker.INSTANCE.appNotificationDropped(CollectionExtensions.filterNonNullValues(Maps6.mapOf(tuples2Arr)));
                return;
            }
            if (notificationData.getChannelId() != -1) {
                NotificationCache.INSTANCE.setIgnoreNextClearForAck(notificationData.getChannelId(), false);
            }
            if (NotificationClient.access$isBackgrounded$p(notificationClient2) && settings$app_productionGoogleRelease.isEnabled()) {
                NotificationRenderer.INSTANCE.display(contextAccess$getContext$p, notificationData, settings$app_productionGoogleRelease);
            } else {
                if (NotificationClient.access$isBackgrounded$p(notificationClient2) || !settings$app_productionGoogleRelease.isEnabledInApp()) {
                    return;
                }
                NotificationRenderer.INSTANCE.displayInApp(contextAccess$getContext$p, notificationData);
            }
        }

        @Override // com.google.firebase.messaging.FirebaseMessagingService
        public void onNewToken(String token) {
            Intrinsics3.checkNotNullParameter(token, "token");
            NotificationClient.INSTANCE.onNewToken(token);
        }
    }

    /* compiled from: NotificationClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.fcm.NotificationClient$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            return NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease().getToken();
        }
    }

    /* compiled from: NotificationClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.fcm.NotificationClient$init$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            return NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease().getLocale();
        }
    }

    /* compiled from: NotificationClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/gms/tasks/Task;", "", "kotlin.jvm.PlatformType", "task", "", "onComplete", "(Lcom/google/android/gms/tasks/Task;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.fcm.NotificationClient$init$3, reason: invalid class name */
    public static final class AnonymousClass3<TResult> implements c<String> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // b.i.a.f.n.c
        public final void onComplete(Task<String> task) {
            Intrinsics3.checkNotNullExpressionValue(task, "task");
            if (task.p()) {
                NotificationClient.INSTANCE.onNewToken(task.l());
            } else {
                AppLog.g.w("Fetching FCM registration token failed", task.k());
            }
        }
    }

    private NotificationClient() {
    }

    public static final /* synthetic */ Context access$getContext$p(NotificationClient notificationClient) {
        return context;
    }

    public static final /* synthetic */ boolean access$isBackgrounded$p(NotificationClient notificationClient) {
        return isBackgrounded;
    }

    public static final /* synthetic */ void access$setBackgrounded$p(NotificationClient notificationClient, boolean z2) {
        isBackgrounded = z2;
    }

    public static final /* synthetic */ void access$setContext$p(NotificationClient notificationClient, Context context2) {
        context = context2;
    }

    public static /* synthetic */ void clear$default(NotificationClient notificationClient, long j, Context context2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            context2 = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        notificationClient.clear(j, context2, z2);
    }

    public final Map<String, Object> buildTrackingData(Intent intent) {
        return NotificationData.INSTANCE.buildTrackingData(intent);
    }

    public final void clear(long channelId, Context context2, boolean isAckRequest) {
        NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
        if (context2 == null) {
            context2 = context;
        }
        notificationRenderer.clear(context2, channelId, isAckRequest);
    }

    public final synchronized SettingsV2 getSettings$app_productionGoogleRelease() {
        return settings.get();
    }

    @TargetApi(26)
    public final void init(Application application) {
        FirebaseMessaging firebaseMessaging;
        Intrinsics3.checkNotNullParameter(application, "application");
        context = application;
        if (isOsLevelNotificationEnabled()) {
            NotificationRenderer.INSTANCE.initNotificationChannels(application);
        }
        RestAPI.AppHeadersProvider.authTokenProvider = AnonymousClass1.INSTANCE;
        RestAPI.AppHeadersProvider.localeProvider = AnonymousClass2.INSTANCE;
        try {
            synchronized (FirebaseMessaging.class) {
                firebaseMessaging = FirebaseMessaging.getInstance(FirebaseApp2.b());
            }
            Intrinsics3.checkNotNullExpressionValue(firebaseMessaging, "FirebaseMessaging.getInstance()");
            Intrinsics3.checkNotNullExpressionValue(firebaseMessaging.d.f().h(i.a).b(AnonymousClass3.INSTANCE), "FirebaseMessaging.getIns…eption)\n        }\n      }");
        } catch (IllegalStateException e) {
            AppLog.g.w("FCM service start error", e);
        }
    }

    public final synchronized boolean isAuthed() {
        return settings.get().getIsAuthed();
    }

    public final boolean isOsLevelNotificationEnabled() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public final synchronized void onNewToken(String token2) {
        AppLog appLog = AppLog.g;
        StringBuilder sb = new StringBuilder();
        sb.append("FCM token received. hash=");
        sb.append(token2 != null ? Integer.valueOf(token2.hashCode()) : null);
        Logger.d$default(appLog, sb.toString(), null, 2, null);
        token = token2;
        tokenCallback.invoke(token2);
    }

    public final synchronized void setRegistrationIdReceived(Function1<? super String, Unit> onDeviceRegistrationIdReceived) {
        Intrinsics3.checkNotNullParameter(onDeviceRegistrationIdReceived, "onDeviceRegistrationIdReceived");
        tokenCallback = onDeviceRegistrationIdReceived;
        onDeviceRegistrationIdReceived.invoke(token);
    }

    public final synchronized void updateSettings$app_productionGoogleRelease(SettingsV2 settings2, boolean isBackgrounded2) {
        Intrinsics3.checkNotNullParameter(settings2, "settings");
        settings.set(settings2, isBackgrounded2);
        isBackgrounded = isBackgrounded2;
    }

    /* compiled from: NotificationClient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000e¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u001a\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012Jv\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000eHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001e\u0010\fJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b\u0018\u0010\u0004R#\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b)\u0010\u0012R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b*\u0010\fR\u0019\u0010+\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b+\u0010\u0004¨\u0006."}, d2 = {"Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "", "", "component1", "()Z", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/lang/String;", "component8", "", "", "Lcom/discord/primitives/ChannelId;", "component9", "()Ljava/util/Set;", "isEnabled", "isEnabledInApp", "isWake", "isDisableBlink", "isDisableSound", "isDisableVibrate", "token", "locale", "sendBlockedChannels", "copy", "(ZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/util/Set;)Lcom/discord/utilities/fcm/NotificationClient$SettingsV2;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getToken", "Ljava/util/Set;", "getSendBlockedChannels", "getLocale", "isAuthed", "<init>", "(ZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SettingsV2 {
        private final boolean isAuthed;
        private final boolean isDisableBlink;
        private final boolean isDisableSound;
        private final boolean isDisableVibrate;
        private final boolean isEnabled;
        private final boolean isEnabledInApp;
        private final boolean isWake;
        private final String locale;
        private final Set<Long> sendBlockedChannels;
        private final String token;

        public SettingsV2() {
            this(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
        }

        public SettingsV2(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set<Long> set) {
            Intrinsics3.checkNotNullParameter(str2, "locale");
            Intrinsics3.checkNotNullParameter(set, "sendBlockedChannels");
            this.isEnabled = z2;
            this.isEnabledInApp = z3;
            this.isWake = z4;
            this.isDisableBlink = z5;
            this.isDisableSound = z6;
            this.isDisableVibrate = z7;
            this.token = str;
            this.locale = str2;
            this.sendBlockedChannels = set;
            this.isAuthed = str != null;
        }

        public static /* synthetic */ SettingsV2 copy$default(SettingsV2 settingsV2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set set, int i, Object obj) {
            return settingsV2.copy((i & 1) != 0 ? settingsV2.isEnabled : z2, (i & 2) != 0 ? settingsV2.isEnabledInApp : z3, (i & 4) != 0 ? settingsV2.isWake : z4, (i & 8) != 0 ? settingsV2.isDisableBlink : z5, (i & 16) != 0 ? settingsV2.isDisableSound : z6, (i & 32) != 0 ? settingsV2.isDisableVibrate : z7, (i & 64) != 0 ? settingsV2.token : str, (i & 128) != 0 ? settingsV2.locale : str2, (i & 256) != 0 ? settingsV2.sendBlockedChannels : set);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsEnabledInApp() {
            return this.isEnabledInApp;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsWake() {
            return this.isWake;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsDisableBlink() {
            return this.isDisableBlink;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsDisableSound() {
            return this.isDisableSound;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsDisableVibrate() {
            return this.isDisableVibrate;
        }

        /* renamed from: component7, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* renamed from: component8, reason: from getter */
        public final String getLocale() {
            return this.locale;
        }

        public final Set<Long> component9() {
            return this.sendBlockedChannels;
        }

        public final SettingsV2 copy(boolean isEnabled, boolean isEnabledInApp, boolean isWake, boolean isDisableBlink, boolean isDisableSound, boolean isDisableVibrate, String token, String locale, Set<Long> sendBlockedChannels) {
            Intrinsics3.checkNotNullParameter(locale, "locale");
            Intrinsics3.checkNotNullParameter(sendBlockedChannels, "sendBlockedChannels");
            return new SettingsV2(isEnabled, isEnabledInApp, isWake, isDisableBlink, isDisableSound, isDisableVibrate, token, locale, sendBlockedChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingsV2)) {
                return false;
            }
            SettingsV2 settingsV2 = (SettingsV2) other;
            return this.isEnabled == settingsV2.isEnabled && this.isEnabledInApp == settingsV2.isEnabledInApp && this.isWake == settingsV2.isWake && this.isDisableBlink == settingsV2.isDisableBlink && this.isDisableSound == settingsV2.isDisableSound && this.isDisableVibrate == settingsV2.isDisableVibrate && Intrinsics3.areEqual(this.token, settingsV2.token) && Intrinsics3.areEqual(this.locale, settingsV2.locale) && Intrinsics3.areEqual(this.sendBlockedChannels, settingsV2.sendBlockedChannels);
        }

        public final String getLocale() {
            return this.locale;
        }

        public final Set<Long> getSendBlockedChannels() {
            return this.sendBlockedChannels;
        }

        public final String getToken() {
            return this.token;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isEnabled;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isEnabledInApp;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.isWake;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.isDisableBlink;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            ?? r24 = this.isDisableSound;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (i7 + i8) * 31;
            boolean z3 = this.isDisableVibrate;
            int i10 = (i9 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            String str = this.token;
            int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.locale;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Set<Long> set = this.sendBlockedChannels;
            return iHashCode2 + (set != null ? set.hashCode() : 0);
        }

        /* renamed from: isAuthed, reason: from getter */
        public final boolean getIsAuthed() {
            return this.isAuthed;
        }

        public final boolean isDisableBlink() {
            return this.isDisableBlink;
        }

        public final boolean isDisableSound() {
            return this.isDisableSound;
        }

        public final boolean isDisableVibrate() {
            return this.isDisableVibrate;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final boolean isEnabledInApp() {
            return this.isEnabledInApp;
        }

        public final boolean isWake() {
            return this.isWake;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SettingsV2(isEnabled=");
            sbU.append(this.isEnabled);
            sbU.append(", isEnabledInApp=");
            sbU.append(this.isEnabledInApp);
            sbU.append(", isWake=");
            sbU.append(this.isWake);
            sbU.append(", isDisableBlink=");
            sbU.append(this.isDisableBlink);
            sbU.append(", isDisableSound=");
            sbU.append(this.isDisableSound);
            sbU.append(", isDisableVibrate=");
            sbU.append(this.isDisableVibrate);
            sbU.append(", token=");
            sbU.append(this.token);
            sbU.append(", locale=");
            sbU.append(this.locale);
            sbU.append(", sendBlockedChannels=");
            return outline.N(sbU, this.sendBlockedChannels, ")");
        }

        public /* synthetic */ SettingsV2(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z2, (i & 2) == 0 ? z3 : true, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? null : str, (i & 128) != 0 ? "" : str2, (i & 256) != 0 ? new HashSet(0) : set);
        }
    }
}
