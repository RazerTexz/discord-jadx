package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackGuildMemberUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001b\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001eR\u001b\u0010'\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001eR\u001b\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017R$\u00101\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u00107\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0015\u001a\u0004\b8\u0010\u0017R!\u0010:\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`98\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b;\u0010\u0017R\u001b\u0010<\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u001c\u001a\u0004\b=\u0010\u001eR\u001b\u0010>\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0015\u001a\u0004\b?\u0010\u0017R\u001b\u0010@\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0015\u001a\u0004\bA\u0010\u0017R\u001b\u0010B\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0015\u001a\u0004\bC\u0010\u0017R\u001b\u0010D\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u001c\u001a\u0004\bE\u0010\u001eR\u001b\u0010F\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u001c\u001a\u0004\bG\u0010\u001eR\u001b\u0010H\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u0015\u001a\u0004\bI\u0010\u0017R\u001b\u0010J\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\"\u001a\u0004\bK\u0010$R\u001b\u0010L\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u001c\u001a\u0004\bM\u0010\u001eR\u001b\u0010N\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010\u001c\u001a\u0004\bO\u0010\u001eR!\u0010P\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010\u0011\u001a\u0004\bQ\u0010\u0013R!\u0010R\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010\u0011\u001a\u0004\bS\u0010\u0013R\u001c\u0010T\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010\u0005¨\u0006W"}, d2 = {"Lcom/discord/analytics/generated/events/TrackGuildMemberUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "oldRoles", "Ljava/util/List;", "getOldRoles", "()Ljava/util/List;", "accessibleTextChannels", "Ljava/lang/Long;", "getAccessibleTextChannels", "()Ljava/lang/Long;", "userPremiumTier", "getUserPremiumTier", "", "bioUpdateType", "Ljava/lang/CharSequence;", "getBioUpdateType", "()Ljava/lang/CharSequence;", "avatarUpdateType", "getAvatarUpdateType", ModelAuditLogEntry.CHANGE_KEY_MUTE, "Ljava/lang/Boolean;", "getMute", "()Ljava/lang/Boolean;", "updateType", "getUpdateType", "newNickname", "getNewNickname", "", "duration", "Ljava/lang/Float;", "getDuration", "()Ljava/lang/Float;", "bioCustomEmojiCount", "getBioCustomEmojiCount", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "guildId", "getGuildId", "Lcom/discord/primitives/Timestamp;", "communicationDisabledUntil", "getCommunicationDisabledUntil", "oldNickname", "getOldNickname", "deleteMessageDays", "getDeleteMessageDays", "accessibleVoiceChannels", "getAccessibleVoiceChannels", "targetUserId", "getTargetUserId", "bannerUpdateType", "getBannerUpdateType", "guildName", "getGuildName", "accessibleStageChannels", "getAccessibleStageChannels", ModelAuditLogEntry.CHANGE_KEY_DEAF, "getDeaf", ModelAuditLogEntry.CHANGE_KEY_REASON, "getReason", "nicknameUpdateType", "getNicknameUpdateType", "fieldsUpdated", "getFieldsUpdated", "newRoles", "getNewRoles", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGuildMemberUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final Long targetUserId = null;
    private final CharSequence updateType = null;
    private final List<CharSequence> fieldsUpdated = null;
    private final CharSequence oldNickname = null;
    private final CharSequence newNickname = null;
    private final Boolean mute = null;
    private final Boolean deaf = null;
    private final List<Long> oldRoles = null;
    private final List<Long> newRoles = null;
    private final CharSequence reason = null;
    private final Long deleteMessageDays = null;
    private final CharSequence avatarUpdateType = null;
    private final Long userPremiumTier = null;
    private final CharSequence nicknameUpdateType = null;
    private final CharSequence bannerUpdateType = null;
    private final CharSequence bioUpdateType = null;
    private final Float duration = null;
    private final Long communicationDisabledUntil = null;
    private final Long bioCustomEmojiCount = null;
    private final Long accessibleTextChannels = null;
    private final Long accessibleVoiceChannels = null;
    private final Long accessibleStageChannels = null;
    private final transient String analyticsSchemaTypeName = "guild_member_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildMemberUpdated)) {
            return false;
        }
        TrackGuildMemberUpdated trackGuildMemberUpdated = (TrackGuildMemberUpdated) other;
        return Intrinsics3.areEqual(this.guildId, trackGuildMemberUpdated.guildId) && Intrinsics3.areEqual(this.guildName, trackGuildMemberUpdated.guildName) && Intrinsics3.areEqual(this.targetUserId, trackGuildMemberUpdated.targetUserId) && Intrinsics3.areEqual(this.updateType, trackGuildMemberUpdated.updateType) && Intrinsics3.areEqual(this.fieldsUpdated, trackGuildMemberUpdated.fieldsUpdated) && Intrinsics3.areEqual(this.oldNickname, trackGuildMemberUpdated.oldNickname) && Intrinsics3.areEqual(this.newNickname, trackGuildMemberUpdated.newNickname) && Intrinsics3.areEqual(this.mute, trackGuildMemberUpdated.mute) && Intrinsics3.areEqual(this.deaf, trackGuildMemberUpdated.deaf) && Intrinsics3.areEqual(this.oldRoles, trackGuildMemberUpdated.oldRoles) && Intrinsics3.areEqual(this.newRoles, trackGuildMemberUpdated.newRoles) && Intrinsics3.areEqual(this.reason, trackGuildMemberUpdated.reason) && Intrinsics3.areEqual(this.deleteMessageDays, trackGuildMemberUpdated.deleteMessageDays) && Intrinsics3.areEqual(this.avatarUpdateType, trackGuildMemberUpdated.avatarUpdateType) && Intrinsics3.areEqual(this.userPremiumTier, trackGuildMemberUpdated.userPremiumTier) && Intrinsics3.areEqual(this.nicknameUpdateType, trackGuildMemberUpdated.nicknameUpdateType) && Intrinsics3.areEqual(this.bannerUpdateType, trackGuildMemberUpdated.bannerUpdateType) && Intrinsics3.areEqual(this.bioUpdateType, trackGuildMemberUpdated.bioUpdateType) && Intrinsics3.areEqual(this.duration, trackGuildMemberUpdated.duration) && Intrinsics3.areEqual(this.communicationDisabledUntil, trackGuildMemberUpdated.communicationDisabledUntil) && Intrinsics3.areEqual(this.bioCustomEmojiCount, trackGuildMemberUpdated.bioCustomEmojiCount) && Intrinsics3.areEqual(this.accessibleTextChannels, trackGuildMemberUpdated.accessibleTextChannels) && Intrinsics3.areEqual(this.accessibleVoiceChannels, trackGuildMemberUpdated.accessibleVoiceChannels) && Intrinsics3.areEqual(this.accessibleStageChannels, trackGuildMemberUpdated.accessibleStageChannels);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.targetUserId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.updateType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        List<CharSequence> list = this.fieldsUpdated;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.oldNickname;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.newNickname;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.mute;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.deaf;
        int iHashCode9 = (iHashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        List<Long> list2 = this.oldRoles;
        int iHashCode10 = (iHashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.newRoles;
        int iHashCode11 = (iHashCode10 + (list3 != null ? list3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.reason;
        int iHashCode12 = (iHashCode11 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l3 = this.deleteMessageDays;
        int iHashCode13 = (iHashCode12 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.avatarUpdateType;
        int iHashCode14 = (iHashCode13 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l4 = this.userPremiumTier;
        int iHashCode15 = (iHashCode14 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.nicknameUpdateType;
        int iHashCode16 = (iHashCode15 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.bannerUpdateType;
        int iHashCode17 = (iHashCode16 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.bioUpdateType;
        int iHashCode18 = (iHashCode17 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        Float f = this.duration;
        int iHashCode19 = (iHashCode18 + (f != null ? f.hashCode() : 0)) * 31;
        Long l5 = this.communicationDisabledUntil;
        int iHashCode20 = (iHashCode19 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.bioCustomEmojiCount;
        int iHashCode21 = (iHashCode20 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.accessibleTextChannels;
        int iHashCode22 = (iHashCode21 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.accessibleVoiceChannels;
        int iHashCode23 = (iHashCode22 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.accessibleStageChannels;
        return iHashCode23 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildMemberUpdated(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", targetUserId=");
        sbU.append(this.targetUserId);
        sbU.append(", updateType=");
        sbU.append(this.updateType);
        sbU.append(", fieldsUpdated=");
        sbU.append(this.fieldsUpdated);
        sbU.append(", oldNickname=");
        sbU.append(this.oldNickname);
        sbU.append(", newNickname=");
        sbU.append(this.newNickname);
        sbU.append(", mute=");
        sbU.append(this.mute);
        sbU.append(", deaf=");
        sbU.append(this.deaf);
        sbU.append(", oldRoles=");
        sbU.append(this.oldRoles);
        sbU.append(", newRoles=");
        sbU.append(this.newRoles);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", deleteMessageDays=");
        sbU.append(this.deleteMessageDays);
        sbU.append(", avatarUpdateType=");
        sbU.append(this.avatarUpdateType);
        sbU.append(", userPremiumTier=");
        sbU.append(this.userPremiumTier);
        sbU.append(", nicknameUpdateType=");
        sbU.append(this.nicknameUpdateType);
        sbU.append(", bannerUpdateType=");
        sbU.append(this.bannerUpdateType);
        sbU.append(", bioUpdateType=");
        sbU.append(this.bioUpdateType);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", communicationDisabledUntil=");
        sbU.append(this.communicationDisabledUntil);
        sbU.append(", bioCustomEmojiCount=");
        sbU.append(this.bioCustomEmojiCount);
        sbU.append(", accessibleTextChannels=");
        sbU.append(this.accessibleTextChannels);
        sbU.append(", accessibleVoiceChannels=");
        sbU.append(this.accessibleVoiceChannels);
        sbU.append(", accessibleStageChannels=");
        return outline.G(sbU, this.accessibleStageChannels, ")");
    }
}
