package com.discord.widgets.settings;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.CheckedSetting;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* compiled from: WidgetSettingsPrivacy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "checked", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "com/discord/widgets/settings/WidgetSettingsPrivacy$onViewBound$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onViewBound$$inlined$apply$lambda$1<T> implements Action1<Boolean> {
    public final /* synthetic */ CheckedSetting $this_apply;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$onViewBound$$inlined$apply$lambda$1(CheckedSetting checkedSetting, WidgetSettingsPrivacy widgetSettingsPrivacy) {
        this.$this_apply = checkedSetting;
        this.this$0 = widgetSettingsPrivacy;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsPrivacy.access$getUserSettings$p(this.this$0);
        Intrinsics3.checkNotNullExpressionValue(bool, "checked");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(storeUserSettingsAccess$getUserSettings$p.setIsAccessibilityDetectionAllowed(bool.booleanValue()), false, 1, null), this.$this_apply.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetSettingsPrivacy$onViewBound$1$1$1.INSTANCE, 62, (Object) null);
    }
}
