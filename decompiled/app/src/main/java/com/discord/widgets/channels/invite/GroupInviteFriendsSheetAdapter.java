package com.discord.widgets.channels.invite;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.GroupInviteFriendsSheetItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GroupInviteFriendsSheetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B)\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR+\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter$FriendItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function2;", "Lcom/discord/models/user/User;", "", "", "onUserChecked", "Lkotlin/jvm/functions/Function2;", "getOnUserChecked", "()Lkotlin/jvm/functions/Function2;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function2;)V", "FriendItem", "GroupInviteFriendsListItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter extends MGRecyclerAdapterSimple<FriendItem> {
    private final Function2<User, Boolean, Unit> onUserChecked;

    /* compiled from: GroupInviteFriendsSheetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0011R\u001c\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\t\u0010\u0007¨\u0006\""}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter$FriendItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "", "component2", "()Z", "user", "isSelected", "copy", "(Lcom/discord/models/user/User;Z)Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter$FriendItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/user/User;", "getUser", "Z", "<init>", "(Lcom/discord/models/user/User;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class FriendItem implements MGRecyclerDataPayload {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int TYPE_FRIEND = 0;
        private final boolean isSelected;
        private final String key;
        private final int type;
        private final User user;

        /* compiled from: GroupInviteFriendsSheetAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter$FriendItem$Companion;", "", "", "Lcom/discord/models/user/User;", "users", "", "checkedUsers", "Ljava/util/ArrayList;", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter$FriendItem;", "Lkotlin/collections/ArrayList;", "createItems", "(Ljava/util/Collection;Ljava/util/Set;)Ljava/util/ArrayList;", "", "TYPE_FRIEND", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final ArrayList<FriendItem> createItems(Collection<? extends User> users, Set<? extends User> checkedUsers) {
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(checkedUsers, "checkedUsers");
                ArrayList<FriendItem> arrayList = new ArrayList<>();
                for (User user : users) {
                    arrayList.add(new FriendItem(user, checkedUsers.contains(user)));
                }
                return arrayList;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public FriendItem(User user, boolean z2) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.isSelected = z2;
            this.key = String.valueOf(user.getId());
        }

        public static /* synthetic */ FriendItem copy$default(FriendItem friendItem, User user, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = friendItem.user;
            }
            if ((i & 2) != 0) {
                z2 = friendItem.isSelected;
            }
            return friendItem.copy(user, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final FriendItem copy(User user, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new FriendItem(user, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FriendItem)) {
                return false;
            }
            FriendItem friendItem = (FriendItem) other;
            return Intrinsics3.areEqual(this.user, friendItem.user) && this.isSelected == friendItem.isSelected;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            boolean z2 = this.isSelected;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("FriendItem(user=");
            sbU.append(this.user);
            sbU.append(", isSelected=");
            return outline.O(sbU, this.isSelected, ")");
        }
    }

    /* compiled from: GroupInviteFriendsSheetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter;", "Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter$FriendItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter$FriendItem;)V", "Lcom/discord/databinding/GroupInviteFriendsSheetItemBinding;", "binding", "Lcom/discord/databinding/GroupInviteFriendsSheetItemBinding;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/channels/invite/GroupInviteFriendsSheetAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class GroupInviteFriendsListItem extends MGRecyclerViewHolder<GroupInviteFriendsSheetAdapter, FriendItem> {
        private final GroupInviteFriendsSheetItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupInviteFriendsListItem(@LayoutRes int i, GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter) {
            super(i, groupInviteFriendsSheetAdapter);
            Intrinsics3.checkNotNullParameter(groupInviteFriendsSheetAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.friends_list_item_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.friends_list_item_avatar);
            if (simpleDraweeView != null) {
                i2 = R.id.friends_list_item_name;
                TextView textView = (TextView) view.findViewById(R.id.friends_list_item_name);
                if (textView != null) {
                    i2 = R.id.user_selected_checkbox;
                    MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.user_selected_checkbox);
                    if (materialCheckBox != null) {
                        GroupInviteFriendsSheetItemBinding groupInviteFriendsSheetItemBinding = new GroupInviteFriendsSheetItemBinding((ConstraintLayout) view, simpleDraweeView, textView, materialCheckBox);
                        Intrinsics3.checkNotNullExpressionValue(groupInviteFriendsSheetItemBinding, "GroupInviteFriendsSheetItemBinding.bind(itemView)");
                        this.binding = groupInviteFriendsSheetItemBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ GroupInviteFriendsSheetAdapter access$getAdapter$p(GroupInviteFriendsListItem groupInviteFriendsListItem) {
            return (GroupInviteFriendsSheetAdapter) groupInviteFriendsListItem.adapter;
        }

        public static final /* synthetic */ GroupInviteFriendsSheetItemBinding access$getBinding$p(GroupInviteFriendsListItem groupInviteFriendsListItem) {
            return groupInviteFriendsListItem.binding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, FriendItem friendItem) {
            onConfigure2(i, friendItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, FriendItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            User user = data.getUser();
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
            textView.setText(user.getUsername());
            SimpleDraweeView simpleDraweeView = this.binding.f2115b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, R.dimen.avatar_size_standard, null, null, null, 56, null);
            MaterialCheckBox materialCheckBox = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.userSelectedCheckbox");
            materialCheckBox.setChecked(data.isSelected());
            this.binding.d.setOnClickListener(new GroupInviteFriendsSheetAdapter2(this, user));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GroupInviteFriendsSheetAdapter(RecyclerView recyclerView, Function2<? super User, ? super Boolean, Unit> function2) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function2, "onUserChecked");
        this.onUserChecked = function2;
    }

    public final Function2<User, Boolean, Unit> getOnUserChecked() {
        return this.onUserChecked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, FriendItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new GroupInviteFriendsListItem(R.layout.group_invite_friends_sheet_item, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
