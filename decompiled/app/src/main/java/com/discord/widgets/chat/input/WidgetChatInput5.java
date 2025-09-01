package com.discord.widgets.chat.input;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChatInput.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "invoke", "()Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.WidgetChatInput$flexInputViewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatInput5 extends Lambda implements Function0<AppFlexInputViewModel> {
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput5(WidgetChatInput widgetChatInput) {
        super(0);
        this.this$0 = widgetChatInput;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AppFlexInputViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppFlexInputViewModel invoke() {
        return new AppFlexInputViewModel(this.this$0, null, null, null, null, null, 62, null);
    }
}
