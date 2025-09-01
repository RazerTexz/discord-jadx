package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.WidgetEnableMfaStepsBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.steps.StepsView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEnableMFASteps.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFASteps2 extends FunctionReferenceImpl implements Function1<View, WidgetEnableMfaStepsBinding> {
    public static final WidgetEnableMFASteps2 INSTANCE = new WidgetEnableMFASteps2();

    public WidgetEnableMFASteps2() {
        super(1, WidgetEnableMfaStepsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEnableMfaStepsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEnableMfaStepsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.enable_mfa_stepsview;
            StepsView stepsView = (StepsView) view.findViewById(R.id.enable_mfa_stepsview);
            if (stepsView != null) {
                return new WidgetEnableMfaStepsBinding((FrameLayout) view, dimmerView, stepsView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
