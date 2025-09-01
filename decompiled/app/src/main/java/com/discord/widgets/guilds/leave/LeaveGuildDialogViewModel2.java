package com.discord.widgets.guilds.leave;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: LeaveGuildDialogViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "kotlin.jvm.PlatformType", "isLurking", "Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Ljava/lang/Boolean;)Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class LeaveGuildDialogViewModel2<T1, T2, R> implements Func2<Guild, Boolean, LeaveGuildDialogViewModel.StoreState> {
    public static final LeaveGuildDialogViewModel2 INSTANCE = new LeaveGuildDialogViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ LeaveGuildDialogViewModel.StoreState call(Guild guild, Boolean bool) {
        return call2(guild, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final LeaveGuildDialogViewModel.StoreState call2(Guild guild, Boolean bool) {
        if (guild == null) {
            return LeaveGuildDialogViewModel.StoreState.Invalid.INSTANCE;
        }
        Intrinsics3.checkNotNullExpressionValue(bool, "isLurking");
        return new LeaveGuildDialogViewModel.StoreState.Valid(guild, bool.booleanValue());
    }
}
