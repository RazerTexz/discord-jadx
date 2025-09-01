package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackUserAccountUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001b\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011R\u001c\u0010#\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0005R$\u0010'\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u0010-\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u0018R\u001b\u0010/\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u000f\u001a\u0004\b0\u0010\u0011R\u001b\u00101\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u000f\u001a\u0004\b2\u0010\u0011R\u001b\u00103\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u000f\u001a\u0004\b3\u0010\u0011R\u001b\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u00109\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u000f\u001a\u0004\b:\u0010\u0011R\u001b\u0010;\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u000f\u001a\u0004\b<\u0010\u0011R\u001b\u0010=\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u000f\u001a\u0004\b>\u0010\u0011R\u001b\u0010?\u001a\u0004\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u00108R\u001b\u0010A\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u000f\u001a\u0004\bB\u0010\u0011R\u001b\u0010C\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u0016\u001a\u0004\bD\u0010\u0018R\u001b\u0010E\u001a\u0004\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\bE\u00106\u001a\u0004\bF\u00108R\u001b\u0010G\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u000f\u001a\u0004\bH\u0010\u0011¨\u0006I"}, d2 = {"Lcom/discord/analytics/generated/events/TrackUserAccountUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hasBannerColor", "Ljava/lang/Boolean;", "getHasBannerColor", "()Ljava/lang/Boolean;", "hasAnimatedAvatar", "getHasAnimatedAvatar", "", "oldEmail", "Ljava/lang/CharSequence;", "getOldEmail", "()Ljava/lang/CharSequence;", "hasBio", "getHasBio", "hasAvatar", "getHasAvatar", "updatedBanner", "getUpdatedBanner", "newEmail", "getNewEmail", "updatedBannerColor", "getUpdatedBannerColor", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "newUsername", "getNewUsername", "updatedBio", "getUpdatedBio", "hasBanner", "getHasBanner", "isUserSetDiscriminator", "", "newDiscriminator", "Ljava/lang/Long;", "getNewDiscriminator", "()Ljava/lang/Long;", "updatedAvatar", "getUpdatedAvatar", "hasPronouns", "getHasPronouns", "updatedPronouns", "getUpdatedPronouns", "oldDiscriminator", "getOldDiscriminator", "updatedPassword", "getUpdatedPassword", "oldUsername", "getOldUsername", "bioCustomEmojiCount", "getBioCustomEmojiCount", "hasPremium", "getHasPremium", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackUserAccountUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean isUserSetDiscriminator = null;
    private final Long oldDiscriminator = null;
    private final Long newDiscriminator = null;
    private final CharSequence oldUsername = null;
    private final CharSequence newUsername = null;
    private final CharSequence oldEmail = null;
    private final CharSequence newEmail = null;
    private final Boolean hasBanner = null;
    private final Boolean hasBannerColor = null;
    private final Boolean hasBio = null;
    private final Boolean hasPremium = null;
    private final Boolean hasAvatar = null;
    private final Boolean hasAnimatedAvatar = null;
    private final Boolean updatedBio = null;
    private final Boolean updatedBanner = null;
    private final Boolean updatedBannerColor = null;
    private final Boolean updatedAvatar = null;
    private final Long bioCustomEmojiCount = null;
    private final Boolean hasPronouns = null;
    private final Boolean updatedPronouns = null;
    private final Boolean updatedPassword = null;
    private final transient String analyticsSchemaTypeName = "user_account_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserAccountUpdated)) {
            return false;
        }
        TrackUserAccountUpdated trackUserAccountUpdated = (TrackUserAccountUpdated) other;
        return Intrinsics3.areEqual(this.isUserSetDiscriminator, trackUserAccountUpdated.isUserSetDiscriminator) && Intrinsics3.areEqual(this.oldDiscriminator, trackUserAccountUpdated.oldDiscriminator) && Intrinsics3.areEqual(this.newDiscriminator, trackUserAccountUpdated.newDiscriminator) && Intrinsics3.areEqual(this.oldUsername, trackUserAccountUpdated.oldUsername) && Intrinsics3.areEqual(this.newUsername, trackUserAccountUpdated.newUsername) && Intrinsics3.areEqual(this.oldEmail, trackUserAccountUpdated.oldEmail) && Intrinsics3.areEqual(this.newEmail, trackUserAccountUpdated.newEmail) && Intrinsics3.areEqual(this.hasBanner, trackUserAccountUpdated.hasBanner) && Intrinsics3.areEqual(this.hasBannerColor, trackUserAccountUpdated.hasBannerColor) && Intrinsics3.areEqual(this.hasBio, trackUserAccountUpdated.hasBio) && Intrinsics3.areEqual(this.hasPremium, trackUserAccountUpdated.hasPremium) && Intrinsics3.areEqual(this.hasAvatar, trackUserAccountUpdated.hasAvatar) && Intrinsics3.areEqual(this.hasAnimatedAvatar, trackUserAccountUpdated.hasAnimatedAvatar) && Intrinsics3.areEqual(this.updatedBio, trackUserAccountUpdated.updatedBio) && Intrinsics3.areEqual(this.updatedBanner, trackUserAccountUpdated.updatedBanner) && Intrinsics3.areEqual(this.updatedBannerColor, trackUserAccountUpdated.updatedBannerColor) && Intrinsics3.areEqual(this.updatedAvatar, trackUserAccountUpdated.updatedAvatar) && Intrinsics3.areEqual(this.bioCustomEmojiCount, trackUserAccountUpdated.bioCustomEmojiCount) && Intrinsics3.areEqual(this.hasPronouns, trackUserAccountUpdated.hasPronouns) && Intrinsics3.areEqual(this.updatedPronouns, trackUserAccountUpdated.updatedPronouns) && Intrinsics3.areEqual(this.updatedPassword, trackUserAccountUpdated.updatedPassword);
    }

    public int hashCode() {
        Boolean bool = this.isUserSetDiscriminator;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.oldDiscriminator;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.newDiscriminator;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.oldUsername;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.newUsername;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.oldEmail;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.newEmail;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasBanner;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasBannerColor;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.hasBio;
        int iHashCode10 = (iHashCode9 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.hasPremium;
        int iHashCode11 = (iHashCode10 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.hasAvatar;
        int iHashCode12 = (iHashCode11 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.hasAnimatedAvatar;
        int iHashCode13 = (iHashCode12 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.updatedBio;
        int iHashCode14 = (iHashCode13 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.updatedBanner;
        int iHashCode15 = (iHashCode14 + (bool9 != null ? bool9.hashCode() : 0)) * 31;
        Boolean bool10 = this.updatedBannerColor;
        int iHashCode16 = (iHashCode15 + (bool10 != null ? bool10.hashCode() : 0)) * 31;
        Boolean bool11 = this.updatedAvatar;
        int iHashCode17 = (iHashCode16 + (bool11 != null ? bool11.hashCode() : 0)) * 31;
        Long l3 = this.bioCustomEmojiCount;
        int iHashCode18 = (iHashCode17 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool12 = this.hasPronouns;
        int iHashCode19 = (iHashCode18 + (bool12 != null ? bool12.hashCode() : 0)) * 31;
        Boolean bool13 = this.updatedPronouns;
        int iHashCode20 = (iHashCode19 + (bool13 != null ? bool13.hashCode() : 0)) * 31;
        Boolean bool14 = this.updatedPassword;
        return iHashCode20 + (bool14 != null ? bool14.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserAccountUpdated(isUserSetDiscriminator=");
        sbU.append(this.isUserSetDiscriminator);
        sbU.append(", oldDiscriminator=");
        sbU.append(this.oldDiscriminator);
        sbU.append(", newDiscriminator=");
        sbU.append(this.newDiscriminator);
        sbU.append(", oldUsername=");
        sbU.append(this.oldUsername);
        sbU.append(", newUsername=");
        sbU.append(this.newUsername);
        sbU.append(", oldEmail=");
        sbU.append(this.oldEmail);
        sbU.append(", newEmail=");
        sbU.append(this.newEmail);
        sbU.append(", hasBanner=");
        sbU.append(this.hasBanner);
        sbU.append(", hasBannerColor=");
        sbU.append(this.hasBannerColor);
        sbU.append(", hasBio=");
        sbU.append(this.hasBio);
        sbU.append(", hasPremium=");
        sbU.append(this.hasPremium);
        sbU.append(", hasAvatar=");
        sbU.append(this.hasAvatar);
        sbU.append(", hasAnimatedAvatar=");
        sbU.append(this.hasAnimatedAvatar);
        sbU.append(", updatedBio=");
        sbU.append(this.updatedBio);
        sbU.append(", updatedBanner=");
        sbU.append(this.updatedBanner);
        sbU.append(", updatedBannerColor=");
        sbU.append(this.updatedBannerColor);
        sbU.append(", updatedAvatar=");
        sbU.append(this.updatedAvatar);
        sbU.append(", bioCustomEmojiCount=");
        sbU.append(this.bioCustomEmojiCount);
        sbU.append(", hasPronouns=");
        sbU.append(this.hasPronouns);
        sbU.append(", updatedPronouns=");
        sbU.append(this.updatedPronouns);
        sbU.append(", updatedPassword=");
        return outline.D(sbU, this.updatedPassword, ")");
    }
}
