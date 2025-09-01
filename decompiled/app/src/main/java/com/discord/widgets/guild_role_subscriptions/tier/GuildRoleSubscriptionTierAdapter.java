package com.discord.widgets.guild_role_subscriptions.tier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewGuildRoleSubscriptionPlanDetailsReviewBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionTierHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionMemberPreview;
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

/* compiled from: GuildRoleSubscriptionTierAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B+\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u001a\b\u0002\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierViewHolder;I)V", "getItemCount", "()I", "getItemViewType", "(I)I", "", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem;", "newItems", "setItems", "(Ljava/util/List;)V", "Lcom/discord/utilities/recycler/DiffCreator;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "items", "Ljava/util/List;", "Lcom/discord/app/AppComponent;", "appComponent", "<init>", "(Lcom/discord/app/AppComponent;Lcom/discord/utilities/recycler/DiffCreator;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierAdapter extends RecyclerView.Adapter<GuildRoleSubscriptionTierViewHolder> {
    public static final int VIEW_TYPE_ALL_CHANNELS_ACCESS_BENEFIT = 5;
    public static final int VIEW_TYPE_PLAN_DETAILS = 4;
    public static final int VIEW_TYPE_TIER_BENEFIT = 3;
    public static final int VIEW_TYPE_TIER_HEADER = 0;
    public static final int VIEW_TYPE_TIER_MEMBER_PREVIEW = 1;
    public static final int VIEW_TYPE_TIER_SECTION_HEADER = 2;
    private final DiffCreator<List<GuildRoleSubscriptionTierAdapterItem>, GuildRoleSubscriptionTierViewHolder> diffCreator;
    private List<? extends GuildRoleSubscriptionTierAdapterItem> items;

    /* compiled from: GuildRoleSubscriptionTierAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem;", "items", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GuildRoleSubscriptionTierAdapterItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildRoleSubscriptionTierAdapterItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends GuildRoleSubscriptionTierAdapterItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            GuildRoleSubscriptionTierAdapter.access$setItems$p(GuildRoleSubscriptionTierAdapter.this, list);
        }
    }

    public /* synthetic */ GuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter) {
        return guildRoleSubscriptionTierAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter, List list) {
        guildRoleSubscriptionTierAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        GuildRoleSubscriptionTierAdapterItem guildRoleSubscriptionTierAdapterItem = this.items.get(position);
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.Header) {
            return 0;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.MemberPreview) {
            return 1;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.SectionHeader) {
            return 2;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.BenefitItem) {
            return 3;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.PlanDetails) {
            return 4;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.AllChannelsAccessBenefitItem) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((GuildRoleSubscriptionTierViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends GuildRoleSubscriptionTierAdapterItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    public GuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator<List<GuildRoleSubscriptionTierAdapterItem>, GuildRoleSubscriptionTierViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(GuildRoleSubscriptionTierViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GuildRoleSubscriptionTierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_guild_role_subscription_tier_header, parent, false);
            int i = R.id.guild_role_subscription_tier_header_description;
            TextView textView = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_description);
            if (textView != null) {
                i = R.id.guild_role_subscription_tier_header_image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_image);
                if (simpleDraweeView != null) {
                    i = R.id.guild_role_subscription_tier_header_name;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_name);
                    if (textView2 != null) {
                        i = R.id.guild_role_subscription_tier_header_price;
                        TextView textView3 = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_price);
                        if (textView3 != null) {
                            i = R.id.guild_role_subscription_tier_header_price_interval;
                            TextView textView4 = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_price_interval);
                            if (textView4 != null) {
                                i = R.id.guild_role_subscription_tier_header_subscribe;
                                Button button = (Button) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_subscribe);
                                if (button != null) {
                                    ViewGuildRoleSubscriptionTierHeaderBinding viewGuildRoleSubscriptionTierHeaderBinding = new ViewGuildRoleSubscriptionTierHeaderBinding((LinearLayout) viewInflate, textView, simpleDraweeView, textView2, textView3, textView4, button);
                                    Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionTierHeaderBinding, "ViewGuildRoleSubscriptio…rent, false\n            )");
                                    return new GuildRoleSubscriptionTierViewHolder.TierHeaderViewHolder(viewGuildRoleSubscriptionTierHeaderBinding);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType == 1) {
            Context context = parent.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "parent.context");
            return new GuildRoleSubscriptionTierViewHolder.MemberPreviewViewHolder(new GuildRoleSubscriptionMemberPreview(context));
        }
        if (viewType == 2) {
            ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBindingA = ViewGuildRoleSubscriptionSectionHeaderItemBinding.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionSectionHeaderItemBindingA, "ViewGuildRoleSubscriptio…rent, false\n            )");
            return new GuildRoleSubscriptionTierViewHolder.SectionHeaderViewHolder(viewGuildRoleSubscriptionSectionHeaderItemBindingA);
        }
        if (viewType == 3) {
            Context context2 = parent.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "parent.context");
            return new GuildRoleSubscriptionTierViewHolder.BenefitViewHolder(new GuildRoleSubscriptionBenefitItemView(context2));
        }
        if (viewType != 4) {
            if (viewType == 5) {
                Context context3 = parent.getContext();
                Intrinsics3.checkNotNullExpressionValue(context3, "parent.context");
                return new GuildRoleSubscriptionTierViewHolder.BenefitViewHolder(new GuildRoleSubscriptionBenefitItemView(context3));
            }
            StringBuilder sbV = outline.V("invalid viewType ", viewType, " for ");
            sbV.append(GuildRoleSubscriptionTierAdapter.class.getSimpleName());
            throw new IllegalArgumentException(sbV.toString());
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_guild_role_subscription_plan_details_review, parent, false);
        int i2 = R.id.guild_role_subscription_plan_review_cover_image;
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate2.findViewById(R.id.guild_role_subscription_plan_review_cover_image);
        if (simpleDraweeView2 != null) {
            i2 = R.id.guild_role_subscription_plan_review_description;
            TextView textView5 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_plan_review_description);
            if (textView5 != null) {
                ViewGuildRoleSubscriptionPlanDetailsReviewBinding viewGuildRoleSubscriptionPlanDetailsReviewBinding = new ViewGuildRoleSubscriptionPlanDetailsReviewBinding((LinearLayout) viewInflate2, simpleDraweeView2, textView5);
                Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanDetailsReviewBinding, "ViewGuildRoleSubscriptio…rent, false\n            )");
                return new GuildRoleSubscriptionTierViewHolder.PlanDetailsViewHolder(viewGuildRoleSubscriptionPlanDetailsReviewBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
    }
}
