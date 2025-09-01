package com.discord.widgets.guildscheduledevent;

import android.os.Bundle;
import b.d.b.a.outline;
import com.discord.app.AppBottomSheet;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ArgUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcelable;", "P", "invoke", "()Landroid/os/Parcelable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet$$special$$inlined$args$1 extends Lambda implements Function0<WidgetGuildScheduledEventDetailsBottomSheet2> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppBottomSheet $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventDetailsExtrasBottomSheet$$special$$inlined$args$1(AppBottomSheet appBottomSheet, String str) {
        super(0);
        this.$this_args = appBottomSheet;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildScheduledEventDetailsBottomSheet2 invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2 = (WidgetGuildScheduledEventDetailsBottomSheet2) (obj instanceof WidgetGuildScheduledEventDetailsBottomSheet2 ? obj : null);
        if (widgetGuildScheduledEventDetailsBottomSheet2 != null) {
            return widgetGuildScheduledEventDetailsBottomSheet2;
        }
        StringBuilder sbU = outline.U("Missing args for class type ");
        outline.l0(WidgetGuildScheduledEventDetailsBottomSheet2.class, sbU, " + key ");
        throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2 invoke() {
        return invoke();
    }
}
