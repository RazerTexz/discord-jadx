package com.discord.widgets.guilds.join;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildWelcomeSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel;", "invoke", "()Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet5 extends Lambda implements Function0<WidgetGuildWelcomeSheetViewModel> {
    public final /* synthetic */ WidgetGuildWelcomeSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheet5(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
        super(0);
        this.this$0 = widgetGuildWelcomeSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildWelcomeSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildWelcomeSheetViewModel invoke() {
        return new WidgetGuildWelcomeSheetViewModel(WidgetGuildWelcomeSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), null, 2, null);
    }
}
