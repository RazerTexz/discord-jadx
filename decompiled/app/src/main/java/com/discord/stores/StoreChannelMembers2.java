package com.discord.stores;

import com.discord.utilities.lazy.memberlist.MemberListRow;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreChannelMembers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "invoke", "(J)Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "com/discord/stores/StoreChannelMembers$handleGuildRoleCreateOrUpdate$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreChannelMembers$handleGuildRoleCreateOrUpdate$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreChannelMembers2 extends Lambda implements Function1<Long, MemberListRow> {
    public final /* synthetic */ boolean $allowOwnerIndicator$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ StoreChannelMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelMembers2(StoreChannelMembers storeChannelMembers, long j, boolean z2) {
        super(1);
        this.this$0 = storeChannelMembers;
        this.$guildId$inlined = j;
        this.$allowOwnerIndicator$inlined = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MemberListRow invoke(Long l) {
        return invoke(l.longValue());
    }

    public final MemberListRow invoke(long j) {
        return StoreChannelMembers.access$makeRowMember(this.this$0, this.$guildId$inlined, j, this.$allowOwnerIndicator$inlined);
    }
}
