package com.discord.models.store.dto;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: ModelStoreAsset.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJR\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\nR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b\"\u0010\nR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\rR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b'\u0010\r¨\u0006*"}, d2 = {"Lcom/discord/models/store/dto/ModelStoreAsset;", "Ljava/io/Serializable;", "", "component1", "()J", "", "component2", "()I", "", "component3", "()Ljava/lang/String;", "component4", "component5", "()Ljava/lang/Integer;", "component6", ModelAuditLogEntry.CHANGE_KEY_ID, "size", "mimeType", "filename", "width", "height", "copy", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/discord/models/store/dto/ModelStoreAsset;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getId", "Ljava/lang/String;", "getMimeType", "getFilename", "Ljava/lang/Integer;", "getWidth", "I", "getSize", "getHeight", "<init>", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelStoreAsset implements Serializable {
    private final String filename;
    private final Integer height;
    private final long id;
    private final String mimeType;
    private final int size;
    private final Integer width;

    public ModelStoreAsset(long j, int i, String str, String str2, Integer num, Integer num2) {
        Intrinsics3.checkNotNullParameter(str, "mimeType");
        this.id = j;
        this.size = i;
        this.mimeType = str;
        this.filename = str2;
        this.width = num;
        this.height = num2;
    }

    public static /* synthetic */ ModelStoreAsset copy$default(ModelStoreAsset modelStoreAsset, long j, int i, String str, String str2, Integer num, Integer num2, int i2, Object obj) {
        return modelStoreAsset.copy((i2 & 1) != 0 ? modelStoreAsset.id : j, (i2 & 2) != 0 ? modelStoreAsset.size : i, (i2 & 4) != 0 ? modelStoreAsset.mimeType : str, (i2 & 8) != 0 ? modelStoreAsset.filename : str2, (i2 & 16) != 0 ? modelStoreAsset.width : num, (i2 & 32) != 0 ? modelStoreAsset.height : num2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    public final ModelStoreAsset copy(long id2, int size, String mimeType, String filename, Integer width, Integer height) {
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        return new ModelStoreAsset(id2, size, mimeType, filename, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStoreAsset)) {
            return false;
        }
        ModelStoreAsset modelStoreAsset = (ModelStoreAsset) other;
        return this.id == modelStoreAsset.id && this.size == modelStoreAsset.size && Intrinsics3.areEqual(this.mimeType, modelStoreAsset.mimeType) && Intrinsics3.areEqual(this.filename, modelStoreAsset.filename) && Intrinsics3.areEqual(this.width, modelStoreAsset.width) && Intrinsics3.areEqual(this.height, modelStoreAsset.height);
    }

    public final String getFilename() {
        return this.filename;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final long getId() {
        return this.id;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getSize() {
        return this.size;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.size) * 31;
        String str = this.mimeType;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filename;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.width;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStoreAsset(id=");
        sbU.append(this.id);
        sbU.append(", size=");
        sbU.append(this.size);
        sbU.append(", mimeType=");
        sbU.append(this.mimeType);
        sbU.append(", filename=");
        sbU.append(this.filename);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", height=");
        return outline.F(sbU, this.height, ")");
    }
}
