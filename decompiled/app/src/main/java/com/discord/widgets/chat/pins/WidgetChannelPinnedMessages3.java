package com.discord.widgets.chat.pins;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelPinnedMessagesBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelPinnedMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelPinnedMessages3 extends FunctionReferenceImpl implements Function1<View, WidgetChannelPinnedMessagesBinding> {
    public static final WidgetChannelPinnedMessages3 INSTANCE = new WidgetChannelPinnedMessages3();

    public WidgetChannelPinnedMessages3() {
        super(1, WidgetChannelPinnedMessagesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelPinnedMessagesBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelPinnedMessagesBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.channel_pinned_messages_recycler);
        if (recyclerView != null) {
            return new WidgetChannelPinnedMessagesBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.channel_pinned_messages_recycler)));
    }
}
