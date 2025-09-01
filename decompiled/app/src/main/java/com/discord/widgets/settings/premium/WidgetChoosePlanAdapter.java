package com.discord.widgets.settings.premium;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.databinding.WidgetChoosePlanAdapterHeaderItemBinding;
import com.discord.databinding.WidgetChoosePlanAdapterPlanItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.premium.PremiumUtils;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChoosePlanAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\t\u001a\u00020\u00072\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R2\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;", "Lkotlin/Function3;", "Lcom/discord/utilities/billing/GooglePlaySku;", "", "Lcom/android/billingclient/api/SkuDetails;", "", "onClickPlan", "setOnClickPlan", "(Lkotlin/jvm/functions/Function3;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/jvm/functions/Function3;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "DividerViewHolder", "HeaderViewHolder", "Item", "PlanViewHeader", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter extends MGRecyclerAdapterSimple<Item> {
    private Function3<? super GooglePlaySku, ? super String, ? super SkuDetails, Unit> onClickPlan;

    /* compiled from: WidgetChoosePlanAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$DividerViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;", "adapter", "<init>", "(Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DividerViewHolder extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DividerViewHolder(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
            super(R.layout.widget_choose_plan_adapter_divider_item, widgetChoosePlanAdapter);
            Intrinsics3.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
        }
    }

    /* compiled from: WidgetChoosePlanAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$HeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;)V", "Lcom/discord/databinding/WidgetChoosePlanAdapterHeaderItemBinding;", "binding", "Lcom/discord/databinding/WidgetChoosePlanAdapterHeaderItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> {
        private final WidgetChoosePlanAdapterHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
            super(R.layout.widget_choose_plan_adapter_header_item, widgetChoosePlanAdapter);
            Intrinsics3.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.select_subscription_header_text);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.select_subscription_header_text)));
            }
            WidgetChoosePlanAdapterHeaderItemBinding widgetChoosePlanAdapterHeaderItemBinding = new WidgetChoosePlanAdapterHeaderItemBinding((FrameLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetChoosePlanAdapterHeaderItemBinding, "WidgetChoosePlanAdapterH…temBinding.bind(itemView)");
            this.binding = widgetChoosePlanAdapterHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.f2347b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.selectSubscriptionHeaderText");
            FormatUtils.n(textView, ((Item.Header) data).getTitleStringResId(), new Object[0], null, 4);
        }
    }

    /* compiled from: WidgetChoosePlanAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0004\t\n\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "type", "I", "getType", "()I", "<init>", "(I)V", "Companion", "Divider", Traits.Location.Section.HEADER, "Plan", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item$Header;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item$Divider;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item$Plan;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_DIVIDER = 2;
        public static final int TYPE_HEADER = 0;
        public static final int TYPE_PLAN = 1;
        private final int type;

        /* compiled from: WidgetChoosePlanAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item$Divider;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Divider extends Item {
            private final String key;

            public Divider() {
                super(2, null);
                this.key = String.valueOf(getType());
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }
        }

        /* compiled from: WidgetChoosePlanAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item$Header;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;", "", "component1", "()I", "titleStringResId", "copy", "(I)Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item$Header;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "I", "getTitleStringResId", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Header extends Item {
            private final String key;
            private final int titleStringResId;

            public Header(@StringRes int i) {
                super(0, null);
                this.titleStringResId = i;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ Header copy$default(Header header, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = header.titleStringResId;
                }
                return header.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            public final Header copy(@StringRes int titleStringResId) {
                return new Header(titleStringResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Header) && this.titleStringResId == ((Header) other).titleStringResId;
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            public int hashCode() {
                return this.titleStringResId;
            }

            public String toString() {
                return outline.B(outline.U("Header(titleStringResId="), this.titleStringResId, ")");
            }
        }

        /* compiled from: WidgetChoosePlanAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJR\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b\u0015\u0010\u000fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u000bR\u001c\u0010&\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010$\u001a\u0004\b'\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b*\u0010\u0007¨\u0006-"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item$Plan;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;", "Lcom/discord/utilities/billing/GooglePlaySku;", "component1", "()Lcom/discord/utilities/billing/GooglePlaySku;", "Lcom/android/billingclient/api/SkuDetails;", "component2", "()Lcom/android/billingclient/api/SkuDetails;", "component3", "", "component4", "()Ljava/lang/String;", "component5", "", "component6", "()Z", "displaySku", "skuDetails", "purchaseSku", "oldSkuName", "upgradeSkuDetails", "isCurrentPlan", "copy", "(Lcom/discord/utilities/billing/GooglePlaySku;Lcom/android/billingclient/api/SkuDetails;Lcom/discord/utilities/billing/GooglePlaySku;Ljava/lang/String;Lcom/android/billingclient/api/SkuDetails;Z)Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item$Plan;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/utilities/billing/GooglePlaySku;", "getPurchaseSku", "getDisplaySku", "Ljava/lang/String;", "getOldSkuName", "key", "getKey", "Lcom/android/billingclient/api/SkuDetails;", "getSkuDetails", "getUpgradeSkuDetails", "<init>", "(Lcom/discord/utilities/billing/GooglePlaySku;Lcom/android/billingclient/api/SkuDetails;Lcom/discord/utilities/billing/GooglePlaySku;Ljava/lang/String;Lcom/android/billingclient/api/SkuDetails;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Plan extends Item {
            private final GooglePlaySku displaySku;
            private final boolean isCurrentPlan;
            private final String key;
            private final String oldSkuName;
            private final GooglePlaySku purchaseSku;
            private final SkuDetails skuDetails;
            private final SkuDetails upgradeSkuDetails;

            public /* synthetic */ Plan(GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(googlePlaySku, skuDetails, googlePlaySku2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : skuDetails2, (i & 32) != 0 ? false : z2);
            }

            public static /* synthetic */ Plan copy$default(Plan plan, GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    googlePlaySku = plan.displaySku;
                }
                if ((i & 2) != 0) {
                    skuDetails = plan.skuDetails;
                }
                SkuDetails skuDetails3 = skuDetails;
                if ((i & 4) != 0) {
                    googlePlaySku2 = plan.purchaseSku;
                }
                GooglePlaySku googlePlaySku3 = googlePlaySku2;
                if ((i & 8) != 0) {
                    str = plan.oldSkuName;
                }
                String str2 = str;
                if ((i & 16) != 0) {
                    skuDetails2 = plan.upgradeSkuDetails;
                }
                SkuDetails skuDetails4 = skuDetails2;
                if ((i & 32) != 0) {
                    z2 = plan.isCurrentPlan;
                }
                return plan.copy(googlePlaySku, skuDetails3, googlePlaySku3, str2, skuDetails4, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final GooglePlaySku getDisplaySku() {
                return this.displaySku;
            }

            /* renamed from: component2, reason: from getter */
            public final SkuDetails getSkuDetails() {
                return this.skuDetails;
            }

            /* renamed from: component3, reason: from getter */
            public final GooglePlaySku getPurchaseSku() {
                return this.purchaseSku;
            }

            /* renamed from: component4, reason: from getter */
            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            /* renamed from: component5, reason: from getter */
            public final SkuDetails getUpgradeSkuDetails() {
                return this.upgradeSkuDetails;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsCurrentPlan() {
                return this.isCurrentPlan;
            }

            public final Plan copy(GooglePlaySku displaySku, SkuDetails skuDetails, GooglePlaySku purchaseSku, String oldSkuName, SkuDetails upgradeSkuDetails, boolean isCurrentPlan) {
                Intrinsics3.checkNotNullParameter(displaySku, "displaySku");
                Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
                return new Plan(displaySku, skuDetails, purchaseSku, oldSkuName, upgradeSkuDetails, isCurrentPlan);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Plan)) {
                    return false;
                }
                Plan plan = (Plan) other;
                return Intrinsics3.areEqual(this.displaySku, plan.displaySku) && Intrinsics3.areEqual(this.skuDetails, plan.skuDetails) && Intrinsics3.areEqual(this.purchaseSku, plan.purchaseSku) && Intrinsics3.areEqual(this.oldSkuName, plan.oldSkuName) && Intrinsics3.areEqual(this.upgradeSkuDetails, plan.upgradeSkuDetails) && this.isCurrentPlan == plan.isCurrentPlan;
            }

            public final GooglePlaySku getDisplaySku() {
                return this.displaySku;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            public final GooglePlaySku getPurchaseSku() {
                return this.purchaseSku;
            }

            public final SkuDetails getSkuDetails() {
                return this.skuDetails;
            }

            public final SkuDetails getUpgradeSkuDetails() {
                return this.upgradeSkuDetails;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                GooglePlaySku googlePlaySku = this.displaySku;
                int iHashCode = (googlePlaySku != null ? googlePlaySku.hashCode() : 0) * 31;
                SkuDetails skuDetails = this.skuDetails;
                int iHashCode2 = (iHashCode + (skuDetails != null ? skuDetails.hashCode() : 0)) * 31;
                GooglePlaySku googlePlaySku2 = this.purchaseSku;
                int iHashCode3 = (iHashCode2 + (googlePlaySku2 != null ? googlePlaySku2.hashCode() : 0)) * 31;
                String str = this.oldSkuName;
                int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
                SkuDetails skuDetails2 = this.upgradeSkuDetails;
                int iHashCode5 = (iHashCode4 + (skuDetails2 != null ? skuDetails2.hashCode() : 0)) * 31;
                boolean z2 = this.isCurrentPlan;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode5 + i;
            }

            public final boolean isCurrentPlan() {
                return this.isCurrentPlan;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Plan(displaySku=");
                sbU.append(this.displaySku);
                sbU.append(", skuDetails=");
                sbU.append(this.skuDetails);
                sbU.append(", purchaseSku=");
                sbU.append(this.purchaseSku);
                sbU.append(", oldSkuName=");
                sbU.append(this.oldSkuName);
                sbU.append(", upgradeSkuDetails=");
                sbU.append(this.upgradeSkuDetails);
                sbU.append(", isCurrentPlan=");
                return outline.O(sbU, this.isCurrentPlan, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Plan(GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2) {
                super(1, null);
                Intrinsics3.checkNotNullParameter(googlePlaySku, "displaySku");
                Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
                this.displaySku = googlePlaySku;
                this.skuDetails = skuDetails;
                this.purchaseSku = googlePlaySku2;
                this.oldSkuName = str;
                this.upgradeSkuDetails = skuDetails2;
                this.isCurrentPlan = z2;
                this.key = getType() + googlePlaySku.getSkuName();
            }
        }

        private Item(int i) {
            this.type = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public /* synthetic */ Item(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }
    }

    /* compiled from: WidgetChoosePlanAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$PlanViewHeader;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter;", "Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter$Item;)V", "Lcom/discord/databinding/WidgetChoosePlanAdapterPlanItemBinding;", "binding", "Lcom/discord/databinding/WidgetChoosePlanAdapterPlanItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/settings/premium/WidgetChoosePlanAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PlanViewHeader extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> {
        private final WidgetChoosePlanAdapterPlanItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlanViewHeader(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
            super(R.layout.widget_choose_plan_adapter_plan_item, widgetChoosePlanAdapter);
            Intrinsics3.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
            WidgetChoosePlanAdapterPlanItemBinding widgetChoosePlanAdapterPlanItemBindingA = WidgetChoosePlanAdapterPlanItemBinding.a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetChoosePlanAdapterPlanItemBindingA, "WidgetChoosePlanAdapterP…temBinding.bind(itemView)");
            this.binding = widgetChoosePlanAdapterPlanItemBindingA;
        }

        public static final /* synthetic */ WidgetChoosePlanAdapter access$getAdapter$p(PlanViewHeader planViewHeader) {
            return (WidgetChoosePlanAdapter) planViewHeader.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            Item.Plan plan = (Item.Plan) data;
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.planItemName");
            textView.setText(plan.getSkuDetails().a());
            TextView textView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.planItemPrice");
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            MaterialCardView materialCardView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.planItemContainer");
            Context context = materialCardView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.planItemContainer.context");
            textView2.setText(premiumUtils.getPlanPriceText(context, plan.getSkuDetails()));
            this.binding.e.setImageResource(plan.getDisplaySku().getIconDrawableResId());
            TextView textView3 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.planItemCurrentPlan");
            textView3.setVisibility(plan.isCurrentPlan() ? 0 : 8);
            this.binding.f2348b.setImageResource(plan.isCurrentPlan() ? GooglePlaySku.INSTANCE.getBorderResource(plan.getDisplaySku().getType()) : 0);
            if (plan.getPurchaseSku() == null) {
                TextView textView4 = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.planItemPrice");
                DrawableCompat.setCompoundDrawablesCompat$default(textView4, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, 11, (Object) null);
                return;
            }
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, R.attr.ic_navigate_next, 0, 2, (Object) null);
            TextView textView5 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.planItemPrice");
            DrawableCompat.setCompoundDrawablesCompat$default(textView5, 0, 0, themedDrawableRes$default, 0, 11, (Object) null);
            this.binding.c.setOnClickListener(new WidgetChoosePlanAdapter2(this, data));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlanAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClickPlan = WidgetChoosePlanAdapter3.INSTANCE;
    }

    public static final /* synthetic */ Function3 access$getOnClickPlan$p(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
        return widgetChoosePlanAdapter.onClickPlan;
    }

    public static final /* synthetic */ void access$setOnClickPlan$p(WidgetChoosePlanAdapter widgetChoosePlanAdapter, Function3 function3) {
        widgetChoosePlanAdapter.onClickPlan = function3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickPlan(Function3<? super GooglePlaySku, ? super String, ? super SkuDetails, Unit> onClickPlan) {
        Intrinsics3.checkNotNullParameter(onClickPlan, "onClickPlan");
        this.onClickPlan = onClickPlan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new PlanViewHeader(this);
        }
        if (viewType == 2) {
            return new DividerViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
