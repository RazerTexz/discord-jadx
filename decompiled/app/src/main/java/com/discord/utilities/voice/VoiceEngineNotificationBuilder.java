package com.discord.utilities.voice;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.core.app.NotificationCompat;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.extensions.PendingIntentExtensions;
import com.discord.utilities.intent.IntentUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: VoiceEngineNotificationBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J/\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007*\u00020\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0097\u0001\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00052\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0012\u001a\u00020\u00052\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010 J5\u0010#\u001a\u00020\u0007*\u00020\u00022\n\u0010!\u001a\u00060\u0013j\u0002`\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00052\f\b\u0002\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineNotificationBuilder;", "", "Landroid/content/Context;", "Ljava/lang/Class;", "clazz", "", "action", "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", "getServiceActionIntent", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)Landroid/app/PendingIntent;", "context", "actionMain", "actionDisconnect", "actionStopStream", "actionToggleMuted", "actionToggleDeafened", "notificationServiceClass", "notificationChannel", "", "Lcom/discord/primitives/ChannelId;", "notificationChannelId", "", "notificationTitle", "notificationSubtitle", "notificationClass", "", "isStreaming", "isMuted", "isDeafened", "Landroid/app/Notification;", "buildNotification", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;JLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/Class;ZZZ)Landroid/app/Notification;", "voiceChannelId", "fullscreenClass", "getCallScreenNavigationIntent", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Class;)Landroid/app/PendingIntent;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VoiceEngineNotificationBuilder {
    public static final VoiceEngineNotificationBuilder INSTANCE = new VoiceEngineNotificationBuilder();

    private VoiceEngineNotificationBuilder() {
    }

    public static /* synthetic */ PendingIntent getCallScreenNavigationIntent$default(VoiceEngineNotificationBuilder voiceEngineNotificationBuilder, Context context, long j, String str, Class cls, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "com.discord.utilities.voice.action.main";
        }
        String str2 = str;
        if ((i & 4) != 0) {
            cls = AppActivity.Main.class;
        }
        return voiceEngineNotificationBuilder.getCallScreenNavigationIntent(context, j, str2, cls);
    }

    private final PendingIntent getServiceActionIntent(Context context, Class<?> cls, String str) {
        return PendingIntent.getService(context, 0, new Intent(context, cls).setAction(str), PendingIntentExtensions.immutablePendingIntentFlag$default(0, 1, null));
    }

    public final Notification buildNotification(Context context, String actionMain, String actionDisconnect, String actionStopStream, String actionToggleMuted, String actionToggleDeafened, Class<?> notificationServiceClass, String notificationChannel, long notificationChannelId, CharSequence notificationTitle, CharSequence notificationSubtitle, Class<?> notificationClass, boolean isStreaming, boolean isMuted, boolean isDeafened) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(actionMain, "actionMain");
        Intrinsics3.checkNotNullParameter(actionDisconnect, "actionDisconnect");
        Intrinsics3.checkNotNullParameter(actionStopStream, "actionStopStream");
        Intrinsics3.checkNotNullParameter(actionToggleDeafened, "actionToggleDeafened");
        Intrinsics3.checkNotNullParameter(notificationServiceClass, "notificationServiceClass");
        Intrinsics3.checkNotNullParameter(notificationChannel, "notificationChannel");
        Intrinsics3.checkNotNullParameter(notificationClass, "notificationClass");
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(context, notificationChannel).setContentTitle(notificationTitle).setContentText(notificationSubtitle).setColor(ColorCompat.getThemedColor(context, R.attr.color_brand)).setColorized(true).setSmallIcon(R.drawable.ic_notification_24dp).setContentIntent(getCallScreenNavigationIntent(context, notificationChannelId, actionMain, notificationClass)).setOngoing(true);
        String string = context.getResources().getString(R.string.disconnect_self);
        VoiceEngineNotificationBuilder voiceEngineNotificationBuilder = INSTANCE;
        ongoing.addAction(new NotificationCompat.Action(R.drawable.ic_call_disconnect_24dp, string, voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionDisconnect)));
        if (isStreaming) {
            ongoing.addAction(new NotificationCompat.Action(R.drawable.ic_mobile_screenshare_end_24dp, context.getResources().getString(R.string.stop_streaming), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionStopStream)));
        } else {
            if (actionToggleMuted != null) {
                ongoing.addAction(new NotificationCompat.Action(isMuted ? R.drawable.ic_mic_white_18dp_muted : R.drawable.ic_mic_white_18dp, isMuted ? context.getResources().getString(R.string.unmute) : context.getResources().getString(R.string.mute), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionToggleMuted)));
            }
            ongoing.addAction(new NotificationCompat.Action(isDeafened ? R.drawable.ic_headset_white_18dp_deafened : R.drawable.ic_headset_white_18dp, isDeafened ? context.getResources().getString(R.string.undeafen) : context.getResources().getString(R.string.deafen), voiceEngineNotificationBuilder.getServiceActionIntent(context, notificationServiceClass, actionToggleDeafened)));
        }
        Notification notificationBuild = ongoing.build();
        Intrinsics3.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…     }\n          .build()");
        return notificationBuild;
    }

    public final PendingIntent getCallScreenNavigationIntent(Context context, long j, String str, Class<?> cls) {
        Intrinsics3.checkNotNullParameter(context, "$this$getCallScreenNavigationIntent");
        Intrinsics3.checkNotNullParameter(str, "action");
        Intrinsics3.checkNotNullParameter(cls, "fullscreenClass");
        PendingIntent activity = PendingIntent.getActivity(context, 0, IntentUtils.RouteBuilders.INSTANCE.connectVoice(j).setClass(context, cls).setAction(str).setFlags(268468224), PendingIntentExtensions.immutablePendingIntentFlag$default(0, 1, null));
        Intrinsics3.checkNotNullExpressionValue(activity, "PendingIntent.getActivit…lePendingIntentFlag()\n  )");
        return activity;
    }
}
