package com.discord.widgets.guilds;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGuildSelectorBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildSelectorBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildSelectorBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.WidgetGuildSelector$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildSelector4 extends FunctionReferenceImpl implements Function1<View, WidgetGuildSelectorBinding> {
    public static final WidgetGuildSelector4 INSTANCE = new WidgetGuildSelector4();

    public WidgetGuildSelector4() {
        super(1, WidgetGuildSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildSelectorBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildSelectorBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = R.id.guild_selector_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.guild_selector_list);
            if (recyclerView != null) {
                return new WidgetGuildSelectorBinding((NestedScrollView) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
