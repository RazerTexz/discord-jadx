package d0.e0.p.d.l0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: Caller.kt */
/* renamed from: d0.e0.p.d.l0.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface Caller2<M extends Member> {

    /* compiled from: Caller.kt */
    /* renamed from: d0.e0.p.d.l0.d$a */
    public static final class a {
        public static <M extends Member> void checkArguments(Caller2<? extends M> caller2, Object[] objArr) {
            Intrinsics3.checkNotNullParameter(objArr, "args");
            if (Caller3.getArity(caller2) == objArr.length) {
                return;
            }
            StringBuilder sbU = outline.U("Callable expects ");
            sbU.append(Caller3.getArity(caller2));
            sbU.append(" arguments, but ");
            throw new IllegalArgumentException(outline.B(sbU, objArr.length, " were provided."));
        }
    }

    Object call(Object[] objArr);

    /* renamed from: getMember */
    M mo80getMember();

    List<Type> getParameterTypes();

    Type getReturnType();
}
