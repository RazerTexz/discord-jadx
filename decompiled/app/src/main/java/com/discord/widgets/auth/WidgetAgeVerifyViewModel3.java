package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import com.discord.widgets.auth.WidgetAgeVerifyViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetAgeVerifyViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/user/MeUser;", "me", "", "authed", "Lcom/discord/api/channel/Channel;", "safeChannel", "Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;ZLcom/discord/api/channel/Channel;)Lcom/discord/widgets/auth/WidgetAgeVerifyViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$Companion$observeStores$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel3<T1, T2, T3, R> implements Func3<MeUser, Boolean, Channel, WidgetAgeVerifyViewModel.StoreState> {
    public static final WidgetAgeVerifyViewModel3 INSTANCE = new WidgetAgeVerifyViewModel3();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetAgeVerifyViewModel.StoreState call(MeUser meUser, Boolean bool, Channel channel) {
        return call(meUser, bool.booleanValue(), channel);
    }

    public final WidgetAgeVerifyViewModel.StoreState call(MeUser meUser, boolean z2, Channel channel) {
        Intrinsics3.checkNotNullParameter(meUser, "me");
        return new WidgetAgeVerifyViewModel.StoreState(channel, meUser.getNsfwAllowance(), z2);
    }
}
