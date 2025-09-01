package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthAgeGatedBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthAgeGated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetAuthAgeGatedBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthAgeGatedBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthAgeGated$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthAgeGated2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthAgeGatedBinding> {
    public static final WidgetAuthAgeGated2 INSTANCE = new WidgetAuthAgeGated2();

    public WidgetAuthAgeGated2() {
        super(1, WidgetAuthAgeGatedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthAgeGatedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthAgeGatedBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthAgeGatedBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_register_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.auth_register_container);
        if (linearLayout != null) {
            i = R.id.auth_register_underage_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.auth_register_underage_button);
            if (materialButton != null) {
                i = R.id.auth_register_underage_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.auth_register_underage_description);
                if (linkifiedTextView != null) {
                    return new WidgetAuthAgeGatedBinding((CoordinatorLayout) view, linearLayout, materialButton, linkifiedTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
