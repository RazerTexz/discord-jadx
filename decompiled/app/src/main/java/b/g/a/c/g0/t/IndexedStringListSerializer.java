package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.u.StaticListSerializerBase;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* compiled from: IndexedStringListSerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.t.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class IndexedStringListSerializer extends StaticListSerializerBase<List<String>> {
    public static final IndexedStringListSerializer k = new IndexedStringListSerializer();
    private static final long serialVersionUID = 1;

    public IndexedStringListSerializer() {
        super(List.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<String> list = (List) obj;
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            r(list, jsonGenerator, serializerProvider, 1);
            return;
        }
        jsonGenerator.b0(list, size);
        r(list, jsonGenerator, serializerProvider, size);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.u.StaticListSerializerBase, b.g.a.c.JsonSerializer
    public /* bridge */ /* synthetic */ void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        s((List) obj, jsonGenerator, serializerProvider, typeSerializer);
    }

    @Override // b.g.a.c.g0.u.StaticListSerializerBase
    public JsonSerializer<?> p(BeanProperty beanProperty, Boolean bool) {
        return new IndexedStringListSerializer(this, bool);
    }

    @Override // b.g.a.c.g0.u.StaticListSerializerBase
    public /* bridge */ /* synthetic */ void q(Collection collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        s((List) collection, jsonGenerator, serializerProvider, typeSerializer);
    }

    public final void r(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                String str = list.get(i2);
                if (str == null) {
                    serializerProvider.l(jsonGenerator);
                } else {
                    jsonGenerator.j0(str);
                }
            } catch (Exception e) {
                n(serializerProvider, e, list, i2);
                throw null;
            }
        }
    }

    public void s(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(list, JsonToken2.START_ARRAY));
        jsonGenerator.e(list);
        r(list, jsonGenerator, serializerProvider, list.size());
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    public IndexedStringListSerializer(IndexedStringListSerializer indexedStringListSerializer, Boolean bool) {
        super(indexedStringListSerializer, bool);
    }
}
