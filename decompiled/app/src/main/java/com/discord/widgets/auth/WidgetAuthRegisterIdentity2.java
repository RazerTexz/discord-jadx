package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthRegisterIdentityBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthRegisterIdentity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthRegisterIdentity2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthRegisterIdentityBinding> {
    public static final WidgetAuthRegisterIdentity2 INSTANCE = new WidgetAuthRegisterIdentity2();

    public WidgetAuthRegisterIdentity2() {
        super(1, WidgetAuthRegisterIdentityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthRegisterIdentityBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthRegisterIdentityBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_register_identity_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.auth_register_identity_button);
        if (materialButton != null) {
            i = R.id.auth_register_identity_first_segment_card;
            CardSegment cardSegment = (CardSegment) view.findViewById(R.id.auth_register_identity_first_segment_card);
            if (cardSegment != null) {
                i = R.id.auth_register_identity_input;
                PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) view.findViewById(R.id.auth_register_identity_input);
                if (phoneOrEmailInputView != null) {
                    i = R.id.auth_register_identity_policy_link;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.auth_register_identity_policy_link);
                    if (linkifiedTextView != null) {
                        i = R.id.auth_register_identity_second_segment_card;
                        CardSegment cardSegment2 = (CardSegment) view.findViewById(R.id.auth_register_identity_second_segment_card);
                        if (cardSegment2 != null) {
                            i = R.id.auth_register_identity_segmented_control;
                            SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(R.id.auth_register_identity_segmented_control);
                            if (segmentedControlContainer != null) {
                                i = R.id.dimmer_view;
                                DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                                if (dimmerView != null) {
                                    return new WidgetAuthRegisterIdentityBinding((CoordinatorLayout) view, materialButton, cardSegment, phoneOrEmailInputView, linkifiedTextView, cardSegment2, segmentedControlContainer, dimmerView);
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
