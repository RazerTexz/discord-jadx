package b.i.a.f.e.j;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator<DataHolder> {
    @Override // android.os.Parcelable.Creator
    public final DataHolder createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        int i = 0;
        String[] strArrS = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleM = null;
        int iG1 = 0;
        int iG12 = 0;
        while (parcel.dataPosition() < iM2) {
            int i2 = parcel.readInt();
            char c = (char) i2;
            if (c == 1) {
                strArrS = AnimatableValueParser.S(parcel, i2);
            } else if (c == 2) {
                cursorWindowArr = (CursorWindow[]) AnimatableValueParser.U(parcel, i2, CursorWindow.CREATOR);
            } else if (c == 3) {
                iG12 = AnimatableValueParser.G1(parcel, i2);
            } else if (c == 4) {
                bundleM = AnimatableValueParser.M(parcel, i2);
            } else if (c != 1000) {
                AnimatableValueParser.d2(parcel, i2);
            } else {
                iG1 = AnimatableValueParser.G1(parcel, i2);
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        DataHolder dataHolder = new DataHolder(iG1, strArrS, cursorWindowArr, iG12, bundleM);
        dataHolder.l = new Bundle();
        int i3 = 0;
        while (true) {
            String[] strArr = dataHolder.k;
            if (i3 >= strArr.length) {
                break;
            }
            dataHolder.l.putInt(strArr[i3], i3);
            i3++;
        }
        dataHolder.p = new int[dataHolder.m.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = dataHolder.m;
            if (i >= cursorWindowArr2.length) {
                return dataHolder;
            }
            dataHolder.p[i] = numRows;
            numRows += dataHolder.m[i].getNumRows() - (numRows - cursorWindowArr2[i].getStartPosition());
            i++;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
