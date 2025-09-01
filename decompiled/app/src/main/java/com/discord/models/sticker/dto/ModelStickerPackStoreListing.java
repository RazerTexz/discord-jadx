package com.discord.models.sticker.dto;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSku;
import com.discord.models.store.dto.ModelStoreAsset;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelStickerPackStoreListing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b(\u0010)J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJF\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\u000fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b'\u0010\u000b¨\u0006*"}, d2 = {"Lcom/discord/models/sticker/dto/ModelStickerPackStoreListing;", "", "", "getUnpublishedAtDate", "()J", "Lcom/discord/models/domain/ModelSku;", "component1", "()Lcom/discord/models/domain/ModelSku;", "component2", "", "component3", "()Ljava/lang/String;", "component4", "Lcom/discord/models/store/dto/ModelStoreAsset;", "component5", "()Lcom/discord/models/store/dto/ModelStoreAsset;", "sku", ModelAuditLogEntry.CHANGE_KEY_ID, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "unpublishedAt", "thumbnail", "copy", "(Lcom/discord/models/domain/ModelSku;JLjava/lang/String;Ljava/lang/String;Lcom/discord/models/store/dto/ModelStoreAsset;)Lcom/discord/models/sticker/dto/ModelStickerPackStoreListing;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "J", "getId", "Lcom/discord/models/domain/ModelSku;", "getSku", "Lcom/discord/models/store/dto/ModelStoreAsset;", "getThumbnail", "getUnpublishedAt", "<init>", "(Lcom/discord/models/domain/ModelSku;JLjava/lang/String;Ljava/lang/String;Lcom/discord/models/store/dto/ModelStoreAsset;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelStickerPackStoreListing {
    private final String description;
    private final long id;
    private final ModelSku sku;
    private final ModelStoreAsset thumbnail;
    private final String unpublishedAt;

    public ModelStickerPackStoreListing(ModelSku modelSku, long j, String str, String str2, ModelStoreAsset modelStoreAsset) {
        Intrinsics3.checkNotNullParameter(modelSku, "sku");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.sku = modelSku;
        this.id = j;
        this.description = str;
        this.unpublishedAt = str2;
        this.thumbnail = modelStoreAsset;
    }

    public static /* synthetic */ ModelStickerPackStoreListing copy$default(ModelStickerPackStoreListing modelStickerPackStoreListing, ModelSku modelSku, long j, String str, String str2, ModelStoreAsset modelStoreAsset, int i, Object obj) {
        if ((i & 1) != 0) {
            modelSku = modelStickerPackStoreListing.sku;
        }
        if ((i & 2) != 0) {
            j = modelStickerPackStoreListing.id;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str = modelStickerPackStoreListing.description;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = modelStickerPackStoreListing.unpublishedAt;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            modelStoreAsset = modelStickerPackStoreListing.thumbnail;
        }
        return modelStickerPackStoreListing.copy(modelSku, j2, str3, str4, modelStoreAsset);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelSku getSku() {
        return this.sku;
    }

    /* renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUnpublishedAt() {
        return this.unpublishedAt;
    }

    /* renamed from: component5, reason: from getter */
    public final ModelStoreAsset getThumbnail() {
        return this.thumbnail;
    }

    public final ModelStickerPackStoreListing copy(ModelSku sku, long id2, String description, String unpublishedAt, ModelStoreAsset thumbnail) {
        Intrinsics3.checkNotNullParameter(sku, "sku");
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return new ModelStickerPackStoreListing(sku, id2, description, unpublishedAt, thumbnail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStickerPackStoreListing)) {
            return false;
        }
        ModelStickerPackStoreListing modelStickerPackStoreListing = (ModelStickerPackStoreListing) other;
        return Intrinsics3.areEqual(this.sku, modelStickerPackStoreListing.sku) && this.id == modelStickerPackStoreListing.id && Intrinsics3.areEqual(this.description, modelStickerPackStoreListing.description) && Intrinsics3.areEqual(this.unpublishedAt, modelStickerPackStoreListing.unpublishedAt) && Intrinsics3.areEqual(this.thumbnail, modelStickerPackStoreListing.thumbnail);
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getId() {
        return this.id;
    }

    public final ModelSku getSku() {
        return this.sku;
    }

    public final ModelStoreAsset getThumbnail() {
        return this.thumbnail;
    }

    public final String getUnpublishedAt() {
        return this.unpublishedAt;
    }

    public final long getUnpublishedAtDate() {
        return TimeUtils.parseUTCDate(this.unpublishedAt);
    }

    public int hashCode() {
        ModelSku modelSku = this.sku;
        int iHashCode = modelSku != null ? modelSku.hashCode() : 0;
        long j = this.id;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.description;
        int iHashCode2 = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.unpublishedAt;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ModelStoreAsset modelStoreAsset = this.thumbnail;
        return iHashCode3 + (modelStoreAsset != null ? modelStoreAsset.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStickerPackStoreListing(sku=");
        sbU.append(this.sku);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", unpublishedAt=");
        sbU.append(this.unpublishedAt);
        sbU.append(", thumbnail=");
        sbU.append(this.thumbnail);
        sbU.append(")");
        return sbU.toString();
    }
}
