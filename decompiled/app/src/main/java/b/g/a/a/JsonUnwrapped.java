package b.g.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonUnwrapped.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.g.a.a.e0, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonUnwrapped {
    boolean enabled() default true;

    String prefix() default "";

    String suffix() default "";
}
