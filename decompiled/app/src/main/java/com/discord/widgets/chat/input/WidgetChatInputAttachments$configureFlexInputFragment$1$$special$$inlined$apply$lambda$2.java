package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatInputAttachments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/core/view/inputmethod/InputContentInfoCompat;", "it", "", "invoke", "(Landroidx/core/view/inputmethod/InputContentInfoCompat;)V", "com/discord/widgets/chat/input/WidgetChatInputAttachments$configureFlexInputFragment$1$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2 extends Lambda implements Function1<InputContentInfoCompat, Unit> {
    public final /* synthetic */ WidgetChatInputAttachments.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2(WidgetChatInputAttachments.AnonymousClass1 anonymousClass1) {
        super(1);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InputContentInfoCompat inputContentInfoCompat) {
        invoke2(inputContentInfoCompat);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InputContentInfoCompat inputContentInfoCompat) {
        Intrinsics3.checkNotNullParameter(inputContentInfoCompat, "it");
        WidgetChatInputAttachments widgetChatInputAttachments = WidgetChatInputAttachments.this;
        Context context = WidgetChatInputAttachments.access$getFlexInputFragment$p(widgetChatInputAttachments).l().getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "flexInputFragment.getTextInput().context");
        WidgetChatInputAttachments.access$setAttachmentFromPicker(widgetChatInputAttachments, context, inputContentInfoCompat);
    }
}
