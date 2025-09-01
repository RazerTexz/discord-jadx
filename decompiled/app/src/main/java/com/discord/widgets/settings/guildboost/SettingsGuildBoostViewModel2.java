package com.discord.widgets.settings.guildboost;

import androidx.core.app.NotificationCompat;
import com.discord.api.premium.PremiumTier;
import com.discord.models.user.MeUser;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: SettingsGuildBoostViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/api/premium/PremiumTier;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Lcom/discord/api/premium/PremiumTier;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsGuildBoostViewModel2<T, R> implements Func1<MeUser, PremiumTier> {
    public static final SettingsGuildBoostViewModel2 INSTANCE = new SettingsGuildBoostViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ PremiumTier call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final PremiumTier call2(MeUser meUser) {
        return meUser.getPremiumTier();
    }
}
