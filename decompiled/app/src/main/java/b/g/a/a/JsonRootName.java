package b.g.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonRootName.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.g.a.a.y, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonRootName {
    String namespace() default "";

    String value();
}
