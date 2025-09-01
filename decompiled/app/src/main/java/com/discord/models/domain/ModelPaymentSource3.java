package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.billing.ModelBillingAddress;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelPaymentSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004Jz\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b \u0010\u0007J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004J\u001a\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b&\u0010\rR\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010\u0004R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\nR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b-\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b.\u0010\u0004R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b/\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b0\u0010\nR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b1\u0010\u0007R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b2\u0010\u0004¨\u00065"}, d2 = {"Lcom/discord/models/domain/PaymentSourceRaw;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "component4", "()Lcom/discord/models/domain/billing/ModelBillingAddress;", "component5", "component6", "component7", "component8", "component9", "component10", "type", ModelAuditLogEntry.CHANGE_KEY_ID, "invalid", "billingAddress", "default", NotificationCompat.CATEGORY_EMAIL, "brand", "last_4", "expiresMonth", "expiresYear", "copy", "(ILjava/lang/String;ZLcom/discord/models/domain/billing/ModelBillingAddress;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/discord/models/domain/PaymentSourceRaw;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "getBillingAddress", "I", "getExpiresYear", "Ljava/lang/String;", "getBrand", "Z", "getDefault", "getId", "getType", "getEmail", "getInvalid", "getLast_4", "getExpiresMonth", "<init>", "(ILjava/lang/String;ZLcom/discord/models/domain/billing/ModelBillingAddress;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.PaymentSourceRaw, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelPaymentSource3 {
    private final ModelBillingAddress billingAddress;
    private final String brand;
    private final boolean default;
    private final String email;
    private final int expiresMonth;
    private final int expiresYear;
    private final String id;
    private final boolean invalid;
    private final String last_4;
    private final int type;

    public ModelPaymentSource3(int i, String str, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, String str2, String str3, String str4, int i2, int i3) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(modelBillingAddress, "billingAddress");
        this.type = i;
        this.id = str;
        this.invalid = z2;
        this.billingAddress = modelBillingAddress;
        this.default = z3;
        this.email = str2;
        this.brand = str3;
        this.last_4 = str4;
        this.expiresMonth = i2;
        this.expiresYear = i3;
    }

    public static /* synthetic */ ModelPaymentSource3 copy$default(ModelPaymentSource3 modelPaymentSource3, int i, String str, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, String str2, String str3, String str4, int i2, int i3, int i4, Object obj) {
        return modelPaymentSource3.copy((i4 & 1) != 0 ? modelPaymentSource3.type : i, (i4 & 2) != 0 ? modelPaymentSource3.id : str, (i4 & 4) != 0 ? modelPaymentSource3.invalid : z2, (i4 & 8) != 0 ? modelPaymentSource3.billingAddress : modelBillingAddress, (i4 & 16) != 0 ? modelPaymentSource3.default : z3, (i4 & 32) != 0 ? modelPaymentSource3.email : str2, (i4 & 64) != 0 ? modelPaymentSource3.brand : str3, (i4 & 128) != 0 ? modelPaymentSource3.last_4 : str4, (i4 & 256) != 0 ? modelPaymentSource3.expiresMonth : i2, (i4 & 512) != 0 ? modelPaymentSource3.expiresYear : i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final int getExpiresYear() {
        return this.expiresYear;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getInvalid() {
        return this.invalid;
    }

    /* renamed from: component4, reason: from getter */
    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    /* renamed from: component6, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* renamed from: component8, reason: from getter */
    public final String getLast_4() {
        return this.last_4;
    }

    /* renamed from: component9, reason: from getter */
    public final int getExpiresMonth() {
        return this.expiresMonth;
    }

    public final ModelPaymentSource3 copy(int type, String id2, boolean invalid, ModelBillingAddress billingAddress, boolean z2, String email, String brand, String last_4, int expiresMonth, int expiresYear) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(billingAddress, "billingAddress");
        return new ModelPaymentSource3(type, id2, invalid, billingAddress, z2, email, brand, last_4, expiresMonth, expiresYear);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelPaymentSource3)) {
            return false;
        }
        ModelPaymentSource3 modelPaymentSource3 = (ModelPaymentSource3) other;
        return this.type == modelPaymentSource3.type && Intrinsics3.areEqual(this.id, modelPaymentSource3.id) && this.invalid == modelPaymentSource3.invalid && Intrinsics3.areEqual(this.billingAddress, modelPaymentSource3.billingAddress) && this.default == modelPaymentSource3.default && Intrinsics3.areEqual(this.email, modelPaymentSource3.email) && Intrinsics3.areEqual(this.brand, modelPaymentSource3.brand) && Intrinsics3.areEqual(this.last_4, modelPaymentSource3.last_4) && this.expiresMonth == modelPaymentSource3.expiresMonth && this.expiresYear == modelPaymentSource3.expiresYear;
    }

    public final ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final boolean getDefault() {
        return this.default;
    }

    public final String getEmail() {
        return this.email;
    }

    public final int getExpiresMonth() {
        return this.expiresMonth;
    }

    public final int getExpiresYear() {
        return this.expiresYear;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getInvalid() {
        return this.invalid;
    }

    public final String getLast_4() {
        return this.last_4;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.type * 31;
        String str = this.id;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.invalid;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        ModelBillingAddress modelBillingAddress = this.billingAddress;
        int iHashCode2 = (i3 + (modelBillingAddress != null ? modelBillingAddress.hashCode() : 0)) * 31;
        boolean z3 = this.default;
        int i4 = (iHashCode2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        String str2 = this.email;
        int iHashCode3 = (i4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.brand;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.last_4;
        return ((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.expiresMonth) * 31) + this.expiresYear;
    }

    public String toString() {
        StringBuilder sbU = outline.U("PaymentSourceRaw(type=");
        sbU.append(this.type);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", invalid=");
        sbU.append(this.invalid);
        sbU.append(", billingAddress=");
        sbU.append(this.billingAddress);
        sbU.append(", default=");
        sbU.append(this.default);
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", brand=");
        sbU.append(this.brand);
        sbU.append(", last_4=");
        sbU.append(this.last_4);
        sbU.append(", expiresMonth=");
        sbU.append(this.expiresMonth);
        sbU.append(", expiresYear=");
        return outline.B(sbU, this.expiresYear, ")");
    }
}
