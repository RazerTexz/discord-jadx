package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzce;

/* loaded from: classes3.dex */
public final class i0 implements Parcelable.Creator<zzce> {
    @Override // android.os.Parcelable.Creator
    public final zzce createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        zzaf zzafVar = null;
        IBinder iBinderF1 = null;
        String strR = null;
        String strR2 = null;
        ClientAppContext clientAppContext = null;
        int iG1 = 0;
        boolean zE1 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 2:
                    zzafVar = (zzaf) AnimatableValueParser.Q(parcel, i, zzaf.CREATOR);
                    break;
                case 3:
                    iBinderF1 = AnimatableValueParser.F1(parcel, i);
                    break;
                case 4:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 5:
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
                case 6:
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 7:
                    clientAppContext = (ClientAppContext) AnimatableValueParser.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzce(iG1, zzafVar, iBinderF1, strR, strR2, zE1, clientAppContext);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzce[] newArray(int i) {
        return new zzce[i];
    }
}
