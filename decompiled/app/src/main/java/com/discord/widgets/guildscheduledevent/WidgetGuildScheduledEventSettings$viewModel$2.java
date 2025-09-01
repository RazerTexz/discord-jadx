package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.utilities.intent.IntentUtilsKt;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel;", "invoke", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$viewModel$2 extends Lambda implements Function0<GuildScheduledEventSettingsViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventSettings$viewModel$2(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(0);
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventSettingsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventSettingsViewModel invoke() {
        long jAccess$getGuildId$p = WidgetGuildScheduledEventSettings.access$getGuildId$p(this.this$0);
        Long lAccess$getExistingGuildScheduledEventId$p = WidgetGuildScheduledEventSettings.access$getExistingGuildScheduledEventId$p(this.this$0);
        Serializable serializableExtra = this.this$0.getMostRecentIntent().getSerializableExtra("EXTRA_ENTITY_TYPE");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.api.guildscheduledevent.GuildScheduledEventEntityType");
        return new GuildScheduledEventSettingsViewModel(jAccess$getGuildId$p, lAccess$getExistingGuildScheduledEventId$p, (GuildScheduledEventEntityType) serializableExtra, IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "com.discord.intent.extra.EXTRA_CHANNEL_ID"), this.this$0.getMostRecentIntent().getStringExtra("EXTRA_EXTERNAL_LOCATION"), null, 32, null);
    }
}
