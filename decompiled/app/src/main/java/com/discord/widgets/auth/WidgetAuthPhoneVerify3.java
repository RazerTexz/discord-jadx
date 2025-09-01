package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthPhoneVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthPhoneVerify3 extends FunctionReferenceImpl implements Function1<View, WidgetAuthPhoneVerifyBinding> {
    public static final WidgetAuthPhoneVerify3 INSTANCE = new WidgetAuthPhoneVerify3();

    public WidgetAuthPhoneVerify3() {
        super(1, WidgetAuthPhoneVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthPhoneVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthPhoneVerifyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_phone_bailout;
        TextView textView = (TextView) view.findViewById(R.id.auth_phone_bailout);
        if (textView != null) {
            i = R.id.auth_phone_verify_code;
            CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R.id.auth_phone_verify_code);
            if (codeVerificationView != null) {
                i = R.id.auth_phone_verify_resend;
                TextView textView2 = (TextView) view.findViewById(R.id.auth_phone_verify_resend);
                if (textView2 != null) {
                    i = R.id.auth_phone_verify_subtitle;
                    TextView textView3 = (TextView) view.findViewById(R.id.auth_phone_verify_subtitle);
                    if (textView3 != null) {
                        i = R.id.auth_phone_verify_title;
                        TextView textView4 = (TextView) view.findViewById(R.id.auth_phone_verify_title);
                        if (textView4 != null) {
                            i = R.id.dimmer_view;
                            DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                            if (dimmerView != null) {
                                return new WidgetAuthPhoneVerifyBinding((CoordinatorLayout) view, textView, codeVerificationView, textView2, textView3, textView4, dimmerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
