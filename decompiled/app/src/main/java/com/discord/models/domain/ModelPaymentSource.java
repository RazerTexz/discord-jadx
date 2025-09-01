package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.billing.ModelBillingAddress;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelPaymentSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00152\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B)\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u0082\u0001\u0002\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/discord/models/domain/ModelPaymentSource;", "", "", "default", "Z", "getDefault", "()Z", "", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "invalid", "getInvalid", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "billingAddress", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "getBillingAddress", "()Lcom/discord/models/domain/billing/ModelBillingAddress;", "<init>", "(Ljava/lang/String;ZLcom/discord/models/domain/billing/ModelBillingAddress;Z)V", "Companion", "ModelPaymentSourceCard", "ModelPaymentSourcePaypal", "UnableToWrapException", "Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourcePaypal;", "Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourceCard;", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class ModelPaymentSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int PAYMENT_SOURCE_TYPE_CARD = 1;
    private static final int PAYMENT_SOURCE_TYPE_PAYPAL = 2;
    private final ModelBillingAddress billingAddress;
    private final boolean default;
    private final String id;
    private final boolean invalid;

    /* compiled from: ModelPaymentSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/models/domain/ModelPaymentSource$Companion;", "", "Lcom/discord/models/domain/PaymentSourceRaw;", "raw", "Lcom/discord/models/domain/ModelPaymentSource;", "wrap", "(Lcom/discord/models/domain/PaymentSourceRaw;)Lcom/discord/models/domain/ModelPaymentSource;", "", "PAYMENT_SOURCE_TYPE_CARD", "I", "PAYMENT_SOURCE_TYPE_PAYPAL", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ModelPaymentSource wrap(ModelPaymentSource3 raw) throws UnableToWrapException {
            Intrinsics3.checkNotNullParameter(raw, "raw");
            try {
                int type = raw.getType();
                if (type == 1) {
                    String brand = raw.getBrand();
                    Intrinsics3.checkNotNull(brand);
                    String last_4 = raw.getLast_4();
                    Intrinsics3.checkNotNull(last_4);
                    return new ModelPaymentSourceCard(brand, last_4, raw.getExpiresMonth(), raw.getExpiresYear(), raw.getId(), raw.getInvalid(), raw.getBillingAddress(), raw.getDefault());
                }
                if (type == 2) {
                    String email = raw.getEmail();
                    Intrinsics3.checkNotNull(email);
                    return new ModelPaymentSourcePaypal(email, raw.getId(), raw.getInvalid(), raw.getBillingAddress(), raw.getDefault());
                }
                throw new IllegalArgumentException("unsupported payment source type: " + raw.getType());
            } catch (Throwable th) {
                throw new UnableToWrapException(th);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ModelPaymentSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001d\u0010\bJ\u001a\u0010 \u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0018\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b#\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010\rR\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\bR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b,\u0010\bR\u001c\u0010\u0019\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b-\u0010\r¨\u00060"}, d2 = {"Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourceCard;", "Lcom/discord/models/domain/ModelPaymentSource;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "component5", "", "component6", "()Z", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "component7", "()Lcom/discord/models/domain/billing/ModelBillingAddress;", "component8", "brand", "last4", "expiresMonth", "expiresYear", ModelAuditLogEntry.CHANGE_KEY_ID, "invalid", "billingAddress", "default", "copy", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLcom/discord/models/domain/billing/ModelBillingAddress;Z)Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourceCard;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "getBillingAddress", "Z", "getInvalid", "Ljava/lang/String;", "getId", "I", "getExpiresYear", "getLast4", "getBrand", "getExpiresMonth", "getDefault", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLcom/discord/models/domain/billing/ModelBillingAddress;Z)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ModelPaymentSourceCard extends ModelPaymentSource {
        private final ModelBillingAddress billingAddress;
        private final String brand;
        private final boolean default;
        private final int expiresMonth;
        private final int expiresYear;
        private final String id;
        private final boolean invalid;
        private final String last4;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelPaymentSourceCard(String str, String str2, int i, int i2, String str3, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3) {
            super(str3, z2, modelBillingAddress, z3, null);
            Intrinsics3.checkNotNullParameter(str, "brand");
            Intrinsics3.checkNotNullParameter(str2, "last4");
            Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(modelBillingAddress, "billingAddress");
            this.brand = str;
            this.last4 = str2;
            this.expiresMonth = i;
            this.expiresYear = i2;
            this.id = str3;
            this.invalid = z2;
            this.billingAddress = modelBillingAddress;
            this.default = z3;
        }

        public static /* synthetic */ ModelPaymentSourceCard copy$default(ModelPaymentSourceCard modelPaymentSourceCard, String str, String str2, int i, int i2, String str3, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, int i3, Object obj) {
            return modelPaymentSourceCard.copy((i3 & 1) != 0 ? modelPaymentSourceCard.brand : str, (i3 & 2) != 0 ? modelPaymentSourceCard.last4 : str2, (i3 & 4) != 0 ? modelPaymentSourceCard.expiresMonth : i, (i3 & 8) != 0 ? modelPaymentSourceCard.expiresYear : i2, (i3 & 16) != 0 ? modelPaymentSourceCard.getId() : str3, (i3 & 32) != 0 ? modelPaymentSourceCard.getInvalid() : z2, (i3 & 64) != 0 ? modelPaymentSourceCard.getBillingAddress() : modelBillingAddress, (i3 & 128) != 0 ? modelPaymentSourceCard.getDefault() : z3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLast4() {
            return this.last4;
        }

        /* renamed from: component3, reason: from getter */
        public final int getExpiresMonth() {
            return this.expiresMonth;
        }

        /* renamed from: component4, reason: from getter */
        public final int getExpiresYear() {
            return this.expiresYear;
        }

        public final String component5() {
            return getId();
        }

        public final boolean component6() {
            return getInvalid();
        }

        public final ModelBillingAddress component7() {
            return getBillingAddress();
        }

        public final boolean component8() {
            return getDefault();
        }

        public final ModelPaymentSourceCard copy(String brand, String last4, int expiresMonth, int expiresYear, String id2, boolean invalid, ModelBillingAddress billingAddress, boolean z2) {
            Intrinsics3.checkNotNullParameter(brand, "brand");
            Intrinsics3.checkNotNullParameter(last4, "last4");
            Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(billingAddress, "billingAddress");
            return new ModelPaymentSourceCard(brand, last4, expiresMonth, expiresYear, id2, invalid, billingAddress, z2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelPaymentSourceCard)) {
                return false;
            }
            ModelPaymentSourceCard modelPaymentSourceCard = (ModelPaymentSourceCard) other;
            return Intrinsics3.areEqual(this.brand, modelPaymentSourceCard.brand) && Intrinsics3.areEqual(this.last4, modelPaymentSourceCard.last4) && this.expiresMonth == modelPaymentSourceCard.expiresMonth && this.expiresYear == modelPaymentSourceCard.expiresYear && Intrinsics3.areEqual(getId(), modelPaymentSourceCard.getId()) && getInvalid() == modelPaymentSourceCard.getInvalid() && Intrinsics3.areEqual(getBillingAddress(), modelPaymentSourceCard.getBillingAddress()) && getDefault() == modelPaymentSourceCard.getDefault();
        }

        @Override // com.discord.models.domain.ModelPaymentSource
        public ModelBillingAddress getBillingAddress() {
            return this.billingAddress;
        }

        public final String getBrand() {
            return this.brand;
        }

        @Override // com.discord.models.domain.ModelPaymentSource
        public boolean getDefault() {
            return this.default;
        }

        public final int getExpiresMonth() {
            return this.expiresMonth;
        }

        public final int getExpiresYear() {
            return this.expiresYear;
        }

        @Override // com.discord.models.domain.ModelPaymentSource
        public String getId() {
            return this.id;
        }

        @Override // com.discord.models.domain.ModelPaymentSource
        public boolean getInvalid() {
            return this.invalid;
        }

        public final String getLast4() {
            return this.last4;
        }

        public int hashCode() {
            String str = this.brand;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.last4;
            int iHashCode2 = (((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.expiresMonth) * 31) + this.expiresYear) * 31;
            String id2 = getId();
            int iHashCode3 = (iHashCode2 + (id2 != null ? id2.hashCode() : 0)) * 31;
            boolean invalid = getInvalid();
            int i = invalid;
            if (invalid) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            ModelBillingAddress billingAddress = getBillingAddress();
            int iHashCode4 = (i2 + (billingAddress != null ? billingAddress.hashCode() : 0)) * 31;
            boolean z2 = getDefault();
            return iHashCode4 + (z2 ? 1 : z2);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelPaymentSourceCard(brand=");
            sbU.append(this.brand);
            sbU.append(", last4=");
            sbU.append(this.last4);
            sbU.append(", expiresMonth=");
            sbU.append(this.expiresMonth);
            sbU.append(", expiresYear=");
            sbU.append(this.expiresYear);
            sbU.append(", id=");
            sbU.append(getId());
            sbU.append(", invalid=");
            sbU.append(getInvalid());
            sbU.append(", billingAddress=");
            sbU.append(getBillingAddress());
            sbU.append(", default=");
            sbU.append(getDefault());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ModelPaymentSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0011\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b#\u0010\b¨\u0006&"}, d2 = {"Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourcePaypal;", "Lcom/discord/models/domain/ModelPaymentSource;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "component4", "()Lcom/discord/models/domain/billing/ModelBillingAddress;", "component5", NotificationCompat.CATEGORY_EMAIL, ModelAuditLogEntry.CHANGE_KEY_ID, "invalid", "billingAddress", "default", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLcom/discord/models/domain/billing/ModelBillingAddress;Z)Lcom/discord/models/domain/ModelPaymentSource$ModelPaymentSourcePaypal;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDefault", "Ljava/lang/String;", "getId", "Lcom/discord/models/domain/billing/ModelBillingAddress;", "getBillingAddress", "getEmail", "getInvalid", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/discord/models/domain/billing/ModelBillingAddress;Z)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ModelPaymentSourcePaypal extends ModelPaymentSource {
        private final ModelBillingAddress billingAddress;
        private final boolean default;
        private final String email;
        private final String id;
        private final boolean invalid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModelPaymentSourcePaypal(String str, String str2, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3) {
            super(str2, z2, modelBillingAddress, z3, null);
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
            Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(modelBillingAddress, "billingAddress");
            this.email = str;
            this.id = str2;
            this.invalid = z2;
            this.billingAddress = modelBillingAddress;
            this.default = z3;
        }

        public static /* synthetic */ ModelPaymentSourcePaypal copy$default(ModelPaymentSourcePaypal modelPaymentSourcePaypal, String str, String str2, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = modelPaymentSourcePaypal.email;
            }
            if ((i & 2) != 0) {
                str2 = modelPaymentSourcePaypal.getId();
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                z2 = modelPaymentSourcePaypal.getInvalid();
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                modelBillingAddress = modelPaymentSourcePaypal.getBillingAddress();
            }
            ModelBillingAddress modelBillingAddress2 = modelBillingAddress;
            if ((i & 16) != 0) {
                z3 = modelPaymentSourcePaypal.getDefault();
            }
            return modelPaymentSourcePaypal.copy(str, str3, z4, modelBillingAddress2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        public final String component2() {
            return getId();
        }

        public final boolean component3() {
            return getInvalid();
        }

        public final ModelBillingAddress component4() {
            return getBillingAddress();
        }

        public final boolean component5() {
            return getDefault();
        }

        public final ModelPaymentSourcePaypal copy(String email, String id2, boolean invalid, ModelBillingAddress billingAddress, boolean z2) {
            Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
            Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
            Intrinsics3.checkNotNullParameter(billingAddress, "billingAddress");
            return new ModelPaymentSourcePaypal(email, id2, invalid, billingAddress, z2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelPaymentSourcePaypal)) {
                return false;
            }
            ModelPaymentSourcePaypal modelPaymentSourcePaypal = (ModelPaymentSourcePaypal) other;
            return Intrinsics3.areEqual(this.email, modelPaymentSourcePaypal.email) && Intrinsics3.areEqual(getId(), modelPaymentSourcePaypal.getId()) && getInvalid() == modelPaymentSourcePaypal.getInvalid() && Intrinsics3.areEqual(getBillingAddress(), modelPaymentSourcePaypal.getBillingAddress()) && getDefault() == modelPaymentSourcePaypal.getDefault();
        }

        @Override // com.discord.models.domain.ModelPaymentSource
        public ModelBillingAddress getBillingAddress() {
            return this.billingAddress;
        }

        @Override // com.discord.models.domain.ModelPaymentSource
        public boolean getDefault() {
            return this.default;
        }

        public final String getEmail() {
            return this.email;
        }

        @Override // com.discord.models.domain.ModelPaymentSource
        public String getId() {
            return this.id;
        }

        @Override // com.discord.models.domain.ModelPaymentSource
        public boolean getInvalid() {
            return this.invalid;
        }

        public int hashCode() {
            String str = this.email;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String id2 = getId();
            int iHashCode2 = (iHashCode + (id2 != null ? id2.hashCode() : 0)) * 31;
            boolean invalid = getInvalid();
            int i = invalid;
            if (invalid) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            ModelBillingAddress billingAddress = getBillingAddress();
            int iHashCode3 = (i2 + (billingAddress != null ? billingAddress.hashCode() : 0)) * 31;
            boolean z2 = getDefault();
            return iHashCode3 + (z2 ? 1 : z2);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelPaymentSourcePaypal(email=");
            sbU.append(this.email);
            sbU.append(", id=");
            sbU.append(getId());
            sbU.append(", invalid=");
            sbU.append(getInvalid());
            sbU.append(", billingAddress=");
            sbU.append(getBillingAddress());
            sbU.append(", default=");
            sbU.append(getDefault());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ModelPaymentSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/models/domain/ModelPaymentSource$UnableToWrapException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnableToWrapException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnableToWrapException(Throwable th) {
            super(th);
            Intrinsics3.checkNotNullParameter(th, "cause");
        }
    }

    private ModelPaymentSource(String str, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3) {
        this.id = str;
        this.invalid = z2;
        this.billingAddress = modelBillingAddress;
        this.default = z3;
    }

    public ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public boolean getDefault() {
        return this.default;
    }

    public String getId() {
        return this.id;
    }

    public boolean getInvalid() {
        return this.invalid;
    }

    public /* synthetic */ ModelPaymentSource(String str, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z2, modelBillingAddress, z3);
    }
}
