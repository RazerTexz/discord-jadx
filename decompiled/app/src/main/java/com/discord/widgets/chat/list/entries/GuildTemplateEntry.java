package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildTemplateEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001e\u0010\u0005R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001f\u0010\nR\u001c\u0010 \u001a\u00020\u00118\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0013¨\u0006%"}, d2 = {"Lcom/discord/widgets/chat/list/entries/GuildTemplateEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "", "component3", "()Ljava/lang/String;", "userId", "messageId", "guildTemplateCode", "copy", "(JJLjava/lang/String;)Lcom/discord/widgets/chat/list/entries/GuildTemplateEntry;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "J", "getUserId", "getMessageId", "getGuildTemplateCode", "type", "I", "getType", "<init>", "(JJLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildTemplateEntry extends ChatListEntry {
    private final String guildTemplateCode;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public GuildTemplateEntry(long j, long j2, String str) {
        Intrinsics3.checkNotNullParameter(str, "guildTemplateCode");
        this.userId = j;
        this.messageId = j2;
        this.guildTemplateCode = str;
        this.type = 30;
        this.key = "30 -- " + j2 + " -- " + str;
    }

    public static /* synthetic */ GuildTemplateEntry copy$default(GuildTemplateEntry guildTemplateEntry, long j, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = guildTemplateEntry.userId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = guildTemplateEntry.messageId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            str = guildTemplateEntry.guildTemplateCode;
        }
        return guildTemplateEntry.copy(j3, j4, str);
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
    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
    }

    public final GuildTemplateEntry copy(long userId, long messageId, String guildTemplateCode) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        return new GuildTemplateEntry(userId, messageId, guildTemplateCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildTemplateEntry)) {
            return false;
        }
        GuildTemplateEntry guildTemplateEntry = (GuildTemplateEntry) other;
        return this.userId == guildTemplateEntry.userId && this.messageId == guildTemplateEntry.messageId && Intrinsics3.areEqual(this.guildTemplateCode, guildTemplateEntry.guildTemplateCode);
    }

    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
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
        String str = this.guildTemplateCode;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildTemplateEntry(userId=");
        sbU.append(this.userId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", guildTemplateCode=");
        return outline.J(sbU, this.guildTemplateCode, ")");
    }
}
