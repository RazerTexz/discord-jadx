package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.f3.Util2;
import b.i.a.c.z2.Metadata2;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new a();
    public final int j;

    @Nullable
    public final String k;

    @Nullable
    public final String l;

    @Nullable
    public final String m;
    public final boolean n;
    public final int o;

    public class a implements Parcelable.Creator<IcyHeaders> {
        @Override // android.os.Parcelable.Creator
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IcyHeaders[] newArray(int i) {
            return new IcyHeaders[i];
        }
    }

    public IcyHeaders(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z2, int i2) {
        AnimatableValueParser.j(i2 == -1 || i2 > 0);
        this.j = i;
        this.k = str;
        this.l = str2;
        this.m = str3;
        this.n = z2;
        this.o = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static IcyHeaders a(Map<String, List<String>> map) throws NumberFormatException {
        boolean z2;
        int i;
        List<String> list;
        String str;
        List<String> list2;
        String str2;
        List<String> list3;
        String str3;
        List<String> list4;
        boolean zEquals;
        List<String> list5;
        int i2;
        List<String> list6 = map.get("icy-br");
        int i3 = -1;
        boolean z3 = true;
        if (list6 != null) {
            String str4 = list6.get(0);
            try {
                i2 = Integer.parseInt(str4) * 1000;
                if (i2 > 0) {
                    z2 = true;
                } else {
                    try {
                        String strValueOf = String.valueOf(str4);
                        Log.w("IcyHeaders", strValueOf.length() != 0 ? "Invalid bitrate: ".concat(strValueOf) : new String("Invalid bitrate: "));
                        z2 = false;
                        i2 = -1;
                    } catch (NumberFormatException unused) {
                        String strValueOf2 = String.valueOf(str4);
                        Log.w("IcyHeaders", strValueOf2.length() != 0 ? "Invalid bitrate header: ".concat(strValueOf2) : new String("Invalid bitrate header: "));
                        i = i2;
                        z2 = false;
                        list = map.get("icy-genre");
                        if (list == null) {
                        }
                        list2 = map.get("icy-name");
                        if (list2 == null) {
                        }
                        list3 = map.get("icy-url");
                        if (list3 == null) {
                        }
                        list4 = map.get("icy-pub");
                        if (list4 == null) {
                        }
                        list5 = map.get("icy-metaint");
                        if (list5 != null) {
                        }
                        if (z2) {
                        }
                    }
                }
                i = i2;
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
        } else {
            z2 = false;
            i = -1;
        }
        list = map.get("icy-genre");
        if (list == null) {
            str = list.get(0);
            z2 = true;
        } else {
            str = null;
        }
        list2 = map.get("icy-name");
        if (list2 == null) {
            str2 = list2.get(0);
            z2 = true;
        } else {
            str2 = null;
        }
        list3 = map.get("icy-url");
        if (list3 == null) {
            str3 = list3.get(0);
            z2 = true;
        } else {
            str3 = null;
        }
        list4 = map.get("icy-pub");
        if (list4 == null) {
            zEquals = list4.get(0).equals("1");
            z2 = true;
        } else {
            zEquals = false;
        }
        list5 = map.get("icy-metaint");
        if (list5 != null) {
            String str5 = list5.get(0);
            try {
                int i4 = Integer.parseInt(str5);
                if (i4 > 0) {
                    i3 = i4;
                } else {
                    try {
                        String strValueOf3 = String.valueOf(str5);
                        Log.w("IcyHeaders", strValueOf3.length() != 0 ? "Invalid metadata interval: ".concat(strValueOf3) : new String("Invalid metadata interval: "));
                        z3 = z2;
                    } catch (NumberFormatException unused3) {
                        i3 = i4;
                        String strValueOf4 = String.valueOf(str5);
                        Log.w("IcyHeaders", strValueOf4.length() != 0 ? "Invalid metadata interval: ".concat(strValueOf4) : new String("Invalid metadata interval: "));
                        if (z2) {
                        }
                    }
                }
                z2 = z3;
            } catch (NumberFormatException unused4) {
            }
        }
        if (z2) {
            return new IcyHeaders(i, str, str2, str3, zEquals, i3);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        return this.j == icyHeaders.j && Util2.a(this.k, icyHeaders.k) && Util2.a(this.l, icyHeaders.l) && Util2.a(this.m, icyHeaders.m) && this.n == icyHeaders.n && this.o == icyHeaders.o;
    }

    public int hashCode() {
        int i = (527 + this.j) * 31;
        String str = this.k;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.l;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.m;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.n ? 1 : 0)) * 31) + this.o;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ void n(MediaMetadata.b bVar) {
        Metadata2.c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] o0() {
        return Metadata2.a(this);
    }

    public String toString() {
        String str = this.l;
        String str2 = this.k;
        int i = this.j;
        int i2 = this.o;
        StringBuilder sbS = outline.S(outline.b(str2, outline.b(str, 80)), "IcyHeaders: name=\"", str, "\", genre=\"", str2);
        sbS.append("\", bitrate=");
        sbS.append(i);
        sbS.append(", metadataInterval=");
        sbS.append(i2);
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        boolean z2 = this.n;
        int i2 = Util2.a;
        parcel.writeInt(z2 ? 1 : 0);
        parcel.writeInt(this.o);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format2 y() {
        return Metadata2.b(this);
    }

    public IcyHeaders(Parcel parcel) {
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        int i = Util2.a;
        this.n = parcel.readInt() != 0;
        this.o = parcel.readInt();
    }
}
