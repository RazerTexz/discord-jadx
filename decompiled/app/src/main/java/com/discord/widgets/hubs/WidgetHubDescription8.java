package com.discord.widgets.hubs;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetHubDescription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubDescriptionViewModel;", "invoke", "()Lcom/discord/widgets/hubs/WidgetHubDescriptionViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubDescription$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDescription8 extends Lambda implements Function0<WidgetHubDescriptionViewModel> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription8(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubDescriptionViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubDescriptionViewModel invoke() {
        return new WidgetHubDescriptionViewModel(this.this$0.getArgs().getChannelId(), this.this$0.getArgs().getGuildId(), this.this$0.getArgs().isEditing(), this.this$0.getArgs().getPrimaryCategoryId(), null, null, 48, null);
    }
}
