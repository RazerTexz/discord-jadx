package com.discord.widgets.directories;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetDirectoriesSearchBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetDirectoriesSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetDirectoriesSearchBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoriesSearchBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoriesSearch5 extends FunctionReferenceImpl implements Function1<View, WidgetDirectoriesSearchBinding> {
    public static final WidgetDirectoriesSearch5 INSTANCE = new WidgetDirectoriesSearch5();

    public WidgetDirectoriesSearch5() {
        super(1, WidgetDirectoriesSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoriesSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDirectoriesSearchBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDirectoriesSearchBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
        if (appBarLayout != null) {
            i = R.id.barrier;
            Barrier barrier = (Barrier) view.findViewById(R.id.barrier);
            if (barrier != null) {
                i = R.id.empty_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.empty_description);
                if (linkifiedTextView != null) {
                    i = R.id.empty_state;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.empty_state);
                    if (linearLayout != null) {
                        i = R.id.empty_title;
                        TextView textView = (TextView) view.findViewById(R.id.empty_title);
                        if (textView != null) {
                            i = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                            if (recyclerView != null) {
                                i = R.id.search;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.search);
                                if (floatingActionButton != null) {
                                    i = R.id.search_bar;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.search_bar);
                                    if (textInputLayout != null) {
                                        i = R.id.search_bar_text;
                                        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.search_bar_text);
                                        if (textInputEditText != null) {
                                            return new WidgetDirectoriesSearchBinding((ConstraintLayout) view, appBarLayout, barrier, linkifiedTextView, linearLayout, textView, recyclerView, floatingActionButton, textInputLayout, textInputEditText);
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
