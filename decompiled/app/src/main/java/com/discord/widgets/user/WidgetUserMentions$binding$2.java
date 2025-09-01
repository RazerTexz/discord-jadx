package com.discord.widgets.user;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetUserMentionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetUserMentionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMentionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMentions$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetUserMentionsBinding> {
    public static final WidgetUserMentions$binding$2 INSTANCE = new WidgetUserMentions$binding$2();

    public WidgetUserMentions$binding$2() {
        super(1, WidgetUserMentionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMentionsBinding;", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserMentionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = R.id.user_mentions_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.user_mentions_list);
            if (recyclerView != null) {
                return new WidgetUserMentionsBinding((CoordinatorLayout) view, toolbar, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserMentionsBinding invoke(View view) {
        return invoke2(view);
    }
}
