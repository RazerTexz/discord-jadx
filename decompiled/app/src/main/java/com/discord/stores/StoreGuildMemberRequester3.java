package com.discord.stores;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreGuildMemberRequester.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00040\u0003¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "p1", "", "Lcom/discord/primitives/UserId;", "p2", "", "invoke", "(JLjava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuildMemberRequester$requestManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreGuildMemberRequester3 extends FunctionReferenceImpl implements Function2<Long, List<? extends Long>, Unit> {
    public StoreGuildMemberRequester3(StoreGuildMemberRequester storeGuildMemberRequester) {
        super(2, storeGuildMemberRequester, StoreGuildMemberRequester.class, "sendRequests", "sendRequests(JLjava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.a;
    }

    public final void invoke(long j, List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "p2");
        StoreGuildMemberRequester.access$sendRequests((StoreGuildMemberRequester) this.receiver, j, list);
    }
}
