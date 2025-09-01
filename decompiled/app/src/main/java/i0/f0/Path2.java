package i0.f0;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Path.java */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: i0.f0.s, reason: use source file name */
/* loaded from: classes3.dex */
public @interface Path2 {
    boolean encoded() default false;

    String value();
}
