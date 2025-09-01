package com.discord.stores;

import com.discord.models.presence.Presence;
import com.discord.utilities.collections.SnowflakePartitionMap;
import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "p1", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "invoke", "(J)Lcom/discord/models/presence/Presence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$3 extends FunctionReferenceImpl implements Function1<Long, Presence> {
    public StoreStream$lazyChannelMembersStore$3(SnowflakePartitionMap.CopiablePartitionMap copiablePartitionMap) {
        super(1, copiablePartitionMap, SnowflakePartitionMap.CopiablePartitionMap.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Presence invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Presence invoke(long j) {
        return (Presence) ((SnowflakePartitionMap.CopiablePartitionMap) this.receiver).get(Long.valueOf(j));
    }
}
