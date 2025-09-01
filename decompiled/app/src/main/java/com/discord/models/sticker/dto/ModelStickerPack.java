package com.discord.models.sticker.dto;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSku;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelStickerPack.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\n\u0010\u001f\u001a\u00060\u000bj\u0002`\f\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012\n\u0010#\u001a\u00060\u000bj\u0002`\u0018\u0012\u000e\u0010$\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\u001a\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b=\u0010>J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\r\u001a\u00060\u000bj\u0002`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0019\u001a\u00060\u000bj\u0002`\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000eJ\u0018\u0010\u001b\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0014J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ|\u0010'\u001a\u00020\u00002\f\b\u0002\u0010\u001f\u001a\u00060\u000bj\u0002`\f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\b\b\u0002\u0010!\u001a\u00020\u00122\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00152\f\b\u0002\u0010#\u001a\u00060\u000bj\u0002`\u00182\u0010\b\u0002\u0010$\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b)\u0010\u0014J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/R\u001d\u0010#\u001a\u00060\u000bj\u0002`\u00188\u0006@\u0006¢\u0006\f\n\u0004\b#\u00100\u001a\u0004\b1\u0010\u000eR\u001d\u0010\u001f\u001a\u00060\u000bj\u0002`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b2\u0010\u000eR\u001b\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00103\u001a\u0004\b4\u0010\u0017R\u0019\u0010!\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b!\u00105\u001a\u0004\b6\u0010\u0014R!\u0010$\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00107\u001a\u0004\b8\u0010\u001cR\u001b\u0010%\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\b9\u0010\u0014R\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010:\u001a\u0004\b;\u0010\u0011R\u001b\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u00107\u001a\u0004\b<\u0010\u001c¨\u0006?"}, d2 = {"Lcom/discord/models/sticker/dto/ModelStickerPack;", "", "", "canBePurchased", "()Z", "isAnimatedPack", "isPremiumPack", "isLimitedPack", "Lcom/discord/api/sticker/Sticker;", "getCoverSticker", "()Lcom/discord/api/sticker/Sticker;", "", "Lcom/discord/primitives/StickerPackId;", "component1", "()J", "", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/String;", "Lcom/discord/models/sticker/dto/ModelStickerPackStoreListing;", "component4", "()Lcom/discord/models/sticker/dto/ModelStickerPackStoreListing;", "Lcom/discord/primitives/SkuId;", "component5", "Lcom/discord/primitives/StickerId;", "component6", "()Ljava/lang/Long;", "component7", "component8", ModelAuditLogEntry.CHANGE_KEY_ID, "stickers", ModelAuditLogEntry.CHANGE_KEY_NAME, "storeListing", "skuId", "coverStickerId", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "bannerAssetId", "copy", "(JLjava/util/List;Ljava/lang/String;Lcom/discord/models/sticker/dto/ModelStickerPackStoreListing;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/discord/models/sticker/dto/ModelStickerPack;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getSkuId", "getId", "Lcom/discord/models/sticker/dto/ModelStickerPackStoreListing;", "getStoreListing", "Ljava/lang/String;", "getName", "Ljava/lang/Long;", "getCoverStickerId", "getDescription", "Ljava/util/List;", "getStickers", "getBannerAssetId", "<init>", "(JLjava/util/List;Ljava/lang/String;Lcom/discord/models/sticker/dto/ModelStickerPackStoreListing;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelStickerPack {
    private final Long bannerAssetId;
    private final Long coverStickerId;
    private final String description;
    private final long id;
    private final String name;
    private final long skuId;
    private final List<Sticker> stickers;
    private final ModelStickerPackStoreListing storeListing;

    public ModelStickerPack(long j, List<Sticker> list, String str, ModelStickerPackStoreListing modelStickerPackStoreListing, long j2, Long l, String str2, Long l2) {
        Intrinsics3.checkNotNullParameter(list, "stickers");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.stickers = list;
        this.name = str;
        this.storeListing = modelStickerPackStoreListing;
        this.skuId = j2;
        this.coverStickerId = l;
        this.description = str2;
        this.bannerAssetId = l2;
    }

    public static /* synthetic */ ModelStickerPack copy$default(ModelStickerPack modelStickerPack, long j, List list, String str, ModelStickerPackStoreListing modelStickerPackStoreListing, long j2, Long l, String str2, Long l2, int i, Object obj) {
        return modelStickerPack.copy((i & 1) != 0 ? modelStickerPack.id : j, (i & 2) != 0 ? modelStickerPack.stickers : list, (i & 4) != 0 ? modelStickerPack.name : str, (i & 8) != 0 ? modelStickerPack.storeListing : modelStickerPackStoreListing, (i & 16) != 0 ? modelStickerPack.skuId : j2, (i & 32) != 0 ? modelStickerPack.coverStickerId : l, (i & 64) != 0 ? modelStickerPack.description : str2, (i & 128) != 0 ? modelStickerPack.bannerAssetId : l2);
    }

    public final boolean canBePurchased() {
        ModelStickerPackStoreListing modelStickerPackStoreListing = this.storeListing;
        return modelStickerPackStoreListing != null && modelStickerPackStoreListing.getSku().isAvailable();
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<Sticker> component2() {
        return this.stickers;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final ModelStickerPackStoreListing getStoreListing() {
        return this.storeListing;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getCoverStickerId() {
        return this.coverStickerId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getBannerAssetId() {
        return this.bannerAssetId;
    }

    public final ModelStickerPack copy(long id2, List<Sticker> stickers, String name, ModelStickerPackStoreListing storeListing, long skuId, Long coverStickerId, String description, Long bannerAssetId) {
        Intrinsics3.checkNotNullParameter(stickers, "stickers");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ModelStickerPack(id2, stickers, name, storeListing, skuId, coverStickerId, description, bannerAssetId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStickerPack)) {
            return false;
        }
        ModelStickerPack modelStickerPack = (ModelStickerPack) other;
        return this.id == modelStickerPack.id && Intrinsics3.areEqual(this.stickers, modelStickerPack.stickers) && Intrinsics3.areEqual(this.name, modelStickerPack.name) && Intrinsics3.areEqual(this.storeListing, modelStickerPack.storeListing) && this.skuId == modelStickerPack.skuId && Intrinsics3.areEqual(this.coverStickerId, modelStickerPack.coverStickerId) && Intrinsics3.areEqual(this.description, modelStickerPack.description) && Intrinsics3.areEqual(this.bannerAssetId, modelStickerPack.bannerAssetId);
    }

    public final Long getBannerAssetId() {
        return this.bannerAssetId;
    }

    public final Sticker getCoverSticker() {
        Object next;
        Iterator<T> it = this.stickers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            long id2 = ((Sticker) next).getId();
            Long l = this.coverStickerId;
            if (l != null && id2 == l.longValue()) {
                break;
            }
        }
        Sticker sticker = (Sticker) next;
        return sticker != null ? sticker : this.stickers.get(0);
    }

    public final Long getCoverStickerId() {
        return this.coverStickerId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final List<Sticker> getStickers() {
        return this.stickers;
    }

    public final ModelStickerPackStoreListing getStoreListing() {
        return this.storeListing;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<Sticker> list = this.stickers;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        ModelStickerPackStoreListing modelStickerPackStoreListing = this.storeListing;
        int iHashCode3 = modelStickerPackStoreListing != null ? modelStickerPackStoreListing.hashCode() : 0;
        long j2 = this.skuId;
        int i2 = (((iHashCode2 + iHashCode3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Long l = this.coverStickerId;
        int iHashCode4 = (i2 + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l2 = this.bannerAssetId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public final boolean isAnimatedPack() {
        List<Sticker> list = this.stickers;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Sticker) it.next()).l()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isLimitedPack() {
        ModelStickerPackStoreListing modelStickerPackStoreListing = this.storeListing;
        return (modelStickerPackStoreListing != null ? modelStickerPackStoreListing.getUnpublishedAt() : null) != null;
    }

    public final boolean isPremiumPack() {
        ModelSku sku;
        ModelStickerPackStoreListing modelStickerPackStoreListing = this.storeListing;
        if (modelStickerPackStoreListing == null || (sku = modelStickerPackStoreListing.getSku()) == null) {
            return false;
        }
        return sku.getPremium();
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStickerPack(id=");
        sbU.append(this.id);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", storeListing=");
        sbU.append(this.storeListing);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", coverStickerId=");
        sbU.append(this.coverStickerId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", bannerAssetId=");
        return outline.G(sbU, this.bannerAssetId, ")");
    }
}
