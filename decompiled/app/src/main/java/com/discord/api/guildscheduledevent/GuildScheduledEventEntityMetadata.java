package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventEntityMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "Ljava/io/Serializable;", "", "b", "()Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Ljava/lang/String;", "a", "<init>", "(Ljava/lang/String;)V", "Companion", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEventEntityMetadata implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String location;

    /* compiled from: GuildScheduledEventEntityMetadata.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata$Companion;", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "entityType", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "a", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Ljava/lang/String;)Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityMetadata;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                GuildScheduledEventEntityType.values();
                int[] iArr = new int[5];
                $EnumSwitchMapping$0 = iArr;
                iArr[GuildScheduledEventEntityType.EXTERNAL.ordinal()] = 1;
            }
        }

        public Companion() {
        }

        public final GuildScheduledEventEntityMetadata a(GuildScheduledEventEntityType entityType, String location) {
            Intrinsics3.checkNotNullParameter(entityType, "entityType");
            return entityType.ordinal() != 3 ? new GuildScheduledEventEntityMetadata(null, 1) : new GuildScheduledEventEntityMetadata(location);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public GuildScheduledEventEntityMetadata() {
        this.location = null;
    }

    /* renamed from: a, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final boolean b() {
        return this.location == null;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildScheduledEventEntityMetadata) && Intrinsics3.areEqual(this.location, ((GuildScheduledEventEntityMetadata) other).location);
        }
        return true;
    }

    public int hashCode() {
        String str = this.location;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.J(outline.U("GuildScheduledEventEntityMetadata(location="), this.location, ")");
    }

    public GuildScheduledEventEntityMetadata(String str) {
        this.location = str;
    }

    public GuildScheduledEventEntityMetadata(String str, int i) {
        int i2 = i & 1;
        this.location = null;
    }
}
