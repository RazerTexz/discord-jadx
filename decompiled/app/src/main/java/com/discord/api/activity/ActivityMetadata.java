package com.discord.api.activity;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ActivityMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/api/activity/ActivityMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "contextUri", "Ljava/lang/String;", "getContextUri", "albumId", "a", "", "buttonUrls", "Ljava/util/List;", "b", "()Ljava/util/List;", "artistIds", "getArtistIds", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ActivityMetadata {
    private final String albumId;
    private final List<String> artistIds;
    private final List<String> buttonUrls;
    private final String contextUri;

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    public final List<String> b() {
        return this.buttonUrls;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityMetadata)) {
            return false;
        }
        ActivityMetadata activityMetadata = (ActivityMetadata) other;
        return Intrinsics3.areEqual(this.contextUri, activityMetadata.contextUri) && Intrinsics3.areEqual(this.albumId, activityMetadata.albumId) && Intrinsics3.areEqual(this.artistIds, activityMetadata.artistIds) && Intrinsics3.areEqual(this.buttonUrls, activityMetadata.buttonUrls);
    }

    public int hashCode() {
        String str = this.contextUri;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.albumId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.artistIds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.buttonUrls;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActivityMetadata(contextUri=");
        sbU.append(this.contextUri);
        sbU.append(", albumId=");
        sbU.append(this.albumId);
        sbU.append(", artistIds=");
        sbU.append(this.artistIds);
        sbU.append(", buttonUrls=");
        return outline.L(sbU, this.buttonUrls, ")");
    }
}
