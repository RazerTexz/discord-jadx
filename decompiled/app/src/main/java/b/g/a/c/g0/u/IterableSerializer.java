package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.util.Iterator;

/* compiled from: IterableSerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.u.r, reason: use source file name */
/* loaded from: classes3.dex */
public class IterableSerializer extends AsArraySerializerBase<Iterable<?>> {
    public IterableSerializer(JavaType javaType, boolean z2, TypeSerializer typeSerializer) {
        super((Class<?>) Iterable.class, javaType, z2, typeSerializer, (JsonSerializer<Object>) null);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return !((Iterable) obj).iterator().hasNext();
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase, b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Iterable<?> iterable = (Iterable) obj;
        if (((this._unwrapSingle == null && serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE) && u(iterable)) {
            v(iterable, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.X(iterable);
        v(iterable, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
        return new IterableSerializer(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public /* bridge */ /* synthetic */ boolean q(Object obj) {
        return u((Iterable) obj);
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    public /* bridge */ /* synthetic */ void s(Iterable<?> iterable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        v(iterable, jsonGenerator, serializerProvider);
    }

    @Override // b.g.a.c.g0.u.AsArraySerializerBase
    public AsArraySerializerBase<Iterable<?>> t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new IterableSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    public boolean u(Iterable<?> iterable) {
        if (iterable == null) {
            return false;
        }
        Iterator<?> it = iterable.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    public void v(Iterable<?> iterable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            Class<?> cls = null;
            JsonSerializer<Object> jsonSerializerU = null;
            do {
                Object next = it.next();
                if (next == null) {
                    serializerProvider.l(jsonGenerator);
                } else {
                    JsonSerializer<Object> jsonSerializer2 = this._elementSerializer;
                    if (jsonSerializer2 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            jsonSerializerU = serializerProvider.u(cls2, this._property);
                            cls = cls2;
                        }
                        jsonSerializer = jsonSerializerU;
                    } else {
                        jsonSerializer = jsonSerializerU;
                        jsonSerializerU = jsonSerializer2;
                    }
                    if (typeSerializer == null) {
                        jsonSerializerU.f(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializerU.g(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    jsonSerializerU = jsonSerializer;
                }
            } while (it.hasNext());
        }
    }

    public IterableSerializer(IterableSerializer iterableSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(iterableSerializer, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}
