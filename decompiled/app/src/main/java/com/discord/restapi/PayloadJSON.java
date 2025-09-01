package com.discord.restapi;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d0.z.d.Intrinsics3;
import i0.Converter2;
import i0.Retrofit2;
import i0.e0.a.GsonConverterFactory;
import i0.e0.a.GsonRequestBodyConverter;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* compiled from: PayloadJSON.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0015B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00028\u0000HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00028\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/discord/restapi/PayloadJSON;", ExifInterface.GPS_DIRECTION_TRUE, "", "component1", "()Ljava/lang/Object;", "data", "copy", "(Ljava/lang/Object;)Lcom/discord/restapi/PayloadJSON;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "ConverterFactory", "restapi_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class PayloadJSON<T> {
    private final T data;

    /* compiled from: PayloadJSON.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015JG\u0010\f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/discord/restapi/PayloadJSON$ConverterFactory;", "Li0/h$a;", "Ljava/lang/reflect/Type;", "type", "", "", "parameterAnnotations", "methodAnnotations", "Li0/y;", "retrofit", "Li0/h;", "Lokhttp3/RequestBody;", "requestBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Li0/y;)Li0/h;", "Li0/e0/a/a;", "kotlin.jvm.PlatformType", "gsonConverterFactory", "Li0/e0/a/a;", "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "RequestBodyConverter", "restapi_release"}, k = 1, mv = {1, 4, 2})
    public static final class ConverterFactory extends Converter2.a {
        private final GsonConverterFactory gsonConverterFactory;

        /* compiled from: PayloadJSON.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/restapi/PayloadJSON$ConverterFactory$RequestBodyConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Li0/h;", "Lcom/discord/restapi/PayloadJSON;", "Lokhttp3/RequestBody;", "value", "convert", "(Lcom/discord/restapi/PayloadJSON;)Lokhttp3/RequestBody;", "gsonRequestBodyConverter", "Li0/h;", "<init>", "(Li0/h;)V", "restapi_release"}, k = 1, mv = {1, 4, 2})
        public static final class RequestBodyConverter<T> implements Converter2<PayloadJSON<T>, RequestBody> {
            private final Converter2<T, RequestBody> gsonRequestBodyConverter;

            public RequestBodyConverter(Converter2<T, RequestBody> converter2) {
                Intrinsics3.checkNotNullParameter(converter2, "gsonRequestBodyConverter");
                this.gsonRequestBodyConverter = converter2;
            }

            @Override // i0.Converter2
            public /* bridge */ /* synthetic */ RequestBody convert(Object obj) {
                return convert((PayloadJSON) obj);
            }

            public RequestBody convert(PayloadJSON<T> value) {
                Intrinsics3.checkNotNullParameter(value, "value");
                return (RequestBody) this.gsonRequestBodyConverter.convert(PayloadJSON.access$getData$p(value));
            }
        }

        public ConverterFactory(Gson gson) {
            Intrinsics3.checkNotNullParameter(gson, "gson");
            Objects.requireNonNull(gson, "gson == null");
            this.gsonConverterFactory = new GsonConverterFactory(gson);
        }

        @Override // i0.Converter2.a
        public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit2 retrofit) {
            Intrinsics3.checkNotNullParameter(type, "type");
            Intrinsics3.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
            Intrinsics3.checkNotNullParameter(methodAnnotations, "methodAnnotations");
            Intrinsics3.checkNotNullParameter(retrofit, "retrofit");
            if (!(type instanceof ParameterizedType)) {
                type = null;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType == null || (!Intrinsics3.areEqual(parameterizedType.getRawType(), PayloadJSON.class))) {
                return null;
            }
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            GsonConverterFactory gsonConverterFactory = this.gsonConverterFactory;
            return new RequestBodyConverter(new GsonRequestBodyConverter(gsonConverterFactory.a, gsonConverterFactory.a.h(TypeToken.get(type2))));
        }
    }

    public PayloadJSON(T t) {
        this.data = t;
    }

    public static final /* synthetic */ Object access$getData$p(PayloadJSON payloadJSON) {
        return payloadJSON.data;
    }

    private final T component1() {
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayloadJSON copy$default(PayloadJSON payloadJSON, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = payloadJSON.data;
        }
        return payloadJSON.copy(obj);
    }

    public final PayloadJSON<T> copy(T data) {
        return new PayloadJSON<>(data);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PayloadJSON) && Intrinsics3.areEqual(this.data, ((PayloadJSON) other).data);
        }
        return true;
    }

    public int hashCode() {
        T t = this.data;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("PayloadJSON(data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }
}
