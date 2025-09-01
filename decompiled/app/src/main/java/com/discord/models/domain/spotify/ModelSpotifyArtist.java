package com.discord.models.domain.spotify;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelSpotifyArtist.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/models/domain/spotify/ModelSpotifyArtist;", "", "", "component1", "()Ljava/lang/String;", "component2", ModelAuditLogEntry.CHANGE_KEY_ID, ModelAuditLogEntry.CHANGE_KEY_NAME, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/domain/spotify/ModelSpotifyArtist;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelSpotifyArtist {
    private final String id;
    private final String name;

    public ModelSpotifyArtist(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = str;
        this.name = str2;
    }

    public static /* synthetic */ ModelSpotifyArtist copy$default(ModelSpotifyArtist modelSpotifyArtist, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelSpotifyArtist.id;
        }
        if ((i & 2) != 0) {
            str2 = modelSpotifyArtist.name;
        }
        return modelSpotifyArtist.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelSpotifyArtist copy(String id2, String name) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ModelSpotifyArtist(id2, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSpotifyArtist)) {
            return false;
        }
        ModelSpotifyArtist modelSpotifyArtist = (ModelSpotifyArtist) other;
        return Intrinsics3.areEqual(this.id, modelSpotifyArtist.id) && Intrinsics3.areEqual(this.name, modelSpotifyArtist.name);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelSpotifyArtist(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}
