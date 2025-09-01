package com.discord.widgets.user.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.WidgetGlobalSearchItemGuildBinding;
import com.discord.databinding.WidgetGuildsListItemDmBinding;
import com.discord.databinding.WidgetGuildsListItemGuildBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR:\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R:\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "overlayColor", "I", "Lkotlin/Function3;", "", "onClickListener", "Lkotlin/jvm/functions/Function3;", "getOnClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnClickListener", "(Lkotlin/jvm/functions/Function3;)V", "onLongClickListener", "getOnLongClickListener", "setOnLongClickListener", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Item", "ItemDirectMessage", "ItemDivider", "ItemGuild", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter extends MGRecyclerAdapterSimple<WidgetGlobalSearchGuildsModel.Item> {
    private Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> onClickListener;
    private Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> onLongClickListener;
    private final int overlayColor;

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;)V", "Landroid/widget/TextView;", "textView", "count", "configureMentionsCount", "(Landroid/widget/TextView;I)V", "layoutRes", "adapter", "<init>", "(ILcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Item extends MGRecyclerViewHolder<WidgetGlobalSearchGuildsAdapter, WidgetGlobalSearchGuildsModel.Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(@LayoutRes int i, WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
        }

        public static final /* synthetic */ WidgetGlobalSearchGuildsAdapter access$getAdapter$p(Item item) {
            return (WidgetGlobalSearchGuildsAdapter) item.adapter;
        }

        public final void configureMentionsCount(TextView textView, int count) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            if (count < 1) {
                ViewExtensions.setTextAndVisibilityBy(textView, null);
                textView.setContentDescription(null);
                return;
            }
            textView.setVisibility(0);
            textView.setText(String.valueOf(count));
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            textView.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.overlay_guild_mentions_primary_630, 0, 2, (Object) null));
            textView.setContentDescription(FormatUtils.h(context, R.string.mentions_count, new Object[]{String.valueOf(count)}, null, 4));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetGlobalSearchGuildsModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.itemView.setOnClickListener(new WidgetGlobalSearchGuildsAdapter2(this, position, data));
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetGlobalSearchGuildsAdapter3(this, position, data));
        }
    }

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter$ItemDirectMessage;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "data", "", "onConfigure", "(ILcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;)V", "Lcom/discord/databinding/WidgetGuildsListItemDmBinding;", "binding", "Lcom/discord/databinding/WidgetGuildsListItemDmBinding;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;", "adapter", "layoutResId", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemDirectMessage extends Item {
        private final WidgetGuildsListItemDmBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemDirectMessage(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
            WidgetGuildsListItemDmBinding widgetGuildsListItemDmBindingA = WidgetGuildsListItemDmBinding.a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemDmBindingA, "WidgetGuildsListItemDmBinding.bind(itemView)");
            this.binding = widgetGuildsListItemDmBindingA;
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel.Item item) {
            onConfigure(i, item);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item
        public void onConfigure(int position, WidgetGlobalSearchGuildsModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure2(position, data);
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildsItemDmCount");
            configureMentionsCount(textView, data.getMentionCount());
            SimpleDraweeView simpleDraweeView = this.binding.f2459b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildsItemDmAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getChannel(), R.dimen.avatar_size_large, (MGImages.ChangeDetector) null, 8, (Object) null);
        }
    }

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter$ItemDivider;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter$Item;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;", "adapter", "", "layoutResId", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemDivider extends Item {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemDivider(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
        }
    }

    /* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter$ItemGuild;", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "data", "", "onConfigure", "(ILcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;)V", "Lcom/discord/databinding/WidgetGuildsListItemGuildBinding;", "bindingGuild", "Lcom/discord/databinding/WidgetGuildsListItemGuildBinding;", "Lcom/discord/databinding/WidgetGlobalSearchItemGuildBinding;", "binding", "Lcom/discord/databinding/WidgetGlobalSearchItemGuildBinding;", "overlayColor", "I", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;", "adapter", "layoutResId", "<init>", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsAdapter;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemGuild extends Item {
        private final WidgetGlobalSearchItemGuildBinding binding;
        private final WidgetGuildsListItemGuildBinding bindingGuild;
        private final int overlayColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemGuild(WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter, int i, @ColorInt int i2) {
            super(i, widgetGlobalSearchGuildsAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchGuildsAdapter, "adapter");
            this.overlayColor = i2;
            View view = this.itemView;
            int i3 = R.id.guilds_item_selected;
            ImageView imageView = (ImageView) view.findViewById(R.id.guilds_item_selected);
            if (imageView != null) {
                i3 = R.id.guilds_item_unread;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.guilds_item_unread);
                if (imageView2 != null) {
                    WidgetGlobalSearchItemGuildBinding widgetGlobalSearchItemGuildBinding = new WidgetGlobalSearchItemGuildBinding((RelativeLayout) view, imageView, imageView2);
                    Intrinsics3.checkNotNullExpressionValue(widgetGlobalSearchItemGuildBinding, "WidgetGlobalSearchItemGuildBinding.bind(itemView)");
                    this.binding = widgetGlobalSearchItemGuildBinding;
                    WidgetGuildsListItemGuildBinding widgetGuildsListItemGuildBindingA = WidgetGuildsListItemGuildBinding.a(this.itemView);
                    Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemGuildBindingA, "WidgetGuildsListItemGuildBinding.bind(itemView)");
                    this.bindingGuild = widgetGuildsListItemGuildBindingA;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
        }

        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchGuildsModel.Item item) {
            onConfigure(i, item);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter.Item
        public void onConfigure(int position, WidgetGlobalSearchGuildsModel.Item data) {
            Guild guild;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure2(position, data);
            Guild guild2 = data.getGuild();
            boolean z2 = guild2 != null && guild2.hasIcon();
            SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
            boolean zIsSelected = data.isSelected();
            Guild guild3 = data.getGuild();
            Integer numValueOf = Integer.valueOf(this.overlayColor);
            Intrinsics3.checkNotNullExpressionValue(this.bindingGuild.d, "bindingGuild.guildsItemAvatar");
            SimpleDraweeViewExtensions.setGuildIcon$default(simpleDraweeView, zIsSelected, guild3, r8.getResources().getDimensionPixelSize(R.dimen.guild_icon_radius), null, numValueOf, null, null, false, null, 488, null);
            TextView textView = this.bindingGuild.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
            String shortName = null;
            if (!z2 && (guild = data.getGuild()) != null) {
                shortName = guild.getShortName();
            }
            textView.setText(shortName);
            TextView textView2 = this.bindingGuild.h;
            Intrinsics3.checkNotNullExpressionValue(textView2, "bindingGuild.guildsItemMentions");
            configureMentionsCount(textView2, data.getMentionCount());
            ImageView imageView = this.bindingGuild.i;
            Intrinsics3.checkNotNullExpressionValue(imageView, "bindingGuild.guildsItemVoice");
            imageView.setVisibility(data.getConnectedToVoice() ? 0 : 8);
            ImageView imageView2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildsItemUnread");
            imageView2.setVisibility(data.isUnread() ? 0 : 8);
            ImageView imageView3 = this.binding.f2404b;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.guildsItemSelected");
            imageView3.setVisibility(data.isSelected() ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter(RecyclerView recyclerView, @ColorInt int i) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.overlayColor = i;
        this.onClickListener = WidgetGlobalSearchGuildsAdapter4.INSTANCE;
        this.onLongClickListener = WidgetGlobalSearchGuildsAdapter5.INSTANCE;
    }

    public final Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    public final Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> getOnLongClickListener() {
        return this.onLongClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickListener(Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> function3) {
        Intrinsics3.checkNotNullParameter(function3, "<set-?>");
        this.onClickListener = function3;
    }

    public final void setOnLongClickListener(Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel.Item, Unit> function3) {
        Intrinsics3.checkNotNullParameter(function3, "<set-?>");
        this.onLongClickListener = function3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, WidgetGlobalSearchGuildsModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new ItemDivider(this, R.layout.widget_global_search_item_divider);
        }
        if (viewType == 2) {
            return new ItemDirectMessage(this, R.layout.widget_global_search_item_dm);
        }
        if (viewType == 3) {
            return new ItemGuild(this, R.layout.widget_global_search_item_guild, this.overlayColor);
        }
        throw invalidViewTypeException(viewType);
    }
}
