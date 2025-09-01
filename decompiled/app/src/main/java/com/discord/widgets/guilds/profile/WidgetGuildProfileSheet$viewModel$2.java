package com.discord.widgets.guilds.profile;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* compiled from: WidgetGuildProfileSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel;", "invoke", "()Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$viewModel$2 extends Lambda implements Function0<WidgetGuildProfileSheetViewModel> {
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$viewModel$2(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        super(0);
        this.this$0 = widgetGuildProfileSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildProfileSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildProfileSheetViewModel invoke() {
        return new WidgetGuildProfileSheetViewModel(null, null, WidgetGuildProfileSheet.access$getArgumentsOrDefault$p(this.this$0).getBoolean("com.discord.intent.extra.EXTRA_VIEWING_GUILD"), null, null, null, WidgetGuildProfileSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), null, Opcodes.NEW, null);
    }
}
