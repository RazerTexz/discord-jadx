package d0.d0;

import d0.z.d.Intrinsics3;
import java.lang.Comparable;

/* compiled from: Range.kt */
/* renamed from: d0.d0.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface Range3<T extends Comparable<? super T>> {

    /* compiled from: Range.kt */
    /* renamed from: d0.d0.a$a */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean contains(Range3<T> range3, T t) {
            Intrinsics3.checkNotNullParameter(t, "value");
            return t.compareTo(range3.getStart()) >= 0 && t.compareTo(range3.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(Range3<T> range3) {
            return range3.getStart().compareTo(range3.getEndInclusive()) > 0;
        }
    }

    boolean contains(T t);

    T getEndInclusive();

    T getStart();
}
