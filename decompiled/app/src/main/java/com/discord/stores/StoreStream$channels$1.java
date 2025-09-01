package com.discord.stores;

import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: StoreStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\b\u0012\u00060\u0000j\u0002`\u00060\u00040\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", "invoke", "(J)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreStream$channels$1 extends Lambda implements Function1<Long, Observable<Map<Long, ? extends Long>>> {
    public final /* synthetic */ StoreStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$channels$1(StoreStream storeStream) {
        super(1);
        this.this$0 = storeStream;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Observable<Map<Long, ? extends Long>> invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Observable<Map<Long, Long>> invoke(long j) {
        return this.this$0.getPermissions().observeChannelPermissionsForGuild(j);
    }
}
