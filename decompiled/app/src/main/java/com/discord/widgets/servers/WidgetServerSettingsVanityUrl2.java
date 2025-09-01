package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.VanityUrlResponse;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsVanityUrl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: WidgetServerSettingsVanityUrl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/models/user/MeUser;", "meUser", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/guild/VanityUrlResponse;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 3>", "Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Ljava/lang/Long;Lcom/discord/models/guild/Guild;Lcom/discord/api/guild/VanityUrlResponse;)Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl2<T1, T2, T3, T4, R> implements Func4<MeUser, Long, Guild, VanityUrlResponse, WidgetServerSettingsVanityUrl.Model> {
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsVanityUrl2(long j) {
        this.$guildId = j;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetServerSettingsVanityUrl.Model call(MeUser meUser, Long l, Guild guild, VanityUrlResponse vanityUrlResponse) {
        return call2(meUser, l, guild, vanityUrlResponse);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsVanityUrl.Model call2(MeUser meUser, Long l, Guild guild, VanityUrlResponse vanityUrlResponse) {
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        int uses = vanityUrlResponse.getUses();
        if (l == null || guild == null || !guild.canHaveVanityURL()) {
            return null;
        }
        if (guild.isOwner(meUser.getId()) || PermissionUtils.can(32L, l)) {
            return new WidgetServerSettingsVanityUrl.Model(this.$guildId, guild.getName(), guild.getVanityUrlCode(), uses);
        }
        return null;
    }
}
