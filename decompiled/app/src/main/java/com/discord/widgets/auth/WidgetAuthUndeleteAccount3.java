package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetAuthUndeleteAccountBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetAuthUndeleteAccount.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetAuthUndeleteAccountBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthUndeleteAccountBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthUndeleteAccount$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthUndeleteAccount3 extends FunctionReferenceImpl implements Function1<View, WidgetAuthUndeleteAccountBinding> {
    public static final WidgetAuthUndeleteAccount3 INSTANCE = new WidgetAuthUndeleteAccount3();

    public WidgetAuthUndeleteAccount3() {
        super(1, WidgetAuthUndeleteAccountBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthUndeleteAccountBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthUndeleteAccountBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthUndeleteAccountBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.auth_undelete_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.auth_undelete_cancel);
        if (materialButton != null) {
            i = R.id.auth_undelete_delete;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.auth_undelete_delete);
            if (materialButton2 != null) {
                i = R.id.auth_undelete_title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.auth_undelete_title);
                if (screenTitleView != null) {
                    return new WidgetAuthUndeleteAccountBinding((CoordinatorLayout) view, materialButton, materialButton2, screenTitleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
