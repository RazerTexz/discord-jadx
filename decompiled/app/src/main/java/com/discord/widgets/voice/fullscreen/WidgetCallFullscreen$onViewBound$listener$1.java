package com.discord.widgets.voice.fullscreen;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$onViewBound$listener$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public WidgetCallFullscreen$onViewBound$listener$1(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        super(1, widgetCallFullscreenViewModel, WidgetCallFullscreenViewModel.class, "onPushToTalkPressed", "onPushToTalkPressed(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        ((WidgetCallFullscreenViewModel) this.receiver).onPushToTalkPressed(z2);
    }
}
