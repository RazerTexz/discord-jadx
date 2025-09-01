package com.discord.widgets.user.search;

import com.discord.models.member.GuildMember;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u000e\u0012\b\u0012\u00060\u0000j\u0002`\u0004\u0018\u00010\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "it", "", "Lcom/discord/primitives/UserId;", "invoke", "(J)Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getDefaultUserSearch$smallGuildUserIds$1 extends Lambda implements Function1<Long, Set<? extends Long>> {
    public final /* synthetic */ WidgetGlobalSearchModel.UsersContext $usersContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$getDefaultUserSearch$smallGuildUserIds$1(WidgetGlobalSearchModel.UsersContext usersContext) {
        super(1);
        this.$usersContext = usersContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Set<? extends Long> invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Set<Long> invoke(long j) {
        Map<Long, GuildMember> map = this.$usersContext.getMembers().get(Long.valueOf(j));
        if (map != null) {
            return map.keySet();
        }
        return null;
    }
}
