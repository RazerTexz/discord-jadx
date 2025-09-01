package com.discord.widgets.user.search;

import com.discord.models.guild.Guild;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/guild/Guild;", "it", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemGuild;", "invoke", "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemGuild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$2 extends Lambda implements Function1<Guild, WidgetGlobalSearchModel.ItemGuild> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$3 $toItemGuild$3;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$2(WidgetGlobalSearchModel$Companion$create$3 widgetGlobalSearchModel$Companion$create$3, String str) {
        super(1);
        this.$toItemGuild$3 = widgetGlobalSearchModel$Companion$create$3;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemGuild invoke(Guild guild) {
        return invoke2(guild);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemGuild invoke2(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "it");
        return this.$toItemGuild$3.invoke2(guild, this.$sanitizedFilter);
    }
}
