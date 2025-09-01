package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: AutoModSystemMessageEmbedEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\"\u001a\u00020\u0011\u0012\u0018\u0010#\u001a\u0014\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014\u0012\u0016\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u001a\u0012\u0004\u0012\u00020\u001b0\u0014¢\u0006\u0004\bE\u0010FJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0018\u001a\u0014\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u001a\u0012\u0004\u0012\u00020\u001b0\u0014HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0019J\u0086\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\"\u001a\u00020\u00112\u001a\b\u0002\u0010#\u001a\u0014\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00142\u0018\b\u0002\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u001a\u0012\u0004\u0012\u00020\u001b0\u0014HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010.\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/R\u001b\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b1\u0010\u0010R\u001c\u00102\u001a\u00020)8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010+R\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b6\u0010\rR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u0010\nR\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010;\u001a\u0004\b<\u0010\u0007R\u001c\u0010=\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010(R+\u0010#\u001a\u0014\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010@\u001a\u0004\bA\u0010\u0019R\u0019\u0010\"\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010B\u001a\u0004\bC\u0010\u0013R)\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0015j\u0002`\u001a\u0012\u0004\u0012\u00020\u001b0\u00148\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bD\u0010\u0019¨\u0006G"}, d2 = {"Lcom/discord/widgets/chat/list/entries/AutoModSystemMessageEmbedEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/message/Message;", "component2", "()Lcom/discord/models/message/Message;", "Lcom/discord/stores/StoreMessageState$State;", "component3", "()Lcom/discord/stores/StoreMessageState$State;", "Lcom/discord/api/message/embed/MessageEmbed;", "component4", "()Lcom/discord/api/message/embed/MessageEmbed;", "Lcom/discord/models/member/GuildMember;", "component5", "()Lcom/discord/models/member/GuildMember;", "", "component6", "()Z", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component7", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "", "component8", "channel", "message", "messageState", "embed", "author", "animateEmojis", "roles", "nickOrUsernames", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;Lcom/discord/api/message/embed/MessageEmbed;Lcom/discord/models/member/GuildMember;ZLjava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/chat/list/entries/AutoModSystemMessageEmbedEntry;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/member/GuildMember;", "getAuthor", "type", "I", "getType", "Lcom/discord/api/message/embed/MessageEmbed;", "getEmbed", "Lcom/discord/stores/StoreMessageState$State;", "getMessageState", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/message/Message;", "getMessage", "key", "Ljava/lang/String;", "getKey", "Ljava/util/Map;", "getRoles", "Z", "getAnimateEmojis", "getNickOrUsernames", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;Lcom/discord/api/message/embed/MessageEmbed;Lcom/discord/models/member/GuildMember;ZLjava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class AutoModSystemMessageEmbedEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final GuildMember author;
    private final Channel channel;
    private final MessageEmbed embed;
    private final String key;
    private final Message message;
    private final StoreMessageState.State messageState;
    private final Map<Long, String> nickOrUsernames;
    private final Map<Long, GuildRole> roles;
    private final int type;

    public AutoModSystemMessageEmbedEntry(Channel channel, Message message, StoreMessageState.State state, MessageEmbed messageEmbed, GuildMember guildMember, boolean z2, Map<Long, GuildRole> map, Map<Long, String> map2) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(messageEmbed, "embed");
        Intrinsics3.checkNotNullParameter(map2, "nickOrUsernames");
        this.channel = channel;
        this.message = message;
        this.messageState = state;
        this.embed = messageEmbed;
        this.author = guildMember;
        this.animateEmojis = z2;
        this.roles = map;
        this.nickOrUsernames = map2;
        this.type = 45;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(message.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ AutoModSystemMessageEmbedEntry copy$default(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry, Channel channel, Message message, StoreMessageState.State state, MessageEmbed messageEmbed, GuildMember guildMember, boolean z2, Map map, Map map2, int i, Object obj) {
        return autoModSystemMessageEmbedEntry.copy((i & 1) != 0 ? autoModSystemMessageEmbedEntry.channel : channel, (i & 2) != 0 ? autoModSystemMessageEmbedEntry.message : message, (i & 4) != 0 ? autoModSystemMessageEmbedEntry.messageState : state, (i & 8) != 0 ? autoModSystemMessageEmbedEntry.embed : messageEmbed, (i & 16) != 0 ? autoModSystemMessageEmbedEntry.author : guildMember, (i & 32) != 0 ? autoModSystemMessageEmbedEntry.animateEmojis : z2, (i & 64) != 0 ? autoModSystemMessageEmbedEntry.roles : map, (i & 128) != 0 ? autoModSystemMessageEmbedEntry.nickOrUsernames : map2);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final StoreMessageState.State getMessageState() {
        return this.messageState;
    }

    /* renamed from: component4, reason: from getter */
    public final MessageEmbed getEmbed() {
        return this.embed;
    }

    /* renamed from: component5, reason: from getter */
    public final GuildMember getAuthor() {
        return this.author;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final Map<Long, GuildRole> component7() {
        return this.roles;
    }

    public final Map<Long, String> component8() {
        return this.nickOrUsernames;
    }

    public final AutoModSystemMessageEmbedEntry copy(Channel channel, Message message, StoreMessageState.State messageState, MessageEmbed embed, GuildMember author, boolean animateEmojis, Map<Long, GuildRole> roles, Map<Long, String> nickOrUsernames) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(embed, "embed");
        Intrinsics3.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
        return new AutoModSystemMessageEmbedEntry(channel, message, messageState, embed, author, animateEmojis, roles, nickOrUsernames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoModSystemMessageEmbedEntry)) {
            return false;
        }
        AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry = (AutoModSystemMessageEmbedEntry) other;
        return Intrinsics3.areEqual(this.channel, autoModSystemMessageEmbedEntry.channel) && Intrinsics3.areEqual(this.message, autoModSystemMessageEmbedEntry.message) && Intrinsics3.areEqual(this.messageState, autoModSystemMessageEmbedEntry.messageState) && Intrinsics3.areEqual(this.embed, autoModSystemMessageEmbedEntry.embed) && Intrinsics3.areEqual(this.author, autoModSystemMessageEmbedEntry.author) && this.animateEmojis == autoModSystemMessageEmbedEntry.animateEmojis && Intrinsics3.areEqual(this.roles, autoModSystemMessageEmbedEntry.roles) && Intrinsics3.areEqual(this.nickOrUsernames, autoModSystemMessageEmbedEntry.nickOrUsernames);
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final GuildMember getAuthor() {
        return this.author;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final MessageEmbed getEmbed() {
        return this.embed;
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

    public final Map<Long, String> getNickOrUsernames() {
        return this.nickOrUsernames;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Message message = this.message;
        int iHashCode2 = (iHashCode + (message != null ? message.hashCode() : 0)) * 31;
        StoreMessageState.State state = this.messageState;
        int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
        MessageEmbed messageEmbed = this.embed;
        int iHashCode4 = (iHashCode3 + (messageEmbed != null ? messageEmbed.hashCode() : 0)) * 31;
        GuildMember guildMember = this.author;
        int iHashCode5 = (iHashCode4 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        boolean z2 = this.animateEmojis;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode5 + i) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode6 = (i2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.nickOrUsernames;
        return iHashCode6 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AutoModSystemMessageEmbedEntry(channel=");
        sbU.append(this.channel);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", messageState=");
        sbU.append(this.messageState);
        sbU.append(", embed=");
        sbU.append(this.embed);
        sbU.append(", author=");
        sbU.append(this.author);
        sbU.append(", animateEmojis=");
        sbU.append(this.animateEmojis);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", nickOrUsernames=");
        return outline.M(sbU, this.nickOrUsernames, ")");
    }
}
