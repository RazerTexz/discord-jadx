package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetSettingsVoice.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "isListeningForSensitivity", "Lrx/Observable;", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$LocalVoiceStatus;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsVoice$Model$Companion$get$1<T, R> implements Func1<Boolean, Observable<? extends MediaEngine.LocalVoiceStatus>> {
    public static final WidgetSettingsVoice$Model$Companion$get$1 INSTANCE = new WidgetSettingsVoice$Model$Companion$get$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends MediaEngine.LocalVoiceStatus> call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends MediaEngine.LocalVoiceStatus> call2(Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(bool, "isListeningForSensitivity");
        return bool.booleanValue() ? StoreStream.INSTANCE.getMediaEngine().getLocalVoiceStatus() : new ScalarSynchronousObservable(WidgetSettingsVoice.access$getLOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED$cp());
    }
}
