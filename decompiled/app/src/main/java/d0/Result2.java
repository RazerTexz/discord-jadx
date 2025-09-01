package d0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Result.kt */
/* renamed from: d0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class Result2<T> implements Serializable {
    public static final a j = new a(null);
    private final Object value;

    /* compiled from: Result.kt */
    /* renamed from: d0.k$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: Result.kt */
    /* renamed from: d0.k$b */
    public static final class b implements Serializable {
        public final Throwable exception;

        public b(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && Intrinsics3.areEqual(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            StringBuilder sbU = outline.U("Failure(");
            sbU.append(this.exception);
            sbU.append(')');
            return sbU.toString();
        }
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static Object m97constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m98equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result2) && Intrinsics3.areEqual(obj, ((Result2) obj2).m104unboximpl());
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m99exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m100hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m101isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m102isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m103toStringimpl(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m98equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m100hashCodeimpl(this.value);
    }

    public String toString() {
        return m103toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m104unboximpl() {
        return this.value;
    }
}
