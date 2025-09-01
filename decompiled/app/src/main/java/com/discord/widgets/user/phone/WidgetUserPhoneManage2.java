package com.discord.widgets.user.phone;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetUserPhoneManageBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserPhoneManage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetUserPhoneManageBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPhoneManageBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneManage2 extends FunctionReferenceImpl implements Function1<View, WidgetUserPhoneManageBinding> {
    public static final WidgetUserPhoneManage2 INSTANCE = new WidgetUserPhoneManage2();

    public WidgetUserPhoneManage2() {
        super(1, WidgetUserPhoneManageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPhoneManageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserPhoneManageBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserPhoneManageBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.remove_phone;
            TextView textView = (TextView) view.findViewById(R.id.remove_phone);
            if (textView != null) {
                i = R.id.user_phone_add_description_note;
                TextView textView2 = (TextView) view.findViewById(R.id.user_phone_add_description_note);
                if (textView2 != null) {
                    i = R.id.user_phone_add_next;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.user_phone_add_next);
                    if (materialButton != null) {
                        i = R.id.user_phone_add_number;
                        PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) view.findViewById(R.id.user_phone_add_number);
                        if (phoneOrEmailInputView != null) {
                            i = R.id.user_phone_title;
                            TextView textView3 = (TextView) view.findViewById(R.id.user_phone_title);
                            if (textView3 != null) {
                                return new WidgetUserPhoneManageBinding((FrameLayout) view, dimmerView, textView, textView2, materialButton, phoneOrEmailInputView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
