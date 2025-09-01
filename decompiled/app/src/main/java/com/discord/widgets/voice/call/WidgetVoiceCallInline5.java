package com.discord.widgets.voice.call;

import com.discord.databinding.WidgetVoiceCallInlineBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetVoiceCallInline.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", "p1", "", "invoke", "(Lcom/discord/databinding/WidgetVoiceCallInlineBinding;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$binding$3, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceCallInline5 extends FunctionReferenceImpl implements Function1<WidgetVoiceCallInlineBinding, Unit> {
    public WidgetVoiceCallInline5(WidgetVoiceCallInline widgetVoiceCallInline) {
        super(1, widgetVoiceCallInline, WidgetVoiceCallInline.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetVoiceCallInlineBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceCallInlineBinding widgetVoiceCallInlineBinding) {
        invoke2(widgetVoiceCallInlineBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceCallInlineBinding widgetVoiceCallInlineBinding) {
        Intrinsics3.checkNotNullParameter(widgetVoiceCallInlineBinding, "p1");
        WidgetVoiceCallInline.access$onViewBindingDestroy((WidgetVoiceCallInline) this.receiver, widgetVoiceCallInlineBinding);
    }
}
