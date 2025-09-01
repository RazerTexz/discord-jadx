package com.discord.utilities;

import d0.g0.StringNumberConversions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SnowflakeUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\t\u001a\u00060\u0002j\u0002`\u00032\n\u0010\b\u001a\u00060\u0002j\u0002`\u0005H\u0087\b¢\u0006\u0004\b\t\u0010\u0007J \u0010\n\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0087\b¢\u0006\u0004\b\n\u0010\u0007J\u0013\u0010\f\u001a\u0004\u0018\u00010\u0002*\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R)\u0010\u0016\u001a\u00060\u0002j\u0002`\u0005*\u00060\u0002j\u0002`\u00038Æ\u0002@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/discord/utilities/SnowflakeUtils;", "", "", "Lcom/discord/primitives/Snowflake;", "snowflakeId", "Lcom/discord/primitives/Timestamp;", "toTimestamp", "(J)J", "timestamp", "fromTimestamp", "atPreviousMillisecond", "", "toSnowflake", "(Ljava/lang/String;)Ljava/lang/Long;", "", "SNOWFLAKE_TIMESTAMP_SHIFT", "I", "DISCORD_EPOCH", "J", "getTimestampPart", "getTimestampPart$annotations", "(J)V", "timestampPart", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SnowflakeUtils {
    public static final long DISCORD_EPOCH = 1420070400000L;
    public static final SnowflakeUtils INSTANCE = new SnowflakeUtils();
    public static final int SNOWFLAKE_TIMESTAMP_SHIFT = 22;

    private SnowflakeUtils() {
    }

    public static final long atPreviousMillisecond(long snowflakeId) {
        return (((snowflakeId >>> 22) - 1) - DISCORD_EPOCH) << 22;
    }

    public static final long fromTimestamp(long timestamp) {
        return (timestamp - DISCORD_EPOCH) << 22;
    }

    public static final long getTimestampPart(long j) {
        return j >>> 22;
    }

    public static /* synthetic */ void getTimestampPart$annotations(long j) {
    }

    public static final long toTimestamp(long snowflakeId) {
        return (snowflakeId >>> 22) + DISCORD_EPOCH;
    }

    public final Long toSnowflake(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$toSnowflake");
        Long longOrNull = StringNumberConversions.toLongOrNull(str);
        if (longOrNull != null) {
            if (longOrNull.longValue() > DISCORD_EPOCH) {
                return longOrNull;
            }
        }
        return null;
    }
}
