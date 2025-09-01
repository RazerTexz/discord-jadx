package com.discord.widgets.guildscheduledevent;

import androidx.fragment.app.FragmentActivity;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "", "eventCreated", "", "invoke", "(Ljava/lang/Long;JZ)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$previewLauncher$1 extends Lambda implements Function3<Long, Long, Boolean, Unit> {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventSettings$previewLauncher$1(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(3);
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Boolean bool) {
        invoke(l, l2.longValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Long l, long j, boolean z2) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.setResult(-1);
            if (z2) {
                WidgetGuildScheduledEventCreateSuccess.Companion companion = WidgetGuildScheduledEventCreateSuccess.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(activity, "this");
                companion.launch(activity, l, WidgetGuildScheduledEventSettings.access$getGuildId$p(this.this$0), j);
            }
            activity.finish();
        }
    }
}
