package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.k.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes3.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new b();
    public final String j;

    public zza(String str) {
        this.j = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 2, this.j, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
