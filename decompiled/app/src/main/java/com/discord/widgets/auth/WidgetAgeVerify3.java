package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.a.i.LayoutAgeVerifyBinding;
import b.a.i.LayoutAgeVerifyConfirmBinding;
import b.a.i.LayoutAgeVerifyUnderageBinding;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAgeVerifyBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAgeVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetAgeVerifyBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetAgeVerifyBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAgeVerify$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetAgeVerify3 extends FunctionReferenceImpl implements Function1<View, WidgetAgeVerifyBinding> {
    public static final WidgetAgeVerify3 INSTANCE = new WidgetAgeVerify3();

    public WidgetAgeVerify3() {
        super(1, WidgetAgeVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAgeVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAgeVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAgeVerifyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.age_verify_view_flipper;
        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.age_verify_view_flipper);
        if (appViewFlipper != null) {
            i = R.id.confirm;
            View viewFindViewById = view.findViewById(R.id.confirm);
            if (viewFindViewById != null) {
                int i2 = R.id.age_verify_confirm_back_button;
                MaterialButton materialButton = (MaterialButton) viewFindViewById.findViewById(R.id.age_verify_confirm_back_button);
                if (materialButton != null) {
                    i2 = R.id.age_verify_confirm_button;
                    LoadingButton loadingButton = (LoadingButton) viewFindViewById.findViewById(R.id.age_verify_confirm_button);
                    if (loadingButton != null) {
                        i2 = R.id.age_verify_confirm_description;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById.findViewById(R.id.age_verify_confirm_description);
                        if (linkifiedTextView != null) {
                            i2 = R.id.age_verify_confirm_title;
                            TextView textView = (TextView) viewFindViewById.findViewById(R.id.age_verify_confirm_title);
                            if (textView != null) {
                                LayoutAgeVerifyConfirmBinding layoutAgeVerifyConfirmBinding = new LayoutAgeVerifyConfirmBinding((ConstraintLayout) viewFindViewById, materialButton, loadingButton, linkifiedTextView, textView);
                                View viewFindViewById2 = view.findViewById(R.id.underage);
                                if (viewFindViewById2 != null) {
                                    int i3 = R.id.age_verify_return_to_login_button;
                                    MaterialButton materialButton2 = (MaterialButton) viewFindViewById2.findViewById(R.id.age_verify_return_to_login_button);
                                    if (materialButton2 != null) {
                                        i3 = R.id.age_verify_underage_description;
                                        LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewFindViewById2.findViewById(R.id.age_verify_underage_description);
                                        if (linkifiedTextView2 != null) {
                                            i3 = R.id.age_verify_underage_title;
                                            TextView textView2 = (TextView) viewFindViewById2.findViewById(R.id.age_verify_underage_title);
                                            if (textView2 != null) {
                                                i3 = R.id.underage_warning;
                                                TextView textView3 = (TextView) viewFindViewById2.findViewById(R.id.underage_warning);
                                                if (textView3 != null) {
                                                    LayoutAgeVerifyUnderageBinding layoutAgeVerifyUnderageBinding = new LayoutAgeVerifyUnderageBinding((ConstraintLayout) viewFindViewById2, materialButton2, linkifiedTextView2, textView2, textView3);
                                                    View viewFindViewById3 = view.findViewById(R.id.verify);
                                                    if (viewFindViewById3 != null) {
                                                        int i4 = R.id.age_verify_description;
                                                        LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) viewFindViewById3.findViewById(R.id.age_verify_description);
                                                        if (linkifiedTextView3 != null) {
                                                            i4 = R.id.age_verify_input_wrapper;
                                                            TextInputLayout textInputLayout = (TextInputLayout) viewFindViewById3.findViewById(R.id.age_verify_input_wrapper);
                                                            if (textInputLayout != null) {
                                                                i4 = R.id.age_verify_next_button;
                                                                LoadingButton loadingButton2 = (LoadingButton) viewFindViewById3.findViewById(R.id.age_verify_next_button);
                                                                if (loadingButton2 != null) {
                                                                    i4 = R.id.age_verify_title;
                                                                    TextView textView4 = (TextView) viewFindViewById3.findViewById(R.id.age_verify_title);
                                                                    if (textView4 != null) {
                                                                        return new WidgetAgeVerifyBinding((CoordinatorLayout) view, appViewFlipper, layoutAgeVerifyConfirmBinding, layoutAgeVerifyUnderageBinding, new LayoutAgeVerifyBinding((ConstraintLayout) viewFindViewById3, linkifiedTextView3, textInputLayout, loadingButton2, textView4));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i4)));
                                                    }
                                                    i = R.id.verify;
                                                }
                                            }
                                        }
                                    }
                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i3)));
                                }
                                i = R.id.underage;
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
