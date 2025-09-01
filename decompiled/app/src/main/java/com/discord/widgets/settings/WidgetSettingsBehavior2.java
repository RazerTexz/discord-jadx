package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUserSettings;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Action1;

/* compiled from: WidgetSettingsBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "isChecked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "com/discord/widgets/settings/WidgetSettingsBehavior$onViewBound$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsBehavior2<T> implements Action1<Boolean> {
    public final /* synthetic */ StoreUserSettings $userSettings$inlined;

    public WidgetSettingsBehavior2(StoreUserSettings storeUserSettings) {
        this.$userSettings$inlined = storeUserSettings;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings storeUserSettings = this.$userSettings$inlined;
        Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
        storeUserSettings.setIsShiftEnterToSendEnabled(bool.booleanValue());
    }
}
