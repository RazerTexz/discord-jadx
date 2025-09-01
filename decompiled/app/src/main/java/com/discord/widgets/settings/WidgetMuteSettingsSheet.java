package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetMuteSettingsSheetBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.settings.MuteSettingsSheetViewModel;
import d0.z.d.FunctionReferenceImpl;
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
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetMuteSettingsSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\n2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/discord/widgets/settings/WidgetMuteSettingsSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;", "viewState", "", "updateViews", "(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;)V", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState$Loaded;", "configureUnmuteButton", "(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState$Loaded;)V", "", "Lcom/discord/primitives/UtcTimestamp;", "muteEndTime", "parseMuteEndtime", "(Ljava/lang/String;)Ljava/lang/String;", "configureNotificationSettings", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "Lcom/discord/widgets/settings/MuteSettingsSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/MuteSettingsSheetViewModel;", "viewModel", "Lcom/discord/databinding/WidgetMuteSettingsSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetMuteSettingsSheetBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet extends AppBottomSheet {
    private static final float ACTIVE_OPACITY = 1.0f;
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final float INACTIVE_OPACITY = 0.2f;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetMuteSettingsSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMuteSettingsSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\n\u0010\u000b\u001a\u00060\u0002j\u0002`\n2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\tR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/settings/WidgetMuteSettingsSheet$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "showForChannel", "(JLandroidx/fragment/app/FragmentManager;)V", "Lcom/discord/primitives/GuildId;", "guildId", "showForGuild", "", "ACTIVE_OPACITY", "F", "", WidgetMuteSettingsSheet.ARG_CHANNEL_ID, "Ljava/lang/String;", WidgetMuteSettingsSheet.ARG_GUILD_ID, "INACTIVE_OPACITY", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void showForChannel(long channelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetMuteSettingsSheet widgetMuteSettingsSheet = new WidgetMuteSettingsSheet();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetMuteSettingsSheet.ARG_CHANNEL_ID, channelId);
            widgetMuteSettingsSheet.setArguments(bundle);
            widgetMuteSettingsSheet.show(fragmentManager, WidgetMuteSettingsSheet.class.getName());
        }

        public final void showForGuild(long guildId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetMuteSettingsSheet widgetMuteSettingsSheet = new WidgetMuteSettingsSheet();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetMuteSettingsSheet.ARG_GUILD_ID, guildId);
            widgetMuteSettingsSheet.setArguments(bundle);
            widgetMuteSettingsSheet.show(fragmentManager, WidgetMuteSettingsSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            MuteSettingsSheetViewModel.SettingsType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            MuteSettingsSheetViewModel.SettingsType settingsType = MuteSettingsSheetViewModel.SettingsType.GUILD;
            iArr[settingsType.ordinal()] = 1;
            MuteSettingsSheetViewModel.SettingsType settingsType2 = MuteSettingsSheetViewModel.SettingsType.DM;
            iArr[settingsType2.ordinal()] = 2;
            MuteSettingsSheetViewModel.SettingsType settingsType3 = MuteSettingsSheetViewModel.SettingsType.GROUP_DM;
            iArr[settingsType3.ordinal()] = 3;
            iArr[MuteSettingsSheetViewModel.SettingsType.GUILD_CHANNEL.ordinal()] = 4;
            iArr[MuteSettingsSheetViewModel.SettingsType.THREAD.ordinal()] = 5;
            MuteSettingsSheetViewModel.SettingsType settingsType4 = MuteSettingsSheetViewModel.SettingsType.CATEGORY;
            iArr[settingsType4.ordinal()] = 6;
            MuteSettingsSheetViewModel.SettingsType.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[settingsType3.ordinal()] = 1;
            iArr2[settingsType2.ordinal()] = 2;
            MuteSettingsSheetViewModel.SettingsType.values();
            int[] iArr3 = new int[7];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[settingsType2.ordinal()] = 1;
            iArr3[settingsType3.ordinal()] = 2;
            iArr3[settingsType.ordinal()] = 3;
            iArr3[settingsType4.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.unmute(context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MuteSettingsSheetViewModel.ViewState, Unit> {
        public AnonymousClass2(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
            super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "updateViews", "updateViews(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MuteSettingsSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetMuteSettingsSheet.access$updateViews((WidgetMuteSettingsSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<MuteSettingsSheetViewModel.Event, Unit> {
        public AnonymousClass3(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
            super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MuteSettingsSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetMuteSettingsSheet.access$handleEvent((WidgetMuteSettingsSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureNotificationSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(WidgetMuteSettingsSheet.this.requireContext(), R.color.status_red_500));
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureNotificationSettings$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this).onChannelSettingsSelected();
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(900000L, context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(3600000L, context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(28800000L, context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(86400000L, context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(0L, context);
        }
    }

    public WidgetMuteSettingsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetMuteSettingsSheet2.INSTANCE, null, 2, null);
        WidgetMuteSettingsSheet4 widgetMuteSettingsSheet4 = new WidgetMuteSettingsSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(MuteSettingsSheetViewModel.class), new WidgetMuteSettingsSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetMuteSettingsSheet4));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        return widgetMuteSettingsSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetMuteSettingsSheetBinding access$getBinding$p(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        return widgetMuteSettingsSheet.getBinding();
    }

    public static final /* synthetic */ MuteSettingsSheetViewModel access$getViewModel$p(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        return widgetMuteSettingsSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetMuteSettingsSheet widgetMuteSettingsSheet, MuteSettingsSheetViewModel.Event event) {
        widgetMuteSettingsSheet.handleEvent(event);
    }

    public static final /* synthetic */ void access$updateViews(WidgetMuteSettingsSheet widgetMuteSettingsSheet, MuteSettingsSheetViewModel.ViewState viewState) {
        widgetMuteSettingsSheet.updateViews(viewState);
    }

    private final void configureNotificationSettings(MuteSettingsSheetViewModel.ViewState.Loaded viewState) {
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.notificationSettingsOverridesLabel");
        int notificationSetting = viewState.getNotificationSetting();
        textView.setText(notificationSetting == ModelNotificationSettings.FREQUENCY_ALL ? FormatUtils.k(this, R.string.form_label_all_messages_short, new Object[0], null, 4) : notificationSetting == ModelNotificationSettings.FREQUENCY_MENTIONS ? FormatUtils.k(this, R.string.form_label_only_mentions_short, new Object[0], null, 4) : notificationSetting == ModelNotificationSettings.FREQUENCY_NOTHING ? FormatUtils.k(this, R.string.form_label_nothing, new Object[0], null, 4) : "");
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal != 0) {
            boolean z2 = true;
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 5) {
                if (!viewState.isChannelMuted() && !viewState.isGuildMuted()) {
                    z2 = false;
                }
                if (z2) {
                    TextView textView2 = getBinding().f;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.notificationSettingsLabel");
                    textView2.setAlpha(0.2f);
                    getBinding().d.setOnClickListener(null);
                    TextView textView3 = getBinding().f2498b;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelMutedDetails");
                    textView3.setVisibility(0);
                    TextView textView4 = getBinding().f2498b;
                    Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelMutedDetails");
                    textView4.setText(viewState.isChannelMuted() ? FormatUtils.k(this, R.string.form_description_mobile_notification_muted, new Object[0], null, 4) : FormatUtils.e(this, R.string.form_label_mobile_channel_override_guild_muted, new Object[0], new AnonymousClass1()));
                } else {
                    TextView textView5 = getBinding().f;
                    Intrinsics3.checkNotNullExpressionValue(textView5, "binding.notificationSettingsLabel");
                    textView5.setAlpha(1.0f);
                    getBinding().d.setOnClickListener(new AnonymousClass2());
                    TextView textView6 = getBinding().f2498b;
                    Intrinsics3.checkNotNullExpressionValue(textView6, "binding.channelMutedDetails");
                    textView6.setVisibility(8);
                }
                FrameLayout frameLayout = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.notificationSettingsButtonContainer");
                frameLayout.setVisibility(0);
                return;
            }
        }
        FrameLayout frameLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.notificationSettingsButtonContainer");
        frameLayout2.setVisibility(8);
        TextView textView7 = getBinding().f2498b;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.channelMutedDetails");
        textView7.setVisibility(8);
    }

    private final void configureUnmuteButton(MuteSettingsSheetViewModel.ViewState.Loaded viewState) {
        CharSequence charSequenceE;
        WidgetMuteSettingsSheet3 widgetMuteSettingsSheet3 = new WidgetMuteSettingsSheet3(this);
        if (!viewState.isChannelMuted()) {
            LinearLayout linearLayout = getBinding().o;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.unmuteButton");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.muteSettingsSheetMuteOptions");
            linearLayout2.setVisibility(0);
            return;
        }
        TextView textView = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.unmuteButtonLabel");
        FormatUtils.m(textView, R.string.unmute_channel, new Object[]{viewState.getSubtitle()}, widgetMuteSettingsSheet3);
        TextView textView2 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.unmuteButtonDetailsLabel");
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            String muteEndTime = viewState.getMuteEndTime();
            charSequenceE = muteEndTime == null ? FormatUtils.e(this, R.string.form_label_mobile_dm_muted, new Object[0], widgetMuteSettingsSheet3) : FormatUtils.e(this, R.string.form_label_mobile_dm_muted_until, new Object[]{parseMuteEndtime(muteEndTime)}, widgetMuteSettingsSheet3);
        } else {
            String muteEndTime2 = viewState.getMuteEndTime();
            charSequenceE = muteEndTime2 == null ? FormatUtils.e(this, R.string.form_label_mobile_channel_muted, new Object[0], widgetMuteSettingsSheet3) : FormatUtils.e(this, R.string.form_label_mobile_channel_muted_until, new Object[]{parseMuteEndtime(muteEndTime2)}, widgetMuteSettingsSheet3);
        }
        textView2.setText(charSequenceE);
        LinearLayout linearLayout3 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.unmuteButton");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.muteSettingsSheetMuteOptions");
        linearLayout4.setVisibility(8);
    }

    private final WidgetMuteSettingsSheetBinding getBinding() {
        return (WidgetMuteSettingsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MuteSettingsSheetViewModel getViewModel() {
        return (MuteSettingsSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(MuteSettingsSheetViewModel.Event event) {
        if (event instanceof MuteSettingsSheetViewModel.Event.Dismiss) {
            dismiss();
        } else if (event instanceof MuteSettingsSheetViewModel.Event.NavigateToChannelSettings) {
            WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetChannelNotificationSettings.Companion.launch$default(companion, contextRequireContext, ((MuteSettingsSheetViewModel.Event.NavigateToChannelSettings) event).getChannelId(), false, 4, null);
        }
    }

    private final String parseMuteEndtime(String muteEndTime) {
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return TimeUtils.renderUtcDateTime$default(timeUtils, muteEndTime, contextRequireContext, null, 3, 3, 4, null);
    }

    public static final void showForChannel(long j, FragmentManager fragmentManager) {
        INSTANCE.showForChannel(j, fragmentManager);
    }

    private final void updateViews(MuteSettingsSheetViewModel.ViewState viewState) {
        if (!(viewState instanceof MuteSettingsSheetViewModel.ViewState.Loaded)) {
            if (viewState instanceof MuteSettingsSheetViewModel.ViewState.Failure) {
                AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
                dismiss();
                return;
            }
            return;
        }
        MuteSettingsSheetViewModel.ViewState.Loaded loaded = (MuteSettingsSheetViewModel.ViewState.Loaded) viewState;
        int iOrdinal = loaded.getSettingsType().ordinal();
        Integer numValueOf = iOrdinal != 0 ? (iOrdinal == 1 || iOrdinal == 2) ? Integer.valueOf(R.string.mute_settings_mute_this_conversation) : iOrdinal != 3 ? iOrdinal != 4 ? iOrdinal != 5 ? null : Integer.valueOf(R.string.mute_settings_mute_category) : Integer.valueOf(R.string.mute_settings_mute_channel) : Integer.valueOf(R.string.mute_settings_mute_thread) : Integer.valueOf(R.string.mute_settings_mute_server);
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(numValueOf != null ? FormatUtils.k(this, numValueOf.intValue(), new Object[0], null, 4) : null);
        TextView textView2 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.subtitle");
        textView2.setText(loaded.getSubtitle());
        configureUnmuteButton(loaded);
        configureNotificationSettings(loaded);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        getBinding().o.setOnClickListener(new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetMuteSettingsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetMuteSettingsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_mute_settings_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().j.setOnClickListener(new AnonymousClass1());
        getBinding().k.setOnClickListener(new AnonymousClass2());
        getBinding().i.setOnClickListener(new AnonymousClass3());
        getBinding().l.setOnClickListener(new AnonymousClass4());
        getBinding().h.setOnClickListener(new AnonymousClass5());
    }
}
