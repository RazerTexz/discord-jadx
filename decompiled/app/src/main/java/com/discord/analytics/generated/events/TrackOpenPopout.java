package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackOpenPopout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u001b\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001b\u0010#\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019R\u001b\u0010%\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019R\u001b\u0010'\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\u001b\u0010)\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019R\u001b\u0010+\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019R\u001b\u0010-\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0017\u001a\u0004\b.\u0010\u0019R\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b0\u0010\u0014R\u001b\u00101\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u001eR\u001b\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b4\u0010\u0014R\u001b\u00105\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u001c\u001a\u0004\b6\u0010\u001eR$\u00108\u001a\u0004\u0018\u0001078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u001c\u001a\u0004\b?\u0010\u001eR$\u0010A\u001a\u0004\u0018\u00010@8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001b\u0010G\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0012\u001a\u0004\bH\u0010\u0014R\u001b\u0010I\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\u0012\u001a\u0004\bI\u0010\u0014R\u001b\u0010J\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\u001c\u001a\u0004\bK\u0010\u001eR\u001b\u0010L\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0012\u001a\u0004\bM\u0010\u0014R$\u0010O\u001a\u0004\u0018\u00010N8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001b\u0010U\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u0012\u001a\u0004\bV\u0010\u0014R\u001c\u0010W\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010\bR\u001b\u0010Z\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010\u0012\u001a\u0004\bZ\u0010\u0014R$\u0010\\\u001a\u0004\u0018\u00010[8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001b\u0010b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010\u001c\u001a\u0004\bc\u0010\u001eR\u001b\u0010d\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010\u001c\u001a\u0004\be\u0010\u001eR\u001b\u0010f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010\u001c\u001a\u0004\bg\u0010\u001eR\u001b\u0010h\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bh\u0010\u0017\u001a\u0004\bi\u0010\u0019¨\u0006j"}, d2 = {"Lcom/discord/analytics/generated/events/TrackOpenPopout;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hasGuildMemberBio", "Ljava/lang/Boolean;", "getHasGuildMemberBio", "()Ljava/lang/Boolean;", "", "gamePlatform", "Ljava/lang/CharSequence;", "getGamePlatform", "()Ljava/lang/CharSequence;", "", "stickerPackId", "Ljava/lang/Long;", "getStickerPackId", "()Ljava/lang/Long;", "hasGuildMemberBanner", "getHasGuildMemberBanner", "skuId", "getSkuId", "applicationName", "getApplicationName", "type", "getType", "partyId", "getPartyId", "gameName", "getGameName", "source", "getSource", "partyPlatform", "getPartyPlatform", "hasCustomStatus", "getHasCustomStatus", "emojiId", "getEmojiId", "profileHasNitroCustomization", "getProfileHasNitroCustomization", "partyMax", "getPartyMax", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "applicationId", "getApplicationId", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "trackOverlayClientMetadata", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "getTrackOverlayClientMetadata", "()Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "setTrackOverlayClientMetadata", "(Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;)V", "hasGuildMemberAvatar", "getHasGuildMemberAvatar", "isStreaming", "guildId", "getGuildId", "hasNickname", "getHasNickname", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "hasImages", "getHasImages", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "isFriend", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "otherUserId", "getOtherUserId", "gameId", "getGameId", "stickerId", "getStickerId", "profileUserStatus", "getProfileUserStatus", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackOpenPopout implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackLocationMetadata2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final CharSequence source = null;
    private final CharSequence type = null;
    private final Long otherUserId = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final Long gameId = null;
    private final Boolean isFriend = null;
    private final Boolean hasImages = null;
    private final Long partyMax = null;
    private final CharSequence partyId = null;
    private final CharSequence partyPlatform = null;
    private final CharSequence gameName = null;
    private final CharSequence gamePlatform = null;
    private final Long skuId = null;
    private final CharSequence profileUserStatus = null;
    private final Boolean isStreaming = null;
    private final Boolean hasCustomStatus = null;
    private final Long guildId = null;
    private final Long emojiId = null;
    private final Long stickerId = null;
    private final Long stickerPackId = null;
    private final Boolean profileHasNitroCustomization = null;
    private final Boolean hasNickname = null;
    private final Boolean hasGuildMemberAvatar = null;
    private final Boolean hasGuildMemberBanner = null;
    private final Boolean hasGuildMemberBio = null;
    private final transient String analyticsSchemaTypeName = "open_popout";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOpenPopout)) {
            return false;
        }
        TrackOpenPopout trackOpenPopout = (TrackOpenPopout) other;
        return Intrinsics3.areEqual(this.source, trackOpenPopout.source) && Intrinsics3.areEqual(this.type, trackOpenPopout.type) && Intrinsics3.areEqual(this.otherUserId, trackOpenPopout.otherUserId) && Intrinsics3.areEqual(this.applicationId, trackOpenPopout.applicationId) && Intrinsics3.areEqual(this.applicationName, trackOpenPopout.applicationName) && Intrinsics3.areEqual(this.gameId, trackOpenPopout.gameId) && Intrinsics3.areEqual(this.isFriend, trackOpenPopout.isFriend) && Intrinsics3.areEqual(this.hasImages, trackOpenPopout.hasImages) && Intrinsics3.areEqual(this.partyMax, trackOpenPopout.partyMax) && Intrinsics3.areEqual(this.partyId, trackOpenPopout.partyId) && Intrinsics3.areEqual(this.partyPlatform, trackOpenPopout.partyPlatform) && Intrinsics3.areEqual(this.gameName, trackOpenPopout.gameName) && Intrinsics3.areEqual(this.gamePlatform, trackOpenPopout.gamePlatform) && Intrinsics3.areEqual(this.skuId, trackOpenPopout.skuId) && Intrinsics3.areEqual(this.profileUserStatus, trackOpenPopout.profileUserStatus) && Intrinsics3.areEqual(this.isStreaming, trackOpenPopout.isStreaming) && Intrinsics3.areEqual(this.hasCustomStatus, trackOpenPopout.hasCustomStatus) && Intrinsics3.areEqual(this.guildId, trackOpenPopout.guildId) && Intrinsics3.areEqual(this.emojiId, trackOpenPopout.emojiId) && Intrinsics3.areEqual(this.stickerId, trackOpenPopout.stickerId) && Intrinsics3.areEqual(this.stickerPackId, trackOpenPopout.stickerPackId) && Intrinsics3.areEqual(this.profileHasNitroCustomization, trackOpenPopout.profileHasNitroCustomization) && Intrinsics3.areEqual(this.hasNickname, trackOpenPopout.hasNickname) && Intrinsics3.areEqual(this.hasGuildMemberAvatar, trackOpenPopout.hasGuildMemberAvatar) && Intrinsics3.areEqual(this.hasGuildMemberBanner, trackOpenPopout.hasGuildMemberBanner) && Intrinsics3.areEqual(this.hasGuildMemberBio, trackOpenPopout.hasGuildMemberBio);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.type;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.otherUserId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.applicationId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.applicationName;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l3 = this.gameId;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.isFriend;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasImages;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l4 = this.partyMax;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.partyId;
        int iHashCode10 = (iHashCode9 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.partyPlatform;
        int iHashCode11 = (iHashCode10 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.gameName;
        int iHashCode12 = (iHashCode11 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.gamePlatform;
        int iHashCode13 = (iHashCode12 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l5 = this.skuId;
        int iHashCode14 = (iHashCode13 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.profileUserStatus;
        int iHashCode15 = (iHashCode14 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Boolean bool3 = this.isStreaming;
        int iHashCode16 = (iHashCode15 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.hasCustomStatus;
        int iHashCode17 = (iHashCode16 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l6 = this.guildId;
        int iHashCode18 = (iHashCode17 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.emojiId;
        int iHashCode19 = (iHashCode18 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.stickerId;
        int iHashCode20 = (iHashCode19 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.stickerPackId;
        int iHashCode21 = (iHashCode20 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Boolean bool5 = this.profileHasNitroCustomization;
        int iHashCode22 = (iHashCode21 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.hasNickname;
        int iHashCode23 = (iHashCode22 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.hasGuildMemberAvatar;
        int iHashCode24 = (iHashCode23 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.hasGuildMemberBanner;
        int iHashCode25 = (iHashCode24 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.hasGuildMemberBio;
        return iHashCode25 + (bool9 != null ? bool9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOpenPopout(source=");
        sbU.append(this.source);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", otherUserId=");
        sbU.append(this.otherUserId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", isFriend=");
        sbU.append(this.isFriend);
        sbU.append(", hasImages=");
        sbU.append(this.hasImages);
        sbU.append(", partyMax=");
        sbU.append(this.partyMax);
        sbU.append(", partyId=");
        sbU.append(this.partyId);
        sbU.append(", partyPlatform=");
        sbU.append(this.partyPlatform);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", profileUserStatus=");
        sbU.append(this.profileUserStatus);
        sbU.append(", isStreaming=");
        sbU.append(this.isStreaming);
        sbU.append(", hasCustomStatus=");
        sbU.append(this.hasCustomStatus);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", stickerPackId=");
        sbU.append(this.stickerPackId);
        sbU.append(", profileHasNitroCustomization=");
        sbU.append(this.profileHasNitroCustomization);
        sbU.append(", hasNickname=");
        sbU.append(this.hasNickname);
        sbU.append(", hasGuildMemberAvatar=");
        sbU.append(this.hasGuildMemberAvatar);
        sbU.append(", hasGuildMemberBanner=");
        sbU.append(this.hasGuildMemberBanner);
        sbU.append(", hasGuildMemberBio=");
        return outline.D(sbU, this.hasGuildMemberBio, ")");
    }
}
