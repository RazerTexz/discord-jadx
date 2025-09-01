package com.discord.widgets.guild_role_subscriptions.tier;

import androidx.annotation.ColorInt;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "<init>", "()V", "AllChannelsAccessBenefitItem", "BenefitItem", Traits.Location.Section.HEADER, "MemberPreview", "PlanDetails", "SectionHeader", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$Header;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$MemberPreview;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$SectionHeader;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$BenefitItem;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$AllChannelsAccessBenefitItem;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$PlanDetails;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionTierAdapterItem implements DiffKeyProvider {

    /* compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$AllChannelsAccessBenefitItem;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AllChannelsAccessBenefitItem extends GuildRoleSubscriptionTierAdapterItem {
        public static final AllChannelsAccessBenefitItem INSTANCE = new AllChannelsAccessBenefitItem();
        private static final String key = "allChannelsAccessBenefitItem";

        private AllChannelsAccessBenefitItem() {
            super(null);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }
    }

    /* compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$BenefitItem;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem;", "", "component1", "()I", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "component2", "()Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "index", "benefit", "copy", "(ILcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;)Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$BenefitItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "getBenefit", "key", "Ljava/lang/String;", "getKey", "<init>", "(ILcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class BenefitItem extends GuildRoleSubscriptionTierAdapterItem {
        private final Benefit benefit;
        private final int index;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BenefitItem(int i, Benefit benefit) {
            super(null);
            Intrinsics3.checkNotNullParameter(benefit, "benefit");
            this.index = i;
            this.benefit = benefit;
            this.key = String.valueOf(i);
        }

        public static /* synthetic */ BenefitItem copy$default(BenefitItem benefitItem, int i, Benefit benefit, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = benefitItem.index;
            }
            if ((i2 & 2) != 0) {
                benefit = benefitItem.benefit;
            }
            return benefitItem.copy(i, benefit);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: component2, reason: from getter */
        public final Benefit getBenefit() {
            return this.benefit;
        }

        public final BenefitItem copy(int index, Benefit benefit) {
            Intrinsics3.checkNotNullParameter(benefit, "benefit");
            return new BenefitItem(index, benefit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BenefitItem)) {
                return false;
            }
            BenefitItem benefitItem = (BenefitItem) other;
            return this.index == benefitItem.index && Intrinsics3.areEqual(this.benefit, benefitItem.benefit);
        }

        public final Benefit getBenefit() {
            return this.benefit;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public int hashCode() {
            int i = this.index * 31;
            Benefit benefit = this.benefit;
            return i + (benefit != null ? benefit.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("BenefitItem(index=");
            sbU.append(this.index);
            sbU.append(", benefit=");
            sbU.append(this.benefit);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JL\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$Header;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/lang/Long;", "component4", "component5", ModelAuditLogEntry.CHANGE_KEY_NAME, "price", "skuId", "image", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$Header;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "getName", "getImage", "getDescription", "Ljava/lang/Integer;", "getPrice", "Ljava/lang/Long;", "getSkuId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Header extends GuildRoleSubscriptionTierAdapterItem {
        private final String description;
        private final String image;
        private final String key;
        private final String name;
        private final Integer price;
        private final Long skuId;

        public /* synthetic */ Header(String str, Integer num, Long l, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, num, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
        }

        public static /* synthetic */ Header copy$default(Header header, String str, Integer num, Long l, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = header.name;
            }
            if ((i & 2) != 0) {
                num = header.price;
            }
            Integer num2 = num;
            if ((i & 4) != 0) {
                l = header.skuId;
            }
            Long l2 = l;
            if ((i & 8) != 0) {
                str2 = header.image;
            }
            String str4 = str2;
            if ((i & 16) != 0) {
                str3 = header.description;
            }
            return header.copy(str, num2, l2, str4, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getPrice() {
            return this.price;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getSkuId() {
            return this.skuId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* renamed from: component5, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final Header copy(String name, Integer price, Long skuId, String image, String description) {
            return new Header(name, price, skuId, image, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Header)) {
                return false;
            }
            Header header = (Header) other;
            return Intrinsics3.areEqual(this.name, header.name) && Intrinsics3.areEqual(this.price, header.price) && Intrinsics3.areEqual(this.skuId, header.skuId) && Intrinsics3.areEqual(this.image, header.image) && Intrinsics3.areEqual(this.description, header.description);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getImage() {
            return this.image;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getPrice() {
            return this.price;
        }

        public final Long getSkuId() {
            return this.skuId;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.price;
            int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
            Long l = this.skuId;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            String str2 = this.image;
            int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Header(name=");
            sbU.append(this.name);
            sbU.append(", price=");
            sbU.append(this.price);
            sbU.append(", skuId=");
            sbU.append(this.skuId);
            sbU.append(", image=");
            sbU.append(this.image);
            sbU.append(", description=");
            return outline.J(sbU, this.description, ")");
        }

        public Header(String str, Integer num, Long l, String str2, String str3) {
            super(null);
            this.name = str;
            this.price = num;
            this.skuId = l;
            this.image = str2;
            this.description = str3;
            this.key = outline.w("header:", str);
        }
    }

    /* compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$MemberPreview;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem;", "", "component1", "()Ljava/lang/Integer;", "", "component2", "()Ljava/lang/String;", "memberColor", "memberIcon", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$MemberPreview;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Ljava/lang/Integer;", "getMemberColor", "getMemberIcon", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MemberPreview extends GuildRoleSubscriptionTierAdapterItem {
        private final String key;
        private final Integer memberColor;
        private final String memberIcon;

        public /* synthetic */ MemberPreview(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(num, (i & 2) != 0 ? null : str);
        }

        public static /* synthetic */ MemberPreview copy$default(MemberPreview memberPreview, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = memberPreview.memberColor;
            }
            if ((i & 2) != 0) {
                str = memberPreview.memberIcon;
            }
            return memberPreview.copy(num, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getMemberColor() {
            return this.memberColor;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMemberIcon() {
            return this.memberIcon;
        }

        public final MemberPreview copy(@ColorInt Integer memberColor, String memberIcon) {
            return new MemberPreview(memberColor, memberIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberPreview)) {
                return false;
            }
            MemberPreview memberPreview = (MemberPreview) other;
            return Intrinsics3.areEqual(this.memberColor, memberPreview.memberColor) && Intrinsics3.areEqual(this.memberIcon, memberPreview.memberIcon);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Integer getMemberColor() {
            return this.memberColor;
        }

        public final String getMemberIcon() {
            return this.memberIcon;
        }

        public int hashCode() {
            Integer num = this.memberColor;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            String str = this.memberIcon;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MemberPreview(memberColor=");
            sbU.append(this.memberColor);
            sbU.append(", memberIcon=");
            return outline.J(sbU, this.memberIcon, ")");
        }

        public MemberPreview(@ColorInt Integer num, String str) {
            super(null);
            this.memberColor = num;
            this.memberIcon = str;
            this.key = "member:" + num;
        }
    }

    /* compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$PlanDetails;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem;", "", "component1", "()Ljava/lang/String;", "component2", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "coverImage", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$PlanDetails;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "getDescription", "getCoverImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class PlanDetails extends GuildRoleSubscriptionTierAdapterItem {
        private final String coverImage;
        private final String description;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlanDetails(String str, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            Intrinsics3.checkNotNullParameter(str2, "coverImage");
            this.description = str;
            this.coverImage = str2;
            this.key = "planDetails";
        }

        public static /* synthetic */ PlanDetails copy$default(PlanDetails planDetails, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = planDetails.description;
            }
            if ((i & 2) != 0) {
                str2 = planDetails.coverImage;
            }
            return planDetails.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        public final PlanDetails copy(String description, String coverImage) {
            Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            Intrinsics3.checkNotNullParameter(coverImage, "coverImage");
            return new PlanDetails(description, coverImage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlanDetails)) {
                return false;
            }
            PlanDetails planDetails = (PlanDetails) other;
            return Intrinsics3.areEqual(this.description, planDetails.description) && Intrinsics3.areEqual(this.coverImage, planDetails.coverImage);
        }

        public final String getCoverImage() {
            return this.coverImage;
        }

        public final String getDescription() {
            return this.description;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public int hashCode() {
            String str = this.description;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.coverImage;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("PlanDetails(description=");
            sbU.append(this.description);
            sbU.append(", coverImage=");
            return outline.J(sbU, this.coverImage, ")");
        }
    }

    /* compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$SectionHeader;", "Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem;", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "titleResId", "titlePluralResId", "formatArgument", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/discord/widgets/guild_role_subscriptions/tier/GuildRoleSubscriptionTierAdapterItem$SectionHeader;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getFormatArgument", "key", "Ljava/lang/String;", "getKey", "getTitlePluralResId", "getTitleResId", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SectionHeader extends GuildRoleSubscriptionTierAdapterItem {
        private final Integer formatArgument;
        private final String key;
        private final Integer titlePluralResId;
        private final Integer titleResId;

        public SectionHeader(@StringRes Integer num, @PluralsRes Integer num2, Integer num3) {
            super(null);
            this.titleResId = num;
            this.titlePluralResId = num2;
            this.formatArgument = num3;
            StringBuilder sb = new StringBuilder();
            sb.append(num2);
            sb.append(num);
            this.key = sb.toString();
        }

        public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, Integer num, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = sectionHeader.titleResId;
            }
            if ((i & 2) != 0) {
                num2 = sectionHeader.titlePluralResId;
            }
            if ((i & 4) != 0) {
                num3 = sectionHeader.formatArgument;
            }
            return sectionHeader.copy(num, num2, num3);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getTitleResId() {
            return this.titleResId;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getTitlePluralResId() {
            return this.titlePluralResId;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getFormatArgument() {
            return this.formatArgument;
        }

        public final SectionHeader copy(@StringRes Integer titleResId, @PluralsRes Integer titlePluralResId, Integer formatArgument) {
            return new SectionHeader(titleResId, titlePluralResId, formatArgument);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionHeader)) {
                return false;
            }
            SectionHeader sectionHeader = (SectionHeader) other;
            return Intrinsics3.areEqual(this.titleResId, sectionHeader.titleResId) && Intrinsics3.areEqual(this.titlePluralResId, sectionHeader.titlePluralResId) && Intrinsics3.areEqual(this.formatArgument, sectionHeader.formatArgument);
        }

        public final Integer getFormatArgument() {
            return this.formatArgument;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Integer getTitlePluralResId() {
            return this.titlePluralResId;
        }

        public final Integer getTitleResId() {
            return this.titleResId;
        }

        public int hashCode() {
            Integer num = this.titleResId;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            Integer num2 = this.titlePluralResId;
            int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.formatArgument;
            return iHashCode2 + (num3 != null ? num3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SectionHeader(titleResId=");
            sbU.append(this.titleResId);
            sbU.append(", titlePluralResId=");
            sbU.append(this.titlePluralResId);
            sbU.append(", formatArgument=");
            return outline.F(sbU, this.formatArgument, ")");
        }
    }

    private GuildRoleSubscriptionTierAdapterItem() {
    }

    public /* synthetic */ GuildRoleSubscriptionTierAdapterItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
