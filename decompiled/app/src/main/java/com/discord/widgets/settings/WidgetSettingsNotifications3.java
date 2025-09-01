package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreNotifications;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Action1;

/* compiled from: WidgetSettingsNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isChecked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBound$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsNotifications3<T> implements Action1<Boolean> {
    public final /* synthetic */ StoreNotifications $this_apply;

    public WidgetSettingsNotifications3(StoreNotifications storeNotifications) {
        this.$this_apply = storeNotifications;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreNotifications storeNotifications = this.$this_apply;
        Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
        storeNotifications.setEnabled(bool.booleanValue());
    }
}
