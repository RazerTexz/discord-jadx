package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelInvite;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StageInviteEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u000e¢\u0006\u0004\b-\u0010.J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000f\u001a\u00060\u0002j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005JN\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\f\b\u0002\u0010\u0014\u001a\u00060\u0002j\u0002`\u000eHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0014\u001a\u00060\u0002j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\u0005R\u001c\u0010\"\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\nR\u001c\u0010%\u001a\u00020\u00188\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u001aR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b(\u0010\u0005R\u001d\u0010\u0011\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b)\u0010\u0005R\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010\rR\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b,\u0010\n¨\u0006/"}, d2 = {"Lcom/discord/widgets/chat/list/entries/StageInviteEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "", "component3", "()Ljava/lang/String;", "Lcom/discord/models/domain/ModelInvite;", "component4", "()Lcom/discord/models/domain/ModelInvite;", "Lcom/discord/primitives/GuildId;", "component5", "userId", "messageId", "inviteCode", "invite", "guildId", "copy", "(JJLjava/lang/String;Lcom/discord/models/domain/ModelInvite;J)Lcom/discord/widgets/chat/list/entries/StageInviteEntry;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "getUserId", "getMessageId", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "getInviteCode", "<init>", "(JJLjava/lang/String;Lcom/discord/models/domain/ModelInvite;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class StageInviteEntry extends ChatListEntry {
    private final long guildId;
    private final ModelInvite invite;
    private final String inviteCode;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public StageInviteEntry(long j, long j2, String str, ModelInvite modelInvite, long j3) {
        Intrinsics3.checkNotNullParameter(str, "inviteCode");
        Intrinsics3.checkNotNullParameter(modelInvite, "invite");
        this.userId = j;
        this.messageId = j2;
        this.inviteCode = str;
        this.invite = modelInvite;
        this.guildId = j3;
        this.type = 39;
        this.key = "39 -- " + j2 + " -- " + str;
    }

    public static /* synthetic */ StageInviteEntry copy$default(StageInviteEntry stageInviteEntry, long j, long j2, String str, ModelInvite modelInvite, long j3, int i, Object obj) {
        return stageInviteEntry.copy((i & 1) != 0 ? stageInviteEntry.userId : j, (i & 2) != 0 ? stageInviteEntry.messageId : j2, (i & 4) != 0 ? stageInviteEntry.inviteCode : str, (i & 8) != 0 ? stageInviteEntry.invite : modelInvite, (i & 16) != 0 ? stageInviteEntry.guildId : j3);
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
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* renamed from: component5, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final StageInviteEntry copy(long userId, long messageId, String inviteCode, ModelInvite invite, long guildId) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics3.checkNotNullParameter(invite, "invite");
        return new StageInviteEntry(userId, messageId, inviteCode, invite, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageInviteEntry)) {
            return false;
        }
        StageInviteEntry stageInviteEntry = (StageInviteEntry) other;
        return this.userId == stageInviteEntry.userId && this.messageId == stageInviteEntry.messageId && Intrinsics3.areEqual(this.inviteCode, stageInviteEntry.inviteCode) && Intrinsics3.areEqual(this.invite, stageInviteEntry.invite) && this.guildId == stageInviteEntry.guildId;
    }

    public final long getGuildId() {
        return this.guildId;
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
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        ModelInvite modelInvite = this.invite;
        return b.a(this.guildId) + ((iHashCode + (modelInvite != null ? modelInvite.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageInviteEntry(userId=");
        sbU.append(this.userId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", invite=");
        sbU.append(this.invite);
        sbU.append(", guildId=");
        return outline.C(sbU, this.guildId, ")");
    }
}
