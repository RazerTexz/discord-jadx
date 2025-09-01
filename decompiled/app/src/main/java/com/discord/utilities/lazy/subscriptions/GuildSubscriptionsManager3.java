package com.discord.utilities.lazy.subscriptions;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: GuildSubscriptionsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b2\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "p1", "", "Lcom/discord/primitives/UserId;", "p2", "", "p3", "", "invoke", "(JLjava/util/Set;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager$guildMemberSubscriptionsManager$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager3 extends FunctionReferenceImpl implements Function3<Long, Set<? extends Long>, Boolean, Unit> {
    public GuildSubscriptionsManager3(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(3, guildSubscriptionsManager, GuildSubscriptionsManager.class, "handleMemberSubscriptionsChange", "handleMemberSubscriptionsChange(JLjava/util/Set;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Set<? extends Long> set, Boolean bool) {
        invoke(l.longValue(), (Set<Long>) set, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(long j, Set<Long> set, boolean z2) {
        Intrinsics3.checkNotNullParameter(set, "p2");
        GuildSubscriptionsManager.access$handleMemberSubscriptionsChange((GuildSubscriptionsManager) this.receiver, j, set, z2);
    }
}
