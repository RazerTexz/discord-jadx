package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StickerGreetEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\u0010\u0010\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ<\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\f\b\u0002\u0010\u0010\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000eJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0010\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u000bR\u001c\u0010!\u001a\u00020\f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u000eR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b$\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b'\u0010\u000e¨\u0006*"}, d2 = {"Lcom/discord/widgets/chat/list/entries/StickerGreetEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/api/sticker/Sticker;", "component1", "()Lcom/discord/api/sticker/Sticker;", "", "Lcom/discord/primitives/ChannelId;", "component2", "()J", "", "component3", "()Ljava/lang/String;", "", "component4", "()I", "sticker", "channelId", "channelName", "channelType", "copy", "(Lcom/discord/api/sticker/Sticker;JLjava/lang/String;I)Lcom/discord/widgets/chat/list/entries/StickerGreetEntry;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "getChannelName", "Lcom/discord/api/sticker/Sticker;", "getSticker", "getChannelType", "<init>", "(Lcom/discord/api/sticker/Sticker;JLjava/lang/String;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class StickerGreetEntry extends ChatListEntry {
    private final long channelId;
    private final String channelName;
    private final int channelType;
    private final String key;
    private final Sticker sticker;
    private final int type;

    public StickerGreetEntry(Sticker sticker, long j, String str, int i) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(str, "channelName");
        this.sticker = sticker;
        this.channelId = j;
        this.channelName = str;
        this.channelType = i;
        this.type = 41;
        this.key = getType() + " -- " + sticker.getId();
    }

    public static /* synthetic */ StickerGreetEntry copy$default(StickerGreetEntry stickerGreetEntry, Sticker sticker, long j, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = stickerGreetEntry.sticker;
        }
        if ((i2 & 2) != 0) {
            j = stickerGreetEntry.channelId;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            str = stickerGreetEntry.channelName;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            i = stickerGreetEntry.channelType;
        }
        return stickerGreetEntry.copy(sticker, j2, str2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    public final StickerGreetEntry copy(Sticker sticker, long channelId, String channelName, int channelType) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        return new StickerGreetEntry(sticker, channelId, channelName, channelType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerGreetEntry)) {
            return false;
        }
        StickerGreetEntry stickerGreetEntry = (StickerGreetEntry) other;
        return Intrinsics3.areEqual(this.sticker, stickerGreetEntry.sticker) && this.channelId == stickerGreetEntry.channelId && Intrinsics3.areEqual(this.channelName, stickerGreetEntry.channelName) && this.channelType == stickerGreetEntry.channelType;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iA = (b.a(this.channelId) + ((sticker != null ? sticker.hashCode() : 0) * 31)) * 31;
        String str = this.channelName;
        return ((iA + (str != null ? str.hashCode() : 0)) * 31) + this.channelType;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerGreetEntry(sticker=");
        sbU.append(this.sticker);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", channelType=");
        return outline.B(sbU, this.channelType, ")");
    }
}
