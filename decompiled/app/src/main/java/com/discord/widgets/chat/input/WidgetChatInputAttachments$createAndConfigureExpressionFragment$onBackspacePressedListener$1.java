package com.discord.widgets.chat.input;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.Metadata;

/* compiled from: WidgetChatInputAttachments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/discord/widgets/chat/input/WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1", "Lcom/discord/widgets/chat/input/OnBackspacePressedListener;", "", "onBackspacePressed", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1 implements OnBackspacePressedListener {
    public final /* synthetic */ TextView $chatInput;

    public WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1(TextView textView) {
        this.$chatInput = textView;
    }

    @Override // com.discord.widgets.chat.input.OnBackspacePressedListener
    public void onBackspacePressed() {
        this.$chatInput.dispatchKeyEvent(new KeyEvent(0, 67));
    }
}
