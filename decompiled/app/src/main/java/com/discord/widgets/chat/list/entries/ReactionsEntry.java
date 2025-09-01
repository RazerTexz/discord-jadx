package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ReactionsEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00138\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0015R\u001c\u0010\u001d\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b$\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/list/entries/ReactionsEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "", "component2", "()Z", "component3", "component4", "message", "canAddReactions", "canCreateReactions", "animateEmojis", "copy", "(Lcom/discord/models/message/Message;ZZZ)Lcom/discord/widgets/chat/list/entries/ReactionsEntry;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Z", "getAnimateEmojis", "Lcom/discord/models/message/Message;", "getMessage", "getCanAddReactions", "getCanCreateReactions", "<init>", "(Lcom/discord/models/message/Message;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ReactionsEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final boolean canAddReactions;
    private final boolean canCreateReactions;
    private final String key;
    private final Message message;
    private final int type;

    public ReactionsEntry(Message message, boolean z2, boolean z3, boolean z4) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.message = message;
        this.canAddReactions = z2;
        this.canCreateReactions = z3;
        this.animateEmojis = z4;
        this.type = 4;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        Object nonce = message.getNonce();
        sb.append(nonce == null ? Long.valueOf(message.getId()) : nonce);
        this.key = sb.toString();
    }

    public static /* synthetic */ ReactionsEntry copy$default(ReactionsEntry reactionsEntry, Message message, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            message = reactionsEntry.message;
        }
        if ((i & 2) != 0) {
            z2 = reactionsEntry.canAddReactions;
        }
        if ((i & 4) != 0) {
            z3 = reactionsEntry.canCreateReactions;
        }
        if ((i & 8) != 0) {
            z4 = reactionsEntry.animateEmojis;
        }
        return reactionsEntry.copy(message, z2, z3, z4);
    }

    /* renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanCreateReactions() {
        return this.canCreateReactions;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final ReactionsEntry copy(Message message, boolean canAddReactions, boolean canCreateReactions, boolean animateEmojis) {
        Intrinsics3.checkNotNullParameter(message, "message");
        return new ReactionsEntry(message, canAddReactions, canCreateReactions, animateEmojis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReactionsEntry)) {
            return false;
        }
        ReactionsEntry reactionsEntry = (ReactionsEntry) other;
        return Intrinsics3.areEqual(this.message, reactionsEntry.message) && this.canAddReactions == reactionsEntry.canAddReactions && this.canCreateReactions == reactionsEntry.canCreateReactions && this.animateEmojis == reactionsEntry.animateEmojis;
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    public final boolean getCanCreateReactions() {
        return this.canCreateReactions;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        boolean z2 = this.canAddReactions;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.canCreateReactions;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.animateEmojis;
        return i4 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReactionsEntry(message=");
        sbU.append(this.message);
        sbU.append(", canAddReactions=");
        sbU.append(this.canAddReactions);
        sbU.append(", canCreateReactions=");
        sbU.append(this.canCreateReactions);
        sbU.append(", animateEmojis=");
        return outline.O(sbU, this.animateEmojis, ")");
    }
}
