package com.discord.widgets.chat.managereactions;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import d0.t.Maps6;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ManageReactionsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$guildMembersObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsModel3 extends Lambda implements Function0<Map<Long, ? extends GuildMember>> {
    public final /* synthetic */ ManageReactionsModel2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsModel3(ManageReactionsModel2 manageReactionsModel2) {
        super(0);
        this.this$0 = manageReactionsModel2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends GuildMember> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends GuildMember> invoke2() {
        Channel channel = ManageReactionsModel2.access$getStoreChannels$p(this.this$0).getChannel(this.this$0.getChannelId());
        Map<Long, GuildMember> map = ManageReactionsModel2.access$getStoreGuilds$p(this.this$0).getMembers().get(channel != null ? Long.valueOf(channel.getGuildId()) : null);
        return map != null ? map : Maps6.emptyMap();
    }
}
