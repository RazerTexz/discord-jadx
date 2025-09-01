package com.discord.widgets.guilds.profile;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChangeGuildIdentity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel;", "invoke", "()Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity8 extends Lambda implements Function0<WidgetChangeGuildIdentityViewModel> {
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentity8(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        super(0);
        this.this$0 = widgetChangeGuildIdentity;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChangeGuildIdentityViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChangeGuildIdentityViewModel invoke() {
        long longExtra = this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra("com.discord.intent.extra.EXTRA_SOURCE");
        if (stringExtra == null) {
            stringExtra = "";
        }
        return new WidgetChangeGuildIdentityViewModel(longExtra, stringExtra, null, 4, null);
    }
}
