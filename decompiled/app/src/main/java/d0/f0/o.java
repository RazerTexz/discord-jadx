package d0.f0;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class o<T> extends Lambda implements Function1<T, T> {
    public static final o j = new o();

    public o() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(T t) {
        return t;
    }
}
