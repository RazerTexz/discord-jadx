package b.f.m;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: DoNotOptimize.java */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.CLASS)
/* renamed from: b.f.m.d, reason: use source file name */
/* loaded from: classes3.dex */
public @interface DoNotOptimize {
}
