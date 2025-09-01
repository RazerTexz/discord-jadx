package b.g.a.c.h0;

import b.g.a.b.s.ResolvedType;
import b.g.a.c.JavaType;

/* compiled from: ReferenceType.java */
/* renamed from: b.g.a.c.h0.i, reason: use source file name */
/* loaded from: classes3.dex */
public class ReferenceType extends SimpleType {
    private static final long serialVersionUID = 1;
    public final JavaType _anchorType;
    public final JavaType _referencedType;

    public ReferenceType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2._hash, obj, obj2, z2);
        this._referencedType = javaType2;
        this._anchorType = javaType3 == null ? this : javaType3;
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.JavaType
    public JavaType C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new ReferenceType(cls, this._bindings, javaType, javaTypeArr, this._referencedType, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.JavaType
    public JavaType D(JavaType javaType) {
        return this._referencedType == javaType ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.JavaType
    public JavaType E(Object obj) {
        JavaType javaType = this._referencedType;
        return obj == javaType._typeHandler ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType.H(obj), this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.JavaType
    public /* bridge */ /* synthetic */ JavaType G() {
        return P();
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.JavaType
    public /* bridge */ /* synthetic */ JavaType H(Object obj) {
        return Q(obj);
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.JavaType
    public /* bridge */ /* synthetic */ JavaType I(Object obj) {
        return R(obj);
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.h0.TypeBase
    public String K() {
        return this._class.getName() + '<' + this._referencedType.e() + '>';
    }

    @Override // b.g.a.c.h0.SimpleType
    public /* bridge */ /* synthetic */ SimpleType M() {
        return P();
    }

    @Override // b.g.a.c.h0.SimpleType
    public /* bridge */ /* synthetic */ SimpleType N(Object obj) {
        return Q(obj);
    }

    @Override // b.g.a.c.h0.SimpleType
    public /* bridge */ /* synthetic */ SimpleType O(Object obj) {
        return R(obj);
    }

    public ReferenceType P() {
        return this._asStatic ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.G(), this._anchorType, this._valueHandler, this._typeHandler, true);
    }

    public ReferenceType Q(Object obj) {
        return obj == this._typeHandler ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, this._valueHandler, obj, this._asStatic);
    }

    public ReferenceType R(Object obj) {
        return obj == this._valueHandler ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.JavaType, b.g.a.b.s.ResolvedType
    public ResolvedType a() {
        return this._referencedType;
    }

    @Override // b.g.a.b.s.ResolvedType
    public boolean b() {
        return true;
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ReferenceType.class) {
            return false;
        }
        ReferenceType referenceType = (ReferenceType) obj;
        if (referenceType._class != this._class) {
            return false;
        }
        return this._referencedType.equals(referenceType._referencedType);
    }

    @Override // b.g.a.c.JavaType
    public JavaType k() {
        return this._referencedType;
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.JavaType
    public StringBuilder l(StringBuilder sb) {
        TypeBase.J(this._class, sb, true);
        return sb;
    }

    @Override // b.g.a.c.h0.SimpleType, b.g.a.c.JavaType
    public StringBuilder m(StringBuilder sb) {
        TypeBase.J(this._class, sb, false);
        sb.append('<');
        StringBuilder sbM = this._referencedType.m(sb);
        sbM.append(">;");
        return sbM;
    }

    @Override // b.g.a.c.JavaType
    public JavaType p() {
        return this._referencedType;
    }

    @Override // b.g.a.c.h0.SimpleType
    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[reference type, class ");
        sb.append(K());
        sb.append('<');
        sb.append(this._referencedType);
        sb.append('>');
        sb.append(']');
        return sb.toString();
    }
}
