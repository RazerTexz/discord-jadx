package com.discord.player;

import android.os.Parcel;
import android.os.Parcelable;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MediaType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/player/MediaType;", "", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "<init>", "(Ljava/lang/String;I)V", "CREATOR", "a", "VIDEO", "GIFV", "app_media_player_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum MediaType implements Parcelable {
    VIDEO,
    GIFV;


    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: MediaType.kt */
    /* renamed from: com.discord.player.MediaType$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<MediaType> {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @Override // android.os.Parcelable.Creator
        public MediaType createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            Intrinsics3.checkNotNull(string);
            Intrinsics3.checkNotNullExpressionValue(string, "parcel.readString()!!");
            return MediaType.valueOf(string);
        }

        @Override // android.os.Parcelable.Creator
        public MediaType[] newArray(int i) {
            return new MediaType[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(name());
    }
}
