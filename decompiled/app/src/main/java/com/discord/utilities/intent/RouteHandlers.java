package com.discord.utilities.intent;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.a0.WidgetGiftAcceptDialog;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.intent.StaticChannelRoutes;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.guild_role_subscriptions.RoleSubscriptionsLinkingUtil;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.media.WidgetQRScanner;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.Tuples;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KFunction;
import kotlin.text.MatchResult;
import rx.Observable;

/* compiled from: RouteHandlers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ)\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\nJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\nJ'\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0011J'\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\nJ'\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\nJ'\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\nJ'\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\nJ'\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\nJ'\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\nJ'\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\nJ'\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\nJ'\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/intent/RouteHandlers;", "", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "Lkotlin/text/MatchResult;", "matchResult", "Landroid/content/Context;", "context", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "acceptGift", "(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "useInvite", "useGuildTemplate", "selectFeature", "handleQuery", "wildCardMatcher", "selectChannel", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/text/MatchResult;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "selectStaticChannel", "navigateToFriendsScreen", "selectLurk", "voiceConnect", "selectDirectMessage", "selectUserProfile", "openEventDetails", "authorize", "remoteAuth", "selectPremiumGuild", "<init>", "()V", "AnalyticsMetadata", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RouteHandlers {
    public static final RouteHandlers INSTANCE = new RouteHandlers();

    /* compiled from: RouteHandlers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\r\u0012\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R!\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR!\u0010\u000e\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Ljava/lang/Long;", "getChannelId", "()Ljava/lang/Long;", "Lcom/discord/primitives/GuildId;", "guildId", "getGuildId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AnalyticsMetadata {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final AnalyticsMetadata UNKNOWN = new AnalyticsMetadata(EnvironmentCompat.MEDIA_UNKNOWN, null, null, 6, null);
        private final Long channelId;
        private final Long guildId;
        private final String type;

        /* compiled from: RouteHandlers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata$Companion;", "", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "UNKNOWN", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "getUNKNOWN", "()Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final AnalyticsMetadata getUNKNOWN() {
                return AnalyticsMetadata.access$getUNKNOWN$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public AnalyticsMetadata(String str, Long l, Long l2) {
            Intrinsics3.checkNotNullParameter(str, "type");
            this.type = str;
            this.guildId = l;
            this.channelId = l2;
        }

        public static final /* synthetic */ AnalyticsMetadata access$getUNKNOWN$cp() {
            return UNKNOWN;
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final String getType() {
            return this.type;
        }

        public /* synthetic */ AnalyticsMetadata(String str, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StaticChannelRoutes.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            iArr[StaticChannelRoutes.ROLE_SUBSCRIPTIONS.ordinal()] = 1;
        }
    }

    /* compiled from: RouteHandlers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "ctx", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.intent.RouteHandlers$handleQuery$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public final /* synthetic */ String $query;
        public final /* synthetic */ String $queryMessageText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2) {
            super(1);
            this.$queryMessageText = str;
            this.$query = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, "ctx");
            if (this.$queryMessageText.length() > 0) {
                WidgetIncomingShare.INSTANCE.launch(fragmentActivity, this.$queryMessageText, this.$query);
            } else {
                WidgetGlobalSearchDialog.Companion companion = WidgetGlobalSearchDialog.INSTANCE;
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "ctx.supportFragmentManager");
                companion.show(supportFragmentManager, this.$query);
            }
            return true;
        }
    }

    /* compiled from: RouteHandlers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "ctx", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.intent.RouteHandlers$selectFeature$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public final /* synthetic */ Map $settingMap;
        public final /* synthetic */ String $settingsSubPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map, String str) {
            super(1);
            this.$settingMap = map;
            this.$settingsSubPath = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, "ctx");
            Function1 function1 = (Function1) this.$settingMap.get(this.$settingsSubPath);
            if (function1 == null) {
                return true;
            }
            return true;
        }
    }

    /* compiled from: RouteHandlers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.intent.RouteHandlers$voiceConnect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $isServicePermissionDeniedRedirect;
        public final /* synthetic */ WeakReference $weakContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WeakReference weakReference, long j, boolean z2) {
            super(1);
            this.$weakContext = weakReference;
            this.$channelId = j;
            this.$isServicePermissionDeniedRedirect = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Context context = (Context) this.$weakContext.get();
            if (context != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "weakContext.get() ?: return@appSubscribe");
                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                if (ChannelUtils.B(channel)) {
                    return;
                }
                StoreStream.INSTANCE.getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, context, this.$channelId, this.$isServicePermissionDeniedRedirect, null, null, 24, null);
            }
        }
    }

    /* compiled from: RouteHandlers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "input", "Lkotlin/reflect/KFunction3;", "Landroid/net/Uri;", "Lkotlin/text/MatchResult;", "Landroid/content/Context;", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "invoke", "(Ljava/lang/String;)Lkotlin/reflect/KFunction;", "getActualHandler"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, KFunction<? extends AnalyticsMetadata>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: RouteHandlers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/net/Uri;", "p1", "Lkotlin/text/MatchResult;", "p2", "Landroid/content/Context;", "p3", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "invoke", "(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1$1, reason: invalid class name and collision with other inner class name */
        public static final /* synthetic */ class C02171 extends FunctionReferenceImpl implements Function3<Uri, MatchResult, Context, AnalyticsMetadata> {
            public C02171(RouteHandlers routeHandlers) {
                super(3, routeHandlers, RouteHandlers.class, "acceptGift", "acceptGift(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
                return invoke2(uri, matchResult, context);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AnalyticsMetadata invoke2(Uri uri, MatchResult matchResult, Context context) {
                Intrinsics3.checkNotNullParameter(uri, "p1");
                Intrinsics3.checkNotNullParameter(context, "p3");
                return RouteHandlers.access$acceptGift((RouteHandlers) this.receiver, uri, matchResult, context);
            }
        }

        /* compiled from: RouteHandlers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/net/Uri;", "p1", "Lkotlin/text/MatchResult;", "p2", "Landroid/content/Context;", "p3", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "invoke", "(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1$2, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function3<Uri, MatchResult, Context, AnalyticsMetadata> {
            public AnonymousClass2(RouteHandlers routeHandlers) {
                super(3, routeHandlers, RouteHandlers.class, "useInvite", "useInvite(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
                return invoke2(uri, matchResult, context);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AnalyticsMetadata invoke2(Uri uri, MatchResult matchResult, Context context) {
                Intrinsics3.checkNotNullParameter(uri, "p1");
                Intrinsics3.checkNotNullParameter(context, "p3");
                return RouteHandlers.access$useInvite((RouteHandlers) this.receiver, uri, matchResult, context);
            }
        }

        /* compiled from: RouteHandlers.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/net/Uri;", "p1", "Lkotlin/text/MatchResult;", "p2", "Landroid/content/Context;", "p3", "Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "invoke", "(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1$3, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function3<Uri, MatchResult, Context, AnalyticsMetadata> {
            public AnonymousClass3(RouteHandlers routeHandlers) {
                super(3, routeHandlers, RouteHandlers.class, "useGuildTemplate", "useGuildTemplate(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
                return invoke2(uri, matchResult, context);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final AnalyticsMetadata invoke2(Uri uri, MatchResult matchResult, Context context) {
                Intrinsics3.checkNotNullParameter(uri, "p1");
                Intrinsics3.checkNotNullParameter(context, "p3");
                return RouteHandlers.access$useGuildTemplate((RouteHandlers) this.receiver, uri, matchResult, context);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ KFunction<? extends AnalyticsMetadata> invoke(String str) {
            return invoke2(str);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        
            if (r2.equals("discord.gg") != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
        
            if (r2.equals("gift") != false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        
            if (r2.equals("discord.new") != false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        
            if (r2.equals("invite") != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        
            if (r2.equals("template") != false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
        
            return new com.discord.utilities.intent.RouteHandlers.AnonymousClass1.C02171(com.discord.utilities.intent.RouteHandlers.INSTANCE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        
            return new com.discord.utilities.intent.RouteHandlers.AnonymousClass1.AnonymousClass2(com.discord.utilities.intent.RouteHandlers.INSTANCE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        
            return new com.discord.utilities.intent.RouteHandlers.AnonymousClass1.AnonymousClass3(com.discord.utilities.intent.RouteHandlers.INSTANCE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
        
            if (r2.equals("discord.gift") != false) goto L15;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final KFunction<AnalyticsMetadata> invoke2(String str) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1321546630:
                        break;
                    case -1183699191:
                        break;
                    case -633644578:
                        break;
                    case 3172656:
                        break;
                    case 533748962:
                        break;
                    case 1831649458:
                        break;
                }
            }
            return null;
        }
    }

    private RouteHandlers() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AnalyticsMetadata acceptGift(Uri uri, MatchResult matchResult, Context context) {
        String str;
        List<String> groupValues;
        String str2 = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) _Collections.last((List) groupValues);
        String queryParameter = uri.getQueryParameter("source");
        if (queryParameter != null) {
            Intrinsics3.checkNotNullExpressionValue(queryParameter, "it");
            str = StringsJVM.isBlank(queryParameter) ^ true ? queryParameter : null;
            if (str == null) {
                str = StoreInviteSettings.LOCATION_DEEPLINK;
            }
        }
        Intrinsics3.checkNotNullExpressionValue(str, "uri.getQueryParameter(\"s…ettings.LOCATION_DEEPLINK");
        if (str2 != null && (!StringsJVM.isBlank(str2))) {
            WidgetGiftAcceptDialog.INSTANCE.a(str2, str, 0L);
        }
        return new AnalyticsMetadata("gift", null, null, 6, null);
    }

    public static final /* synthetic */ AnalyticsMetadata access$acceptGift(RouteHandlers routeHandlers, Uri uri, MatchResult matchResult, Context context) {
        return routeHandlers.acceptGift(uri, matchResult, context);
    }

    public static final /* synthetic */ AnalyticsMetadata access$useGuildTemplate(RouteHandlers routeHandlers, Uri uri, MatchResult matchResult, Context context) {
        return routeHandlers.useGuildTemplate(uri, matchResult, context);
    }

    public static final /* synthetic */ AnalyticsMetadata access$useInvite(RouteHandlers routeHandlers, Uri uri, MatchResult matchResult, Context context) {
        return routeHandlers.useInvite(uri, matchResult, context);
    }

    private final AnalyticsMetadata useGuildTemplate(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) _Collections.last((List) groupValues);
        if (str != null) {
            StoreStream.INSTANCE.getGuildTemplates().setDynamicLinkGuildTemplateCode(str);
        }
        return new AnalyticsMetadata("guild_template", null, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AnalyticsMetadata useInvite(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) _Collections.last((List) groupValues);
        if (!(!Intrinsics3.areEqual(str, "invite"))) {
            str = null;
        }
        String queryParameter = uri.getQueryParameter("source");
        if (queryParameter != null) {
            Intrinsics3.checkNotNullExpressionValue(queryParameter, "it");
            if (!(!StringsJVM.isBlank(queryParameter))) {
                queryParameter = null;
            }
            if (queryParameter == null) {
                queryParameter = StoreInviteSettings.LOCATION_DEEPLINK;
            }
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(\"s…        ?: inviteLocation");
        String queryParameter2 = uri.getQueryParameter("event");
        Long snowflake = queryParameter2 != null ? SnowflakeUtils.INSTANCE.toSnowflake(queryParameter2) : null;
        if (str != null) {
            StoreStream.INSTANCE.getInviteSettings().setInviteCode(str, queryParameter, snowflake);
        } else {
            WidgetGuildJoin.INSTANCE.show(context, StoreInviteSettings.LOCATION_DEEPLINK);
        }
        return new AnalyticsMetadata("invite", null, null, 6, null);
    }

    public final AnalyticsMetadata authorize(Uri uri, MatchResult matchResult, Context context) {
        boolean zAreEqual;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        if (!(context instanceof Activity) || Build.VERSION.SDK_INT < 22) {
            zAreEqual = false;
        } else {
            Uri referrer = ((Activity) context).getReferrer();
            zAreEqual = Intrinsics3.areEqual(referrer != null ? referrer.getAuthority() : null, BuildConfig.APPLICATION_ID);
        }
        Uri uriBuild = uri.buildUpon().appendQueryParameter("internal_referrer", String.valueOf(zAreEqual)).build();
        StoreAuthentication authentication = StoreStream.INSTANCE.getAuthentication();
        Intrinsics3.checkNotNullExpressionValue(uriBuild, "oAuthUri");
        authentication.setOAuthUriSubject(uriBuild);
        return new AnalyticsMetadata("oauth2", null, null, 6, null);
    }

    public final AnalyticsMetadata handleQuery(Uri uri, MatchResult matchResult, Context context) {
        String str;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        String queryParameter = uri.getQueryParameter("type");
        String queryParameter2 = uri.getQueryParameter("channelName");
        String str2 = "";
        String str3 = queryParameter2 != null ? queryParameter2 : "";
        Intrinsics3.checkNotNullExpressionValue(str3, "uri.getQueryParameter(\"channelName\") ?: \"\"");
        String queryParameter3 = uri.getQueryParameter("serverName");
        if (queryParameter3 == null) {
            queryParameter3 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter3, "uri.getQueryParameter(\"serverName\") ?: \"\"");
        String queryParameter4 = uri.getQueryParameter("userName");
        if (queryParameter4 == null) {
            queryParameter4 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter4, "uri.getQueryParameter(\"userName\") ?: \"\"");
        String queryParameter5 = uri.getQueryParameter("userNameAlt");
        if (queryParameter5 == null) {
            queryParameter5 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter5, "uri.getQueryParameter(\"userNameAlt\") ?: \"\"");
        String queryParameter6 = uri.getQueryParameter("messageText");
        if (queryParameter6 == null) {
            queryParameter6 = "";
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter6, "uri.getQueryParameter(\"messageText\") ?: \"\"");
        if (queryParameter != null) {
            int iHashCode = queryParameter.hashCode();
            if (iHashCode != -905826493) {
                if (iHashCode != 3599307) {
                    if (iHashCode == 738950403 && queryParameter.equals("channel")) {
                        List listSplit$default = Strings4.split$default((CharSequence) str3, new String[]{" in "}, false, 0, 6, (Object) null);
                        String str4 = (String) (Collections2.getLastIndex(listSplit$default) >= 0 ? listSplit$default.get(0) : "");
                        String str5 = (String) (1 <= Collections2.getLastIndex(listSplit$default) ? listSplit$default.get(1) : "");
                        if (str5.length() > 0) {
                            str2 = ' ' + str5;
                        }
                        str = MentionUtils.CHANNELS_CHAR + str4 + str2;
                        StoreStream.INSTANCE.getNavigation().launchNotice("DEEPLINK_QUERY", new AnonymousClass1(queryParameter6, str));
                        return new AnalyticsMetadata("query", null, null, 6, null);
                    }
                } else if (queryParameter.equals("user")) {
                    if (!(queryParameter4.length() > 0)) {
                        queryParameter4 = queryParameter5;
                    }
                    if (queryParameter4.length() == 0) {
                        return AnalyticsMetadata.INSTANCE.getUNKNOWN();
                    }
                    str = MentionUtils.MENTIONS_CHAR + queryParameter4;
                    StoreStream.INSTANCE.getNavigation().launchNotice("DEEPLINK_QUERY", new AnonymousClass1(queryParameter6, str));
                    return new AnalyticsMetadata("query", null, null, 6, null);
                }
            } else if (queryParameter.equals("server")) {
                str = '*' + queryParameter3;
                StoreStream.INSTANCE.getNavigation().launchNotice("DEEPLINK_QUERY", new AnonymousClass1(queryParameter6, str));
                return new AnalyticsMetadata("query", null, null, 6, null);
            }
        }
        return AnalyticsMetadata.INSTANCE.getUNKNOWN();
    }

    public final AnalyticsMetadata navigateToFriendsScreen(Uri uri, MatchResult matchResult, Context context) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        StoreStream.INSTANCE.getTabsNavigation().selectTab(NavigationTab.FRIENDS, true);
        return new AnalyticsMetadata("friends", null, null, 6, null);
    }

    public final AnalyticsMetadata openEventDetails(Uri uri, MatchResult matchResult, Context context) throws NumberFormatException {
        List<String> groupValues;
        String str;
        List<String> groupValues2;
        String str2;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        long j = 0;
        long j2 = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = groupValues2.get(1)) == null) ? 0L : Long.parseLong(str2);
        if (matchResult != null && (groupValues = matchResult.getGroupValues()) != null && (str = groupValues.get(2)) != null) {
            j = Long.parseLong(str);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Guild guild = companion.getGuilds().getGuild(j2);
        Channel channel = guild == null ? companion.getChannels().getChannel(j2) : null;
        if (guild == null && channel == null) {
            WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.handleInvalidEvent(context);
        } else {
            WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.enqueue(j);
            if (guild == null) {
                guild = channel != null ? companion.getGuilds().getGuild(channel.getGuildId()) : null;
            }
            if (guild != null) {
                companion.getGuildSelected().set(guild.getId());
            }
        }
        return new AnalyticsMetadata("event", null, null, 6, null);
    }

    public final AnalyticsMetadata remoteAuth(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        if (((matchResult == null || (groupValues = matchResult.getGroupValues()) == null) ? null : (String) _Collections.last((List) groupValues)) != null) {
            WidgetQRScanner.INSTANCE.launch(context, true);
        }
        return new AnalyticsMetadata("remoteAuth", null, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AnalyticsMetadata selectChannel(Context context, Uri uri, MatchResult matchResult) {
        long jLongValue;
        List<String> groupValues;
        String str;
        Long longOrNull;
        List<String> groupValues2;
        String str2;
        Long longOrNull2;
        List<String> groupValues3;
        String str3;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (matchResult == null || (groupValues3 = matchResult.getGroupValues()) == null || (str3 = (String) _Collections.getOrNull(groupValues3, 1)) == null) {
            jLongValue = 0;
        } else {
            Long longOrNull3 = Intrinsics3.areEqual(str3, "@me") ? 0L : StringNumberConversions.toLongOrNull(str3);
            if (longOrNull3 != null) {
                jLongValue = longOrNull3.longValue();
            }
        }
        long jLongValue2 = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = (String) _Collections.getOrNull(groupValues2, 2)) == null || (longOrNull2 = StringNumberConversions.toLongOrNull(str2)) == null) ? 0L : longOrNull2.longValue();
        long jLongValue3 = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) _Collections.getOrNull(groupValues, 3)) == null || (longOrNull = StringNumberConversions.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreTabsNavigation tabsNavigation = companion.getTabsNavigation();
        if (jLongValue2 == 0 && jLongValue3 == 0 && jLongValue != 0) {
            companion.getGuildSelected().set(jLongValue);
            tabsNavigation.selectHomeTab(StoreNavigation.PanelAction.CLOSE, true);
        } else if (jLongValue3 == 0) {
            if ((companion.getChannels().findChannelById(jLongValue2) == null) && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, jLongValue, null, 2, null)) {
                ChannelSelector.INSTANCE.getInstance().findAndSetThread(context, jLongValue2);
            } else {
                ChannelSelector.INSTANCE.getInstance().findAndSet(context, jLongValue2);
            }
            tabsNavigation.selectHomeTab(StoreNavigation.PanelAction.CLOSE, true);
        } else {
            companion.getMessagesLoader().jumpToMessage(jLongValue2, jLongValue3);
        }
        return new AnalyticsMetadata("channel", Long.valueOf(jLongValue), Long.valueOf(jLongValue2));
    }

    public final AnalyticsMetadata selectDirectMessage(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Long longOrNull;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        if (matchResult != null && (groupValues = matchResult.getGroupValues()) != null && (str = (String) _Collections.last((List) groupValues)) != null && (longOrNull = StringNumberConversions.toLongOrNull(str)) != null) {
            ChannelSelector.INSTANCE.getInstance().findAndSetDirectMessage(context, longOrNull.longValue());
        }
        return new AnalyticsMetadata("DM", null, null, 6, null);
    }

    public final AnalyticsMetadata selectFeature(Uri uri, MatchResult matchResult, Context context) {
        String str;
        List<String> groupValues;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        if (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) _Collections.getOrNull(groupValues, 1)) == null) {
            str = "";
        }
        String str2 = str;
        Map mapMapOf = Maps6.mapOf(Tuples.to("/account", RouteHandlers$selectFeature$settingMap$1.INSTANCE), Tuples.to("/nitro", RouteHandlers$selectFeature$settingMap$2.INSTANCE), Tuples.to("/voice", RouteHandlers$selectFeature$settingMap$3.INSTANCE), Tuples.to("/createServer", RouteHandlers$selectFeature$settingMap$4.INSTANCE), Tuples.to("/quickSwitcher", RouteHandlers$selectFeature$settingMap$5.INSTANCE), Tuples.to("/friends", RouteHandlers$selectFeature$settingMap$6.INSTANCE), Tuples.to("/mentions", RouteHandlers$selectFeature$settingMap$7.INSTANCE), Tuples.to("/settings", RouteHandlers$selectFeature$settingMap$8.INSTANCE), Tuples.to("/contactSync", RouteHandlers$selectFeature$settingMap$9.INSTANCE), Tuples.to("/addFriends", RouteHandlers$selectFeature$settingMap$10.INSTANCE), Tuples.to("/editProfile", RouteHandlers$selectFeature$settingMap$11.INSTANCE), Tuples.to("/voiceChannel", new RouteHandlers$selectFeature$settingMap$12(uri)), Tuples.to("/xboxLinkBeta", RouteHandlers$selectFeature$settingMap$13.INSTANCE));
        StoreStream.INSTANCE.getNavigation().launchNotice(outline.w("ROUTING:", str2), new AnonymousClass1(mapMapOf, str2));
        return mapMapOf.containsKey(str2) ? new AnalyticsMetadata(str2, null, null, 6, null) : AnalyticsMetadata.INSTANCE.getUNKNOWN();
    }

    public final AnalyticsMetadata selectLurk(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        List<String> groupValues2;
        String str2;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        long j = (matchResult == null || (groupValues2 = matchResult.getGroupValues()) == null || (str2 = groupValues2.get(1)) == null) ? 0L : Long.parseLong(str2);
        Long longOrNull = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = groupValues.get(2)) == null) ? null : StringNumberConversions.toLongOrNull(str);
        StoreStream.INSTANCE.getLurking().startLurkingAndNavigate(j, longOrNull, context);
        return new AnalyticsMetadata("lurk", Long.valueOf(j), longOrNull);
    }

    public final AnalyticsMetadata selectPremiumGuild(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        long j = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = groupValues.get(1)) == null) ? 0L : Long.parseLong(str);
        if (j != 0) {
            WidgetGuildBoost.INSTANCE.create(context, j);
        }
        return new AnalyticsMetadata("guild", Long.valueOf(j), null, 4, null);
    }

    public final AnalyticsMetadata selectStaticChannel(Context context, Uri uri, MatchResult matchResult) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        StaticChannelRoutes.WithGuild withGuildExtractStaticRoute = StaticChannelRoutes.INSTANCE.extractStaticRoute(uri);
        if (withGuildExtractStaticRoute == null) {
            return AnalyticsMetadata.INSTANCE.getUNKNOWN();
        }
        StaticChannelRoutes route = withGuildExtractStaticRoute.getRoute();
        long guildId = withGuildExtractStaticRoute.getGuildId();
        if (guildId != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            if (companion.getGuilds().getGuild(guildId) != null) {
                if (route.ordinal() == 0) {
                    RoleSubscriptionsLinkingUtil.INSTANCE.handoffToGuildRoleSubscriptions(context, guildId);
                }
                companion.getTabsNavigation().selectHomeTab(StoreNavigation.PanelAction.CLOSE, true);
                return new AnalyticsMetadata("channel", Long.valueOf(guildId), null, 4, null);
            }
        }
        return new AnalyticsMetadata("channel", Long.valueOf(guildId), null, 4, null);
    }

    public final AnalyticsMetadata selectUserProfile(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        Long longOrNull = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = (String) _Collections.last((List) groupValues)) == null) ? null : StringNumberConversions.toLongOrNull(str);
        String queryParameter = uri.getQueryParameter("friend_token");
        if (longOrNull != null) {
            WidgetUserSheet.INSTANCE.enqueueNotice(longOrNull.longValue(), queryParameter);
        }
        return new AnalyticsMetadata("profile", null, null, 6, null);
    }

    public final AnalyticsMetadata voiceConnect(Uri uri, MatchResult matchResult, Context context) {
        List<String> groupValues;
        String str;
        Long longOrNull;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        long jLongValue = (matchResult == null || (groupValues = matchResult.getGroupValues()) == null || (str = groupValues.get(1)) == null || (longOrNull = StringNumberConversions.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
        boolean booleanQueryParameter = uri.getBooleanQueryParameter("service_denied", false);
        WeakReference weakReference = new WeakReference(context);
        Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(jLongValue).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null)), RouteHandlers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(weakReference, jLongValue, booleanQueryParameter), 62, (Object) null);
        return new AnalyticsMetadata("voice", null, Long.valueOf(jLongValue), 2, null);
    }

    public final AnalyticsMetadata wildCardMatcher(Uri uri, MatchResult matchResult, Context context) {
        AnalyticsMetadata analyticsMetadata;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        List<String> pathSegments = uri.getPathSegments();
        String str = pathSegments != null ? (String) _Collections.firstOrNull((List) pathSegments) : null;
        String host = uri.getHost();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        KFunction<AnalyticsMetadata> kFunctionInvoke2 = anonymousClass1.invoke2(str);
        if (kFunctionInvoke2 == null) {
            kFunctionInvoke2 = anonymousClass1.invoke2(host);
        }
        return (kFunctionInvoke2 == null || (analyticsMetadata = (AnalyticsMetadata) ((Function3) kFunctionInvoke2).invoke(uri, matchResult, context)) == null) ? AnalyticsMetadata.INSTANCE.getUNKNOWN() : analyticsMetadata;
    }
}
