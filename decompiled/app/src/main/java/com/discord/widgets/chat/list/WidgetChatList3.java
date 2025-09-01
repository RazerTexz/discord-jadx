package com.discord.widgets.chat.list;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatListBinding;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/databinding/WidgetChatListBinding;", "binding", "", "invoke", "(Lcom/discord/databinding/WidgetChatListBinding;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.WidgetChatList$binding$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatList3 extends Lambda implements Function1<WidgetChatListBinding, Unit> {
    public final /* synthetic */ WidgetChatList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatList3(WidgetChatList widgetChatList) {
        super(1);
        this.this$0 = widgetChatList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListBinding widgetChatListBinding) {
        invoke2(widgetChatListBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListBinding widgetChatListBinding) {
        Intrinsics3.checkNotNullParameter(widgetChatListBinding, "binding");
        RecyclerView recyclerView = widgetChatListBinding.f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setLayoutManager(null);
        RecyclerView recyclerView2 = widgetChatListBinding.f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.chatListRecycler");
        recyclerView2.setAdapter(null);
        WidgetChatListAdapter widgetChatListAdapterAccess$getAdapter$p = WidgetChatList.access$getAdapter$p(this.this$0);
        if (widgetChatListAdapterAccess$getAdapter$p != null) {
            widgetChatListAdapterAccess$getAdapter$p.dispose();
        }
    }
}
