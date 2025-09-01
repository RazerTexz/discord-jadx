package com.discord.widgets.guildscheduledevent;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;
import kotlin.Metadata;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/widget/DatePicker;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "year", "month", "dayOfMonth", "", "onDateSet", "(Landroid/widget/DatePicker;III)V", "com/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventSettings$onViewBound$8$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1 implements DatePickerDialog.OnDateSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings.AnonymousClass8 this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1(WidgetGuildScheduledEventSettings.AnonymousClass8 anonymousClass8) {
        this.this$0 = anonymousClass8;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        GuildScheduledEventSettingsViewModel.DateError endDate = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).setEndDate(i, i2, i3);
        if (endDate != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, endDate);
        }
    }
}
