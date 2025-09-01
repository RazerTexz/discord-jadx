package com.discord.rtcconnection.enums;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AudioManagerBroadcastAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/rtcconnection/enums/AudioManagerBroadcastAction;", "", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "AudioBecomingNoisy", "HeadsetPlug", "ScoAudioStateUpdated", "MicrophoneMuteChanged", "SpeakerphoneStateChanged", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum AudioManagerBroadcastAction {
    AudioBecomingNoisy("android.media.AUDIO_BECOMING_NOISY"),
    HeadsetPlug("android.intent.action.HEADSET_PLUG"),
    ScoAudioStateUpdated("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"),
    MicrophoneMuteChanged("android.media.action.MICROPHONE_MUTE_CHANGED"),
    SpeakerphoneStateChanged("android.media.action.SPEAKERPHONE_STATE_CHANGED");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String action;

    /* compiled from: AudioManagerBroadcastAction.kt */
    /* renamed from: com.discord.rtcconnection.enums.AudioManagerBroadcastAction$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        INSTANCE = new Companion(null);
    }

    AudioManagerBroadcastAction(String str) {
        this.action = str;
    }

    public final String getAction() {
        return this.action;
    }
}
