package com.discord.widgets.contact_sync;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.ContactSyncPermissionsSheetBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
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

/* compiled from: ContactSyncPermissionsSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/contact_sync/ContactSyncPermissionsSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ViewState;)V", "", "getContentViewResId", "()I", "onResume", "()V", "Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", "binding", "Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(ContactSyncPermissionsSheet.class, "binding", "getBinding()Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: ContactSyncPermissionsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/contact_sync/ContactSyncPermissionsSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/contact_sync/ContactSyncPermissionsSheet;", "show", "(Landroidx/fragment/app/FragmentManager;)Lcom/discord/widgets/contact_sync/ContactSyncPermissionsSheet;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ContactSyncPermissionsSheet show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            ContactSyncPermissionsSheet contactSyncPermissionsSheet = new ContactSyncPermissionsSheet();
            contactSyncPermissionsSheet.show(fragmentManager, ContactSyncPermissionsSheet.class.getSimpleName());
            return contactSyncPermissionsSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* compiled from: ContactSyncPermissionsSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02841 extends Lambda implements Function1<Hook, Unit> {

            /* compiled from: ContactSyncPermissionsSheet.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02851 extends Lambda implements Function1<View, Unit> {
                public static final C02851 INSTANCE = new C02851();

                public C02851() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics3.checkNotNullParameter(view, "it");
                    UriHandler uriHandler = UriHandler.INSTANCE;
                    Context context = view.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                    UriHandler.handle$default(uriHandler, context, AppHelpDesk.a.a(360061878534L, null), false, false, null, 28, null);
                }
            }

            public C02841() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(ContactSyncPermissionsSheet.this.getContext(), R.color.link)), false, null, C02851.INSTANCE, 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("learnMoreHook", new C02841());
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ boolean $discoverable;

        public AnonymousClass2(boolean z2) {
            this.$discoverable = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSyncViewModel widgetContactSyncViewModelAccess$getViewModel$p = ContactSyncPermissionsSheet.access$getViewModel$p(ContactSyncPermissionsSheet.this);
            boolean z2 = this.$discoverable;
            widgetContactSyncViewModelAccess$getViewModel$p.onPermissionsToggle(!z2, !z2);
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ WidgetContactSyncViewModel.ViewState $viewState;

        public AnonymousClass3(WidgetContactSyncViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ContactSyncPermissionsSheet.access$getViewModel$p(ContactSyncPermissionsSheet.this).onPermissionsToggle(!this.$viewState.getAllowPhone(), this.$viewState.getAllowEmail());
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ WidgetContactSyncViewModel.ViewState $viewState;

        public AnonymousClass4(WidgetContactSyncViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ContactSyncPermissionsSheet.access$getViewModel$p(ContactSyncPermissionsSheet.this).onPermissionsToggle(this.$viewState.getAllowPhone(), !this.$viewState.getAllowEmail());
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/contact_sync/WidgetContactSyncViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetContactSyncViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            ContactSyncPermissionsSheet.access$configureUI(ContactSyncPermissionsSheet.this, viewState);
        }
    }

    public ContactSyncPermissionsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, ContactSyncPermissionsSheet2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new ContactSyncPermissionsSheet$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new ContactSyncPermissionsSheet3(this)));
    }

    public static final /* synthetic */ void access$configureUI(ContactSyncPermissionsSheet contactSyncPermissionsSheet, WidgetContactSyncViewModel.ViewState viewState) {
        contactSyncPermissionsSheet.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetContactSyncViewModel access$getViewModel$p(ContactSyncPermissionsSheet contactSyncPermissionsSheet) {
        return contactSyncPermissionsSheet.getViewModel();
    }

    private final void configureUI(WidgetContactSyncViewModel.ViewState viewState) {
        boolean z2 = viewState.getAllowPhone() || viewState.getAllowEmail();
        CheckedSetting checkedSetting = getBinding().f2092b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncPermissionsDiscoverableToggle");
        checkedSetting.setChecked(z2);
        CheckedSetting checkedSetting2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncPermissionsPhoneToggle");
        checkedSetting2.setChecked(viewState.getAllowPhone());
        CheckedSetting checkedSetting3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncPermissionsEmailToggle");
        checkedSetting3.setChecked(viewState.getAllowEmail());
        LinkifiedTextView linkifiedTextView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncPermissionsLearnMore");
        FormatUtils.m(linkifiedTextView, R.string.contact_sync_learn_more, new Object[0], new AnonymousClass1());
        getBinding().f2092b.e(new AnonymousClass2(z2));
        getBinding().e.e(new AnonymousClass3(viewState));
        getBinding().c.e(new AnonymousClass4(viewState));
    }

    private final ContactSyncPermissionsSheetBinding getBinding() {
        return (ContactSyncPermissionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.contact_sync_permissions_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), ContactSyncPermissionsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
