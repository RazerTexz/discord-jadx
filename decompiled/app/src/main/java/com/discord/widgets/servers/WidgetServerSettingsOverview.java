package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsOverviewAfkTimeoutBinding;
import com.discord.databinding.WidgetServerSettingsOverviewBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetServerSettingsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 N2\u00020\u0001:\u0003ONPB\u0007¢\u0006\u0004\bM\u00109J\u0015\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0019\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001aJ/\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b(\u0010'J1\u0010,\u001a\u00020\u0003*\u00020)2\b\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0001\u0010*\u001a\u00020\u001e2\b\b\u0001\u0010+\u001a\u00020\u001eH\u0002¢\u0006\u0004\b,\u0010-J\u001f\u00101\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\rH\u0016¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\rH\u0016¢\u0006\u0004\b3\u00102J\u0017\u00106\u001a\u00020\u00032\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0003H\u0016¢\u0006\u0004\b8\u00109R\u001c\u0010;\u001a\u00020:8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001d\u0010G\u001a\u00020B8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006Q"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsOverview;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;)V", "configureUpdatedGuild", "Lcom/discord/models/guild/Guild;", "guild", "configureSplashSection", "(Lcom/discord/models/guild/Guild;)V", "configureBannerSection", "configureAnimatedBannerUpsellSection", "", "guildShortName", "iconOriginal", "openAvatarPicker", "(Ljava/lang/String;Ljava/lang/String;)V", "iconUpdated", "", "stateShouldUpdate", "configureIcon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "splashOriginalUrl", "splashUpdatedUrl", "configureSplashImage", "(Ljava/lang/String;Ljava/lang/String;Z)V", "bannerOriginalUrl", "bannerUpdatedUrl", "configureBannerImage", "", "stateId", "activeRadioIndex", "isAboveNotifyAllSize", "configureRadios", "(IIZZ)V", "Lcom/discord/api/channel/Channel;", "selectedChannel", "configureAfkChannel", "(Lcom/discord/api/channel/Channel;)V", "configureSystemChannel", "Landroid/widget/TextView;", "defaultStringRes", "iconRes", "configureChannel", "(Landroid/widget/TextView;Lcom/discord/api/channel/Channel;II)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "mimeType", "onImageChosen", "(Landroid/net/Uri;Ljava/lang/String;)V", "onImageCropped", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lrx/functions/Action1;", "imageSelectedResult", "Lrx/functions/Action1;", "Lcom/discord/databinding/WidgetServerSettingsOverviewBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsOverviewBinding;", "binding", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "hasOpenedAvatarPicker", "Z", "<init>", "Companion", "AfkBottomSheet", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsOverviewBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_OPEN_AVATAR_PICKER = "INTENT_EXTRA_OPEN_AVATAR_PICKER";
    private static final String REQUEST_KEY_AFK_CHANNEL = "REQUEST_KEY_AFK_CHANNEL";
    private static final String REQUEST_KEY_SYSTEM_CHANNEL = "REQUEST_KEY_SYSTEM_CHANNEL";
    private static final int STATE_ID_NOTIFICATION_DEFAULT = 90001;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean hasOpenedAvatarPicker;
    private Action1<String> imageSelectedResult;
    private final AppLogger2 loggingConfig;
    private final StatefulViews state;

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsOverview$AfkBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", "binding", "", "Landroid/widget/TextView;", "getTimeouts", "()Ljava/util/List;", "timeouts", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AfkBottomSheet extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(AfkBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", 0)};

        /* renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        public AfkBottomSheet() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsOverview4.INSTANCE, null, 2, null);
        }

        private final WidgetServerSettingsOverviewAfkTimeoutBinding getBinding() {
            return (WidgetServerSettingsOverviewAfkTimeoutBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        private final List<TextView> getTimeouts() {
            TextView textView = getBinding().f2581b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsOverviewAfkTimeout01");
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsOverviewAfkTimeout05");
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsOverviewAfkTimeout15");
            TextView textView4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.serverSettingsOverviewAfkTimeout30");
            TextView textView5 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.serverSettingsOverviewAfkTimeout60");
            return Collections2.listOf((Object[]) new TextView[]{textView, textView2, textView3, textView4, textView5});
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return R.layout.widget_server_settings_overview_afk_timeout;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) throws NumberFormatException {
            Intrinsics3.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            Fragment parentFragment = getParentFragment();
            if (!(parentFragment instanceof WidgetServerSettingsOverview)) {
                parentFragment = null;
            }
            WidgetServerSettingsOverview widgetServerSettingsOverview = (WidgetServerSettingsOverview) parentFragment;
            if (widgetServerSettingsOverview == null) {
                dismiss();
                return;
            }
            for (TextView textView : getTimeouts()) {
                Object tag = textView.getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
                int i = Integer.parseInt((String) tag);
                Model.Companion companion = Model.INSTANCE;
                Context context = textView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                CharSequence afkTimeout = companion.getAfkTimeout(context, i);
                textView.setText(afkTimeout);
                textView.setOnClickListener(new WidgetServerSettingsOverview2(afkTimeout, i, this, widgetServerSettingsOverview));
            }
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "openAvatarPicker", "", "create", "(Landroid/content/Context;JZ)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", WidgetServerSettingsOverview.INTENT_EXTRA_OPEN_AVATAR_PICKER, WidgetServerSettingsOverview.REQUEST_KEY_AFK_CHANNEL, WidgetServerSettingsOverview.REQUEST_KEY_SYSTEM_CHANNEL, "", "STATE_ID_NOTIFICATION_DEFAULT", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, Context context, long j, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.create(context, j, z2);
        }

        public final void create(Context context, long guildId, boolean openAvatarPicker) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("OVERVIEW", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId).putExtra(WidgetServerSettingsOverview.INTENT_EXTRA_OPEN_AVATAR_PICKER, openAvatarPicker);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…PICKER, openAvatarPicker)");
            AppScreen2.d(context, WidgetServerSettingsOverview.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!BE\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001c\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0019\u0010\u000e\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\f\u001a\u0004\b\u000e\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\rR\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;", "", "Lcom/discord/api/channel/Channel;", "afkChannelModel", "Lcom/discord/api/channel/Channel;", "getAfkChannelModel", "()Lcom/discord/api/channel/Channel;", "", "approximateMemberCount", "Ljava/lang/Integer;", "", "isAboveNotifyAllSize", "Z", "()Z", "isOwner", "systemChannelModel", "getSystemChannelModel", "canManage", "getCanManage", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/guild/Guild;", "getGuild", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/user/MeUser;", "me", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "guildProfile", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Ljava/lang/Long;Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel afkChannelModel;
        private final Integer approximateMemberCount;
        private final boolean canManage;
        private final Guild guild;
        private final boolean isAboveNotifyAllSize;
        private final boolean isOwner;
        private final Channel systemChannelModel;

        /* compiled from: WidgetServerSettingsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;", "get", "(J)Lrx/Observable;", "Landroid/content/Context;", "context", "", "afkTimeout", "", "getAfkTimeout", "(Landroid/content/Context;I)Ljava/lang/CharSequence;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                Observable<R> observableY = StoreStream.INSTANCE.getGuilds().observeGuild(guildId).Y(new WidgetServerSettingsOverview5(guildId));
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public final CharSequence getAfkTimeout(Context context, int afkTimeout) {
                Intrinsics3.checkNotNullParameter(context, "context");
                if (afkTimeout == 60) {
                    Resources resources = context.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
                    return StringResourceUtils.getQuantityString(resources, context, R.plurals.duration_minutes_minutes, 1, 1);
                }
                if (afkTimeout == 300) {
                    Resources resources2 = context.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources2, "context.resources");
                    return StringResourceUtils.getQuantityString(resources2, context, R.plurals.duration_minutes_minutes, 5, 5);
                }
                if (afkTimeout == 900) {
                    Resources resources3 = context.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources3, "context.resources");
                    return StringResourceUtils.getQuantityString(resources3, context, R.plurals.duration_minutes_minutes, 15, 15);
                }
                if (afkTimeout == 1800) {
                    Resources resources4 = context.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources4, "context.resources");
                    return StringResourceUtils.getQuantityString(resources4, context, R.plurals.duration_minutes_minutes, 30, 30);
                }
                if (afkTimeout != 3600) {
                    return "";
                }
                Resources resources5 = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources5, "context.resources");
                return StringResourceUtils.getQuantityString(resources5, context, R.plurals.duration_hours_hours, 1, 1);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, MeUser meUser, Channel channel, Channel channel2, Long l, StoreGuildProfiles.GuildProfileData guildProfileData) {
            GuildPreview data;
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.guild = guild;
            this.afkChannelModel = channel;
            this.systemChannelModel = channel2;
            boolean zIsOwner = guild.isOwner(meUser.getId());
            this.isOwner = zIsOwner;
            boolean z2 = false;
            this.canManage = zIsOwner || PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
            Integer approximateMemberCount = (guildProfileData == null || (data = guildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
            this.approximateMemberCount = approximateMemberCount;
            if (approximateMemberCount != null && approximateMemberCount.intValue() > 2500) {
                z2 = true;
            }
            this.isAboveNotifyAllSize = z2;
        }

        public final Channel getAfkChannelModel() {
            return this.afkChannelModel;
        }

        public final boolean getCanManage() {
            return this.canManage;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Channel getSystemChannelModel() {
            return this.systemChannelModel;
        }

        /* renamed from: isAboveNotifyAllSize, reason: from getter */
        public final boolean getIsAboveNotifyAllSize() {
            return this.isAboveNotifyAllSize;
        }

        /* renamed from: isOwner, reason: from getter */
        public final boolean getIsOwner() {
            return this.isOwner;
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureAnimatedBannerUpsellSection$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass1(Guild guild) {
            this.$guild = guild;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.INSTANCE.create(outline.x(view, "it", "it.context"), this.$guild.getId());
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerImage$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $bannerOriginalUrl;

        /* compiled from: WidgetServerSettingsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "dataUrl", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerImage$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03111<T> implements Action1<String> {
            public C03111() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(String str) {
                call2(str);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(String str) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                WidgetServerSettingsOverview.access$configureBannerImage(WidgetServerSettingsOverview.this, anonymousClass1.$bannerOriginalUrl, str, true);
            }
        }

        /* compiled from: WidgetServerSettingsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerImage$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetServerSettingsOverview.this.openMediaChooser();
            }
        }

        public AnonymousClass1(String str) {
            this.$bannerOriginalUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.access$setImageSelectedResult$p(WidgetServerSettingsOverview.this, new C03111());
            WidgetServerSettingsOverview.this.requestMedia(new AnonymousClass2());
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerImage$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ String $bannerOriginalUrl;

        public AnonymousClass2(String str) {
            this.$bannerOriginalUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.access$configureBannerImage(WidgetServerSettingsOverview.this, this.$bannerOriginalUrl, null, true);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerSection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Guild $guild;

        /* compiled from: WidgetServerSettingsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerSection$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03121 extends Lambda implements Function1<View, Unit> {
            public C03121() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                companion.create(context, AnonymousClass1.this.$guild.getId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Guild guild) {
            super(1);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("tierStatus", new C03121());
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureBannerSection$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass2(Guild guild) {
            this.$guild = guild;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.INSTANCE.create(outline.x(view, "it", "it.context"), this.$guild.getId());
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureIcon$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $guildShortName;
        public final /* synthetic */ String $iconOriginal;

        public AnonymousClass1(String str, String str2) {
            this.$guildShortName = str;
            this.$iconOriginal = str2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.access$openAvatarPicker(WidgetServerSettingsOverview.this, this.$guildShortName, this.$iconOriginal);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureIcon$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ String $guildShortName;
        public final /* synthetic */ String $iconOriginal;

        public AnonymousClass2(String str, String str2) {
            this.$guildShortName = str;
            this.$iconOriginal = str2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.access$configureIcon(WidgetServerSettingsOverview.this, this.$guildShortName, this.$iconOriginal, null, true);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashImage$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $splashOriginalUrl;

        /* compiled from: WidgetServerSettingsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "dataUrl", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashImage$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03131<T> implements Action1<String> {
            public C03131() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(String str) {
                call2(str);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(String str) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                WidgetServerSettingsOverview.access$configureSplashImage(WidgetServerSettingsOverview.this, anonymousClass1.$splashOriginalUrl, str, true);
            }
        }

        public AnonymousClass1(String str) {
            this.$splashOriginalUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.access$setImageSelectedResult$p(WidgetServerSettingsOverview.this, new C03131());
            WidgetServerSettingsOverview.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashImage$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ String $splashOriginalUrl;

        public AnonymousClass2(String str) {
            this.$splashOriginalUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.access$configureSplashImage(WidgetServerSettingsOverview.this, this.$splashOriginalUrl, null, true);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashSection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Guild $guild;

        /* compiled from: WidgetServerSettingsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashSection$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03141 extends Lambda implements Function1<View, Unit> {
            public C03141() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                companion.create(context, AnonymousClass1.this.$guild.getId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Guild guild) {
            super(1);
            this.$guild = guild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("tierInfo", new C03141());
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureSplashSection$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass2(Guild guild) {
            this.$guild = guild;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoost.INSTANCE.create(outline.x(view, "it", "it.context"), this.$guild.getId());
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass1(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.INSTANCE.launchForVoice(WidgetServerSettingsOverview.this, this.$this_configureUI.getGuild().getId(), WidgetServerSettingsOverview.REQUEST_KEY_AFK_CHANNEL, true, R.string.no_afk_channel);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AfkBottomSheet afkBottomSheet = new AfkBottomSheet();
            FragmentManager childFragmentManager = WidgetServerSettingsOverview.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            afkBottomSheet.show(childFragmentManager, Reflection2.getOrCreateKotlinClass(AfkBottomSheet.class).toString());
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass3(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.INSTANCE.launchForText(WidgetServerSettingsOverview.this, this.$this_configureUI.getGuild().getId(), WidgetServerSettingsOverview.REQUEST_KEY_SYSTEM_CHANNEL, true, R.string.no_system_channel);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelJoin");
            Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.d, "binding.systemChannel.systemChannelJoin");
            checkedSetting.setChecked(!r1.isChecked());
            StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            CheckedSetting checkedSetting2 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelJoin");
            int id2 = checkedSetting2.getId();
            CheckedSetting checkedSetting3 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelJoin");
            statefulViewsAccess$getState$p.put(id2, Boolean.valueOf(checkedSetting3.isChecked()));
            WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this).configureSaveActionView(WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).e);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelBoost");
            Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.c, "binding.systemChannel.systemChannelBoost");
            checkedSetting.setChecked(!r1.isChecked());
            StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            CheckedSetting checkedSetting2 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelBoost");
            int id2 = checkedSetting2.getId();
            CheckedSetting checkedSetting3 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelBoost");
            statefulViewsAccess$getState$p.put(id2, Boolean.valueOf(checkedSetting3.isChecked()));
            WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this).configureSaveActionView(WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).e);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelJoinReplies");
            Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.e, "binding.systemChannel.systemChannelJoinReplies");
            checkedSetting.setChecked(!r1.isChecked());
            StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            CheckedSetting checkedSetting2 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelJoinReplies");
            int id2 = checkedSetting2.getId();
            CheckedSetting checkedSetting3 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelJoinReplies");
            statefulViewsAccess$getState$p.put(id2, Boolean.valueOf(checkedSetting3.isChecked()));
            WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this).configureSaveActionView(WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).e);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        /* compiled from: WidgetServerSettingsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/guild/Guild;", "kotlin.jvm.PlatformType", "updatedGuild", "Lrx/Observable;", "Lcom/discord/models/guild/Guild;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guild/Guild;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$7$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<com.discord.api.guild.Guild, Observable<? extends Guild>> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Guild> call(com.discord.api.guild.Guild guild) {
                return call2(guild);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Guild> call2(com.discord.api.guild.Guild guild) {
                Observable<R> observableG = StoreStream.INSTANCE.getGuilds().observeGuild(guild.getId()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
                return observableG;
            }
        }

        /* compiled from: WidgetServerSettingsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/guild/Guild;", "kotlin.jvm.PlatformType", "updatedGuild", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$7$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<Guild, Observable<? extends Model>> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Model> call(Guild guild) {
                return call2(guild);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Model> call2(Guild guild) {
                return Model.INSTANCE.get(guild.getId());
            }
        }

        /* compiled from: WidgetServerSettingsOverview.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureUI$7$3, reason: invalid class name */
        public static final class AnonymousClass3<T> implements Action1<Model> {
            public AnonymousClass3() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Model model) throws Resources.NotFoundException {
                call2(model);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Model model) throws Resources.NotFoundException {
                WidgetServerSettingsOverview.access$configureUpdatedGuild(WidgetServerSettingsOverview.this, model);
            }
        }

        public AnonymousClass7(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            CheckedSetting checkedSetting = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelJoin");
            int id2 = checkedSetting.getId();
            CheckedSetting checkedSetting2 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelJoin");
            int i = !((Boolean) statefulViewsAccess$getState$p.get(id2, Boolean.valueOf(checkedSetting2.isChecked()))).booleanValue() ? 1 : 0;
            StatefulViews statefulViewsAccess$getState$p2 = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            CheckedSetting checkedSetting3 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelJoinReplies");
            int id3 = checkedSetting3.getId();
            CheckedSetting checkedSetting4 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelJoinReplies");
            if (!((Boolean) statefulViewsAccess$getState$p2.get(id3, Boolean.valueOf(checkedSetting4.isChecked()))).booleanValue()) {
                i |= 8;
            }
            StatefulViews statefulViewsAccess$getState$p3 = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            CheckedSetting checkedSetting5 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelBoost");
            int id4 = checkedSetting5.getId();
            CheckedSetting checkedSetting6 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelBoost");
            if (!((Boolean) statefulViewsAccess$getState$p3.get(id4, Boolean.valueOf(checkedSetting6.isChecked()))).booleanValue()) {
                i |= 2;
            }
            RestAPI apiSerializeNulls = RestAPI.INSTANCE.getApiSerializeNulls();
            long id5 = this.$this_configureUI.getGuild().getId();
            StatefulViews statefulViewsAccess$getState$p4 = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            TextView textView = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).f2582b.f242b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
            Channel channel = (Channel) statefulViewsAccess$getState$p4.get(textView.getId(), this.$this_configureUI.getAfkChannelModel());
            Long lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
            StatefulViews statefulViewsAccess$getState$p5 = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            LinearLayout linearLayout = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).f2582b.e;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
            Integer num = (Integer) statefulViewsAccess$getState$p5.get(linearLayout.getId(), Integer.valueOf(this.$this_configureUI.getGuild().getAfkTimeout()));
            StatefulViews statefulViewsAccess$getState$p6 = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            TextView textView2 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).g.f153b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.systemChannel.systemChannel");
            Channel channel2 = (Channel) statefulViewsAccess$getState$p6.get(textView2.getId(), this.$this_configureUI.getSystemChannelModel());
            Long lValueOf2 = channel2 != null ? Long.valueOf(channel2.getId()) : null;
            Integer num2 = (Integer) WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this).get(WidgetServerSettingsOverview.STATE_ID_NOTIFICATION_DEFAULT, Integer.valueOf(this.$this_configureUI.getGuild().getDefaultMessageNotifications()));
            StatefulViews statefulViewsAccess$getState$p7 = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            SimpleDraweeView simpleDraweeView = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).c.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.header.serverSettingsOverviewIcon");
            String str = (String) statefulViewsAccess$getState$p7.get(simpleDraweeView.getId(), IconUtils.getForGuild$default(this.$this_configureUI.getGuild(), null, false, null, 14, null));
            StatefulViews statefulViewsAccess$getState$p8 = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            TextInputLayout textInputLayout = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).c.c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
            String str2 = (String) statefulViewsAccess$getState$p8.get(textInputLayout.getId(), this.$this_configureUI.getGuild().getName());
            GuildVerificationLevel verificationLevel = this.$this_configureUI.getGuild().getVerificationLevel();
            GuildExplicitContentFilter explicitContentFilter = this.$this_configureUI.getGuild().getExplicitContentFilter();
            StatefulViews statefulViewsAccess$getState$p9 = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            SimpleDraweeView simpleDraweeView2 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).i.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadSplash.uploadSplash");
            String str3 = (String) statefulViewsAccess$getState$p9.get(simpleDraweeView2.getId(), this.$this_configureUI.getGuild().getSplash());
            StatefulViews statefulViewsAccess$getState$p10 = WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this);
            SimpleDraweeView simpleDraweeView3 = WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).h.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadBanner.uploadBanner");
            Observable observableY = ObservableExtensionsKt.restSubscribeOn$default(apiSerializeNulls.updateGuild(id5, new RestAPIParams.UpdateGuild(lValueOf, num, lValueOf2, num2, str, str2, verificationLevel, explicitContentFilter, str3, (String) statefulViewsAccess$getState$p10.get(simpleDraweeView3.getId(), this.$this_configureUI.getGuild().getBanner()), Integer.valueOf(i), _Collections.toList(this.$this_configureUI.getGuild().getFeatures()), this.$this_configureUI.getGuild().getRulesChannelId(), this.$this_configureUI.getGuild().getPublicUpdatesChannelId(), this.$this_configureUI.getGuild().getPreferredLocale())), false, 1, null).Y(AnonymousClass1.INSTANCE).Y(AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "RestAPI\n          .apiSe…atedGuild.id)\n          }");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null), WidgetServerSettingsOverview.this, null, 2, null).k(o.i(new AnonymousClass3(), WidgetServerSettingsOverview.this));
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            Channel channel = StoreStream.INSTANCE.getChannels().getChannel(j);
            WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this).put(R.id.afk_channel, channel);
            WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this).configureSaveActionView(WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).e);
            WidgetServerSettingsOverview.access$configureAfkChannel(WidgetServerSettingsOverview.this, channel);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            Channel channel = StoreStream.INSTANCE.getChannels().getChannel(j);
            WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this).put(R.id.system_channel, channel);
            WidgetServerSettingsOverview.access$getState$p(WidgetServerSettingsOverview.this).configureSaveActionView(WidgetServerSettingsOverview.access$getBinding$p(WidgetServerSettingsOverview.this).e);
            WidgetServerSettingsOverview.access$configureSystemChannel(WidgetServerSettingsOverview.this, channel);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;", "it", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsOverview$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            WidgetServerSettingsOverview.access$configureUI(WidgetServerSettingsOverview.this, model);
        }
    }

    /* compiled from: WidgetServerSettingsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "dataUrl", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$openAvatarPicker$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<String> {
        public final /* synthetic */ String $guildShortName;
        public final /* synthetic */ String $iconOriginal;

        public AnonymousClass1(String str, String str2) {
            this.$guildShortName = str;
            this.$iconOriginal = str2;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetServerSettingsOverview.access$configureIcon(WidgetServerSettingsOverview.this, this.$guildShortName, this.$iconOriginal, str, true);
        }
    }

    public WidgetServerSettingsOverview() {
        super(R.layout.widget_server_settings_overview);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsOverview6.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.server_settings_overview_icon, R.id.overview_name, R.id.afk_channel, R.id.afk_timeout, R.id.afk_timeout_wrap, R.id.system_channel, R.id.upload_splash, R.id.upload_banner, R.id.system_channel_join, R.id.system_channel_join_replies, R.id.system_channel_boost, STATE_ID_NOTIFICATION_DEFAULT);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsOverview7.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureAfkChannel(WidgetServerSettingsOverview widgetServerSettingsOverview, Channel channel) {
        widgetServerSettingsOverview.configureAfkChannel(channel);
    }

    public static final /* synthetic */ void access$configureBannerImage(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2, boolean z2) {
        widgetServerSettingsOverview.configureBannerImage(str, str2, z2);
    }

    public static final /* synthetic */ void access$configureIcon(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2, String str3, boolean z2) {
        widgetServerSettingsOverview.configureIcon(str, str2, str3, z2);
    }

    public static final /* synthetic */ void access$configureRadios(WidgetServerSettingsOverview widgetServerSettingsOverview, int i, int i2, boolean z2, boolean z3) {
        widgetServerSettingsOverview.configureRadios(i, i2, z2, z3);
    }

    public static final /* synthetic */ void access$configureSplashImage(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2, boolean z2) {
        widgetServerSettingsOverview.configureSplashImage(str, str2, z2);
    }

    public static final /* synthetic */ void access$configureSystemChannel(WidgetServerSettingsOverview widgetServerSettingsOverview, Channel channel) {
        widgetServerSettingsOverview.configureSystemChannel(channel);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsOverview widgetServerSettingsOverview, Model model) throws Resources.NotFoundException {
        widgetServerSettingsOverview.configureUI(model);
    }

    public static final /* synthetic */ void access$configureUpdatedGuild(WidgetServerSettingsOverview widgetServerSettingsOverview, Model model) throws Resources.NotFoundException {
        widgetServerSettingsOverview.configureUpdatedGuild(model);
    }

    public static final /* synthetic */ WidgetServerSettingsOverviewBinding access$getBinding$p(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        return widgetServerSettingsOverview.getBinding();
    }

    public static final /* synthetic */ Action1 access$getImageSelectedResult$p(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        return widgetServerSettingsOverview.imageSelectedResult;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        return widgetServerSettingsOverview.state;
    }

    public static final /* synthetic */ void access$openAvatarPicker(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2) {
        widgetServerSettingsOverview.openAvatarPicker(str, str2);
    }

    public static final /* synthetic */ void access$setImageSelectedResult$p(WidgetServerSettingsOverview widgetServerSettingsOverview, Action1 action1) {
        widgetServerSettingsOverview.imageSelectedResult = action1;
    }

    private final void configureAfkChannel(Channel selectedChannel) {
        TextView textView = getBinding().f2582b.f242b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
        configureChannel(textView, selectedChannel, R.string.no_afk_channel, R.drawable.ic_channel_voice_16dp);
    }

    private final void configureAnimatedBannerUpsellSection(Guild guild) {
        int premiumTier = guild.getPremiumTier();
        Integer minimumBoostTierForGuildFeature = PremiumUtils.INSTANCE.getMinimumBoostTierForGuildFeature(GuildFeature.ANIMATED_BANNER);
        boolean z2 = premiumTier == (minimumBoostTierForGuildFeature != null ? minimumBoostTierForGuildFeature.intValue() : 0) - 1;
        boolean zCanHaveAnimatedBanner = guild.canHaveAnimatedBanner();
        LinearLayout linearLayout = getBinding().h.f167b.c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.uploadBanner.ani…atedBannerUpsellContainer");
        linearLayout.setVisibility(zCanHaveAnimatedBanner || z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().h.f167b.f160b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.uploadBanner.ani…nimatedBannerUpsellButton");
        materialButton.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().h.f167b.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadBanner.ani….animatedBannerUpsellText");
        FormatUtils.n(textView, zCanHaveAnimatedBanner ? R.string.guild_settings_animated_banner_try_it : R.string.guild_settings_animated_banner_upsell, new Object[0], null, 4);
        MaterialButton materialButton2 = getBinding().h.f167b.f160b;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.uploadBanner.ani…nimatedBannerUpsellButton");
        if (materialButton2.getVisibility() == 0) {
            getBinding().h.f167b.f160b.setOnClickListener(new AnonymousClass1(guild));
        }
    }

    private final void configureBannerImage(String bannerOriginalUrl, String bannerUpdatedUrl, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().h.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.uploadBanner.uploadBanner");
            statefulViews.put(simpleDraweeView.getId(), bannerUpdatedUrl != null ? bannerUpdatedUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().h.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadBanner.uploadBanner");
            bannerUpdatedUrl = (String) statefulViews2.get(simpleDraweeView2.getId(), bannerOriginalUrl);
        }
        getBinding().h.c.setOnClickListener(new AnonymousClass1(bannerOriginalUrl));
        SimpleDraweeView simpleDraweeView3 = getBinding().h.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadBanner.uploadBanner");
        IconUtils.setIcon$default(simpleDraweeView3, bannerUpdatedUrl, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView = getBinding().h.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadBanner.ser…verviewUploadBannerRemove");
        textView.setVisibility((bannerUpdatedUrl == null || StringsJVM.isBlank(bannerUpdatedUrl)) ^ true ? 0 : 8);
        getBinding().h.d.setOnClickListener(new AnonymousClass2(bannerOriginalUrl));
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureBannerSection(Guild guild) throws Resources.NotFoundException {
        boolean z2 = true;
        if (!guild.canHaveBanner()) {
            TextView textView = getBinding().h.h;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadBanner.uploadBannerNitroTier");
            FormatUtils.m(textView, R.string.guild_settings_overview_tier_info, new Object[]{ExifInterface.GPS_MEASUREMENT_2D, "tierStatus"}, new AnonymousClass1(guild));
            TextView textView2 = getBinding().h.h;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.uploadBanner.uploadBannerNitroTier");
            textView2.setVisibility(0);
            FloatingActionButton floatingActionButton = getBinding().h.f;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.uploadBanner.uploadBannerFab");
            ViewExtensions.setEnabledAlpha$default(floatingActionButton, false, 0.0f, 2, null);
            int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guild.getId(), 2, null, null, 12, null) - guild.getPremiumSubscriptionCount();
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.guild_settings_overview_boost_unlock_boosts, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default));
            TextView textView3 = getBinding().h.i;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.uploadBanner.uploadBannerUnlock");
            ViewExtensions.setTextAndVisibilityBy(textView3, FormatUtils.k(this, R.string.guild_settings_overview_boost_unlock, new Object[]{quantityString}, null, 4));
            TextView textView4 = getBinding().h.i;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.uploadBanner.uploadBannerUnlock");
            DrawableCompat.setCompoundDrawablesCompat$default(textView4, 0, R.drawable.ic_perk_lock, 0, 0, 13, (Object) null);
            getBinding().h.i.setTextColor(ColorCompat.getThemedColor(requireContext(), R.attr.primary_300));
            getBinding().h.e.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), R.attr.primary_630));
            getBinding().h.h.setOnClickListener(new AnonymousClass2(guild));
            return;
        }
        getBinding().h.e.setBackgroundResource(R.drawable.drawable_bg_nitro_gradient);
        TextView textView5 = getBinding().h.h;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.uploadBanner.uploadBannerNitroTier");
        textView5.setVisibility(8);
        TextView textView6 = getBinding().h.i;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.uploadBanner.uploadBannerUnlock");
        FormatUtils.n(textView6, R.string.guild_settings_overview_boost_unlocked, new Object[]{ExifInterface.GPS_MEASUREMENT_2D}, null, 4);
        TextView textView7 = getBinding().h.i;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.uploadBanner.uploadBannerUnlock");
        DrawableCompat.setCompoundDrawablesCompat$default(textView7, 0, R.drawable.ic_perk_tier_1_boosted, 0, 0, 13, (Object) null);
        getBinding().h.i.setTextColor(ColorCompat.getColor(requireContext(), R.color.white));
        TextView textView8 = getBinding().h.i;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.uploadBanner.uploadBannerUnlock");
        String banner = guild.getBanner();
        if (banner != null && banner.length() != 0) {
            z2 = false;
        }
        textView8.setVisibility(z2 ? 0 : 8);
        IconUtils iconUtils = IconUtils.INSTANCE;
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        configureBannerImage(IconUtils.getBannerForGuild$default(iconUtils, guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null, false, 4, null), null, false);
    }

    private final void configureChannel(TextView textView, Channel channel, @StringRes int i, @DrawableRes int i2) {
        CharSequence charSequenceH;
        if (channel != null) {
            charSequenceH = ChannelUtils.c(channel);
        } else {
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            charSequenceH = FormatUtils.h(context, i, new Object[0], null, 4);
        }
        textView.setText(charSequenceH);
        DrawableCompat.setCompoundDrawablesCompat$default(textView, channel == null ? 0 : i2, 0, 0, 0, 14, (Object) null);
    }

    private final void configureIcon(String guildShortName, String iconOriginal, String iconUpdated, boolean stateShouldUpdate) {
        boolean z2 = true;
        if (!this.hasOpenedAvatarPicker && getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_OPEN_AVATAR_PICKER, false)) {
            openAvatarPicker(guildShortName, iconOriginal);
        }
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.header.serverSettingsOverviewIcon");
            statefulViews.put(simpleDraweeView.getId(), iconUpdated != null ? iconUpdated : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.header.serverSettingsOverviewIcon");
            iconUpdated = (String) statefulViews2.get(simpleDraweeView2.getId(), iconOriginal);
        }
        getBinding().c.d.setOnClickListener(new AnonymousClass1(guildShortName, iconOriginal));
        SimpleDraweeView simpleDraweeView3 = getBinding().c.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.header.serverSettingsOverviewIcon");
        IconUtils.setIcon$default(simpleDraweeView3, iconUpdated, R.dimen.avatar_size_extra_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        if (iconUpdated != null && !StringsJVM.isBlank(iconUpdated)) {
            z2 = false;
        }
        TextView textView = getBinding().c.f140b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.header.iconLabel");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = getBinding().c.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.header.serverSettingsOverviewIconRemove");
        textView2.setVisibility(z2 ^ true ? 0 : 8);
        getBinding().c.e.setOnClickListener(new AnonymousClass2(guildShortName, iconOriginal));
        TextView textView3 = getBinding().c.f;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.header.serverSettingsOverviewIconText");
        textView3.setVisibility(z2 ? 0 : 8);
        TextView textView4 = getBinding().c.f;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.header.serverSettingsOverviewIconText");
        textView4.setText(guildShortName);
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureRadios(int stateId, int activeRadioIndex, boolean isAboveNotifyAllSize, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            this.state.put(stateId, Integer.valueOf(activeRadioIndex));
        }
        int i = 0;
        for (Object obj : Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().d.f147b, getBinding().d.c})) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "checkedSetting");
            checkedSetting.setChecked(i == activeRadioIndex);
            if (isAboveNotifyAllSize && checkedSetting.getId() == R.id.server_settings_overview_notification_all) {
                checkedSetting.h(FormatUtils.k(this, R.string.guild_settings_default_notifications_large_guild_notify_all, new Object[0], null, 4), false);
            } else {
                checkedSetting.h(null, false);
            }
            checkedSetting.setOnCheckedListener(new WidgetServerSettingsOverview3(i, this, activeRadioIndex, isAboveNotifyAllSize, stateId));
            i = i2;
        }
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureSplashImage(String splashOriginalUrl, String splashUpdatedUrl, boolean stateShouldUpdate) {
        if (stateShouldUpdate) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().i.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.uploadSplash.uploadSplash");
            statefulViews.put(simpleDraweeView.getId(), splashUpdatedUrl != null ? splashUpdatedUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().i.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.uploadSplash.uploadSplash");
            splashUpdatedUrl = (String) statefulViews2.get(simpleDraweeView2.getId(), splashOriginalUrl);
        }
        getBinding().i.f174b.setOnClickListener(new AnonymousClass1(splashOriginalUrl));
        SimpleDraweeView simpleDraweeView3 = getBinding().i.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.uploadSplash.uploadSplash");
        IconUtils.setIcon$default(simpleDraweeView3, splashUpdatedUrl, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView = getBinding().i.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadSplash.ser…verviewUploadSplashRemove");
        textView.setVisibility((splashUpdatedUrl == null || StringsJVM.isBlank(splashUpdatedUrl)) ^ true ? 0 : 8);
        getBinding().i.d.setOnClickListener(new AnonymousClass2(splashOriginalUrl));
        this.state.configureSaveActionView(getBinding().e);
    }

    private final void configureSplashSection(Guild guild) throws Resources.NotFoundException {
        boolean z2 = true;
        if (!guild.canHaveSplash()) {
            TextView textView = getBinding().i.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.uploadSplash.uploadSplashNitroTier");
            FormatUtils.m(textView, R.string.guild_settings_overview_tier_info, new Object[]{"1", "tierInfo"}, new AnonymousClass1(guild));
            TextView textView2 = getBinding().i.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.uploadSplash.uploadSplashNitroTier");
            textView2.setVisibility(0);
            FloatingActionButton floatingActionButton = getBinding().i.c;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.uploadSplash.ser…gsOverviewUploadSplashFab");
            ViewExtensions.setEnabledAlpha$default(floatingActionButton, false, 0.0f, 2, null);
            int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guild.getId(), 1, null, null, 12, null) - guild.getPremiumSubscriptionCount();
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.guild_settings_overview_boost_unlock_boosts, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default));
            TextView textView3 = getBinding().i.h;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.uploadSplash.uploadSplashUnlock");
            ViewExtensions.setTextAndVisibilityBy(textView3, FormatUtils.k(this, R.string.guild_settings_overview_boost_unlock, new Object[]{quantityString}, null, 4));
            TextView textView4 = getBinding().i.h;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.uploadSplash.uploadSplashUnlock");
            DrawableCompat.setCompoundDrawablesCompat$default(textView4, 0, R.drawable.ic_perk_lock, 0, 0, 13, (Object) null);
            getBinding().i.h.setTextColor(ColorCompat.getThemedColor(requireContext(), R.attr.primary_300));
            getBinding().i.e.setBackgroundColor(ColorCompat.getThemedColor(requireContext(), R.attr.primary_630));
            getBinding().i.g.setOnClickListener(new AnonymousClass2(guild));
            return;
        }
        TextView textView5 = getBinding().i.g;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.uploadSplash.uploadSplashNitroTier");
        textView5.setVisibility(8);
        getBinding().i.e.setBackgroundResource(R.drawable.drawable_bg_nitro_gradient);
        TextView textView6 = getBinding().i.h;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.uploadSplash.uploadSplashUnlock");
        FormatUtils.n(textView6, R.string.guild_settings_overview_boost_unlocked, new Object[]{"1"}, null, 4);
        TextView textView7 = getBinding().i.h;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.uploadSplash.uploadSplashUnlock");
        DrawableCompat.setCompoundDrawablesCompat$default(textView7, 0, R.drawable.ic_perk_tier_1_boosted, 0, 0, 13, (Object) null);
        getBinding().i.h.setTextColor(ColorCompat.getColor(requireContext(), R.color.white));
        TextView textView8 = getBinding().i.h;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.uploadSplash.uploadSplashUnlock");
        String splash = guild.getSplash();
        if (splash != null && splash.length() != 0) {
            z2 = false;
        }
        textView8.setVisibility(z2 ? 0 : 8);
        IconUtils iconUtils = IconUtils.INSTANCE;
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        configureSplashImage(iconUtils.getGuildSplashUrl(guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null), null, false);
    }

    private final void configureSystemChannel(Channel selectedChannel) {
        TextView textView = getBinding().g.f153b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.systemChannel.systemChannel");
        configureChannel(textView, selectedChannel, R.string.no_system_channel, R.drawable.ic_channel_text_16dp);
    }

    private final void configureUI(Model model) throws Resources.NotFoundException {
        if (model == null || !model.getCanManage()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        configureIcon(model.getGuild().getShortName(), IconUtils.getForGuild$default(model.getGuild(), null, true, null, 10, null), null, false);
        TextInputLayout textInputLayout = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.header.overviewName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), model.getGuild().getName()));
        StatefulViews statefulViews2 = this.state;
        TextView textView = getBinding().f2582b.f242b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.afk.afkChannel");
        configureAfkChannel((Channel) statefulViews2.get(textView.getId(), model.getAfkChannelModel()));
        getBinding().f2582b.c.setOnClickListener(new AnonymousClass1(model));
        TextView textView2 = getBinding().f2582b.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.afk.afkTimeout");
        StatefulViews statefulViews3 = this.state;
        TextView textView3 = getBinding().f2582b.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.afk.afkTimeout");
        textView2.setText((CharSequence) statefulViews3.get(textView3.getId(), Model.INSTANCE.getAfkTimeout(outline.I(getBinding().f2582b.d, "binding.afk.afkTimeout", "binding.afk.afkTimeout.context"), model.getGuild().getAfkTimeout())));
        getBinding().f2582b.e.setOnClickListener(new AnonymousClass2());
        LinearLayout linearLayout = getBinding().f2582b.e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
        linearLayout.setTag(Integer.valueOf(model.getGuild().getAfkTimeout()));
        StatefulViews statefulViews4 = this.state;
        TextView textView4 = getBinding().g.f153b;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.systemChannel.systemChannel");
        configureSystemChannel((Channel) statefulViews4.get(textView4.getId(), model.getSystemChannelModel()));
        getBinding().g.f.setOnClickListener(new AnonymousClass3(model));
        LinearLayout linearLayout2 = getBinding().g.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.systemChannel.systemChannelWrap");
        StatefulViews statefulViews5 = this.state;
        LinearLayout linearLayout3 = getBinding().g.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.systemChannel.systemChannelWrap");
        linearLayout2.setTag(statefulViews5.get(linearLayout3.getId(), model.getGuild().getSystemChannelId()));
        configureRadios(STATE_ID_NOTIFICATION_DEFAULT, ((Number) this.state.get(STATE_ID_NOTIFICATION_DEFAULT, Integer.valueOf(model.getGuild().getDefaultMessageNotifications()))).intValue(), model.getIsAboveNotifyAllSize(), false);
        configureSplashSection(model.getGuild());
        configureBannerSection(model.getGuild());
        configureAnimatedBannerUpsellSection(model.getGuild());
        boolean z2 = (model.getGuild().getSystemChannelFlags() & 1) == 0;
        CheckedSetting checkedSetting = getBinding().g.d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.systemChannel.systemChannelJoin");
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().g.d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.systemChannel.systemChannelJoin");
        checkedSetting.setChecked(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(z2))).booleanValue());
        if (model.getSystemChannelModel() != null) {
            getBinding().g.d.e(new AnonymousClass4());
        } else {
            CheckedSetting.d(getBinding().g.d, null, 1);
        }
        boolean z3 = (model.getGuild().getSystemChannelFlags() & 2) == 0;
        CheckedSetting checkedSetting3 = getBinding().g.c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.systemChannel.systemChannelBoost");
        StatefulViews statefulViews7 = this.state;
        CheckedSetting checkedSetting4 = getBinding().g.c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.systemChannel.systemChannelBoost");
        checkedSetting3.setChecked(((Boolean) statefulViews7.get(checkedSetting4.getId(), Boolean.valueOf(z3))).booleanValue());
        if (model.getSystemChannelModel() != null) {
            getBinding().g.c.e(new AnonymousClass5());
        } else {
            CheckedSetting.d(getBinding().g.c, null, 1);
        }
        boolean z4 = (model.getGuild().getSystemChannelFlags() & 8) == 0;
        CheckedSetting checkedSetting5 = getBinding().g.e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.systemChannel.systemChannelJoinReplies");
        StatefulViews statefulViews8 = this.state;
        CheckedSetting checkedSetting6 = getBinding().g.e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.systemChannel.systemChannelJoinReplies");
        checkedSetting5.setChecked(((Boolean) statefulViews8.get(checkedSetting6.getId(), Boolean.valueOf(z4))).booleanValue());
        if (model.getSystemChannelModel() != null) {
            getBinding().g.e.e(new AnonymousClass6());
        } else {
            CheckedSetting.d(getBinding().g.e, null, 1);
        }
        this.state.configureSaveActionView(getBinding().e);
        getBinding().e.setOnClickListener(new AnonymousClass7(model));
    }

    private final void configureUpdatedGuild(Model model) throws Resources.NotFoundException {
        StatefulViews.clear$default(this.state, false, 1, null);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        getBinding().f.fullScroll(33);
        configureUI(model);
        AppToast.i(this, R.string.server_settings_updated, 0, 4);
    }

    public static final void create(Context context, long j, boolean z2) {
        INSTANCE.create(context, j, z2);
    }

    private final WidgetServerSettingsOverviewBinding getBinding() {
        return (WidgetServerSettingsOverviewBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void openAvatarPicker(String guildShortName, String iconOriginal) {
        this.hasOpenedAvatarPicker = true;
        this.imageSelectedResult = new AnonymousClass1(guildShortName, iconOriginal);
        openMediaChooser();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.imageSelectedResult, ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.imageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().e;
        TextInputLayout textInputLayout = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.header.overviewName");
        TextView textView = getBinding().f2582b.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.afk.afkTimeout");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout, textView);
        StatefulViews statefulViews2 = this.state;
        TextView textView2 = getBinding().f2582b.f242b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.afk.afkChannel");
        TextView textView3 = getBinding().g.f153b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.systemChannel.systemChannel");
        statefulViews2.addOptionalFields(textView2, textView3);
        TextView textView4 = getBinding().c.f140b;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.header.iconLabel");
        FormatUtils.n(textView4, R.string.minimum_size, new Object[]{"128", "128"}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().i.f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.uploadSplash.uploadSplashLearnMore");
        AppHelpDesk appHelpDesk = AppHelpDesk.a;
        FormatUtils.n(linkifiedTextView, R.string.guild_settings_splash_recommend, new Object[]{appHelpDesk.a(4415841146391L, null)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = getBinding().h.g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.uploadBanner.uploadBannerLearnMore");
        FormatUtils.n(linkifiedTextView2, R.string.guild_settings_banner_recommend, new Object[]{appHelpDesk.a(360028716472L, null)}, null, 4);
        getBinding().e.hide();
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        companion.registerForResult(this, REQUEST_KEY_AFK_CHANNEL, true, new AnonymousClass1());
        companion.registerForResult(this, REQUEST_KEY_SYSTEM_CHANNEL, true, new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        setActionBarTitle(R.string.overview);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), WidgetServerSettingsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
