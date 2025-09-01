package b.g.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonIdentityInfo.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.g.a.a.k, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonIdentityInfo {
    Class<? extends ObjectIdGenerator<?>> generator();

    String property() default "@id";

    Class<?> resolver() default SimpleObjectIdResolver.class;

    Class<?> scope() default Object.class;
}
