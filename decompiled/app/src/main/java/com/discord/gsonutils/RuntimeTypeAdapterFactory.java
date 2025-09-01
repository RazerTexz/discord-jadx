package com.discord.gsonutils;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.d.JsonPrimitive;
import b.i.d.TypeAdapterFactory2;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory2 {
    public final Class<?> j;
    public final String k;
    public final Map<String, Class<?>> l = new LinkedHashMap();
    public final Map<Class<?>, String> m = new LinkedHashMap();
    public final boolean n;
    public final Class<?> o;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* renamed from: com.discord.gsonutils.RuntimeTypeAdapterFactory$1, reason: invalid class name */
    public class AnonymousClass1<R> extends TypeAdapter<R> {
        public final /* synthetic */ Map a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TypeAdapter f2707b;
        public final /* synthetic */ Map c;

        public AnonymousClass1(Map map, TypeAdapter typeAdapter, Map map2) {
            this.a = map;
            this.f2707b = typeAdapter;
            this.c = map2;
        }

        @Override // com.google.gson.TypeAdapter
        public R read(JsonReader jsonReader) throws JsonParseException, IOException {
            JsonElement jsonElementRemove;
            JsonElement jsonElementS0 = f.S0(jsonReader);
            if (RuntimeTypeAdapterFactory.this.n) {
                LinkedTreeMap.e<String, JsonElement> eVarC = jsonElementS0.d().a.c(RuntimeTypeAdapterFactory.this.k);
                jsonElementRemove = eVarC != null ? eVarC.p : null;
            } else {
                jsonElementRemove = jsonElementS0.d().a.remove(RuntimeTypeAdapterFactory.this.k);
            }
            if (jsonElementRemove == null) {
                StringBuilder sbU = outline.U("cannot deserialize ");
                sbU.append(RuntimeTypeAdapterFactory.this.j);
                sbU.append(" because it does not define a field named ");
                sbU.append(RuntimeTypeAdapterFactory.this.k);
                throw new JsonParseException(sbU.toString());
            }
            String strG = jsonElementRemove.g();
            TypeAdapter typeAdapter = (TypeAdapter) this.a.get(strG);
            if (typeAdapter == null) {
                typeAdapter = this.f2707b;
            }
            if (typeAdapter != null) {
                return (R) typeAdapter.fromJsonTree(jsonElementS0);
            }
            StringBuilder sbU2 = outline.U("cannot deserialize ");
            sbU2.append(RuntimeTypeAdapterFactory.this.j);
            sbU2.append(" subtype named ");
            sbU2.append(strG);
            sbU2.append("; did you forget to register a subtype?");
            throw new JsonParseException(sbU2.toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, R r) throws IOException {
            Class<?> cls = r.getClass();
            String str = RuntimeTypeAdapterFactory.this.m.get(cls);
            TypeAdapter typeAdapter = (TypeAdapter) this.c.get(cls);
            if (typeAdapter == null) {
                throw new JsonParseException(outline.o(cls, outline.U("cannot serialize "), "; did you forget to register a subtype?"));
            }
            JsonObject jsonObjectD = typeAdapter.toJsonTree(r).d();
            if (RuntimeTypeAdapterFactory.this.n) {
                TypeAdapters.X.write(jsonWriter, jsonObjectD);
                return;
            }
            JsonObject jsonObject = new JsonObject();
            if (jsonObjectD.a.c(RuntimeTypeAdapterFactory.this.k) != null) {
                StringBuilder sbU = outline.U("cannot serialize ");
                outline.k0(cls, sbU, " because it already defines a field named ");
                sbU.append(RuntimeTypeAdapterFactory.this.k);
                throw new JsonParseException(sbU.toString());
            }
            jsonObject.a.put(RuntimeTypeAdapterFactory.this.k, new JsonPrimitive(str));
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            LinkedTreeMap.e eVar = linkedTreeMap.header.m;
            int i = linkedTreeMap.modCount;
            while (true) {
                LinkedTreeMap.e eVar2 = linkedTreeMap.header;
                if (!(eVar != eVar2)) {
                    TypeAdapters.X.write(jsonWriter, jsonObject);
                    return;
                } else {
                    if (eVar == eVar2) {
                        throw new NoSuchElementException();
                    }
                    if (linkedTreeMap.modCount != i) {
                        throw new ConcurrentModificationException();
                    }
                    LinkedTreeMap.e eVar3 = eVar.m;
                    jsonObject.h((String) eVar.o, (JsonElement) eVar.p);
                    eVar = eVar3;
                }
            }
        }
    }

    public RuntimeTypeAdapterFactory(Class<?> cls, String str, boolean z2, Class<?> cls2) {
        if (str == null || cls == null) {
            throw null;
        }
        this.j = cls;
        this.k = str;
        this.n = z2;
        this.o = cls2;
    }

    @Override // b.i.d.TypeAdapterFactory2
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        if (typeToken.getRawType() != this.j) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Class<?> cls = this.o;
        TypeAdapter<T> typeAdapterJ = cls != null ? gson.j(this, TypeToken.get((Class) cls)) : null;
        for (Map.Entry<String, Class<?>> entry : this.l.entrySet()) {
            TypeAdapter<T> typeAdapterJ2 = gson.j(this, TypeToken.get((Class) entry.getValue()));
            linkedHashMap.put(entry.getKey(), typeAdapterJ2);
            linkedHashMap2.put(entry.getValue(), typeAdapterJ2);
        }
        return new AnonymousClass1(linkedHashMap, typeAdapterJ, linkedHashMap2).nullSafe();
    }
}
