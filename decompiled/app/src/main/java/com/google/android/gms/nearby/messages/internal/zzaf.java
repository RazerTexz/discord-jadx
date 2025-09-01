package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.j.b.e.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new e();
    public final int j;
    public final Message k;

    public zzaf(int i, Message message) {
        this.j = i;
        Objects.requireNonNull(message, "null reference");
        this.k = message;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzaf) {
            return AnimatableValueParser.h0(this.k, ((zzaf) obj).k);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.k});
    }

    public final String toString() {
        String string = this.k.toString();
        return outline.k(outline.b(string, 24), "MessageWrapper{message=", string, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.s2(parcel, 1, this.k, i, false);
        int i2 = this.j;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
