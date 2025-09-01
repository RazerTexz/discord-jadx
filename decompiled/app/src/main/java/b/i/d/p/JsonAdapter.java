package b.i.d.p;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonAdapter.java */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: b.i.d.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public @interface JsonAdapter {
    boolean nullSafe() default true;

    Class<?> value();
}
