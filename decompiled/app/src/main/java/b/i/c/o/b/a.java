package b.i.c.o.b;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator<DynamicLinkData> {
    @Override // android.os.Parcelable.Creator
    public final DynamicLinkData createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        String strR2 = null;
        Bundle bundleM = null;
        Uri uri = null;
        long jH1 = 0;
        int iG1 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 2:
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
                case 3:
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 4:
                    jH1 = AnimatableValueParser.H1(parcel, i);
                    break;
                case 5:
                    bundleM = AnimatableValueParser.M(parcel, i);
                    break;
                case 6:
                    uri = (Uri) AnimatableValueParser.Q(parcel, i, Uri.CREATOR);
                    break;
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new DynamicLinkData(strR, strR2, iG1, jH1, bundleM, uri);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DynamicLinkData[] newArray(int i) {
        return new DynamicLinkData[i];
    }
}
