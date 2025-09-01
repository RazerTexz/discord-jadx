package com.discord.widgets.user.phone;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.discord.R;
import com.discord.databinding.WidgetUserPhoneVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserPhoneVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneVerify6 extends FunctionReferenceImpl implements Function1<View, WidgetUserPhoneVerifyBinding> {
    public static final WidgetUserPhoneVerify6 INSTANCE = new WidgetUserPhoneVerify6();

    public WidgetUserPhoneVerify6() {
        super(1, WidgetUserPhoneVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserPhoneVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserPhoneVerifyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.close_button;
        ImageView imageView = (ImageView) view.findViewById(R.id.close_button);
        if (imageView != null) {
            i = R.id.dimmer_view;
            DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
            if (dimmerView != null) {
                i = R.id.phone_digit_verification_view;
                CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R.id.phone_digit_verification_view);
                if (codeVerificationView != null) {
                    return new WidgetUserPhoneVerifyBinding((RelativeLayout) view, imageView, dimmerView, codeVerificationView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
