package com.discord.widgets.forums;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.databinding.ForumBrowserHeaderItemBinding;
import com.discord.databinding.ForumBrowserPostItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.forums.ForumBrowserItem;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetForumBrowserAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bB7\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/forums/WidgetForumBrowserAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/forums/ForumBrowserItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function1;", "Lcom/discord/api/channel/Channel;", "", "onPostLongClick", "Lkotlin/jvm/functions/Function1;", "onPostClick", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemDecoration", "()Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "HeaderItem", "LoadingItem", "PostItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter extends MGRecyclerAdapterSimple<ForumBrowserItem> {
    private final RecyclerView.ItemDecoration itemDecoration;
    private final Function1<Channel, Unit> onPostClick;
    private final Function1<Channel, Unit> onPostLongClick;

    /* compiled from: WidgetForumBrowserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/forums/WidgetForumBrowserAdapter$HeaderItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/forums/WidgetForumBrowserAdapter;", "Lcom/discord/widgets/forums/ForumBrowserItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/forums/ForumBrowserItem;)V", "Lcom/discord/databinding/ForumBrowserHeaderItemBinding;", "binding", "Lcom/discord/databinding/ForumBrowserHeaderItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/forums/WidgetForumBrowserAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HeaderItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
        private final ForumBrowserHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
            super(R.layout.forum_browser_header_item, widgetForumBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.header_name);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.header_name)));
            }
            ForumBrowserHeaderItemBinding forumBrowserHeaderItemBinding = new ForumBrowserHeaderItemBinding((ConstraintLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(forumBrowserHeaderItemBinding, "ForumBrowserHeaderItemBinding.bind(itemView)");
            this.binding = forumBrowserHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ForumBrowserItem forumBrowserItem) {
            onConfigure2(i, forumBrowserItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ForumBrowserItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.binding.f2107b.setText(((ForumBrowserItem.HeaderItem) data).getStringResId());
        }
    }

    /* compiled from: WidgetForumBrowserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/forums/WidgetForumBrowserAdapter$LoadingItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/forums/WidgetForumBrowserAdapter;", "Lcom/discord/widgets/forums/ForumBrowserItem;", "adapter", "<init>", "(Lcom/discord/widgets/forums/WidgetForumBrowserAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
            super(R.layout.forum_browser_loading_item, widgetForumBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
        }
    }

    /* compiled from: WidgetForumBrowserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/forums/WidgetForumBrowserAdapter$PostItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/forums/WidgetForumBrowserAdapter;", "Lcom/discord/widgets/forums/ForumBrowserItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/forums/ForumBrowserItem;)V", "Lcom/discord/databinding/ForumBrowserPostItemBinding;", "binding", "Lcom/discord/databinding/ForumBrowserPostItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/forums/WidgetForumBrowserAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PostItem extends MGRecyclerViewHolder<WidgetForumBrowserAdapter, ForumBrowserItem> {
        private final ForumBrowserPostItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostItem(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
            super(R.layout.forum_browser_post_item, widgetForumBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetForumBrowserAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            ForumBrowserPostView forumBrowserPostView = (ForumBrowserPostView) view;
            ForumBrowserPostItemBinding forumBrowserPostItemBinding = new ForumBrowserPostItemBinding(forumBrowserPostView, forumBrowserPostView);
            Intrinsics3.checkNotNullExpressionValue(forumBrowserPostItemBinding, "ForumBrowserPostItemBinding.bind(itemView)");
            this.binding = forumBrowserPostItemBinding;
        }

        public static final /* synthetic */ WidgetForumBrowserAdapter access$getAdapter$p(PostItem postItem) {
            return (WidgetForumBrowserAdapter) postItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ForumBrowserItem forumBrowserItem) throws Resources.NotFoundException {
            onConfigure2(i, forumBrowserItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ForumBrowserItem data) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ForumBrowserItem.PostItem postItem = (ForumBrowserItem.PostItem) data;
            this.binding.f2108b.configurePost(postItem.getPost());
            this.binding.f2108b.setOnClickListener(new WidgetForumBrowserAdapter2(this, postItem));
            ForumBrowserPostView forumBrowserPostView = this.binding.f2108b;
            Intrinsics3.checkNotNullExpressionValue(forumBrowserPostView, "binding.forumBrowserPostView");
            ViewExtensions.setOnLongClickListenerConsumeClick(forumBrowserPostView, new WidgetForumBrowserAdapter3(this, postItem));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetForumBrowserAdapter(RecyclerView recyclerView, Function1<? super Channel, Unit> function1, Function1<? super Channel, Unit> function12) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function1, "onPostClick");
        Intrinsics3.checkNotNullParameter(function12, "onPostLongClick");
        this.onPostClick = function1;
        this.onPostLongClick = function12;
        this.itemDecoration = new WidgetForumBrowserAdapter4(this);
    }

    public static final /* synthetic */ List access$getInternalData$p(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        return widgetForumBrowserAdapter.getInternalData();
    }

    public static final /* synthetic */ Function1 access$getOnPostClick$p(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        return widgetForumBrowserAdapter.onPostClick;
    }

    public static final /* synthetic */ Function1 access$getOnPostLongClick$p(WidgetForumBrowserAdapter widgetForumBrowserAdapter) {
        return widgetForumBrowserAdapter.onPostLongClick;
    }

    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ForumBrowserItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderItem(this);
        }
        if (viewType == 1) {
            return new PostItem(this);
        }
        if (viewType == 2) {
            return new LoadingItem(this);
        }
        throw new IllegalStateException(outline.q("Invalid view type: ", viewType));
    }
}
