package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: WidgetChangeGuildIdentityViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\n \u0001*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelsInfo;", "kotlin.jvm.PlatformType", "guildChannelsInfo", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/MeUser;", "meUser", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "meMember", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/channel/GuildChannelsInfo;Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;)Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel3<T1, T2, T3, T4, R> implements Func4<GuildChannelsInfo, Guild, MeUser, GuildMember, WidgetChangeGuildIdentityViewModel.StoreState> {
    public static final WidgetChangeGuildIdentityViewModel3 INSTANCE = new WidgetChangeGuildIdentityViewModel3();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetChangeGuildIdentityViewModel.StoreState call(GuildChannelsInfo guildChannelsInfo, Guild guild, MeUser meUser, GuildMember guildMember) {
        return call2(guildChannelsInfo, guild, meUser, guildMember);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChangeGuildIdentityViewModel.StoreState call2(GuildChannelsInfo guildChannelsInfo, Guild guild, MeUser meUser, GuildMember guildMember) {
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        Intrinsics3.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
        return new WidgetChangeGuildIdentityViewModel.StoreState(guild, meUser, guildMember, guildChannelsInfo);
    }
}
