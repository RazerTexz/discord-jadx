package com.discord.widgets.chat.input;

import com.discord.databinding.WidgetChatInputBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatInput.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/databinding/WidgetChatInputBinding;", "p1", "", "invoke", "(Lcom/discord/databinding/WidgetChatInputBinding;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.WidgetChatInput$binding$3, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatInput3 extends FunctionReferenceImpl implements Function1<WidgetChatInputBinding, Unit> {
    public WidgetChatInput3(WidgetChatInput widgetChatInput) {
        super(1, widgetChatInput, WidgetChatInput.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChatInputBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatInputBinding widgetChatInputBinding) {
        invoke2(widgetChatInputBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatInputBinding widgetChatInputBinding) {
        Intrinsics3.checkNotNullParameter(widgetChatInputBinding, "p1");
        WidgetChatInput.access$onViewBindingDestroy((WidgetChatInput) this.receiver, widgetChatInputBinding);
    }
}
