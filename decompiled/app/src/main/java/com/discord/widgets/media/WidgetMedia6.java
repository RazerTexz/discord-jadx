package com.discord.widgets.media;

import com.discord.databinding.WidgetMediaBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetMedia.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/databinding/WidgetMediaBinding;", "p1", "", "invoke", "(Lcom/discord/databinding/WidgetMediaBinding;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.media.WidgetMedia$binding$3, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetMedia6 extends FunctionReferenceImpl implements Function1<WidgetMediaBinding, Unit> {
    public WidgetMedia6(WidgetMedia widgetMedia) {
        super(1, widgetMedia, WidgetMedia.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetMediaBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetMediaBinding widgetMediaBinding) {
        invoke2(widgetMediaBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetMediaBinding widgetMediaBinding) {
        Intrinsics3.checkNotNullParameter(widgetMediaBinding, "p1");
        WidgetMedia.access$onViewBindingDestroy((WidgetMedia) this.receiver, widgetMediaBinding);
    }
}
