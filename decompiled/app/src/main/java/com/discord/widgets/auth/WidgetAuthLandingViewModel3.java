package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreInviteSettings;
import com.discord.widgets.auth.WidgetAuthLandingViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: WidgetAuthLandingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\t0\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/discord/stores/StoreInviteSettings$InviteCode;", "inviteCode", "Lcom/discord/models/domain/ModelInvite;", "invite", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "kotlin.jvm.PlatformType", "guildTemplate", "", "ageGateError", "Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreInviteSettings$InviteCode;Lcom/discord/models/domain/ModelInvite;Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;Ljava/lang/String;)Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel3<T1, T2, T3, T4, R> implements Func4<StoreInviteSettings.InviteCode, ModelInvite, StoreGuildTemplates.GuildTemplateState, String, WidgetAuthLandingViewModel.StoreState> {
    public static final WidgetAuthLandingViewModel3 INSTANCE = new WidgetAuthLandingViewModel3();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetAuthLandingViewModel.StoreState call(StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str) {
        return call2(inviteCode, modelInvite, guildTemplateState, str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetAuthLandingViewModel.StoreState call2(StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str) {
        Intrinsics3.checkNotNullExpressionValue(guildTemplateState, "guildTemplate");
        return new WidgetAuthLandingViewModel.StoreState(inviteCode, modelInvite, guildTemplateState, str);
    }
}
