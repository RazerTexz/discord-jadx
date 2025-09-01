package com.discord.models.domain;

import com.discord.api.premium.SubscriptionInterval;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import d0.t.Iterables2;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelSubscription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/discord/models/domain/HasSubscriptionItems;", "", "", "Lcom/discord/primitives/PlanId;", "getPremiumBasePlanId", "()J", "", "Lcom/discord/models/domain/ModelSubscription$SubscriptionAdditionalPlan;", "getPremiumAdditionalPlans", "()Ljava/util/List;", "getGuildBoostPlanId", "()Ljava/lang/Long;", "Lcom/discord/models/domain/ModelSubscription$SubscriptionItem;", "getItems", "items", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.HasSubscriptionItems, reason: use source file name */
/* loaded from: classes.dex */
public abstract class ModelSubscription2 {
    public final Long getGuildBoostPlanId() {
        ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan = (ModelSubscription.SubscriptionAdditionalPlan) _Collections.firstOrNull((List) getPremiumAdditionalPlans());
        if (subscriptionAdditionalPlan != null) {
            return Long.valueOf(subscriptionAdditionalPlan.getPlanId());
        }
        return null;
    }

    public abstract List<ModelSubscription.SubscriptionItem> getItems();

    public final List<ModelSubscription.SubscriptionAdditionalPlan> getPremiumAdditionalPlans() {
        List<ModelSubscription.SubscriptionItem> items = getItems();
        ArrayList<ModelSubscription.SubscriptionItem> arrayList = new ArrayList();
        for (Object obj : items) {
            if (((ModelSubscription.SubscriptionItem) obj).getPlanId() != getPremiumBasePlanId()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (ModelSubscription.SubscriptionItem subscriptionItem : arrayList) {
            arrayList2.add(new ModelSubscription.SubscriptionAdditionalPlan(subscriptionItem.getPlanId(), subscriptionItem.getQuantity()));
        }
        return arrayList2;
    }

    public final long getPremiumBasePlanId() {
        ModelSubscription.SubscriptionItem subscriptionItem = (ModelSubscription.SubscriptionItem) _Collections.firstOrNull((List) getItems());
        Long lValueOf = subscriptionItem != null ? Long.valueOf(subscriptionItem.getPlanId()) : null;
        SubscriptionInterval interval = lValueOf != null ? SubscriptionPlanType.INSTANCE.from(lValueOf.longValue()).getInterval() : SubscriptionInterval.MONTHLY;
        ModelSubscription.SubscriptionItem subscriptionItem2 = (ModelSubscription.SubscriptionItem) _Collections.firstOrNull((List) getItems());
        Long lValueOf2 = subscriptionItem2 != null ? Long.valueOf(subscriptionItem2.getPlanId()) : null;
        return SubscriptionPlanType.INSTANCE.getBasePlanFromSubscriptionItems(getItems(), interval, lValueOf2 != null ? SubscriptionPlanType.INSTANCE.from(lValueOf2.longValue()).getIntervalCount() : 1).getPlanId();
    }
}
