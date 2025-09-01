package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelInvite;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventInviteEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001c\u0010\u001b\u001a\u00020\u00118\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0013R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\"\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/discord/widgets/chat/list/entries/GuildScheduledEventInviteEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "", "component2", "()Ljava/lang/String;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component3", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "invite", "inviteCode", "guildScheduledEvent", "copy", "(Lcom/discord/models/domain/ModelInvite;Ljava/lang/String;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/widgets/chat/list/entries/GuildScheduledEventInviteEntry;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEvent", "type", "I", "getType", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "Ljava/lang/String;", "getInviteCode", "key", "getKey", "<init>", "(Lcom/discord/models/domain/ModelInvite;Ljava/lang/String;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventInviteEntry extends ChatListEntry {
    private final GuildScheduledEvent guildScheduledEvent;
    private final ModelInvite invite;
    private final String inviteCode;
    private final String key;
    private final int type;

    public GuildScheduledEventInviteEntry(ModelInvite modelInvite, String str, GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(modelInvite, "invite");
        Intrinsics3.checkNotNullParameter(str, "inviteCode");
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.invite = modelInvite;
        this.inviteCode = str;
        this.guildScheduledEvent = guildScheduledEvent;
        this.type = 43;
        StringBuilder sbU = outline.U("43 -- ");
        sbU.append(guildScheduledEvent.getId());
        sbU.append(" -- ");
        sbU.append(str);
        this.key = sbU.toString();
    }

    public static /* synthetic */ GuildScheduledEventInviteEntry copy$default(GuildScheduledEventInviteEntry guildScheduledEventInviteEntry, ModelInvite modelInvite, String str, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = guildScheduledEventInviteEntry.invite;
        }
        if ((i & 2) != 0) {
            str = guildScheduledEventInviteEntry.inviteCode;
        }
        if ((i & 4) != 0) {
            guildScheduledEvent = guildScheduledEventInviteEntry.guildScheduledEvent;
        }
        return guildScheduledEventInviteEntry.copy(modelInvite, str, guildScheduledEvent);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* renamed from: component3, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final GuildScheduledEventInviteEntry copy(ModelInvite invite, String inviteCode, GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        return new GuildScheduledEventInviteEntry(invite, inviteCode, guildScheduledEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventInviteEntry)) {
            return false;
        }
        GuildScheduledEventInviteEntry guildScheduledEventInviteEntry = (GuildScheduledEventInviteEntry) other;
        return Intrinsics3.areEqual(this.invite, guildScheduledEventInviteEntry.invite) && Intrinsics3.areEqual(this.inviteCode, guildScheduledEventInviteEntry.inviteCode) && Intrinsics3.areEqual(this.guildScheduledEvent, guildScheduledEventInviteEntry.guildScheduledEvent);
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
        String str = this.inviteCode;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return iHashCode2 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventInviteEntry(invite=");
        sbU.append(this.invite);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}
