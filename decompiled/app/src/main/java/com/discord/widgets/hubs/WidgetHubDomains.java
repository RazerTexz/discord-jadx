package com.discord.widgets.hubs;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubDomainsBinding;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action2;

/* compiled from: WidgetHubDomains.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00178F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR%\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010'\u001a\u00020#8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubDomains;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/hubs/DomainsState;", "state", "", "updateView", "(Lcom/discord/widgets/hubs/DomainsState;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/hubs/DomainGuildInfo;", "guildInfo", "onServerClickListener", "(Lcom/discord/widgets/hubs/DomainGuildInfo;)V", "Lcom/discord/databinding/WidgetHubDomainsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetHubDomainsBinding;", "binding", "Lcom/discord/widgets/hubs/HubDomainArgs;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/hubs/HubDomainArgs;", "args", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/widgets/hubs/HubDomainViewHolder;", "adapter", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/widgets/hubs/WidgetHubDomainsViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/hubs/WidgetHubDomainsViewModel;", "viewModel", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubDomains extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubDomains.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDomainsBinding;", 0)};
    private final SimpleRecyclerAdapter<WidgetHubDomains2, WidgetHubDomains4> adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubDomains.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "item", "Landroid/content/Context;", "context", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomains$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "item");
            if (menuItem.getItemId() == R.id.search) {
                AppScreen2 appScreen2 = AppScreen2.g;
                FragmentManager parentFragmentManager = WidgetHubDomains.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                AppScreen2.g(appScreen2, parentFragmentManager, context, WidgetHubDomainSearch.class, 0, true, null, null, 104);
            }
        }
    }

    /* compiled from: WidgetHubDomains.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/hubs/DomainsState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/hubs/DomainsState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomains$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetHubDomainsViewModel2, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
            invoke2(widgetHubDomainsViewModel2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
            WidgetHubDomains widgetHubDomains = WidgetHubDomains.this;
            Intrinsics3.checkNotNullExpressionValue(widgetHubDomainsViewModel2, "viewState");
            WidgetHubDomains.access$updateView(widgetHubDomains, widgetHubDomainsViewModel2);
        }
    }

    /* compiled from: WidgetHubDomains.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/Success;", "", "it", "", "invoke", "(Lcom/discord/stores/utilities/Success;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomains$updateView$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState6<? extends Object>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetHubDomainsViewModel2 $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
            super(1);
            this.$context = context;
            this.$state = widgetHubDomainsViewModel2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends Object> restCallState6) {
            invoke2(restCallState6);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<? extends Object> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            AppScreen2.g(AppScreen2.g, WidgetHubDomains.this.getParentFragmentManager(), this.$context, WidgetHubAuthentication.class, 0, true, null, new WidgetHubAuthenticationlViewModel2(WidgetHubDomains.this.getArgs().getEmail(), this.$state.getSelectedGuildId()), 40);
            WidgetHubDomains.this.getViewModel().reset();
        }
    }

    public WidgetHubDomains() {
        super(R.layout.widget_hub_domains);
        this.args = LazyJVM.lazy(new WidgetHubDomains$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubDomains8.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubDomains7(this), 1, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubDomainsViewModel.class), new WidgetHubDomains$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetHubDomains9.INSTANCE));
    }

    public static final /* synthetic */ void access$updateView(WidgetHubDomains widgetHubDomains, WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2) {
        widgetHubDomains.updateView(widgetHubDomainsViewModel2);
    }

    private final void updateView(WidgetHubDomainsViewModel2 state) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            RestCallState5.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new AnonymousClass1(context, state), 6, null);
        }
    }

    public final SimpleRecyclerAdapter<WidgetHubDomains2, WidgetHubDomains4> getAdapter() {
        return this.adapter;
    }

    public final WidgetHubDomains3 getArgs() {
        return (WidgetHubDomains3) this.args.getValue();
    }

    public final WidgetHubDomainsBinding getBinding() {
        return (WidgetHubDomainsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetHubDomainsViewModel getViewModel() {
        return (WidgetHubDomainsViewModel) this.viewModel.getValue();
    }

    public final void onServerClickListener(WidgetHubDomains2 guildInfo) {
        Intrinsics3.checkNotNullParameter(guildInfo, "guildInfo");
        getViewModel().onGuildClicked(guildInfo.getId(), getArgs().getEmail());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f2472b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        this.adapter.setData(getArgs().getGuildInfos());
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_search, new AnonymousClass1(), null, 4, null);
        MaterialButton materialButton = getBinding().c;
        Context context = materialButton.getContext();
        if (context != null) {
            materialButton.setText(FormatUtils.h(context, R.string.hub_email_connection_guild_select_subheader, new Object[0], null, 4));
            materialButton.setOnClickListener(new WidgetHubDomains6(context, this));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetHubDomainsViewModel2> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetHubDomains.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
