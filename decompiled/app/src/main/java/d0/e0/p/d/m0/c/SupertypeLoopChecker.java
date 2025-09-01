package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SupertypeLoopChecker.kt */
/* renamed from: d0.e0.p.d.m0.c.x0, reason: use source file name */
/* loaded from: classes3.dex */
public interface SupertypeLoopChecker {

    /* compiled from: SupertypeLoopChecker.kt */
    /* renamed from: d0.e0.p.d.m0.c.x0$a */
    public static final class a implements SupertypeLoopChecker {
        public static final a a = new a();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.e0.p.d.m0.c.SupertypeLoopChecker
        public Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> function1, Function1<? super KotlinType, Unit> function12) {
            Intrinsics3.checkNotNullParameter(typeConstructor, "currentTypeConstructor");
            Intrinsics3.checkNotNullParameter(collection, "superTypes");
            Intrinsics3.checkNotNullParameter(function1, "neighbors");
            Intrinsics3.checkNotNullParameter(function12, "reportLoop");
            return collection;
        }
    }

    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> function1, Function1<? super KotlinType, Unit> function12);
}
