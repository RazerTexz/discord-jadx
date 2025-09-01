package b.g.a.c.y;

import b.g.a.c.e0.TypeIdResolver;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonTypeIdResolver.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.g.a.c.y.f, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonTypeIdResolver {
    Class<? extends TypeIdResolver> value();
}
