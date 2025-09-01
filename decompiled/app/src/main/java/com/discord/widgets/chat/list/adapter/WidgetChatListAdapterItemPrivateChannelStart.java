package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemPrivateChannelStartBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.views.PileView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StartOfPrivateChatEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemPrivateChannelStart.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemPrivateChannelStart;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "", "channelType", "getStartResId", "(I)I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/databinding/WidgetChatListAdapterItemPrivateChannelStartBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemPrivateChannelStartBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemPrivateChannelStart extends WidgetChatListItem {
    private final WidgetChatListAdapterItemPrivateChannelStartBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemPrivateChannelStart(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_private_channel_start, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_private_channel_start_header;
        TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_private_channel_start_header);
        if (textView != null) {
            i = R.id.mutual_guild_pile;
            PileView pileView = (PileView) view.findViewById(R.id.mutual_guild_pile);
            if (pileView != null) {
                i = R.id.mutual_guilds;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.mutual_guilds);
                if (linearLayout != null) {
                    i = R.id.mutual_guilds_text;
                    TextView textView2 = (TextView) view.findViewById(R.id.mutual_guilds_text);
                    if (textView2 != null) {
                        i = R.id.private_channel_start_image;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.private_channel_start_image);
                        if (simpleDraweeView != null) {
                            i = R.id.private_channel_start_text;
                            TextView textView3 = (TextView) view.findViewById(R.id.private_channel_start_text);
                            if (textView3 != null) {
                                WidgetChatListAdapterItemPrivateChannelStartBinding widgetChatListAdapterItemPrivateChannelStartBinding = new WidgetChatListAdapterItemPrivateChannelStartBinding((LinearLayout) view, textView, pileView, linearLayout, textView2, simpleDraweeView, textView3);
                                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemPrivateChannelStartBinding, "WidgetChatListAdapterIte…artBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemPrivateChannelStartBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @StringRes
    private final int getStartResId(int channelType) {
        return (channelType == 1 || channelType != 3) ? R.string.beginning_dm : R.string.beginning_group_dm;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        CharSequence charSequenceJ;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StartOfPrivateChatEntry startOfPrivateChatEntry = (StartOfPrivateChatEntry) data;
        String strComponent2 = startOfPrivateChatEntry.getChannelName();
        int iComponent3 = startOfPrivateChatEntry.getChannelType();
        String strComponent4 = startOfPrivateChatEntry.getChannelIcon();
        boolean zComponent5 = startOfPrivateChatEntry.getIsSystemDM();
        List<Guild> listComponent6 = startOfPrivateChatEntry.component6();
        if (!(!StringsJVM.isBlank(strComponent2))) {
            TextView textView = this.binding.f2328b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterI…PrivateChannelStartHeader");
            strComponent2 = textView.getContext().getString(R.string.unnamed);
            Intrinsics3.checkNotNullExpressionValue(strComponent2, "binding.chatListAdapterI…tString(R.string.unnamed)");
        }
        TextView textView2 = this.binding.f2328b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterI…PrivateChannelStartHeader");
        textView2.setText(strComponent2);
        if (strComponent4 != null) {
            SimpleDraweeView simpleDraweeView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.privateChannelStartImage");
            IconUtils.setIcon$default(simpleDraweeView, strComponent4, R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.privateChannelStartImage");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON, R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        }
        if (zComponent5) {
            this.binding.g.setText(R.string.system_dm_empty_message);
        } else {
            TextView textView3 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.privateChannelStartText");
            FormatUtils.n(textView3, getStartResId(iComponent3), new Object[]{strComponent2}, null, 4);
        }
        boolean z2 = !zComponent5 && iComponent3 == 1;
        LinearLayout linearLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.mutualGuilds");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            PileView pileView = this.binding.c;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listComponent6, 10));
            for (Guild guild : listComponent6) {
                arrayList.add(new PileView.c(new WidgetChatListAdapterItemPrivateChannelStart2(IconUtils.getForGuild$default(guild, null, false, Integer.valueOf(DimenUtils.dpToPixels(24)), 2, null)), new WidgetChatListAdapterItemPrivateChannelStart3(guild)));
            }
            pileView.setItems(arrayList);
            TextView textView4 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.mutualGuildsText");
            if (!listComponent6.isEmpty()) {
                charSequenceJ = StringResourceUtils.getI18nPluralString(outline.I(this.binding.e, "binding.mutualGuildsText", "binding.mutualGuildsText.context"), R.plurals.user_profile_mutual_guilds_count, listComponent6.size(), Integer.valueOf(listComponent6.size()));
            } else {
                TextView textView5 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.mutualGuildsText");
                charSequenceJ = FormatUtils.j(textView5, R.string.no_mutual_guilds, new Object[0], null, 4);
            }
            textView4.setText(charSequenceJ);
        }
    }
}
