package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "<init>", "()V", "AddBenefitItem", "BenefitItem", "FreeTrialItem", Traits.Location.Section.HEADER, "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$BenefitItem;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$Header;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionBenefitAdapterItem implements DiffKeyProvider {

    /* compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\f\b\u0002\u0010\r\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001d\u0010\r\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "component1", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "", "Lcom/discord/primitives/GuildId;", "component2", "()J", "", "component3", "()Ljava/lang/String;", "type", "guildId", "tierName", "copy", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;JLjava/lang/String;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTierName", "J", "getGuildId", "key", "getKey", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "getType", "<init>", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;JLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AddBenefitItem extends GuildRoleSubscriptionBenefitAdapterItem {
        private final long guildId;
        private final String key;
        private final String tierName;
        private final GuildRoleSubscriptionBenefitType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddBenefitItem(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, long j, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "type");
            this.type = guildRoleSubscriptionBenefitType;
            this.guildId = j;
            this.tierName = str;
            this.key = "AddBenefitItem" + guildRoleSubscriptionBenefitType;
        }

        public static /* synthetic */ AddBenefitItem copy$default(AddBenefitItem addBenefitItem, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionBenefitType = addBenefitItem.type;
            }
            if ((i & 2) != 0) {
                j = addBenefitItem.guildId;
            }
            if ((i & 4) != 0) {
                str = addBenefitItem.tierName;
            }
            return addBenefitItem.copy(guildRoleSubscriptionBenefitType, j, str);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTierName() {
            return this.tierName;
        }

        public final AddBenefitItem copy(GuildRoleSubscriptionBenefitType type, long guildId, String tierName) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new AddBenefitItem(type, guildId, tierName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddBenefitItem)) {
                return false;
            }
            AddBenefitItem addBenefitItem = (AddBenefitItem) other;
            return Intrinsics3.areEqual(this.type, addBenefitItem.type) && this.guildId == addBenefitItem.guildId && Intrinsics3.areEqual(this.tierName, addBenefitItem.tierName);
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getTierName() {
            return this.tierName;
        }

        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        public int hashCode() {
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.type;
            int iA = (b.a(this.guildId) + ((guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType.hashCode() : 0) * 31)) * 31;
            String str = this.tierName;
            return iA + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AddBenefitItem(type=");
            sbU.append(this.type);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", tierName=");
            return outline.J(sbU, this.tierName, ")");
        }
    }

    /* compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\n\u0010\u0011\u001a\u00060\bj\u0002`\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\f\b\u0002\u0010\u0011\u001a\u00060\bj\u0002`\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\"\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\u000eR\u001d\u0010\u0011\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\u0004¨\u0006*"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$BenefitItem;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "component1", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "component2", "()Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "", "Lcom/discord/primitives/GuildId;", "component3", "()J", "", "component4", "()Ljava/lang/String;", "type", "benefit", "guildId", "tierName", "copy", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;JLjava/lang/String;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$BenefitItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTierName", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "getBenefit", "key", "getKey", "J", "getGuildId", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "getType", "<init>", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;JLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class BenefitItem extends GuildRoleSubscriptionBenefitAdapterItem {
        private final Benefit benefit;
        private final long guildId;
        private final String key;
        private final String tierName;
        private final GuildRoleSubscriptionBenefitType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BenefitItem(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, Benefit benefit, long j, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "type");
            Intrinsics3.checkNotNullParameter(benefit, "benefit");
            this.type = guildRoleSubscriptionBenefitType;
            this.benefit = benefit;
            this.guildId = j;
            this.tierName = str;
            this.key = String.valueOf(benefit.hashCode());
        }

        public static /* synthetic */ BenefitItem copy$default(BenefitItem benefitItem, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, Benefit benefit, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionBenefitType = benefitItem.type;
            }
            if ((i & 2) != 0) {
                benefit = benefitItem.benefit;
            }
            Benefit benefit2 = benefit;
            if ((i & 4) != 0) {
                j = benefitItem.guildId;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                str = benefitItem.tierName;
            }
            return benefitItem.copy(guildRoleSubscriptionBenefitType, benefit2, j2, str);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final Benefit getBenefit() {
            return this.benefit;
        }

        /* renamed from: component3, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTierName() {
            return this.tierName;
        }

        public final BenefitItem copy(GuildRoleSubscriptionBenefitType type, Benefit benefit, long guildId, String tierName) {
            Intrinsics3.checkNotNullParameter(type, "type");
            Intrinsics3.checkNotNullParameter(benefit, "benefit");
            return new BenefitItem(type, benefit, guildId, tierName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BenefitItem)) {
                return false;
            }
            BenefitItem benefitItem = (BenefitItem) other;
            return Intrinsics3.areEqual(this.type, benefitItem.type) && Intrinsics3.areEqual(this.benefit, benefitItem.benefit) && this.guildId == benefitItem.guildId && Intrinsics3.areEqual(this.tierName, benefitItem.tierName);
        }

        public final Benefit getBenefit() {
            return this.benefit;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getTierName() {
            return this.tierName;
        }

        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        public int hashCode() {
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.type;
            int iHashCode = (guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType.hashCode() : 0) * 31;
            Benefit benefit = this.benefit;
            int iA = (b.a(this.guildId) + ((iHashCode + (benefit != null ? benefit.hashCode() : 0)) * 31)) * 31;
            String str = this.tierName;
            return iA + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("BenefitItem(type=");
            sbU.append(this.type);
            sbU.append(", benefit=");
            sbU.append(this.benefit);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", tierName=");
            return outline.J(sbU, this.tierName, ")");
        }
    }

    /* compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u001e\u001a\u00020\u00108\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0012¨\u0006#"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "", "component1", "()Z", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "component2", "()Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "", "component3", "()Ljava/lang/Integer;", "isFreeTrialEnabled", "trialInterval", "activeTrialUserLimit", "copy", "(ZLcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;Ljava/lang/Integer;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getActiveTrialUserLimit", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "getTrialInterval", "Z", "key", "Ljava/lang/String;", "getKey", "<init>", "(ZLcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class FreeTrialItem extends GuildRoleSubscriptionBenefitAdapterItem {
        private final Integer activeTrialUserLimit;
        private final boolean isFreeTrialEnabled;
        private final String key;
        private final SubscriptionTrialInterval trialInterval;

        public FreeTrialItem(boolean z2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num) {
            super(null);
            this.isFreeTrialEnabled = z2;
            this.trialInterval = subscriptionTrialInterval;
            this.activeTrialUserLimit = num;
            this.key = "FreeTrialItem";
        }

        public static /* synthetic */ FreeTrialItem copy$default(FreeTrialItem freeTrialItem, boolean z2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = freeTrialItem.isFreeTrialEnabled;
            }
            if ((i & 2) != 0) {
                subscriptionTrialInterval = freeTrialItem.trialInterval;
            }
            if ((i & 4) != 0) {
                num = freeTrialItem.activeTrialUserLimit;
            }
            return freeTrialItem.copy(z2, subscriptionTrialInterval, num);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsFreeTrialEnabled() {
            return this.isFreeTrialEnabled;
        }

        /* renamed from: component2, reason: from getter */
        public final SubscriptionTrialInterval getTrialInterval() {
            return this.trialInterval;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getActiveTrialUserLimit() {
            return this.activeTrialUserLimit;
        }

        public final FreeTrialItem copy(boolean isFreeTrialEnabled, SubscriptionTrialInterval trialInterval, Integer activeTrialUserLimit) {
            return new FreeTrialItem(isFreeTrialEnabled, trialInterval, activeTrialUserLimit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FreeTrialItem)) {
                return false;
            }
            FreeTrialItem freeTrialItem = (FreeTrialItem) other;
            return this.isFreeTrialEnabled == freeTrialItem.isFreeTrialEnabled && Intrinsics3.areEqual(this.trialInterval, freeTrialItem.trialInterval) && Intrinsics3.areEqual(this.activeTrialUserLimit, freeTrialItem.activeTrialUserLimit);
        }

        public final Integer getActiveTrialUserLimit() {
            return this.activeTrialUserLimit;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final SubscriptionTrialInterval getTrialInterval() {
            return this.trialInterval;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isFreeTrialEnabled;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            SubscriptionTrialInterval subscriptionTrialInterval = this.trialInterval;
            int iHashCode = (i + (subscriptionTrialInterval != null ? subscriptionTrialInterval.hashCode() : 0)) * 31;
            Integer num = this.activeTrialUserLimit;
            return iHashCode + (num != null ? num.hashCode() : 0);
        }

        public final boolean isFreeTrialEnabled() {
            return this.isFreeTrialEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("FreeTrialItem(isFreeTrialEnabled=");
            sbU.append(this.isFreeTrialEnabled);
            sbU.append(", trialInterval=");
            sbU.append(this.trialInterval);
            sbU.append(", activeTrialUserLimit=");
            return outline.F(sbU, this.activeTrialUserLimit, ")");
        }
    }

    /* compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$Header;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "component1", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "type", "copy", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$Header;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "getType", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Header extends GuildRoleSubscriptionBenefitAdapterItem {
        private final String key;
        private final GuildRoleSubscriptionBenefitType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Header(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType) {
            super(null);
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "type");
            this.type = guildRoleSubscriptionBenefitType;
            this.key = "BenefitHeader" + guildRoleSubscriptionBenefitType;
        }

        public static /* synthetic */ Header copy$default(Header header, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionBenefitType = header.type;
            }
            return header.copy(guildRoleSubscriptionBenefitType);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        public final Header copy(GuildRoleSubscriptionBenefitType type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new Header(type);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Header) && Intrinsics3.areEqual(this.type, ((Header) other).type);
            }
            return true;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        public int hashCode() {
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.type;
            if (guildRoleSubscriptionBenefitType != null) {
                return guildRoleSubscriptionBenefitType.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Header(type=");
            sbU.append(this.type);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private GuildRoleSubscriptionBenefitAdapterItem() {
    }

    public /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
