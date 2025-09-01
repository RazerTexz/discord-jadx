package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: UploadProgressEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\u0010\n\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\f\b\u0002\u0010\n\u001a\u00060\u0005j\u0002`\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\n\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u00020\u000e8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/list/entries/UploadProgressEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/ChannelId;", "component2", "()J", "messageNonce", "channelId", "copy", "(Ljava/lang/String;J)Lcom/discord/widgets/chat/list/entries/UploadProgressEntry;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "type", "I", "getType", "Ljava/lang/String;", "getMessageNonce", "key", "getKey", "<init>", "(Ljava/lang/String;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class UploadProgressEntry extends ChatListEntry {
    private final long channelId;
    private final String key;
    private final String messageNonce;
    private final int type;

    public UploadProgressEntry(String str, long j) {
        Intrinsics3.checkNotNullParameter(str, "messageNonce");
        this.messageNonce = str;
        this.channelId = j;
        this.type = 6;
        this.key = getType() + ' ' + str;
    }

    public static /* synthetic */ UploadProgressEntry copy$default(UploadProgressEntry uploadProgressEntry, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadProgressEntry.messageNonce;
        }
        if ((i & 2) != 0) {
            j = uploadProgressEntry.channelId;
        }
        return uploadProgressEntry.copy(str, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMessageNonce() {
        return this.messageNonce;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final UploadProgressEntry copy(String messageNonce, long channelId) {
        Intrinsics3.checkNotNullParameter(messageNonce, "messageNonce");
        return new UploadProgressEntry(messageNonce, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadProgressEntry)) {
            return false;
        }
        UploadProgressEntry uploadProgressEntry = (UploadProgressEntry) other;
        return Intrinsics3.areEqual(this.messageNonce, uploadProgressEntry.messageNonce) && this.channelId == uploadProgressEntry.channelId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getMessageNonce() {
        return this.messageNonce;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.messageNonce;
        return b.a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("UploadProgressEntry(messageNonce=");
        sbU.append(this.messageNonce);
        sbU.append(", channelId=");
        return outline.C(sbU, this.channelId, ")");
    }
}
