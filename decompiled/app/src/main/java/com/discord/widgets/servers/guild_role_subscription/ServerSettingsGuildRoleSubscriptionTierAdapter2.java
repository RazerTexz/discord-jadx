package com.discord.widgets.servers.guild_role_subscription;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "<init>", "()V", "AddTier", "Tier", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class ServerSettingsGuildRoleSubscriptionTierAdapter2 implements DiffKeyProvider {

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier */
    public static final class AddTier extends ServerSettingsGuildRoleSubscriptionTierAdapter2 {
        public static final AddTier INSTANCE = new AddTier();
        private static final String key = "AddTierItem";

        private AddTier() {
            super(null);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u000b\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JR\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\f\b\u0002\u0010\u0015\u001a\u00060\u0002j\u0002`\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\nJ\u001a\u0010\u001e\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0015\u001a\u00060\u0002j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010$\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\nR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b+\u0010\u0007¨\u0006."}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem;", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "Lcom/discord/primitives/ApplicationId;", "component4", "", "component5", "()Z", "component6", "()Ljava/lang/Long;", "tierListingId", "tierName", "tierPrice", "applicationId", "isPublished", "tierImageAssetId", "copy", "(JLjava/lang/String;IJZLjava/lang/Long;)Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getApplicationId", "getTierListingId", "Z", "key", "Ljava/lang/String;", "getKey", "I", "getTierPrice", "Ljava/lang/Long;", "getTierImageAssetId", "getTierName", "<init>", "(JLjava/lang/String;IJZLjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier */
    public static final /* data */ class Tier extends ServerSettingsGuildRoleSubscriptionTierAdapter2 {
        private final long applicationId;
        private final boolean isPublished;
        private final String key;
        private final Long tierImageAssetId;
        private final long tierListingId;
        private final String tierName;
        private final int tierPrice;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tier(long j, String str, int i, long j2, boolean z2, Long l) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "tierName");
            this.tierListingId = j;
            this.tierName = str;
            this.tierPrice = i;
            this.applicationId = j2;
            this.isPublished = z2;
            this.tierImageAssetId = l;
            this.key = String.valueOf(j);
        }

        public static /* synthetic */ Tier copy$default(Tier tier, long j, String str, int i, long j2, boolean z2, Long l, int i2, Object obj) {
            return tier.copy((i2 & 1) != 0 ? tier.tierListingId : j, (i2 & 2) != 0 ? tier.tierName : str, (i2 & 4) != 0 ? tier.tierPrice : i, (i2 & 8) != 0 ? tier.applicationId : j2, (i2 & 16) != 0 ? tier.isPublished : z2, (i2 & 32) != 0 ? tier.tierImageAssetId : l);
        }

        /* renamed from: component1, reason: from getter */
        public final long getTierListingId() {
            return this.tierListingId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTierName() {
            return this.tierName;
        }

        /* renamed from: component3, reason: from getter */
        public final int getTierPrice() {
            return this.tierPrice;
        }

        /* renamed from: component4, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsPublished() {
            return this.isPublished;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getTierImageAssetId() {
            return this.tierImageAssetId;
        }

        public final Tier copy(long tierListingId, String tierName, int tierPrice, long applicationId, boolean isPublished, Long tierImageAssetId) {
            Intrinsics3.checkNotNullParameter(tierName, "tierName");
            return new Tier(tierListingId, tierName, tierPrice, applicationId, isPublished, tierImageAssetId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tier)) {
                return false;
            }
            Tier tier = (Tier) other;
            return this.tierListingId == tier.tierListingId && Intrinsics3.areEqual(this.tierName, tier.tierName) && this.tierPrice == tier.tierPrice && this.applicationId == tier.applicationId && this.isPublished == tier.isPublished && Intrinsics3.areEqual(this.tierImageAssetId, tier.tierImageAssetId);
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Long getTierImageAssetId() {
            return this.tierImageAssetId;
        }

        public final long getTierListingId() {
            return this.tierListingId;
        }

        public final String getTierName() {
            return this.tierName;
        }

        public final int getTierPrice() {
            return this.tierPrice;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.tierListingId) * 31;
            String str = this.tierName;
            int iA2 = (b.a(this.applicationId) + ((((iA + (str != null ? str.hashCode() : 0)) * 31) + this.tierPrice) * 31)) * 31;
            boolean z2 = this.isPublished;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iA2 + i) * 31;
            Long l = this.tierImageAssetId;
            return i2 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isPublished() {
            return this.isPublished;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Tier(tierListingId=");
            sbU.append(this.tierListingId);
            sbU.append(", tierName=");
            sbU.append(this.tierName);
            sbU.append(", tierPrice=");
            sbU.append(this.tierPrice);
            sbU.append(", applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", isPublished=");
            sbU.append(this.isPublished);
            sbU.append(", tierImageAssetId=");
            return outline.G(sbU, this.tierImageAssetId, ")");
        }
    }

    private ServerSettingsGuildRoleSubscriptionTierAdapter2() {
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
