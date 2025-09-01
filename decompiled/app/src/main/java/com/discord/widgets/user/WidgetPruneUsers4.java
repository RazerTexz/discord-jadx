package com.discord.widgets.user;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetPruneUsersBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPruneUsers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetPruneUsersBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetPruneUsersBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetPruneUsers$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetPruneUsers4 extends FunctionReferenceImpl implements Function1<View, WidgetPruneUsersBinding> {
    public static final WidgetPruneUsers4 INSTANCE = new WidgetPruneUsers4();

    public WidgetPruneUsers4() {
        super(1, WidgetPruneUsersBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPruneUsersBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPruneUsersBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPruneUsersBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.prune_user_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.prune_user_cancel);
        if (materialButton != null) {
            i = R.id.prune_user_header;
            TextView textView = (TextView) view.findViewById(R.id.prune_user_header);
            if (textView != null) {
                i = R.id.prune_user_prune;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.prune_user_prune);
                if (materialButton2 != null) {
                    i = R.id.prune_users_estimate_text;
                    TextView textView2 = (TextView) view.findViewById(R.id.prune_users_estimate_text);
                    if (textView2 != null) {
                        i = R.id.prune_users_history_1_radio;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.prune_users_history_1_radio);
                        if (checkedSetting != null) {
                            i = R.id.prune_users_history_2_radio;
                            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.prune_users_history_2_radio);
                            if (checkedSetting2 != null) {
                                i = R.id.prune_users_loading_progressbar;
                                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.prune_users_loading_progressbar);
                                if (progressBar != null) {
                                    return new WidgetPruneUsersBinding((ScrollView) view, materialButton, textView, materialButton2, textView2, checkedSetting, checkedSetting2, progressBar);
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
