package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildWelcomeEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\u0010\u0011\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0014\u0010\t\u001a\u00060\u0007j\u0002`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJF\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\f\b\u0002\u0010\u0011\u001a\u00060\u0007j\u0002`\b2\b\b\u0002\u0010\u0012\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010 \u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\rR\u001c\u0010#\u001a\u00020\u00168\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0018R\u001d\u0010\u0011\u001a\u00060\u0007j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b(\u0010\r¨\u0006+"}, d2 = {"Lcom/discord/widgets/chat/list/entries/GuildWelcomeEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "component1", "()Z", "component2", "component3", "", "Lcom/discord/primitives/GuildId;", "component4", "()J", "", "component5", "()Ljava/lang/String;", "isOwner", "guildHasIcon", "canInvite", "guildId", "guildName", "copy", "(ZZZJLjava/lang/String;)Lcom/discord/widgets/chat/list/entries/GuildWelcomeEntry;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getGuildHasIcon", "getCanInvite", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "J", "getGuildId", "getGuildName", "<init>", "(ZZZJLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GuildWelcomeEntry extends ChatListEntry {
    private final boolean canInvite;
    private final boolean guildHasIcon;
    private final long guildId;
    private final String guildName;
    private final boolean isOwner;
    private final String key;
    private final int type;

    public GuildWelcomeEntry(boolean z2, boolean z3, boolean z4, long j, String str) {
        Intrinsics3.checkNotNullParameter(str, "guildName");
        this.isOwner = z2;
        this.guildHasIcon = z3;
        this.canInvite = z4;
        this.guildId = j;
        this.guildName = str;
        this.type = 25;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ GuildWelcomeEntry copy$default(GuildWelcomeEntry guildWelcomeEntry, boolean z2, boolean z3, boolean z4, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildWelcomeEntry.isOwner;
        }
        if ((i & 2) != 0) {
            z3 = guildWelcomeEntry.guildHasIcon;
        }
        boolean z5 = z3;
        if ((i & 4) != 0) {
            z4 = guildWelcomeEntry.canInvite;
        }
        boolean z6 = z4;
        if ((i & 8) != 0) {
            j = guildWelcomeEntry.guildId;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            str = guildWelcomeEntry.guildName;
        }
        return guildWelcomeEntry.copy(z2, z5, z6, j2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsOwner() {
        return this.isOwner;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getGuildHasIcon() {
        return this.guildHasIcon;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanInvite() {
        return this.canInvite;
    }

    /* renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final GuildWelcomeEntry copy(boolean isOwner, boolean guildHasIcon, boolean canInvite, long guildId, String guildName) {
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        return new GuildWelcomeEntry(isOwner, guildHasIcon, canInvite, guildId, guildName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildWelcomeEntry)) {
            return false;
        }
        GuildWelcomeEntry guildWelcomeEntry = (GuildWelcomeEntry) other;
        return this.isOwner == guildWelcomeEntry.isOwner && this.guildHasIcon == guildWelcomeEntry.guildHasIcon && this.canInvite == guildWelcomeEntry.canInvite && this.guildId == guildWelcomeEntry.guildId && Intrinsics3.areEqual(this.guildName, guildWelcomeEntry.guildName);
    }

    public final boolean getCanInvite() {
        return this.canInvite;
    }

    public final boolean getGuildHasIcon() {
        return this.guildHasIcon;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.isOwner;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.guildHasIcon;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z3 = this.canInvite;
        int iA = (b.a(this.guildId) + ((i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31)) * 31;
        String str = this.guildName;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildWelcomeEntry(isOwner=");
        sbU.append(this.isOwner);
        sbU.append(", guildHasIcon=");
        sbU.append(this.guildHasIcon);
        sbU.append(", canInvite=");
        sbU.append(this.canInvite);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        return outline.J(sbU, this.guildName, ")");
    }
}
