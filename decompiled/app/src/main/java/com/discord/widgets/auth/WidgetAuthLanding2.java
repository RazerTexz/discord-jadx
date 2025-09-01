package com.discord.widgets.auth;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAuthLandingBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthLanding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetAuthLandingBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthLandingBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthLanding$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLanding2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthLandingBinding> {
    public static final WidgetAuthLanding2 INSTANCE = new WidgetAuthLanding2();

    public WidgetAuthLanding2() {
        super(1, WidgetAuthLandingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthLandingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthLandingBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthLandingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_bottom_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.auth_bottom_container);
        if (linearLayout != null) {
            i = R.id.auth_landing_invite_info;
            AuthInviteInfoView authInviteInfoView = (AuthInviteInfoView) view.findViewById(R.id.auth_landing_invite_info);
            if (authInviteInfoView != null) {
                i = R.id.auth_landing_login;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.auth_landing_login);
                if (materialButton != null) {
                    i = R.id.auth_landing_logo;
                    ImageView imageView = (ImageView) view.findViewById(R.id.auth_landing_logo);
                    if (imageView != null) {
                        i = R.id.auth_landing_register;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.auth_landing_register);
                        if (materialButton2 != null) {
                            i = R.id.auth_landing_switch_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.auth_landing_switch_flipper);
                            if (appViewFlipper != null) {
                                i = R.id.auth_landing_title;
                                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.auth_landing_title);
                                if (screenTitleView != null) {
                                    return new WidgetAuthLandingBinding((RelativeLayout) view, linearLayout, authInviteInfoView, materialButton, imageView, materialButton2, appViewFlipper, screenTitleView);
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
