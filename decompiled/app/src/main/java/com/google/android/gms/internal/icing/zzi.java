package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.h.k.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new n();
    public final String j;
    public final String k;
    public final String l;

    public zzi(String str, String str2, String str3) {
        this.j = str;
        this.k = str2;
        this.l = str3;
    }

    public final String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", this.j, this.k, this.l);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 1, this.j, false);
        AnimatableValueParser.t2(parcel, 2, this.k, false);
        AnimatableValueParser.t2(parcel, 3, this.l, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
