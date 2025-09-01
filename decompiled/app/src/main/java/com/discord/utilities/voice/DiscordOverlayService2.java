package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: DiscordOverlayService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$StateChange;", "kotlin.jvm.PlatformType", "stateChange", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/rtcconnection/RtcConnection$StateChange;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.voice.DiscordOverlayService$Companion$launchForConnect$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class DiscordOverlayService2<T, R> implements Func1<RtcConnection.StateChange, String> {
    public static final DiscordOverlayService2 INSTANCE = new DiscordOverlayService2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ String call(RtcConnection.StateChange stateChange) {
        return call2(stateChange);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return (!(state instanceof RtcConnection.State.d) || ((RtcConnection.State.d) state).a) ? "com.discord.actions.OVERLAY_OPEN" : "com.discord.actions.OVERLAY_SELECTOR";
    }
}
