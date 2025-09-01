package com.discord.stores;

import com.discord.stores.StoreGuildRoleMemberCounts;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreGuildRoleMemberCounts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/discord/stores/StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1$$special$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuildRoleMemberCounts2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Map $it;
    public final /* synthetic */ StoreGuildRoleMemberCounts.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleMemberCounts2(Map map, StoreGuildRoleMemberCounts.AnonymousClass1 anonymousClass1) {
        super(0);
        this.$it = map;
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildRoleMemberCounts.access$getGuildRoleMemberCounts$p(StoreGuildRoleMemberCounts.this).put(Long.valueOf(this.this$0.$guildId), this.$it);
        StoreGuildRoleMemberCounts.this.markChanged();
    }
}
