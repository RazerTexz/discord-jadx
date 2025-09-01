package b.g.a.c.e0.h;

import b.g.a.a.JsonTypeInfo;
import b.g.a.c.BeanProperty;
import b.g.a.c.e0.TypeIdResolver;
import b.g.a.c.e0.TypeSerializer;

/* compiled from: AsExistingPropertyTypeSerializer.java */
/* renamed from: b.g.a.c.e0.h.b, reason: use source file name */
/* loaded from: classes3.dex */
public class AsExistingPropertyTypeSerializer extends AsPropertyTypeSerializer {
    public AsExistingPropertyTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty, str);
    }

    @Override // b.g.a.c.e0.h.AsPropertyTypeSerializer, b.g.a.c.e0.h.AsArrayTypeSerializer, b.g.a.c.e0.TypeSerializer
    public /* bridge */ /* synthetic */ TypeSerializer a(BeanProperty beanProperty) {
        return i(beanProperty);
    }

    @Override // b.g.a.c.e0.h.AsPropertyTypeSerializer, b.g.a.c.e0.h.AsArrayTypeSerializer, b.g.a.c.e0.TypeSerializer
    public JsonTypeInfo.a c() {
        return JsonTypeInfo.a.EXISTING_PROPERTY;
    }

    @Override // b.g.a.c.e0.h.AsPropertyTypeSerializer, b.g.a.c.e0.h.AsArrayTypeSerializer
    public /* bridge */ /* synthetic */ AsArrayTypeSerializer g(BeanProperty beanProperty) {
        return i(beanProperty);
    }

    @Override // b.g.a.c.e0.h.AsPropertyTypeSerializer
    public /* bridge */ /* synthetic */ AsPropertyTypeSerializer h(BeanProperty beanProperty) {
        return i(beanProperty);
    }

    public AsExistingPropertyTypeSerializer i(BeanProperty beanProperty) {
        return this.f699b == beanProperty ? this : new AsExistingPropertyTypeSerializer(this.a, beanProperty, this.c);
    }
}
