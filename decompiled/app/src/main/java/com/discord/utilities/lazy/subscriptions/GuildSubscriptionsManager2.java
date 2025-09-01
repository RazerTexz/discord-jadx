package com.discord.utilities.lazy.subscriptions;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;

/* compiled from: GuildSubscriptionsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b2\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u001c\u0010\u0007\u001a\u0018\u0012\b\u0012\u00060\u0000j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "p1", "", "Lcom/discord/primitives/ChannelId;", "", "Lkotlin/ranges/IntRange;", "p2", "", "invoke", "(JLjava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager$guildChannelSubscriptionsManager$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager2 extends FunctionReferenceImpl implements Function2<Long, Map<Long, ? extends List<? extends Ranges2>>, Unit> {
    public GuildSubscriptionsManager2(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(2, guildSubscriptionsManager, GuildSubscriptionsManager.class, "handleChannelSubscriptionsChange", "handleChannelSubscriptionsChange(JLjava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Map<Long, ? extends List<? extends Ranges2>> map) {
        invoke(l.longValue(), (Map<Long, ? extends List<Ranges2>>) map);
        return Unit.a;
    }

    public final void invoke(long j, Map<Long, ? extends List<Ranges2>> map) {
        Intrinsics3.checkNotNullParameter(map, "p2");
        GuildSubscriptionsManager.access$handleChannelSubscriptionsChange((GuildSubscriptionsManager) this.receiver, j, map);
    }
}
