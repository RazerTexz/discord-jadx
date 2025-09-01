package com.discord.utilities.guildscheduledevent;

import kotlin.Metadata;

/* compiled from: GuildScheduledEventUtilities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/guildscheduledevent/GuildScheduledEventTiming;", "", "", "isLongStartable", "()Z", "isStartable", "<init>", "(Ljava/lang/String;I)V", "LATER", "TOMORROW", "TODAY", "SOON", "NOW", "LIVE", "EXPIRED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming, reason: use source file name */
/* loaded from: classes2.dex */
public enum GuildScheduledEventUtilities2 {
    LATER,
    TOMORROW,
    TODAY,
    SOON,
    NOW,
    LIVE,
    EXPIRED;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GuildScheduledEventUtilities2.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventUtilities2.LATER.ordinal()] = 1;
            iArr[GuildScheduledEventUtilities2.TOMORROW.ordinal()] = 2;
            iArr[GuildScheduledEventUtilities2.TODAY.ordinal()] = 3;
            GuildScheduledEventUtilities2.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[GuildScheduledEventUtilities2.SOON.ordinal()] = 1;
            iArr2[GuildScheduledEventUtilities2.NOW.ordinal()] = 2;
            iArr2[GuildScheduledEventUtilities2.EXPIRED.ordinal()] = 3;
        }
    }

    public final boolean isLongStartable() {
        int iOrdinal = ordinal();
        return iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2;
    }

    public final boolean isStartable() {
        int iOrdinal = ordinal();
        return iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 6;
    }
}
