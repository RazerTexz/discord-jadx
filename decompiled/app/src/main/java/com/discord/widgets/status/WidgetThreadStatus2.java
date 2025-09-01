package com.discord.widgets.status;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetThreadStatusBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetThreadStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetThreadStatusBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadStatusBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetThreadStatus$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadStatus2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadStatusBinding> {
    public static final WidgetThreadStatus2 INSTANCE = new WidgetThreadStatus2();

    public WidgetThreadStatus2() {
        super(1, WidgetThreadStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadStatusBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.thread_status_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.thread_status_button);
        if (loadingButton != null) {
            i = R.id.thread_status_text;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.thread_status_text);
            if (linkifiedTextView != null) {
                return new WidgetThreadStatusBinding((ConstraintLayout) view, constraintLayout, loadingButton, linkifiedTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
