package com.discord.stores;

import com.discord.utilities.lazy.subscriptions.GuildSubscriptions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreGuildSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/utilities/lazy/subscriptions/GuildSubscriptions;", "subscriptions", "", "invoke", "(JLcom/discord/utilities/lazy/subscriptions/GuildSubscriptions;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuildSubscriptions$subscriptionsManager$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuildSubscriptions3 extends Lambda implements Function2<Long, GuildSubscriptions, Unit> {
    public final /* synthetic */ StoreGuildSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildSubscriptions3(StoreGuildSubscriptions storeGuildSubscriptions) {
        super(2);
        this.this$0 = storeGuildSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, GuildSubscriptions guildSubscriptions) {
        invoke(l.longValue(), guildSubscriptions);
        return Unit.a;
    }

    public final void invoke(long j, GuildSubscriptions guildSubscriptions) {
        Intrinsics3.checkNotNullParameter(guildSubscriptions, "subscriptions");
        StoreGuildSubscriptions.access$getStoreStream$p(this.this$0).getGatewaySocket().updateGuildSubscriptions(j, guildSubscriptions);
    }
}
