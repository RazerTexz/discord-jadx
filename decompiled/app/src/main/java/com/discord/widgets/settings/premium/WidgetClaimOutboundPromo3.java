package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetClaimOutboundPromoBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetClaimOutboundPromo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetClaimOutboundPromo3 extends FunctionReferenceImpl implements Function1<View, WidgetClaimOutboundPromoBinding> {
    public static final WidgetClaimOutboundPromo3 INSTANCE = new WidgetClaimOutboundPromo3();

    public WidgetClaimOutboundPromo3() {
        super(1, WidgetClaimOutboundPromoBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetClaimOutboundPromoBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetClaimOutboundPromoBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetClaimOutboundPromoBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.claimPromoBody;
        TextView textView = (TextView) view.findViewById(R.id.claimPromoBody);
        if (textView != null) {
            i = R.id.claimPromoCode;
            TextView textView2 = (TextView) view.findViewById(R.id.claimPromoCode);
            if (textView2 != null) {
                i = R.id.claimPromoCodeBox;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.claimPromoCodeBox);
                if (linearLayout != null) {
                    i = R.id.claimPromoCopyButton;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.claimPromoCopyButton);
                    if (materialButton != null) {
                        i = R.id.claimPromoFailure;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.claimPromoFailure);
                        if (linearLayoutCompat != null) {
                            i = R.id.claimPromoFailureCloseButton;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.claimPromoFailureCloseButton);
                            if (materialButton2 != null) {
                                i = R.id.claimPromoFlipper;
                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.claimPromoFlipper);
                                if (appViewFlipper != null) {
                                    i = R.id.claimPromoLoading;
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.claimPromoLoading);
                                    if (frameLayout != null) {
                                        i = R.id.claimPromoMaybeLaterButton;
                                        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.claimPromoMaybeLaterButton);
                                        if (materialButton3 != null) {
                                            i = R.id.claimPromoRedeemButton;
                                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(R.id.claimPromoRedeemButton);
                                            if (materialButton4 != null) {
                                                i = R.id.claimPromoSuccess;
                                                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.claimPromoSuccess);
                                                if (linearLayoutCompat2 != null) {
                                                    return new WidgetClaimOutboundPromoBinding((LinearLayoutCompat) view, textView, textView2, linearLayout, materialButton, linearLayoutCompat, materialButton2, appViewFlipper, frameLayout, materialButton3, materialButton4, linearLayoutCompat2);
                                                }
                                            }
                                        }
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
