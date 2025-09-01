package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.internal.zza;

/* loaded from: classes3.dex */
public final class w implements Parcelable.Creator<zza> {
    @Override // android.os.Parcelable.Creator
    public final zza createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int iG1 = 0;
        int iG12 = 0;
        int iG13 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                iG12 = AnimatableValueParser.G1(parcel, i);
            } else if (c != 3) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                iG13 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zza(iG1, iG12, iG13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
