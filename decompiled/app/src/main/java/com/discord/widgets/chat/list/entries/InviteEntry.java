package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: InviteEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b*\u0010+J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0012\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJP\u0010\u0013\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u0010\u001a\u00020\b2\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001c\u0010 \u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\nR\u001d\u0010\u0011\u001a\u00060\u0002j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0005R\u001c\u0010$\u001a\u00020\u00168\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0018R\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b'\u0010\u0005R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b(\u0010\nR\u001d\u0010\u000f\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b)\u0010\u0005¨\u0006,"}, d2 = {"Lcom/discord/widgets/chat/list/entries/InviteEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "", "component3", "()Ljava/lang/String;", "Lcom/discord/primitives/GuildId;", "component4", "component5", "userId", "messageId", "inviteCode", "guildId", "eventId", "copy", "(JJLjava/lang/String;JLjava/lang/String;)Lcom/discord/widgets/chat/list/entries/InviteEntry;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEventId", "key", "getKey", "J", "getGuildId", "type", "I", "getType", "getUserId", "getInviteCode", "getMessageId", "<init>", "(JJLjava/lang/String;JLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class InviteEntry extends ChatListEntry {
    private final String eventId;
    private final long guildId;
    private final String inviteCode;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public InviteEntry(long j, long j2, String str, long j3, String str2) {
        Intrinsics3.checkNotNullParameter(str, "inviteCode");
        this.userId = j;
        this.messageId = j2;
        this.inviteCode = str;
        this.guildId = j3;
        this.eventId = str2;
        this.type = 24;
        this.key = "24 -- " + j2 + " -- " + str;
    }

    public static /* synthetic */ InviteEntry copy$default(InviteEntry inviteEntry, long j, long j2, String str, long j3, String str2, int i, Object obj) {
        return inviteEntry.copy((i & 1) != 0 ? inviteEntry.userId : j, (i & 2) != 0 ? inviteEntry.messageId : j2, (i & 4) != 0 ? inviteEntry.inviteCode : str, (i & 8) != 0 ? inviteEntry.guildId : j3, (i & 16) != 0 ? inviteEntry.eventId : str2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    public final InviteEntry copy(long userId, long messageId, String inviteCode, long guildId, String eventId) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        return new InviteEntry(userId, messageId, inviteCode, guildId, eventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteEntry)) {
            return false;
        }
        InviteEntry inviteEntry = (InviteEntry) other;
        return this.userId == inviteEntry.userId && this.messageId == inviteEntry.messageId && Intrinsics3.areEqual(this.inviteCode, inviteEntry.inviteCode) && this.guildId == inviteEntry.guildId && Intrinsics3.areEqual(this.eventId, inviteEntry.eventId);
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iA = (b.a(this.messageId) + (b.a(this.userId) * 31)) * 31;
        String str = this.inviteCode;
        int iA2 = (b.a(this.guildId) + ((iA + (str != null ? str.hashCode() : 0)) * 31)) * 31;
        String str2 = this.eventId;
        return iA2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InviteEntry(userId=");
        sbU.append(this.userId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", eventId=");
        return outline.J(sbU, this.eventId, ")");
    }
}
