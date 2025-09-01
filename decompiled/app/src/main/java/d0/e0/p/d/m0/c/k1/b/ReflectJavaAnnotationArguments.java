package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.annotationArguments;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ReflectJavaAnnotationArguments implements annotationArguments {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final Name f3292b;

    /* compiled from: ReflectJavaAnnotationArguments.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.d$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ReflectJavaAnnotationArguments create(Object obj, Name name) {
            Intrinsics3.checkNotNullParameter(obj, "value");
            return reflectClassUtil.isEnumClassOrSpecializedEnumEntryClass(obj.getClass()) ? new ReflectJavaAnnotationArguments5(name, (Enum) obj) : obj instanceof Annotation ? new ReflectJavaAnnotationArguments2(name, (Annotation) obj) : obj instanceof Object[] ? new ReflectJavaAnnotationArguments3(name, (Object[]) obj) : obj instanceof Class ? new ReflectJavaAnnotationArguments4(name, (Class) obj) : new ReflectJavaAnnotationArguments6(name, obj);
        }
    }

    public ReflectJavaAnnotationArguments(Name name) {
        this.f3292b = name;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.annotationArguments
    public Name getName() {
        return this.f3292b;
    }
}
