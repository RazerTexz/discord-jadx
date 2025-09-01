package com.discord.models.domain.billing;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelInvoicePreview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\n\u0010\u0018\u001a\u00060\tj\u0002`\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0014\u0010\u0011\u001a\u00060\tj\u0002`\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\f\b\u0002\u0010\u0018\u001a\u00060\tj\u0002`\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J\u001a\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\bR\u001d\u0010\u0018\u001a\u00060\tj\u0002`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b)\u0010\u000bR\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u000eR\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b-\u0010\u0004¨\u00060"}, d2 = {"Lcom/discord/models/domain/billing/ModelInvoiceItem;", "", "", "component1", "()I", "", "Lcom/discord/models/domain/billing/ModelInvoiceDiscount;", "component2", "()Ljava/util/List;", "", "component3", "()J", "", "component4", "()Z", "component5", "Lcom/discord/primitives/PlanId;", "component6", "component7", "amount", "discount", ModelAuditLogEntry.CHANGE_KEY_ID, "proration", "quantity", "subscriptionPlanId", "subscriptionPlanPrice", "copy", "(ILjava/util/List;JZIJI)Lcom/discord/models/domain/billing/ModelInvoiceItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getDiscount", "J", "getSubscriptionPlanId", "I", "getAmount", "getId", "getQuantity", "Z", "getProration", "getSubscriptionPlanPrice", "<init>", "(ILjava/util/List;JZIJI)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.billing.ModelInvoiceItem, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelInvoicePreview3 {
    private final int amount;
    private final List<ModelInvoicePreview2> discount;
    private final long id;
    private final boolean proration;
    private final int quantity;
    private final long subscriptionPlanId;
    private final int subscriptionPlanPrice;

    public ModelInvoicePreview3(int i, List<ModelInvoicePreview2> list, long j, boolean z2, int i2, long j2, int i3) {
        Intrinsics3.checkNotNullParameter(list, "discount");
        this.amount = i;
        this.discount = list;
        this.id = j;
        this.proration = z2;
        this.quantity = i2;
        this.subscriptionPlanId = j2;
        this.subscriptionPlanPrice = i3;
    }

    public static /* synthetic */ ModelInvoicePreview3 copy$default(ModelInvoicePreview3 modelInvoicePreview3, int i, List list, long j, boolean z2, int i2, long j2, int i3, int i4, Object obj) {
        return modelInvoicePreview3.copy((i4 & 1) != 0 ? modelInvoicePreview3.amount : i, (i4 & 2) != 0 ? modelInvoicePreview3.discount : list, (i4 & 4) != 0 ? modelInvoicePreview3.id : j, (i4 & 8) != 0 ? modelInvoicePreview3.proration : z2, (i4 & 16) != 0 ? modelInvoicePreview3.quantity : i2, (i4 & 32) != 0 ? modelInvoicePreview3.subscriptionPlanId : j2, (i4 & 64) != 0 ? modelInvoicePreview3.subscriptionPlanPrice : i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    public final List<ModelInvoicePreview2> component2() {
        return this.discount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getProration() {
        return this.proration;
    }

    /* renamed from: component5, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    /* renamed from: component6, reason: from getter */
    public final long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSubscriptionPlanPrice() {
        return this.subscriptionPlanPrice;
    }

    public final ModelInvoicePreview3 copy(int amount, List<ModelInvoicePreview2> discount, long id2, boolean proration, int quantity, long subscriptionPlanId, int subscriptionPlanPrice) {
        Intrinsics3.checkNotNullParameter(discount, "discount");
        return new ModelInvoicePreview3(amount, discount, id2, proration, quantity, subscriptionPlanId, subscriptionPlanPrice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInvoicePreview3)) {
            return false;
        }
        ModelInvoicePreview3 modelInvoicePreview3 = (ModelInvoicePreview3) other;
        return this.amount == modelInvoicePreview3.amount && Intrinsics3.areEqual(this.discount, modelInvoicePreview3.discount) && this.id == modelInvoicePreview3.id && this.proration == modelInvoicePreview3.proration && this.quantity == modelInvoicePreview3.quantity && this.subscriptionPlanId == modelInvoicePreview3.subscriptionPlanId && this.subscriptionPlanPrice == modelInvoicePreview3.subscriptionPlanPrice;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final List<ModelInvoicePreview2> getDiscount() {
        return this.discount;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getProration() {
        return this.proration;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    public final int getSubscriptionPlanPrice() {
        return this.subscriptionPlanPrice;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.amount * 31;
        List<ModelInvoicePreview2> list = this.discount;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        long j = this.id;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        boolean z2 = this.proration;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (((i2 + i3) * 31) + this.quantity) * 31;
        long j2 = this.subscriptionPlanId;
        return ((i4 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.subscriptionPlanPrice;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelInvoiceItem(amount=");
        sbU.append(this.amount);
        sbU.append(", discount=");
        sbU.append(this.discount);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", proration=");
        sbU.append(this.proration);
        sbU.append(", quantity=");
        sbU.append(this.quantity);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", subscriptionPlanPrice=");
        return outline.B(sbU, this.subscriptionPlanPrice, ")");
    }
}
