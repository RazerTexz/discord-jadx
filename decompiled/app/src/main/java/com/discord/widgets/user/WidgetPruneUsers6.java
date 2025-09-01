package com.discord.widgets.user;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetPruneUsers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel;", "invoke", "()Lcom/discord/widgets/user/WidgetPruneUsersViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetPruneUsers$viewModel$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetPruneUsers6 extends Lambda implements Function0<WidgetPruneUsersViewModel> {
    public final /* synthetic */ WidgetPruneUsers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsers6(WidgetPruneUsers widgetPruneUsers) {
        super(0);
        this.this$0 = widgetPruneUsers;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetPruneUsersViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetPruneUsersViewModel invoke() {
        return new WidgetPruneUsersViewModel(WidgetPruneUsers.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_GUILD_ID", -1L), null, null, null, null, null, 62, null);
    }
}
