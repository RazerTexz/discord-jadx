package com.discord.widgets.channels.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.WidgetChannelSettingsDeleteBinding;
import b.a.k.FormatUtils;
import b.a.y.OnSeekBarChangeListenerAdapter;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadSettingsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetThreadSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b%\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettings;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;)V", "Lcom/discord/api/channel/Channel;", "channel", "confirmDelete", "(Lcom/discord/api/channel/Channel;)V", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;)V", "", "cooldownSecs", "setSlowmodeLabel", "(I)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel;", "viewModel", "Lcom/discord/databinding/WidgetThreadSettingsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetThreadSettingsBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettings$Companion;", "", "", "channelId", "Landroid/content/Context;", "context", "", "launch", "(JLandroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            AppScreen2.d(context, WidgetThreadSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ WidgetThreadSettingsViewModel.ViewState $viewState;

        public AnonymousClass1(WidgetThreadSettingsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_channel_settings_delete) {
                return;
            }
            WidgetThreadSettings.access$confirmDelete(WidgetThreadSettings.this, ((WidgetThreadSettingsViewModel.ViewState.Valid) this.$viewState).getChannel());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/Menu;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/Menu;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public final /* synthetic */ WidgetThreadSettingsViewModel.ViewState $viewState;

        public AnonymousClass2(WidgetThreadSettingsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_channel_settings_delete);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
            menuItemFindItem.setVisible(((WidgetThreadSettingsViewModel.ViewState.Valid) this.$viewState).getCanManageThread());
            menu.findItem(R.id.menu_channel_settings_delete).setTitle(R.string.delete_thread);
            MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_channel_settings_reset);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "it.findItem(R.id.menu_channel_settings_reset)");
            menuItemFindItem2.setVisible(false);
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ WidgetThreadSettingsViewModel.ViewState $viewState;

        public AnonymousClass3(WidgetThreadSettingsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelPinnedMessages.INSTANCE.show(outline.x(view, "it", "it.context"), ((WidgetThreadSettingsViewModel.ViewState.Valid) this.$viewState).getChannel().getId());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            AppToast.g(view.getContext(), R.string.pins_disabled_nsfw, 0, null, 12);
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).saveThread();
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$confirmDelete$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass1(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$confirmDelete$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).onThreadDeleted(this.$channel.getId());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).onChannelNameInputChanged(editable.toString());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/widgets/channels/settings/WidgetThreadSettings$onViewBound$2", "Lb/a/y/j;", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends OnSeekBarChangeListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            super.onProgressChanged(seekBar, progress, fromUser);
            if (fromUser) {
                int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                WidgetThreadSettings.access$setSlowmodeLabel(WidgetThreadSettings.this, iIntValue);
                WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).onSlowModeInputChanged(iIntValue);
                TextView textView = WidgetThreadSettings.access$getBinding$p(WidgetThreadSettings.this).h;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
                seekBar.setContentDescription(textView.getText());
            }
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetThreadSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetThreadSettings.access$configureUI((WidgetThreadSettings) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetThreadSettingsViewModel.Event, Unit> {
        public AnonymousClass2(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetThreadSettings.access$handleEvent((WidgetThreadSettings) this.receiver, event);
        }
    }

    public WidgetThreadSettings() {
        super(R.layout.widget_thread_settings);
        WidgetThreadSettings3 widgetThreadSettings3 = new WidgetThreadSettings3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadSettingsViewModel.class), new WidgetThreadSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetThreadSettings3));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadSettings2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadSettings widgetThreadSettings, WidgetThreadSettingsViewModel.ViewState viewState) {
        widgetThreadSettings.configureUI(viewState);
    }

    public static final /* synthetic */ void access$confirmDelete(WidgetThreadSettings widgetThreadSettings, Channel channel) {
        widgetThreadSettings.confirmDelete(channel);
    }

    public static final /* synthetic */ WidgetThreadSettingsBinding access$getBinding$p(WidgetThreadSettings widgetThreadSettings) {
        return widgetThreadSettings.getBinding();
    }

    public static final /* synthetic */ WidgetThreadSettingsViewModel access$getViewModel$p(WidgetThreadSettings widgetThreadSettings) {
        return widgetThreadSettings.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetThreadSettings widgetThreadSettings, WidgetThreadSettingsViewModel.Event event) {
        widgetThreadSettings.handleEvent(event);
    }

    public static final /* synthetic */ void access$setSlowmodeLabel(WidgetThreadSettings widgetThreadSettings, int i) {
        widgetThreadSettings.setSlowmodeLabel(i);
    }

    private final void configureUI(WidgetThreadSettingsViewModel.ViewState viewState) {
        if (!(viewState instanceof WidgetThreadSettingsViewModel.ViewState.Valid)) {
            requireActivity().finish();
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.thread_settings);
        WidgetThreadSettingsViewModel.ViewState.Valid valid = (WidgetThreadSettingsViewModel.ViewState.Valid) viewState;
        setActionBarSubtitle(ChannelUtils.e(valid.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(R.menu.menu_text_channel_settings, new AnonymousClass1(viewState), new AnonymousClass2(viewState));
        LinearLayout linearLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.threadSettingsEditWrap");
        linearLayout.setVisibility(valid.getCanManageThread() ? 0 : 8);
        String channelNameDraft = valid.getChannelNameDraft();
        Intrinsics3.checkNotNullExpressionValue(getBinding().d, "binding.threadSettingsEditName");
        if (!Intrinsics3.areEqual(channelNameDraft, ViewExtensions.getTextOrEmpty(r4))) {
            TextInputLayout textInputLayout = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
            ViewExtensions.setText(textInputLayout, valid.getChannelNameDraft());
        }
        LinearLayout linearLayout2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.threadSettingsSectionSlowMode");
        linearLayout2.setVisibility(valid.getCanManageThread() ? 0 : 8);
        int slowModeCooldownDraft = valid.getSlowModeCooldownDraft();
        setSlowmodeLabel(slowModeCooldownDraft);
        Iterator<Integer> it = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else {
                if (it.next().intValue() >= slowModeCooldownDraft) {
                    break;
                } else {
                    i++;
                }
            }
        }
        SeekBar seekBar = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        SeekBar seekBar2 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.threadSettingsSlowModeCooldownSlider");
        TextView textView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView.getText());
        TextView textView2 = getBinding().f2672b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelSettingsPinnedMessages");
        textView2.setEnabled(valid.isPinsEnabled());
        getBinding().f2672b.setOnClickListener(new AnonymousClass3(viewState));
        View view = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(true ^ valid.isPinsEnabled() ? 0 : 8);
        getBinding().c.setOnClickListener(AnonymousClass4.INSTANCE);
        FloatingActionButton floatingActionButton = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.threadSettingsSave");
        floatingActionButton.setVisibility(valid.getHasUnsavedChanges() ? 0 : 8);
        getBinding().f.setOnClickListener(new AnonymousClass5());
    }

    private final void confirmDelete(Channel channel) {
        WidgetChannelSettingsDeleteBinding widgetChannelSettingsDeleteBindingA = WidgetChannelSettingsDeleteBinding.a(LayoutInflater.from(getContext()), null, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsDeleteBindingA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = widgetChannelSettingsDeleteBindingA.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(widgetChannelSettingsDeleteBindingA.a).create();
        widgetChannelSettingsDeleteBindingA.e.setText(R.string.delete_thread);
        widgetChannelSettingsDeleteBindingA.c.setOnClickListener(new AnonymousClass1(alertDialogCreate));
        widgetChannelSettingsDeleteBindingA.d.setOnClickListener(new AnonymousClass2(channel));
        TextView textView = widgetChannelSettingsDeleteBindingA.f199b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        FormatUtils.n(textView, R.string.delete_channel_body, new Object[]{ChannelUtils.e(channel, requireContext(), false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetThreadSettingsBinding getBinding() {
        return (WidgetThreadSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadSettingsViewModel getViewModel() {
        return (WidgetThreadSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetThreadSettingsViewModel.Event event) {
        if (event instanceof WidgetThreadSettingsViewModel.Event.ShowToast) {
            AppToast.i(this, ((WidgetThreadSettingsViewModel.Event.ShowToast) event).getMessageStringRes(), 0, 4);
        }
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        WidgetTextChannelSettings.Companion companion = WidgetTextChannelSettings.INSTANCE;
        TextView textView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), R.string.form_label_slowmode_off);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        SeekBar seekBar = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setMax(Collections2.getLastIndex(WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES()));
        getBinding().i.setOnSeekBarChangeListener(new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetThreadSettingsViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetThreadSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), WidgetThreadSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
