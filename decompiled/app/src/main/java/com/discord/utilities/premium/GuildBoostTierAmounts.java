package com.discord.utilities.premium;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: GuildBoostTierAmounts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/utilities/premium/GuildBoostTierAmounts;", "", "", "component1", "()I", "component2", "component3", "tier1Boosts", "tier2Boosts", "tier3Boosts", "copy", "(III)Lcom/discord/utilities/premium/GuildBoostTierAmounts;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTier1Boosts", "getTier2Boosts", "getTier3Boosts", "<init>", "(III)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildBoostTierAmounts {
    private final int tier1Boosts;
    private final int tier2Boosts;
    private final int tier3Boosts;

    public GuildBoostTierAmounts(int i, int i2, int i3) {
        this.tier1Boosts = i;
        this.tier2Boosts = i2;
        this.tier3Boosts = i3;
    }

    public static /* synthetic */ GuildBoostTierAmounts copy$default(GuildBoostTierAmounts guildBoostTierAmounts, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = guildBoostTierAmounts.tier1Boosts;
        }
        if ((i4 & 2) != 0) {
            i2 = guildBoostTierAmounts.tier2Boosts;
        }
        if ((i4 & 4) != 0) {
            i3 = guildBoostTierAmounts.tier3Boosts;
        }
        return guildBoostTierAmounts.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTier1Boosts() {
        return this.tier1Boosts;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTier2Boosts() {
        return this.tier2Boosts;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTier3Boosts() {
        return this.tier3Boosts;
    }

    public final GuildBoostTierAmounts copy(int tier1Boosts, int tier2Boosts, int tier3Boosts) {
        return new GuildBoostTierAmounts(tier1Boosts, tier2Boosts, tier3Boosts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostTierAmounts)) {
            return false;
        }
        GuildBoostTierAmounts guildBoostTierAmounts = (GuildBoostTierAmounts) other;
        return this.tier1Boosts == guildBoostTierAmounts.tier1Boosts && this.tier2Boosts == guildBoostTierAmounts.tier2Boosts && this.tier3Boosts == guildBoostTierAmounts.tier3Boosts;
    }

    public final int getTier1Boosts() {
        return this.tier1Boosts;
    }

    public final int getTier2Boosts() {
        return this.tier2Boosts;
    }

    public final int getTier3Boosts() {
        return this.tier3Boosts;
    }

    public int hashCode() {
        return (((this.tier1Boosts * 31) + this.tier2Boosts) * 31) + this.tier3Boosts;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildBoostTierAmounts(tier1Boosts=");
        sbU.append(this.tier1Boosts);
        sbU.append(", tier2Boosts=");
        sbU.append(this.tier2Boosts);
        sbU.append(", tier3Boosts=");
        return outline.B(sbU, this.tier3Boosts, ")");
    }
}
