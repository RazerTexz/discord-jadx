package com.google.gson.internal.bind;

import b.i.d.ExclusionStrategy;
import b.i.d.FieldAttributes;
import b.i.d.FieldNamingStrategy;
import b.i.d.TypeAdapterFactory2;
import b.i.d.p.Since2;
import b.i.d.p.Until;
import b.i.d.q.ObjectConstructor;
import b.i.d.q.g;
import b.i.d.q.y.ReflectionAccessor;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory2 {
    public final g j;
    public final FieldNamingStrategy k;
    public final Excluder l;
    public final JsonAdapterAnnotationTypeAdapterFactory m;
    public final ReflectionAccessor n = ReflectionAccessor.a;

    public static final class Adapter<T> extends TypeAdapter<T> {
        public final ObjectConstructor<T> a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, a> f3122b;

        public Adapter(ObjectConstructor<T> objectConstructor, Map<String, a> map) {
            this.a = objectConstructor;
            this.f3122b = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            T tA = this.a.a();
            try {
                jsonReader.b();
                while (jsonReader.q()) {
                    a aVar = this.f3122b.get(jsonReader.C());
                    if (aVar == null || !aVar.c) {
                        jsonReader.U();
                    } else {
                        aVar.a(jsonReader, tA);
                    }
                }
                jsonReader.f();
                return tA;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.s();
                return;
            }
            jsonWriter.c();
            try {
                for (a aVar : this.f3122b.values()) {
                    if (aVar.c(t)) {
                        jsonWriter.n(aVar.a);
                        aVar.b(jsonWriter, t);
                    }
                }
                jsonWriter.f();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static abstract class a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3123b;
        public final boolean c;

        public a(String str, boolean z2, boolean z3) {
            this.a = str;
            this.f3123b = z2;
            this.c = z3;
        }

        public abstract void a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException;

        public abstract void b(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException;

        public abstract boolean c(Object obj) throws IllegalAccessException, IOException;
    }

    public ReflectiveTypeAdapterFactory(g gVar, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.j = gVar;
        this.k = fieldNamingStrategy;
        this.l = excluder;
        this.m = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Field field, boolean z2) {
        boolean z3;
        Excluder excluder = this.l;
        Class<?> type = field.getType();
        if (!(excluder.b(type) || excluder.f(type, z2))) {
            if ((excluder.l & field.getModifiers()) == 0 && ((excluder.k == -1.0d || excluder.i((Since2) field.getAnnotation(Since2.class), (Until) field.getAnnotation(Until.class))) && !field.isSynthetic() && ((excluder.m || !excluder.h(field.getType())) && !excluder.g(field.getType())))) {
                List<ExclusionStrategy> list = z2 ? excluder.n : excluder.o;
                if (!list.isEmpty()) {
                    FieldAttributes fieldAttributes = new FieldAttributes(field);
                    Iterator<ExclusionStrategy> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().a(fieldAttributes)) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    return true;
                }
            } else {
                z3 = true;
                if (z3) {
                }
            }
        }
        return false;
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    @Override // b.i.d.TypeAdapterFactory2
    public <T> com.google.gson.TypeAdapter<T> create(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r36v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */
}
