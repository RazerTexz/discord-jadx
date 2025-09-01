package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelGuildBoostSlot.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\u0010\u0013\u001a\u00060\u0005j\u0002`\b\u0012\n\u0010\u0014\u001a\u00060\u0005j\u0002`\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\t\u001a\u00060\u0005j\u0002`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0014\u0010\u000b\u001a\u00060\u0005j\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JN\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\f\b\u0002\u0010\u0013\u001a\u00060\u0005j\u0002`\b2\f\b\u0002\u0010\u0014\u001a\u00060\u0005j\u0002`\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\u000eR\u0019\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010$R\u001d\u0010\u0014\u001a\u00060\u0005j\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\u0007R\u001d\u0010\u0013\u001a\u00060\u0005j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b'\u0010\u0007¨\u0006*"}, d2 = {"Lcom/discord/models/domain/ModelGuildBoostSlot;", "", "", "component1", "()Ljava/lang/String;", "", "getCooldownExpiresAtTimestamp", "()J", "Lcom/discord/primitives/GuildBoostSlotId;", "component2", "Lcom/discord/primitives/AppliedGuildBoostId;", "component3", "Lcom/discord/models/domain/ModelAppliedGuildBoost;", "component4", "()Lcom/discord/models/domain/ModelAppliedGuildBoost;", "", "component5", "()Z", "cooldownEndsAt", ModelAuditLogEntry.CHANGE_KEY_ID, "subscriptionId", "premiumGuildSubscription", "canceled", "copy", "(Ljava/lang/String;JJLcom/discord/models/domain/ModelAppliedGuildBoost;Z)Lcom/discord/models/domain/ModelGuildBoostSlot;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelAppliedGuildBoost;", "getPremiumGuildSubscription", "Z", "getCanceled", "Ljava/lang/String;", "J", "getSubscriptionId", "getId", "<init>", "(Ljava/lang/String;JJLcom/discord/models/domain/ModelAppliedGuildBoost;Z)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelGuildBoostSlot {
    private final boolean canceled;
    private final String cooldownEndsAt;
    private final long id;
    private final ModelAppliedGuildBoost premiumGuildSubscription;
    private final long subscriptionId;

    public ModelGuildBoostSlot(String str, long j, long j2, ModelAppliedGuildBoost modelAppliedGuildBoost, boolean z2) {
        this.cooldownEndsAt = str;
        this.id = j;
        this.subscriptionId = j2;
        this.premiumGuildSubscription = modelAppliedGuildBoost;
        this.canceled = z2;
    }

    /* renamed from: component1, reason: from getter */
    private final String getCooldownEndsAt() {
        return this.cooldownEndsAt;
    }

    public static /* synthetic */ ModelGuildBoostSlot copy$default(ModelGuildBoostSlot modelGuildBoostSlot, String str, long j, long j2, ModelAppliedGuildBoost modelAppliedGuildBoost, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelGuildBoostSlot.cooldownEndsAt;
        }
        if ((i & 2) != 0) {
            j = modelGuildBoostSlot.id;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = modelGuildBoostSlot.subscriptionId;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            modelAppliedGuildBoost = modelGuildBoostSlot.premiumGuildSubscription;
        }
        ModelAppliedGuildBoost modelAppliedGuildBoost2 = modelAppliedGuildBoost;
        if ((i & 16) != 0) {
            z2 = modelGuildBoostSlot.canceled;
        }
        return modelGuildBoostSlot.copy(str, j3, j4, modelAppliedGuildBoost2, z2);
    }

    /* renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component4, reason: from getter */
    public final ModelAppliedGuildBoost getPremiumGuildSubscription() {
        return this.premiumGuildSubscription;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    public final ModelGuildBoostSlot copy(String cooldownEndsAt, long id2, long subscriptionId, ModelAppliedGuildBoost premiumGuildSubscription, boolean canceled) {
        return new ModelGuildBoostSlot(cooldownEndsAt, id2, subscriptionId, premiumGuildSubscription, canceled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildBoostSlot)) {
            return false;
        }
        ModelGuildBoostSlot modelGuildBoostSlot = (ModelGuildBoostSlot) other;
        return Intrinsics3.areEqual(this.cooldownEndsAt, modelGuildBoostSlot.cooldownEndsAt) && this.id == modelGuildBoostSlot.id && this.subscriptionId == modelGuildBoostSlot.subscriptionId && Intrinsics3.areEqual(this.premiumGuildSubscription, modelGuildBoostSlot.premiumGuildSubscription) && this.canceled == modelGuildBoostSlot.canceled;
    }

    public final boolean getCanceled() {
        return this.canceled;
    }

    public final long getCooldownExpiresAtTimestamp() {
        return TimeUtils.parseUTCDate(this.cooldownEndsAt);
    }

    public final long getId() {
        return this.id;
    }

    public final ModelAppliedGuildBoost getPremiumGuildSubscription() {
        return this.premiumGuildSubscription;
    }

    public final long getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.cooldownEndsAt;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.id;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.subscriptionId;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        ModelAppliedGuildBoost modelAppliedGuildBoost = this.premiumGuildSubscription;
        int iHashCode2 = (i2 + (modelAppliedGuildBoost != null ? modelAppliedGuildBoost.hashCode() : 0)) * 31;
        boolean z2 = this.canceled;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        return iHashCode2 + i3;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGuildBoostSlot(cooldownEndsAt=");
        sbU.append(this.cooldownEndsAt);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", premiumGuildSubscription=");
        sbU.append(this.premiumGuildSubscription);
        sbU.append(", canceled=");
        return outline.O(sbU, this.canceled, ")");
    }
}
