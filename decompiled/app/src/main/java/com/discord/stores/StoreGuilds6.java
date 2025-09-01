package com.discord.stores;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreGuilds.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "userIds", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuilds$Actions$requestRoleMembers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuilds6 extends Lambda implements Function1<List<? extends Long>, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGatewayConnection $storeGatewayConnection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuilds6(StoreGatewayConnection storeGatewayConnection, long j) {
        super(1);
        this.$storeGatewayConnection = storeGatewayConnection;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
        invoke2((List<Long>) list);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "userIds");
        StoreGatewayConnection.requestGuildMembers$default(this.$storeGatewayConnection, this.$guildId, null, list, null, 10, null);
    }
}
