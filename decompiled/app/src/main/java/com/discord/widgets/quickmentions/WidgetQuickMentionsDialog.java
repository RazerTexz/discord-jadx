package com.discord.widgets.quickmentions;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetQuickMentionsDialogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2Extensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserMentions;
import com.discord.widgets.user.search.WidgetGlobalSearch;
import com.discord.widgets.user.search.WidgetGlobalSearchDismissModel;
import com.google.android.material.tabs.TabLayout;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetQuickMentionsDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/quickmentions/WidgetQuickMentionsDialog;", "Lcom/discord/app/AppDialog;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "", "onStart", "()V", "onViewBoundOrOnResume", "Lcom/discord/widgets/user/search/WidgetGlobalSearchDismissModel;", "dismissViewModel$delegate", "Lkotlin/Lazy;", "getDismissViewModel", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchDismissModel;", "dismissViewModel", "Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", "binding", "<init>", "Companion", "TabsAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetQuickMentionsDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetQuickMentionsDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQuickMentionsDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int POSITION_MENTIONS = 1;
    private static final int POSITION_QUICK_SWITCHER = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;

    /* compiled from: WidgetQuickMentionsDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/quickmentions/WidgetQuickMentionsDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "searchText", "", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "dismiss", "(Landroidx/fragment/app/FragmentManager;)V", "", "POSITION_MENTIONS", "I", "POSITION_QUICK_SWITCHER", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.show(fragmentManager, str);
        }

        public final void dismiss(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("javaClass");
            if (fragmentFindFragmentByTag instanceof WidgetQuickMentionsDialog) {
                ((WidgetQuickMentionsDialog) fragmentFindFragmentByTag).dismiss();
            }
        }

        public final void show(FragmentManager fragmentManager, String searchText) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            dismiss(fragmentManager);
            WidgetQuickMentionsDialog widgetQuickMentionsDialog = new WidgetQuickMentionsDialog();
            widgetQuickMentionsDialog.setArguments(Bundle2.bundleOf(Tuples.to(WidgetGlobalSearch.EXTRA_SEARCH_TEXT, searchText)));
            widgetQuickMentionsDialog.show(fragmentManager, "javaClass");
            AnalyticsTracker.INSTANCE.quickSwitcherOpen();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetQuickMentionsDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/quickmentions/WidgetQuickMentionsDialog$TabsAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "()I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Landroidx/fragment/app/Fragment;", "createFragment", "(I)Landroidx/fragment/app/Fragment;", "getItemTitleResId", "(I)I", "", "searchText", "Ljava/lang/String;", "Lcom/discord/widgets/quickmentions/WidgetQuickMentionsDialog;", "fragment", "<init>", "(Lcom/discord/widgets/quickmentions/WidgetQuickMentionsDialog;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class TabsAdapter extends FragmentStateAdapter {
        private final String searchText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabsAdapter(WidgetQuickMentionsDialog widgetQuickMentionsDialog, String str) {
            super(widgetQuickMentionsDialog);
            Intrinsics3.checkNotNullParameter(widgetQuickMentionsDialog, "fragment");
            this.searchText = str;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            if (position == 0) {
                return WidgetGlobalSearch.INSTANCE.create(this.searchText);
            }
            if (position == 1) {
                return WidgetUserMentions.INSTANCE.create(true);
            }
            throw new UnsupportedOperationException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getPageSize() {
            return 2;
        }

        public final int getItemTitleResId(int position) {
            if (position == 0) {
                return R.string.search;
            }
            if (position == 1) {
                return R.string.mentions;
            }
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: WidgetQuickMentionsDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.quickmentions.WidgetQuickMentionsDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            WidgetQuickMentionsDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetQuickMentionsDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "invoke", "(Lcom/google/android/material/tabs/TabLayout$Tab;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.quickmentions.WidgetQuickMentionsDialog$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<TabLayout.Tab, Integer, Unit> {
        public final /* synthetic */ TabsAdapter $adapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TabsAdapter tabsAdapter) {
            super(2);
            this.$adapter = tabsAdapter;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.a;
        }

        public final void invoke(TabLayout.Tab tab, int i) {
            Intrinsics3.checkNotNullParameter(tab, "tab");
            tab.setText(WidgetQuickMentionsDialog.this.getString(this.$adapter.getItemTitleResId(i)));
        }
    }

    public WidgetQuickMentionsDialog() {
        super(R.layout.widget_quick_mentions_dialog);
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetQuickMentionsDialog$$special$$inlined$activityViewModels$1(this), new WidgetQuickMentionsDialog$$special$$inlined$activityViewModels$2(this));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetQuickMentionsDialog2.INSTANCE, null, 2, null);
    }

    private final WidgetQuickMentionsDialogBinding getBinding() {
        return (WidgetQuickMentionsDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setStyle(0, 2131951656);
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        if (!AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            window.getAttributes().windowAnimations = 2131952508;
        }
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(53);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getDismissViewModel().getDismissEvents(), this, null, 2, null), WidgetQuickMentionsDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        TabsAdapter tabsAdapter = new TabsAdapter(this, requireArguments().getString(WidgetGlobalSearch.EXTRA_SEARCH_TEXT));
        ViewPager2 viewPager2 = getBinding().f2516b;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.tabContents");
        viewPager2.setAdapter(tabsAdapter);
        TabLayout tabLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        ViewPager2 viewPager22 = getBinding().f2516b;
        Intrinsics3.checkNotNullExpressionValue(viewPager22, "binding.tabContents");
        ViewPager2Extensions.setUpWithViewPager2(tabLayout, viewPager22, new AnonymousClass2(tabsAdapter));
    }
}
