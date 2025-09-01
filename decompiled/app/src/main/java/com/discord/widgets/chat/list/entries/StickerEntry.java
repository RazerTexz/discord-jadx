package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.api.sticker.BaseSticker;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StickerEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000eR\u001c\u0010\u001e\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0011¨\u0006#"}, d2 = {"Lcom/discord/widgets/chat/list/entries/StickerEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "Lcom/discord/api/sticker/BaseSticker;", "component2", "()Lcom/discord/api/sticker/BaseSticker;", "message", "sticker", "copy", "(Lcom/discord/models/message/Message;Lcom/discord/api/sticker/BaseSticker;)Lcom/discord/widgets/chat/list/entries/StickerEntry;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/sticker/BaseSticker;", "getSticker", "Lcom/discord/models/message/Message;", "getMessage", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "<init>", "(Lcom/discord/models/message/Message;Lcom/discord/api/sticker/BaseSticker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class StickerEntry extends ChatListEntry {
    private final String key;
    private final Message message;
    private final BaseSticker sticker;
    private final int type;

    public StickerEntry(Message message, BaseSticker baseSticker) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
        this.message = message;
        this.sticker = baseSticker;
        this.type = 31;
        this.key = getType() + " -- " + message.getId() + " -- " + baseSticker.getId();
    }

    public static /* synthetic */ StickerEntry copy$default(StickerEntry stickerEntry, Message message, BaseSticker baseSticker, int i, Object obj) {
        if ((i & 1) != 0) {
            message = stickerEntry.message;
        }
        if ((i & 2) != 0) {
            baseSticker = stickerEntry.sticker;
        }
        return stickerEntry.copy(message, baseSticker);
    }

    /* renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final BaseSticker getSticker() {
        return this.sticker;
    }

    public final StickerEntry copy(Message message, BaseSticker sticker) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        return new StickerEntry(message, sticker);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerEntry)) {
            return false;
        }
        StickerEntry stickerEntry = (StickerEntry) other;
        return Intrinsics3.areEqual(this.message, stickerEntry.message) && Intrinsics3.areEqual(this.sticker, stickerEntry.sticker);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final BaseSticker getSticker() {
        return this.sticker;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        BaseSticker baseSticker = this.sticker;
        return iHashCode + (baseSticker != null ? baseSticker.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerEntry(message=");
        sbU.append(this.message);
        sbU.append(", sticker=");
        sbU.append(this.sticker);
        sbU.append(")");
        return sbU.toString();
    }
}
