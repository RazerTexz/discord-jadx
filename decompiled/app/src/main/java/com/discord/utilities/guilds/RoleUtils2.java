package com.discord.utilities.guilds;

import com.discord.api.role.GuildRole;
import com.discord.utilities.time.TimeUtils;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: RoleUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/utilities/guilds/RoleUtils$ROLE_COMPARATOR$1", "Ljava/util/Comparator;", "Lcom/discord/api/role/GuildRole;", "Lkotlin/Comparator;", "role1", "role2", "", "compare", "(Lcom/discord/api/role/GuildRole;Lcom/discord/api/role/GuildRole;)I", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.guilds.RoleUtils$ROLE_COMPARATOR$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RoleUtils2 implements Comparator<GuildRole> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(GuildRole guildRole, GuildRole guildRole2) {
        return compare2(guildRole, guildRole2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(GuildRole role1, GuildRole role2) {
        if (role1 != null && role2 != null) {
            int position = role1.getPosition();
            int position2 = role2.getPosition();
            return position2 != position ? position2 - position : (TimeUtils.parseSnowflake(Long.valueOf(role1.getId())) > TimeUtils.parseSnowflake(Long.valueOf(role2.getId())) ? 1 : (TimeUtils.parseSnowflake(Long.valueOf(role1.getId())) == TimeUtils.parseSnowflake(Long.valueOf(role2.getId())) ? 0 : -1));
        }
        if (role1 == null || role2 != null) {
            return (role1 != null || role2 == null) ? 0 : 1;
        }
        return -1;
    }
}
