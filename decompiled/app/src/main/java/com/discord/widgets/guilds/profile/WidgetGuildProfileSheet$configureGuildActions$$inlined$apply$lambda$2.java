package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.widgets.channels.WidgetCreateChannel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildProfileSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "com/discord/widgets/guilds/profile/WidgetGuildProfileSheet$configureGuildActions$3$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ boolean $canManageChannels$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ TextView $this_apply;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$2(TextView textView, WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, long j) {
        super(1);
        this.$this_apply = textView;
        this.this$0 = widgetGuildProfileSheet;
        this.$canManageChannels$inlined = z2;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetCreateChannel.Companion companion = WidgetCreateChannel.INSTANCE;
        Context context = this.$this_apply.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        WidgetCreateChannel.Companion.show$default(companion, context, this.$guildId$inlined, 0, null, 12, null);
    }
}
