package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.premium.SubscriptionPlan;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelEntitlement.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\n\u0010\u001d\u001a\u00060\u0002j\u0002`\t\u0012\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u000b\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012\u000e\u0010#\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0018¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\n\u001a\u00060\u0002j\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0014\u0010\f\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0014J\u008a\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00062\f\b\u0002\u0010\u001d\u001a\u00060\u0002j\u0002`\t2\f\b\u0002\u0010\u001e\u001a\u00060\u0002j\u0002`\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\r2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010#\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0018HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b)\u0010\bJ\u001a\u0010+\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001d\u0010\u001d\u001a\u00060\u0002j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010\u0004R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b0\u0010\u0017R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u0010\bR\u001b\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b5\u0010\u0014R\u001d\u0010\u001e\u001a\u00060\u0002j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b6\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u0010\u000fR!\u0010#\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00188\u0006@\u0006¢\u0006\f\n\u0004\b#\u00104\u001a\u0004\b9\u0010\u0014R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b:\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b \u0010;\u001a\u0004\b<\u0010\u0012¨\u0006?"}, d2 = {"Lcom/discord/models/domain/ModelEntitlement;", "", "", "component1", "()J", "component2", "", "component3", "()I", "Lcom/discord/primitives/UserId;", "component4", "Lcom/discord/primitives/SkuId;", "component5", "Lcom/discord/models/domain/ModelSku;", "component6", "()Lcom/discord/models/domain/ModelSku;", "Lcom/discord/api/premium/SubscriptionPlan;", "component7", "()Lcom/discord/api/premium/SubscriptionPlan;", "component8", "()Ljava/lang/Long;", "", "component9", "()Ljava/lang/Boolean;", "Lcom/discord/primitives/PromoId;", "component10", ModelAuditLogEntry.CHANGE_KEY_ID, "applicationId", "type", "userId", "skuId", "sku", "subscriptionPlan", "parentId", "consumed", "promotionId", "copy", "(JJIJJLcom/discord/models/domain/ModelSku;Lcom/discord/api/premium/SubscriptionPlan;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/discord/models/domain/ModelEntitlement;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getUserId", "Ljava/lang/Boolean;", "getConsumed", "getApplicationId", "I", "getType", "Ljava/lang/Long;", "getParentId", "getSkuId", "Lcom/discord/models/domain/ModelSku;", "getSku", "getPromotionId", "getId", "Lcom/discord/api/premium/SubscriptionPlan;", "getSubscriptionPlan", "<init>", "(JJIJJLcom/discord/models/domain/ModelSku;Lcom/discord/api/premium/SubscriptionPlan;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelEntitlement {
    private final long applicationId;
    private final Boolean consumed;
    private final long id;
    private final Long parentId;
    private final Long promotionId;
    private final ModelSku sku;
    private final long skuId;
    private final SubscriptionPlan subscriptionPlan;
    private final int type;
    private final long userId;

    public ModelEntitlement(long j, long j2, int i, long j3, long j4, ModelSku modelSku, SubscriptionPlan subscriptionPlan, Long l, Boolean bool, Long l2) {
        Intrinsics3.checkNotNullParameter(modelSku, "sku");
        this.id = j;
        this.applicationId = j2;
        this.type = i;
        this.userId = j3;
        this.skuId = j4;
        this.sku = modelSku;
        this.subscriptionPlan = subscriptionPlan;
        this.parentId = l;
        this.consumed = bool;
        this.promotionId = l2;
    }

    public static /* synthetic */ ModelEntitlement copy$default(ModelEntitlement modelEntitlement, long j, long j2, int i, long j3, long j4, ModelSku modelSku, SubscriptionPlan subscriptionPlan, Long l, Boolean bool, Long l2, int i2, Object obj) {
        return modelEntitlement.copy((i2 & 1) != 0 ? modelEntitlement.id : j, (i2 & 2) != 0 ? modelEntitlement.applicationId : j2, (i2 & 4) != 0 ? modelEntitlement.type : i, (i2 & 8) != 0 ? modelEntitlement.userId : j3, (i2 & 16) != 0 ? modelEntitlement.skuId : j4, (i2 & 32) != 0 ? modelEntitlement.sku : modelSku, (i2 & 64) != 0 ? modelEntitlement.subscriptionPlan : subscriptionPlan, (i2 & 128) != 0 ? modelEntitlement.parentId : l, (i2 & 256) != 0 ? modelEntitlement.consumed : bool, (i2 & 512) != 0 ? modelEntitlement.promotionId : l2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getPromotionId() {
        return this.promotionId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* renamed from: component6, reason: from getter */
    public final ModelSku getSku() {
        return this.sku;
    }

    /* renamed from: component7, reason: from getter */
    public final SubscriptionPlan getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getParentId() {
        return this.parentId;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getConsumed() {
        return this.consumed;
    }

    public final ModelEntitlement copy(long id2, long applicationId, int type, long userId, long skuId, ModelSku sku, SubscriptionPlan subscriptionPlan, Long parentId, Boolean consumed, Long promotionId) {
        Intrinsics3.checkNotNullParameter(sku, "sku");
        return new ModelEntitlement(id2, applicationId, type, userId, skuId, sku, subscriptionPlan, parentId, consumed, promotionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelEntitlement)) {
            return false;
        }
        ModelEntitlement modelEntitlement = (ModelEntitlement) other;
        return this.id == modelEntitlement.id && this.applicationId == modelEntitlement.applicationId && this.type == modelEntitlement.type && this.userId == modelEntitlement.userId && this.skuId == modelEntitlement.skuId && Intrinsics3.areEqual(this.sku, modelEntitlement.sku) && Intrinsics3.areEqual(this.subscriptionPlan, modelEntitlement.subscriptionPlan) && Intrinsics3.areEqual(this.parentId, modelEntitlement.parentId) && Intrinsics3.areEqual(this.consumed, modelEntitlement.consumed) && Intrinsics3.areEqual(this.promotionId, modelEntitlement.promotionId);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final Boolean getConsumed() {
        return this.consumed;
    }

    public final long getId() {
        return this.id;
    }

    public final Long getParentId() {
        return this.parentId;
    }

    public final Long getPromotionId() {
        return this.promotionId;
    }

    public final ModelSku getSku() {
        return this.sku;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final SubscriptionPlan getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.applicationId;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.type) * 31;
        long j3 = this.userId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.skuId;
        int i3 = (i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        ModelSku modelSku = this.sku;
        int iHashCode = (i3 + (modelSku != null ? modelSku.hashCode() : 0)) * 31;
        SubscriptionPlan subscriptionPlan = this.subscriptionPlan;
        int iHashCode2 = (iHashCode + (subscriptionPlan != null ? subscriptionPlan.hashCode() : 0)) * 31;
        Long l = this.parentId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.consumed;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.promotionId;
        return iHashCode4 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelEntitlement(id=");
        sbU.append(this.id);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", sku=");
        sbU.append(this.sku);
        sbU.append(", subscriptionPlan=");
        sbU.append(this.subscriptionPlan);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", consumed=");
        sbU.append(this.consumed);
        sbU.append(", promotionId=");
        return outline.G(sbU, this.promotionId, ")");
    }
}
