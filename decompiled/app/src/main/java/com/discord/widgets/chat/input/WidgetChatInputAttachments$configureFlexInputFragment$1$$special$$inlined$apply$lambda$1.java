package com.discord.widgets.chat.input;

import android.view.View;
import b.b.a.f.KeyboardManager;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChatInputAttachments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"com/discord/widgets/chat/input/WidgetChatInputAttachments$configureFlexInputFragment$1$1$1", "Lb/b/a/f/a;", "Landroid/view/View;", "view", "", "requestDisplay", "(Landroid/view/View;)V", "requestHide", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1 implements KeyboardManager {
    public final /* synthetic */ WidgetChatInputAttachments.AnonymousClass1 this$0;

    public WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1(WidgetChatInputAttachments.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
    }

    @Override // b.b.a.f.KeyboardManager
    public void requestDisplay(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        this.this$0.$fragment.showKeyboard(view);
    }

    @Override // b.b.a.f.KeyboardManager
    public void requestHide() {
        WidgetChatInputAttachments.AnonymousClass1 anonymousClass1 = this.this$0;
        anonymousClass1.$fragment.hideKeyboard(WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).l());
    }
}
