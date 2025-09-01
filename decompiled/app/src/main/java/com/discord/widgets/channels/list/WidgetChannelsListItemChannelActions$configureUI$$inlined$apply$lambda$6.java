package com.discord.widgets.channels.list;

import android.view.View;
import b.d.b.a.outline;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import kotlin.Metadata;

/* compiled from: WidgetChannelsListItemChannelActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$configureUI$6$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6 implements View.OnClickListener {
    public final /* synthetic */ WidgetChannelsListItemChannelActions.Model $this_configureUI$inlined;

    public WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6(WidgetChannelsListItemChannelActions.Model model) {
        this.$this_configureUI$inlined = model;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelNotificationSettings.Companion.launch$default(WidgetChannelNotificationSettings.INSTANCE, outline.x(view, "it", "it.context"), this.$this_configureUI$inlined.getChannel().getId(), false, 4, null);
    }
}
