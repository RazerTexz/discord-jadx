package com.discord.api.guild;

import b.d.b.a.outline;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildMaxVideoChannelUsers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "", "<init>", "()V", "Limited", "Unlimited", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers$Limited;", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers$Unlimited;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class GuildMaxVideoChannelUsers {

    /* compiled from: GuildMaxVideoChannelUsers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/discord/api/guild/GuildMaxVideoChannelUsers$Limited;", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "limit", "I", "a", "<init>", "(I)V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Limited extends GuildMaxVideoChannelUsers {
        private final int limit;

        public Limited(int i) {
            super(null);
            this.limit = i;
        }

        /* renamed from: a, reason: from getter */
        public final int getLimit() {
            return this.limit;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Limited) && this.limit == ((Limited) other).limit;
            }
            return true;
        }

        public int hashCode() {
            return this.limit;
        }

        public String toString() {
            return outline.B(outline.U("Limited(limit="), this.limit, ")");
        }
    }

    /* compiled from: GuildMaxVideoChannelUsers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/api/guild/GuildMaxVideoChannelUsers$Unlimited;", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Unlimited extends GuildMaxVideoChannelUsers {
        public static final Unlimited INSTANCE = new Unlimited();

        public Unlimited() {
            super(null);
        }
    }

    public GuildMaxVideoChannelUsers() {
    }

    public GuildMaxVideoChannelUsers(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
