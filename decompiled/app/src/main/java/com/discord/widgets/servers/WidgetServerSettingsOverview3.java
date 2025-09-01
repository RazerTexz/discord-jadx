package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import rx.functions.Action1;

/* compiled from: WidgetServerSettingsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "com/discord/widgets/servers/WidgetServerSettingsOverview$configureRadios$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$configureRadios$$inlined$forEachIndexed$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsOverview3<T> implements Action1<Boolean> {
    public final /* synthetic */ int $activeRadioIndex$inlined;
    public final /* synthetic */ int $index;
    public final /* synthetic */ boolean $isAboveNotifyAllSize$inlined;
    public final /* synthetic */ int $stateId$inlined;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview3(int i, WidgetServerSettingsOverview widgetServerSettingsOverview, int i2, boolean z2, int i3) {
        this.$index = i;
        this.this$0 = widgetServerSettingsOverview;
        this.$activeRadioIndex$inlined = i2;
        this.$isAboveNotifyAllSize$inlined = z2;
        this.$stateId$inlined = i3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetServerSettingsOverview.access$configureRadios(this.this$0, this.$stateId$inlined, this.$index, this.$isAboveNotifyAllSize$inlined, true);
    }
}
