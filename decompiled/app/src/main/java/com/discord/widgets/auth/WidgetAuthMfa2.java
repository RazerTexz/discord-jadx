package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthMfaBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthMfa.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetAuthMfaBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthMfaBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthMfa$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthMfa2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthMfaBinding> {
    public static final WidgetAuthMfa2 INSTANCE = new WidgetAuthMfa2();

    public WidgetAuthMfa2() {
        super(1, WidgetAuthMfaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthMfaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthMfaBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthMfaBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_login_forgot_password;
        TextView textView = (TextView) view.findViewById(R.id.auth_login_forgot_password);
        if (textView != null) {
            i = R.id.auth_mfa_verification;
            CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R.id.auth_mfa_verification);
            if (codeVerificationView != null) {
                i = R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                if (dimmerView != null) {
                    return new WidgetAuthMfaBinding((CoordinatorLayout) view, textView, codeVerificationView, dimmerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
