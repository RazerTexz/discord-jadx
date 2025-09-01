package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.widgets.user.WidgetUserStatusSheetViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetUserStatusSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "kotlin.jvm.PlatformType", "localPresence", "Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/presence/Presence;)Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetUserStatusSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserStatusSheetViewModel2<T, R> implements Func1<Presence, WidgetUserStatusSheetViewModel.StoreState> {
    public static final WidgetUserStatusSheetViewModel2 INSTANCE = new WidgetUserStatusSheetViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetUserStatusSheetViewModel.StoreState call(Presence presence) {
        return call2(presence);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetUserStatusSheetViewModel.StoreState call2(Presence presence) {
        PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(presence, "localPresence");
        return new WidgetUserStatusSheetViewModel.StoreState(presenceUtils.getCustomStatusActivity(presence));
    }
}
