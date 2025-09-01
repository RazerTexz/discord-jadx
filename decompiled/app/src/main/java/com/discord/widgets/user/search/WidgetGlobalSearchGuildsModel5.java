package com.discord.widgets.user.search;

import com.discord.models.guild.Guild;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchGuildsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "it", "Lcom/discord/models/guild/Guild;", "invoke", "(J)Lcom/discord/models/guild/Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel$Companion$create$guildItems$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel5 extends Lambda implements Function1<Long, Guild> {
    public final /* synthetic */ Map $guilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsModel5(Map map) {
        super(1);
        this.$guilds = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Guild invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Guild invoke(long j) {
        return (Guild) this.$guilds.get(Long.valueOf(j));
    }
}
