package com.discord.utilities.uri;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.NotificationCompat;
import b.a.a.g.WidgetMaskedLinksDialog;
import b.a.h.CustomTabs;
import b.a.h.CustomTabsPackages;
import b.a.h.CustomTabsPackages2;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.R;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.LayoutUnhandledUriBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.color.ColorCompat;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.guild_role_subscriptions.RoleSubscriptionsLinkingUtil;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.media.WidgetMedia;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.user.WidgetUserMentions;
import com.google.android.material.button.MaterialButton;
import d0.e0.KClass;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* compiled from: UriHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JM\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017JI\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJE\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001f¨\u0006$"}, d2 = {"Lcom/discord/utilities/uri/UriHandler;", "", "Landroid/content/Context;", "context", "", "url", "mask", "", "handleOrUntrusted", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "packageName", "source", "directToPlayStore", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "handleUriSpecialCase", "(Landroid/content/Context;Landroid/net/Uri;)Z", "forceExternal", "preventCustomTab", "Lkotlin/Function0;", "onFailure", "openUrl", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;)V", "openUrlExternally", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "showUnhandledUrlDialog", "(Landroid/content/Context;Ljava/lang/String;)V", "handle", "(Landroid/content/Context;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;)V", "URL_PLAY_STORE_DIRECT", "Ljava/lang/String;", "URL_PLAY_STORE_ALT", "APP_PACKAGE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UriHandler {
    private static final String APP_PACKAGE = "com.discord";
    public static final UriHandler INSTANCE = new UriHandler();
    private static final String URL_PLAY_STORE_ALT = "https://play.google.com/store/apps/details";
    private static final String URL_PLAY_STORE_DIRECT = "market://details";

    /* compiled from: UriHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "invoke", "(Ljava/lang/String;)Ljava/lang/String;", "createFullUriString"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.uri.UriHandler$directToPlayStore$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, String> {
        public final /* synthetic */ String $packageName;
        public final /* synthetic */ String $source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2) {
            super(1);
            this.$packageName = str;
            this.$source = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String str) {
            return invoke2(str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_ID, this.$packageName);
            StringBuilder sbU = outline.U("utm_source=");
            sbU.append(this.$source);
            String string = builderAppendQueryParameter.appendQueryParameter(Constants.REFERRER, sbU.toString()).build().toString();
            Intrinsics3.checkNotNullExpressionValue(string, "Uri.parse(uri).buildUpon…ild()\n        .toString()");
            return string;
        }
    }

    /* compiled from: UriHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.uri.UriHandler$directToPlayStore$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass1 $createFullUriString$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, AnonymousClass1 anonymousClass1) {
            super(0);
            this.$context = context;
            this.$createFullUriString$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            UriHandler.handle$default(UriHandler.INSTANCE, this.$context, this.$createFullUriString$1.invoke2(UriHandler.URL_PLAY_STORE_ALT), false, false, null, 28, null);
        }
    }

    /* compiled from: UriHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/content/pm/ResolveInfo;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Landroid/content/pm/ResolveInfo;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.uri.UriHandler$openUrlExternally$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ResolveInfo, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(ResolveInfo resolveInfo) {
            return invoke2(resolveInfo);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(ResolveInfo resolveInfo) {
            return resolveInfo.activityInfo.packageName;
        }
    }

    /* compiled from: UriHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.uri.UriHandler$openUrlExternally$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return !Intrinsics3.areEqual(str, this.$context.getPackageName());
        }
    }

    private UriHandler() {
    }

    public static final /* synthetic */ void access$openUrlExternally(UriHandler uriHandler, Context context, Uri uri, String str, boolean z2, Function0 function0) {
        uriHandler.openUrlExternally(context, uri, str, z2, function0);
    }

    public static final void directToPlayStore(Context context) {
        directToPlayStore$default(context, null, null, 6, null);
    }

    public static final void directToPlayStore(Context context, String str) {
        directToPlayStore$default(context, str, null, 4, null);
    }

    public static final void directToPlayStore(Context context, String packageName, String source) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(packageName, "packageName");
        Intrinsics3.checkNotNullParameter(source, "source");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(packageName, source);
        handle$default(INSTANCE, context, anonymousClass1.invoke2(URL_PLAY_STORE_DIRECT), false, false, new AnonymousClass2(context, anonymousClass1), 12, null);
    }

    public static /* synthetic */ void directToPlayStore$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "com.discord";
        }
        if ((i & 4) != 0) {
            str2 = "discord";
        }
        directToPlayStore(context, str, str2);
    }

    public static /* synthetic */ void handle$default(UriHandler uriHandler, Context context, String str, boolean z2, boolean z3, Function0 function0, int i, Object obj) {
        boolean z4 = (i & 4) != 0 ? false : z2;
        boolean z5 = (i & 8) != 0 ? false : z3;
        if ((i & 16) != 0) {
            function0 = null;
        }
        uriHandler.handle(context, str, z4, z5, function0);
    }

    public static final void handleOrUntrusted(Context context, String url, String mask) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(url, "url");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (companion.getMaskedLinks().isTrustedDomain(url, mask)) {
            handle$default(INSTANCE, context, url, false, false, null, 28, null);
        } else {
            Objects.requireNonNull(WidgetMaskedLinksDialog.INSTANCE);
            companion.getNotices().requestToShow(new StoreNotices.Notice("WIDGET_SPOOPY_LINKS_DIALOG", null, 0L, 0, false, Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetHome.class), Reflection2.getOrCreateKotlinClass(WidgetUserMentions.class), Reflection2.getOrCreateKotlinClass(WidgetSearch.class), Reflection2.getOrCreateKotlinClass(WidgetChannelPinnedMessages.class), Reflection2.getOrCreateKotlinClass(WidgetMedia.class)}), 0L, false, 0L, new UriHandler3(url), Opcodes.I2F, null));
        }
    }

    public static /* synthetic */ void handleOrUntrusted$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        handleOrUntrusted(context, str, str2);
    }

    private final boolean handleUriSpecialCase(Context context, Uri uri) {
        return RoleSubscriptionsLinkingUtil.INSTANCE.tryPerformHandoff(context, uri);
    }

    private final void openUrl(Context context, Uri uri, String url, boolean forceExternal, boolean preventCustomTab, Function0<Unit> onFailure) {
        if (!(!preventCustomTab && StoreStream.INSTANCE.getUserSettings().getIsChromeCustomTabsEnabled())) {
            openUrlExternally(context, uri, url, forceExternal, onFailure);
            return;
        }
        AppTransitionActivity.j = true;
        int themedColor = ColorCompat.getThemedColor(context, R.attr.colorPrimary);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(context, uri, url, forceExternal, onFailure);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(anonymousClass1, "onFailure");
        String strA = forceExternal ? CustomTabsPackages2.a.a(context, new CustomTabs(context)) : CustomTabsPackages2.a.a(context, CustomTabsPackages.j);
        if (strA == null) {
            anonymousClass1.invoke();
            return;
        }
        CustomTabColorSchemeParams customTabColorSchemeParamsBuild = new CustomTabColorSchemeParams.Builder().setNavigationBarColor(themedColor).setToolbarColor(themedColor).setSecondaryToolbarColor(themedColor).build();
        Intrinsics3.checkNotNullExpressionValue(customTabColorSchemeParamsBuild, "CustomTabColorSchemePara…Color)\n          .build()");
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().setDefaultColorSchemeParams(customTabColorSchemeParamsBuild).setShowTitle(false).setStartAnimations(context, R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_open_out).setExitAnimations(context, R.anim.activity_slide_horizontal_close_in, R.anim.activity_slide_horizontal_close_out).build();
        Intrinsics3.checkNotNullExpressionValue(customTabsIntentBuild, "CustomTabsIntent.Builder…ResId)\n          .build()");
        if (forceExternal) {
            try {
                Intent intent = customTabsIntentBuild.intent;
                Intrinsics3.checkNotNullExpressionValue(intent, "customTabsIntent.intent");
                intent.setPackage(strA);
            } catch (ActivityNotFoundException unused) {
                anonymousClass1.invoke();
                return;
            }
        }
        Intent intent2 = customTabsIntentBuild.intent;
        Intrinsics3.checkNotNullExpressionValue(intent2, "customTabsIntent.intent");
        intent2.setData(uri);
        customTabsIntentBuild.launchUrl(context, uri);
    }

    public static /* synthetic */ void openUrl$default(UriHandler uriHandler, Context context, Uri uri, String str, boolean z2, boolean z3, Function0 function0, int i, Object obj) {
        uriHandler.openUrl(context, uri, str, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? null : function0);
    }

    private final void openUrlExternally(Context context, Uri uri, String url, boolean forceExternal, Function0<Unit> onFailure) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (forceExternal) {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                Intrinsics3.checkNotNullExpressionValue(listQueryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
                intent.setPackage((String) _Sequences2.firstOrNull(_Sequences2.filter(_Sequences2.mapNotNull(_Collections.asSequence(listQueryIntentActivities), AnonymousClass1.INSTANCE), new AnonymousClass2(context))));
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            if ((onFailure == null || onFailure.invoke() == null) && url != null) {
                INSTANCE.showUnhandledUrlDialog(context, url);
            }
        }
    }

    public static /* synthetic */ void openUrlExternally$default(UriHandler uriHandler, Context context, Uri uri, String str, boolean z2, Function0 function0, int i, Object obj) {
        uriHandler.openUrlExternally(context, uri, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : function0);
    }

    private final void showUnhandledUrlDialog(Context context, String url) {
        AnalyticsTracker.INSTANCE.unhandledUrl(url);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_unhandled_uri, (ViewGroup) null, false);
        int i = R.id.unhandled_uri_display;
        TextView textView = (TextView) viewInflate.findViewById(R.id.unhandled_uri_display);
        if (textView != null) {
            i = R.id.unhandled_uri_okay;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.unhandled_uri_okay);
            if (materialButton != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                LayoutUnhandledUriBinding layoutUnhandledUriBinding = new LayoutUnhandledUriBinding(linearLayout, textView, materialButton);
                Intrinsics3.checkNotNullExpressionValue(layoutUnhandledUriBinding, "LayoutUnhandledUriBindin…utInflater.from(context))");
                AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(linearLayout).create();
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.unhandledUriDisplay");
                textView.setText(url);
                textView.setOnClickListener(new UriHandler2(layoutUnhandledUriBinding, url));
                materialButton.setOnClickListener(new UriHandler4(alertDialogCreate));
                alertDialogCreate.show();
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void handle(Context context, String url, boolean forceExternal, boolean preventCustomTab, Function0<Unit> onFailure) {
        Uri uri;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (url != null) {
            try {
                uri = Uri.parse(url);
            } catch (Exception unused) {
                uri = null;
            }
            Uri uri2 = uri;
            if (uri2 != null) {
                if (forceExternal || !handleUriSpecialCase(context, uri2)) {
                    openUrl(context, uri2, url, forceExternal, preventCustomTab, onFailure);
                }
            }
        }
    }

    /* compiled from: UriHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.uri.UriHandler$openUrl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $forceExternal;
        public final /* synthetic */ Function0 $onFailure;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, Uri uri, String str, boolean z2, Function0 function0) {
            super(0);
            this.$context = context;
            this.$uri = uri;
            this.$url = str;
            this.$forceExternal = z2;
            this.$onFailure = function0;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppTransitionActivity.j = false;
            UriHandler.access$openUrlExternally(UriHandler.INSTANCE, this.$context, this.$uri, this.$url, this.$forceExternal, this.$onFailure);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }
    }
}
