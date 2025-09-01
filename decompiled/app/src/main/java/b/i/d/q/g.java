package b.i.d.q;

import b.i.d.InstanceCreator;
import b.i.d.q.y.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes3.dex */
public final class g {
    public final Map<Type, InstanceCreator<?>> a;

    /* renamed from: b, reason: collision with root package name */
    public final ReflectionAccessor f1808b = ReflectionAccessor.a;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    public class a<T> implements ObjectConstructor<T> {
        public final /* synthetic */ InstanceCreator a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f1809b;

        public a(g gVar, InstanceCreator instanceCreator, Type type) {
            this.a = instanceCreator;
            this.f1809b = type;
        }

        @Override // b.i.d.q.ObjectConstructor
        public T a() {
            return (T) this.a.a(this.f1809b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    public class b<T> implements ObjectConstructor<T> {
        public final /* synthetic */ InstanceCreator a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f1810b;

        public b(g gVar, InstanceCreator instanceCreator, Type type) {
            this.a = instanceCreator;
            this.f1810b = type;
        }

        @Override // b.i.d.q.ObjectConstructor
        public T a() {
            return (T) this.a.a(this.f1810b);
        }
    }

    public g(Map<Type, InstanceCreator<?>> map) {
        this.a = map;
    }

    public <T> ObjectConstructor<T> a(TypeToken<T> typeToken) throws NoSuchMethodException, SecurityException {
        h hVar;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.a.get(type);
        if (instanceCreator != null) {
            return new a(this, instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.a.get(rawType);
        if (instanceCreator2 != null) {
            return new b(this, instanceCreator2, type);
        }
        ObjectConstructor<T> nVar = null;
        try {
            Constructor<? super T> declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f1808b.a(declaredConstructor);
            }
            hVar = new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            hVar = null;
        }
        if (hVar != null) {
            return hVar;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            nVar = SortedSet.class.isAssignableFrom(rawType) ? new i<>(this) : EnumSet.class.isAssignableFrom(rawType) ? new j<>(this, type) : Set.class.isAssignableFrom(rawType) ? new k<>(this) : Queue.class.isAssignableFrom(rawType) ? new l<>(this) : new m<>(this);
        } else if (Map.class.isAssignableFrom(rawType)) {
            nVar = ConcurrentNavigableMap.class.isAssignableFrom(rawType) ? new n<>(this) : ConcurrentMap.class.isAssignableFrom(rawType) ? new b.i.d.q.b<>(this) : SortedMap.class.isAssignableFrom(rawType) ? new c<>(this) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new e<>(this) : new d<>(this);
        }
        return nVar != null ? nVar : new f(this, rawType, type);
    }

    public String toString() {
        return this.a.toString();
    }
}
