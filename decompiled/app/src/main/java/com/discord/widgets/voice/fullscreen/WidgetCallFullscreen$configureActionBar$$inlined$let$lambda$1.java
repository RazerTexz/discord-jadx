package com.discord.widgets.voice.fullscreen;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/voice/fullscreen/WidgetCallFullscreen$$special$$inlined$apply$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ GuildScheduledEvent $activeEvent$inlined;
    public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid $viewState$inlined;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$1(GuildScheduledEvent guildScheduledEvent, WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel.ViewState.Valid valid) {
        this.$activeEvent$inlined = guildScheduledEvent;
        this.this$0 = widgetCallFullscreen;
        this.$viewState$inlined = valid;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForGuild(parentFragmentManager, this.$activeEvent$inlined.getId());
    }
}
