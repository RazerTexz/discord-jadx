package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GiftEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ<\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00128\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u001c\u0010\u001d\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\"\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b#\u0010\u0004R\u001d\u0010\r\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/discord/widgets/chat/list/entries/GiftEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "component1", "()J", "component2", "Lcom/discord/primitives/ChannelId;", "component3", "", "component4", "()Ljava/lang/String;", "userId", "messageId", "channelId", "giftCode", "copy", "(JJJLjava/lang/String;)Lcom/discord/widgets/chat/list/entries/GiftEntry;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "J", "getUserId", "getGiftCode", "getMessageId", "getChannelId", "<init>", "(JJJLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GiftEntry extends ChatListEntry {
    private final long channelId;
    private final String giftCode;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public GiftEntry(long j, long j2, long j3, String str) {
        Intrinsics3.checkNotNullParameter(str, "giftCode");
        this.userId = j;
        this.messageId = j2;
        this.channelId = j3;
        this.giftCode = str;
        this.type = 26;
        this.key = "26 -- " + j2 + " -- " + str;
    }

    public static /* synthetic */ GiftEntry copy$default(GiftEntry giftEntry, long j, long j2, long j3, String str, int i, Object obj) {
        return giftEntry.copy((i & 1) != 0 ? giftEntry.userId : j, (i & 2) != 0 ? giftEntry.messageId : j2, (i & 4) != 0 ? giftEntry.channelId : j3, (i & 8) != 0 ? giftEntry.giftCode : str);
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
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getGiftCode() {
        return this.giftCode;
    }

    public final GiftEntry copy(long userId, long messageId, long channelId, String giftCode) {
        Intrinsics3.checkNotNullParameter(giftCode, "giftCode");
        return new GiftEntry(userId, messageId, channelId, giftCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftEntry)) {
            return false;
        }
        GiftEntry giftEntry = (GiftEntry) other;
        return this.userId == giftEntry.userId && this.messageId == giftEntry.messageId && this.channelId == giftEntry.channelId && Intrinsics3.areEqual(this.giftCode, giftEntry.giftCode);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getGiftCode() {
        return this.giftCode;
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
        int iA = (b.a(this.channelId) + ((b.a(this.messageId) + (b.a(this.userId) * 31)) * 31)) * 31;
        String str = this.giftCode;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GiftEntry(userId=");
        sbU.append(this.userId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", giftCode=");
        return outline.J(sbU, this.giftCode, ")");
    }
}
