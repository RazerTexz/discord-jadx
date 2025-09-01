package com.discord.utilities.user;

import android.content.Context;
import com.discord.api.user.UserProfile;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: UserProfileUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005\"\u0019\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0017\u0010\f\u001a\u00020\u000b*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"'\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000e*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0017\u0010\u0015\u001a\u00020\u000b*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/discord/api/user/UserProfile;", "Landroid/content/Context;", "context", "", "getPremiumSince", "(Lcom/discord/api/user/UserProfile;Landroid/content/Context;)Ljava/lang/String;", "getBoostingSince", "", "getGuildBoostMonthsSubscribed", "(Lcom/discord/api/user/UserProfile;)Ljava/lang/Integer;", "guildBoostMonthsSubscribed", "", "isPremium", "(Lcom/discord/api/user/UserProfile;)Z", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/api/user/UserProfile$GuildReference;", "getMutualGuildsById", "(Lcom/discord/api/user/UserProfile;)Ljava/util/Map;", "mutualGuildsById", "isGuildBooster", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.user.UserProfileUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class UserProfileUtils {
    public static final String getBoostingSince(UserProfile userProfile, Context context) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$getBoostingSince");
        Intrinsics3.checkNotNullParameter(context, "context");
        String premiumGuildSince = userProfile.getPremiumGuildSince();
        if (premiumGuildSince != null) {
            return TimeUtils.getReadableTimeString(context, premiumGuildSince);
        }
        return null;
    }

    public static final Integer getGuildBoostMonthsSubscribed(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$guildBoostMonthsSubscribed");
        String premiumGuildSince = userProfile.getPremiumGuildSince();
        if (premiumGuildSince != null) {
            return Integer.valueOf(TimeUtils.getMonthsBetweenDates(new Date(TimeUtils.parseUTCDate(premiumGuildSince)), new Date()));
        }
        return null;
    }

    public static final Map<Long, UserProfile.GuildReference> getMutualGuildsById(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$mutualGuildsById");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : userProfile.d()) {
            linkedHashMap.put(Long.valueOf(((UserProfile.GuildReference) obj).getId()), obj);
        }
        return Util7.A(linkedHashMap);
    }

    public static final String getPremiumSince(UserProfile userProfile, Context context) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$getPremiumSince");
        Intrinsics3.checkNotNullParameter(context, "context");
        String premiumSince = userProfile.getPremiumSince();
        if (premiumSince != null) {
            return TimeUtils.getReadableTimeString(context, premiumSince);
        }
        return null;
    }

    public static final boolean isGuildBooster(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$isGuildBooster");
        String premiumGuildSince = userProfile.getPremiumGuildSince();
        return !(premiumGuildSince == null || premiumGuildSince.length() == 0);
    }

    public static final boolean isPremium(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$isPremium");
        String premiumSince = userProfile.getPremiumSince();
        return !(premiumSince == null || premiumSince.length() == 0);
    }
}
