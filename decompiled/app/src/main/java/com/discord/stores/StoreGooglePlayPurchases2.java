package com.discord.stores;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StoreGooglePlayPurchases.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/stores/PendingDowngrade;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "purchaseToken", "subscriptionId", "newSkuName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/stores/PendingDowngrade;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNewSkuName", "getPurchaseToken", "getSubscriptionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.stores.PendingDowngrade, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class StoreGooglePlayPurchases2 {
    private final String newSkuName;
    private final String purchaseToken;
    private final String subscriptionId;

    public StoreGooglePlayPurchases2(String str, String str2, String str3) {
        outline.q0(str, "purchaseToken", str2, "subscriptionId", str3, "newSkuName");
        this.purchaseToken = str;
        this.subscriptionId = str2;
        this.newSkuName = str3;
    }

    public static /* synthetic */ StoreGooglePlayPurchases2 copy$default(StoreGooglePlayPurchases2 storeGooglePlayPurchases2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeGooglePlayPurchases2.purchaseToken;
        }
        if ((i & 2) != 0) {
            str2 = storeGooglePlayPurchases2.subscriptionId;
        }
        if ((i & 4) != 0) {
            str3 = storeGooglePlayPurchases2.newSkuName;
        }
        return storeGooglePlayPurchases2.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNewSkuName() {
        return this.newSkuName;
    }

    public final StoreGooglePlayPurchases2 copy(String purchaseToken, String subscriptionId, String newSkuName) {
        Intrinsics3.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics3.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics3.checkNotNullParameter(newSkuName, "newSkuName");
        return new StoreGooglePlayPurchases2(purchaseToken, subscriptionId, newSkuName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGooglePlayPurchases2)) {
            return false;
        }
        StoreGooglePlayPurchases2 storeGooglePlayPurchases2 = (StoreGooglePlayPurchases2) other;
        return Intrinsics3.areEqual(this.purchaseToken, storeGooglePlayPurchases2.purchaseToken) && Intrinsics3.areEqual(this.subscriptionId, storeGooglePlayPurchases2.subscriptionId) && Intrinsics3.areEqual(this.newSkuName, storeGooglePlayPurchases2.newSkuName);
    }

    public final String getNewSkuName() {
        return this.newSkuName;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public int hashCode() {
        String str = this.purchaseToken;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subscriptionId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.newSkuName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PendingDowngrade(purchaseToken=");
        sbU.append(this.purchaseToken);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", newSkuName=");
        return outline.J(sbU, this.newSkuName, ")");
    }
}
