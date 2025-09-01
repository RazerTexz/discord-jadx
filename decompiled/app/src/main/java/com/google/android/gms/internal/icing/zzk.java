package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.h.k.o;
import b.i.a.f.h.k.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzk extends AbstractSafeParcelable {
    public final String k;
    public final zzt l;
    public final int m;
    public final byte[] n;
    public static final int j = Integer.parseInt("-1");
    public static final Parcelable.Creator<zzk> CREATOR = new o();

    static {
        ArrayList arrayList = new ArrayList();
        new zzt("SsbContext", "blob", true, 1, false, null, (zzm[]) arrayList.toArray(new zzm[arrayList.size()]), null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzk(String str, zzt zztVar, int i, byte[] bArr) {
        boolean z2;
        int i2 = j;
        String strG = null;
        if (i != i2) {
            String[] strArr = q.a;
            if (i >= 0) {
                String[] strArr2 = q.a;
                String str2 = i >= strArr2.length ? null : strArr2[i];
                z2 = str2 != null;
            }
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Invalid section type ");
        sb.append(i);
        AnimatableValueParser.o(z2, sb.toString());
        this.k = str;
        this.l = zztVar;
        this.m = i;
        this.n = bArr;
        if (i != i2) {
            String[] strArr3 = q.a;
            if (i >= 0) {
                String[] strArr4 = q.a;
                String str3 = i >= strArr4.length ? null : strArr4[i];
                if (str3 == null) {
                    strG = outline.g(32, "Invalid section type ", i);
                } else if (str != null && bArr != null) {
                    strG = "Both content and blobContent set";
                }
            }
        }
        if (strG != null) {
            throw new IllegalArgumentException(strG);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 1, this.k, false);
        AnimatableValueParser.s2(parcel, 3, this.l, i, false);
        int i2 = this.m;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        AnimatableValueParser.q2(parcel, 5, this.n, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
