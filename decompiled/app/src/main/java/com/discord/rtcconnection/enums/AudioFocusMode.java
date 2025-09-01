package com.discord.rtcconnection.enums;

import android.os.Build;
import kotlin.Metadata;

/* compiled from: AudioFocusMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/discord/rtcconnection/enums/AudioFocusMode;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "Gain", "GainTransient", "GainTransientMayDuck", "GainTransientExclusive", "Loss", "LossTransient", "LossTransientCanDuck", "None", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum AudioFocusMode {
    Gain(1),
    GainTransient(2),
    GainTransientMayDuck(3),
    GainTransientExclusive(4),
    Loss(-1),
    LossTransient(-2),
    LossTransientCanDuck(-3),
    None(0);

    private final int value;

    static {
        int i = Build.VERSION.SDK_INT;
        INSTANCE = new Companion(null);
    }

    AudioFocusMode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
