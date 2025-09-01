package i0;

import i0.Converter2;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: OptionalConverterFactory.java */
@IgnoreJRERequirement
/* renamed from: i0.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class OptionalConverterFactory extends Converter2.a {
    public static final Converter2.a a = new OptionalConverterFactory();

    /* compiled from: OptionalConverterFactory.java */
    @IgnoreJRERequirement
    /* renamed from: i0.q$a */
    public static final class a<T> implements Converter2<ResponseBody, Optional<T>> {
        public final Converter2<ResponseBody, T> a;

        public a(Converter2<ResponseBody, T> converter2) {
            this.a = converter2;
        }

        @Override // i0.Converter2
        public Object convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.a.convert(responseBody));
        }
    }

    @Override // i0.Converter2.a
    public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit22) {
        if (Converter2.a.getRawType(type) != Optional.class) {
            return null;
        }
        return new a(retrofit22.d(Converter2.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
