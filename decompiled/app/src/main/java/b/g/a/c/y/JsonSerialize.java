package b.g.a.c.y;

import b.g.a.c.JsonSerializer;
import b.g.a.c.i0.Converter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonSerialize.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.g.a.c.y.e, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonSerialize {

    /* compiled from: JsonSerialize.java */
    @Deprecated
    /* renamed from: b.g.a.c.y.e$a */
    public enum a {
        ALWAYS,
        NON_NULL,
        NON_DEFAULT,
        NON_EMPTY,
        DEFAULT_INCLUSION
    }

    /* compiled from: JsonSerialize.java */
    /* renamed from: b.g.a.c.y.e$b */
    public enum b {
        DYNAMIC,
        STATIC,
        DEFAULT_TYPING
    }

    Class<?> as() default Void.class;

    Class<?> contentAs() default Void.class;

    Class<? extends Converter> contentConverter() default Converter.a.class;

    Class<? extends JsonSerializer> contentUsing() default JsonSerializer.a.class;

    Class<? extends Converter> converter() default Converter.a.class;

    @Deprecated
    a include() default a.DEFAULT_INCLUSION;

    Class<?> keyAs() default Void.class;

    Class<? extends JsonSerializer> keyUsing() default JsonSerializer.a.class;

    Class<? extends JsonSerializer> nullsUsing() default JsonSerializer.a.class;

    b typing() default b.DEFAULT_TYPING;

    Class<? extends JsonSerializer> using() default JsonSerializer.a.class;
}
