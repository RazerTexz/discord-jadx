package com.discord.utilities.guilds;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.api.role.GuildRoleTags;
import com.discord.models.member.GuildMember;
import com.discord.utilities.color.ColorCompat;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: RoleUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b2\u0010-J'\u0010\u0007\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\rJ/\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0015J5\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u0014\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u001f\u0010!J\u0013\u0010\"\u001a\u00020\u000b*\u00020\u0002H\u0007¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020\u000b*\u00020\u0002H\u0007¢\u0006\u0004\b$\u0010#J\u0013\u0010%\u001a\u00020\u000b*\u00020\u0002H\u0007¢\u0006\u0004\b%\u0010#R2\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00020&j\b\u0012\u0004\u0012\u00020\u0002`'8\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u001e\u00100\u001a\n /*\u0004\u0018\u00010.0.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/discord/utilities/guilds/RoleUtils;", "", "Lcom/discord/api/role/GuildRole;", "Landroid/content/Context;", "context", "", "defaultColor", "getRoleColor", "(Lcom/discord/api/role/GuildRole;Landroid/content/Context;Ljava/lang/Integer;)I", "role1", "role2", "", "rankIsHigher", "(Lcom/discord/api/role/GuildRole;Lcom/discord/api/role/GuildRole;)Z", "rankEquals", "", "", "guildRoles", "Lcom/discord/models/member/GuildMember;", "member", "getHighestRole", "(Ljava/util/Map;Lcom/discord/models/member/GuildMember;)Lcom/discord/api/role/GuildRole;", "getHighestHoistedRole", "", "roleIds", "(Ljava/util/Map;Ljava/util/Collection;)Lcom/discord/api/role/GuildRole;", "", "input", "containsRoleMentions", "(Ljava/lang/String;)Z", "role", "getOpaqueColor", "(Lcom/discord/api/role/GuildRole;I)I", "(Lcom/discord/api/role/GuildRole;)I", "isDefaultColor", "(Lcom/discord/api/role/GuildRole;)Z", "hasSubscriptionListingId", "isSubscriptionRolePurchasableOrHasSubscribers", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "ROLE_COMPARATOR", "Ljava/util/Comparator;", "getROLE_COMPARATOR", "()Ljava/util/Comparator;", "getROLE_COMPARATOR$annotations", "()V", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "ROLE_MENTION_RE", "Ljava/util/regex/Pattern;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RoleUtils {
    public static final RoleUtils INSTANCE = new RoleUtils();
    private static final Pattern ROLE_MENTION_RE = Pattern.compile("<@&(\\d+)>");
    private static final Comparator<GuildRole> ROLE_COMPARATOR = new RoleUtils2();

    private RoleUtils() {
    }

    public static final boolean containsRoleMentions(String input) {
        return input != null && ROLE_MENTION_RE.matcher(input).find();
    }

    public static final GuildRole getHighestHoistedRole(Map<Long, GuildRole> guildRoles, GuildMember member) {
        Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
        if (member == null) {
            return null;
        }
        List<Long> roles = member.getRoles();
        ArrayList arrayList = new ArrayList();
        for (Object obj : roles) {
            GuildRole guildRole = guildRoles.get(Long.valueOf(((Number) obj).longValue()));
            if (guildRole != null && guildRole.getHoist()) {
                arrayList.add(obj);
            }
        }
        return getHighestRole(guildRoles, arrayList);
    }

    public static final GuildRole getHighestRole(Map<Long, GuildRole> guildRoles, GuildMember member) {
        Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
        if (member == null) {
            return null;
        }
        return getHighestRole(guildRoles, member.getRoles());
    }

    @ColorInt
    public static final int getOpaqueColor(GuildRole role, @ColorInt int defaultColor) {
        if (role != null) {
            try {
                if (role.getColor() != 0) {
                    defaultColor = role.getColor();
                }
            } catch (Exception unused) {
                return ViewCompat.MEASURED_STATE_MASK;
            }
        }
        return ViewCompat.MEASURED_STATE_MASK + defaultColor;
    }

    public static final Comparator<GuildRole> getROLE_COMPARATOR() {
        return ROLE_COMPARATOR;
    }

    public static /* synthetic */ void getROLE_COMPARATOR$annotations() {
    }

    @ColorInt
    public static final int getRoleColor(GuildRole guildRole, Context context) {
        return getRoleColor$default(guildRole, context, null, 2, null);
    }

    @ColorInt
    public static final int getRoleColor(GuildRole guildRole, Context context, @ColorInt Integer num) {
        Intrinsics3.checkNotNullParameter(guildRole, "$this$getRoleColor");
        Intrinsics3.checkNotNullParameter(context, "context");
        return isDefaultColor(guildRole) ? num != null ? num.intValue() : ColorCompat.getColor(context, R.color.primary_300) : getOpaqueColor(guildRole);
    }

    public static /* synthetic */ int getRoleColor$default(GuildRole guildRole, Context context, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return getRoleColor(guildRole, context, num);
    }

    public static final boolean hasSubscriptionListingId(GuildRole guildRole) {
        Intrinsics3.checkNotNullParameter(guildRole, "$this$hasSubscriptionListingId");
        GuildRoleTags tags = guildRole.getTags();
        String subscriptionListingId = tags != null ? tags.getSubscriptionListingId() : null;
        return !(subscriptionListingId == null || StringsJVM.isBlank(subscriptionListingId));
    }

    public static final boolean isDefaultColor(GuildRole guildRole) {
        Intrinsics3.checkNotNullParameter(guildRole, "$this$isDefaultColor");
        return guildRole.getColor() == 0;
    }

    public static final boolean isSubscriptionRolePurchasableOrHasSubscribers(GuildRole guildRole) {
        GuildRoleTags tags;
        Intrinsics3.checkNotNullParameter(guildRole, "$this$isSubscriptionRolePurchasableOrHasSubscribers");
        return hasSubscriptionListingId(guildRole) && (tags = guildRole.getTags()) != null && tags.b();
    }

    public static final boolean rankEquals(GuildRole role1, GuildRole role2) {
        return ROLE_COMPARATOR.compare(role1, role2) == 0;
    }

    public static final boolean rankIsHigher(GuildRole role1, GuildRole role2) {
        return ROLE_COMPARATOR.compare(role1, role2) < 0;
    }

    public static final GuildRole getHighestRole(Map<Long, GuildRole> guildRoles, Collection<Long> roleIds) {
        Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
        GuildRole guildRole = null;
        if (roleIds == null) {
            return null;
        }
        Iterator<Long> it = roleIds.iterator();
        while (it.hasNext()) {
            GuildRole guildRole2 = guildRoles.get(Long.valueOf(it.next().longValue()));
            if (guildRole2 != null && rankIsHigher(guildRole2, guildRole)) {
                guildRole = guildRole2;
            }
        }
        return guildRole;
    }

    @ColorInt
    public static final int getOpaqueColor(GuildRole role) {
        return getOpaqueColor(role, 0);
    }
}
