package com.discord.models.sticker.dto;

import b.d.b.a.outline;
import com.discord.models.store.dto.ModelStoreDirectoryLayout;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelStickerStoreDirectory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/discord/models/sticker/dto/ModelStickerStoreDirectory;", "", "", "Lcom/discord/models/sticker/dto/ModelStickerPack;", "component1", "()Ljava/util/List;", "Lcom/discord/models/store/dto/ModelStoreDirectoryLayout;", "component2", "()Lcom/discord/models/store/dto/ModelStoreDirectoryLayout;", "stickerPacks", "storeDirectoryLayout", "copy", "(Ljava/util/List;Lcom/discord/models/store/dto/ModelStoreDirectoryLayout;)Lcom/discord/models/sticker/dto/ModelStickerStoreDirectory;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getStickerPacks", "Lcom/discord/models/store/dto/ModelStoreDirectoryLayout;", "getStoreDirectoryLayout", "<init>", "(Ljava/util/List;Lcom/discord/models/store/dto/ModelStoreDirectoryLayout;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelStickerStoreDirectory {
    private final List<ModelStickerPack> stickerPacks;
    private final ModelStoreDirectoryLayout storeDirectoryLayout;

    public ModelStickerStoreDirectory(List<ModelStickerPack> list, ModelStoreDirectoryLayout modelStoreDirectoryLayout) {
        Intrinsics3.checkNotNullParameter(list, "stickerPacks");
        this.stickerPacks = list;
        this.storeDirectoryLayout = modelStoreDirectoryLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelStickerStoreDirectory copy$default(ModelStickerStoreDirectory modelStickerStoreDirectory, List list, ModelStoreDirectoryLayout modelStoreDirectoryLayout, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelStickerStoreDirectory.stickerPacks;
        }
        if ((i & 2) != 0) {
            modelStoreDirectoryLayout = modelStickerStoreDirectory.storeDirectoryLayout;
        }
        return modelStickerStoreDirectory.copy(list, modelStoreDirectoryLayout);
    }

    public final List<ModelStickerPack> component1() {
        return this.stickerPacks;
    }

    /* renamed from: component2, reason: from getter */
    public final ModelStoreDirectoryLayout getStoreDirectoryLayout() {
        return this.storeDirectoryLayout;
    }

    public final ModelStickerStoreDirectory copy(List<ModelStickerPack> stickerPacks, ModelStoreDirectoryLayout storeDirectoryLayout) {
        Intrinsics3.checkNotNullParameter(stickerPacks, "stickerPacks");
        return new ModelStickerStoreDirectory(stickerPacks, storeDirectoryLayout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStickerStoreDirectory)) {
            return false;
        }
        ModelStickerStoreDirectory modelStickerStoreDirectory = (ModelStickerStoreDirectory) other;
        return Intrinsics3.areEqual(this.stickerPacks, modelStickerStoreDirectory.stickerPacks) && Intrinsics3.areEqual(this.storeDirectoryLayout, modelStickerStoreDirectory.storeDirectoryLayout);
    }

    public final List<ModelStickerPack> getStickerPacks() {
        return this.stickerPacks;
    }

    public final ModelStoreDirectoryLayout getStoreDirectoryLayout() {
        return this.storeDirectoryLayout;
    }

    public int hashCode() {
        List<ModelStickerPack> list = this.stickerPacks;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        ModelStoreDirectoryLayout modelStoreDirectoryLayout = this.storeDirectoryLayout;
        return iHashCode + (modelStoreDirectoryLayout != null ? modelStoreDirectoryLayout.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStickerStoreDirectory(stickerPacks=");
        sbU.append(this.stickerPacks);
        sbU.append(", storeDirectoryLayout=");
        sbU.append(this.storeDirectoryLayout);
        sbU.append(")");
        return sbU.toString();
    }
}
