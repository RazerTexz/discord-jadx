package com.discord.widgets.servers.member_verification;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: MemberVerificationSuccessViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "guildJoinRequest", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/widgets/servers/member_verification/MemberVerificationSuccessViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/guildjoinrequest/GuildJoinRequest;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/servers/member_verification/MemberVerificationSuccessViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MemberVerificationSuccessViewModel2<T1, T2, R> implements Func2<GuildJoinRequest, Guild, MemberVerificationSuccessViewModel.StoreState> {
    public static final MemberVerificationSuccessViewModel2 INSTANCE = new MemberVerificationSuccessViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ MemberVerificationSuccessViewModel.StoreState call(GuildJoinRequest guildJoinRequest, Guild guild) {
        return call2(guildJoinRequest, guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final MemberVerificationSuccessViewModel.StoreState call2(GuildJoinRequest guildJoinRequest, Guild guild) {
        return new MemberVerificationSuccessViewModel.StoreState(guildJoinRequest != null ? guildJoinRequest.getLastSeen() : null, guild != null ? guild.getName() : null);
    }
}
