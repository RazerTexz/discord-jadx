package com.discord.models.domain.spotify;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelSpotifyTrack.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JT\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0018\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010\u000bR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\bR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b\u0018\u0010\u0012¨\u0006."}, d2 = {"Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "Lcom/discord/models/domain/spotify/ModelSpotifyAlbum;", "component4", "()Lcom/discord/models/domain/spotify/ModelSpotifyAlbum;", "", "Lcom/discord/models/domain/spotify/ModelSpotifyArtist;", "component5", "()Ljava/util/List;", "", "component6", "()Z", ModelAuditLogEntry.CHANGE_KEY_ID, ModelAuditLogEntry.CHANGE_KEY_NAME, "durationMs", "album", "artists", "isLocal", "copy", "(Ljava/lang/String;Ljava/lang/String;JLcom/discord/models/domain/spotify/ModelSpotifyAlbum;Ljava/util/List;Z)Lcom/discord/models/domain/spotify/ModelSpotifyTrack;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Lcom/discord/models/domain/spotify/ModelSpotifyAlbum;", "getAlbum", "Ljava/util/List;", "getArtists", "J", "getDurationMs", "getName", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/discord/models/domain/spotify/ModelSpotifyAlbum;Ljava/util/List;Z)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelSpotifyTrack {
    private final ModelSpotifyAlbum album;
    private final List<ModelSpotifyArtist> artists;
    private final long durationMs;
    private final String id;
    private final boolean isLocal;
    private final String name;

    public ModelSpotifyTrack(String str, String str2, long j, ModelSpotifyAlbum modelSpotifyAlbum, List<ModelSpotifyArtist> list, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "artists");
        this.id = str;
        this.name = str2;
        this.durationMs = j;
        this.album = modelSpotifyAlbum;
        this.artists = list;
        this.isLocal = z2;
    }

    public static /* synthetic */ ModelSpotifyTrack copy$default(ModelSpotifyTrack modelSpotifyTrack, String str, String str2, long j, ModelSpotifyAlbum modelSpotifyAlbum, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelSpotifyTrack.id;
        }
        if ((i & 2) != 0) {
            str2 = modelSpotifyTrack.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = modelSpotifyTrack.durationMs;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            modelSpotifyAlbum = modelSpotifyTrack.album;
        }
        ModelSpotifyAlbum modelSpotifyAlbum2 = modelSpotifyAlbum;
        if ((i & 16) != 0) {
            list = modelSpotifyTrack.artists;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            z2 = modelSpotifyTrack.isLocal;
        }
        return modelSpotifyTrack.copy(str, str3, j2, modelSpotifyAlbum2, list2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: component4, reason: from getter */
    public final ModelSpotifyAlbum getAlbum() {
        return this.album;
    }

    public final List<ModelSpotifyArtist> component5() {
        return this.artists;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsLocal() {
        return this.isLocal;
    }

    public final ModelSpotifyTrack copy(String id2, String name, long durationMs, ModelSpotifyAlbum album, List<ModelSpotifyArtist> artists, boolean isLocal) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(artists, "artists");
        return new ModelSpotifyTrack(id2, name, durationMs, album, artists, isLocal);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSpotifyTrack)) {
            return false;
        }
        ModelSpotifyTrack modelSpotifyTrack = (ModelSpotifyTrack) other;
        return Intrinsics3.areEqual(this.id, modelSpotifyTrack.id) && Intrinsics3.areEqual(this.name, modelSpotifyTrack.name) && this.durationMs == modelSpotifyTrack.durationMs && Intrinsics3.areEqual(this.album, modelSpotifyTrack.album) && Intrinsics3.areEqual(this.artists, modelSpotifyTrack.artists) && this.isLocal == modelSpotifyTrack.isLocal;
    }

    public final ModelSpotifyAlbum getAlbum() {
        return this.album;
    }

    public final List<ModelSpotifyArtist> getArtists() {
        return this.artists;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.durationMs;
        int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        ModelSpotifyAlbum modelSpotifyAlbum = this.album;
        int iHashCode3 = (i + (modelSpotifyAlbum != null ? modelSpotifyAlbum.hashCode() : 0)) * 31;
        List<ModelSpotifyArtist> list = this.artists;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isLocal;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return iHashCode4 + i2;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelSpotifyTrack(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", durationMs=");
        sbU.append(this.durationMs);
        sbU.append(", album=");
        sbU.append(this.album);
        sbU.append(", artists=");
        sbU.append(this.artists);
        sbU.append(", isLocal=");
        return outline.O(sbU, this.isLocal, ")");
    }
}
