package com.discord.widgets.servers;

import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreEmojiGuild;
import com.discord.stores.StoreGuilds;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import d0.t.Maps6;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsEmojis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;", "invoke", "()Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$1 extends Lambda implements Function0<WidgetServerSettingsEmojis.Model> {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ StoreGuilds $storeGuild;
    public final /* synthetic */ StoreEmojiGuild $storeGuildEmoji;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$1(Guild guild, StoreEmojiGuild storeEmojiGuild, StoreGuilds storeGuilds) {
        super(0);
        this.$guild = guild;
        this.$storeGuildEmoji = storeEmojiGuild;
        this.$storeGuild = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmojis.Model invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsEmojis.Model invoke() {
        long id2 = this.$guild.getId();
        List<ModelEmojiGuild> guildEmoji = this.$storeGuildEmoji.getGuildEmoji(id2);
        Map<Long, GuildMember> mapEmptyMap = this.$storeGuild.getMembers().get(Long.valueOf(id2));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        return WidgetServerSettingsEmojis.Model.Companion.access$create(WidgetServerSettingsEmojis.Model.INSTANCE, this.$guild, guildEmoji, mapEmptyMap);
    }
}
