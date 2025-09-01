package com.discord.widgets.chat.list.entries;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: MessageHeaderEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b!\u0010\"B%\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b!\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\u001f\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u0007¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/list/entries/MessageHeaderEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "", "component2", "()Ljava/lang/String;", "component3", "message", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "channelName", "copy", "(Lcom/discord/models/message/Message;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/chat/list/entries/MessageHeaderEntry;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/message/Message;", "getMessage", "type", "I", "getType", "Ljava/lang/String;", "getChannelName", "getText", "key", "getKey", "<init>", "(Lcom/discord/models/message/Message;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/models/guild/Guild;", "guild", "(Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class MessageHeaderEntry extends ChatListEntry {
    private final String channelName;
    private final String key;
    private final Message message;
    private final String text;
    private final int type;

    public MessageHeaderEntry(Message message, String str, String str2) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.message = message;
        this.text = str;
        this.channelName = str2;
        this.type = 17;
        this.key = String.valueOf(getType());
    }

    public static /* synthetic */ MessageHeaderEntry copy$default(MessageHeaderEntry messageHeaderEntry, Message message, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            message = messageHeaderEntry.message;
        }
        if ((i & 2) != 0) {
            str = messageHeaderEntry.text;
        }
        if ((i & 4) != 0) {
            str2 = messageHeaderEntry.channelName;
        }
        return messageHeaderEntry.copy(message, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    public final MessageHeaderEntry copy(Message message, String text, String channelName) {
        Intrinsics3.checkNotNullParameter(message, "message");
        return new MessageHeaderEntry(message, text, channelName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageHeaderEntry)) {
            return false;
        }
        MessageHeaderEntry messageHeaderEntry = (MessageHeaderEntry) other;
        return Intrinsics3.areEqual(this.message, messageHeaderEntry.message) && Intrinsics3.areEqual(this.text, messageHeaderEntry.text) && Intrinsics3.areEqual(this.channelName, messageHeaderEntry.channelName);
    }

    public final String getChannelName() {
        return this.channelName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        String str = this.text;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channelName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageHeaderEntry(message=");
        sbU.append(this.message);
        sbU.append(", text=");
        sbU.append(this.text);
        sbU.append(", channelName=");
        return outline.J(sbU, this.channelName, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageHeaderEntry(Message message, Channel channel, Guild guild) {
        this(message, guild != null ? guild.getName() : null, channel != null ? ChannelUtils.c(channel) : null);
        Intrinsics3.checkNotNullParameter(message, "message");
    }
}
