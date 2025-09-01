package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.InviteSettingsRadioButtonBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetGuildInviteSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetGuildInviteSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\u00020\u0001:\u000265B\u0007¢\u0006\u0004\b4\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J3\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010$\u001a\u00020#8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00103\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00067"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteSettings;", "Lcom/discord/app/AppFragment;", "", "setOnItemSelected", "()V", "Landroid/widget/RadioGroup;", "radioGroup", "", "valueSet", "Lkotlin/Function1;", "", "", "textFactory", "createHorizontalCheckableButtons", "(Landroid/widget/RadioGroup;[ILkotlin/jvm/functions/Function1;)V", "numUses", "", "getMaxUsesString", "(I)Ljava/lang/String;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$ViewState;", "viewState", "configureUi", "(Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$ViewState;)V", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event;)V", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteSettings$ChannelsSpinnerAdapter;", "channelsSpinnerAdapter", "Lcom/discord/widgets/guilds/invite/WidgetGuildInviteSettings$ChannelsSpinnerAdapter;", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel;", "viewModel", "Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", "binding", "<init>", "Companion", "ChannelsSpinnerAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildInviteSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildInviteSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CREATED_INVITE = "EXTRA_CREATED_INVITE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ChannelsSpinnerAdapter channelsSpinnerAdapter;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018¢\u0006\u0004\b!\u0010\"J1\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u001b\u0010\u001a\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteSettings$ChannelsSpinnerAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/discord/api/channel/Channel;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "layoutId", "Landroid/view/View;", "convertView", "", "dropDownMode", "getItemView", "(IILandroid/view/View;Z)Landroid/view/View;", "", "setupViews", "(Landroid/view/View;IZ)V", "getCount", "()I", "getItem", "(I)Lcom/discord/api/channel/Channel;", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "getDropDownView", "", "newData", "setData", "([Lcom/discord/api/channel/Channel;)V", "channels", "[Lcom/discord/api/channel/Channel;", "Landroid/content/Context;", "context", "textViewResourceId", "<init>", "(Landroid/content/Context;I[Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelsSpinnerAdapter extends ArrayAdapter<Channel> {
        private Channel[] channels;

        public /* synthetic */ ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, i, (i2 & 4) != 0 ? new Channel[0] : channelArr);
        }

        private final View getItemView(int position, int layoutId, View convertView, boolean dropDownMode) {
            if (convertView == null) {
                convertView = View.inflate(getContext(), layoutId, null);
            }
            Intrinsics3.checkNotNullExpressionValue(convertView, "view");
            setupViews(convertView, position, dropDownMode);
            return convertView;
        }

        private final void setupViews(View convertView, int position, boolean dropDownMode) {
            TextView textView = (TextView) convertView.findViewById(new WidgetGuildInviteSettings2(dropDownMode).invoke2());
            Intrinsics3.checkNotNullExpressionValue(textView, "label");
            String str = String.format("#%s", Arrays.copyOf(new Object[]{ChannelUtils.c(this.channels[position])}, 1));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            textView.setText(str);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.channels.length;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return getItemView(position, R.layout.view_invite_settngs_channel_spinner_item_open, convertView, true);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int i) {
            return getItem(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return getItemView(position, R.layout.view_invite_settings_channel_spinner_item, convertView, false);
        }

        public final void setData(Channel[] newData) {
            Intrinsics3.checkNotNullParameter(newData, "newData");
            this.channels = newData;
            notifyDataSetChanged();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr) {
            super(context, i, channelArr);
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(channelArr, "channels");
            this.channels = channelArr;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Channel getItem(int position) {
            return this.channels[position];
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInviteSettings$Companion;", "", "Landroid/content/Context;", "context", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "launcher", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "", "source", "", "launch", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultLauncher;Ljava/lang/Long;JLjava/lang/String;)V", "Landroidx/fragment/app/DialogFragment;", "fragment", "Lkotlin/Function1;", "Lcom/discord/widgets/guilds/invite/GuildInvite;", "callback", "registerForResult", "(Landroidx/fragment/app/DialogFragment;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", WidgetGuildInviteSettings.EXTRA_CREATED_INVITE, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, Long channelId, long guildId, String source) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("Link Settings", source, null, 4, null);
            Intent intent = new Intent();
            if (channelId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.g.f(context, launcher, WidgetGuildInviteSettings.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(DialogFragment fragment, Function1<? super GuildInvite, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetGuildInviteSettings3(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$configureUi$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteSettings.access$getViewModel$p(WidgetGuildInviteSettings.this).saveInviteSettings();
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "checkedId", "", "onCheckedChanged", "(Landroid/widget/RadioGroup;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$configureUi$4, reason: invalid class name */
    public static final class AnonymousClass4 implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ ModelInvite.Settings $inviteSettings;

        public AnonymousClass4(ModelInvite.Settings settings) {
            this.$inviteSettings = settings;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            GuildInviteSettingsViewModel guildInviteSettingsViewModelAccess$getViewModel$p = WidgetGuildInviteSettings.access$getViewModel$p(WidgetGuildInviteSettings.this);
            ModelInvite.Settings settingsMergeMaxAge = this.$inviteSettings.mergeMaxAge(i);
            Intrinsics3.checkNotNullExpressionValue(settingsMergeMaxAge, "inviteSettings.mergeMaxAge(checkedId)");
            guildInviteSettingsViewModelAccess$getViewModel$p.updatePendingInviteSettings(settingsMergeMaxAge);
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "checkedId", "", "onCheckedChanged", "(Landroid/widget/RadioGroup;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$configureUi$8, reason: invalid class name */
    public static final class AnonymousClass8 implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ ModelInvite.Settings $inviteSettings;

        public AnonymousClass8(ModelInvite.Settings settings) {
            this.$inviteSettings = settings;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            GuildInviteSettingsViewModel guildInviteSettingsViewModelAccess$getViewModel$p = WidgetGuildInviteSettings.access$getViewModel$p(WidgetGuildInviteSettings.this);
            ModelInvite.Settings settingsMergeMaxUses = this.$inviteSettings.mergeMaxUses(i);
            Intrinsics3.checkNotNullExpressionValue(settingsMergeMaxUses, "inviteSettings.mergeMaxUses(checkedId)");
            guildInviteSettingsViewModelAccess$getViewModel$p.updatePendingInviteSettings(settingsMergeMaxUses);
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$configureUi$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite.Settings $inviteSettings;

        public AnonymousClass9(ModelInvite.Settings settings) {
            this.$inviteSettings = settings;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteSettings.access$getBinding$p(WidgetGuildInviteSettings.this).f.toggle();
            GuildInviteSettingsViewModel guildInviteSettingsViewModelAccess$getViewModel$p = WidgetGuildInviteSettings.access$getViewModel$p(WidgetGuildInviteSettings.this);
            ModelInvite.Settings settings = this.$inviteSettings;
            CheckedSetting checkedSetting = WidgetGuildInviteSettings.access$getBinding$p(WidgetGuildInviteSettings.this).f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
            ModelInvite.Settings settingsMergeTemporary = settings.mergeTemporary(checkedSetting.isChecked());
            Intrinsics3.checkNotNullExpressionValue(settingsMergeTemporary, "inviteSettings.mergeTemp…raryMembership.isChecked)");
            guildInviteSettingsViewModelAccess$getViewModel$p.updatePendingInviteSettings(settingsMergeTemporary);
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "expirationTime", "", "invoke", "(I)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, CharSequence> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharSequence invoke(int i) {
            return DurationUtils3.formatInviteExpireAfterString(WidgetGuildInviteSettings.this.requireContext(), i);
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(I)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBound$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Integer, String> {
        public AnonymousClass2(WidgetGuildInviteSettings widgetGuildInviteSettings) {
            super(1, widgetGuildInviteSettings, WidgetGuildInviteSettings.class, "getMaxUsesString", "getMaxUsesString(I)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final String invoke(int i) {
            return WidgetGuildInviteSettings.access$getMaxUsesString((WidgetGuildInviteSettings) this.receiver, i);
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildInviteSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteSettingsViewModel.ViewState viewState) {
            WidgetGuildInviteSettings widgetGuildInviteSettings = WidgetGuildInviteSettings.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            widgetGuildInviteSettings.configureUi(viewState);
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/guilds/invite/GuildInviteSettingsViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildInviteSettingsViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetGuildInviteSettings.this.handleEvent(event);
        }
    }

    /* compiled from: WidgetGuildInviteSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/discord/widgets/guilds/invite/WidgetGuildInviteSettings$setOnItemSelected$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", ModelAuditLogEntry.CHANGE_KEY_ID, "", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$setOnItemSelected$1, reason: invalid class name */
    public static final class AnonymousClass1 implements AdapterView.OnItemSelectedListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            Intrinsics3.checkNotNullParameter(view, "view");
            WidgetGuildInviteSettings.access$getViewModel$p(WidgetGuildInviteSettings.this).selectChannel(WidgetGuildInviteSettings.access$getChannelsSpinnerAdapter$p(WidgetGuildInviteSettings.this).getItem(position));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
        }
    }

    public WidgetGuildInviteSettings() {
        super(R.layout.widget_guild_invite_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteSettings4.INSTANCE, null, 2, null);
        WidgetGuildInviteSettings6 widgetGuildInviteSettings6 = new WidgetGuildInviteSettings6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildInviteSettingsViewModel.class), new WidgetGuildInviteSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteSettings6));
        this.loggingConfig = new AppLogger2(false, null, WidgetGuildInviteSettings5.INSTANCE, 3);
    }

    public static final /* synthetic */ WidgetGuildInviteSettingsBinding access$getBinding$p(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        return widgetGuildInviteSettings.getBinding();
    }

    public static final /* synthetic */ ChannelsSpinnerAdapter access$getChannelsSpinnerAdapter$p(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        ChannelsSpinnerAdapter channelsSpinnerAdapter = widgetGuildInviteSettings.channelsSpinnerAdapter;
        if (channelsSpinnerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        return channelsSpinnerAdapter;
    }

    public static final /* synthetic */ String access$getMaxUsesString(WidgetGuildInviteSettings widgetGuildInviteSettings, int i) {
        return widgetGuildInviteSettings.getMaxUsesString(i);
    }

    public static final /* synthetic */ GuildInviteSettingsViewModel access$getViewModel$p(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        return widgetGuildInviteSettings.getViewModel();
    }

    public static final /* synthetic */ void access$setChannelsSpinnerAdapter$p(WidgetGuildInviteSettings widgetGuildInviteSettings, ChannelsSpinnerAdapter channelsSpinnerAdapter) {
        widgetGuildInviteSettings.channelsSpinnerAdapter = channelsSpinnerAdapter;
    }

    @MainThread
    private final void createHorizontalCheckableButtons(RadioGroup radioGroup, int[] valueSet, Function1<? super Integer, ? extends CharSequence> textFactory) {
        if (radioGroup.getChildCount() > 0) {
            return;
        }
        boolean z2 = false;
        for (int i : valueSet) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.invite_settings_radio_button, (ViewGroup) radioGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) viewInflate;
            Intrinsics3.checkNotNullExpressionValue(new InviteSettingsRadioButtonBinding(appCompatRadioButton), "InviteSettingsRadioButto…text), radioGroup, false)");
            Intrinsics3.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
            appCompatRadioButton.setId(i);
            Intrinsics3.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
            appCompatRadioButton.setText(textFactory.invoke(Integer.valueOf(i)));
            if (!z2) {
                Intrinsics3.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
                ViewGroup.LayoutParams layoutParams = appCompatRadioButton.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
                RadioGroup.LayoutParams layoutParams2 = (RadioGroup.LayoutParams) layoutParams;
                layoutParams2.leftMargin = DimenUtils.dpToPixels(16);
                Intrinsics3.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
                appCompatRadioButton.setLayoutParams(layoutParams2);
                z2 = true;
            }
            radioGroup.addView(appCompatRadioButton);
        }
    }

    private final WidgetGuildInviteSettingsBinding getBinding() {
        return (WidgetGuildInviteSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getMaxUsesString(int numUses) {
        return numUses != 0 ? String.valueOf(numUses) : "∞";
    }

    private final GuildInviteSettingsViewModel getViewModel() {
        return (GuildInviteSettingsViewModel) this.viewModel.getValue();
    }

    private final void setOnItemSelected() {
        Spinner spinner = getBinding().f2417b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setOnItemSelectedListener(new AnonymousClass1());
    }

    public final void configureUi(GuildInviteSettingsViewModel.ViewState viewState) {
        Object obj;
        Object next;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        List<Channel> invitableChannels = viewState.getInvitableChannels();
        ChannelsSpinnerAdapter channelsSpinnerAdapter = this.channelsSpinnerAdapter;
        if (channelsSpinnerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        Object[] array = invitableChannels.toArray(new Channel[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        channelsSpinnerAdapter.setData((Channel[]) array);
        Iterator<Channel> it = invitableChannels.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Channel next2 = it.next();
            Channel targetChannel = viewState.getTargetChannel();
            if (targetChannel != null && targetChannel.getId() == next2.getId()) {
                break;
            } else {
                i++;
            }
        }
        getBinding().f2417b.setSelection(Math.max(i, 0), false);
        ModelInvite.Settings inviteSettings = viewState.getInviteSettings();
        RadioGroup radioGroup = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        Ranges2 ranges2Until = _Ranges.until(0, radioGroup.getChildCount());
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
        Iterator<Integer> it2 = ranges2Until.iterator();
        while (it2.hasNext()) {
            View childAt = getBinding().c.getChildAt(((Iterators4) it2).nextInt());
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
            arrayList.add((RadioButton) childAt);
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it3.hasNext()) {
                next = null;
                break;
            } else {
                next = it3.next();
                if (((RadioButton) next).getId() == inviteSettings.getMaxAge()) {
                    break;
                }
            }
        }
        RadioButton radioButton = (RadioButton) next;
        if (radioButton != null) {
            radioButton.setChecked(true);
        }
        getBinding().c.setOnCheckedChangeListener(new AnonymousClass4(inviteSettings));
        RadioGroup radioGroup2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        Ranges2 ranges2Until2 = _Ranges.until(0, radioGroup2.getChildCount());
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until2, 10));
        Iterator<Integer> it4 = ranges2Until2.iterator();
        while (it4.hasNext()) {
            View childAt2 = getBinding().e.getChildAt(((Iterators4) it4).nextInt());
            Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.RadioButton");
            arrayList2.add((RadioButton) childAt2);
        }
        Iterator it5 = arrayList2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next3 = it5.next();
            if (((RadioButton) next3).getId() == inviteSettings.getMaxUses()) {
                obj = next3;
                break;
            }
        }
        RadioButton radioButton2 = (RadioButton) obj;
        if (radioButton2 != null) {
            radioButton2.setChecked(true);
        }
        getBinding().e.setOnCheckedChangeListener(new AnonymousClass8(inviteSettings));
        CheckedSetting checkedSetting = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
        checkedSetting.setChecked(inviteSettings.isTemporary());
        getBinding().f.e(new AnonymousClass9(inviteSettings));
        getBinding().d.setOnClickListener(new AnonymousClass10());
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleEvent(GuildInviteSettingsViewModel.Event event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        if (!(event instanceof GuildInviteSettingsViewModel.Event.InviteCreationSuccess)) {
            if (Intrinsics3.areEqual(event, GuildInviteSettingsViewModel.Event.InviteCreationFailure.INSTANCE)) {
                AppToast.g(requireContext(), R.string.default_failure_to_perform_action_message, 0, null, 12);
            }
        } else {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_CREATED_INVITE, ((GuildInviteSettingsViewModel.Event.InviteCreationSuccess) event).getInvite());
            requireActivity().setResult(-1, intent);
            requireActivity().finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.channelsSpinnerAdapter = new ChannelsSpinnerAdapter(requireContext(), R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        Spinner spinner = getBinding().f2417b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = this.channelsSpinnerAdapter;
        if (channelsSpinnerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new AnonymousClass1());
        RadioGroup radioGroup2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new AnonymousClass2(this));
        setOnItemSelected();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildInviteSettingsViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGuildInviteSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildInviteSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
