package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelGroupDmSettingsBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetChannelGroupDMSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b6\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010\"R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00040$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00105\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetChannelGroupDMSettings;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState;", "viewState", "", "configureUi", "(Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState;)V", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState$Valid;", "configureIcon", "(Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState$Valid;)V", "handleSettingsSaved", "()V", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "confirmed", "", "groupName", "confirmLeave", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Ljava/lang/CharSequence;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event;)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "mimeType", "onImageChosen", "(Landroid/net/Uri;Ljava/lang/String;)V", "onImageCropped", "Lkotlin/Function1;", "iconEditedResult", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", "binding", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelGroupDMSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function1<? super String, Unit> iconEditedResult;
    private final StatefulViews state;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetChannelGroupDMSettings$Companion;", "", "", "channelId", "Landroid/content/Context;", "context", "", "create", "(JLandroid/content/Context;)V", "", WidgetChannelGroupDMSettings.INTENT_EXTRA_CHANNEL_ID, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetChannelGroupDMSettings.INTENT_EXTRA_CHANNEL_ID, channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
            AppScreen2.d(context, WidgetChannelGroupDMSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureIcon$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelGroupDMSettings.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "dataUrl", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureIcon$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "dataUrl");
            WidgetChannelGroupDMSettings.access$getViewModel$p(WidgetChannelGroupDMSettings.this).onIconEdited(str);
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureIcon$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelGroupDMSettings.access$getViewModel$p(WidgetChannelGroupDMSettings.this).removeEditedIcon();
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ String $displayName;

        /* compiled from: WidgetChannelGroupDMSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02481 extends Lambda implements Function0<Unit> {
            public C02481() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChannelGroupDMSettings.access$getViewModel$p(WidgetChannelGroupDMSettings.this).leaveGroup();
            }
        }

        public AnonymousClass1(String str) {
            this.$displayName = str;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() == R.id.menu_leave_group) {
                WidgetChannelGroupDMSettings widgetChannelGroupDMSettings = WidgetChannelGroupDMSettings.this;
                WidgetChannelGroupDMSettings.access$confirmLeave(widgetChannelGroupDMSettings, widgetChannelGroupDMSettings.requireContext(), new C02481(), this.$displayName);
            }
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ String $displayName;
        public final /* synthetic */ Channel $group;

        public AnonymousClass2(Channel channel, String str) {
            this.$group = channel;
            this.$displayName = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModelAccess$getViewModel$p = WidgetChannelGroupDMSettings.access$getViewModel$p(WidgetChannelGroupDMSettings.this);
            long id2 = this.$group.getId();
            StatefulViews statefulViewsAccess$getState$p = WidgetChannelGroupDMSettings.access$getState$p(WidgetChannelGroupDMSettings.this);
            TextInputLayout textInputLayout = WidgetChannelGroupDMSettings.access$getBinding$p(WidgetChannelGroupDMSettings.this).f2257b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            channelGroupDMSettingsViewModelAccess$getViewModel$p.editGroup(id2, ((String) statefulViewsAccess$getState$p.get(textInputLayout.getId(), this.$displayName)).toString());
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long j = this.$channelId;
            FragmentManager parentFragmentManager = WidgetChannelGroupDMSettings.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(j, parentFragmentManager);
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChannelGroupDMSettings.access$getViewModel$p(WidgetChannelGroupDMSettings.this).unmute(WidgetChannelGroupDMSettings.this.requireContext());
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$confirmLeave$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $confirmed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$confirmed = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            this.$confirmed.invoke();
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelGroupDMSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelGroupDMSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelGroupDMSettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelGroupDMSettings.access$configureUi(WidgetChannelGroupDMSettings.this, viewState);
        }
    }

    /* compiled from: WidgetChannelGroupDMSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ChannelGroupDMSettingsViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelGroupDMSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelGroupDMSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetChannelGroupDMSettings.this.handleEvent(event);
        }
    }

    public WidgetChannelGroupDMSettings() {
        super(R.layout.widget_channel_group_dm_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelGroupDMSettings2.INSTANCE, null, 2, null);
        WidgetChannelGroupDMSettings5 widgetChannelGroupDMSettings5 = new WidgetChannelGroupDMSettings5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ChannelGroupDMSettingsViewModel.class), new WidgetChannelGroupDMSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelGroupDMSettings5));
        this.iconEditedResult = WidgetChannelGroupDMSettings3.INSTANCE;
        this.state = new StatefulViews(R.id.channel_settings_edit_name, R.id.settings_group_icon);
    }

    public static final /* synthetic */ void access$configureUi(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings, ChannelGroupDMSettingsViewModel.ViewState viewState) {
        widgetChannelGroupDMSettings.configureUi(viewState);
    }

    public static final /* synthetic */ void access$confirmLeave(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings, Context context, Function0 function0, CharSequence charSequence) {
        widgetChannelGroupDMSettings.confirmLeave(context, function0, charSequence);
    }

    public static final /* synthetic */ WidgetChannelGroupDmSettingsBinding access$getBinding$p(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings) {
        return widgetChannelGroupDMSettings.getBinding();
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings) {
        return widgetChannelGroupDMSettings.state;
    }

    public static final /* synthetic */ ChannelGroupDMSettingsViewModel access$getViewModel$p(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings) {
        return widgetChannelGroupDMSettings.getViewModel();
    }

    private final void configureIcon(ChannelGroupDMSettingsViewModel.ViewState.Valid viewState) {
        String currentIconUrl = viewState.getCurrentIconUrl();
        if (viewState.getHasUnsavedIconChange()) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.settingsGroupIcon");
            statefulViews.put(simpleDraweeView.getId(), currentIconUrl != null ? currentIconUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.settingsGroupIcon");
            statefulViews2.get(simpleDraweeView2.getId(), currentIconUrl != null ? currentIconUrl : "");
        }
        getBinding().f.setOnClickListener(new AnonymousClass1());
        this.iconEditedResult = new AnonymousClass2();
        SimpleDraweeView simpleDraweeView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.settingsGroupIcon");
        IconUtils.setIcon$default(simpleDraweeView3, currentIconUrl, R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsGroupIconLabel");
        textView.setVisibility(viewState.isDefaultPhoto() ? 0 : 8);
        TextView textView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsGroupIconRemove");
        textView2.setVisibility(viewState.isDefaultPhoto() ^ true ? 0 : 8);
        getBinding().h.setOnClickListener(new AnonymousClass3());
        this.state.configureSaveActionView(getBinding().c);
    }

    private final void configureUi(ChannelGroupDMSettingsViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, ChannelGroupDMSettingsViewModel.ViewState.Invalid.INSTANCE)) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        if (viewState instanceof ChannelGroupDMSettingsViewModel.ViewState.Valid) {
            ChannelGroupDMSettingsViewModel.ViewState.Valid valid = (ChannelGroupDMSettingsViewModel.ViewState.Valid) viewState;
            ChannelSettings channelSettings = valid.getChannelSettings();
            Channel channel = channelSettings.getChannel();
            String strD = ChannelUtils.d(channel, requireContext(), true);
            setActionBarTitle(R.string.channel_settings);
            setActionBarSubtitle(strD);
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_main_group_settings, new AnonymousClass1(strD), null, 4, null);
            TextInputLayout textInputLayout = getBinding().f2257b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            StatefulViews statefulViews = this.state;
            TextInputLayout textInputLayout2 = getBinding().f2257b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
            ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), strD));
            TextInputLayout textInputLayout3 = getBinding().f2257b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditName");
            ViewExtensions.setSelectionEnd(textInputLayout3);
            configureIcon(valid);
            this.state.configureSaveActionView(getBinding().c);
            getBinding().c.setOnClickListener(new AnonymousClass2(channel, strD));
            long id2 = channel.getId();
            getBinding().d.updateView(new NotificationMuteSettingsView.ViewState(channelSettings.isMuted(), channelSettings.getMuteEndTime(), FormatUtils.k(this, R.string.mute_conversation, new Object[0], null, 4), FormatUtils.k(this, R.string.unmute_conversation, new Object[0], null, 4), FormatUtils.k(this, R.string.form_label_mobile_dm_muted, new Object[0], null, 4), R.string.form_label_mobile_dm_muted_until, null), new AnonymousClass3(id2), new AnonymousClass4());
        }
    }

    private final void confirmLeave(Context context, Function0<Unit> confirmed, CharSequence groupName) {
        WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(context).setTitle(FormatUtils.k(this, R.string.leave_group_dm_title, new Object[]{groupName}, null, 4)).setMessage(FormatUtils.k(this, R.string.leave_group_dm_body, new Object[]{groupName}, null, 4)).setDialogAttrTheme(R.attr.notice_theme_positive_red).setPositiveButton(R.string.leave_group_dm, new AnonymousClass1(confirmed)), R.string.cancel, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        negativeButton$default.show(parentFragmentManager);
    }

    private final WidgetChannelGroupDmSettingsBinding getBinding() {
        return (WidgetChannelGroupDmSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChannelGroupDMSettingsViewModel getViewModel() {
        return (ChannelGroupDMSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleSettingsSaved() {
        AppToast.i(this, R.string.saved_settings, 0, 4);
        StatefulViews.clear$default(this.state, false, 1, null);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        getBinding().e.fullScroll(33);
    }

    public final void handleEvent(ChannelGroupDMSettingsViewModel.Event event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        if (!Intrinsics3.areEqual(event, ChannelGroupDMSettingsViewModel.Event.LeaveGroupSuccess.INSTANCE)) {
            if (Intrinsics3.areEqual(event, ChannelGroupDMSettingsViewModel.Event.SettingsSaved.INSTANCE)) {
                handleSettingsSaved();
            }
        } else {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$sam$rx_functions_Action1$0] */
    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Function1<? super String, Unit> widgetChannelGroupDMSettings4 = this.iconEditedResult;
        if (widgetChannelGroupDMSettings4 != null) {
            widgetChannelGroupDMSettings4 = new WidgetChannelGroupDMSettings4(widgetChannelGroupDMSettings4);
        }
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, (Action1) widgetChannelGroupDMSettings4, ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$sam$rx_functions_Action1$0] */
    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> widgetChannelGroupDMSettings4 = this.iconEditedResult;
        if (widgetChannelGroupDMSettings4 != null) {
            widgetChannelGroupDMSettings4 = new WidgetChannelGroupDMSettings4(widgetChannelGroupDMSettings4);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetChannelGroupDMSettings4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsGroupIconLabel");
        textView.setText(FormatUtils.k(this, R.string.minimum_size, new Object[]{"128", "128"}, null, 4));
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().c;
        TextInputLayout textInputLayout = getBinding().f2257b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelGroupDMSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChannelGroupDMSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
