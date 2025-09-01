package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.billing.ModelBillingAddress;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelPaymentSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/models/domain/PatchPaymentSourceRaw;", "", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "component1", "()Lcom/discord/models/domain/billing/ModelBillingAddress;", "", "component2", "()Z", "billingAddress", "default", "copy", "(Lcom/discord/models/domain/billing/ModelBillingAddress;Z)Lcom/discord/models/domain/PatchPaymentSourceRaw;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDefault", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "getBillingAddress", "<init>", "(Lcom/discord/models/domain/billing/ModelBillingAddress;Z)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.PatchPaymentSourceRaw, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelPaymentSource2 {
    private final ModelBillingAddress billingAddress;
    private final boolean default;

    public ModelPaymentSource2(ModelBillingAddress modelBillingAddress, boolean z2) {
        Intrinsics3.checkNotNullParameter(modelBillingAddress, "billingAddress");
        this.billingAddress = modelBillingAddress;
        this.default = z2;
    }

    public static /* synthetic */ ModelPaymentSource2 copy$default(ModelPaymentSource2 modelPaymentSource2, ModelBillingAddress modelBillingAddress, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelBillingAddress = modelPaymentSource2.billingAddress;
        }
        if ((i & 2) != 0) {
            z2 = modelPaymentSource2.default;
        }
        return modelPaymentSource2.copy(modelBillingAddress, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    public final ModelPaymentSource2 copy(ModelBillingAddress billingAddress, boolean z2) {
        Intrinsics3.checkNotNullParameter(billingAddress, "billingAddress");
        return new ModelPaymentSource2(billingAddress, z2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelPaymentSource2)) {
            return false;
        }
        ModelPaymentSource2 modelPaymentSource2 = (ModelPaymentSource2) other;
        return Intrinsics3.areEqual(this.billingAddress, modelPaymentSource2.billingAddress) && this.default == modelPaymentSource2.default;
    }

    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public final boolean getDefault() {
        return this.default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ModelBillingAddress modelBillingAddress = this.billingAddress;
        int iHashCode = (modelBillingAddress != null ? modelBillingAddress.hashCode() : 0) * 31;
        boolean z2 = this.default;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("PatchPaymentSourceRaw(billingAddress=");
        sbU.append(this.billingAddress);
        sbU.append(", default=");
        return outline.O(sbU, this.default, ")");
    }
}
