package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StickerAdapterItems.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/HeaderItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/widgets/chat/input/sticker/HeaderType;", "component1", "()Lcom/discord/widgets/chat/input/sticker/HeaderType;", "headerType", "copy", "(Lcom/discord/widgets/chat/input/sticker/HeaderType;)Lcom/discord/widgets/chat/input/sticker/HeaderItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/widgets/chat/input/sticker/HeaderType;", "getHeaderType", "type", "I", "getType", "<init>", "(Lcom/discord/widgets/chat/input/sticker/HeaderType;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.HeaderItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class StickerAdapterItems implements MGRecyclerDataPayload {
    private final StickerAdapterItems2 headerType;
    private final String key;
    private final int type;

    public StickerAdapterItems(StickerAdapterItems2 stickerAdapterItems2) {
        Intrinsics3.checkNotNullParameter(stickerAdapterItems2, "headerType");
        this.headerType = stickerAdapterItems2;
        this.key = stickerAdapterItems2.getId();
    }

    public static /* synthetic */ StickerAdapterItems copy$default(StickerAdapterItems stickerAdapterItems, StickerAdapterItems2 stickerAdapterItems2, int i, Object obj) {
        if ((i & 1) != 0) {
            stickerAdapterItems2 = stickerAdapterItems.headerType;
        }
        return stickerAdapterItems.copy(stickerAdapterItems2);
    }

    /* renamed from: component1, reason: from getter */
    public final StickerAdapterItems2 getHeaderType() {
        return this.headerType;
    }

    public final StickerAdapterItems copy(StickerAdapterItems2 headerType) {
        Intrinsics3.checkNotNullParameter(headerType, "headerType");
        return new StickerAdapterItems(headerType);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StickerAdapterItems) && Intrinsics3.areEqual(this.headerType, ((StickerAdapterItems) other).headerType);
        }
        return true;
    }

    public final StickerAdapterItems2 getHeaderType() {
        return this.headerType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        StickerAdapterItems2 stickerAdapterItems2 = this.headerType;
        if (stickerAdapterItems2 != null) {
            return stickerAdapterItems2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HeaderItem(headerType=");
        sbU.append(this.headerType);
        sbU.append(")");
        return sbU.toString();
    }
}
