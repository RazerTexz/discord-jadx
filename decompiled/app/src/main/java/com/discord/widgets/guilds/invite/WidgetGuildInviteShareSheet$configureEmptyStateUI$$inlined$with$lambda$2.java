package com.discord.widgets.guilds.invite;

import android.content.res.Resources;
import android.view.View;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import kotlin.Metadata;

/* compiled from: WidgetGuildInviteShareSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/guilds/invite/WidgetGuildInviteShareSheet$configureEmptyStateUI$2$3", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$2 implements View.OnClickListener {
    public final /* synthetic */ GuildInvite $invite;
    public final /* synthetic */ GuildInviteShareSheetViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    public WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$2(GuildInvite guildInvite, WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, GuildInviteShareSheetViewModel.ViewState viewState) {
        this.$invite = guildInvite;
        this.this$0 = widgetGuildInviteShareSheet;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        if (this.$invite != null) {
            GuildInviteUiHelper.shareLinkClick(this.this$0.getContext(), this.$invite, this.$viewState$inlined.getChannel());
        }
    }
}
