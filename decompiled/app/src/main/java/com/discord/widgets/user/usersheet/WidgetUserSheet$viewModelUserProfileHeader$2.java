package com.discord.widgets.user.usersheet;

import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetUserSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel;", "invoke", "()Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserSheet$viewModelUserProfileHeader$2 extends Lambda implements Function0<UserProfileHeaderViewModel> {
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$viewModelUserProfileHeader$2(WidgetUserSheet widgetUserSheet) {
        super(0);
        this.this$0 = widgetUserSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ UserProfileHeaderViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UserProfileHeaderViewModel invoke() {
        return new UserProfileHeaderViewModel(WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_USER_ID"), Long.valueOf(WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_CHANNEL_ID")), Long.valueOf(WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_GUILD_ID")), null, false, null, null, 120, null);
    }
}
