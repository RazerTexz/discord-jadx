package b.i.a.f.j.b.e;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;

/* loaded from: classes3.dex */
public final class h0 implements Parcelable.Creator<SubscribeRequest> {
    @Override // android.os.Parcelable.Creator
    public final SubscribeRequest createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        IBinder iBinderF1 = null;
        Strategy strategy = null;
        IBinder iBinderF12 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        String strR = null;
        String strR2 = null;
        byte[] bArrN = null;
        IBinder iBinderF13 = null;
        ClientAppContext clientAppContext = null;
        int iG1 = 0;
        int iG12 = 0;
        boolean zE1 = false;
        boolean zE12 = false;
        boolean zE13 = false;
        int iG13 = 0;
        int iG14 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 2:
                    iBinderF1 = AnimatableValueParser.F1(parcel, i);
                    break;
                case 3:
                    strategy = (Strategy) AnimatableValueParser.Q(parcel, i, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderF12 = AnimatableValueParser.F1(parcel, i);
                    break;
                case 5:
                    messageFilter = (MessageFilter) AnimatableValueParser.Q(parcel, i, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) AnimatableValueParser.Q(parcel, i, PendingIntent.CREATOR);
                    break;
                case 7:
                    iG12 = AnimatableValueParser.G1(parcel, i);
                    break;
                case '\b':
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case '\t':
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
                case '\n':
                    bArrN = AnimatableValueParser.N(parcel, i);
                    break;
                case 11:
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case '\f':
                    iBinderF13 = AnimatableValueParser.F1(parcel, i);
                    break;
                case '\r':
                    zE12 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 14:
                    clientAppContext = (ClientAppContext) AnimatableValueParser.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                case 15:
                    zE13 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 16:
                    iG13 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 17:
                    iG14 = AnimatableValueParser.G1(parcel, i);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new SubscribeRequest(iG1, iBinderF1, strategy, iBinderF12, messageFilter, pendingIntent, iG12, strR, strR2, bArrN, zE1, iBinderF13, zE12, clientAppContext, zE13, iG13, iG14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
