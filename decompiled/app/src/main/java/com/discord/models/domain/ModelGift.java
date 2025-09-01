package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.api.user.User;
import com.discord.models.domain.ModelSku;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelGift.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0007\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010'\u001a\u00020\u000e\u0012\u0006\u0010(\u001a\u00020\u0012\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010*\u001a\u00020\u0012\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0019\u0012\u000e\u0010,\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u001c\u0012\b\u0010-\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bO\u0010PJ\u0019\u0010\u0005\u001a\u00020\u00022\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0014J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0090\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u00122\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010*\u001a\u00020\u00122\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010,\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u001c2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b1\u0010\u0010J\u0010\u00102\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b2\u0010\u0014J\u001a\u00104\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b4\u00105R\u0019\u0010%\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b%\u00106\u001a\u0004\b7\u0010\rR\u001b\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u00108\u001a\u0004\b9\u0010\u0010R\u001b\u0010.\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010:\u001a\u0004\b;\u0010#R\u0013\u0010<\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b<\u0010\rR\u0013\u0010=\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b=\u0010\rR\u0013\u0010>\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b>\u0010\rR\u0019\u0010'\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u00108\u001a\u0004\b?\u0010\u0010R\u0013\u0010@\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010\rR\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010A\u001a\u0004\bB\u0010\u000bR\u0019\u0010*\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010C\u001a\u0004\bD\u0010\u0014R\u001b\u0010+\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010E\u001a\u0004\bF\u0010\u001bR\u001b\u0010-\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010G\u001a\u0004\bH\u0010!R\u001b\u0010)\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010I\u001a\u0004\bJ\u0010\u0017R!\u0010,\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010K\u001a\u0004\bL\u0010\u001eR\u0013\u0010M\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bM\u0010\rR\u0019\u0010(\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010C\u001a\u0004\bN\u0010\u0014¨\u0006Q"}, d2 = {"Lcom/discord/models/domain/ModelGift;", "", "", "Lcom/discord/primitives/Timestamp;", "currentTime", "getExpiresDiff", "(J)J", "", "isExpired", "(J)Z", "component1", "()J", "component2", "()Z", "", "component3", "()Ljava/lang/String;", "component4", "", "component5", "()I", "Lcom/discord/models/domain/ModelStoreListing;", "component6", "()Lcom/discord/models/domain/ModelStoreListing;", "component7", "Lcom/discord/api/user/User;", "component8", "()Lcom/discord/api/user/User;", "Lcom/discord/primitives/PlanId;", "component9", "()Ljava/lang/Long;", "Lcom/discord/api/premium/SubscriptionPlan;", "component10", "()Lcom/discord/api/premium/SubscriptionPlan;", "component11", "()Ljava/lang/Integer;", "skuId", "redeemed", "expiresAt", ModelAuditLogEntry.CHANGE_KEY_CODE, ModelAuditLogEntry.CHANGE_KEY_USES, "storeListing", "maxUses", "user", "subscriptionPlanId", "subscriptionPlan", "giftStyle", "copy", "(JZLjava/lang/String;Ljava/lang/String;ILcom/discord/models/domain/ModelStoreListing;ILcom/discord/api/user/User;Ljava/lang/Long;Lcom/discord/api/premium/SubscriptionPlan;Ljava/lang/Integer;)Lcom/discord/models/domain/ModelGift;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getRedeemed", "Ljava/lang/String;", "getExpiresAt", "Ljava/lang/Integer;", "getGiftStyle", "isComplete", "isAnyNitroGift", "isClaimedByMe", "getCode", "isNitroGift", "J", "getSkuId", "I", "getMaxUses", "Lcom/discord/api/user/User;", "getUser", "Lcom/discord/api/premium/SubscriptionPlan;", "getSubscriptionPlan", "Lcom/discord/models/domain/ModelStoreListing;", "getStoreListing", "Ljava/lang/Long;", "getSubscriptionPlanId", "isNitroClassicGift", "getUses", "<init>", "(JZLjava/lang/String;Ljava/lang/String;ILcom/discord/models/domain/ModelStoreListing;ILcom/discord/api/user/User;Ljava/lang/Long;Lcom/discord/api/premium/SubscriptionPlan;Ljava/lang/Integer;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelGift {
    private final String code;
    private final String expiresAt;
    private final Integer giftStyle;
    private final int maxUses;
    private final boolean redeemed;
    private final long skuId;
    private final ModelStoreListing storeListing;
    private final SubscriptionPlan subscriptionPlan;
    private final Long subscriptionPlanId;
    private final User user;
    private final int uses;

    public ModelGift(long j, boolean z2, String str, String str2, int i, ModelStoreListing modelStoreListing, int i2, User user, Long l, SubscriptionPlan subscriptionPlan, Integer num) {
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.skuId = j;
        this.redeemed = z2;
        this.expiresAt = str;
        this.code = str2;
        this.uses = i;
        this.storeListing = modelStoreListing;
        this.maxUses = i2;
        this.user = user;
        this.subscriptionPlanId = l;
        this.subscriptionPlan = subscriptionPlan;
        this.giftStyle = num;
    }

    public static /* synthetic */ ModelGift copy$default(ModelGift modelGift, long j, boolean z2, String str, String str2, int i, ModelStoreListing modelStoreListing, int i2, User user, Long l, SubscriptionPlan subscriptionPlan, Integer num, int i3, Object obj) {
        return modelGift.copy((i3 & 1) != 0 ? modelGift.skuId : j, (i3 & 2) != 0 ? modelGift.redeemed : z2, (i3 & 4) != 0 ? modelGift.expiresAt : str, (i3 & 8) != 0 ? modelGift.code : str2, (i3 & 16) != 0 ? modelGift.uses : i, (i3 & 32) != 0 ? modelGift.storeListing : modelStoreListing, (i3 & 64) != 0 ? modelGift.maxUses : i2, (i3 & 128) != 0 ? modelGift.user : user, (i3 & 256) != 0 ? modelGift.subscriptionPlanId : l, (i3 & 512) != 0 ? modelGift.subscriptionPlan : subscriptionPlan, (i3 & 1024) != 0 ? modelGift.giftStyle : num);
    }

    /* renamed from: component1, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* renamed from: component10, reason: from getter */
    public final SubscriptionPlan getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getGiftStyle() {
        return this.giftStyle;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getRedeemed() {
        return this.redeemed;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUses() {
        return this.uses;
    }

    /* renamed from: component6, reason: from getter */
    public final ModelStoreListing getStoreListing() {
        return this.storeListing;
    }

    /* renamed from: component7, reason: from getter */
    public final int getMaxUses() {
        return this.maxUses;
    }

    /* renamed from: component8, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component9, reason: from getter */
    public final Long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    public final ModelGift copy(long skuId, boolean redeemed, String expiresAt, String code, int uses, ModelStoreListing storeListing, int maxUses, User user, Long subscriptionPlanId, SubscriptionPlan subscriptionPlan, Integer giftStyle) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return new ModelGift(skuId, redeemed, expiresAt, code, uses, storeListing, maxUses, user, subscriptionPlanId, subscriptionPlan, giftStyle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGift)) {
            return false;
        }
        ModelGift modelGift = (ModelGift) other;
        return this.skuId == modelGift.skuId && this.redeemed == modelGift.redeemed && Intrinsics3.areEqual(this.expiresAt, modelGift.expiresAt) && Intrinsics3.areEqual(this.code, modelGift.code) && this.uses == modelGift.uses && Intrinsics3.areEqual(this.storeListing, modelGift.storeListing) && this.maxUses == modelGift.maxUses && Intrinsics3.areEqual(this.user, modelGift.user) && Intrinsics3.areEqual(this.subscriptionPlanId, modelGift.subscriptionPlanId) && Intrinsics3.areEqual(this.subscriptionPlan, modelGift.subscriptionPlan) && Intrinsics3.areEqual(this.giftStyle, modelGift.giftStyle);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final long getExpiresDiff(long currentTime) {
        String str = this.expiresAt;
        if (str != null) {
            return TimeUtils.parseUTCDate(str) - currentTime;
        }
        return 0L;
    }

    public final Integer getGiftStyle() {
        return this.giftStyle;
    }

    public final int getMaxUses() {
        return this.maxUses;
    }

    public final boolean getRedeemed() {
        return this.redeemed;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final ModelStoreListing getStoreListing() {
        return this.storeListing;
    }

    public final SubscriptionPlan getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    public final Long getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    public final User getUser() {
        return this.user;
    }

    public final int getUses() {
        return this.uses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.skuId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.redeemed;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        String str = this.expiresAt;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.code;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.uses) * 31;
        ModelStoreListing modelStoreListing = this.storeListing;
        int iHashCode3 = (((iHashCode2 + (modelStoreListing != null ? modelStoreListing.hashCode() : 0)) * 31) + this.maxUses) * 31;
        User user = this.user;
        int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
        Long l = this.subscriptionPlanId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        SubscriptionPlan subscriptionPlan = this.subscriptionPlan;
        int iHashCode6 = (iHashCode5 + (subscriptionPlan != null ? subscriptionPlan.hashCode() : 0)) * 31;
        Integer num = this.giftStyle;
        return iHashCode6 + (num != null ? num.hashCode() : 0);
    }

    public final boolean isAnyNitroGift() {
        return isNitroGift() || isNitroClassicGift();
    }

    public final boolean isClaimedByMe() {
        return this.redeemed;
    }

    public final boolean isComplete() {
        return this.storeListing != null;
    }

    public final boolean isExpired(long currentTime) {
        String str = this.expiresAt;
        return str != null && currentTime > TimeUtils.parseUTCDate(str);
    }

    public final boolean isNitroClassicGift() {
        ModelSku sku;
        ModelStoreListing modelStoreListing = this.storeListing;
        return ((modelStoreListing == null || (sku = modelStoreListing.getSku()) == null) ? null : sku.getSkuCategory()) == ModelSku.SkuCategory.NITRO_CLASSIC;
    }

    public final boolean isNitroGift() {
        ModelSku sku;
        ModelStoreListing modelStoreListing = this.storeListing;
        return ((modelStoreListing == null || (sku = modelStoreListing.getSku()) == null) ? null : sku.getSkuCategory()) == ModelSku.SkuCategory.NITRO;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGift(skuId=");
        sbU.append(this.skuId);
        sbU.append(", redeemed=");
        sbU.append(this.redeemed);
        sbU.append(", expiresAt=");
        sbU.append(this.expiresAt);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", uses=");
        sbU.append(this.uses);
        sbU.append(", storeListing=");
        sbU.append(this.storeListing);
        sbU.append(", maxUses=");
        sbU.append(this.maxUses);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", subscriptionPlan=");
        sbU.append(this.subscriptionPlan);
        sbU.append(", giftStyle=");
        return outline.F(sbU, this.giftStyle, ")");
    }
}
