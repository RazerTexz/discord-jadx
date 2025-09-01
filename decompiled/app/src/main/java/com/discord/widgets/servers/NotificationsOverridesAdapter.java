package com.discord.widgets.servers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewCategoryOverrideItemBinding;
import com.discord.databinding.ViewChannelOverrideItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.Standard2;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotificationsOverridesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B!\u0012\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R6\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/discord/widgets/servers/NotificationsOverridesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder;", "", "getItemCount", "()I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder;", "holder", "", "onBindViewHolder", "(Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder;I)V", "", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", "value", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "Lkotlin/Function2;", "Landroid/view/View;", "onClick", "Lkotlin/jvm/functions/Function2;", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "DiffCallback", "Item", "ViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NotificationsOverridesAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Item> data;
    private final Function2<View, Item, Unit> onClick;

    /* compiled from: NotificationsOverridesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/servers/NotificationsOverridesAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "()I", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areContentsTheSame", "(II)Z", "areItemsTheSame", "", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", "newItems", "Ljava/util/List;", "oldItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DiffCallback extends DiffUtil.Callback {
        private final List<Item> newItems;
        private final List<Item> oldItems;

        public DiffCallback(List<Item> list, List<Item> list2) {
            Intrinsics3.checkNotNullParameter(list, "newItems");
            Intrinsics3.checkNotNullParameter(list2, "oldItems");
            this.newItems = list;
            this.oldItems = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual(this.newItems.get(newItemPosition), this.oldItems.get(oldItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return this.newItems.get(newItemPosition).getChannel().getId() == this.oldItems.get(oldItemPosition).getChannel().getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newItems.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldItems.size();
        }
    }

    /* compiled from: NotificationsOverridesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", "", "Lcom/discord/api/channel/Channel;", "parent", "Lcom/discord/api/channel/Channel;", "getParent", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/domain/ModelNotificationSettings$ChannelOverride;", "overrideSettings", "Lcom/discord/models/domain/ModelNotificationSettings$ChannelOverride;", "getOverrideSettings", "()Lcom/discord/models/domain/ModelNotificationSettings$ChannelOverride;", "channel", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings$ChannelOverride;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Item {
        private final Channel channel;
        private final ModelNotificationSettings.ChannelOverride overrideSettings;
        private final Channel parent;

        public Item(Channel channel, Channel channel2, ModelNotificationSettings.ChannelOverride channelOverride) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(channelOverride, "overrideSettings");
            this.channel = channel;
            this.parent = channel2;
            this.overrideSettings = channelOverride;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final ModelNotificationSettings.ChannelOverride getOverrideSettings() {
            return this.overrideSettings;
        }

        public final Channel getParent() {
            return this.parent;
        }
    }

    /* compiled from: NotificationsOverridesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B+\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nR+\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", "data", "", "onBind", "(Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;)V", "", "messageNotificationLevel", "messageNotificationToString", "(I)I", "Lkotlin/Function2;", "Landroid/view/View;", "onClick", "Lkotlin/jvm/functions/Function2;", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "itemView", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "CategoryOverridesViewHolder", "ChannelOverridesViewHolder", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder$ChannelOverridesViewHolder;", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder$CategoryOverridesViewHolder;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        private final Function2<View, Item, Unit> onClick;

        /* compiled from: NotificationsOverridesAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder$CategoryOverridesViewHolder;", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder;", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", "data", "", "onBind", "(Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;)V", "Lcom/discord/databinding/ViewCategoryOverrideItemBinding;", "binding", "Lcom/discord/databinding/ViewCategoryOverrideItemBinding;", "Lkotlin/Function2;", "Landroid/view/View;", "onClick", "<init>", "(Lcom/discord/databinding/ViewCategoryOverrideItemBinding;Lkotlin/jvm/functions/Function2;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class CategoryOverridesViewHolder extends ViewHolder {
            private final ViewCategoryOverrideItemBinding binding;

            /* JADX WARN: Illegal instructions before constructor call */
            public CategoryOverridesViewHolder(ViewCategoryOverrideItemBinding viewCategoryOverrideItemBinding, Function2<? super View, ? super Item, Unit> function2) {
                Intrinsics3.checkNotNullParameter(viewCategoryOverrideItemBinding, "binding");
                Intrinsics3.checkNotNullParameter(function2, "onClick");
                ConstraintLayout constraintLayout = viewCategoryOverrideItemBinding.a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
                super(constraintLayout, function2, null);
                this.binding = viewCategoryOverrideItemBinding;
            }

            @Override // com.discord.widgets.servers.NotificationsOverridesAdapter.ViewHolder
            public void onBind(Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onBind(data);
                TextView textView = this.binding.f2175b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.categoryOverrideName");
                textView.setText(ChannelUtils.c(data.getChannel()));
                int iMessageNotificationToString = data.getOverrideSettings().isMuted() ? R.string.form_label_muted : messageNotificationToString(data.getOverrideSettings().getMessageNotifications());
                TextView textView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.categoryOverrideStatus");
                FormatUtils.n(textView2, iMessageNotificationToString, new Object[0], null, 4);
            }
        }

        /* compiled from: NotificationsOverridesAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder$ChannelOverridesViewHolder;", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$ViewHolder;", "Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;", "data", "", "onBind", "(Lcom/discord/widgets/servers/NotificationsOverridesAdapter$Item;)V", "Lcom/discord/databinding/ViewChannelOverrideItemBinding;", "binding", "Lcom/discord/databinding/ViewChannelOverrideItemBinding;", "Lkotlin/Function2;", "Landroid/view/View;", "onClick", "<init>", "(Lcom/discord/databinding/ViewChannelOverrideItemBinding;Lkotlin/jvm/functions/Function2;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ChannelOverridesViewHolder extends ViewHolder {
            private final ViewChannelOverrideItemBinding binding;

            /* JADX WARN: Illegal instructions before constructor call */
            public ChannelOverridesViewHolder(ViewChannelOverrideItemBinding viewChannelOverrideItemBinding, Function2<? super View, ? super Item, Unit> function2) {
                Intrinsics3.checkNotNullParameter(viewChannelOverrideItemBinding, "binding");
                Intrinsics3.checkNotNullParameter(function2, "onClick");
                ConstraintLayout constraintLayout = viewChannelOverrideItemBinding.a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
                super(constraintLayout, function2, null);
                this.binding = viewChannelOverrideItemBinding;
            }

            @Override // com.discord.widgets.servers.NotificationsOverridesAdapter.ViewHolder
            public void onBind(Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onBind(data);
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelOverrideName");
                textView.setText(ChannelUtils.c(data.getChannel()));
                TextView textView2 = this.binding.f2176b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelOverrideCategoryName");
                Channel parent = data.getParent();
                ViewExtensions.setTextAndVisibilityBy(textView2, parent != null ? ChannelUtils.c(parent) : null);
                int iMessageNotificationToString = data.getOverrideSettings().isMuted() ? R.string.form_label_muted : messageNotificationToString(data.getOverrideSettings().getMessageNotifications());
                TextView textView3 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelOverrideStatus");
                FormatUtils.n(textView3, iMessageNotificationToString, new Object[0], null, 4);
            }
        }

        public /* synthetic */ ViewHolder(View view, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, function2);
        }

        public final Function2<View, Item, Unit> getOnClick() {
            return this.onClick;
        }

        @StringRes
        public final int messageNotificationToString(int messageNotificationLevel) {
            if (messageNotificationLevel == ModelNotificationSettings.FREQUENCY_ALL) {
                return R.string.form_label_all_messages;
            }
            if (messageNotificationLevel == ModelNotificationSettings.FREQUENCY_MENTIONS) {
                return R.string.form_label_only_mentions;
            }
            if (messageNotificationLevel == ModelNotificationSettings.FREQUENCY_NOTHING) {
                return R.string.form_label_nothing;
            }
            return 0;
        }

        public void onBind(Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.itemView.setOnClickListener(new NotificationsOverridesAdapter2(this, data));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private ViewHolder(View view, Function2<? super View, ? super Item, Unit> function2) {
            super(view);
            this.onClick = function2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NotificationsOverridesAdapter(Function2<? super View, ? super Item, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "onClick");
        this.onClick = function2;
        this.data = Collections2.emptyList();
    }

    public final List<Item> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getChannel().getType();
    }

    public final Function2<View, Item, Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @MainThread
    public final void setData(List<Item> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffCallback(list, this.data), true);
        Intrinsics3.checkNotNullExpressionValue(diffResultCalculateDiff, "DiffUtil.calculateDiff(D…back(value, field), true)");
        this.data = list;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.onBind(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        int i = R.id.navigation_indicator;
        if (viewType != 0 && viewType != 15) {
            if (viewType == 4) {
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category_override_item, parent, false);
                TextView textView = (TextView) viewInflate.findViewById(R.id.category_override_name);
                if (textView != null) {
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.category_override_status);
                    if (textView2 != null) {
                        Guideline guideline = (Guideline) viewInflate.findViewById(R.id.guideline);
                        if (guideline != null) {
                            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.navigation_indicator);
                            if (imageView != null) {
                                ViewCategoryOverrideItemBinding viewCategoryOverrideItemBinding = new ViewCategoryOverrideItemBinding((ConstraintLayout) viewInflate, textView, textView2, guideline, imageView);
                                Intrinsics3.checkNotNullExpressionValue(viewCategoryOverrideItemBinding, "ViewCategoryOverrideItem….context), parent, false)");
                                return new ViewHolder.CategoryOverridesViewHolder(viewCategoryOverrideItemBinding, this.onClick);
                            }
                        } else {
                            i = R.id.guideline;
                        }
                    } else {
                        i = R.id.category_override_status;
                    }
                } else {
                    i = R.id.category_override_name;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            }
            if (viewType != 5) {
                throw new Standard2(outline.w("An operation is not implemented: ", outline.r("Type[", viewType, "] not implemented")));
            }
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_channel_override_item, parent, false);
        TextView textView3 = (TextView) viewInflate2.findViewById(R.id.channel_override_category_name);
        if (textView3 != null) {
            TextView textView4 = (TextView) viewInflate2.findViewById(R.id.channel_override_name);
            if (textView4 != null) {
                TextView textView5 = (TextView) viewInflate2.findViewById(R.id.channel_override_status);
                if (textView5 != null) {
                    Guideline guideline2 = (Guideline) viewInflate2.findViewById(R.id.guideline);
                    if (guideline2 != null) {
                        ImageView imageView2 = (ImageView) viewInflate2.findViewById(R.id.navigation_indicator);
                        if (imageView2 != null) {
                            ViewChannelOverrideItemBinding viewChannelOverrideItemBinding = new ViewChannelOverrideItemBinding((ConstraintLayout) viewInflate2, textView3, textView4, textView5, guideline2, imageView2);
                            Intrinsics3.checkNotNullExpressionValue(viewChannelOverrideItemBinding, "ViewChannelOverrideItemB….context), parent, false)");
                            return new ViewHolder.ChannelOverridesViewHolder(viewChannelOverrideItemBinding, this.onClick);
                        }
                    } else {
                        i = R.id.guideline;
                    }
                } else {
                    i = R.id.channel_override_status;
                }
            } else {
                i = R.id.channel_override_name;
            }
        } else {
            i = R.id.channel_override_category_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
