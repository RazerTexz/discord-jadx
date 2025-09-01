package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.c.a.f.g;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes3.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new g();

    @Deprecated
    public String j;
    public GoogleSignInAccount k;

    @Deprecated
    public String l;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.k = googleSignInAccount;
        AnimatableValueParser.v(str, "8.3 and 8.4 SDKs require non-null email");
        this.j = str;
        AnimatableValueParser.v(str2, "8.3 and 8.4 SDKs require non-null userId");
        this.l = str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 4, this.j, false);
        AnimatableValueParser.s2(parcel, 7, this.k, i, false);
        AnimatableValueParser.t2(parcel, 8, this.l, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
