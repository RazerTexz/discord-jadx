package b.g.a.c.e0.h;

import b.g.a.a.JsonTypeInfo;
import b.g.a.c.BeanProperty;
import b.g.a.c.e0.TypeIdResolver;
import b.g.a.c.e0.TypeSerializer;

/* compiled from: AsPropertyTypeSerializer.java */
/* renamed from: b.g.a.c.e0.h.d, reason: use source file name */
/* loaded from: classes3.dex */
public class AsPropertyTypeSerializer extends AsArrayTypeSerializer {
    public final String c;

    public AsPropertyTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty);
        this.c = str;
    }

    @Override // b.g.a.c.e0.h.AsArrayTypeSerializer, b.g.a.c.e0.TypeSerializer
    public /* bridge */ /* synthetic */ TypeSerializer a(BeanProperty beanProperty) {
        return h(beanProperty);
    }

    @Override // b.g.a.c.e0.h.TypeSerializerBase, b.g.a.c.e0.TypeSerializer
    public String b() {
        return this.c;
    }

    @Override // b.g.a.c.e0.h.AsArrayTypeSerializer, b.g.a.c.e0.TypeSerializer
    public JsonTypeInfo.a c() {
        return JsonTypeInfo.a.PROPERTY;
    }

    @Override // b.g.a.c.e0.h.AsArrayTypeSerializer
    public /* bridge */ /* synthetic */ AsArrayTypeSerializer g(BeanProperty beanProperty) {
        return h(beanProperty);
    }

    public AsPropertyTypeSerializer h(BeanProperty beanProperty) {
        return this.f699b == beanProperty ? this : new AsPropertyTypeSerializer(this.a, beanProperty, this.c);
    }
}
