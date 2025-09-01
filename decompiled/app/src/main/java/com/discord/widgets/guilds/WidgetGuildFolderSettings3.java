package com.discord.widgets.guilds;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildFolderSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel;", "invoke", "()Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildFolderSettings3 extends Lambda implements Function0<WidgetGuildFolderSettingsViewModel> {
    public final /* synthetic */ WidgetGuildFolderSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettings3(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        super(0);
        this.this$0 = widgetGuildFolderSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildFolderSettingsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildFolderSettingsViewModel invoke() {
        return new WidgetGuildFolderSettingsViewModel(this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", -1L), null, null, 6, null);
    }
}
