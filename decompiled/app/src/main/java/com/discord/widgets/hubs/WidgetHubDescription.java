package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetHubDescriptionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import com.google.android.material.textfield.TextInputEditText;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetHubDescription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\u00020#8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\u00020(8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubDescription;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/hubs/HubDescriptionState;", "state", "", "configureUI", "(Lcom/discord/widgets/hubs/HubDescriptionState;)V", "maybeAddServer", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "Lkotlin/Lazy;", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "Lcom/discord/widgets/hubs/HubDescriptionArgs;", "args$delegate", "getArgs", "()Lcom/discord/widgets/hubs/HubDescriptionArgs;", "args", "Lcom/discord/databinding/WidgetHubDescriptionBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetHubDescriptionBinding;", "binding", "Lcom/discord/widgets/hubs/RadioSelectorItems;", "getSelectorArgs", "()Lcom/discord/widgets/hubs/RadioSelectorItems;", "selectorArgs", "Lcom/discord/widgets/hubs/WidgetHubDescriptionViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/hubs/WidgetHubDescriptionViewModel;", "viewModel", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubDescription extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubDescription.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDescriptionBinding;", 0)};

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubDescription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/Success;", "Lcom/discord/api/directory/DirectoryEntryGuild;", "it", "", "invoke", "(Lcom/discord/stores/utilities/Success;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RestCallState6<? extends DirectoryEntryGuild>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends DirectoryEntryGuild> restCallState6) {
            invoke2((RestCallState6<DirectoryEntryGuild>) restCallState6);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<DirectoryEntryGuild> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            StoreStream.INSTANCE.getDirectories().addServerToDirectory(WidgetHubDescription.this.getArgs().getChannelId(), restCallState6.invoke());
            WidgetHubDescription widgetHubDescription = WidgetHubDescription.this;
            widgetHubDescription.hideKeyboard(widgetHubDescription.getView());
            FragmentActivity activity = WidgetHubDescription.this.getActivity();
            if (activity != null) {
                activity.setResult(-1, AnimatableValueParser.g2(new WidgetHubDescription2(restCallState6.invoke().getGuild().getId(), WidgetHubDescription.this.getArgs().getHubName())));
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubDescription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {

        /* compiled from: WidgetHubDescription.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_ID, "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02981 extends Lambda implements Function1<Integer, Unit> {
            public C02981() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                WidgetHubDescription.this.getViewModel().setCategory(i);
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetHubDescription.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            companion.show(childFragmentManager, WidgetHubDescription.access$getSelectorArgs$p(WidgetHubDescription.this), new C02981());
        }
    }

    /* compiled from: WidgetHubDescription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/hubs/HubDescriptionState;", "viewState", "", "invoke", "(Lcom/discord/widgets/hubs/HubDescriptionState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetHubDescriptionViewModel3, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            invoke2(widgetHubDescriptionViewModel3);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubDescriptionViewModel3, "viewState");
            WidgetHubDescription.access$configureUI(WidgetHubDescription.this, widgetHubDescriptionViewModel3);
        }
    }

    public WidgetHubDescription() {
        super(R.layout.widget_hub_description);
        this.args = LazyJVM.lazy(new WidgetHubDescription$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubDescription4.INSTANCE, null, 2, null);
        WidgetHubDescription8 widgetHubDescription8 = new WidgetHubDescription8(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubDescriptionViewModel.class), new WidgetHubDescription$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubDescription8));
        this.validationManager = LazyJVM.lazy(new WidgetHubDescription7(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetHubDescription5(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetHubDescription widgetHubDescription, WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        widgetHubDescription.configureUI(widgetHubDescriptionViewModel3);
    }

    public static final /* synthetic */ WidgetRadioSelectorBottomSheet3 access$getSelectorArgs$p(WidgetHubDescription widgetHubDescription) {
        return widgetHubDescription.getSelectorArgs();
    }

    public static final /* synthetic */ void access$maybeAddServer(WidgetHubDescription widgetHubDescription) {
        widgetHubDescription.maybeAddServer();
    }

    private final void configureUI(WidgetHubDescriptionViewModel3 state) {
        int i;
        String string;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().h.setTitle(FormatUtils.k(this, getArgs().isEditing() ? R.string.hub_entry_update_description_title : R.string.hub_customize_existing_guild_title, new Object[]{state.getGuildName()}, null, 4));
            LoadingButton loadingButton = getBinding().f2470b;
            loadingButton.setOnClickListener(new WidgetHubDescription3(this, state));
            loadingButton.setIsLoading(state.getAddServerAsync() instanceof RestCallState4);
            loadingButton.setText(getString(getArgs().isEditing() ? R.string.save : R.string.hub_add_server_cta));
            TextView textView = getBinding().c;
            DirectoryEntryCategory selectedCategory = state.getSelectedCategory();
            if (selectedCategory != null) {
                selectedCategory.getTitleRes();
                i = R.attr.colorTextNormal;
            } else {
                i = R.attr.colorTextMuted;
            }
            textView.setTextColor(ColorCompat.getThemedColor(context, i));
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.category");
            DirectoryEntryCategory selectedCategory2 = state.getSelectedCategory();
            if (selectedCategory2 == null || (string = selectedCategory2.getTitle(context)) == null) {
                string = getString(R.string.categories);
            }
            textView2.setText(string);
            RestCallState5.handleResponse$default(state.getAddServerAsync(), context, null, null, new AnonymousClass3(), 6, null);
        }
    }

    private final WidgetRadioSelectorBottomSheet3 getSelectorArgs() {
        String string = requireContext().getString(R.string.categories);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getString(R.string.categories)");
        return new WidgetRadioSelectorBottomSheet3(string, (List) getViewModel().withViewState(new WidgetHubDescription6(this)));
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeAddServer() {
        if (getValidationManager().validate(true)) {
            WidgetHubDescriptionViewModel viewModel = getViewModel();
            long channelId = getArgs().getChannelId();
            long guildId = getArgs().getGuildId();
            TextInputEditText textInputEditText = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.description");
            viewModel.addServer(channelId, guildId, String.valueOf(textInputEditText.getText()));
        }
    }

    public final WidgetHubDescriptionViewModel2 getArgs() {
        return (WidgetHubDescriptionViewModel2) this.args.getValue();
    }

    public final WidgetHubDescriptionBinding getBinding() {
        return (WidgetHubDescriptionBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubDescriptionViewModel getViewModel() {
        return (WidgetHubDescriptionViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f.setText(getArgs().getDescription());
        getBinding().e.setOnClickListener(new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), WidgetHubDescription.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
