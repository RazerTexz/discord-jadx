package com.discord.utilities.voice;

import kotlin.Metadata;

/* compiled from: Bitrate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/voice/Bitrate;", "", "", "kbps", "I", "getKbps", "()I", "<init>", "(Ljava/lang/String;II)V", "MIN", "DEFAULT", "MAX", "PREMIUM_TIER_1", "PREMIUM_TIER_2", "PREMIUM_TIER_3", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public enum Bitrate {
    MIN(8),
    DEFAULT(64),
    MAX(96),
    PREMIUM_TIER_1(128),
    PREMIUM_TIER_2(256),
    PREMIUM_TIER_3(384);

    private final int kbps;

    Bitrate(int i) {
        this.kbps = i;
    }

    public final int getKbps() {
        return this.kbps;
    }
}
