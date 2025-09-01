package com.discord.widgets.hubs;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetHubAddName.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubAddNameViewModel;", "invoke", "()Lcom/discord/widgets/hubs/WidgetHubAddNameViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubAddName$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddName4 extends Lambda implements Function0<WidgetHubAddNameViewModel> {
    public final /* synthetic */ WidgetHubAddName this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddName4(WidgetHubAddName widgetHubAddName) {
        super(0);
        this.this$0 = widgetHubAddName;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubAddNameViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubAddNameViewModel invoke() {
        return new WidgetHubAddNameViewModel(this.this$0.getArgs().getGuildId(), null, null, null, 14, null);
    }
}
