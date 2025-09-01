package com.discord.widgets.guilds.invite;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetGuildInviteShareItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: PrivateChannelAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/invite/PrivateChannelAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/guilds/invite/PrivateChannelAdapter$Item;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/guilds/invite/PrivateChannelAdapter$Item;", "Lkotlin/Function1;", "", "onClick", "Lkotlin/jvm/functions/Function1;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PrivateChannelAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItem> {
    private Function1<? super InviteSuggestionItem, Unit> onClick;

    /* compiled from: PrivateChannelAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/guilds/invite/PrivateChannelAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/guilds/invite/PrivateChannelAdapter;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/guilds/invite/InviteSuggestionItem;)V", "Lcom/discord/databinding/WidgetGuildInviteShareItemBinding;", "binding", "Lcom/discord/databinding/WidgetGuildInviteShareItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/guilds/invite/PrivateChannelAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Item extends MGRecyclerViewHolder<PrivateChannelAdapter, InviteSuggestionItem> {
        private final WidgetGuildInviteShareItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(PrivateChannelAdapter privateChannelAdapter) {
            super(R.layout.widget_guild_invite_share_item, privateChannelAdapter);
            Intrinsics3.checkNotNullParameter(privateChannelAdapter, "adapter");
            WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingA = WidgetGuildInviteShareItemBinding.a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingA, "WidgetGuildInviteShareItemBinding.bind(itemView)");
            this.binding = widgetGuildInviteShareItemBindingA;
        }

        public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(Item item) {
            return (PrivateChannelAdapter) item.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, InviteSuggestionItem inviteSuggestionItem) {
            onConfigure2(i, inviteSuggestionItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, InviteSuggestionItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            boolean z2 = data instanceof InviteSuggestionItem.ChannelItem;
            if (z2) {
                InviteSuggestionItem.ChannelItem channelItem = (InviteSuggestionItem.ChannelItem) data;
                if (channelItem.getChannel().getType() != 1) {
                    SimpleDraweeView simpleDraweeView = this.binding.f2421b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
                    IconUtils.setIcon$default(simpleDraweeView, channelItem.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
                } else {
                    SimpleDraweeView simpleDraweeView2 = this.binding.f2421b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIconIv");
                    IconUtils.setIcon$default(simpleDraweeView2, ChannelUtils.a(channelItem.getChannel()), 0, null, null, null, 60, null);
                }
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemNameTv");
                textView.setText(ChannelUtils.c(channelItem.getChannel()));
            } else if (data instanceof InviteSuggestionItem.UserItem) {
                SimpleDraweeView simpleDraweeView3 = this.binding.f2421b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemIconIv");
                InviteSuggestionItem.UserItem userItem = (InviteSuggestionItem.UserItem) data;
                IconUtils.setIcon$default(simpleDraweeView3, userItem.getUser(), 0, null, null, null, 60, null);
                TextView textView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
                textView2.setText(userItem.getUser().getUsername());
            }
            if (z2 || (data instanceof InviteSuggestionItem.UserItem)) {
                MaterialButton materialButton = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemSent");
                materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
                MaterialButton materialButton2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
                materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
                this.binding.c.setOnClickListener(new PrivateChannelAdapter2(this, data));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateChannelAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClick = PrivateChannelAdapter3.INSTANCE;
    }

    public final Function1<InviteSuggestionItem, Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClick(Function1<? super InviteSuggestionItem, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClick = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Item onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        return new Item(this);
    }
}
