package com.discord.widgets.guilds.invite;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetGuildInviteShareItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.guilds.invite.InviteSuggestionItemV2;
import com.discord.widgets.user.UserNameFormatter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: InviteSuggestionsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function1;", "", "onClick", "Lkotlin/jvm/functions/Function1;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "EmptySearchResultsViewHolder", "InviteSuggestionViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class InviteSuggestionsAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItemV2> {
    private Function1<? super InviteSuggestionItemV2, Unit> onClick;

    /* compiled from: InviteSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionsAdapter$EmptySearchResultsViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionsAdapter;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;", "adapter", "<init>", "(Lcom/discord/widgets/guilds/invite/InviteSuggestionsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class EmptySearchResultsViewHolder extends MGRecyclerViewHolder<InviteSuggestionsAdapter, InviteSuggestionItemV2> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmptySearchResultsViewHolder(InviteSuggestionsAdapter inviteSuggestionsAdapter) {
            super(R.layout.guild_invite_empty_search_results_item, inviteSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(inviteSuggestionsAdapter, "adapter");
        }
    }

    /* compiled from: InviteSuggestionsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteSuggestionsAdapter$InviteSuggestionViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionsAdapter;", "Lcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;", "Lcom/discord/models/user/User;", "user", "", "configureItemForUser", "(Lcom/discord/models/user/User;)V", "Lcom/discord/api/channel/Channel;", "channel", "configureItemForChannel", "(Lcom/discord/api/channel/Channel;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "onConfigure", "(ILcom/discord/widgets/guilds/invite/InviteSuggestionItemV2;)V", "Lcom/discord/databinding/WidgetGuildInviteShareItemBinding;", "binding", "Lcom/discord/databinding/WidgetGuildInviteShareItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/guilds/invite/InviteSuggestionsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class InviteSuggestionViewHolder extends MGRecyclerViewHolder<InviteSuggestionsAdapter, InviteSuggestionItemV2> {
        private final WidgetGuildInviteShareItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InviteSuggestionViewHolder(InviteSuggestionsAdapter inviteSuggestionsAdapter) {
            super(R.layout.widget_guild_invite_share_item, inviteSuggestionsAdapter);
            Intrinsics3.checkNotNullParameter(inviteSuggestionsAdapter, "adapter");
            WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingA = WidgetGuildInviteShareItemBinding.a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingA, "WidgetGuildInviteShareItemBinding.bind(itemView)");
            this.binding = widgetGuildInviteShareItemBindingA;
        }

        public static final /* synthetic */ InviteSuggestionsAdapter access$getAdapter$p(InviteSuggestionViewHolder inviteSuggestionViewHolder) {
            return (InviteSuggestionsAdapter) inviteSuggestionViewHolder.adapter;
        }

        private final void configureItemForChannel(Channel channel) {
            SimpleDraweeView simpleDraweeView = this.binding.f2421b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
            IconUtils.setIcon$default(simpleDraweeView, channel, 0, (MGImages.ChangeDetector) null, 12, (Object) null);
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemNameTv");
            textView.setText(ChannelUtils.c(channel));
        }

        private final void configureItemForUser(User user) {
            SimpleDraweeView simpleDraweeView = this.binding.f2421b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
            IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, null, 60, null);
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemNameTv");
            textView.setText(UserNameFormatter.getSpannableForUserNameWithDiscrim(user, null, ((InviteSuggestionsAdapter) this.adapter).getContext(), R.attr.colorHeaderPrimary, R.attr.font_primary_semibold, R.integer.uikit_textsize_large_sp, R.attr.colorTextMuted, R.attr.font_primary_normal, R.integer.uikit_textsize_large_sp));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, InviteSuggestionItemV2 inviteSuggestionItemV2) {
            onConfigure2(i, inviteSuggestionItemV2);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, InviteSuggestionItemV2 data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            boolean z2 = data instanceof InviteSuggestionItemV2.ChannelItem;
            if (z2) {
                InviteSuggestionItemV2.ChannelItem channelItem = (InviteSuggestionItemV2.ChannelItem) data;
                User userA = ChannelUtils.a(channelItem.getChannel());
                if (userA != null) {
                    configureItemForUser(userA);
                } else {
                    configureItemForChannel(channelItem.getChannel());
                }
            } else if (data instanceof InviteSuggestionItemV2.UserItem) {
                configureItemForUser(((InviteSuggestionItemV2.UserItem) data).getUser());
            }
            if (z2 || (data instanceof InviteSuggestionItemV2.UserItem)) {
                MaterialButton materialButton = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemSent");
                materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
                MaterialButton materialButton2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
                materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
                this.binding.c.setOnClickListener(new InviteSuggestionsAdapter2(this, data));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestionsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClick = InviteSuggestionsAdapter3.INSTANCE;
    }

    public final Function1<InviteSuggestionItemV2, Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClick(Function1<? super InviteSuggestionItemV2, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClick = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<InviteSuggestionsAdapter, InviteSuggestionItemV2> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new EmptySearchResultsViewHolder(this);
        }
        if (viewType == 2 || viewType == 3) {
            return new InviteSuggestionViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
