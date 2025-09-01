package com.discord.widgets.settings.billing;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.discord.R;
import com.discord.databinding.WidgetPaymentSourceEditDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPaymentSourceEditDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetPaymentSourceEditDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetPaymentSourceEditDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetPaymentSourceEditDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetPaymentSourceEditDialogBinding> {
    public static final WidgetPaymentSourceEditDialog2 INSTANCE = new WidgetPaymentSourceEditDialog2();

    public WidgetPaymentSourceEditDialog2() {
        super(1, WidgetPaymentSourceEditDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPaymentSourceEditDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPaymentSourceEditDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPaymentSourceEditDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = R.id.dialog_delete;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.dialog_delete);
            if (materialButton != null) {
                i = R.id.dialog_save;
                LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.dialog_save);
                if (loadingButton != null) {
                    i = R.id.payment_source_edit_address1;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.payment_source_edit_address1);
                    if (textInputLayout != null) {
                        i = R.id.payment_source_edit_address2;
                        TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.payment_source_edit_address2);
                        if (textInputLayout2 != null) {
                            i = R.id.payment_source_edit_city;
                            TextInputLayout textInputLayout3 = (TextInputLayout) view.findViewById(R.id.payment_source_edit_city);
                            if (textInputLayout3 != null) {
                                i = R.id.payment_source_edit_country;
                                TextInputLayout textInputLayout4 = (TextInputLayout) view.findViewById(R.id.payment_source_edit_country);
                                if (textInputLayout4 != null) {
                                    i = R.id.payment_source_edit_default;
                                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.payment_source_edit_default);
                                    if (checkBox != null) {
                                        i = R.id.payment_source_edit_error;
                                        TextView textView = (TextView) view.findViewById(R.id.payment_source_edit_error);
                                        if (textView != null) {
                                            i = R.id.payment_source_edit_help;
                                            TextView textView2 = (TextView) view.findViewById(R.id.payment_source_edit_help);
                                            if (textView2 != null) {
                                                i = R.id.payment_source_edit_name;
                                                TextInputLayout textInputLayout5 = (TextInputLayout) view.findViewById(R.id.payment_source_edit_name);
                                                if (textInputLayout5 != null) {
                                                    i = R.id.payment_source_edit_postal_code;
                                                    TextInputLayout textInputLayout6 = (TextInputLayout) view.findViewById(R.id.payment_source_edit_postal_code);
                                                    if (textInputLayout6 != null) {
                                                        i = R.id.payment_source_edit_state;
                                                        TextInputLayout textInputLayout7 = (TextInputLayout) view.findViewById(R.id.payment_source_edit_state);
                                                        if (textInputLayout7 != null) {
                                                            i = R.id.payment_source_summary;
                                                            PaymentSourceView paymentSourceView = (PaymentSourceView) view.findViewById(R.id.payment_source_summary);
                                                            if (paymentSourceView != null) {
                                                                return new WidgetPaymentSourceEditDialogBinding((LinearLayout) view, toolbar, materialButton, loadingButton, textInputLayout, textInputLayout2, textInputLayout3, textInputLayout4, checkBox, textView, textView2, textInputLayout5, textInputLayout6, textInputLayout7, paymentSourceView);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
