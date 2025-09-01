package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzj;

/* loaded from: classes3.dex */
public final class n0 implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final zzj createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int iG1 = 0;
        ClientAppContext clientAppContext = null;
        int iG12 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iG1 = AnimatableValueParser.G1(parcel, i);
            } else if (c == 2) {
                clientAppContext = (ClientAppContext) AnimatableValueParser.Q(parcel, i, ClientAppContext.CREATOR);
            } else if (c != 3) {
                AnimatableValueParser.d2(parcel, i);
            } else {
                iG12 = AnimatableValueParser.G1(parcel, i);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzj(iG1, clientAppContext, iG12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i) {
        return new zzj[i];
    }
}
