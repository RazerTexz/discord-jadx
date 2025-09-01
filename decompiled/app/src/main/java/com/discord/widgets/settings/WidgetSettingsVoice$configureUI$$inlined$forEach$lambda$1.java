package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.views.CheckedSetting;
import kotlin.Metadata;
import rx.functions.Action1;

/* compiled from: WidgetSettingsVoice.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)V", "com/discord/widgets/settings/WidgetSettingsVoice$configureUI$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsVoice$configureUI$$inlined$forEach$lambda$1<T> implements Action1<Boolean> {
    public final /* synthetic */ CheckedSetting $button;
    public final /* synthetic */ WidgetSettingsVoice this$0;

    public WidgetSettingsVoice$configureUI$$inlined$forEach$lambda$1(CheckedSetting checkedSetting, WidgetSettingsVoice widgetSettingsVoice) {
        this.$button = checkedSetting;
        this.this$0 = widgetSettingsVoice;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetSettingsVoice.access$getOpenSLESConfigRadioManager$p(this.this$0).a(this.$button);
        WidgetSettingsVoice.access$onOpenSLESConfigChanged(this.this$0);
    }
}
