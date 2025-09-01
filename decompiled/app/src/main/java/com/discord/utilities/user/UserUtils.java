package com.discord.utilities.user;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import androidx.annotation.ColorInt;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.api.premium.PremiumTier;
import com.discord.api.presence.ClientStatus;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.nullserializable.NullSerializable;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.g0.Charsets2;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: UserUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bb\u0010cJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u0005*\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\n*\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u0017\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u001bJM\u0010\u0017\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\u0010\u001f\u001a\u00060\nj\u0002`\u001e2\n\u0010 \u001a\u00060\nj\u0002`\u001e¢\u0006\u0004\b\u0017\u0010!J\u0015\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J)\u0010)\u001a\u00020(*\u00020\b2\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020\u0005*\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b+\u0010\u0012J#\u0010.\u001a\u00020\u0005*\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J'\u00103\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00102\u001a\u00020\u0005¢\u0006\u0004\b3\u00104J#\u00103\u001a\u00020\u0005*\u00020\b2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00102\u001a\u00020\u0005¢\u0006\u0004\b3\u00105J\u0011\u00107\u001a\u000206*\u00020\b¢\u0006\u0004\b7\u00108R\u0017\u00109\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0017\u0010;\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b;\u0010:R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010=R\u0017\u0010>\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b>\u0010:R\u0016\u0010?\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010@R\u0017\u0010A\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010:R\u0017\u0010B\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bB\u0010:R\u0017\u0010C\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bC\u0010:R\u0017\u0010D\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bD\u0010:R\u0017\u0010G\u001a\u00020\f*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0017\u0010H\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bH\u0010:R\u0017\u0010I\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bI\u0010:R\u0016\u0010J\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010@R\u0016\u0010K\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bK\u0010=R\u0017\u0010M\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bL\u0010:R\u0017\u0010N\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bN\u0010:R\u0019\u0010O\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0017\u0010S\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bS\u0010:R\u0017\u0010T\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bT\u0010:R\u0017\u0010U\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bU\u0010:R\u0017\u0010W\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bV\u0010:R\u0017\u0010X\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bX\u0010:R\u0017\u0010Y\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bY\u0010:R\u0017\u0010Z\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bZ\u0010:R\u0017\u0010[\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b[\u0010:R\u0017\u0010_\u001a\u00020\u0005*\u00020\\8F@\u0006¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0017\u0010a\u001a\u00020\u0005*\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b`\u0010:¨\u0006d"}, d2 = {"Lcom/discord/utilities/user/UserUtils;", "", "", "flags", "targetFlag", "", "hasFlag", "(II)Z", "Lcom/discord/models/user/User;", "(Lcom/discord/models/user/User;I)Z", "", ModelAuditLogEntry.CHANGE_KEY_ID, "", "getObfuscatedUserId", "(Ljava/lang/Long;)Ljava/lang/String;", "Lcom/discord/utilities/time/Clock;", "clock", "isAccountOldEnough", "(Lcom/discord/models/user/User;Lcom/discord/utilities/time/Clock;)Z", "getAgeMs", "(Lcom/discord/models/user/User;Lcom/discord/utilities/time/Clock;)J", "user1", "user2", "compareUserNames", "(Lcom/discord/models/user/User;Lcom/discord/models/user/User;)I", "user1Nickname", "user2Nickname", "(Lcom/discord/models/user/User;Lcom/discord/models/user/User;Ljava/lang/String;Ljava/lang/String;)I", "user1Username", "user2Username", "Lcom/discord/primitives/UserId;", "user1Id", "user2Id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)I", "discriminator", "padDiscriminator", "(I)Ljava/lang/String;", "discriminatorColor", "", "discriminatorRelativeSize", "", "getUserNameWithDiscriminator", "(Lcom/discord/models/user/User;Ljava/lang/Integer;Ljava/lang/Float;)Ljava/lang/CharSequence;", "isNewUser", "Lcom/discord/api/utcdatetime/UtcDateTime;", "date", "since", "(Lcom/discord/models/user/User;Lcom/discord/utilities/time/Clock;Lcom/discord/api/utcdatetime/UtcDateTime;)Z", "Lcom/discord/models/presence/Presence;", "presence", "isMissingPresenceVisible", "isStatusVisible", "(ILcom/discord/models/presence/Presence;Z)Z", "(Lcom/discord/models/user/User;Lcom/discord/models/presence/Presence;Z)Z", "Lcom/discord/api/user/User;", "synthesizeApiUser", "(Lcom/discord/models/user/User;)Lcom/discord/api/user/User;", "isPartner", "(Lcom/discord/models/user/User;)Z", "isHypesquadHouse2", "GUILD_VERIFICATION_ACCOUNT_AGE_THRESHOLD", "I", "isInHypesquadHouse", "CLYDE_BOT_USER_ID", "J", "isBugHunterLevel2", "isPremiumEarlySupporter", "isVerifiedDeveloper", "isPremium", "getDiscriminatorWithPadding", "(Lcom/discord/models/user/User;)Ljava/lang/String;", "discriminatorWithPadding", "isHypeSquad", "isHypesquadHouse3", "SYSTEM_USER_ID", "NEW_USER_THRESHOLD", "getHasSubscription", "hasSubscription", "isBugHunterLevel1", "EMPTY_USER", "Lcom/discord/models/user/User;", "getEMPTY_USER", "()Lcom/discord/models/user/User;", "isCertifiedModerator", "isHypesquadHouse1", "isMfaSMSEnabled", "getHasUnreadUrgentMessages", "hasUnreadUrgentMessages", "isHttpInteractionsBot", "isStaff", "isVerifiedBot", "isPremiumTier2", "Lcom/discord/models/user/MeUser;", "getHasPhone", "(Lcom/discord/models/user/MeUser;)Z", "hasPhone", "getCanUsePremiumStickers", "canUsePremiumStickers", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class UserUtils {
    public static final long CLYDE_BOT_USER_ID = -1;
    private static final int GUILD_VERIFICATION_ACCOUNT_AGE_THRESHOLD = 300000;
    private static final int NEW_USER_THRESHOLD = 604800000;
    public static final long SYSTEM_USER_ID = 643945264868098049L;
    public static final UserUtils INSTANCE = new UserUtils();
    private static final User EMPTY_USER = new CoreUser(0, "Empty User", null, null, false, false, 1, PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY, 0, 0, null, null, 3900, null);

    private UserUtils() {
    }

    public static /* synthetic */ long getAgeMs$default(UserUtils userUtils, User user, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return userUtils.getAgeMs(user, clock);
    }

    public static /* synthetic */ CharSequence getUserNameWithDiscriminator$default(UserUtils userUtils, User user, Integer num, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            f = null;
        }
        return userUtils.getUserNameWithDiscriminator(user, num, f);
    }

    private final boolean hasFlag(int flags, int targetFlag) {
        return (flags & targetFlag) == targetFlag;
    }

    private final boolean hasFlag(User user, int i) {
        return hasFlag(user.getPublicFlags() | user.getFlags(), i);
    }

    public static /* synthetic */ boolean isAccountOldEnough$default(UserUtils userUtils, User user, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return userUtils.isAccountOldEnough(user, clock);
    }

    public static /* synthetic */ boolean isNewUser$default(UserUtils userUtils, User user, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return userUtils.isNewUser(user, clock);
    }

    public static /* synthetic */ boolean since$default(UserUtils userUtils, User user, Clock clock, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return userUtils.since(user, clock, utcDateTime);
    }

    public final int compareUserNames(User user1, User user2) {
        return compareUserNames(user1, user2, null, null);
    }

    public final long getAgeMs(User user, Clock clock) {
        Intrinsics3.checkNotNullParameter(user, "$this$getAgeMs");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return clock.currentTimeMillis() - ((user.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH);
    }

    public final boolean getCanUsePremiumStickers(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$canUsePremiumStickers");
        return PremiumUtils3.grantsAccessToPremiumStickers(user.getPremiumTier());
    }

    public final String getDiscriminatorWithPadding(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$discriminatorWithPadding");
        return padDiscriminator(user.getDiscriminator());
    }

    public final User getEMPTY_USER() {
        return EMPTY_USER;
    }

    public final boolean getHasPhone(MeUser meUser) {
        Intrinsics3.checkNotNullParameter(meUser, "$this$hasPhone");
        return meUser.getPhoneNumber() != null;
    }

    public final boolean getHasSubscription(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$hasSubscription");
        return user.getPremiumTier() != PremiumTier.NONE;
    }

    public final boolean getHasUnreadUrgentMessages(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$hasUnreadUrgentMessages");
        return hasFlag(user, 8192);
    }

    public final String getObfuscatedUserId(Long id2) throws NoSuchAlgorithmException {
        if (id2 == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
        String strValueOf = String.valueOf(id2.longValue());
        Charset charset = Charsets2.a;
        Objects.requireNonNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strValueOf.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics3.checkNotNullExpressionValue(bArrDigest, "MessageDigest\n        .g…toString().toByteArray())");
        String string = "";
        for (byte b2 : bArrDigest) {
            StringBuilder sbU = outline.U(string);
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
            sbU.append(str);
            string = sbU.toString();
        }
        return string;
    }

    public final CharSequence getUserNameWithDiscriminator(User user, @ColorInt Integer num, Float f) {
        Intrinsics3.checkNotNullParameter(user, "$this$getUserNameWithDiscriminator");
        String str = user.getUsername() + getDiscriminatorWithPadding(user);
        if (num == null && f == null) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        if (num != null) {
            spannableString.setSpan(new ForegroundColorSpan(num.intValue()), user.getUsername().length(), spannableString.length(), 17);
        }
        if (f != null) {
            spannableString.setSpan(new RelativeSizeSpan(f.floatValue()), user.getUsername().length(), spannableString.length(), 17);
        }
        return spannableString;
    }

    public final boolean isAccountOldEnough(User user, Clock clock) {
        Intrinsics3.checkNotNullParameter(user, "$this$isAccountOldEnough");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return getAgeMs(user, clock) > ((long) GUILD_VERIFICATION_ACCOUNT_AGE_THRESHOLD);
    }

    public final boolean isBugHunterLevel1(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isBugHunterLevel1");
        return hasFlag(user, 8);
    }

    public final boolean isBugHunterLevel2(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isBugHunterLevel2");
        return hasFlag(user, 16384);
    }

    public final boolean isCertifiedModerator(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isCertifiedModerator");
        return hasFlag(user, 262144);
    }

    public final boolean isHttpInteractionsBot(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHttpInteractionsBot");
        return hasFlag(user, 524288);
    }

    public final boolean isHypeSquad(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHypeSquad");
        return hasFlag(user, 4);
    }

    public final boolean isHypesquadHouse1(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHypesquadHouse1");
        return hasFlag(user, 64);
    }

    public final boolean isHypesquadHouse2(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHypesquadHouse2");
        return hasFlag(user, 128);
    }

    public final boolean isHypesquadHouse3(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHypesquadHouse3");
        return hasFlag(user, 256);
    }

    public final boolean isInHypesquadHouse(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isInHypesquadHouse");
        return isHypesquadHouse1(user) || isHypesquadHouse2(user) || isHypesquadHouse3(user);
    }

    public final boolean isMfaSMSEnabled(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isMfaSMSEnabled");
        return hasFlag(user, 16);
    }

    public final boolean isNewUser(User user, Clock clock) {
        Intrinsics3.checkNotNullParameter(user, "$this$isNewUser");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return (user.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH >= clock.currentTimeMillis() - ((long) NEW_USER_THRESHOLD);
    }

    public final boolean isPartner(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isPartner");
        return hasFlag(user, 2);
    }

    public final boolean isPremium(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isPremium");
        return (user.getPremiumTier() == PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY || user.getPremiumTier() == PremiumTier.NONE) ? false : true;
    }

    public final boolean isPremiumEarlySupporter(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isPremiumEarlySupporter");
        return hasFlag(user, 512);
    }

    public final boolean isPremiumTier2(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isPremiumTier2");
        return user.getPremiumTier() == PremiumTier.TIER_2;
    }

    public final boolean isStaff(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isStaff");
        return hasFlag(user, 1);
    }

    public final boolean isStatusVisible(int flags, Presence presence, boolean isMissingPresenceVisible) {
        return hasFlag(flags, 524288) ? (presence == null || presence.getStatus() == ClientStatus.OFFLINE) ? false : true : presence != null || isMissingPresenceVisible;
    }

    public final boolean isVerifiedBot(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isVerifiedBot");
        return hasFlag(user, 65536) || user.getIsSystemUser() || user.getId() == -1;
    }

    public final boolean isVerifiedDeveloper(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isVerifiedDeveloper");
        return hasFlag(user, 131072);
    }

    public final String padDiscriminator(int discriminator) {
        return outline.P(new Object[]{Integer.valueOf(discriminator)}, 1, "#%04d", "java.lang.String.format(format, *args)");
    }

    public final boolean since(User user, Clock clock, UtcDateTime utcDateTime) {
        Intrinsics3.checkNotNullParameter(user, "$this$since");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(utcDateTime, "date");
        return new UtcDateTime((user.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH).f(utcDateTime) <= 0;
    }

    public final com.discord.api.user.User synthesizeApiUser(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$synthesizeApiUser");
        long id2 = user.getId();
        String username = user.getUsername();
        String avatar = user.getAvatar();
        return new com.discord.api.user.User(id2, username, avatar != null ? new NullSerializable.b(avatar) : new NullSerializable.a(null, 1), null, String.valueOf(user.getDiscriminator()), Integer.valueOf(user.getPublicFlags()), Integer.valueOf(user.getFlags()), Boolean.valueOf(user.getIsBot()), Boolean.valueOf(user.getIsSystemUser()), null, null, null, null, null, null, null, null, null, null, null, null, null, 3145736);
    }

    public final int compareUserNames(User user1, User user2, String user1Nickname, String user2Nickname) {
        return compareUserNames(user1 != null ? user1.getUsername() : null, user2 != null ? user2.getUsername() : null, user1Nickname, user2Nickname, user1 != null ? user1.getId() : 0L, user2 != null ? user2.getId() : 0L);
    }

    public final boolean isStatusVisible(User user, Presence presence, boolean z2) {
        Intrinsics3.checkNotNullParameter(user, "$this$isStatusVisible");
        return isStatusVisible(user.getPublicFlags() | user.getFlags(), presence, z2);
    }

    public final int compareUserNames(String user1Username, String user2Username, String user1Nickname, String user2Nickname, long user1Id, long user2Id) {
        if (user1Username == null) {
            return user2Username == null ? 0 : -1;
        }
        if (user2Username == null) {
            return 1;
        }
        if (!(user1Nickname == null || StringsJVM.isBlank(user1Nickname))) {
            user1Username = user1Nickname;
        }
        if (!(user2Nickname == null || StringsJVM.isBlank(user2Nickname))) {
            user2Username = user2Nickname;
        }
        int iCompareTo = StringsJVM.compareTo(user1Username, user2Username, true);
        return iCompareTo != 0 ? iCompareTo : (user1Id > user2Id ? 1 : (user1Id == user2Id ? 0 : -1));
    }
}
