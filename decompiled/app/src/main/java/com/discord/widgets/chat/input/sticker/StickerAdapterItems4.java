package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StickerAdapterItems.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\u001a\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "component1", "()Lcom/discord/models/sticker/dto/ModelStickerPack;", "", "component2", "()Z", "pack", "isNewPack", "copy", "(Lcom/discord/models/sticker/dto/ModelStickerPack;Z)Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "getPack", "<init>", "(Lcom/discord/models/sticker/dto/ModelStickerPack;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.StoreHeaderItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class StickerAdapterItems4 implements MGRecyclerDataPayload {
    private final boolean isNewPack;
    private final String key;
    private final ModelStickerPack pack;
    private final int type;

    public StickerAdapterItems4(ModelStickerPack modelStickerPack, boolean z2) {
        Intrinsics3.checkNotNullParameter(modelStickerPack, "pack");
        this.pack = modelStickerPack;
        this.isNewPack = z2;
        this.type = 2;
        StringBuilder sbU = outline.U("store-header:");
        sbU.append(modelStickerPack.getId());
        this.key = sbU.toString();
    }

    public static /* synthetic */ StickerAdapterItems4 copy$default(StickerAdapterItems4 stickerAdapterItems4, ModelStickerPack modelStickerPack, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelStickerPack = stickerAdapterItems4.pack;
        }
        if ((i & 2) != 0) {
            z2 = stickerAdapterItems4.isNewPack;
        }
        return stickerAdapterItems4.copy(modelStickerPack, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelStickerPack getPack() {
        return this.pack;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsNewPack() {
        return this.isNewPack;
    }

    public final StickerAdapterItems4 copy(ModelStickerPack pack, boolean isNewPack) {
        Intrinsics3.checkNotNullParameter(pack, "pack");
        return new StickerAdapterItems4(pack, isNewPack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerAdapterItems4)) {
            return false;
        }
        StickerAdapterItems4 stickerAdapterItems4 = (StickerAdapterItems4) other;
        return Intrinsics3.areEqual(this.pack, stickerAdapterItems4.pack) && this.isNewPack == stickerAdapterItems4.isNewPack;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final ModelStickerPack getPack() {
        return this.pack;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ModelStickerPack modelStickerPack = this.pack;
        int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
        boolean z2 = this.isNewPack;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isNewPack() {
        return this.isNewPack;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StoreHeaderItem(pack=");
        sbU.append(this.pack);
        sbU.append(", isNewPack=");
        return outline.O(sbU, this.isNewPack, ")");
    }
}
