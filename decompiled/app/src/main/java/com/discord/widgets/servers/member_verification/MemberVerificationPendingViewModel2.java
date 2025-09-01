package com.discord.widgets.servers.member_verification;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildMemberVerificationForm;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: MemberVerificationPendingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "memberVerificationForm", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "guildJoinRequest", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;Lcom/discord/models/guild/Guild;Lcom/discord/api/guildjoinrequest/GuildJoinRequest;)Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel2<T1, T2, T3, R> implements Func3<StoreGuildMemberVerificationForm.MemberVerificationFormData, Guild, GuildJoinRequest, MemberVerificationPendingViewModel.StoreState> {
    public static final MemberVerificationPendingViewModel2 INSTANCE = new MemberVerificationPendingViewModel2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ MemberVerificationPendingViewModel.StoreState call(StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Guild guild, GuildJoinRequest guildJoinRequest) {
        return call2(memberVerificationFormData, guild, guildJoinRequest);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final MemberVerificationPendingViewModel.StoreState call2(StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Guild guild, GuildJoinRequest guildJoinRequest) {
        ApplicationStatus applicationStatus;
        ModelMemberVerificationForm form;
        boolean z2 = (memberVerificationFormData == null || (form = memberVerificationFormData.getForm()) == null || !form.isFormOutdated()) ? false : true;
        boolean zHasFeature = guild != null ? guild.hasFeature(GuildFeature.PREVIEW_ENABLED) : false;
        if (guildJoinRequest == null || (applicationStatus = guildJoinRequest.getApplicationStatus()) == null) {
            applicationStatus = ApplicationStatus.STARTED;
        }
        return new MemberVerificationPendingViewModel.StoreState(z2, zHasFeature, applicationStatus, guildJoinRequest != null ? guildJoinRequest.getRejectionReason() : null);
    }
}
