package com.discord.widgets.user.search;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSearchItemHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: WidgetGlobalSearchAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0018\u0019\u001a\u001b\u001cB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR@\u0010\u000e\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function4;", "Landroid/view/View;", "", "", "onSelectedListener", "Lkotlin/jvm/functions/Function4;", "getOnSelectedListener", "()Lkotlin/jvm/functions/Function4;", "setOnSelectedListener", "(Lkotlin/jvm/functions/Function4;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "ChannelViewHolder", "GuildViewHolder", "HeaderViewHolder", "SearchViewHolder", "UserViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter extends MGRecyclerAdapterSimple<WidgetGlobalSearchModel.ItemDataPayload> {
    private Function4<? super View, ? super Integer, ? super WidgetGlobalSearchModel.ItemDataPayload, ? super Boolean, Unit> onSelectedListener;

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter$ChannelViewHolder;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter$SearchViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "data", "", "onConfigure", "(ILcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;)V", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelViewHolder extends SearchViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure(i, itemDataPayload);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel.ItemChannel) data);
        }
    }

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter$GuildViewHolder;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter$SearchViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "data", "", "onConfigure", "(ILcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;)V", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class GuildViewHolder extends SearchViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure(i, itemDataPayload);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel.ItemGuild) data);
        }
    }

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter$HeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;)V", "Lcom/discord/databinding/WidgetChannelSearchItemHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetChannelSearchItemHeaderBinding;", "adapter", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel.ItemDataPayload> {
        private final WidgetChannelSearchItemHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(R.layout.widget_channel_search_item_header, widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetChannelSearchItemHeaderBinding widgetChannelSearchItemHeaderBinding = new WidgetChannelSearchItemHeaderBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetChannelSearchItemHeaderBinding, "WidgetChannelSearchItemH…derBinding.bind(itemView)");
            this.binding = widgetChannelSearchItemHeaderBinding;
        }

        public static final /* synthetic */ WidgetGlobalSearchAdapter access$getAdapter$p(HeaderViewHolder headerViewHolder) {
            return (WidgetGlobalSearchAdapter) headerViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure2(i, itemDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.binding.f2266b.setText(((WidgetGlobalSearchModel.ItemHeader) data).getName());
            this.binding.a.setOnClickListener(new WidgetGlobalSearchAdapter2(this, position, data));
            TextView textView = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(textView, new WidgetGlobalSearchAdapter3(this, position, data));
        }
    }

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\"\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter$SearchViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;)V", "Lcom/discord/widgets/user/search/ViewGlobalSearchItem;", "viewGlobalSearchItem", "Lcom/discord/widgets/user/search/ViewGlobalSearchItem;", "getViewGlobalSearchItem", "()Lcom/discord/widgets/user/search/ViewGlobalSearchItem;", "adapter", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class SearchViewHolder extends MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel.ItemDataPayload> {
        private final ViewGlobalSearchItem viewGlobalSearchItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(R.layout.widget_channel_search_item, widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "null cannot be cast to non-null type com.discord.widgets.user.search.ViewGlobalSearchItem");
            ViewGlobalSearchItem viewGlobalSearchItem = (ViewGlobalSearchItem) view;
            viewGlobalSearchItem.setSelected(true);
            this.viewGlobalSearchItem = viewGlobalSearchItem;
        }

        public static final /* synthetic */ WidgetGlobalSearchAdapter access$getAdapter$p(SearchViewHolder searchViewHolder) {
            return (WidgetGlobalSearchAdapter) searchViewHolder.adapter;
        }

        public final ViewGlobalSearchItem getViewGlobalSearchItem() {
            return this.viewGlobalSearchItem;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure(i, itemDataPayload);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.itemView.setOnClickListener(new WidgetGlobalSearchAdapter4(this, position, data));
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetGlobalSearchAdapter5(this, position, data));
        }
    }

    /* compiled from: WidgetGlobalSearchAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter$UserViewHolder;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter$SearchViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "data", "", "onConfigure", "(ILcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;)V", "Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class UserViewHolder extends SearchViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            onConfigure(i, itemDataPayload);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel.ItemUser) data);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onSelectedListener = WidgetGlobalSearchAdapter6.INSTANCE;
    }

    public final Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> getOnSelectedListener() {
        return this.onSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnSelectedListener(Function4<? super View, ? super Integer, ? super WidgetGlobalSearchModel.ItemDataPayload, ? super Boolean, Unit> function4) {
        Intrinsics3.checkNotNullParameter(function4, "<set-?>");
        this.onSelectedListener = function4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel.ItemDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == -1) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 0) {
            return new ChannelViewHolder(this);
        }
        if (viewType == 1) {
            return new UserViewHolder(this);
        }
        if (viewType == 2) {
            return new GuildViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
