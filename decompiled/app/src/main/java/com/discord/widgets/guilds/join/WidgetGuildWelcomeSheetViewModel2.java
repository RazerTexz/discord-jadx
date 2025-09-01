package com.discord.widgets.guilds.join;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/stores/StoreGuildWelcomeScreens$State;", "guildWelcomeScreen", "Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildWelcomeScreens$State;)Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetViewModel2<T1, T2, R> implements Func2<Guild, StoreGuildWelcomeScreens.State, WidgetGuildWelcomeSheetViewModel.StoreState> {
    public static final WidgetGuildWelcomeSheetViewModel2 INSTANCE = new WidgetGuildWelcomeSheetViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGuildWelcomeSheetViewModel.StoreState call(Guild guild, StoreGuildWelcomeScreens.State state) {
        return call2(guild, state);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildWelcomeSheetViewModel.StoreState call2(Guild guild, StoreGuildWelcomeScreens.State state) {
        return new WidgetGuildWelcomeSheetViewModel.StoreState(guild, state);
    }
}
