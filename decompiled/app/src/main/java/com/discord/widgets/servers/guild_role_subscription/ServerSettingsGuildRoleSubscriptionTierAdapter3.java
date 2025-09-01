package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionTierItemBinding;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter2;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "AddTierItemViewHolder", "TierItemViewHolder", "Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder$TierItemViewHolder;", "Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder$AddTierItemViewHolder;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class ServerSettingsGuildRoleSubscriptionTierAdapter3 extends RecyclerView.ViewHolder {

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder$AddTierItemViewHolder;", "Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder;", "Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;", "binding", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;", "itemClickListener", "<init>", "(Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$AddTierItemViewHolder */
    public static final class AddTierItemViewHolder extends ServerSettingsGuildRoleSubscriptionTierAdapter3 {

        /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$AddTierItemViewHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener $itemClickListener;

            public AnonymousClass1(ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
                this.$itemClickListener = itemClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.$itemClickListener.onAddTierItemClick();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public AddTierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
            Intrinsics3.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(itemClickListener, "itemClickListener");
            ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.itemView.setOnClickListener(new AnonymousClass1(itemClickListener));
            viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.f2209b.setText(R.string.guild_settings_role_subscription_tier_card_create);
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder$TierItemViewHolder;", "Lcom/discord/widgets/servers/guild_role_subscription/TierViewHolder;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier;", "tierAdapterItem", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;", "itemClickListener", "", "configureUI", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier;Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener;)V", "", "tierImageSizePx", "I", "Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionTierItemBinding;", "binding", "Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionTierItemBinding;", "<init>", "(Lcom/discord/databinding/ViewServerSettingsGuildRoleSubscriptionTierItemBinding;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$TierItemViewHolder */
    public static final class TierItemViewHolder extends ServerSettingsGuildRoleSubscriptionTierAdapter3 {
        private static final int MAX_TIER_IMAGE_SIZE = 64;
        private final ViewServerSettingsGuildRoleSubscriptionTierItemBinding binding;
        private final int tierImageSizePx;

        /* JADX WARN: Illegal instructions before constructor call */
        public TierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionTierItemBinding viewServerSettingsGuildRoleSubscriptionTierItemBinding) {
            Intrinsics3.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionTierItemBinding, "binding");
            ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionTierItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.binding = viewServerSettingsGuildRoleSubscriptionTierItemBinding;
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            this.tierImageSizePx = view.getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_tier_image_size);
        }

        public final void configureUI(ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier tierAdapterItem, ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
            Intrinsics3.checkNotNullParameter(tierAdapterItem, "tierAdapterItem");
            Intrinsics3.checkNotNullParameter(itemClickListener, "itemClickListener");
            this.itemView.setOnClickListener(new ServerSettingsGuildRoleSubscriptionTierAdapter4(itemClickListener, tierAdapterItem));
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierName");
            textView.setText(tierAdapterItem.getTierName());
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierPrice");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            int tierPrice = tierAdapterItem.getTierPrice();
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            Context context = view2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
            textView2.setText(FormatUtils.j(view, R.string.billing_price_per_month, new Object[]{PremiumUtils2.getFormattedPriceUsd(tierPrice, context)}, null, 4));
            String storeAssetImage = tierAdapterItem.getTierImageAssetId() != null ? IconUtils.INSTANCE.getStoreAssetImage(Long.valueOf(tierAdapterItem.getApplicationId()), String.valueOf(tierAdapterItem.getTierImageAssetId().longValue()), 64) : null;
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierIcon");
            int i = this.tierImageSizePx;
            MGImages.setImage$default(simpleDraweeView, storeAssetImage, i, i, false, null, null, 112, null);
            TextView textView3 = this.binding.f2210b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierDraftTag");
            textView3.setVisibility(tierAdapterItem.isPublished() ^ true ? 0 : 8);
        }
    }

    private ServerSettingsGuildRoleSubscriptionTierAdapter3(View view) {
        super(view);
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter3(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
