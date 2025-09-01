package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: BotUiComponentEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0016R\u001c\u0010\"\u001a\u00020\u00178\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b*\u0010\tR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010\r¨\u0006/"}, d2 = {"Lcom/discord/widgets/chat/list/entries/BotUiComponentEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "", "component2", "()J", "component3", "()Ljava/lang/Long;", "", "Lcom/discord/models/botuikit/MessageComponent;", "component4", "()Ljava/util/List;", "message", "applicationId", "guildId", "messageComponents", "copy", "(Lcom/discord/models/message/Message;JLjava/lang/Long;Ljava/util/List;)Lcom/discord/widgets/chat/list/entries/BotUiComponentEntry;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/models/message/Message;", "getMessage", "J", "getApplicationId", "Ljava/lang/Long;", "getGuildId", "Ljava/util/List;", "getMessageComponents", "<init>", "(Lcom/discord/models/message/Message;JLjava/lang/Long;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class BotUiComponentEntry extends ChatListEntry {
    private final long applicationId;
    private final Long guildId;
    private final String key;
    private final Message message;
    private final List<MessageComponent> messageComponents;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public BotUiComponentEntry(Message message, long j, Long l, List<? extends MessageComponent> list) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(list, "messageComponents");
        this.message = message;
        this.applicationId = j;
        this.guildId = l;
        this.messageComponents = list;
        this.type = 36;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(" -- ");
        Object nonce = message.getNonce();
        sb.append(nonce == null ? Long.valueOf(message.getId()) : nonce);
        this.key = sb.toString();
    }

    public static /* synthetic */ BotUiComponentEntry copy$default(BotUiComponentEntry botUiComponentEntry, Message message, long j, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            message = botUiComponentEntry.message;
        }
        if ((i & 2) != 0) {
            j = botUiComponentEntry.applicationId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            l = botUiComponentEntry.guildId;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            list = botUiComponentEntry.messageComponents;
        }
        return botUiComponentEntry.copy(message, j2, l2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final List<MessageComponent> component4() {
        return this.messageComponents;
    }

    public final BotUiComponentEntry copy(Message message, long applicationId, Long guildId, List<? extends MessageComponent> messageComponents) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(messageComponents, "messageComponents");
        return new BotUiComponentEntry(message, applicationId, guildId, messageComponents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BotUiComponentEntry)) {
            return false;
        }
        BotUiComponentEntry botUiComponentEntry = (BotUiComponentEntry) other;
        return Intrinsics3.areEqual(this.message, botUiComponentEntry.message) && this.applicationId == botUiComponentEntry.applicationId && Intrinsics3.areEqual(this.guildId, botUiComponentEntry.guildId) && Intrinsics3.areEqual(this.messageComponents, botUiComponentEntry.messageComponents);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final List<MessageComponent> getMessageComponents() {
        return this.messageComponents;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Message message = this.message;
        int iA = (b.a(this.applicationId) + ((message != null ? message.hashCode() : 0) * 31)) * 31;
        Long l = this.guildId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        List<MessageComponent> list = this.messageComponents;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("BotUiComponentEntry(message=");
        sbU.append(this.message);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", messageComponents=");
        return outline.L(sbU, this.messageComponents, ")");
    }
}
