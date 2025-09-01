package b.g.a.c.i0;

import b.g.a.c.JavaType;
import b.g.a.c.h0.TypeFactory;

/* compiled from: Converter.java */
/* renamed from: b.g.a.c.i0.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface Converter<IN, OUT> {

    /* compiled from: Converter.java */
    /* renamed from: b.g.a.c.i0.e$a */
    public static abstract class a implements Converter<Object, Object> {
    }

    JavaType a(TypeFactory typeFactory);

    OUT convert(IN in);
}
