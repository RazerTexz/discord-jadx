package com.discord.widgets.chat.input.models;

import com.discord.api.role.GuildRole;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: CommandOptionValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/chat/input/models/RoleOptionValue;", "Lcom/discord/widgets/chat/input/models/CommandOptionValue;", "Lcom/discord/api/role/GuildRole;", "role", "<init>", "(Lcom/discord/api/role/GuildRole;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RoleOptionValue extends CommandOptionValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleOptionValue(GuildRole guildRole) {
        super(String.valueOf(guildRole.getId()), null);
        Intrinsics3.checkNotNullParameter(guildRole, "role");
    }
}
