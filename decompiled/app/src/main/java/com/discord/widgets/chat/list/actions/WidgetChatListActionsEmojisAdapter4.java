package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatListActionsEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/chat/list/actions/MoreEmojisViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/list/actions/WidgetChatListActionsEmojisAdapter;", "Lcom/discord/widgets/chat/list/actions/EmojiItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/actions/EmojiItem;)V", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/actions/WidgetChatListActionsEmojisAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.actions.MoreEmojisViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter4 extends MGRecyclerViewHolder<WidgetChatListActionsEmojisAdapter, WidgetChatListActionsEmojisAdapter2> {

    /* compiled from: WidgetChatListActionsEmojisAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.actions.MoreEmojisViewHolder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActionsEmojisAdapter4.access$getAdapter$p(WidgetChatListActionsEmojisAdapter4.this).getOnClickMoreEmojis().invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActionsEmojisAdapter4(WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter) {
        super(R.layout.view_chat_list_actions_emoji_item_more, widgetChatListActionsEmojisAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListActionsEmojisAdapter, "adapter");
    }

    public static final /* synthetic */ WidgetChatListActionsEmojisAdapter access$getAdapter$p(WidgetChatListActionsEmojisAdapter4 widgetChatListActionsEmojisAdapter4) {
        return (WidgetChatListActionsEmojisAdapter) widgetChatListActionsEmojisAdapter4.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetChatListActionsEmojisAdapter2 widgetChatListActionsEmojisAdapter2) {
        onConfigure2(i, widgetChatListActionsEmojisAdapter2);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetChatListActionsEmojisAdapter2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        this.itemView.setOnClickListener(new AnonymousClass1());
    }
}
