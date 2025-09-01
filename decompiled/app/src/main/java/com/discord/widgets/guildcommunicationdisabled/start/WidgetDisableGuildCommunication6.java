package com.discord.widgets.guildcommunicationdisabled.start;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetDisableGuildCommunication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel;", "invoke", "()Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication6 extends Lambda implements Function0<DisableGuildCommunicationViewModel> {
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDisableGuildCommunication6(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        super(0);
        this.this$0 = widgetDisableGuildCommunication;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DisableGuildCommunicationViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DisableGuildCommunicationViewModel invoke() {
        return new DisableGuildCommunicationViewModel(WidgetDisableGuildCommunication.access$getUserId$p(this.this$0), WidgetDisableGuildCommunication.access$getGuildId$p(this.this$0), null, null, null, null, 60, null);
    }
}
