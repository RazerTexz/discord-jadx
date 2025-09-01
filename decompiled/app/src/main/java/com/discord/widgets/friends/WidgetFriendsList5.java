package com.discord.widgets.friends;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetFriendsListAdapterItemLoadingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetFriendsList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListLoadingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "getItemCount", "()I", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.friends.WidgetFriendsListLoadingAdapter, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsList5 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int LOADING_CELLS_COUNT = 15;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 15;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_friends_list_adapter_item_loading, parent, false);
        int i = R.id.blank_item_avatar_placeholder;
        View viewFindViewById = viewInflate.findViewById(R.id.blank_item_avatar_placeholder);
        if (viewFindViewById != null) {
            i = R.id.blank_item_username_placeholder;
            View viewFindViewById2 = viewInflate.findViewById(R.id.blank_item_username_placeholder);
            if (viewFindViewById2 != null) {
                WidgetFriendsListAdapterItemLoadingBinding widgetFriendsListAdapterItemLoadingBinding = new WidgetFriendsListAdapterItemLoadingBinding((ConstraintLayout) viewInflate, viewFindViewById, viewFindViewById2);
                Intrinsics3.checkNotNullExpressionValue(widgetFriendsListAdapterItemLoadingBinding, "WidgetFriendsListAdapter….context), parent, false)");
                return new WidgetFriendsList2(widgetFriendsListAdapterItemLoadingBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
