package com.discord.widgets.settings;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.stores.StoreMediaSettings;
import com.discord.widgets.settings.WidgetSettingsVoice;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetSettingsVoice.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "p1", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLESConfig;", "p2", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$LocalVoiceStatus;", "p3", "Lcom/discord/widgets/settings/WidgetSettingsVoice$Model;", "invoke", "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLESConfig;Lcom/discord/rtcconnection/mediaengine/MediaEngine$LocalVoiceStatus;)Lcom/discord/widgets/settings/WidgetSettingsVoice$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsVoice$Model$Companion$get$2 extends FunctionReferenceImpl implements Function3<StoreMediaSettings.VoiceConfiguration, MediaEngine.OpenSLESConfig, MediaEngine.LocalVoiceStatus, WidgetSettingsVoice.Model> {
    public static final WidgetSettingsVoice$Model$Companion$get$2 INSTANCE = new WidgetSettingsVoice$Model$Companion$get$2();

    public WidgetSettingsVoice$Model$Companion$get$2() {
        super(3, WidgetSettingsVoice.Model.class, "<init>", "<init>(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLESConfig;Lcom/discord/rtcconnection/mediaengine/MediaEngine$LocalVoiceStatus;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetSettingsVoice.Model invoke(StoreMediaSettings.VoiceConfiguration voiceConfiguration, MediaEngine.OpenSLESConfig openSLESConfig, MediaEngine.LocalVoiceStatus localVoiceStatus) {
        return invoke2(voiceConfiguration, openSLESConfig, localVoiceStatus);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsVoice.Model invoke2(StoreMediaSettings.VoiceConfiguration voiceConfiguration, MediaEngine.OpenSLESConfig openSLESConfig, MediaEngine.LocalVoiceStatus localVoiceStatus) {
        Intrinsics3.checkNotNullParameter(voiceConfiguration, "p1");
        Intrinsics3.checkNotNullParameter(openSLESConfig, "p2");
        Intrinsics3.checkNotNullParameter(localVoiceStatus, "p3");
        return new WidgetSettingsVoice.Model(voiceConfiguration, openSLESConfig, localVoiceStatus, null);
    }
}
