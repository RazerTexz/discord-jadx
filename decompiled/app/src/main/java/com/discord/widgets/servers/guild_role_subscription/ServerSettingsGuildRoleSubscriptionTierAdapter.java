package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionTierItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter2;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B+\u0012\u0006\u0010\"\u001a\u00020!\u0012\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020\u001b¢\u0006\u0004\b#\u0010$J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR(\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder;I)V", "getItemCount", "()I", "getItemViewType", "(I)I", "", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem;", "newItems", "setItems", "(Ljava/util/List;)V", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;", "itemClickListener", "setItemClickListener", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;)V", "Lcom/discord/utilities/recycler/DiffCreator;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;", "items", "Ljava/util/List;", "Lcom/discord/app/AppComponent;", "appComponent", "<init>", "(Lcom/discord/app/AppComponent;Lcom/discord/utilities/recycler/DiffCreator;)V", "Companion", "ItemClickListener", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierAdapter extends RecyclerView.Adapter<ServerSettingsGuildRoleSubscriptionTierAdapter3> {
    private static final int VIEW_TYPE_ADD_ITEM = 1;
    private static final int VIEW_TYPE_TIER = 0;
    private final DiffCreator<List<ServerSettingsGuildRoleSubscriptionTierAdapter2>, ServerSettingsGuildRoleSubscriptionTierAdapter3> diffCreator;
    private ItemClickListener itemClickListener;
    private List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> items;

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;", "", "", "tierListingId", "", "onTierItemClick", "(J)V", "onAddTierItemClick", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface ItemClickListener {
        void onAddTierItemClick();

        void onTierItemClick(long tierListingId);
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem;", "items", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            ServerSettingsGuildRoleSubscriptionTierAdapter.access$setItems$p(ServerSettingsGuildRoleSubscriptionTierAdapter.this, list);
        }
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter) {
        return serverSettingsGuildRoleSubscriptionTierAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter, List list) {
        serverSettingsGuildRoleSubscriptionTierAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ServerSettingsGuildRoleSubscriptionTierAdapter2 serverSettingsGuildRoleSubscriptionTierAdapter2 = this.items.get(position);
        if (serverSettingsGuildRoleSubscriptionTierAdapter2 instanceof ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier) {
            return 0;
        }
        if (serverSettingsGuildRoleSubscriptionTierAdapter2 instanceof ServerSettingsGuildRoleSubscriptionTierAdapter2.AddTier) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ServerSettingsGuildRoleSubscriptionTierAdapter3) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItemClickListener(ItemClickListener itemClickListener) {
        Intrinsics3.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    public final void setItems(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdates(this, new AnonymousClass1(), this.items, newItems);
    }

    public ServerSettingsGuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator<List<ServerSettingsGuildRoleSubscriptionTierAdapter2>, ServerSettingsGuildRoleSubscriptionTierAdapter3> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(ServerSettingsGuildRoleSubscriptionTierAdapter3 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        ServerSettingsGuildRoleSubscriptionTierAdapter2 serverSettingsGuildRoleSubscriptionTierAdapter2 = this.items.get(position);
        if ((holder instanceof ServerSettingsGuildRoleSubscriptionTierAdapter3.TierItemViewHolder) && (serverSettingsGuildRoleSubscriptionTierAdapter2 instanceof ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier)) {
            ServerSettingsGuildRoleSubscriptionTierAdapter3.TierItemViewHolder tierItemViewHolder = (ServerSettingsGuildRoleSubscriptionTierAdapter3.TierItemViewHolder) holder;
            ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier tier = (ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier) serverSettingsGuildRoleSubscriptionTierAdapter2;
            ItemClickListener itemClickListener = this.itemClickListener;
            if (itemClickListener == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("itemClickListener");
            }
            tierItemViewHolder.configureUI(tier, itemClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ServerSettingsGuildRoleSubscriptionTierAdapter3 onCreateViewHolder(ViewGroup parent, int viewType) {
        ServerSettingsGuildRoleSubscriptionTierAdapter3 tierItemViewHolder;
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType != 0) {
            if (viewType != 1) {
                Context context = parent.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "parent.context");
                throw new IllegalArgumentException(FormatUtils.h(context, R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, null, 4).toString());
            }
            View viewInflate = layoutInflaterFrom.inflate(R.layout.view_server_settings_guild_role_subscription_add_tier_item, parent, false);
            int i = R.id.guild_role_subscription_add_tier_image;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.guild_role_subscription_add_tier_image);
            if (imageView != null) {
                i = R.id.guild_role_subscription_add_tier_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_add_tier_text);
                if (textView != null) {
                    ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding viewServerSettingsGuildRoleSubscriptionAddTierItemBinding = new ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding((ConstraintLayout) viewInflate, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, "ViewServerSettingsGuildR…rent, false\n            )");
                    ItemClickListener itemClickListener = this.itemClickListener;
                    if (itemClickListener == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("itemClickListener");
                    }
                    tierItemViewHolder = new ServerSettingsGuildRoleSubscriptionTierAdapter3.AddTierItemViewHolder(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, itemClickListener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.view_server_settings_guild_role_subscription_tier_item, parent, false);
        int i2 = R.id.guild_role_subscription_tier_draft_tag;
        TextView textView2 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_draft_tag);
        if (textView2 != null) {
            i2 = R.id.guild_role_subscription_tier_edit;
            ImageView imageView2 = (ImageView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_edit);
            if (imageView2 != null) {
                i2 = R.id.guild_role_subscription_tier_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_icon);
                if (simpleDraweeView != null) {
                    i2 = R.id.guild_role_subscription_tier_name;
                    TextView textView3 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_name);
                    if (textView3 != null) {
                        i2 = R.id.guild_role_subscription_tier_price;
                        TextView textView4 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_price);
                        if (textView4 != null) {
                            ViewServerSettingsGuildRoleSubscriptionTierItemBinding viewServerSettingsGuildRoleSubscriptionTierItemBinding = new ViewServerSettingsGuildRoleSubscriptionTierItemBinding((ConstraintLayout) viewInflate2, textView2, imageView2, simpleDraweeView, textView3, textView4);
                            Intrinsics3.checkNotNullExpressionValue(viewServerSettingsGuildRoleSubscriptionTierItemBinding, "ViewServerSettingsGuildR…(inflater, parent, false)");
                            tierItemViewHolder = new ServerSettingsGuildRoleSubscriptionTierAdapter3.TierItemViewHolder(viewServerSettingsGuildRoleSubscriptionTierItemBinding);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
        return tierItemViewHolder;
    }
}
