package com.discord.widgets.settings.account;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\b0\b \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u000726\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "kotlin.jvm.PlatformType", "relationships", "Lrx/Observable;", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersViewModel2<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends WidgetSettingsBlockedUsersViewModel.StoreState>> {
    public final /* synthetic */ StoreUser $storeUser;

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "users", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends User>, WidgetSettingsBlockedUsersViewModel.StoreState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetSettingsBlockedUsersViewModel.StoreState call(Map<Long, ? extends User> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetSettingsBlockedUsersViewModel.StoreState call2(Map<Long, ? extends User> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "users");
            return new WidgetSettingsBlockedUsersViewModel.StoreState(map);
        }
    }

    public WidgetSettingsBlockedUsersViewModel2(StoreUser storeUser) {
        this.$storeUser = storeUser;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetSettingsBlockedUsersViewModel.StoreState> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetSettingsBlockedUsersViewModel.StoreState> call2(Map<Long, Integer> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "relationships");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() == 2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return this.$storeUser.observeUsers(linkedHashMap.keySet()).G(AnonymousClass1.INSTANCE);
    }
}
