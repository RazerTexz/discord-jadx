package b.i.a.f.h.m;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.internal.nearby.zzgs;

/* loaded from: classes3.dex */
public final class f implements Parcelable.Creator<zzgs> {
    @Override // android.os.Parcelable.Creator
    public final zzgs createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        String strR2 = null;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 3) {
                strR = AnimatableValueParser.R(parcel, i);
            } else if (c == 6) {
                strR2 = AnimatableValueParser.R(parcel, i);
            } else if (c != 1000) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                iG1 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzgs(iG1, strR, strR2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgs[] newArray(int i) {
        return new zzgs[i];
    }
}
