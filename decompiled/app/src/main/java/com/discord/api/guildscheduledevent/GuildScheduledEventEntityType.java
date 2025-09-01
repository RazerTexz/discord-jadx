package com.discord.api.guildscheduledevent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventEntityType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "", "", "apiValue", "I", "getApiValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "NONE", "STAGE_INSTANCE", "VOICE", "EXTERNAL", "UNKNOWN", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum GuildScheduledEventEntityType {
    NONE(0),
    STAGE_INSTANCE(1),
    VOICE(2),
    EXTERNAL(3),
    UNKNOWN(-1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* compiled from: GuildScheduledEventEntityType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType$Companion;", "", "", "type", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "a", "(I)Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final GuildScheduledEventEntityType a(int type) {
            return type != 0 ? type != 1 ? type != 2 ? type != 3 ? GuildScheduledEventEntityType.UNKNOWN : GuildScheduledEventEntityType.EXTERNAL : GuildScheduledEventEntityType.VOICE : GuildScheduledEventEntityType.STAGE_INSTANCE : GuildScheduledEventEntityType.NONE;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    GuildScheduledEventEntityType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
