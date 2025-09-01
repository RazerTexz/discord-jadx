package com.discord.widgets.channels.list;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetCollapsedVoiceUserListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: WidgetCollapsedUsersListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/channels/list/items/CollapsedUser;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "OverlapDecoration", "WidgetCollapsedUserListItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCollapsedUsersListAdapter extends MGRecyclerAdapterSimple<CollapsedUser> {

    /* compiled from: WidgetCollapsedUsersListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter$OverlapDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "offset", "I", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class OverlapDecoration extends RecyclerView.ItemDecoration {
        private final int offset;

        public OverlapDecoration(int i) {
            this.offset = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics3.checkNotNullParameter(outRect, "outRect");
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(parent, "parent");
            Intrinsics3.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            outRect.set(((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() != 0 ? this.offset : 0, 0, 0, 0);
        }
    }

    /* compiled from: WidgetCollapsedUsersListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter$WidgetCollapsedUserListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter;", "Lcom/discord/widgets/channels/list/items/CollapsedUser;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/list/items/CollapsedUser;)V", "Lcom/discord/databinding/WidgetCollapsedVoiceUserListItemBinding;", "binding", "Lcom/discord/databinding/WidgetCollapsedVoiceUserListItemBinding;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/channels/list/WidgetCollapsedUsersListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class WidgetCollapsedUserListItem extends MGRecyclerViewHolder<WidgetCollapsedUsersListAdapter, CollapsedUser> {
        private final WidgetCollapsedVoiceUserListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WidgetCollapsedUserListItem(@LayoutRes int i, WidgetCollapsedUsersListAdapter widgetCollapsedUsersListAdapter) {
            super(i, widgetCollapsedUsersListAdapter);
            Intrinsics3.checkNotNullParameter(widgetCollapsedUsersListAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.widget_collapsed_user_count;
            TextView textView = (TextView) view.findViewById(R.id.widget_collapsed_user_count);
            if (textView != null) {
                i2 = R.id.widget_collapsed_user_imageview;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.widget_collapsed_user_imageview);
                if (simpleDraweeView != null) {
                    WidgetCollapsedVoiceUserListItemBinding widgetCollapsedVoiceUserListItemBinding = new WidgetCollapsedVoiceUserListItemBinding((FrameLayout) view, textView, simpleDraweeView);
                    Intrinsics3.checkNotNullExpressionValue(widgetCollapsedVoiceUserListItemBinding, "WidgetCollapsedVoiceUser…temBinding.bind(itemView)");
                    this.binding = widgetCollapsedVoiceUserListItemBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, CollapsedUser collapsedUser) {
            onConfigure2(i, collapsedUser);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, CollapsedUser data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (data.getExtraCount() <= 0) {
                if (data.getEmptySlot()) {
                    return;
                }
                TextView textView = this.binding.f2352b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetCollapsedUserCount");
                textView.setVisibility(8);
                SimpleDraweeView simpleDraweeView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.widgetCollapsedUserImageview");
                IconUtils.setIcon$default(simpleDraweeView, data.getUser(), R.dimen.avatar_size_medium, null, null, null, 56, null);
                return;
            }
            TextView textView2 = this.binding.f2352b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.widgetCollapsedUserCount");
            StringBuilder sb = new StringBuilder();
            sb.append('+');
            sb.append(data.getExtraCount());
            ViewExtensions.setTextAndVisibilityBy(textView2, sb.toString());
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.widgetCollapsedUserImageview");
            MGImages.setImage$default(mGImages, simpleDraweeView2, R.drawable.drawable_grey_user_icon, (MGImages.ChangeDetector) null, 4, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCollapsedUsersListAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        recyclerView.addItemDecoration(new OverlapDecoration(-context.getResources().getDimensionPixelSize(R.dimen.avatar_overlap)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, CollapsedUser> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        return new WidgetCollapsedUserListItem(R.layout.widget_collapsed_voice_user_list_item, this);
    }
}
