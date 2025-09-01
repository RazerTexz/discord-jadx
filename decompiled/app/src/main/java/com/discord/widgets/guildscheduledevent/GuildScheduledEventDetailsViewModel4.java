package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventDetailsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "com/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$endEventClicked$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$endEventClicked$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel4 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function0 $onSuccess$inlined;
    public final /* synthetic */ GuildScheduledEventDetailsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel4(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel, Context context, Function0 function0) {
        super(1);
        this.this$0 = guildScheduledEventDetailsViewModel;
        this.$context$inlined = context;
        this.$onSuccess$inlined = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        Intrinsics3.checkNotNullParameter(unit, "it");
        this.$onSuccess$inlined.invoke();
    }
}
