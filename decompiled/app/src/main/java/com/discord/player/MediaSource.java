package com.discord.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MediaSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u001f\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\nJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/discord/player/MediaSource;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "k", "Ljava/lang/String;", "getFeatureTag", "featureTag", "Lcom/discord/player/MediaType;", "l", "Lcom/discord/player/MediaType;", "getMediaType", "()Lcom/discord/player/MediaType;", "mediaType", "Landroid/net/Uri;", "j", "Landroid/net/Uri;", "getProgressiveMediaUri", "()Landroid/net/Uri;", "progressiveMediaUri", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Lcom/discord/player/MediaType;)V", "CREATOR", "a", "app_media_player_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class MediaSource implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: from kotlin metadata */
    public final Uri progressiveMediaUri;

    /* renamed from: k, reason: from kotlin metadata */
    public final String featureTag;

    /* renamed from: l, reason: from kotlin metadata */
    public final MediaType mediaType;

    /* compiled from: MediaSource.kt */
    /* renamed from: com.discord.player.MediaSource$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<MediaSource> {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @Override // android.os.Parcelable.Creator
        public MediaSource createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            Parcelable parcelable = parcel.readParcelable(Uri.class.getClassLoader());
            Intrinsics3.checkNotNull(parcelable);
            String string = parcel.readString();
            Intrinsics3.checkNotNull(string);
            Intrinsics3.checkNotNullExpressionValue(string, "parcel.readString()!!");
            Parcelable parcelable2 = parcel.readParcelable(MediaType.class.getClassLoader());
            Intrinsics3.checkNotNull(parcelable2);
            return new MediaSource((Uri) parcelable, string, (MediaType) parcelable2);
        }

        @Override // android.os.Parcelable.Creator
        public MediaSource[] newArray(int i) {
            return new MediaSource[i];
        }
    }

    public MediaSource(Uri uri, String str, MediaType mediaType) {
        Intrinsics3.checkNotNullParameter(uri, "progressiveMediaUri");
        Intrinsics3.checkNotNullParameter(str, "featureTag");
        Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
        this.progressiveMediaUri = uri;
        this.featureTag = str;
        this.mediaType = mediaType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaSource)) {
            return false;
        }
        MediaSource mediaSource = (MediaSource) other;
        return Intrinsics3.areEqual(this.progressiveMediaUri, mediaSource.progressiveMediaUri) && Intrinsics3.areEqual(this.featureTag, mediaSource.featureTag) && Intrinsics3.areEqual(this.mediaType, mediaSource.mediaType);
    }

    public int hashCode() {
        Uri uri = this.progressiveMediaUri;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        String str = this.featureTag;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        MediaType mediaType = this.mediaType;
        return iHashCode2 + (mediaType != null ? mediaType.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MediaSource(progressiveMediaUri=");
        sbU.append(this.progressiveMediaUri);
        sbU.append(", featureTag=");
        sbU.append(this.featureTag);
        sbU.append(", mediaType=");
        sbU.append(this.mediaType);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.progressiveMediaUri, flags);
        parcel.writeString(this.featureTag);
        parcel.writeParcelable(this.mediaType, flags);
    }
}
