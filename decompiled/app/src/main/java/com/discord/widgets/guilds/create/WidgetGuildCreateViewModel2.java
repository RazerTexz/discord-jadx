package com.discord.widgets.guilds.create;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionGuildCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.guild.Guild;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildCreateViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/guild/Guild;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$createGuild$createGuildRequestObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildCreateViewModel2 extends Lambda implements Function1<Guild, TrackNetworkMetadata2> {
    public final /* synthetic */ WidgetGuildCreateViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreateViewModel2(WidgetGuildCreateViewModel widgetGuildCreateViewModel) {
        super(1);
        this.this$0 = widgetGuildCreateViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Guild guild) {
        return invoke2(guild);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadata2 invoke2(Guild guild) {
        return new TrackNetworkActionGuildCreate(WidgetGuildCreateViewModel.access$getStockGuildTemplate$p(this.this$0).name(), null);
    }
}
