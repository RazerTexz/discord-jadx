package com.discord.widgets.chat.list.sheet;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetApplicationCommandBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel;", "invoke", "()Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet4 extends Lambda implements Function0<WidgetApplicationCommandBottomSheetViewModel> {
    public final /* synthetic */ WidgetApplicationCommandBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheet4(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet) {
        super(0);
        this.this$0 = widgetApplicationCommandBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetApplicationCommandBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetApplicationCommandBottomSheetViewModel invoke() {
        Bundle arguments;
        return new WidgetApplicationCommandBottomSheetViewModel(WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_INTERACTION_ID"), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_MESSAGE_ID"), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), (!WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).containsKey("com.discord.intent.extra.EXTRA_GUILD_ID") || (arguments = this.this$0.getArguments()) == null) ? null : Long.valueOf(arguments.getLong("com.discord.intent.extra.EXTRA_GUILD_ID")), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_USER_ID"), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_APPLICATION_ID"), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString(WidgetApplicationCommandBottomSheet.ARG_MESSAGE_NONCE), null, 128, null);
    }
}
