package com.discord.api.user;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: User.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0004R!\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001b\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010-\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00101\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u001d\u001a\u0004\b2\u0010\u001fR\u001b\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u00104\u001a\u0004\b8\u00106R\u001b\u00109\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0004R\u0019\u0010;\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u000e\u001a\u0004\b<\u0010\u0004R\u001b\u0010=\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b=\u00104\u001a\u0004\b>\u00106R\u001b\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR!\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u0019\u001a\u0004\bE\u0010\u001bR!\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u0019\u001a\u0004\bG\u0010\u001bR\u001b\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u000e\u001a\u0004\bI\u0010\u0004R\u001b\u0010J\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\u000e\u001a\u0004\bK\u0010\u0004R!\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0019\u001a\u0004\bM\u0010\u001bR\u001b\u0010N\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010\u001d\u001a\u0004\bO\u0010\u001f¨\u0006P"}, d2 = {"Lcom/discord/api/user/User;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "username", "Ljava/lang/String;", "getUsername", "Lcom/discord/api/premium/PremiumTier;", "premiumType", "Lcom/discord/api/premium/PremiumTier;", "m", "()Lcom/discord/api/premium/PremiumTier;", NotificationCompat.CATEGORY_EMAIL, "g", "Lcom/discord/nullserializable/NullSerializable;", "banner", "Lcom/discord/nullserializable/NullSerializable;", "b", "()Lcom/discord/nullserializable/NullSerializable;", "bot", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "system", "o", "Lcom/discord/api/user/Phone;", "phone", "Lcom/discord/api/user/Phone;", "l", "()Lcom/discord/api/user/Phone;", "Lcom/discord/api/user/NsfwAllowance;", "nsfwAllowed", "Lcom/discord/api/user/NsfwAllowance;", "k", "()Lcom/discord/api/user/NsfwAllowance;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "verified", "q", "publicFlags", "Ljava/lang/Integer;", "n", "()Ljava/lang/Integer;", "approximateGuildCount", "getApproximateGuildCount", "token", "p", "discriminator", "f", "flags", "h", "Lcom/discord/api/guildmember/GuildMember;", "member", "Lcom/discord/api/guildmember/GuildMember;", "i", "()Lcom/discord/api/guildmember/GuildMember;", "bio", "d", "bannerColor", "c", "locale", "getLocale", "analyticsToken", "getAnalyticsToken", "avatar", "a", "mfaEnabled", "j", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class User implements Serializable {
    private final String analyticsToken;
    private final Integer approximateGuildCount;
    private final NullSerializable<String> avatar;
    private final NullSerializable<String> banner;
    private final NullSerializable<String> bannerColor;
    private final NullSerializable<String> bio;
    private final Boolean bot;
    private final String discriminator;
    private final String email;
    private final Integer flags;
    private final long id;
    private final String locale;
    private final GuildMember member;
    private final Boolean mfaEnabled;
    private final NsfwAllowance nsfwAllowed;
    private final Phone phone;
    private final PremiumTier premiumType;
    private final Integer publicFlags;
    private final Boolean system;
    private final String token;
    private final String username;
    private final Boolean verified;

    public User(long j, String str, NullSerializable nullSerializable, NullSerializable nullSerializable2, String str2, Integer num, Integer num2, Boolean bool, Boolean bool2, String str3, String str4, Boolean bool3, String str5, NsfwAllowance nsfwAllowance, Boolean bool4, Phone phone, String str6, PremiumTier premiumTier, Integer num3, GuildMember guildMember, NullSerializable nullSerializable3, NullSerializable nullSerializable4, int i) {
        NullSerializable nullSerializable5 = (i & 4) != 0 ? null : nullSerializable;
        int i2 = i & 8;
        String str7 = (i & 16) != 0 ? "0000" : str2;
        Integer num4 = (i & 32) != 0 ? null : num;
        Integer num5 = (i & 64) != 0 ? null : num2;
        Boolean bool5 = (i & 128) != 0 ? null : bool;
        Boolean bool6 = (i & 256) != 0 ? null : bool2;
        int i3 = i & 512;
        int i4 = i & 1024;
        int i5 = i & 2048;
        int i6 = i & 4096;
        int i7 = i & 8192;
        int i8 = i & 16384;
        int i9 = 32768 & i;
        int i10 = 65536 & i;
        int i11 = 131072 & i;
        int i12 = 262144 & i;
        int i13 = 524288 & i;
        int i14 = 1048576 & i;
        int i15 = i & 2097152;
        Intrinsics3.checkNotNullParameter(str, "username");
        Intrinsics3.checkNotNullParameter(str7, "discriminator");
        this.id = j;
        this.username = str;
        this.avatar = nullSerializable5;
        this.banner = null;
        this.discriminator = str7;
        this.publicFlags = num4;
        this.flags = num5;
        this.bot = bool5;
        this.system = bool6;
        this.token = null;
        this.email = null;
        this.verified = null;
        this.locale = null;
        this.nsfwAllowed = null;
        this.mfaEnabled = null;
        this.phone = null;
        this.analyticsToken = null;
        this.premiumType = null;
        this.approximateGuildCount = null;
        this.member = null;
        this.bio = null;
        this.bannerColor = null;
    }

    public final NullSerializable<String> a() {
        return this.avatar;
    }

    public final NullSerializable<String> b() {
        return this.banner;
    }

    public final NullSerializable<String> c() {
        return this.bannerColor;
    }

    public final NullSerializable<String> d() {
        return this.bio;
    }

    /* renamed from: e, reason: from getter */
    public final Boolean getBot() {
        return this.bot;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return this.id == user.id && Intrinsics3.areEqual(this.username, user.username) && Intrinsics3.areEqual(this.avatar, user.avatar) && Intrinsics3.areEqual(this.banner, user.banner) && Intrinsics3.areEqual(this.discriminator, user.discriminator) && Intrinsics3.areEqual(this.publicFlags, user.publicFlags) && Intrinsics3.areEqual(this.flags, user.flags) && Intrinsics3.areEqual(this.bot, user.bot) && Intrinsics3.areEqual(this.system, user.system) && Intrinsics3.areEqual(this.token, user.token) && Intrinsics3.areEqual(this.email, user.email) && Intrinsics3.areEqual(this.verified, user.verified) && Intrinsics3.areEqual(this.locale, user.locale) && Intrinsics3.areEqual(this.nsfwAllowed, user.nsfwAllowed) && Intrinsics3.areEqual(this.mfaEnabled, user.mfaEnabled) && Intrinsics3.areEqual(this.phone, user.phone) && Intrinsics3.areEqual(this.analyticsToken, user.analyticsToken) && Intrinsics3.areEqual(this.premiumType, user.premiumType) && Intrinsics3.areEqual(this.approximateGuildCount, user.approximateGuildCount) && Intrinsics3.areEqual(this.member, user.member) && Intrinsics3.areEqual(this.bio, user.bio) && Intrinsics3.areEqual(this.bannerColor, user.bannerColor);
    }

    /* renamed from: f, reason: from getter */
    public final String getDiscriminator() {
        return this.discriminator;
    }

    /* renamed from: g, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final long getId() {
        return this.id;
    }

    public final String getUsername() {
        return this.username;
    }

    /* renamed from: h, reason: from getter */
    public final Integer getFlags() {
        return this.flags;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.username;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable = this.avatar;
        int iHashCode2 = (iHashCode + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable2 = this.banner;
        int iHashCode3 = (iHashCode2 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
        String str2 = this.discriminator;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.publicFlags;
        int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.flags;
        int iHashCode6 = (iHashCode5 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Boolean bool = this.bot;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.system;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str3 = this.token;
        int iHashCode9 = (iHashCode8 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.email;
        int iHashCode10 = (iHashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool3 = this.verified;
        int iHashCode11 = (iHashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str5 = this.locale;
        int iHashCode12 = (iHashCode11 + (str5 != null ? str5.hashCode() : 0)) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        int iHashCode13 = (iHashCode12 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31;
        Boolean bool4 = this.mfaEnabled;
        int iHashCode14 = (iHashCode13 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Phone phone = this.phone;
        int iHashCode15 = (iHashCode14 + (phone != null ? phone.hashCode() : 0)) * 31;
        String str6 = this.analyticsToken;
        int iHashCode16 = (iHashCode15 + (str6 != null ? str6.hashCode() : 0)) * 31;
        PremiumTier premiumTier = this.premiumType;
        int iHashCode17 = (iHashCode16 + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
        Integer num3 = this.approximateGuildCount;
        int iHashCode18 = (iHashCode17 + (num3 != null ? num3.hashCode() : 0)) * 31;
        GuildMember guildMember = this.member;
        int iHashCode19 = (iHashCode18 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable3 = this.bio;
        int iHashCode20 = (iHashCode19 + (nullSerializable3 != null ? nullSerializable3.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable4 = this.bannerColor;
        return iHashCode20 + (nullSerializable4 != null ? nullSerializable4.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* renamed from: j, reason: from getter */
    public final Boolean getMfaEnabled() {
        return this.mfaEnabled;
    }

    /* renamed from: k, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* renamed from: l, reason: from getter */
    public final Phone getPhone() {
        return this.phone;
    }

    /* renamed from: m, reason: from getter */
    public final PremiumTier getPremiumType() {
        return this.premiumType;
    }

    /* renamed from: n, reason: from getter */
    public final Integer getPublicFlags() {
        return this.publicFlags;
    }

    /* renamed from: o, reason: from getter */
    public final Boolean getSystem() {
        return this.system;
    }

    /* renamed from: p, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: q, reason: from getter */
    public final Boolean getVerified() {
        return this.verified;
    }

    public String toString() {
        StringBuilder sbU = outline.U("User(id=");
        sbU.append(this.id);
        sbU.append(", username=");
        sbU.append(this.username);
        sbU.append(", avatar=");
        sbU.append(this.avatar);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", discriminator=");
        sbU.append(this.discriminator);
        sbU.append(", publicFlags=");
        sbU.append(this.publicFlags);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", bot=");
        sbU.append(this.bot);
        sbU.append(", system=");
        sbU.append(this.system);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", verified=");
        sbU.append(this.verified);
        sbU.append(", locale=");
        sbU.append(this.locale);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", mfaEnabled=");
        sbU.append(this.mfaEnabled);
        sbU.append(", phone=");
        sbU.append(this.phone);
        sbU.append(", analyticsToken=");
        sbU.append(this.analyticsToken);
        sbU.append(", premiumType=");
        sbU.append(this.premiumType);
        sbU.append(", approximateGuildCount=");
        sbU.append(this.approximateGuildCount);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", bio=");
        sbU.append(this.bio);
        sbU.append(", bannerColor=");
        sbU.append(this.bannerColor);
        sbU.append(")");
        return sbU.toString();
    }
}
