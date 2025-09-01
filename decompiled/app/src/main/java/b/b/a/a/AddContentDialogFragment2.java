package b.b.a.a;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.Intrinsics3;

/* compiled from: AddContentDialogFragment.kt */
/* renamed from: b.b.a.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AddContentDialogFragment2 implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ AddContentDialogFragment a;

    public AddContentDialogFragment2(AddContentDialogFragment addContentDialogFragment) {
        this.a = addContentDialogFragment;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Intrinsics3.checkNotNullParameter(tab, "tab");
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) throws Resources.NotFoundException {
        FlexInputViewModel flexInputViewModel;
        Intrinsics3.checkNotNullParameter(tab, "tab");
        int position = tab.getPosition();
        if (position != 3) {
            ViewPager viewPager = this.a.contentPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(position);
                return;
            }
            return;
        }
        this.a.h(false);
        Fragment parentFragment = this.a.getParentFragment();
        if (!(parentFragment instanceof FlexInputFragment) || (flexInputViewModel = ((FlexInputFragment) parentFragment).viewModel) == null) {
            return;
        }
        flexInputViewModel.onCreateThreadSelected();
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Intrinsics3.checkNotNullParameter(tab, "tab");
    }
}
