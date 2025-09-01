package com.discord.utilities.lazy.subscriptions;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildSubscriptionsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/Function0;", "", "p1", "invoke", "(Lkotlin/jvm/functions/Function0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager$guildMemberSubscriptionsManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager4 extends FunctionReferenceImpl implements Function1<Function0<? extends Unit>, Unit> {
    public GuildSubscriptionsManager4(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(1, guildSubscriptionsManager, GuildSubscriptionsManager.class, "requestFlushUnsubscriptions", "requestFlushUnsubscriptions(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
        invoke2((Function0<Unit>) function0);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "p1");
        GuildSubscriptionsManager.access$requestFlushUnsubscriptions((GuildSubscriptionsManager) this.receiver, function0);
    }
}
