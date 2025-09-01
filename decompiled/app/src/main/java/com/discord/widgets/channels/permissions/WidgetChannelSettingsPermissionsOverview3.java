package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelSettingsPermissionsOverviewBinding;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$viewBinding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsOverview3 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSettingsPermissionsOverviewBinding> {
    public static final WidgetChannelSettingsPermissionsOverview3 INSTANCE = new WidgetChannelSettingsPermissionsOverview3();

    public WidgetChannelSettingsPermissionsOverview3() {
        super(1, WidgetChannelSettingsPermissionsOverviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsOverviewBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsPermissionsOverviewBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.advanced_permissions_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.advanced_permissions_fragment);
        if (fragmentContainerView != null) {
            i = R.id.flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.flipper);
            if (appViewFlipper != null) {
                i = R.id.segmented_control;
                SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(R.id.segmented_control);
                if (segmentedControlContainer != null) {
                    i = R.id.stage_moderator_permissions_fragment;
                    FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R.id.stage_moderator_permissions_fragment);
                    if (fragmentContainerView2 != null) {
                        return new WidgetChannelSettingsPermissionsOverviewBinding((CoordinatorLayout) view, fragmentContainerView, appViewFlipper, segmentedControlContainer, fragmentContainerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
