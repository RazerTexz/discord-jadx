package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.WidgetSettingsAppearance;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetSettingsAppearance.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/stores/StoreUserSettingsSystem$Settings;", "settings", "", "isPureEvilVisible", "Lcom/discord/widgets/settings/WidgetSettingsAppearance$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/stores/StoreUserSettingsSystem$Settings;Ljava/lang/Boolean;)Lcom/discord/widgets/settings/WidgetSettingsAppearance$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAppearance2<T1, T2, T3, R> implements Func3<MeUser, StoreUserSettingsSystem.Settings, Boolean, WidgetSettingsAppearance.Model> {
    public static final WidgetSettingsAppearance2 INSTANCE = new WidgetSettingsAppearance2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetSettingsAppearance.Model call(MeUser meUser, StoreUserSettingsSystem.Settings settings, Boolean bool) {
        return call2(meUser, settings, bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetSettingsAppearance.Model call2(MeUser meUser, StoreUserSettingsSystem.Settings settings, Boolean bool) {
        boolean z2;
        String theme = settings.getTheme();
        Intrinsics3.checkNotNullExpressionValue(bool, "isPureEvilVisible");
        if (!bool.booleanValue()) {
            UserUtils userUtils = UserUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            z2 = userUtils.isStaff(meUser);
        }
        int fontScale = settings.getFontScale();
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        return new WidgetSettingsAppearance.Model(theme, z2, fontScale, meUser);
    }
}
