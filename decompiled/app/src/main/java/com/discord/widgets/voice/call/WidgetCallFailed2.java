package com.discord.widgets.voice.call;

import android.view.View;
import com.discord.models.user.User;
import kotlin.Metadata;

/* compiled from: WidgetCallFailed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/voice/call/WidgetCallFailed$configureUI$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.call.WidgetCallFailed$configureUI$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetCallFailed2 implements View.OnClickListener {
    public final /* synthetic */ User $this_configureUI$inlined;
    public final /* synthetic */ WidgetCallFailed this$0;

    public WidgetCallFailed2(WidgetCallFailed widgetCallFailed, User user) {
        this.this$0 = widgetCallFailed;
        this.$this_configureUI$inlined = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetCallFailed.sendFriendRequest$default(this.this$0, this.$this_configureUI$inlined.getId(), this.$this_configureUI$inlined.getUsername(), null, 4, null);
    }
}
