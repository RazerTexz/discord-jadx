package b.g.a.c.e0.h;

import b.g.a.a.JsonTypeInfo;
import b.g.a.c.BeanProperty;
import b.g.a.c.e0.TypeIdResolver;
import b.g.a.c.e0.TypeSerializer;

/* compiled from: AsArrayTypeSerializer.java */
/* renamed from: b.g.a.c.e0.h.a, reason: use source file name */
/* loaded from: classes3.dex */
public class AsArrayTypeSerializer extends TypeSerializerBase {
    public AsArrayTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public /* bridge */ /* synthetic */ TypeSerializer a(BeanProperty beanProperty) {
        return g(beanProperty);
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public JsonTypeInfo.a c() {
        return JsonTypeInfo.a.WRAPPER_ARRAY;
    }

    public AsArrayTypeSerializer g(BeanProperty beanProperty) {
        return this.f699b == beanProperty ? this : new AsArrayTypeSerializer(this.a, beanProperty);
    }
}
