package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel;
import kotlin.Metadata;

/* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet2 implements View.OnClickListener {
    public final /* synthetic */ boolean $canManageEvent$inlined;
    public final /* synthetic */ GuildScheduledEventUtilities2 $eventTiming$inlined;
    public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet2(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet, boolean z2, GuildScheduledEventUtilities2 guildScheduledEventUtilities2, GuildScheduledEventDetailsViewModel.ViewState viewState) {
        this.this$0 = widgetGuildScheduledEventDetailsExtrasBottomSheet;
        this.$canManageEvent$inlined = z2;
        this.$eventTiming$inlined = guildScheduledEventUtilities2;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$getViewModel$p(this.this$0).onRsvpButtonClicked();
    }
}
