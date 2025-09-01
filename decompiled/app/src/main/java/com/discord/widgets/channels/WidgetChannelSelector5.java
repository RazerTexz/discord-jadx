package com.discord.widgets.channels;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSelectorBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelSelectorBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSelectorBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelSelector$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSelector5 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSelectorBinding> {
    public static final WidgetChannelSelector5 INSTANCE = new WidgetChannelSelector5();

    public WidgetChannelSelector5() {
        super(1, WidgetChannelSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSelectorBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSelectorBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_selector_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.channel_selector_list);
        if (recyclerView != null) {
            i = R.id.guild_actions_overview_header_tv;
            TextView textView = (TextView) view.findViewById(R.id.guild_actions_overview_header_tv);
            if (textView != null) {
                return new WidgetChannelSelectorBinding((NestedScrollView) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
