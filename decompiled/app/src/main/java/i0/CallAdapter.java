package i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* compiled from: CallAdapter.java */
/* renamed from: i0.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface CallAdapter<R, T> {

    /* compiled from: CallAdapter.java */
    /* renamed from: i0.e$a */
    public static abstract class a {
        public abstract CallAdapter<?, ?> a(Type type, Annotation[] annotationArr, Retrofit2 retrofit22);
    }

    Type a();

    T b(Call3<R> call3);
}
