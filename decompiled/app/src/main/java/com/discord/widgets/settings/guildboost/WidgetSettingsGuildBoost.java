package com.discord.widgets.settings.guildboost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.GuildBoostCancelDialog;
import b.a.a.a.GuildBoostUncancelDialog;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBoostBinding;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetSettingsGuildBoost.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00022\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoost;", "Lcom/discord/app/AppFragment;", "", "showLoadingUI", "()V", "showFailureUI", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState$Loaded;", "viewState", "showContent", "(Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState$Loaded;)V", "", "hasNoGuilds", "configureNoGuildsViews", "(Z)V", "", "Lcom/discord/primitives/GuildId;", "selectedGuildId", "handleSampleGuildSelected", "(J)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel;", "viewModel", "Lcom/discord/databinding/WidgetSettingsBoostBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsBoostBinding;", "binding", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter;", "sampleGuildsAdapter", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter;", "guildBoostSubscriptionsAdapter", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBoostBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int VIEW_INDEX_FAILURE = 1;
    public static final int VIEW_INDEX_LOADED = 2;
    public static final int VIEW_INDEX_LOADING = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetSettingsGuildBoostSubscriptionAdapter guildBoostSubscriptionsAdapter;
    private SettingsGuildBoostSampleGuildAdapter sampleGuildsAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoost$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "", "VIEW_INDEX_FAILURE", "I", "VIEW_INDEX_LOADED", "VIEW_INDEX_LOADING", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsGuildBoost.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $helpdeskArticleUrl;

        public AnonymousClass1(String str) {
            this.$helpdeskArticleUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view, "it", "it.context"), this.$helpdeskArticleUrl, false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).retryClicked();
        }
    }

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "guildId", "", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).handleGuildSearchCallback(j);
        }
    }

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState;", "kotlin.jvm.PlatformType", "model", "", "invoke", "(Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<SettingsGuildBoostViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGuildBoostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGuildBoostViewModel.ViewState viewState) {
            if (viewState instanceof SettingsGuildBoostViewModel.ViewState.Loaded) {
                WidgetSettingsGuildBoost.access$showContent(WidgetSettingsGuildBoost.this, (SettingsGuildBoostViewModel.ViewState.Loaded) viewState);
            } else if (viewState instanceof SettingsGuildBoostViewModel.ViewState.Loading) {
                WidgetSettingsGuildBoost.access$showLoadingUI(WidgetSettingsGuildBoost.this);
            } else if (viewState instanceof SettingsGuildBoostViewModel.ViewState.Failure) {
                WidgetSettingsGuildBoost.access$showFailureUI(WidgetSettingsGuildBoost.this);
            }
        }
    }

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/domain/ModelGuildBoostSlot;", "slot", "", "Lcom/discord/primitives/GuildId;", "previousGuildId", "", "invoke", "(Lcom/discord/models/domain/ModelGuildBoostSlot;J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<ModelGuildBoostSlot, Long, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildBoostSlot modelGuildBoostSlot, Long l) {
            invoke(modelGuildBoostSlot, l.longValue());
            return Unit.a;
        }

        public final void invoke(ModelGuildBoostSlot modelGuildBoostSlot, long j) {
            Intrinsics3.checkNotNullParameter(modelGuildBoostSlot, "slot");
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).transferClicked(modelGuildBoostSlot, j);
            WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetSettingsGuildBoost.this, null, false, 0, new WidgetGuildSelector.GuildFilterFunction(_Sets.minus(StoreStream.INSTANCE.getGuilds().getGuilds().keySet(), Long.valueOf(j))), 14, null);
        }
    }

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildBoostSlotId;", "slotId", "", "cancel", "", "invoke", "(JZ)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, Boolean, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).cancelClicked(j, z2);
        }
    }

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildBoostSlotId;", "slotId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).subscribeClicked(j);
            WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetSettingsGuildBoost.this, null, false, 0, null, 30, null);
        }
    }

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "p1", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass4(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
            super(1, widgetSettingsGuildBoost, WidgetSettingsGuildBoost.class, "handleSampleGuildSelected", "handleSampleGuildSelected(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetSettingsGuildBoost.access$handleSampleGuildSelected((WidgetSettingsGuildBoost) this.receiver, j);
        }
    }

    /* compiled from: WidgetSettingsGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function0<Unit> {
        public AnonymousClass7() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetSettingsGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    public WidgetSettingsGuildBoost() {
        super(R.layout.widget_settings_boost);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsGuildBoost2.INSTANCE, null, 2, null);
        WidgetSettingsGuildBoost3 widgetSettingsGuildBoost3 = WidgetSettingsGuildBoost3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsGuildBoostViewModel.class), new WidgetSettingsGuildBoost$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettingsGuildBoost3));
    }

    public static final /* synthetic */ SettingsGuildBoostViewModel access$getViewModel$p(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        return widgetSettingsGuildBoost.getViewModel();
    }

    public static final /* synthetic */ void access$handleSampleGuildSelected(WidgetSettingsGuildBoost widgetSettingsGuildBoost, long j) {
        widgetSettingsGuildBoost.handleSampleGuildSelected(j);
    }

    public static final /* synthetic */ void access$showContent(WidgetSettingsGuildBoost widgetSettingsGuildBoost, SettingsGuildBoostViewModel.ViewState.Loaded loaded) {
        widgetSettingsGuildBoost.showContent(loaded);
    }

    public static final /* synthetic */ void access$showFailureUI(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        widgetSettingsGuildBoost.showFailureUI();
    }

    public static final /* synthetic */ void access$showLoadingUI(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        widgetSettingsGuildBoost.showLoadingUI();
    }

    private final void configureNoGuildsViews(boolean hasNoGuilds) {
        ImageView imageView = getBinding().f2612b.f204b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.noGuilds.settingsBoostNoGuildsImage");
        imageView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView = getBinding().f2612b.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noGuilds.settingsBoostNoGuildsTitle");
        textView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView2 = getBinding().f2612b.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noGuilds.settingsBoostNoGuildsSubtitle");
        textView2.setVisibility(hasNoGuilds ? 0 : 8);
    }

    private final WidgetSettingsBoostBinding getBinding() {
        return (WidgetSettingsBoostBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsGuildBoostViewModel getViewModel() {
        return (SettingsGuildBoostViewModel) this.viewModel.getValue();
    }

    private final void handleSampleGuildSelected(long selectedGuildId) {
        StoreStream.INSTANCE.getGuildSelected().dispatchSampleGuildIdSelected(selectedGuildId);
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", true);
        intent.addFlags(268468224);
        AppScreen2.c(requireContext(), false, intent, 2);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void showContent(SettingsGuildBoostViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(2);
        boolean z2 = !viewState.getGuildBoostItems().isEmpty();
        LinearLayout linearLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsBoostSubtextContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter = this.guildBoostSubscriptionsAdapter;
            if (widgetSettingsGuildBoostSubscriptionAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildBoostSubscriptionsAdapter");
            }
            widgetSettingsGuildBoostSubscriptionAdapter.configure(viewState.getGuildBoostItems(), new AnonymousClass3(), new AnonymousClass1(), new AnonymousClass2(), viewState.getCanCancelBoosts(), viewState.getCanUncancelBoosts());
        }
        SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter = this.sampleGuildsAdapter;
        if (settingsGuildBoostSampleGuildAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("sampleGuildsAdapter");
        }
        settingsGuildBoostSampleGuildAdapter.configure(viewState.getSampleGuildItems(), new AnonymousClass4(this));
        SettingsGuildBoostViewModel.PendingAction pendingAction = viewState.getPendingAction();
        if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Subscribe) {
            SettingsGuildBoostViewModel.PendingAction.Subscribe subscribe = (SettingsGuildBoostViewModel.PendingAction.Subscribe) pendingAction;
            Long targetGuildId = subscribe.getTargetGuildId();
            if (targetGuildId != null) {
                targetGuildId.longValue();
                WidgetGuildBoostConfirmation.INSTANCE.create(requireContext(), subscribe.getTargetGuildId().longValue(), subscribe.getSlotId());
                getViewModel().consumePendingAction();
            }
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Transfer) {
            SettingsGuildBoostViewModel.PendingAction.Transfer transfer = (SettingsGuildBoostViewModel.PendingAction.Transfer) pendingAction;
            Long targetGuildId2 = transfer.getTargetGuildId();
            if (targetGuildId2 != null) {
                targetGuildId2.longValue();
                WidgetGuildBoostTransfer.INSTANCE.create(requireContext(), transfer.getPreviousGuildId(), transfer.getTargetGuildId().longValue(), transfer.getSlot());
                getViewModel().consumePendingAction();
            }
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Cancel) {
            GuildBoostCancelDialog.Companion companion = GuildBoostCancelDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            long slotId = ((SettingsGuildBoostViewModel.PendingAction.Cancel) pendingAction).getSlotId();
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            GuildBoostCancelDialog guildBoostCancelDialog = new GuildBoostCancelDialog();
            Bundle bundle = new Bundle();
            bundle.putLong("extra_slot_id", slotId);
            guildBoostCancelDialog.setArguments(bundle);
            guildBoostCancelDialog.show(parentFragmentManager, GuildBoostCancelDialog.class.getName());
            getViewModel().consumePendingAction();
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Uncancel) {
            GuildBoostUncancelDialog.Companion companion2 = GuildBoostUncancelDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            long slotId2 = ((SettingsGuildBoostViewModel.PendingAction.Uncancel) pendingAction).getSlotId();
            Objects.requireNonNull(companion2);
            Intrinsics3.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            GuildBoostUncancelDialog guildBoostUncancelDialog = new GuildBoostUncancelDialog();
            Bundle bundle2 = new Bundle();
            bundle2.putLong("extra_slot_id", slotId2);
            guildBoostUncancelDialog.setArguments(bundle2);
            guildBoostUncancelDialog.show(parentFragmentManager2, GuildBoostUncancelDialog.class.getName());
            getViewModel().consumePendingAction();
        }
        getBinding().d.a(viewState.getUserPremiumTier(), new AnonymousClass7());
        getBinding().j.a(viewState.getUserPremiumTier(), !viewState.getSampleGuildItems().isEmpty());
        configureNoGuildsViews(viewState.getSampleGuildItems().isEmpty());
    }

    private final void showFailureUI() {
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    private final void showLoadingUI() {
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.premium_guild_subscription_title);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.settingsBoostRecycler");
        this.guildBoostSubscriptionsAdapter = (WidgetSettingsGuildBoostSubscriptionAdapter) companion.configure(new WidgetSettingsGuildBoostSubscriptionAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.settingsBoostSampleGuilds");
        this.sampleGuildsAdapter = (SettingsGuildBoostSampleGuildAdapter) companion.configure(new SettingsGuildBoostSampleGuildAdapter(recyclerView2));
        String strA = AppHelpDesk.a.a(360028038352L, null);
        LinkifiedTextView linkifiedTextView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsBoostSubtext");
        FormatUtils.n(linkifiedTextView, R.string.premium_guild_subscription_subtitle_mobile_2, new Object[]{strA}, null, 4);
        getBinding().h.setOnClickListener(new AnonymousClass1(strA));
        getBinding().f.setOnClickListener(new AnonymousClass2());
        getBinding().e.setHasFixedSize(false);
        WidgetGuildSelector.Companion.registerForResult$default(WidgetGuildSelector.INSTANCE, this, null, false, new AnonymousClass3(), 6, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsGuildBoostViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetSettingsPremium.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
