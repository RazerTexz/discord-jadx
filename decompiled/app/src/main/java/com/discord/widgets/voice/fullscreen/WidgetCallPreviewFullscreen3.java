package com.discord.widgets.voice.fullscreen;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCallPreviewFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel;", "invoke", "()Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$viewModel$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen3 extends Lambda implements Function0<WidgetCallPreviewFullscreenViewModel> {
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen3(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        super(0);
        this.this$0 = widgetCallPreviewFullscreen;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetCallPreviewFullscreenViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetCallPreviewFullscreenViewModel invoke() {
        return new WidgetCallPreviewFullscreenViewModel(WidgetCallPreviewFullscreen.access$getVoiceChannelId(this.this$0), null, null, null, null, null, null, null, null, null, null, null, 4094, null);
    }
}
