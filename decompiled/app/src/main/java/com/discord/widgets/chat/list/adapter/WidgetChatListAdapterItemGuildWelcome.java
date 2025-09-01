package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.d.AppHelpDesk;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemGuildWelcomeBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChatListAdapterItemGuildWelcome.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildWelcome;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/databinding/WidgetChatListAdapterItemGuildWelcomeBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemGuildWelcomeBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;Lcom/discord/utilities/time/Clock;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildWelcome extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildWelcomeBinding binding;
    private final Clock clock;

    /* compiled from: WidgetChatListAdapterItemGuildWelcome.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ChatListEntry $data;

        public AnonymousClass1(ChatListEntry chatListEntry) {
            this.$data = chatListEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.INSTANCE.create(outline.x(view, "view", "view.context"), ((GuildWelcomeEntry) this.$data).getGuildId(), true);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildWelcome.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ ChatListEntry $data;

        public AnonymousClass2(ChatListEntry chatListEntry) {
            this.$data = chatListEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildInviteShare.Companion.launch$default(WidgetGuildInviteShare.INSTANCE, outline.x(view, "view", "view.context"), WidgetChatListAdapterItemGuildWelcome.access$getAdapter$p(WidgetChatListAdapterItemGuildWelcome.this).getFragmentManager(), ((GuildWelcomeEntry) this.$data).getGuildId(), null, false, null, null, "Welcome Message", 120, null);
        }
    }

    public /* synthetic */ WidgetChatListAdapterItemGuildWelcome(WidgetChatListAdapter widgetChatListAdapter, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetChatListAdapter, (i & 2) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGuildWelcome widgetChatListAdapterItemGuildWelcome) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGuildWelcome.adapter;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildWelcome(WidgetChatListAdapter widgetChatListAdapter, Clock clock) {
        super(R.layout.widget_chat_list_adapter_item_guild_welcome, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        View view = this.itemView;
        int i = R.id.item_guild_welcome_header;
        TextView textView = (TextView) view.findViewById(R.id.item_guild_welcome_header);
        if (textView != null) {
            i = R.id.item_guild_welcome_subheader;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.item_guild_welcome_subheader);
            if (linkifiedTextView != null) {
                i = R.id.item_guild_welcome_subheader_intro;
                LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) view.findViewById(R.id.item_guild_welcome_subheader_intro);
                if (linkifiedTextView2 != null) {
                    i = R.id.welcome_card_invite_friends;
                    ChatActionItem chatActionItem = (ChatActionItem) view.findViewById(R.id.welcome_card_invite_friends);
                    if (chatActionItem != null) {
                        i = R.id.welcome_card_upload_icon;
                        ChatActionItem chatActionItem2 = (ChatActionItem) view.findViewById(R.id.welcome_card_upload_icon);
                        if (chatActionItem2 != null) {
                            WidgetChatListAdapterItemGuildWelcomeBinding widgetChatListAdapterItemGuildWelcomeBinding = new WidgetChatListAdapterItemGuildWelcomeBinding((LinearLayout) view, textView, linkifiedTextView, linkifiedTextView2, chatActionItem, chatActionItem2);
                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGuildWelcomeBinding, "WidgetChatListAdapterIte…omeBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemGuildWelcomeBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof GuildWelcomeEntry) {
            TextView textView = this.binding.f2324b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemGuildWelcomeHeader");
            boolean z2 = true;
            GuildWelcomeEntry guildWelcomeEntry = (GuildWelcomeEntry) data;
            FormatUtils.n(textView, R.string.welcome_cta_title_mobile, new Object[]{guildWelcomeEntry.getGuildName()}, null, 4);
            boolean z3 = (guildWelcomeEntry.getGuildId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH < this.clock.currentTimeMillis() - WidgetChatListAdapterItemGuildWelcome2.OLD_GUILD_AGE_THRESHOLD;
            ChatActionItem chatActionItem = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(chatActionItem, "binding.welcomeCardUploadIcon");
            chatActionItem.setVisibility(!guildWelcomeEntry.getGuildHasIcon() && guildWelcomeEntry.isOwner() ? 0 : 8);
            this.binding.f.setOnClickListener(new AnonymousClass1(data));
            ChatActionItem chatActionItem2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(chatActionItem2, "binding.welcomeCardInviteFriends");
            chatActionItem2.setVisibility(guildWelcomeEntry.getCanInvite() ? 0 : 8);
            this.binding.e.setOnClickListener(new AnonymousClass2(data));
            String strJ = outline.J(new StringBuilder(), AppHelpDesk.a.a(360045138571L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-new-user&utm_content=--t%3Apm");
            LinkifiedTextView linkifiedTextView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.itemGuildWelcomeSubheaderIntro");
            FormatUtils.n(linkifiedTextView, R.string.welcome_cta_subtitle_action_with_guide, new Object[]{strJ}, null, 4);
            LinkifiedTextView linkifiedTextView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.itemGuildWelcomeSubheaderIntro");
            ChatActionItem chatActionItem3 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(chatActionItem3, "binding.welcomeCardUploadIcon");
            if (!(chatActionItem3.getVisibility() == 0)) {
                ChatActionItem chatActionItem4 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(chatActionItem4, "binding.welcomeCardInviteFriends");
                if (!(chatActionItem4.getVisibility() == 0)) {
                    z2 = false;
                }
            }
            linkifiedTextView2.setVisibility(z2 ? 0 : 8);
            LinkifiedTextView linkifiedTextView3 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "binding.itemGuildWelcomeSubheader");
            FormatUtils.n(linkifiedTextView3, z3 ? R.string.welcome_cta_subtitle_existing_server : guildWelcomeEntry.isOwner() ? R.string.welcome_cta_subtitle_owner : R.string.welcome_cta_subtitle_member, new Object[0], null, 4);
        }
    }
}
