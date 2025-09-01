package com.discord.widgets.phone;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetPhoneCountryCodeBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetPhoneCountryCodeBottomSheetBinding> {
    public static final WidgetPhoneCountryCodeBottomSheet2 INSTANCE = new WidgetPhoneCountryCodeBottomSheet2();

    public WidgetPhoneCountryCodeBottomSheet2() {
        super(1, WidgetPhoneCountryCodeBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPhoneCountryCodeBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPhoneCountryCodeBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.phone_country_code_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.phone_country_code_recycler);
        if (recyclerView != null) {
            i = R.id.phone_country_code_search;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.phone_country_code_search);
            if (textInputLayout != null) {
                return new WidgetPhoneCountryCodeBottomSheetBinding((LinearLayout) view, recyclerView, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
