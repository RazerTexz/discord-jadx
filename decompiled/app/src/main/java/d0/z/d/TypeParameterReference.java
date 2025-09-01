package d0.z.d;

import d0.e0.KTypeParameter;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TypeParameterReference.kt */
/* renamed from: d0.z.d.f0, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypeParameterReference implements KTypeParameter {
    public static final a j = new a(null);

    /* compiled from: TypeParameterReference.kt */
    /* renamed from: d0.z.d.f0$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String toString(KTypeParameter kTypeParameter) {
            Intrinsics3.checkNotNullParameter(kTypeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int iOrdinal = kTypeParameter.getVariance().ordinal();
            if (iOrdinal == 1) {
                sb.append("in ");
            } else if (iOrdinal == 2) {
                sb.append("out ");
            }
            sb.append(kTypeParameter.getName());
            String string = sb.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }
}
