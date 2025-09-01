package b.g.a.c.h0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;

/* compiled from: MapType.java */
/* renamed from: b.g.a.c.h0.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class MapType extends MapLikeType {
    private static final long serialVersionUID = 1;

    public MapType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2, javaType3, obj, obj2, z2);
    }

    public static MapType Q(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3) {
        return new MapType(cls, typeBindings, javaType, javaTypeArr, javaType2, javaType3, null, null, false);
    }

    @Override // b.g.a.c.h0.MapLikeType, b.g.a.c.JavaType
    public JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new MapType(cls, typeBindings, javaType, javaTypeArr, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.MapLikeType, b.g.a.c.JavaType
    public JavaType D(JavaType javaType) {
        return this._valueType == javaType ? this : new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.MapLikeType, b.g.a.c.JavaType
    public /* bridge */ /* synthetic */ JavaType E(Object obj) {
        return R(obj);
    }

    @Override // b.g.a.c.h0.MapLikeType, b.g.a.c.JavaType
    public /* bridge */ /* synthetic */ JavaType G() {
        return S();
    }

    @Override // b.g.a.c.h0.MapLikeType, b.g.a.c.JavaType
    public /* bridge */ /* synthetic */ JavaType H(Object obj) {
        return T(obj);
    }

    @Override // b.g.a.c.h0.MapLikeType, b.g.a.c.JavaType
    public /* bridge */ /* synthetic */ JavaType I(Object obj) {
        return U(obj);
    }

    @Override // b.g.a.c.h0.MapLikeType
    public /* bridge */ /* synthetic */ MapLikeType L(Object obj) {
        return R(obj);
    }

    @Override // b.g.a.c.h0.MapLikeType
    public MapLikeType M(JavaType javaType) {
        return javaType == this._keyType ? this : new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.MapLikeType
    public /* bridge */ /* synthetic */ MapLikeType N() {
        return S();
    }

    @Override // b.g.a.c.h0.MapLikeType
    public /* bridge */ /* synthetic */ MapLikeType O(Object obj) {
        return T(obj);
    }

    @Override // b.g.a.c.h0.MapLikeType
    public /* bridge */ /* synthetic */ MapLikeType P(Object obj) {
        return U(obj);
    }

    public MapType R(Object obj) {
        return new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.H(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public MapType S() {
        return this._asStatic ? this : new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType.G(), this._valueType.G(), this._valueHandler, this._typeHandler, true);
    }

    public MapType T(Object obj) {
        return new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    public MapType U(Object obj) {
        return new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.MapLikeType
    public String toString() {
        StringBuilder sbU = outline.U("[map type; class ");
        outline.k0(this._class, sbU, ", ");
        sbU.append(this._keyType);
        sbU.append(" -> ");
        sbU.append(this._valueType);
        sbU.append("]");
        return sbU.toString();
    }
}
