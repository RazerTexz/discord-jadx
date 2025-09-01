package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.ViewGiftOutboundPromoListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.recycler.SimpleItemCallback;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B/\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000f\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingOutboundPromosAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder;I)V", "Lkotlin/Function1;", "onMoreDetailsClick", "Lkotlin/jvm/functions/Function1;", "onButtonClick", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "OutboundPromoViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsGiftingOutboundPromosAdapter extends ListAdapter<SettingsGiftingViewModel.OutboundPromoItem, OutboundPromoViewHolder> {
    private static final SimpleItemCallback<SettingsGiftingViewModel.OutboundPromoItem> DIFF_CALLBACK = new SimpleItemCallback<>(WidgetSettingsGiftingOutboundPromosAdapter4.INSTANCE);
    private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onButtonClick;
    private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onMoreDetailsClick;

    /* compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "item", "", "bindTo", "(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", "Lcom/discord/databinding/ViewGiftOutboundPromoListItemBinding;", "binding", "Lcom/discord/databinding/ViewGiftOutboundPromoListItemBinding;", "Lkotlin/Function1;", "onMoreDetailsClick", "Lkotlin/jvm/functions/Function1;", "onButtonClick", "boundItem", "Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class OutboundPromoViewHolder extends RecyclerView.ViewHolder {
        private final ViewGiftOutboundPromoListItemBinding binding;
        private SettingsGiftingViewModel.OutboundPromoItem boundItem;
        private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onButtonClick;
        private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onMoreDetailsClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public OutboundPromoViewHolder(ViewGroup viewGroup, Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function1, Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function12) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_gift_outbound_promo_list_item, viewGroup, false));
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            Intrinsics3.checkNotNullParameter(function1, "onMoreDetailsClick");
            Intrinsics3.checkNotNullParameter(function12, "onButtonClick");
            this.onMoreDetailsClick = function1;
            this.onButtonClick = function12;
            View view = this.itemView;
            int i = R.id.giftPromoButton;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.giftPromoButton);
            if (materialButton != null) {
                i = R.id.giftPromoDescription;
                TextView textView = (TextView) view.findViewById(R.id.giftPromoDescription);
                if (textView != null) {
                    i = R.id.giftPromoImage;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.giftPromoImage);
                    if (simpleDraweeView != null) {
                        i = R.id.giftPromoMoreDetails;
                        TextView textView2 = (TextView) view.findViewById(R.id.giftPromoMoreDetails);
                        if (textView2 != null) {
                            i = R.id.giftPromoTitle;
                            TextView textView3 = (TextView) view.findViewById(R.id.giftPromoTitle);
                            if (textView3 != null) {
                                ViewGiftOutboundPromoListItemBinding viewGiftOutboundPromoListItemBinding = new ViewGiftOutboundPromoListItemBinding((MaterialCardView) view, materialButton, textView, simpleDraweeView, textView2, textView3);
                                textView2.setOnClickListener(new WidgetSettingsGiftingOutboundPromosAdapter2(this));
                                materialButton.setOnClickListener(new WidgetSettingsGiftingOutboundPromosAdapter3(this));
                                Intrinsics3.checkNotNullExpressionValue(viewGiftOutboundPromoListItemBinding, "ViewGiftOutboundPromoLis…nClick(boundItem) }\n    }");
                                this.binding = viewGiftOutboundPromoListItemBinding;
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ SettingsGiftingViewModel.OutboundPromoItem access$getBoundItem$p(OutboundPromoViewHolder outboundPromoViewHolder) {
            SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem = outboundPromoViewHolder.boundItem;
            if (outboundPromoItem == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("boundItem");
            }
            return outboundPromoItem;
        }

        public static final /* synthetic */ Function1 access$getOnButtonClick$p(OutboundPromoViewHolder outboundPromoViewHolder) {
            return outboundPromoViewHolder.onButtonClick;
        }

        public static final /* synthetic */ Function1 access$getOnMoreDetailsClick$p(OutboundPromoViewHolder outboundPromoViewHolder) {
            return outboundPromoViewHolder.onMoreDetailsClick;
        }

        public static final /* synthetic */ void access$setBoundItem$p(OutboundPromoViewHolder outboundPromoViewHolder, SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
            outboundPromoViewHolder.boundItem = outboundPromoItem;
        }

        public final void bindTo(SettingsGiftingViewModel.OutboundPromoItem item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            this.boundItem = item;
            SimpleDraweeView simpleDraweeView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.giftPromoImage");
            IconUtils.setIcon$default(simpleDraweeView, item.getImageUrl(), 0, (Function1) null, new MGImages.DistinctChangeDetector(), 12, (Object) null);
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.giftPromoTitle");
            textView.setText(item.getTitle());
            ClaimStatus claimStatus = item.getClaimStatus();
            if (claimStatus instanceof ClaimStatus.Unclaimed) {
                long dateTimeMillis = ((ClaimStatus.Unclaimed) item.getClaimStatus()).getClaimBy().getDateTimeMillis();
                TimeUtils timeUtils = TimeUtils.INSTANCE;
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
                String strRenderUtcDate = timeUtils.renderUtcDate(dateTimeMillis, context, 1);
                TextView textView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.giftPromoDescription");
                FormatUtils.n(textView2, R.string.mobile_outbound_promotion_card_unclaimed_body, new Object[]{strRenderUtcDate}, null, 4);
                MaterialButton materialButton = this.binding.f2187b;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.giftPromoButton");
                FormatUtils.n(materialButton, R.string.promotion_card_action_claim, new Object[0], null, 4);
                return;
            }
            if (claimStatus instanceof ClaimStatus.Claimed) {
                long dateTimeMillis2 = ((ClaimStatus.Claimed) item.getClaimStatus()).getRedeemBy().getDateTimeMillis();
                TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                View view2 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
                Context context2 = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "itemView.context");
                String strRenderUtcDate2 = timeUtils2.renderUtcDate(dateTimeMillis2, context2, 1);
                TextView textView3 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.giftPromoDescription");
                FormatUtils.n(textView3, R.string.mobile_outbound_promotion_card_claimed_body, new Object[]{strRenderUtcDate2}, null, 4);
                MaterialButton materialButton2 = this.binding.f2187b;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.giftPromoButton");
                FormatUtils.n(materialButton2, R.string.outbound_promotion_see_code, new Object[0], null, 4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSettingsGiftingOutboundPromosAdapter(Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function1, Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function12) {
        super(DIFF_CALLBACK);
        Intrinsics3.checkNotNullParameter(function1, "onMoreDetailsClick");
        Intrinsics3.checkNotNullParameter(function12, "onButtonClick");
        this.onMoreDetailsClick = function1;
        this.onButtonClick = function12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((OutboundPromoViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(OutboundPromoViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        SettingsGiftingViewModel.OutboundPromoItem item = getItem(position);
        Intrinsics3.checkNotNullExpressionValue(item, "getItem(position)");
        holder.bindTo(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OutboundPromoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        return new OutboundPromoViewHolder(parent, this.onMoreDetailsClick, this.onButtonClick);
    }
}
