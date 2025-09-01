package b.g.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonPropertyOrder.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.g.a.a.w, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonPropertyOrder {
    boolean alphabetic() default false;

    String[] value() default {};
}
