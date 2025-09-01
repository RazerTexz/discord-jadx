package s.b;

import android.os.Parcel;

/* compiled from: Parceler.kt */
/* renamed from: s.b.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface Parceler<T> {
    T create(Parcel parcel);

    void write(T t, Parcel parcel, int i);
}
