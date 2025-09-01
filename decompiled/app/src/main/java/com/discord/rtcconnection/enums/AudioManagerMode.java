package com.discord.rtcconnection.enums;

import android.os.Build;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AudioManagerMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/rtcconnection/enums/AudioManagerMode;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "Current", "Invalid", "Normal", "Ringtone", "InCall", "InCommunication", "CallScreening", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AudioManagerMode {
    private static final /* synthetic */ AudioManagerMode[] $VALUES;
    public static final AudioManagerMode CallScreening;
    public static final AudioManagerMode Current;
    public static final AudioManagerMode InCall;
    public static final AudioManagerMode InCommunication;
    public static final AudioManagerMode Invalid;
    public static final AudioManagerMode Normal;
    public static final AudioManagerMode Ringtone;
    private final int value;

    static {
        AudioManagerMode[] audioManagerModeArr = new AudioManagerMode[7];
        AudioManagerMode audioManagerMode = new AudioManagerMode("Current", 0, -1);
        Current = audioManagerMode;
        audioManagerModeArr[0] = audioManagerMode;
        AudioManagerMode audioManagerMode2 = new AudioManagerMode("Invalid", 1, -2);
        Invalid = audioManagerMode2;
        audioManagerModeArr[1] = audioManagerMode2;
        AudioManagerMode audioManagerMode3 = new AudioManagerMode("Normal", 2, 0);
        Normal = audioManagerMode3;
        audioManagerModeArr[2] = audioManagerMode3;
        AudioManagerMode audioManagerMode4 = new AudioManagerMode("Ringtone", 3, 1);
        Ringtone = audioManagerMode4;
        audioManagerModeArr[3] = audioManagerMode4;
        AudioManagerMode audioManagerMode5 = new AudioManagerMode("InCall", 4, 2);
        InCall = audioManagerMode5;
        audioManagerModeArr[4] = audioManagerMode5;
        AudioManagerMode audioManagerMode6 = new AudioManagerMode("InCommunication", 5, 3);
        InCommunication = audioManagerMode6;
        audioManagerModeArr[5] = audioManagerMode6;
        AudioManagerMode audioManagerMode7 = new AudioManagerMode("CallScreening", 6, Build.VERSION.SDK_INT >= 30 ? 4 : 2);
        CallScreening = audioManagerMode7;
        audioManagerModeArr[6] = audioManagerMode7;
        $VALUES = audioManagerModeArr;
        INSTANCE = new Companion(null);
    }

    private AudioManagerMode(String str, int i, int i2) {
        this.value = i2;
    }

    public static AudioManagerMode valueOf(String str) {
        return (AudioManagerMode) Enum.valueOf(AudioManagerMode.class, str);
    }

    public static AudioManagerMode[] values() {
        return (AudioManagerMode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
