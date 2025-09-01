package com.discord.widgets.settings;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetMuteSettingsSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/settings/MuteSettingsSheetViewModel;", "invoke", "()Lcom/discord/widgets/settings/MuteSettingsSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet4 extends Lambda implements Function0<MuteSettingsSheetViewModel> {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMuteSettingsSheet4(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(0);
        this.this$0 = widgetMuteSettingsSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MuteSettingsSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MuteSettingsSheetViewModel invoke() {
        return new MuteSettingsSheetViewModel(WidgetMuteSettingsSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_GUILD_ID", 0L), WidgetMuteSettingsSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_CHANNEL_ID", 0L), null, null, null, 28, null);
    }
}
