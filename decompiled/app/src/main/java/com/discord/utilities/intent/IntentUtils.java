package com.discord.utilities.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import b.a.d.m0.RoutingPatterns;
import b.c.a.a0.AnimatableValueParser;
import b.i.c.FirebaseApp2;
import b.i.c.k.b;
import b.i.c.k.c.a;
import com.adjust.sdk.Constants;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIBuilder;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AppStartAnalyticsTracker;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.RouteHandlers;
import com.discord.utilities.logging.Logger;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.firebase.appindexing.internal.zza;
import com.google.firebase.appindexing.internal.zzc;
import d0.Tuples;
import d0.g0.Regex5;
import d0.g0.StringNumberConversions;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: IntentUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b-\u0010.J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b*\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u000f*\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\b\u0002\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u000f*\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010 \u001a\u0004\u0018\u00010\u001f*\u00020\u000f¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b%\u0010$R<\u0010+\u001a(\u0012\u0004\u0012\u00020'\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0(0&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/discord/utilities/intent/IntentUtils;", "", "Landroid/content/Context;", "context", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "chooserText", "", "performChooserSendIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;)V", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "externalize", "(Landroid/net/Uri;)Landroid/net/Uri;", "Landroid/content/Intent;", "sendText", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;", "intent", "", "isHandledSuccessfully", "notifyFirebaseUserActionStatus", "(Landroid/content/Intent;Z)V", "Lkotlin/Function2;", "callback", "consumeRoutingIntent", "(Landroid/content/Intent;Landroid/content/Context;Lkotlin/jvm/functions/Function2;)Z", "consumeExternalRoutingIntent", "(Landroid/content/Intent;Landroid/content/Context;)Z", "toExternalizedSend", "(Landroid/content/Intent;)Landroid/content/Intent;", "", "getDirectShareId", "(Landroid/content/Intent;)Ljava/lang/Long;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "isHttpDomainUrl", "(Landroid/net/Uri;)Z", "isDiscordAppUri", "", "Lkotlin/text/Regex;", "Lkotlin/Function3;", "Lkotlin/text/MatchResult;", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "pathRouterMap", "Ljava/util/Map;", "<init>", "()V", "RouteBuilders", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class IntentUtils {
    public static final IntentUtils INSTANCE = new IntentUtils();
    private static final Map<Regex, Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata>> pathRouterMap;

    /* compiled from: IntentUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002!\"B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J;\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005H\u0007¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u00020\t2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u000e\u0010\u000f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\t2\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\rJ\u0019\u0010\u0016\u001a\u00020\t2\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\rJ\u0019\u0010\u0017\u001a\u00020\t2\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0012¢\u0006\u0004\b\u0017\u0010\rJ!\u0010\u001b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001e\u0010\u001c¨\u0006#"}, d2 = {"Lcom/discord/utilities/intent/IntentUtils$RouteBuilders;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/MessageId;", "messageId", "Landroid/content/Intent;", "selectChannel", "(JJLjava/lang/Long;)Landroid/content/Intent;", "selectGuild", "(J)Landroid/content/Intent;", "Lcom/discord/primitives/GuildScheduledEventId;", "eventId", "selectExternalEvent", "(JLjava/lang/Long;)Landroid/content/Intent;", "Lcom/discord/primitives/UserId;", "userId", "selectUserProfile", "voiceChannelId", "connectVoice", "selectDirectMessage", "", "inviteText", "source", "selectInvite", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "guildTemplateText", "selectGuildTemplate", "<init>", "()V", "SDK", "Uris", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class RouteBuilders {
        public static final RouteBuilders INSTANCE = new RouteBuilders();

        /* compiled from: IntentUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/intent/IntentUtils$RouteBuilders$SDK;", "", "", Constants.DEEPLINK, "", "Lcom/discord/primitives/ApplicationId;", "applicationId", "secret", "Landroid/content/Intent;", "join", "(Ljava/lang/String;JLjava/lang/String;)Landroid/content/Intent;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class SDK {
            public static final SDK INSTANCE = new SDK();

            private SDK() {
            }

            public static final Intent join(String deeplink, long applicationId, String secret) {
                Intrinsics3.checkNotNullParameter(deeplink, Constants.DEEPLINK);
                return new Intent("com.discord.intent.action.SDK", Uri.parse(deeplink).buildUpon().appendPath("join").appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, String.valueOf(applicationId)).appendQueryParameter("secret", secret).build());
            }
        }

        /* compiled from: IntentUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0013\u0010\t\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/discord/utilities/intent/IntentUtils$RouteBuilders$Uris;", "", "Landroid/net/Uri;", "getSelectSettingsVoice", "()Landroid/net/Uri;", "selectSettingsVoice", "getApp", "app", "getOauth2Authorize", "oauth2Authorize", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uris {
            public static final Uris INSTANCE = new Uris();

            private Uris() {
            }

            public final Uri getApp() {
                Uri uri = Uri.parse("discord://app");
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app\")");
                return uri;
            }

            public final Uri getOauth2Authorize() {
                Uri uri = Uri.parse("discord://action/oauth2/authorize");
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://action/oauth2/authorize\")");
                return uri;
            }

            public final Uri getSelectSettingsVoice() {
                Uri uri = Uri.parse("discord://app/settings/voice");
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app/settings/voice\")");
                return uri;
            }
        }

        private RouteBuilders() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Long] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
        public static final Intent selectChannel(long channelId, long guildId, Long messageId) {
            Object objValueOf = (guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId);
            if (messageId == 0) {
                messageId = "";
            }
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/" + objValueOf + MentionUtils.SLASH_CHAR + channelId + MentionUtils.SLASH_CHAR + messageId));
        }

        public static /* synthetic */ Intent selectChannel$default(long j, long j2, Long l, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = 0;
            }
            if ((i & 4) != 0) {
                l = null;
            }
            return selectChannel(j, j2, l);
        }

        public static final Intent selectExternalEvent(long guildId, Long eventId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/events/" + ((guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId)) + MentionUtils.SLASH_CHAR + eventId));
        }

        public static final Intent selectGuild(long guildId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/" + ((guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId))));
        }

        public static final Intent selectUserProfile(long userId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/users/" + userId));
        }

        public final Intent connectVoice(long voiceChannelId) {
            return new Intent("com.discord.intent.action.CONNECT", Uri.parse("discord://app/connect/" + voiceChannelId));
        }

        public final Intent selectDirectMessage(long userId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/@me/user/" + userId));
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Intent selectGuildTemplate(String guildTemplateText, String source) {
            Uri uri = Uri.parse(guildTemplateText);
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (uri.getScheme() == null) {
                if (guildTemplateText != null) {
                    RoutingPatterns routingPatterns = RoutingPatterns.G;
                    if (StringsJVM.startsWith$default(guildTemplateText, RoutingPatterns.e, false, 2, null)) {
                        uri = Uri.parse("https://" + guildTemplateText);
                    } else {
                        uri = Uri.parse("discord://app/template/" + guildTemplateText + "?source=" + source);
                    }
                }
            }
            Intent data = new Intent().setData(uri);
            Intrinsics3.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
            return data;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Intent selectInvite(String inviteText, String source) {
            Uri uri = Uri.parse(inviteText);
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (uri.getScheme() == null) {
                if (inviteText != null) {
                    RoutingPatterns routingPatterns = RoutingPatterns.G;
                    if (StringsJVM.startsWith$default(inviteText, RoutingPatterns.d, false, 2, null)) {
                        uri = Uri.parse("https://" + inviteText);
                    } else {
                        uri = Uri.parse("discord://app/invite/" + inviteText + "?source=" + source);
                    }
                }
            }
            Intent data = new Intent().setData(uri);
            Intrinsics3.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
            return data;
        }
    }

    /* compiled from: IntentUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "uriRoutable", "", "invoke", "(Landroid/net/Uri;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.intent.IntentUtils$consumeExternalRoutingIntent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Uri, Boolean, Unit> {
        public final /* synthetic */ Intent $intent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Intent intent) {
            super(2);
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
            invoke(uri, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(Uri uri, boolean z2) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Map<String, Object> mapBuildTrackingData = NotificationClient.INSTANCE.buildTrackingData(this.$intent);
            Iterator<T> it = mapBuildTrackingData.keySet().iterator();
            while (it.hasNext()) {
                this.$intent.removeExtra((String) it.next());
            }
            AnalyticsTracker.appNotificationClicked(mapBuildTrackingData);
            AppStartAnalyticsTracker.INSTANCE.getInstance().appOpen(uri, z2, !mapBuildTrackingData.isEmpty());
        }
    }

    /* compiled from: IntentUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/net/Uri;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke", "(Landroid/net/Uri;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.intent.IntentUtils$consumeRoutingIntent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Uri, Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
            invoke(uri, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(Uri uri, boolean z2) {
            Intrinsics3.checkNotNullParameter(uri, "<anonymous parameter 0>");
        }
    }

    static {
        RoutingPatterns routingPatterns = RoutingPatterns.G;
        Regex regex = RoutingPatterns.F;
        RouteHandlers routeHandlers = RouteHandlers.INSTANCE;
        pathRouterMap = Maps6.mapOf(Tuples.to(RoutingPatterns.t, IntentUtils$pathRouterMap$1.INSTANCE), Tuples.to(RoutingPatterns.u, IntentUtils$pathRouterMap$2.INSTANCE), Tuples.to(regex, new IntentUtils$pathRouterMap$3(routeHandlers)), Tuples.to(RoutingPatterns.v, new IntentUtils$pathRouterMap$4(routeHandlers)), Tuples.to(RoutingPatterns.f62x, new IntentUtils$pathRouterMap$5(routeHandlers)), Tuples.to(RoutingPatterns.f63y, new IntentUtils$pathRouterMap$6(routeHandlers)), Tuples.to(RoutingPatterns.f64z, new IntentUtils$pathRouterMap$7(routeHandlers)), Tuples.to(RoutingPatterns.A, new IntentUtils$pathRouterMap$8(routeHandlers)), Tuples.to(RoutingPatterns.f61s, new IntentUtils$pathRouterMap$9(routeHandlers)), Tuples.to(RoutingPatterns.w, new IntentUtils$pathRouterMap$10(routeHandlers)), Tuples.to(RoutingPatterns.C, new IntentUtils$pathRouterMap$11(routeHandlers)), Tuples.to(RoutingPatterns.D, new IntentUtils$pathRouterMap$12(routeHandlers)), Tuples.to(RoutingPatterns.E, new IntentUtils$pathRouterMap$13(routeHandlers)), Tuples.to(RoutingPatterns.B, new IntentUtils$pathRouterMap$14(routeHandlers)), Tuples.to(RoutingPatterns.m, new IntentUtils$pathRouterMap$15(routeHandlers)));
    }

    private IntentUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean consumeRoutingIntent$default(IntentUtils intentUtils, Intent intent, Context context, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = AnonymousClass1.INSTANCE;
        }
        return intentUtils.consumeRoutingIntent(intent, context, function2);
    }

    private final Uri externalize(Uri uri) {
        Uri.Builder builderScheme = uri.buildUpon().scheme(Constants.SCHEME);
        RoutingPatterns routingPatterns = RoutingPatterns.G;
        return builderScheme.authority(RoutingPatterns.a).build();
    }

    private final void notifyFirebaseUserActionStatus(Intent intent, boolean isHandledSuccessfully) {
        String stringExtra = intent.getStringExtra("actions.fulfillment.extra.ACTION_TOKEN");
        if (stringExtra != null) {
            Intrinsics3.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(In…A_VOICE_ACTION) ?: return");
            String str = isHandledSuccessfully ? "http://schema.org/CompletedActionStatus" : "http://schema.org/FailedActionStatus";
            a aVar = new a();
            aVar.f = stringExtra;
            aVar.e = str;
            AnimatableValueParser.z(stringExtra, "setActionToken is required before calling build().");
            AnimatableValueParser.z(new String(aVar.e), "setActionStatus is required before calling build().");
            aVar.a("actionToken", aVar.f);
            b bVar = null;
            if ((aVar.c == null ? null : new String(aVar.c)) == null) {
                aVar.c = "AssistAction";
                aVar.a(ModelAuditLogEntry.CHANGE_KEY_NAME, "AssistAction");
            }
            if ((aVar.d == null ? null : new String(aVar.d)) == null) {
                String strValueOf = String.valueOf(aVar.f);
                String strConcat = strValueOf.length() != 0 ? "https://developers.google.com/actions?invocation=".concat(strValueOf) : new String("https://developers.google.com/actions?invocation=");
                Objects.requireNonNull(strConcat, "null reference");
                aVar.d = strConcat;
                aVar.a("url", strConcat);
            }
            AnimatableValueParser.z(aVar.c, "setObject is required before calling build().");
            AnimatableValueParser.z(aVar.d, "setObject is required before calling build().");
            zza zzaVar = new zza(aVar.f1660b, aVar.c, aVar.d, null, new zzc(true), aVar.e, aVar.a);
            synchronized (b.class) {
                WeakReference<b> weakReference = b.a;
                if (weakReference != null) {
                    bVar = weakReference.get();
                }
                if (bVar == null) {
                    FirebaseApp2 firebaseApp2B = FirebaseApp2.b();
                    firebaseApp2B.a();
                    bVar = new b.i.c.k.d.b(firebaseApp2B.d);
                    b.a = new WeakReference<>(bVar);
                }
            }
            bVar.a(zzaVar);
        }
    }

    public static final void performChooserSendIntent(Context context, String str) {
        performChooserSendIntent$default(context, str, null, 4, null);
    }

    public static final void performChooserSendIntent(Context context, String text, CharSequence chooserText) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(chooserText, "chooserText");
        context.startActivity(Intent.createChooser(INSTANCE.sendText(new Intent("android.intent.action.SEND"), text), chooserText));
    }

    public static /* synthetic */ void performChooserSendIntent$default(Context context, String str, CharSequence charSequence, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence = context.getString(R.string.share);
            Intrinsics3.checkNotNullExpressionValue(charSequence, "context.getString(R.string.share)");
        }
        performChooserSendIntent(context, str, charSequence);
    }

    private final Intent sendText(Intent intent, String str) {
        intent.setAction("android.intent.action.SEND");
        intent.setType(RestAPIBuilder.CONTENT_TYPE_TEXT);
        if (str == null) {
            str = "";
        }
        intent.putExtra("android.intent.extra.TEXT", str);
        return intent;
    }

    public final boolean consumeExternalRoutingIntent(Intent intent, Context context) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(context, "context");
        StoreStream.INSTANCE.getDynamicLinkCache().storeLinkIfExists(intent, context);
        return consumeRoutingIntent(intent, context, new AnonymousClass1(intent));
    }

    public final boolean consumeRoutingIntent(Intent intent, Context context, Function2<? super Uri, ? super Boolean, Unit> callback) {
        MatchResult matchResultMatchEntire;
        RouteHandlers.AnalyticsMetadata unknown;
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(callback, "callback");
        Uri data = intent.getData();
        if (data == null) {
            data = Uri.EMPTY;
        }
        Intrinsics3.checkNotNullExpressionValue(data, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        boolean z2 = isDiscordAppUri(data) || isHttpDomainUrl(data);
        callback.invoke(data, Boolean.valueOf(z2));
        if (z2) {
            AppLog appLog = AppLog.g;
            String simpleName = IntentUtils.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            String string = data.toString();
            if (string == null) {
                string = "<null>";
            }
            Intrinsics3.checkNotNullExpressionValue(string, "uri?.toString() ?: \"<null>\"");
            appLog.f(simpleName, string);
            for (Map.Entry<Regex, Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata>> entry : pathRouterMap.entrySet()) {
                Regex key = entry.getKey();
                Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> value = entry.getValue();
                String path = data.getPath();
                if (path != null) {
                    Intrinsics3.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = key.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    try {
                        unknown = value.invoke(data, matchResultMatchEntire, context);
                    } catch (Exception unused) {
                        unknown = RouteHandlers.AnalyticsMetadata.INSTANCE.getUNKNOWN();
                    }
                    intent.setData(Uri.EMPTY);
                    boolean z3 = !Intrinsics3.areEqual(unknown, RouteHandlers.AnalyticsMetadata.INSTANCE.getUNKNOWN());
                    Logger.d$default(AppLog.g, "Intent handler activated for " + data + ", consumed: " + z3, null, 2, null);
                    notifyFirebaseUserActionStatus(intent, z3);
                    StoreStream.INSTANCE.getAnalytics().deepLinkReceived(intent, unknown);
                    return z3;
                }
            }
        }
        notifyFirebaseUserActionStatus(intent, false);
        return false;
    }

    public final Long getDirectShareId(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "$this$getDirectShareId");
        String stringExtra = intent.getStringExtra(ShortcutManagerCompat.EXTRA_SHORTCUT_ID);
        if (stringExtra != null) {
            return StringNumberConversions.toLongOrNull(stringExtra);
        }
        return null;
    }

    public final boolean isDiscordAppUri(Uri uri) {
        String lowerCase;
        int iHashCode;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (StringsJVM.equals(uri.getScheme(), "discord", true)) {
            String host = uri.getHost();
            if (host != null) {
                Locale locale = Locale.ENGLISH;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                lowerCase = host.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null && ((iHashCode = lowerCase.hashCode()) == -1422950858 ? lowerCase.equals("action") : iHashCode == 96801 && lowerCase.equals("app"))) {
                return true;
            }
        }
        return false;
    }

    public final boolean isHttpDomainUrl(Uri uri) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Regex regex = new Regex("https?", Regex5.IGNORE_CASE);
        String scheme = uri.getScheme();
        if (scheme == null) {
            scheme = "";
        }
        Intrinsics3.checkNotNullExpressionValue(scheme, "uri.scheme ?: \"\"");
        if (regex.matches(scheme)) {
            return RoutingPatterns.G.a(uri.getHost());
        }
        return false;
    }

    public final Intent toExternalizedSend(Intent intent) {
        Uri uriExternalize;
        Intrinsics3.checkNotNullParameter(intent, "$this$toExternalizedSend");
        Uri data = intent.getData();
        if (data == null || (uriExternalize = INSTANCE.externalize(data)) == null) {
            uriExternalize = Uri.EMPTY;
        }
        intent.setData(uriExternalize);
        IntentUtils intentUtils = INSTANCE;
        Uri data2 = intent.getData();
        intentUtils.sendText(intent, data2 != null ? data2.toString() : null);
        return intent;
    }
}
