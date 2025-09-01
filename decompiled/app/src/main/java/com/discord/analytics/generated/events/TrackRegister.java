package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata2;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplate2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackRegister.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001fR\u001b\u0010'\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001aR\u001b\u0010)\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001fR\u001b\u0010+\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001aR$\u0010.\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00104\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\"\u001a\u0004\b5\u0010$R\u001b\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u001d\u001a\u0004\b<\u0010\u001fR\u001b\u0010=\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0018\u001a\u0004\b>\u0010\u001aR\u001b\u0010?\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\"\u001a\u0004\b@\u0010$R$\u0010B\u001a\u0004\u0018\u00010A8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001b\u0010H\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u001d\u001a\u0004\bI\u0010\u001fR\u001b\u0010J\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\"\u001a\u0004\bK\u0010$R\u001b\u0010L\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0018\u001a\u0004\bM\u0010\u001aR\u001b\u0010N\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010\u001d\u001a\u0004\bO\u0010\u001fR\u001b\u0010P\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010\u001d\u001a\u0004\bQ\u0010\u001fR\u001c\u0010R\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010\u0007R\u001b\u0010U\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u0018\u001a\u0004\bV\u0010\u001aR\u001b\u0010W\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010\u0018\u001a\u0004\bX\u0010\u001a¨\u0006Y"}, d2 = {"Lcom/discord/analytics/generated/events/TrackRegister;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGiftCodeMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildTemplateReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackGuildTemplate;", "trackGuildTemplate", "Lcom/discord/analytics/generated/traits/TrackGuildTemplate;", "getTrackGuildTemplate", "()Lcom/discord/analytics/generated/traits/TrackGuildTemplate;", "setTrackGuildTemplate", "(Lcom/discord/analytics/generated/traits/TrackGuildTemplate;)V", "solvedCaptcha", "Ljava/lang/Boolean;", "getSolvedCaptcha", "()Ljava/lang/Boolean;", "", "phone", "Ljava/lang/CharSequence;", "getPhone", "()Ljava/lang/CharSequence;", "", "inviteInviterId", "Ljava/lang/Long;", "getInviteInviterId", "()Ljava/lang/Long;", "registrationSource", "getRegistrationSource", "instantInvite", "getInstantInvite", "phoneCarrierName", "getPhoneCarrierName", "smiteCaptchaRequested", "getSmiteCaptchaRequested", "Lcom/discord/analytics/generated/traits/TrackGiftCodeMetadata;", "trackGiftCodeMetadata", "Lcom/discord/analytics/generated/traits/TrackGiftCodeMetadata;", "getTrackGiftCodeMetadata", "()Lcom/discord/analytics/generated/traits/TrackGiftCodeMetadata;", "setTrackGiftCodeMetadata", "(Lcom/discord/analytics/generated/traits/TrackGiftCodeMetadata;)V", "inviteChannelType", "getInviteChannelType", "", "captchaScore", "Ljava/lang/Float;", "getCaptchaScore", "()Ljava/lang/Float;", "identityType", "getIdentityType", "requireVerifiedPhoneThenEmail", "getRequireVerifiedPhoneThenEmail", "inviteGuildId", "getInviteGuildId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "inviteCode", "getInviteCode", "inviteChannelId", "getInviteChannelId", "requireVerifiedPhone", "getRequireVerifiedPhone", "phoneCountry", "getPhoneCountry", NotificationCompat.CATEGORY_EMAIL, "getEmail", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "requireVerifiedEmail", "getRequireVerifiedEmail", "full", "getFull", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackRegister implements AnalyticsSchema, TrackBase2, TrackGiftCodeMetadata2, TrackGuildTemplate2 {
    private TrackBase trackBase;
    private TrackGiftCodeMetadata trackGiftCodeMetadata;
    private TrackGuildTemplate trackGuildTemplate;
    private final CharSequence registrationSource = null;
    private final Boolean full = null;
    private final Boolean instantInvite = null;
    private final CharSequence inviteCode = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final Boolean smiteCaptchaRequested = null;
    private final Boolean solvedCaptcha = null;
    private final Float captchaScore = null;
    private final Boolean requireVerifiedPhone = null;
    private final Boolean requireVerifiedEmail = null;
    private final Boolean requireVerifiedPhoneThenEmail = null;
    private final CharSequence email = null;
    private final CharSequence phone = null;
    private final CharSequence identityType = null;
    private final CharSequence phoneCarrierName = null;
    private final CharSequence phoneCountry = null;
    private final transient String analyticsSchemaTypeName = "register";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRegister)) {
            return false;
        }
        TrackRegister trackRegister = (TrackRegister) other;
        return Intrinsics3.areEqual(this.registrationSource, trackRegister.registrationSource) && Intrinsics3.areEqual(this.full, trackRegister.full) && Intrinsics3.areEqual(this.instantInvite, trackRegister.instantInvite) && Intrinsics3.areEqual(this.inviteCode, trackRegister.inviteCode) && Intrinsics3.areEqual(this.inviteGuildId, trackRegister.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackRegister.inviteChannelId) && Intrinsics3.areEqual(this.inviteChannelType, trackRegister.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackRegister.inviteInviterId) && Intrinsics3.areEqual(this.smiteCaptchaRequested, trackRegister.smiteCaptchaRequested) && Intrinsics3.areEqual(this.solvedCaptcha, trackRegister.solvedCaptcha) && Intrinsics3.areEqual(this.captchaScore, trackRegister.captchaScore) && Intrinsics3.areEqual(this.requireVerifiedPhone, trackRegister.requireVerifiedPhone) && Intrinsics3.areEqual(this.requireVerifiedEmail, trackRegister.requireVerifiedEmail) && Intrinsics3.areEqual(this.requireVerifiedPhoneThenEmail, trackRegister.requireVerifiedPhoneThenEmail) && Intrinsics3.areEqual(this.email, trackRegister.email) && Intrinsics3.areEqual(this.phone, trackRegister.phone) && Intrinsics3.areEqual(this.identityType, trackRegister.identityType) && Intrinsics3.areEqual(this.phoneCarrierName, trackRegister.phoneCarrierName) && Intrinsics3.areEqual(this.phoneCountry, trackRegister.phoneCountry);
    }

    public int hashCode() {
        CharSequence charSequence = this.registrationSource;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.full;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.instantInvite;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.inviteGuildId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.inviteChannelId;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool3 = this.smiteCaptchaRequested;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.solvedCaptcha;
        int iHashCode10 = (iHashCode9 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Float f = this.captchaScore;
        int iHashCode11 = (iHashCode10 + (f != null ? f.hashCode() : 0)) * 31;
        Boolean bool5 = this.requireVerifiedPhone;
        int iHashCode12 = (iHashCode11 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.requireVerifiedEmail;
        int iHashCode13 = (iHashCode12 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.requireVerifiedPhoneThenEmail;
        int iHashCode14 = (iHashCode13 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.email;
        int iHashCode15 = (iHashCode14 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.phone;
        int iHashCode16 = (iHashCode15 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.identityType;
        int iHashCode17 = (iHashCode16 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.phoneCarrierName;
        int iHashCode18 = (iHashCode17 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.phoneCountry;
        return iHashCode18 + (charSequence7 != null ? charSequence7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRegister(registrationSource=");
        sbU.append(this.registrationSource);
        sbU.append(", full=");
        sbU.append(this.full);
        sbU.append(", instantInvite=");
        sbU.append(this.instantInvite);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", inviteGuildId=");
        sbU.append(this.inviteGuildId);
        sbU.append(", inviteChannelId=");
        sbU.append(this.inviteChannelId);
        sbU.append(", inviteChannelType=");
        sbU.append(this.inviteChannelType);
        sbU.append(", inviteInviterId=");
        sbU.append(this.inviteInviterId);
        sbU.append(", smiteCaptchaRequested=");
        sbU.append(this.smiteCaptchaRequested);
        sbU.append(", solvedCaptcha=");
        sbU.append(this.solvedCaptcha);
        sbU.append(", captchaScore=");
        sbU.append(this.captchaScore);
        sbU.append(", requireVerifiedPhone=");
        sbU.append(this.requireVerifiedPhone);
        sbU.append(", requireVerifiedEmail=");
        sbU.append(this.requireVerifiedEmail);
        sbU.append(", requireVerifiedPhoneThenEmail=");
        sbU.append(this.requireVerifiedPhoneThenEmail);
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", phone=");
        sbU.append(this.phone);
        sbU.append(", identityType=");
        sbU.append(this.identityType);
        sbU.append(", phoneCarrierName=");
        sbU.append(this.phoneCarrierName);
        sbU.append(", phoneCountry=");
        return outline.E(sbU, this.phoneCountry, ")");
    }
}
