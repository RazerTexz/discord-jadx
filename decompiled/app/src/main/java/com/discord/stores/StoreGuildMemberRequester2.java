package com.discord.stores;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: StoreGuildMemberRequester.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "p1", "Lcom/discord/primitives/UserId;", "p2", "", "invoke", "(JJ)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuildMemberRequester$requestManager$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreGuildMemberRequester2 extends FunctionReferenceImpl implements Function2<Long, Long, Boolean> {
    public StoreGuildMemberRequester2(StoreGuildMemberRequester storeGuildMemberRequester) {
        super(2, storeGuildMemberRequester, StoreGuildMemberRequester.class, "guildMemberExists", "guildMemberExists(JJ)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Long l, Long l2) {
        return Boolean.valueOf(invoke(l.longValue(), l2.longValue()));
    }

    public final boolean invoke(long j, long j2) {
        return StoreGuildMemberRequester.access$guildMemberExists((StoreGuildMemberRequester) this.receiver, j, j2);
    }
}
