package b.g.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* compiled from: JsonAutoDetect.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.g.a.a.e, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonAutoDetect {

    /* compiled from: JsonAutoDetect.java */
    /* renamed from: b.g.a.a.e$a */
    public enum a {
        ANY,
        NON_PRIVATE,
        PROTECTED_AND_PUBLIC,
        PUBLIC_ONLY,
        NONE,
        DEFAULT;

        public boolean f(Member member) {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return true;
            }
            if (iOrdinal == 1) {
                return !Modifier.isPrivate(member.getModifiers());
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    return false;
                }
            } else if (Modifier.isProtected(member.getModifiers())) {
                return true;
            }
            return Modifier.isPublic(member.getModifiers());
        }
    }

    a creatorVisibility() default a.DEFAULT;

    a fieldVisibility() default a.DEFAULT;

    a getterVisibility() default a.DEFAULT;

    a isGetterVisibility() default a.DEFAULT;

    a setterVisibility() default a.DEFAULT;
}
