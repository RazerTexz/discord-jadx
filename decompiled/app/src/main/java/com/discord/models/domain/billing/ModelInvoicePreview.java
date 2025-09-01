package com.discord.models.domain.billing;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelInvoicePreview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010Jp\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00052\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010\"\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\"\u0010\u0010J\u001a\u0010$\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010(\u001a\u0004\b)\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b-\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b0\u0010\u0014R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b2\u0010\u000bR\u0019\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b3\u0010\u0010¨\u00066"}, d2 = {"Lcom/discord/models/domain/billing/ModelInvoicePreview;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "", "Lcom/discord/models/domain/billing/ModelInvoiceItem;", "component3", "()Ljava/util/List;", "component4", "component5", "", "component6", "()I", "component7", "", "component8", "()Z", "component9", "currency", ModelAuditLogEntry.CHANGE_KEY_ID, "invoiceItems", "subscriptionPeriodEnd", "subscriptionPeriodStart", "subtotal", "tax", "taxInclusive", "total", "copy", "(Ljava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;IIZI)Lcom/discord/models/domain/billing/ModelInvoicePreview;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSubscriptionPeriodStart", "I", "getTotal", "J", "getId", "getSubscriptionPeriodEnd", "getTax", "getCurrency", "Z", "getTaxInclusive", "Ljava/util/List;", "getInvoiceItems", "getSubtotal", "<init>", "(Ljava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;IIZI)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelInvoicePreview {
    private final String currency;
    private final long id;
    private final List<ModelInvoicePreview3> invoiceItems;
    private final String subscriptionPeriodEnd;
    private final String subscriptionPeriodStart;
    private final int subtotal;
    private final int tax;
    private final boolean taxInclusive;
    private final int total;

    public ModelInvoicePreview(String str, long j, List<ModelInvoicePreview3> list, String str2, String str3, int i, int i2, boolean z2, int i3) {
        Intrinsics3.checkNotNullParameter(str, "currency");
        Intrinsics3.checkNotNullParameter(list, "invoiceItems");
        Intrinsics3.checkNotNullParameter(str2, "subscriptionPeriodEnd");
        Intrinsics3.checkNotNullParameter(str3, "subscriptionPeriodStart");
        this.currency = str;
        this.id = j;
        this.invoiceItems = list;
        this.subscriptionPeriodEnd = str2;
        this.subscriptionPeriodStart = str3;
        this.subtotal = i;
        this.tax = i2;
        this.taxInclusive = z2;
        this.total = i3;
    }

    public static /* synthetic */ ModelInvoicePreview copy$default(ModelInvoicePreview modelInvoicePreview, String str, long j, List list, String str2, String str3, int i, int i2, boolean z2, int i3, int i4, Object obj) {
        return modelInvoicePreview.copy((i4 & 1) != 0 ? modelInvoicePreview.currency : str, (i4 & 2) != 0 ? modelInvoicePreview.id : j, (i4 & 4) != 0 ? modelInvoicePreview.invoiceItems : list, (i4 & 8) != 0 ? modelInvoicePreview.subscriptionPeriodEnd : str2, (i4 & 16) != 0 ? modelInvoicePreview.subscriptionPeriodStart : str3, (i4 & 32) != 0 ? modelInvoicePreview.subtotal : i, (i4 & 64) != 0 ? modelInvoicePreview.tax : i2, (i4 & 128) != 0 ? modelInvoicePreview.taxInclusive : z2, (i4 & 256) != 0 ? modelInvoicePreview.total : i3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<ModelInvoicePreview3> component3() {
        return this.invoiceItems;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubscriptionPeriodEnd() {
        return this.subscriptionPeriodEnd;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSubscriptionPeriodStart() {
        return this.subscriptionPeriodStart;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSubtotal() {
        return this.subtotal;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTax() {
        return this.tax;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getTaxInclusive() {
        return this.taxInclusive;
    }

    /* renamed from: component9, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final ModelInvoicePreview copy(String currency, long id2, List<ModelInvoicePreview3> invoiceItems, String subscriptionPeriodEnd, String subscriptionPeriodStart, int subtotal, int tax, boolean taxInclusive, int total) {
        Intrinsics3.checkNotNullParameter(currency, "currency");
        Intrinsics3.checkNotNullParameter(invoiceItems, "invoiceItems");
        Intrinsics3.checkNotNullParameter(subscriptionPeriodEnd, "subscriptionPeriodEnd");
        Intrinsics3.checkNotNullParameter(subscriptionPeriodStart, "subscriptionPeriodStart");
        return new ModelInvoicePreview(currency, id2, invoiceItems, subscriptionPeriodEnd, subscriptionPeriodStart, subtotal, tax, taxInclusive, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInvoicePreview)) {
            return false;
        }
        ModelInvoicePreview modelInvoicePreview = (ModelInvoicePreview) other;
        return Intrinsics3.areEqual(this.currency, modelInvoicePreview.currency) && this.id == modelInvoicePreview.id && Intrinsics3.areEqual(this.invoiceItems, modelInvoicePreview.invoiceItems) && Intrinsics3.areEqual(this.subscriptionPeriodEnd, modelInvoicePreview.subscriptionPeriodEnd) && Intrinsics3.areEqual(this.subscriptionPeriodStart, modelInvoicePreview.subscriptionPeriodStart) && this.subtotal == modelInvoicePreview.subtotal && this.tax == modelInvoicePreview.tax && this.taxInclusive == modelInvoicePreview.taxInclusive && this.total == modelInvoicePreview.total;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final long getId() {
        return this.id;
    }

    public final List<ModelInvoicePreview3> getInvoiceItems() {
        return this.invoiceItems;
    }

    public final String getSubscriptionPeriodEnd() {
        return this.subscriptionPeriodEnd;
    }

    public final String getSubscriptionPeriodStart() {
        return this.subscriptionPeriodStart;
    }

    public final int getSubtotal() {
        return this.subtotal;
    }

    public final int getTax() {
        return this.tax;
    }

    public final boolean getTaxInclusive() {
        return this.taxInclusive;
    }

    public final int getTotal() {
        return this.total;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.currency;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.id;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        List<ModelInvoicePreview3> list = this.invoiceItems;
        int iHashCode2 = (i + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.subscriptionPeriodEnd;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subscriptionPeriodStart;
        int iHashCode4 = (((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.subtotal) * 31) + this.tax) * 31;
        boolean z2 = this.taxInclusive;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return ((iHashCode4 + i2) * 31) + this.total;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelInvoicePreview(currency=");
        sbU.append(this.currency);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", invoiceItems=");
        sbU.append(this.invoiceItems);
        sbU.append(", subscriptionPeriodEnd=");
        sbU.append(this.subscriptionPeriodEnd);
        sbU.append(", subscriptionPeriodStart=");
        sbU.append(this.subscriptionPeriodStart);
        sbU.append(", subtotal=");
        sbU.append(this.subtotal);
        sbU.append(", tax=");
        sbU.append(this.tax);
        sbU.append(", taxInclusive=");
        sbU.append(this.taxInclusive);
        sbU.append(", total=");
        return outline.B(sbU, this.total, ")");
    }
}
