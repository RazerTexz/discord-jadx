package com.discord.widgets.channels;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionChannelCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.ViewCheckableRoleListItemThemedBinding;
import com.discord.databinding.WidgetCreateChannelBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember;
import com.discord.widgets.forums.ForumUtils;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action2;

/* compiled from: WidgetCreateChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\u00020\u0001:\u0003GHIB\u0007¢\u0006\u0004\bF\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR%\u0010%\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010)R\u0016\u0010/\u001a\u00020\u001a8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u001eR\u001c\u00101\u001a\u0002008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001d\u0010:\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001d\u0010=\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u001c\u001a\u0004\b<\u0010)R\u001d\u0010@\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u001c\u001a\u0004\b?\u0010)R!\u0010E\u001a\u00060 j\u0002`A8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u001c\u001a\u0004\bC\u0010D¨\u0006J"}, d2 = {"Lcom/discord/widgets/channels/WidgetCreateChannel;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/WidgetCreateChannel$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/channels/WidgetCreateChannel$Model;)V", "configurePrivateRoles", "()V", "", "Lcom/discord/restapi/RestAPIParams$ChannelPermissionOverwrites;", "getPermissionOverwrites", "()Ljava/util/List;", "Lcom/discord/api/channel/Channel;", "channel", "onChannelCreated", "(Lcom/discord/api/channel/Channel;)V", "finishActivity", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/channels/WidgetCreateChannel$RolesAdapter;", "rolesAdapter", "Lcom/discord/widgets/channels/WidgetCreateChannel$RolesAdapter;", "", "type$delegate", "Lkotlin/Lazy;", "getType", "()I", "type", "", "Lcom/discord/primitives/ChannelId;", "categoryId$delegate", "getCategoryId", "()Ljava/lang/Long;", "categoryId", "", "provideResultOnly$delegate", "getProvideResultOnly", "()Z", "provideResultOnly", "shouldChannelDefaultPrivate$delegate", "getShouldChannelDefaultPrivate", "shouldChannelDefaultPrivate", "getChannelType", "channelType", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/databinding/WidgetCreateChannelBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetCreateChannelBinding;", "binding", "disablePrivateSwitch$delegate", "getDisablePrivateSwitch", "disablePrivateSwitch", "disableAnnouncementChannelType$delegate", "getDisableAnnouncementChannelType", "disableAnnouncementChannelType", "Lcom/discord/primitives/GuildId;", "guildId$delegate", "getGuildId", "()J", "guildId", "<init>", "Companion", ExifInterface.TAG_MODEL, "RolesAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCreateChannel extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCreateChannel.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateChannelBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_CATEGORY_ID = "INTENT_CATEGORY_ID";
    private static final String INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE = "INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE";
    private static final String INTENT_DISABLE_PRIVATE_SWITCH = "INTENT_DISABLE_PRIVATE_SWITCH";
    private static final String INTENT_GUILD_ID = "INTENT_GUILD_ID";
    private static final String INTENT_PROVIDE_RESULT_ONLY = "INTENT_PROVIDE_RESULT_ONLY";
    private static final String INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE = "INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE";
    private static final String INTENT_TYPE = "INTENT_TYPE";
    private static final String RESULT_EXTRA_CHANNEL_ICON_RES_ID = "RESULT_EXTRA_CHANNEL_ICON_RES_ID";
    private static final String RESULT_EXTRA_CHANNEL_ID = "RESULT_EXTRA_CHANNEL_ID";
    private static final String RESULT_EXTRA_CHANNEL_NAME = "RESULT_EXTRA_CHANNEL_NAME";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: categoryId$delegate, reason: from kotlin metadata */
    private final Lazy categoryId;

    /* renamed from: disableAnnouncementChannelType$delegate, reason: from kotlin metadata */
    private final Lazy disableAnnouncementChannelType;

    /* renamed from: disablePrivateSwitch$delegate, reason: from kotlin metadata */
    private final Lazy disablePrivateSwitch;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;

    /* renamed from: provideResultOnly$delegate, reason: from kotlin metadata */
    private final Lazy provideResultOnly;
    private RolesAdapter rolesAdapter;

    /* renamed from: shouldChannelDefaultPrivate$delegate, reason: from kotlin metadata */
    private final Lazy shouldChannelDefaultPrivate;

    /* renamed from: type$delegate, reason: from kotlin metadata */
    private final Lazy type;

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\t¢\u0006\u0004\b\f\u0010\rJs\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J?\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\"\u0010\u001c\u001a\u001e\u0012\b\u0012\u00060\u0004j\u0002`\t\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010#\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010 R\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010%\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010 R\u0016\u0010&\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010'\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010 R\u0016\u0010(\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010)\u001a\u00020\u001b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010 ¨\u0006,"}, d2 = {"Lcom/discord/widgets/channels/WidgetCreateChannel$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "type", "Lcom/discord/primitives/ChannelId;", "categoryId", "", "show", "(Landroid/content/Context;JILjava/lang/Long;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "", "shouldChannelDefaultPrivate", "provideResultOnly", "disablePrivateSwitch", "disableAnnouncementChannelType", "launch", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;JILjava/lang/Long;ZZZZ)V", "Lcom/discord/app/AppFragment;", "fragment", "Lkotlin/Function3;", "", "callback", "registerForResult", "(Lcom/discord/app/AppFragment;Lkotlin/jvm/functions/Function3;)Landroidx/activity/result/ActivityResultLauncher;", WidgetCreateChannel.INTENT_CATEGORY_ID, "Ljava/lang/String;", WidgetCreateChannel.INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE, WidgetCreateChannel.INTENT_DISABLE_PRIVATE_SWITCH, WidgetCreateChannel.INTENT_GUILD_ID, WidgetCreateChannel.INTENT_PROVIDE_RESULT_ONLY, WidgetCreateChannel.INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE, WidgetCreateChannel.INTENT_TYPE, WidgetCreateChannel.RESULT_EXTRA_CHANNEL_ICON_RES_ID, WidgetCreateChannel.RESULT_EXTRA_CHANNEL_ID, WidgetCreateChannel.RESULT_EXTRA_CHANNEL_NAME, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, long j, int i, Long l, boolean z2, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
            companion.launch(context, activityResultLauncher, j, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : l, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? false : z3, (i2 & 128) != 0 ? false : z4, (i2 & 256) != 0 ? false : z5);
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, long j, int i, Long l, int i2, Object obj) {
            int i3 = (i2 & 4) != 0 ? 0 : i;
            if ((i2 & 8) != 0) {
                l = null;
            }
            companion.show(context, j, i3, l);
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, int type, Long categoryId, boolean shouldChannelDefaultPrivate, boolean provideResultOnly, boolean disablePrivateSwitch, boolean disableAnnouncementChannelType) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            AppScreen2 appScreen2 = AppScreen2.g;
            Intent intent = new Intent();
            intent.putExtra(WidgetCreateChannel.INTENT_GUILD_ID, guildId);
            intent.putExtra(WidgetCreateChannel.INTENT_TYPE, type);
            intent.putExtra(WidgetCreateChannel.INTENT_CATEGORY_ID, categoryId);
            intent.putExtra(WidgetCreateChannel.INTENT_PROVIDE_RESULT_ONLY, provideResultOnly);
            intent.putExtra(WidgetCreateChannel.INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE, shouldChannelDefaultPrivate);
            intent.putExtra(WidgetCreateChannel.INTENT_DISABLE_PRIVATE_SWITCH, disablePrivateSwitch);
            intent.putExtra(WidgetCreateChannel.INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE, disableAnnouncementChannelType);
            appScreen2.f(context, launcher, WidgetCreateChannel.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function3<? super Long, ? super String, ? super Integer, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetCreateChannel$Companion$registerForResult$1(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public final void show(Context context, long guildId, int type, Long categoryId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetCreateChannel.INTENT_GUILD_ID, guildId);
            intent.putExtra(WidgetCreateChannel.INTENT_TYPE, type);
            intent.putExtra(WidgetCreateChannel.INTENT_CATEGORY_ID, categoryId);
            AppScreen2.d(context, WidgetCreateChannel.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B=\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/channels/WidgetCreateChannel$Model;", "", "", "canCreateForumChannels", "Z", "getCanCreateForumChannels", "()Z", "", "Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "Lcom/discord/api/role/GuildRole;", "roleItems", "Ljava/util/List;", "getRoleItems", "()Ljava/util/List;", "canManageRoles", "getCanManageRoles", "canCreate", "getCanCreate", "canCreateCommunityChannels", "getCanCreateCommunityChannels", "<init>", "(ZZZZLjava/util/List;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canCreate;
        private final boolean canCreateCommunityChannels;
        private final boolean canCreateForumChannels;
        private final boolean canManageRoles;
        private final List<SingleTypePayload<GuildRole>> roleItems;

        /* compiled from: WidgetCreateChannel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/channels/WidgetCreateChannel$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "categoryId", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetCreateChannel$Model;", "get", "(JLjava/lang/Long;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, Long categoryId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableF = Observable.f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getPermissions().observePermissionsForChannel(categoryId != null ? categoryId.longValue() : 0L), companion.getGuilds().observeSortedRoles(guildId), ForumUtils.observeCanCreateForumChannels$default(ForumUtils.INSTANCE, guildId, null, null, 6, null), WidgetCreateChannel$Model$Companion$get$1.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n            .…          }\n            }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Model(boolean z2, boolean z3, boolean z4, boolean z5, List<SingleTypePayload<GuildRole>> list) {
            this.canCreateForumChannels = z2;
            this.canCreate = z3;
            this.canManageRoles = z4;
            this.canCreateCommunityChannels = z5;
            this.roleItems = list;
        }

        public final boolean getCanCreate() {
            return this.canCreate;
        }

        public final boolean getCanCreateCommunityChannels() {
            return this.canCreateCommunityChannels;
        }

        public final boolean getCanCreateForumChannels() {
            return this.canCreateForumChannels;
        }

        public final boolean getCanManageRoles() {
            return this.canManageRoles;
        }

        public final List<SingleTypePayload<GuildRole>> getRoleItems() {
            return this.roleItems;
        }

        public /* synthetic */ Model(boolean z2, boolean z3, boolean z4, boolean z5, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, z3, z4, z5, list);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0016\u001a\u0012\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R)\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00060\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/discord/widgets/channels/WidgetCreateChannel$RolesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "Lcom/discord/api/role/GuildRole;", "", "checked", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "Lcom/discord/primitives/RoleId;", "roleId", "", "onRoleClicked", "(ZIJ)V", "", "data", "setData", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", "checkedRoles", "Ljava/util/Map;", "getCheckedRoles", "()Ljava/util/Map;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "RoleListItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class RolesAdapter extends MGRecyclerAdapterSimple<SingleTypePayload<GuildRole>> {
        private final Map<Long, Integer> checkedRoles;

        /* compiled from: WidgetCreateChannel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/WidgetCreateChannel$RolesAdapter$RoleListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/WidgetCreateChannel$RolesAdapter;", "Lcom/discord/utilities/mg_recycler/SingleTypePayload;", "Lcom/discord/api/role/GuildRole;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/SingleTypePayload;)V", "Lcom/discord/databinding/ViewCheckableRoleListItemThemedBinding;", "binding", "Lcom/discord/databinding/ViewCheckableRoleListItemThemedBinding;", "adapter", "<init>", "(Lcom/discord/widgets/channels/WidgetCreateChannel$RolesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class RoleListItem extends MGRecyclerViewHolder<RolesAdapter, SingleTypePayload<GuildRole>> {
            private final ViewCheckableRoleListItemThemedBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RoleListItem(RolesAdapter rolesAdapter) {
                super(R.layout.view_checkable_role_list_item_themed, rolesAdapter);
                Intrinsics3.checkNotNullParameter(rolesAdapter, "adapter");
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                CheckedSetting checkedSetting = (CheckedSetting) view;
                ViewCheckableRoleListItemThemedBinding viewCheckableRoleListItemThemedBinding = new ViewCheckableRoleListItemThemedBinding(checkedSetting, checkedSetting);
                Intrinsics3.checkNotNullExpressionValue(viewCheckableRoleListItemThemedBinding, "ViewCheckableRoleListIte…medBinding.bind(itemView)");
                this.binding = viewCheckableRoleListItemThemedBinding;
            }

            public static final /* synthetic */ RolesAdapter access$getAdapter$p(RoleListItem roleListItem) {
                return (RolesAdapter) roleListItem.adapter;
            }

            public static final /* synthetic */ ViewCheckableRoleListItemThemedBinding access$getBinding$p(RoleListItem roleListItem) {
                return roleListItem.binding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, SingleTypePayload<GuildRole> singleTypePayload) {
                onConfigure2(i, singleTypePayload);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, SingleTypePayload<GuildRole> data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                GuildRole data2 = data.getData();
                boolean zContainsKey = ((RolesAdapter) this.adapter).getCheckedRoles().containsKey(Long.valueOf(data2.getId()));
                CheckedSetting checkedSetting = this.binding.f2180b;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.roleItemCheckedSetting");
                checkedSetting.setChecked(zContainsKey);
                this.binding.f2180b.e(new WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1(this, data2));
                this.binding.f2180b.setText(data2.getName());
                CheckedSetting checkedSetting2 = this.binding.f2180b;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.roleItemCheckedSetting");
                Context context = checkedSetting2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.roleItemCheckedSetting.context");
                checkedSetting2.setTextColor(RoleUtils.getRoleColor$default(data2, context, null, 2, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RolesAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            this.checkedRoles = new HashMap();
        }

        public static final /* synthetic */ void access$onRoleClicked(RolesAdapter rolesAdapter, boolean z2, int i, long j) {
            rolesAdapter.onRoleClicked(z2, i, j);
        }

        private final void onRoleClicked(boolean checked, int position, long roleId) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(position));
            if (checked) {
                this.checkedRoles.put(Long.valueOf(roleId), Integer.valueOf(position));
            } else {
                this.checkedRoles.remove(Long.valueOf(roleId));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (iIntValue < getPageSize()) {
                    notifyItemChanged(iIntValue);
                }
            }
        }

        public final Map<Long, Integer> getCheckedRoles() {
            return this.checkedRoles;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
        public void setData(List<SingleTypePayload<GuildRole>> data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.setData(data);
            this.checkedRoles.clear();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, SingleTypePayload<GuildRole>> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new RoleListItem(this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/MenuItem;", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {

        /* compiled from: WidgetCreateChannel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/channel/Channel;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02401 extends Lambda implements Function1<Channel, TrackNetworkMetadata2> {
            public C02401() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Channel channel) {
                return invoke2(channel);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadata2 invoke2(Channel channel) {
                List<PermissionOverwrite> listV;
                return new TrackNetworkActionChannelCreate((channel == null || (listV = channel.v()) == null) ? null : Boolean.valueOf(!listV.isEmpty()), channel != null ? Long.valueOf(channel.getType()) : null, channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Long.valueOf(channel.getParentId()) : null, Long.valueOf(WidgetCreateChannel.access$getGuildId$p(WidgetCreateChannel.this)));
            }
        }

        /* compiled from: WidgetCreateChannel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "p1", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$configureUI$1$2, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
            public AnonymousClass2(WidgetCreateChannel widgetCreateChannel) {
                super(1, widgetCreateChannel, WidgetCreateChannel.class, "onChannelCreated", "onChannelCreated(Lcom/discord/api/channel/Channel;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "p1");
                WidgetCreateChannel.access$onChannelCreated((WidgetCreateChannel) this.receiver, channel);
            }
        }

        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullParameter(menuItem, "menuItem");
            if (menuItem.getItemId() == R.id.menu_sort_channel) {
                RestAPI api = RestAPI.INSTANCE.getApi();
                long jAccess$getGuildId$p = WidgetCreateChannel.access$getGuildId$p(WidgetCreateChannel.this);
                int iAccess$getChannelType$p = WidgetCreateChannel.access$getChannelType$p(WidgetCreateChannel.this);
                TextInputLayout textInputLayout = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).f;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.createChannelNameLayout");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(api.createGuildChannel(jAccess$getGuildId$p, new RestAPIParams.CreateGuildChannel(iAccess$getChannelType$p, null, ViewExtensions.getTextOrEmpty(textInputLayout), WidgetCreateChannel.access$getCategoryId$p(WidgetCreateChannel.this), WidgetCreateChannel.access$getPermissionOverwrites(WidgetCreateChannel.this), null)), new C02401()), false, 1, null), WidgetCreateChannel.this, null, 2, null), WidgetCreateChannel.this.getClass(), WidgetCreateChannel.this.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(WidgetCreateChannel.this), 60, (Object) null);
            }
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetCreateChannel$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/channels/WidgetCreateChannel$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetCreateChannel widgetCreateChannel) {
            super(1, widgetCreateChannel, WidgetCreateChannel.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/WidgetCreateChannel$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetCreateChannel.access$configureUI((WidgetCreateChannel) this.receiver, model);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public AnonymousClass2(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).q;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelTextRadio");
            radioManager.a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public AnonymousClass3(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).t;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelVoiceRadio");
            radioManager.a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public AnonymousClass4(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).c;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelAnnouncementsRadio");
            radioManager.a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public AnonymousClass5(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).o;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelStageRadio");
            radioManager.a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public AnonymousClass6(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).e;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelForumRadio");
            radioManager.a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SwitchCompat switchCompat = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).i;
            Intrinsics3.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
            Intrinsics3.checkNotNullExpressionValue(WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).i, "binding.createChannelPrivateSwitch");
            switchCompat.setChecked(!r1.isChecked());
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    public WidgetCreateChannel() {
        super(R.layout.widget_create_channel);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCreateChannel$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetCreateChannel$guildId$2(this));
        this.type = LazyJVM.lazy(new WidgetCreateChannel$type$2(this));
        this.categoryId = LazyJVM.lazy(new WidgetCreateChannel$categoryId$2(this));
        this.provideResultOnly = LazyJVM.lazy(new WidgetCreateChannel$provideResultOnly$2(this));
        this.shouldChannelDefaultPrivate = LazyJVM.lazy(new WidgetCreateChannel$shouldChannelDefaultPrivate$2(this));
        this.disablePrivateSwitch = LazyJVM.lazy(new WidgetCreateChannel$disablePrivateSwitch$2(this));
        this.disableAnnouncementChannelType = LazyJVM.lazy(new WidgetCreateChannel$disableAnnouncementChannelType$2(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetCreateChannel$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configurePrivateRoles(WidgetCreateChannel widgetCreateChannel) {
        widgetCreateChannel.configurePrivateRoles();
    }

    public static final /* synthetic */ void access$configureUI(WidgetCreateChannel widgetCreateChannel, Model model) {
        widgetCreateChannel.configureUI(model);
    }

    public static final /* synthetic */ WidgetCreateChannelBinding access$getBinding$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getBinding();
    }

    public static final /* synthetic */ Long access$getCategoryId$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getCategoryId();
    }

    public static final /* synthetic */ int access$getChannelType$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getChannelType();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getGuildId();
    }

    public static final /* synthetic */ List access$getPermissionOverwrites(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getPermissionOverwrites();
    }

    public static final /* synthetic */ void access$onChannelCreated(WidgetCreateChannel widgetCreateChannel, Channel channel) {
        widgetCreateChannel.onChannelCreated(channel);
    }

    private final void configurePrivateRoles() {
        boolean z2 = (getChannelType() == 13 || getDisablePrivateSwitch()) ? false : true;
        SwitchCompat switchCompat = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        boolean zIsChecked = switchCompat.isChecked();
        RelativeLayout relativeLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.createChannelPrivateContainer");
        relativeLayout.setVisibility(z2 ? 0 : 8);
        View view = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.createChannelRoleDivider");
        view.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.createChannelRoleHeader");
        textView.setVisibility(z2 && zIsChecked ? 0 : 8);
        RecyclerView recyclerView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.createChannelRoleAccessRecycler");
        recyclerView.setVisibility(z2 && zIsChecked ? 0 : 8);
    }

    private final void configureUI(Model model) {
        if (model == null || !model.getCanCreate()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(getType() == 4 ? R.string.create_category : R.string.create_channel);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_channel_create, new AnonymousClass1(), null, 4, null);
        ConstraintLayout constraintLayout = getBinding().f2357b;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.createChannelAnnouncementsContainer");
        constraintLayout.setVisibility(model.getCanCreateCommunityChannels() && !getDisableAnnouncementChannelType() ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.createChannelStageContainer");
        constraintLayout2.setVisibility(model.getCanCreateCommunityChannels() && model.getCanManageRoles() ? 0 : 8);
        ConstraintLayout constraintLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.createChannelForumContainer");
        constraintLayout3.setVisibility(model.getCanCreateForumChannels() ? 0 : 8);
        RolesAdapter rolesAdapter = this.rolesAdapter;
        if (rolesAdapter != null) {
            rolesAdapter.setData(model.getRoleItems());
        }
    }

    private final void finishActivity() {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    private final WidgetCreateChannelBinding getBinding() {
        return (WidgetCreateChannelBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getCategoryId() {
        return (Long) this.categoryId.getValue();
    }

    private final int getChannelType() {
        if (getType() == 4) {
            return 4;
        }
        RadioButton radioButton = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelVoiceRadio");
        if (radioButton.isChecked()) {
            return 2;
        }
        RadioButton radioButton2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(radioButton2, "binding.createChannelAnnouncementsRadio");
        if (radioButton2.isChecked()) {
            return 5;
        }
        RadioButton radioButton3 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(radioButton3, "binding.createChannelStageRadio");
        if (radioButton3.isChecked()) {
            return 13;
        }
        RadioButton radioButton4 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(radioButton4, "binding.createChannelForumRadio");
        return radioButton4.isChecked() ? 15 : 0;
    }

    private final boolean getDisableAnnouncementChannelType() {
        return ((Boolean) this.disableAnnouncementChannelType.getValue()).booleanValue();
    }

    private final boolean getDisablePrivateSwitch() {
        return ((Boolean) this.disablePrivateSwitch.getValue()).booleanValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<RestAPIParams.ChannelPermissionOverwrites> getPermissionOverwrites() {
        Map<Long, Integer> checkedRoles;
        Set<Long> setKeySet;
        Map<Long, Integer> checkedRoles2;
        Set<Long> setKeySet2;
        if (getChannelType() != 13) {
            SwitchCompat switchCompat = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
            if (!switchCompat.isChecked()) {
                if (!getDisablePrivateSwitch() || !getShouldChannelDefaultPrivate()) {
                    return null;
                }
            }
        }
        RolesAdapter rolesAdapter = this.rolesAdapter;
        if (rolesAdapter != null && (checkedRoles2 = rolesAdapter.getCheckedRoles()) != null && (setKeySet2 = checkedRoles2.keySet()) != null && setKeySet2.contains(Long.valueOf(getGuildId()))) {
            return null;
        }
        long j = (getChannelType() == 2 || getChannelType() == 13) ? Permission.CONNECT : Permission.VIEW_CHANNEL;
        ArrayList arrayList = new ArrayList();
        arrayList.add(RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(getGuildId(), 0L, Long.valueOf(j)));
        RolesAdapter rolesAdapter2 = this.rolesAdapter;
        if (rolesAdapter2 != null && (checkedRoles = rolesAdapter2.getCheckedRoles()) != null && (setKeySet = checkedRoles.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(((Number) it.next()).longValue(), Long.valueOf(j), 0L));
            }
        }
        return arrayList;
    }

    private final boolean getProvideResultOnly() {
        return ((Boolean) this.provideResultOnly.getValue()).booleanValue();
    }

    private final boolean getShouldChannelDefaultPrivate() {
        return ((Boolean) this.shouldChannelDefaultPrivate.getValue()).booleanValue();
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    private final void onChannelCreated(Channel channel) {
        if (getProvideResultOnly()) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_CHANNEL_ID, channel.getId());
            intent.putExtra(RESULT_EXTRA_CHANNEL_NAME, ChannelUtils.c(channel));
            intent.putExtra(RESULT_EXTRA_CHANNEL_ICON_RES_ID, GuildChannelIconUtils2.guildChannelIcon(channel));
            fragmentActivityRequireActivity.setResult(-1, intent);
            finishActivity();
            return;
        }
        if (channel.getType() == 0) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean zComputeCanEditStageModerators = StageChannelUtils.computeCanEditStageModerators(companion.getPermissions(), companion.getGuilds(), companion.getUsers().getMeSnapshot().getId(), getGuildId(), channel);
        if (channel.getType() == 13 && zComputeCanEditStageModerators) {
            WidgetCreateChannelAddMember.INSTANCE.create(requireContext(), channel.getId());
        }
        finishActivity();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.createChannelRoleAccessRecycler");
        this.rolesAdapter = (RolesAdapter) companion.configure(new RolesAdapter(recyclerView));
        getBinding().k.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.createChannelRoleAccessRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        SwitchCompat switchCompat = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        switchCompat.setChecked(getShouldChannelDefaultPrivate() || getDisablePrivateSwitch());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId(), getCategoryId()), this, null, 2, null), WidgetCreateChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        RadioManager radioManager = new RadioManager(Collections2.listOf((Object[]) new RadioButton[]{getBinding().q, getBinding().t, getBinding().c, getBinding().o, getBinding().e}));
        getBinding().p.setOnClickListener(new AnonymousClass2(radioManager));
        getBinding().f2358s.setOnClickListener(new AnonymousClass3(radioManager));
        getBinding().f2357b.setOnClickListener(new AnonymousClass4(radioManager));
        getBinding().n.setOnClickListener(new AnonymousClass5(radioManager));
        getBinding().d.setOnClickListener(new AnonymousClass6(radioManager));
        int type = getType();
        if (type == 0) {
            RadioButton radioButton = getBinding().q;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelTextRadio");
            radioManager.a(radioButton);
        } else if (type == 2) {
            RadioButton radioButton2 = getBinding().t;
            Intrinsics3.checkNotNullExpressionValue(radioButton2, "binding.createChannelVoiceRadio");
            radioManager.a(radioButton2);
        } else if (type == 5) {
            RadioButton radioButton3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(radioButton3, "binding.createChannelAnnouncementsRadio");
            radioManager.a(radioButton3);
        } else if (type == 13) {
            RadioButton radioButton4 = getBinding().o;
            Intrinsics3.checkNotNullExpressionValue(radioButton4, "binding.createChannelStageRadio");
            radioManager.a(radioButton4);
        } else if (type == 15) {
            RadioButton radioButton5 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(radioButton5, "binding.createChannelForumRadio");
            radioManager.a(radioButton5);
        }
        configurePrivateRoles();
        getBinding().g.setOnClickListener(new AnonymousClass7());
        LinearLayout linearLayout = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.createChannelTypeContainer");
        linearLayout.setVisibility(getType() != 4 ? 0 : 8);
        getBinding().j.setText(getType() == 4 ? R.string.private_category : R.string.private_channel);
        getBinding().h.setText(getType() == 4 ? R.string.private_category_note : R.string.private_channel_note);
        getBinding().m.setText(getType() == 4 ? R.string.form_label_category_permissions : R.string.form_label_channel_permissions);
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.createChannelNameLayout");
        textInputLayout.setHint(getString(getType() == 4 ? R.string.category_name : R.string.form_label_channel_name));
    }
}
