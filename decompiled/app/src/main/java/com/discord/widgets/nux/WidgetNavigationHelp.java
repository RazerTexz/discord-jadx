package com.discord.widgets.nux;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetNavigationHelpBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.recycler.ViewPager2Extensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetNavigationHelp.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/nux/WidgetNavigationHelp;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "onStart", "()V", "Lcom/discord/databinding/WidgetNavigationHelpBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetNavigationHelpBinding;", "binding", "<init>", "Companion", "NuxChannelsPageFragment", "NuxDmsPageFragment", "NuxGuildsPageFragment", "NuxPagerAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetNavigationHelp extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetNavigationHelp.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNavigationHelpBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetNavigationHelp.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/nux/WidgetNavigationHelp$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "show", "(Landroidx/fragment/app/FragmentManager;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            AnalyticsTracker.openModal$default("Help Nav", "Guild List", null, 4, null);
            new WidgetNavigationHelp().show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/nux/WidgetNavigationHelp$NuxChannelsPageFragment;", "Lcom/discord/app/AppFragment;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class NuxChannelsPageFragment extends AppFragment {
        public NuxChannelsPageFragment() {
            super(R.layout.widget_navigation_help_nux_channels);
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/nux/WidgetNavigationHelp$NuxDmsPageFragment;", "Lcom/discord/app/AppFragment;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class NuxDmsPageFragment extends AppFragment {
        public NuxDmsPageFragment() {
            super(R.layout.widget_navigation_help_nux_dms);
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/nux/WidgetNavigationHelp$NuxGuildsPageFragment;", "Lcom/discord/app/AppFragment;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class NuxGuildsPageFragment extends AppFragment {
        public NuxGuildsPageFragment() {
            super(R.layout.widget_navigation_help_nux_guilds);
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/nux/WidgetNavigationHelp$NuxPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "()I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Landroidx/fragment/app/Fragment;", "createFragment", "(I)Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class NuxPagerAdapter extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NuxPagerAdapter(Fragment fragment) {
            super(fragment);
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            if (position == 0) {
                return new NuxGuildsPageFragment();
            }
            if (position == 1) {
                return new NuxChannelsPageFragment();
            }
            if (position == 2) {
                return new NuxDmsPageFragment();
            }
            throw new IllegalStateException(outline.q("unknown nux page: ", position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getPageSize() {
            return 3;
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetNavigationHelp$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNavigationHelp.this.dismissAllowingStateLoss();
        }
    }

    public WidgetNavigationHelp() {
        super(R.layout.widget_navigation_help);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNavigationHelp2.INSTANCE, null, 2, null);
    }

    private final WidgetNavigationHelpBinding getBinding() {
        return (WidgetNavigationHelpBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.9f);
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(53);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().d.setPageTransformer(new MarginPageTransformer(DimenUtils.dpToPixels(8)));
        ViewPager2 viewPager2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.navigationHelpNuxPager");
        viewPager2.setAdapter(new NuxPagerAdapter(this));
        TabLayout tabLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.navigationHelpIndicators");
        ViewPager2 viewPager22 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(viewPager22, "binding.navigationHelpNuxPager");
        ViewPager2Extensions.setUpWithViewPager2$default(tabLayout, viewPager22, null, 2, null);
        getBinding().f2499b.setOnClickListener(new AnonymousClass1());
    }
}
