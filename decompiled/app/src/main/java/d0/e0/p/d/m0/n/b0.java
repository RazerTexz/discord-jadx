package d0.e0.p.d.m0.n;

import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
public final class b0<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return d0.u.a.compareValues(((KotlinType) t).toString(), ((KotlinType) t2).toString());
    }
}
