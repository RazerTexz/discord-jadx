package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import b.a.i.WidgetRemoteAuthNotFoundBinding;
import b.a.i.WidgetRemoteAuthPendingLoginBinding;
import b.a.i.WidgetRemoteAuthSuccessBinding;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetRemoteAuthBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetRemoteAuth.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetRemoteAuthBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetRemoteAuthBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetRemoteAuth$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetRemoteAuth2 extends FunctionReferenceImpl implements Function1<View, WidgetRemoteAuthBinding> {
    public static final WidgetRemoteAuth2 INSTANCE = new WidgetRemoteAuth2();

    public WidgetRemoteAuth2() {
        super(1, WidgetRemoteAuthBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetRemoteAuthBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetRemoteAuthBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetRemoteAuthBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_success;
        View viewFindViewById = view.findViewById(R.id.auth_success);
        if (viewFindViewById != null) {
            MaterialButton materialButton = (MaterialButton) viewFindViewById.findViewById(R.id.remote_auth_finish_button);
            if (materialButton == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(R.id.remote_auth_finish_button)));
            }
            WidgetRemoteAuthSuccessBinding widgetRemoteAuthSuccessBinding = new WidgetRemoteAuthSuccessBinding((LinearLayout) viewFindViewById, materialButton);
            i = R.id.not_found;
            View viewFindViewById2 = view.findViewById(R.id.not_found);
            if (viewFindViewById2 != null) {
                MaterialButton materialButton2 = (MaterialButton) viewFindViewById2.findViewById(R.id.remote_auth_not_found_cancel_button);
                if (materialButton2 == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(R.id.remote_auth_not_found_cancel_button)));
                }
                WidgetRemoteAuthNotFoundBinding widgetRemoteAuthNotFoundBinding = new WidgetRemoteAuthNotFoundBinding((LinearLayout) viewFindViewById2, materialButton2);
                i = R.id.pending_login;
                View viewFindViewById3 = view.findViewById(R.id.pending_login);
                if (viewFindViewById3 != null) {
                    int i2 = R.id.remote_auth_cancel_button;
                    MaterialButton materialButton3 = (MaterialButton) viewFindViewById3.findViewById(R.id.remote_auth_cancel_button);
                    if (materialButton3 != null) {
                        i2 = R.id.remote_auth_login_button;
                        MaterialButton materialButton4 = (MaterialButton) viewFindViewById3.findViewById(R.id.remote_auth_login_button);
                        if (materialButton4 != null) {
                            i2 = R.id.remote_auth_temporary_switch;
                            SwitchMaterial switchMaterial = (SwitchMaterial) viewFindViewById3.findViewById(R.id.remote_auth_temporary_switch);
                            if (switchMaterial != null) {
                                WidgetRemoteAuthPendingLoginBinding widgetRemoteAuthPendingLoginBinding = new WidgetRemoteAuthPendingLoginBinding((LinearLayout) viewFindViewById3, materialButton3, materialButton4, switchMaterial);
                                i = R.id.remote_auth_view_flipper;
                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.remote_auth_view_flipper);
                                if (appViewFlipper != null) {
                                    return new WidgetRemoteAuthBinding((RelativeLayout) view, widgetRemoteAuthSuccessBinding, widgetRemoteAuthNotFoundBinding, widgetRemoteAuthPendingLoginBinding, appViewFlipper);
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i2)));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
