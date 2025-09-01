package com.discord.widgets.chat.list.entries;

import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: EphemeralMessageEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/chat/list/entries/EphemeralMessageEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "type", "I", "getType", "()I", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/models/message/Message;", "getMessage", "()Lcom/discord/models/message/Message;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "(Lcom/discord/models/message/Message;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EphemeralMessageEntry extends ChatListEntry {
    private final String key;
    private final Message message;
    private final int type;

    public EphemeralMessageEntry(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.message = message;
        this.type = 34;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(' ');
        Object nonce = message.getNonce();
        sb.append(nonce == null ? Long.valueOf(message.getId()) : nonce);
        this.key = sb.toString();
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
}
