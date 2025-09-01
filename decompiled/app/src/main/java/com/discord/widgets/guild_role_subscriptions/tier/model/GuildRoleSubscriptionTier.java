package com.discord.widgets.guild_role_subscriptions.tier.model;

import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildRoleSubscriptionTier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010&\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bP\u0010QJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\nJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\nJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000eJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\nJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001bHÆ\u0003¢\u0006\u0004\b \u0010\u001eJ\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b$\u0010\u0011JÒ\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010&\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010!2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b6\u0010\nJ\u0010\u00107\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b7\u00108J\u001a\u0010:\u001a\u00020\u00022\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b:\u0010;R\u001b\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010<\u001a\u0004\b=\u0010\u0011R\u001b\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010<\u001a\u0004\b>\u0010\u0011R\u001b\u0010)\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010?\u001a\u0004\b@\u0010\nR\u001b\u0010%\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010?\u001a\u0004\bA\u0010\nR\u001b\u0010*\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010B\u001a\u0004\bC\u0010\u0016R\u001b\u00102\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010D\u001a\u0004\bE\u0010#R\u001b\u00103\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010<\u001a\u0004\bF\u0010\u0011R\u001b\u0010+\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010?\u001a\u0004\bG\u0010\nR\u001b\u0010-\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010?\u001a\u0004\bH\u0010\nR!\u0010&\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010I\u001a\u0004\bJ\u0010\u000eR\u001b\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010K\u001a\u0004\b.\u0010\u0004R\u001f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010L\u001a\u0004\bM\u0010\u001eR\u0018\u0010/\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010KR\u001f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010L\u001a\u0004\bN\u0010\u001eR\u001b\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010I\u001a\u0004\bO\u0010\u000e¨\u0006R"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "", "", "component11", "()Ljava/lang/Boolean;", "isFullServerGating", "canAccessAllChannelsOrDefault", "(Ljava/lang/Boolean;)Z", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/ApplicationId;", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/lang/Integer;", "component4", "component5", "Lcom/discord/api/role/GuildRole;", "component6", "()Lcom/discord/api/role/GuildRole;", "component7", "component8", "component9", "component10", "", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$ChannelBenefit;", "component12", "()Ljava/util/List;", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$IntangibleBenefit;", "component13", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "component14", "()Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "component15", ModelAuditLogEntry.CHANGE_KEY_NAME, "applicationId", "priceTier", "memberColor", "memberIcon", "guildRole", "image", "imageAssetId", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "isPublished", "canAccessAllChannels", "channelBenefits", "intangibleBenefits", "trialInterval", "activeTrialUserLimit", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/discord/api/role/GuildRole;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;Ljava/lang/Integer;)Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getMemberColor", "getPriceTier", "Ljava/lang/String;", "getMemberIcon", "getName", "Lcom/discord/api/role/GuildRole;", "getGuildRole", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "getTrialInterval", "getActiveTrialUserLimit", "getImage", "getDescription", "Ljava/lang/Long;", "getApplicationId", "Ljava/lang/Boolean;", "Ljava/util/List;", "getChannelBenefits", "getIntangibleBenefits", "getImageAssetId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/discord/api/role/GuildRole;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTier {
    private final Integer activeTrialUserLimit;
    private final Long applicationId;
    private final Boolean canAccessAllChannels;
    private final List<Benefit.ChannelBenefit> channelBenefits;
    private final String description;
    private final GuildRole guildRole;
    private final String image;
    private final Long imageAssetId;
    private final List<Benefit.IntangibleBenefit> intangibleBenefits;
    private final Boolean isPublished;
    private final Integer memberColor;
    private final String memberIcon;
    private final String name;
    private final Integer priceTier;
    private final SubscriptionTrialInterval trialInterval;

    public GuildRoleSubscriptionTier() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public GuildRoleSubscriptionTier(String str, Long l, Integer num, Integer num2, String str2, GuildRole guildRole, String str3, Long l2, String str4, Boolean bool, Boolean bool2, List<Benefit.ChannelBenefit> list, List<Benefit.IntangibleBenefit> list2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num3) {
        Intrinsics3.checkNotNullParameter(list, "channelBenefits");
        Intrinsics3.checkNotNullParameter(list2, "intangibleBenefits");
        this.name = str;
        this.applicationId = l;
        this.priceTier = num;
        this.memberColor = num2;
        this.memberIcon = str2;
        this.guildRole = guildRole;
        this.image = str3;
        this.imageAssetId = l2;
        this.description = str4;
        this.isPublished = bool;
        this.canAccessAllChannels = bool2;
        this.channelBenefits = list;
        this.intangibleBenefits = list2;
        this.trialInterval = subscriptionTrialInterval;
        this.activeTrialUserLimit = num3;
    }

    /* renamed from: component11, reason: from getter */
    private final Boolean getCanAccessAllChannels() {
        return this.canAccessAllChannels;
    }

    public static /* synthetic */ GuildRoleSubscriptionTier copy$default(GuildRoleSubscriptionTier guildRoleSubscriptionTier, String str, Long l, Integer num, Integer num2, String str2, GuildRole guildRole, String str3, Long l2, String str4, Boolean bool, Boolean bool2, List list, List list2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num3, int i, Object obj) {
        return guildRoleSubscriptionTier.copy((i & 1) != 0 ? guildRoleSubscriptionTier.name : str, (i & 2) != 0 ? guildRoleSubscriptionTier.applicationId : l, (i & 4) != 0 ? guildRoleSubscriptionTier.priceTier : num, (i & 8) != 0 ? guildRoleSubscriptionTier.memberColor : num2, (i & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : str2, (i & 32) != 0 ? guildRoleSubscriptionTier.guildRole : guildRole, (i & 64) != 0 ? guildRoleSubscriptionTier.image : str3, (i & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : l2, (i & 256) != 0 ? guildRoleSubscriptionTier.description : str4, (i & 512) != 0 ? guildRoleSubscriptionTier.isPublished : bool, (i & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : bool2, (i & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : list, (i & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : list2, (i & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : subscriptionTrialInterval, (i & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : num3);
    }

    public final boolean canAccessAllChannelsOrDefault(Boolean isFullServerGating) {
        Boolean bool = Boolean.TRUE;
        return Intrinsics3.areEqual(isFullServerGating, bool) && (Intrinsics3.areEqual(this.canAccessAllChannels, bool) || this.canAccessAllChannels == null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getIsPublished() {
        return this.isPublished;
    }

    public final List<Benefit.ChannelBenefit> component12() {
        return this.channelBenefits;
    }

    public final List<Benefit.IntangibleBenefit> component13() {
        return this.intangibleBenefits;
    }

    /* renamed from: component14, reason: from getter */
    public final SubscriptionTrialInterval getTrialInterval() {
        return this.trialInterval;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getActiveTrialUserLimit() {
        return this.activeTrialUserLimit;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getPriceTier() {
        return this.priceTier;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getMemberColor() {
        return this.memberColor;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMemberIcon() {
        return this.memberIcon;
    }

    /* renamed from: component6, reason: from getter */
    public final GuildRole getGuildRole() {
        return this.guildRole;
    }

    /* renamed from: component7, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getImageAssetId() {
        return this.imageAssetId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final GuildRoleSubscriptionTier copy(String name, Long applicationId, Integer priceTier, Integer memberColor, String memberIcon, GuildRole guildRole, String image, Long imageAssetId, String description, Boolean isPublished, Boolean canAccessAllChannels, List<Benefit.ChannelBenefit> channelBenefits, List<Benefit.IntangibleBenefit> intangibleBenefits, SubscriptionTrialInterval trialInterval, Integer activeTrialUserLimit) {
        Intrinsics3.checkNotNullParameter(channelBenefits, "channelBenefits");
        Intrinsics3.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        return new GuildRoleSubscriptionTier(name, applicationId, priceTier, memberColor, memberIcon, guildRole, image, imageAssetId, description, isPublished, canAccessAllChannels, channelBenefits, intangibleBenefits, trialInterval, activeTrialUserLimit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTier)) {
            return false;
        }
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = (GuildRoleSubscriptionTier) other;
        return Intrinsics3.areEqual(this.name, guildRoleSubscriptionTier.name) && Intrinsics3.areEqual(this.applicationId, guildRoleSubscriptionTier.applicationId) && Intrinsics3.areEqual(this.priceTier, guildRoleSubscriptionTier.priceTier) && Intrinsics3.areEqual(this.memberColor, guildRoleSubscriptionTier.memberColor) && Intrinsics3.areEqual(this.memberIcon, guildRoleSubscriptionTier.memberIcon) && Intrinsics3.areEqual(this.guildRole, guildRoleSubscriptionTier.guildRole) && Intrinsics3.areEqual(this.image, guildRoleSubscriptionTier.image) && Intrinsics3.areEqual(this.imageAssetId, guildRoleSubscriptionTier.imageAssetId) && Intrinsics3.areEqual(this.description, guildRoleSubscriptionTier.description) && Intrinsics3.areEqual(this.isPublished, guildRoleSubscriptionTier.isPublished) && Intrinsics3.areEqual(this.canAccessAllChannels, guildRoleSubscriptionTier.canAccessAllChannels) && Intrinsics3.areEqual(this.channelBenefits, guildRoleSubscriptionTier.channelBenefits) && Intrinsics3.areEqual(this.intangibleBenefits, guildRoleSubscriptionTier.intangibleBenefits) && Intrinsics3.areEqual(this.trialInterval, guildRoleSubscriptionTier.trialInterval) && Intrinsics3.areEqual(this.activeTrialUserLimit, guildRoleSubscriptionTier.activeTrialUserLimit);
    }

    public final Integer getActiveTrialUserLimit() {
        return this.activeTrialUserLimit;
    }

    public final Long getApplicationId() {
        return this.applicationId;
    }

    public final List<Benefit.ChannelBenefit> getChannelBenefits() {
        return this.channelBenefits;
    }

    public final String getDescription() {
        return this.description;
    }

    public final GuildRole getGuildRole() {
        return this.guildRole;
    }

    public final String getImage() {
        return this.image;
    }

    public final Long getImageAssetId() {
        return this.imageAssetId;
    }

    public final List<Benefit.IntangibleBenefit> getIntangibleBenefits() {
        return this.intangibleBenefits;
    }

    public final Integer getMemberColor() {
        return this.memberColor;
    }

    public final String getMemberIcon() {
        return this.memberIcon;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getPriceTier() {
        return this.priceTier;
    }

    public final SubscriptionTrialInterval getTrialInterval() {
        return this.trialInterval;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.applicationId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.priceTier;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.memberColor;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.memberIcon;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildRole guildRole = this.guildRole;
        int iHashCode6 = (iHashCode5 + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        String str3 = this.image;
        int iHashCode7 = (iHashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l2 = this.imageAssetId;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str4 = this.description;
        int iHashCode9 = (iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.isPublished;
        int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.canAccessAllChannels;
        int iHashCode11 = (iHashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        List<Benefit.ChannelBenefit> list = this.channelBenefits;
        int iHashCode12 = (iHashCode11 + (list != null ? list.hashCode() : 0)) * 31;
        List<Benefit.IntangibleBenefit> list2 = this.intangibleBenefits;
        int iHashCode13 = (iHashCode12 + (list2 != null ? list2.hashCode() : 0)) * 31;
        SubscriptionTrialInterval subscriptionTrialInterval = this.trialInterval;
        int iHashCode14 = (iHashCode13 + (subscriptionTrialInterval != null ? subscriptionTrialInterval.hashCode() : 0)) * 31;
        Integer num3 = this.activeTrialUserLimit;
        return iHashCode14 + (num3 != null ? num3.hashCode() : 0);
    }

    public final Boolean isPublished() {
        return this.isPublished;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleSubscriptionTier(name=");
        sbU.append(this.name);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", priceTier=");
        sbU.append(this.priceTier);
        sbU.append(", memberColor=");
        sbU.append(this.memberColor);
        sbU.append(", memberIcon=");
        sbU.append(this.memberIcon);
        sbU.append(", guildRole=");
        sbU.append(this.guildRole);
        sbU.append(", image=");
        sbU.append(this.image);
        sbU.append(", imageAssetId=");
        sbU.append(this.imageAssetId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", isPublished=");
        sbU.append(this.isPublished);
        sbU.append(", canAccessAllChannels=");
        sbU.append(this.canAccessAllChannels);
        sbU.append(", channelBenefits=");
        sbU.append(this.channelBenefits);
        sbU.append(", intangibleBenefits=");
        sbU.append(this.intangibleBenefits);
        sbU.append(", trialInterval=");
        sbU.append(this.trialInterval);
        sbU.append(", activeTrialUserLimit=");
        return outline.F(sbU, this.activeTrialUserLimit, ")");
    }

    public /* synthetic */ GuildRoleSubscriptionTier(String str, Long l, Integer num, Integer num2, String str2, GuildRole guildRole, String str3, Long l2, String str4, Boolean bool, Boolean bool2, List list, List list2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : guildRole, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : l2, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : bool2, (i & 2048) != 0 ? Collections2.emptyList() : list, (i & 4096) != 0 ? Collections2.emptyList() : list2, (i & 8192) != 0 ? null : subscriptionTrialInterval, (i & 16384) == 0 ? num3 : null);
    }
}
