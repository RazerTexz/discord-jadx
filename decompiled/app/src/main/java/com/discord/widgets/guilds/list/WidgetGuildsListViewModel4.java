package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetGuildsListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel4<T, R> implements Func1<MeUser, Boolean> {
    public final /* synthetic */ Clock $clock;

    public WidgetGuildsListViewModel4(Clock clock) {
        this.$clock = clock;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        UserUtils userUtils = UserUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        return Boolean.valueOf(userUtils.getAgeMs(meUser, this.$clock) < 1209600000);
    }
}
