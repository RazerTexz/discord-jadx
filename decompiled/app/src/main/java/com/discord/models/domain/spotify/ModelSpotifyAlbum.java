package com.discord.models.domain.spotify;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelSpotifyAlbum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001!B-\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J>\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\t¨\u0006\""}, d2 = {"Lcom/discord/models/domain/spotify/ModelSpotifyAlbum;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/discord/models/domain/spotify/ModelSpotifyAlbum$AlbumImage;", "component3", "()Ljava/util/List;", "component4", "albumType", ModelAuditLogEntry.CHANGE_KEY_ID, "images", ModelAuditLogEntry.CHANGE_KEY_NAME, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/discord/models/domain/spotify/ModelSpotifyAlbum;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getId", "getAlbumType", "Ljava/util/List;", "getImages", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "AlbumImage", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelSpotifyAlbum {
    private final String albumType;
    private final String id;
    private final List<AlbumImage> images;
    private final String name;

    /* compiled from: ModelSpotifyAlbum.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/discord/models/domain/spotify/ModelSpotifyAlbum$AlbumImage;", "", "", "component1", "()Ljava/lang/String;", "url", "copy", "(Ljava/lang/String;)Lcom/discord/models/domain/spotify/ModelSpotifyAlbum$AlbumImage;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrl", "<init>", "(Ljava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AlbumImage {
        private final String url;

        public AlbumImage(String str) {
            this.url = str;
        }

        public static /* synthetic */ AlbumImage copy$default(AlbumImage albumImage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = albumImage.url;
            }
            return albumImage.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final AlbumImage copy(String url) {
            return new AlbumImage(url);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof AlbumImage) && Intrinsics3.areEqual(this.url, ((AlbumImage) other).url);
            }
            return true;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.url;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("AlbumImage(url="), this.url, ")");
        }
    }

    public ModelSpotifyAlbum(String str, String str2, List<AlbumImage> list, String str3) {
        Intrinsics3.checkNotNullParameter(str, "albumType");
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(list, "images");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.albumType = str;
        this.id = str2;
        this.images = list;
        this.name = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSpotifyAlbum copy$default(ModelSpotifyAlbum modelSpotifyAlbum, String str, String str2, List list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelSpotifyAlbum.albumType;
        }
        if ((i & 2) != 0) {
            str2 = modelSpotifyAlbum.id;
        }
        if ((i & 4) != 0) {
            list = modelSpotifyAlbum.images;
        }
        if ((i & 8) != 0) {
            str3 = modelSpotifyAlbum.name;
        }
        return modelSpotifyAlbum.copy(str, str2, list, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAlbumType() {
        return this.albumType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<AlbumImage> component3() {
        return this.images;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelSpotifyAlbum copy(String albumType, String id2, List<AlbumImage> images, String name) {
        Intrinsics3.checkNotNullParameter(albumType, "albumType");
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(images, "images");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ModelSpotifyAlbum(albumType, id2, images, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSpotifyAlbum)) {
            return false;
        }
        ModelSpotifyAlbum modelSpotifyAlbum = (ModelSpotifyAlbum) other;
        return Intrinsics3.areEqual(this.albumType, modelSpotifyAlbum.albumType) && Intrinsics3.areEqual(this.id, modelSpotifyAlbum.id) && Intrinsics3.areEqual(this.images, modelSpotifyAlbum.images) && Intrinsics3.areEqual(this.name, modelSpotifyAlbum.name);
    }

    public final String getAlbumType() {
        return this.albumType;
    }

    public final String getId() {
        return this.id;
    }

    public final List<AlbumImage> getImages() {
        return this.images;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.albumType;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.id;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<AlbumImage> list = this.images;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.name;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelSpotifyAlbum(albumType=");
        sbU.append(this.albumType);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", images=");
        sbU.append(this.images);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}
