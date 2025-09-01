package com.discord.widgets.settings.premium;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.Parcelers;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ClaimStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimStatus;", "Landroid/os/Parcelable;", "<init>", "()V", "Claimed", "Unclaimed", "Lcom/discord/widgets/settings/premium/ClaimStatus$Unclaimed;", "Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class ClaimStatus implements Parcelable {

    /* compiled from: ClaimStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b-\u0010.J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJF\u0010\u0013\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b)\u0010\bR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b*\u0010\bR\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010\r¨\u0006/"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "", "Lcom/discord/primitives/PromoId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Lcom/discord/api/utcdatetime/UtcDateTime;", "component5", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "promoId", ModelAuditLogEntry.CHANGE_KEY_CODE, "body", "link", "redeemBy", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/utcdatetime/UtcDateTime;)Lcom/discord/widgets/settings/premium/ClaimStatus$Claimed;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getPromoId", "Ljava/lang/String;", "getCode", "getBody", "getLink", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getRedeemBy", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/utcdatetime/UtcDateTime;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Claimed extends ClaimStatus {
        public static final Parcelable.Creator<Claimed> CREATOR = new Creator();
        private final String body;
        private final String code;
        private final String link;
        private final long promoId;
        private final UtcDateTime redeemBy;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Claimed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Claimed createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Claimed(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), Parcelers.INSTANCE.create(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Claimed createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Claimed[] newArray(int i) {
                return new Claimed[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Claimed[] newArray(int i) {
                return newArray(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Claimed(long j, String str, String str2, String str3, UtcDateTime utcDateTime) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            Intrinsics3.checkNotNullParameter(str2, "body");
            Intrinsics3.checkNotNullParameter(str3, "link");
            Intrinsics3.checkNotNullParameter(utcDateTime, "redeemBy");
            this.promoId = j;
            this.code = str;
            this.body = str2;
            this.link = str3;
            this.redeemBy = utcDateTime;
        }

        public static /* synthetic */ Claimed copy$default(Claimed claimed, long j, String str, String str2, String str3, UtcDateTime utcDateTime, int i, Object obj) {
            if ((i & 1) != 0) {
                j = claimed.promoId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = claimed.code;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = claimed.body;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = claimed.link;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                utcDateTime = claimed.redeemBy;
            }
            return claimed.copy(j2, str4, str5, str6, utcDateTime);
        }

        /* renamed from: component1, reason: from getter */
        public final long getPromoId() {
            return this.promoId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* renamed from: component3, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        /* renamed from: component4, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        /* renamed from: component5, reason: from getter */
        public final UtcDateTime getRedeemBy() {
            return this.redeemBy;
        }

        public final Claimed copy(long promoId, String code, String body, String link, UtcDateTime redeemBy) {
            Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
            Intrinsics3.checkNotNullParameter(body, "body");
            Intrinsics3.checkNotNullParameter(link, "link");
            Intrinsics3.checkNotNullParameter(redeemBy, "redeemBy");
            return new Claimed(promoId, code, body, link, redeemBy);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Claimed)) {
                return false;
            }
            Claimed claimed = (Claimed) other;
            return this.promoId == claimed.promoId && Intrinsics3.areEqual(this.code, claimed.code) && Intrinsics3.areEqual(this.body, claimed.body) && Intrinsics3.areEqual(this.link, claimed.link) && Intrinsics3.areEqual(this.redeemBy, claimed.redeemBy);
        }

        public final String getBody() {
            return this.body;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getLink() {
            return this.link;
        }

        public final long getPromoId() {
            return this.promoId;
        }

        public final UtcDateTime getRedeemBy() {
            return this.redeemBy;
        }

        public int hashCode() {
            int iA = b.a(this.promoId) * 31;
            String str = this.code;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.body;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.link;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            UtcDateTime utcDateTime = this.redeemBy;
            return iHashCode3 + (utcDateTime != null ? utcDateTime.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Claimed(promoId=");
            sbU.append(this.promoId);
            sbU.append(", code=");
            sbU.append(this.code);
            sbU.append(", body=");
            sbU.append(this.body);
            sbU.append(", link=");
            sbU.append(this.link);
            sbU.append(", redeemBy=");
            sbU.append(this.redeemBy);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.promoId);
            parcel.writeString(this.code);
            parcel.writeString(this.body);
            parcel.writeString(this.link);
            Parcelers.INSTANCE.write((Parcelers) this.redeemBy, parcel, flags);
        }
    }

    /* compiled from: ClaimStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/discord/widgets/settings/premium/ClaimStatus$Unclaimed;", "Lcom/discord/widgets/settings/premium/ClaimStatus;", "", "Lcom/discord/primitives/PromoId;", "component1", "()J", "Lcom/discord/api/utcdatetime/UtcDateTime;", "component2", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "promoId", "claimBy", "copy", "(JLcom/discord/api/utcdatetime/UtcDateTime;)Lcom/discord/widgets/settings/premium/ClaimStatus$Unclaimed;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getPromoId", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getClaimBy", "<init>", "(JLcom/discord/api/utcdatetime/UtcDateTime;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Unclaimed extends ClaimStatus {
        public static final Parcelable.Creator<Unclaimed> CREATOR = new Creator();
        private final UtcDateTime claimBy;
        private final long promoId;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Unclaimed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unclaimed createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Unclaimed(parcel.readLong(), Parcelers.INSTANCE.create(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Unclaimed createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unclaimed[] newArray(int i) {
                return new Unclaimed[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Unclaimed[] newArray(int i) {
                return newArray(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unclaimed(long j, UtcDateTime utcDateTime) {
            super(null);
            Intrinsics3.checkNotNullParameter(utcDateTime, "claimBy");
            this.promoId = j;
            this.claimBy = utcDateTime;
        }

        public static /* synthetic */ Unclaimed copy$default(Unclaimed unclaimed, long j, UtcDateTime utcDateTime, int i, Object obj) {
            if ((i & 1) != 0) {
                j = unclaimed.promoId;
            }
            if ((i & 2) != 0) {
                utcDateTime = unclaimed.claimBy;
            }
            return unclaimed.copy(j, utcDateTime);
        }

        /* renamed from: component1, reason: from getter */
        public final long getPromoId() {
            return this.promoId;
        }

        /* renamed from: component2, reason: from getter */
        public final UtcDateTime getClaimBy() {
            return this.claimBy;
        }

        public final Unclaimed copy(long promoId, UtcDateTime claimBy) {
            Intrinsics3.checkNotNullParameter(claimBy, "claimBy");
            return new Unclaimed(promoId, claimBy);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unclaimed)) {
                return false;
            }
            Unclaimed unclaimed = (Unclaimed) other;
            return this.promoId == unclaimed.promoId && Intrinsics3.areEqual(this.claimBy, unclaimed.claimBy);
        }

        public final UtcDateTime getClaimBy() {
            return this.claimBy;
        }

        public final long getPromoId() {
            return this.promoId;
        }

        public int hashCode() {
            int iA = b.a(this.promoId) * 31;
            UtcDateTime utcDateTime = this.claimBy;
            return iA + (utcDateTime != null ? utcDateTime.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Unclaimed(promoId=");
            sbU.append(this.promoId);
            sbU.append(", claimBy=");
            sbU.append(this.claimBy);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.promoId);
            Parcelers.INSTANCE.write((Parcelers) this.claimBy, parcel, flags);
        }
    }

    private ClaimStatus() {
    }

    public /* synthetic */ ClaimStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
