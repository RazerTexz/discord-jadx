package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: EmbedEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\n\u0010\u001a\u001a\u00060\bj\u0002`\t\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004Jp\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00052\f\b\u0002\u0010\u001a\u001a\u00060\bj\u0002`\t2\b\b\u0002\u0010\u001b\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b'\u0010\u0007J\u001a\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b-\u0010\u0004R\u001c\u0010.\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b1\u0010\u0007R\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010,\u001a\u0004\b!\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b3\u0010\u000eR\u001c\u00104\u001a\u00020$8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010&R\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b\u001e\u0010\u0004R\u001d\u0010\u001a\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00107\u001a\u0004\b8\u0010\u000bR\u0019\u0010\u001d\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010\u0014R\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\b;\u0010\u0004R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010<\u001a\u0004\b=\u0010\u0011¨\u0006@"}, d2 = {"Lcom/discord/widgets/chat/list/entries/EmbedEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "isInExpandedBlockedMessageChunk", "()Z", "", "component1", "()I", "", "Lcom/discord/primitives/GuildId;", "component2", "()J", "Lcom/discord/models/message/Message;", "component3", "()Lcom/discord/models/message/Message;", "Lcom/discord/stores/StoreMessageState$State;", "component4", "()Lcom/discord/stores/StoreMessageState$State;", "Lcom/discord/api/message/embed/MessageEmbed;", "component5", "()Lcom/discord/api/message/embed/MessageEmbed;", "component6", "component7", "component8", "component9", "embedIndex", "guildId", "message", "messageState", "embed", "isBlockedExpanded", "allowAnimatedEmojis", "autoPlayGifs", "isThreadStarterMessage", "copy", "(IJLcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;Lcom/discord/api/message/embed/MessageEmbed;ZZZZ)Lcom/discord/widgets/chat/list/entries/EmbedEntry;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAllowAnimatedEmojis", "type", "I", "getType", "getEmbedIndex", "Lcom/discord/models/message/Message;", "getMessage", "key", "Ljava/lang/String;", "getKey", "J", "getGuildId", "Lcom/discord/api/message/embed/MessageEmbed;", "getEmbed", "getAutoPlayGifs", "Lcom/discord/stores/StoreMessageState$State;", "getMessageState", "<init>", "(IJLcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;Lcom/discord/api/message/embed/MessageEmbed;ZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class EmbedEntry extends ChatListEntry {
    private final boolean allowAnimatedEmojis;
    private final boolean autoPlayGifs;
    private final MessageEmbed embed;
    private final int embedIndex;
    private final long guildId;
    private final boolean isBlockedExpanded;
    private final boolean isThreadStarterMessage;
    private final String key;
    private final Message message;
    private final StoreMessageState.State messageState;
    private final int type;

    public EmbedEntry(int i, long j, Message message, StoreMessageState.State state, MessageEmbed messageEmbed, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(messageEmbed, "embed");
        this.embedIndex = i;
        this.guildId = j;
        this.message = message;
        this.messageState = state;
        this.embed = messageEmbed;
        this.isBlockedExpanded = z2;
        this.allowAnimatedEmojis = z3;
        this.autoPlayGifs = z4;
        this.isThreadStarterMessage = z5;
        this.type = 21;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(message.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ EmbedEntry copy$default(EmbedEntry embedEntry, int i, long j, Message message, StoreMessageState.State state, MessageEmbed messageEmbed, boolean z2, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        return embedEntry.copy((i2 & 1) != 0 ? embedEntry.embedIndex : i, (i2 & 2) != 0 ? embedEntry.guildId : j, (i2 & 4) != 0 ? embedEntry.message : message, (i2 & 8) != 0 ? embedEntry.messageState : state, (i2 & 16) != 0 ? embedEntry.embed : messageEmbed, (i2 & 32) != 0 ? embedEntry.isBlockedExpanded : z2, (i2 & 64) != 0 ? embedEntry.allowAnimatedEmojis : z3, (i2 & 128) != 0 ? embedEntry.autoPlayGifs : z4, (i2 & 256) != 0 ? embedEntry.isThreadStarterMessage : z5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getEmbedIndex() {
        return this.embedIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component3, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final StoreMessageState.State getMessageState() {
        return this.messageState;
    }

    /* renamed from: component5, reason: from getter */
    public final MessageEmbed getEmbed() {
        return this.embed;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsBlockedExpanded() {
        return this.isBlockedExpanded;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public final EmbedEntry copy(int embedIndex, long guildId, Message message, StoreMessageState.State messageState, MessageEmbed embed, boolean isBlockedExpanded, boolean allowAnimatedEmojis, boolean autoPlayGifs, boolean isThreadStarterMessage) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(embed, "embed");
        return new EmbedEntry(embedIndex, guildId, message, messageState, embed, isBlockedExpanded, allowAnimatedEmojis, autoPlayGifs, isThreadStarterMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedEntry)) {
            return false;
        }
        EmbedEntry embedEntry = (EmbedEntry) other;
        return this.embedIndex == embedEntry.embedIndex && this.guildId == embedEntry.guildId && Intrinsics3.areEqual(this.message, embedEntry.message) && Intrinsics3.areEqual(this.messageState, embedEntry.messageState) && Intrinsics3.areEqual(this.embed, embedEntry.embed) && this.isBlockedExpanded == embedEntry.isBlockedExpanded && this.allowAnimatedEmojis == embedEntry.allowAnimatedEmojis && this.autoPlayGifs == embedEntry.autoPlayGifs && this.isThreadStarterMessage == embedEntry.isThreadStarterMessage;
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    public final MessageEmbed getEmbed() {
        return this.embed;
    }

    public final int getEmbedIndex() {
        return this.embedIndex;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final StoreMessageState.State getMessageState() {
        return this.messageState;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = (b.a(this.guildId) + (this.embedIndex * 31)) * 31;
        Message message = this.message;
        int iHashCode = (iA + (message != null ? message.hashCode() : 0)) * 31;
        StoreMessageState.State state = this.messageState;
        int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
        MessageEmbed messageEmbed = this.embed;
        int iHashCode3 = (iHashCode2 + (messageEmbed != null ? messageEmbed.hashCode() : 0)) * 31;
        boolean z2 = this.isBlockedExpanded;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.allowAnimatedEmojis;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.autoPlayGifs;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z5 = this.isThreadStarterMessage;
        return i6 + (z5 ? 1 : z5 ? 1 : 0);
    }

    public final boolean isBlockedExpanded() {
        return this.isBlockedExpanded;
    }

    @Override // com.discord.widgets.chat.list.entries.ChatListEntry
    public boolean isInExpandedBlockedMessageChunk() {
        return this.isBlockedExpanded;
    }

    public final boolean isThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public String toString() {
        StringBuilder sbU = outline.U("EmbedEntry(embedIndex=");
        sbU.append(this.embedIndex);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", messageState=");
        sbU.append(this.messageState);
        sbU.append(", embed=");
        sbU.append(this.embed);
        sbU.append(", isBlockedExpanded=");
        sbU.append(this.isBlockedExpanded);
        sbU.append(", allowAnimatedEmojis=");
        sbU.append(this.allowAnimatedEmojis);
        sbU.append(", autoPlayGifs=");
        sbU.append(this.autoPlayGifs);
        sbU.append(", isThreadStarterMessage=");
        return outline.O(sbU, this.isThreadStarterMessage, ")");
    }
}
