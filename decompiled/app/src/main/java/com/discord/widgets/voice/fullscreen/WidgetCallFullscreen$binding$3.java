package com.discord.widgets.voice.fullscreen;

import com.discord.databinding.WidgetCallFullscreenBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/databinding/WidgetCallFullscreenBinding;", "p1", "", "invoke", "(Lcom/discord/databinding/WidgetCallFullscreenBinding;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$binding$3 extends FunctionReferenceImpl implements Function1<WidgetCallFullscreenBinding, Unit> {
    public WidgetCallFullscreen$binding$3(WidgetCallFullscreen widgetCallFullscreen) {
        super(1, widgetCallFullscreen, WidgetCallFullscreen.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetCallFullscreenBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        invoke2(widgetCallFullscreenBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        Intrinsics3.checkNotNullParameter(widgetCallFullscreenBinding, "p1");
        WidgetCallFullscreen.access$onViewBindingDestroy((WidgetCallFullscreen) this.receiver, widgetCallFullscreenBinding);
    }
}
