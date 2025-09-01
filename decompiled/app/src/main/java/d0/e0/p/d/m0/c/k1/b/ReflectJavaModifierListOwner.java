package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.Visibilities;
import d0.e0.p.d.m0.c.Visibility2;
import d0.e0.p.d.m0.c.j1.JavaVisibilities;
import d0.e0.p.d.m0.c.j1.JavaVisibilities2;
import d0.e0.p.d.m0.c.j1.JavaVisibilities3;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Modifier;

/* compiled from: ReflectJavaModifierListOwner.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.t, reason: use source file name */
/* loaded from: classes3.dex */
public interface ReflectJavaModifierListOwner extends d0.e0.p.d.m0.e.a.k0.s {

    /* compiled from: ReflectJavaModifierListOwner.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.t$a */
    public static final class a {
        public static Visibility2 getVisibility(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaModifierListOwner, "this");
            int modifiers = reflectJavaModifierListOwner.getModifiers();
            return Modifier.isPublic(modifiers) ? Visibilities.h.c : Modifier.isPrivate(modifiers) ? Visibilities.e.c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? JavaVisibilities3.c : JavaVisibilities2.c : JavaVisibilities.c;
        }

        public static boolean isAbstract(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaModifierListOwner, "this");
            return Modifier.isAbstract(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isFinal(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaModifierListOwner, "this");
            return Modifier.isFinal(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isStatic(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaModifierListOwner, "this");
            return Modifier.isStatic(reflectJavaModifierListOwner.getModifiers());
        }
    }

    int getModifiers();
}
