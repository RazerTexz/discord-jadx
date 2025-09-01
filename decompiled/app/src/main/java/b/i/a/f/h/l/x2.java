package b.i.a.f.h.l;

import java.io.Serializable;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public abstract class x2<T> implements Serializable {
    public static <T> x2<T> a(T t) {
        Objects.requireNonNull(t);
        return new y2(t);
    }

    public abstract boolean b();

    public abstract T c();
}
