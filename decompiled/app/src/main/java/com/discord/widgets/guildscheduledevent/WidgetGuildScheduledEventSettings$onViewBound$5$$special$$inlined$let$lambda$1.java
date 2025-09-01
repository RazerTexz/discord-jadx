package com.discord.widgets.guildscheduledevent;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;
import kotlin.Metadata;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\n\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/widget/TimePicker;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "hourOfDay", "minute", "", "onTimeSet", "(Landroid/widget/TimePicker;II)V", "com/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventSettings$onViewBound$5$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$5$$special$$inlined$let$lambda$1 implements TimePickerDialog.OnTimeSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings.AnonymousClass5 this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$5$$special$$inlined$let$lambda$1(WidgetGuildScheduledEventSettings.AnonymousClass5 anonymousClass5) {
        this.this$0 = anonymousClass5;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        GuildScheduledEventSettingsViewModel.DateError startTime = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).setStartTime(i, i2);
        if (startTime != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, startTime);
        }
    }
}
