package i0.f0;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: HTTP.java */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: i0.f0.h, reason: use source file name */
/* loaded from: classes3.dex */
public @interface HTTP {
    boolean hasBody() default false;

    String method();

    String path() default "";
}
