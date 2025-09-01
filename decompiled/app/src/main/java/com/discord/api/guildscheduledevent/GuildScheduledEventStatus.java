package com.discord.api.guildscheduledevent;

import d0.t.Sets5;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventStatus;", "", "", "apiValue", "I", "getApiValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "SCHEDULED", "ACTIVE", "COMPLETED", "CANCELED", "UNKNOWN", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum GuildScheduledEventStatus {
    SCHEDULED(1),
    ACTIVE(2),
    COMPLETED(3),
    CANCELED(4),
    UNKNOWN(0);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<GuildScheduledEventStatus> DONE;
    private final int apiValue;

    /* compiled from: GuildScheduledEventStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventStatus$Companion;", "", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        GuildScheduledEventStatus guildScheduledEventStatus = COMPLETED;
        GuildScheduledEventStatus guildScheduledEventStatus2 = CANCELED;
        INSTANCE = new Companion(null);
        DONE = Sets5.setOf((Object[]) new GuildScheduledEventStatus[]{guildScheduledEventStatus, guildScheduledEventStatus2});
    }

    GuildScheduledEventStatus(int i) {
        this.apiValue = i;
    }

    public static final /* synthetic */ Set access$getDONE$cp() {
        return DONE;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
