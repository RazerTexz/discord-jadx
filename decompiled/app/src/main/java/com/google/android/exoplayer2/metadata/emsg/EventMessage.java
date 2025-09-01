package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.f3.Util2;
import b.i.a.c.z2.Metadata2;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR;
    public static final Format2 j;
    public static final Format2 k;
    public final String l;
    public final String m;
    public final long n;
    public final long o;
    public final byte[] p;
    public int q;

    public class a implements Parcelable.Creator<EventMessage> {
        @Override // android.os.Parcelable.Creator
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public EventMessage[] newArray(int i) {
            return new EventMessage[i];
        }
    }

    static {
        Format2.b bVar = new Format2.b();
        bVar.k = "application/id3";
        j = bVar.a();
        Format2.b bVar2 = new Format2.b();
        bVar2.k = "application/x-scte35";
        k = bVar2.a();
        CREATOR = new a();
    }

    public EventMessage(String str, String str2, long j2, long j3, byte[] bArr) {
        this.l = str;
        this.m = str2;
        this.n = j2;
        this.o = j3;
        this.p = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.n == eventMessage.n && this.o == eventMessage.o && Util2.a(this.l, eventMessage.l) && Util2.a(this.m, eventMessage.m) && Arrays.equals(this.p, eventMessage.p);
    }

    public int hashCode() {
        if (this.q == 0) {
            String str = this.l;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.m;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j2 = this.n;
            int i = (((iHashCode + iHashCode2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.o;
            this.q = Arrays.hashCode(this.p) + ((i + ((int) (j3 ^ (j3 >>> 32)))) * 31);
        }
        return this.q;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void n(MediaMetadata.b bVar) {
        Metadata2.c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public byte[] o0() {
        if (y() != null) {
            return this.p;
        }
        return null;
    }

    public String toString() {
        String str = this.l;
        long j2 = this.o;
        long j3 = this.n;
        String str2 = this.m;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 79);
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j2);
        sb.append(", durationMs=");
        sb.append(j3);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeLong(this.n);
        parcel.writeLong(this.o);
        parcel.writeByteArray(this.p);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @Nullable
    public Format2 y() {
        String str = this.l;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return k;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return j;
            default:
                return null;
        }
    }

    public EventMessage(Parcel parcel) {
        String string = parcel.readString();
        int i = Util2.a;
        this.l = string;
        this.m = parcel.readString();
        this.n = parcel.readLong();
        this.o = parcel.readLong();
        this.p = parcel.createByteArray();
    }
}
