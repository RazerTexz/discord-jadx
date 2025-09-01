package com.discord.widgets.servers.member_verification;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetMemberVerificationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CustomAppBarLayout;
import com.discord.views.LoadingButton;
import com.discord.views.MemberVerificationAvatarView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetMemberVerification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetMemberVerificationBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetMemberVerification2 extends FunctionReferenceImpl implements Function1<View, WidgetMemberVerificationBinding> {
    public static final WidgetMemberVerification2 INSTANCE = new WidgetMemberVerification2();

    public WidgetMemberVerification2() {
        super(1, WidgetMemberVerificationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMemberVerificationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMemberVerificationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.app_bar_layout;
        CustomAppBarLayout customAppBarLayout = (CustomAppBarLayout) view.findViewById(R.id.app_bar_layout);
        if (customAppBarLayout != null) {
            i = R.id.collapsing_toolbar;
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
            if (collapsingToolbarLayout != null) {
                i = R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                if (dimmerView != null) {
                    i = R.id.member_verification_container;
                    MemberVerificationView memberVerificationView = (MemberVerificationView) view.findViewById(R.id.member_verification_container);
                    if (memberVerificationView != null) {
                        i = R.id.member_verification_guild_icon;
                        MemberVerificationAvatarView memberVerificationAvatarView = (MemberVerificationAvatarView) view.findViewById(R.id.member_verification_guild_icon);
                        if (memberVerificationAvatarView != null) {
                            i = R.id.member_verification_rules_confirm;
                            LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.member_verification_rules_confirm);
                            if (loadingButton != null) {
                                i = R.id.member_verification_rules_recycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.member_verification_rules_recycler);
                                if (recyclerView != null) {
                                    i = R.id.member_verification_scrollview;
                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.member_verification_scrollview);
                                    if (nestedScrollView != null) {
                                        return new WidgetMemberVerificationBinding((CoordinatorLayout) view, customAppBarLayout, collapsingToolbarLayout, dimmerView, memberVerificationView, memberVerificationAvatarView, loadingButton, recyclerView, nestedScrollView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
