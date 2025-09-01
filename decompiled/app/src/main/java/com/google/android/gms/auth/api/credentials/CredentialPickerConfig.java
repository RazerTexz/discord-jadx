package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.c.a.d.f;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes3.dex */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new f();
    public final int j;
    public final boolean k;
    public final boolean l;
    public final int m;

    public CredentialPickerConfig(int i, boolean z2, boolean z3, boolean z4, int i2) {
        this.j = i;
        this.k = z2;
        this.l = z3;
        if (i < 2) {
            this.m = z4 ? 3 : 1;
        } else {
            this.m = i2;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        boolean z2 = this.k;
        parcel.writeInt(262145);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.l;
        parcel.writeInt(262146);
        parcel.writeInt(z3 ? 1 : 0);
        int i2 = this.m == 3 ? 1 : 0;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        int i3 = this.m;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        int i4 = this.j;
        parcel.writeInt(263144);
        parcel.writeInt(i4);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
