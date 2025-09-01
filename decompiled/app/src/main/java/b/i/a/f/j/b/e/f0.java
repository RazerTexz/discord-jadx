package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzbz;

/* loaded from: classes3.dex */
public final class f0 implements Parcelable.Creator<zzbz> {
    @Override // android.os.Parcelable.Creator
    public final zzbz createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        zzaf zzafVar = null;
        Strategy strategy = null;
        IBinder iBinderF1 = null;
        String strR = null;
        String strR2 = null;
        IBinder iBinderF12 = null;
        ClientAppContext clientAppContext = null;
        int iG1 = 0;
        boolean zE1 = false;
        boolean zE12 = false;
        int iG12 = 0;
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
                    strategy = (Strategy) AnimatableValueParser.Q(parcel, i, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderF1 = AnimatableValueParser.F1(parcel, i);
                    break;
                case 5:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 6:
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
                case 7:
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case '\b':
                    iBinderF12 = AnimatableValueParser.F1(parcel, i);
                    break;
                case '\t':
                    zE12 = AnimatableValueParser.E1(parcel, i);
                    break;
                case '\n':
                    clientAppContext = (ClientAppContext) AnimatableValueParser.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                case 11:
                    iG12 = AnimatableValueParser.G1(parcel, i);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new zzbz(iG1, zzafVar, strategy, iBinderF1, strR, strR2, zE1, iBinderF12, zE12, clientAppContext, iG12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbz[] newArray(int i) {
        return new zzbz[i];
    }
}
