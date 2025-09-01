package com.discord.widgets.guilds.contextmenu;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: GuildContextMenuViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\n0\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u0018\u0010\t\u001a\u0014 \u0003*\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b0\u0007j\u0002`\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "isUnread", "", "Lcom/discord/primitives/GuildId;", "selectedGuildId", "Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildContextMenuViewModel2<T1, T2, T3, T4, R> implements Func4<Guild, MeUser, Boolean, Long, GuildContextMenuViewModel.StoreState> {
    public static final GuildContextMenuViewModel2 INSTANCE = new GuildContextMenuViewModel2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ GuildContextMenuViewModel.StoreState call(Guild guild, MeUser meUser, Boolean bool, Long l) {
        return call2(guild, meUser, bool, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildContextMenuViewModel.StoreState call2(Guild guild, MeUser meUser, Boolean bool, Long l) {
        if (guild == null) {
            return GuildContextMenuViewModel.StoreState.Invalid.INSTANCE;
        }
        long id2 = meUser.getId();
        Intrinsics3.checkNotNullExpressionValue(bool, "isUnread");
        boolean zBooleanValue = bool.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(l, "selectedGuildId");
        return new GuildContextMenuViewModel.StoreState.Valid(guild, id2, zBooleanValue, l.longValue());
    }
}
