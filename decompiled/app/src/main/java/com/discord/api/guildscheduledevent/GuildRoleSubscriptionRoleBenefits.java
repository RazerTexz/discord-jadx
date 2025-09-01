package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionRoleBenefits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildRoleSubscriptionRoleBenefits;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/SkuId;", "skuId", "J", "getSkuId", "()J", "", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "benefits", "Ljava/util/List;", "a", "()Ljava/util/List;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionRoleBenefits {
    private final List<GuildRoleSubscriptionBenefit> benefits;
    private final long skuId;

    public final List<GuildRoleSubscriptionBenefit> a() {
        return this.benefits;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionRoleBenefits)) {
            return false;
        }
        GuildRoleSubscriptionRoleBenefits guildRoleSubscriptionRoleBenefits = (GuildRoleSubscriptionRoleBenefits) other;
        return this.skuId == guildRoleSubscriptionRoleBenefits.skuId && Intrinsics3.areEqual(this.benefits, guildRoleSubscriptionRoleBenefits.benefits);
    }

    public int hashCode() {
        long j = this.skuId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<GuildRoleSubscriptionBenefit> list = this.benefits;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleSubscriptionRoleBenefits(skuId=");
        sbU.append(this.skuId);
        sbU.append(", benefits=");
        return outline.L(sbU, this.benefits, ")");
    }
}
