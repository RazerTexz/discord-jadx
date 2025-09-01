package com.discord.widgets.servers.member_verification;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildMemberVerificationForm;
import com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func6;

/* compiled from: WidgetMemberVerificationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0014\u001a\n \u0001*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052.\u0010\u000b\u001a*\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n \u0001*\u0014\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00070\u00072.\u0010\u000e\u001a*\u0012\b\u0012\u00060\bj\u0002`\f\u0012\u0004\u0012\u00020\r \u0001*\u0014\u0012\b\u0012\u00060\bj\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u00070\u00072\u000e\u0010\u0010\u001a\n \u0001*\u0004\u0018\u00010\u000f0\u000fH\n¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "memberVerificationFormData", "", "", "Lcom/discord/primitives/ChannelId;", "", "channels", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "", "allowAnimatedEmojis", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMemberVerificationViewModel2<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, Guild, StoreGuildMemberVerificationForm.MemberVerificationFormData, Map<Long, ? extends String>, Map<Long, ? extends GuildRole>, Boolean, WidgetMemberVerificationViewModel.StoreState> {
    public final /* synthetic */ Guild $inviteGuild;

    public WidgetMemberVerificationViewModel2(Guild guild) {
        this.$inviteGuild = guild;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetMemberVerificationViewModel.StoreState call(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, ? extends String> map, Map<Long, ? extends GuildRole> map2, Boolean bool) {
        return call2(meUser, guild, memberVerificationFormData, (Map<Long, String>) map, (Map<Long, GuildRole>) map2, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetMemberVerificationViewModel.StoreState call2(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, String> map, Map<Long, GuildRole> map2, Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        if (guild == null) {
            guild = this.$inviteGuild;
        }
        Intrinsics3.checkNotNullExpressionValue(map, "channels");
        Intrinsics3.checkNotNullExpressionValue(map2, "roles");
        Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
        return new WidgetMemberVerificationViewModel.StoreState(meUser, guild, memberVerificationFormData, map, map2, bool.booleanValue());
    }
}
