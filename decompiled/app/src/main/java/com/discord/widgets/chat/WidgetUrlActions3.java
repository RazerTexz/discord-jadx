package com.discord.widgets.chat;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetUrlActionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUrlActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetUrlActionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetUrlActionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.WidgetUrlActions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetUrlActions3 extends FunctionReferenceImpl implements Function1<View, WidgetUrlActionsBinding> {
    public static final WidgetUrlActions3 INSTANCE = new WidgetUrlActions3();

    public WidgetUrlActions3() {
        super(1, WidgetUrlActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUrlActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUrlActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUrlActionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dialog_url_actions_copy;
        TextView textView = (TextView) view.findViewById(R.id.dialog_url_actions_copy);
        if (textView != null) {
            i = R.id.dialog_url_actions_open;
            TextView textView2 = (TextView) view.findViewById(R.id.dialog_url_actions_open);
            if (textView2 != null) {
                i = R.id.dialog_url_actions_share;
                TextView textView3 = (TextView) view.findViewById(R.id.dialog_url_actions_share);
                if (textView3 != null) {
                    i = R.id.dialog_url_actions_url;
                    TextView textView4 = (TextView) view.findViewById(R.id.dialog_url_actions_url);
                    if (textView4 != null) {
                        return new WidgetUrlActionsBinding((LinearLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
