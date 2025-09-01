package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ImageAsset.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/api/guildrolesubscription/ImageAsset;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "size", "Ljava/lang/Integer;", "getSize", "()Ljava/lang/Integer;", "mimeType", "Ljava/lang/String;", "getMimeType", "width", "getWidth", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "a", "()J", "height", "getHeight", "filename", "getFilename", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ImageAsset {
    private final String filename;
    private final Integer height;
    private final long id;
    private final String mimeType;
    private final Integer size;
    private final Integer width;

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageAsset)) {
            return false;
        }
        ImageAsset imageAsset = (ImageAsset) other;
        return this.id == imageAsset.id && Intrinsics3.areEqual(this.size, imageAsset.size) && Intrinsics3.areEqual(this.mimeType, imageAsset.mimeType) && Intrinsics3.areEqual(this.filename, imageAsset.filename) && Intrinsics3.areEqual(this.width, imageAsset.width) && Intrinsics3.areEqual(this.height, imageAsset.height);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Integer num = this.size;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.mimeType;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filename;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num2 = this.width;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.height;
        return iHashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ImageAsset(id=");
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
