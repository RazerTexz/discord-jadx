package com.discord.widgets.settings.billing;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.PaymentMethodListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: PaymentSourceAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\b\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB1\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function0;", "", "onAddClick", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "Lcom/discord/models/domain/ModelPaymentSource;", "onEditPaymentSource", "Lkotlin/jvm/functions/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Companion", "Item", "PaymentSourceAddItem", "PaymentSourceAddViewHolder", "PaymentSourceHeader", "PaymentSourceHeaderViewHolder", "PaymentSourceItem", "PaymentSourceItemViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PaymentSourceAdapter extends MGRecyclerAdapterSimple<Item> {
    private static final int VIEW_TYPE_HEADER = 2;
    private static final int VIEW_TYPE_PAYMENT_ADD = 1;
    private static final int VIEW_TYPE_PAYMENT_SOURCE = 0;
    private final Function0<Unit> onAddClick;
    private final Function1<ModelPaymentSource, Unit> onEditPaymentSource;

    /* compiled from: PaymentSourceAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Item extends MGRecyclerDataPayload {
    }

    /* compiled from: PaymentSourceAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceAddItem;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "", "type", "I", "getType", "()I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PaymentSourceAddItem implements Item {
        private final int type = 1;
        private final String key = "AddPaymentSource";

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceAddViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;)V", "adapter", "<init>", "(Lcom/discord/widgets/settings/billing/PaymentSourceAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PaymentSourceAddViewHolder extends MGRecyclerViewHolder<PaymentSourceAdapter, Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaymentSourceAddViewHolder(PaymentSourceAdapter paymentSourceAdapter) {
            super(R.layout.payment_method_list_add_item, paymentSourceAdapter);
            Intrinsics3.checkNotNullParameter(paymentSourceAdapter, "adapter");
        }

        public static final /* synthetic */ PaymentSourceAdapter access$getAdapter$p(PaymentSourceAddViewHolder paymentSourceAddViewHolder) {
            return (PaymentSourceAdapter) paymentSourceAddViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.itemView.setOnClickListener(new PaymentSourceAdapter2(this));
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u001c\u0010\u0018\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceHeader;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceHeader$Type;", "component1", "()Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceHeader$Type;", "headerType", "copy", "(Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceHeader$Type;)Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceHeader;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceHeader$Type;", "getHeaderType", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "<init>", "(Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceHeader$Type;)V", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PaymentSourceHeader implements Item {
        private final Type headerType;
        private final String key;
        private final int type;

        /* compiled from: PaymentSourceAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceHeader$Type;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "OTHER", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            DEFAULT,
            OTHER
        }

        public PaymentSourceHeader(Type type) {
            Intrinsics3.checkNotNullParameter(type, "headerType");
            this.headerType = type;
            this.type = 2;
            this.key = "headerType" + type;
        }

        public static /* synthetic */ PaymentSourceHeader copy$default(PaymentSourceHeader paymentSourceHeader, Type type, int i, Object obj) {
            if ((i & 1) != 0) {
                type = paymentSourceHeader.headerType;
            }
            return paymentSourceHeader.copy(type);
        }

        /* renamed from: component1, reason: from getter */
        public final Type getHeaderType() {
            return this.headerType;
        }

        public final PaymentSourceHeader copy(Type headerType) {
            Intrinsics3.checkNotNullParameter(headerType, "headerType");
            return new PaymentSourceHeader(headerType);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PaymentSourceHeader) && Intrinsics3.areEqual(this.headerType, ((PaymentSourceHeader) other).headerType);
            }
            return true;
        }

        public final Type getHeaderType() {
            return this.headerType;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.headerType;
            if (type != null) {
                return type.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PaymentSourceHeader(headerType=");
            sbU.append(this.headerType);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceHeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;)V", "adapter", "<init>", "(Lcom/discord/widgets/settings/billing/PaymentSourceAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PaymentSourceHeaderViewHolder extends MGRecyclerViewHolder<PaymentSourceAdapter, Item> {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                PaymentSourceHeader.Type.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[PaymentSourceHeader.Type.DEFAULT.ordinal()] = 1;
                iArr[PaymentSourceHeader.Type.OTHER.ordinal()] = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaymentSourceHeaderViewHolder(PaymentSourceAdapter paymentSourceAdapter) {
            super(R.layout.payment_method_list_header, paymentSourceAdapter);
            Intrinsics3.checkNotNullParameter(paymentSourceAdapter, "adapter");
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            int i;
            Intrinsics3.checkNotNullParameter(data, "data");
            View view = this.itemView;
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) view;
            int iOrdinal = ((PaymentSourceHeader) data).getHeaderType().ordinal();
            if (iOrdinal == 0) {
                i = R.string._default;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.string.other_options;
            }
            textView.setText(i);
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\t\u0010\u0007¨\u0006!"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceItem;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "Lcom/discord/models/domain/ModelPaymentSource;", "component1", "()Lcom/discord/models/domain/ModelPaymentSource;", "", "component2", "()Z", "paymentSource", "isPremium", "copy", "(Lcom/discord/models/domain/ModelPaymentSource;Z)Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelPaymentSource;", "getPaymentSource", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Z", "<init>", "(Lcom/discord/models/domain/ModelPaymentSource;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PaymentSourceItem implements Item {
        private final boolean isPremium;
        private final String key;
        private final ModelPaymentSource paymentSource;
        private final int type;

        public PaymentSourceItem(ModelPaymentSource modelPaymentSource, boolean z2) {
            Intrinsics3.checkNotNullParameter(modelPaymentSource, "paymentSource");
            this.paymentSource = modelPaymentSource;
            this.isPremium = z2;
            this.key = modelPaymentSource.getId();
        }

        public static /* synthetic */ PaymentSourceItem copy$default(PaymentSourceItem paymentSourceItem, ModelPaymentSource modelPaymentSource, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelPaymentSource = paymentSourceItem.paymentSource;
            }
            if ((i & 2) != 0) {
                z2 = paymentSourceItem.isPremium;
            }
            return paymentSourceItem.copy(modelPaymentSource, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelPaymentSource getPaymentSource() {
            return this.paymentSource;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsPremium() {
            return this.isPremium;
        }

        public final PaymentSourceItem copy(ModelPaymentSource paymentSource, boolean isPremium) {
            Intrinsics3.checkNotNullParameter(paymentSource, "paymentSource");
            return new PaymentSourceItem(paymentSource, isPremium);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaymentSourceItem)) {
                return false;
            }
            PaymentSourceItem paymentSourceItem = (PaymentSourceItem) other;
            return Intrinsics3.areEqual(this.paymentSource, paymentSourceItem.paymentSource) && this.isPremium == paymentSourceItem.isPremium;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final ModelPaymentSource getPaymentSource() {
            return this.paymentSource;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelPaymentSource modelPaymentSource = this.paymentSource;
            int iHashCode = (modelPaymentSource != null ? modelPaymentSource.hashCode() : 0) * 31;
            boolean z2 = this.isPremium;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isPremium() {
            return this.isPremium;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PaymentSourceItem(paymentSource=");
            sbU.append(this.paymentSource);
            sbU.append(", isPremium=");
            return outline.O(sbU, this.isPremium, ")");
        }
    }

    /* compiled from: PaymentSourceAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$PaymentSourceItemViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter;", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;)V", "Lcom/discord/databinding/PaymentMethodListItemBinding;", "binding", "Lcom/discord/databinding/PaymentMethodListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/settings/billing/PaymentSourceAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PaymentSourceItemViewHolder extends MGRecyclerViewHolder<PaymentSourceAdapter, Item> {
        private final PaymentMethodListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaymentSourceItemViewHolder(PaymentSourceAdapter paymentSourceAdapter) {
            super(R.layout.payment_method_list_item, paymentSourceAdapter);
            Intrinsics3.checkNotNullParameter(paymentSourceAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.payment_method_edit;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.payment_method_edit);
            if (materialButton != null) {
                i = R.id.payment_method_summary;
                PaymentSourceView paymentSourceView = (PaymentSourceView) view.findViewById(R.id.payment_method_summary);
                if (paymentSourceView != null) {
                    PaymentMethodListItemBinding paymentMethodListItemBinding = new PaymentMethodListItemBinding((RelativeLayout) view, materialButton, paymentSourceView);
                    Intrinsics3.checkNotNullExpressionValue(paymentMethodListItemBinding, "PaymentMethodListItemBinding.bind(itemView)");
                    this.binding = paymentMethodListItemBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ PaymentSourceAdapter access$getAdapter$p(PaymentSourceItemViewHolder paymentSourceItemViewHolder) {
            return (PaymentSourceAdapter) paymentSourceItemViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            PaymentSourceItem paymentSourceItem = (PaymentSourceItem) data;
            ModelPaymentSource paymentSource = paymentSourceItem.getPaymentSource();
            this.binding.c.bind(paymentSource, paymentSourceItem.isPremium());
            this.binding.f2134b.setOnClickListener(new PaymentSourceAdapter3(this, paymentSource));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentSourceAdapter(RecyclerView recyclerView, Function0<Unit> function0, Function1<? super ModelPaymentSource, Unit> function1) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function0, "onAddClick");
        Intrinsics3.checkNotNullParameter(function1, "onEditPaymentSource");
        this.onAddClick = function0;
        this.onEditPaymentSource = function1;
    }

    public static final /* synthetic */ Function0 access$getOnAddClick$p(PaymentSourceAdapter paymentSourceAdapter) {
        return paymentSourceAdapter.onAddClick;
    }

    public static final /* synthetic */ Function1 access$getOnEditPaymentSource$p(PaymentSourceAdapter paymentSourceAdapter) {
        return paymentSourceAdapter.onEditPaymentSource;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new PaymentSourceItemViewHolder(this);
        }
        if (viewType == 1) {
            return new PaymentSourceAddViewHolder(this);
        }
        if (viewType == 2) {
            return new PaymentSourceHeaderViewHolder(this);
        }
        throw new IllegalArgumentException(outline.q("unknown type ", viewType));
    }
}
