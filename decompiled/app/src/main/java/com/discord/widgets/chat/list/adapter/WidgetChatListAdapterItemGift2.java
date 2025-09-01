package com.discord.widgets.chat.list.adapter;

import android.view.View;
import b.a.a.a0.WidgetGiftAcceptDialog;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemGift.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift2 implements View.OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemGift.Model.Resolved $model$inlined;
    public final /* synthetic */ WidgetChatListAdapterItemGift this$0;

    public WidgetChatListAdapterItemGift2(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, WidgetChatListAdapterItemGift.Model.Resolved resolved) {
        this.this$0 = widgetChatListAdapterItemGift;
        this.$model$inlined = resolved;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGiftAcceptDialog.INSTANCE.a(this.$model$inlined.getGift().getCode(), "Embed", WidgetChatListAdapterItemGift.access$getItem$p(this.this$0).getChannelId());
    }
}
