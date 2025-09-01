package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: SettingsGiftingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$Companion$observeStores$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsGiftingViewModel3<T, R> implements Func1<MeUser, Boolean> {
    public static final SettingsGiftingViewModel3 INSTANCE = new SettingsGiftingViewModel3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        UserUtils userUtils = UserUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUser, "it");
        return Boolean.valueOf(userUtils.isPremium(meUser));
    }
}
