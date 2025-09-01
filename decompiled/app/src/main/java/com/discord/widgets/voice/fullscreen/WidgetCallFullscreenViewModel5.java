package com.discord.widgets.voice.fullscreen;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCallFullscreenViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isIdleFooter", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$videoPlayerIdleDetectorFooter$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel5 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetCallFullscreenViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel5(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        super(1);
        this.this$0 = widgetCallFullscreenViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetCallFullscreenViewModel.onIdleStateChanged$default(this.this$0, Boolean.valueOf(z2), null, 2, null);
    }
}
