package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemGuildInviteReminderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemGuildInviteReminder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildInviteReminder;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/databinding/WidgetChatListAdapterItemGuildInviteReminderBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemGuildInviteReminderBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildInviteReminder extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildInviteReminderBinding binding;

    /* compiled from: WidgetChatListAdapterItemGuildInviteReminder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildInviteReminder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShare.Companion.launch$default(WidgetGuildInviteShare.INSTANCE, outline.x(view, "view", "view.context"), WidgetChatListAdapterItemGuildInviteReminder.access$getAdapter$p(WidgetChatListAdapterItemGuildInviteReminder.this).getFragmentManager(), WidgetChatListAdapterItemGuildInviteReminder.access$getAdapter$p(WidgetChatListAdapterItemGuildInviteReminder.this).getData().getGuildId(), null, false, null, null, "Welcome Message", 120, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildInviteReminder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildInviteReminder$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ ChatListEntry $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ChatListEntry chatListEntry) {
            super(1);
            this.$data = chatListEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemGuildInviteReminder.access$getAdapter$p(WidgetChatListAdapterItemGuildInviteReminder.this).getEventHandler();
            Message message = ((MessageEntry) this.$data).getMessage();
            View view2 = WidgetChatListAdapterItemGuildInviteReminder.this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            String string = view2.getContext().getString(R.string.system_message_invite_users_owner);
            Intrinsics3.checkNotNullExpressionValue(string, "itemView.context.getStri…ssage_invite_users_owner)");
            eventHandler.onMessageLongClicked(message, string, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildInviteReminder(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_guild_invite_reminder, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_action_item_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.chat_action_item_button);
        if (materialButton != null) {
            i = R.id.chat_action_item_image;
            ImageView imageView = (ImageView) view.findViewById(R.id.chat_action_item_image);
            if (imageView != null) {
                i = R.id.chat_action_item_subtext;
                TextView textView = (TextView) view.findViewById(R.id.chat_action_item_subtext);
                if (textView != null) {
                    i = R.id.chat_action_item_text;
                    TextView textView2 = (TextView) view.findViewById(R.id.chat_action_item_text);
                    if (textView2 != null) {
                        WidgetChatListAdapterItemGuildInviteReminderBinding widgetChatListAdapterItemGuildInviteReminderBinding = new WidgetChatListAdapterItemGuildInviteReminderBinding((ConstraintLayout) view, materialButton, imageView, textView, textView2);
                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGuildInviteReminderBinding, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
                        this.binding = widgetChatListAdapterItemGuildInviteReminderBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGuildInviteReminder widgetChatListAdapterItemGuildInviteReminder) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGuildInviteReminder.adapter;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof MessageEntry) {
            Guild guild = ((WidgetChatListAdapter) this.adapter).getData().getGuild();
            boolean zIsOwner = guild != null ? guild.isOwner(((WidgetChatListAdapter) this.adapter).getData().getUserId()) : false;
            int i = zIsOwner ? R.string.system_message_invite_users_owner : R.string.system_message_invite_users;
            int i2 = zIsOwner ? R.string.system_message_invite_users_description_owner : R.string.system_message_invite_users_description;
            this.binding.d.setText(i);
            this.binding.c.setText(i2);
            this.binding.f2321b.setOnClickListener(new AnonymousClass1());
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new AnonymousClass2(data));
        }
    }
}
