package com.discord.utilities.search.validation;

import b.d.b.a.outline;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.search.validation.SearchData;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SearchData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "recipient", "", "invoke", "(Lcom/discord/models/user/User;)V", "processRecipient"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.search.validation.SearchData$Builder$buildForChannel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SearchData2 extends Lambda implements Function1<User, Unit> {
    public final /* synthetic */ Map $guildMembers;
    public final /* synthetic */ HashMap $usernameAndDiscriminatorIndex;
    public final /* synthetic */ HashMap $users;
    public final /* synthetic */ SearchData.Builder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchData2(SearchData.Builder builder, HashMap map, Map map2, HashMap map3) {
        super(1);
        this.this$0 = builder;
        this.$users = map;
        this.$guildMembers = map2;
        this.$usernameAndDiscriminatorIndex = map3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "recipient");
        this.$users.put(Long.valueOf(user.getId()), new UserGuildMember(user, (GuildMember) outline.f(user, this.$guildMembers)));
        this.$usernameAndDiscriminatorIndex.put(SearchData.Builder.access$getUsernameWithDiscrim(this.this$0, user), Long.valueOf(user.getId()));
    }
}
