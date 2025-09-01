package com.discord.widgets.chat.input;

import androidx.fragment.app.Fragment;
import com.discord.R;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChatInput.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/lytefast/flexinput/fragment/FlexInputFragment;", "invoke", "()Lcom/lytefast/flexinput/fragment/FlexInputFragment;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.WidgetChatInput$flexInputFragment$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatInput4 extends Lambda implements Function0<FlexInputFragment> {
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput4(WidgetChatInput widgetChatInput) {
        super(0);
        this.this$0 = widgetChatInput;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ FlexInputFragment invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FlexInputFragment invoke() {
        Fragment fragmentFindFragmentById = this.this$0.getChildFragmentManager().findFragmentById(R.id.chat_input_widget);
        Objects.requireNonNull(fragmentFindFragmentById, "null cannot be cast to non-null type com.lytefast.flexinput.fragment.FlexInputFragment");
        return (FlexInputFragment) fragmentFindFragmentById;
    }
}
