package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import com.discord.R;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDisableGuildCommunication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "hasFocus", "", "onFocusChange", "(Landroid/view/View;Z)V", "com/discord/widgets/guildcommunicationdisabled/start/WidgetDisableGuildCommunication$configureUI$3$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication2 implements View.OnFocusChangeListener {
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    public WidgetDisableGuildCommunication2(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        this.this$0 = widgetDisableGuildCommunication;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (!z2) {
            WidgetDisableGuildCommunication.access$getBinding$p(this.this$0).d.setHint(R.string.guild_communication_disabled_reason_hint_android);
            return;
        }
        TextInputLayout textInputLayout = WidgetDisableGuildCommunication.access$getBinding$p(this.this$0).d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
        textInputLayout.setHint("");
    }
}
