package com.discord.widgets.guilds.profile;

import android.view.View;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel;
import kotlin.Metadata;

/* compiled from: WidgetChangeGuildIdentity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/guilds/profile/WidgetChangeGuildIdentity$configureNickname$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity3 implements View.OnClickListener {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    public WidgetChangeGuildIdentity3(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel.ViewState.Loaded loaded) {
        this.this$0 = widgetChangeGuildIdentity;
        this.$viewState$inlined = loaded;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChangeGuildIdentity.access$getViewModel$p(this.this$0).updateNickname("");
    }
}
