package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.application.Application;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.ViewGiftEntitlementListItemBinding;
import com.discord.databinding.ViewGiftSkuListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetSettingsGiftingAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004 !\"#B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u008f\u0001\u0010\u0018\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2$\u0010\u0011\u001a \u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\f\u0012\n\u0018\u00010\rj\u0004\u0018\u0001`\u000f\u0012\u0004\u0012\u00020\u00100\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00122$\u0010\u0017\u001a \u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\f\u0012\n\u0018\u00010\rj\u0004\u0018\u0001`\u000f\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001aR4\u0010\u0011\u001a \u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\f\u0012\n\u0018\u00010\rj\u0004\u0018\u0001`\u000f\u0012\u0004\u0012\u00020\u00100\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR4\u0010\u0017\u001a \u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\f\u0012\n\u0018\u00010\rj\u0004\u0018\u0001`\u000f\u0012\u0004\u0012\u00020\u00100\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001a¨\u0006$"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$GiftItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", "giftItems", "Lkotlin/Function2;", "", "Lcom/discord/primitives/SkuId;", "Lcom/discord/primitives/PlanId;", "", "onClickSkuListener", "Lkotlin/Function1;", "", "onClickCopyListener", "Lcom/discord/models/domain/ModelGift;", "onRevokeClickListener", "onGenerateClickListener", "configure", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "EntitlementListItem", "GiftItem", "NoGiftsListItem", "SkuListItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter extends MGRecyclerAdapterSimple<GiftItem> {
    private Function1<? super String, Unit> onClickCopyListener;
    private Function2<? super Long, ? super Long, Unit> onClickSkuListener;
    private Function2<? super Long, ? super Long, Unit> onGenerateClickListener;
    private Function1<? super ModelGift, Unit> onRevokeClickListener;

    /* compiled from: WidgetSettingsGiftingAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$EntitlementListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter;", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$GiftItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$GiftItem;)V", "Lcom/discord/databinding/ViewGiftEntitlementListItemBinding;", "binding", "Lcom/discord/databinding/ViewGiftEntitlementListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class EntitlementListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> {
        private static final int VIEW_INDEX_CODE = 0;
        private static final int VIEW_INDEX_GENERATE = 1;
        private final ViewGiftEntitlementListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntitlementListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
            super(R.layout.view_gift_entitlement_list_item, widgetSettingsGiftingAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.gift_entitlement_code;
            TextView textView = (TextView) view.findViewById(R.id.gift_entitlement_code);
            if (textView != null) {
                i = R.id.gift_entitlement_code_container;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.gift_entitlement_code_container);
                if (relativeLayout != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = R.id.gift_entitlement_copy;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.gift_entitlement_copy);
                    if (materialButton != null) {
                        i = R.id.gift_entitlement_divider;
                        View viewFindViewById = view.findViewById(R.id.gift_entitlement_divider);
                        if (viewFindViewById != null) {
                            i = R.id.gift_entitlement_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.gift_entitlement_flipper);
                            if (appViewFlipper != null) {
                                i = R.id.gift_entitlement_generate;
                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.gift_entitlement_generate);
                                if (materialButton2 != null) {
                                    i = R.id.gift_entitlement_revoke;
                                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.gift_entitlement_revoke);
                                    if (linkifiedTextView != null) {
                                        ViewGiftEntitlementListItemBinding viewGiftEntitlementListItemBinding = new ViewGiftEntitlementListItemBinding(frameLayout, textView, relativeLayout, frameLayout, materialButton, viewFindViewById, appViewFlipper, materialButton2, linkifiedTextView);
                                        Intrinsics3.checkNotNullExpressionValue(viewGiftEntitlementListItemBinding, "ViewGiftEntitlementListItemBinding.bind(itemView)");
                                        this.binding = viewGiftEntitlementListItemBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSettingsGiftingAdapter access$getAdapter$p(EntitlementListItem entitlementListItem) {
            return (WidgetSettingsGiftingAdapter) entitlementListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, GiftItem giftItem) {
            onConfigure2(i, giftItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, GiftItem data) {
            int themedDrawableRes$default;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (Intrinsics3.areEqual(data.getExpanded(), Boolean.FALSE)) {
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                View view2 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                layoutParams.height = 0;
                view.setLayoutParams(layoutParams);
                return;
            }
            View view3 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view3, "itemView");
            View view4 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view4, "itemView");
            ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
            layoutParams2.height = -2;
            view3.setLayoutParams(layoutParams2);
            View view5 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view5, "itemView");
            Context context = view5.getContext();
            if (data.getEntitlement() == null || data.isLastItem() == null) {
                return;
            }
            if (data.getGift() != null) {
                AppViewFlipper appViewFlipper = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.giftEntitlementFlipper");
                appViewFlipper.setDisplayedChild(0);
                boolean zAreEqual = Intrinsics3.areEqual(data.getWasCopied(), Boolean.TRUE);
                MaterialButton materialButton = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.giftEntitlementCopy");
                View view6 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view6, "itemView");
                materialButton.setText(FormatUtils.j(view6, zAreEqual ? R.string.copied : R.string.copy, new Object[0], null, 4));
                RelativeLayout relativeLayout = this.binding.c;
                if (zAreEqual) {
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.gift_code_copied_outline, 0, 2, (Object) null);
                } else {
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.primary_660_bg_outline, 0, 2, (Object) null);
                }
                relativeLayout.setBackgroundResource(themedDrawableRes$default);
                this.binding.e.setOnClickListener(new WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$3(this, data));
                GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
                CharSequence timeString = giftingUtils.getTimeString(data.getGift().getExpiresDiff(ClockFactory.get().currentTimeMillis()), context);
                LinkifiedTextView linkifiedTextView = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.giftEntitlementRevoke");
                FormatUtils.m(linkifiedTextView, R.string.gift_inventory_expires_in_mobile, new Object[]{timeString}, new WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4(this, data));
                TextView textView = this.binding.f2186b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.giftEntitlementCode");
                textView.setText(giftingUtils.generateGiftUrl(data.getGift().getCode()));
            } else {
                AppViewFlipper appViewFlipper2 = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.giftEntitlementFlipper");
                appViewFlipper2.setDisplayedChild(1);
                this.binding.h.setOnClickListener(new WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$5(this, data));
            }
            View view7 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(view7, "binding.giftEntitlementDivider");
            view7.setVisibility(data.isLastItem().booleanValue() ^ true ? 0 : 8);
            if (!data.isLastItem().booleanValue()) {
                FrameLayout frameLayout = this.binding.d;
                View view8 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view8, "itemView");
                frameLayout.setBackgroundColor(ColorCompat.getThemedColor(view8.getContext(), R.attr.primary_630));
                return;
            }
            FrameLayout frameLayout2 = this.binding.d;
            View view9 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view9, "itemView");
            Context context2 = view9.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "itemView.context");
            frameLayout2.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context2, R.attr.primary_630_bg_bottom_corners, 0, 2, (Object) null));
        }
    }

    /* compiled from: WidgetSettingsGiftingAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$NoGiftsListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter;", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$GiftItem;", "adapter", "<init>", "(Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class NoGiftsListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoGiftsListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
            super(R.layout.view_no_gifts_list_item, widgetSettingsGiftingAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
        }
    }

    /* compiled from: WidgetSettingsGiftingAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$SkuListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter;", "Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$GiftItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$GiftItem;)V", "Lcom/discord/databinding/ViewGiftSkuListItemBinding;", "binding", "Lcom/discord/databinding/ViewGiftSkuListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SkuListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> {
        private final ViewGiftSkuListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SkuListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
            super(R.layout.view_gift_sku_list_item, widgetSettingsGiftingAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.gift_sku_arrow;
            ImageView imageView = (ImageView) view.findViewById(R.id.gift_sku_arrow);
            if (imageView != null) {
                i = R.id.gift_sku_copies;
                TextView textView = (TextView) view.findViewById(R.id.gift_sku_copies);
                if (textView != null) {
                    i = R.id.gift_sku_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.gift_sku_icon);
                    if (simpleDraweeView != null) {
                        i = R.id.gift_sku_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.gift_sku_name);
                        if (textView2 != null) {
                            ViewGiftSkuListItemBinding viewGiftSkuListItemBinding = new ViewGiftSkuListItemBinding((CardView) view, imageView, textView, simpleDraweeView, textView2);
                            Intrinsics3.checkNotNullExpressionValue(viewGiftSkuListItemBinding, "ViewGiftSkuListItemBinding.bind(itemView)");
                            this.binding = viewGiftSkuListItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSettingsGiftingAdapter access$getAdapter$p(SkuListItem skuListItem) {
            return (WidgetSettingsGiftingAdapter) skuListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, GiftItem giftItem) {
            onConfigure2(i, giftItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, GiftItem data) {
            CharSequence name;
            String icon;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (data.getSku() == null || data.getCopies() == null || data.getExpanded() == null) {
                return;
            }
            TextView textView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.giftSkuName");
            textView.setText(data.getSku().getName());
            String applicationIcon$default = null;
            SubscriptionPlanType subscriptionPlanTypeFrom = data.getPlanId() != null ? SubscriptionPlanType.INSTANCE.from(data.getPlanId().longValue()) : null;
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.giftSkuName");
            if (subscriptionPlanTypeFrom != null) {
                Tuples2 tuples2 = subscriptionPlanTypeFrom.getInterval() == SubscriptionInterval.MONTHLY ? new Tuples2(Integer.valueOf(R.string.gift_inventory_subscription_months), Integer.valueOf(R.plurals.gift_inventory_subscription_months_intervalCount)) : new Tuples2(Integer.valueOf(R.string.gift_inventory_subscription_years), Integer.valueOf(R.plurals.gift_inventory_subscription_years_intervalCount));
                int iIntValue = ((Number) tuples2.component1()).intValue();
                int iIntValue2 = ((Number) tuples2.component2()).intValue();
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                name = FormatUtils.d(view, iIntValue, new Object[0], new WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1(this, data, iIntValue2, 1));
            } else {
                name = data.getSku().getName();
            }
            textView2.setText(name);
            TextView textView3 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.giftSkuCopies");
            textView3.setText(StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.gift_inventory_copies_copies, data.getCopies().intValue(), data.getCopies()));
            this.binding.f2188b.setImageResource(data.getExpanded().booleanValue() ? R.drawable.ic_chevron_down_primary_300_12dp : R.drawable.ic_chevron_right_primary_300_12dp);
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            if (premiumUtils.isNitroSku(data.getSku())) {
                this.binding.d.setImageResource(premiumUtils.getNitroGiftIcon(data.getSku()));
            } else {
                Application application = data.getSku().getApplication();
                if (application != null && (icon = application.getIcon()) != null) {
                    applicationIcon$default = IconUtils.getApplicationIcon$default(data.getSku().getApplicationId(), icon, 0, 4, (Object) null);
                }
                this.binding.d.setImageURI(applicationIcon$default);
            }
            this.itemView.setOnClickListener(new WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$2(this, data));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClickSkuListener = WidgetSettingsGiftingAdapter$onClickSkuListener$1.INSTANCE;
        this.onClickCopyListener = WidgetSettingsGiftingAdapter$onClickCopyListener$1.INSTANCE;
        this.onRevokeClickListener = WidgetSettingsGiftingAdapter$onRevokeClickListener$1.INSTANCE;
        this.onGenerateClickListener = WidgetSettingsGiftingAdapter$onGenerateClickListener$1.INSTANCE;
    }

    public static final /* synthetic */ Function1 access$getOnClickCopyListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        return widgetSettingsGiftingAdapter.onClickCopyListener;
    }

    public static final /* synthetic */ Function2 access$getOnClickSkuListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        return widgetSettingsGiftingAdapter.onClickSkuListener;
    }

    public static final /* synthetic */ Function2 access$getOnGenerateClickListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        return widgetSettingsGiftingAdapter.onGenerateClickListener;
    }

    public static final /* synthetic */ Function1 access$getOnRevokeClickListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        return widgetSettingsGiftingAdapter.onRevokeClickListener;
    }

    public static final /* synthetic */ void access$setOnClickCopyListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter, Function1 function1) {
        widgetSettingsGiftingAdapter.onClickCopyListener = function1;
    }

    public static final /* synthetic */ void access$setOnClickSkuListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter, Function2 function2) {
        widgetSettingsGiftingAdapter.onClickSkuListener = function2;
    }

    public static final /* synthetic */ void access$setOnGenerateClickListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter, Function2 function2) {
        widgetSettingsGiftingAdapter.onGenerateClickListener = function2;
    }

    public static final /* synthetic */ void access$setOnRevokeClickListener$p(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter, Function1 function1) {
        widgetSettingsGiftingAdapter.onRevokeClickListener = function1;
    }

    public final void configure(List<GiftItem> giftItems, Function2<? super Long, ? super Long, Unit> onClickSkuListener, Function1<? super String, Unit> onClickCopyListener, Function1<? super ModelGift, Unit> onRevokeClickListener, Function2<? super Long, ? super Long, Unit> onGenerateClickListener) {
        Intrinsics3.checkNotNullParameter(giftItems, "giftItems");
        Intrinsics3.checkNotNullParameter(onClickSkuListener, "onClickSkuListener");
        Intrinsics3.checkNotNullParameter(onClickCopyListener, "onClickCopyListener");
        Intrinsics3.checkNotNullParameter(onRevokeClickListener, "onRevokeClickListener");
        Intrinsics3.checkNotNullParameter(onGenerateClickListener, "onGenerateClickListener");
        setData(giftItems);
        this.onClickSkuListener = onClickSkuListener;
        this.onClickCopyListener = onClickCopyListener;
        this.onRevokeClickListener = onRevokeClickListener;
        this.onGenerateClickListener = onGenerateClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new NoGiftsListItem(this);
        }
        if (viewType == 1) {
            return new SkuListItem(this);
        }
        if (viewType == 2) {
            return new EntitlementListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* compiled from: WidgetSettingsGiftingAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001BBu\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\rJ\u0080\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0004J\u001a\u0010*\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001c\u0010,\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0004R\u001c\u0010/\u001a\u00020$8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010&R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b2\u0010\u0004R!\u0010\u001f\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b4\u0010\u0016R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b6\u0010\u0010R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b8\u0010\rR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00109\u001a\u0004\b:\u0010\nR\u001b\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b \u0010\rR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010;\u001a\u0004\b<\u0010\u0007R\u001b\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b=\u0010\rR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010>\u001a\u0004\b?\u0010\u0012¨\u0006C"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$GiftItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "component1", "()I", "Lcom/discord/models/domain/ModelGift;", "component2", "()Lcom/discord/models/domain/ModelGift;", "Lcom/discord/models/domain/ModelEntitlement;", "component3", "()Lcom/discord/models/domain/ModelEntitlement;", "", "component4", "()Ljava/lang/Boolean;", "Lcom/discord/models/domain/ModelSku;", "component5", "()Lcom/discord/models/domain/ModelSku;", "component6", "()Ljava/lang/Integer;", "", "Lcom/discord/primitives/PlanId;", "component7", "()Ljava/lang/Long;", "component8", "component9", "typeInt", "gift", "entitlement", "expanded", "sku", "copies", "planId", "isLastItem", "wasCopied", "copy", "(ILcom/discord/models/domain/ModelGift;Lcom/discord/models/domain/ModelEntitlement;Ljava/lang/Boolean;Lcom/discord/models/domain/ModelSku;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/discord/widgets/settings/premium/WidgetSettingsGiftingAdapter$GiftItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "getTypeInt", "Ljava/lang/Long;", "getPlanId", "Lcom/discord/models/domain/ModelSku;", "getSku", "Ljava/lang/Boolean;", "getExpanded", "Lcom/discord/models/domain/ModelEntitlement;", "getEntitlement", "Lcom/discord/models/domain/ModelGift;", "getGift", "getWasCopied", "Ljava/lang/Integer;", "getCopies", "<init>", "(ILcom/discord/models/domain/ModelGift;Lcom/discord/models/domain/ModelEntitlement;Ljava/lang/Boolean;Lcom/discord/models/domain/ModelSku;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GiftItem implements MGRecyclerDataPayload {
        public static final int TYPE_GIFT = 2;
        public static final int TYPE_NO_GIFTS = 0;
        public static final int TYPE_SKU = 1;
        private final Integer copies;
        private final ModelEntitlement entitlement;
        private final Boolean expanded;
        private final ModelGift gift;
        private final Boolean isLastItem;
        private final String key;
        private final Long planId;
        private final ModelSku sku;
        private final int type;
        private final int typeInt;
        private final Boolean wasCopied;

        public GiftItem(int i, ModelGift modelGift, ModelEntitlement modelEntitlement, Boolean bool, ModelSku modelSku, Integer num, Long l, Boolean bool2, Boolean bool3) {
            this.typeInt = i;
            this.gift = modelGift;
            this.entitlement = modelEntitlement;
            this.expanded = bool;
            this.sku = modelSku;
            this.copies = num;
            this.planId = l;
            this.isLastItem = bool2;
            this.wasCopied = bool3;
            this.type = i;
            int type = getType();
            String strValueOf = "";
            if (type != 0) {
                if (type == 1) {
                    strValueOf = String.valueOf(modelSku != null ? Long.valueOf(modelSku.getId()) : null);
                } else if (type == 2) {
                    strValueOf = String.valueOf(modelEntitlement != null ? Long.valueOf(modelEntitlement.getId()) : null);
                }
            }
            this.key = strValueOf;
        }

        public static /* synthetic */ GiftItem copy$default(GiftItem giftItem, int i, ModelGift modelGift, ModelEntitlement modelEntitlement, Boolean bool, ModelSku modelSku, Integer num, Long l, Boolean bool2, Boolean bool3, int i2, Object obj) {
            return giftItem.copy((i2 & 1) != 0 ? giftItem.typeInt : i, (i2 & 2) != 0 ? giftItem.gift : modelGift, (i2 & 4) != 0 ? giftItem.entitlement : modelEntitlement, (i2 & 8) != 0 ? giftItem.expanded : bool, (i2 & 16) != 0 ? giftItem.sku : modelSku, (i2 & 32) != 0 ? giftItem.copies : num, (i2 & 64) != 0 ? giftItem.planId : l, (i2 & 128) != 0 ? giftItem.isLastItem : bool2, (i2 & 256) != 0 ? giftItem.wasCopied : bool3);
        }

        /* renamed from: component1, reason: from getter */
        public final int getTypeInt() {
            return this.typeInt;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelGift getGift() {
            return this.gift;
        }

        /* renamed from: component3, reason: from getter */
        public final ModelEntitlement getEntitlement() {
            return this.entitlement;
        }

        /* renamed from: component4, reason: from getter */
        public final Boolean getExpanded() {
            return this.expanded;
        }

        /* renamed from: component5, reason: from getter */
        public final ModelSku getSku() {
            return this.sku;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getCopies() {
            return this.copies;
        }

        /* renamed from: component7, reason: from getter */
        public final Long getPlanId() {
            return this.planId;
        }

        /* renamed from: component8, reason: from getter */
        public final Boolean getIsLastItem() {
            return this.isLastItem;
        }

        /* renamed from: component9, reason: from getter */
        public final Boolean getWasCopied() {
            return this.wasCopied;
        }

        public final GiftItem copy(int typeInt, ModelGift gift, ModelEntitlement entitlement, Boolean expanded, ModelSku sku, Integer copies, Long planId, Boolean isLastItem, Boolean wasCopied) {
            return new GiftItem(typeInt, gift, entitlement, expanded, sku, copies, planId, isLastItem, wasCopied);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GiftItem)) {
                return false;
            }
            GiftItem giftItem = (GiftItem) other;
            return this.typeInt == giftItem.typeInt && Intrinsics3.areEqual(this.gift, giftItem.gift) && Intrinsics3.areEqual(this.entitlement, giftItem.entitlement) && Intrinsics3.areEqual(this.expanded, giftItem.expanded) && Intrinsics3.areEqual(this.sku, giftItem.sku) && Intrinsics3.areEqual(this.copies, giftItem.copies) && Intrinsics3.areEqual(this.planId, giftItem.planId) && Intrinsics3.areEqual(this.isLastItem, giftItem.isLastItem) && Intrinsics3.areEqual(this.wasCopied, giftItem.wasCopied);
        }

        public final Integer getCopies() {
            return this.copies;
        }

        public final ModelEntitlement getEntitlement() {
            return this.entitlement;
        }

        public final Boolean getExpanded() {
            return this.expanded;
        }

        public final ModelGift getGift() {
            return this.gift;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Long getPlanId() {
            return this.planId;
        }

        public final ModelSku getSku() {
            return this.sku;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final int getTypeInt() {
            return this.typeInt;
        }

        public final Boolean getWasCopied() {
            return this.wasCopied;
        }

        public int hashCode() {
            int i = this.typeInt * 31;
            ModelGift modelGift = this.gift;
            int iHashCode = (i + (modelGift != null ? modelGift.hashCode() : 0)) * 31;
            ModelEntitlement modelEntitlement = this.entitlement;
            int iHashCode2 = (iHashCode + (modelEntitlement != null ? modelEntitlement.hashCode() : 0)) * 31;
            Boolean bool = this.expanded;
            int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
            ModelSku modelSku = this.sku;
            int iHashCode4 = (iHashCode3 + (modelSku != null ? modelSku.hashCode() : 0)) * 31;
            Integer num = this.copies;
            int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
            Long l = this.planId;
            int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
            Boolean bool2 = this.isLastItem;
            int iHashCode7 = (iHashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            Boolean bool3 = this.wasCopied;
            return iHashCode7 + (bool3 != null ? bool3.hashCode() : 0);
        }

        public final Boolean isLastItem() {
            return this.isLastItem;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GiftItem(typeInt=");
            sbU.append(this.typeInt);
            sbU.append(", gift=");
            sbU.append(this.gift);
            sbU.append(", entitlement=");
            sbU.append(this.entitlement);
            sbU.append(", expanded=");
            sbU.append(this.expanded);
            sbU.append(", sku=");
            sbU.append(this.sku);
            sbU.append(", copies=");
            sbU.append(this.copies);
            sbU.append(", planId=");
            sbU.append(this.planId);
            sbU.append(", isLastItem=");
            sbU.append(this.isLastItem);
            sbU.append(", wasCopied=");
            return outline.D(sbU, this.wasCopied, ")");
        }

        public /* synthetic */ GiftItem(int i, ModelGift modelGift, ModelEntitlement modelEntitlement, Boolean bool, ModelSku modelSku, Integer num, Long l, Boolean bool2, Boolean bool3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : modelGift, (i2 & 4) != 0 ? null : modelEntitlement, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? null : modelSku, (i2 & 32) != 0 ? null : num, (i2 & 64) != 0 ? null : l, (i2 & 128) != 0 ? null : bool2, (i2 & 256) == 0 ? bool3 : null);
        }
    }
}
