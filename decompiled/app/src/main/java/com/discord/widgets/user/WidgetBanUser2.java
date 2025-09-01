package com.discord.widgets.user;

import android.view.View;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import kotlin.Metadata;

/* compiled from: WidgetBanUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/user/WidgetBanUser$onViewBound$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetBanUser$onViewBound$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetBanUser2 implements View.OnClickListener {
    public final /* synthetic */ CheckedSetting $radio;
    public final /* synthetic */ WidgetBanUser this$0;

    public WidgetBanUser2(CheckedSetting checkedSetting, WidgetBanUser widgetBanUser) {
        this.$radio = checkedSetting;
        this.this$0 = widgetBanUser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RadioManager radioManagerAccess$getDeleteHistoryRadioManager$p = WidgetBanUser.access$getDeleteHistoryRadioManager$p(this.this$0);
        if (radioManagerAccess$getDeleteHistoryRadioManager$p != null) {
            radioManagerAccess$getDeleteHistoryRadioManager$p.a(this.$radio);
        }
    }
}
