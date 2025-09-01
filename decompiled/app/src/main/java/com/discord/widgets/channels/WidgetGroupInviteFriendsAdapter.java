package com.discord.widgets.channels;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGroupInviteFriendsItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGroupInviteFriendsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\n\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00060\u0010R\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/channels/WidgetGroupInviteFriendsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$FriendItem;", "", "data", "Lkotlin/Function2;", "Lcom/discord/models/user/User;", "", "", "friendChosenListener", "setData", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/channels/WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/channels/WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem;", "listener", "Lkotlin/jvm/functions/Function2;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "WidgetGroupInviteFriendsListItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriendsAdapter extends MGRecyclerAdapterSimple<WidgetGroupInviteFriends.Model.FriendItem> {
    private Function2<? super User, ? super Boolean, Unit> listener;

    /* compiled from: WidgetGroupInviteFriendsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/WidgetGroupInviteFriendsAdapter;", "Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$FriendItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/WidgetGroupInviteFriends$Model$FriendItem;)V", "Lcom/discord/databinding/WidgetGroupInviteFriendsItemBinding;", "binding", "Lcom/discord/databinding/WidgetGroupInviteFriendsItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/channels/WidgetGroupInviteFriendsAdapter;Lcom/discord/widgets/channels/WidgetGroupInviteFriendsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class WidgetGroupInviteFriendsListItem extends MGRecyclerViewHolder<WidgetGroupInviteFriendsAdapter, WidgetGroupInviteFriends.Model.FriendItem> {
        private final WidgetGroupInviteFriendsItemBinding binding;
        public final /* synthetic */ WidgetGroupInviteFriendsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WidgetGroupInviteFriendsListItem(WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter, WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter2) {
            super(R.layout.widget_group_invite_friends_item, widgetGroupInviteFriendsAdapter2);
            Intrinsics3.checkNotNullParameter(widgetGroupInviteFriendsAdapter2, "adapter");
            this.this$0 = widgetGroupInviteFriendsAdapter;
            View view = this.itemView;
            int i = R.id.friend_container;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.friend_container);
            if (relativeLayout != null) {
                i = R.id.friends_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.friends_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = R.id.friends_list_item_avatar_wrap;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.friends_list_item_avatar_wrap);
                    if (relativeLayout2 != null) {
                        i = R.id.friends_list_item_game;
                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.friends_list_item_game);
                        if (simpleDraweeSpanTextView != null) {
                            i = R.id.friends_list_item_name;
                            TextView textView = (TextView) view.findViewById(R.id.friends_list_item_name);
                            if (textView != null) {
                                i = R.id.friends_list_item_status;
                                StatusView statusView = (StatusView) view.findViewById(R.id.friends_list_item_status);
                                if (statusView != null) {
                                    i = R.id.user_selected_checkbox;
                                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.user_selected_checkbox);
                                    if (checkBox != null) {
                                        WidgetGroupInviteFriendsItemBinding widgetGroupInviteFriendsItemBinding = new WidgetGroupInviteFriendsItemBinding((LinearLayout) view, relativeLayout, simpleDraweeView, relativeLayout2, simpleDraweeSpanTextView, textView, statusView, checkBox);
                                        Intrinsics3.checkNotNullExpressionValue(widgetGroupInviteFriendsItemBinding, "WidgetGroupInviteFriendsItemBinding.bind(itemView)");
                                        this.binding = widgetGroupInviteFriendsItemBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetGroupInviteFriendsAdapter access$getAdapter$p(WidgetGroupInviteFriendsListItem widgetGroupInviteFriendsListItem) {
            return (WidgetGroupInviteFriendsAdapter) widgetGroupInviteFriendsListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGroupInviteFriends.Model.FriendItem friendItem) {
            onConfigure2(i, friendItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetGroupInviteFriends.Model.FriendItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
            User user = data.getUser();
            textView.setText(user != null ? user.getUsername() : null);
            this.binding.f.setPresence(data.getPresence());
            CheckBox checkBox = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(checkBox, "binding.userSelectedCheckbox");
            checkBox.setChecked(data.isSelected());
            this.binding.f2407b.setOnClickListener(new WidgetGroupInviteFriendsAdapter2(this, data));
            Presence presence = data.getPresence();
            boolean zIsApplicationStreaming = data.isApplicationStreaming();
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.friendsListItemGame");
            PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, true, false, 16, null);
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getUser(), R.dimen.avatar_size_standard, null, null, null, 56, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGroupInviteFriendsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function2 access$getListener$p(WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter) {
        return widgetGroupInviteFriendsAdapter.listener;
    }

    public static final /* synthetic */ void access$setListener$p(WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter, Function2 function2) {
        widgetGroupInviteFriendsAdapter.listener = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<WidgetGroupInviteFriends.Model.FriendItem> data, Function2<? super User, ? super Boolean, Unit> friendChosenListener) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(friendChosenListener, "friendChosenListener");
        super.setData(data);
        this.listener = friendChosenListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetGroupInviteFriendsListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetGroupInviteFriendsListItem(this, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
