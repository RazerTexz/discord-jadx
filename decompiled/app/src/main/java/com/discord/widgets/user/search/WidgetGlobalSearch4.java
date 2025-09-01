package com.discord.widgets.user.search;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGlobalSearchBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGlobalSearchBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGlobalSearchBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearch4 extends FunctionReferenceImpl implements Function1<View, WidgetGlobalSearchBinding> {
    public static final WidgetGlobalSearch4 INSTANCE = new WidgetGlobalSearch4();

    public WidgetGlobalSearch4() {
        super(1, WidgetGlobalSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGlobalSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.global_search_add_a_friend_btn;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.global_search_add_a_friend_btn);
        if (materialButton != null) {
            i = R.id.global_search_bar;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.global_search_bar);
            if (textInputLayout != null) {
                i = R.id.global_search_bar_text;
                TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.global_search_bar_text);
                if (textInputEditText != null) {
                    i = R.id.global_search_guild_list;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.global_search_guild_list);
                    if (recyclerView != null) {
                        i = R.id.global_search_join_guild_btn;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.global_search_join_guild_btn);
                        if (materialButton2 != null) {
                            i = R.id.global_search_recycler;
                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.global_search_recycler);
                            if (recyclerView2 != null) {
                                i = R.id.global_search_view_flipper;
                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.global_search_view_flipper);
                                if (appViewFlipper != null) {
                                    return new WidgetGlobalSearchBinding((CoordinatorLayout) view, materialButton, textInputLayout, textInputEditText, recyclerView, materialButton2, recyclerView2, appViewFlipper);
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
