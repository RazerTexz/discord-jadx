package b.g.a.c.e0;

import b.g.a.a.JsonTypeInfo;
import b.g.a.c.JavaType;
import b.g.a.c.SerializationConfig;
import b.g.a.c.e0.TypeResolverBuilder;
import java.util.Collection;

/* compiled from: TypeResolverBuilder.java */
/* renamed from: b.g.a.c.e0.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface TypeResolverBuilder<T extends TypeResolverBuilder<T>> {
    T a(boolean z2);

    T b(JsonTypeInfo.b bVar, TypeIdResolver typeIdResolver);

    T c(String str);

    T d(Class<?> cls);

    TypeSerializer e(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection);

    T f(JsonTypeInfo.a aVar);
}
