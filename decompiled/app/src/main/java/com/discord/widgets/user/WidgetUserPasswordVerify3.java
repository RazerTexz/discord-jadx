package com.discord.widgets.user;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetUserPasswordVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserPasswordVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPasswordVerify3 extends FunctionReferenceImpl implements Function1<View, WidgetUserPasswordVerifyBinding> {
    public static final WidgetUserPasswordVerify3 INSTANCE = new WidgetUserPasswordVerify3();

    public WidgetUserPasswordVerify3() {
        super(1, WidgetUserPasswordVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPasswordVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserPasswordVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserPasswordVerifyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.edit_account_password_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.edit_account_password_wrap);
            if (textInputLayout != null) {
                i = R.id.settings_account_save;
                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.settings_account_save);
                if (floatingActionButton != null) {
                    return new WidgetUserPasswordVerifyBinding((CoordinatorLayout) view, dimmerView, textInputLayout, floatingActionButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
