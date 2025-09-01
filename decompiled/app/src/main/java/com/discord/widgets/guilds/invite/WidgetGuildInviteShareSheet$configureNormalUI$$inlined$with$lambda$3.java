package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import com.discord.widgets.guilds.invite.WidgetGuildInviteSettings;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetGuildInviteShareSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/guilds/invite/WidgetGuildInviteShareSheet$configureNormalUI$2$3", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$3 implements View.OnClickListener {
    public final /* synthetic */ GuildInvite $invite;
    public final /* synthetic */ String $searchQuery$inlined;
    public final /* synthetic */ GuildInviteShareSheetViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    public WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$3(GuildInvite guildInvite, WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, String str, GuildInviteShareSheetViewModel.ViewState viewState) {
        this.$invite = guildInvite;
        this.this$0 = widgetGuildInviteShareSheet;
        this.$searchQuery$inlined = str;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteSettings.Companion companion = WidgetGuildInviteSettings.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ActivityResultLauncher<Intent> activityResultLauncherAccess$getGuildInviteSettingsLauncher$p = WidgetGuildInviteShareSheet.access$getGuildInviteSettingsLauncher$p(this.this$0);
        GuildInvite guildInvite = this.$invite;
        companion.launch(contextRequireContext, activityResultLauncherAccess$getGuildInviteSettingsLauncher$p, guildInvite != null ? guildInvite.getChannelId() : null, WidgetGuildInviteShareSheet.access$getViewModel$p(this.this$0).getGuildId(), "Instant Invite Action Sheet");
    }
}
