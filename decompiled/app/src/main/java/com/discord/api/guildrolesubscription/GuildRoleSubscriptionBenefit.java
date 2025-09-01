package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionBenefit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefit;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "refId", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "Ljava/lang/String;", "a", "emojiId", "b", "emojiName", "c", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "refType", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "f", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", ModelAuditLogEntry.CHANGE_KEY_NAME, "d", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;Ljava/lang/String;Ljava/lang/Long;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionBenefit {
    private final String description;
    private final Long emojiId;
    private final String emojiName;
    private final String name;
    private final Long refId;
    private final GuildRoleSubscriptionBenefitType refType;

    public GuildRoleSubscriptionBenefit(Long l, String str, String str2, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str3, Long l2) {
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "refType");
        this.emojiId = l;
        this.emojiName = str;
        this.name = str2;
        this.refType = guildRoleSubscriptionBenefitType;
        this.description = str3;
        this.refId = l2;
    }

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: b, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: c, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final Long getRefId() {
        return this.refId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionBenefit)) {
            return false;
        }
        GuildRoleSubscriptionBenefit guildRoleSubscriptionBenefit = (GuildRoleSubscriptionBenefit) other;
        return Intrinsics3.areEqual(this.emojiId, guildRoleSubscriptionBenefit.emojiId) && Intrinsics3.areEqual(this.emojiName, guildRoleSubscriptionBenefit.emojiName) && Intrinsics3.areEqual(this.name, guildRoleSubscriptionBenefit.name) && Intrinsics3.areEqual(this.refType, guildRoleSubscriptionBenefit.refType) && Intrinsics3.areEqual(this.description, guildRoleSubscriptionBenefit.description) && Intrinsics3.areEqual(this.refId, guildRoleSubscriptionBenefit.refId);
    }

    /* renamed from: f, reason: from getter */
    public final GuildRoleSubscriptionBenefitType getRefType() {
        return this.refType;
    }

    public int hashCode() {
        Long l = this.emojiId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.emojiName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.refType;
        int iHashCode4 = (iHashCode3 + (guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType.hashCode() : 0)) * 31;
        String str3 = this.description;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l2 = this.refId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleSubscriptionBenefit(emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", emojiName=");
        sbU.append(this.emojiName);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", refType=");
        sbU.append(this.refType);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", refId=");
        return outline.G(sbU, this.refId, ")");
    }
}
