package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.h.m.e;
import b.i.a.f.j.b.e.k0;
import com.esotericsoftware.kryo.Kryo;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new k0();
    public final int j;
    public final int k;
    public final Message l;

    @Nullable
    public final zze m;

    @Nullable
    public final zza n;

    @Nullable
    public final zzgs o;

    @Nullable
    public final byte[] p;

    public Update(int i, int i2, Message message, @Nullable zze zzeVar, @Nullable zza zzaVar, @Nullable zzgs zzgsVar, @Nullable byte[] bArr) {
        this.j = i;
        if ((i2 & 2) != 0) {
            i2 = 2;
            zzeVar = null;
            zzaVar = null;
            zzgsVar = null;
            bArr = null;
        }
        this.k = i2;
        this.l = message;
        this.m = zzeVar;
        this.n = zzaVar;
        this.o = zzgsVar;
        this.p = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.k == update.k && AnimatableValueParser.h0(this.l, update.l) && AnimatableValueParser.h0(this.m, update.m) && AnimatableValueParser.h0(this.n, update.n) && AnimatableValueParser.h0(this.o, update.o) && Arrays.equals(this.p, update.p);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.k), this.l, this.m, this.n, this.o, this.p});
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x00af. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String str;
        byte[] bArr;
        ArraySet arraySet = new ArraySet();
        if (w0(1)) {
            arraySet.add("FOUND");
        }
        if (w0(2)) {
            arraySet.add("LOST");
        }
        if (w0(4)) {
            arraySet.add("DISTANCE");
        }
        if (w0(8)) {
            arraySet.add("BLE_SIGNAL");
        }
        if (w0(16)) {
            arraySet.add("DEVICE");
        }
        if (w0(32)) {
            arraySet.add("BLE_RECORD");
        }
        String strValueOf = String.valueOf(arraySet);
        String strValueOf2 = String.valueOf(this.l);
        String strValueOf3 = String.valueOf(this.m);
        String strValueOf4 = String.valueOf(this.n);
        String strValueOf5 = String.valueOf(this.o);
        byte[] bArr2 = this.p;
        ParcelUuid parcelUuid = e.a;
        e eVar = null;
        if (bArr2 == null) {
            str = strValueOf5;
        } else {
            int i = 0;
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            HashMap map = new HashMap();
            String str2 = null;
            int i2 = -1;
            byte b2 = Kryo.NULL;
            try {
                while (i < bArr2.length) {
                    try {
                        int i3 = i + 1;
                        int i4 = bArr2[i] & 255;
                        if (i4 != 0) {
                            int i5 = i4 - 1;
                            int i6 = i3 + 1;
                            int i7 = bArr2[i3] & 255;
                            str = strValueOf5;
                            if (i7 == 22) {
                                map.put(e.c(e.b(bArr2, i6, 2)), e.b(bArr2, i6 + 2, i5 - 2));
                            } else if (i7 != 255) {
                                switch (i7) {
                                    case 1:
                                        i2 = bArr2[i6] & 255;
                                        break;
                                    case 2:
                                    case 3:
                                        e.a(bArr2, i6, i5, 2, arrayList);
                                        break;
                                    case 4:
                                    case 5:
                                        e.a(bArr2, i6, i5, 4, arrayList);
                                        break;
                                    case 6:
                                    case 7:
                                        e.a(bArr2, i6, i5, 16, arrayList);
                                        break;
                                    case 8:
                                    case 9:
                                        str2 = new String(e.b(bArr2, i6, i5));
                                        break;
                                    case 10:
                                        try {
                                            b2 = bArr2[i6];
                                            break;
                                        } catch (Exception e) {
                                            e = e;
                                            bArr = bArr2;
                                            String strValueOf6 = String.valueOf(Arrays.toString(bArr));
                                            Log.w("BleRecord", strValueOf6.length() == 0 ? "Unable to parse scan record: ".concat(strValueOf6) : new String("Unable to parse scan record: "), e);
                                            String strValueOf7 = String.valueOf(eVar);
                                            StringBuilder sbS = outline.S(strValueOf7.length() + str.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 68, "Update{types=", strValueOf, ", message=", strValueOf2);
                                            outline.s0(sbS, ", distance=", strValueOf3, ", bleSignal=", strValueOf4);
                                            outline.s0(sbS, ", device=", str, ", bleRecord=", strValueOf7);
                                            sbS.append("}");
                                            return sbS.toString();
                                        }
                                }
                            } else {
                                sparseArray.put(((bArr2[i6 + 1] & 255) << 8) + (bArr2[i6] & 255), e.b(bArr2, i6 + 2, i5 - 2));
                            }
                            i = i5 + i6;
                            strValueOf5 = str;
                        } else {
                            str = strValueOf5;
                            bArr = bArr2;
                            eVar = new e(!arrayList.isEmpty() ? null : arrayList, sparseArray, map, i2, b2, str2, bArr2);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = strValueOf5;
                    }
                }
                eVar = new e(!arrayList.isEmpty() ? null : arrayList, sparseArray, map, i2, b2, str2, bArr2);
            } catch (Exception e3) {
                e = e3;
                String strValueOf62 = String.valueOf(Arrays.toString(bArr));
                Log.w("BleRecord", strValueOf62.length() == 0 ? "Unable to parse scan record: ".concat(strValueOf62) : new String("Unable to parse scan record: "), e);
                String strValueOf72 = String.valueOf(eVar);
                StringBuilder sbS2 = outline.S(strValueOf72.length() + str.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 68, "Update{types=", strValueOf, ", message=", strValueOf2);
                outline.s0(sbS2, ", distance=", strValueOf3, ", bleSignal=", strValueOf4);
                outline.s0(sbS2, ", device=", str, ", bleRecord=", strValueOf72);
                sbS2.append("}");
                return sbS2.toString();
            }
            str = strValueOf5;
            bArr = bArr2;
        }
        String strValueOf722 = String.valueOf(eVar);
        StringBuilder sbS22 = outline.S(strValueOf722.length() + str.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 68, "Update{types=", strValueOf, ", message=", strValueOf2);
        outline.s0(sbS22, ", distance=", strValueOf3, ", bleSignal=", strValueOf4);
        outline.s0(sbS22, ", device=", str, ", bleRecord=", strValueOf722);
        sbS22.append("}");
        return sbS22.toString();
    }

    public final boolean w0(int i) {
        return (i & this.k) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        AnimatableValueParser.s2(parcel, 3, this.l, i, false);
        AnimatableValueParser.s2(parcel, 4, this.m, i, false);
        AnimatableValueParser.s2(parcel, 5, this.n, i, false);
        AnimatableValueParser.s2(parcel, 6, this.o, i, false);
        AnimatableValueParser.q2(parcel, 7, this.p, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
