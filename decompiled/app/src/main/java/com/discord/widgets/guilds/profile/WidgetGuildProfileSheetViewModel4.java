package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import rx.functions.Func9;

/* compiled from: WidgetGuildProfileSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0018\u001a\n \u0005*\u0004\u0018\u00010\u00150\u00152\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\r \u0005*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f2*\u0010\u0011\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00100\u0010 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\f0\u000f2\u000e\u0010\u0012\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00130\u0013H\n¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "guildProfile", "", "kotlin.jvm.PlatformType", "isUnread", "Lcom/discord/models/user/MeUser;", "me", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "computedMe", "", "", "restrictedGuildIds", "", "Lcom/discord/models/domain/emoji/Emoji;", "emojis", "isLurking", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "guildChannelsInfo", "Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;Ljava/lang/Boolean;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lcom/discord/utilities/channel/GuildChannelsInfo;)Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel4<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Guild, StoreGuildProfiles.GuildProfileData, Boolean, MeUser, GuildMember, List<? extends Long>, List<Emoji>, Boolean, GuildChannelsInfo, WidgetGuildProfileSheetViewModel.StoreState> {
    public static final WidgetGuildProfileSheetViewModel4 INSTANCE = new WidgetGuildProfileSheetViewModel4();

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetGuildProfileSheetViewModel.StoreState call(Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool, MeUser meUser, GuildMember guildMember, List<? extends Long> list, List<Emoji> list2, Boolean bool2, GuildChannelsInfo guildChannelsInfo) {
        return call2(guild, guildProfileData, bool, meUser, guildMember, (List<Long>) list, list2, bool2, guildChannelsInfo);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildProfileSheetViewModel.StoreState call2(Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool, MeUser meUser, GuildMember guildMember, List<Long> list, List<Emoji> list2, Boolean bool2, GuildChannelsInfo guildChannelsInfo) {
        Intrinsics3.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        Intrinsics3.checkNotNullExpressionValue(list, "restrictedGuildIds");
        boolean isDeveloperMode = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
        List<Emoji> listEmptyList = list2 != null ? list2 : Collections2.emptyList();
        Intrinsics3.checkNotNullExpressionValue(bool2, "isLurking");
        boolean zBooleanValue = bool2.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(bool, "isUnread");
        return new WidgetGuildProfileSheetViewModel.StoreState(guild, guildProfileData, guildChannelsInfo, meUser, guildMember, list, isDeveloperMode, listEmptyList, zBooleanValue, bool.booleanValue());
    }
}
