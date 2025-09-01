package com.discord.api.role;

import b.d.b.a.outline;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: GuildRoleTags.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u0013\u0010\u0012\u001a\u00020\n8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0004R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0004R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/discord/api/role/GuildRoleTags;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "integrationId", "Ljava/lang/String;", "getIntegrationId", "b", "()Z", "isPurchasableOrHasSubscribers", "subscriptionListingId", "a", "Lcom/discord/nullserializable/NullSerializable;", "premiumSubscriber", "Lcom/discord/nullserializable/NullSerializable;", "skuId", "getSkuId", "botId", "getBotId", "purchasableOrHasSubscribers", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildRoleTags implements Serializable {
    private final String botId;
    private final String integrationId;
    private final NullSerializable<Object> premiumSubscriber;
    private final NullSerializable<Object> purchasableOrHasSubscribers;
    private final String skuId;
    private final String subscriptionListingId;

    /* renamed from: a, reason: from getter */
    public final String getSubscriptionListingId() {
        return this.subscriptionListingId;
    }

    public final boolean b() {
        return this.purchasableOrHasSubscribers != null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleTags)) {
            return false;
        }
        GuildRoleTags guildRoleTags = (GuildRoleTags) other;
        return Intrinsics3.areEqual(this.premiumSubscriber, guildRoleTags.premiumSubscriber) && Intrinsics3.areEqual(this.botId, guildRoleTags.botId) && Intrinsics3.areEqual(this.integrationId, guildRoleTags.integrationId) && Intrinsics3.areEqual(this.skuId, guildRoleTags.skuId) && Intrinsics3.areEqual(this.subscriptionListingId, guildRoleTags.subscriptionListingId) && Intrinsics3.areEqual(this.purchasableOrHasSubscribers, guildRoleTags.purchasableOrHasSubscribers);
    }

    public int hashCode() {
        NullSerializable<Object> nullSerializable = this.premiumSubscriber;
        int iHashCode = (nullSerializable != null ? nullSerializable.hashCode() : 0) * 31;
        String str = this.botId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.integrationId;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.skuId;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.subscriptionListingId;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        NullSerializable<Object> nullSerializable2 = this.purchasableOrHasSubscribers;
        return iHashCode5 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleTags(premiumSubscriber=");
        sbU.append(this.premiumSubscriber);
        sbU.append(", botId=");
        sbU.append(this.botId);
        sbU.append(", integrationId=");
        sbU.append(this.integrationId);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", subscriptionListingId=");
        sbU.append(this.subscriptionListingId);
        sbU.append(", purchasableOrHasSubscribers=");
        sbU.append(this.purchasableOrHasSubscribers);
        sbU.append(")");
        return sbU.toString();
    }
}
