package com.discord.widgets.voice.sheet;

import android.view.View;
import b.d.b.a.outline;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet;
import kotlin.Metadata;

/* compiled from: WidgetVoiceSettingsBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/voice/sheet/WidgetVoiceSettingsBottomSheet$configureUI$6$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet2 implements View.OnClickListener {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    public WidgetVoiceSettingsBottomSheet2(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet, WidgetVoiceSettingsBottomSheet.ViewState viewState) {
        this.this$0 = widgetVoiceSettingsBottomSheet;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelNotificationSettings.Companion.launch$default(WidgetChannelNotificationSettings.INSTANCE, outline.x(view, "it", "it.context"), WidgetVoiceSettingsBottomSheet.access$getChannelId$p(this.this$0), false, 4, null);
    }
}
