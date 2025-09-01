package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetVoiceCallInline.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "voiceConnected", "Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;)Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceCallInline2<T, R> implements Func1<WidgetVoiceCallInline.Model.VoiceConnected, WidgetVoiceCallInline.Model> {
    public static final WidgetVoiceCallInline2 INSTANCE = new WidgetVoiceCallInline2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetVoiceCallInline.Model call(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
        return call2(voiceConnected);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetVoiceCallInline.Model call2(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
        return new WidgetVoiceCallInline.Model(voiceConnected);
    }
}
