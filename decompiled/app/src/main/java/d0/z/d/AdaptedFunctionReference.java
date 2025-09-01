package d0.z.d;

import b.d.b.a.outline;
import java.io.Serializable;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: AdaptedFunctionReference.java */
/* renamed from: d0.z.d.a, reason: use source file name */
/* loaded from: classes3.dex */
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    public final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int i, Class cls, String str, String str2, int i2) {
        this(i, CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        return this.isTopLevel == adaptedFunctionReference.isTopLevel && this.arity == adaptedFunctionReference.arity && this.flags == adaptedFunctionReference.flags && Intrinsics3.areEqual(this.receiver, adaptedFunctionReference.receiver) && Intrinsics3.areEqual(this.owner, adaptedFunctionReference.owner) && this.name.equals(adaptedFunctionReference.name) && this.signature.equals(adaptedFunctionReference.signature);
    }

    @Override // d0.z.d.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? Reflection2.getOrCreateKotlinPackage(cls) : Reflection2.getOrCreateKotlinClass(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        return ((((outline.m(this.signature, outline.m(this.name, (iHashCode + (cls != null ? cls.hashCode() : 0)) * 31, 31), 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return Reflection2.renderLambdaToString(this);
    }

    public AdaptedFunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i2 & 1) == 1;
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
