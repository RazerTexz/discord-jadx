package com.discord.utilities.voice;

import android.app.Application;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import b.a.d.AppState2;
import b.d.b.a.outline;
import com.discord.app.AppActivity;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.extensions.PendingIntentExtensions;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.system.SystemServiceExtensions;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageChannelNotifications;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* compiled from: VoiceEngineForegroundService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0003-./B\u0007¢\u0006\u0004\b,\u0010\u000bJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0018\u00010\u001dR\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0018\u00010$R\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010+\u001a\b\u0018\u00010$R\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010'¨\u00060"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineForegroundService;", "Landroid/app/IntentService;", "Lcom/discord/app/AppComponent;", "Landroid/content/Intent;", "intent", "", "accept", "", "ackStageInvite", "(Landroid/content/Intent;Z)V", "onCreate", "()V", "onDestroy", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onUnbind", "(Landroid/content/Intent;)Z", "onHandleIntent", "(Landroid/content/Intent;)V", "Lrx/subjects/Subject;", "Ljava/lang/Void;", "unsubscribeSignal", "Lrx/subjects/Subject;", "getUnsubscribeSignal", "()Lrx/subjects/Subject;", "Lcom/discord/utilities/voice/ScreenShareManager;", "screenShareManager", "Lcom/discord/utilities/voice/ScreenShareManager;", "Landroid/net/wifi/WifiManager$WifiLock;", "Landroid/net/wifi/WifiManager;", "wakeLockWifi", "Landroid/net/wifi/WifiManager$WifiLock;", "Lcom/discord/utilities/voice/CallSoundManager;", "ringManager", "Lcom/discord/utilities/voice/CallSoundManager;", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "wakeLockPartial", "Landroid/os/PowerManager$WakeLock;", "Lcom/discord/utilities/voice/VoiceEngineForegroundService$LocalBinder;", "binder", "Lcom/discord/utilities/voice/VoiceEngineForegroundService$LocalBinder;", "wakeLockProximity", "<init>", "Companion", "Connection", "LocalBinder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VoiceEngineForegroundService extends IntentService implements AppComponent {
    private static final String LOG_TAG = "DiscordVoiceService";
    private static final int NOTIFICATION_ID = 101;
    private static final long WAKELOCK_TIMEOUT = 7200000;
    private final LocalBinder binder;
    private final CallSoundManager ringManager;
    private ScreenShareManager screenShareManager;
    private final Subject<Void, Void> unsubscribeSignal;
    private PowerManager.WakeLock wakeLockPartial;
    private PowerManager.WakeLock wakeLockProximity;
    private WifiManager.WifiLock wakeLockWifi;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function0<Unit> onDisconnect = VoiceEngineForegroundService2.INSTANCE;
    private static Function0<Unit> onToggleSelfDeafen = VoiceEngineForegroundService3.INSTANCE;
    private static Function0<Unit> onToggleSelfMute = VoiceEngineForegroundService4.INSTANCE;

    /* compiled from: VoiceEngineForegroundService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002;<B\t\b\u0002¢\u0006\u0004\b9\u0010:J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJi\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u000e\u0010\u0018\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00172\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b#\u0010\u001fR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R(\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010&\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00108¨\u0006="}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineForegroundService$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "accept", "Landroid/app/PendingIntent;", "stageInviteAckPendingIntent", "(Landroid/content/Context;JZ)Landroid/app/PendingIntent;", "Landroid/content/Intent;", "stageInviteAckIntent", "(Landroid/content/Context;JZ)Landroid/content/Intent;", "Lcom/discord/utilities/voice/VoiceEngineForegroundService$Connection;", "connection", "", "title", "subtitle", "selfMute", "selfDeafen", "selfStream", "Lcom/discord/primitives/GuildId;", "guildId", "isProximityLockEnabled", "canSpeak", "", "startForegroundAndBind", "(Lcom/discord/utilities/voice/VoiceEngineForegroundService$Connection;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZJLjava/lang/Long;ZZ)V", "stopForegroundAndUnbind", "(Lcom/discord/utilities/voice/VoiceEngineForegroundService$Connection;)V", "permissionIntent", "startStream", "(Lcom/discord/utilities/voice/VoiceEngineForegroundService$Connection;Landroid/content/Intent;)V", "stopStream", "Lkotlin/Function0;", "onDisconnect", "Lkotlin/jvm/functions/Function0;", "getOnDisconnect", "()Lkotlin/jvm/functions/Function0;", "setOnDisconnect", "(Lkotlin/jvm/functions/Function0;)V", "onToggleSelfDeafen", "getOnToggleSelfDeafen", "setOnToggleSelfDeafen", "onToggleSelfMute", "getOnToggleSelfMute", "setOnToggleSelfMute", "", "LOG_TAG", "Ljava/lang/String;", "", "NOTIFICATION_ID", "I", "WAKELOCK_TIMEOUT", "J", "<init>", "()V", "ACTION", "EXTRA", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: VoiceEngineForegroundService.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineForegroundService$Companion$ACTION;", "", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public interface ACTION {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = Companion.$$INSTANCE;
            public static final String DISCONNECT = "com.discord.utilities.voice.action.disconnect";
            public static final String MAIN_ACTION = "com.discord.utilities.voice.action.main";
            public static final String STAGE_INVITE_ACCEPT = "com.discord.utilities.voice.action.stage_invite_accept";
            public static final String STAGE_INVITE_DECLINE = "com.discord.utilities.voice.action.stage_invite_decline";
            public static final String START_FOREGROUND = "com.discord.utilities.voice.action.start_foreground";
            public static final String START_STREAM = "com.discord.utilities.voice.action.start_stream";
            public static final String STOP_SERVICE = "com.discord.utilities.voice.action.stop";
            public static final String STOP_STREAM = "com.discord.utilities.voice.action.stop_stream";
            public static final String TOGGLE_DEAFENED = "com.discord.utilities.voice.action.toggle_deafened";
            public static final String TOGGLE_MUTED = "com.discord.utilities.voice.action.toggle_muted";

            /* compiled from: VoiceEngineForegroundService.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineForegroundService$Companion$ACTION$Companion;", "", "", "TOGGLE_MUTED", "Ljava/lang/String;", "TOGGLE_DEAFENED", "STOP_SERVICE", "DISCONNECT", "MAIN_ACTION", "START_FOREGROUND", "START_STREAM", "STOP_STREAM", "STAGE_INVITE_ACCEPT", "STAGE_INVITE_DECLINE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                public static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final String DISCONNECT = "com.discord.utilities.voice.action.disconnect";
                public static final String MAIN_ACTION = "com.discord.utilities.voice.action.main";
                public static final String STAGE_INVITE_ACCEPT = "com.discord.utilities.voice.action.stage_invite_accept";
                public static final String STAGE_INVITE_DECLINE = "com.discord.utilities.voice.action.stage_invite_decline";
                public static final String START_FOREGROUND = "com.discord.utilities.voice.action.start_foreground";
                public static final String START_STREAM = "com.discord.utilities.voice.action.start_stream";
                public static final String STOP_SERVICE = "com.discord.utilities.voice.action.stop";
                public static final String STOP_STREAM = "com.discord.utilities.voice.action.stop_stream";
                public static final String TOGGLE_DEAFENED = "com.discord.utilities.voice.action.toggle_deafened";
                public static final String TOGGLE_MUTED = "com.discord.utilities.voice.action.toggle_muted";

                private Companion() {
                }
            }
        }

        /* compiled from: VoiceEngineForegroundService.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bb\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineForegroundService$Companion$EXTRA;", "", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public interface EXTRA {
            public static final String CHANNEL_ID = "com.discord.utilities.voice.extra.channel_id";

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = Companion.$$INSTANCE;
            public static final String GUILD_ID = "com.discord.utilities.voice.extra.guild_id";
            public static final String ITEM_CAN_SPEAK = "com.discord.utilities.voice.extra.item_can_speak";
            public static final String ITEM_DEAFENED = "com.discord.utilities.voice.extra.item_deafened";
            public static final String ITEM_MUTED = "com.discord.utilities.voice.extra.item_muted";
            public static final String ITEM_STREAMING = "com.discord.utilities.voice.extra.item_streaming";
            public static final String PROXIMITY_LOCK_ENABLED = "com.discord.utilities.voice.extra.proximity_lock_enabled";
            public static final String TITLE = "com.discord.utilities.voice.extra.title";
            public static final String TITLE_SUBTEXT = "com.discord.utilities.voice.extra.title_subtext";

            /* compiled from: VoiceEngineForegroundService.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineForegroundService$Companion$EXTRA$Companion;", "", "", "ITEM_DEAFENED", "Ljava/lang/String;", "CHANNEL_ID", "GUILD_ID", "TITLE_SUBTEXT", "ITEM_CAN_SPEAK", "PROXIMITY_LOCK_ENABLED", "ITEM_STREAMING", "ITEM_MUTED", "TITLE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                public static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final String CHANNEL_ID = "com.discord.utilities.voice.extra.channel_id";
                public static final String GUILD_ID = "com.discord.utilities.voice.extra.guild_id";
                public static final String ITEM_CAN_SPEAK = "com.discord.utilities.voice.extra.item_can_speak";
                public static final String ITEM_DEAFENED = "com.discord.utilities.voice.extra.item_deafened";
                public static final String ITEM_MUTED = "com.discord.utilities.voice.extra.item_muted";
                public static final String ITEM_STREAMING = "com.discord.utilities.voice.extra.item_streaming";
                public static final String PROXIMITY_LOCK_ENABLED = "com.discord.utilities.voice.extra.proximity_lock_enabled";
                public static final String TITLE = "com.discord.utilities.voice.extra.title";
                public static final String TITLE_SUBTEXT = "com.discord.utilities.voice.extra.title_subtext";

                private Companion() {
                }
            }
        }

        private Companion() {
        }

        public final Function0<Unit> getOnDisconnect() {
            return VoiceEngineForegroundService.access$getOnDisconnect$cp();
        }

        public final Function0<Unit> getOnToggleSelfDeafen() {
            return VoiceEngineForegroundService.access$getOnToggleSelfDeafen$cp();
        }

        public final Function0<Unit> getOnToggleSelfMute() {
            return VoiceEngineForegroundService.access$getOnToggleSelfMute$cp();
        }

        public final void setOnDisconnect(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "<set-?>");
            VoiceEngineForegroundService.access$setOnDisconnect$cp(function0);
        }

        public final void setOnToggleSelfDeafen(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "<set-?>");
            VoiceEngineForegroundService.access$setOnToggleSelfDeafen$cp(function0);
        }

        public final void setOnToggleSelfMute(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "<set-?>");
            VoiceEngineForegroundService.access$setOnToggleSelfMute$cp(function0);
        }

        public final Intent stageInviteAckIntent(Context context, long channelId, boolean accept) {
            Intrinsics3.checkNotNullParameter(context, "context");
            boolean z2 = ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
            if (accept && !z2) {
                Intent intent = new Intent(context, (Class<?>) WidgetCallFullscreen.class);
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
                return intent;
            }
            Intent intent2 = new Intent(context, (Class<?>) VoiceEngineForegroundService.class);
            intent2.setAction(accept ? "com.discord.utilities.voice.action.stage_invite_accept" : "com.discord.utilities.voice.action.stage_invite_decline");
            intent2.putExtra("com.discord.utilities.voice.extra.channel_id", channelId);
            return intent2;
        }

        public final PendingIntent stageInviteAckPendingIntent(Context context, long channelId, boolean accept) {
            Intrinsics3.checkNotNullParameter(context, "context");
            PendingIntent service = PendingIntent.getService(context, 0, stageInviteAckIntent(context, channelId, accept), PendingIntentExtensions.immutablePendingIntentFlag(1207959552));
            Intrinsics3.checkNotNullExpressionValue(service, "PendingIntent.getService…AG_UPDATE_CURRENT),\n    )");
            return service;
        }

        public final void startForegroundAndBind(Connection connection, CharSequence title, CharSequence subtitle, boolean selfMute, boolean selfDeafen, boolean selfStream, long channelId, Long guildId, boolean isProximityLockEnabled, boolean canSpeak) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            try {
                Logger.v$default(AppLog.g, VoiceEngineForegroundService.LOG_TAG, "Bind service connection.", null, 4, null);
                Context context = connection.getContext();
                Intent intent = new Intent(connection.getContext(), (Class<?>) VoiceEngineForegroundService.class);
                intent.setAction("com.discord.utilities.voice.action.start_foreground");
                intent.putExtra("com.discord.utilities.voice.extra.title", title);
                intent.putExtra("com.discord.utilities.voice.extra.title_subtext", subtitle);
                intent.putExtra("com.discord.utilities.voice.extra.item_muted", selfMute);
                intent.putExtra("com.discord.utilities.voice.extra.item_deafened", selfDeafen);
                intent.putExtra("com.discord.utilities.voice.extra.item_streaming", selfStream);
                intent.putExtra("com.discord.utilities.voice.extra.item_can_speak", canSpeak);
                intent.putExtra("com.discord.utilities.voice.extra.proximity_lock_enabled", isProximityLockEnabled);
                intent.putExtra("com.discord.utilities.voice.extra.channel_id", channelId);
                intent.putExtra("com.discord.utilities.voice.extra.guild_id", guildId);
                context.startService(intent);
                connection.getContext().bindService(new Intent(connection.getContext(), (Class<?>) VoiceEngineForegroundService.class), connection.getConnection(), 1);
            } catch (Exception e) {
                AppLog.g.v(VoiceEngineForegroundService.LOG_TAG, "Unable to bind service connection.", e);
            }
        }

        public final void startStream(Connection connection, Intent permissionIntent) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            Intrinsics3.checkNotNullParameter(permissionIntent, "permissionIntent");
            Context context = connection.getContext();
            Intent intent = new Intent(context, (Class<?>) VoiceEngineForegroundService.class);
            intent.setAction("com.discord.utilities.voice.action.start_stream");
            intent.putExtra("android.intent.extra.INTENT", permissionIntent);
            context.startService(intent);
        }

        public final void stopForegroundAndUnbind(Connection connection) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            try {
                if (connection.getService() == null || connection.isUnbinding()) {
                    return;
                }
                Logger.v$default(AppLog.g, VoiceEngineForegroundService.LOG_TAG, "Unbind service connection.", null, 4, null);
                connection.setUnbinding(true);
                Context context = connection.getContext();
                Intent intent = new Intent(connection.getContext(), (Class<?>) VoiceEngineForegroundService.class);
                intent.setAction("com.discord.utilities.voice.action.stop");
                context.startService(intent);
                connection.getContext().unbindService(connection.getConnection());
            } catch (Exception e) {
                AppLog.g.v(VoiceEngineForegroundService.LOG_TAG, "Unable to unbind service connection.", e);
            }
        }

        public final void stopStream(Connection connection) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            Context context = connection.getContext();
            Intent intent = new Intent(context, (Class<?>) VoiceEngineForegroundService.class);
            intent.setAction("com.discord.utilities.voice.action.stop_stream");
            context.startService(intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: VoiceEngineForegroundService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineForegroundService$Connection;", "", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/content/ServiceConnection;", "connection", "Landroid/content/ServiceConnection;", "getConnection", "()Landroid/content/ServiceConnection;", "", "<set-?>", "isUnbinding", "Z", "()Z", "setUnbinding", "(Z)V", "Lcom/discord/utilities/voice/VoiceEngineForegroundService;", NotificationCompat.CATEGORY_SERVICE, "Lcom/discord/utilities/voice/VoiceEngineForegroundService;", "getService", "()Lcom/discord/utilities/voice/VoiceEngineForegroundService;", "<init>", "(Landroid/content/Context;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Connection {
        private final ServiceConnection connection;
        private final Context context;
        private boolean isUnbinding;
        private VoiceEngineForegroundService service;

        public Connection(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            this.context = context;
            this.connection = new VoiceEngineForegroundService5(this);
        }

        public static final /* synthetic */ VoiceEngineForegroundService access$getService$p(Connection connection) {
            return connection.service;
        }

        public static final /* synthetic */ void access$setService$p(Connection connection, VoiceEngineForegroundService voiceEngineForegroundService) {
            connection.service = voiceEngineForegroundService;
        }

        public final ServiceConnection getConnection() {
            return this.connection;
        }

        public final Context getContext() {
            return this.context;
        }

        public final VoiceEngineForegroundService getService() {
            return this.service;
        }

        public final synchronized boolean isUnbinding() {
            return this.isUnbinding;
        }

        public final synchronized void setUnbinding(boolean z2) {
            this.isUnbinding = z2;
        }
    }

    /* compiled from: VoiceEngineForegroundService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineForegroundService$LocalBinder;", "Landroid/os/Binder;", "Lcom/discord/utilities/voice/VoiceEngineForegroundService;", NotificationCompat.CATEGORY_SERVICE, "Lcom/discord/utilities/voice/VoiceEngineForegroundService;", "getService", "()Lcom/discord/utilities/voice/VoiceEngineForegroundService;", "<init>", "(Lcom/discord/utilities/voice/VoiceEngineForegroundService;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class LocalBinder extends Binder {
        private final VoiceEngineForegroundService service;

        public LocalBinder(VoiceEngineForegroundService voiceEngineForegroundService) {
            this.service = voiceEngineForegroundService;
        }

        public final VoiceEngineForegroundService getService() {
            return this.service;
        }
    }

    /* compiled from: VoiceEngineForegroundService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.VoiceEngineForegroundService$ackStageInvite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StageChannelNotifications.INSTANCE.getINSTANCE().onInvitedToSpeakAckFailed(this.$channelId);
        }
    }

    /* compiled from: VoiceEngineForegroundService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.VoiceEngineForegroundService$ackStageInvite$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ boolean $accept;
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2, long j) {
            super(1);
            this.$accept = z2;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            if (this.$accept) {
                AnalyticsTracker.INSTANCE.promotedToSpeaker(this.$channelId);
            }
            StageChannelNotifications.Notifications.InvitedToSpeak.INSTANCE.cancel(VoiceEngineForegroundService.this);
        }
    }

    public VoiceEngineForegroundService() {
        super("VoiceEngineForegroundService");
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.binder = new LocalBinder(this);
        this.ringManager = new CallSoundManager(this, null, null, 6, null);
    }

    public static final /* synthetic */ Function0 access$getOnDisconnect$cp() {
        return onDisconnect;
    }

    public static final /* synthetic */ Function0 access$getOnToggleSelfDeafen$cp() {
        return onToggleSelfDeafen;
    }

    public static final /* synthetic */ Function0 access$getOnToggleSelfMute$cp() {
        return onToggleSelfMute;
    }

    public static final /* synthetic */ void access$setOnDisconnect$cp(Function0 function0) {
        onDisconnect = function0;
    }

    public static final /* synthetic */ void access$setOnToggleSelfDeafen$cp(Function0 function0) {
        onToggleSelfDeafen = function0;
    }

    public static final /* synthetic */ void access$setOnToggleSelfMute$cp(Function0 function0) {
        onToggleSelfMute = function0;
    }

    private final void ackStageInvite(Intent intent, boolean accept) {
        long longExtra = intent.getLongExtra("com.discord.utilities.voice.extra.channel_id", 0L);
        Observable<Void> observableAckInvitationToSpeak = StageChannelAPI.INSTANCE.ackInvitationToSpeak(longExtra, accept);
        if (observableAckInvitationToSpeak != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(observableAckInvitationToSpeak, false, 1, null)), VoiceEngineForegroundService.class, (Context) null, (Function1) null, new AnonymousClass1(longExtra), (Function0) null, (Function0) null, new AnonymousClass2(accept, longExtra), 54, (Object) null);
        } else {
            Logger.w$default(AppLog.g, LOG_TAG, outline.t("Unable to ack stage invite for unknown channel ", longExtra), null, 4, null);
        }
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        return this.binder;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.v$default(AppLog.g, LOG_TAG, "Service created.", null, 4, null);
        AppState2.c.a(this);
        Application application = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application, "application");
        WifiManager.WifiLock wifiLockCreateWifiLock$default = SystemServiceExtensions.createWifiLock$default(application, false, 0, null, 7, null);
        this.wakeLockWifi = wifiLockCreateWifiLock$default;
        if (wifiLockCreateWifiLock$default != null) {
            wifiLockCreateWifiLock$default.acquire();
        }
        Application application2 = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application2, "application");
        PowerManager.WakeLock wakeLockCreatePartialWakeLock$default = SystemServiceExtensions.createPartialWakeLock$default(application2, false, null, 3, null);
        this.wakeLockPartial = wakeLockCreatePartialWakeLock$default;
        if (wakeLockCreatePartialWakeLock$default != null) {
            wakeLockCreatePartialWakeLock$default.acquire(WAKELOCK_TIMEOUT);
        }
        Application application3 = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application3, "application");
        PowerManager.WakeLock wakeLockCreateProximityScreenWakeLock$default = SystemServiceExtensions.createProximityScreenWakeLock$default(application3, false, null, 3, null);
        this.wakeLockProximity = wakeLockCreateProximityScreenWakeLock$default;
        if (wakeLockCreateProximityScreenWakeLock$default != null) {
            wakeLockCreateProximityScreenWakeLock$default.acquire(WAKELOCK_TIMEOUT);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.v$default(AppLog.g, LOG_TAG, "Service destroyed.", null, 4, null);
        StageChannelNotifications.INSTANCE.getINSTANCE().onInviteToSpeakRescinded();
        AppState2.c.b(this);
        WifiManager.WifiLock wifiLock = this.wakeLockWifi;
        if (wifiLock != null) {
            wifiLock.release();
        }
        PowerManager.WakeLock wakeLock = this.wakeLockPartial;
        if (wakeLock != null) {
            wakeLock.release();
        }
        PowerManager.WakeLock wakeLock2 = this.wakeLockProximity;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onHandleIntent(Intent intent) {
        String action;
        ScreenShareManager screenShareManager;
        Intent intent2;
        ScreenShareManager screenShareManager2;
        Long l;
        String str;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(action, "intent?.action ?: return");
        Logger.v$default(AppLog.g, LOG_TAG, outline.w("Received action: ", action), null, 4, null);
        switch (action.hashCode()) {
            case -2024885008:
                if (action.equals("com.discord.utilities.voice.action.toggle_deafened")) {
                    onToggleSelfDeafen.invoke();
                    return;
                }
                return;
            case -1497102229:
                if (action.equals("com.discord.utilities.voice.action.stop")) {
                    stopForeground(true);
                    stopSelf();
                    return;
                }
                return;
            case -1440499724:
                if (action.equals("com.discord.utilities.voice.action.stage_invite_accept")) {
                    ackStageInvite(intent, true);
                    return;
                }
                return;
            case -712636972:
                if (!action.equals("com.discord.utilities.voice.action.stop_stream") || (screenShareManager = this.screenShareManager) == null) {
                    return;
                }
                screenShareManager.stopStream();
                return;
            case -702962107:
                if (action.equals("com.discord.utilities.voice.action.disconnect")) {
                    onDisconnect.invoke();
                    return;
                }
                return;
            case 162053478:
                if (!action.equals("com.discord.utilities.voice.action.start_stream") || (intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT")) == null || (screenShareManager2 = this.screenShareManager) == null) {
                    return;
                }
                screenShareManager2.startStream(intent2);
                return;
            case 541488169:
                if (action.equals("com.discord.utilities.voice.action.start_foreground")) {
                    if (intent.getBooleanExtra("com.discord.utilities.voice.extra.proximity_lock_enabled", false)) {
                        PowerManager.WakeLock wakeLock = this.wakeLockProximity;
                        if (wakeLock != null) {
                            wakeLock.acquire(WAKELOCK_TIMEOUT);
                        }
                    } else {
                        PowerManager.WakeLock wakeLock2 = this.wakeLockProximity;
                        if (wakeLock2 != null) {
                            wakeLock2.release();
                        }
                    }
                    Long l2 = (Long) intent.getSerializableExtra("com.discord.utilities.voice.extra.guild_id");
                    Long l3 = (Long) intent.getSerializableExtra("com.discord.utilities.voice.extra.channel_id");
                    if (l3 != null) {
                        this.ringManager.subscribeToStoreState(l3.longValue());
                        if (!(!Intrinsics3.areEqual(this.screenShareManager != null ? Long.valueOf(r0.getChannelId()) : null, l3))) {
                            if (!(!Intrinsics3.areEqual(this.screenShareManager != null ? r0.getGuildId() : null, l2))) {
                                l = l3;
                                str = "com.discord.utilities.voice.action.toggle_muted";
                            }
                        }
                        ScreenShareManager screenShareManager3 = this.screenShareManager;
                        if (screenShareManager3 != null) {
                            screenShareManager3.release();
                        }
                        l = l3;
                        str = "com.discord.utilities.voice.action.toggle_muted";
                        this.screenShareManager = new ScreenShareManager(this, l3.longValue(), l2, null, null, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
                    }
                    startForeground(101, VoiceEngineNotificationBuilder.INSTANCE.buildNotification(this, "com.discord.utilities.voice.action.main", "com.discord.utilities.voice.action.disconnect", "com.discord.utilities.voice.action.stop_stream", intent.getBooleanExtra("com.discord.utilities.voice.extra.item_can_speak", true) ? str : null, "com.discord.utilities.voice.action.toggle_deafened", VoiceEngineForegroundService.class, NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS, l != null ? l.longValue() : 0L, intent.getCharSequenceExtra("com.discord.utilities.voice.extra.title"), intent.getCharSequenceExtra("com.discord.utilities.voice.extra.title_subtext"), AppActivity.Main.class, intent.getBooleanExtra("com.discord.utilities.voice.extra.item_streaming", false), intent.getBooleanExtra("com.discord.utilities.voice.extra.item_muted", false), intent.getBooleanExtra("com.discord.utilities.voice.extra.item_deafened", false)));
                    return;
                }
                break;
            case 1014152586:
                if (action.equals("com.discord.utilities.voice.action.stage_invite_decline")) {
                    ackStageInvite(intent, false);
                    break;
                }
                break;
            case 1602537513:
                if (action.equals("com.discord.utilities.voice.action.toggle_muted")) {
                    onToggleSelfMute.invoke();
                    break;
                }
                break;
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        getUnsubscribeSignal().onNext(null);
        return super.onUnbind(intent);
    }
}
