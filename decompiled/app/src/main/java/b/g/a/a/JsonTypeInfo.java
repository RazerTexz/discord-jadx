package b.g.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonTypeInfo.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.g.a.a.c0, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonTypeInfo {

    /* compiled from: JsonTypeInfo.java */
    /* renamed from: b.g.a.a.c0$a */
    public enum a {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY,
        EXTERNAL_PROPERTY,
        EXISTING_PROPERTY
    }

    /* compiled from: JsonTypeInfo.java */
    /* renamed from: b.g.a.a.c0$b */
    public enum b {
        NONE(null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        DEDUCTION(null),
        CUSTOM(null);

        private final String _defaultPropertyName;

        b(String str) {
            this._defaultPropertyName = str;
        }

        public String f() {
            return this._defaultPropertyName;
        }
    }

    /* compiled from: JsonTypeInfo.java */
    @Deprecated
    /* renamed from: b.g.a.a.c0$c */
    public static abstract class c {
    }

    Class<?> defaultImpl() default JsonTypeInfo.class;

    a include() default a.PROPERTY;

    String property() default "";

    b use();

    boolean visible() default false;
}
