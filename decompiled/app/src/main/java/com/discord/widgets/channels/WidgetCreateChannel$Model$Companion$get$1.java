package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.WidgetCreateChannel;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import rx.functions.Func6;

/* compiled from: WidgetCreateChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u000e\u0010\b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\n \u0001*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t2\u000e\u0010\r\u001a\n \u0001*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "categoryPermissions", "", "Lcom/discord/api/role/GuildRole;", "roles", "", "canCreateForumChannels", "Lcom/discord/widgets/channels/WidgetCreateChannel$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;)Lcom/discord/widgets/channels/WidgetCreateChannel$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCreateChannel$Model$Companion$get$1<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, Guild, Long, Long, List<? extends GuildRole>, Boolean, WidgetCreateChannel.Model> {
    public static final WidgetCreateChannel$Model$Companion$get$1 INSTANCE = new WidgetCreateChannel$Model$Companion$get$1();

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetCreateChannel.Model call(MeUser meUser, Guild guild, Long l, Long l2, List<? extends GuildRole> list, Boolean bool) {
        return call2(meUser, guild, l, l2, (List<GuildRole>) list, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetCreateChannel.Model call2(MeUser meUser, Guild guild, Long l, Long l2, List<GuildRole> list, Boolean bool) {
        if (guild == null || l == null || list == null) {
            return null;
        }
        Intrinsics3.checkNotNullExpressionValue(bool, "canCreateForumChannels");
        boolean zBooleanValue = bool.booleanValue();
        boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, Long.valueOf(l2 != null ? l2.longValue() : l.longValue()), meUser.getMfaEnabled(), guild.getMfaLevel());
        boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
        boolean zCanAndIsElevated2 = PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(l2 != null ? l2.longValue() : l.longValue()), meUser.getMfaEnabled(), guild.getMfaLevel());
        ArrayList arrayList = new ArrayList();
        for (GuildRole guildRole : list) {
            SingleTypePayload singleTypePayload = guildRole.getId() != guild.getId() ? new SingleTypePayload(guildRole, String.valueOf(guildRole.getId()), 0) : null;
            if (singleTypePayload != null) {
                arrayList.add(singleTypePayload);
            }
        }
        return new WidgetCreateChannel.Model(zBooleanValue, zCanAndIsElevated, zCanAndIsElevated2, zContains, arrayList, null);
    }
}
