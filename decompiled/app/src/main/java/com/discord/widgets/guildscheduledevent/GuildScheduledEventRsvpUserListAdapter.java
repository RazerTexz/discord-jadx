package com.discord.widgets.guildscheduledevent;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.GuildScheduledEventRsvpUserListAdapterItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListItem;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventRsvpUserListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B'\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR&\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\r0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function1;", "", "Lcom/discord/primitives/UserId;", "", "onItemClick", "Lkotlin/jvm/functions/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function1;)V", "UserViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventRsvpUserListAdapter extends MGRecyclerAdapterSimple<GuildScheduledEventRsvpUserListItem> {
    private final Function1<Long, Unit> onItemClick;

    /* compiled from: GuildScheduledEventRsvpUserListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0015¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListAdapter$UserViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListAdapter;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListItem;)V", "Lcom/discord/databinding/GuildScheduledEventRsvpUserListAdapterItemBinding;", "binding", "Lcom/discord/databinding/GuildScheduledEventRsvpUserListAdapterItemBinding;", "getBinding", "()Lcom/discord/databinding/GuildScheduledEventRsvpUserListAdapterItemBinding;", "<init>", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventRsvpUserListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class UserViewHolder extends MGRecyclerViewHolder<GuildScheduledEventRsvpUserListAdapter, GuildScheduledEventRsvpUserListItem> {
        private final GuildScheduledEventRsvpUserListAdapterItemBinding binding;

        public UserViewHolder() {
            super(R.layout.guild_scheduled_event_rsvp_user_list_adapter_item, GuildScheduledEventRsvpUserListAdapter.this);
            View view = this.itemView;
            int i = R.id.user_profile_adapter_item_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.user_profile_adapter_item_avatar);
            if (simpleDraweeView != null) {
                i = R.id.user_profile_adapter_item_discriminator;
                TextView textView = (TextView) view.findViewById(R.id.user_profile_adapter_item_discriminator);
                if (textView != null) {
                    i = R.id.user_profile_adapter_item_status;
                    StatusView statusView = (StatusView) view.findViewById(R.id.user_profile_adapter_item_status);
                    if (statusView != null) {
                        i = R.id.user_profile_adapter_item_user_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.user_profile_adapter_item_user_name);
                        if (textView2 != null) {
                            GuildScheduledEventRsvpUserListAdapterItemBinding guildScheduledEventRsvpUserListAdapterItemBinding = new GuildScheduledEventRsvpUserListAdapterItemBinding((RelativeLayout) view, simpleDraweeView, textView, statusView, textView2);
                            Intrinsics3.checkNotNullExpressionValue(guildScheduledEventRsvpUserListAdapterItemBinding, "GuildScheduledEventRsvpU…temBinding.bind(itemView)");
                            this.binding = guildScheduledEventRsvpUserListAdapterItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public final GuildScheduledEventRsvpUserListAdapterItemBinding getBinding() {
            return this.binding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, GuildScheduledEventRsvpUserListItem guildScheduledEventRsvpUserListItem) {
            onConfigure2(i, guildScheduledEventRsvpUserListItem);
        }

        @SuppressLint({"SetTextI18n"})
        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, GuildScheduledEventRsvpUserListItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            GuildScheduledEventRsvpUserListItem.RsvpUser rsvpUser = (GuildScheduledEventRsvpUserListItem.RsvpUser) data;
            this.itemView.setOnClickListener(new GuildScheduledEventRsvpUserListAdapter2(this, rsvpUser));
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.userProfileAdapterItemUserName");
            textView.setText(rsvpUser.getDisplayName());
            if (rsvpUser.getNickname() == null) {
                TextView textView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.userProfileAdapterItemDiscriminator");
                textView2.setText(UserUtils.INSTANCE.padDiscriminator(rsvpUser.getDiscriminator()));
            }
            String forGuildMember$default = rsvpUser.getGuildAvatar() != null ? IconUtils.getForGuildMember$default(IconUtils.INSTANCE, rsvpUser.getGuildAvatar(), rsvpUser.getGuildId(), rsvpUser.getUserId(), null, false, 24, null) : IconUtils.getForUser$default(Long.valueOf(rsvpUser.getUserId()), rsvpUser.getUserAvatar(), null, false, null, 28, null);
            if (forGuildMember$default != null) {
                SimpleDraweeView simpleDraweeView = this.binding.f2122b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.userProfileAdapterItemAvatar");
                IconUtils.setIcon$default(simpleDraweeView, forGuildMember$default, R.dimen.avatar_size_standard, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildScheduledEventRsvpUserListAdapter(RecyclerView recyclerView, Function1<? super Long, Unit> function1) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(function1, "onItemClick");
        this.onItemClick = function1;
    }

    public static final /* synthetic */ Function1 access$getOnItemClick$p(GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter) {
        return guildScheduledEventRsvpUserListAdapter.onItemClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, GuildScheduledEventRsvpUserListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new UserViewHolder();
        }
        throw invalidViewTypeException(viewType);
    }
}
