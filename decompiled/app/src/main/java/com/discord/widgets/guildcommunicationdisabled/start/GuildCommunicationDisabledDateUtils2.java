package com.discord.widgets.guildcommunicationdisabled.start;

import com.adjust.sdk.Constants;
import kotlin.Metadata;

/* compiled from: GuildCommunicationDisabledDateUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;", "", "", "durationMs", "I", "getDurationMs", "()I", "<init>", "(Ljava/lang/String;II)V", "SECONDS_60", "MINUTES_5", "MINUTES_10", "HOUR_1", "DAY_1", "WEEK_1", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.TimeDurationDisabledCommunication, reason: use source file name */
/* loaded from: classes2.dex */
public enum GuildCommunicationDisabledDateUtils2 {
    SECONDS_60(60000),
    MINUTES_5(300000),
    MINUTES_10(600000),
    HOUR_1(Constants.ONE_HOUR),
    DAY_1(86400000),
    WEEK_1(604800000);

    private final int durationMs;

    GuildCommunicationDisabledDateUtils2(int i) {
        this.durationMs = i;
    }

    public final int getDurationMs() {
        return this.durationMs;
    }
}
