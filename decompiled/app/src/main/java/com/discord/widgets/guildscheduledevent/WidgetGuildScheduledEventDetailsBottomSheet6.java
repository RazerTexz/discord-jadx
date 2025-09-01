package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser;", "invoke", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$descriptionParser$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet6 extends Lambda implements Function0<GuildScheduledEventDescriptionParser> {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventDetailsBottomSheet6(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventDescriptionParser invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDescriptionParser invoke() {
        LinkifiedTextView linkifiedTextView = this.this$0.getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventDetailsDescText");
        return new GuildScheduledEventDescriptionParser(linkifiedTextView);
    }
}
