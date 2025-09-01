package i0;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: Converter.java */
/* renamed from: i0.h, reason: use source file name */
/* loaded from: classes3.dex */
public interface Converter2<F, T> {

    /* compiled from: Converter.java */
    /* renamed from: i0.h$a */
    public static abstract class a {
        public static Type getParameterUpperBound(int i, ParameterizedType parameterizedType) {
            return Utils8.e(i, parameterizedType);
        }

        public static Class<?> getRawType(Type type) {
            return Utils8.f(type);
        }

        public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit2 retrofit22) {
            return null;
        }

        public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit22) {
            return null;
        }

        public Converter2<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit22) {
            return null;
        }
    }

    T convert(F f) throws IOException;
}
